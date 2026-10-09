---
tags: ["typ/uebung", "thema/events", "kategorie/gui", "semester/2", "schwierigkeit/2", "hat/musterloesung"]
aliases: ["BMICalculator"]
thema: "[[23 Events]]"
klasse: "BMICalculator"
package: "de.dhbwka.java.exercise.ui.event"
schwierigkeit: 2
status: "offen"
---

# Ü23 Body-Mass-Index (BMI)

**Thema:** [[23 Events]] · **Bereich:** Grafische Benutzeroberflächen (UI), Events (1) · **Schwierigkeit:** ★★☆☆☆
**Klasse:** `BMICalculator` · **Package:** `de.dhbwka.java.exercise.ui.event`

📄 Aufgabe: [[Material/Aufgaben/23_Events_Aufgaben-1.pdf#page=2|23_Events_Aufgaben-1.pdf, S. 2]]
✅ Musterlösung: [[Material/Aufgaben/23_Events_Aufgaben-1_Muster.pdf#page=3|23_Events_Aufgaben-1_Muster.pdf, S. 3]]

> [!question] Kurz gesagt
> Der Body-Mass-Index (BMI) ist ein Index, der das Verhältnis von Körpergewicht zur Größe angibt. Die Formel für den BMI lautet: BMI \= (Körpergewicht in kg) / (Größe in m)2.

## Aufgabenstellung
```text
Der Body-Mass-Index (BMI) ist ein Index, der das Verhältnis von Körpergewicht zur Größe angibt.
Die Formel für den BMI lautet:

         BMI = (Körpergewicht in kg) / (Größe in m)2.

Folgende Tabelle zeigt die Klassifikation der BMI-Werte in Abhängigkeit des Geschlechts.

            Klassifikation                                   Männer          Frauen
            Untergewicht (Short weight)                        <20             <19
            Normalgewicht (Normal weight)                     20-25           19-24
            Übergewicht (Overweight)                          25-30           24-30
            Adipositas (Adiposity)                            30-40           30-40
            massive Adipositas (Massive Adiposity)             >40             >40

    a) Schreiben Sie eine JFrame-basierte Java-Applikation BMICalculator, in der man das
       Gewicht, die Körpergröße und das Geschlecht eingeben kann und die dann den BMI
       berechnet.

    b) Erweitern Sie Ihre Applikation derart, dass der Benutzer eine Einschätzung seines BMI
       anhand obiger Tabellen erhält.

Hinweis:
In der Klasse JRadioButton gibt es eine (geerbte) Instanzmethode boolean isSelected(),
die den Zustand eines Feststell-Buttons zurückliefert: true wenn der Button ausgewählt ist, false
wenn nicht.
```

## Benötigte Begriffe
[[this]] · [[toString]] · [[Kapselung]] · [[Vererbung]] · [[Überschreiben]] · [[Interface]] · [[Wrapperklasse]] · [[Exception]] · [[Swing]] · [[JFrame]] · [[JPanel]] · [[Swing-Komponenten]] · [[Layoutmanager]] · [[Listener]]

## Weitere Übungen zum Thema
[[Ü23 Währungsumrechner (2)]] · [[Ü23 Binäre Zahlen]] · [[Ü23 Zahlenraten (2)]] · [[Ü23 Editor]] · [[Ü23 Hütchenspiel]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.ui.event;
> 
> import java.awt.GridLayout;
> import java.awt.event.ActionEvent;
> import java.awt.event.ActionListener;
> 
> import javax.swing.ButtonGroup;
> import javax.swing.JButton;
> import javax.swing.JFrame;
> import javax.swing.JLabel;
> import javax.swing.JPanel;
> import javax.swing.JRadioButton;
> import javax.swing.JTextField;
> 
> public class BMICalculator implements ActionListener {
> 
>     private JTextField weightField = new JTextField( 10 );
>     private JTextField heightField = new JTextField( 10 );
>     private JTextField bmiField = new JTextField( 15 );
>     private JTextField messageField = new JTextField( 20 );
>     private JRadioButton rbMale = new JRadioButton( "male", true );
>     private JRadioButton rbFemale = new JRadioButton( "female", false );
> 
>     public BMICalculator() {
>         JFrame frame = new JFrame( "BMI Calculator" );
>         frame.setLayout( new GridLayout( 6, 1 ) );
> 
>         JPanel weightPanel = new JPanel();
>         JPanel heightPanel = new JPanel();
>         JPanel sexPanel = new JPanel();
>         JPanel calcBtnPanel = new JPanel();
>         JPanel bmiPanel = new JPanel();
>         JPanel messagePanel = new JPanel();
> 
>         ButtonGroup radioButtonGroup = new ButtonGroup();
>         radioButtonGroup.add( this.rbMale );
>         radioButtonGroup.add( this.rbFemale );
> 
>         // Continued on next page
> 
>         Aufgaben Events (1)                           Musterlösung                           3 / 11
> 
>         weightPanel.add( new JLabel( "Weight [kg]:" ) );
>         weightPanel.add( this.weightField );
>         heightPanel.add( new JLabel( "Body height [m]" ) );
>         heightPanel.add( this.heightField );
> 
>         sexPanel.add( this.rbMale );
>         sexPanel.add( this.rbFemale );
> 
>         JButton calcBtn = new JButton( "Calculate" );
>         calcBtn.addActionListener( this );
>         calcBtnPanel.add( calcBtn );
> 
>         bmiPanel.add( new JLabel( "BMI:" ) );
>         bmiPanel.add( this.bmiField );
>         messagePanel.add( this.messageField );
> 
>         frame.add( weightPanel );
>         frame.add( heightPanel );
>         frame.add( sexPanel );
>         frame.add( calcBtnPanel );
>         frame.add( bmiPanel );
>         frame.add( messagePanel );
> 
>         frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
>         frame.pack();
>         frame.setVisible( true );
>     }
> 
>     @Override
>     public void actionPerformed( ActionEvent e ) {
>         try {
>             int weight = Integer.parseInt( this.weightField.getText() );
>             double height = Double.parseDouble( this.heightField.getText() );
>             double bmi = weight / (height * height);
> 
>             this.bmiField.setText( Double.toString( bmi ) );
>             this.messageField
>             .setText( this.getBMIType( this.rbMale.isSelected(), bmi ) );
>         } catch ( Exception ex ) {
>             this.bmiField.setText( "Bad input" );
>         }
>     }
> 
>     // Continued on next page
> 
>     Aufgaben Events (1)                           Musterlösung                       4 / 11
> 
>     public String getBMIType( boolean male, double bmi ) {
>         String erg;
>         if ( male ) {
>             if ( bmi < 20 ) {
>                 erg = "Short weight";
>             } else if ( bmi < 25 ) {
>                 erg = "Normal weight";
>             } else if ( bmi < 30 ) {
>                 erg = "Overweight";
>             } else if ( bmi < 40 ) {
>                 erg = "Adiposity";
>             } else {
>                 erg = "Massive Adiposity";
>             }
>         } else {
>             if ( bmi < 19 ) {
>                 erg = "Short weight";
>             } else if ( bmi < 24 ) {
>                 erg = "Normal weight";
>             } else if ( bmi < 30 ) {
>                 erg = "Overweight";
>             } else if ( bmi < 40 ) {
>                 erg = "Adiposity";
>             } else {
>                 erg = "Massive Adiposity";
>             }
>         }
>         return erg;
>     }
> 
>     public static void main( String[] args ) {
>         new BMICalculator();
>     }
> 
> }
> 
> Aufgaben Events (1)                           Musterlösung   5 / 11
> 
> Grafische Benutzeroberflächen (UI), Events (1)
> ```

## Meine Notizen

