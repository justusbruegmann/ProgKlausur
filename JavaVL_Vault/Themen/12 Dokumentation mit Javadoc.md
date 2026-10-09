---
tags: ["typ/thema", "thema/dokumentation", "kategorie/werkzeuge", "semester/1"]
aliases: ["Dokumentation mit Javadoc", "Folien 12"]
semester: 1
kategorie: "Werkzeuge"
folien: "[[Material/Folien/12_Dokumentation.pdf]]"
seiten: 27
---

# 12 Dokumentation mit Javadoc

← [[11 Methoden – Parameterübergabe und Rekursion]] · [[Start|🏠 Start]] · [[13 Vererbung]] →

> [!abstract] Worum geht's?
> Automatische Programmdokumentation mit javadoc: Kommentar-Typen, @-Tags, Erzeugen der Doku per Kommandozeile und IDE sowie Offline-Konfiguration der API-Doku.

**Semester:** Programmieren I · **Bereich:** #kategorie/werkzeuge · **Folien:** [[Material/Folien/12_Dokumentation.pdf|12_Dokumentation.pdf]] (27 Seiten)

## Gliederung der Folien
- [[Material/Folien/12_Dokumentation.pdf#page=2|S. 2]] Automatische Dokumentation
- [[Material/Folien/12_Dokumentation.pdf#page=3|S. 3]] Kommentar-Typen
- [[Material/Folien/12_Dokumentation.pdf#page=4|S. 4]] javadoc
- [[Material/Folien/12_Dokumentation.pdf#page=5|S. 5]] Javadoc-Output (z.B. http://docs.oracle.com/javase/8/docs/api/)
- [[Material/Folien/12_Dokumentation.pdf#page=6|S. 6]] Programmdokumentation
- [[Material/Folien/12_Dokumentation.pdf#page=7|S. 7]] Beispiel: Klasse und Methode dokumentieren
- [[Material/Folien/12_Dokumentation.pdf#page=8|S. 8]] Die wichtigsten @-Elemente
- [[Material/Folien/12_Dokumentation.pdf#page=9|S. 9]] Weitere @-Elemente
- [[Material/Folien/12_Dokumentation.pdf#page=10|S. 10]] Anwendung von javadoc – Kommandozeile
- [[Material/Folien/12_Dokumentation.pdf#page=11|S. 11]] Anwendung von javadoc – Eclipse
- [[Material/Folien/12_Dokumentation.pdf#page=12|S. 12]] Anwendung von javadoc – IntelliJ IDEA
- [[Material/Folien/12_Dokumentation.pdf#page=13|S. 13]] Anwendung von javadoc – NetBeans
- [[Material/Folien/12_Dokumentation.pdf#page=14|S. 14]] Ergebnis
- [[Material/Folien/12_Dokumentation.pdf#page=15|S. 15]] Anhang – Offline-Konfiguration für IDE
- [[Material/Folien/12_Dokumentation.pdf#page=16|S. 16]] Anhang – Variante 1: Quellcode-Archiv-Pfad
- [[Material/Folien/12_Dokumentation.pdf#page=17|S. 17]] Anhang – Variante 1 in Eclipse
- [[Material/Folien/12_Dokumentation.pdf#page=20|S. 20]] Anhang – Variante 1 in IntelliJ
- [[Material/Folien/12_Dokumentation.pdf#page=21|S. 21]] Anhang – Variante 2: Javadoc-Archiv
- [[Material/Folien/12_Dokumentation.pdf#page=22|S. 22]] Anhang – Variante 2 in Eclipse
- [[Material/Folien/12_Dokumentation.pdf#page=25|S. 25]] Anhang – Variante 2 in IntelliJ
- [[Material/Folien/12_Dokumentation.pdf#page=27|S. 27]] Anhang – Offline-Javadoc

## Begriffe in diesem Kapitel
- [[Kommentare]] (S. [[Material/Folien/12_Dokumentation.pdf#page=2|2]], [[Material/Folien/12_Dokumentation.pdf#page=3|3]], [[Material/Folien/12_Dokumentation.pdf#page=4|4]], [[Material/Folien/12_Dokumentation.pdf#page=7|7]])
- [[Javadoc]] (S. [[Material/Folien/12_Dokumentation.pdf#page=4|4]], [[Material/Folien/12_Dokumentation.pdf#page=5|5]], [[Material/Folien/12_Dokumentation.pdf#page=10|10]], [[Material/Folien/12_Dokumentation.pdf#page=11|11]], [[Material/Folien/12_Dokumentation.pdf#page=12|12]], [[Material/Folien/12_Dokumentation.pdf#page=13|13]])

## Übungen
- [ ] [[Ü12 Radio kommentiert]] – ✅ Musterlösung

## Verwandte Themen
[[02 Entwicklungsumgebungen Eclipse und IntelliJ]] · [[09 Klassen und Objekte]]

## Folien ansehen
![[Material/Folien/12_Dokumentation.pdf]]

## Folientext (durchsuchbar)
> [!quote]- Kompletter Folientext – aufklappen
> ```text
> ── Seite 1 ──
> Programmieren I
> Dokumentation mit javadoc
>    Heusch 10.4
>    Ratz 4.1.1
> 
> Institut für Automation und angewandte Informatik
> 
> KIT – Die Forschungsuniversität in der Helmholtz-Gemeinschaft www.kit.edu
> 
> ── Seite 2 ──
> Automatische Dokumentation
> 
>    Java bietet standardmäßig das Dokumentationssystem
>    javadoc, das ganze Programmsysteme vollautomatisch
>    dokumentieren kann
>    Zur Dokumentation
>    werden Kommentare
>    verwendet;
>    javadoc kann nur
>    dokumentieren, was auch
>    kommentiert wurde!
>    Anreicherung der
>    Kommentare
>    durch Platzhalter
>    und Variablen
> 2 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 3 ──
> Kommentar-Typen
> 
>    Einzeilige Kommentare (auch am Zeilenende)
>    // Ich bin ein Kommentar
>    System.out.println("Hello World"); // Ausgabe einer Nachricht
> 
>    Mehrzeilige Kommentare
>    /* String fractionString = Utils.inputString(System.in);
>    * int pos = fractionString.indexOf("/")
>    */
> 
>    /* Die Methode implementiert das Kürzen eines
>    * Bruchs mittels GGT-Algorithmus */
> 
>    Kommentare zur automatischen Programmdokumentation
>    /** Programmdokumentation zur Klasse Fraction */
>    public class Fraction {
>    /** Doku zur Variable numerator */
>    public int numerator;
>    /** Doku zur Methode add(Fraction) */
>    public Fraction add(Fraction f) { /*...*/ }
>    }
> 
> 3 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 4 ──
> javadoc
> 
>    Aus Kommentaren, die mit /** beginnen und mit */
>    enden, erzeugt javadoc eine automatische
>    Dokumentation im HTML-Format.
>    javadoc erstellt standardmäßig nur für public- und
>    protected-Elemente eine Dokumentation.
>    Mit der -private Option von javadoc kann auch für
>    private-Elemente eine Dokumentation erstellt werden.
> 
> 4 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 5 ──
> Javadoc-Output (z.B. http://docs.oracle.com/javase/8/docs/api/)
>    packages
>    interfaces and classes
> 
>    class details
> 
> 5 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 6 ──
> Programmdokumentation
> 
>    Embedded HTML
>    Beliebiger HTML-Code kann in die Dokumentation integriert
>    werden.
>    Beispiel:
> 
>    /**
>    * <pre>
>    * System.out.println(new Date());
>    * </pre>
>    */
>    public static void main(String[] args) {
>    System.out.println(new Date());
>    }
> 
> 6 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 7 ──
> Beispiel: Klasse und Methode dokumentieren
> 
>    /**
>    * Hello-World-Programm in Java.
>    * Dies ist ein Javadoc-Kommentar
>    *
>    * @author John Doe
>    * @version 0.9
>    * @since 0.1
>    */
>    public class HelloWorld {
>    /**
>    * Hauptprogramm
>    *
>    * @param args Kommandozeilen-Parameter
>    */
>    public static void main(String[] args) {
>    System.out.println("Hello World!");
>    }
>    }
> 7 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 8 ──
> Die wichtigsten @-Elemente
> 
>    @see - erlaubt Referenz auf die Dokumentation anderer
>    Klassen   /**   Beispiel
> 
>    @see Klassenname   * @see java.lang.Object
>    @see Klassenname#Methodenname   */
> 
>    @author - Wer hat das verbockt?
>    @version - Version der Methode/Programms/Klasse/...
>    @return - Was ist die Bedeutung des Rückgabewertes
>    @return Beschreibung
> 
>    @param - Welche Parameter werden übergeben
>    @param Parametername Beschreibung
> 
>    @throws, @exception - Welche Ausnahmen sind möglich
>    @throws Ausnahme-Klassenname Beschreibung
> 
> 8 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 9 ──
> Weitere @-Elemente
> 
>    @deprecated - veraltete Methoden markieren
>    @deprecated As of JDK 1.1, replaced by
>    {@link #setBounds(int,int,int,int)} */
> 
>    @since - wenn ein Feld oder eine Methode ab einer
>    bestimmten Version verfügbar ist
>    @since 1.5
> 
>    @serial, @serialData, @serialField - für serialisierbare
>    Attribute
>    {@value} - zum Anzeigen des Wertes eines statischen
>    Feldes
> 
>    Vollständige Beschreibung:
>    http://docs.oracle.com/javase/8/docs/technotes/guides/javadoc/index.html
> 
> 9 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 10 ──
> Anwendung von javadoc (1) - Kommandozeile
> 
>    Generieren der Dokumentation mit dem Kommandozeilen-
>    Tool javadoc (Bestandteil des JDK)
> 
>    > javadoc *.java # im Sourceverzeichnis
>    > javadoc -d doc -sourcepath src -subpackages de # im Projektverzeichnis
> 
> 10 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 11 ──
> Anwendung von javadoc (2) - Eclipse
> 
>    Entwicklungsumgebungen stellen Funktionalität zur
>    Generierung von Javadoc bereit
> 
>    Project > Generate Javadoc…
> 
> 11 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 12 ──
> Anwendung von javadoc (3) – IntelliJ IDEA
> 
>    Tools > Generate JavaDoc
> 
> 12 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 13 ──
> Anwendung von javadoc (4) - NetBeans
> 
>    Run > Generate Javadoc
> 
> 13 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 14 ──
> Ergebnis
> 
> 14 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 15 ──
> Anhang – Offline-Konfiguration für IDE
> 
>    Normalerweise Javadoc für Standard-Klassen von IDE
>    automatisch über das Internet verfügbar
> 
>    In Prüfungssituation ungünstig → kein Internet erlaubt
>    Möglichkeit der Offline-Konfiguration
> 
>    2 Möglichkeiten für Offline-Verfügbarkeit von Javadoc
>    Variante 1: Java-Quellcode (src.zip) verknüpfen
>    Variante 2: Javadoc-Archiv verknüpfen
> 
>    → eine von beiden Varianten genügt für Javadoc,
>    für Debugging aber ist Variante 1 zu bevorzugen
> 
> 15 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 16 ──
> Anhang – Variante 1: Quellcode-Archiv-Pfad
> 
>    Variante 1: Source-Code-ZIP des JDKs
>    Bei installiertem JDK im Installationsverzeichnis dabei, bspw:
>    Gängige Pfade für JDK-Verzeichnis (am Beispiel Java 8 Update 192):
>    Windows:
>    C:\Program Files\Java\jdk1.8.0_192\
>    C:\Program Files (x86)\Java\jdk1.8.0_192\
>    Linux:
>    /usr/lib/jvm/java-1.8.0-openjdk-amd64/ (openJDK)
>    /usr/lib/jvm/java-8-oracle/ (Oracle JDK)
>    MacOS:
>    /Library/Java/JavaVirtualMachines/jdk1.8.0_192.jdk/Contents/Home
>    Source-Code-Archiv liegt dann entweder unter
>    $JDK_DIR/src.zip (bis Java 8)
>    $JDK_DIR/lib/src.zip (ab Java 9)
>    Javadoc der Standard-Klassen ist Teil des Quellcodes
>    → kann von der IDE ausgewertet werden
> 
> 16 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 17 ──
> Anhang – Variante 1 in Eclipse (1)
> 
>    Window > Preferences
> 
>    Installed JREs > JRE/JDK auswählen > Edit
> 
> 17 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 18 ──
> Anhang – Variante 1 in Eclipse (2)
> 
>    rt.jar: bis Java 8
>    jrt-fs.jar ab Java 9
> 
> In der Liste rt.jar/jrt-fs.jar auswählen > Source Attachment
> 
> 18 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 19 ──
> Anhang – Variante 1 in Eclipse (3)
> 
>    External location > External File… > src.zip-Datei auswählen
> 
> 19 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 20 ──
> Anhang – Variante 1 in IntelliJ
> 
> File > Project Structure…
> 
>    SDKs > 1.8 > Sourcepath-Tab
> 
>    Normalerweise ist src.zip bereits automatisch verknüpft. Sollte das nicht der
>    Fall sein, kann es mit „+“ (rechter Rand) entsprechend hinzugefügt werden.
> 
> 20 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 21 ──
> Anhang – Variante 2: Javadoc-Archiv
> 
>    Javadoc-ZIP muss heruntergeladen werden
>    http://java.oracle.com > Top Downloads > JavaSE
>    (aktueller Direktlink: https://www.oracle.com/technetwork/java/javase/downloads/index.html)
> 
>    Unter „Additional Resouces“ gibt es dann die Downloads für die
>    akutell unterstützten Versionen Java 8 und 11:
> 
>    Zum Herunterladen muss analog
>    zum JDK der entsprechenden
>    Lizenz zugestimmt werden
> 
> 21 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 22 ──
> Anhang – Variante 2 in Eclipse (1)
> 
>    Window > Preferences
> 
>    Installed JREs > JRE/JDK auswählen > Edit
> 
> 22 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 23 ──
> Anhang – Variante 2 in Eclipse (2)
> 
>    rt.jar: bis Java 8
>    jrt-fs.jar ab Java 9
> 
> In der Liste rt.jar/jrt-fs.jar auswählen > Javadoc Location…
> 
> 23 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 24 ──
> Anhang – Variante 2 in Eclipse (3)
> 
>    Standard-Einstellung: Online   Offline-Variante die
>    direkt von docs.oracle.com   heruntergeladenes Archiv nutzt
> 
> 24 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 25 ──
> Anhang – Variante 2 in IntelliJ (1)
> 
> File > Project Structure…
> 
>    SDKs > 1.8 > Documentation Paths Tab > „+“
> 
> 25 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 26 ──
> Anhang – Variante 2 in IntelliJ (2)
> 
>    Zum Javadoc-ZIP navigieren und innerhalb
>    des Archivs dann docs/api auswählen
> 
> 26 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 27 ──
> Anhang – Offline-Javadoc
> 
>    Bei beiden Varianten funktioniert nun Javadoc auch offline
> 
> 27 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> ```
