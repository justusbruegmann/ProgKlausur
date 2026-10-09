---
tags: ["typ/uebung", "thema/java8", "kategorie/funktional", "semester/2", "schwierigkeit/2", "hat/musterloesung"]
aliases: ["NumberGuessJava8"]
thema: "[[33 Java 8 – Lambdas, Streams, NIO.2]]"
klasse: "NumberGuessJava8"
package: "de.dhbwka.java.exercise.java8"
schwierigkeit: 2
status: "offen"
---

# Ü33 Zahlenraten (3)

**Thema:** [[33 Java 8 – Lambdas, Streams, NIO.2]] · **Bereich:** Java 8 · **Schwierigkeit:** ★★☆☆☆
**Klasse:** `NumberGuessJava8` · **Package:** `de.dhbwka.java.exercise.java8`

📄 Aufgabe: [[Material/Aufgaben/33_Java8_Aufgaben.pdf#page=3|33_Java8_Aufgaben.pdf, S. 3]]
✅ Musterlösung: [[Material/Aufgaben/33_Java8_Aufgaben_Muster.pdf#page=9|33_Java8_Aufgaben_Muster.pdf, S. 9]]

> [!question] Kurz gesagt
> Nehmen Sie die Musterlösung zur Aufgabe Zahlenraten (siehe Musterlösung zu Events (1)) und nutzen Sie die neuen Features von Java 8:  Ersetzen Sie die explizit erstellten, anonymen ActionListener-Instanzen durch die Schreibweise mit Lambda-Ausdrücken  Verändern Sie die Methode showBestPlayer so, dass der beste Spieler mittels Streaming- API ermittelt wird. Nutzen Sie ebenfalls …

## Aufgabenstellung
```text
Nehmen Sie die Musterlösung zur Aufgabe Zahlenraten (siehe Musterlösung zu Events (1)) und
nutzen Sie die neuen Features von Java 8:

        Ersetzen Sie die explizit erstellten, anonymen ActionListener-Instanzen durch die
         Schreibweise mit Lambda-Ausdrücken

        Verändern Sie die Methode showBestPlayer so, dass der beste Spieler mittels Streaming-
         API ermittelt wird. Nutzen Sie ebenfalls java.nio.file.Files für das Einlesen der
         Highscore-Datei!

        Überlegen Sie, wie das Hinzufügen der Buttons zum Panel
           panButtons.add( this.btnNew );
           panButtons.add( this.btnOk );
           panButtons.add( this.btnStat );
           panButtons.add( this.btnExit );

         und der verschiedenen Panels zum Frame
           this.add( panName );
           this.add( panNumberinput );
           this.add( panButtons );
           this.add( panOutput );

         eventuell kompakter gelöst werden könnte

        Seien Sie kreativ! Finden Sie weitere Möglichkeiten die neuen Features zu Nutzen
```

## Benötigte Begriffe
[[Überlauf und Zweierkomplement]] · [[Typkonversion]] · [[Formatierte Ausgabe]] · [[Zufallszahlen]] · [[Array]] · [[Konstruktor]] · [[this]] · [[Kapselung]] · [[super]] · [[Innere Klasse]] · [[Wrapperklasse]] · [[Exception]] · [[RuntimeException]] · [[try-with-resources]] · [[Reader und Writer]] · [[Datei und Pfad]] · [[Swing]] · [[JFrame]] · [[JPanel]] · [[Swing-Komponenten]] · [[Layoutmanager]] · [[Listener]] · [[Lambda-Ausdruck]] · [[Funktionales Interface]] · [[Methodenreferenz]] · [[Stream-API]] · [[Optional]]

## Weitere Übungen zum Thema
[[Ü33 Arbeiten mit Streams]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.java8;
> 
> import java.awt.GridLayout;
> import java.awt.event.ActionEvent;
> import java.io.FileWriter;
> import java.nio.file.Files;
> import java.nio.file.Paths;
> import java.util.Optional;
> import java.util.StringTokenizer;
> import java.util.function.Consumer;
> import java.util.stream.Stream;
> 
> import javax.swing.JButton;
> import javax.swing.JFrame;
> import javax.swing.JLabel;
> import javax.swing.JPanel;
> import javax.swing.JTextField;
> 
> @SuppressWarnings( "serial" )
> public class NumberGuessJava8 extends JFrame {
> 
>     private int numberToGuess;
>     private int countAttempts;
>     private int limit = 1000;
> 
>     private JButton btnExit = new JButton( "Exit" );
>     private JButton btnOk = new JButton( "OK" );
>     private JButton btnNew = new JButton( "New Game" );
>     private JButton btnStat = new JButton( "Best Player" );
>     private JTextField txtName = new JTextField( "Name", 20 );
> 
>     private JTextField txtGuess = new JTextField( 10 );
>     private JTextField txtOutput = new JTextField( 40 );
> 
>     private String statFileName = "stat.txt";
> 
>     // continued on next page
> 
>     Aufgaben Java 8                               Musterlösung                              9 / 13
> 
>     public NumberGuessJava8() {
>         super( "Number Guessing Game" );
> 
>         JPanel panName = new JPanel();
>         JPanel panNumberinput = new JPanel();
>         JPanel panButtons = new JPanel();
>         JPanel panOutput = new JPanel();
> 
>         panName.add( new JLabel( "Player Name" ) );
>         panName.add( this.txtName );
> 
>         panNumberinput.add(
>         new JLabel( "Enter number beween 1 and " + this.limit ) );
>         panNumberinput.add( this.txtGuess );
> 
>         // add all four buttons by streaming
>         // and invoke panButtons.add for all of them
>         Stream.of( this.btnNew, this.btnOk, this.btnStat, this.btnExit )
>         .forEach( panButtons::add );
> 
>         panOutput.add( this.txtOutput );
> 
>         this.setLayout( new GridLayout( 4, 1 ) );
> 
>         // add all four panels by streaming
>         // and invoke this.add for all of them
>         Stream.of( panName, panNumberinput, panButtons, panOutput )
>         .forEach( this::add );
> 
>         this.addEventHandling();
>         this.createRandomNumber();
> 
>         this.setSize( 500, 250 );
>         this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
>         this.setVisible( true );
>     }
> 
>     /**
>      * Add event handling and use lambda expressions to do so
>      */
>     public void addEventHandling() {
>         this.btnNew.addActionListener( e -> this.createRandomNumber() );
>         this.btnExit.addActionListener( e -> System.exit( 0 ) );
> 
>         // okActionListener matches signature of ActionListener#actionPerformed
>         this.txtGuess.addActionListener( this::okActionListener );
>         this.btnOk.addActionListener( this::okActionListener );
> 
>         this.btnStat.addActionListener( e -> this.showBestPlayer() );
>     }
> 
>     // continued on next page
> 
>     Aufgaben Java 8                               Musterlösung                        10 / 13
> 
>     public void okActionListener( ActionEvent event ) {
>         try {
>             int guess = Integer.parseInt( this.txtGuess.getText() );
>             this.countAttempts++;
>             this.txtGuess.setText( "" );
> 
>             // since all texts for output are being constructed from
>             // this.countAttempts and guess, for correct inputs,
>             // it is possible to define a consumer which just takes
>             // the string to pass to String.format and then sets the
>             // correct text for this.txtOutput
>             Consumer<String> outputSetter = s -> {
>                 this.txtOutput
>                 .setText( String.format( s, this.countAttempts, guess ) );
>             };
> 
>             if ( guess > this.numberToGuess ) {
>                 outputSetter.accept( "Attempt #%s: %s => too big!" );
>             }
> 
>             else if ( guess < this.numberToGuess ) {
>                 outputSetter.accept( "Attempt #%s: %s => too small!" );
>             }
> 
>             else {
>                 outputSetter.accept( "Attempt #%s: %s => correct!!! New Game!" );
>                 this.writeStatFile();
>                 this.createRandomNumber();
>             }
>         } catch ( NumberFormatException nfe ) {
>             this.txtOutput.setText( "Bad input!" );
>         }
>     }
> 
>     private void writeStatFile() {
>         try ( FileWriter f = new FileWriter( this.statFileName, true ) ) {
>             String name = this.txtName.getText();
>             f.write( name + " " + this.countAttempts + " attempts\n" );
>         } catch ( Exception e ) {
>         }
>     }
> 
>     // continued on next page
> 
>     Aufgaben Java 8                               Musterlösung                        11 / 13
> 
>     /**
>      * Show best player and use NIO + streaming to find minimum attempts
>      */
>     private void showBestPlayer() {
>         try {
>             Optional<PlayerHelper> bestPlayer =
>             // read all lines as list
>             Files.readAllLines( Paths.get( this.statFileName ) )
>             // stream this list of strings
>             .stream()
>             // Convert string line to player helper object,
>             .map( PlayerHelper::new )
>             // Stream now contains these helper object items,
>             // no longer strings!
>             // => Find minimum attempts by comparing
>             .min( ( a, b ) -> Integer.compare( a.getAttempts(),
>             b.getAttempts() ) );
> 
>             if ( bestPlayer.isPresent() ) {
>                 PlayerHelper player = bestPlayer.get();
>                 this.txtOutput
>                 .setText( "Best Player: " + player.getName() + ",    "
>                 + player.getAttempts() + " attempts" );
>             }
> 
>         } catch ( Exception ex ) {
>         }
>     }
> 
>     private void createRandomNumber() {
>         this.txtGuess.setText( "" );
>         this.txtOutput.setText( "New Game!" );
>         this.numberToGuess = (int) (Math.random() * this.limit + 1);
>         this.countAttempts = 0;
> 
>         // For debugging purposes
>         System.out.println( "Number to guess: " + this.numberToGuess );
>     }
> 
>     public static void main( String args[] ) {
>         new NumberGuessJava8();
>     }
> 
>     // continued on next page
> 
>     Aufgaben Java 8                               Musterlösung                    12 / 13
> 
>     /**
>      * Helper class to store name and points separately to better utilize
>      * streaming features
>      */
>     private class PlayerHelper {
> 
>         private String name;
> 
>         private int attempts = Integer.MAX_VALUE;
> 
>         public PlayerHelper( String line ) {
>             StringTokenizer st = new StringTokenizer( line );
>             this.name = st.nextToken();
>             try {
>                 this.attempts = Integer.parseInt( st.nextToken() );
>             } catch ( Exception e ) {
>             }
>         }
> 
>         public int getAttempts() {
>             return this.attempts;
>         }
> 
>         public String getName() {
>             return this.name;
>         }
>     }
> }
> 
> Aufgaben Java 8                               Musterlösung                  13 / 13
> ```

## Meine Notizen

