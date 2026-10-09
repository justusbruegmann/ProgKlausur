---
tags: ["typ/thema", "thema/java-allgemein", "kategorie/grundlagen", "semester/1"]
aliases: ["Die Programmiersprache Java", "Folien 01"]
semester: 1
kategorie: "Grundlagen"
folien: "[[Material/Folien/01_Java_Allgemein.pdf]]"
seiten: 21
---

# 01 Die Programmiersprache Java

← [[00 Überblick Programmieren I]] · [[Start|🏠 Start]] · [[02 Entwicklungsumgebungen Eclipse und IntelliJ]] →

> [!abstract] Worum geht's?
> Einordnung von Java unter den Programmiersprachen, Eigenschaften der Sprache, das JDK mit Compiler (javac) und JVM, Aufbau einer Java-Anwendung und der Weg vom Quellcode über Bytecode zur Ausführung.

**Semester:** Programmieren I · **Bereich:** #kategorie/grundlagen · **Folien:** [[Material/Folien/01_Java_Allgemein.pdf|01_Java_Allgemein.pdf]] (21 Seiten)

## Gliederung der Folien
- [[Material/Folien/01_Java_Allgemein.pdf#page=2|S. 2]] Programmiersprachen, Übersicht
- [[Material/Folien/01_Java_Allgemein.pdf#page=3|S. 3]] Programmiersprachen, Entwicklung
- [[Material/Folien/01_Java_Allgemein.pdf#page=4|S. 4]] Eigenschaften von Java
- [[Material/Folien/01_Java_Allgemein.pdf#page=5|S. 5]] Das Java Development Kit (JDK)
- [[Material/Folien/01_Java_Allgemein.pdf#page=7|S. 7]] Einsatzgebiete des JDK
- [[Material/Folien/01_Java_Allgemein.pdf#page=8|S. 8]] Sprachkonzepte von Java
- [[Material/Folien/01_Java_Allgemein.pdf#page=9|S. 9]] Java-Programme
- [[Material/Folien/01_Java_Allgemein.pdf#page=10|S. 10]] Aufbau einer Anwendung
- [[Material/Folien/01_Java_Allgemein.pdf#page=11|S. 11]] Erstellung und Ausführung
- [[Material/Folien/01_Java_Allgemein.pdf#page=12|S. 12]] Programmentwicklung in Java – allg. Vorgehen
- [[Material/Folien/01_Java_Allgemein.pdf#page=13|S. 13]] Programmentwicklung in Java – Beispiel: Aufgabe
- [[Material/Folien/01_Java_Allgemein.pdf#page=14|S. 14]] Programmentwicklung in Java – Quellcode
- [[Material/Folien/01_Java_Allgemein.pdf#page=15|S. 15]] Programmentwicklung in Java – Übersetzen/Ausführen
- [[Material/Folien/01_Java_Allgemein.pdf#page=16|S. 16]] Programmentwicklung in Java – Systemvorbereitungen
- [[Material/Folien/01_Java_Allgemein.pdf#page=17|S. 17]] Muss man das alles von Hand machen?
- [[Material/Folien/01_Java_Allgemein.pdf#page=18|S. 18]] Java-Entwicklungsumgebungen

## Begriffe in diesem Kapitel
- [[JDK und JVM]] (S. [[Material/Folien/01_Java_Allgemein.pdf#page=5|5]], [[Material/Folien/01_Java_Allgemein.pdf#page=6|6]], [[Material/Folien/01_Java_Allgemein.pdf#page=7|7]], [[Material/Folien/01_Java_Allgemein.pdf#page=11|11]], [[Material/Folien/01_Java_Allgemein.pdf#page=12|12]], [[Material/Folien/01_Java_Allgemein.pdf#page=15|15]])
- [[IDE]] (S. [[Material/Folien/01_Java_Allgemein.pdf#page=19|19]], [[Material/Folien/01_Java_Allgemein.pdf#page=20|20]])
- [[main-Methode]] (S. [[Material/Folien/01_Java_Allgemein.pdf#page=9|9]], [[Material/Folien/01_Java_Allgemein.pdf#page=10|10]], [[Material/Folien/01_Java_Allgemein.pdf#page=14|14]])

## Verwandte Themen
[[02 Entwicklungsumgebungen Eclipse und IntelliJ]] · [[03 Java Packages]] · [[04 Primitive Datentypen]]

## Folien ansehen
![[Material/Folien/01_Java_Allgemein.pdf]]

## Folientext (durchsuchbar)
> [!quote]- Kompletter Folientext – aufklappen
> ```text
> ── Seite 1 ──
> Programmieren I
> Die Programmiersprache Java
> 
> Institut für Automation und angewandte Informatik
> 
> KIT – Die Forschungsuniversität in der Helmholtz-Gemeinschaft www.kit.edu
> 
> ── Seite 2 ──
> Programmiersprachen, Übersicht
> 
>    Quelle: https://redmonk.com/sogrady/2025/06/18/language-rankings-1-25/
> 2 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 3 ──
> Programmiersprachen, Entwicklung
> 
>    Quelle:
>    http://www.ilsb.tuwien.ac.at/~pahr/317.530/
> 
> 3 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 4 ──
> Eigenschaften von Java
> 
>    Java ist eine von der Firma Sun Microsystems (mittlerweile
>    aufgegangen in Oracle) entwickelte objektorientierte
>    Programmiersprache.
>    Heusch 2.2
>    Java is...   Ratz 1.1
> 
>    „...a simple, object-oriented, distributed, interpreted, robust, secure,
>    architectural neutral, portable, high-performance, multithreaded, and
>    dynamic language.“
>    (Sun Microsystems)
>    Plattformunabhängigkeit – „Write Once, Run Anywhere“
>    Java enthält standardmäßig eine große Anzahl von Bibliotheken, z.B.
>    zur Grafikprogrammierung, zum Netzwerkzugriff oder zur Arbeit mit
>    Dateien und Datenbanken.
>    Java ist frei verfügbar. Außerdem stehen auch zahlreiche kostenfreie
>    Entwicklungsumgebungen zur Verfügung.
> 
> 4 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 5 ──
> Das Java Development Kit (JDK) (1)
> 
>    Historie von Java
>    1991: Erste Anfänge bei Sun Microsystems, heute Oracle
>    1995: Vorstellung von Java auf der SUNWORLD '95
>    1997: Freigabe der Version Java 1.1
>    1998: Freigabe der Version Java 1.2 („Java 2“)
>    Derzeit aktuelle Version:
>    Java 25 (Long-Term Support)
> 
>    Bestandteile des Java Development-Kit (JDK)
>    Java Runtime Environment (JRE)
>    Tools
>    Bibliotheken (Java-Klassen)
>    Keine (!) grafische Entwicklungsumgebung
> 
> 5 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 6 ──
> Das Java Development Kit (JDK) (2)
> 
>    Tools
>    Java-Compiler javac
>    Java-Interpreter java zum Ausführen des vom Compiler erzeugten
>    Bytecodes
>    Weitere Programme, beispielsweise zur Erstellung von
>    Dokumentationen und zur Erzeugung so genannter JAR-Archive
> 
>    Bibliotheken (Java-API - Application Programming Interface)
>    Sammlung von Komponenten (Klassen), beispielsweise zur
>    Entwicklung von grafischen Anwendungen, oder von Anwendungen
>    mit Zugriff auf Dateien bzw. Ein- und Ausgabe über Tastatur und
>    Bildschirm etc.
>    Liste und Dokumentation unter http://www.oracle.com
> 
> 6 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 7 ──
> Einsatzgebiete des JDK
> 
>    Das JDK liegt für verschiedene Einsatzgebiete vor:
>    Java Platform, Standard Edition (J2SE, SE)
>    Die Standard Edition wird zur Entwicklung von Programmen für
>    Desktop-Computer eingesetzt.
>    Java Platform, Enterprise Edition (J2EE, EE)
>    Mit der Enterprise Edition werden zusätzliche Bibliotheken für
>    verteilte Anwendungen und Web-Services angeboten
>    Java Platform, Micro Edition (J2ME, ME)
>    Diese Edition ist für Anwendungen gedacht, die in kleinen Geräten
>    wie Telefonen, Handheldcomputern (PDA), Waschmaschinen etc.
>    betrieben werden können, da diese Geräte wenig Speicher und
>    geringe Rechenleistung besitzen.
> 
> 7 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 8 ──
> Sprachkonzepte von Java
> 
>    Angelehnt an C/C++, aber stark vereinfacht:
>    Kein Präprozessor
>    Keine Pointer
>    Keine eigenen/überladenen Operatoren, Mehrfachvererbung, …
> 
>    Bewährte Konzepte anderer Sprachen wurden integriert:
>    Exceptions: Fehlerbehandlung
>    Garbage Collection: Automatische Speicherfreigabe
>    Package-Konzept: Zusammenfassung von Klassen
>    Concurrency: Nebenläufigkeit
> 
> 8 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 9 ──
> Java-Programme
> 
>    Java-Applikationen (Anwendung, engl. Application)
>    kann direkt auf der Betriebssystemebene gestartet werden
>    besteht aus einer oder mehreren Klassen
>    muss eine main-Methode enthalten
>    wird mit Hilfe des Java-Interpreters gestartet und ausgeführt
>    werden meistens einfach als „Java-Programme“ bezeichnet
> 
>    Weitere spezialisierte Anwendungen
>    Servlet, Portlet, Web-Service, …
> 
>    Historisch / Veraltet
>    Applets für die Einbettung von Java-Programmen in Webseiten
> 
> 9 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 10 ──
> Aufbau einer Anwendung
>    Java-Programme bestehen   Klasse Programmname
>    aus Klassen. Diese beinhalten   ...
>    alle Informationen, die zur
>    Ausführung notwendig sind.   main-Methode
>    Klassen umfassen Attribute
>    ...
>    (Daten) und Methoden   Anweisungen
>    (Funktionalität). Methoden   ...
>    beinhalten die Anweisungen,
>    die ausgeführt werden sollen.
>    Die einfachste Java-   Klasse X
>    Anwendung besteht aus einer
>    Attribute
>    Klasse mit dem Namen der
>    Anwendung. Diese Klasse   Methoden
>    enthält das Hauptprogramm,
>    die main-Methode   Klasse Y
> 
>    Attribute
>    Methoden
> 
> 10 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 11 ──
> Erstellung und Ausführung
>    eines Java-Programms
>    Programm   Texteditor
>    schreiben
>    Programm   Java-Programm
>    mit Compiler
>    javac übersetzen
>    Bytecode mit   Java Compiler javac
>    Interpreter
>    Plattformunabhängiger
>    java ausführen
>    Bytecode
> 
>    Java Interpreter –   Java Interpreter –   Java Interpreter –
>    virtuelle Maschine   virtuelle Maschine   virtuelle Maschine
>    für Windows   für Linux   für MacOS X
>    Programm   Programm   Programm
>    unter Windows   unter Linux   unter MacOS X
>    ausführen   ausführen   ausführen
> 
> 11 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 12 ──
> Programmentwicklung in Java (1) – allg. Vorgehen
> 
>    Formulierung der Aufgabenstellung (Problem)
>    Entwurf eines Lösungsalgorithmus
>    Formulierung auf abstrakter Ebene
>    Beachten von Strukturregeln
>    Korrektheit des Lösungsalgorithmus prüfen
>    Effizienzuntersuchungen
>    Implementierung, d.h. Übertragung des
>    Lösungsalgorithmus in eine Programmiersprache.
>    Ergebnis ist ein Programm als Quellcode.
>    Übersetzen (engl.: to compile) des Programms in eine
>    maschinennahe Zwischensprache. Das geschieht mit Hilfe
>    des Compilers (javac). Das Ergebnis ist Bytecode.
>    Ausführen und Testen des Programms (java)
> 
> 12 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 13 ──
> Programmentwicklung in Java (2) – Beispiel: Aufgabe
> 
>    Formulierung der Aufgabenstellung:
>    „Berechne den Quotienten zweier Zahlen a, b (d.h. a/b),
>    falls b<>0. Sonst melde, dass b ein unzulässiger Wert ist.“
>    Entwurf eines Lösungsalgorithmus
>    Lies zwei Zahlen a und b ein
>    WENN b ungleich 0
>    DANN
>    quotient sei a / b
>    schreibe quotient
>    SONST
>    schreibe "b ist unzulaessig."
> 
>    ... Strukturregeln, Korrektheit, Effizienz.
> 
> 13 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 14 ──
> Programmentwicklung in Java (3) – Quellcode
> 
>    Implementierung (Speichern als Quotient.java):
>    class Quotient {
>    public static void main(String args[]) {
>    float a, b, quotient;
>    java.util.Scanner scan = new java.util.Scanner(System.in);
>    System.out.println("Enter a: ");
>    a = scan.nextFloat();
>    System.out.println("Enter b: ");
>    b = scan.nextFloat();
>    if (b != 0) {
>    quotient = a / b;
>    System.out.println("Quotient: " + quotient);
>    } else {
>    System.out.println(b + " for b is invalid.");
>    }
>    }
>    }
> 
> 14 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 15 ──
> Programmentwicklung in Java (4) – Übersetzen/Ausführen
> 
>    Übersetzen des Programms (mit Hilfe des JDK):
> 
>    > javac Quotient.java
>    (Erzeugt die Datei Quotient.class)
> 
>    Starten und Ausführen (Kommandozeile):
> 
>    > java Quotient
>    Enter a: 3
>    Enter b: 6
>    Quotient 0.5
>    > java Quotient
>    Enter a: 3
>    Enter b: 0   Groß-/Kleinschreibung
>    0.0 for b is invalid.   beachten!
> 
> 15 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 16 ──
> Programmentwicklung in Java (5) – Systemvorbereitungen
> 
>    Falls nicht vom JDK-Installer erledigt: JDK-Pfad in
>    Umgebungsvariable PATH aufnehmen, bspw. unter Win 11
>    im Startmenü nach „Umgebungsvariablen“ suchen:
> 
>    Terminal im Ordner starten
> 
> 16 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 17 ──
> Muss man das alles von Hand machen?
> 
> 17 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 18 ──
> Java-Entwicklungsumgebungen (1)
> 
>    bestehen (mindestens) aus
>    Source-Code-Editor
>    Übersetzer (Compiler)
>    Werkzeugen zum automatisierten Bau (Build) von Paketen
>    Werkzeugen zur Fehlersuche und -analyse (Debugger)
>    helfen beim Entwickeln von Java-Programmen
>    „Schablonen“ für Anwendungen
>    Ändern von Code (Refactoring)
>    Anzeigen von Fehlermeldungen, Debugging
>    Automatisches Vervollständigen von Code
>    Design von grafischen Oberflächen
>    Umsetzen von UML-Diagrammen in Code
>    und, und, und…
> 
> 18 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 19 ──
> Java-Entwicklungsumgebungen (2)
> 
>    …gibt es wie Sand am Meer
>    Eclipse (www.eclipse.org)
>    NetWeaver Developer Studio (SAP)
>    IntelliJ IDEA (www.jetbrains.com/idea/)
>    NetBeans (netbeans.apache.org)
>    VS Code (https://code.visualstudio.com/)
>    JCreator
>    JDeveloper (Oracle)
>    JBuilder
>    MS Visual Studio
>    …
> 
> 19 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 20 ──
> Java-Entwicklungsumgebungen (3)
> 
>    Wir empfehlen aktuelle Versionen von entweder
> 
>    Eclipse
>    oder
>    IntelliJ IDEA
>    oder
> 
>    Auswahl auf Basis von Erfahrung und/oder Einsatz im
>    Ausbildungsbetrieb
> 
> 20 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 21 ──
> Java-Entwicklungsumgebungen (4)
> 
> 21 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> ```
