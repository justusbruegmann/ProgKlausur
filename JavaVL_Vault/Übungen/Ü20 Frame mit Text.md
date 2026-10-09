---
tags: ["typ/uebung", "thema/swing", "kategorie/gui", "semester/2", "schwierigkeit/2", "hat/musterloesung"]
aliases: ["TextFrame"]
thema: "[[20 Grafische Oberflächen mit Swing]]"
klasse: "TextFrame"
package: "de.dhbwka.java.exercise.ui"
schwierigkeit: 2
status: "offen"
---

# Ü20 Frame mit Text

**Thema:** [[20 Grafische Oberflächen mit Swing]] · **Bereich:** Grafische Benutzeroberflächen (GUI/Swing) (1) · **Schwierigkeit:** ★★☆☆☆
**Klasse:** `TextFrame` · **Package:** `de.dhbwka.java.exercise.ui`

📄 Aufgabe: [[Material/Aufgaben/20_Swing_Aufgaben-1.pdf#page=2|20_Swing_Aufgaben-1.pdf, S. 2]]
✅ Musterlösung: [[Material/Aufgaben/20_Swing_Aufgaben-1_Muster.pdf#page=2|20_Swing_Aufgaben-1_Muster.pdf, S. 2]]

> [!question] Kurz gesagt
> Schreiben Sie eine Klasse TextFrame, die die Klasse JFrame erweitert und ein Fenster mit dem Inhalt einer txt-Datei erzeugt. Es soll einen Konstruktor mit den drei Parametern Dateiname der Textdatei, Breite und Höhe des Fensters (Breite und Höhe sind ganzzahlig) geben.

## Aufgabenstellung
```text
Schreiben Sie eine Klasse TextFrame, die die Klasse JFrame erweitert und ein Fenster mit dem
Inhalt einer txt-Datei erzeugt.
Es soll einen Konstruktor mit den drei Parametern Dateiname der Textdatei, Breite und Höhe des
Fensters (Breite und Höhe sind ganzzahlig) geben.
Der Fenstertitel soll dem Dateinamen entsprechen.
Der Textinhalt soll aus der Datei mit dem angegebenen Dateinamen eingelesen werden.

Schreiben Sie zum Testen der Klasse eine main-Methode, welche die Werte der Parameter
Dateiname, Breite und Höhe über Kommandozeilenparameter einliest und ein Objekt der Klasse
TextFrame erzeugt. Bei weniger als drei Kommandozeilenparametern soll die korrekte
Aufrufsyntax ausgegeben werden.

Mögliche Ausnahmen (NumberFormatException, IOException) sollen abfangen werden.

Hinweise:
   • Verwenden Sie für die Darstellung des Textes im Fenster die Klasse JTextArea.
   • Angabe von Kommandozeilenparametern etc. in den IDEs:
       Eclipse: Run > Run Configurations [> Java Application > TextFrame] > Reiter „Arguments“:
       Program Arguments + ggf. Working Directory angeben)
       NetBeans: File > Project Properties > Run > Arguments (+ Main Class + ggf. Working
       Directory)
```

## Benötigte Begriffe
[[while-Schleife]] · [[Konstruktor]] · [[this]] · [[static]] · [[toString]] · [[super]] · [[StringBuilder und StringBuffer]] · [[Wrapperklasse]] · [[Exception]] · [[RuntimeException]] · [[try-with-resources]] · [[Reader und Writer]] · [[BufferedReader und BufferedWriter]] · [[Datei und Pfad]] · [[Swing]] · [[JFrame]] · [[Swing-Komponenten]] · [[Layoutmanager]]

## Weitere Übungen zum Thema
[[Ü20 Swing-Grundkomponenten]] · [[Ü20 Datei auswählen und zeilenweise darstellen]] · [[Ü20 Währungsumrechner]] · [[Ü20 Editor]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.ui;
> 
> import java.awt.BorderLayout;
> import java.io.BufferedReader;
> import java.io.FileReader;
> import java.io.IOException;
> 
> import javax.swing.JFrame;
> import javax.swing.JTextArea;
> 
> @SuppressWarnings( "serial" )
> public class TextFrame extends JFrame {
> 
>     public TextFrame( String filename, int width, int height ) {
>         super( filename );
>         this.setLayout( new BorderLayout() );
>         this.add( new JTextArea( TextFrame.readFile( filename ) ) );
>         this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
>         this.setSize( width, height );
>         this.setVisible( true );
>     }
> 
>     /**
>      * Read a text file and return its content as String
>      *
>      * @param filename
>      *            file name to open text file from
>      * @return content of file
>      */
>     private static String readFile( String filename ) {
>         StringBuilder content = new StringBuilder();
>         try ( BufferedReader br =
>         new BufferedReader( new FileReader( filename ) ) ) {
>             while ( br.ready() ) {
>                 content.append( br.readLine() ).append( System.lineSeparator() );
>             }
>         } catch ( IOException e ) {
>             return "Error reading File " + filename;
>         }
>         return content.toString();
>     }
> 
>     public static void main( String[] args ) {
>         try { // if argument count < 3 or non-parsable content => exception
>             new TextFrame( args[0], Integer.parseInt( args[1] ),
>             Integer.parseInt( args[2] ) );
>         } catch ( Exception e ) {
>             System.out
>             .println( "Please use: TextFrame <filename> <width> <height>\n" +
>             "with an existing (relative or absolute) filename and\n" +
>             "integer values for width and height." );
>         }
>     }
> 
> }
> ```

## Meine Notizen

