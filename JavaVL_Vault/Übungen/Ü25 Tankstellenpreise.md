---
tags: ["typ/uebung", "thema/datenstrukturen", "kategorie/datenstrukturen", "semester/2", "schwierigkeit/3", "hat/musterloesung"]
aliases: ["GasStations"]
thema: "[[25 Datenstrukturen und Generics]]"
klasse: "GasStations"
package: "de.dhbwka.java.exercise.collections.gas"
schwierigkeit: 3
status: "offen"
---

# Ü25 Tankstellenpreise

**Thema:** [[25 Datenstrukturen und Generics]] · **Bereich:** Datenstrukturen (3) · **Schwierigkeit:** ★★★☆☆
**Klasse:** `GasStations` · **Package:** `de.dhbwka.java.exercise.collections.gas`

📄 Aufgabe: [[Material/Aufgaben/25_Datenstrukturen_Aufgaben-3.pdf#page=1|25_Datenstrukturen_Aufgaben-3.pdf, S. 1]]
✅ Musterlösung: [[Material/Aufgaben/25_Datenstrukturen_Aufgaben-3_Muster.pdf#page=1|25_Datenstrukturen_Aufgaben-3_Muster.pdf, S. 1]]

> [!question] Kurz gesagt
> Schreiben Sie ein Programm zur Erfassung von Preisen an verschiedenen Tankstellen. Sehen Sie hierfür zunächst eine Modellklasse GasPrices vor, welche Instanz-Attribute für drei Sorten von Treibstoff hat (alles vom Typ double): - Diesel-Kraftstoff (diesel) - E5 Super-Benzin (superE5) - E10 Super-Benzin (superE10) Die Klasse soll eine toString-Methode realisieren, welche sämtliche Preise …

## Aufgabenstellung
```text
Schreiben Sie ein Programm zur Erfassung von Preisen an verschiedenen Tankstellen.
Sehen Sie hierfür zunächst eine Modellklasse GasPrices vor, welche Instanz-Attribute für drei
Sorten von Treibstoff hat (alles vom Typ double):
      -   Diesel-Kraftstoff (diesel)
      -   E5 Super-Benzin (superE5)
      -   E10 Super-Benzin (superE10)
Die Klasse soll eine toString-Methode realisieren, welche sämtliche Preise zurückgibt, bspw:
                       Diesel: 1.96, SuperE5: 1.97, SuperE10: 1.91
Schreiben Sie nun eine Klasse GasStations, welche eine grafische Nutzeroberfläche zur Eingabe
eines Tankstellen-Namens sowie aller Preise realisiert:

Beim Drücken des Buttons Save soll zunächst geprüft werden ob ein Name eingetragen ist.
Ist kein Name eingetragen soll der Nutzer per Dialog informiert werden, dass ein Name
eingetragen werden muss. Sonst soll nichts weiter passieren.

Ist ein Name eingetragen, soll ein GasPrices-Objekt erzeugt werden und mit den Werten aus der
Nutzeroberfläche gefüllt werden. Sollte in einem der Text-Felder für den Preis einer Treibstoffsorte
kein gültiger Wert eingetragen sein, nutzen Sie -1 als Wert.
Das erzeugte Objekt soll in einer geeigneten Datenstruktur dann als Schlüssel-Wert-Paar
gespeichert werden.
Der Name der Station ist als Schlüssel zu verwenden und das GasPrices-Objekt als Wert.

(…)

Im Anschluss soll ein Dialog den Nutzer darüber informieren, welches Objekt für welche Station
erfolgreich gespeichert wurde (Beispiel siehe Screenshot) und alle Textfelder sollen geleert
werden. Nutzen Sie die zuvor geschriebene toString-Methode!

Beim Button Show All sollen alle bereits in der Datenstruktur gespeicherten Tankstellen samt Ihren
Preisen ausgegeben werden. Das könnte bspw. so aussehen:

Hinweise:
Leeren lässt sich eine JTextField-Instanz bspw. mit textfield.setText("")
Mehrzeilige Dialog-Texte können bei JOptionPane-Dialogen mit dem Einfügen eines
Zeilenumbruchs (bspw. "\n") in der anzuzeigenden Zeichenkette erreicht werden.

Erweiterung:
Überlegen Sie, wie Sie Ihre Lösung abändern müssten, dass automatisch nach dem
Tankstellennamen sortiert wird – und setzen das gern auch um 😊
```

## Benötigte Begriffe
[[switch]] · [[for-Schleife]] · [[break und continue]] · [[Array]] · [[Sortieren]] · [[Konstruktor]] · [[this]] · [[toString]] · [[Kapselung]] · [[Überschreiben]] · [[super]] · [[Interface]] · [[String]] · [[StringBuilder und StringBuffer]] · [[Wrapperklasse]] · [[Exception]] · [[Swing]] · [[JFrame]] · [[JPanel]] · [[Swing-Komponenten]] · [[Layoutmanager]] · [[Dialoge]] · [[Listener]] · [[Map]]

## Weitere Übungen zum Thema
[[Ü25 Ziehung der Lottozahlen]] · [[Ü25 Bücherei]] · [[Ü25 Binärbaum]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.collections.gas;
> 
> public class GasPrices {
> 
>     private double diesel;
>     private double superE5;
>     private double superE10;
> 
>     public double getDiesel() {
>         return diesel;
>     }
>     public void setDiesel(double diesel) {
>         this.diesel = diesel;
>     }
>     public double getSuperE5() {
>         return superE5;
>     }
>     public void setSuperE5(double superE5) {
>         this.superE5 = superE5;
>     }
>     public double getSuperE10() {
>         return superE10;
>     }
>     public void setSuperE10(double superE10) {
>         this.superE10 = superE10;
>     }
> 
>     @Override
>     public String toString() {
>         return "Diesel: " + this.diesel + ", SuperE5: " + this.superE5
>         + ", SuperE10: " + this.superE10;
>     }
> }
> 
> package de.dhbwka.java.exercise.collections.gas;
> 
> import javax.swing.JButton;
> import javax.swing.JFrame;
> import javax.swing.JLabel;
> import javax.swing.JOptionPane;
> import javax.swing.JPanel;
> import javax.swing.JTextField;
> 
> import java.awt.BorderLayout;
> import java.awt.GridLayout;
> import java.awt.event.ActionEvent;
> import java.awt.event.ActionListener;
> import java.util.HashMap;
> import java.util.Map;
> import java.util.Map.Entry;
> 
> @SuppressWarnings("serial")
> public class GasStations extends JFrame implements ActionListener {
> 
>     private JTextField txtName = new JTextField();
>     private JTextField txtDiesel = new JTextField();
>     private JTextField txtSuperE5 = new JTextField();
>     private JTextField txtSuperE10 = new JTextField();
> 
>     private final Map<String, GasPrices> stations = new HashMap<>();
> 
>     public GasStations() {
>         super("Gas Stations");
>         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
> 
>         // inputs
>         JPanel panInput = new JPanel(new GridLayout(4,2,5,5));
>         panInput.add( new JLabel("Station Name") );
>         panInput.add( this.txtName );
> 
>         panInput.add( new JLabel("Diesel") );
>         panInput.add( this.txtDiesel );
> 
>         panInput.add( new JLabel("Super E5") );
>         panInput.add( this.txtSuperE5 );
> 
>         panInput.add( new JLabel("Super E10") );
>         panInput.add( this.txtSuperE10 );
> 
>         // save button
>         JPanel panButtons = new JPanel();
>         JButton btnSave = new JButton("Save");
>         JButton btnShow = new JButton("Show all");
> 
>         // example with single action listener and action commands
>         btnSave.addActionListener(this);
>         btnShow.addActionListener(this);
>         btnSave.setActionCommand("save");
>         btnShow.setActionCommand("show");
> 
>         panButtons.add(btnSave);
>         panButtons.add(btnShow);
> 
>         this.add(panInput); // implicit: BorderLayout.CENTER
>         this.add(panButtons, BorderLayout.SOUTH);
> 
>         this.pack();
>         this.setVisible(true);
>     }
> 
>     public static void main(String[] args) {
>         new GasStations();
>     }
> 
>     @Override
>     public void actionPerformed(ActionEvent e) {
>         switch (e.getActionCommand()) {
> 
>             case "save":
>             this.saveCurrentInput();
>             break;
>             case "show":
>             this.showAllStations();
>             break;
>             default:
>             break;
>         }
>     }
> 
>     private void saveCurrentInput() {
>         String station = this.txtName.getText();
>         if ( station.isEmpty() ) {
>             JOptionPane.showMessageDialog(this,
>             "Please provide a station name");
>             return;
>         }
>         GasPrices gp = new GasPrices();
>         gp.setDiesel(this.getValue(this.txtDiesel));
>         gp.setSuperE5(this.getValue(this.txtSuperE5));
>         gp.setSuperE10(this.getValue(this.txtSuperE10));
> 
>         this.txtName.setText("");
>         this.txtDiesel.setText("");
>         this.txtSuperE5.setText("");
>         this.txtSuperE10.setText("");
> 
>         this.stations.put(station, gp);
> 
>         JOptionPane.showMessageDialog(this, "Saved: " + station
>         + " (" + gp + ")");
>     }
> 
>     private double getValue(JTextField txt) {
>         String txtVal = txt.getText();
>         if ( !txtVal.isEmpty() ) {
>             txtVal = txtVal.replace(',', '.'); // optional comma support
>         }
>         try {
>             return Double.parseDouble(txtVal);
>         } catch (Exception e) {
>             return -1;
>         }
>     }
> 
>     private void showAllStations() {
>         StringBuilder sb = new StringBuilder();
>         for( Entry<String, GasPrices> e : this.stations.entrySet() ) {
>             sb.append(e.getKey() + ": " + e.getValue() + "\n");
>         }
>         JOptionPane.showMessageDialog(this, sb.toString().trim());
>     }
> }
> ```

## Meine Notizen

