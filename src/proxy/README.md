# Procuration / Proxy (TD2)

## Intention

Fournir un **substitut** (le proxy) à un autre objet afin d'en **contrôler les accès** (les opérations qui lui sont appliquées). Le proxy a **la même interface** que l'objet contrôlé.

Famille : **structure**.

Types de proxy : **distant** (représentant local d'un objet sur un serveur), **virtuel** (création coûteuse retardée), **de protection** (contrôle des droits), **intelligent** (compteur, facture, journal...).

## UML global (cours)

```
+--------+     +------------------+
| Client |---->|  «interface»     |
+--------+     |  Subject         |
               +------------------+
               | + request()      |
               +------------------+
                  ^            ^
                  |            |
        +--------------+   +--------------+
        | RealSubject  |<--|    Proxy     |
        +--------------+   +--------------+
        | + request()  |   | + request()  |
        +--------------+   +--------------+

Proxy.request() : contrôle, puis realSubject.request()
```

## UML de l'exercice (fournisseur de 4 services)

```
                         +-----------------------+
 +------------+          |      «interface»      |
 |  Main.run  |--------->|       Provider        |
 +------------+          +-----------------------+
                         | + service1()          |
                         | + service2()          |
                         | + service3()          |
                         | + service4()          |
                         +-----------------------+
                           ^         ^          ^
                           |         |          |
              +------------+   +-----+------+  +-+----------------------+
              |RealProvider|   |InvoiceProxy|  |    ProtectionProxy     |
              +------------+   +------------+  +------------------------+
              | service1..4|   | - nbUses[] |  | - password : String    |
              +------------+   | - costs[]  |  | - sc : Scanner {static}|
                      ^        +------------+  +------------------------+
                      |        | service1..4|  | service1(), service2()  : délègue
                      |        | totalCost()|  | service3(), service4()  : demande le mdp
                      |        +-----+------+  +-----------+------------+
                      |              |                     |
                      +--------------+---------------------+
                             provider : Provider (délégation)

 InvoiceProxy.serviceN()    : provider.serviceN(); nbUses[N-1]++
 InvoiceProxy.totalCost()   : somme(nbUses[i] * costs[i])        costs = {11, 20, 22, 17}
 ProtectionProxy.service3() : si authorizedAccess() alors provider.service3() sinon "non autorisé"
```

Les proxys sont **chaînables** car ils implémentent tous `Provider` :
`new ProtectionProxy(new InvoiceProxy(), "0000")` (le 3e scénario de `Main`).

Types : `InvoiceProxy` = proxy **intelligent** ; `ProtectionProxy` = proxy **de protection**.

## Pièges d'examen

- Proxy et RealSubject implémentent le **même** `Subject` ; le Proxy a une **référence** vers le RealSubject.
- Proxy vs Décorateur : même structure, intention différente (contrôle d'accès vs ajout de comportement).
- Proxy distant : représentant **local** d'un objet stocké sur un serveur, accès comme s'il était local.

## Arborescence

Les sous-packages reprennent ceux du .jar du corrigé ; `Main` (à la racine du package) lance la démonstration.

```
proxy/
├── provider/
│   ├── Provider.java
│   └── RealProvider.java
├── proxy/
│   ├── InvoiceProxy.java
│   └── ProtectionProxy.java
└── Main.java
```

## Lancer

Depuis la racine du dépôt (PowerShell) :

```powershell
javac -encoding UTF-8 -d out (Get-ChildItem -Recurse src/proxy -Filter *.java).FullName
java -cp out proxy.Main
```

Ou directement dans IntelliJ : clic droit sur `proxy/Main.java` > Run.

Le `ProtectionProxy` lit le mot de passe sur l'entrée standard. Pour tester sans clavier :

```powershell
"1234`n1234`n0000`n0000" | java -cp out proxy.Main
```
