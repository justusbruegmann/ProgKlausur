---
tags: ["typ/uebung", "thema/swing", "kategorie/gui", "semester/2", "schwierigkeit/1", "hat/musterloesung"]
aliases: ["ComponentFrame"]
thema: "[[20 Grafische Oberflächen mit Swing]]"
klasse: "ComponentFrame"
package: "de.dhbwka.java.exercise.ui"
schwierigkeit: 1
status: "offen"
---

# Ü20 Swing-Grundkomponenten

**Thema:** [[20 Grafische Oberflächen mit Swing]] · **Bereich:** Grafische Benutzeroberflächen (GUI/Swing) (1) · **Schwierigkeit:** ★☆☆☆☆
**Klasse:** `ComponentFrame` · **Package:** `de.dhbwka.java.exercise.ui`

📄 Aufgabe: [[Material/Aufgaben/20_Swing_Aufgaben-1.pdf#page=1|20_Swing_Aufgaben-1.pdf, S. 1]]
✅ Musterlösung: [[Material/Aufgaben/20_Swing_Aufgaben-1_Muster.pdf#page=1|20_Swing_Aufgaben-1_Muster.pdf, S. 1]]

> [!question] Kurz gesagt
> Schreiben Sie eine Klasse ComponentFrame, um die Programmierung einiger GUI- Grundkomponenten näher kennen zu lernen. Die Klasse soll die Klasse JFrame erweitern und mit Hilfe eines JPanel-Containers folgende Grundkomponenten in ein Fenster ausgeben: • ein Label • ein Textfeld • ein Password-Feld • ein Button (mit einem Tooltipp) • ein Toggle-Button • eine Check-Box • eine Combo-Box • eine …

## Aufgabenstellung
```text
Schreiben Sie eine Klasse ComponentFrame, um die Programmierung einiger GUI-
Grundkomponenten näher kennen zu lernen.

Die Klasse soll die Klasse JFrame erweitern und mit Hilfe eines JPanel-Containers folgende
Grundkomponenten in ein Fenster ausgeben:
    • ein Label
    • ein Textfeld
    • ein Password-Feld
    • ein Button (mit einem Tooltipp)
    • ein Toggle-Button
    • eine Check-Box
    • eine Combo-Box
    • eine Radio-Button-Gruppe mit drei Radio-Buttons.

Besorgen Sie sich erforderliche Informationen über benötigte Klassen (insbesondere über die Klasse
ButtonGroup) über die Javadoc-Dokumentation der API und die Java-Tutorials. Spielen Sie mit
den verschiedenen Komponenten!

Javadoc Swing:
https://docs.oracle.com/javase/8/docs/api/index.html?javax/swing/package-summary.html

Anmerkung:
Mit der Methode setColumns(int columns) der Klasse JTextField kann die Breite eines
Textfeldes festgelegt werden.
```

## Benötigte Begriffe
[[for-Schleife]] · [[Array]] · [[Konstruktor]] · [[this]] · [[super]] · [[Javadoc]] · [[Swing]] · [[JFrame]] · [[JPanel]] · [[Swing-Komponenten]] · [[Layoutmanager]]

## Weitere Übungen zum Thema
[[Ü20 Frame mit Text]] · [[Ü20 Datei auswählen und zeilenweise darstellen]] · [[Ü20 Währungsumrechner]] · [[Ü20 Editor]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.ui;
> 
> import java.awt.FlowLayout;
> import javax.swing.*;
> 
> @SuppressWarnings( "serial" )
> public class ComponentFrame extends JFrame {
> 
>     public ComponentFrame() {
>         this( "ComponentFrame" );
>     }
> 
>     @SuppressWarnings( { "unchecked", "rawtypes" } )
>     public ComponentFrame( String title ) {
>         super( title );
>         // Default layout for JFrame content would be BorderLayout!
>         this.setLayout( new FlowLayout() );
>         this.add( new JLabel( "JLabel" ) );
>         this.add( new JTextField( "JTextField" ) );
>         this.add( new JPasswordField( "JPasswordField" ) );
>         this.add( new JButton( "JButton" ) );
>         this.add( new JToggleButton( "JToggleButton" ) );
>         this.add( new JCheckBox( "JCheckBox" ) );
>         // No generic type for JComboBox - we had no generics yet
>         this.add( new JComboBox(
>         new String[] { "Item 1", "Item 2", "Item 3", "Item 4" } ) );
>         // ButtonGroup connects the RadioButtons as a functional unit
>         ButtonGroup group = new ButtonGroup();
>         for ( int i = 1; i <= 3; i++ ) {
>             JRadioButton rb = new JRadioButton( "Radio-Button-" + i );
>             group.add( rb );
>             this.add( rb );
>         }
>         this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
>         this.setSize( 640, 100 );
>         this.setVisible( true );
>     }
>     public static void main( String[] args ) {
>         new ComponentFrame( "Several basic Swing components" );
>     }
> }
> ```

## Meine Notizen

