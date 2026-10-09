---
tags: ["typ/thema", "thema/java8", "kategorie/funktional", "semester/2"]
aliases: ["Java 8 – Lambdas, Streams, NIO.2", "Folien 33"]
semester: 2
kategorie: "Funktionale Programmierung"
folien: "[[Material/Folien/33_Java8.pdf]]"
seiten: 62
---

# 33 Java 8 – Lambdas, Streams, NIO.2

← [[32 Maven]] · [[Start|🏠 Start]] · [[35 Zum Programmentwurf]] →

> [!abstract] Worum geht's?
> Sprach-Erweiterungen ab Java 8: effectively final, funktionale Interfaces, Lambda-Ausdrücke, Erweiterungen im Collection-Framework, die Stream-API (Zwischen- und Terminalfunktionen), NIO.2 (Path/Files) und records.

**Semester:** Programmieren II · **Bereich:** #kategorie/funktional · **Folien:** [[Material/Folien/33_Java8.pdf|33_Java8.pdf]] (62 Seiten)

## Gliederung der Folien
- [[Material/Folien/33_Java8.pdf#page=2|S. 2]] Übersicht Sprach-Erweiterungen
- [[Material/Folien/33_Java8.pdf#page=5|S. 5]] Was ist noch neu in Java 8?
- [[Material/Folien/33_Java8.pdf#page=6|S. 6]] Effectively Final
- [[Material/Folien/33_Java8.pdf#page=8|S. 8]] Functional Interfaces
- [[Material/Folien/33_Java8.pdf#page=9|S. 9]] Lambda-Expressions
- [[Material/Folien/33_Java8.pdf#page=12|S. 12]] Lambda-Expressions – mehrere Argumente
- [[Material/Folien/33_Java8.pdf#page=14|S. 14]] Lambda-Expressions – weiteres Beispiel
- [[Material/Folien/33_Java8.pdf#page=15|S. 15]] Lambda-Expressions – Code-Blöcke
- [[Material/Folien/33_Java8.pdf#page=16|S. 16]] Lambda-Expressions – Gültigkeitsbereich
- [[Material/Folien/33_Java8.pdf#page=17|S. 17]] Lambda-Expressions – Mehrdeutigkeiten
- [[Material/Folien/33_Java8.pdf#page=18|S. 18]] Beispiel: Runnable als Lambda-Expression
- [[Material/Folien/33_Java8.pdf#page=19|S. 19]] Erweiterungen im Collection-Framework
- [[Material/Folien/33_Java8.pdf#page=21|S. 21]] Streaming-API
- [[Material/Folien/33_Java8.pdf#page=22|S. 22]] Für die Beispiele: Klasse Person
- [[Material/Folien/33_Java8.pdf#page=23|S. 23]] Streamverarbeitung starten
- [[Material/Folien/33_Java8.pdf#page=26|S. 26]] Streamverarbeitung starten mit generate
- [[Material/Folien/33_Java8.pdf#page=29|S. 29]] Vorschau: Terminalfunktion forEach
- [[Material/Folien/33_Java8.pdf#page=30|S. 30]] Zwischenfunktionen - filter
- [[Material/Folien/33_Java8.pdf#page=31|S. 31]] Zwischenfunktionen – map
- [[Material/Folien/33_Java8.pdf#page=33|S. 33]] Zwischenfunktionen – skip
- [[Material/Folien/33_Java8.pdf#page=34|S. 34]] Zwischenfunktionen – distinct
- [[Material/Folien/33_Java8.pdf#page=35|S. 35]] Zwischenfunktionen – peek
- [[Material/Folien/33_Java8.pdf#page=36|S. 36]] Zwischenfunktionen – flatMap
- [[Material/Folien/33_Java8.pdf#page=37|S. 37]] Zwischenfunktionen – sorted
- [[Material/Folien/33_Java8.pdf#page=38|S. 38]] Terminalfunktionen – Erinnerung: forEach
- [[Material/Folien/33_Java8.pdf#page=39|S. 39]] Terminalfunktionen – collect
- [[Material/Folien/33_Java8.pdf#page=42|S. 42]] Terminalfunktionen – Reduzierer
- [[Material/Folien/33_Java8.pdf#page=44|S. 44]] Terminalfunktionen – IntStream
- [[Material/Folien/33_Java8.pdf#page=45|S. 45]] Beispiel 1: Parallele Verarbeitung
- [[Material/Folien/33_Java8.pdf#page=46|S. 46]] Beispiel 2: Mit Stream vs. ohne Stream
- [[Material/Folien/33_Java8.pdf#page=47|S. 47]] NIO.2
- [[Material/Folien/33_Java8.pdf#page=48|S. 48]] NIO.2 – File vs. Path
- [[Material/Folien/33_Java8.pdf#page=50|S. 50]] NIO.2 - Path
- [[Material/Folien/33_Java8.pdf#page=51|S. 51]] NIO.2 – Files
- [[Material/Folien/33_Java8.pdf#page=52|S. 52]] NIO.2 – Files.newBufferedReader
- [[Material/Folien/33_Java8.pdf#page=53|S. 53]] NIO.2 – Files.newBufferedWriter
- [[Material/Folien/33_Java8.pdf#page=54|S. 54]] NIO.2 – Files.readAllBytes
- [[Material/Folien/33_Java8.pdf#page=55|S. 55]] NIO.2 – Files.readAllLines
- [[Material/Folien/33_Java8.pdf#page=56|S. 56]] NIO.2 und Streams
- [[Material/Folien/33_Java8.pdf#page=59|S. 59]] record
- [[Material/Folien/33_Java8.pdf#page=62|S. 62]] Literatur

## Begriffe in diesem Kapitel
- [[Default-Methode]] (S. [[Material/Folien/33_Java8.pdf#page=19|19]], [[Material/Folien/33_Java8.pdf#page=20|20]])
- [[Record]] (S. [[Material/Folien/33_Java8.pdf#page=59|59]], [[Material/Folien/33_Java8.pdf#page=60|60]], [[Material/Folien/33_Java8.pdf#page=61|61]])
- [[BufferedReader und BufferedWriter]] (S. [[Material/Folien/33_Java8.pdf#page=52|52]], [[Material/Folien/33_Java8.pdf#page=53|53]], [[Material/Folien/33_Java8.pdf#page=56|56]])
- [[Datei und Pfad]] (S. [[Material/Folien/33_Java8.pdf#page=47|47]], [[Material/Folien/33_Java8.pdf#page=48|48]], [[Material/Folien/33_Java8.pdf#page=49|49]], [[Material/Folien/33_Java8.pdf#page=50|50]], [[Material/Folien/33_Java8.pdf#page=52|52]], [[Material/Folien/33_Java8.pdf#page=53|53]])
- [[Collection API]] (S. [[Material/Folien/33_Java8.pdf#page=5|5]], [[Material/Folien/33_Java8.pdf#page=12|12]], [[Material/Folien/33_Java8.pdf#page=13|13]], [[Material/Folien/33_Java8.pdf#page=14|14]], [[Material/Folien/33_Java8.pdf#page=19|19]], [[Material/Folien/33_Java8.pdf#page=20|20]])
- [[Comparable und Comparator]] (S. [[Material/Folien/33_Java8.pdf#page=8|8]], [[Material/Folien/33_Java8.pdf#page=12|12]], [[Material/Folien/33_Java8.pdf#page=37|37]])
- [[Runnable]] (S. [[Material/Folien/33_Java8.pdf#page=8|8]], [[Material/Folien/33_Java8.pdf#page=18|18]])
- [[Lambda-Ausdruck]] (S. [[Material/Folien/33_Java8.pdf#page=9|9]], [[Material/Folien/33_Java8.pdf#page=10|10]], [[Material/Folien/33_Java8.pdf#page=11|11]], [[Material/Folien/33_Java8.pdf#page=12|12]], [[Material/Folien/33_Java8.pdf#page=13|13]], [[Material/Folien/33_Java8.pdf#page=14|14]])
- [[Funktionales Interface]] (S. [[Material/Folien/33_Java8.pdf#page=5|5]], [[Material/Folien/33_Java8.pdf#page=8|8]], [[Material/Folien/33_Java8.pdf#page=17|17]], [[Material/Folien/33_Java8.pdf#page=19|19]], [[Material/Folien/33_Java8.pdf#page=20|20]], [[Material/Folien/33_Java8.pdf#page=26|26]])
- [[Methodenreferenz]] (S. [[Material/Folien/33_Java8.pdf#page=14|14]], [[Material/Folien/33_Java8.pdf#page=19|19]], [[Material/Folien/33_Java8.pdf#page=25|25]], [[Material/Folien/33_Java8.pdf#page=26|26]], [[Material/Folien/33_Java8.pdf#page=27|27]], [[Material/Folien/33_Java8.pdf#page=28|28]])
- [[Effectively final]] (S. [[Material/Folien/33_Java8.pdf#page=3|3]], [[Material/Folien/33_Java8.pdf#page=6|6]], [[Material/Folien/33_Java8.pdf#page=7|7]])
- [[Stream-API]] (S. [[Material/Folien/33_Java8.pdf#page=21|21]], [[Material/Folien/33_Java8.pdf#page=23|23]], [[Material/Folien/33_Java8.pdf#page=24|24]], [[Material/Folien/33_Java8.pdf#page=25|25]], [[Material/Folien/33_Java8.pdf#page=26|26]], [[Material/Folien/33_Java8.pdf#page=27|27]])
- [[Optional]] (S. [[Material/Folien/33_Java8.pdf#page=43|43]], [[Material/Folien/33_Java8.pdf#page=44|44]])

## Kommt hier auch vor
[[Zufallszahlen]] · [[Array]] · [[Sortieren]] · [[toString]] · [[equals und hashCode]] · [[Interface]] · [[Anonyme innere Klasse]] · [[Wrapperklasse]] · [[Exception]] · [[try-with-resources]] · [[Datenströme]] · [[Reader und Writer]] · [[Swing-Komponenten]] · [[List]] · [[Collections-Klasse]] · [[Generics]]

## Übungen
- [ ] [[Ü33 Arbeiten mit Streams]] ★★★☆☆ ✅ Musterlösung
- [ ] [[Ü33 Zahlenraten (3)]] ★★☆☆☆ ✅ Musterlösung

## Relevant für diese Programmentwürfe
[[PE CHORona]] · [[PE SpeedyQuiz]]

## Verwandte Themen
[[25 Datenstrukturen und Generics]] · [[22 Innere Klassen]] · [[15 Input und Output]] · [[27 Threads]]

## Folien ansehen
![[Material/Folien/33_Java8.pdf]]

## Folientext (durchsuchbar)
> [!quote]- Kompletter Folientext – aufklappen
> ```text
> ── Seite 1 ──
> Programmieren II
> Java ab Version 8 – Was ist neu?
> 
> Institut für Automation und angewandte Informatik
> 
> KIT – Die Forschungsuniversität in der Helmholtz-Gemeinschaft www.kit.edu
> 
> ── Seite 2 ──
> Übersicht Sprach-Erweiterungen (1)
>    Java-Version   Jahr
>    1.0   1996
>    Java 1.1 (1997)   1.1
>    1.2
>    1997
>    1998
>    1999
>    Innere Klassen   1.3   2000
>    2001
>    Reflection   1.4   2002
>    2003
>    Beans   5   2004
>    2005
>    6   2006
>    2007
>    Java 5 (2004)   2008
>    2009
>    2010
>    Generics   7   2011
>    2012
>    Enums   2013
>    8   2014
>    Autoboxing   2015
>    2016
>    Foreach-Schleife   9
>    10+11
>    2017
>    2018
>    12+13   2019
>    Varargs   14+15   2020
>    16+17   2021
>    Annotationen*   18+19   2022
>    20+21   2023
>    Statische Imports   22+23   2024
>    24(+25)   2025
>    * nicht im Rahmen der Vorlesung behandelt   (26+27)   2026
> 2 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 3 ──
> Übersicht Sprach-Erweiterungen (2)
>    Java-Version   Jahr
>    1.0   1996
>    Java 7 (2011)   1.1
>    1.2
>    1997
>    1998
>    1999
>    switch mit String-Literalen   1.3   2000
>    2001
>    Diamond-Operator (<>)   1.4   2002
>    2003
>    try-with-resources   5   2004
>    2005
>    6   2006
>    2007
>    Java 8 (2014)   2008
>    2009
>    „effectively final“   2010
>    7   2011
>    Statische + Default-Methoden   2012
>    2013
>    in Interfaces   8   2014
>    2015
>    Annotation-Erweiterungen   2016
>    9   2017
>    Lambda-Expressions   10+11
>    12+13
>    2018
>    2019
>    14+15   2020
>    16+17   2021
>    18+19   2022
>    20+21   2023
>    22+23   2024
>    24(+25)   2025
>    (26+27)   2026
> 3 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 4 ──
> Übersicht Sprach-Erweiterungen (3)
>    Java-Version   Jahr
>    1.0   1996
>    Java 10 (2018)   1.1
>    1.2
>    1997
>    1998
>    1999
>    Local-Variable Type Inference   1.3   2000
>    2001
>    Java 12 (2019)   1.4   2002
>    2003
>    Switch Expressions   5   2004
>    2005
>    6   2006
>    Java 14 (2020)   2007
>    2008
>    Records   2009
>    2010
>    7   2011
>    2012
>    2013
>    8   2014
>    2015
>    2016
>    9   2017
>    10+11   2018
>    12+13   2019
>    14+15   2020
>    16+17   2021
>    18+19   2022
>    20+21   2023
>    22+23   2024
>    (Disclaimer: Die Liste stellt keinen Anspruch auf Vollständigkeit!)   24(+25)   2025
>    (26+27)   2026
> 4 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 5 ──
> Was ist noch neu in Java 8?
> 
>    Neben Erweiterung der Sprachfeatures bei Annotations
>    und Lambda-Expressions auch Ergänzungen bei der API
>    JavaFX nun Teil der Standardbibliothek*
>    Neue Verschlüsselungsalgorithmen (java.net.URL → https!)
>    Neue Date/Time-API (Package java.time)
>    Nashorn-JavaScript-Engine (ersetzt Rhino)
>    Functional Interfaces (SAM-Types)
>    Default-Methoden bei Interfaces des Collection-Frameworks
>    Streaming-API
> 
>    Dazu nachher noch ein kleiner „Ausflug“:
>    NIO.2 / Java 7
> 
>    * wurde mit Java 12 wieder rückgängig gemacht
> 
> 5 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 6 ──
> Effectively Final (1)
> 
>    Variablen gelten als „effectively final“, wenn ihnen nur
>    einmal ein Wert zugewiesen wird
>    Variable überall verwendbar, wo normal „final“-Keyword nötig wäre:
>    public void buildMyUi() {
> 
>    JButton b = new JButton(); // kein final Keyword!
> 
>    b.addActionListener( new ActionListener() {
>    public void actionPerformed( ActionEvent e ) {
>    // in anonymer innerer Klasse verwendet
>    System.out.println( b.getText() );
>    }
>    } );
>    Vor Java 8: Compiler-Error
>    }   Ab Java 8: funktioniert!
> 
> 6 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 7 ──
> Effectively Final (2)
> 
>    Sobald zweite Zuweisung ergänzt wird → Fehler!
>    public void buildMyUi() {
>    JButton b = new JButton(); // erste Zuweisung
>    b.addActionListener( new ActionListener() {
>    public void actionPerformed( ActionEvent e ) {
>    // in anonymer innerer Klasse verwendet
>    System.out.println( b.getText() );
>    }
>    } );
>    b = new JButton(); // zweite Zuweisung
>    }
> 
>    Wenn man final-Keyword an der Variable ergänzen
>    könnte, ohne dass es Compiler-Fehler gibt
>    → dann „effectively final“
> 7 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 8 ──
> Functional Interfaces
> 
>    Interfaces mit genau einer abstrakten Methode
>    Auch SAM-Type (single abstract method type) genannt
>    Beispiele, die es bereits vor Java 8 gab
>    Runnable (void run())
>    Comparator (int compare(T,T))
>    ActionListener (void actionPerformed(ActionEvent))
>    Prominente Erweiterungen mit Java 8 (java.util.function)
>    Consumer (void accept(T))
>    BiConsumer (void accept(T,U))
>    Function (R apply(T))
>    BiFunction (R apply(T,U))
>    Supplier (T get())
>    Predicate (boolean test(T))
>    Oft verwand als Lambda-Expression
> 8 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 9 ──
> Lambda-Expressions (1)
> 
>    „Verkürzte Schreibweise“ für die Erzeugung von Instanzen
>    eines SAM-Type
>    JButton b = new JButton();
>    b.addActionListener( new ActionListener() {
>    public void actionPerformed( ActionEvent e ) {
>    System.out.println( b.getText() );
>    }
>    } );
> 
>    wird zu
>    JButton b = new JButton();
>    b.addActionListener( e -> System.out.println( b.getText() ) );
> 
> 9 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 10 ──
> Lambda-Expressions (2)
> 
>    JButton b = new JButton();
>    b.addActionListener( new ActionListener() {
>    public void actionPerformed( ActionEvent e ) {
>    System.out.println( b.getText() );
>    }
>    } );   JButton b = new JButton();
>    b.addActionListener( e -> System.out.println( b.getText() ) );
> 
>    Woher weiß der Compiler was gemeint ist?
>    addActionListener(...) ist nicht überladen, daher ist der Typ
>    des Arguments eindeutig
>    → muss ActionListener sein!
>    ActionListener ist SAM-Type
>    → „Zu implementierende Methode“ muss actionPerformed sein
>    → Typ des Arguments ergibt sich dadurch ebenfalls eindeutig
> 
> 10 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 11 ──
> Lambda-Expressions (3)
> 
>    Es gibt alternative Schreibweisen:
>    JButton b = new JButton();
> 
>    // Bekannte Schreibweise von den Folien zuvor
>    b.addActionListener( e -> System.out.println( b.getText() ) );
> 
>    // Mit Klammern
>    b.addActionListener( (e) -> System.out.println( b.getText() ) );
> 
>    // Mit Klammern + Argument-Typ
>    b.addActionListener(
>    (ActionEvent e) -> System.out.println( b.getText() ) );
> 
>    ➔ alle Bedeutungsgleich!
> 
> 11 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 12 ──
> Lambda-Expressions – mehrere Argumente (1)
> 
>    Was ist bei mehreren Argumenten?
>    List<String> names = new ArrayList<>();
>    // Namen hinzufügen ...
> 
>    // Sortieren nach Länge des namen
>    Collections.sort( names, new Comparator<String>() {
>    @Override
>    public int compare( String a, String b ) {
>    return Integer.compare( a.length(), b.length() );
>    }
>    } );
> 
>    wird zu
>    List<String> names = new ArrayList<>();
>    // Namen hinzufügen ...
> 
>    Collections.sort( names,
>    (a, b) -> Integer.compare( a.length(), b.length() ) );
> 
> 12 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 13 ──
> Lambda-Expressions – mehrere Argumente (2)
> 
>    Bei mehreren Argumenten sind die Klammern nicht mehr
>    optional:
>    List<String> names = new ArrayList<>();
>    // Namen hinzufügen ...
> 
>    Collections.sort( names,
>    (a, b) -> Integer.compare( a.length(), b.length() ) );
> 
>    List<String> names = new ArrayList<>();
>    // Namen hinzufügen ...
> 
>    Collections.sort( names,
>    a, b -> Integer.compare( a.length(), b.length() ) );
> 
> 13 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 14 ──
> Lambda-Expressions – weiteres Beispiel
> 
>    Auslagern des Vergleichs:
>    private int compareByLength( String a, String b ) {
>    return Integer.compare( a.length(), b.length() );
>    }
>    Argumente der SAM-Type-
>    private void foobar() {   Methode und der aufgerufenen
>    List<String> names = new ArrayList<>();   Methode identisch!
>    // Namen hinzufügen ...
> 
>    Collections.sort( names, (a, b) -> this.compareByLength(a, b) );
>    }
> 
>    → weitere Schreibweise möglich
>    Collections.sort( names, this::compareByLength );
> 
>    eine Art „Verweis“ auf die zu nutzende Methode
> 
> 14 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 15 ──
> Lambda-Expressions – Code-Blöcke
> 
>    Bisher immer nur Aufruf einer anderen Methode
>    JButton b = new JButton();
>    b.addActionListener( e -> System.out.println( b.getText() ) );
> 
>    Mehrere Anweisungen in Form eines Code-Blocks sind
>    möglich:
>    JButton b = new JButton();
>    b.addActionListener( e -> {
>    System.out.println( b.getText() );
>    b.setText("Foo");
>    } );
> 
>    Variante ohne geschweifte Klammern ist Vereinfachung
>    des allgemeinen Falls mit komplettem Code-Block
> 
> 15 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 16 ──
> Lambda-Expressions – Gültigkeitsbereich
> 
>    Wichtig: Lambda-Expressions definieren anders als
>    anonyme Instanzen keinen eigenen Gültigkeitsbereich!
>    JButton b = new JButton();
>    b.addActionListener(new ActionListener() {
>    @Override
>    public void actionPerformed(ActionEvent e) {
>    int b = 12;
>    }
>    });
> 
>    JButton b = new JButton();
>    b.addActionListener( e -> {
>    int b = 12;
>    });
> 
>    “Lambda expression's local variable b cannot redeclare
>    Compiler-Fehler
>    another local variable defined in an enclosing scope.“
> 
> 16 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 17 ──
> Lambda-Expressions – Mehrdeutigkeiten
> 
>    Überladene Funktionen ermöglichen Mehrdeutigkeiten
>    public void myFunc( ActionListener al ) {
>    /* ... */
>    }
>    public void myFunc( Consumer<ActionEvent> con ) {
>    /* ... */
>    }
> 
>    Die zu implementierende Methode von ActionListener und
>    Consumer<ActionEvent> hat „Rückgabetyp“ void und erwartet
>    genau ein Argument.
>    this.myFunc( e -> {} ); // ActionListener oder Consumer!?
> 
>    Lösung: Type-Cast zur Kennzeichnung!
>    this.myFunc( (ActionListener) e -> {} );
> 
> 17 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 18 ──
> Beispiel: Runnable als Lambda-Expression
> 
>    „Clock-App“ umgestellt:
>    public ClockApp() {
>    super( "Digital Clock" );
>    this.add( this.dateField );
>    this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
>    this.setSize( 220, 70 );
>    this.setVisible( true );
> 
>    new Thread( () -> {   // Runnable ist SAM-Type mit Methode run()
>    while (true) {
>    try {
>    this.dateField.setText( new Date().toString() );
>    Thread.sleep(1000);
>    } catch (InterruptedException ex) { }
>    }
>    } ).start();
>    }
> 
> 18 W. Geiger, W. Süß, T. Schlachter, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 19 ──
> Erweiterungen im Collection-Framework (1)
> 
>    Einige Schnittstellen im Collection-Framework wurden um
>    Default-Methoden (insb. zur Verwendung mit Lambda-
>    Expressions) erweitert
> 
>    Prominentes Beispiel: Iterieren über Werte
>    Iterable: default void forEach(Consumer<T> action)
>    Map: default void forEach(BiConsumer<K, V> action)
> 
>    List<String> names = new ArrayList<>();
>    // Namen hinzufügen ...
> 
>    // Gibt nacheinander alle Namen aus
>    names.forEach( System.out::println );
> 
> 19 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 20 ──
> Erweiterungen im Collection-Framework (2)
> 
>    Was steckt dahiner?
>    Iterable.forEach ist eine Default-Methode, die eine Schleife
>    implementiert und den Consumer für jedes Element aufruft:
>    default void forEach( Consumer<? super T> action ) {
>    Objects.requireNonNull( action );
>    for ( T t : this ) {
>    action.accept( t );
>    }
>    }   Quelle: java.lang.Iterable
> 
>    Im Prinzip steht da also
>    List<String> names = new ArrayList<>();
>    // Namen hinzufügen ...
> 
>    // Gibt nacheinander alle Namen aus
>    for ( String n : names ) {
>    System.out.println( n );
>    }
> 20 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 21 ──
> Streaming-API
> 
>    Auch: „Bulk Data Operations for Collections”
>    Einführung sog. “Streams” (java.util.stream.Stream)
>    Welche Operationen gibt es?
>    Stream-Verarbeitung “starten”
>    Sequentiell
>    Parallel
>    Zwischenoperationen (“map/reduce/filter”)
>    Terminalfunktionen
>    Beenden die Stream-Verarbeitung
> 
>    Hinweis: es werden nicht alle Operationen vorgestellt
> 21 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 22 ──
> Für die Beispiele: Klasse Person
> 
>    Für einige der Beispiele wird folgende (Hilfs-)Klasse als
>    bekannt vorausgesetzt:
>    public class Person {
>    private String name;
>    private int age;
> 
>    public Person( String name ) {
>    this.name = name;
>    }
>    public Person( String name, int age ) {
>    this.name = name;
>    this.age = age;
>    }
> 
>    public String getName() { return this.name; }
>    public void setName( String name ) { this.name = name; }
>    public int getAge() { return this.age; }
>    public void setAge( int age ) { this.age = age; }
>    public String toString() {
>    return "Person[" + this.name + "," + this.age + "]"; }
>    }
> 
> 22 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 23 ──
> Streamverarbeitung starten (1)
> 
>    Erzeugen eines Streams von Zeichenketten
>    List<String> names = new ArrayList<>();
>    // Namen hinzufügen ...
> 
>    names.stream()... // sequentielle Abarbeitung der Elemente
> 
>    names.parallelStream()... // parallele Abarbeitung der Elemente
> 
>    stream() ist Erweiterung am Interface Collection
>    → für alle Collection-Typen verfügbar
> 
>    Macht natürlich erst „Spaß“ mit weiteren Operationen
> 
> 23 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 24 ──
> Streamverarbeitung starten (2)
> 
>    Erzeugen eines Streams aus einzelnen/mehreren Objekten
>    oder Arrays:
>    // Erzeugt einen Stream mit 1 Zeichenkette
>    Stream.of( "Emma" );
> 
>    // Erzeugt einen Stream mit 2 Zeichenketten
>    Stream.of( "Emma", "Hannah" );
> 
>    // Erzeugt einen Stream mit 2 Zeichenketten aus Array
>    String[] nameArr = { "Emma", "Hannah" };
>    Stream.of( nameArr );
> 
>    Dies funktioniert intern über die Klasse StreamSupport – die Details hierzu würden jedoch zu weit führen
> 24 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 25 ──
> Streamverarbeitung starten (3)
> 
>    Die parallele Streamverarbeitung kann auch jederzeit
>    aktiviert werden:
>    // Erzeugt einen Stream mit 2 Zeichenketten
>    Stream.of( "Emma", "Hannah" )
>    .parallel()   // ab hier paralleler Stream
>    .forEach( this::someCalculation );
> 
>    Es geht auch explizit sequentiell:
>    // Erzeugt einen Stream mit 2 Zeichenketten
>    Stream.of( "Emma", "Hannah" )
>    .sequential()   // ab hier sequentieller Stream
>    .forEach( this::someCalculation );
> 
> 25 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 26 ──
> Streamverarbeitung starten mit generate (1)
> 
>    Mithilfe der .generate()-Methode von Stream lässt sich
>    mittels eines Suppliers (Methode ohne Parameter, die
>    einen Wert liefert) eine beliebige Anzahl von Werten
>    generieren, deren Anzahl mit .limit() begrenzt werden
>    kann:
>    // Produces 10 random numbers and prints them
>    System.out.println("Unbounded random numbers:");
>    Stream.generate( new Random()::nextInt )   Ausgabe
>    .limit(10)   Unbounded random numbers:
>    -1854132691
>    .forEach( System.out::println );   -1796194831
>    654607355
>    1510795794
>    -1085757814
>    484535663
>    -386890242
>    -1195797610
>    540601809
>    44730816
> 
> 26 W. Geiger, W. Süß, T. Schlachter, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 27 ──
> Streamverarbeitung starten mit generate (2)
> 
>    Wenn wir den Wertebereich von .nextInt() einschränken
>    möchten, werden allerdings Parameter benötigt, die der
>    Supplier aber nicht haben darf…
> 
>    // Erzeugt 10 Zufallszahlen von 0 bis 99
>    System.out.println("Unbounded random numbers:");
>    Stream.generate( new Random().nextInt(0, 100) )
>    .limit(10)
>    .forEach( System.out::println );
> 
> 27 W. Geiger, W. Süß, T. Schlachter, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 28 ──
> Streamverarbeitung starten mit generate (3)
> 
>    Die Lösung kann das Auslagern in eine eigene (hier:
>    statische) Methode mit der passenden Signatur sein:
>    import java.util.Random;
>    Ausgabe
>    import java.util.stream.Stream;
>    Random numbers from 0-99:
>    21
>    public class StreamGenerator {   59
>    36
>    static final Random rnd = new Random();
>    7
>    58
>    static int generateRandom() {   73
>    14
>    return rnd.nextInt(0, 100);
>    70
>    }   13
>    48
>    public static void main(String[] args) {
>    System.out.println("Random numbers from 0-99:");
>    Stream.generate( StreamGenerator::generateRandom )
>    .limit( 10 )
>    .forEach( System.out::println );
>    }
>    }
> 
> 28 W. Geiger, W. Süß, T. Schlachter, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 29 ──
> Vorschau: Terminalfunktion forEach
> 
>    Führt Operation auf Elementen des Streams aus und
>    beendet die Stream-Verarbeitung
>    // Befüllen einer Liste mit Namen - mittels Stream
>    List<String> names = new ArrayList<>();
>    Stream.of("Emma","Hannah","Mia","Sophia","Emilia","Lina",
>    "Anna","Marie","Mila","Lea").forEach( names::add );
> 
>    // Alle Stream-Elemente ausgeben
>    names.stream().forEach( System.out::println );
>    Achtung: forEach hier von Stream, nicht von Collection!
> 
>    Weitere Terminalfunktionen später
>    Warum? → forEach praktisch für Beispiele
> 
> 29 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 30 ──
> Zwischenfunktionen - filter
> 
>    filter: Elemente anhand eines bestimmten Kriteriums
>    (Predicate) aussortieren
>    → Alle Namen mit weniger als 4 Zeichen bestimmen:
>    // Befüllen einer Liste mit Namen - mittels Stream
>    List<String> names = new ArrayList<>();
>    Stream.of("Emma","Hannah","Mia","Sophia","Emilia","Lina","Anna","Marie","Mila","Lea").forEach(names::add);
> 
>    names.stream()
>    .filter( n -> (n.length()<4) )   // Hier sind für weitere
>    .forEach( System.out::println );   // Operationen nur noch
>    // Mia und Lea im Stream
> 
>    n ist vom Typ String (da List<String>)
>    Rückgabe des Lambda-Ausdrucks ist vom Typ boolean:
>    true → Element bleibt im Stream
>    Ausgabe
>    false → Element wird aus Stream entfernt
>    Mia
>    Lea
> 
> 30 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 31 ──
> Zwischenfunktionen – map (1)
> 
>    map: Elemente mithilfe einer Umwandlungsfunktion
>    (Function) in andere Objekte umwandeln
>    → Alle Namen in Person-Objekte umwandeln
>    // Befüllen einer Liste mit Namen - mittels Stream
>    List<String> names = new ArrayList<>();
>    Stream.of("Emma","Hannah","Mia","Sophia","Emilia","Lina","Anna","Marie","Mila","Lea").forEach(names::add);
> 
>    names.stream()
>    .map( n -> new Person( n ) )   // Hier sind ab nächstem
>    .forEach( System.out::println ); // Schritt Personen-Objekte im
>    // Stream, keine Strings mehr!
>    Ausgabe
>    n ist vom Typ String (da List<String>)
>    Person[Emma,0]
>    Rückgabe des Lambda-Ausdrucks ist   Person[Hannah,0]
>    Person[Mia,0]
>    vom Typ Person   Person[Sophia,0]
>    Person[Emilia,0]
>    Person[Lina,0]
>    Person[Anna,0]
>    Person[Marie,0]
>    Person[Mila,0]
>    toString-Methode von Person!   Person[Lea,0]
> 
> 31 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 32 ──
> Zwischenfunktionen – map (2)
> 
>    Das geht aber auch noch kürzer:
>    names.stream().map( n -> new Person( n ) ); // Bekannte Variante
> 
>    names.stream().map( Person::new ); // Alternative Schreibweise
> 
>    Compiler weiß anhand der Argumente (1 String-Argument) welcher
>    der beiden Person-Konstruktoren zu verwenden ist
> 
>    map ist der allgemeine Fall für Objekttypen, für primitive
>    Datentypen gibt es spezielle Mapping-Methoden
>    Stream.of( "1","2","3" ).   // Stream mit 3 Zeichenketten.
>    mapToInt( Integer::parseInt ); // Stream aus primitiven int
>    // durch Umwandlung mittels
>    // Integer.parseInt.
> 
>    Ergebnis ist ein IntStream, kein normaler Stream (später mehr)
> 
> 32 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 33 ──
> Zwischenfunktionen – skip
> 
>    Überpringen von n Elementen im Stream
>    // Befüllen einer Liste mit Namen - mittels Stream
>    List<String> names = new ArrayList<>();
>    Stream.of("Emma","Hannah","Mia","Sophia","Emilia",
>    "Lina","Anna","Marie","Mila","Lea").forEach( names::add );
> 
>    names.stream().skip( 4 )   // Emma, Hannah, Mia und
>    .forEach( System.out::println ); // Sophia werden übersprungen,
>    // folgende Operationen
>    // beginnen beim Emilia
> 
>    Ausgabe
>    Emilia
>    Lina
>    Anna
>    Marie
>    Mila
>    Lea
> 
> 33 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 34 ──
> Zwischenfunktionen – distinct
> 
>    Aussortieren von Dubletten
>    für Vergleich wird die equals-Methode verwendet
>    Ausgabe (1)
>    // Variante 1: ohne distinct
>    1
>    Stream.of("1","2","1","2","1","2")   2
>    .forEach( System.out::println );   1
>    2
>    1
>    // Variante 2: mit distinct   2
>    Stream.of("1","2","1","2","1","2")
>    Ausgabe (2)
>    .distinct()   1
>    .forEach( System.out::println );   2
> 
> 34 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 35 ──
> Zwischenfunktionen – peek
> 
>    Operation auf allen Elementen des Streams durchführen
>    Unterschied zu forEach: Stream-Verarbeitung geht weiter
>    Stream.of("1","2","1","2","1","2")
>    .peek( n -> System.out.println( "Peek: " + n ) )
>    .distinct()
>    ...
> 
>    Nach peek geht die Stream-Verarbeitung weiter!
>    Ausgabe
>    Peek: 1
>    Peek: 2
>    Peek: 1
>    Peek: 2
>    Peek: 1
>    Peek: 2
> 
> 35 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 36 ──
> Zwischenfunktionen – flatMap
> 
>    Elemente eines Streams in mehrere Objekte für die weitere
>    Verarbeitung mithilfe einer Function auftrennen
>    („Flachklopfen“ einer Datenstruktur)
>    → „Ergebnis“ der Function muss ein Stream sein!
>    String[][] strings = new String[][]{
>    {"Lorem", "ipsum"}, {"dolor", "sit"}, {"amet", "consectetur"} };
> 
>    Stream.of( strings )   // Stream aus String[]-Elementen
> 
>    .flatMap( Stream::of )   // aus String[]-Eintrag
>    // wird neuer String-Stream
> 
>    .forEach( System.out::println ); // Stream ab hier   Ausgabe
>    // besteht dank flatMap   Lorem
>    // aus String-Elementen   ipsum
>    dolor
>    sit
>    amet
>    consectetur
> 
> 36 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 37 ──
> Zwischenfunktionen – sorted
> 
>    Elemente eines Streams sortieren
>    Stream.of("Lorem","ipsum","dolor","sit","amet","consectetur")
>    .sorted()
>    Ausgabe
>    .forEach( System.out::println );
>    Lorem
>    amet
>    consectetur
>    Elemente müssen vergleichbar sein (Interface   dolor
>    Comparable implementieren)   ipsum
>    sit
> 
>    Alternativ: eigenen Comparator für Sortieren angeben
>    Stream.of("Lorem","ipsum","dolor","sit","amet","consectetur")
>    .sorted( (a, b) -> a.compareToIgnoreCase( b ) )
>    .forEach( System.out::println );   Ausgabe
>    amet
>    consectetur
>    Vorher: (implizit) String.compareTo (Case-sensitive)   dolor
>    ipsum
>    Nun: String.compareToIgnoreCase (Case-insensitive)   Lorem
>    sit
> 
> 37 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 38 ──
> Terminalfunktionen – Erinnerung: forEach
> 
>    Beendet die Stream-Verarbeitung („Rückgabetyp“ void)
>    // Befüllen einer Liste mit Namen - mittels Stream
>    List<String> names = new ArrayList<>();
>    Stream.of("Emma","Hannah","Mia","Sophia","Emilia","Lina",
>    "Anna","Marie","Mila","Lea").forEach( names::add );
> 
>    // Alle Stream-Elemente ausgeben
>    names.stream().forEach( System.out::println );
>    Achtung: forEach hier von Stream, nicht von Collection!
> 
> 38 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 39 ──
> Terminalfunktionen – collect (1)
> 
>    „Einsammeln“ der Elemente im Stream, bspw. in eine Liste
>    // Befüllen einer Liste mit Namen - mittels Stream
>    List<String> names = new ArrayList<>();
>    Stream.of("Emma","Hannah","Mia","Sophia","Emilia",
>    "Lina","Anna","Marie","Mila","Lea").forEach( names::add );
> 
>    List<String> resNames = names.stream()
>    .skip( 4 )   // 4 Elemente überspringen
>    .collect( Collectors.toList() ); // Elemente als Liste einsammeln
> 
>    System.out.println( resNames );
> 
>    Ausgabe
>    [Emilia, Lina, Anna, Marie, Mila, Lea]
> 
>    Ausgabe von toString für List
> 
> 39 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 40 ──
> Terminalfunktionen – collect (2)
> 
>    Es gibt verschiedene, mitgelieferte Kollektoren
>    Werden von java.util.stream.Collectors bereitgestellt
>    Als Liste: Collectors.toList
>    Als Set: Collectors.toSet
>    Zusammenfügen als String: Collectors.joining( CharSequence )
>    // Befüllen einer Liste mit Namen - mittels Stream
>    List<String> names = new ArrayList<>();
>    Stream.of("Emma","Hannah","Mia","Sophia","Emilia",
>    "Lina","Anna","Marie","Mila","Lea").forEach( names::add );
> 
>    String namesCsv = names.stream()
>    .skip( 4 )   // 4 Elemente überspringen
>    .collect( Collectors.joining( ", " ) ); // Elemente als Gesamtstring
>    // einsammeln und jedes Element
>    // durch ", " vom andern trennen
>    System.out.println( namesCsv );
> 
>    Ausgabe
>    Emilia, Lina, Anna, Marie, Mila, Lea
> 
> 40 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 41 ──
> Terminalfunktionen – collect (3)
> 
>    Hinweis:
>    Seit Java 16 gibt es in der Klasse Stream auch eine Methode
>    (Terminalfunktion) toList(), die ebenfalls die Elemente des
>    Streams als Liste zurückliefert.
>    Im Unterschied zur Terminalfunktion
>    .collect(Collectors.toList())
>    handelt es sich bei der resultierenden Liste jedoch um keine
>    konventionelle ArrayList, sondern eine ImmutableList
>    (genauer: java.util.ImmutableCollections.ListN), d.h. die
>    Weiterverarbeitung (z.B. sortieren, löschen von Objekten aus der
>    Liste) ist nicht möglich bzw. der Versuch endet in einem
>    Laufzeitfehler!
> 
> 41 W. Geiger, W. Süß, T. Schlachter, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 42 ──
> Terminalfunktionen – Reduzierer (1)
> 
>    count: Zählen der Anzahl der Elemente im Stream
>    // Befüllen einer Liste mit Namen - mittels Stream
>    List<String> names = new ArrayList<>();
>    Stream.of("Emma","Hannah","Mia","Sophia","Emilia",
>    "Lina","Anna","Marie","Mila","Lea").forEach( names::add );
> 
>    long count = names.stream()
>    .skip( 4 ) // 4 Elemente überspringen
>    .count();   // verbleibende Elemente zählen
> 
>    System.out.println( "count = " + count );
> 
>    Ausgabe
>    count = 6
> 
> 42 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 43 ──
> Terminalfunktionen – Reduzierer (2)
> 
>    findFirst: Das erste Element finden
>    findAny: „Irgendein“ Element finden
>    // Befüllen einer Liste mit Namen - mittels Stream
>    List<String> names = new ArrayList<>();
>    Stream.of("Emma","Hannah","Mia","Sophia","Emilia",
>    "Lina","Anna","Marie","Mila","Lea").forEach( names::add );
> 
>    Optional<String> first = names.stream()
>    .skip( 4 )   // 4 Elemente überspringen
>    .findFirst();   // erstes Element finden
> 
>    if ( first.isPresent() ) { // isPresent von Optional
>    System.out.println( "first = " + first.get() );
>    } else {
>    System.out.println( "no element found" );
>    }
> 
>    Ausgabe
>    first = Emilia
> 
> 43 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 44 ──
> Terminalfunktionen – IntStream
> 
>    Bei typisierten Streams sind weitere, typenspezifische
>    Terminalfunktionen verfügbar
>    Bspw. bei IntStream arithmetische Operationen:
>    // Größte Zahl im IntStream
>    OptionalInt max = IntStream.of( 1, 2, 3, 4, 5 ).max();
> 
>    // Kleinste Zahl im IntStream
>    OptionalInt min = IntStream.of( 1, 2, 3, 4, 5 ).min();
> 
>    // Durchschnitt der Zahlen im IntStream
>    OptionalDouble avg = IntStream.of( 1, 2, 3, 4, 5 ).average();
> 
>    // Summe der Zahlen im IntStream
>    int sum = IntStream.of( 1, 2, 3, 4, 5 ).sum();
> 
>    System.out.printf( "%s, %s, %s, %s\n", max, min, avg, sum );
> 
>    Ausgabe
>    OptionalInt[5], OptionalInt[1], OptionalDouble[3.0], 15
> 
> 44 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 45 ──
> Beispiel 1: Parallele Verarbeitung
>    public class Parallel {
>    public static void main( String[] args ) {
>    // Befüllen einer Liste mit Namen - mittels Stream
>    List<String> names = new ArrayList<>();
>    Stream.of("Emma","Hannah","Mia","Sophia","Emilia",
>    "Lina","Anna","Marie","Mila","Lea").forEach( names::add );
> 
>    long start = System.currentTimeMillis();
>    names.parallelStream().forEach( Parallel::timeConsumingCalculation );
>    System.out.println( "Parallel took " +
>    ( System.currentTimeMillis() – start ) + "ms" );
> 
>    start = System.currentTimeMillis();
>    names.stream().forEach( Parallel::timeConsumingCalculation );
>    System.out.println( "Sequential took "
>    + ( System.currentTimeMillis() - start ) + "ms" );
> 
>    }
>    Ausgabe (8-Kern CPU)
>    public static void timeConsumingCalculation( String name ) {   Parallel took 2010ms
>    try { Thread.sleep( 1000L ); } catch ( Exception e ) { }   Sequential took 10001ms
>    }
>    }
> 
> 45 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 46 ──
> Beispiel 2: Mit Stream vs. ohne Stream
> 
>    Alle Zeichenketten mit ungerade Länge ausfiltern
> // Mit Streams // Klassisch, ohne Streams
> 
> String[] data = String[] data =
> { "Abc", "Defg", "Hi", "Jkl" }; { "Abc", "Defg", "Hi", "Jkl" };
> 
> List<String> filtered = Stream.of( data ) List<String> filtered = new ArrayList<>();
> .filter( e -> (e.length()%2==0) ) for ( String s : data ) {
> .collect( Collectors.toList() ); if ( s.length()%2 == 0 ) {
>    filtered.add( s );
>    }
>    }
> 
>    ➔ Code wird kürzer & übersichtlicher
> 
>    ➔ Es ist vom Wording im Code meist klarer was inhaltlich passiert
> 
> 46 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 47 ──
> NIO.2
> 
>    Eingeführt mit JDK7
>    Neue API für I/O-Operationen
>    Keine Spracherweiterung → Ergänzung der Klassenbibliothek
> 
>    Aspekte die wir betrachten
>    File vs. Path
>    (vereinfachter) Zugriff auf Dateien
>    Nutzung der Java 8-Features mit NIO.2
> 
> 47 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 48 ──
> NIO.2 – File vs. Path (1)
> 
>    Pfad ist (wie File) allgemeine Abbildung einer abstrakten
>    „Adresse“ einer Datei
>    Diese „Adressen“ können absolut oder relativ sein
> 
>    absolut   relativ
>    Windows
>    C:\temp\abc\def.zip   temp\abc\def.zip
> 
>    Unixoide
>    Systeme   /tmp/abc/def.zip   abc/def.zip
> 
> 48 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 49 ──
> NIO.2 – File vs. Path (2)
> 
>    java.util.File hat diverse Nachteile
>    Fehlende Exceptions bei Fehlern die genauer spezifizieren was
>    schiefgegangen ist
>    File.rename funktionierte nicht auf allen Plattformen gleich
>    Symbolische Links kaum unterstützt
>    Attribute wie bspw. Zugriffs- &
>    Eigentumsrechte nicht abgebildet
>    Probleme mit großer Anzahl von
>    Dateien in einem Verzeichnis
>    Probleme mit zirkulären
>    symbolischen Links
> 
>    NIO.2 korrigiert diese Defizite
>    Quelle: https://docs.oracle.com/javase/tutorial/essential/io/legacy.html
> 
> 49 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 50 ──
> NIO.2 - Path
> 
>    Instanzen von java.nio.file.Path werden nicht mit dem
>    new-Operator erzeugt
>    Hierfür ist die Verwendung der einer Factory-Methode vorgesehen:
>    java.nio.file.Paths.get(..)
> 
>    // alt - mit File
>    File f = new File( "/tmp/abc/def.txt" );
> 
>    // neu - mit Path
>    Path p = Paths.get( "/tmp/abc/def.txt" );
> 
> 50 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 51 ──
> NIO.2 – Files
> 
>    Zur Interaktion mit dem Dateisystem bietet die Klasse
>    java.nio.file.Files statische Methoden an
>    Die bekannte Funktionalität kann meist 1:1 wieder
>    gefunden werden, Auswahl:
>    File.createNewFile → Files.createFile
>    File.mkdir → Files.createDirectory
>    File.renameTo → Files.move
>    File.canRead → Files.isReadable
>    Ausführliche Übersicht Alt/Neu siehe
>    https://docs.oracle.com/javase/tutorial/essential/io/legacy.html#mapping
> 
>    Es kam jedoch auch neue Funktionalität hinzu
> 
> 51 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 52 ──
> NIO.2 – Files.newBufferedReader
> 
>    Erzeugen eines BufferedReader-Objekts für eine Datei
>    // alt - mit File
>    File f = new File( "/tmp/abc/def.txt" );
>    try( BufferedReader br = new BufferedReader( new FileReader( f ) ) ){
>    // ...
>    } catch (IOException e) { }
> 
>    //neu - mit Path
>    Path p = Paths.get( "/tmp/abc/def.txt" );
>    try( BufferedReader br = Files.newBufferedReader( p ) ){
>    // ...
>    } catch (IOException e) { }
> 
>    // Encoding Angabe möglich - vorher nur über "Umweg" InputStream
>    try( BufferedReader br = Files.newBufferedReader( p,
>    StandardCharsets.UTF_8 ) ){
>    // ...
>    } catch (IOException e) { }
> 
> 52 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 53 ──
> NIO.2 – Files.newBufferedWriter
> 
>    Erzeugen eines BufferedWriter-Objekts für eine Datei
>    // alt - mit File
>    File f = new File( "/tmp/abc/def.txt" );
>    try( BufferedWriter bw = new BufferedWriter( new FileWriter( f ) ) ){
>    // ...
>    } catch (IOException e) { }
> 
>    //neu - mit Path
>    Path p = Paths.get( "/tmp/abc/def.txt" );
>    try( BufferedWriter bw = Files.newBufferedWriter( p ) ){
>    // ...
>    } catch (IOException e) { }
> 
>    // Encoding Angabe möglich - vorher nur über "Umweg" OutputStream
>    try( BufferedWriter bw = Files.newBufferedWriter( p,
>    StandardCharsets.UTF_8 ) ){
>    // ...
>    } catch (IOException e) { }
> 
> 53 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 54 ──
> NIO.2 – Files.readAllBytes
> 
>    Einlesen einer kompletten Binärdatei
> 
>    Path p = Paths.get( "/tmp/abc/ghi.zip" );
>    try {
>    byte[] data = Files.readAllBytes( p );
>    } catch (IOException e) {
>    }
> 
>    Kein try-with-resources → Komplette Resourcen-
>    Behandlung innerhalb der aufgerufenen Methode
>    Inhalt der Datei steht im Anschluss als byte-Array zur
>    Verfügung
> 
> 54 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 55 ──
> NIO.2 – Files.readAllLines
> 
>    Einlesen aller Zeilen einer Textdatei in 1 Befehl
>    Path p = Paths.get( "/tmp/abc/def.txt" );
>    try {
>    List<String> lines1 = Files.readAllLines( p );
>    List<String> lines2 = Files.readAllLines( p,
>    StandardCharsets.UTF_8 );
>    } catch (IOException e) {
>    }
> 
>    Kein try-with-resources → Komplette Resourcen-
>    Behandlung innerhalb der aufgerufenen Methode
>    Inhalt der Datei steht zeilenweise in der String-Liste
>    Direkte Weiterverarbeiung mit Streams möglich!
> 
> 55 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 56 ──
> NIO.2 und Streams (1)
> 
>    Auszug aus der Musterlösung zu Bücherei
>    Noch keine Nutzung von NIO.2 + Streams
>    public void loadBooks() {
>    try ( BufferedReader br = new BufferedReader(
>    new FileReader( new File( this.filename ) ) ); ) {
>    while ( br.ready() ) {
>    String[] parts = br.readLine().split( ";" );
>    if ( parts.length == 4 ) {
>    this.books.add( new Book( parts[0], parts[1],
>    Integer.parseInt( parts[2] ), parts[3] ) );
>    }
>    }
>    } catch ( Exception ex ) {
>    System.err.println( "Read error: " + ex.getLocalizedMessage() );
>    }
>    }
> 
> 56 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 57 ──
> NIO.2 und Streams (2)
> 
>    Mögliche Anpassung:
>    public void loadBooks() {
>    Path p = Paths.get( this.filename );
>    try {
>    Files.readAllLines( p )   // alle Zeilen lesen
>    .stream()   // als Stream weiterverarbeiten
> 
>    .map(l->l.split( ";" )) // aufsplitten an ";" zu String-Array
> 
>    .filter( l->l.length == 4 )   // alle Arrays rausfiltern, die nicht
>    // genau 4 Einträge haben
> 
>    .map( l->new Book( l[0], l[1],   // Array in ein Buch-Objekt umwandeln
>    Integer.parseInt( l[2] ), l[3] ) )
> 
>    .forEach( this.books::add );   // jedes Buch in die Liste hinzufügen
>    } catch (IOException ex) {
>    System.err.println( "Read error: " + ex.getLocalizedMessage() );
>    }
>    }
> 
> 57 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 58 ──
> NIO.2 und Streams (3)
> 
>    Weitere Möglichkeit (Mix aus „klassisch“ und Streams):
>    public void loadBooks() {
>    Path p = Paths.get( this.filename );
>    try {
>    // Ergebnis der Stream-Operationen wird this.books zugewiesen!
>    this.books = Files.readAllLines( p ) // alle Zeilen lesen
>    .stream()   // als Stream weiterverarbeiten
>    .map( this::parseBook )   // Zeile in Buch umwandeln
>    .filter( Objects::nonNull )   // null-Werte aussortieren
>    .collect( Collectors.toList() ); // Stream in Liste umwandeln
>    } catch (IOException ex) {
>    System.err.println( "Read error: " + ex.getLocalizedMessage() );
>    }
>    }
>    private Book parseBook(String line) {
>    String[] p = line.split( ";" );
>    if ( p.length == 4 ) {
>    return new Book( p[0], p[1], Integer.parseInt( p[2] ), p[3] );
>    } else {
>    return null;
>    }
>    }
> 
> 58 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 59 ──
> record (1)
> 
>    Seit Java 14 gibt es das Schlüsselwort record, mit dem
>    unveränderliche (immutable) Objekte mit verschiedenen
>    Attributen beschrieben werden können.
>    record ist kein neuer Datentyp, sondern eher eine
>    Kurzschreibweise/Schablone, die der Compiler in
>    „normale“ Java-Klassen (mit bestimmten Eigenschaften)
>    umwandelt. Records sind wie Klassen eigene Datentypen.
> 
>    Beispiele für Anwendungsfälle:
>    Ein record repräsentiert eine Zeile einer Datenbank mit je einem
>    Attribut für jede Spalte.
>    Ein record wird verwendet um das strukturierte Ergebnis eines
>    Service-Aufrufs entgegenzunehmen.
> 
> 59 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 60 ──
> record (2)
> 
>    So wird z.B. aus der „normalen“ Java-Klasse
>    public class Person {
>    private String name;
>    private String givenName;
> 
>    public Person(String name, String givenName) {
>    this.name = name;
>    this.givenName = givenName;
>    }
> 
>    /* hashCode and equals */
>    public int hashCode() { … }
>    public boolean equals(Object obj) { … }
> 
>    /* getters */
>    public String getName() { … }
>    public String getGivenName() { … }
>    }
> 
> 60 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 61 ──
> record (3)
> 
>    das sehr viel kompaktere record
>    public record Person (String name, String givenName) { }
> 
>    Der Compiler fügt dem record automatisch folgendes hinzu:
>    Die Parameter als Attribute ( String name; String givenName; )
>    Konstruktor Person(String name, String givenName)
>    getter-Methoden ( name(), givenName() ) für alle Attribute
>    KEINE setter-Methoden (records sind unveränderlich (immutable)!)
>    hashCode() und equals(Object o)
>    für equals(o)==true müssen alle Attribute beider Objekte gleich sein
>    toString() im Stil „Person[name=Doe, givenName=John]“
>    Eigene Konstruktoren sowie Methoden und statische
>    Variablen können dem record hinzugefügt werden.
> 
> 61 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 62 ──
> Literatur
> 
>    Processing Data with Java SE 8 Streams, Part 1+2
>    http://www.oracle.com/technetwork/articles/java/ma14-java-se-8-streams-2177646.html
>    http://www.oracle.com/technetwork/articles/java/architect-streams-pt2-2227132.html
> 
>    The Java™ Tutorials / Lesson: Aggregate Operations
>    https://docs.oracle.com/javase/tutorial/collections/streams/index.html
> 
> 62 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> ```
