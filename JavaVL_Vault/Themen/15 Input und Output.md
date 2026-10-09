---
tags: ["typ/thema", "thema/io", "kategorie/io", "semester/1"]
aliases: ["Input und Output", "Folien 15"]
semester: 1
kategorie: "Ein- und Ausgabe"
folien: "[[Material/Folien/15_InputOutput.pdf]]"
seiten: 40
---

# 15 Input und Output

← [[14 Exceptions]] · [[Start|🏠 Start]] · [[00 Überblick Programmieren II]] →

> [!abstract] Worum geht's?
> Dateien und Datenströme mit java.io und java.nio: Pfade, InputStream/OutputStream, Reader/Writer, Puffer-Klassen (BufferedReader/-Writer, PrintWriter) und sauberes Schließen von Ressourcen.

**Semester:** Programmieren I · **Bereich:** #kategorie/io · **Folien:** [[Material/Folien/15_InputOutput.pdf|15_InputOutput.pdf]] (40 Seiten)

## Gliederung der Folien
- [[Material/Folien/15_InputOutput.pdf#page=2|S. 2]] java.io + java.nio
- [[Material/Folien/15_InputOutput.pdf#page=3|S. 3]] Vorab: Verzeichnis- und Dateipfade
- [[Material/Folien/15_InputOutput.pdf#page=5|S. 5]] IO
- [[Material/Folien/15_InputOutput.pdf#page=6|S. 6]] NIO
- [[Material/Folien/15_InputOutput.pdf#page=7|S. 7]] Vergleich: Ein paar wichtige Funktionalitäten
- [[Material/Folien/15_InputOutput.pdf#page=9|S. 9]] IO
- [[Material/Folien/15_InputOutput.pdf#page=10|S. 10]] NIO
- [[Material/Folien/15_InputOutput.pdf#page=11|S. 11]] ÜBUNG
- [[Material/Folien/15_InputOutput.pdf#page=12|S. 12]] Ein- und Ausgabe über Datenströme
- [[Material/Folien/15_InputOutput.pdf#page=14|S. 14]] Basisklassen für Ein- und Ausgabe-Ströme
- [[Material/Folien/15_InputOutput.pdf#page=15|S. 15]] Basisklasse InputStream – Einige Methoden
- [[Material/Folien/15_InputOutput.pdf#page=16|S. 16]] Basisklasse OutputStream – Einige Methoden
- [[Material/Folien/15_InputOutput.pdf#page=17|S. 17]] Basisklasse Reader – Einige Methoden
- [[Material/Folien/15_InputOutput.pdf#page=18|S. 18]] Basisklasse Writer – Einige Methoden
- [[Material/Folien/15_InputOutput.pdf#page=19|S. 19]] Ein- und Ausgabetypen
- [[Material/Folien/15_InputOutput.pdf#page=20|S. 20]] Inputs und Outputs: Dateien
- [[Material/Folien/15_InputOutput.pdf#page=21|S. 21]] Exception-Handling & Schließen von Ressourcen
- [[Material/Folien/15_InputOutput.pdf#page=22|S. 22]] IO
- [[Material/Folien/15_InputOutput.pdf#page=23|S. 23]] ÜBUNG
- [[Material/Folien/15_InputOutput.pdf#page=24|S. 24]] Anmerkungen zum Zeilentrenner
- [[Material/Folien/15_InputOutput.pdf#page=25|S. 25]] Elementare und höherwertige I/O-Klassen
- [[Material/Folien/15_InputOutput.pdf#page=28|S. 28]] Einige höherwertige Funktionen – PrintWriter
- [[Material/Folien/15_InputOutput.pdf#page=29|S. 29]] Einige höherw. Funktionen – BufferedWriter
- [[Material/Folien/15_InputOutput.pdf#page=30|S. 30]] Einige höherw. Funktionen – BufferedReader
- [[Material/Folien/15_InputOutput.pdf#page=31|S. 31]] Beispiele
- [[Material/Folien/15_InputOutput.pdf#page=32|S. 32]] IO
- [[Material/Folien/15_InputOutput.pdf#page=33|S. 33]] NIO
- [[Material/Folien/15_InputOutput.pdf#page=35|S. 35]] Datei schreiben mit BufferedWriter
- [[Material/Folien/15_InputOutput.pdf#page=39|S. 39]] IO
- [[Material/Folien/15_InputOutput.pdf#page=40|S. 40]] Historischer Vergleich:

## Begriffe in diesem Kapitel
- [[try-with-resources]] (S. [[Material/Folien/15_InputOutput.pdf#page=2|2]], [[Material/Folien/15_InputOutput.pdf#page=21|21]], [[Material/Folien/15_InputOutput.pdf#page=22|22]], [[Material/Folien/15_InputOutput.pdf#page=32|32]], [[Material/Folien/15_InputOutput.pdf#page=33|33]], [[Material/Folien/15_InputOutput.pdf#page=35|35]])
- [[Datenströme]] (S. [[Material/Folien/15_InputOutput.pdf#page=12|12]], [[Material/Folien/15_InputOutput.pdf#page=13|13]], [[Material/Folien/15_InputOutput.pdf#page=14|14]], [[Material/Folien/15_InputOutput.pdf#page=15|15]], [[Material/Folien/15_InputOutput.pdf#page=16|16]], [[Material/Folien/15_InputOutput.pdf#page=17|17]])
- [[Reader und Writer]] (S. [[Material/Folien/15_InputOutput.pdf#page=17|17]], [[Material/Folien/15_InputOutput.pdf#page=18|18]], [[Material/Folien/15_InputOutput.pdf#page=28|28]], [[Material/Folien/15_InputOutput.pdf#page=29|29]], [[Material/Folien/15_InputOutput.pdf#page=30|30]], [[Material/Folien/15_InputOutput.pdf#page=35|35]])
- [[BufferedReader und BufferedWriter]] (S. [[Material/Folien/15_InputOutput.pdf#page=20|20]], [[Material/Folien/15_InputOutput.pdf#page=26|26]], [[Material/Folien/15_InputOutput.pdf#page=29|29]], [[Material/Folien/15_InputOutput.pdf#page=30|30]], [[Material/Folien/15_InputOutput.pdf#page=35|35]], [[Material/Folien/15_InputOutput.pdf#page=36|36]])
- [[PrintWriter]] (S. [[Material/Folien/15_InputOutput.pdf#page=26|26]], [[Material/Folien/15_InputOutput.pdf#page=28|28]], [[Material/Folien/15_InputOutput.pdf#page=39|39]])
- [[Datei und Pfad]] (S. [[Material/Folien/15_InputOutput.pdf#page=2|2]], [[Material/Folien/15_InputOutput.pdf#page=3|3]], [[Material/Folien/15_InputOutput.pdf#page=4|4]], [[Material/Folien/15_InputOutput.pdf#page=5|5]], [[Material/Folien/15_InputOutput.pdf#page=6|6]], [[Material/Folien/15_InputOutput.pdf#page=7|7]])

## Kommt hier auch vor
[[Array]] · [[Überschreiben]] · [[Exception]] · [[Stack Trace]] · [[Set]] · [[Stream-API]] · [[Optional]]

## Übungen
- [ ] [[Ü15 Arbeiten mit Dateien]] ★☆☆☆☆ ✅ Musterlösung
- [ ] [[Ü15 Quersummen speichern]] ★☆☆☆☆ ✅ Musterlösung
- [ ] [[Ü15 Palindrome speichern]] ★☆☆☆☆ ✅ Musterlösung
- [ ] [[Ü15 Teil einer Datei]] ★★☆☆☆ ✅ Musterlösung
- [ ] [[Ü15 Zugriff auf eine Textdatei]] ★★☆☆☆ ✅ Musterlösung
- [ ] [[Ü15 Primzahlen speichern und lesen]] ★★★☆☆ ✅ Musterlösung

## Relevant für diese Programmentwürfe
[[PE CHORona]] · [[PE ChatterGPT Validator]] · [[PE CoronaWarn]] · [[PE DBVasion]] · [[PE FakeTalk]] · [[PE SnatChat (Übungs-PE Oktober 2026)]] · [[PE SpeedyQuiz]] · [[PE jBay]]

## Verwandte Themen
[[14 Exceptions]] · [[33 Java 8 – Lambdas, Streams, NIO.2]] · [[29 XML]] · [[30 JSON mit GSON]]

## Folien ansehen
![[Material/Folien/15_InputOutput.pdf]]

## Folientext (durchsuchbar)
> [!quote]- Kompletter Folientext – aufklappen
> ```text
> ── Seite 1 ──
> Programmieren I
> Input / Output (I/O)
>    Heusch 2. Bd.
>    Ratz 19
> 
> Institut für Automation und angewandte Informatik
> 
> KIT – Die Forschungsuniversität in der Helmholtz-Gemeinschaft www.kit.edu
> 
> ── Seite 2 ──
> java.io + java.nio
> 
>    Für das Handling von Dateien gibt es zwei „Wege“
>    Das Original: java.io + File   Neuer: java.nio + Path
> 
>    Für die „Basics“ vollkommend   Adressiert Probleme die mit
>    ausreichend   java.io identifiziert wurden
>    Blockierendes I/O   Ergänzt java.io teilweise
>    Fehlerbehandlung nicht ganz   Asynchrone/Nicht-Blockierende
>    optimal   I/O-Operationen unterstützt
>    Probleme bei symbolischen Links   UTF-8 als Standard-Zeichensatz
>    Probleme bei Verzeichnissen mit   Erweiterte Datei-Operationen
>    vielen Unterverzeichnissen / Dateien
>    Aber: Alles wäre zu umfangreich
>    Aber: Noch häufig verwendet in   → wir zeigen die Basics im
>    Beispielen & Code „den man so   Vergleich mit java.io
>    findet“ → Auslassen keine Option!
>    NIO: Java 1.4
>    IO   NIO
>    NIO.2: Java 1.7
> 2 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 3 ──
> Vorab: Verzeichnis- und Dateipfade (1)
> 
>    Verzeichnisse haben einen Namen und ggf. ein Eltern-
>    Verzeichnis in dem sie liegen
>    Beides zusammen ist der Verzeichnispfad
> 
>    Dateien werden über das Verzeichnis in dem sie
>    gespeichert sind und ihrem Namen angesprochen
>    Beides zusammen ist der Dateipfad
> 
>    Dateipfade gibt es in 2 Varianten:
>    Absolut → von überall eindeutig (bspw. C:\temp\abc\def.txt)
>    Beginnt unter Windows mit $LAUFWERK:\
>    unter Unix-Systemen mit / (forward slash)
>    Relativ → Angabe abhängig davon wo man sich „gerade befindet“
>    (bspw. abc/def.txt)
> 3 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 4 ──
> Vorab: Verzeichnis- und Dateipfade (2)
> 
>    Und wo befinde ich mich gerade?
> 
>    Konsole: zeigt es an
>    IDE: Standardmäßig im
>    Projektverzeichis (nicht src!)
> 
>    Relativer Pfad: abc/def.txt
>    Aktuelles Verzeichnis: /tmp
> 
>    ➔ /tmp/abc/def.txt
> 
> 4 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 5 ──
> IO
>    Die Klasse File
> 
>    Ein File-Objekt repräsentiert einen (abstrakten) Datei- oder
>    Verzeichnis-Pfadnamen im Dateisystem.
>    Dabei kann es sich neben existierenden auch um (noch) nicht
>    existierende Dateien und Verzeichnisse handeln.
>    Ein File-Objekt enthält Informationen über ein File oder
>    Verzeichnis (den (abstrakten) Pfadnamen)
>    Das File-Objekt ist nicht die Datei bzw. das Verzeichnis selbst!
>    Konstruktoren:
>    File(String pathname)   File test = new File("tmp.txt");
>    erzeugt ein File-Objekt mit dem angegebenen Pfadnamen.
>    File(String parent, String child)
>    File(File parent, String child)
>    erzeugt ein File-Objekt. Der Pfadname ergibt sich aus dem
>    Basisverzeichnis parent und dem weiteren Pfad-Teil child.
> 5 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 6 ──
> NIO
>    Die Schnittstelle Path
> 
>    Analog zu File-Objekten repräsentiert ein Path nur die
>    „Adresse“ zu einem Verzeichnis bzw. einer Datei
> 
>    Path-Instanzen werden im Gegensatz zu Files nicht mit einem
>    eigenen Konstruktor erzeugt
>    Dafür gibt es die Hilfsklasse Paths
> 
>    Path test = Paths.get("tmp.txt");
> 
>    Path-Instanzen enthalten im Gegensatz zu Files auch keine
>    Informationen über das Verzeichnis oder die Datei bereit
>    Dafür gibt es die Hilfsklasse Files
> 
> 6 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 7 ──
> Vergleich: Ein paar wichtige Funktionalitäten (1)
>    File dir =   Path dirPath =
>    new File("/tmp/a");   Paths.get("/tmp/a");
>    File file =   Path filePath =
>    new File("/tmp/b.txt");   Paths.get("/tmp/b.txt");
> 
>    Was   File   Path
>    Verzeichnis anlegen   dir.mkdir()   Files.createDirectory(
>    dirPath)
>    Verzeichnisse   dir.mkdirs()   Files.createDirectories(
>    anlegen   dirPath)
>    Wenn das Verzeichnis /tmp/abc/def/ghi angelegt werden soll und bisher „nur“ /tmp existiert wird die erste
>    Variante fehlschlagen. Bei der zweiten Variante werden alle „Zwischenverzeichnisse“ ebenfalls angelegt.
> 
>    Test ob „Adresse“   dir.isDirectory()   Files.isDirectory(dirPath)
>    ein existierendes
>    Verzeichnis ist
>    Test ob „Adresse“   file.isFile()   Files.isRegularFile(
>    eine existierende   filePath)
>    Datei ist
> 
> 7 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 8 ──
> Vergleich: Ein paar wichtige Funktionalitäten (2)
>    File dir =   Path dirPath =
>    new File("/tmp/a");   Paths.get("/tmp/a");
>    File file =   Path filePath =
>    new File("/tmp/b.txt");   Paths.get("/tmp/b.txt");
> 
>    Was   File   Path
>    Existenz prinzipiell   dir.exists()   Files.exists(dirPath)
>    überprüfen   file.exists()   Files.exists(filePath)
>    Umbenennen /   file.renameTo(otherFile)   Files.move(filePath,
>    verschieben   otherFilePath)
>    Löschen   file.delete()   Files.delete(filePath)
>    dir.delete()   Files.delete(dirPath)
>    Wenn ein Verzeichnis gelöscht wird, dürfen darin keine Unterordner oder Dateien mehr liegen.
> 
>    In absolute File-   file.getAbsoluteFile()   filePath.toAbsolutePath()
>    /Path-Instanz   dir.getAbsoluteFile()   dirPath.toAbsolutePath()
>    umwandeln
> 
>    Vollständige Dokumentation:   Vollständige Dokumentation:
>    https://docs.oracle.com/en/java/javase/21/docs/api/j https://docs.oracle.com/en/java/javase/21/docs/api/j
>    ava.base/java/io/File.html   ava.base/java/nio/file/Files.html
> 
> 8 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 9 ──
> IO
>    Beispiel: Verzeichnis und Datei erzeugen (1)
>    import java.io.*;
> 
>    public class FileIOV1 {
> 
>    public static void main(String args[]) {
>    File testDir = new File("testDir");
>    testDir.mkdir();
>    File testFile = new File(testDir, "testFile.txt");
>    try {
>    testFile.createNewFile();
>    } catch (IOException ex) {
>    ex.printStackTrace();
>    }
>    }
> 
>    }
> 
> 9 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 10 ──
> NIO
>    Beispiel: Verzeichnis und Datei erzeugen (2)
>    import java.io.IOException;
>    import java.nio.file.*;
> 
>    public class CreateDirAndFile2 {
>    Auch Verzeichnis
>    anlegen wirft im
>    public static void main(String args[]) {   Fehlerfall eine
>    Path testDir = Paths.get("testDir");   IOException
>    try {
>    Files.createDirectory(testDir);
>    Path testFile = testDir.resolve("testFile.txt");
>    Files.createFile(testFile);
>    } catch (IOException ex) {
>    ex.printStackTrace();
>    }
>    }
> 
>    }
> 
> 10 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 11 ──
> ÜBUNG
> 
>    INPUT/OUTPUT (1)
>    1. AUFGABE
> 
> 11 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 12 ──
> Ein- und Ausgabe über Datenströme (1)
> 
>    Sämtliche Ein- und Ausgaben in Java laufen über (Daten-)
>    Ströme (engl. Streams) ab.
>    Ein (Daten-)Strom ist eine Verbindung zwischen einem
>    Programm und einer Datenquelle bzw. einer Datensenke
>    (Datenziel).
>    Diese Verbindung (der Strom) läuft dabei stets nur in einer
>    Richtung (uni-direktional).
>    Ein Strom kann an der Datenquelle Daten nur aufnehmen und
>    an der Datensenke nur Daten abgeben.
> 
> 12 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 13 ──
> Ein- und Ausgabe über Datenströme (2)
> 
>    Für Eingaben muss ein Programm
>    zunächst einen Strom, der mit der Datenquelle verbundenen
>    ist, anlegen und öffnen,
>    dann die ankommenden Informationen sequentiell lesen
>    (wobei mit dem Lesen die Daten dem Strom entnommen
>    werden) und
>    den Strom nach seiner Verwendung wieder schließen.
>    Für Ausgaben gilt das Entsprechende mit einer Datensenke.
>    In einem Java-Programm wird ein Strom durch ein Stream-
>    Objekt repräsentiert.
>    Für die Verarbeitung verschiedenartiger Datenströme stellt
>    Java zahlreiche Klassen bereit, die sich auch kombinieren
>    lassen.
> 13 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 14 ──
> Basisklassen für Ein- und Ausgabe-Ströme
> 
>    Für Ein- und Ausgabe-Ströme hat Java vier Basisklassen:
>    InputStream und OutputStream (Binärdaten)
>    Reader und Writer (Zeichen-orientierte Daten)
>    Daten-   01001010
>    InputStream   01100001
>    quelle
>    01110110
>    Daten-   01100001
>    Binärdaten   OutputStream
>    senke
>    JVM
>    Daten-   Das ist
>    Reader
>    quelle   das Haus
>    vom
>    Daten-   Nikolaus
>    Textdaten
>    Writer
>    senke
> 
>    Diese vier Klassen sind direkte Unterklassen von Object
>    Sie liegen im Paket java.io
>    → aber auch von NIO verwendet!
> 14 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 15 ──
> Basisklasse InputStream – Einige Methoden
> 
>    int read()
>    liest das nächste Byte von diesem InputStream (und
>    entnimmt es dabei). Liefert -1 bei Ende des Streams.
>    int read(byte[] b)
>    int read(byte[] b, int off, int len)
>    liest mehrere Bytes vom InputStream (max. b.length
>    viele) und speichert sie in dem Array b.
>    Optional: Offset und von b.length abweichende Menge
>    Rückgabewert: Anzahl der gelesenen Bytes
>    long skip(long n)
>    überspringt n Bytes dieses InputStreams.
>    void close()
>    InputStream schließen und Ressourcen freigeben
> Vollständige Dokumentation: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/InputStream.html
> 
> 15 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 16 ──
> Basisklasse OutputStream – Einige Methoden
> 
>    void write(int b)
>    schreibt ein einzelnes Byte auf diesen OutputStream.
>    Geschrieben werden die niederwertigen 8 Bits von b.
>    void write(byte[] b)
>    void write(byte[] b, int off, int len)
>    schreibt die Bytes aus Puffer b auf den OutputStream
>    Optional: Offset und von b.length abweichende Menge
>    void flush()
>    „spült“ (leert) einen eventuellen Puffer des OutputStream-
>    Objekts (durch die sofortige Abarbeitung aller noch
>    anstehenden Bytes). Wichtig bei gepufferten Ausgaben!
>    void close()
>    OutputStream schließen und Ressourcen freigeben
> Vollständige Dokumentation: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/OutputStream.html
> 
> 16 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 17 ──
> Basisklasse Reader – Einige Methoden
> 
>    int read()
>    liest das nächste Zeichen von diesem Reader (und
>    entnimmt es dabei). Liefert -1 bei Ende des Datenstroms.
>    int read(char[] b)
>    int read(char[] b, int off, int len)
>    liest mehrere Zeichen vom Reader (max. b.length viele)
>    und speichert sie in dem Array b.
>    Optional: Offset und von b.length abweichende Menge
>    Rückgabewert: Anzahl der gelesenen Zeichen
>    long skip(long n)
>    überspringt n Zeichen dieses Readers.
>    void close()
>    Reader schließen und Ressourcen freigeben
>    Vollständige Dokumentation: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/Reader.html
> 
> 17 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 18 ──
> Basisklasse Writer – Einige Methoden
> 
>    void write(char c)
>    schreibt ein einzelnes Zeichen auf diesen Writer
>    void write(char[] b)
>    void write(char[] b, int off, int len)
>    schreibt die Zeichen aus Puffer b auf den Writer
>    Optional: Offset und von b.length abweichende Menge
>    void write(String s)
>    schreibt die Zeichenkette s auf den Writer
>    void flush()
>    analog zu OutputStream
>    void close()
>    Writer schließen und Ressourcen freigeben
>    Vollständige Dokumentation: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/Writer.html
> 
> 18 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 19 ──
> Ein- und Ausgabetypen
> 
>    Verschiedene Datenquellen möglich
>    Byte-Array   Je nach
>    Anwendungsfall
>    Java-Zeichenkette
>    Daten-   Datei   Binärdaten:
>    InputStreams   JVM
>    quellen   Pipe*
>    Netzwerk/Internet   Zeichenbasiert:
>    …   Reader
> 
>    Verschiedene Datensenken möglich
> 
>    * Kommunikation zwischen Threads
>    Je nach   Byte-Array
>    Anwendungsfall
>    Java-Zeichenkette
>    Daten-   Binärdaten:   Datei
>    OutputStreams   JVM
>    senken   Pipe*
>    Zeichenbasiert:   Netzwerk/Internet
>    Writer   …
> 
> 19 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 20 ──
> Inputs und Outputs: Dateien
>    Binäre Dateien
>    Textdateien
>    (bspw. Bilder)
>    Datei lesen   FileInputStream   FileReader
>    Datei schreiben   FileOutputStream   FileWriter
> 
>    Anmerkung: was BufferedWriter ist kommt später ☺
>    Besonderheit beim Schreiben: Entscheidung ob
>    die komplette Datei überschrieben werden soll
>    der neue Inhalt am Ende der Datei angehängt werden soll
> 
>    File f = new File("myfile.txt");
>    IO   new FileWriter(f);   // Überschreiben
>    new FileWriter(f, true); // Anhängen
> 
>    Path p = Paths.get("myfile.txt");
>    Files.newBufferedWriter(p);   // Überschreiben
>    NIO
>    Files.newBufferedWriter(p, StandardOpenOption.CREATE,
>    StandardOpenOption.APPEND); // Anhängen
> 20 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 21 ──
> Exception-Handling & Schließen von Ressourcen
> 
>    Ressourcen müssen geschlossen werden, wenn sie nicht mehr
>    gebraucht werden.
>    Seit Java 1.7 gibt es try-with-resources (try-Block mit Parameter)
>    Die im Parameter angegebenen Ressourcen werden nach dem try-
>    Block automatisch geschlossen, und eventuell auftretende
>    Exceptions werden wie üblich behandelt (in einem catch-Block).
>    Im Parameter lassen sich eine oder auch mehrere
>    Ressourcen deklarieren. Beispiel:
>    try ( InputStream is = new FileInputStream(source);
>    IO
>    OutputStream os = new FileOutputStream(target) ) {
>    // Ströme zum Lesen und zum Schreiben
>    } // Ressourcen werden automatisch geschlossen
>    catch(IOException e){
>    // Fehlerbehandlung
>    }
>    Ab Java 1.7
> 
> 21 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 22 ──
> IO
>    Beispiel: Erstes Zeichen einer Datei lesen
>    Eingeschränktes Beispiel zum
>    import java.io.*;   „warm werden“. Die „richtigen“
>    Beispiele folgen später!
>    public class ReadFirstChar {
> 
>    public static void main(String args[]) {
>    String testFile = "test.txt";
>    // Anlegen des FileReaders zum Lesen von textbasierten Dateien
>    try (Reader fReader = new FileReader(testFile)) {
>    int c = fReader.read(); // read() liefert int-Wert
>    System.out.println("Read: " + (char) c);
>    } catch (IOException ex) {
>    ex.printStackTrace();
>    }
>    }
>    }
> 
>    Ausgabe
>    Read: L
> 
> 22 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 23 ──
> ÜBUNG
> 
>    INPUT/OUTPUT (1)
>    2. AUFGABE
> 
> 23 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 24 ──
> Anmerkungen zum Zeilentrenner
>    (Carriage Return und Line Feed)
>    Standard-Zeilentrenner sind in Unix/Linux/MacOS X und Windows
>    unterschiedliche Zeichen bzw. Zeichenkombinationen:
> 
>    Unix/Linux/MacOS X   Windows
>    \n (LF)   \r\n (CRLF)
> 
>    Der Zeilentrenner des Systems auf dem das Java-Programm
>    ausgeführt wird lässt sich zur Laufzeit auslesen:
>    String newLine = System.lineSeparator();   oder
>    String newLine = System.getProperty("line.separator");
> 
>    Höherwertige Ein-/Ausgabeklassen kümmern sich darum
>    plattformunabhängig automatisch
>    Anmerkung: Früher bei „klassischem“ MacOS: \r (CR)
> 24 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 25 ──
> Elementare und höherwertige I/O-Klassen (1)
> 
>    Die bisher behandelten Klassen bieten eher „elementare“
>    (einfache) Ein-/Ausgabe-Funktionen,
>    wie z.B. Öffnen/Schließen eines Stroms, byteweise bzw.
>    zeichenweise Ein-/Ausgabe
> 
>    Daneben gibt es in Java eine Reihe von Klassen mit
>    „höherwertigeren“ Ein-/Ausgabe-Funktionen, die zusätzliche
>    Funktionalität bietenden, wie z.B.
>    Automatische Behandlung des Zeilentrenners
>    gepufferte Ein-/Ausgabe.
>    die Ein-/Ausgabe primitiver Datentypen in ihrer
>    Binärdarstellung (z.B. long- oder double-Daten)
> 
> 25 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 26 ──
> Elementare und höherwertige I/O-Klassen (2)
> 
>    Bisherige Klassen mit elementaren Funktionen
>    FileInputStream / FileOutputStream
>    FileReader / FileWriter
> 
>    Klassen mit „höherwertigen“ Funktionen
>    PrintStream   höherwertige
>    Nur Schreiben!
>    PrintWriter   Methoden
> 
>    BufferedInputStream/BufferedOutputStream   Zusätzlich:
>    gepufferte
>    BufferedReader/BufferedWriter   Ein-/Ausgabe
> 
>    Typische Verkettung:
>    BufferedReader br =
>    new BufferedReader(new FileReader("test.txt"));
> 
> 26 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 27 ──
> Elementare und höherwertige I/O-Klassen (3)
> 
>    Verdeutlichung der Verkettung
> 
>    einzelnes
>    Elementare   Zeichen lesen   Elementare
>    Funktionen   Funktionen
>    read()   read()
> 
>    ganze Zeile lesen
>    Höherwertige Funktionen
>    readLine()
> FileReader fr =
>    new FileReader("test.txt");
> fr.read();
> 
>    BufferedReader br =
>    new BufferedReader(new FileReader("test.txt"));
>    br.readLine();
> 
> 27 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 28 ──
> Einige höherwertige Funktionen – PrintWriter
> 
>    Schwerpunkt: Formatierung & zeichenorientierte Ausgabe
>    void print(type x)
>    erzeugt dem Datentyp type entsprechende String-
>    Darstellung für den Wert x und schreibt sie auf die Ausgabe
>    void println()
>    schreibt einen Zeilenwechsel-String auf die Ausgabe
>    void println(type x)
>    ruft print(x) und anschließend println() auf
>    PrintWriter printf(String format, Object... args)
>    schreibt eine formatierte Zeichenkette auf die Ausgabe
>    PrintWriter append(CharSequence csq)
>    schreibt die Zeichenfolge csq in den Strom
>    Vollständige Dokumentation: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/PrintWriter.html
> 
> 28 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 29 ──
> Einige höherw. Funktionen – BufferedWriter
> 
>    Schwerpunkt: gepufferte Ausgabe für bessere Performance
>    void newLine()
>    schreibt den Zeilentrenner des Systems auf dem das Java-
>    Programm aktuell läuft auf die Ausgabe
>    • Wenn sehr viele Zeichen auf eine Datensenke geschrieben werden, kann
> Vorteil gepufferter Ausgabe
> 
>    dies ineffizient sein, jedes Zeichen in einem eigenen Vorgang zu schreiben
>    → Für jedes einzelne Zeichen muss z.B. die entsprechende Verbindung
>    mit dem Speichermedium bzw. der Netzwerkumgebung separat auf- und
>    wieder abgebaut werden.
>    • Die Klasse BufferedWriter ermöglicht es, eine ganze Reihe von vor dem
>    eigentlichen Schreibvorgang auf das „echte“ Medium in einem internen
>    Puffer zwischenzuspeichern.
>    • Dadurch können ganze Sequenzen von Zeichen zu größeren Blöcken
>    zusammengefasst und in einem Vorgang geschrieben werden.
> Vollständige Dokumentation: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/BufferedWriter.html
> 
> 29 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 30 ──
> Einige höherw. Funktionen – BufferedReader
> 
>    Schwerpunkt: gepufferte Eingabe für bessere Performance
>    String readLine()
>    ließt die Eingabe bis zum nächsten Zeilentrenner
>    (unabhängig davon ob dies LF, CRLF oder CR ist!)
>    Rückgabewert null signalisiert Ende der Eingabe(-datei)
>    boolean ready()
>    wahr, wenn das nächste read() garantiert nicht wegen
>    nicht vorhandener Daten wartet (blockiert)
> 
>    Die Vorteile der gepufferten Ausgabe gelten in die „andere Richtung“
> gepufferter
> Eingabe
> 
>    analog für die gepufferte Eingabe!
> Vorteil
> 
>    Es ist wesentlich effizienter ganze Blöcke von Zeichen in einen
>    internen Puffer zu lesen als jedes Zeichen einzeln.
> 
> Vollständige Dokumentation: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/BufferedReader.html
> 
> 30 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 31 ──
> Beispiele
> 
>    Es folgen nun einige Beispiele (endlich mehr Code!)
> 
>    Wo möglich gibt es jeweils 2 Varianten
>    Standard-IO
>    Alternative mit NIO
> 
>    Verstehen als Nachschlagewerk
> 
> 31 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 32 ──
> IO
>    Datei lesen mit BufferedReader (1)
> 
>    import java.io.BufferedReader;
>    import java.io.File;
>    import java.io.FileReader;
>    import java.io.IOException;
> 
>    public class BufferedReaderExampleIO {
> 
>    public static void main(String[] args) {
>    File f = new File("test.txt");
>    try (BufferedReader br = new BufferedReader(new FileReader(f))) {
>    while (br.ready()) {
>    String line = br.readLine();
>    System.out.println("Line Read: " + line);
>    }
>    } catch (IOException e) {
>    e.printStackTrace();
>    }
>    }
> 
>    }
> 
> 32 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 33 ──
> NIO
>    Datei lesen mit BufferedReader (2)
> 
>    import java.io.BufferedReader;
>    import java.io.IOException;
>    import java.nio.file.Files;
>    import java.nio.file.Path;
>    import java.nio.file.Paths;
> 
>    public class BufferedReaderExampleNIO {
>    public static void main(String[] args) {
>    Path p = Paths.get("test.txt");
>    try (BufferedReader br = Files.newBufferedReader(p)){
>    while ( br.ready() ) {
>    String line = br.readLine();
>    System.out.println("Line Read: " + line);
>    }
>    } catch (IOException e) {
>    e.printStackTrace();
>    }
>    }
> 
>    }
> 
> 33 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 34 ──
> NIO
>    Datei lesen mit Files-Methoden
>    import java.io.IOException; import java.nio.file.Files; import java.nio.file.Path; import java.nio.file.Paths; import java.util.List;
> 
>    public class ReadAllExamplesNIO {
>    public static void main(String[] args) {
>    Path p = Paths.get("test.txt");
> 
>    // kein try-with-resources, Files.readXYZ-Methoden lesen komplette
>    // Datei und kuemmern sich um das Schliessen der Ressourcen
>    try {
>    // der komplette Inhalt der Textdatei als Zeichenkette
>    String entireFileContent = Files.readString(p);
> 
>    // Jede Zeile als Eintrag in einer Liste
>    // mehr zu Listen: 2. Semester :-)
>    List<String> allLines = Files.readAllLines(p);
>    } catch (IOException e) {
>    e.printStackTrace();
>    }
>    }
>    }
> 
> 34 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 35 ──
> Datei schreiben mit BufferedWriter (1)
>    IO
>    Komplette Datei überschreiben (IO)
> 
>    import java.io.BufferedWriter; import java.io.File;
>    import java.io.FileWriter; import java.io.IOException;
> 
>    public class BufferedWriterExampleIO {
> 
>    public static void main(String[] args) {
>    File f = new File("test.txt");
>    try (BufferedWriter bw =
>    new BufferedWriter(new FileWriter(f))) {
>    bw.write("Ich bin die erste Zeile");
>    bw.newLine();
>    bw.write("Ich bin die zweite Zeile");
>    bw.newLine();
>    } catch (IOException e) {
>    e.printStackTrace();
>    }
>    }
>    }
> 
> 35 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 36 ──
> Datei schreiben mit BufferedWriter (2)
>    IO
>    Inhalt an Datei anhängen (IO)
> 
>    import java.io.BufferedWriter; import java.io.File;
>    import java.io.FileWriter; import java.io.IOException;
> 
>    public class BufferedWriterExampleAppendIO {
> 
>    public static void main(String[] args) {
>    File f = new File("test.txt");
>    try (BufferedWriter bw =
>    new BufferedWriter(new FileWriter(f, true))) {
>    bw.write("Ich bin die erste Zeile die angehaengt wird");
>    bw.newLine();
>    bw.write("Ich bin die zweite Zeile die angehaengt wird");
>    bw.newLine();
>    } catch (IOException e) {
>    e.printStackTrace();
>    }
>    }
> 
>    }
> 
> 36 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 37 ──
> Datei schreiben mit BufferedWriter (3)
>    NIO
>    Komplette Datei überschreiben (NIO)
> 
>    import java.io.BufferedWriter; import java.io.IOException;
>    import java.nio.file.Files; import java.nio.file.Path;
>    import java.nio.file.Paths;
> 
>    public class BufferedWriterExampleNIO {
> 
>    public static void main(String[] args) {
>    Path p = Paths.get("test.txt");
>    try (BufferedWriter bw = Files.newBufferedWriter(p)) {
>    bw.write("Ich bin die erste Zeile");
>    bw.newLine();
>    bw.write("Ich bin die zweite Zeile");
>    bw.newLine();
>    } catch (IOException e) {
>    e.printStackTrace();
>    }
>    }
> 
>    }
> 
> 37 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 38 ──
> Datei schreiben mit BufferedWriter (4)
>    NIO
>    Inhalt an Datei anhängen (NIO)
> 
>    import java.io.BufferedWriter; import java.io.IOException;
>    import java.nio.file.Files; import java.nio.file.Path;
>    import java.nio.file.Paths; import java.nio.file.StandardOpenOption;
> 
>    public class BufferedWriterExampleAppendNIO {
> 
>    public static void main(String[] args) {
>    Path p = Paths.get("test.txt");
>    try (BufferedWriter bw =
>    Files.newBufferedWriter(p, StandardOpenOption.CREATE,
>    StandardOpenOption.APPEND)){
> 
>    bw.write("Ich bin die erste Zeile die angehaengt wird");
>    bw.newLine();
>    bw.write("Ich bin die zweite Zeile die angehaengt wird");
>    bw.newLine();
>    } catch (IOException e) {
>    e.printStackTrace();
>    }
>    }
>    }
> 38 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 39 ──
> IO
>    Datei schreiben mit PrintWriter
> 
>    import java.io.File;
>    import java.io.IOException;
>    import java.io.PrintWriter;
>    Es kann auch direkt der
>    Dateiname angegeben werden.
>    public class PrintWriterExampleIO {
> 
>    public static void main(String[] args) {
>    try (PrintWriter pw = new PrintWriter("test.txt")) {
>    pw.println("Ich bin die erste Zeile");
>    pw.println("Ich bin die zweite Zeile");
>    } catch (IOException e) {
>    e.printStackTrace();
>    }
>    }
> 
>    }
> 
> 39 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 40 ──
> Historischer Vergleich:
>    saubere Ressourcenbehandlung
>    InputStream in = null;
>    Bis Java 1.6
>    try {
>    in = new FileInputStream("a.txt");   // FileNotFoundException möglich
>    // IO-Operationen
>    }
>    catch (IOException e) {
>    e.printStackTrace();
>    }
>    finally {
>    try {
>    if ( in != null ){
>    in.close();
>    }
>    } catch (IOException e){ /* ... */ }
>    }
> 
>    try (InputStream in = new FileInputStream("a.txt")){
>    // IO-Operationen   Ab Java 1.7
>    } catch (IOException e) {
>    e.printStackTrace();
>    }
> 
> 40 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> ```
