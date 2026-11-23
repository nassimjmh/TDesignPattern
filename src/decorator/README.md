# Décorateur (TD3, condiments)

## Intention

**Attacher dynamiquement** des responsabilités supplémentaires à un objet. Alternative flexible à l'héritage pour étendre des fonctionnalités.

Famille : **structure**.

## UML global (cours)

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

A retenir : **un seul** `Component` enveloppé (multiplicité `1`). Avec une liste, ce serait un Composite.

## UML de l'exercice (TD3, condiments)

```
                 +----------------------+
                 |    «abstract» Order  |
                 +----------------------+
                           ^
                           |
                 +----------------------+
                 |  «abstract» Beverage |<>------------------+
                 +----------------------+                    | decorated : 1
                    ^         ^                              |
        +-----------+         +--------------------+         |
        |                                          |         |
 Espresso, Chocolate,                +------------------------------+
 Coffee, Decaf, Tea                  | «abstract» CondimentDecorator|<>
 (ConcreteComponent)                 +------------------------------+
                                     | # decorated : Beverage       |
                                     +------------------------------+
                                         ^     ^      ^      ^
                                         |     |      |      |
                                       Milk  Mocha   Soy   Whip
                                      +0.20  +0.30  +0.40  +0.50

 Milk.getPrice() : decorated.getPrice() + 0.2
 Milk.toString() : decorated + ", lait"
```

Utilisation (Main) :

```java
new Mocha(new Mocha(new Coffee()))   // café, moka, moka : 2.35
new Milk(new Soy(new Coffee()))      // café, soja, lait : 2.35
```

Résultat attendu : `Total : 9.92`.

Inconvénients de la modélisation par booléens (question 3) : classe `Boisson` qui change à chaque nouveau condiment, pas de dose double sans nouveaux attributs, prix et affichage pleins de `if`.

## Pièges d'examen

- Le décorateur implémente **la même interface** que ce qu'il décore, et **contient** un composant.
- Décorateur vs Proxy : le décorateur **ajoute** du comportement, le proxy **contrôle l'accès**.

## Arborescence

Les sous-packages reprennent ceux du .jar du corrigé ; `Main` (à la racine du package) lance la démonstration.

```
decorator/
├── beverage/
│   ├── condiment/
│   │   ├── CondimentDecorator.java
│   │   ├── Milk.java
│   │   ├── Mocha.java
│   │   ├── Soy.java
│   │   └── Whip.java
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
javac -encoding UTF-8 -d out (Get-ChildItem -Recurse src/decorator -Filter *.java).FullName
java -cp out decorator.Main
```

Ou directement dans IntelliJ : clic droit sur `decorator/Main.java` > Run.
