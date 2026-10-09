---
tags: ["typ/uebung", "thema/threads", "kategorie/nebenlaeufigkeit", "semester/2", "hat/musterloesung"]
aliases: ["DancingText"]
thema: "[[27 Threads]]"
klasse: "DancingText"
package: "de.dhbwka.java.exercise.threads"
status: "offen"
---

# Ü27 Tanzende Schrift

**Thema:** [[27 Threads]] · **Bereich:** Threads (1) · **Schwierigkeit:** –
**Klasse:** `DancingText` · **Package:** `de.dhbwka.java.exercise.threads`

📄 Aufgabe: [[Material/Aufgaben/27_Threads_Aufgaben-1.pdf#page=1|27_Threads_Aufgaben-1.pdf, S. 1]]
✅ Musterlösung: [[Material/Aufgaben/27_Threads_Aufgaben-1_Muster.pdf#page=1|27_Threads_Aufgaben-1_Muster.pdf, S. 1]]

> [!question] Kurz gesagt
> Schreiben Sie eine Java-Applikation DancingText, welche die Buchstaben ihres Namens oder eine andere, beliebige Zeichenkette in verschiedenen Farben „tanzen“ lässt. Gesteuert durch einen Thread sollen die Buchstaben ihre Lage und ihre Farbe zyklisch verändern.

## Aufgabenstellung
```text
Schreiben Sie eine Java-Applikation DancingText, welche die Buchstaben ihres Namens oder eine
andere, beliebige Zeichenkette in verschiedenen Farben „tanzen“ lässt.
Gesteuert durch einen Thread sollen die Buchstaben ihre Lage und ihre Farbe zyklisch verändern.

Hinweise:
• Lassen Sie Ihrer Phantasie freien Lauf! Neben zufälligen Sprüngen kann man z.B. auch Wellen
   oder Zickzackmuster erzeugen, nur Rot-Töne oder Regenbogenfarben verwenden, etc.
• Veranlassen sie in der Methode run() das erneute Zeichnen der Komponente mit repaint().
```

## Benötigte Begriffe
[[Konstante]] · [[Zufallszahlen]] · [[while-Schleife]] · [[for-Schleife]] · [[this]] · [[static]] · [[Kapselung]] · [[Überschreiben]] · [[super]] · [[Interface]] · [[String]] · [[Exception]] · [[Swing]] · [[JFrame]] · [[JPanel]] · [[Farben und Schriften]] · [[Zeichnen mit Graphics]] · [[Thread]] · [[Runnable]]

## Weitere Übungen zum Thema
[[Ü27 Ampel]] · [[Ü27 Synchronisation]] · [[Ü27 Suchmaschine]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.threads;
> 
> import java.awt.Color;
> import java.awt.Font;
> import java.awt.Graphics;
> import java.util.Random;
> 
> import javax.swing.JComponent;
> import javax.swing.JFrame;
> 
> @SuppressWarnings( "serial" )
> public class DancingText extends JComponent implements Runnable {
> 
>     private final static int XBASE = 30;
>     private final static int XSTEP = 36;
>     private final static int YBASE = 150;
>     private final static Random RANDOM = new Random();
> 
>     private String text;
>     private final long delay;
> 
>     private int colR = 0; // Color-Channel: red
>     private int colG = 90; // Color-Channel: green
>     private int colB = 180; // Color-Channel: blue
>     private int yOffset = 0;
> 
>     public DancingText( String text, long delay ) {
>         this.text = text;
>         this.delay = delay;
>         new Thread( this ).start(); // Start Thread
>     }
> 
>     // Continued on next page
> 
>     /**
>      * Paint dancing text on Graphics
>      *
>      * @param g
>      *            graphics to use
>      */
>     @Override
>     public void paintComponent( Graphics g ) {
>         super.paintComponent( g );
>         g.setFont( new Font( "Helvetica", Font.BOLD, 48 ) );
>         for ( int i = 0; i < this.text.length(); i++ ) {
>             char c = this.text.charAt( i );
> 
>             this.colR = (this.colR + 4 + DancingText.RANDOM.nextInt( 4 )) % 256;
>             this.colG = (this.colG + 4 + DancingText.RANDOM.nextInt( 4 )) % 256;
>             this.colB = (this.colB + 4 + DancingText.RANDOM.nextInt( 4 )) % 256;
> 
>             this.yOffset = DancingText.RANDOM.nextInt( 30 );
> 
>             g.setColor( new Color( this.colR, this.colG, this.colB ) );
>             g.drawString( "" + c, DancingText.XBASE + i * DancingText.XSTEP,
>             DancingText.YBASE - this.yOffset );
>         }
>     }
> 
>     @Override
>     public void run() {
>         while ( true ) {
>             // Repaint and wait for delay
>             this.repaint();
>             try {
>                 Thread.sleep( this.delay );
>             } catch ( InterruptedException e ) {
>                 System.err.println( "Interrupted!" );
>             }
>         }
>     }
> 
>     public static void main( String[] args ) {
>         // Create frame and add DancingText component
>         JFrame f = new JFrame( "Dancing Text" );
>         f.add( new DancingText( "Dancing Text :-)", 200 ) );
>         f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
>         f.setSize( 640, 280 );
>         f.setVisible( true );
>     }
> 
> }
> ```

## Meine Notizen

