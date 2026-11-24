# Visiteur / Visitor (TD6 + exemple des bâtiments)

> **Pas encore de corrigé** pour ce TD. `visiteur/boolexpr` part des classes du .jar `tree.jar` (que vous aviez déjà) auxquelles j'ai ajouté `accept()` et deux visiteurs ; `visiteur/batiment` reprend l'exemple d'une conversation partagée. À comparer avec la correction quand elle arrivera.

## Intention

Représenter une **opération à effectuer sur les éléments d'une structure** et permettre de **définir une nouvelle opération sans modifier les classes des éléments** sur lesquels elle opère.

Famille : **comportement**.

Métaphore (meilleure que le taxi) : des **agents** (assureur, pompier, fisc) visitent des **bâtiments** (maison, immeuble, usine). Chaque bâtiment ouvre sa porte (`accept`) puis se présente (`visiterMaison(this)`) ; chaque agent a sa propre procédure par type de bâtiment. Un nouvel agent = une nouvelle classe, aucun bâtiment n'est modifié.

## UML global (cours)

```
 +--------+      +---------------------------+           +---------------------------+
 | Client |----->|     «interface» Visitor   |           |   «interface» Element     |
 +--------+      +---------------------------+           +---------------------------+
                 | + visit(a : ConcreteElemA)|           | + accept(v : Visitor)     |
                 | + visit(b : ConcreteElemB)|           +---------------------------+
                 +---------------------------+                  ^              ^
                      ^               ^                         |              |
            +------------------+ +------------------+  +------------------+ +------------------+
            | ConcreteVisitor1 | | ConcreteVisitor2 |  | ConcreteElementA | | ConcreteElementB |
            +------------------+ +------------------+  +------------------+ +------------------+
                                                       | + accept(v)      | | + accept(v)      |
                                                       |   v.visit(this)  | |   v.visit(this)  |
                                                       +------------------+ +------------------+
```

A retenir : **double dispatch**. `element.accept(visitor)` (1er dispatch, polymorphisme sur l'élément réel) appelle `visitor.visit(this)` : dans `accept`, `this` a un type connu à la compilation, donc la bonne surcharge `visit` est choisie (2e dispatch). Sans cela, il faudrait des `instanceof` dans le visiteur.

Avantages : nouvelle opération = nouveau visiteur, sans toucher aux éléments ; un visiteur peut **accumuler un état** ; il parcourt des éléments de **types différents** (contrairement à un itérateur).
Inconvénient : ajouter un **nouveau type d'élément** oblige à modifier **toutes** les classes de visiteurs. A utiliser quand la **structure change rarement** mais que les opérations changent souvent.

## UML de l'exercice (TD6, expressions booléennes)

```
 +----------------------------+            +------------------------------+
 |   «interface» Node         |<-----------|   «interface» Visitor        |
 | + accept(v : Visitor)      |  accept    | + visit(b : Bool)            |
 +----------------------------+            | + visit(a : And)             |
        ^              ^                   | + visit(o : Or)              |
        |              |                   | + visit(n : Not)             |
 +-----------+   +--------------------+    +------------------------------+
 |   Bool    |   | «interface»        |            ^               ^
 | - value   |   | Operator           |    +----------------+ +----------------+
 +-----------+   +--------------------+    |  PrintVisitor  | |  EvalVisitor   |
                      ^          ^         | - sb           | | - result       |
          +--------------------+ +--------------------+ +----------------+ +----------------+
          | «abstract»         | | «abstract»         |
          | BinaryOperator     | | UnaryOperator      |
          | left, right : Node | | operand : Node     |
          +--------------------+ +--------------------+
               ^          ^              ^
              And         Or            Not

 Bool.accept(v)           : v.visit(this)
 EvalVisitor.visit(And a) : a.left.accept(this); l = result; a.right.accept(this); result = l && result
 PrintVisitor.visit(Not n): sb.append("(Not "); n.operand.accept(this); sb.append(")")
```

Résultat : `((true Or false) And (Not true)) = false`.

Inconvénients de la version sans pattern (question 3 du TD) : chaque nouvelle opération (affichage, évaluation, simplification...) oblige à **modifier toutes les classes de noeuds** et mélange la structure et les traitements.

## UML de l'exemple (bâtiments et agents)

```
 +----------------+        +--------------------------+         +--------------------------+
 |   Quartier     |------->|   «interface» Batiment   |         |   «interface» Visiteur   |
 | (ObjectStruct.)|  0..*  | + accept(v : Visiteur)   |-------->| + visiterMaison(m)       |
 | + accept(v)    |        +--------------------------+  accept | + visiterImmeuble(i)     |
 +----------------+            ^        ^        ^              | + visiterUsine(u)        |
                               |        |        |              +--------------------------+
                         +---------+ +----------+ +--------+          ^         ^         ^
                         | Maison  | | Immeuble | | Usine  |          |         |         |
                         +---------+ +----------+ +--------+     Assureur   Pompier     Fisc
                         |accept(v)| |accept(v) | |accept(v)|
                         | v.visiterMaison(this)  ...                  Assureur : prime selon surface / lots / risque
                         +---------+ +----------+ +--------+          Pompier  : conformité sécurité incendie
                                                                      Fisc     : taxe foncière / professionnelle

 Assureur garde un état : totalPrimes (accumulé pendant la visite)
```

Ajouter un agent (ex. `Douanier`) : une classe de plus, **aucun bâtiment modifié** (cas où le pattern est avantageux). Ajouter un `Entrepot` : il faut ajouter `visiterEntrepot` dans l'interface `Visiteur`, donc dans **tous** les agents : le compilateur signale chaque agent à mettre à jour (cas où le pattern coûte cher).

## Pièges d'examen

- `accept()` est redéfini dans **chaque** classe concrète (`v.visit(this)`), pas seulement déclaré dans l'interface : sinon le type statique de `this` serait `Node` et on perdrait le double dispatch.
- Visiteur vs Itérateur : l'itérateur parcourt, le visiteur **applique une opération par type** d'élément.
- Le visiteur connaît les classes concrètes des éléments ; les éléments ne connaissent que l'interface `Visitor`.

## Arborescence

```
visiteur/
├── batiment/
│   ├── Assureur.java
│   ├── Batiment.java
│   ├── Fisc.java
│   ├── Immeuble.java
│   ├── Maison.java
│   ├── Pompier.java
│   ├── Quartier.java
│   ├── Usine.java
│   └── Visiteur.java
├── boolexpr/
│   ├── And.java
│   ├── BinaryOperator.java
│   ├── Bool.java
│   ├── EvalVisitor.java
│   ├── Node.java
│   ├── Not.java
│   ├── Operator.java
│   ├── Or.java
│   ├── PrintVisitor.java
│   ├── UnaryOperator.java
│   └── Visitor.java
└── Main.java
```


## Lancer

Depuis la racine du dépôt (PowerShell) :

```powershell
javac -encoding UTF-8 -d out (Get-ChildItem -Recurse src/visiteur -Filter *.java).FullName
java -cp out visiteur.Main
```

Ou directement dans IntelliJ : clic droit sur `visiteur/Main.java` > Run.
