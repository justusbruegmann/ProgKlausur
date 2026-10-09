---
tags: ["typ/programmentwurf", "kategorie/pruefung", "thema/datentypen", "thema/kontrollstrukturen", "thema/arrays", "thema/objektorientierung", "thema/klassen", "thema/strings", "thema/vererbung", "thema/exceptions", "thema/io", "thema/swing", "thema/zeichnen", "thema/datenstrukturen", "thema/enum", "thema/programmentwurf"]
art: "Probe-Programmentwurf"
status: "offen"
bearbeitungszeit: "120 Minuten"
---

# PE DBVasion

[[Programmentwurf – Übersicht|⬆ Programmentwurf – Übersicht]] · [[Start|🏠 Start]]

**Art:** Probe-Programmentwurf · **Bearbeitungszeit:** 120 Minuten

> [!abstract] Worum geht's?
> Fahrplan-Simulation, bei der die Pünktlichkeit an jedem Halt zufällig „ausgewürfelt“ wird. Gefordert sind die Klasse `Time` mit Plausibilitätsprüfung und eigener `DBException`, ein Enum `StopStatus` mit Farben, das Einlesen von Verbindungsdateien und eine grafische Anzeige mit eigener Komponente (`StopComponent`).

📄 Aufgabenstellung: [[Material/Projekte/41e_DBVasion_ProbePE_Download/ProbePE_DBVasion.pdf|ProbePE_DBVasion.pdf]]

## Teilaufgaben
- [ ] **a)** **[17 %]** Das Wichtigste in jedem Fahrplan ist die Erfassung von Zeiten. Schreiben Sie hierfür eine Klasse Time, welche die aktuelle Zeit als Stunde (hour) und Minute (minute) speichern kann.
- [ ] **b)** **[12 %]** Erstellen Sie nun eine Klasse Stop zur Repräsentation eines Halts während der Fahrt. Ein Halt besteht aus dem Namen des Bahnhofs (name), der Ankunftszeit (arrival vom Typ Time), der Aufenthaltsdauer (stayPeriod) sowie der Gleisnummer (stage).
- [ ] **c)** **[8 %]** Ändern Sie die loadConnections-Methode der Klasse DBVasion so ab, dass die Verbindungen aus der bereitgestellten Textdatei connections.txt zeilenweise eingelesen werden und anstatt der bereitgestellten Testdaten verwendet werden. Für das Parsen der Textzeilen in TrainConnection-Objekte nutzen Sie die zur Verfügung gestellte Methode parseConnection aus der Klasse DBVasion!
- [ ] **d)** **[18 %]** Schreiben Sie eine Klasse ConnectionSelectionTerm, welche eine grafische Nutzeroberfläche zur Auswahl einer verfügbaren Zugverbindung ermöglicht. Der Konstruktor von ConnectionSelectionTerm nimmt eine Liste von Zugverbindungen entgegen (vgl.
- [ ] **e)** **[9 %]** Erstellen Sie mittels der Klasse ConnectionTerm nun eine grafische Oberfläche, welche Einzelheiten zu einer Verbindung anzeigt. Diese Verbindung wird dem Konstruktor beim Erzeugen des Objekts übergeben.
- [ ] **f)** **[5 %]** Aktualisieren Sie nun Ihre Implementierung für den Kauf von Tickets aus Teilaufgabe c). Die Nachricht für den Ticket-Kauf, die bisher nur am Ende als Dialog angezeigt wurde soll nun noch in eine Datei mit dem Namen „tickets.txt“ geschrieben werden.
- [ ] **g)** **[6 %]** Abschließend soll nun eine Fahrt entsprechend simuliert werden. Standardmäßig sind in einer StopComponent sämtliche Haltebahnhöfe grau dargestellt, d.h. nicht erreicht worden.

## Benötigte Begriffe
[[Typkonversion]] · [[Konstante]] · [[Zufallszahlen]] · [[for-Schleife]] · [[Array]] · [[Konstruktor]] · [[this]] · [[static]] · [[toString]] · [[Kapselung]] · [[super]] · [[Enum]] · [[String]] · [[Wrapperklasse]] · [[Exception]] · [[Eigene Exception]] · [[BufferedReader und BufferedWriter]] · [[Datei und Pfad]] · [[Swing]] · [[JPanel]] · [[Swing-Komponenten]] · [[Layoutmanager]] · [[Look and Feel]] · [[Dialoge]] · [[Farben und Schriften]] · [[Zeichnen mit Graphics]] · [[List]] · [[Set]] · [[Programmentwurf]]

## Dafür wiederholen (Themen)
**Schwerpunkte:** [[08 Objektorientierung]] · [[09 Klassen und Objekte]] · [[13 Vererbung]] · [[14 Exceptions]] · [[15 Input und Output]] · [[20 Grafische Oberflächen mit Swing]] · [[24 Zeichnen in Swing]] · [[25 Datenstrukturen und Generics]] · [[26 Aufzählungstypen (Enums)]]

**Grundlagen:** [[04 Primitive Datentypen]] · [[06 Kontrollstrukturen]] · [[07 Arrays]] · [[10 Strings und Wrapperklassen]]

## Dateien
- [DBVasion.java](<Material/Projekte/41e_DBVasion_ProbePE_Download/DBVasion.java>)
- [IC-2036.txt](<Material/Projekte/41e_DBVasion_ProbePE_Download/IC-2036.txt>)
- [ICE-1171.txt](<Material/Projekte/41e_DBVasion_ProbePE_Download/ICE-1171.txt>)
- [ICE-509.txt](<Material/Projekte/41e_DBVasion_ProbePE_Download/ICE-509.txt>)
- [IRE-19673.txt](<Material/Projekte/41e_DBVasion_ProbePE_Download/IRE-19673.txt>)
- [ProbePE_DBVasion.pdf](<Material/Projekte/41e_DBVasion_ProbePE_Download/ProbePE_DBVasion.pdf>)
- [SBB-V.txt](<Material/Projekte/41e_DBVasion_ProbePE_Download/SBB-V.txt>)
- [SWB-E.txt](<Material/Projekte/41e_DBVasion_ProbePE_Download/SWB-E.txt>)
- [StopComponent.java](<Material/Projekte/41e_DBVasion_ProbePE_Download/StopComponent.java>)
- [connections.txt](<Material/Projekte/41e_DBVasion_ProbePE_Download/connections.txt>)

## Vorgegebener Code
> [!example]- DBVasion.java
> ```java
> import java.awt.Color;
> import java.awt.Graphics;
> import java.awt.image.BufferedImage;
> import java.io.IOException;
> import java.nio.charset.StandardCharsets;
> import java.nio.file.Files;
> import java.nio.file.Paths;
> import java.util.LinkedList;
> import java.util.List;
> 
> import javax.swing.ImageIcon;
> import javax.swing.JOptionPane;
> import javax.swing.UIManager;
> 
> public class DBVasion {
>     
>     public static void main(String[] args) {
>         try {
>             // Ensure cross platform look&feel on all platforms, including MacOS for foreground/background color support
>             UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName() );
>         } catch (Exception e) {
>         }
>         
>         try {
>             List<TrainConnection> connections = loadConnections();
> 
>             new ConnectionSelectionTerm(connections);
>         } catch (DBException e) {
>             e.printStackTrace();
>         }
>     }
>     
>     public static List<TrainConnection> loadConnections() throws DBException {
>         List<TrainConnection> conns = new LinkedList<>();
>         
>         // REPLACE CODE BELOW
>         String[] dummies = new String[] {
>             "ICE-1;Hamburg Altona;München Hbf;false;123.40",
>             "ICE-2;Hamburg Altona;München Hbf;false;123.40",
>             "ICE-3;Hamburg Altona;München Hbf;false;123.40"
>         };
>         
>         for ( String dummy : dummies ) {
>             TrainConnection tc = DBVasion.parseTrainConnection(dummy);
>             if ( tc!=null ) {
>                 conns.add(tc);
>             }
>         }
>         // REPLACE CODE ABOVE
>         
>         for ( TrainConnection tc : conns ) {
>             tc.setStops(DBVasion.loadTrainStops(tc.getName()));
>         }
>         
>         return conns;
>     }
>         
>     private static List<Stop> loadTrainStops(String trainName) throws DBException {
>         String[] dummies = new String[] {
>                 "10:17;0;Hamburg-Altona;11",
>                 "10:25;1;Hamburg Dammtor;4",
>                 "10:31;3;Hamburg Hbf;5",
>                 "12:08;2;Berlin-Spandau;5",
>                 "12:20;9;Berlin Hbf (tief);1",
>                 "12:34;2;Berlin Südkreuz;3",
>                 "13:10;1;Lutherstadt Wittenberg Hbf;2",
>                 "13:42;6;Leipzig Hbf;14",
>                 "14:29;2;Erfurt Hbf;1",
>                 "15:14;2;Bamberg;3",
>                 "15:36;2;Erlangen;4",
>                 "15:52;3;Nürnberg Hbf;9",
>                 "17:01;0;München Hbf;20"
>         };
>         
>         String filename = trainName + ".txt"; // train name "ICE-123" => ICE-123.txt
>         
>         List<Stop> stops = new LinkedList<>();
>         
>         // REPLACE CODE BELOW
>         // !! Adapt loadConnections first. The dummy connections !!
>         // !! ICE-1, ICE-2 and ICE-3 do not have matching        !!
>         // !! connection stop files.                             !!
>         for ( String dummy : dummies ) {
>             Stop stop = DBVasion.parseStops(dummy);
>             if ( stop != null ) {
>                 stops.add(stop);
>             }
>         }
>         // REPLACE CODE ABOVE
> 
>         return stops;
>     }
>     
>     private static TrainConnection parseTrainConnection(String line) {
>         String[] parts = line.split("[;]");
>         if ( parts.length == 5 ) {
>             boolean regional = Boolean.parseBoolean(parts[3]);
>             double price = Double.parseDouble(parts[4]);
>             return new TrainConnection(parts[0],parts[1],parts[2], regional, price);
>         }
>         return null;
>     }
> 
>     
>     private static Stop parseStops(String line) throws DBException {
>         String[] parts = line.split("[;]");
>         if ( parts.length == 4 ) {
>             String name = parts[2];
>             int stayPeriod = Integer.parseInt(parts[1]);
>             int stage = Integer.parseInt(parts[3]);
>             
>             String[] timeParts = parts[0].split("[:]");
>             Time time = new Time(Integer.parseInt(timeParts[0]), Integer.parseInt(timeParts[1]));
>             
>             
>             return new Stop(name, time, stayPeriod, stage);
>         }
>         return null;
>     }
>     
>     public static ImageIcon createDLTicketIcon() {
>         int barH = 4;
>         int width = 16;
>         BufferedImage img = new BufferedImage(width, barH*3, BufferedImage.TYPE_3BYTE_BGR);
>         Graphics g = img.createGraphics();
>         g.setColor(Color.BLACK);
>         g.fillRect(0, 0, width, barH);
>         g.setColor(Color.RED);
>         g.fillRect(0, barH, width, barH);
>         g.setColor(Color.YELLOW);
>         g.fillRect(0, barH*2, width, barH);
>         g.dispose();
>         return new ImageIcon(img);
>     }
> 
> }
> ```

> [!example]- StopComponent.java
> ```java
> import java.awt.BorderLayout;
> import java.awt.Color;
> import java.awt.GridLayout;
> 
> import javax.swing.BorderFactory;
> import javax.swing.JLabel;
> import javax.swing.JPanel;
> 
> @SuppressWarnings("serial")
> public class StopComponent extends JPanel {
> 
>     private final static Color NOT_REACHED = new Color(0x64, 0x69, 0x73);
>     
> 
>     public final static String[] DELAY_REASONS = {
>             "Kurzfristiger Personalausfall",
>             "Versp\u00e4tetes Personal aus vorheriger Fahrt ",
>             "Warten auf Anschlussreisende",
>             "Verz\u00f6gerungen im Betriebsablauf",
>             "Bahnsteigl\u00e4nge nicht ausreichend",
>             "Kraftstoffaufnahme vor der Abfahrt",
>             "Schaden Oberleitung/ Ausr\u00fcstungsteile",
>             "Fernsprecheinrichtungen gest\u00f6rt",
>             "Vegetation im Fahrwegprofil",
>             "Schlechte Signalsicht durch Sonneneinstrahlung",
>             "St\u00f6rung an der Weichenheizanlage",
>             "Fehlende/ ungen\u00fcgende Fahrstromversorgung",
>             "Defekte Fahrgastinformationsanlagen",
>             "Teilr\u00e4umung wegen erh\u00f6htem Reisendenaufkommen",
>             "Verz\u00f6gerungen durch Reisendenverhalten",
>             "Au\u00dferplanm\u00e4\u00dfiger Halt f\u00fcr Reisende",
>             "Tiertransporte (F\u00fcttern/ Tr\u00e4nken)",
>             "Dienstunf\u00e4hig w\u00e4hrend der Schicht",
>             "Au\u00dferplanm\u00e4\u00dfige Zugbildung",
>             "Warten auf Schiebelok",
>             "K\u00fchlpausen wegen Motor\u00fcberhitzungen",
>             "Energiesparendes Fahren verursacht Versp\u00e4tung",
>             "Arbeitsschutzpause",
>             "Warten auf Papiere",
>             "Streik Rangierpersonal",
>             "Schnee auf den Schrankenb\u00e4umen",
>             "Vereisung der Oberleitung",
>             "Rettungseinsatz am Bahnsteig/ am Zug",
>             "Fahndungs- und Ermittlungsarbeiten",
>             "Zeitumstellung",
>             "L\u00f6scharbeiten in Gleisn\u00e4he",
>             "Missbrauch Notbremse durch Reisende",
>             "Wassereinbruch in Gleisn\u00e4he",
>             "Sprengstoffverd\u00e4chtiges Gep\u00e4ckst\u00fcck",
>             "Zugentgleisung",
>             "Anschlussaufnahme - Zubringer versp\u00e4tet",
>             "Besch\u00e4digungen/ Eingriffe durch Fremde oder Tiere",
>             "B\u00f6schungsbrand",
>             "Bombendrohung",
>             "Bahnsteigverfehlungen/ erforderliches Zur\u00fccksetzen"
>     };
>     
>     private final JLabel lblArrivalPlan = new JLabel("00:00");
>     private final JLabel lblArrivalActual = new JLabel("00:00");
>     private final JLabel lblDeparturePlan = new JLabel("00:00");
>     private final JLabel lblDepartureActual = new JLabel("00:00");
>     private final JLabel lblStage = new JLabel("0", JLabel.CENTER);
>     private final JLabel lblDelayReason = new JLabel("", JLabel.CENTER);
>     private final JLabel lblStopName = new JLabel("Hbf", JLabel.CENTER);
>     
>     private final Stop stop;
>     
>     public StopComponent(Stop stop) {
>         super(new BorderLayout(2,2));
>         setBorder(BorderFactory.createEtchedBorder());
>         this.stop = stop;
> //        this.delayReasonIdx = (int)(Math.random()*DELAY_REASONS.length);
>         
>         this.lblArrivalActual.setOpaque(true);
>         this.lblDepartureActual.setOpaque(true);
>         
>         // the four time labels on the left
>         final JPanel arrivalDeparture = new JPanel(new GridLayout(2, 2, 10, 2));
>         arrivalDeparture.add(this.lblArrivalPlan);
>         arrivalDeparture.add(this.lblArrivalActual);
>         arrivalDeparture.add(this.lblDeparturePlan);
>         arrivalDeparture.add(this.lblDepartureActual);
>         this.lblArrivalPlan.setText(stop.getArrival().toString());
>         Time departure = getTimeWithDifference(stop.getArrival(), stop.getStayPeriod());
>         this.lblDeparturePlan.setText(departure.toString());
>         this.add(arrivalDeparture, BorderLayout.WEST);
>         
>         // stage info on the right
>         final JPanel stagePanel = new JPanel(new GridLayout(2, 1, 5, 5));
>         this.lblStage.setText(String.valueOf(stop.getStage()));
>         stagePanel.add(new JLabel("Stage", JLabel.CENTER));
>         stagePanel.add(this.lblStage);
>         this.add(stagePanel, BorderLayout.EAST);
>         
>         this.lblDelayReason.setForeground(Color.RED);
>         this.add(this.lblDelayReason, BorderLayout.SOUTH);
> 
>         this.setStopReached(false);
>         this.lblStopName.setText(stop.getName());
>         this.add(lblStopName, BorderLayout.CENTER);
>         
>         setDelay(0);
>     }
>     
>     public void setStopReached(boolean reached) {
>         this.lblStopName.setForeground(reached?Color.BLACK:NOT_REACHED);
>     }
>     
>     public void setReason(String text) {
>         if ( text == null || text.trim().isEmpty() ) {
>             text = "";
>         }
>         this.lblDelayReason.setText(text);
>     }
>     public void setDelay(int minutes) {
>         StopStatus status = StopStatus.get(minutes);
>         
>         this.lblArrivalActual.setForeground(status.getTextColor());
>         this.lblDepartureActual.setForeground(status.getTextColor());
>         this.lblArrivalActual.setBackground(status.getBackgroundColor());
>         this.lblDepartureActual.setBackground(status.getBackgroundColor());
>         
>         Time arrival = getTimeWithDifference(stop.getArrival(), minutes);
>         Time departure = getTimeWithDifference(stop.getArrival(), stop.getStayPeriod()+minutes);
>         
>         this.lblArrivalActual.setText(arrival.toString());
>         this.lblDepartureActual.setText(departure.toString());
>     }
>     
>     private Time getTimeWithDifference(Time time, int diffMinutes) {
>         int minute = time.getMinute() + diffMinutes;
>         int hour = time.getHour();
>         
>         if ( minute < 0 ) {
>             hour--;
>             minute = 60-minute;
>         }
>         if ( minute > 60 ) {
>             hour++;
>             minute -= 60;
>         }
>         try {
>             return new Time(hour, minute);
>         } catch (DBException e) {
>             return time;
>         }
> 
>     }
> }
> ```

## Aufgabenstellung ansehen
![[Material/Projekte/41e_DBVasion_ProbePE_Download/ProbePE_DBVasion.pdf]]

## Aufgabentext (durchsuchbar)
> [!quote]- Kompletter Aufgabentext – aufklappen
> ```text
> Hinweis zur Bewertung:
>    • 1/4 der Punkte (25%) wird nach Funktionstests Ihrer Lösung vergeben.
>    • 3/4 der Punkte (75%) werden entsprechend des in den Teilaufgaben
>        angegebenen Schlüssels auf Basis des Quellcodes vergeben.
> Deko-Bild erzeugt mit Adobe Firefly 2, Prompt: „Fast white train moving on rails; clock in the background“. Stile: Kunst, Schichtpapier
> 
>                        DHBW Karlsruhe, Vorlesung Programmieren I+II
>                                          Probe-Programmentwurf
>                                      Bearbeitungszeit: 120 Minuten
> 
> Aufgabe
> Die Situation ist sicher bekannt: Sie stehen am Gleis und warten darauf, dass Ihr Zug zu der Zeit einfährt, die vorher
> vom Beförderungsunternehmen („Der Betreiber“, kurz: DB) im Fahrplan kommuniziert wurde. Es soll jedoch schon
> vorgekommen sein, dass die erlebte Realität von dieser Information – auch kurzfristig in der App – abwich.
> 
> Daher soll ein Experiment durchgeführt werden: Ist es evtl. ressourcenschonender und auch nicht weniger genau,
> wenn die Fahrten nicht mehr per Monitoring in großen Server-Farmen analysiert und dann angezeigt würden, sondern
> die Pünktlichkeit an den einzelnen Halten einfach vor Fahrtantritt einmalig ausgewürfelt wird. Studien haben
> außerdem gezeigt, dass von den Kunden die Anzeige von Gründen bei Verspätungen als positiv wahrgenommen wird,
> weshalb diese ebenso zufällig zugewiesen werden. Realisieren Sie dies in Form der Java-Anwendung DBVasion!
> 
> Teilaufgabe a)                                                                                                  [17%]
> Das Wichtigste in jedem Fahrplan ist die Erfassung von Zeiten. Schreiben Sie hierfür eine Klasse Time, welche die
> aktuelle Zeit als Stunde (hour) und Minute (minute) speichern kann. Für die spätere Anzeige implementieren Sie die
> toString()-Methode und geben dort die Zeit in der Form hh:mm (also bspw. 08:15) als Zeichenkette zurück.
> Der Konstruktor nimmt die Werte für hour und minute in exakt dieser Reihenfolge entgegen (vgl. Verwendung in
> der bereitgestellten Klasse DBVasion) und speichert diese. Zusätzlich ist jedoch eine Plausibilitätsprüfung
> vorzunehmen: Die Werte für die Stunde dürfen nur im Bereich 0 bis 23, für die Minute im Bereich 0 bis 59 (jeweils
> inklusive) liegen. Ist dies nicht der Fall ist eine selbst zu schreibende, sprechende DBException zu werfen, deren
> Nachricht auf den gültigen Wertebereich hinweist!
> Um verschiedene Halte auf einer Fahrt zu klassifizieren, soll der komplexe Aufzählungstyp StopStatus umgesetzt
> werden. Neben der eigentlichen Konstante besetzt der Status eine Farbe für den Text (textColor) sowie den
> Hintergrund (backgroundColor), für die spätere Anzeige in einer grafischen Oberfläche.
> Folgende Statustypen sollen implementiert werden:
>  StopStatus                              Text-Farbe                               Hintergrund-Farbe
>  ON_SCHEDULE                             Color.BLACK                              new Color(0, 150, 0)
>  REASONABLE                              Color.BLACK                              new Color(150, 150, 255)
>  DELAYED                                 Color.WHITE                              Color.RED
> 
> Um den Status für einen konkreten Halt zu erhalten, realisieren Sie zusätzlich die statische Methode
> public static StopStatus get(int delay)
> welche bei einer Verspätung von 0 oder weniger Minuten StopStatus.ON_SCHEDULE, bei weniger als 6 Minuten
> StopStatus.REASONABLE und StopStatus.DELAYED in jedem anderen Fall zurückgibt.
> Hinweis: Die Verwendung der Text- und Hintergrundfarbe sowie der statischen get-Methode können Sie in der Methode
> setDelay der bereitgestellten Klasse StopComponent sehen.
> 
> Teilaufgabe b)                                                                                                  [12%]
> Erstellen Sie nun eine Klasse Stop zur Repräsentation eines Halts während der Fahrt. Ein Halt besteht aus dem
> Namen des Bahnhofs (name), der Ankunftszeit (arrival vom Typ Time), der Aufenthaltsdauer (stayPeriod)
> sowie der Gleisnummer (stage).
> Schreiben Sie einen Konstruktor, der die Attribute in exakt dieser Reihenfolge (vgl. Verwendung in bereitgestellter
> Klasse DBVasion) entgegennimmt und in den Instanz-Attributen speichert.
> Um eine Zugverbindung als Ganze abbilden zu können, implementieren Sie nun die Klasse TrainConnection. Eine
> Zugverbindung besteht aus einem Namen (name), dem Start- und Endbahnhof (start, end), einem Wahrheitswert,
> der aussagt, ob die Verbindung zum Regionalverkehr gehört (regional), dem Preis für ein reguläres Ticket (price)
> sowie einer Liste von Halten (stops).
> 
> Der Konstruktor nimmt die ersten fünf der Attribute in exakt dieser Reihenfolge (vgl. Verwendung in bereitgestellter
> Klasse DBVasion) entgegen und speichert diese in den Instanz-Attributen. Die Halte werden nachträglich mit der Set-
> Methode für die stops-Instanz-Variable gesetzt (vgl. Verwendung in bereitgestellter Klasse DBVasion).
> 
> Teilaufgabe c)                                                                                                  [8%]
> Ändern Sie die loadConnections-Methode der Klasse DBVasion so ab, dass die Verbindungen aus der
> bereitgestellten Textdatei connections.txt zeilenweise eingelesen werden und anstatt der bereitgestellten
> Testdaten verwendet werden. Für das Parsen der Textzeilen in TrainConnection-Objekte nutzen Sie die zur
> Verfügung gestellte Methode parseConnection aus der Klasse DBVasion!
> Ändern Sie außerdem zusätzlich die loadTrainStops-Methode der Klasse DBVasion so ab, dass die Halte für den
> übergebenen Verbindungsnamen aus einer der bereitgestellten Text-Dateien geladen wird. Der zu verwendende
> Dateiname ist in der Variable filename vordefiniert (bspw. ICE-509.txt für den Zug mit dem Namen ICE-509).
> Lesen Sie die Datei ebenso zeilenweise ein und verwenden Sie diese anstatt der bereitgestellten Testdaten. Für das
> Parsen der Textzeilen in Stop-Objekte nutzen Sie die zur Verfügung gestellte Methode parseStop aus der Klasse
> DBVasion!
> Sollten beim Lesen Fehler auftreten sind diese abzufangen, müssen aber nicht weiter behandelt werden.
> 
> Teilaufgabe d)                                                                                                  [18%]
> Schreiben Sie eine Klasse ConnectionSelectionTerm, welche eine grafische
> Nutzeroberfläche zur Auswahl einer verfügbaren Zugverbindung ermöglicht. Der
> Konstruktor von ConnectionSelectionTerm nimmt eine Liste von
> Zugverbindungen entgegen (vgl. Verwendung in bereitgestellter Klasse DBVasion).
> Der Titel des Fensters ist auf „Connections“ zu setzen. Im oberen Bereich ist ein
> Feld für die Eingabe des Namens samt Beschriftung vorzusehen. Für jede dem
> Konstruktor übergebene Verbindung sollen darunter zeilenweise zwei Buttons
> erstellt werden. Einen mit dem Verbindungsnamen als Text, einen mit der Aufschrift „Buy Ticket“.
> Sollte die Verbindung Teil des Regionalverkehrs sein (vgl. Teilaufgabe b)), ist dem ersten der beiden Buttons
> zusätzlich ein entsprechendes Icon zu setzen (Hinweise beachten, Ansicht siehe Deckblatt).
> Hinweis: Ein Icon können Sie auf einen JButton mittels button.setIcon(icon) setzen. Die ImageIcon-Instanz wird Ihnen
> von DBVasion.createDLTicketIcon bereitgestellt.
> Wird ein Verbindungsbutton ausgewählt ist („normalerweise“, Ausnahme s.u.) für die
> entsprechende Verbindung ein neues Fenster mit den Verbindungsinformationen
> (welches Sie in Teilaufgabe d) erstellen werden) anzuzeigen.
> Aus aktuellem Anlass soll in 70% der Fälle das Fenster jedoch nicht erscheinen und
> stattdessen eine Meldung angezeigt werden, dass die Verbindung leider entfällt.
> Wird ein Button zum Kaufen eines Tickets ausgewählt, soll zunächst geprüft werden, ob
> ein Name eingegeben wurde. Ist dies nicht der Fall, soll ein Dialog darüber informieren.
> Um die Kunden für unser Transportmittel zu begeistern, gibt es die Möglichkeit ein
> Ticket zum Super-Sparpreis mit 80% Rabatt (quasi ein „Lo(c)k-Angebot“!) angeboten.
> Fragen Sie in einem Dialog, ob ein solches Ticket erworben werden soll. Neben dem
> Rabatt-Angebot von 80% muss auch der reguläre Preis der Verbindung angezeigt werden (Hinweise beachten!)
> 
> Abhängig von Dialog-Auswahl berechnen Sie den endgültigen Preis für das Ticket und geben diesen in einer Meldung
> zusammen mit dem Namen der Verbindung, dem Namen der reisenden Person sowie der Ticket-Art (Super-Sparpreis
> bzw. Regular) aus!
> Hinweis: Die Rabatt-Abfrage kann mit boolean discount = JOptionPane.showConfirmDialog(parent, msg,
> "Discount?", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION realisiert werden..
> Hinweis: Sie müssen die Gleitkomma-Werte zur Vereinfachung nicht auf zwei Nachkommastellen runden
> Hinweis: Diese Funktionalität wird in Teilaufgabe f) noch erweitert.
> 
> Teilaufgabe e)                                                                                                  [9%]
> Erstellen Sie mittels der Klasse ConnectionTerm nun eine
> grafische Oberfläche, welche Einzelheiten zu einer Verbindung
> anzeigt. Diese Verbindung wird dem Konstruktor beim Erzeugen
> des Objekts übergeben.
> Der Titel des Fensters ist auf den Verbindungsnamen zu setzen.
> Für jeden Halt ist untereinander die entsprechende Information zu
> Abfahrtszeiten, Name und Gleis anzuzeigen.
> Nutzen Sie hierfür die bereitgestellt Klasse StopComponent
> (siehe USB-Stick), welche die grafische Oberfläche für einen
> Halt bereits realisiert.
> Berechnen Sie ebenfalls die Verspätungen für die Fahrt. Es
> beginnt immer pünktlich (Verspätung von 0 Minuten) und fügen
> Sie dann für jeden Halt eine zufällige Verspätung zwischen -5
> (auch Aufholen ist möglich!) und 10 Minuten (jeweils inklusive)
> hinzu und übergeben den jeweils aktuellen Wert der Komponente
> für den aktuellen Halt.
> Sollte bei einem Halt eine Verspätung von insgesamt mehr als 10
> Minuten vorhanden sein, setzen Sie noch eine zufälligen
> Verspätungsgrund. Der Text kann mit
> stopComp.setReason(text) gesetzt werden, ein Array mit
> allen verfügbaren Gründen ist unter
> StopComponent.DELAY_REASONS verfügbar.
> Hinweis: Die Funktionalität wird in Teilaufgabe g) noch erweitert!
> 
> Teilaufgabe f)                                                                                                  [5%]
> Aktualisieren Sie nun Ihre Implementierung für den Kauf von Tickets aus Teilaufgabe c).
> Die Nachricht für den Ticket-Kauf, die bisher nur am Ende als Dialog angezeigt wurde soll nun noch in eine Datei mit
> dem Namen „tickets.txt“ geschrieben werden. Sollte die Datei bereits existieren sind weitere Inhalte an das Ende
> der Datei anzuhängen.
> Fehler beim Schreiben der Datei sind abzufangen, müssen aber nicht weiter behandelt werden.
> 
> Teilaufgabe g)                                                                                                  [6%]
> Abschließend soll nun eine Fahrt entsprechend simuliert werden. Standardmäßig sind in einer StopComponent
> sämtliche Haltebahnhöfe grau dargestellt, d.h. nicht erreicht worden. Wird die Komponente auf „Stop erreicht“ gesetzt
> (Aufruf von stopComponent.setStopReached(true)), wird die Schrift schwarz.
> Starten Sie einen nebenläufigen Programmteil, welcher vom ersten bis zum letzten Halt nach und nach den Zustand
> der entsprechenden Komponente als erreicht setzt. Vor jedem Halt ist dabei eine zufällige Zeit zwischen zwei und fünf
> Sekunden zu warten, bevor er auf „erreicht“ gesetzt wird. Die Nebenläufigkeit endet, sobald alle Halte abgearbeitet
> wurden.
> 
> Allgemeine Hinweise
> Starten
> Starten Sie die Anwendung mit der gegebenen Klasse DBVasion (siehe USB-Stick).
> Schließen eines Fensters
> Beim Schließen eines Fensters soll die komplette Anwendung beendet werden.
> Sichtbarkeit von Instanz-Attributen
> Sämtliche Instanz-Attribute sind als privat zu definieren und von außerhalb der Klasse ggf. mittels Getter- und/oder
> Setter-Methoden zu verwenden.
> 
>                                                                                                        ____
>                                                                                                        |DB|____T_
>                                                                                                        |_ |_____|<
>                                                                                                          @-@-@-oo\
> ```

## Meine Notizen

