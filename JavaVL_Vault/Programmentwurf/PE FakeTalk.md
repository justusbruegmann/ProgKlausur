---
tags: ["typ/programmentwurf", "kategorie/pruefung", "thema/datentypen", "thema/operatoren", "thema/kontrollstrukturen", "thema/arrays", "thema/objektorientierung", "thema/klassen", "thema/strings", "thema/exceptions", "thema/io", "thema/swing", "thema/interfaces", "thema/datenstrukturen", "thema/enum", "thema/programmentwurf"]
art: "Probe-Programmentwurf"
status: "offen"
bearbeitungszeit: "120 Minuten"
---

# PE FakeTalk

[[Programmentwurf – Übersicht|⬆ Programmentwurf – Übersicht]] · [[Start|🏠 Start]]

**Art:** Probe-Programmentwurf · **Bearbeitungszeit:** 120 Minuten

> [!abstract] Worum geht's?
> Spiel zur Einordnung von Zitaten („Hot shit“ oder „Bullshit“). Gefordert sind ein komplexer Enum `QuoteType` mit Label, Icon und Farbe, die Klasse `Quote`, das Einlesen einer CSV-Datei, eine Swing-Oberfläche mit Zitat-Anzeige und eine Punktevergabe.

📄 Aufgabenstellung: [[Material/Projekte/41f_FakeTalk_ProbePE_Download/FakeTalk_ProbePE.pdf|FakeTalk_ProbePE.pdf]]

## Teilaufgaben
- [ ] **a)** **[6 %]** Um verschiedene Einordneungen von Zitaten im Programm zu ermöglichen soll zunächst ein komplexer Aufzählungstyp QuoteType realisiert werden. Der Aufzählungstyp soll hierbei neben der Konstante ein menschenlesbares Label (label), ein Bild für die spätere Darstellung (icon) sowie eine Farbe (color) realisieren.
- [ ] **b)** **[7 %]** Zur Repräsentation eines Zitats soll die Klasse Quote umgesetzt werden. Ein Zitat besteht aus dem Text (text), der Name der Person, welche dies gesagt bzw. geschrieben hat (person), deren Funktion (role), der Quelle des Zitats (source) sowie dem Typ des Zitats (type, vgl.
- [ ] **c)** **[5 %]** Um neben unserem Beispiel-Client später weitere Clients problemlos ergänzen zu können soll eine Java-Schnittstelle FakeTalkClient realisiert werden, welche folgende Methoden für spätere Implementierungen definiert: - String getPlayerName(): soll den Namen des Spielers zurückgeben - void setQuote(Quote q): setzt dem Client das Zitat und aktualisiert ggf. die Anzeige - void addPoints(int points): …
- [ ] **d)** **[30 %]** Wie auf dem Deckblatt zu sehen sollen Spieler ein Zitat auswählen können. Schreiben Sie hierfür eine Klasse QuoteSelectionTerm, die dies in Form einer grafischen Oberfläche ermöglicht.
- [ ] **e)** **[12 %]** Als grafische Oberfläche zur Einordnung von Zitaten durch Spieler ist eine Klasse QuoteTerm umzusetzen. Diese ist natürlich eine Ausprägung der Schnittstelle FakeTalkClient und realisiert die hierdurch vorgegebene Funktionalität wie in Teilaufgabe c) beschrieben.
- [ ] **f)** **[5 %]** Ändern Sie die Implementierung der loadQuotes-Methode in der bereitgestellten Klasse FakeTalk (s. USB-Stick) so, dass die auf dem USB-Stick bereitgestellte Datei „corona.csv“ (CSV \= „Catalog of shit verses“ 😉) zeilenweise eingelesen wird.
- [ ] **g)** **[5 %]** Erweitern Sie die answerSelected-Methode von QuoteSelectionTerm (siehe Teilaufgabe d)) nun so, dass zum Ende des Spiels die zuvor lediglich im Dialog angezeigte Nachricht zusätzlich in eine Textdatei mit dem Namen „fake-score.txt“ gespeichert wird. Sollte die Textdatei bereits existieren, ist die Nachricht als neue Zeile an das Ende anzuhängen.
- [ ] **h)** **[5 %]** Erweitern Sie die Klasse QuoteSelectionTerm (vgl. Teilaufgabe d)) nun so, dass alle zwei Sekunden die Punktzahl für die Beantwortung des Zitattyps um einen Punkt reduziert wird.

## Benötigte Begriffe
[[Konstante]] · [[Arithmetische Operatoren]] · [[Bedingungsoperator]] · [[Formatierte Ausgabe]] · [[Zufallszahlen]] · [[for-Schleife]] · [[Array]] · [[Mehrdimensionales Array]] · [[Konstruktor]] · [[this]] · [[static]] · [[Kapselung]] · [[Vererbung]] · [[Interface]] · [[Enum]] · [[String]] · [[Exception]] · [[Eigene Exception]] · [[Reader und Writer]] · [[BufferedReader und BufferedWriter]] · [[Datei und Pfad]] · [[Swing]] · [[Swing-Komponenten]] · [[Dialoge]] · [[Farben und Schriften]] · [[List]] · [[Programmentwurf]]

## Dafür wiederholen (Themen)
**Schwerpunkte:** [[08 Objektorientierung]] · [[09 Klassen und Objekte]] · [[14 Exceptions]] · [[15 Input und Output]] · [[20 Grafische Oberflächen mit Swing]] · [[21 Abstrakte Klassen und Interfaces]] · [[25 Datenstrukturen und Generics]] · [[26 Aufzählungstypen (Enums)]]

**Grundlagen:** [[04 Primitive Datentypen]] · [[05 Operatoren]] · [[06 Kontrollstrukturen]] · [[07 Arrays]] · [[10 Strings und Wrapperklassen]]

## Dateien
- [FakeTalk.java](<Material/Projekte/41f_FakeTalk_ProbePE_Download/FakeTalk.java>)
- [FakeTalkIcons.java](<Material/Projekte/41f_FakeTalk_ProbePE_Download/FakeTalkIcons.java>)
- [FakeTalk_ProbePE.pdf](<Material/Projekte/41f_FakeTalk_ProbePE_Download/FakeTalk_ProbePE.pdf>)
- [QuoteDisplay.java](<Material/Projekte/41f_FakeTalk_ProbePE_Download/QuoteDisplay.java>)
- [corona.csv](<Material/Projekte/41f_FakeTalk_ProbePE_Download/corona.csv>)

## Vorgegebener Code
> [!example]- FakeTalk.java
> ```java
> import java.io.BufferedReader;
> import java.io.FileReader;
> import java.util.LinkedList;
> import java.util.List;
> 
> public class FakeTalk {
> 
>    public static void main( String[] args ) {
>       List<Quote> quotes = FakeTalk.loadQuotes( "corona.csv" );
>       try {
>          QuoteSelectionTerm selectionTerm = new QuoteSelectionTerm( quotes, 3, 4 );
> 
>          QuoteTerm t1 = new QuoteTerm( "Muenchhausen", selectionTerm );
>          QuoteTerm t2 = new QuoteTerm( "Pinocchio", selectionTerm );
>          selectionTerm.register( t1 );
>          selectionTerm.register( t2 );
> 
>          selectionTerm.start();
>       } catch ( FakeNewsException e ) {
>          e.printStackTrace();
>       }
>    }
> 
>    private static List<Quote> loadQuotes( String filename ) {
>       List<Quote> quotes = new LinkedList<>();
> 
>       // REPLACE THE CODE BELOW!
>       for ( int i = 1; i <= 25; i++ ) {
>          quotes.add( FakeTalk.parseQuote( String.format( "%b;Quote Text %d;John Doe;Head of Dummy-Data Department %d;Source Code, 17.10.2022;", i % 2 == 0, i, i ) ) );
>       }
>       // REPLACE THE CODE ABOVE!
> 
>       return quotes;
>    }
> 
>    private static Quote parseQuote( String s ) {
>       if ( s != null ) {
>          String[] parts = s.trim().split( ";" );
>          if ( parts.length == 6 || parts.length == 5 ) {
>             return new Quote( parts[1], parts[2], parts[3], parts[4], Boolean.parseBoolean( parts[0] ) ? QuoteType.HOT_SHIT : QuoteType.BULLSHIT );
>          }
>       }
>       return null;
>    }
> 
> }
> ```

> [!example]- FakeTalkIcons.java
> ```java
> import javax.swing.ImageIcon;
> 
> /**
>  * Icons required for the FakeTalk application
>  */
> public class FakeTalkIcons {
> 
>    /**
>     * Image icon for quote type 'hot shit' (Source:
>     * https://openmoji.org/library/emoji-1F32D/)
>     */
>    public final static ImageIcon ICON_HOT_SHIT = new ImageIcon( new byte[] { -119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 0, 100, 0, 0, 0, 100, 8, 3, 0, 0, 0, 71, 60, 101, 102, 0, 0, 0, -109, 80, 76, 84, 69, 0, 0, 0, 0, 0, 0, -12, -86, 65, -22, 90, 71, -27, 88, 70, -15, -88, 64, -125, 91, 35, -37, -104, 58, 60, 42, 16, 118, 45, 35, 122, 47, 37, 55, 38, 14, -39, -105, 58, -41, 82, 65, -29, 87, 68, -33, 85, 67, -57, 76, 60, -93, 62, 49, -97, 60, 48, 98, 37, 29, -70, -127, 48, 106, 40, 32, -75, 69, 54, -79, 68, 53, 11, 4, 2, -86, 119, 45, -114, 54, 42, 73, 28, 22, 50, 18, 14, 88, 34, 26, -69, 72, 57, -82, 66, 52, 67, 25, 20, 26, 9, 8, -46, 80, 63, -50, 79, 62, 127, 48, 38, 112, 43, 34, -20, -91, 63, -97, 110, 42, -113, 100, 38, 122, 85, 32, 109, 76, 29, 80, 30, 24, 61, 23, 18, 51, 35, 13, -124, 50, 40, 91, 35, 27, -110, 56, 44, 65, -6, 99, -68, 0, 0, 0, 1, 116, 82, 78, 83, 0, 64, -26, -40, 102, 0, 0, 2, -51, 73, 68, 65, 84, 104, -34, -19, -38, -37, 82, -93, 64, 20, -123, -31, 89, 118, -58, 24, 29, -50, -112, 64, 36, 39, 19, 115, -46, -88, -17, -1, 116, 67, 3, -50, 26, 3, 122, 49, -67, -9, -59, -108, -7, -81, 82, 93, -87, -6, -118, 16, 40, 54, -16, -29, -46, -91, 111, 29, -102, 58, 11, -110, 4, -21, 44, 8, 26, -84, -77, 0, 57, -29, 80, -92, -23, -2, 4, 91, -77, -112, 69, -109, -59, -76, -92, -30, 110, 28, -121, 87, -74, -19, 14, 109, -55, -38, -40, -4, 56, 39, -30, 104, 92, -1, -68, 106, 75, -13, -38, 24, 13, 76, -37, -100, -118, -116, 97, 43, 104, 52, -59, 68, -92, -116, -31, 77, 99, 48, -65, -92, 34, 109, -80, 41, 17, 53, -61, 44, -120, -88, 25, 102, 66, 68, -62, -72, 3, 13, 22, 17, -111, -34, 14, -106, 17, 81, 51, -42, -88, 82, 54, 6, -119, -114, 17, 68, 99, 26, 35, 84, -55, 27, 102, 4, -116, -75, 13, 83, 2, -79, -74, -15, 0, 96, -46, 24, -73, 90, -122, -97, 1, -16, 104, 0, -62, -122, 31, -114, -93, 123, 0, 27, 26, 85, -94, 70, 48, 93, -95, 110, 25, -68, 27, 119, 69, 78, 69, -62, -16, -18, -47, 52, -13, -2, 24, -61, -85, 20, 85, 98, -122, -1, 84, 11, -85, 100, 50, -96, 81, 125, 99, 71, -60, -47, 104, -49, -125, 73, 24, -40, -49, 52, -86, -74, 39, 42, -82, -122, 121, 6, 94, 125, 99, -93, 81, -73, 39, -30, 106, 120, 0, -58, 125, 70, -67, 87, 100, 12, 19, 2, 88, 119, 12, 34, 18, -122, 25, -37, 67, -16, -52, -32, -11, -117, -116, -31, -49, -128, -25, -82, 97, 59, 16, 113, 50, -126, 48, 1, 16, -9, 26, 67, 84, -71, 26, -125, 69, -122, -70, 39, -65, -49, -8, 121, 20, 48, -68, 87, 52, -35, 123, -67, -58, 53, -86, -2, -35, -72, -75, 70, -80, 108, -120, -4, 45, 80, 51, -52, -58, 110, 67, 52, 15, 3, -13, 110, -36, -120, 27, -98, 29, 68, 120, -100, 43, 24, -19, -43, -31, -61, 7, -29, -105, -72, 97, -25, -126, -107, -98, -63, 43, -10, -103, -26, 111, 101, 11, 74, -32, 69, -39, -16, 30, 1, -52, 21, 127, -85, 48, -34, 100, 57, -128, 68, -51, -80, -37, -48, -76, -12, -92, 13, -98, 75, -106, -83, -15, -88, 103, -104, 4, 64, -2, -72, -119, 67, -93, 103, -52, -19, 54, 4, -43, 7, 69, -61, -68, 0, -91, -74, 97, 102, -64, 84, -37, 48, 43, 32, 86, 52, 56, 27, 40, 26, -100, 13, 20, -115, 32, -100, -41, -77, -63, -117, -98, 17, -68, -27, -100, 13, -92, -115, -18, 108, -32, 104, 88, -28, -8, -43, 108, -128, 108, 49, 16, 48, 48, -20, 51, 76, 92, -49, 6, -66, -45, 127, -105, -56, -31, -45, -39, 96, -26, 27, 55, -125, 72, -15, -7, 108, -32, 106, 16, 73, -49, 12, -34, -120, 9, 69, 12, 34, -3, -77, -127, -85, 65, 100, -33, 103, -8, -81, -64, -77, -77, 65, -28, -76, 61, 55, 6, -51, 108, 16, 57, 92, -105, 116, -108, -35, -121, 123, 125, -125, 73, -78, -30, 108, -32, 104, 16, 65, -6, -105, -31, -51, 56, 27, 72, 24, 84, -118, -42, -32, 108, -80, -102, 6, 66, 6, -107, -38, -32, 108, 48, 14, 125, 35, 97, 48, 26, 114, -77, 65, 55, 26, -35, -39, -32, 78, -46, -32, 108, 80, -66, 27, 35, 113, -125, -57, -7, 72, -39, -80, 74, 20, 72, -18, 15, 34, 9, 13, -34, -33, 21, 53, -72, -89, 109, -62, -5, -125, 72, -90, 103, 16, -119, -12, 12, 34, 19, 61, -125, -56, 66, -49, 32, 50, -43, 51, -120, -108, -66, -98, 65, 37, 62, 51, 80, -120, 25, 68, -14, 57, 13, -44, -91, 114, 6, -107, -40, -81, -115, 117, -126, -74, -35, -74, 54, -122, 71, -63, -89, -46, 40, -89, -117, 73, -108, -127, 79, -66, 79, -5, 34, 45, 14, -78, -49, -41, 89, 103, -27, 127, 122, 29, -31, -85, 23, 43, 46, 93, -6, -50, -3, 6, 105, 10, 70, 103, 89, 115, -123, 15, 0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126 } );
> 
>    /**
>     * Image icon for quote type 'bullshit' (Source:
>     * https://openmoji.org/library/emoji-1F4A9/)
>     */
>    public final static ImageIcon ICON_BULLSHIT = new ImageIcon( new byte[] { -119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 0, 100, 0, 0, 0, 100, 8, 3, 0, 0, 0, 71, 60, 101, 102, 0, 0, 1, 38, 80, 76, 84, 69, 0, 0, 0, 0, 0, 0, -91, 121, 57, 106, 70, 47, -1, -1, -1, -94, 119, 56, 25, 17, 9, -122, 98, 46, -96, 117, 55, -102, 112, 53, 85, 56, 37, 9, 6, 3, -116, 103, 48, 95, 69, 32, 74, 54, 25, -99, 115, 54, -111, 105, 50, 106, 77, 36, 15, 10, 5, 97, 64, 42, 100, 73, 34, 123, 90, 42, 85, 62, 29, -105, 111, 52, -108, 108, 51, -125, 95, 44, 110, 81, 38, 30, 21, 11, -38, -38, -38, 104, 69, 46, 80, 58, 27, 62, 46, 21, 43, 30, 16, 35, 25, 12, -91, 122, 57, 101, 67, 44, 92, 61, 41, 117, 85, 40, 58, 38, 25, 68, 50, 23, 52, 38, 17, 38, 26, 14, 89, 58, 39, 58, 42, 20, 19, 14, 8, 6, 4, 3, -17, -17, -17, 79, 52, 35, 75, 49, 33, 90, 66, 30, -14, -14, -14, -32, -32, -32, 112, 82, 39, -7, -7, -7, -62, -62, -62, -71, -71, -71, 104, 104, 104, 115, 78, 48, 127, 93, 44, 71, 47, 31, 66, 43, 28, 48, 35, 16, -10, -10, -10, -25, -25, -25, -54, -54, -54, -66, -66, -66, -92, -92, -92, -128, -128, -128, 117, 117, 117, 75, 75, 75, -120, 96, 52, 112, 74, 48, -22, -22, -22, -76, -76, -76, -81, -81, -81, -86, -86, -86, -115, -115, -115, 110, 110, 110, 89, 89, 89, -107, 107, 54, -124, 92, 51, 126, 87, 49, -119, 101, 47, 43, 43, 43, 24, 24, 24, 53, 34, 23, 48, 32, 21, -4, -4, -4, -44, -44, -44, -48, -48, -48, 57, 57, 57, -115, 100, 53, 51, 51, 51, -100, -100, -100, -110, -110, -110, -121, -121, -121, 65, 65, 65, 95, 95, 95, 87, 109, -91, -52, 0, 0, 0, 1, 116, 82, 78, 83, 0, 64, -26, -40, 102, 0, 0, 5, -105, 73, 68, 65, 84, 104, -34, -19, -103, 121, 87, -45, 64, 16, -64, -99, 77, -102, 52, 109, -109, 38, -23, 65, 79, 74, 91, 123, 66, 41, 32, -118, 114, 8, 94, 120, 32, -126, 120, 43, 94, -33, -1, 75, -72, -77, -69, -51, 70, 106, 48, -124, -26, 61, 125, -81, -65, 127, 18, 74, -55, 47, -77, 51, 59, -109, -106, 27, 115, -26, -52, -7, -49, 0, -128, 27, -79, 3, 16, -65, 6, 37, -15, 107, 0, -30, -41, -96, -60, 92, -114, 89, -125, -110, 51, -78, 29, -81, 6, 37, 11, -124, -112, 114, -116, 26, 116, -72, 4, 73, -104, -51, -72, 52, 40, 89, 36, 12, 67, 73, -59, -92, 65, 73, -123, 112, 14, -107, 122, 60, 26, -108, -24, 66, -110, 120, -86, 40, -11, -79, 6, 72, 12, 121, 23, 124, 81, 40, -11, 93, 64, 102, -20, -48, -120, -57, 61, 5, 25, -82, -96, 37, -114, -68, -21, -101, 6, 33, -74, -62, -56, 105, -77, -107, -92, 69, -34, 11, 0, 13, 30, 10, 114, 19, 40, 51, -107, -24, 24, 7, 61, 106, 45, 12, -123, -77, 59, 75, 9, -39, -34, 51, 19, 52, -114, 17, -67, 104, -127, -8, 66, -103, -87, -124, -48, -37, 55, -118, 64, -87, -120, 2, -29, 84, 103, 104, -95, -105, 45, -27, 93, -23, -64, -67, -62, 120, 55, 59, 73, -47, 49, -5, -128, -84, -108, -119, -32, 112, -90, -111, -128, -113, -59, 5, 50, -63, 96, -114, 54, 58, 102, -85, -56, 16, 9, 79, 125, 10, 37, -77, 113, -92, -75, 102, -61, 44, -80, 40, 36, -89, 40, -23, -94, 100, 6, -114, -111, 105, 39, 91, -83, 22, -71, -120, -115, -85, -123, 37, 61, 3, 71, -33, 38, 127, -26, -124, 74, -58, -64, -71, -90, -93, -105, 13, 112, 96, -26, 115, 46, 120, 92, 67, -78, -121, -114, 32, 73, 125, 9, -4, 68, 14, 36, 67, 2, 57, 97, 89, 127, -97, 74, -83, 117, -85, -111, 45, 40, 41, -110, 96, -66, 96, 115, -44, -38, -68, -25, -81, 105, 17, 45, 44, -112, 96, 76, -84, -19, -101, -118, -96, -115, -3, 37, -110, -93, -102, 8, 84, 36, -48, 1, 41, -59, -93, -34, 68, 75, -92, 89, 24, -124, 97, 9, -121, 100, 45, -94, -60, 20, 119, -67, 112, -79, -58, -12, 1, -82, 85, 74, -71, -71, -37, -124, -47, 96, -105, 45, -38, -16, 26, -110, 100, -95, 71, -49, -106, -14, 37, 95, 24, -21, -128, 47, -107, -79, -68, 56, -35, 54, 111, 99, 17, -117, 75, -9, -10, 66, 94, 36, 40, 89, 97, -107, 100, 25, -91, 62, 120, 84, 115, -54, 78, 68, 73, -109, 20, 64, 98, -31, -94, -107, 28, -90, 72, 119, -120, -79, 7, 62, -86, -19, -91, -88, -27, -107, 7, 63, -106, -35, -23, -55, -71, -62, 82, -1, -29, 121, -83, -10, -30, 28, -49, 6, 16, 77, 34, 120, 84, 91, -35, 127, -2, 6, 36, 13, -99, 16, 30, -29, -29, 13, -107, -78, 122, 23, 56, -47, 29, -49, 85, 100, -1, -119, 55, -70, 116, 86, 113, -72, 58, -81, -18, -85, -116, 13, -4, 37, 39, -110, 2, 30, -86, -100, 91, 111, 89, 16, 29, 49, -70, -74, -127, 82, 83, 5, -97, 64, 18, 97, -24, 62, -71, -83, 10, 94, 0, -59, 32, -126, 69, 92, 71, -43, -29, -18, -43, 45, 124, -26, 22, -127, -14, 64, -99, 112, 31, -45, 82, 16, -114, 36, 80, 14, -92, -28, 14, 62, -55, -28, -122, -35, -16, 22, -90, 112, -78, 58, 61, -68, -35, 80, 61, -66, -6, -38, 114, 6, 40, -104, -111, -37, -75, -38, 7, 122, 120, 6, -108, 28, 109, -57, -17, -61, 90, 112, 88, -39, -124, 108, 98, -7, -48, 11, 124, 56, 120, -79, -75, 74, -113, 7, -20, -29, -125, 76, -55, 93, -6, 90, -19, 7, 77, -1, 45, 122, -14, 89, -76, -78, 58, 11, 38, -36, 46, -60, -12, 98, -13, 56, -94, -9, -6, -120, 30, -49, -23, -123, -10, 101, 82, -40, 13, -68, -92, -59, -5, 102, -110, -73, 99, 122, 28, 43, 104, 25, -124, -107, 108, 19, 74, -113, -89, -28, 1, 32, -81, 104, 68, 120, 20, 45, -84, -126, 117, -121, -87, 96, 124, 82, -43, -105, -12, -80, -90, 76, 26, 37, -124, -112, -72, 73, 66, 105, -16, -36, 126, 7, -58, 51, 85, -99, -52, 99, 41, -39, 2, -58, 29, 79, -126, -124, -23, 47, -8, 24, -44, 18, 18, -4, -13, 111, -68, -42, 54, -72, -60, -106, -110, 111, 116, -13, 0, -78, -78, -54, 107, 120, 28, 122, -80, -96, 100, 25, 37, -84, 57, 109, -87, -22, 71, 64, -66, -45, 26, -106, -53, -59, -102, -54, 49, -51, -9, 17, 43, 115, -103, 120, 100, 24, 78, -78, -28, 13, -15, -81, 42, 93, -109, -73, -40, -92, -60, 109, 39, 125, 37, -116, -5, -76, -10, -16, -24, -106, 44, -31, -48, 31, -116, -48, -62, 38, 97, -121, -98, -4, 100, -83, -23, -29, -66, -118, 50, 92, 72, -62, -55, 2, -27, -29, -123, -51, 88, -25, -110, 84, 72, 9, -21, -127, 54, 80, -16, -14, -126, -57, -40, -5, -7, 60, -42, 89, 55, 120, -7, 123, 91, -23, 42, 28, -36, -113, -31, -97, -73, 6, -66, -2, -120, -85, -59, -19, 73, 61, 95, -59, -45, -87, 6, -103, -110, -127, -124, -110, -92, 13, -108, 56, -40, 87, -98, -87, 2, -36, -109, 110, 121, -45, 26, -127, 64, -74, -6, 85, 108, -11, 85, -111, -111, 116, -72, -66, 34, -106, -91, 101, -77, -71, 36, -38, -16, 3, -16, 83, -51, 59, 120, 56, 94, -107, 67, 43, -59, 29, 110, -8, -34, -27, 110, -102, 61, 109, -60, 7, -29, 6, -53, 108, 90, 26, -76, -11, 114, 82, -116, -33, -49, 56, 126, 89, 111, 41, 62, 101, 107, 37, -34, 22, 74, -30, -25, -4, -24, 96, -21, 24, 4, 105, -85, -110, 73, 16, -54, -123, 7, -119, 126, -10, -75, -40, -121, -126, 112, -118, 105, -118, -101, -27, 18, 10, 4, 11, 125, -16, 88, 54, -56, 41, 127, 30, -106, -4, 93, 49, 106, -84, 59, -123, -14, -103, -66, 4, 30, 14, -71, 64, -42, 4, -127, 73, -105, -17, 112, -88, -31, -23, 78, 46, -75, 35, -2, -24, 114, -121, -43, -79, 19, -109, 11, -83, 79, -42, 67, 39, -45, -40, 78, 67, -45, 122, 78, 9, -33, -56, -74, -114, -53, -45, -33, -34, 113, -125, 45, -84, -35, 57, 6, -15, 83, -38, 92, 108, 88, 121, -90, 8, 38, -39, 97, 97, 12, 114, -118, 32, -57, -94, 9, 114, 88, 6, -71, 50, -39, 78, -109, 21, 69, -59, -72, -89, 76, -88, -65, 15, -106, 88, -119, -85, 26, 18, 25, -45, -27, -117, 92, -94, 63, -68, -10, 44, 109, -116, -19, -49, -110, -46, 85, 13, -7, -127, -88, 47, 93, 126, -79, 19, 52, 87, -124, 99, -17, -118, -122, 38, 112, 26, -2, 47, 118, 4, -71, 32, -55, 114, 104, 67, 82, 55, 39, 125, -46, 53, 51, -66, -126, -109, 89, 9, -110, 104, -119, 112, -103, 46, -81, 107, -62, -80, 82, -60, 30, 35, 57, -99, -114, 36, -4, -25, 93, -55, 66, -63, 74, 79, 12, -21, -46, 32, 3, 17, -116, 3, 37, -67, -53, 67, 73, -98, 57, 125, -39, 39, 117, 110, -112, 24, -81, 21, -55, 32, 80, 2, -59, 108, -96, 32, -45, -79, 92, 16, 12, -14, -6, -44, -19, -100, 80, -123, 100, 124, -39, 110, 28, 116, -116, -23, 58, 90, -48, -99, -98, 43, -37, -95, 99, -117, -41, 19, -83, -55, 59, 78, 78, 101, -15, -2, 101, -80, -120, -126, 116, -74, 51, -91, 108, 18, 49, 108, -67, -109, -17, 85, -63, 67, 91, -108, -33, -82, -107, 53, -83, -65, -24, 20, 50, -103, -61, -55, 78, -105, -114, -107, 75, 59, -92, 100, -60, -13, 43, 25, -11, 112, -104, 120, -76, -106, -67, 65, -7, 110, 39, -107, -85, 75, 69, 123, 55, 76, -77, -97, 70, -77, 42, 103, 23, -45, -107, 7, 63, 110, -77, -69, 51, 78, 13, -121, -61, 113, 55, 29, 105, 110, 93, -31, -83, -79, -3, -85, 48, 110, -123, -28, 55, -59, -100, 57, 115, -26, -52, -7, 119, -8, 5, -127, 107, -124, 93, 102, 96, -13, 96, 0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126 } );
> 
>    /**
>     * Image icon for quote type 'unknown'
>     */
>    public final static ImageIcon ICON_UNKNOWN = new ImageIcon( new byte[] { -119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 0, 100, 0, 0, 0, 100, 8, 3, 0, 0, 0, 71, 60, 101, 102, 0, 0, 0, 102, 80, 76, 84, 69, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 112, 108, -108, -42, 0, 0, 0, 33, 116, 82, 78, 83, 0, 4, 124, 20, -5, -12, 47, -16, -33, -57, -84, 25, -71, -125, 98, 87, 75, 72, 58, 41, 35, 10, -10, -25, -26, -46, -89, -95, -106, 67, 54, 43, 42, -111, 9, 103, 56, 0, 0, 0, -20, 73, 68, 65, 84, 104, -34, -19, -40, -55, 14, -126, 64, 16, -124, -31, 26, 5, 20, 112, 99, 115, -61, 109, -34, -1, 37, -91, 67, -116, -102, -71, 105, 42, 65, -84, -17, -60, -19, -49, 12, -121, -18, 12, 68, 68, 100, -40, 110, -53, -59, 62, -118, -25, -39, -38, -127, -27, -100, -6, -121, 67, 5, 14, -25, 95, -20, 114, 24, 98, -60, -76, 48, -116, 72, 116, 44, -14, 38, -55, 44, 18, 59, 48, 56, -97, 38, -3, -57, -36, 42, 53, 24, -36, -55, -95, -73, -80, 72, 5, 46, 59, 73, -44, -128, 106, -27, 59, 25, -88, 46, 113, -41, -104, -43, 96, 42, 103, 118, 89, 27, 48, -107, -79, 53, -42, 96, -70, -38, 57, -74, 27, 80, -91, 118, -114, 2, 84, -119, -17, 44, -63, -75, -78, 72, 2, -82, -119, 69, 114, -48, 60, 35, 83, -68, -7, -51, -56, 7, 6, 58, -3, -61, -21, 10, -89, 63, 35, 18, 78, 127, 118, -60, -76, -92, 72, 56, -3, -65, -113, 104, -6, 107, -6, 107, -6, 107, -6, 107, -6, 15, 45, 50, 30, -3, 117, 17, -10, 18, 66, 36, -36, 75, 24, -111, 112, 47, 97, 71, 76, 27, 68, -12, 42, -95, -67, 68, 123, -119, -10, 18, -19, 37, -38, 75, -2, -49, 120, -2, -119, 34, 34, 34, 34, 18, -72, 3, 52, -85, 53, 50, -97, -55, -22, -84, 0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126 } );
> 
> }
> ```

> [!example]- QuoteDisplay.java
> ```java
> import java.awt.Dimension;
> import java.awt.Insets;
> 
> import javax.swing.JScrollPane;
> import javax.swing.JTextPane;
> import javax.swing.text.SimpleAttributeSet;
> import javax.swing.text.StyleConstants;
> import javax.swing.text.StyledDocument;
> 
> /**
>  * Component to display the quotes
>  */
> @SuppressWarnings( "serial" )
> public class QuoteDisplay extends JScrollPane {
> 
>    private final JTextPane txt = new JTextPane();
> 
>    /**
>     * Create the scroll pane that contains the text pane for display
>     */
>    public QuoteDisplay() {
>       this.setViewportView( this.txt );
>       this.setPreferredSize( new Dimension( 100, 100 ) );
>       this.txt.setFont( this.getFont().deriveFont( 14f ) );
>       this.txt.setEditable( false );
>       this.txt.setMargin( new Insets( 20, 20, 20, 20 ) );
>    }
> 
>    /**
>     * Set the quote text.
>     * 
>     * It will automatically be centered horizontally.
>     * 
>     * @param text
>     *           quote text to set
>     */
>    public void setText( String text ) {
>       this.txt.setText( text );
>       this.txt.setCaretPosition( 0 );
>       StyledDocument doc = this.txt.getStyledDocument();
>       SimpleAttributeSet center = new SimpleAttributeSet();
>       StyleConstants.setAlignment( center, StyleConstants.ALIGN_CENTER );
>       doc.setParagraphAttributes( 0, doc.getLength(), center, false );
>    }
> }
> ```

## Aufgabenstellung ansehen
![[Material/Projekte/41f_FakeTalk_ProbePE_Download/FakeTalk_ProbePE.pdf]]

## Aufgabentext (durchsuchbar)
> [!quote]- Kompletter Aufgabentext – aufklappen
> ```text
> Hinweis zur Bewertung:
>    • 1/4 der Punkte (25%) wird nach Funktionstests Ihrer Lösung vergeben.
>    • 3/4 der Punkte (75%) werden entsprechend des in den Teilaufgaben
>        angegebenen Schlüssels auf Basis des Quellcodes vergeben.
> 
>                        DHBW Karlsruhe, Vorlesung Programmieren I+II,
>                                         Probe-sProgrammentwurf
>                                      Bearbeitungszeit: 120 Minuten
> 
> Aufgabe
> Die letzten Jahre fällt es immer schwerer, Aussagen, die auf Social-Media-Plattformen die Runde machen oder im
> Fernsehen getätigt werden, richtig einzuordnen. Zitate können dabei entweder zum Zeitpunkt der Äußerung schon
> problematisch sein, sich im Nachhinein als falsch herausstellen oder schlicht rein fiktional sein, da sie bspw. aus Film-
> Dialogen stammen. Zur korrekten Bewertung ist eine gute Medienkompetenz gefragt!
> Sie sollen in Form der grafischen Java-Anwendung FakeTalk einen spielerischen Ansatz realisieren, der die
> Einordnung von Zitaten ermöglicht. Die Aufmachung soll sich an ein eher junges Publikum richten und ist in Sachen
> Design und Sprache bewusst plakativ und überspitzt (quasi doppelter Test der Medienkompetenz 😉).
> 
> Teilaufgabe a)                                                                                                    [6%]
> Um verschiedene Einordneungen von Zitaten im Programm zu ermöglichen soll zunächst ein komplexer
> Aufzählungstyp QuoteType realisiert werden.
> Der Aufzählungstyp soll hierbei neben der Konstante ein menschenlesbares Label (label), ein Bild für die spätere
> Darstellung (icon) sowie eine Farbe (color) realisieren. Die Icons sollen vom Typ javax.swing.ImageIcon sein
> und sind in der mitgelieferten Klasse FakeTalkIcons (s. USB-Stick) bereitgestellt.
> Wir unterscheiden inhaltlich nur zwischen non-fiktionalen Zitaten, die bis heute Bestand haben („der heiße Scheiß“),
> und dem Rest („Blödsinn“). Hierfür sind folgende drei QuoteType-Werte sind zu realisieren:
>  QuoteType           Label             Icon                                  Farbe
>  UNKNOWN             Unknown           FakeTalkIcons.ICON_UNKNOWN            java.awt.Color.LIGHT_GRAY
>  HOT_SHIT            Hot shit          FakeTalkIcons.ICON_HOT_SHIT           java.awt.Color.GREEN
>  BULLSHIT            Bullshit          FakeTalkIcons.ICON_BULLSHIT           new java.awt.Color(74,65,42)
> 
> Teilaufgabe b)                                                                                                    [7%]
> Zur Repräsentation eines Zitats soll die Klasse Quote umgesetzt werden. Ein Zitat besteht aus dem Text (text), der
> Name der Person, welche dies gesagt bzw. geschrieben hat (person), deren Funktion (role), der Quelle des Zitats
> (source) sowie dem Typ des Zitats (type, vgl. Teilaufgabe a)).
> Realisieren Sie einen Konstruktor, welcher die Attribute in exakt dieser Reihenfolge entgegennimmt und in den
> zugehörigen Instanzvariablen speichert.
> Ebenso ist eine Methode getCitation zu realisieren, welche als Zeichenkette die Informationen zur Person, ihrer
> Funktion und der Quelle des Zitats liefert (vgl. Dialog im Screenshot auf dem Deckblatt).
> Hinweis: der Konstruktor wird in der bereitgestellten Methode FakeTalk.parseQuote verwendet.
> 
> Teilaufgabe c)                                                                                                    [5%]
> Um neben unserem Beispiel-Client später weitere Clients problemlos ergänzen zu können soll eine Java-Schnittstelle
> FakeTalkClient realisiert werden, welche folgende Methoden für spätere Implementierungen definiert:
>     -   String getPlayerName(): soll den Namen des Spielers zurückgeben
>     -   void setQuote(Quote q): setzt dem Client das Zitat und aktualisiert ggf. die Anzeige
>     -   void addPoints(int points): fügt dem Client Punkte hinzu und aktualisiert ggf. die Anzeige
>     -   int getPoints(): liefert den aktuellen Punktstand
> 
> Teilaufgabe d)                                                                                                  [30%]
> Wie auf dem Deckblatt zu sehen sollen Spieler ein Zitat auswählen können. Schreiben Sie hierfür eine Klasse
> QuoteSelectionTerm, die dies in Form einer grafischen Oberfläche ermöglicht. Am oberen Rand ist eine Anzeige
> vorzusehen, die den aktuellen Spieler zur Auswahl auffordert, darunter eine Matrix-artige Struktur für die Auswahl
> und am unterem Rand eine Anzeige für die Punkte, die für eine korrekte Antwort vergeben werden (zunächst:
> Points: 10). Der Titel soll entsprechend dem auf der nächsten Seite folgenden Screenshot gesetzt werden.
> 
> Realisieren Sie als Knopf für die Auswahl der Fragen
> sollen Sie eine eigene Klasse QuoteButton, welche von
> JButton erbt. Ein QuoteButton hat ein zusätzliches
> Attribut, welches den aktuellen Typ (vgl. Teilaufgabe a)),
> für den der Button steht, repräsentiert.
> Entsprechend dem aktuellen Typ sind immer die
> Hintergrundfarbe (vgl. Hinweise) und das Icon des
> QuoteButtons auf die Werte des aktuellen Typs zu
> setzen! Initial sind alle QuoteButtons vom Typ
> QuoteType.UNKNOWN.
> Ebenso soll es eine Methode boolean isUnknown() geben,
> die genau dann true zurückliefert wenn der Typ des
> Buttons QuoteType.UNKNOWN ist, in jedem anderen Fall
> false.
> Der Konstruktor von QuoteSelectionTerm nimmt die Liste aller Zitate sowie die Anzahl der Zeilen und Spalten
> für die Auswahl entgegen (in dieser Reihenfolge, vgl. Verwendung in Klasse FakeTalk vom USB-Stick).
> Sollte die Größe der übergebenen Zitatliste nicht ausreichen um genügend Zitate für die gegebenen Zeilen und Spalten
> auswählen zu können, ist eine selbst zu schreibende FakeNewsException zu werfen, der die Nachricht „Provided
> quote catalog does not contain enough (hot|bull)shit!“ übergeben wird.
> Sind genügend Zitate vorhanden wählen Sie die korrekte Anzahl zufällig aus dem Katalog aus und nutzen Sie diese
> für das aktuelle Spiel. Duplikate sind hierbei zu vermeiden. Ebenso sind folgende Methoden zu realisieren:
>     -   void register(FakeTalkClient client) : Ermöglicht das Registrieren eines Clients. Diese müssen in
>         einer geeigneten Datenstruktur abgelegt werden. Sollte das Spiel bereits gestartet worden sein (siehe darunter)
>         ist eine FakeNewsException mit einer entsprechenden Nachricht zu werfen.
>     -   void start(): Starten des Spiels. Sollten sich beim Aufruf der Methode weniger als 2 Clients in der o.g.
>         Datenstruktur befinden, ist eine FakeNewsException mit entsprechender Fehlermeldung zu werfen. Wenn
>         alles passt soll das Spiel gestartet werden und der erste Client zur Auswahl eines Zitats aufgefordert werden
>         (vgl. Screenshot oben). Wurde das Spiel bereits gestartet soll nichts passieren.
>     -   void answerSelected(FakeTalkClient client, Quote q, QuoteType selectedType): Teilt eine
>         selektierte Antwort mit. Dabei sind folgende Schritte durchzuführen
>              o Es ist ein Dialog mit dem eigentlichen Typ des Zitats sowie dessen Quellenangabe (getCitation-
>                  Methode) anzuzeigen (vgl. Screenshots unten links).
>              o Ist der ausgewählte Zitat-Typ selectedType richtig, sind die entsprechenden Punkte (aktuell immer
>                  10, siehe Hinweise) dem Spieler hinzuzufügen, ansonsten sind sie abzuziehen. Das Label für die
>                  Punkte ist ebenfalls entsprechend zu aktualisieren.
>              o Der QuoteButton für das übergebene Zitat ist auf den korrekten Zitat-Typ zu setzen
>              o Alle QuoteButtons, die noch im Zustand UNKNOWN sind, sind wieder zu aktivieren
>                      ▪ Ist kein QuoteButton mehr im Zustand UNKNOWN (d.h. alle Zitate wurden bereits gespielt)
>                           ist ein Dialog mit den Punkten aller Spieler anzuzeigen, der über das Ende des Spiels
>                           informiert (vgl. Screenshot unten rechts).
>                      ▪ Ansonsten ist der nächste Spieler an der Reihe und soll zur Auswahl eines Zitats aufgefordert
>                           werden (Label am oberen Rand).
> 
> Wird ein QuoteButton ausgewählt, ist dies dem aktuellen Client mittels der setQuote-Methode mitzuteilen und alle
> QuoteButtons sind zu deaktivieren.
> Hinweis 1: UI-Elemente können mit setEnabled(false) deaktiviert bzw. mit setEnabled(true) aktiviert.
> Hinweis 2: Die Anzeige und Vergabe der Punkte wird in Teilaufgabe i) erweitert.
> Hinweis 3: ImageIcon-Instanzen können einfach mittels der Methode setIcon auf einem Button angezeigt werden.
> Hinweis 4: Die Hintergrundfarbe eines Buttons kann mit der Methode setBackground(color) gesetzt werden.
> 
> Teilaufgabe e)                                                                                                 [12%]
> Als grafische Oberfläche zur Einordnung von Zitaten durch Spieler ist eine Klasse
> QuoteTerm umzusetzen. Diese ist natürlich eine Ausprägung der Schnittstelle
> FakeTalkClient und realisiert die hierdurch vorgegebene Funktionalität wie in
> Teilaufgabe c) beschrieben.
> Der Konstruktor nimmt hierbei den Namen der Person entgegen, die in diesem
> QuoteTerm spielt, sowie die Referenz auf das QuoteSelectionTerm, um diesem
> später die Kategorie-Selektion mitzuteilen (vgl. Verwendung in bereitgestellter
> Klasse FakeTalk, s. USB-Stick).
> Der Titel des Fensters ist auf den Namen der spielenden Person zu setzen. Im oberen
> Bereich sehen Sie die Anzeige für das später zu bewertende Zitat vor. Nutzen Sie hierfür die mitgelieferte
> Komponente QuoteDisplay (s. USB-Stick) welche sich um Mindestgröße, Schriftgröße, Zeilenumbruch,
> Ausrichtung und ggf. Scroll-Balken kümmert. Den Zitattext können Sie später mit Hilfe der Methode
> setText(String) setzen.
> Darunter sind zwei Buttons vorzusehen, welche die Auswahl von „Heißem Scheiß“ oder „Blödsinn“ für ein Zitat
> erlauben und die initial deaktiviert sind. Nutzen Sie für die Anzeige die jeweiligen Icons (vgl. Screenshot)! Darunter
> ist ein Label für die Anzeige der aktuell gesammelten Punkte vorzusehen.
> Beim Aufruf der durch die Schnittstelle definierte setQuote-Methode ist das Zitat in der Anzeige sichtbar zu machen
> und die Buttons müssen für die Auswahl des Zitat-Typs aktiviert werden.
> Die Buttons müssen bei Auswahl eines Typs dem QuoteSelectionTerm mittels der Methode answerSelected
> mitteilen, welcher Typ für das Zitat ausgewählt wurde. (Es müssen der aktuelle Client, das aktuelle Zitat und der
> auswählte Typ je nach gewähltem Button übergeben werden.)
> 
> Teilaufgabe f)                                                                                                   [5%]
> Ändern Sie die Implementierung der loadQuotes-Methode in der bereitgestellten Klasse FakeTalk (s. USB-Stick)
> so, dass die auf dem USB-Stick bereitgestellte Datei „corona.csv“ (CSV = „Catalog of shit verses“ 😉) zeilenweise
> eingelesen wird. Fehler müssen zwar abgefangen aber nicht weiter behandelt werden.
> Dabei ist jede Zeile der Datei in ein Quote-Objekt umzuwandeln und anstatt der Beispieldaten der Liste der Zitate
> hinzuzufügen. Nutzen Sie für das Konvertieren die bereitgestellte Methode parseQuote, welche bereits für die
> Umwandlung der Beispieldaten genutzt wird.
> 
> Teilaufgabe g)                                                                                                   [5%]
> Erweitern Sie die answerSelected-Methode von QuoteSelectionTerm (siehe Teilaufgabe d)) nun so, dass zum
> Ende des Spiels die zuvor lediglich im Dialog angezeigte Nachricht zusätzlich in eine Textdatei mit dem Namen
> „fake-score.txt“ gespeichert wird. Sollte die Textdatei bereits existieren, ist die Nachricht als neue Zeile an das
> Ende anzuhängen. Fehler müssen zwar abgefangen aber nicht weiter behandelt werden.
> 
> Teilaufgabe h)                                                                                                   [5%]
> Erweitern Sie die Klasse QuoteSelectionTerm (vgl. Teilaufgabe d)) nun so, dass alle zwei Sekunden die Punktzahl
> für die Beantwortung des Zitattyps um einen Punkt reduziert wird. Aktualisieren Sie auch die Anzeige entsprechend!
> Diese Aktion soll nebenläufig durchgeführt werden. Die nebenläufige Ausführung endet, nachdem entweder eine
> Antwort für das aktuelle Zitat gegeben wurde oder die zu vergebende Punktzahl nur noch einen (1) Punkt beträgt (und
> dann auch nicht mehr kleiner wird).
> 
> Allgemeine Hinweise
> Starten
> Starten Sie die Anwendung mit der gegebenen Klasse FakeTalk (siehe USB-Stick).
> Schließen eines Fensters
> Beim Schließen eines Fensters soll die komplette Anwendung beendet werden.
> Sichtbarkeit von Instanz-Attributen
> Sämtliche Instanz-Attribute sind als privat zu definieren und von außerhalb der Klasse ggf. mittels Getter- und/oder
> Setter-Methoden zu verwenden.
> ```

## Meine Notizen

