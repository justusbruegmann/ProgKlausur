---
tags: ["typ/uebung", "thema/events", "kategorie/gui", "semester/2", "schwierigkeit/2", "hat/musterloesung"]
aliases: ["BinaryNumber"]
thema: "[[23 Events]]"
klasse: "BinaryNumber"
package: "de.dhbwka.java.exercise.ui.event"
schwierigkeit: 2
status: "offen"
---

# Ü23 Binäre Zahlen

**Thema:** [[23 Events]] · **Bereich:** Grafische Benutzeroberflächen (UI), Events (1) · **Schwierigkeit:** ★★☆☆☆
**Klasse:** `BinaryNumber` · **Package:** `de.dhbwka.java.exercise.ui.event`

📄 Aufgabe: [[Material/Aufgaben/23_Events_Aufgaben-1.pdf#page=3|23_Events_Aufgaben-1.pdf, S. 3]]
✅ Musterlösung: [[Material/Aufgaben/23_Events_Aufgaben-1_Muster.pdf#page=6|23_Events_Aufgaben-1_Muster.pdf, S. 6]]
📦 Zusatzdateien: [icon-source.txt](<Material/Projekte/23_Events_Aufgaben-1_Icons/icon-source.txt>), [off.png](<Material/Projekte/23_Events_Aufgaben-1_Icons/off.png>), [on.png](<Material/Projekte/23_Events_Aufgaben-1_Icons/on.png>)

> [!question] Kurz gesagt
> Schreiben Sie zur Bestimmung des Dezimalwerts einer Binärzahl eine Benutzeroberfläche, welche das Setzen von 8 Bits ermöglicht. Nutzen Sie hierbei zum Setzen eines virtuellen Bits JToggleButtons.

## Aufgabenstellung
```text
Schreiben Sie zur Bestimmung des Dezimalwerts einer Binärzahl eine Benutzeroberfläche, welche
das Setzen von 8 Bits ermöglicht.
Nutzen Sie hierbei zum Setzen eines virtuellen Bits JToggleButtons. Ist der Button gedrückt, soll
das Bit für den Wert als gesetzt gelten.
Zur besseren optischen Veranschaulichung nutzen Sie die bereitgestellten Icons, um den Zustand
des jeweiligen JToggleButtons herauszuheben (siehe Hinweise). Beschriften Sie auch jeweils
unterhalb der JToggleButtons, welche 2-er Potenz das Bit repräsentiert.
Im unteren Bereich soll zusätzlich ein Label den aktuellen Dezimalwert anzeigen, der sich durch
Einstellen der virtuellen Bits ergibt. Selbstverständlich soll dieser Wert beim Drücken eines Buttons
aktualisiert werden.

Hinweise:
Kopieren Sie die Dateien on.png und off.png in Ihr Projektverzeichnis. (Eine Download-
Möglichkeit für diese Dateien finden Sie auf der Homepage der Vorlesung bei dieser
Aufgabenstellung.) Die Icons für die verschiedenen Zustände der JToggleButtons können Sie
wie folgt setzen (ImageIcon: Klasse im Package javax.swing)
ImageIcon imgOff = new ImageIcon("off.png");
ImageIcon imgOn = new ImageIcon("on.png");
toggleButton.setIcon(imgOff); // icon if not selected (default icon)
toggleButton.setSelectedIcon(imgOn); // icon if selected
Analog zu JRadioButton erbt auch JToggleButton die Methode boolean
isSelected() zur Bestimmung des Zustands (siehe Hinweise in BMI-Aufgabe).

Icon-Quelle: https://www.iconfinder.com/iconsets/essential-app-1
```

## Benötigte Begriffe
[[Typkonversion]] · [[Math-Klasse]] · [[for-Schleife]] · [[Konstruktor]] · [[this]] · [[toString]] · [[Kapselung]] · [[Vererbung]] · [[Überschreiben]] · [[super]] · [[Interface]] · [[Wrapperklasse]] · [[Datei und Pfad]] · [[Swing]] · [[JFrame]] · [[JPanel]] · [[Swing-Komponenten]] · [[Layoutmanager]] · [[Listener]]

## Weitere Übungen zum Thema
[[Ü23 Währungsumrechner (2)]] · [[Ü23 Body-Mass-Index (BMI)]] · [[Ü23 Zahlenraten (2)]] · [[Ü23 Editor]] · [[Ü23 Hütchenspiel]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.ui.event;
> 
> import java.awt.BorderLayout;
> import java.awt.GridLayout;
> import java.awt.event.ActionEvent;
> import java.awt.event.ActionListener;
> 
> import javax.swing.ImageIcon;
> import javax.swing.JFrame;
> import javax.swing.JLabel;
> import javax.swing.JPanel;
> import javax.swing.JToggleButton;
> import javax.swing.SwingConstants;
> import javax.swing.WindowConstants;
> 
> @SuppressWarnings( "serial" )
> public class BinaryNumber extends JFrame implements ActionListener {
> 
>     /**
>      * Label to display value
>      */
>     private JLabel lblValue = new JLabel( "0", JLabel.CENTER );
> 
>     /**
>      * Current value
>      */
>     private int value = 0;
> 
>     /**
>      * Create the binary number and init UI
>      */
>     public BinaryNumber() {
>         super( "Binary Number" );
>         this.setLayout( new BorderLayout( 5, 5 ) );
>         this.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
> 
>         final int countBits = 8;
>         JPanel panSwitches = new JPanel( new GridLayout( 2, countBits, 5, 5 ) );
> 
>         ImageIcon imgOff = new ImageIcon( "off.png" );
>         ImageIcon imgOn = new ImageIcon( "on.png" );
> 
>         Aufgaben Events (1)                           Musterlösung                          6 / 11
> 
>         // 1st row: buttons
>         for ( int i = countBits - 1; i >= 0; i-- ) {
>             JToggleButton btn = new JToggleButton();
>             int num = (int) Math.pow( 2, i ); // calculate value for JToggleButton
>             btn.setName( Integer.toString( num ) ); // and set value as name
> 
>             btn.setIcon( imgOff ); // icon if not selected
>             btn.setSelectedIcon( imgOn ); // icon if selected
> 
>             btn.addActionListener( this );
>             panSwitches.add( btn );
>         }
>         // 2nd row: labels
>         for ( int i = countBits - 1; i >= 0; i-- ) {
>             panSwitches.add( new JLabel( "2^" + i, SwingConstants.CENTER ) );
>         }
>         // enlarge font for value label
>         this.lblValue.setFont( this.lblValue.getFont().deriveFont( 24f ) );
> 
>         // add to JFrame
>         this.add( panSwitches, BorderLayout.CENTER );
>         this.add( this.lblValue, BorderLayout.SOUTH );
>         // Adapt size to content
>         this.pack();
>     }
> 
>     /**
>      * {@inheritDoc}
>      */
>     @Override
>     public void actionPerformed( ActionEvent e ) {
>         // get the source of the event, must be a JToggleButton
>         JToggleButton src = ((JToggleButton) e.getSource());
> 
>         // parse the name as number
>         int num = Integer.parseInt( src.getName() );
> 
>         // and add or subtract depending on selected state
>         if ( src.isSelected() ) {
>             this.value += num;
>         } else {
>             this.value -= num;
>         }
>         // update label
>         this.lblValue.setText( Integer.toString( this.value ) );
>     }
> 
>     /**
>      * Application entry point
>      *
>      * @param args command line arguments
>      */
>     public static void main( String[] args ) {
>         BinaryNumber bin = new BinaryNumber();
>         bin.setVisible( true );
>     }
> }
> 
> Aufgaben Events (1)                           Musterlösung                      7 / 11
> 
> Grafische Benutzeroberflächen (UI), Events (1)
> ```

## Meine Notizen

