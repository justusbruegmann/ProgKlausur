---
tags: ["typ/uebung", "thema/events", "kategorie/gui", "semester/2", "schwierigkeit/3", "hat/musterloesung"]
aliases: ["ShellGame"]
thema: "[[23 Events]]"
klasse: "ShellGame"
package: "de.dhbwka.java.exercise.ui.event"
schwierigkeit: 3
status: "offen"
---

# Ü23 Hütchenspiel

**Thema:** [[23 Events]] · **Bereich:** Grafische Benutzeroberflächen (UI), Events (2) · **Schwierigkeit:** ★★★☆☆
**Klasse:** `ShellGame` · **Package:** `de.dhbwka.java.exercise.ui.event`

📄 Aufgabe: [[Material/Aufgaben/23_Events_Aufgaben-2.pdf#page=5|23_Events_Aufgaben-2.pdf, S. 5]]
✅ Musterlösung: [[Material/Aufgaben/23_Events_Aufgaben-2_Muster.pdf#page=8|23_Events_Aufgaben-2_Muster.pdf, S. 8]]

> [!question] Kurz gesagt
> Schreiben Sie eine Java-Applikation, die das bekannte Hütchenspiel („shell game“) implementiert! Beim Hütchenspiel gibt es drei Hütchen.

## Aufgabenstellung
```text
Schreiben Sie eine Java-Applikation, die das bekannte Hütchenspiel („shell game“) implementiert!

Beim Hütchenspiel gibt es drei Hütchen. Unter einem der Hütchen liegt eine Kugel.
Der Spieler muss erraten, unter welchem Hütchen die Kugel liegt.

Die drei Hütchen sollen in der Java-Applikation durch drei Buttons realisiert werden. Bei jedem
Spielzug wird zufällig die Kugel unter ein Hütchen gelegt.

Wurde ein Hütchen-Button angeklickt, so bekommt der Spieler in einem Textfeld angezeigt, ob
er richtig geraten hat und wie viele Versuche er bisher hatte. Hat er richtig geraten wird die Anzahl
der Versuche und der Name des Spielers in ein Ergebnisfile angehängt.

Eine mögliche grafische Oberfläche zu diesem Hütchenspiel sieht wie folgt aus:

Der Benutzer muss folgendes über der Oberfläche tun können:
    • Spielername eingeben
    • Anklicken von drei Buttons, die die Hütchen realisieren.
       Nach jedem Spielzug (Aufdecken eines Hütchens) wird die Kugel zufällig unter einem
       Hütchen verteilt.
       Verwenden Sie dazu z.B. eine zufällige erzeugte Integer-Zahl zwischen 1 und 3!
    • Ein Button zum Beenden der Applikation.

Im Ausgabefeld muss stehen:
    • Wie viele Versuche bisher gemacht wurden.
    • Ob das richtige Hütchen getippt wurde oder nicht.
    • Wurde richtig getippt, muss an eine Ergebnisdatei der Name des Spielers und die Anzahl der
       Versuche angehängt werden.

Zusatzaufgabe:
Erweitern Sie die Applikation um einen Button „Statistics“. Bei Anklicken des Buttons soll das
Ergebnisfile gelesen werden. Aus dem Ergebnisfile soll der Durchschnitt der bisherigen Versuche
ermittelt und ins Ausgabefeld ausgegeben werden.
```

## Benötigte Begriffe
[[Konstante]] · [[Zufallszahlen]] · [[while-Schleife]] · [[for-Schleife]] · [[Array]] · [[Konstruktor]] · [[this]] · [[static]] · [[toString]] · [[Kapselung]] · [[Überschreiben]] · [[super]] · [[Anonyme innere Klasse]] · [[String]] · [[Wrapperklasse]] · [[Exception]] · [[try-with-resources]] · [[Reader und Writer]] · [[BufferedReader und BufferedWriter]] · [[PrintWriter]] · [[Swing]] · [[JFrame]] · [[JPanel]] · [[Swing-Komponenten]] · [[Layoutmanager]] · [[Listener]]

## Weitere Übungen zum Thema
[[Ü23 Währungsumrechner (2)]] · [[Ü23 Body-Mass-Index (BMI)]] · [[Ü23 Binäre Zahlen]] · [[Ü23 Zahlenraten (2)]] · [[Ü23 Editor]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.ui.event;
> 
> import java.awt.GridLayout;
> import java.awt.event.ActionEvent;
> import java.awt.event.ActionListener;
> import java.io.BufferedReader;
> import java.io.FileReader;
> import java.io.FileWriter;
> import java.io.IOException;
> import java.io.PrintWriter;
> import java.util.Random;
> 
> import javax.swing.JButton;
> import javax.swing.JFrame;
> import javax.swing.JLabel;
> import javax.swing.JPanel;
> import javax.swing.JTextField;
> 
> @SuppressWarnings( "serial" )
> public class ShellGame extends JFrame {
> 
>     private final static int LIMIT = 3; // Number of Buttons
>     private final static String STATS_FILENAME = "shellstats.txt";
> 
>     private final Random rnd = new Random();
> 
>     private int shell;
>     private int attempts = 0;
>     private JButton[] shellButtons;
>     private JButton btnExit = new JButton( "Exit" );
>     private JButton btnStat = new JButton( "Statistics" );
>     private JTextField txtName = new JTextField( "Name", 20 );
>     private JTextField txtOutput = new JTextField( 30 );
> 
>     // Continued on next page
> 
>     Aufgaben Events (2)                           Musterlösung                        8 / 11
> 
>     /**
>      * Create shell game
>      */
>     public ShellGame() {
>         super( "Shell Game" );
>         this.setLayout( new GridLayout( 4, 1 ) );
> 
>         JPanel panName = new JPanel();
>         JPanel panShell = new JPanel();
>         JPanel panFunction = new JPanel();
>         JPanel panOutput = new JPanel();
> 
>         panName.add( new JLabel( "Player Name" ) );
>         panName.add( this.txtName );
> 
>         this.shellButtons = new JButton[ShellGame.LIMIT];
>         for ( int i = 0; i < ShellGame.LIMIT; i++ ) {
>             JButton btnShell = new JButton( "Shell " + (i + 1) );
>             btnShell.setActionCommand( Integer.toString( i + 1 ) );
>             this.shellButtons[i] = btnShell;
>             panShell.add( btnShell );
>         }
> 
>         panOutput.add( this.btnStat );
>         panOutput.add( this.btnExit );
> 
>         panFunction.add( this.txtOutput );
> 
>         this.add( panName );
>         this.add( panShell );
>         this.add( panOutput );
>         this.add( panFunction );
> 
>         this.initEventHandling();
> 
>         this.shell = this.getRandomShell();
> 
>         this.setSize( 400, 300 );
>         this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
>         this.setVisible( true );
>     }
> 
>     /**
>      * Add event handling to buttons
>      */
>     public void initEventHandling() {
>         // Statistics
>         this.btnStat.addActionListener( new ActionListener() {
>             @Override
>             public void actionPerformed( ActionEvent event ) {
>                 ShellGame.this.showStats();
>             }
>         } );
> 
>         // Continued on next page
> 
>         Aufgaben Events (2)                           Musterlösung           9 / 11
> 
>         // Exit
>         this.btnExit.addActionListener( new ActionListener() {
>             @Override
>             public void actionPerformed( ActionEvent event ) {
>                 System.exit( 0 );
>             }
>         } );
> 
>         // Shell-Listener for all Shell Buttons
>         ActionListener shellListener = new ActionListener() {
>             @Override
>             public void actionPerformed( ActionEvent event ) {
>                 // Get Shell Number by ActionCommand
>                 ShellGame.this
>                 .revealShell( Integer.parseInt( event.getActionCommand() ) );
>             }
>         };
>         for ( JButton b : this.shellButtons ) {
>             b.addActionListener( shellListener );
>         }
>     }
> 
>     /**
>      * Reveal a shell
>      */
>     public void revealShell( int tip ) {
>         this.attempts++;
>         if ( tip == this.shell ) {
>             this.txtOutput.setText( "Attempt " + this.attempts
>             + " wins: Ball was below shell " + this.shell );
>             this.saveStats();
>             this.attempts = 0;
>         } else {
>             this.txtOutput.setText( "Attempt " + this.attempts
>             + " fails: Ball was below shell " + this.shell );
>         }
>         this.shell = this.getRandomShell();
>     }
>     /**
>      * Show statistics from stats file
>      */
>     private void showStats() {
>         try ( BufferedReader in =
>         new BufferedReader( new FileReader( ShellGame.STATS_FILENAME ) ) ) {
>             int count = 0;
>             float sum = 0;
>             while ( in.ready() ) {
>                 try {
>                     sum += Integer.parseInt( in.readLine().split( ";" )[1] );
>                     count++;
>                 } catch ( Exception e ) {
>                 }
>             }
>             this.txtOutput.setText( "Success after " + sum / count + " attempts!" );
>         } catch ( IOException eee ) {
>         }
>     }
> 
>     Aufgaben Events (2)                           Musterlösung                      10 / 11
> 
>     /**
>      * Add statistics to stats file
>      */
>     private void saveStats() {
>         try ( PrintWriter f = new PrintWriter(
>         new FileWriter( ShellGame.STATS_FILENAME, true ) ) ) {
>             f.println( this.txtName.getText() + ";" + this.attempts );
>         } catch ( IOException e ) {
>         }
>     }
> 
>     /**
>      * Gets a random number for shell from 1..LIMIT
>      */
>     private int getRandomShell() {
>         return this.rnd.nextInt( ShellGame.LIMIT ) + 1;
>     }
> 
>     public static void main( String args[] ) {
>         new ShellGame();
>     }
> }
> 
> Aufgaben Events (2)                           Musterlösung               11 / 11
> ```

## Meine Notizen

