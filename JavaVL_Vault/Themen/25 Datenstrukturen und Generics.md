---
tags: ["typ/thema", "thema/datenstrukturen", "kategorie/datenstrukturen", "semester/2"]
aliases: ["Datenstrukturen und Generics", "Folien 25"]
semester: 2
kategorie: "Datenstrukturen"
folien: "[[Material/Folien/25_Datenstrukturen.pdf]]"
seiten: 71
---

# 25 Datenstrukturen und Generics

← [[24A Swing vs. JavaFX]] · [[Start|🏠 Start]] · [[26 Aufzählungstypen (Enums)]] →

> [!abstract] Worum geht's?
> Das Collection-Framework: List, Set, Map mit ihren Implementierungen (ArrayList, LinkedList, HashSet, TreeSet, HashMap, TreeMap), Stack, Iterator, Comparable/Comparator, die Klasse Collections sowie Generics mit Wildcards, Ko- und Kontravarianz.

**Semester:** Programmieren II · **Bereich:** #kategorie/datenstrukturen · **Folien:** [[Material/Folien/25_Datenstrukturen.pdf|25_Datenstrukturen.pdf]] (71 Seiten)

## Gliederung der Folien
- [[Material/Folien/25_Datenstrukturen.pdf#page=2|S. 2]] Datenstrukturen
- [[Material/Folien/25_Datenstrukturen.pdf#page=4|S. 4]] Beispiel: List als „dynamisches“ Array
- [[Material/Folien/25_Datenstrukturen.pdf#page=5|S. 5]] Anwendung generischer Datentypen
- [[Material/Folien/25_Datenstrukturen.pdf#page=8|S. 8]] Zum Vergleich
- [[Material/Folien/25_Datenstrukturen.pdf#page=9|S. 9]] Die Collection API
- [[Material/Folien/25_Datenstrukturen.pdf#page=10|S. 10]] Collection Interfaces
- [[Material/Folien/25_Datenstrukturen.pdf#page=11|S. 11]] Wichtige Methoden des Interfaces Collection
- [[Material/Folien/25_Datenstrukturen.pdf#page=12|S. 12]] Implementierungen von Collections
- [[Material/Folien/25_Datenstrukturen.pdf#page=15|S. 15]] Wichtige Methoden des Interfaces List
- [[Material/Folien/25_Datenstrukturen.pdf#page=16|S. 16]] Die Klasse java.util.ArrayList
- [[Material/Folien/25_Datenstrukturen.pdf#page=17|S. 17]] Die Klasse java.util.LinkedList
- [[Material/Folien/25_Datenstrukturen.pdf#page=18|S. 18]] Beispiel: List und ArrayList
- [[Material/Folien/25_Datenstrukturen.pdf#page=19|S. 19]] Beispiel: Ausgabe einer List
- [[Material/Folien/25_Datenstrukturen.pdf#page=20|S. 20]] Methoden des Interfaces java.util.Set
- [[Material/Folien/25_Datenstrukturen.pdf#page=21|S. 21]] Beispiel: Set mit HashSet
- [[Material/Folien/25_Datenstrukturen.pdf#page=22|S. 22]] Beispiel: Set mit TreeSet
- [[Material/Folien/25_Datenstrukturen.pdf#page=23|S. 23]] Beispiel: Bestimmte Anzahl von Zufallszahlen
- [[Material/Folien/25_Datenstrukturen.pdf#page=24|S. 24]] Methoden des Interfaces java.util.Map
- [[Material/Folien/25_Datenstrukturen.pdf#page=25|S. 25]] Die Klasse java.util.HashMap
- [[Material/Folien/25_Datenstrukturen.pdf#page=27|S. 27]] Mögliches Prinzip für Kollisions-Vermeidung
- [[Material/Folien/25_Datenstrukturen.pdf#page=28|S. 28]] Beispiel Map
- [[Material/Folien/25_Datenstrukturen.pdf#page=29|S. 29]] Die Klasse java.util.TreeMap
- [[Material/Folien/25_Datenstrukturen.pdf#page=30|S. 30]] Weitere Methoden von des Interfaces Map
- [[Material/Folien/25_Datenstrukturen.pdf#page=31|S. 31]] Alternatives Erzeugen von Listen
- [[Material/Folien/25_Datenstrukturen.pdf#page=33|S. 33]] Alternatives Erzeugen von Mengen (Set)
- [[Material/Folien/25_Datenstrukturen.pdf#page=34|S. 34]] Alternatives Erzeugen von Maps
- [[Material/Folien/25_Datenstrukturen.pdf#page=37|S. 37]] Überschreiben von hashCode()
- [[Material/Folien/25_Datenstrukturen.pdf#page=38|S. 38]] Beispiel: Überschreiben von hashCode()
- [[Material/Folien/25_Datenstrukturen.pdf#page=39|S. 39]] Beispiel: Überschreiben von equals()
- [[Material/Folien/25_Datenstrukturen.pdf#page=40|S. 40]] Die Klasse java.util.Stack
- [[Material/Folien/25_Datenstrukturen.pdf#page=41|S. 41]] Methoden von Stack
- [[Material/Folien/25_Datenstrukturen.pdf#page=42|S. 42]] Beispiel: Stack mit Zahlen
- [[Material/Folien/25_Datenstrukturen.pdf#page=43|S. 43]] Das Interface java.util.Enumeration
- [[Material/Folien/25_Datenstrukturen.pdf#page=45|S. 45]] Beispiel: Vorsicht bei remove()
- [[Material/Folien/25_Datenstrukturen.pdf#page=49|S. 49]] Collection mit Iterator „durchlaufen“
- [[Material/Folien/25_Datenstrukturen.pdf#page=50|S. 50]] Iterator benutzen
- [[Material/Folien/25_Datenstrukturen.pdf#page=51|S. 51]] Iterator benutzen ohne Interface Collection
- [[Material/Folien/25_Datenstrukturen.pdf#page=52|S. 52]] Comparable und Comparator
- [[Material/Folien/25_Datenstrukturen.pdf#page=53|S. 53]] Comparable
- [[Material/Folien/25_Datenstrukturen.pdf#page=54|S. 54]] Comparator
- [[Material/Folien/25_Datenstrukturen.pdf#page=55|S. 55]] Comparator in Collection nutzen
- [[Material/Folien/25_Datenstrukturen.pdf#page=56|S. 56]] Anonyme Implementierungen
- [[Material/Folien/25_Datenstrukturen.pdf#page=58|S. 58]] Die Klasse Collections: Algorithmen
- [[Material/Folien/25_Datenstrukturen.pdf#page=61|S. 61]] Beispiel: Sortieren einer Liste
- [[Material/Folien/25_Datenstrukturen.pdf#page=62|S. 62]] myClass\<T\>
- [[Material/Folien/25_Datenstrukturen.pdf#page=63|S. 63]] Generics
- [[Material/Folien/25_Datenstrukturen.pdf#page=64|S. 64]] Unsere erste generische Klasse
- [[Material/Folien/25_Datenstrukturen.pdf#page=66|S. 66]] Invarianz
- [[Material/Folien/25_Datenstrukturen.pdf#page=67|S. 67]] Wildcards
- [[Material/Folien/25_Datenstrukturen.pdf#page=69|S. 69]] Kovarianz und Kontravarianz

## Begriffe in diesem Kapitel
- [[Zufallszahlen]] (S. [[Material/Folien/25_Datenstrukturen.pdf#page=23|23]])
- [[for-Schleife]] (S. [[Material/Folien/25_Datenstrukturen.pdf#page=19|19]], [[Material/Folien/25_Datenstrukturen.pdf#page=21|21]], [[Material/Folien/25_Datenstrukturen.pdf#page=22|22]], [[Material/Folien/25_Datenstrukturen.pdf#page=23|23]], [[Material/Folien/25_Datenstrukturen.pdf#page=28|28]], [[Material/Folien/25_Datenstrukturen.pdf#page=45|45]])
- [[Sortieren]] (S. [[Material/Folien/25_Datenstrukturen.pdf#page=2|2]], [[Material/Folien/25_Datenstrukturen.pdf#page=10|10]], [[Material/Folien/25_Datenstrukturen.pdf#page=20|20]], [[Material/Folien/25_Datenstrukturen.pdf#page=22|22]], [[Material/Folien/25_Datenstrukturen.pdf#page=23|23]], [[Material/Folien/25_Datenstrukturen.pdf#page=29|29]])
- [[equals und hashCode]] (S. [[Material/Folien/25_Datenstrukturen.pdf#page=26|26]], [[Material/Folien/25_Datenstrukturen.pdf#page=27|27]], [[Material/Folien/25_Datenstrukturen.pdf#page=37|37]], [[Material/Folien/25_Datenstrukturen.pdf#page=38|38]], [[Material/Folien/25_Datenstrukturen.pdf#page=39|39]], [[Material/Folien/25_Datenstrukturen.pdf#page=46|46]])
- [[Interface]] (S. [[Material/Folien/25_Datenstrukturen.pdf#page=10|10]], [[Material/Folien/25_Datenstrukturen.pdf#page=11|11]], [[Material/Folien/25_Datenstrukturen.pdf#page=15|15]], [[Material/Folien/25_Datenstrukturen.pdf#page=20|20]], [[Material/Folien/25_Datenstrukturen.pdf#page=24|24]], [[Material/Folien/25_Datenstrukturen.pdf#page=30|30]])
- [[Anonyme innere Klasse]] (S. [[Material/Folien/25_Datenstrukturen.pdf#page=3|3]], [[Material/Folien/25_Datenstrukturen.pdf#page=56|56]], [[Material/Folien/25_Datenstrukturen.pdf#page=57|57]])
- [[Collection API]] (S. [[Material/Folien/25_Datenstrukturen.pdf#page=9|9]], [[Material/Folien/25_Datenstrukturen.pdf#page=10|10]], [[Material/Folien/25_Datenstrukturen.pdf#page=11|11]], [[Material/Folien/25_Datenstrukturen.pdf#page=12|12]], [[Material/Folien/25_Datenstrukturen.pdf#page=13|13]], [[Material/Folien/25_Datenstrukturen.pdf#page=14|14]])
- [[List]] (S. [[Material/Folien/25_Datenstrukturen.pdf#page=4|4]], [[Material/Folien/25_Datenstrukturen.pdf#page=15|15]], [[Material/Folien/25_Datenstrukturen.pdf#page=16|16]], [[Material/Folien/25_Datenstrukturen.pdf#page=17|17]], [[Material/Folien/25_Datenstrukturen.pdf#page=18|18]], [[Material/Folien/25_Datenstrukturen.pdf#page=19|19]])
- [[Set]] (S. [[Material/Folien/25_Datenstrukturen.pdf#page=9|9]], [[Material/Folien/25_Datenstrukturen.pdf#page=10|10]], [[Material/Folien/25_Datenstrukturen.pdf#page=12|12]], [[Material/Folien/25_Datenstrukturen.pdf#page=13|13]], [[Material/Folien/25_Datenstrukturen.pdf#page=20|20]], [[Material/Folien/25_Datenstrukturen.pdf#page=21|21]])
- [[Map]] (S. [[Material/Folien/25_Datenstrukturen.pdf#page=9|9]], [[Material/Folien/25_Datenstrukturen.pdf#page=10|10]], [[Material/Folien/25_Datenstrukturen.pdf#page=24|24]], [[Material/Folien/25_Datenstrukturen.pdf#page=25|25]], [[Material/Folien/25_Datenstrukturen.pdf#page=26|26]], [[Material/Folien/25_Datenstrukturen.pdf#page=28|28]])
- [[Stack]] (S. [[Material/Folien/25_Datenstrukturen.pdf#page=2|2]], [[Material/Folien/25_Datenstrukturen.pdf#page=40|40]], [[Material/Folien/25_Datenstrukturen.pdf#page=41|41]], [[Material/Folien/25_Datenstrukturen.pdf#page=42|42]])
- [[Iterator]] (S. [[Material/Folien/25_Datenstrukturen.pdf#page=43|43]], [[Material/Folien/25_Datenstrukturen.pdf#page=44|44]], [[Material/Folien/25_Datenstrukturen.pdf#page=49|49]], [[Material/Folien/25_Datenstrukturen.pdf#page=50|50]], [[Material/Folien/25_Datenstrukturen.pdf#page=51|51]])
- [[Comparable und Comparator]] (S. [[Material/Folien/25_Datenstrukturen.pdf#page=29|29]], [[Material/Folien/25_Datenstrukturen.pdf#page=52|52]], [[Material/Folien/25_Datenstrukturen.pdf#page=53|53]], [[Material/Folien/25_Datenstrukturen.pdf#page=54|54]], [[Material/Folien/25_Datenstrukturen.pdf#page=55|55]], [[Material/Folien/25_Datenstrukturen.pdf#page=58|58]])
- [[Collections-Klasse]] (S. [[Material/Folien/25_Datenstrukturen.pdf#page=32|32]], [[Material/Folien/25_Datenstrukturen.pdf#page=33|33]], [[Material/Folien/25_Datenstrukturen.pdf#page=36|36]], [[Material/Folien/25_Datenstrukturen.pdf#page=57|57]], [[Material/Folien/25_Datenstrukturen.pdf#page=61|61]])
- [[Generics]] (S. [[Material/Folien/25_Datenstrukturen.pdf#page=3|3]], [[Material/Folien/25_Datenstrukturen.pdf#page=5|5]], [[Material/Folien/25_Datenstrukturen.pdf#page=6|6]], [[Material/Folien/25_Datenstrukturen.pdf#page=7|7]], [[Material/Folien/25_Datenstrukturen.pdf#page=62|62]], [[Material/Folien/25_Datenstrukturen.pdf#page=63|63]])
- [[Wildcards und Varianz]] (S. [[Material/Folien/25_Datenstrukturen.pdf#page=66|66]], [[Material/Folien/25_Datenstrukturen.pdf#page=67|67]], [[Material/Folien/25_Datenstrukturen.pdf#page=68|68]], [[Material/Folien/25_Datenstrukturen.pdf#page=69|69]], [[Material/Folien/25_Datenstrukturen.pdf#page=70|70]], [[Material/Folien/25_Datenstrukturen.pdf#page=71|71]])
- [[Binärbaum]] (S. [[Material/Folien/25_Datenstrukturen.pdf#page=13|13]], [[Material/Folien/25_Datenstrukturen.pdf#page=20|20]], [[Material/Folien/25_Datenstrukturen.pdf#page=69|69]])

## Kommt hier auch vor
[[while-Schleife]] · [[Array]] · [[Überschreiben]] · [[Enum]] · [[Wrapperklasse]] · [[Autoboxing]] · [[Stack Trace]] · [[try-with-resources]] · [[Datenströme]] · [[Synchronisation]]

## Übungen
- [ ] [[Ü25 Ziehung der Lottozahlen]] ★★☆☆☆ ✅ Musterlösung
- [ ] [[Ü25 Bücherei]] ★★★☆☆ ✅ Musterlösung
- [ ] [[Ü25 Binärbaum]] ★★★★☆ ✅ Musterlösung
- [ ] [[Ü25 Tankstellenpreise]] ★★★☆☆ ✅ Musterlösung

## Relevant für diese Programmentwürfe
[[PE CHORona]] · [[PE ChatterGPT Validator]] · [[PE CoronaWarn]] · [[PE DBVasion]] · [[PE FakeTalk]] · [[PE SnatChat (Übungs-PE Oktober 2026)]] · [[PE SpeedyQuiz]] · [[PE jBay]]

## Verwandte Themen
[[07 Arrays]] · [[13 Vererbung]] · [[26 Aufzählungstypen (Enums)]] · [[33 Java 8 – Lambdas, Streams, NIO.2]]

## Folien ansehen
![[Material/Folien/25_Datenstrukturen.pdf]]

## Folientext (durchsuchbar)
> [!quote]- Kompletter Folientext – aufklappen
> ```text
> ── Seite 1 ──
> Programmieren II
> Datenstrukturen / Das Collection-Framework
>    Heusch 14
>    Ratz 12.7
> 
> Institut für Automation und angewandte Informatik
> 
> KIT – Die Forschungsuniversität in der Helmholtz-Gemeinschaft www.kit.edu
> 
> ── Seite 2 ──
> Datenstrukturen (1)
> 
>    Datenstrukturen dienen dazu, anwendungsspezifische
>    Informationen im Speicher abzubilden
>    Standardisierte Datenstrukturen helfen beim Software-
>    Erstellungsprozess (Verständnis für „Muster“)
>    Standardisierte Datenstrukturen können durch gängige Operationen
>    (z.B. Sortieren, Maximum/Minimum finden, etc.) unterstützt werden
> 
>    Grundlegende Datenstrukturen gab es bereits im JDK 1.0.
>    Das Paket java.util enthält hierfür z.B. die Klassen Hashtable,
>    Vector, Stack.
>    Für viele Anwendungen reichten jedoch diese (wenigen)
>    vordefinierten Datenstrukturen nicht aus.
> 
> 2 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 3 ──
> Datenstrukturen (2)
> 
>    Aus diesem Grund wird seit JDK 1.2 das Java Collection-
>    Framework mitgeliefert.
>    Dieses Framework ist eine Sammlung von oft benötigten
>    Containern und Algorithmen in Java.
> 
>    In Java 1.5 wurde es um generische Datentypen (Generics)
>    erweitert.
> 
>    Seit Java 1.8 können Collections zusammen mit Streams und
>    anonyme Funktionen (Lambda Expressions) verwendet werden.
> 
> 3 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 4 ──
> Beispiel: List als „dynamisches“ Array
> 
>    Interface List definiert eine Ansammlung von Objekten
>    Reihenfolge (Position innerhalb der Liste),
>    entsprechend dem Index 0…(n-1) in einem Array.
>    Duplikate sind erlaubt.
>    Das Interface List definiert die Schnittstelle (Methoden),
>    die Implementierungen ArrayList und LinkedList
>    implementieren dieses Interface.
>    In spitzen Klammern (Typparameter) kann der Datentyp
>    angegeben werden, für den die Liste genutzt werden soll.
> 
>    List<String> myList = new ArrayList<String>();
>    myList.add( "Hello" );
>    myList.add( "World" );
>    String myString = myList.get( 0 ); // "Hello"
> 
> 4 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 5 ──
> Anwendung generischer Datentypen (1)
> 
>    Klassen und Methoden können um Typparametern
>    ergänzt werden, um Typsicherheit trotz generischer
>    Programmierung zu ermöglichen, z.B.
>    ArrayList<String> myList = new ArrayList<String>();
>    myList.add( "Hello" );
> 
>    In dieser ArrayList können nun ausschließlich Objekte
>    von Typ String gespeichert werden, und die Liste liefert
>    auch Objekte vom Typ String zurück.
>    ArrayList kann jedoch auch mit beliebigen anderen
>    Datentypen (Klassen) genutzt werden – sie ist generisch.
> 
> 5 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 6 ──
> Anwendung generischer Datentypen (2)
> 
>    Um den Datentyp einer generischen Klasse festzulegen,
>    wird dieser dem Klassennamen in Spitzen Klammern <>
>    hinzugefügt. Dies gilt auch für Interfaces.
>    Hier werden das Interface List und die Klasse ArrayList
>    entsprechend für die Verwendung mit Integer-Objekten
>    versehen:
>    List<Integer> my = new ArrayList<Integer>();
> 
>    Seit Java 1.7 kann der Datentyp auch weggelassen
>    werden, wenn er aus dem Kontext heraus bereits feststeht
>    („Diamond Operator“ <>):
>    List<Integer> my = new ArrayList<>();
> 
> 6 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 7 ──
> Anwendung generischer Datentypen (3)
> 
>    Als Typparameter generischer Interfaces und Klassen
>    können nur Interfaces, Klassen und komplexe
>    Aufzählungstypen (enum) verwendet werden.
>    Primitive Datentypen müssen daher in den
>    entsprechenden Wrapperklassen gekapselt werden.
> 
>    List<int> my = new ArrayList<>();   // Compiler-Fehler!
> 
>    List<Integer> my = new ArrayList<>(); // richtig!
>    my.add( 42 ); // autoboxing
> 
>    Autoboxing hilft hier ungemein… ☺
> 
> 7 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 8 ──
> Zum Vergleich
> 
>    Ohne Generics   Mit Generics
> 
>    import java.util.ArrayList;   import java.util.ArrayList;
>    import java.util.List;   import java.util.List;
>    …   …
>    List my = new ArrayList();   List<Integer> my = new ArrayList<>();
>    my.add( 42 ); // autoboxing   my.add( new Integer( 4711 ) );
>    my.add( "Hello" );   my.add( 42 ); // autoboxing
>    Object erstes = my.get(0);   Integer erstes = my.get(0);
>    Object zweites = my.get(1);   Integer zweites = my.get(1);
> 
>    ➔ Keine Garantie, was   ➔ Compiler kann Datentypen
>    in der Liste steckt (Object)   überprüfen
>    ➔ Alles kann in der Liste stecken,   ➔ Keine gemischten Einträge
>    auch „gemischte“ Typen   ➔ .get() liefert korrekten Typ
> 
> 8 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 9 ──
> Die Collection API
> 
>    Die Architektur besteht aus drei wichtigen Komponenten:
> 
>    Alle Methoden sind in Interfaces im Paket java.util definiert.
> 
>    Ein Interface definiert nur die Schnittstelle für den Zugriff. Die
>    Speicherung der Daten bestimmt die konkrete Implementierung.
>    z.B. List, Set, SortedSet, Map
> 
>    Unterschiedlichen Implementierungen unterscheiden sich meist
>    darin, wie die Daten verwaltet werden: Eine Liste könnte man z. B.
>    sowohl mit einem Array als auch durch direkte Verkettung der
>    Elemente realisieren.
>    z.B. ArrayList, LinkedList, HashSet, TreeSet, HashMap, TreeMap
> 
> 9 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 10 ──
> Collection Interfaces
> 
>    Collection Eine beliebige Gruppe von Objekten. Die Interfaces
>    Set, SortedSet und List sind von Collection abgeleitet.
>    Set beschreibt eine Gruppe von Objekten mit Mengencharakter,
>    d.h. Duplikate sind nicht erlaubt.
>    SortedSet ist Analog zu Set mit dem Unterschied, dass die
>    Elemente sortiert werden.
>    List beschreibt eine Gruppe von Objekten, die über Integer-
>    Werte indiziert werden. Duplikate sind erlaubt. Ein neues
>    Element kann an eine beliebige Stelle positioniert werden.
>    Map definiert eine Zuordnung von Schlüsseln zu Werten. Jedem
>    Schlüssel wird eindeutig ein Wert zugewiesen. Schlüssel
>    können keine Duplikate enthalten, Werte schon.
>    SortedMap ist eine Map, deren Schlüssel sortiert werden.
> 
> 10 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 11 ──
> Wichtige Methoden des Interfaces Collection
>    Beispielhaft seien hier einige wichtige Methoden des
>    Interfaces Collection aufgeführt:
>    boolean add(E e)
>    fügt das Element e in das Collection-Objekt hinzu (falls möglich
>    bzw. nötig). E: Typ* der Elemente in dieser Collection
>    boolean addAll(Collection<? extends E> c)
>    fügt alle Element der Collection c in das Collection-Objekt hinzu
>    (falls möglich bzw. nötig). E: Typ* der Elemente in der Collection
>    boolean remove(Object o)
>    Entfernt das Objekt o aus dem Collection-Objekt, falls es
>    vorhanden ist.
>    boolean contains(Object o)
>    Liefert true, falls das Collection-Objekt das Element o enthält,
>    sonst false. Hinweis: Es gibt auch containsAll(…)
>    int size()
>    Liefert die aktuelle Anzahl der Elemente
> 11 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 12 ──
> Implementierungen von Collections (1)
> 
>    Die Tabelle zeigt die seit Java SDK 1.4 verfügbaren
>    Implementierungen der Collection-Interfaces:
>    Interface
>    List   Set   SortedSet   Map   SortedMap   JDK 1.0
>    Klasse
>    LinkedList   
>    ArrayList   
>    Vector      
>    HashSet   
>    TreeSet      
>    HashMap   
>    WeakHashMap   
>    TreeMap      
>    Hashtable      
> 12 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 13 ──
> Implementierungen von Collections (2)
>    HashSet implementiert das Set-Interface und speichert seine Elemente in
>    einer Hash-Tabelle.
>    TreeSet implementiert das SortedSet-Interface und speichert seine Elemente
>    in einem Baum.
>    ArrayList implementiert das List-Interface und speichert seine Elemente in
>    einem Array.
>    LinkedList implementiert das List-Interface und speichert seine Elemente in
>    einer verketteten Liste. Werden die Elemente häufig durchlaufen, hat
>    LinkedList eine bessere Performance als ArrayList.
>    HashMap implementiert das Map-Interface und speichert seine Elemente in
>    einer Hash-Tabelle.
>    WeakHashMap implementiert das Map-Interface und speichert seine Elemente in
>    einer Hash-Tabelle. Wird der Schlüssel außerhalb der WeakHashMap nicht
>    mehr referenziert, so wird das entsprechende Schlüssel-Wert-Paar
>    automatisch vom Garbage-Collector entfernt.
>    TreeMap implementiert das SortedMap-Interface und speichert seine Elemente
>    in einem Baum.
> 13 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 14 ──
> Implementierungen von Collections (3)
> 
>    Auch die beiden Klassen Vector und Hashtable sind seit dem JDK
>    1.2 Implementierungen der Collection-Interfaces (List bzw. Map).
>    Beide Klassen waren seit der Version 1.0 im JDK enthalten und
>    wurden nachträglich an das Collection-Framework angepasst.
>    Aus diesem Grund sind sie nicht ganz mit den nun folgenden
>    Implementierungen gleichzustellen:
>    Zum einen besitzen diese Klassen zusätzlich zu den Methoden der
>    Collection-Interfaces weitere Methoden zum Datenzugriff, die bereits aus
>    historischen Gründen vorhanden waren,
>    zum anderen ist der Zugriff sowohl auf Vector als auch auf Hashtable
>    bereits synchronisiert. Synchronisierte Varianten der oben beschriebenen
>    neuen Implementierungen muss man explizit über Wrapper-
>    Implementierungen anfordern.
> 
>    ➔ Versions-Kauderwelsch!
> 
>    Bild: CC BY 2.0 / Alex E. Proimos - http://www.flickr.com/photos/proimos/4199675334/
> 
> 14 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 15 ──
> Wichtige Methoden des Interfaces List
>    Zusätzliche Methoden des Interfaces List (erweitern die von
>    Collection geerbten Methoden):
>    E get(int i)
>    Liefert das i-te Objekt aus der Liste
>    int indexOf(Object o)
>    Liefert den Index des ersten Vorkommen von Objekts o aus dem
>    List-Objekt, falls es vorhanden ist (sonst -1).
>    int lastIndexOf(Object o)
>    Liefert den Index des letzten Vorkommen von Objekts o aus dem
>    List-Objekt, falls es vorhanden ist (sonst -1).
>    E remove(int i)
>    Entfernt das i-te Objekt aus dem List-Objekt und gibt es als
>    Ergebnis der Methode zurück
>    Anmerkung: Vorsicht ist geboten bei Integer-Objekten als Übergabeparameter! Trotz
>    Autoboxing greift hier boolean remove(Object o) von Collection → es sind
>    Objekte!
> 15 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 16 ──
> Die Klasse java.util.ArrayList
> 
>    Die Klasse ArrayList ist eine Implementierung des
>    Interfaces List
>    Sie repräsentiert quasi ein Array variablen Inhalts, dessen
>    Länge bei Bedarf automatisch angepasst wird.
>    Über Indizes kann direkt auf die einzelnen Elemente
>    zugegriffen werden.
>    In einer ArrayList kann jedes von Object abgeleitete
>    Objekt gespeichert werden, ebenso null-Werte.
>    Hinweis:
>    Wenn eine sichere Nebenläufigkeit (Thread-Sicherheit)
>    erforderlich ist, muss dies über einen Wrapper angefordert
>    werden (folgt später).
> 
> 16 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 17 ──
> Die Klasse java.util.LinkedList
> 
>    Die Klasse LinkedList ist eine Implementierung der
>    Interfaces List und Deque
>    Speichert den Vorgänger und Nachfolger der Elemente
>    (Doppelt verkettete Liste)
>    Eignet sich besonders gut beim häufigen Einfügen und
>    Löschen von Elementen, da nur die Nachbarverweise
>    verändert werden müssen
>    Zugriff auf bestimmtes Element dadurch jedoch langsam
>    (für n-tes Element müssen n Verkettungen durchlaufen
>    werden)
>    In einer LinkedList kann jedes von Object abgeleitete
>    Objekt gespeichert werden und zusätzlich auch null-
>    Werte.
> 17 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 18 ──
> Beispiel: List und ArrayList
> 
>    Die Variable vom Typ des Interfaces List,
>    die Instanz vom Typ der Implementierung ArrayList!
>    import java.util.ArrayList;
>    import java.util.List;
> 
>    public class ListExample {
> 
>    public static void main(String[] args) {
>    List<String> words = new ArrayList<>();
>    words.add( "Some" ); // 0
>    words.add( "words" ); // 1
>    words.add( "in" );   // 2
>    words.add( "a" );   // 3
>    words.add( "list." ); // 4
>    System.out.println( words.get( 2 ) ); // "in"
>    }
> 
>    }
> 
> 18 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 19 ──
> Beispiel: Ausgabe einer List
>    import java.util.ArrayList;
>    import java.util.List;
> 
>    public class ListExample2 {
> 
>    public static void main(String[] args) {
>    List<String> words = new ArrayList<>();
>    words.add( "This" );
>    words.add( "is" );
>    words.add( "an" );
>    words.add( "example" );
> 
>    for(String s : words) {
>    System.out.println( s );
>    }
>    }   Ausgabe
>    This
>    }   is
>    an
>    example
> 
> 19 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 20 ──
> Methoden des Interfaces java.util.Set
> 
>    Die Methoden add(E e), remove(Object o),
>    contains(Object o), isEmpty(), size() werden (wie
>    bei List) vom Interface Collection geerbt.
>    Im praktischen Handling funktionieren List und Set also
>    sehr ähnlich. Aber
>    Set erlaubt keine Duplikate,
>    die Elemente in einem Set haben keine feste Position (außer in
>    einem TreeSet, da werden sie automatisch sortiert).
>    ➔ Man kann daher nicht mit get(i) auf das i-te Element eines
>    Set zugreifen!
>    Die Implementierungen HashSet bzw. TreeSet speichern
>    die Elemente in einer Hashtabelle bzw. (sortiert) in einer
>    Baumstruktur.
> 
> 20 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 21 ──
> Beispiel: Set mit HashSet
>    Ausgabe   REIHENFOLGE WEICHT AB!
>    import java.util.Set;
>    Uli
>    import java.util.HashSet;   Mia
>    Peter
>    public class SetExample {   Element count: 3
> 
>    public static void main(String[] args) {
>    Set<String> mySet = new HashSet<>(); // HashSet ➔ Reihenfolge?
>    mySet.add("Mia");
>    mySet.add("Uli");
>    mySet.add("Peter");
>    mySet.add("Mia");   // Duplikat wird nicht hinzugefügt!
>    for(String s : mySet) {
>    System.out.println(s);
>    }
>    System.out.println("Element count: " + mySet.size());
>    }
> 
>    }
> 
> 21 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 22 ──
> Beispiel: Set mit TreeSet
>    Ausgabe   SORTIERT!
>    import java.util.Set;
>    Mia
>    import java.util.TreeSet;   Peter
>    Uli
>    public class SetExampleSorted {   Element count: 3
> 
>    public static void main(String[] args) {
>    Set<String> mySet = new TreeSet<>(); // TreeSet ➔ sortiere!
>    mySet.add("Mia");
>    mySet.add("Uli");
>    mySet.add("Peter");
>    mySet.add("Mia");   // Duplikat wird nicht hinzugefügt!
>    for(String s : mySet) {
>    System.out.println(s);
>    }
>    System.out.println("Element count: " + mySet.size());
>    }
> 
>    }
> 
> 22 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 23 ──
> Beispiel: Bestimmte Anzahl von Zufallszahlen
>    Ausgabe
>    import java.util.Random;
>    1 2 3 8 9 10 11 16 17 18
>    import java.util.Set;
>    import java.util.TreeSet;
> 
>    public class SetRandomExample {
> 
>    public static void main(String[] args) {
>    Set<Integer> numbers = new TreeSet<>(); // TreeSet ➔ sortiert!
>    Random rnd = new Random();
>    // Erzeuge genau 10 verschiedene Zufallszahlen zwischen 1 und 20
>    do {
>    numbers.add( rnd.nextInt(20)+1 ); // Keine Duplikate!
>    } while ( numbers.size() < 10 );   // Stopp, wenn es 10 sind
>    // Ausgabe
>    for (Integer n : numbers) {
>    System.out.print( n + " " );
>    }
>    }
> 
>    }
> 
> 23 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 24 ──
> Methoden des Interfaces java.util.Map
> 
>    Beispielhaft seien hier einige wichtige Methoden des
>    Interfaces Map aufgeführt:
>    V put(K key, V value)
>    Fügt das Objekt value unter dem Schlüssel key zur Map hinzu.
>    Existierte für diesen Schlüssel bereits ein Wert in der Map, wird
>    dieser entfernt und als Ergebnis der Methode zurückgegeben.
>    K: Typ der Schlüssel der Map / V: Typ der Werte der Map
>    V get(Object key)
>    Liefert den Wert, der in der Map unter dem Schlüssel key hinterlegt
>    ist (oder null, falls kein Wert vorhanden).
>    int size()
>    Liefert die aktuelle Anzahl der Schlüssel/Wert-Paare, die im
>    Map-Objekt gespeichert sind.
> 
> 24 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 25 ──
> Die Klasse java.util.HashMap (1)
> 
>    Die Klasse HashMap ist eine Implementierung des
>    Interfaces Map
>    HashMap ist eine Klasse, die durch Verwendung des
>    Hashing das Speichern und Wiederauffinden von Objekten
>    ermöglicht. Mit Hashing wird ein Kompromiss zwischen
>    verwendetem Speicherplatz und benötigter Zeit zum
>    Wiederauffinden gespeicherter Elemente gemacht.
>    HashMap ist von der abstrakten Klasse AbstractMap
>    abgeleitet.
>    Einer HashMap wird ein bestimmtes Object zusammen mit
>    einem anderen Object, das als Schlüssel dient,
>    hinzugefügt. Mit diesem Schlüssel kann man wieder auf
>    das gespeicherte Objekt zugreifen.
> 25 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 26 ──
> Die Klasse java.util.HashMap (2)
> 
>    hashCode() liefert das Ergebnis der Hash-Funktion eines
>    jeden Objekts (definiert in java.lang.Object).
>    Die Hash-Funktion bildet die Basis um Schlüssel-Objekte
>    auf die Indexe der Hash-Tabelle (wie die eines Array) ab.
>    Muss innerhalb der Array-Grenzen liegen (z.B.: modulo)
>    ggf. Kollisionsauflösung, z.B. nächste freie Stelle suchen
>    Einfügen eines neuen Objekts mit
>    public V put(K key, V value)*
>    Ist ein Schlüssel bereits in der HashMap vorhanden
>    (errechneter Hash-Wert gleich), wird diesem Schlüssel der
>    neue Wert zugeordnet. Der alte Wert wird überschrieben
>    und von put() als Ergebnis zurückgegeben, ansonsten
>    null.
>    * K: Typ der Schlüssel der Map / V: Typ der Werte der Map
> 26 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 27 ──
> Mögliches Prinzip für Kollisions-Vermeidung
>    A
>    hashCode()
>    28   4   0   1   2   3   4   5   6   7
> 
>    Hash-Index = Hashcode % Tabellengröße
>    4   = 28 % 8
>    B
>    hashCode()   A
>    29   5   0   1   2   3   4   5   6   7
> 
>    Hash-Index = Hashcode % Tabellengröße
>    5   = 29 % 8
>    C
>    hashCode()   A   B
>    36   4   0   1   2   3   4   5   6   7
> 
>    A   B   C
>    0   1   2   3   4   5   6   7
>    Hash-Index = Hashcode % Tabellengröße
>    4   = 36 % 8
>    Tatsächlicher Index durch Kollisionsauflösung: 6
> 27 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 28 ──
> Beispiel Map
>    Ausgabe
>    import java.util.HashMap;
>    Uli born on 10.08.1993
>    import java.util.Map;   Mia born on 31.12.1991
>    Peter born on 19.07.1994
>    public class MapExample {
> 
>    public static void main(String[] args) {
>    Map<String, String> bdays = new HashMap<>();
>    bdays.put( "Mia", "20.04.1992" );
>    bdays.put( "Uli", "10.08.1993" );
>    bdays.put( "Peter", "19.07.1994" );
>    bdays.put( "Mia", "31.12.1991" );   // Duplikat überschreibt!
>    for(String name : bdays.keySet()) { // Schlüssel als Set
>    System.out.println(name + " born on " +
>    bdays.get(name)); // Schlüssel 'name'
>    }
>    }
> 
>    }
> 
> 28 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 29 ──
> Die Klasse java.util.TreeMap
> 
>    Die Klasse TreeMap ist eine Implementierung des
>    Interfaces Map und SortedMap
>    Die Werte werden bei einer TreeMap sortiert nach ihren
>    Schlüsseln abgelegt
>    Sämtliche Klassen, deren Instanzen als Schlüssel
>    verwendet werden, müssen daher die Schnittstelle
>    Comparable implementieren – außer es wird eine
>    passende Comparator-Instanz beim Erzeugen der
>    TreeMap übergeben
>    ➔ Vergleichbarkeit der Schlüssel muss gewährleistet sein!
> 
> 29 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 30 ──
> Weitere Methoden von des Interfaces Map
> 
>    Object remove(Object key)
>    Entfernt Schlüssel und zugehörigen Wert
>    void clear()
>    Alle Schlüssel und Werte entfernen
>    boolean containsKey(Object key)
>    Prüft: Ist dieser Schlüssel enthalten?
>    boolean containsValue(Object value)
>    Prüft: Ist dieser Wert enthalten?
>    boolean isEmpty()
>    Testet, ob es (gar) keine Schlüssel gibt
>    Set keySet()
>    Alle Schlüssel als Set
>    Collection values()
>    Alle Werte als Collection
> 
> 30 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 31 ──
> Alternatives Erzeugen von Listen (1)
> 
>    Mit List.of() lassen sich Listen aus einzelnen Objekten
>    oder Arrays erzeugen.
>    Allerdings sind die auf diesem Weg erzeugten Listen
>    „unmodifiable“ bzw. “immutable“, d.h. es lassen sich keine
>    Elemente mehr entfernen oder hinzufügen.
>    // create an unmodifiable (!) List of single Strings
>    List<String> names = List.of( "Rike", "Peter", "Max", "Katrin" );
>    System.out.println( names );
> 
>    // create an unmodifiable (!) List of Strings from an Array
>    String[] carBrands = { "Audi", "Opel", "BMW", "VW" };
>    List<String> brandsList = List.of( carBrands );
>    System.out.println( brandsList );   Ab Java 9
> 
>    Ausgabe
>    [Rike, Peter, Max, Katrin]
>    [Audi, Opel, BMW, VW]
> 
> 31 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 32 ──
> Alternatives Erzeugen von Listen (2)
> 
>    Vorsicht: Auch die „ImmutableList“ implementiert das
>    komplette List-Interface, d.h. der Compiler warnt z.B.
>    nicht vor dem Hinzufügen oder Entfernen von Elementen!
>    Exceptions fliegen erst zur Laufzeit!
> 
>    // create an unmodifiable (!) List of Strings from an Array
>    String[] carBrands = { "Audi", "Opel", "BMW", "VW" };
>    List<String> brandsList = List.of( carBrands );
>    System.out.println( brandsList );
>    brandsList.add( "Tesla" ); // UnsupportedOperationException
>    Ab Java 9
> 
>    Ausgabe
>    [Audi, Opel, BMW, VW]
>    Exception in thread "main" java.lang.UnsupportedOperationException
>    at java.base/java.util.ImmutableCollections.uoe(ImmutableCollections.java:142)
>    at java.base/java.util.ImmutableCollections$AbstractImmutableCollection.add(ImmutableCollections.java:147)
>    at de.dhbwka.java.slides.sem2.coll.ListOfExample.main(ListOfExample.java:17)
> 
> 32 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 33 ──
> Alternatives Erzeugen von Mengen (Set)
> 
>    Mit Set.of() funktioniert analog zu List.of().
>    Auch hier sind die erzeugten Sets „unmodifiable“.
>    Das wirkt sich auf das Hinzufügen von Duplikaten aus.
>    String[] carBrands = { "Audi", "Opel", "BMW", "VW" };
>    Ab Java 9
>    // create an unmodifiable (!) List of Strings from an Array
>    Set<String> brandsSet = Set.of( carBrands );
>    System.out.println( brandsSet );
> 
>    // no duplicates allowed! Set is unmodifiable here!
>    carBrands = new String[] { "Audi", "Opel", "BMW", "VW", "Audi" };
>    brandsSet = Set.of( carBrands ); // IllegalArgumentException!
> 
>    Ausgabe
>    [Audi, VW, BMW, Opel]
>    Exception in thread "main" java.lang.IllegalArgumentException: duplicate element: Audi
>    at java.base/java.util.ImmutableCollections$SetN.<init>(ImmutableCollections.java:918)
>    at java.base/java.util.Set.of(Set.java:706)
>    at de.dhbwka.java.slides.sem2.coll.ListOfExample.main(ListOfExample.java:25)
> 
> 33 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 34 ──
> Alternatives Erzeugen von Maps (1)
> 
>    Mit Map.of() lassen sich Maps aus einzelnen Schlüssel-
>    Wert-Paaren erzeugen.
>    Die auf diesem Weg erzeugten Maps auch „unmodifiable“.
>    Die Anzahl der Paare ist auf 10 beschränkt.
> 
>    // create unmodifiable Map from key-value-pairs   Ab Java 9
>    // maximum of 10 pairs
>    Map<String, Integer> ages = Map.of("Peter", 22, "Uli", 21, "Katrin", 23, "Max", 20);
>    System.out.println( ages );
> 
>    Ausgabe
>    {Peter=22, Max=20, Uli=21, Katrin=23}
> 
> 34 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 35 ──
> Alternatives Erzeugen von Maps (2)
> 
>    Die Beschränkung der Anzahl lässt sich durch die Methode
>    Map.ofEntries() umgehen.
>    Beim Hinzufügen zur Map werden die Schlüssel und Werte
>    der Entries ausgelesen, die Entries bleiben nicht erhalten.
> 
>    // create unmodifiable Map from unlimited entries
>    Map<String, Integer> ages = Map.ofEntries(
>    Map.entry("Peter", 22),
>    Map.entry("Ulrike", 21),
>    Map.entry("Katrin", 23),
>    Map.entry("Max", 20) );
>    System.out.println( ages );   Ab Java 9
> 
>    Ausgabe
>    {Peter=22, Max=20, Ulrike=21, Katrin=23}
> 
> 35 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 36 ──
> Alternatives Erzeugen von Maps (3)
> 
>    Auch hier werden beim Hinzufügen Duplikate nicht
>    aussortiert. Programmierer müssen selbst sicherstellen,
>    dass keine doppelten Schlüssel vorhanden sind.
> 
>    // create unmodifiable Map from unlimited entries
>    Map<String, Integer> ages = Map.ofEntries(
>    Map.entry("Peter", 22),
>    Map.entry("Ulrike", 21),
>    Map.entry("Katrin", 23),
>    Map.entry("Max", 20),
>    Map.entry("Peter", 24) ); // IllegalArgumentException
>    System.out.println( ages );   Ab Java 9
> 
>    Ausgabe
>    Exception in thread "main" java.lang.IllegalArgumentException: duplicate key: Peter
>    at java.base/java.util.ImmutableCollections$MapN.<init>(ImmutableCollections.java:1189)
>    at java.base/java.util.Map.ofEntries(Map.java:1668)
>    at de.dhbwka.java.slides.sem2.coll.MapOfExample.main(MapOfExample.java:24)
> 
> 36 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 37 ──
> Überschreiben von hashCode()
> 
>    Die Methode hashCode() soll zu jedem Objekt eine
>    möglichst eindeutige Integerzahl (int) liefern, die das
>    Objekt identifiziert.
>    Die Methode hashCode() ist eine Methode von Object.
>    Sie wird von verschiedenen Klassen überschrieben bzw.
>    soll überschrieben werden.
> 
>    Regel: Wenn man die equals-Methode überschreibt, wird
>    man aufgefordert, auch die hashCode-Methode zu
>    überschreiben ("Generate missing hashCode()").
>    Dabei soll gelten:
>    Zwei Objekte, die laut equals-Methode gleich sind, sollen
>    den gleichen Hashcode zurückliefern.
> 37 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 38 ──
> Beispiel: Überschreiben von hashCode()
>    import java.util.Objects;
>    class Person {
>    private String surname;
>    private String name;
>    private int age;
> 
>    public Person( String surname, String name, int age ) {
>    this.surname = surname;
>    this.name = name;
>    this.age = age;
>    }
> 
>    @Override
>    public int hashCode() {
>    return Objects.hash( this.age, this.name, this.surname );
>    }
> 
>    @Override
>    Ab Java 1.7
>    public boolean equals( Object obj ) {
>    // ...
>    }
> 
>    // Getter und Setter-Methoden
>    Tipp: von der IDE generieren lassen!
>    }
> 
> 38 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 39 ──
> Beispiel: Überschreiben von equals()
>    import java.util.Objects;
>    class Person {
>    // ...
> 
>    @Override
>    public boolean equals( Object obj ) {
>    if ( this == obj ) {
>    return true;
>    }
>    if ( obj == null ) {
>    Ab Java 1.7
>    return false;
>    }
>    if ( this.getClass() != obj.getClass() ) {
>    return false;
>    }
>    Person other = (Person) obj;
>    return this.age == other.age && Objects.equals( this.name, other.name )
>    && Objects.equals( this.surname, other.surname );
>    }
> 
>    // ...
>    }
>    Tipp: von der IDE generieren lassen!
> 
> 39 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 40 ──
> Die Klasse java.util.Stack
> 
>    Die Klasse Stack repräsentiert einen Stapelspeicher:
>    Neue Elemente werden immer „oben drauf“ gepackt
>    Es wird immer das oberste Element zuerst entfernt
>    Beim Anlegen eines Stacks wird seine Größe mit „0“
>    initialisiert:
> 
>    Stack<Integer> myStack = new Stack<>();
> 
> 40 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 41 ──
> Methoden von Stack
> 
>    boolean empty()
>    Testet, ob der Stack leer ist
>    Object peek()
>    Liefert das oberste Objekt ohne es zu löschen
>    Object pop()
>    Entfernt das oberste Objekt vom Stack und liefert es
>    zurück
>    Object push(Object item)
>    Legt ein Objekt oben auf den Stack
>    int search(Object o)
>    Liefert die Position eines Objekts (von oben) auf dem
>    Stack
> 
> 41 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 42 ──
> Beispiel: Stack mit Zahlen
> 
>    Ausgabe   First-in Last-out
>    import java.util.Stack;
>    Count: 3
>    public class StackExample {   Peek: 999
>    Pop: 999
>    public static void main(String[] args) {   Pop: 4711
>    Pop: 42
>    Stack<Integer> numbers = new Stack<>();
>    numbers.push( 42 );
>    numbers.push( 4711 );
>    numbers.push( 999 );
> 
>    System.out.println("Count: " + numbers.size()); // Count
>    System.out.println("Peek: " + numbers.peek()); // Peek Element
> 
>    do {
>    System.out.println("Pop: " + numbers.pop());
>    } while ( !numbers.empty() );
> 
>    }
> 
>    }
> 
> 42 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 43 ──
> Das Interface java.util.Enumeration (1)
> 
>    Enumeration ist nicht mit obigen Datenstrukturen, die
>    durch Klassen repräsentiert werden, vergleichbar, wird
>    aber trotzdem an dieser Stelle aufgeführt, da sie ebenso
>    Zugriff auf Daten bietet.
>    Enumeration ist ein Interface, das dazu verwendet wird,
>    eine Aufzählung von Elementen anzugeben. Dieses
>    Interface wird z. B. von der Klasse StringTokenizer
>    implementiert.
> 
> 43 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 44 ──
> Das Interface java.util.Enumeration (2)
> 
>    Eine Klasse, die Enumeration<T> implementiert, muss die
>    folgenden Methoden überschreiben:
>    boolean hasMoreElements()
>    Liefert true, wenn die Aufzählung weitere Elemente enthält.
>    <T> nextElement()
>    Liefert das nächste Objekt in der Aufzählung. Vorbedingung für
>    diese Methode ist, dass der letzte Aufruf von hasMoreElements()
>    das Ergebnis true hatte.
> 
>    Beispiel (Nutzung in Schleife):
>    while (d.hasMoreElements()) {
>    System.out.println(d.nextElement());
>    }
> 
> 44 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 45 ──
> Beispiel: Vorsicht bei remove() (1)
>    Ausgabe
>    import java.util.ArrayList;
>    This
>    import java.util.List;   an
>    example
>    public class ListRemove1 {
> 
>    public static void main(String[] args) {
>    List<String> list = new ArrayList<>();
>    list.add("This");
>    list.add("is");
>    list.add("an");
>    list.add("example");
>    list.remove("is"); // remove() vor der Schleife
>    for (String o : list) {
>    System.out.println(o);
>    }
>    }
> 
>    }
> 
> 45 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 46 ──
> Beispiel: Vorsicht bei remove() (2)
>    import java.util.ArrayList;
>    import java.util.List;
> 
>    public class ListRemove2 {
> 
>    public static void main(String[] args) {
>    List<String> list = new ArrayList<>();
>    list.add("This");
>    list.add("is");
>    list.add("an");
>    list.add("example");
>    for (String o : list) {
>    if ("is".equals(o)){
>    list.remove(o); // Entfernen innerhalb der Schleife
>    }
>    }
>    }   Ausgabe
>    Exception in thread "main" java.util.ConcurrentModificationException
>    }   at java.util.ArrayList$Itr.checkForComodification(Unknown Source)
>    at java.util.ArrayList$Itr.next(Unknown Source)
>    at ListRemove2.main(ListRemove2.java:14)
> 
> 46 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 47 ──
> Beispiel: Vorsicht bei remove() (3)
>    Ausgabe
>    import java.util.ArrayList;
>    Element count: 3
>    import java.util.List;
> 
>    public class ListRemove3 {
> 
>    public static void main(String[] args) {
>    List<String> list = new ArrayList<>();
>    list.add("This");
>    list.add("is");
>    list.add("an");
>    list.add("example");
>    for (String o : list) {
>    if ("is".equals(o)){
>    list.remove(o); // Entfernen innerhalb der Schleife
>    break; // nach remove!
>    }
>    }
>    System.out.println("Element count: " + list.size());
>    }
>    }
> 
> 47 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 48 ──
> Beispiel: Vorsicht bei remove() (4)
>    Ausgabe
>    import java.util.ArrayList;
>    Element count: 3
>    import java.util.List;
> 
>    public class ListRemove4 {
> 
>    public static void main(String[] args) {
>    List<String> list = new ArrayList<>();
>    list.add("This");
>    list.add("is");
>    list.add("an");
>    list.add("example");
>    for(int i=0; i<list.size(); i++) {
>    if (list.get(i).equals("is")) {
>    list.remove(i);   // i--;
>    }
>    }
>    System.out.println("Element count: " + list.size());
>    }
> 
>    }
> 
> 48 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 49 ──
> Collection mit Iterator „durchlaufen“
> 
>    Für Implementierungen des Interface Collection gibt es
>    eine Möglichkeit, alle Elemente nacheinander zu
>    durchlaufen.
>    Diese Funktion wird vom Interface Iterator bereitgestellt.
>    Iterator hat prinzipiell dieselbe Aufgabe wie die Klasse
>    Enumeration, mit dem Unterschied, dass Elemente beim
>    Durchlaufen auch gelöscht werden können.
>    Hierfür stellt Iterator die Methode remove() zur
>    Verfügung. Über die Methode iterator() kann ein
>    Iterator für eine Kollektion ermittelt werden. iterator()
>    ist im Interface Collection definiert.
> 
> 49 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 50 ──
> Iterator benutzen
>    Ausgabe
>    import java.util.Iterator;
>    Karl
>    import java.util.List;   Otto
>    import java.util.ArrayList;   Hans
> 
>    public class ListExampleWithIterator {
> 
>    public static void main(String[] args) {
>    List<String> list = new ArrayList<>();
>    list.add("Karl");
>    list.add("Otto");
>    list.add("Hans");
>    Iterator<String> iter = list.iterator();
>    for (; iter.hasNext();) {
>    System.out.println(iter.next());
>    }
>    }
> 
>    }
> 
> 50 W. Süß,
>    Geiger,
>    T. W.
>    Schlachter,
>    Süß, T. Schlachter
>    J. Sidler, M. A. Koubaa, C. Schmitt   Institut für Automation und angewandte Informatik
> 
> ── Seite 51 ──
> Iterator benutzen ohne Interface Collection
> 
>    Bei Kollektionen, die nicht direkt das Interface Collection
>    implementieren, wie z. B. die Klasse TreeMap, kann man
>    über die Methode values() ein Collection-Exemplar
>    ermitteln, das Zugriff auf die Original-Elemente bietet.
>    Folgendes Beispiel zeigt, wie ein Iterator von der Klasse
>    TreeMap ermittelt und bearbeitet wird:
>    TreeMap<String, String> tm = new TreeMap<>();
>    // Elemente der Kollektion hinzufügen
>    // ...
>    Collection<String> col = tm.values();
>    Iterator<String> iter = col.iterator();
>    // Elemente durchlaufen
>    while (iter.hasNext()) {
>    String o = iter.next();
>    // hier Bearbeiten der Elemente // ...
>    }
> 
> 51 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 52 ──
> Comparable und Comparator
> 
>    Klassen, die SortedSet und SortedMap implementieren,
>    bieten eine Sortierung für ihre Elemente an.
>    Da prinzipiell beliebige Objekte in einer Kollektion
>    gespeichert werden können, muss ein Sortierungskriterium
>    bereitgestellt werden.
>    Zu diesem Zweck werden die Interfaces Comparable und
>    Comparator benutzt.
>    Objekte, die in einer sortierten Kollektion gespeichert
>    werden, müssen entweder das Interface Comparable
>    implementieren oder die Kollektion muss einmalig mit einer
>    Implementierung von Comparator initialisiert werden.
> 
> 52 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 53 ──
> Comparable
> 
>    Das Interface Comparable<T> definiert eine Methode:
>    public int compareTo(T o)
>    (T durch konkrete Klasse ersetzen!)
> 
>    Diese Methode vergleicht das übergebene Exemplar mit
>    dem Exemplar, in dem der Aufruf stattfindet. Der
>    Rückgabewert der Methode sollte folgende Werte
>    annehmen:
>    eine negative Zahl, falls das aufgerufene Objekte kleiner ist
>    0, falls die Objekte gleich sind
>    eine positive Zahl, falls das aufgerufene Objekte größer ist
> 
> 53 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 54 ──
> Comparator
> 
>    Da die Implementierung eines Interface nur möglich ist, wenn man
>    Zugriff auf den Quellcode hat, wird im JDK zusätzlich das Interface
>    Comparator definiert.
>    Comparator<T> definiert die Methode (T durch konkrete Klasse ersetzen!)
>    public int compare(T o1, T o2)
>    Diese Methode sollte prinzipiell dasselbe Verhalten wie compareTo()
>    bei Comparable zeigen:
>    Negativer Rückgabewert, wenn o1 < o2
>    0 bei Gleichheit
>    positiver Rückgabewert, wenn o1 > o2.
>    Ein Comparator kann z. B. implementiert werden, wenn man keinen
>    Zugriff auf den Quellcode von Klassen hat, sie aber dennoch in
>    sortierten Kollektionen speichern möchte. Hierzu muss man eine
>    Klasse definieren, die das Interface Comparator implementiert und in
>    compare() die Vergleichsregeln implementieren.
> 54 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 55 ──
> Comparator in Collection nutzen
> 
>    Die Initialisierung einer konkreten Kollektion mit einem Comparator
>    erfolgt bei den vordefinierten Klassen mit dem Konstruktor:
>    SortedMap<String, String> tm = new TreeMap<>(
>    new StringLengthComparator() );
>    Hier wird eine TreeMap (eine Implementierung von SortedMap) erzeugt
>    und mit einem Comparator initialisiert.
> 
>    Beispiel:
>    import java.util.Comparator;
> 
>    public class StringLengthComparator implements Comparator<String> {
>    @Override
>    public int compare(String s1, String s2) {
>    return s1.length() - s2.length();
>    }
>    }
> 
> 55 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 56 ──
> Anonyme Implementierungen (1)
> 
>    Über Factory-Methoden der Klasse java.util.Collections können
>    anonyme Implementierungen von Kollektionen erzeugt werden.
>    Das sind Implementierungen eines Collection-Interfaces, deren
>    Klassendefinitionen nicht als public deklariert sind.
>    Über diese Methoden ist es möglich, von einem Objekt einer
>    beliebigen Klasse, die eines der Collection-Interfaces implementiert,
>    eine Version zu erhalten, die unveränderbar bzw. synchronisiert ist.
>    Hierfür stellt die Klasse Collections die Methoden synchronizedXXX()
>    und unmodifiableXXX() zur Verfügung, wobei XXX für eines der
>    Collection-Interfaces steht.
>    Als Parameter bekommen die Methoden jeweils ein Exemplar einer
>    vorhandenen Implementierung übergeben. Als Ergebnis wird die
>    synchronisierte bzw. unveränderbare Implementierung des
>    übergebenen Exemplars zurückgeliefert.
> 
> 56 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 57 ──
> Anonyme Implementierungen (2)
> 
>    Um z. B. eine synchronisierte Implementierung einer TreeMap zu
>    erhalten, müssen folgende Zeilen Code ausgeführt werden:
>    SortedMap<String, String> sm;
>    sm = java.util.Collections.synchronizedSortedMap(new TreeMap<>());
>    // Die Aufrufe an sm sind nun synchronisiert
> 
>    Die Methoden der Klasse Collections sind alle statisch.
>    Die erweiterte Funktionalität wird bei dieser Vorgehensweise durch so
>    genannte Wrapper-Implementierungen zur Verfügung gestellt.
>    Beim Aufruf von synchronizedXXX() bzw. unmodifiableXXX() wird
>    zunächst ein Exemplar der passenden Wrapper-Implementierung erzeugt,
>    das in einem Datenelement einen Verweis auf das übergebene Original-
>    Exemplar speichert (oben ein Exemplar der Klasse TreeMap). Beim Aufruf
>    der Methoden stellt nun der Wrapper zunächst die neue Funktionalität zur
>    Verfügung (z. B. Synchronisation) und leitet danach den Aufruf an die
>    Original-Implementierung weiter.
> 
> 57 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 58 ──
> Die Klasse Collections: Algorithmen (1)
> 
>    In der Klasse java.util.Collections (nicht zu verwechseln mit dem
>    Interface Collection) sind mehrere Algorithmen implementiert, die auf
>    Kollektionen angewendet werden können.
>    Einige dieser Algorithmen sind auf alle Kollektionen anwendbar, andere
>    jedoch nur auf dem Interface List.
>    Auf alle Collections anwendbare Methoden:
>    static Object max(Collection col)
>    liefert das größte Element der Collection col zurück.
>    Diese Methode kann jedoch nur auf Kollektionen angewendet werden, deren
>    Elemente das Interface Comparable implementieren.
>    static Object max(Collection col, Comparator comp)
>    Diese zweite Variante verfügt über einen zweiten Parameter vom Typ
>    Comparator.
>    Bei dieser Methode kann der Vergleichsoperator explizit angegeben werden.
>    Die Elemente müssen in diesem Fall nicht Comparable implementieren.
> 
> 58 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 59 ──
> Die Klasse Collections: Algorithmen (2)
>    static Object min(Collection col)
>    arbeitet wie max(), liefert jedoch das kleinste Element zurück.
>    Auch von min() gibt es zwei Varianten.
> 
>    Nur auf Implementierungen von List anwendbare Methoden:
>    static void sort(List l)
>    sortiert die Elemente in der Liste l aufsteigend.
>    Diese Variante setzt voraus, dass die Klassen aller enthaltenen Objekte das
>    Interface Comparable implementieren.
>    static void sort(List l, Comparator comp)
>    Dieser zweiten Variante von sort wird eine Comparator-Instanz als zweites
>    Argument übergeben.
>    Sie hat nicht die o.g. Voraussetzung.
>    static void reverse(List l)
>    ordnet die Elemente der Liste l so um, dass sie in umgekehrter Reihenfolge
>    stehen.
> 
> 59 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 60 ──
> Die Klasse Collections: Algorithmen (3)
>    static void shuffle(List l)
>    permutiert die Elemente in der Liste l zufällig.
>    static int binarySearch(List list, Object key)
>    sucht in der aufsteigend sortierten Liste list das Element key über die
>    binäre Suche.
>    Wird key in der Liste gefunden, liefert binarySearch() die Index-Position
>    des Elements zurück.
>    Wird key nicht gefunden, liefert die Methode den negativen Wert der
>    potenziellen Einfügeposition minus 1 (also immer negative Werte, wenn
>    das Objekt nicht gefunden wird).
> 
>    Alle Algorithmen in der Klasse Collections sind mit statischen
>    Methoden realisiert.
> 
> 60 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 61 ──
> Beispiel: Sortieren einer Liste
>    Ausgabe
>    import java.util.List;
>    Hans
>    import java.util.ArrayList;   Karl
>    import java.util.Collections;   Otto
> 
>    public class ListExampleSort {
> 
>    public static void main(String[] args) {
>    List<String> list = new ArrayList<>();
>    list.add("Karl");
>    list.add("Otto");
>    list.add("Hans");
> 
>    Collections.sort(list);
> 
>    for (String name : list) {
>    System.out.println(name);
>    }
>    }
> 
>    }
> 
> 61 W. Süß,
>    Geiger,
>    T. W.
>    Schlachter,
>    Süß, T. Schlachter
>    J. Sidler, M. A. Koubaa, C. Schmitt   Institut für Automation und angewandte Informatik
> 
> ── Seite 62 ──
> myClass<T>
>    EIGENE GENERISCHE
>    KLASSEN ERSTELLEN
> 
> 62 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 63 ──
> Generics
> 
>    Generics bzw. Generizität und generische Elemente sind ein
>    Sprachmittel von Programmiersprachen. Im Falle von Java heißt dies,
>    dass Klassen und Methoden (Methoden auch außerhalb von
>    parametrisierten Klassen), aber auch Schnittstellen mit
>    Typparametern parametrisiert werden können.
>    Es geht also u. a. um Konstrukte wie z.B. eine „List of String", also
>    eine Liste, die nur String-Objekte aufnehmen kann.
>    Aus anderen Programmiersprachen sind vergleichbare Konzepte
>    bekannt, teilweise unter anderen Namen. In C++ gibt es die Template-
>    Klassen, also Schablonenklassen. Auch wenn diese syntaktisch einige
>    Ähnlichkeit zu den Generics in Java haben, arbeiten diese völlig
>    anders.
>    Einer der Hauptgründe für die Einführung von Generics mit der Java-
>    Version 1.5 war der Wunsch, die existierenden Containerklassen wie
>    z. B. List, Map, Set um Typsicherheit zu erweitern.
> 
> 63 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 64 ──
> Unsere erste generische Klasse (1)
>    public class MyLinkedList<T> {
>    private T value;
>    private MyLinkedList<T> next;
> 
>    public MyLinkedList() {
>    }
> 
>    public boolean isEmpty() {
>    return this.value == null;
>    }
> 
>    public void add(T value) {
>    if (this.isEmpty()) {   // letztes Element?
>    this.value = value; // neues, leeres Element anhängen
>    this.next = new MyLinkedList<T>();
>    } else {
>    this.next.add(value);
>    }
>    }
>    // ... weiter auf der nächsten Folie
> 
> 64 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 65 ──
> Unsere erste generische Klasse (2)
>    public T get(int index) {
>    if (index < 0 || this.isEmpty()) {
>    throw new IndexOutOfBoundsException();
>    }
>    return index == 0 ? this.value : this.next.get(index-1);
>    }
> 
>    public int size() {
>    return this.isEmpty() ? 0 : (this.next.size()+1);
>    }
>    }
> 
>    public class MyLinkedListTest {
>    public static void main(String[] args) {
>    MyLinkedList<Integer> intList = new MyLinkedList<>();
>    intList.add(new Integer(17));
>    Integer i = intList.get(0);
>    System.out.println("i = " + i);
>    }
>    }
> 
> 65 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 66 ──
> Invarianz
> 
>    Folgende Zuweisung ist nicht erlaubt:
>    MyLinkedList<Integer> intList = new MyLinkedList<Integer>();
>    MyLinkedList<Number> numList = intList; // error
> 
>    In Bezug auf den Typparameter verhält sich die
>    Zuweisungskompatibilität bei den Generics in Java also invariant.
>    Hierfür gibt es jedoch auch einen guten Grund. Einmal angenommen,
>    die obige Zuweisung wäre doch erlaubt. Dann wäre folgender Code
>    ebenfalls erlaubt:
>    MyLinkedList<Integer> intList = new MyLinkedList<Integer>();
>    MyLinkedList<Number> numList = intList; // angenommen (!) erlaubt
>    numList.add(new Double(3.14));   // erlaubt
> 
>    Der Grund für die Invarianz liegt also hier in der Veränderlichkeit der
>    Containerobjekte.
> 
> 66 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 67 ──
> Wildcards (1)
> 
>    Zunächst einmal kann ein Zuweisungsproblem durch Benutzung der so
>    genannten Wildcards umgangen werden.
>    Hierbei gibt man explizit an, dass man nicht genau weiß, welcher Typ
>    als Typparameter verwendet wurde:
> 
>    List<Integer> intList = new ArrayList<Integer>();
>    List<?> list = intList;
>    list.add(new Double(3.14)); // nicht erlaubt
>    list.add(new Integer(1));   // nicht erlaubt
>    list.add(new Object());   // nicht erlaubt
>    list.add(null);   // erlaubt
> 
>    Die logische Folge ist, dass nun keine Objekte mehr über die neue
>    Referenz eingefügt werden können. Da für den Compiler nicht
>    ersichtlich ist, mit welchem Typ list parametrisiert wurde, kann er für
>    die add()-Methode nicht den Typ des nötigen Parameters bestimmen.
>    Das einzige, was er zulassen kann, ist der Wert null.
> 
> 67 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 68 ──
> Wildcards (2)
> 
>    Ähnlich verhält es sich beim Auslesen von Objekten per
>    get()-Methode:
>    List<Integer> intList = new ArrayList<Integer>();
>    intList.add(new Integer(42));
>    List<?> list = intList;
>    Integer i = list.get(0);   // nicht erlaubt
>    Object o = list.get(0);   // erlaubt
> 
>    Der Compiler kann nichts über die konkreten Objekte, die
>    von get() geliefert werden, garantieren, außer dass sie
>    zuweisungskompatibel zu Object sind (dies gilt für jedes
>    konkrete Objekt).
> 
> 68 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 69 ──
> Kovarianz und Kontravarianz (1)
> 
>    Die durch die Verwendung von Wildcards gewonnene Flexibilität ist
>    natürlich nicht sehr befriedigend. Daher kann man die Wildcards im
>    Klassenbaum nach unten (Kovarianz) oder nach oben (Kontravarianz)
>    einschränken. Die Schlüsselwörter hierfür sind extends bzw. super:
>    List<Integer> intList = new ArrayList<Integer>();
>    intList.add(new Integer(42));
>    List<? extends Number> list = intList;
> 
>    Integer i = list.get(0); // nicht erlaubt
>    Number n = list.get(0); // erlaubt
>    list.add(n);   // nicht erlaubt
>    list.add(i);   // nicht erlaubt
>    list.add(null);   // erlaubt
> 
>    In Zeile 3 wird die Variable list definiert und für den Typparameter
>    festgelegt, dass dieser Number oder aber eine Unterklasse von
>    Number sein muss. Diese Bedingung erfüllt das Objekt, das von
>    intList referenziert wird, so dass die Zuweisung hier erlaubt ist.
> 69 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 70 ──
> Kovarianz und Kontravarianz (2)
>    Das Schlüsselwort super hat umgekehrte Auswirkungen:
>    List<Number> numList = new ArrayList<Number>();
>    numList.add(new Integer(42));
>    List<? super Integer> list = numList;
> 
>    Integer i = list.get(0);   // nicht erlaubt
>    Number num = list.get(0);   // nicht erlaubt
>    Object obj = list.get(0);   // erlaubt
> 
>    list.add(obj);   // nicht erlaubt
>    list.add(num);   // nicht erlaubt
>    list.add(i);   // erlaubt
> 
>    In Zeile 1 wird dieses Mal eine Liste erzeugt, die mit Number
>    parametrisiert ist und somit neben Integer-Objekten auch Double-,
>    Long- und andere Objekte akzeptiert. Beispielhaft wird in Zeile 2 ein
>    Integer-Objekt eingefügt.
> 
> 70 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 71 ──
> Kovarianz und Kontravarianz (3)
> 
>    In Zeile 3 wird nun eine Variable definiert, die auf eine Liste
>    referenziert, die mit dem Typ Integer oder einer Oberklasse davon
>    (also bis einschließlich Object) parametrisiert wurde. Diese
>    Bedingung erfüllt das Objekt, das von numList referenziert wird, so
>    dass die Zuweisung erlaubt ist.
>    Nun kann beim Auslesen von Objekten über deren konkreten Typ
>    natürlich nichts zugesichert werden, außer dass sie
>    zuweisungskompatibel zu Object sind (dies wäre ja der "schlimmste"
>    Fall, den man annehmen könnte). Daher liefert die get()-Methode
>    auch nur eine Object-Referenz (Zeile 7).
>    Beim Hinzufügen von Elementen verhält es sich umgekehrt: Es werden
>    nur noch Integer-Referenzen akzeptiert (theoretisch auch
>    Unterklassen von Integer), da dies wiederum der speziellste Typ ist,
>    der hätte verwendet werden können. Ließe man allgemeinere Typen
>    zu, bestünde die Möglichkeit, dass ja doch Integer als Typparameter
>    verwendet wurde, und somit das Typsystem umgangen wäre.
> 71 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> ```
