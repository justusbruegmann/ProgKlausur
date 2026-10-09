---
tags: ["typ/uebung", "thema/swing", "kategorie/gui", "semester/2", "schwierigkeit/2", "hat/musterloesung"]
aliases: ["CurrencyCalculator"]
thema: "[[20 Grafische Oberflächen mit Swing]]"
klasse: "CurrencyCalculator"
package: "de.dhbwka.java.exercise.ui"
schwierigkeit: 2
status: "offen"
---

# Ü20 Währungsumrechner

**Thema:** [[20 Grafische Oberflächen mit Swing]] · **Bereich:** Grafische Benutzeroberflächen (GUI/Swing) (2) · **Schwierigkeit:** ★★☆☆☆
**Klasse:** `CurrencyCalculator` · **Package:** `de.dhbwka.java.exercise.ui`

📄 Aufgabe: [[Material/Aufgaben/20_Swing_Aufgaben-2.pdf#page=2|20_Swing_Aufgaben-2.pdf, S. 2]]
✅ Musterlösung: [[Material/Aufgaben/20_Swing_Aufgaben-2_Muster.pdf#page=5|20_Swing_Aufgaben-2_Muster.pdf, S. 5]]

> [!question] Kurz gesagt
> Entwickeln Sie mit Swing eine Anwendung CurrencyCalculator, welche ein einzeiliges Eingabefeld sowie darunter drei Schaltflächen („EUR → USD“, „USD→ EUR“, „Cancel“) hat. Verwenden Sie ein BorderLayout.

## Aufgabenstellung
```text
Entwickeln Sie mit Swing eine Anwendung CurrencyCalculator, welche ein einzeiliges
Eingabefeld sowie darunter drei Schaltflächen („EUR → USD“, „USD→ EUR“, „Cancel“) hat.
Verwenden Sie ein BorderLayout.

Hinweis:
Die Anwendung soll sonst (noch) nichts weiter tun. Die Anwendung wird später erweitert.
```

## Benötigte Begriffe
[[Konstante]] · [[this]] · [[static]] · [[Kapselung]] · [[Swing]] · [[JFrame]] · [[Swing-Komponenten]] · [[Layoutmanager]] · [[Lambda-Ausdruck]]

## Gleiche Klasse in anderen Übungen (Fortsetzung/Variante)
[[Ü23 Währungsumrechner (2)]]

## Weitere Übungen zum Thema
[[Ü20 Swing-Grundkomponenten]] · [[Ü20 Frame mit Text]] · [[Ü20 Datei auswählen und zeilenweise darstellen]] · [[Ü20 Editor]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.ui;
> 
> import java.awt.BorderLayout;
> 
> import javax.swing.JButton;
> import javax.swing.JFrame;
> import javax.swing.JTextField;
> 
> public class CurrencyCalculator {
> 
>     public final static float CHANGE_RATE = 1.14f;
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
>         this.frame.setSize( 350, 100 );
>         this.frame.setVisible( true );
>     }
> 
>     public static void main( String[] args ) {
>         new CurrencyCalculator();
>     }
> 
> }
> ```

## Meine Notizen

