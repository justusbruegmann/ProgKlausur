---
tags: ["typ/uebung", "thema/events", "kategorie/gui", "semester/2", "schwierigkeit/3", "hat/musterloesung"]
aliases: ["NumberGuess"]
thema: "[[23 Events]]"
klasse: "NumberGuess"
package: "de.dhbwka.java.exercise.ui.event"
schwierigkeit: 3
status: "offen"
---

# Ü23 Zahlenraten (2)

**Thema:** [[23 Events]] · **Bereich:** Grafische Benutzeroberflächen (UI), Events (1) · **Schwierigkeit:** ★★★☆☆
**Klasse:** `NumberGuess` · **Package:** `de.dhbwka.java.exercise.ui.event`

📄 Aufgabe: [[Material/Aufgaben/23_Events_Aufgaben-1.pdf#page=4|23_Events_Aufgaben-1.pdf, S. 4]]
✅ Musterlösung: [[Material/Aufgaben/23_Events_Aufgaben-1_Muster.pdf#page=8|23_Events_Aufgaben-1_Muster.pdf, S. 8]]

> [!question] Kurz gesagt
> Schreiben Sie eine Java-Applikation, die ein Ratespiel implementiert. Bei diesem Ratespiel muss der Benutzer eine zufällig erzeugte Zahl zwischen 1 und 1000 erraten.

## Aufgabenstellung
```text
Schreiben Sie eine Java-Applikation, die ein Ratespiel implementiert. Bei diesem Ratespiel muss der
Benutzer eine zufällig erzeugte Zahl zwischen 1 und 1000 erraten. Als Hinweis bekommt er
angezeigt, ob er zu hoch oder zu niedrig getippt hat. Die Anzahl der Versuche, die er benötigt, wird
mitgezählt. Wenn er die Zahl erraten hat, werden sein Name und die Anzahl der Versuche an eine
Ergebnisdatei angehängt. Eine mögliche grafische Oberfläche zu diesem Ratespiel sieht wie folgt
aus:

Der Benutzer muss folgendes über der Oberfläche eingeben können:
    • Spielername
    • Nächste getippte Zahl
    • Zwei Buttons zum Erzeugen eines neuen Spiels und zum Beenden der Applikation.
    • Die Prüfung, ob die aktuelle Eingabe höher, niedriger oder gleich der gesuchten Zahl ist, soll
       entweder über einen „OK“-Button oder durch ein Return im Textfeld erfolgen. (Eine der
       beiden Lösungen ist zu realisieren).

Im Ausgabefeld muss stehen:
    • Ob der Tipp zu hoch, zu niedrig oder richtig war.
    • Wie viele Versuche bisher gemacht wurden.

Wurde richtig getippt, muss an eine Ergebnisdatei der Name des Spielers und die Anzahl der
Versuche angehängt werden.

Hinweis: Siehe auch die Aufgabe „Zahlenraten“ des Aufgabenblatts „Kontrollstrukturen“, bei der die
Ein-/Ausgabe über das Konsolenfenster erfolgt.

Zusatzaufgabe:
Erweitern Sie die Applikation um einen Button „Best Player“. Bei Anklicken des Buttons soll das
Ergebnisfile gelesen werden. Aus dem Ergebnisfile soll der bisher beste Spieler (d.h. der Spieler mit
den wenigsten Versuchen) ermittelt und im Ausgabefeld ausgegeben werden.
```

## Benötigte Begriffe
[[Überlauf und Zweierkomplement]] · [[Typkonversion]] · [[Formatierte Ausgabe]] · [[Zufallszahlen]] · [[while-Schleife]] · [[Array]] · [[Konstruktor]] · [[this]] · [[Kapselung]] · [[Überschreiben]] · [[super]] · [[Anonyme innere Klasse]] · [[Wrapperklasse]] · [[Exception]] · [[RuntimeException]] · [[try-with-resources]] · [[Reader und Writer]] · [[BufferedReader und BufferedWriter]] · [[Swing]] · [[JFrame]] · [[JPanel]] · [[Swing-Komponenten]] · [[Layoutmanager]] · [[Listener]]

## Gleiche Klasse in anderen Übungen (Fortsetzung/Variante)
[[Ü06 Zahlenraten]]

## Weitere Übungen zum Thema
[[Ü23 Währungsumrechner (2)]] · [[Ü23 Body-Mass-Index (BMI)]] · [[Ü23 Binäre Zahlen]] · [[Ü23 Editor]] · [[Ü23 Hütchenspiel]]

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
> import java.util.StringTokenizer;
> 
> import javax.swing.JButton;
> import javax.swing.JFrame;
> import javax.swing.JLabel;
> import javax.swing.JPanel;
> import javax.swing.JTextField;
> 
> @SuppressWarnings( "serial" )
> public class NumberGuess extends JFrame {
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
>     // Continued on next page
> 
>     Aufgaben Events (1)                           Musterlösung                         8 / 11
> 
>     public NumberGuess() {
>         super( "Number Guessing Game" );
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
>         panButtons.add( this.btnNew );
>         panButtons.add( this.btnOk );
>         panButtons.add( this.btnStat );
>         panButtons.add( this.btnExit );
> 
>         panOutput.add( this.txtOutput );
> 
>         this.setLayout( new GridLayout( 4, 1 ) );
>         this.add( panName );
>         this.add( panNumberinput );
>         this.add( panButtons );
>         this.add( panOutput );
> 
>         this.addEventHandling();
>         this.createRandomNumber();
> 
>         this.setSize( 500, 250 );
>         this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
>         this.setVisible( true );
>     }
>     public void addEventHandling() {
>         this.btnNew.addActionListener( new ActionListener() {
>             @Override
>             public void actionPerformed( ActionEvent event ) {
>                 NumberGuess.this.createRandomNumber();
>             }
>         } );
> 
>         this.btnExit.addActionListener( new ActionListener() {
>             @Override
>             public void actionPerformed( ActionEvent event ) {
>                 System.exit( 0 );
>             }
>         } );
> 
>         ActionListener okListener = new ActionListener() {
>             @Override
>             public void actionPerformed( ActionEvent event ) {
>                 NumberGuess.this.okActionListener( event );
>             }
>         };
>         this.txtGuess.addActionListener( okListener );
>         this.btnOk.addActionListener( okListener );
> 
>         Aufgaben Events (1)                           Musterlösung                 9 / 11
> 
>         this.btnStat.addActionListener( new ActionListener() {
>             @Override
>             public void actionPerformed( ActionEvent event ) {
>                 NumberGuess.this.showBestPlayer();
>             }
>         } );
>     }
> 
>     public void okActionListener( ActionEvent event ) {
>         try {
>             int guess = Integer.parseInt( this.txtGuess.getText() );
>             this.countAttempts++;
>             this.txtGuess.setText( "" );
>             if ( guess > this.numberToGuess ) {
>                 this.txtOutput.setText( String.format(
>                 "Attempt #%s: %s => too big!", this.countAttempts, guess ) );
>             }
> 
>             else if ( guess < this.numberToGuess ) {
>                 this.txtOutput.setText( String.format(
>                 "Attempt #%s: %s => too small!", this.countAttempts,
>                 guess ) );
>             }
> 
>             else {
>                 this.txtOutput.setText(
>                 String.format( "Attempt #%s: %s => correct!!! New Game!",
>                 this.countAttempts, guess ) );
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
>     // Continued on next page
> 
>     Aufgaben Events (1)                           Musterlösung                      10 / 11
> 
>     private void showBestPlayer() {
>         int minAttempts = Integer.MAX_VALUE;
>         String name = "";
>         try ( BufferedReader in =
>         new BufferedReader( new FileReader( this.statFileName ) ) ) {
> 
>             String line;
>             do {
>                 try {
>                     line = in.readLine();
>                     if ( line != null ) {
>                         StringTokenizer st = new StringTokenizer( line );
>                         String currLineName = st.nextToken();
>                         try {
>                             int currLinePoints = Integer.parseInt( st.nextToken() );
>                             if ( currLinePoints < minAttempts ) {
>                                 name = currLineName;
>                                 minAttempts = currLinePoints;
>                             }
>                         } catch ( Exception e ) {
>                         }
>                     }
>                 } catch ( IOException e ) {
>                     line = null;
>                 }
>             } while ( line != null );
> 
>             this.txtOutput.setText( "Best Player: " + name + ",   " + minAttempts
>             + " attempts" );
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
>         new NumberGuess();
>     }
> 
> }
> 
> Aufgaben Events (1)                           Musterlösung                          11 / 11
> ```

## Meine Notizen

