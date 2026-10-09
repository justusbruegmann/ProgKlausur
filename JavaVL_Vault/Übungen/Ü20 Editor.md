---
tags: ["typ/uebung", "thema/swing", "kategorie/gui", "semester/2", "schwierigkeit/2", "hat/musterloesung"]
aliases: ["EditorSimple"]
thema: "[[20 Grafische Oberflächen mit Swing]]"
klasse: "EditorSimple"
package: "de.dhbwka.java.exercise.ui.editor"
schwierigkeit: 2
status: "offen"
---

# Ü20 Editor

**Thema:** [[20 Grafische Oberflächen mit Swing]] · **Bereich:** Grafische Benutzeroberflächen (GUI/Swing) (2) · **Schwierigkeit:** ★★☆☆☆
**Klasse:** `EditorSimple` · **Package:** `de.dhbwka.java.exercise.ui.editor`

📄 Aufgabe: [[Material/Aufgaben/20_Swing_Aufgaben-2.pdf#page=3|20_Swing_Aufgaben-2.pdf, S. 3]]
✅ Musterlösung: [[Material/Aufgaben/20_Swing_Aufgaben-2_Muster.pdf#page=6|20_Swing_Aufgaben-2_Muster.pdf, S. 6]]

> [!question] Kurz gesagt
> Entwickeln Sie eine Anwendung EditorSimple, die eine Menü-Struktur (JMenuBar etc.) entsprechend der Screenshots unten hat. Die Anwendung soll noch nicht auf Ereignisse reagieren, sondern lediglich die Menü-Struktur erzeugen.

## Aufgabenstellung
```text
Entwickeln Sie eine Anwendung EditorSimple, die eine Menü-Struktur (JMenuBar etc.)
entsprechend der Screenshots unten hat. Die Anwendung soll noch nicht auf Ereignisse reagieren,
sondern lediglich die Menü-Struktur erzeugen.

Die Menüleiste können wir mit JMenuBar erzeugen. Jedes (Haupt-)Menü („Datei“, „Bearbeiten“)
ist ein JMenu. Jeder einzelne Menüpunkt ein JMenuItem. Bitte beachten Sie den Menüpunkt
„Senden an“, bei dem es sich um ein Untermenü handelt. „Senden an“ ist also kein JMenuItem,
sondern ein JMenu und enthält seinerseits wieder JMenuItems.
Die Klasse EditorSimple soll die Klasse JFrame erweitern.

Hinweis: Die Anwendung wird in einer späteren Übung erweitert.
```

## Benötigte Begriffe
[[Konstante]] · [[switch]] · [[for-Schleife]] · [[break und continue]] · [[Array]] · [[Konstruktor]] · [[this]] · [[static]] · [[Kapselung]] · [[Überschreiben]] · [[super]] · [[Anonyme innere Klasse]] · [[Datei und Pfad]] · [[Swing]] · [[JFrame]] · [[Swing-Komponenten]] · [[Menü]] · [[Layoutmanager]] · [[Farben und Schriften]] · [[Listener]]

## Weitere Übungen zum Thema
[[Ü20 Swing-Grundkomponenten]] · [[Ü20 Frame mit Text]] · [[Ü20 Datei auswählen und zeilenweise darstellen]] · [[Ü20 Währungsumrechner]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.ui.editor;
> 
> import java.awt.BorderLayout;
> import java.awt.Font;
> import java.awt.event.ActionEvent;
> import java.awt.event.ActionListener;
> import java.awt.event.KeyEvent;
> 
> import javax.swing.JEditorPane;
> import javax.swing.JFrame;
> import javax.swing.JMenu;
> import javax.swing.JMenuBar;
> import javax.swing.JMenuItem;
> import javax.swing.JScrollPane;
> import javax.swing.JSeparator;
> 
> @SuppressWarnings("serial")
> public class EditorSimple extends JFrame {
> 
>     private final static String SEPARATOR = "--";
>     private final static String SEND_MENU = "-SENDMENU-";
>     private final static int INITIAL_WIDTH = 600;
>     private final static int INITIAL_HEIGHT = 480;
> 
>     private JMenu fileMenu;
>     private JMenu editMenu;
>     private JEditorPane editPane;
> 
>     private final String[] fileMenuItems =
>     { "Neu", "\u00D6ffnen", EditorSimple.SEPARATOR,
>         "Schlie\u00DFen", EditorSimple.SEPARATOR, "Speichern",
>         "Speichern unter...",
>         "Als Webseite speichern", "Suchen", EditorSimple.SEPARATOR,
>         "Versionen",
>         EditorSimple.SEPARATOR, "Webseitenvorschau",
>         EditorSimple.SEPARATOR, "Seite einrichten...",
>         "Seitenansicht", "Drucken", EditorSimple.SEPARATOR,
>         EditorSimple.SEND_MENU,
>         "Eigenschaften", EditorSimple.SEPARATOR, "bilanz_2017.doc",
>         "bericht_2018_01.doc", "ziele.doc",
>         EditorSimple.SEPARATOR, "Beenden" };
> 
>     private final String[] editMenuItems =
>     { "R\u00FCckg\u00E4ngig", "Wiederholen",
>         EditorSimple.SEPARATOR, "Ausschneiden", "Kopieren",
>         "Office-Zwischenablage",
>         "Einf\u00FCgen", "Inhalte einf\u00FCgen",
>         "Als Hyperlink einf\u00FCgen",
>         EditorSimple.SEPARATOR, "L\u00F6schen", "Alles markieren",
>         EditorSimple.SEPARATOR,
>         "Suchen...", "Ersetzen...", "Gehe zu...", EditorSimple.SEPARATOR,
>         "Verkn\u00FCpfungen...", "Objekt" };
> 
>     private final String[] sendMenuItems = { "E-Mail-Empf\u00E4nger",
>         "E-Mail-Empf\u00E4nger (zur \u00DCberarbeitung)",
>         "E-Mail-Empf\u00E4nger (als Anlage)", EditorSimple.SEPARATOR,
>         "Verteilerempf\u00E4nger...", "Onlinebesprechungsteilnehmer",
>         "Exchange-Ordner...", "Fax-Empf\u00E4nger...",
>         EditorSimple.SEPARATOR, "Microsoft PowerPoint" };
> 
>     /**
>      * Constructor for the editor
>      */
>     public EditorSimple() {
>         super( "Editor" );
>         this.setLayout( new BorderLayout() );
> 
>         // Create scrollable editor
>         this.editPane = new JEditorPane();
>         this.editPane.setFont( new Font( Font.MONOSPACED, Font.PLAIN, 12 ) );
>         this.add( new JScrollPane( this.editPane ), BorderLayout.CENTER );
> 
>         // Create menu
>         JMenuBar menu = new JMenuBar();
>         this.fileMenu =
>         this.getMenu( "Datei", KeyEvent.VK_D, this.fileMenuItems );
>         this.editMenu =
>         this.getMenu( "Bearbeiten", KeyEvent.VK_B, this.editMenuItems );
>         menu.add( this.fileMenu );
>         menu.add( this.editMenu );
> 
>         this.addListener();
> 
>         this.setJMenuBar( menu );
>         this.setSize( EditorSimple.INITIAL_WIDTH, EditorSimple.INITIAL_HEIGHT );
>         this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
>         this.setVisible( true );
>     }
> 
>     // Continued on next page
> 
>     /**
>      * Add the listener to exit button
>      */
>     private void addListener() {
>         // 25 = index of 'Beenden' in this.fileMenuItems
>         JMenuItem itemExit = (JMenuItem) this.fileMenu.getMenuComponent( 25 );
>         itemExit.addActionListener( new ActionListener() {
>             @Override
>             public void actionPerformed( ActionEvent e ) {
>                 System.exit( 0 );
>             }
>         } );
>     }
> 
>     /**
>      * Produces a JMenu with JMenuItems according to items array
>      *
>      * @param menuName
>      *            name of parent menu
>      * @param mnemonic
>      *            for the parent menu
>      * @param items
>      *            string array with sub items labels
>      * @return create parent menu
>      */
>     private JMenu getMenu( String menuName, int mnemonic, String[] items ) {
>         JMenu menu = new JMenu( menuName );
>         menu.setMnemonic( mnemonic );
>         for ( String menuItemName : items ) {
>             switch (menuItemName) {
>                 case SEPARATOR:
>                 menu.add( new JSeparator() );
>                 break;
>                 case SEND_MENU:
>                 menu.add( this.getMenu( "Senden an", KeyEvent.VK_S,
>                 this.sendMenuItems ) );
>                 break;
>                 default:
>                 menu.add( new JMenuItem( menuItemName ) );
>             }
>         }
>         return menu;
>     }
> 
>     /**
>      * Run an instance of the editor
>      */
>     public static void main( String[] args ) {
>         new EditorSimple();
>     }
> 
> }
> ```

## Meine Notizen

