---
tags: ["typ/programmentwurf", "kategorie/pruefung", "thema/datentypen", "thema/operatoren", "thema/kontrollstrukturen", "thema/arrays", "thema/objektorientierung", "thema/klassen", "thema/strings", "thema/vererbung", "thema/exceptions", "thema/io", "thema/swing", "thema/interfaces", "thema/zeichnen", "thema/datenstrukturen", "thema/enum", "thema/java8", "thema/programmentwurf"]
art: "Probe-Programmentwurf"
status: "offen"
bearbeitungszeit: "120 Minuten"
---

# PE CHORona

[[Programmentwurf – Übersicht|⬆ Programmentwurf – Übersicht]] · [[Start|🏠 Start]]

**Art:** Probe-Programmentwurf · **Bearbeitungszeit:** 120 Minuten

> [!abstract] Worum geht's?
> Grafische Simulation der Aerosol-Verbreitung bei einer Chorprobe. Der Raum ist ein Zellraster mit zufällig platzierten Infizierten. Gefordert sind ein komplexer Enum `Variant` (Virusvarianten), das Interface `IRoom`, Datei-Einlesen (Schadstofffaktoren) und eine Swing-Darstellung, die in Zeitscheiben aktualisiert wird.

📄 Aufgabenstellung: [[Material/Projekte/41b_CHORona_ProbePE_Download/CHORona/CHORona_ProbePE.pdf|CHORona_ProbePE.pdf]]

## Teilaufgaben
- [ ] **a)** **[8 %]** Zur Unterscheidung der verschiedenen Varianten von SARS-CoV-2 in unserem Programm soll zunächst ein komplexer Aufzählungstyp Variant realisiert werden. Der Konstanten-Name ist der griechische „Buchstabe“ der für die Variante vergeben wurde.
- [ ] **b)** **[6 %]** Zur Nutzung der vorgegeben Klasse für die Viruslast-Verteilung muss die dort verwendete Java-Schnittstelle (Interface) IRoom realisiert werden. Folgende Methoden müssen definiert werden: - double getDose(int x, int y): Liefert Viruslast an den übergebenen Koordinaten des Rasters - void setDose(int x, int y, double dose): Setzt die Viruslast an den übergebenen Koordinaten - void addDose(int x, int …
- [ ] **c)** **[13 %]** Zur Definition einer Koordinate für infizierte Personen erweitern Sie die bereitgestellte Klasse Point, welche als Attribute zwei ganzzahlige Werte für die x- und y-Komponente einer Koordinate speichern kann. Definieren Sie einen Konstruktor der für beide Attribute Werte entgegennimmt und diese speichert.
- [ ] **d)** **[18 %]** Zur Visualisierung der Verbreitung setzen Sie nun die grafische Oberfläche in Form der Klasse ChoronaTerminal um. Der Konstruktor nimmt die Virus-Variante für das Fenster sowie die passende Room-Instanz entgegen (vgl.
- [ ] **e)** **[4 %]** Bisher sind in der bereitgestellten Klasse Chorona feste Zahlen für Breite, Höhe und Anzahl der infizierten Personen für die RoomSetting-Instanz vorgegeben. Überarbeiten Sie die Initialisierung nun so, dass zufällige Werte verwendet werden.
- [ ] **f)** **[6 %]** Um die unterschiedliche Ansteckungswahrscheinlichkeit für die verschiedenen Varianten bei neuen wissenschaftlichen Erkenntnissen flexibel anpassen zu können, sollen diese aus einer Datei eingelesen werden. Ändern Sie die Implementierung der getPollutantFactors-Methode in der bereitgestellten Klasse Chorona (s.
- [ ] **g)** **[13 %]** Erweitern Sie die Klasse ChoronaTerminal (vgl. Teilaufgabe d)) nun so, dass beim Drücken des Save-Buttons der aktuelle Zustand des Fensters in eine Datei geschrieben wird.
- [ ] **h)** **[7 %]** Erweitern Sie die Klasse ChoronaTerminal (vgl. Teilaufgabe d)) nun so, dass beim Drücken des Play-Buttons automatisch 20 Schritte im Abstand von 0,5s ausgelöst werden.

## Benötigte Begriffe
[[Typkonversion]] · [[Konstante]] · [[Formatierte Ausgabe]] · [[Zufallszahlen]] · [[Math-Klasse]] · [[while-Schleife]] · [[for-Schleife]] · [[Array]] · [[Mehrdimensionales Array]] · [[Konstruktor]] · [[this]] · [[static]] · [[Kapselung]] · [[Vererbung]] · [[Überschreiben]] · [[equals und hashCode]] · [[Interface]] · [[Enum]] · [[String]] · [[Wrapperklasse]] · [[Exception]] · [[Eigene Exception]] · [[BufferedReader und BufferedWriter]] · [[Datei und Pfad]] · [[Swing]] · [[Swing-Komponenten]] · [[Dialoge]] · [[Farben und Schriften]] · [[Zeichnen mit Graphics]] · [[List]] · [[Map]] · [[Collections-Klasse]] · [[Lambda-Ausdruck]] · [[Programmentwurf]]

## Dafür wiederholen (Themen)
**Schwerpunkte:** [[08 Objektorientierung]] · [[09 Klassen und Objekte]] · [[13 Vererbung]] · [[14 Exceptions]] · [[15 Input und Output]] · [[20 Grafische Oberflächen mit Swing]] · [[21 Abstrakte Klassen und Interfaces]] · [[24 Zeichnen in Swing]] · [[25 Datenstrukturen und Generics]] · [[26 Aufzählungstypen (Enums)]] · [[33 Java 8 – Lambdas, Streams, NIO.2]]

**Grundlagen:** [[04 Primitive Datentypen]] · [[05 Operatoren]] · [[06 Kontrollstrukturen]] · [[07 Arrays]] · [[10 Strings und Wrapperklassen]]

## Dateien
- [CHORona/CHORona_ProbePE.pdf](<Material/Projekte/41b_CHORona_ProbePE_Download/CHORona/CHORona_ProbePE.pdf>)
- [CHORona/Chorona.java](<Material/Projekte/41b_CHORona_ProbePE_Download/CHORona/Chorona.java>)
- [CHORona/Point.java](<Material/Projekte/41b_CHORona_ProbePE_Download/CHORona/Point.java>)
- [CHORona/Room.java](<Material/Projekte/41b_CHORona_ProbePE_Download/CHORona/Room.java>)
- [CHORona/pollutantfactors.txt](<Material/Projekte/41b_CHORona_ProbePE_Download/CHORona/pollutantfactors.txt>)

## Vorgegebener Code
> [!example]- CHORona/Chorona.java
> ```java
> import java.awt.Color;
> import java.util.Collections;
> import java.util.HashMap;
> import java.util.LinkedList;
> import java.util.List;
> import java.util.Map;
> import java.util.Map.Entry;
> 
> import javax.swing.ImageIcon;
> import javax.swing.JButton;
> 
> public class Chorona {
> 
>    // Icon in "binaerform" damit keine Datei eingelesen werden muss :-)
>    private final static ImageIcon ICON_500 = new ImageIcon( new byte[] { 71, 73, 70, 56, 57, 97, 64, 0, 56, 0, -11, 0, 0, 0, 0, 0, 8, 7, 1, 12, 10, 2, 17, 14, 3, 21, 17, 4, 27, 22, 5, 30, 24, 5, 34, 28, 6, 39, 33, 7, 42, 34, 7, 45, 37, 8, 52, 43, 9, 56, 46, 10, 61, 50, 11, 66, 54, 11, 69, 57, 12, 75, 62, 13, 79, 65, 14, 84, 70, 15, 89, 73, 15, 94, 77, 16, 96, 79, 17, 100, 82, 17, 105, 87, 18, 108, 89, 19, 114, 94, 20, 118, 97, 20, 121, 100, 21, 127, 104, 22, -124, 108, 23, -120, 112, 23, -116, 115, 24, -112, 119, 25, -108, 122, 26, -102, 127, 27, -99, -127, 27, -94, -123, 28, -90, -119, 29, -86, -116, 29, -77, -108, 31, -73, -105, 32, -67, -101, 33, -64, -98, 33, -60, -94, 34, -54, -90, 35, -51, -87, 35, -45, -83, 36, -42, -80, 37, -37, -75, 38, -33, -72, 39, -29, -69, 39, -26, -66, 40, -24, -65, 40, -21, -63, 40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 33, -7, 4, 1, 0, 0, 54, 0, 33, -1, 11, 73, 109, 97, 103, 101, 77, 97, 103, 105, 99, 107, 13, 103, 97, 109, 109, 97, 61, 48, 46, 52, 53, 52, 53, 53, 0, 44, 0, 0, 0, 0, 64, 0, 56, 0, 0, 6, -2, 64, -101, 112, 72, 44, 26, -113, 67, 0, 0, -55, 108, 58, -97, 78, -91, 18, 74, -83, 90, -123, -46, -27, 117, -53, 37, 102, -89, -35, 112, -11, 43, 21, -101, -93, 74, 6, -93, 124, 110, 23, -91, 2, -109, 73, -64, 118, -69, -91, 20, -103, -116, 82, -73, -101, -91, 5, 41, 53, 53, 41, 6, 125, 126, 93, 82, 26, 53, 52, -116, 26, -121, -120, 87, 82, 10, 45, 53, 51, -115, 45, 10, -112, -111, 80, 82, 1, 32, -116, 52, -115, 53, 32, 1, -101, -100, 77, 82, 15, 49, -105, -94, -115, 48, 15, -89, -88, 71, 82, 3, 38, -95, -82, -115, 38, 3, -78, -77, 94, 74, 121, -71, -71, 123, -67, -66, 54, 82, 6, 42, -72, -62, 53, 42, -122, 96, -58, -76, 74, 27, -72, -105, 51, -83, 51, 53, 27, -59, -88, -109, 46, -116, -39, -95, -125, -82, 46, 11, -36, -120, -98, 33, -106, 53, 50, 44, -107, 52, 45, 44, 50, -125, 53, 33, -90, -48, -47, -57, 74, -85, 53, 49, 36, 26, 32, 86, 12, 90, 1, 66, 3, -119, 24, -20, 98, -31, 51, 86, -21, -42, 10, 9, 22, 86, 52, 18, 101, 105, -123, 5, 9, 2, 79, -16, 90, 56, 75, -118, -123, 26, 39, 20, 88, 64, 72, -93, -43, -88, 24, 21, 18, -100, -104, 97, -31, -36, 25, 100, 43, 86, 36, 96, -16, -51, -110, -80, 108, 46, 24, 36, -120, 121, -64, -91, -2, 24, 41, 28, 100, 68, 0, -96, 78, 88, -82, 65, 32, 0, 68, -112, -63, -63, 103, 34, 37, 11, 94, -112, 8, 96, -128, -59, -78, -101, 53, 88, 24, 8, 64, -30, -123, 57, -114, 118, 60, -119, -104, 1, 1, 0, -125, 24, 70, -103, -59, 88, 3, 65, -122, -120, 123, 90, 34, 73, 105, -85, 21, -128, 3, 25, 20, -57, -47, 3, 39, -93, 1, -128, -86, 100, -99, -114, 81, 50, -32, 68, 13, 19, -90, 22, -64, 24, -28, -30, -97, 5, 11, 6, 107, -62, 48, 23, -32, -106, 70, -63, -99, -108, 88, -56, 22, -126, 112, -118, 23, 29, 18, -64, 5, 16, 32, 1, -121, 23, 41, 8, 40, 17, 97, -23, 2, 102, 52, 0, 14, 8, -84, 39, 101, 67, 6, 37, 84, 23, 44, -40, -86, 68, -61, 54, 37, -22, 106, -84, -24, 9, 54, -116, -108, 14, -93, 62, 72, 57, -48, 1, 65, 3, 17, 45, 96, -64, 96, 33, -94, 65, 2, 15, -60, 1, 124, -96, -41, 33, -53, -99, 52, 47, -78, 94, 40, -112, -91, 1, -119, -59, -30, 106, -64, 32, -79, 6, -112, 5, -85, 57, 95, 27, -15, 52, -30, 112, 2, 50, 0, 20, -116, 64, 63, 40, -122, 8, 77, 100, 36, 112, -53, 8, 112, -67, -92, -60, 82, 37, 60, -125, 95, 0, 12, 96, 80, 66, 9, 23, 48, 48, -38, 23, 6, -108, 32, -125, 4, -14, 37, -95, 4, 1, 40, -2, -80, 112, 31, 0, 3, 44, 0, 1, 4, 12, 108, -124, 91, 6, 26, -116, 54, 0, 3, 35, 46, -80, 81, 2, 44, -100, -96, 90, 113, 84, 72, 113, -63, 12, 124, 8, 64, -63, 9, 49, -96, 0, 89, 9, 22, -48, 17, 64, 7, 122, 116, 7, -128, 0, 22, -108, -96, 1, 5, 40, -12, 72, 1, 29, 20, -52, -32, 26, -115, 79, 44, -41, 66, 106, 4, -124, 16, -50, 8, 32, 42, 51, 66, 1, 6, 84, 82, 67, 11, 6, 20, 80, -97, 10, -68, -44, 103, 73, 8, 4, 16, -112, 2, 11, -39, 113, -111, 69, 7, -38, 4, 16, -36, 32, 92, 10, -128, -62, 32, 34, 72, 80, -109, 11, 18, -80, 86, 3, 10, 116, -88, -39, -120, 61, 28, -44, -32, -127, 119, -110, 40, -47, -64, 11, 50, 60, 32, 1, 94, 20, -99, 64, 71, 112, 51, -112, 32, 1, 9, -102, -110, 64, -111, 8, 71, -18, 73, -47, -123, 15, -56, -16, -126, 95, 84, 74, 67, 26, 9, 53, -68, -64, 64, 9, -72, -76, -86, -55, -92, -115, 88, 26, 64, 0, 2, 24, 86, 18, -122, 9, 124, 35, 74, 54, 37, 48, 16, 30, 9, 116, -92, -6, -122, 18, -109, -42, -32, 2, 4, -66, -26, -126, 1, -120, -80, -54, -86, -124, 2, -31, 29, -58, 11, 6, -52, -76, -64, 44, 59, 24, 26, -85, 33, 0, 28, 90, -30, -62, 72, 38, 53, -94, 66, 79, -2, 10, 40, 19, -23, 62, -13, -88, -96, -55, 1, -54, 8, 19, -125, 5, 46, 52, -126, -62, -116, 113, -63, -122, 65, 43, 49, 112, 0, 67, -71, -115, 124, 96, 74, 2, 93, 41, -12, -128, 84, -9, 5, -80, -99, 81, 48, 112, -128, -48, 53, -49, 122, 43, 5, -116, -95, -52, 16, -62, 59, -62, -56, -80, 1, 29, 2, 124, 0, -96, 2, 31, 112, -68, 1, -91, -82, 100, -45, -126, -106, 37, -115, -7, 97, -66, -86, 6, -32, 65, -84, 44, -8, 90, 46, 59, 33, 28, 96, 64, 7, -59, 10, -48, -127, 1, 7, -96, 12, 112, -85, 86, -75, -94, 104, -127, 76, 72, -15, -88, 77, 41, 51, 114, 21, 69, 44, -108, -48, 45, -78, 37, 88, -107, 86, 94, -40, -76, -118, 42, -53, -65, 28, -55, -86, 81, 51, -72, 48, 79, 73, 96, -113, 18, 66, -79, 74, 8, -64, 90, 46, 38, -55, -32, 2, -64, -115, -108, 64, 54, 18, 82, -48, -118, -107, 9, 34, -52, -93, -12, 32, 50, -80, 73, 70, -106, 118, -113, -62, -114, 8, 38, 112, 77, -61, -123, -101, 0, -78, 103, 53, -82, -56, 48, -126, -125, 94, -85, 109, -62, -109, -53, 101, 23, 0, 5, 38, 52, -18, 66, 9, 24, -44, 61, -11, -96, -28, 113, 36, 69, 6, 108, -1, 106, -55, 9, 18, 44, -48, 64, 3, 8, -64, 53, 0, 5, 42, -84, 64, -127, -119, 2, 36, 112, -6, 112, 2, 18, -100, 48, -47, -26, -73, 45, 52, -15, 59, -21, -36, 46, 78, 12, 16, 50, 96, -13, 1, 14, 104, 112, -62, -41, 50, -96, -112, 1, -22, 60, 47, 96, -127, 9, -13, 100, 115, -119, 56, -82, -88, 92, -121, 39, -96, -20, -91, -3, -10, -20, -72, -32, 2, -92, -36, -77, -13, -62, -9, 118, -121, -49, 125, 41, 108, 72, 65, -128, 6, 29, -76, -17, -2, -5, -16, -57, 47, -1, -4, -12, -53, -81, 1, -66, -6, -32, -89, -1, -2, -4, -9, -17, -1, -1, 0, 12, -96, 0, -5, -105, -65, 1, 26, -16, -128, 95, -80, 65, 16, 0, 0, 59 } );
> 
>     public static void main(String[] args) {
>       try {
>          Map<Variant, Double> pollutants = Chorona.getPollutantFactors();
> 
>          // Diese drei Werte sind im Verlauf der Aufgabe zufaellig zu setzen
>          int width = 9;
>          int height = 7;
>          int noOfPolluters = 6;
> 
>          RoomSetting setting = new RoomSetting( width, height, noOfPolluters );
>          for ( Entry<Variant, Double> e : pollutants.entrySet() ) {
>             new ChoronaTerminal( e.getKey(), new Room( e.getValue(), setting ) );
>          }
>       } catch ( Exception e ) {
>          e.printStackTrace();
>       }
>     }
>     
> 
>    public static Map<Variant, Double> getPollutantFactors() {
>       Map<Variant, Double> map = new HashMap<>();
> 
>       // Diese beiden TEST (!) Zeilen auskommentieren und das Einlesen der Datei
>       // "pollutantfactors.txt" ergaenzen
>       Chorona.parsePolluteFactor( "DELTA,50", map );
>       Chorona.parsePolluteFactor( "OMICRON,200", map );
> 
>       // Wenn nach dem Einlesen der Datei mehr als zwei Eintraege in der Map
>       // sind werden zwecks Uebersicht zufaellig so lange Eintraege entfernt,
>       // bis nur noch zwei uebrig sind (daher auch weiterhin nur zwei Fenster)!
>       if ( map.size() > 2 ) {
>          List<Variant> keys = new LinkedList<>( map.keySet() );
>          Collections.shuffle( keys );
>          while ( map.size() > 2 ) {
>             map.remove( keys.remove( 0 ) );
>          }
>       }
> 
>       return map;
>    }
> 
>    public static void parsePolluteFactor( String line, Map<Variant, Double> map ) {
>       String[] parts = line.split( "," );
>       if ( parts.length >= 2 ) {
>          map.put( Variant.valueOf( parts[0] ), Double.parseDouble( parts[1] ) );
>       }
>    }
> 
>    public static Color getColorForDose( double dose ) {
>       final int limit1 = 200;
>       final int limit2 = 500;
>       int val = Math.max( 0, 255 - (int) (255 * (dose / limit1)) );
>       if ( dose < limit1 ) {
>          return new Color( 255, val, val );
>       }
>       if ( dose >= limit2 ) {
>          return Color.GREEN; // new Color( 216, 216, 216 );
>       }
>       return new Color( 160, 32, 240 );
>    }
> 
>    public static void updateButtonForDose( JButton btn, double dose ) {
>       final int limit1 = 200;
>       final int limit2 = 500;
>       int val = Math.max( 0, 255 - (int) (255 * (dose / limit1)) );
>       if ( dose < limit1 ) {
>          btn.setBackground( new Color( 255, val, val ) );
>          btn.setText( String.format( "%5.1f ", dose ) );
>       } else if ( dose >= limit2 ) {
>          btn.setIcon( Chorona.ICON_500 );
>          btn.setText( "" );
>       } else {
>          btn.setBackground( new Color( 160, 32, 240 ) );
>          btn.setText( String.format( "%d ", (int) dose ) );
>       }
>    }
> }
> ```

> [!example]- CHORona/Point.java
> ```java
> public class Point {
> 
>     @Override
>     public int hashCode() {
>       final int prime = 31;
>       int result = 1;
>       result = prime * result + this.x;
>       result = prime * result + this.y;
>       return result;
>     }
> 
>     @Override
>     public boolean equals(Object obj) {
>         if (this == obj) {
>          return true;
>       }
>         if (obj == null) {
>          return false;
>       }
>         if (this.getClass() != obj.getClass()) {
>          return false;
>       }
>         Point other = (Point) obj;
>         if (this.x != other.x) {
>          return false;
>       }
>         if (this.y != other.y) {
>          return false;
>       }
>         return true;
>     }    
> }
> ```

> [!example]- CHORona/Room.java
> ```java
> import java.util.Random;
> 
> /**
>  * Class to represent a room. Simulates the distribution of pollutants.
>  */
> public class Room implements IRoom {
> 
>    /**
>     * Random instance
>     */
>    private final static Random RND = new Random();
> 
>    /**
>     * Array with pollution values for each cell
>     */
>     private double[][] cells;
> 
>    /**
>     * Room setting with width/height and information about pollutants
>     */
>    private RoomSetting setting;
> 
>    /**
>     * Factor for current variant
>     */
>    private double factor;
> 
>    /**
>     * Current step
>     */
>    private int steps = 0;
>     
>    /**
>     * Initalize the room
>     * 
>     * @param factor
>     *           factor for the variant
>     * @param setting
>     *           setting for the room
>     */
>    public Room( double factor, RoomSetting setting ) {
>       this.factor = factor;
>       this.setting = setting;
>       this.cells = new double[setting.getHeight()][setting.getWidth()];
>     }
>     
>    /**
>     * Get the dose at x, y
>     * 
>     * @param x
>     *           x value
>     * @param y
>     *           y value
>     * @return dose at provided position
>     */
>     @Override
>    public double getDose(int x, int y) {
>       return this.cells[y][x];
>     }
>     
>    /**
>     * Set the dose at x, y
>     * 
>     * @param x
>     *           x value
>     * @param y
>     *           y value
>     * @param dose
>     *           dose to set at provided position
>     */
>     @Override
>    public void setDose(int x, int y, double dose) {
>       this.cells[y][x] = dose;
>     }
>     
>    /**
>     * Add the dose at x, y
>     * 
>     * @param x
>     *           x value
>     * @param y
>     *           y value
>     * @param dose
>     *           dose to add at provided position
>     */
>     @Override
>    public void addDose(int x, int y, double dose) {
>       this.setDose( x, y, dose + this.getDose( x, y ) );
>     }
> 
> 
>    /**
>     * Do a step (distribute pollution to neighbor cells)
>     */
>     @Override
>    public void step() {
>       this.pollute();
>         double[][] result = new double[this.cells.length][this.cells[0].length];
>       for ( int y = 0; y < this.setting.getHeight(); y++ ) {
>          for ( int x = 0; x < this.setting.getWidth(); x++ ) {
>                 double av = this.getAverageForCellAndNeighbours(x, y);
>             result[y][x] = av;
>             }
>         }    
>       for ( int y = 0; y < this.setting.getHeight(); y++ ) {
>          for ( int x = 0; x < this.setting.getWidth(); x++ ) {
>             this.cells[y][x] = result[y][x];
>             }
>         }    
>       this.steps++;
>     }
> 
>    /**
>     * Get the performed steps
>     * 
>     * @return performed steps
>     */
>    public int getSteps() {
>       return this.steps;
>    }
> 
>    /**
>     * Get the room setting
>     * 
>     * @return room setting
>     */
>    public RoomSetting getSetting() {
>       return this.setting;
>    }
> 
>    /**
>     * Add pollution to all cells with polluters
>     */
>    private void pollute() {
>       for ( Point p : this.getSetting().getPollutants() ) {
>          this.addDose( p.getX(), p.getY(), 50 + this.factor * Room.RND.nextDouble() );
>       }
>    }
> 
>    /**
>     * Calculate average for current cell and it's neighbors
>     * 
>     * @param x
>     *           x value of cell
>     * @param y
>     *           y value of cell
>     * @return average value
>     */
>    private double getAverageForCellAndNeighbours( int x, int y ) {
>       return this.getSumForCellAndNeighbours( x, y ) / this.getNoOfCellsForCellAndNeighbours( x, y );
>    }
> 
>    /**
>     * Get number cell plus it's neighbors
>     * 
>     * @param x
>     *           x value of cell
>     * @param y
>     *           y value of cell
>     * @return number of cells
>     */
>    private int getNoOfCellsForCellAndNeighbours( int x, int y ) {
>       int cellsNo = 0;
>       for ( int j = Math.max( y - 1, 0 ); j <= Math.min( this.setting.getHeight() - 1, y + 1 ); j++ ) {
>          for ( int i = Math.max( x - 1, 0 ); i <= Math.min( this.setting.getWidth() - 1, x + 1 ); i++ ) {
>             cellsNo++;
>          }
>       }
>       return cellsNo;
>    }
> 
>    /**
>     * Get sum of the values of current cell and it's neighbors
>     * 
>     * @param x
>     *           x value of cell
>     * @param y
>     *           y value of cell
>     * @return sum
>     */
>    private double getSumForCellAndNeighbours( int x, int y ) {
>       double sum = 0.0;
>       for ( int j = Math.max( y - 1, 0 ); j <= Math.min( this.setting.getHeight() - 1, y + 1 ); j++ ) {
>          for ( int i = Math.max( x - 1, 0 ); i <= Math.min( this.setting.getWidth() - 1, x + 1 ); i++ ) {
>             sum += this.cells[j][i];
>          }
>       }
>       return sum;
>    }
> }
> ```

## Aufgabenstellung ansehen
![[Material/Projekte/41b_CHORona_ProbePE_Download/CHORona/CHORona_ProbePE.pdf]]

## Aufgabentext (durchsuchbar)
> [!quote]- Kompletter Aufgabentext – aufklappen
> ```text
> Hinweis: Für die Bonuspunkt-Aufgabe am Ende der letzten Seite füllen Sie Kurs und
> Matrikelnummer aus und geben das Aufgabenblatt anders als bei der letzten Prüfung ebenfalls ab!
> Andere Notizen/Markierungen auf dem Aufgabenblatt werden nicht bewertet!
> 
> Hinweis zur Bewertung:
>     1/4 der Punkte (25%) wird nach Funktionstests Ihrer Lösung vergeben.
>     3/4 der Punkte (75%) werden entsprechend des in den Teilaufgaben
>        angegebenen Schlüssels auf Basis des Quellcodes vergeben.
> 
>    DHBW Karlsruhe, Vorlesung Programmieren I+II, Probe-Programmentwurf
> 
>                                        Bearbeitungszeit: 120 Minuten
> 
> Aufgabe
> Die letzten beiden Jahre ist immer wieder von Aerosol-Verbreitung in Innenräumen berichtet worden. Um dies besser
> zu veranschaulichen, soll für verschiedene Varianten von SARS-CoV-2 eine Simulation umgesetzt werden. Ihre
> Aufgabe ist es, dies in Form der grafischen Java-Anwendung Chorona zu entwickeln, welche ein (stark
> vereinfachtes!) Modell zur Aerosol-Verbreitung bei einer Chorprobe veranschaulicht.
> Der Raum wird hierfür in einzelne Zellen unterteilt und es werden zufällig infizierte Chormitglieder platziert.
> Anschließend wird in Zeitscheiben die Verbreitung der Viruspartikel simuliert und grafisch dargestellt. Der
> Algorithmus für die Übertragung in die jeweiligen Nachbarzellen wird Ihnen bereitgestellt.
> 
> Teilaufgabe a)                                                                                                           [8%]
> Zur Unterscheidung der verschiedenen Varianten von SARS-CoV-2 in unserem Programm soll zunächst ein
> komplexer Aufzählungstyp Variant realisiert werden.
> Der Konstanten-Name ist der griechische „Buchstabe“ der für die Variante vergeben wurde. Ein Label für die Anzeige
> (label) sowie die korrekte wissenschaftliche Bezeichnung (designation) sollen als Attribute erfasst werden:
>  Variant              Label                 Wiss. Bez.           Variant               Label                Wiss. Bez.
>  WILD_TYPE            Wildtyp               SARS-CoV-2           DELTA                 Delta                B.1.617
>  ALPHA                Alpha                 B.1.1.7              FETA                  Feta                 O.u.z.o
>  BETA                 Beta                  B.1.351              LAMBDA                Lambda               C.37
>  GAMMA                Gamma                 P.1                  OMICRON               Omikron              B.1.1.529
> 
> Teilaufgabe b)                                                                                                           [6%]
> Zur Nutzung der vorgegeben Klasse für die Viruslast-Verteilung muss die dort verwendete Java-Schnittstelle
> (Interface) IRoom realisiert werden. Folgende Methoden müssen definiert werden:
>     -   double getDose(int x, int y): Liefert Viruslast an den übergebenen Koordinaten des Rasters
>     -   void setDose(int x, int y, double dose): Setzt die Viruslast an den übergebenen Koordinaten
>     -   void addDose(int x, int y, double dose): Erhöht die Viruslast an den übergebenen Koordinaten
>     -   void step(): Simuliert eine „Zeitscheibe“ mit Ausatmen und Verteilung der Aerosole
> Hinweis: Sie müssen die Schnittstelle nur definieren, die Implementierung ist mit der Klasse Room bereits vorgegeben.
> 
> Teilaufgabe c)                                                                                                          [13%]
> Zur Definition einer Koordinate für infizierte Personen erweitern Sie die bereitgestellte Klasse Point, welche als
> Attribute zwei ganzzahlige Werte für die x- und y-Komponente einer Koordinate speichern kann. Definieren Sie einen
> Konstruktor der für beide Attribute Werte entgegennimmt und diese speichert.
> Hinweis: Ein Klassenrumpf mit vordefinierter hashCode und equals-Methode ist bereits vorgegeben. Ergänzen Sie sinnvoll!
> Um Parameter für den Verteilungsalgorithmus definieren zu können, erstellen Sie die Klasse RoomSetting, welche
> alle relevanten Informationen über einen Raum abspeichern kann. Das sind sowohl die Breite (width) und Höhe
> (height) des Rasters für den Raum (beide ganzzahlig) als auch eine Sammlung von Koordinaten mit den Positionen
> der infizierten Chormitglieder (pollutants).
> Der Konstruktor soll die Breite und Höhe als Parameter entgegennehmen. Darüber hinaus ist die Anzahl der infizierten
> Personen zu übergeben (vgl. Verwendung in vorgegebener Klasse Chorona).
> Sollte die Anzahl der sich aus Breite und Höhe ergebenen Felder kleiner sein als die Anzahl der übergebenen
> infizierten Personen ist eine selbst zu schreibende AHAException mit der übergebenen Nachricht „Insufficient
> singers“ zu werfen.
> Ansonsten ist die übergebene Anzahl an Infizierten auf zufällige Koordinaten des Rasters zu verteilen. Fügen Sie dazu
> für jeden Infizierten einen Punkt mit den entsprechenden zufälligen Koordinaten in pollutants ein. Duplikate
> müssen hierbei vermieden werden!
> 
> Teilaufgabe d)                                                                                                      [18%]
> Zur Visualisierung der Verbreitung setzen Sie nun die grafische Oberfläche in Form der Klasse ChoronaTerminal
> um. Der Konstruktor nimmt die Virus-Variante für das Fenster sowie die passende Room-Instanz entgegen (vgl.
> Verwendung in bereitgestellter Klasse Chorona) und speichert diese in den Attributen variant und room mit den
> entsprechenden Datentypen.
> Der Titel des Fensters ist nach dem Muster „Chorona - $variantLabel ($variantDesignation)“ zu setzen (vgl.
> Screenshot). Im oberen Bereich ist ein Label zur Anzeige der aktuellen Zeitschreibe („Step“) vorzusehen, darunter ein
> Bereich zur Anzeige des Rasters. Am unten Rand sind 3 Buttons Step, Play und Save vorzusehen.
> 
> Die übergebene Room-Instanz stellt Ihnen einige benötigte Informationen zur Verfügung:
>        Breite und Höhe des Rasters sowie die Positionen der infizierten Chormitglieder über die RoomSetting-
>         Instanz welche die getSettings -Methode liefert.
>        Die aktuelle Zeitscheibe (getStep-Methode)
>        Die aktuelle Belastung einer Zelle abhängig von x und y-Werten mit der getDose(x,y)-Methode.
> Zur Repräsentation einer Zelle im Raster sollen Sie eine weitere Klasse CellButton realisieren, welche von
> JButton erbt und zusätzlich die aktuelle Belastung (double dose) und einen Wahrheitswert zur Bestimmung ob die
> Zelle eine infizierte Person enthält oder nicht (polluter).
> Sollte die Zelle eine infizierte Person beinhalten ist ein deutlich sichtbarer der Rahmen (vgl. Hinweis unten) zu setzen!
> Wenn die Belastung des Buttons gesetzt wird, soll die vorgegebene Methode Chorona.updateButtonForDose
> aufgerufen werden, die sowohl den Text als auch die Hintergrundfarbe bzw. Icon des Buttons aktualisiert (vgl.
> Screenshot Deckblatt). Initial ist eine Belastung von 0 zu setzen (o.g. Methode aufrufen!).
> Beim Drücken des Step-Buttons soll nun die Verbreitung der Viruslast simuliert werden.
> Hierfür ist:
>        in der Room-Instanz durch Aufruf der step-Methode die Verbreitung der Viruslast für eine Zeitscheibe
>         auszulösen (Simuliert ausatmen + Verteilen)
>        danach die Nutzeroberfläche zu aktualisieren, d.h.
>             o die Anzeige der aktuellen Zeitscheibe („Steps“) aktualisieren
>             o sämtlichen CellButton-Instanzen die neue Belastung zu setzen (neu aus Room auslesen!).
> Hinweis 1: Um den Rahmen zur Markierung von Zellen mit infizierten Personen zu setzen, können Sie folgenden Aufruf in
> CellButton verwenden: this.setBorder(BorderFactory.createLineBorder(Color.BLACK,4));
> Hinweis 2: Die Klasse ChoronaTerminal wird in den Teilaufgaben g) und h) noch erweitert.
> 
> Teilaufgabe e)                                                                                                           [4%]
> Bisher sind in der bereitgestellten Klasse Chorona feste Zahlen für Breite, Höhe und Anzahl der infizierten Personen
> für die RoomSetting-Instanz vorgegeben. Überarbeiten Sie die Initialisierung nun so, dass zufällige Werte verwendet
> werden. Dabei soll
>        die Raumbreite zwischen 7 und 9 (jeweils inklusive!) sein,
>        die Raumhöhe ebenfalls zwischen 7 und 9 (jeweils inklusive!) sein
>        und die Anzahl der infizierten Personen zwischen 5 und 7 (jeweils inklusive!) betragen.
> 
> Teilaufgabe f)                                                                                                           [6%]
> Um die unterschiedliche Ansteckungswahrscheinlichkeit für die verschiedenen Varianten bei neuen
> wissenschaftlichen Erkenntnissen flexibel anpassen zu können, sollen diese aus einer Datei eingelesen werden.
> Ändern Sie die Implementierung der getPollutantFactors-Methode in der bereitgestellten Klasse Chorona (s.
> USB-Stick) nun so, dass die ebenfalls bereitgestellte Datei „pollutantfactors.txt“ (s. USB-Stick) zeilenweise
> eingelesen wird. Fehler müssen zwar abgefangen, aber nicht weiter behandelt werden.
> Dabei ist jede Zeile der Datei analog zu den vorgegebenen Beispiel-Daten mit Hilfe der bereitgestellten Methode
> parsePolluteFactor in die vorgegebene Map einzufügen.
> Hinweis: Damit die Einlese-Methode funktioniert, müssen die Konstanten des Aufzählungstyps Variant (vgl. Teilaufgabe a))
> exakt wie vorgegeben lauten. Dies betrifft auch Groß- und Kleinschreibung!
> 
> Teilaufgabe g)                                                                                                          [13%]
> Erweitern Sie die Klasse ChoronaTerminal (vgl. Teilaufgabe d)) nun so, dass beim Drücken des Save-Buttons der
> aktuelle Zustand des Fensters in eine Datei geschrieben wird. Der Dateiname soll aus Virusvariante, Raum-
> Breite/Höhe, Anzahl infizierter Personen und aktuellem Step zusammengesetzt werden (vgl. Screenshots).
> Falls die Datei bereits existiert, soll sie überschrieben werden. In jedem Fall soll ein Dialog am Ende angezeigt
> werden, der darüber informiert ob die Datei erfolgreich gespeichert wurde oder nicht:
> 
> Hinweis: Beispiel für Breite: 9, Höhe: 7, Infizierte: 6, Step: 2. Der Dateiname muss im Dialogtext erwähnt werden. Dialog-Titel
> & -Icon sind egal, sofern aus dem Text eindeutig Erfolgs- und Fehlerfall ersichtlich sind.
> Für jede Zelle soll nun eine Zeile mit ihren Koordinaten und dem aktuellen Wert für die Belastung geschrieben
> werden. Für ein 9x7-Raster hätte die Datei somit 63 Zeilen. Eine Zeile könnte bspw. so aussehen:
> 3;6;254.3 (für x=3, y=6 und dose=254.3)
> 
> Teilaufgabe h)                                                                                                           [7%]
> Erweitern Sie die Klasse ChoronaTerminal (vgl. Teilaufgabe d)) nun so, dass beim Drücken des Play-Buttons
> automatisch 20 Schritte im Abstand von 0,5s ausgelöst werden. Diese Aktion soll nebenläufig durchgeführt werden.
> Die nebenläufige Ausführung endet, nachdem die 20 Schritte durchgeführt wurden. Zu Beginn sind der Step- und
> Play-Button zu deaktivieren. Am Ende der Nebenläufigkeit werden beide wieder aktiviert.
> 
> Allgemeine Hinweise                                                                      Bonuspunkt: Zeichnen Sie (grob)
> Starten                                                                                  das Icon, welches bei einem
> Starten Sie die Anwendung mit der gegebenen Klasse Chorona                               Zellenwert größer 500 erscheint:
> (siehe USB-Stick).
> Schließen eines Fensters
> Beim Schließen eines Fensters soll die komplette Anwendung beendet werden.
> Sichtbarkeit von Instanz-Attributen
> Sämtliche Instanz-Attribute sind als privat zu definieren und von außerhalb der
> Klasse ggf. mittels Getter- und/oder Setter-Methoden zu verwenden.
> ```

## Meine Notizen

