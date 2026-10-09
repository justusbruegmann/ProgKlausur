---
tags: ["typ/uebung", "thema/events", "kategorie/gui", "semester/2", "schwierigkeit/1", "hat/musterloesung"]
aliases: ["CurrencyCalculator"]
thema: "[[23 Events]]"
klasse: "CurrencyCalculator"
package: "de.dhbwka.java.exercise.ui.event"
schwierigkeit: 1
status: "offen"
---

# Ü23 Währungsumrechner (2)

**Thema:** [[23 Events]] · **Bereich:** Grafische Benutzeroberflächen (UI), Events (1) · **Schwierigkeit:** ★☆☆☆☆
**Klasse:** `CurrencyCalculator` · **Package:** `de.dhbwka.java.exercise.ui.event`

📄 Aufgabe: [[Material/Aufgaben/23_Events_Aufgaben-1.pdf#page=1|23_Events_Aufgaben-1.pdf, S. 1]]
✅ Musterlösung: [[Material/Aufgaben/23_Events_Aufgaben-1_Muster.pdf#page=1|23_Events_Aufgaben-1_Muster.pdf, S. 1]]

> [!question] Kurz gesagt
> Erweitern Sie die Aufgabe CurrencyCalculator des Aufgabenblatts „Grafische Benutzeroberflächen (2)“ so, dass auf Events an den einzelnen Buttons reagiert wird: Sobald ein Button gedrückt wurde soll die Benutzereingabe im Textfeld

## Aufgabenstellung
```text
Erweitern Sie die Aufgabe CurrencyCalculator des Aufgabenblatts „Grafische
Benutzeroberflächen (2)“ so, dass auf Events an den einzelnen Buttons reagiert wird:

Sobald ein Button gedrückt wurde soll die Benutzereingabe im Textfeld
   • durch eine Fehlermeldung ersetzt werden, wenn es sich um keine Zahl handelt;
   • mit dem Faktor 1,09 multipliziert werden, wenn „EUR → USD“ gedrückt wurde;
   • durch den Faktor 1,09 dividiert werden, wenn „USD → EUR“ gedrückt wurde.

Wenn der Button „Cancel“ gedrückt wurde soll die Anwendung beendet werden.

Hinweis:
Das Beenden einer Anwendung kann man mit System.exit(0); herbeiführen.
```

## Benötigte Begriffe
[[Konstante]] · [[this]] · [[static]] · [[toString]] · [[Kapselung]] · [[Überschreiben]] · [[Interface]] · [[Exception]] · [[Swing]] · [[JFrame]] · [[Swing-Komponenten]] · [[Layoutmanager]] · [[Listener]] · [[Lambda-Ausdruck]]

## Gleiche Klasse in anderen Übungen (Fortsetzung/Variante)
[[Ü20 Währungsumrechner]]

## Weitere Übungen zum Thema
[[Ü23 Body-Mass-Index (BMI)]] · [[Ü23 Binäre Zahlen]] · [[Ü23 Zahlenraten (2)]] · [[Ü23 Editor]] · [[Ü23 Hütchenspiel]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.ui.event;
> 
> import java.awt.BorderLayout;
> import java.awt.event.ActionEvent;
> import java.awt.event.ActionListener;
> 
> import javax.swing.JButton;
> import javax.swing.JFrame;
> import javax.swing.JTextField;
> 
> public class CurrencyCalculator implements ActionListener {
> 
>     public final static float CHANGE_RATE = 1.09f;
> 
>     private JFrame frame = new JFrame( "Currency converter" );
> 
>     private JTextField input =
>     new JTextField( "Please enter amount to convert!" );
> 
>     private JButton btnEur2usd = new JButton( "EUR -> USD" );
>     private JButton btnUsd2eur = new JButton( "USD -> EUR" );
>     private JButton btnCancel = new JButton( "Cancel" );
> 
>     public CurrencyCalculator() {
>         // default BorderLayout has no margin!
>         this.frame.setLayout( new BorderLayout( 10, 10 ) );
>         this.frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
>         this.frame.add( this.input, BorderLayout.NORTH );
>         this.frame.add( this.btnEur2usd, BorderLayout.WEST );
>         this.frame.add( this.btnUsd2eur, BorderLayout.CENTER );
>         this.frame.add( this.btnCancel, BorderLayout.EAST );
> 
>         // Add ActionListener to buttons (2nd part)
>         this.btnEur2usd.addActionListener( this );
>         this.btnUsd2eur.addActionListener( this );
>         this.btnCancel.addActionListener( this );
> 
>         this.frame.setSize( 350, 90 );
>         this.frame.setVisible( true );
>     }
> 
>     Aufgaben Events (1)                           Musterlösung                           1 / 11
> 
>     /**
>      * Event handling (2nd part)
>      */
>     @Override
>     public void actionPerformed( ActionEvent e ) {
>         if ( e.getSource() == this.btnCancel ) {
>             System.exit( 0 );
>         }
>         try {
>             float amount = Float.parseFloat( this.input.getText() );
>             if ( e.getSource() == this.btnEur2usd ) {
>                 amount = amount * CurrencyCalculator.CHANGE_RATE;
>             }
>             if ( e.getSource() == this.btnUsd2eur ) {
>                 amount = amount / CurrencyCalculator.CHANGE_RATE;
>             }
> 
>             this.input.setText( Float.toString( amount ) );
>         } catch ( Exception ex ) {
>             this.input.setText( "Error parsing amount." );
>         }
>     }
> 
>     public static void main( String[] args ) {
>         new CurrencyCalculator();
>     }
> 
> }
> 
> Aufgaben Events (1)                           Musterlösung            2 / 11
> 
> Grafische Benutzeroberflächen (UI), Events (1)
> ```

## Meine Notizen

