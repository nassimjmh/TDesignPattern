# Observateur / Observer (TD5, fleurs)

## Intention

Définir une **interdépendance de type un-à-plusieurs** : quand un objet change d'état, tous ceux qui en dépendent sont **notifiés et mis à jour automatiquement**.

Famille : **comportement**.

## UML global (cours)

```
 +------------------------+   observers   +----------------------+
 |  Subject (Observable)  |<>------------>|  «interface»         |
 +------------------------+     0..*      |  Observer            |
 | + attach(o : Observer) |               +----------------------+
 | + detach(o : Observer) |               | + update()           |
 | + notify()             |               +----------------------+
 +------------------------+                        ^
          ^                                        |
 +------------------------+  subject    +----------------------+
 |    ConcreteSubject     |<------------|   ConcreteObserver   |
 +------------------------+             +----------------------+
 | - state                |             | + update()           |
 | + getState()           |             +----------------------+
 +------------------------+

 notify()  : pour chaque o dans observers : o.update()
 update()  : lit subject.getState()
```

## UML de l'exercice (TD5, fleurs : `java.beans`)

Chaînes de notification : `SeasonCycle` -> `Flower` -> `PollinatingAnimal`. `Flower` est à la fois **observeur** du cycle et **observable** pour les pollinisateurs.

```
 +--------------------------------------+
 |  SeasonCycle  (Observable)           |
 +--------------------------------------+     «enumeration» Season
 | - season : Season                    |     PRINTEMPS, ETE, AUTOMNE, HIVER
 | - pcs : PropertyChangeSupport        |
 +--------------------------------------+
 | + next()   (firePropertyChange)      |
 | + addPropertyChangeListener(l)       |
 +--------------------<>----------------+
                      | listeners 0..*
                      v
 +---------------------------------------------+   implémente   +--------------------------+
 |  Flower                                     |--------------->| «interface»              |
 |  (Observeur de SeasonCycle,                 |                | PropertyChangeListener   |
 |   Observable pour les pollinisateurs)       |                | + propertyChange(evt)    |
 +---------------------------------------------+                +--------------------------+
 | - season : Season (floraison)               |                          ^
 | - isBlooming : boolean                      |                          |
 | - pcs : PropertyChangeSupport               |            +---------------------------------+
 +---------------------------------------------+            | «abstract» PollinatingAnimal    |
 | + propertyChange(evt) : si saison == la      |            +---------------------------------+
 |     sienne alors bloom()                    |            | + gatherPollen(f : Flower) {abs}|
 | + bloom() : isBlooming = true; fire(...)    |            | + propertyChange(evt)           |
 +--------------------<>-----------------------+            +---------------------------------+
                      | listeners 0..*                           ^                ^
                      +----------------------------------------->|                |
                                                                Bee           HummingBird

 SeasonCycle.next()                : season suivante; firePropertyChange("season", old, new)
 Flower.propertyChange(evt)        : si evt.newValue == season && !isBlooming : bloom()
 Flower.bloom()                    : isBlooming = true; firePropertyChange("isBlooming", false, true)
 PollinatingAnimal.propertyChange  : si fleur ouverte : gatherPollen(fleur)
```

Usage : `cycle.addPropertyChangeListener(f); f.addPropertyChangeListener(abeille); cycle.next();`

## Pièges d'examen

- La liste des observeurs est dans l'**Observable**, pas l'inverse ; `notifier()` est appelé à **chaque changement d'état**.
- Une classe peut avoir les deux rôles (`Flower`) : chaîne de notifications.
- `java.util.Observable` / `Observer` sont **dépréciés** : utiliser `PropertyChangeSupport` (composition) + `PropertyChangeListener`.
- `firePropertyChange` ne notifie **pas** si ancienne valeur == nouvelle valeur.

## Lancer

Depuis la racine du dépôt (PowerShell) :

```powershell
javac -encoding UTF-8 -d out (Get-ChildItem -Recurse src/observateur -Filter *.java).FullName
java -cp out observateur.Main
```

Ou directement dans IntelliJ : clic droit sur `observateur/Main.java` > Run.
