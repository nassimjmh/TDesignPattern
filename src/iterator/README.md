# Itérateur / Iterator (TD6)

> **Pas encore de corrigé** pour ce TD. Les classes de `iterator/exemple/` sont des **exemples écrits ici** pour étudier le pattern ; elles seront à comparer avec la correction quand elle arrivera. `iterator/tree/` (vos parcours récursifs et la classe `Tree` du .jar) est laissé tel quel.

## Intention

Fournir un moyen de **parcourir séquentiellement un agrégat** (collection, conteneur) d'éléments **sans connaître sa structure interne**.

Famille : **comportement**.

## UML global (cours)

```
 +--------+      +------------------------+            +------------------------+
 | Client |----->|  «interface»           |            |  «interface»           |
 +--------+      |  Aggregate (Iterable)  |----------->|  Iterator              |
     |           +------------------------+  crée      +------------------------+
     |           | + createIterator()     |            | + hasNext() : boolean  |
     |           |   : Iterator           |            | + next() : Element     |
     |           +------------------------+            +------------------------+
     |                     ^                                       ^
     |                     |                                       |
     |           +------------------------+  - - - - ->  +------------------------+
     |           |  ConcreteAggregate     |  «create»    |  ConcreteIterator      |
     |           +------------------------+              +------------------------+
     |           | + createIterator()     |<-------------| - courant              |
     |           |   : return new         |  aggregate   | + hasNext() / next()   |
     +---------->|     ConcreteIterator() |              +------------------------+
                 +------------------------+

 for (Element e : aggregate)  <=>  it = aggregate.createIterator(); while (it.hasNext()) { e = it.next(); ... }
```

A retenir : `createIterator()` est une **méthode de fabrique** (en Java : `Iterable.iterator()`). Le client ne dépend que des **interfaces** `Iterable` / `Iterator`, jamais de la structure interne.

## UML de l'exercice (TD6, arbre binaire)

```
 +----------------------------+            +----------------------------+
 |       «interface»          |            |       «interface»          |
 |       Iterable<V>          |----------->|       Iterator<V>          |
 +----------------------------+   crée     +----------------------------+
 | + iterator() : Iterator<V> |            | + hasNext() : boolean      |
 +----------------------------+            | + next() : V               |
            ^                              +----------------------------+
            |                                  ^          ^          ^
 +----------------------------+                |          |          |
 |         Tree<V>            |      InfixIterator  PrefixIterator  PostfixIterator
 +----------------------------+      +---------------------------------------------+
 | - value : V                |      | - pile : Deque<Tree<V>>                     |
 | - left, right, parent      |<-----| + InfixIterator(racine : Tree<V>)           |
 +----------------------------+ racine| + hasNext() / next()                       |
 | + iterator() : Iterator<V> |      +---------------------------------------------+
 | + getLeft() / getRight()   |
 | + getValue() / getParent() |
 +----------------------------+

 Infixe   : gauche, racine, droite   (1 2 3 4 5 6 7)
 Préfixe  : racine, gauche, droite   (4 2 1 3 6 5 7)
 Postfixe : gauche, droite, racine   (1 3 2 5 7 6 4)
```

Rôles : Aggregate = `Iterable<V>` / `Tree<V>`, Iterator = `Iterator<V>`, ConcreteIterator = `InfixIterator`, `PrefixIterator`, `PostfixIterator`.

Chaque itérateur garde **son propre état** (une pile) : on peut avoir plusieurs parcours en cours sur le même arbre. `next()` ne calcule que l'élément suivant (parcours paresseux), contrairement à un parcours récursif qui remplit une liste d'un coup.

## Autre exemple : `Playlist`

Une collection `Iterable<String>` avec un itérateur en classe interne (accès à la liste privée) : le client écrit `for (String t : playlist)` sans savoir que c'est une `ArrayList`.

## Pièges d'examen

- Le `for-each` Java appelle `iterator()`, `hasNext()` et `next()` : une classe est utilisable dans un `for-each` si elle implémente `Iterable`.
- Itérateur vs Visiteur : l'itérateur **parcourt** (mêmes types d'éléments) ; le visiteur **applique une opération** différente selon le type de chaque élément.
- `next()` doit lever `NoSuchElementException` s'il n'y a plus d'élément.
- Parcours récursif avec une liste (comme dans `iterator/tree`) : pensez aux noeuds qui n'ont **qu'un seul enfant** (ex. pas de fils gauche) : leur valeur doit quand même être ajoutée.

## Arborescence

```
iterator/
├── exemple/
│   ├── InfixIterator.java
│   ├── Playlist.java
│   ├── PostfixIterator.java
│   └── PrefixIterator.java
├── tree/
│   ├── Main.java
│   ├── Infixe.java
│   ├── Prefixe.java
│   ├── Suffixe.java
│   └── Tree.java
└── Main.java
```


## Lancer

Depuis la racine du dépôt (PowerShell) :

```powershell
javac -encoding UTF-8 -d out (Get-ChildItem -Recurse src/iterator -Filter *.java).FullName
java -cp out iterator.Main
```

Ou directement dans IntelliJ : clic droit sur `iterator/Main.java` > Run.
