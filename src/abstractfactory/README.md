# Fabrique abstraite / Abstract Factory (TD4 + examen)

## Intention

Fournir une interface pour la création de **familles d'objets apparentés ou interdépendants**, sans qu'il soit nécessaire de spécifier leurs classes concrètes.

Famille : **création**.

## UML global (cours)

```
 +-----------+        +------------------------+
 |  Client   |------->|  «interface»           |
 +-----------+        |  AbstractFactory       |
      |               +------------------------+
      |               | + createProductA()     |
      |               | + createProductB()     |
      |               +------------------------+
      |                    ^              ^
      |                    |              |
      |           +----------------+ +----------------+
      |           | ConcreteFactory1| | ConcreteFactory2|
      |           +----------------+ +----------------+
      |           | createProductA() : new A1()       |
      |           | createProductB() : new B1()       |
      v
 +------------------+   +------------------+
 | «interface» ProdA|   | «interface» ProdB|      Famille 1 : A1 + B1
 +------------------+   +------------------+      Famille 2 : A2 + B2
     ^         ^            ^         ^
    A1        A2           B1        B2
```

A retenir : le client ne connaît que `AbstractFactory` et les interfaces des produits ; une fabrique concrète produit **toute une famille cohérente**.

## UML de l'exercice (TD4, labyrinthe)

```
 +--------------------------------+        +-----------------------------+
 |  MazeGameAbstractFactory       |------->|        MazeFactory          |
 |  + create(f : MazeFactory)     |        +-----------------------------+
 |      : Maze                    |        | + makeMaze() : Maze         |
 +--------------------------------+        | + makeRoom(n) : Room        |
                                           | + makeWall() : Wall         |
                                           | + makeDoor(r1, r2) : Door   |
                                           +-----------------------------+
                                                ^                 ^
                                                |                 |
                                  +--------------------+  +--------------------+
                                  | EnchantedMazeFactory|  |  BombedMazeFactory |
                                  +--------------------+  +--------------------+
                                  | makeRoom : EnchantedRoom | makeRoom : RoomWithABomb
                                  | makeDoor : MagicDoor     | makeWall : BombedWall
                                  +--------------------+  +--------------------+

 create(factory) : maze = factory.makeMaze(); room1 = factory.makeRoom(1); ...
```

Différence avec la Méthode de fabrique (question 4) : ici la création est déléguée à **un objet fabrique passé en paramètre** (composition), plus de sous-classe du jeu ; on peut **changer de famille à l'exécution** ; la fabrique regroupe **plusieurs** méthodes de création pour des produits liés.

## Examen : decks cohérents

Besoin : deux joueurs jouent avec des cartes de la même version (officielles, fan-art, collab), logique du jeu séparée de la représentation graphique, sans duplication quand on ajoute une version.

```
 +---------+      +-------------------------+      +------------------------+
 | Joueur  |----->|   CarteGraphique        |----->|  «interface»           |
 | deck    | 0..60| - carte : Carte         |      |  Illustration          |
 +---------+      | - illustration          |      | + dessiner(g, l, h)    |
                  +-------------------------+      +------------------------+
                         |                              ^        ^        ^
                         v                              |        |        |
                  +-----------+          IllustrationOfficielle  FanArt    Collab
                  |  Carte    | (logique)
                  +-----------+

        +--------------------------------------+
        |   «interface» FabriqueIllustrations  |
        +--------------------------------------+
        | + creerIllustrationPikachu()         |
        | + creerIllustrationEnergieElectrique()|
        +--------------------------------------+
              ^               ^              ^
   FabriqueOfficielle  FabriqueFanArt   FabriqueCollab
   (chacune ne crée que des illustrations de sa version)
```

Code client (Q10d) : `composerDeck("Sacha", new FabriqueOfficielle())` pour les deux joueurs.

## Pièges d'examen

- Avec une seule méthode `createX`, ce n'est techniquement qu'une méthode de fabrique : pour une **vraie** fabrique abstraite, il faut une **famille** (au moins deux produits liés).
- Ajouter une **nouvelle famille** est facile (nouvelle fabrique) ; ajouter un **nouveau produit** est coûteux (toutes les fabriques changent).

## Lancer

Depuis la racine du dépôt (PowerShell) :

```powershell
javac -encoding UTF-8 -d out (Get-ChildItem -Recurse src/abstractfactory -Filter *.java).FullName
java -cp out abstractfactory.Main
```

Ou directement dans IntelliJ : clic droit sur `abstractfactory/Main.java` > Run.
