---
tags: ["typ/uebung", "thema/io", "kategorie/io", "semester/1", "schwierigkeit/2", "hat/musterloesung"]
aliases: ["TextFile"]
thema: "[[15 Input und Output]]"
klasse: "TextFile"
package: "de.dhbwka.java.exercise.io.textfile"
schwierigkeit: 2
status: "offen"
---

# Ü15 Zugriff auf eine Textdatei

**Thema:** [[15 Input und Output]] · **Bereich:** Input/Output (3) · **Schwierigkeit:** ★★☆☆☆
**Klasse:** `TextFile` · **Package:** `de.dhbwka.java.exercise.io.textfile`

📄 Aufgabe: [[Material/Aufgaben/15_IO_Aufgaben-3.pdf#page=1|15_IO_Aufgaben-3.pdf, S. 1]]
✅ Musterlösung: [[Material/Aufgaben/15_IO_Aufgaben-3_Muster.pdf#page=1|15_IO_Aufgaben-3_Muster.pdf, S. 1]]

> [!question] Kurz gesagt
> Schreiben Sie eine Klasse TextFile, welche eine Textdatei verwalten soll. Diese soll folgende Methoden haben:  Konstruktor TextFile(File f) zum Erzeugen eines neuen TextFile-Objektes.

## Aufgabenstellung
```text
Schreiben Sie eine Klasse TextFile, welche eine Textdatei verwalten soll. Diese soll folgende
Methoden haben:

        Konstruktor TextFile(File f)
         zum Erzeugen eines neuen TextFile-Objektes. Der Konstruktor soll die entsprechende
         Datei sofort einlesen. (Die zugehörige Datei muss bereits existieren.)
        Konstruktor TextFile(String pathname)
         zum Erzeugen eines neuen TextFile-Objektes. Der Konstruktor soll die entsprechende
         Datei sofort einlesen. (Die zugehörige Datei muss bereits existieren.)
        void read()
         zum (ggf. erneuten) Einlesen aller Zeilen der Datei in eine passende Datenstruktur (Puffer)
         im Speicher.
        void write()
         zum Schreiben der gepufferten Inhalte zurück in die Datei.
        int availableLines()
         liefert die Anzahl der Zeilen im Puffer.
        String[] getLines()
         liefert alle Zeilen des Puffers als String-Array.
        String getLine(int i)
         liefert Zeile i des Puffers als String (Zählung beginnend bei Zeile 1). Die Methode soll eine
         eigene Exception LineNumberOutOfBoundsException werfen, wenn die
         Zeilenummer kleiner als 1 oder größer als die Anzahl der Zeilen im Puffer ist.
        void setLine(int i, String s)
         Setzt Zeile i des Puffers auf den String s (Zählung beginnend bei Zeile 1). Die Methode soll
         ebenfalls eine eigene Exception LineNumberOutOfBoundsException werfen, wenn
         die Zeilenummer kleiner als 1 oder größer als die Anzahl der Zeilen im Puffer ist.
        void replaceAll(String regexp, String ersatz)
         zum Ersetzen aller Vorkommen von regexp (darf ein regulärer Ausdruck sein!) gegen
         ersatz (in allen Zeilen des Puffers).
        void close()
         zum Schließen der Textdatei und Freigabe der internen Ressourcen (Puffer, File-Objekt).

Testen Sie die Klasse aus einer zweiten Klasse TextFileTest!
Fangen Sie dabei LineNumberOutOfBoundsExceptions ab!

Hinweis: Beachten Sie den Packagenamen!

Beispielinhalt der Datei „bla.txt“:

Alle meine Entchen
schwimmen auf dem See,
Köpfchen in das Wasser,
Schwänzchen in die Höh.
Alle meine Täubchen
gurren auf dem Dach
fliegt eins in die Lüfte
fliegen alle nach.
Alle meine Hühner
scharren in dem Stroh,
finden sie ein Körnchen,
sind sie alle froh.
Alle meine Gänschen
watscheln durch den Grund,
suchen in dem Tümpel,
werden kugelrund.

Nach Aufruf von: aTextFile.replaceAll("meine", "unsre")

Alle unsre Entchen
schwimmen auf dem See,
Köpfchen in das Wasser,
Schwänzchen in die Höh.
Alle unsre Täubchen
gurren auf dem Dach
fliegt eins in die Lüfte
fliegen alle nach.
Alle unsre Hühner
scharren in dem Stroh,
finden sie ein Körnchen,
sind sie alle froh.
Alle unsre Gänschen
watscheln durch den Grund,
suchen in dem Tümpel,
werden kugelrund.
```

## Benötigte Begriffe
[[Scanner]] · [[for-Schleife]] · [[Array]] · [[Konstruktor]] · [[this]] · [[Kapselung]] · [[super]] · [[Exception]] · [[Eigene Exception]] · [[try-with-resources]] · [[Reader und Writer]] · [[BufferedReader und BufferedWriter]] · [[PrintWriter]] · [[Datei und Pfad]]

## Weitere Übungen zum Thema
[[Ü15 Arbeiten mit Dateien]] · [[Ü15 Quersummen speichern]] · [[Ü15 Palindrome speichern]] · [[Ü15 Teil einer Datei]] · [[Ü15 Primzahlen speichern und lesen]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.io.textfile;
> 
> @SuppressWarnings("serial")
> public class LineNumberOutOfBoundsException extends Exception {
> 
>     public LineNumberOutOfBoundsException() {
>         super();
>     }
> 
>     public LineNumberOutOfBoundsException(String message) {
>         super(message);
>     }
> 
> }
> 
> package de.dhbwka.java.exercise.io.textfile;
> 
> import java.io.BufferedReader;
> import java.io.File;
> import java.io.FileReader;
> import java.io.FileWriter;
> import java.io.IOException;
> import java.io.PrintWriter;
> 
> public class TextFile {
> 
>     /** File zum Lesen und Schreiben */
>     private File f;
>     private String[] buffer;
> 
>     /** Konstruktor mit File */
>     public TextFile(File f) {
>         this.f = f;
>         this.read();
>     }
> 
>     /** Konstruktor mit String als Pfadname */
>     public TextFile(String filename) {
>         this(new File(filename));
>     }
> 
>     /** Datei (erneut) einlesen. Wirft keine Exception! */
>     public void read() {
>         int zeilen = 0;
>         try (BufferedReader in = new BufferedReader(new FileReader(f))) {
>             for (; in.ready(); zeilen++)
>             in.readLine();
>         } catch (IOException e) {
>             System.err.println("Fehler bein Lesen der Datei.");
>         }
>         buffer = new String[zeilen];
>         try (BufferedReader in = new BufferedReader(new FileReader(f))) {
>             for (int i = 0; i < zeilen; i++)
>             buffer[i] = in.readLine();
>         } catch (IOException e) {
>             System.err.println("Fehler bein Lesen der Datei.");
>         }
>     }
> 
>     /** Datei schreiben. Wirft Exception! */
>     public void write() {
>         if (buffer != null)
>         try (PrintWriter out = new PrintWriter(new FileWriter(f))) {
>             for (int i = 0; i < buffer.length; i++)
>             out.println(buffer[i]);
>         } catch (IOException e) {
>             System.err.println("Fehler beim write()");
>         }
>     }
> 
>     /** Liefert die Anzahl der Zeilen. */
>     public int availableLines() {
>         if (buffer == null)
>         return -1;
>         return buffer.length;
>     }
> 
>     /** Liefert alle Zeilen als Array. */
>     public String[] getLines() {
>         return buffer;
>     }
> 
>     /** Liefert die angegeben Zeile. Zählung ab 1. */
>     public String getLine(int i) throws LineNumberOutOfBoundsException {
>         if (buffer == null)
>         return null;
>         if (i > 0 && i <= buffer.length)
> 
>         return buffer[i - 1];
>         else
>         throw new LineNumberOutOfBoundsException(
>         "Falsche Eingabe bei getLine");
>     }
> 
>     /** Ersetzt die angegeben Zeile. Zählung ab 1. */
>     public void setLine(int i, String s)
>     throws LineNumberOutOfBoundsException {
>         if (buffer != null && i > 0 && i <= buffer.length)
>         buffer[i - 1] = s;
>         else
>         throw new LineNumberOutOfBoundsException(
>         "Falsche Eingabe bei setLine");
>     }
> 
>     /** Ersetzt alle Vorkommen von regexp in allen Zeilen durch ersatz */
>     public void replaceAll(String regexp, String ersatz) {
>         if (buffer != null && regexp != null && ersatz != null)
>         for (int i = 0; i < buffer.length; i++)
>         buffer[i] = buffer[i].replaceAll(regexp, ersatz);
>     }
> 
>     /** Löscht den Puffer und das Filehandle */
>     public void close() {
>         buffer = null;
>         this.f = null;
>     }
> 
> }
> 
> package de.dhbwka.java.exercise.io.textfile;
> 
> import java.io.IOException;
> 
> public class TextFileTest {
> 
>     public static void main(String[]args) throws IOException,
>     LineNumberOutOfBoundsException {
>         TextFile a = new TextFile("bla.txt");
>         // Anzahl der Zeilen
>         System.out.println("Anzahl der Zeilen: "+a.availableLines());
>         // Erste Zeile
>         System.out.println("Zeile 1: " + a.getLine(1));
>         // Fünfte Zeile
>         System.out.println("Zeile 5: " + a.getLine(5));
> 
>         // Alle Zeilen
>         System.out.println("Alle Zeilen: ");
>         for(String line : a.getLines())
>         System.out.println(line);
>         // Ersetzen von "meine" durch "unsre"
>         a.replaceAll("meine", "unsre");
>         // Datei schreiben
>         // a.write();
>         System.out.println("Alle Zeilen nach dem Ersetzen: ");
>         for(String line : a.getLines())
>         System.out.println(line);
>         a.close();
>     }
> 
> }
> ```

## Meine Notizen

