# Itérateur / Iterator (TD6)

> Corrigé : `iterator/tree/` (extrait de `td6.jar`). Les classes de `iterator/exemple/` sont des exemples complémentaires écrits ici (itérateurs avec pile explicite, `Playlist`).

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

## UML de l'exercice (TD6, arbre binaire : corrigé)

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
 |         Tree<V>            |      InOrderIterator PreOrderIterator PostOrderIterator
 +----------------------------+      +---------------------------------------------+
 | - value : V                |      | - current : Tree<V>                         |
 | - left, right, parent      |<-----| + XxxIterator(t : Tree<V>)                  |
 | - order : Order            | t    | + hasNext() : current != null               |
 +----------------------------+      | + next() : renvoie la valeur puis avance    |
 | + iterator() : Iterator<V> |      +---------------------------------------------+
 | + setOrder(o : Order)      |
 | + getLeft/Right/Parent()   |      enum Order { PREFIXE, INFIXE, POSTFIXE }
 +----------------------------+
```

`Tree.iterator()` choisit le bon itérateur avec un `switch` sur `order` (INFIXE par défaut) : le client ne fait que `for (V v : tree)`.

Le corrigé n'utilise **pas de pile** : grâce au lien `parent`, l'itérateur ne garde que le **nœud courant** (`current`) et calcule le suivant :

- **Infixe** : départ = nœud le plus à gauche (`leftmost`). Suivant : si un fils droit existe, son nœud le plus à gauche ; sinon on **remonte** tant qu'on vient d'un fils droit, puis on prend le parent.
- **Préfixe** : départ = la racine. Suivant : le fils gauche, sinon le fils droit, sinon on remonte jusqu'à un parent qui a un fils droit non encore visité.
- **Postfixe** : départ = première feuille (`firstleaf`, gauche en priorité). Suivant : si on est le fils gauche et que le frère droit existe, la première feuille du frère ; sinon le parent.

Résultats attendus : arbre `2(1,3)` → infixe `1 2 3`, préfixe `2 1 3`, postfixe `1 3 2`.

Rôles : Aggregate = `Iterable<V>` / `Tree<V>`, Iterator = `Iterator<V>`, ConcreteIterator = `InOrderIterator`, `PreOrderIterator`, `PostOrderIterator`.

Chaque itérateur garde **son propre état**, donc plusieurs parcours peuvent être en cours sur le même arbre. `next()` ne calcule que l'élément suivant (parcours paresseux), contrairement à un parcours récursif qui remplit une liste d'un coup.

## Exemples complémentaires (`iterator/exemple`)

`InfixIterator`, `PrefixIterator`, `PostfixIterator` : mêmes parcours mais avec une **pile explicite** (sans lien `parent`).

### `Playlist`

Une collection `Iterable<String>` avec un itérateur en classe interne (accès à la liste privée) : le client écrit `for (String t : playlist)` sans savoir que c'est une `ArrayList`.

## Pièges d'examen

- Le `for-each` Java appelle `iterator()`, `hasNext()` et `next()` : une classe est utilisable dans un `for-each` si elle implémente `Iterable`.
- Itérateur vs Visiteur : l'itérateur **parcourt** (mêmes types d'éléments) ; le visiteur **applique une opération** différente selon le type de chaque élément.
- `next()` doit lever `NoSuchElementException` s'il n'y a plus d'élément.
- Parcours récursif avec une liste : pensez aux nœuds qui n'ont **qu'un seul enfant** (ex. pas de fils gauche) : leur valeur doit quand même être ajoutée.
- Sans pile, l'itérateur d'arbre a besoin du lien `parent` pour remonter.

## Arborescence

Les sous-packages reprennent ceux de `td6.jar` ; `exemple/` et le `Main` racine sont ajoutés.

```
iterator/
├── exemple/
│   ├── InfixIterator.java
│   ├── Playlist.java
│   ├── PostfixIterator.java
│   └── PrefixIterator.java
├── tree/
│   ├── iterator/
│   │   ├── InOrderIterator.java
│   │   ├── PostOrderIterator.java
│   │   └── PreOrderIterator.java
│   ├── Main.java
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
