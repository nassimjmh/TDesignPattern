# Composite (TD3, Starbucks)

## Intention

**Composer** des objets dans des structures **arborescentes** pour représenter des hiérarchies composants/composés. Le client traite de la même façon un objet individuel (feuille) et une composition d'objets.

Famille : **structure**.

## UML global (cours)

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

 Composite.methode1() : forall x in c : x.methode1()
```

A retenir : la liste est de `Component` (feuilles ET composites). `Leaf` est la fin de la récursion. Multiplicité `0..*`.

## UML de l'exercice (commande Starbucks)

```
                       +------------------------------+<>---------+
                       |        «abstract» Order      |           | children
                       +------------------------------+           | 0..*
                       | + getPrice() : double {abs}  |           |
                       | + total()                    |           |
                       | # print()                    |           |
                       | + add(o) / remove(o)         |           |
                       | + getChild(i)                |           |
                       +------------------------------+           |
                          ^        ^            ^                 |
          +---------------+        |            +----------+      |
          |                        |                       |      |
 +-----------------+      +-----------------+      +----------------------+
 |  «abstract»     |      |      Menu       |      |    OrderComposite    |<>
 |  Beverage       |      +-----------------+      +----------------------+
 +-----------------+      | - beverage      |      | - children : List    |
   ^ ^ ^ ^ ^                | - food          |      +----------------------+
   | | | | |              +-----------------+      | + getPrice() = somme |
 Espresso Chocolate       | getPrice() =    |      | + print()  = chaque  |
 Coffee Decaf Tea         |  (b + f) * 0.9  |      |   enfant imprime     |
                          +-----------------+      +----------------------+
 +-----------------+
 |  «abstract» Food|
 +-----------------+
   ^ ^ ^ ^ ^
   | | | | |
 Cake Muffin Cookie Donut Sandwich
```

Rôles : Component = `Order`, Leaf = `Beverage`, `Food`, `Menu` (un menu est une feuille ici : boisson + encas + remise 10 %), Composite = `OrderComposite`.

Résultat attendu (`Main`) :

```
- menu (chocolat + muffin) : 5.22
- café : 1.75
- café : 1.75
Total : 8.72
```

## Pièges d'examen

- Composite : `0..*` enfants. Décorateur : `1` composant.
- Composite se focalise sur la **structure** (traiter uniformément individus et compositions), Décorateur sur l'**ajout de responsabilités**.

## Arborescence

Les sous-packages reprennent ceux du .jar du corrigé ; `Main` (à la racine du package) lance la démonstration.

```
composite/
├── beverage/
│   ├── Beverage.java
│   ├── Chocolate.java
│   ├── Coffee.java
│   ├── Decaf.java
│   ├── Espresso.java
│   └── Tea.java
├── food/
│   ├── Cake.java
│   ├── Cookie.java
│   ├── Donut.java
│   ├── Food.java
│   ├── Muffin.java
│   └── Sandwich.java
├── order/
│   ├── Menu.java
│   ├── Order.java
│   └── OrderComposite.java
└── Main.java
```

## Lancer

Depuis la racine du dépôt (PowerShell) :

```powershell
javac -encoding UTF-8 -d out (Get-ChildItem -Recurse src/composite -Filter *.java).FullName
java -cp out composite.Main
```

Ou directement dans IntelliJ : clic droit sur `composite/Main.java` > Run.
