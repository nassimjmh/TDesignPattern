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

## 9. Commande (Command)

Encapsule une opération dans un objet, pour pouvoir l'exécuter ET l'annuler. Exemple : problème des bidons d'eau.

Rôles : Client = `Simulator`, Invoker = `Historique`, Receiver = `Can`.

```
 +-----------------------------+  historique  +-----------------------------+
 |     Simulator (Client)      |------------->|    Historique (Invoker)     |
 +-----------------------------+      1       +-----------------------------+
 | - can : Can[]               |              | - pile : Stack<Command>     |
 | - historique : Historique   |              +-----------------------------+
 +-----------------------------+              | + run(c : Command)          |
        <>                                    | + annuler()                 |
        | can                                 +-----------------------------+
        | 1..*                                              <>
        |                                                    | pile 0..*
        |                                                    v
        |                                         +----------------------+
        |                                         |     «interface»      |
        |                                         |       Command        |
        |                                         +----------------------+
        |                                         | + exec()             |
        |                                         | + undo()             |
        |                                         +----------------------+
        |                                              ^            ^
        |                                              |            |
        |                                       +------+-----+  +---+------------+
        |                                       |  Remplir   |  |    Verser      |
        |                                       +------------+  +----------------+
        |                                       | - avant:int|  | - quantite:int |
        |                                       +------------+  +----------------+
        |                                       | + exec()   |  | + exec()       |
        |                                       | + undo()   |  | + undo()       |
        |                                       +-----+------+  +---+-----+------+
        |                                             | can         | src | dst
        v                                             v             v     v
 +------------------------------------------------------------------------------+
 |                              Can (Receiver)                                  |
 +------------------------------------------------------------------------------+
 | - niveau : int                                                               |
 | - capacite : int                                                             |
 +------------------------------------------------------------------------------+
 | + remplir()    + vider()    + setNiveau(n : int)                             |
 +------------------------------------------------------------------------------+

 (Vider : idem Remplir)

 Historique.run(c)    : c.exec(); pile.push(c)
 Historique.annuler() : c = pile.pop(); c.undo()
 Usage                : historique.run(new Remplir(can[0]));
                        historique.run(new Verser(can[0], can[1]))
 Remplir.exec()       : avant = can.niveau; can.remplir()
 Remplir.undo()       : can.setNiveau(avant)
 Verser.exec()        : quantite = min(src.niveau, dst.capacite - dst.niveau);
                        src.niveau -= quantite; dst.niveau += quantite
 Verser.undo()        : dst.niveau -= quantite; src.niveau += quantite
```

A retenir :
- `Simulator` (Client) possède `can[]` et un `Historique`, crée les commandes avec `can[i]` et les passe à l'`Historique`.
- `Historique` (Invoker) garde la pile et ne connaît que `Command`, jamais `Remplir` ni `Can`.
- `Can` (Receiver) fait le vrai travail.
- Chaque commande sauvegarde ce qu'il faut pour défaire (`avant`, `quantite`) au moment du `exec()`, pas avant.
- Annuler plusieurs fois = dépiler (dernier exécuté = premier annulé).

---

## Pièges d'examen

- Adapter / Proxy / Décorateur enveloppent tous un objet. Adapter change l'interface, Proxy garde la même et contrôle l'accès, Décorateur garde la même et ajoute du comportement.
- Façade simplifie plusieurs classes, Adapter rend une classe compatible.
- Composite : `0..*` enfants. Décorateur : `1` composant.
- Méthode de fabrique : héritage. Fabrique abstraite : objet fabrique passé au client, famille de produits.
- Commande : le `undo()` doit restaurer l'état exact d'avant, donc la commande mémorise l'état (ou la quantité réellement transférée) dans `exec()`.