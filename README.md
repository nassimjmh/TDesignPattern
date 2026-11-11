# Design Patterns : UML

Légende : `^` héritage / implémentation, `- - ->` dépendance (utilise / crée), `<>` agrégation, `-->` association.

---

## 1. Singleton

Une seule instance, accès global.

```
+---------------------------------------+
| Singleton                             |
+---------------------------------------+
| - instance : Singleton       {static} |
+---------------------------------------+
| - Singleton()                         |
| + getInstance() : Singleton  {static} |
+---------------------------------------+
```

A retenir : constructeur privé, attribut statique de son propre type, `getInstance()` statique.

---

## 2. Façade

Une interface simple devant un sous-système.

```
+--------+      +----------+      +---------+
| Client |----->|  Facade  |----->| ClasseA |
+--------+      +----------+  |   +---------+
                | + op()   |  |   +---------+
                +----------+  +-->| ClasseB |
                              |   +---------+
                              |   +---------+
                              +-->| ClasseC |
                                  +---------+
```

A retenir : le client ne connaît plus les classes du sous-système. Pas d'interface commune.

---

## 3. Adaptateur

Convertit une interface en une autre.

```
+--------+     +------------------+
| Client |---->|  «interface»     |
+--------+     |  Target          |
               +------------------+
               | + request()      |
               +------------------+
                        ^
                        |
               +------------------+          +------------------+
               |     Adapter      |--------->|     Adaptee      |
               +------------------+          +------------------+
               | + request()      |          | + specificRequest() |
               +------------------+          +------------------+

Adapter.request() : adaptee.specificRequest()
```

---

## 4. Procuration (Proxy)

Même interface, contrôle l'accès.

```
+--------+     +------------------+
| Client |---->|  «interface»     |
+--------+     |  Subject         |
               +------------------+
               | + request()      |
               +------------------+
                  ^            ^
                  |            |
        +--------------+   +--------------+
        | RealSubject  |<--|    Proxy     |
        +--------------+   +--------------+
        | + request()  |   | + request()  |
        +--------------+   +--------------+

Proxy.request() : controle, puis realSubject.request()
```

A retenir : Proxy et RealSubject implémentent le même Subject, Proxy a une référence vers RealSubject.

---

## 5. Composite

Traiter feuille et groupe de la même façon.

```
 +---------------------+
 |  «interface»        |<>--------+
 |  Component          |          | 0..*
 +---------------------+          |
 | + methode1()        |          |
 | + methode2()        |          |
 +---------------------+          |
      ^           ^               |
      |           |               |
 +----+---+   +---+----------------------+
 |  Leaf  |   |        Composite         |<>
 +--------+   +--------------------------+
 |+meth1()|   | - c : List<Component>    |
 |+meth2()|   +--------------------------+
 +--------+   | + methode1()             |
              | + methode2()             |
              | + add(x : Component)     |
              | + remove(x : Component)  |
              +--------------------------+

 Note sur Composite.methode1() : forall x in c : x.methode1()
 Note sur Composite.methode2() : forall x in c : x.methode2()
```

A retenir : la liste est de `Component` (feuilles ET composites). Leaf est la fin de la récursion.

---

## 6. Décorateur

Ajoute du comportement dynamiquement.

```
 +------------------------+
 |  «interface»           |<>---------+
 |  Component             |           | 1
 +------------------------+           |
 | + operation()          |           |
 +------------------------+           |
      ^              ^                |
      |              |                |
 +----+-----------+ +-+----------------------+
 |ConcreteComponent| | «abstract» Decorator  |<>
 +-----------------+ +-----------------------+
 | + operation()   | | # c : Component       |
 +-----------------+ +-----------------------+
                     | + operation()         |
                     +-----------------------+
                            ^         ^
                     DecoratorA   DecoratorB

 Decorator.operation()  : c.operation()
 DecoratorA.operation() : super.operation(); ajout()
```

A retenir : un seul `Component` enveloppé (multiplicité `1`). Avec une liste, ce serait un Composite.

---

## 7. Méthode de fabrique

La sous-classe décide quoi instancier.

```
 +-----------------------------------+          +------------------+
 |        «abstract» Creator         |- - - - ->|  «interface»     |
 +-----------------------------------+ utilise  |  Product         |
 | + anOperation()                   |          +------------------+
 | + factoryMethod() : Product {abs} |          | + methode()      |
 +-----------------------------------+          +------------------+
                  ^                                      ^
                  |                                      |
 +-----------------------------------+          +------------------+
 |         ConcreteCreator           |- - - - ->| ConcreteProduct  |
 +-----------------------------------+ «create» +------------------+
 | + factoryMethod() : Product       |          | + methode()      |
 +-----------------------------------+          +------------------+

 anOperation()   : p = factoryMethod(); p.methode()
 factoryMethod() : return new ConcreteProduct()
```

A retenir : variation par héritage (sous-classe de Creator).

---

## 8. Fabrique abstraite (version MazeGame)

```
 +-----------+        +-----------------------+        +----------------+
 |  Client   |------->| «abstract» MazeGame   |- - - ->| «interface»    |
 +-----------+        +-----------------------+        |   Door         |
                      | + createDoor() : Door |        +----------------+
                      +-----------------------+        | + methode()    |
                                ^                      +----------------+
                                |                          ^         ^
                      +-----------------------+            |         |
                      |      HpMazeGame       |        +--------+ +--------+
                      +-----------------------+- - - ->| HpDoor | |  Door2 |
                      | + createDoor() : Door |«create»+--------+ +--------+
                      +-----------------------+

 HpMazeGame.createDoor() : return new HpDoor()
```

A retenir : le Client ne connaît que `MazeGame` et `Door`, jamais `HpDoor`.

Nuance : avec une seule méthode `createDoor`, c'est techniquement une méthode de fabrique. Pour une vraie fabrique abstraite, ajouter une famille : `createRoom() : Room` dans `MazeGame`, avec `HpRoom` créé par `HpMazeGame` (jamais un `HpDoor` avec une `Room2`).

---

## Pièges d'examen

- Adapter / Proxy / Décorateur enveloppent tous un objet. Adapter change l'interface, Proxy garde la même et contrôle l'accès, Décorateur garde la même et ajoute du comportement.
- Façade simplifie plusieurs classes, Adapter rend une classe compatible.
- Composite : `0..*` enfants. Décorateur : `1` composant.
- Méthode de fabrique : héritage. Fabrique abstraite : objet fabrique passé au client, famille de produits.