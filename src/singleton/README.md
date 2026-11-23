# Singleton (TD1)

## Intention

Garantir qu'une classe n'a **qu'une seule instance** et fournir un **point d'accès global** à cette instance.

Famille : **création**.

## UML global (cours)

```
+---------------------------------------+
| Singleton                             |
+---------------------------------------+
| - instance : Singleton       {static} |
+---------------------------------------+
| - Singleton()                         |
| + getInstance() : Singleton  {static} |
+---------------------------------------+

getInstance() : si instance == null (lazy) alors instance = new Singleton();
                return instance;
```

A retenir : constructeur **privé**, attribut **statique** de son propre type, `getInstance()` **statique**.

## UML de l'exercice (TD1 : système de logging)

```
 +--------------------------------------------+
 |          LoggerLazy / LoggerEager          |
 +--------------------------------------------+
 | - nbLoggedMessages : int                   |
 | - uniqueInstance : Logger        {static}  |
 +--------------------------------------------+
 | - Logger()                                 |
 | + getInstance() : Logger         {static}  |
 | + log(msg : String)                        |
 +--------------------------------------------+

 Lazy  : uniqueInstance = null au départ ; créée au 1er getInstance()
 Eager : uniqueInstance = new Logger() à l'initialisation de la classe

 +--------------------------------------------+
 |              LoggerMultiton                |
 +--------------------------------------------+
 | - instances : Map<String, Logger> {static} |
 | - nbLoggedMessages : int                   |
 +--------------------------------------------+
 | - LoggerMultiton()                         |
 | + getInstance(key : String)       {static} |
 | + log(msg : String)                        |
 +--------------------------------------------+

 getInstance(key) : si la clé est absente, crée l'instance et la range dans la Map
```

Multiton = Singleton généralisé : une instance **par clé** (ex. un logger "info" et un logger "err").

## Lazy vs Eager

| | Lazy | Eager |
|---|---|---|
| Création | au premier `getInstance()` | au chargement de la classe |
| Thread-safe | non, sauf `synchronized` | oui (garanti par la JVM) |
| Coût | seulement si utilisé | toujours payé |

## Pièges d'examen

- Oublier de mettre le constructeur en `private`.
- `getInstance()` doit être `static` (sinon il faudrait déjà une instance pour l'appeler).
- Lazy en multi-thread : deux threads peuvent créer deux instances (ajouter `synchronized`).

## Arborescence

Les sous-packages reprennent ceux du .jar du corrigé ; `Main` (à la racine du package) lance la démonstration.

```
singleton/
├── logging/
│   ├── Logger.java
│   ├── LoggerEager.java
│   ├── LoggerLazy.java
│   └── LoggerMultiton.java
└── Main.java
```

## Lancer

Depuis la racine du dépôt (PowerShell) :

```powershell
javac -encoding UTF-8 -d out (Get-ChildItem -Recurse src/singleton -Filter *.java).FullName
java -cp out singleton.Main
```

Ou directement dans IntelliJ : clic droit sur `singleton/Main.java` > Run.
