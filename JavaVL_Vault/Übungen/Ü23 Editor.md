---
tags: ["typ/uebung", "thema/events", "kategorie/gui", "semester/2", "schwierigkeit/3", "hat/musterloesung"]
aliases: ["Editor"]
thema: "[[23 Events]]"
klasse: "Editor"
package: "de.dhbwka.java.exercise.ui.editor"
schwierigkeit: 3
status: "offen"
---

# Ü23 Editor

**Thema:** [[23 Events]] · **Bereich:** Grafische Benutzeroberflächen (UI), Events (2) · **Schwierigkeit:** ★★★☆☆
**Klasse:** `Editor` · **Package:** `de.dhbwka.java.exercise.ui.editor`

📄 Aufgabe: [[Material/Aufgaben/23_Events_Aufgaben-2.pdf#page=1|23_Events_Aufgaben-2.pdf, S. 1]]
✅ Musterlösung: [[Material/Aufgaben/23_Events_Aufgaben-2_Muster.pdf#page=1|23_Events_Aufgaben-2_Muster.pdf, S. 1]]

> [!question] Kurz gesagt
> Schreiben Sie einen kleinen Texteditor mit „Swing“ (aufbauend auf der Klasse EditorSimple)! Keine Panik, das geht relativ einfach.

## Aufgabenstellung
```text
Schreiben Sie einen kleinen Texteditor mit „Swing“ (aufbauend auf der Klasse EditorSimple)!
Keine Panik, das geht relativ einfach. Hier ein grobes Gerüst dafür:

package de.dhbwka.java.exercise.ui.editor;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Editor extends JFrame {
   /**
    * Constructor for the editor, UI elements and listeners
    * may be created/assigned here
    */
   public Editor() {
       super( "Editor" );

        // (...)

        // Set size and show
        this.setSize( 640, 480 );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setVisible( true );
    }
}

Wir halten an dieser Stelle kurz fest, dass unser Editor bereits die Klasse JFrame erweitert, also
bereits ein Fenster ist, zu dem weitere GUI-Komponenten hinzugefügt werden können
(this.add(Component)).

Im Wesentlichen soll die Oberfläche aus zwei Teilen bestehen:
     • einer Menüleiste mit Pull-Down-Menüs
     • einer Editor-Oberfläche inkl. Scroll-Balken
Die Menüleiste müssen wir uns selbst basteln, die Editor-Oberfläche bringt Swing weitgehend fertig
mit.

Eine neue Menüleiste erzeugen wir mit JMenuBar.
Jedes (Haupt-)Menü („Datei“, „Bearbeiten“) ist ein JMenu.
Jeder einzelne Menüpunkt ein JMenuItem.

Die Menüauswahl soll etwa so wie auf den folgenden Seiten aussehen.

Bitte beachten Sie den Menüpunkt „Senden an“, bei dem es sich um ein Untermenü handelt.
„Senden an“ ist also kein JMenuItem, sondern ein JMenu und enthält seinerseits wieder
JMenuItems.

Die Editor-Oberfläche bringt Swing weitgehend in Form der Klasse JTextPane mit. In dieser kann
man mit den Methoden setText() bzw. getText() den Inhalt setzen bzw. auslesen.

Bettet man diese JTextPane in eine JScrollPane ein, erhält man automatisch einen
passenden Scrollbalken.

Vorgehen:
   • Instanz von JTextPane erstellen
   • Instanz von JScrollPane mit dieser JTextPane als Inhalt erstellen (über den
       Konstruktor)
   • JScrollPane zum Fenster hinzufügen.

Hinweis: Das JScrollPane ist ein Container und enthält nun das JTextPane. Es reicht also, das
JScrollPane hinzuzufügen; das darin enthaltener JTextPane wird damit ebenfalls hinzugefügt.

Zum Beispiel so:
JTextPane editPane = new JTextPane();
JScrollPane scrollPane = new JScrollPane(editPane);
scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
frameInstance.add(scrollPane);

Teilaufgaben (gehen Sie am besten in dieser Reihenfolge vor!):

1) Legen Sie das Grundgerüst (JFrame, s.o.) an und wählen Sie einen Layoutmanager.
2) Erzeugen Sie ein Menü, das den obigen Angaben (zumindest in etwa) entspricht.
       Hinweis:
       Component- bzw. Button-Objekte (hier: comp) haben u.a. folgende Methoden:
         comp.setEnabled(boolean); // Aktiviert oder nicht?
         comp.addActionListener(ActionListener); // Instanz v. ActionListener
         comp.setMnemonic(int);    // Tastenkürzel (char), siehe JavaDoc
       Evtl. rentiert es sich, eine Methode zu schreiben, über die man in einer Zeile ein neues
       JMenuItem erzeugen und gleichzeitig mehrere dieser Werte setzen kann.
3) Erzeugen Sie ein JTextPane mit Scrollbalken wie oben beschrieben
4) Füllen Sie die Methode actionPerformed() mit Leben und implementieren Sie folgende
   Funktionen:
   a) „Neu…“ leert das JTextPane (leere Anzeige).
   b) „Öffnen…“ zeigt eine Dateiauswahlbox an und liest den Inhalt der gewählten Textdatei in
       den Editor ein.
   c) Der Menüpunkt „Speichern“ ist erst aktiviert, wenn eine Datei eingelesen wurde. Wird er
       ausgewählt, wird der aktuelle Inhalt des Editors in diese Datei zurückgeschrieben.
   d) „Beenden“ beendet das Programm nach einer Abfrage, ob das Programm tatsächlich
       beendet werden soll
5) Freiwillige Erweiterungen:
   a) Wer will darf sich auch an der Funktion „Suchen und Ersetzen“ versuchen und Tastenkürzel
       ermöglichen.
   b) Erweitern um Copy & Paste per Bearbeiten-Menü (Hinweise am Ende beachten für das
       Arbeiten mit der Zwischenablage)
   c) Erweitern um ein Popup-Menü für Copy & Paste

Hinweis: Erfinden Sie das Rad nicht immer neu! Verwenden Sie zum Lesen und Schreiben der Dateien
Code, den Sie bereits in anderen Übungsaufgaben entwickelt haben, wieder. Selbiges gilt für die
Dateiauswahlbox und die Abfrage zum Beenden des Programms.

                                      Screenshot Menü „Datei“

                                   Screenshot Menü „Bearbeiten“

Arbeiten mit der Zwischenablage:
Folgende Code-Snippets können Sie verwenden, um Inhalte in der Zwischenablage programmatisch
zu speichern respektive auszulesen:

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;

// (...)

/**
  * Copy content to clipboard
  *
  * @param content content to copy
  */
public void copySelectionToClipboard() {
     String content = this.editPane.getSelectedText();
     if (content != null) {
        StringSelection selection = new StringSelection(content);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
     }
}

/**
  * Paste clipboard content, just inserts at current caret position and ignores
  * selection (text editors usually replace selected text with clipboard content)
  */
public void doPaste() {
     try {
        String data = (String) Toolkit.getDefaultToolkit().getSystemClipboard()
                                                 .getData(DataFlavor.stringFlavor);
        if (data != null) {
           this.editPane.getDocument()
                       .insertString(this.editPane.getCaretPosition(), data, null);
        }
     } catch (Exception e) {
     }
}
```

## Benötigte Begriffe
[[Konstante]] · [[Bedingungsoperator]] · [[switch]] · [[while-Schleife]] · [[for-Schleife]] · [[break und continue]] · [[Array]] · [[Konstruktor]] · [[this]] · [[static]] · [[toString]] · [[Kapselung]] · [[Sichtbarkeitsmodifikatoren]] · [[Vererbung]] · [[Überschreiben]] · [[super]] · [[equals und hashCode]] · [[Anonyme innere Klasse]] · [[String]] · [[StringBuilder und StringBuffer]] · [[Exception]] · [[try-with-resources]] · [[Reader und Writer]] · [[BufferedReader und BufferedWriter]] · [[Datei und Pfad]] · [[Swing]] · [[JFrame]] · [[Swing-Komponenten]] · [[Menü]] · [[Layoutmanager]] · [[Dialoge]] · [[Farben und Schriften]] · [[Listener]] · [[Set]] · [[Lambda-Ausdruck]]

## Weitere Übungen zum Thema
[[Ü23 Währungsumrechner (2)]] · [[Ü23 Body-Mass-Index (BMI)]] · [[Ü23 Binäre Zahlen]] · [[Ü23 Zahlenraten (2)]] · [[Ü23 Hütchenspiel]]

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
> import java.io.BufferedReader;
> import java.io.BufferedWriter;
> import java.io.File;
> import java.io.FileReader;
> import java.io.FileWriter;
> import java.io.IOException;
> 
> import javax.swing.JFileChooser;
> import javax.swing.JFrame;
> import javax.swing.JMenu;
> import javax.swing.JMenuBar;
> import javax.swing.JMenuItem;
> import javax.swing.JOptionPane;
> import javax.swing.JScrollPane;
> import javax.swing.JSeparator;
> import javax.swing.JTextPane;
> import javax.swing.KeyStroke;
> import javax.swing.filechooser.FileFilter;
> 
> @SuppressWarnings("serial")
> public class Editor extends JFrame {
>     private static final String SEPARATOR = "--";
>     private static final String SEND_MENU = "-SENDMENU-";
>     private static final String NEWFILENAME = "newfile.txt";
> 
>     private final static int INITIAL_WIDTH = 600;
>     private final static int INITIAL_HEIGHT = 480;
> 
>     private JMenu fileMenu;
>     private JMenu editMenu;
>     private JTextPane editPane;
> 
>     private String filePath = Editor.NEWFILENAME;
> 
>     Aufgaben Events (2)                           Musterlösung                        1 / 11
> 
>     private final String[] fileMenuItems = { "Neu", "\u00D6ffnen",
>         Editor.SEPARATOR, "Schlie\u00DFen", Editor.SEPARATOR, "Speichern",
>         "Speichern unter...", "Als Webseite speichern",
>         "Suchen", Editor.SEPARATOR, "Versionen", Editor.SEPARATOR,
>         "Webseitenvorschau", Editor.SEPARATOR, "Seite einrichten...",
>         "Seitenansicht", "Drucken", Editor.SEPARATOR, Editor.SEND_MENU,
>         "Eigenschaften", Editor.SEPARATOR, "bilanz_2017.doc",
>         "bericht_2018_01.doc", "ziele.doc", Editor.SEPARATOR,
>         "Beenden" };
> 
>     // The following numbers are the array indices of the items in fileMenuItems
>     private static final int NEW_MENU = 0;
>     private static final int OPEN_MENU = 1;
>     private static final int CLOSE_MENU = 3;
>     private static final int SAVE_MENU = 5;
>     private static final int SAVEAS_MENU = 6;
>     private static final int EXIT_MENU = 25;
> 
>     private final String[] editMenuItems = { "R\u00FCckg\u00E4ngig",
>         "Wiederholen", Editor.SEPARATOR, "Ausschneiden", "Kopieren",
>         "Office-Zwischenablage", "Einf\u00FCgen", "Inhalte einf\u00FCgen",
>         "Als Hyperlink einf\u00FCgen", Editor.SEPARATOR, "L\u00F6schen",
>         "Alles markieren", Editor.SEPARATOR, "Suchen...", "Ersetzen...",
>         "Gehe zu...", Editor.SEPARATOR, "Verkn\u00FCpfungen...", "Objekt" };
> 
>     // The following numbers are the array indices of the items in editMenuItems
>     private static final int FIND_MENU = 13;
>     private static final int REPLACE_MENU = 14;
> 
>     private final String[] sendMenuItems = { "E-Mail-Empf\u00E4nger",
>         "E-Mail-Empf\u00E4nger (zur \u00DCberarbeitung)",
>         "E-Mail-Empf\u00E4nger (als Anlage)", Editor.SEPARATOR,
>         "Verteilerempf\u00E4nger...", "Onlinebesprechungsteilnehmer",
>         "Exchange-Ordner...", "Fax-Empf\u00E4nger...", Editor.SEPARATOR,
>         "Microsoft Powerpoint" };
> 
>     /**
>      * Constructor for the editor
>      */
>     public Editor() {
>         super( "Editor" );
>         this.setLayout( new BorderLayout() );
> 
>         // Create scrollable editor
>         this.editPane = new JTextPane();
>         this.editPane.setFont( new Font( Font.MONOSPACED, Font.PLAIN, 16 ) );
>         this.add( new JScrollPane( this.editPane ), BorderLayout.CENTER );
> 
>         // Create menu
>         JMenuBar menu = new JMenuBar();
>         menu.add( this.fileMenu =
>         this.getMenu( "Datei", KeyEvent.VK_D, this.fileMenuItems ) );
>         menu.add( this.editMenu =
>         this.getMenu( "Bearbeiten", KeyEvent.VK_B, this.editMenuItems ) );
> 
>         // Add listeners
> 
>         Aufgaben Events (2)                           Musterlösung                         2 / 11
> 
>         this.addFileMenuListeners();
>         this.addEditMenuListeners(); // extension
> 
>         this.setSaveAndCloseEnabledState();
>         this.setJMenuBar( menu );
>         this.setSize( Editor.INITIAL_WIDTH, Editor.INITIAL_HEIGHT );
>         this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
>         this.setVisible( true );
>     }
> 
>     /**
>      * Add the listeners to the file menu items
>      */
>     private void addFileMenuListeners() {
>         // Cast is not very elegant -> use getItem() !
>         JMenuItem itemNew =
>         (JMenuItem) this.fileMenu.getMenuComponent( Editor.NEW_MENU );
>         itemNew.addActionListener( new ActionListener() {
>             @Override
>             public void actionPerformed( ActionEvent e ) {
>                 Editor.this.filePath = Editor.NEWFILENAME;
>                 Editor.this.setTitle( Editor.this.filePath );
>                 Editor.this.editPane.setText( "" );
>                 Editor.this.setSaveAndCloseEnabledState();
>             }
>         } );
> 
>         // Open
>         this.fileMenu.getItem( Editor.OPEN_MENU )
>         .addActionListener( new ActionListener() {
>             @Override
>             public void actionPerformed( ActionEvent e ) {
>                 File f = Editor.this.selectFile( "\u00D6ffnen" );
>                 if ( f != null ) {
>                     Editor.this.filePath = f.getAbsolutePath();
>                     Editor.this.setTitle( f.getName() );
>                     Editor.this.editPane
>                     .setText( Editor.this.readTextfile( f ) );
>                     Editor.this.setSaveAndCloseEnabledState();
>                 }
>             }
>         } );
> 
>         // Close (extension)
>         this.fileMenu.getItem( Editor.CLOSE_MENU )
>         .addActionListener( new ActionListener() {
>             @Override
>             public void actionPerformed( ActionEvent e ) {
>                 Editor.this.filePath = Editor.NEWFILENAME;
>                 Editor.this.setTitle( Editor.this.filePath );
>                 Editor.this.editPane.setText( "" );
>                 Editor.this.setSaveAndCloseEnabledState();
>             }
>         } );
> 
>         // Save
> 
>         Aufgaben Events (2)                           Musterlösung                     3 / 11
> 
>         this.fileMenu.getItem( Editor.SAVE_MENU )
>         .addActionListener( new ActionListener() {
>             @Override
>             public void actionPerformed( ActionEvent e ) {
>                 Editor.this.writeTextfile( new File( Editor.this.filePath ),
>                 Editor.this.editPane.getText() );
>             }
>         } );
> 
>         // Save as (extension)
>         this.fileMenu.getItem( Editor.SAVEAS_MENU )
>         .addActionListener( new ActionListener() {
>             @Override
>             public void actionPerformed( ActionEvent e ) {
>                 File f = Editor.this.selectFile( "Speichern unter" );
>                 if ( f != null ) {
>                     Editor.this.filePath = f.getAbsolutePath();
>                     Editor.this.setTitle( f.getName() );
>                     Editor.this.writeTextfile( f,
>                     Editor.this.editPane.getText() );
>                     Editor.this.setSaveAndCloseEnabledState();
>                 }
>             }
>         } );
> 
>         // Exit (with confirmation)
>         this.fileMenu.getItem( Editor.EXIT_MENU )
>         .addActionListener( new ActionListener() {
>             @Override
>             public void actionPerformed( ActionEvent e ) {
>                 if ( JOptionPane.showConfirmDialog( null,
>                 "Editor wirklich beenden?",
>                 "Beenden",
>                 JOptionPane.YES_NO_OPTION ) == JOptionPane.YES_OPTION ) {
>                     System.exit( 0 );
>                 }
>             }
>         } );
>     }
>     /**
>      * Add the listeners to the edit menu items (extension)
>      */
>     private void addEditMenuListeners() {
>         JMenuItem itemFind = this.editMenu.getItem( Editor.FIND_MENU );
>         itemFind.setAccelerator( KeyStroke.getKeyStroke( "control F" ) );
> 
>         itemFind.addActionListener( new ActionListener() {
>             @Override
>             public void actionPerformed( ActionEvent e ) {
>                 String toFind =
>                 JOptionPane.showInputDialog( null, "Was suchen?",
>                 Editor.this.editPane.getSelectedText() );
> 
>                 // Force unix line separators
>                 String text = Editor.this.editPane.getText()
>                 .replaceAll( System.lineSeparator(), "\n" );
>                 // If something is already selected: continue search afterwards
> 
>                 Aufgaben Events (2)                           Musterlösung                         4 / 11
> 
>                 int start = Editor.this.editPane.getSelectionStart();
>                 start = (start >= 0 && start < text.length()) ? start + 1 : 0;
>                 int position = text.indexOf( toFind, start );
>                 if ( position >= 0 ) {
>                     Editor.this.editPane.select( position,
>                     position + toFind.length() );
>                 }
>             }
>         } );
>         JMenuItem itemReplace = this.editMenu.getItem( Editor.REPLACE_MENU );
>         itemReplace.setAccelerator( KeyStroke.getKeyStroke( "control G" ) );
>         itemReplace.addActionListener( new ActionListener() {
>             @Override
>             public void actionPerformed( ActionEvent e ) {
>                 String toReplace =
>                 JOptionPane.showInputDialog( null, "Was suchen?",
>                 Editor.this.editPane.getSelectedText() );
>                 String replacement =
>                 JOptionPane.showInputDialog( null, "Mit was ersetzen?",
>                 Editor.this.editPane.getSelectedText() );
> 
>                 // Force unix line separators
>                 String text = Editor.this.editPane.getText()
>                 .replaceAll( System.lineSeparator(), "\n" );
> 
>                 text = text.replaceAll( toReplace, replacement );
>                 Editor.this.editPane.setText( text );
>             }
>         } );
>     }
>     /**
>      * Produces a JMenu with JMenuItems according to items array
>      *
>      * @param menuName name of parent menu
>      * @param mnemonic mnemonic for the parent menu
>      * @param items string array with sub items labels
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
>     /**
> 
>     Aufgaben Events (2)                           Musterlösung                        5 / 11
> 
>      * Set the menu items enabled state according to condition if current file
>      * path is {@link Editor#NEWFILENAME}.
>      */
>     private void setSaveAndCloseEnabledState() {
>         boolean enabled = !this.filePath.equals( Editor.NEWFILENAME );
>         this.fileMenu.getItem( Editor.SAVE_MENU ).setEnabled( enabled );
>         this.fileMenu.getItem( Editor.CLOSE_MENU ).setEnabled( enabled );
>     }
> 
>     /**
>      * Open file select dialog
>      *
>      * @param text approve button label
>      * @return selected file or <code>null</code> if no file was selected
>      */
>     public File selectFile( String text ) {
>         JFileChooser fc = new JFileChooser();
>         fc.setFileFilter( new FileFilter() {
>             @Override
>             public boolean accept( File f ) {
>                 return f.isDirectory()
>                 || f.getName().toLowerCase().endsWith( ".txt" );
>             }
> 
>             @Override
>             public String getDescription() {
>                 return "Textdateien";
>             }
>         } );
>         if ( fc.showDialog( null, text ) == JFileChooser.APPROVE_OPTION ) {
>             return fc.getSelectedFile();
>         }
>         return null;
>     }
> 
>     /**
>      * Get the content of a text file as string and current system line
>      * separators
>      *
>      * @param textFile text file to read
>      * @return content of file or empty string if file does not exist
>      */
>     protected String readTextfile( File textFile ) {
>         StringBuilder result = new StringBuilder();
>         if ( textFile.exists() ) {
>             try ( BufferedReader br =
>             new BufferedReader( new FileReader( textFile ) ) ) {
>                 while ( br.ready() ) {
>                     result.append( br.readLine() ).append( System.lineSeparator() );
>                 }
>             } catch ( IOException e ) {
>                 System.err.println( "Fehler beim Lesen: " + e.getMessage() );
>             }
>         }
>         return result.toString();
>     }
>     /**
> 
>     Aufgaben Events (2)                           Musterlösung                        6 / 11
> 
>      * Save content to text file (overwriting existing files!)
>      *
>      * @param textFile
>      *            file to write to
>      * @param content
>      *            content to write
>      */
>     public void writeTextfile( File textFile, String content ) {
>         if ( textFile != null ) {
>             try ( BufferedWriter bw =
>             new BufferedWriter( new FileWriter( textFile ) ) ) {
>                 bw.write( content );
>             } catch ( IOException ex ) {
>                 System.err.println( "Fehler beim Schreiben von " +
>                 textFile.getAbsolutePath() );
>             }
>         }
>     }
> 
>     /**
>      * Run an instance of the editor
>      */
>     public static void main( String[] args ) {
>         new Editor();
>     }
> 
> }
> 
> Aufgaben Events (2)                           Musterlösung               7 / 11
> ```

## Meine Notizen

