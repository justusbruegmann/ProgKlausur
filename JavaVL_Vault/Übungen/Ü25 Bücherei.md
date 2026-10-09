---
tags: ["typ/uebung", "thema/datenstrukturen", "kategorie/datenstrukturen", "semester/2", "schwierigkeit/3", "hat/musterloesung"]
aliases: ["Library"]
thema: "[[25 Datenstrukturen und Generics]]"
klasse: "Library"
package: "de.dhbwka.java.exercise.collections"
schwierigkeit: 3
status: "offen"
---

# Ü25 Bücherei

**Thema:** [[25 Datenstrukturen und Generics]] · **Bereich:** Datenstrukturen (1) · **Schwierigkeit:** ★★★☆☆
**Klasse:** `Library` · **Package:** `de.dhbwka.java.exercise.collections`

📄 Aufgabe: [[Material/Aufgaben/25_Datenstrukturen_Aufgaben-1.pdf#page=2|25_Datenstrukturen_Aufgaben-1.pdf, S. 2]]
✅ Musterlösung: [[Material/Aufgaben/25_Datenstrukturen_Aufgaben-1_Muster.pdf#page=2|25_Datenstrukturen_Aufgaben-1_Muster.pdf, S. 2]]

> [!question] Kurz gesagt
> Schreiben Sie eine graphische Java-Applikation, die es erlaubt Bücherdaten einer Bücherei zu archivieren! Als Archiv soll dazu eine Textdatei dienen.

## Aufgabenstellung
```text
Schreiben Sie eine graphische Java-Applikation, die es erlaubt Bücherdaten einer Bücherei zu
archivieren!

Als Archiv soll dazu eine Textdatei dienen.

Über die Oberfläche soll der Autor, Titel, Erscheinungsjahr und Verlag des betreffenden Buches
eingegeben werden können (siehe auch „Beispiel für geschachteltes Layout“ im Foliensatz
„Grafische Benutzeroberflächen mit Swing“). Nach der Eingabe eines Eintrages sollen diese vier
Eigenschaften in ein File geschrieben werden. Zu Beginn der Applikation wird dieses File eingelesen.

Hinweis: Schreiben Sie eine Klasse Book und eine Klasse Library. Verwenden Sie eine geeignete
Collection zum Speichern der Bücher!

Ihre Oberfläche sollte die folgende Funktionalität haben:

    •    Zu Beginn der Applikation einlesen eines Files, das die bisher existierenden Einträge enthält.
    •    Speichern von neuen Einträgen (im File), bereits vorhandene Einträge sollen nicht noch
         einmal gespeichert werden.
    •    Anzeige aller archivierten Einträge. Hier soll ausgewählt werden können ob die Einträge
         nach Autor, Titel, Erscheinungsjahr oder Verlag sortiert sind (siehe Beispiel oben).
    •    Jede sortierte Liste soll dabei in einem eigenen Pop-Up-Fenster dargestellt werden (siehe
         Beispiele).

Weitere Hinweise:
   • Verwenden Sie das Interface Comparator zum Erzeugen geeigneter Comparatoren.
   • Mit der Methode split() eines String-Objekts können Sie eine Zeichenkette unter
       Vorgabe eines Trenners in Teilzeichenketten zerlegen, siehe Javadoc. Die Rückgabe ist ein
       Feld der Teilzeichenketten String[].

                                   Beispiele für sortierte Ausgabe
```

## Benötigte Begriffe
[[Konstante]] · [[Scanner]] · [[switch]] · [[while-Schleife]] · [[for-Schleife]] · [[Array]] · [[Sortieren]] · [[Konstruktor]] · [[this]] · [[toString]] · [[Kapselung]] · [[Überschreiben]] · [[super]] · [[Interface]] · [[Anonyme innere Klasse]] · [[String]] · [[StringBuilder und StringBuffer]] · [[Wrapperklasse]] · [[Javadoc]] · [[Exception]] · [[try-with-resources]] · [[Reader und Writer]] · [[BufferedReader und BufferedWriter]] · [[PrintWriter]] · [[Datei und Pfad]] · [[Swing]] · [[JFrame]] · [[JPanel]] · [[Swing-Komponenten]] · [[Layoutmanager]] · [[Dialoge]] · [[Listener]] · [[List]] · [[Comparable und Comparator]] · [[Collections-Klasse]]

## Weitere Übungen zum Thema
[[Ü25 Ziehung der Lottozahlen]] · [[Ü25 Binärbaum]] · [[Ü25 Tankstellenpreise]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.collections;
> 
> public class Book {
> 
>     public static final int TITLE = 0;
>     public static final int AUTHOR = 1;
>     public static final int YEAR = 2;
>     public static final int PUBLISHER = 3;
>     public static final int[] CRITERIA =
>     { Book.TITLE, Book.AUTHOR, Book.YEAR, Book.PUBLISHER };
> 
>     private String title;
>     private String author;
>     private int year;
>     private String publisher;
> 
>     public Book() {
>     }
> 
>     public Book( String title, String author, int year, String publisher ) {
>         super();
>         this.title = title;
>         this.author = author;
>         this.year = year;
>         this.publisher = publisher;
>     }
> 
>     @Override
>     public String toString() {
>         return this.title + ";" + this.author + ";" + this.year + ";"
>         + this.publisher;
>     }
> 
>     public String getTitle() {
>         return this.title;
>     }
> 
>     public void setTitle( String title ) {
>         this.title = title;
>     }
> 
>     public String getAuthor() {
>         return this.author;
>     }
> 
>     public void setAuthor( String author ) {
>         this.author = author;
>     }
> 
>     public int getYear() {
>         return this.year;
>     }
> 
>     public void setYear( int year ) {
>         this.year = year;
>     }
> 
>     public String getPublisher() {
>         return this.publisher;
>     }
> 
>     public void setPublisher( String publisher ) {
>         this.publisher = publisher;
>     }
> }
> 
> package de.dhbwka.java.exercise.collections;
> 
> import java.util.Comparator;
> 
> public class BookComparator implements Comparator<Book> {
> 
>     private int order; // Selects Attribute to compare
> 
>     public BookComparator( int order ) {
>         this.order = order;
>     }
>     @Override
>     public int compare( Book b1, Book b2 ) {
>         switch (this.order) {
>             case Book.TITLE: return b1.getTitle().compareTo( b2.getTitle() );
>             case Book.AUTHOR: return b1.getAuthor().compareTo( b2.getAuthor() );
>             case Book.YEAR:    return b1.getYear() - b2.getYear();
>             case Book.PUBLISHER:
>             return b1.getPublisher().compareTo( b2.getPublisher() );
>         }
>         return 0;
>     }
> }
> 
> package de.dhbwka.java.exercise.collections;
> 
> import java.awt.BorderLayout;
> import java.awt.FlowLayout;
> import java.awt.GridLayout;
> import java.awt.event.ActionEvent;
> import java.awt.event.ActionListener;
> import java.io.BufferedReader;
> import java.io.File;
> import java.io.FileReader;
> import java.io.FileWriter;
> import java.io.PrintWriter;
> import java.util.ArrayList;
> import java.util.Collections;
> import java.util.List;
> 
> import javax.swing.JButton;
> import javax.swing.JFrame;
> import javax.swing.JLabel;
> import javax.swing.JOptionPane;
> import javax.swing.JPanel;
> import javax.swing.JTextField;
> 
> public class Library {
> 
>     private static final String[] orderCriteria =
>     { "Title", "Author", "Year", "Publisher" };
> 
>     private JFrame frame;
>     private String filename = "books.txt";
>     private JTextField[] inputFields;
>     private List<Book> books = new ArrayList<>();
> 
>     public Library() {
>         this.loadBooks();
> 
>         // Input fields incl. labels
>         JPanel panInput = new JPanel();
>         panInput.setLayout( new GridLayout( 4, 2, 5, 5 ) );
>         this.inputFields = new JTextField[Library.orderCriteria.length];
>         for ( int i = 0; i < Library.orderCriteria.length; i++ ) {
>             panInput.add( new JLabel( Library.orderCriteria[i] ) );
>             this.inputFields[i] = new JTextField( "" );
>             panInput.add( this.inputFields[i] );
>         }
> 
>         // Continued on next page
> 
>         // save button incl. event handling
>         JButton btnSave = new JButton( "Save entry" );
>         btnSave.addActionListener( new ActionListener() {
>             @Override
>             public void actionPerformed( ActionEvent e ) {
>                 Library.this.saveBook( Library.this.inputFields[0].getText(),
>                 Library.this.inputFields[1].getText(),
>                 new Integer( Library.this.inputFields[2].getText() ),
>                 Library.this.inputFields[3].getText() );
>                 for ( JTextField field : Library.this.inputFields ) {
>                     field.setText( "" );
>                 }
>             }
>         } );
> 
>         // sort buttons incl. event handling
>         JPanel panSort = new JPanel( new FlowLayout() );
>         panSort.add( new JLabel( "Ordered output:" ) );
> 
>         for ( int i = 0; i < Library.orderCriteria.length; i++ ) {
>             JButton but = new JButton( Library.orderCriteria[i] );
> 
>             // artificial attribute
>             but.setActionCommand( Integer.toString( Book.CRITERIA[i] ) );
>             but.addActionListener( new ActionListener() {
>                 @Override
>                 public void actionPerformed( ActionEvent e ) {
>                     Library.this.sort( Integer.parseInt( e.getActionCommand() ) );
>                 }
>             } );
> 
>             panSort.add( but );
>         }
>         this.frame = new JFrame( "Library" );
>         this.frame.setLayout( new BorderLayout() );
>         this.frame.add( panInput, BorderLayout.NORTH );
>         this.frame.add( btnSave, BorderLayout.CENTER );
>         this.frame.add( panSort, BorderLayout.SOUTH );
>         this.frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
>         this.frame.setSize( 500, 190 );
>         this.frame.setVisible( true );
>     }
> 
>     public void saveBook( String title, String author, int year,
>     String publisher ) {
>         Book book = new Book( title, author, year, publisher );
>         this.books.add( book );
> 
>         try ( PrintWriter pw = new PrintWriter(
>         new FileWriter( new File( this.filename ), true ) ); ) {
>             pw.println( book ); // uses toString of Book
>         } catch ( Exception ex ) {
>             System.err
>             .println( "Write error: " + ex.getLocalizedMessage() );
>         }
>     }
> 
>     public void loadBooks() {
>         try ( BufferedReader br = new BufferedReader(
>         new FileReader( new File( this.filename ) ) ); ) {
>             while ( br.ready() ) {
>                 String[] parts = br.readLine().split( ";" );
>                 if ( parts.length == 4 ) {
>                     this.books.add( new Book( parts[0], parts[1],
>                     new Integer( parts[2] ), parts[3] ) );
>                 }
>             }
>         } catch ( Exception ex ) {
>             System.err.println( "Read error: " + ex.getLocalizedMessage() );
>         }
>     }
> 
>     /**
>      * Order books by order criteria and display ordered list
>      */
>     public void sort( int order ) {
>         Collections.sort( this.books, new BookComparator( order ) );
>         // uses Library.toString()
>         JOptionPane.showMessageDialog( this.frame, this,
>         "Books ordered by " + Library.orderCriteria[order],
>         JOptionPane.INFORMATION_MESSAGE );
>     }
> 
>     /**
>      * All books as a single multi line String
>      *
>      * @return string with one book per line
>      */
>     @Override
>     public String toString() {
>         StringBuffer output = new StringBuffer( "" );
>         for ( Book book : this.books ) {
>             output.append( book + System.lineSeparator() );
>         }
>         return output.toString();
>     };
> 
>     public static void main( String[] args ) {
>         new Library();
>     }
> 
> }
> ```

## Meine Notizen

