---
tags: ["typ/uebung", "thema/swing", "kategorie/gui", "semester/2", "schwierigkeit/2", "hat/musterloesung"]
aliases: ["TextfileViewer"]
thema: "[[20 Grafische Oberflächen mit Swing]]"
klasse: "TextfileViewer"
package: "de.dhbwka.java.exercise.ui"
schwierigkeit: 2
status: "offen"
---

# Ü20 Datei auswählen und zeilenweise darstellen

**Thema:** [[20 Grafische Oberflächen mit Swing]] · **Bereich:** Grafische Benutzeroberflächen (GUI/Swing) (2) · **Schwierigkeit:** ★★☆☆☆
**Klasse:** `TextfileViewer` · **Package:** `de.dhbwka.java.exercise.ui`

📄 Aufgabe: [[Material/Aufgaben/20_Swing_Aufgaben-2.pdf#page=1|20_Swing_Aufgaben-2.pdf, S. 1]]
✅ Musterlösung: [[Material/Aufgaben/20_Swing_Aufgaben-2_Muster.pdf#page=1|20_Swing_Aufgaben-2_Muster.pdf, S. 1]]

> [!question] Kurz gesagt
> Entwickeln Sie auf Basis der Klasse JFileChooserDemo (s. Folien) eine Anwendung TextfileViewer, die zunächst eine Dateiauswahlbox anzeigt und anschließend (sofern eine Datei ausgewählt wurde) diese zeilenweise einliest.

## Aufgabenstellung
```text
Entwickeln Sie auf Basis der Klasse JFileChooserDemo (s. Folien) eine Anwendung
TextfileViewer, die zunächst eine Dateiauswahlbox anzeigt und anschließend (sofern eine
Datei ausgewählt wurde) diese zeilenweise einliest.

Stellen Sie in einer ersten Darstellungsvariante den Dateiinhalt in einem neuen Fenster (JFrame)
zeilenweise untereinander in Form von JLabels dar. Verwenden Sie dabei innerhalb des JFrame
ein GridLayout. Zur Vereinfachung sollen hier nur die ersten (maximal 10) Zeilen dargestellt
werden.
Ersetzen Sie in einer zweiten Darstellungsvariante ohne Beschränkung der Zeilenanzahl die Anzeige
durch ein JTextArea. Wenn die Inhalte zu groß für die Anzeige im Fenster werden, soll ein
Scrollbalken (JScrollPane) erscheinen.
```

## Benötigte Begriffe
[[Konstante]] · [[Math-Klasse]] · [[while-Schleife]] · [[for-Schleife]] · [[Array]] · [[static]] · [[toString]] · [[Kapselung]] · [[Überschreiben]] · [[Anonyme innere Klasse]] · [[String]] · [[StringBuilder und StringBuffer]] · [[Exception]] · [[try-with-resources]] · [[Reader und Writer]] · [[BufferedReader und BufferedWriter]] · [[Datei und Pfad]] · [[Swing]] · [[JFrame]] · [[Swing-Komponenten]] · [[Layoutmanager]] · [[Dialoge]]

## Weitere Übungen zum Thema
[[Ü20 Swing-Grundkomponenten]] · [[Ü20 Frame mit Text]] · [[Ü20 Währungsumrechner]] · [[Ü20 Editor]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> Variante 1 (Labels)
> 
> package de.dhbwka.java.exercise.ui;
> 
> import java.awt.GridLayout;
> import java.io.BufferedReader;
> import java.io.File;
> import java.io.FileReader;
> import java.io.IOException;
> 
> import javax.swing.JFileChooser;
> import javax.swing.JFrame;
> import javax.swing.JLabel;
> import javax.swing.JOptionPane;
> import javax.swing.filechooser.FileFilter;
> 
> public class TextfileViewer {
> 
>     private static final int MAX_LINES = 10;
> 
>     public TextfileViewer( File file ) {
>         JFrame frame = new JFrame( file.getName() );
>         String[] content = TextfileViewer.readTextfile( file );
> 
>         final int displayLines =
>         Math.min( content.length, TextfileViewer.MAX_LINES );
> 
>         frame.setLayout( new GridLayout( displayLines, 1 ) );
>         for ( int i = 0; i < displayLines; i++ ) {
>             frame.add( new JLabel( content[i] ) );
>         }
> 
>         frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
>         frame.setSize( 640, 480 );
>         frame.setVisible( true );
>     }
> 
>     // Continued on next page
> 
>     /**
>      * Read text file and return its content as an string array
>      *
>      * @param f
>      *            text file
>      * @return content as string array
>      */
>     public static String[] readTextfile( File f ) {
>         // Count lines first (remember: arrays => fix length!)
>         int lines = 0;
>         try ( BufferedReader br = new BufferedReader( new FileReader( f ) ) ) {
>             while ( br.ready() ) {
>                 br.readLine();
>                 lines++;
>             }
>         } catch ( IOException e ) {
>             e.printStackTrace(); // TODO: nice error handling
>         }
> 
>         // Create array with count of lines as length
>         String[] result = new String[lines];
>         lines = 0;
>         try ( BufferedReader br = new BufferedReader( new FileReader( f ) ) ) {
>             while ( br.ready() ) {
>                 result[lines++] = br.readLine();
>             }
>         } catch ( IOException e ) {
>             e.printStackTrace(); // TODO: nice error handling
>         }
> 
>         return result;
>     }
> 
>     public static void main( String[] args ) {
>         // FileChooser as presented in slides "Swing"
>         JFileChooser fc = new JFileChooser();
>         fc.setFileFilter( new FileFilter() {
>             @Override
>             public boolean accept( File f ) {
>                 return f.isDirectory()
>                 || f.getName().toLowerCase().endsWith( ".txt" );
>             }
> 
>             @Override
>             public String getDescription() {
>                 return "Text files (*.txt)";
>             }
>         } );
> 
>         int state = fc.showOpenDialog( null );
>         if ( state == JFileChooser.APPROVE_OPTION ) {
>             new TextfileViewer( fc.getSelectedFile() );
>         } else {
>             JOptionPane.showMessageDialog( null, "Choice cancelled" );
>         }
>     }
> }
> 
> Variante 2 (TextArea)
> 
> package de.dhbwka.java.exercise.ui;
> 
> import java.awt.BorderLayout;
> import java.io.File;
> 
> import javax.swing.JFileChooser;
> import javax.swing.JFrame;
> import javax.swing.JOptionPane;
> import javax.swing.JScrollPane;
> import javax.swing.JTextArea;
> import javax.swing.filechooser.FileFilter;
> 
> public class TextfileViewer2 {
> 
>     public TextfileViewer2( File file ) {
>         JFrame frame = new JFrame( file.getName() );
> 
>         StringBuilder joinedContent = new StringBuilder();
>         for ( String s : TextfileViewer.readTextfile( file ) ) {
>             joinedContent.append( s ).append( System.lineSeparator() );
>         }
> 
>         JScrollPane scrollpane =
>         new JScrollPane( new JTextArea( joinedContent.toString() ) );
> 
>         // remember: default layout for frame content border layout
>         frame.add( scrollpane, BorderLayout.CENTER );
>         frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
>         frame.setSize( 640, 480 );
>         frame.setVisible( true );
>     }
> 
>     // Continued on next page
> 
>     public static void main( String[] args ) {
>         // FileChooser as presented in slides "Swing"
>         JFileChooser fc = new JFileChooser();
>         fc.setFileFilter( new FileFilter() {
>             @Override
>             public boolean accept( File f ) {
>                 return f.isDirectory()
>                 || f.getName().toLowerCase().endsWith( ".txt" );
>             }
> 
>             @Override
>             public String getDescription() {
>                 return "Text files (*.txt)";
>             }
>         } );
> 
>         int state = fc.showOpenDialog( null );
>         if ( state == JFileChooser.APPROVE_OPTION ) {
>             new TextfileViewer2( fc.getSelectedFile() );
>         } else {
>             JOptionPane.showMessageDialog( null, "Choice cancelled" );
>         }
>     }
> 
> }
> ```

## Meine Notizen

