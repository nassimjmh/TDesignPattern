# Commande / Command (TD5, bidons d'eau)

## Intention

**Encapsuler une requête comme un objet**, pour permettre de gérer une file d'attente ou un **historique** de requêtes et d'assurer le traitement des opérations **réversibles** (annuler).

Famille : **comportement**.

## UML global (cours)

```
 +--------+      +------------+      +------------------+
 | Client |----->|  Invoker   |<>--->|  «interface»     |
 +--------+      +------------+ 0..* |  Command         |
     |           | + run(c)   |      +------------------+
     |           +------------+      | + execute()      |
     |                               | + cancel()       |
     |                               +------------------+
     |                                        ^
     |                               +------------------+      receiver
     +- - - - creates - - - - - - - >| ConcreteCommand  |------------------> +----------+
                                     +------------------+                    | Receiver |
                                     | + execute()      |                    +----------+
                                     | + cancel()       |                    | action() |
                                     +------------------+                    +----------+

 ConcreteCommand.execute() : receiver.action()
```

## UML de l'exercice (corrigé)

Rôles : Client = `Simulator`, Invoker = `Invoker`, Receiver = `Can`.

```
 +-----------------------------+              +------------------------------+
 |     Simulator (Client)      |------------->|        Invoker               |
 +-----------------------------+      1       +------------------------------+
 | - cans : Can[]              |              | - history : Stack<Command>   |
 | - desiredVolume : int       |              +------------------------------+
 | - invoker : Invoker         |              | + pushCommand(c : Command)   |
 +-----------------------------+              | + popLastCommand()           |
        <>                                    +------------------------------+
        | cans 1..*                                          <>
        |                                                    | history 0..*
        |                                                    v
        |                                         +----------------------+
        |                                         |     «interface»      |
        |                                         |       Command        |
        |                                         +----------------------+
        |                                         | + execute()          |
        |                                         | + cancel()           |
        |                                         +----------------------+
        |                                                   ^
        |                                         +----------------------+
        |                                         |   «abstract»         |
        |                                         |   AbstractCommand    |
        |                                         | # decantedVolume:int |
        |                                         +----------------------+
        |                                           ^        ^        ^
        |                                           |        |        |
        |                                    FillCommand EmptyCommand DecantCommand
        |                                           | can      | can     | src , dest
        v                                           v          v         v
 +--------------------------------------------------------------------------+
 |                              Can (Receiver)                              |
 +--------------------------------------------------------------------------+
 | - maxVolume : int       - volume : int                                   |
 | + fill()   + empty()   + decant(dest : Can) : int   + setVolume(v : int) |
 +--------------------------------------------------------------------------+

 Invoker.pushCommand(c)  : c.execute(); history.push(c)
 Invoker.popLastCommand(): history.lastElement().cancel(); history.pop()
 FillCommand.execute()   : decantedVolume = max - volume; can.fill()
 FillCommand.cancel()    : can.setVolume(volume - decantedVolume)
 EmptyCommand.execute()  : decantedVolume = volume; can.empty()
 EmptyCommand.cancel()   : can.setVolume(decantedVolume)
 DecantCommand.execute() : decantedVolume = src.decant(dest)
 DecantCommand.cancel()  : src += decantedVolume ; dest -= decantedVolume
```

Chaque commande **mémorise ce qu'il faut pour défaire** (`decantedVolume`) au moment du `execute()`, pas avant.

Solution pour obtenir 4 L avec 3 L et 5 L : remplir 5, transvaser 5→3, vider 3, transvaser 5→3, remplir 5, transvaser 5→3 (le bidon de 5 L contient 4 L).

## Pièges d'examen

- L'`Invoker` ne connaît que `Command`, jamais `FillCommand` ni `Can`.
- Annuler plusieurs fois = dépiler (dernier exécuté = premier annulé).
- Ne pas confondre avec Observateur : la Commande encapsule une **action**, l'Observateur une **notification**.

## Arborescence

Les sous-packages reprennent ceux du .jar du corrigé ; `Main` (à la racine du package) lance la démonstration.

```
commande/
├── water/
│   ├── command/
│   │   ├── AbstractCommand.java
│   │   ├── Command.java
│   │   ├── DecantCommand.java
│   │   ├── EmptyCommand.java
│   │   └── FillCommand.java
│   ├── Can.java
│   ├── Invoker.java
│   └── Simulator.java
└── Main.java
```

## Lancer

Depuis la racine du dépôt (PowerShell) :

```powershell
javac -encoding UTF-8 -d out (Get-ChildItem -Recurse src/commande -Filter *.java).FullName
java -cp out commande.Main [interactif]
```

Ou directement dans IntelliJ : clic droit sur `commande/Main.java` > Run.

L'argument `interactif` lance le `Simulator` au clavier (1 remplir, 2 vider, 3 transvaser, 4 annuler, 5 quitter).
