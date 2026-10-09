---
tags: ["typ/thema", "thema/maven", "kategorie/werkzeuge", "semester/2"]
aliases: ["Maven", "Folien 32"]
semester: 2
kategorie: "Werkzeuge"
folien: "[[Material/Folien/32_Maven.pdf]]"
seiten: 30
---

# 32 Maven

← [[31 JUnit-Tests]] · [[Start|🏠 Start]] · [[33 Java 8 – Lambdas, Streams, NIO.2]] →

> [!abstract] Worum geht's?
> Build- und Abhängigkeitsmanagement mit Apache Maven: Lebenszyklus, Projektstruktur, pom.xml, Dependencies, Plugins und Projekterstellung in den IDEs.

**Semester:** Programmieren II · **Bereich:** #kategorie/werkzeuge · **Folien:** [[Material/Folien/32_Maven.pdf|32_Maven.pdf]] (30 Seiten)

## Gliederung der Folien
- [[Material/Folien/32_Maven.pdf#page=2|S. 2]] Agenda
- [[Material/Folien/32_Maven.pdf#page=3|S. 3]] Was ist Apache Maven?
- [[Material/Folien/32_Maven.pdf#page=4|S. 4]] Entstehung
- [[Material/Folien/32_Maven.pdf#page=5|S. 5]] Vereinfachung und Vereinheitlichung des
- [[Material/Folien/32_Maven.pdf#page=6|S. 6]] Bereitstellung von Projektinformationen
- [[Material/Folien/32_Maven.pdf#page=7|S. 7]] Förderung von „Best Practices“
- [[Material/Folien/32_Maven.pdf#page=8|S. 8]] Transparentes Einbinden zusätzlicher Features
- [[Material/Folien/32_Maven.pdf#page=9|S. 9]] Abhängigkeitsverwaltung
- [[Material/Folien/32_Maven.pdf#page=10|S. 10]] Abhängigkeitsverwaltung II
- [[Material/Folien/32_Maven.pdf#page=11|S. 11]] Lebenszyklus eines Maven Projekts
- [[Material/Folien/32_Maven.pdf#page=12|S. 12]] Lebenszyklus eines Maven Projekts II
- [[Material/Folien/32_Maven.pdf#page=13|S. 13]] Voraussetzungen
- [[Material/Folien/32_Maven.pdf#page=14|S. 14]] Projektstruktur
- [[Material/Folien/32_Maven.pdf#page=15|S. 15]] Project Object Model – pom.xml
- [[Material/Folien/32_Maven.pdf#page=16|S. 16]] Project Object Model – pom.xml II
- [[Material/Folien/32_Maven.pdf#page=17|S. 17]] pom.xml Abhängigkeitsverwaltung
- [[Material/Folien/32_Maven.pdf#page=18|S. 18]] pom.xml Abhängigkeitsverwaltung II
- [[Material/Folien/32_Maven.pdf#page=19|S. 19]] pom.xml Abhängigkeitsverwaltung III
- [[Material/Folien/32_Maven.pdf#page=20|S. 20]] Maven Plugins
- [[Material/Folien/32_Maven.pdf#page=23|S. 23]] Maven-Projekt erstellen
- [[Material/Folien/32_Maven.pdf#page=24|S. 24]] Maven-Projekt erstellen: Eclipse
- [[Material/Folien/32_Maven.pdf#page=25|S. 25]] Maven-Projekt erstellen: Eclipse II
- [[Material/Folien/32_Maven.pdf#page=26|S. 26]] Maven-Projekt erstellen: IntelliJ
- [[Material/Folien/32_Maven.pdf#page=27|S. 27]] Maven-Projekt erstellen: IntelliJ II
- [[Material/Folien/32_Maven.pdf#page=28|S. 28]] Maven-Projekt erstellen: NetBeans
- [[Material/Folien/32_Maven.pdf#page=29|S. 29]] Maven-Projekt erstellen: NetBeans II
- [[Material/Folien/32_Maven.pdf#page=30|S. 30]] Aufgabe – Erstes Maven-Projekt

## Begriffe in diesem Kapitel
- [[Maven]] (S. [[Material/Folien/32_Maven.pdf#page=3|3]], [[Material/Folien/32_Maven.pdf#page=11|11]], [[Material/Folien/32_Maven.pdf#page=12|12]], [[Material/Folien/32_Maven.pdf#page=15|15]], [[Material/Folien/32_Maven.pdf#page=16|16]], [[Material/Folien/32_Maven.pdf#page=17|17]])

## Verwandte Themen
[[31 JUnit-Tests]] · [[30 JSON mit GSON]] · [[02 Entwicklungsumgebungen Eclipse und IntelliJ]]

## Folien ansehen
![[Material/Folien/32_Maven.pdf]]

## Folientext (durchsuchbar)
> [!quote]- Kompletter Folientext – aufklappen
> ```text
> ── Seite 1 ──
> Programmieren II
> Apache Maven
> 
> Institut für Automation und angewandte Informatik
> 
> KIT – Die Forschungsuniversität in der Helmholtz-Gemeinschaft www.kit.edu
> 
> ── Seite 2 ──
> Agenda
> 
>    Einführung in Apache Maven
>    Was ist Apache Maven?
>    Verwendung
>    Einbindung in IDE
> 
>    APACHE
> 2 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 3 ──
> Was ist Apache Maven?
> 
>    „Maven ist ein Build-Management-Tool der Apache Software
>    Foundation und basiert auf Java. Mit ihm kann man insbesondere
>    Java-Programme standardisiert erstellen und verwalten.“
>    (Quelle: https://de.wikipedia.org/wiki/Apache_Maven)
> 
>    Kommandozeilen-basiertes Tool
> 
>    Ziele
>    Vereinfachung und Vereinheitlichung des Build-Prozesses
>    Bereitstellung von Projektinformationen
>    Förderung von „Best Practices“
>    Transparentes Einbinden zusätzlicher Features mittels Plugins
> 
> 3 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 4 ──
> Entstehung
> 
>    2003   Version 1   Maven 1
>    2004   Relativ hektische Umsetzung,
>    2005   Version 2
>    daher einige Schwächen
> 
>    2006
> 
>    2007   Maven 2
>    2008
>    Konzept komplett überarbeitet
>    Fehler von Maven 1 korrigiert
>    2009
>    Inkompatibel zu Maven 1
>    2010   Version 3
> 
>    2011
>    Maven 3
>    2012
>    Kompatibel zu Maven 2
>    2013
>    Ziel war Verbesserung der
>    2014   Support-Ende   Benutzbarkeit und Stabilität
>    Version 1 & 2
> 
> 4 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 5 ──
> Vereinfachung und Vereinheitlichung des
>    Build-Prozesses
> 
>    Die Details verschiedener Build-Mechanismen werden
>    über vereinfachte Wrapper bereitgestellt
>    Struktur der Wrapper meist ähnlich, trotz sehr unterschiedlicher
>    Tools die darunter angesprochen werden
> 
>    Projektbeschreibung mittels “Project Object Model” (POM)
>    Beschreibung der Abhängigkeiten
>    Maven-Projekte “funktionieren” alle gleich
>    Zusatzfunktionalität wird über Plugins standardisiert eingebunden
> 
> 5 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 6 ──
> Bereitstellung von Projektinformationen
> 
>    Standardisierte Informationen über Projekt
>    Grobe Zugehörigkeit zu Projektgruppe („groupId“)
>    Konkretes Projekt innerhalb der Gruppe („artifactId“)
>    Versionsnummer (inkl. Markierung von Entwicklungsversionen)
>    Optional möglich
>    Ausführlicher Name des Projekts
>    Beschreibungstext für das Projekt
>    Klare Definition verwendeter Software durch zentral
>    verwaltete Abhängigkeiten
>    Direkte Einbindung von SCM-Systemen (Git, SVN, ..)
>    vorgesehen
>    Möglichkeit zur automatischen Generierung von Test-
>    Reports
> 6 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 7 ──
> Förderung von „Best Practices“
> 
>    Standardisierte Projektstruktur („Ordner-Struktur“)
>    Nicht mehr abhängig von der jeweiligen IDE
> 
>    Best Practices werden gefördert, jedoch nicht erzwungen
> 
>    Beispiel: Unit-Tests
>    Tests sind zentraler Bestandteil des Maven-Entwicklungszyklus‘
>    Test-Klassen werden in separatem, parallel zu den „normalen“
>    Klassen liegenden Quellcode-Baum erwartet
>    Namenskonventionen müssen eingehalten werden, damit Tests
>    gefunden werden
>    Keine Custom-Umgebung für Tests
>    Test-Klassen müssen Test-Umgebung selbst initialisieren
> 
> 7 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 8 ──
> Transparentes Einbinden zusätzlicher Features
> 
>    Einfach gehaltenes Plugin-System für Erweiterung der
>    Funktionalität
> 
>    Sauber geschriebene Maven-Plugins funktionieren für alle
>    Software-Projekte
>    „Früher“: geskriptete Sonderlösungen meist für konkretes Projekt
> 
>    Plugin-Update kann Verbesserungen für alle
>    verwendenden Projekte bereitstellen
> 
> 8 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 9 ──
> Abhängigkeitsverwaltung
> 
>    Wenn Software-Abhängigkeiten automatisch verwaltet
>    werden, müssen diese „irgendwo“ verfügbar sein
> 
>    Maven verwendet hierfür Repositories
> 
>    Es gibt 2 Arten von Repositories
>    Lokal: Ordner auf dem Rechner mit dem Maven-Projekt. Verwaltet
>    eigene Projekt-Artefakte und cachet verwendete Drittsoftware
>    Remote: Server, der bestimmten „Katalog“ von Software bereitstellt,
>    die in Maven-Projekten genutzt werden kann
> 
> 9 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 10 ──
> Abhängigkeitsverwaltung II
> 
>    Abhängigkeiten werden beschrieben, nicht
>    heruntergeladen und in das Projekt kopiert
>    Bibliotheken liegen nicht mehr in „Binär“-Form innerhalb des
>    Software-Projekts
>    Das Projekt kann vollständig in ein Versionskontrollsystem
>    geladen werden, ohne Fremd-Software dort mitzuverwalten
> 
> 10 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 11 ──
> Lebenszyklus eines Maven Projekts
> 
>    Maven bildet einzelne Schritte des Projekts in einem
>    Lebenszyklus ab
> 
>    Häufig ausreichend: Standard-Lebenszyklus
>    Nicht jedes Software-Projekt muss jede der Phasen durchlaufen
> 
>    Phase   Beschreibung
>    archetype   Erstellung des Software-Projekts, ggf. auf Basis eines
>    zuvor definierten Templates
>    validate   Überprüfung der Projektstruktur auf Gültigkeit und
>    Vollständigkeit
>    compile   Übersetzung des Quellcodes (z.B. .java  .class)
> 
> 11 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 12 ──
> Lebenszyklus eines Maven Projekts II
> 
>    Phase   Beschreibung
>    test   Ausführung der Unit-Tests aus dem parallelen Quellcode-
>    Baum mit passendem Test-Framework (z.B. JUnit)
>    package   Die übersetzten Dateien werden zum fertigen „Produkt“
>    verpackt, bspw. ein JAR-Archiv. Hier werden ggf. auch
>    Dateien eingefügt die nicht kompilierbar sind (Bilder,
>    XML-Dateien, …)
>    integration-test   Fertiges Produkt kann in eine andere Umgebung
>    übertragen werden und dort mit anderen Komponenten
>    integriert getestet werden
>    verify   Überprüfung der Struktur des erzeugten Softwarepakets,
>    ggf. Überprüfung von Qualitätskriterien
>    install   Installation im lokalen Maven-Repository
>    deploy   Installation in einem entfernten Maven-Repository
> 
> 12 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 13 ──
> Voraussetzungen
> 
>    Maven basiert auf Java und soll Software erzeugen
>     installiertes JDK nötig
>     Umgebungsvariable $JAVA_HOME muss gesetzt sein
> 
>    Variante 1: Maven herunterladen und installieren
>    Download von http://maven.apache.org
>    Installation besteht aus Entpacken & Anpassen der
>    Umgebungsvariable $PATH
> 
>    Variante 2: IDE-Integration
>    m2e-Plugin für Eclipse (in neueren Eclipse-Versionen bereits enthalten)
>    NetBeans & IntelliJ bringen ebenfalls bereits Plugins mit
> 
> 13 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 14 ──
> Projektstruktur
> 
>    my-maven-project
> 
>    src
> 
>    main
> 
>    java   Java-Packages & -Klassen
> 
>    resources   Nicht übersetzbare Dateien (Bilder, …)
> 
>    test
> 
>    java   Java-Packages & -Klassen für Unit-Tests
> 
>    resources   Nicht übersetzbare Dateien (Bilder, …)
>    für Unit-Tests
>    target
> 
>    classes   Erzeugte, kompilierte Dateien (.class)
> 
>    pom.xml   „Project Object Model“-Konfigurationsdatei
> 
> 14 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 15 ──
> Project Object Model – pom.xml
> 
>    Zentrale Konfigurationsdatei für Maven-Projekt
> 
>    Definiert und instrumentiert zuvor genannte Funktionen
>    Projektinformationen
>    Abhängigkeiten zu anderen Software-Bibliotheken
>    Verwendung und Konfiguration zusätzlicher Plugins
>    Angabe von Repositories
> 
>    pom.xml-Datei wird auf Wohlgeformtheit und Gültigkeit zu
>    Beginn jedes Maven-Aufrufs geprüft
> 
> 15 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 16 ──
> Project Object Model – pom.xml II
> 
>    Standard-Konfigurationsdatei
> <project xmlns="http://maven.apache.org/POM/4.0.0"
>    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
>    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
>    http://maven.apache.org/xsd/maven-4.0.0.xsd">
> 
>    <modelVersion>4.0.0</modelVersion>
>    Gruppenzugehörigkeit, meist
>    <groupId>de.dhbwka.java.exercise</groupId>   Java-Package
> 
>    <artifactId>my-maven-project</artifactId>   Projekt-Identifier
> 
>    <version>0.0.1-SNAPSHOT</version>   Aktuelle Versionsnummer
> 
>    <name>Maven Demo Project</name>   Name des Projekts
> 
>    Typ des resultierenden
>    <packaging>jar</packaging>
>    Software-Artefakts
> </project>
> 
> 16 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 17 ──
> pom.xml Abhängigkeitsverwaltung
> 
>    Abhängigkeiten („Dependencies“) verwalten
>    Google GSON via Maven einbinden
>    <project xmlns="..." xmlns:xsi="..." xsi:schemaLocation="...">
> 
>    (…)
> 
>    <dependencies>
>    <dependency>
>    <groupId>com.google.code.gson</groupId>
>    <artifactId>gson</artifactId>
>    <version>2.11.0</version>
>    </dependency>
>    </dependencies>
> 
>    (…)
> 
>    </project>
> 
> 17 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 18 ──
> pom.xml Abhängigkeitsverwaltung II
> 
>    Gibt es ein Verzeichnis verfügbarer Bibliotheken?
>    Bibliotheken aus Standard-Repository immer verfügbar
>    Fremd-Repositories einbindbar
> 
>    Übersicht über Standard-Repository
>    http://search.maven.org/
>    Standard-Suchmaschine
>    für zentrales Maven-Repo
> 
>    http://mvnrepository.com/
>    Alternative Suchmaschine
>    für zentrales Maven-Repo
> 
> 18 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 19 ──
> pom.xml Abhängigkeitsverwaltung III
> 
>    <project xmlns="..." xmlns:xsi="..." xsi:schemaLocation="...">
> 
>    (…)
> 
>    <dependencies>
>    <dependency>
>    <groupId>com.google.code.gson</groupId>
>    <artifactId>gson</artifactId>
>    <version>2.11.0</version>
>    </dependency>
>    </dependencies>
> 
>    (…)
> 
>    </project>
> 
> 19 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 20 ──
> Maven Plugins
> 
>    Maven bringt eine Reihe von plugins mit, die über die
>    Kommandozeile genutzt werden können
>    Beispiele:
>    mvn clean: Löscht die unter target bereits gespeicherten
>    compilierten .class-Dateien
>    mvn compiler: Compiliert Quellcodedateien
>    Darüber hinaus besitzt jedes plugin sogenannte "goals",
>    welche die konkrete Funktionalität referenzieren
>    Diese können über das plugin mit einem Doppelpunkt
>    angesprochen werden
>    Beispiel: mvn compiler:compile  Startet den Compilierprozess
> 
> 20 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 21 ──
> Maven Plugins (2)
> 
>    Häufig genutzte goals wie compile besitzen meist shortcuts
>    mvn compiler:compile  mvn compile
>    mvn clean:clean  mvn clean
>    Plugins können über Einträge in der pom.xml konfiguriert
>    werden
>    <build>
>    <plugins>
>    <plugin>
>    <groupId>org.apache.maven.plugins</groupId>
>    <artifactId>maven-compiler-plugin</artifactId>
>    <configuration>
>    (…)
>    </configuration>
>    </plugin>
>    </plugins>
>    </build>
> 
> 21 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 22 ──
> Maven Plugins (3)
> 
>    Beispiel-Konfiguration für das maven-compiler-plugin
>    <configuration>
>    <release>25</release>
>    </configuration>
> 
>    Konfiguration kann aber auch über Kommandozeilenbefehl
>    vorgenommen werden
>    mvn clean compile -Dmaven.compiler.release=25
>    manche Konfigurationen werden nicht über
>    Kommandozeilenparameter unterstützt
> 
> 22 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 23 ──
> Maven-Projekt erstellen
> 
>    Grundsätzlich: Maven ist ein Kommandozeilenwerkzeug
>    Projekt kann über Kommandozeile erstellt werden
>    Breite, UI-unterstützte Integration in IDEs
> 
>    Neue Projekte können basierend auf Projektschablonen
>    („Archetypes“) erstellt werden
>    Wir nutzen zunächst eine „nackte“ Schablone
> 
> 23 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 24 ──
> Maven-Projekt erstellen: Eclipse
> 
> 24 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 25 ──
> Maven-Projekt erstellen: Eclipse II
> 
>    Projektgruppe
>    Projekt-ID
> 
> 25 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 26 ──
> Maven-Projekt erstellen: IntelliJ
> 
> 26 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 27 ──
> Maven-Projekt erstellen: IntelliJ II
> 
>    IntelliJ-Projektname
> 
>    kann identisch
>    Projektgruppe   sein, muss nicht
> 
>    Maven-Projekt-ID
> 
> 27 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 28 ──
> Maven-Projekt erstellen: NetBeans
> 
> 28 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 29 ──
> Maven-Projekt erstellen: NetBeans II
> 
>    Projekt-ID
> 
>    Projektgruppe
> 
> 29 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 30 ──
> Aufgabe – Erstes Maven-Projekt
> 
>    Erstellen Sie ein Maven-Projekt
>    Abhängigkeit zu Google GSON
>    https://mvnrepository.com/artifact/com.google.code.gson/gson
>    Konfigurieren der Java-Version auf Java 21 (oder höher) über das
>    maven-compiler-plugin
>    Encoding auf UTF-8 für das maven-compiler-plugin einstellen
> 
> 30 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> ```
