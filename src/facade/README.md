# Façade (TD1)

## Intention

Fournir une **interface unifiée et de plus haut niveau** à un ensemble d'interfaces d'un sous-système (un groupe de classes), afin de le rendre **plus facile à utiliser**.

Famille : **structure**.

## UML global (cours)

```
+--------+      +----------+      +---------+
| Client |----->|  Facade  |----->| ClasseA |
+--------+      +----------+  |   +---------+
                | + op()   |  |   +---------+
                +----------+  +-->| ClasseB |
                              |   +---------+
                              |   +---------+
                              +-->| ClasseC |
                                  +---------+
```

A retenir : le client ne connaît plus les classes du sous-système. Pas d'interface commune. La façade **n'ajoute pas de fonctionnalité**, elle simplifie.

## UML de l'exercice (système de sécurité)

```
 +-------------------+                +-------------------------------+
 | ClientUsingFacade |--------------->|        SecurityFacade         |
 +-------------------+                +-------------------------------+
                                      | - sensors  : List<Sensor>     |
 +----------------------+             | - alarms   : List<Alarm>      |
 | ClientNotUsingFacade |             | - cameras  : List<Camera>     |   (sans façade, le client
 +----------------------+             | - lights   : List<Light>      |    manipule directement
   (manipule directement)             +-------------------------------+    les 4 classes ci-dessous)
                                      | + SecurityFacade(nbSensors,   |
                                      |     nbAlarms, nbCameras,      |
                                      |     nbLights)                 |
                                      | + activate()                  |
                                      | + deactivate()                |
                                      +--------+------+------+--------+
                                               |      |      |      |
                                               v      v      v      v
                                          +--------+ +-------+ +--------+ +-------+
                                          | Sensor | | Alarm | | Camera | | Light |
                                          +--------+ +-------+ +--------+ +-------+
                                          |activate| |activate| |turnOn | |turnOn |
                                          |deactiv.| |deactiv.| |turnOff| |turnOff|
                                          |trigger | |ring    | |rotate | |blink  |
                                          +--------+ |stopRing| +--------+ +-------+
                                                     +-------+

 activate()   : sensors.activate(), alarms.activate(), cameras.turnOn()+rotate(), lights.turnOff()
 deactivate() : sensors.deactivate(), alarms.stopRing(), cameras.turnOff()
```

## Question de cours : `JOptionPane` est une façade

`JOptionPane.showMessageDialog(...)` cache la création d'un `JDialog`, d'un `JPanel`, des boutons, des icônes, du layout et de la boucle modale : une seule méthode statique remplace tout ce sous-système Swing.

## Pièges d'examen

- Façade vs Adaptateur : la façade **simplifie** plusieurs classes ; l'adaptateur rend **une** classe compatible avec une interface attendue.
- Le sous-système reste accessible directement (la façade n'est pas obligatoire).

## Lancer

Depuis la racine du dépôt (PowerShell) :

```powershell
javac -encoding UTF-8 -d out (Get-ChildItem -Recurse src/facade -Filter *.java).FullName
java -cp out facade.Main
```

Ou directement dans IntelliJ : clic droit sur `facade/Main.java` > Run.
