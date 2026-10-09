---
tags: ["typ/uebung", "thema/enum", "kategorie/oop", "semester/2", "schwierigkeit/1", "hat/musterloesung"]
aliases: ["Attributes"]
thema: "[[26 Aufzählungstypen (Enums)]]"
klasse: "Attributes"
package: "de.dhbwka.java.exercise.enums.library"
schwierigkeit: 1
status: "offen"
---

# Ü26 Sortierkriterien

**Thema:** [[26 Aufzählungstypen (Enums)]] · **Bereich:** Aufzählungstypen · **Schwierigkeit:** ★☆☆☆☆
**Klasse:** `Attributes` · **Package:** `de.dhbwka.java.exercise.enums.library`

📄 Aufgabe: [[Material/Aufgaben/26_Enum_Aufgaben.pdf#page=3|26_Enum_Aufgaben.pdf, S. 3]]
✅ Musterlösung: [[Material/Aufgaben/26_Enum_Aufgaben_Muster.pdf#page=8|26_Enum_Aufgaben_Muster.pdf, S. 8]]

> [!question] Kurz gesagt
> Bauen Sie die Musterlösung der Aufgabe „Bücherei“ (s. Datenstrukturen) derart um, dass die folgenden Abschnitte durch einen geeigneten Aufzählungstyp Attributes ersetzt werden!

## Aufgabenstellung
```text
Bauen Sie die Musterlösung der Aufgabe „Bücherei“ (s. Datenstrukturen) derart um, dass die
folgenden Abschnitte durch einen geeigneten Aufzählungstyp Attributes ersetzt werden!
Natürlich muss auch der übrige Code an einigen Stellen angepasst werden, z.B. der Typ des order-
Feldes in BookComparator.

Diesen Teil aus der Klasse Book ersetzen:

public static final int TITLE = 0;
public static final int AUTHOR = 1;
public static final int YEAR = 2;
public static final int PUBLISHER = 3;
public static final int[] CRITERIA = {TITLE, AUTHOR, YEAR, PUBLISHER};

Diesen Teil aus der Klasse Library ersetzen:

private static final String[] orderCriteria = {"Titel","Autor","Jahr","Verlag"};

Zusatzaufgabe:
Ersetzen Sie auch das Array inputFields durch eine geeignete Collection-Klasse und adressieren
Sie die JTextField-Komponenten mit Instanzen der Aufzählung Attributes.
```

## Benötigte Begriffe
[[switch]] · [[while-Schleife]] · [[for-Schleife]] · [[Array]] · [[Sortieren]] · [[Konstruktor]] · [[this]] · [[toString]] · [[Kapselung]] · [[Überschreiben]] · [[super]] · [[Interface]] · [[Anonyme innere Klasse]] · [[Enum]] · [[String]] · [[StringBuilder und StringBuffer]] · [[Wrapperklasse]] · [[Exception]] · [[try-with-resources]] · [[Reader und Writer]] · [[BufferedReader und BufferedWriter]] · [[PrintWriter]] · [[Datei und Pfad]] · [[Swing]] · [[JFrame]] · [[JPanel]] · [[Swing-Komponenten]] · [[Layoutmanager]] · [[Dialoge]] · [[Listener]] · [[List]] · [[Comparable und Comparator]] · [[Collections-Klasse]]

## Weitere Übungen zum Thema
[[Ü26 Monate]] · [[Ü26 Kartenspiel]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.enums.library;
> 
> public enum Attributes {
> 
>     TITLE("Title"),
>     AUTHOR("Author"),
>     YEAR("Year"),
>     PUBLISHER("Publisher");
> 
>     private String name;
> 
>     private Attributes( String name ) {
>         this.name = name;
>     }
> 
>     public String getName() {
>         return this.name;
>     }
> 
> }
> 
> package de.dhbwka.java.exercise.enums.library;
> 
> public class Book {
> 
>     private String title;
>     private String author;
>     private int year;
>     private String publisher;
> 
>     public Book() {
>     }
> 
>     Aufgaben Enum                                 Musterlösung                        8 / 13
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
> 
> }
> 
> // Continued on next page
> 
> Aufgaben Enum                                 Musterlösung                     9 / 13
> 
> package de.dhbwka.java.exercise.enums.library;
> 
> import java.util.Comparator;
> 
> public class BookComparator implements Comparator<Book> {
> 
>     private Attributes order; // Selects Attribute to compare
> 
>     public BookComparator( Attributes order ) {
>         this.order = order;
>     }
> 
>     @Override
>     public int compare( Book b1, Book b2 ) {
>         switch (this.order) {
>             case TITLE:
>             return b1.getTitle().compareTo( b2.getTitle() );
>             case AUTHOR:
>             return b1.getAuthor().compareTo( b2.getAuthor() );
>             case YEAR:
>             return b1.getYear() - b2.getYear();
>             case PUBLISHER:
>             return b1.getPublisher().compareTo( b2.getPublisher() );
>         }
>         return 0;
>     }
> 
> }
> 
> // Continued on next page
> 
> Aufgaben Enum                                 Musterlösung               10 / 13
> 
> package de.dhbwka.java.exercise.enums.library;
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
>     private JFrame frame;
>     private String filename = "books.txt";
>     private List<JTextField> inputFields;
>     private List<Book> books = new ArrayList<>();
> 
>     public Library() {
>         this.loadBooks();
> 
>         // Input fields incl. labels
>         JPanel panInput = new JPanel();
>         panInput.setLayout( new GridLayout( 4, 2, 5, 5 ) );
>         this.inputFields = new ArrayList<>();
>         for ( Attributes att : Attributes.values() ) {
>             JTextField field = new JTextField( "" );
>             this.inputFields.add( field );
>             panInput.add( new JLabel( att.getName() ) );
>             panInput.add( field );
>         }
> 
>         // Continued on next page
> 
>         Aufgaben Enum                                 Musterlösung           11 / 13
> 
>         // save button incl. event handling
>         JButton btnSave = new JButton( "Save entry" );
>         btnSave.addActionListener( new ActionListener() {
>             @Override
>             public void actionPerformed( ActionEvent e ) {
>                 Library.this.saveBook( Library.this.inputFields.get( 0 ).getText(),
>                 Library.this.inputFields.get( 1 ).getText(),
>                 new Integer( Library.this.inputFields.get( 2 ).getText() ),
>                 Library.this.inputFields.get( 3 ).getText() );
> 
>                 // Reset fields
>                 for ( JTextField field : Library.this.inputFields ) {
>                     field.setText( "" );
>                 }
>             }
>         } );
> 
>         // sort buttons incl. event handling
>         JPanel panSort = new JPanel( new FlowLayout() );
>         panSort.add( new JLabel( "Ordered output:" ) );
>         for ( Attributes att : Attributes.values() ) {
>             JButton but = new JButton( att.getName() );
>             but.setActionCommand( att.toString() ); // artificial attribute
>             but.addActionListener( new ActionListener() {
>                 @Override
>                 public void actionPerformed( ActionEvent e ) {
>                     Library.this.sort( Attributes
>                     .valueOf( ((JButton) e.getSource()).getActionCommand() ) );
>                 }
>             } );
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
>     Aufgaben Enum                                 Musterlösung                     12 / 13
> 
>     // Continued on next page
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
>     public void sort( Attributes order ) {
>         Collections.sort( this.books, new BookComparator( order ) );
>         // uses Library.toString()
>         JOptionPane.showMessageDialog( this.frame, this,
>         "Books ordered by " + order.getName(),
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
> 
> Aufgaben Enum                                 Musterlösung                   13 / 13
> ```

## Meine Notizen

