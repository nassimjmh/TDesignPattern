# Adaptateur (TD2)

## Intention

Faire correspondre à une **interface donnée** un objet existant qu'on ne contrôle pas (convertir l'interface d'une classe en une autre interface attendue par le client).

Famille : **structure**.

## UML global (cours)

```
+--------+     +------------------+
| Client |---->|  «interface»     |
+--------+     |  Target          |
               +------------------+
               | + request()      |
               +------------------+
                        ^
                        |
               +------------------+          +---------------------+
               |     Adapter      |--------->|       Adaptee       |
               +------------------+          +---------------------+
               | + request()      |          | + specificRequest() |
               +------------------+          +---------------------+

Adapter.request() : adaptee.specificRequest()
```

### Adaptateur d'objet vs adaptateur de classe (question du rattrapage)

| | Adaptateur d'**objet** | Adaptateur de **classe** |
|---|---|---|
| Lien avec l'adapté | **composition** : l'adaptateur contient un `Adaptee` | **héritage** : l'adaptateur étend `Adaptee` et implémente `Target` |
| Héritage multiple | non requis | requis (impossible en Java pour 2 classes, possible avec une interface + une classe) |
| Sous-classes de l'adapté | adaptées aussi | non, une seule classe adaptée |
| Redéfinition du comportement | difficile | facile |

## UML de l'exercice (Enumeration -> Iterator)

```
 +----------------+      +-------------------------+
 | Main.print()   |----->|   «interface»           |
 |  (client)      |      |   Iterator<Object>      |
 +----------------+      +-------------------------+
                         | + hasNext() : boolean   |
                         | + next() : Object       |
                         | + remove()              |
                         +-------------------------+
                                     ^
                                     |
                         +-------------------------+   e   +-------------------------+
                         |   EnumerationAdapter    |------>|   «interface»           |
                         +-------------------------+       |   Enumeration<Object>   |
                         | - e : Enumeration       |       +-------------------------+
                         +-------------------------+       | + hasMoreElements()     |
                         | + hasNext()             |       | + nextElement()         |
                         | + next()                |       +-------------------------+
                         | + remove()              |
                         +-------------------------+

 hasNext() : return e.hasMoreElements()
 next()    : return e.nextElement()
 remove()  : throw new UnsupportedOperationException()   (Enumeration ne sait pas supprimer)
```

Rôles : Target = `Iterator`, Adaptee = `Enumeration`, Adapter = `EnumerationAdapter`, Client = la méthode `print`.

## Pièges d'examen

- `remove()` n'existe pas dans `Enumeration` : on lève `UnsupportedOperationException` (inutile depuis Java 8, méthode `default`).
- Adapter / Proxy / Décorateur enveloppent tous un objet : l'adaptateur **change l'interface**, les deux autres la gardent.

## Lancer

Depuis la racine du dépôt (PowerShell) :

```powershell
javac -encoding UTF-8 -d out (Get-ChildItem -Recurse src/adapter -Filter *.java).FullName
java -cp out adapter.Main
```

Ou directement dans IntelliJ : clic droit sur `adapter/Main.java` > Run.
