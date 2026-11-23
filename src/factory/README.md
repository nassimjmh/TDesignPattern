# Méthode de fabrique / Factory Method (TD4 + rattrapage)

## Intention

Définir une **interface pour la création** d'un objet, en laissant aux **sous-classes** le soin de choisir la classe concrète à instancier.

Famille : **création**.

## UML global (cours)

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

A retenir : variation **par héritage** (sous-classe de `Creator`).

## UML de l'exercice (TD4, labyrinthe)

```
 +-------------------------------------+                 +----------------------+
 |        MazeGameCreator (Creator)    |                 |   «interface»        |
 +-------------------------------------+                 |   MapSite            |
 | + create() : Maze        (anOperation)|               +----------------------+
 | + makeMaze() : Maze                 |                 | + enter()            |
 | + makeRoom(n : int) : Room          |                 +----------------------+
 | + makeWall() : Wall                 |                   ^        ^        ^
 | + makeDoor(r1, r2) : Door           |                   |        |        |
 +-------------------------------------+                 Room     Wall     Door
        ^                      ^                          ^         ^        ^
        |                      |                          |         |        |
 +----------------------+  +----------------------+  EnchantedRoom BombedWall MagicDoor
 | EnchantedMazeCreator |  |  BombedMazeCreator   |  RoomWithABomb
 +----------------------+  +----------------------+
 | makeRoom : EnchantedRoom | makeRoom : RoomWithABomb
 | makeDoor : MagicDoor     | makeWall : BombedWall
 +----------------------+  +----------------------+

 create() : maze = makeMaze(); room1 = makeRoom(1); room2 = makeRoom(2);
            door = makeDoor(room1, room2); ... return maze
```

`create()` est écrit **une seule fois** ; les sous-classes ne redéfinissent que `makeXxx()`.

Propriétés (question 4) : pas de duplication de `create()` ; pour une nouvelle variante il faut **une sous-classe de Creator** ; on ne peut pas changer de famille à l'exécution sans changer d'objet jeu ; un seul produit créé par méthode (pas de garantie de cohérence entre pièces, cf. Fabrique abstraite).

`SimpleMazeGame` montre la solution **sans pattern** (une méthode par variante, code copié-collé).

## Rattrapage : les forgerons

Pattern : **Méthode de fabrique** (un forgeron = un seul type d'arme, de nouvelles armes sans modifier le code existant).

```
 +---------------------------------+  utilise   +------------------------+
 |      «abstract» Forgeron        |- - - - - ->| «abstract» Arme        |
 +---------------------------------+            +------------------------+
 | # creerArme() : Arme    {abs}   |            | - puissance : int      |
 | + interagir(p : Personnage)     |            | + addPuissance(x)      |
 +---------------------------------+            +------------------------+
     ^          ^          ^                       ^        ^       ^
     |          |          |                       |        |       |
 ForgeronEpee ForgeronArc ForgeronHache          Epee      Arc    Hache
   creerArme()  creerArme() creerArme()
   new Epee()   new Arc()   new Hache()

 interagir(p) : a = creerArme(); a.addPuissance(5); p.setArme(a)

 Personnage ---- arme : 0..1 ----> Arme
```

Code client : `new ForgeronEpee().interagir(aragorn); new ForgeronArc().interagir(legolas); new ForgeronHache().interagir(gimli);`

## Pièges d'examen

- Méthode de fabrique : **héritage**. Fabrique abstraite : **objet** fabrique passé au client, **famille** de produits.
- `anOperation()` utilise `factoryMethod()` : le Creator ne connaît pas la classe concrète.

## Lancer

Depuis la racine du dépôt (PowerShell) :

```powershell
javac -encoding UTF-8 -d out (Get-ChildItem -Recurse src/factory -Filter *.java).FullName
java -cp out factory.Main
```

Ou directement dans IntelliJ : clic droit sur `factory/Main.java` > Run.
