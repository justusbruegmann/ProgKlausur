---
tags: ["typ/thema", "thema/innere-klassen", "kategorie/oop", "semester/2"]
aliases: ["Innere Klassen", "Folien 22"]
semester: 2
kategorie: "Objektorientierung"
folien: "[[Material/Folien/22_Innere_Klassen.pdf]]"
seiten: 17
---

# 22 Innere Klassen

← [[21 Abstrakte Klassen und Interfaces]] · [[Start|🏠 Start]] · [[23 Events]] →

> [!abstract] Worum geht's?
> Statische innere Klassen, Element-, lokale und anonyme innere Klassen und wie man Objekte davon erzeugt – Grundlage für kompaktes Event-Handling.

**Semester:** Programmieren II · **Bereich:** #kategorie/oop · **Folien:** [[Material/Folien/22_Innere_Klassen.pdf|22_Innere_Klassen.pdf]] (17 Seiten)

## Gliederung der Folien
- [[Material/Folien/22_Innere_Klassen.pdf#page=2|S. 2]] Innere Klassen
- [[Material/Folien/22_Innere_Klassen.pdf#page=3|S. 3]] Innere Klassen - Überblick
- [[Material/Folien/22_Innere_Klassen.pdf#page=4|S. 4]] Statische innere Klassen
- [[Material/Folien/22_Innere_Klassen.pdf#page=6|S. 6]] Mitglieds- oder Elementklassen
- [[Material/Folien/22_Innere_Klassen.pdf#page=8|S. 8]] Erzeugung von Objekten innerer Klassen von
- [[Material/Folien/22_Innere_Klassen.pdf#page=12|S. 12]] Lokale Klassen
- [[Material/Folien/22_Innere_Klassen.pdf#page=14|S. 14]] Anonyme innere Klassen
- [[Material/Folien/22_Innere_Klassen.pdf#page=16|S. 16]] Beispiel: Anonyme innere Klassen
- [[Material/Folien/22_Innere_Klassen.pdf#page=17|S. 17]] Anonyme innere Klassen

## Begriffe in diesem Kapitel
- [[Innere Klasse]] (S. [[Material/Folien/22_Innere_Klassen.pdf#page=2|2]], [[Material/Folien/22_Innere_Klassen.pdf#page=3|3]], [[Material/Folien/22_Innere_Klassen.pdf#page=4|4]], [[Material/Folien/22_Innere_Klassen.pdf#page=5|5]], [[Material/Folien/22_Innere_Klassen.pdf#page=6|6]], [[Material/Folien/22_Innere_Klassen.pdf#page=7|7]])
- [[Anonyme innere Klasse]] (S. [[Material/Folien/22_Innere_Klassen.pdf#page=3|3]], [[Material/Folien/22_Innere_Klassen.pdf#page=14|14]], [[Material/Folien/22_Innere_Klassen.pdf#page=15|15]], [[Material/Folien/22_Innere_Klassen.pdf#page=16|16]], [[Material/Folien/22_Innere_Klassen.pdf#page=17|17]])
- [[Effectively final]] (S. [[Material/Folien/22_Innere_Klassen.pdf#page=12|12]])

## Kommt hier auch vor
[[Interface]]

## Relevant für diese Programmentwürfe
[[PE SnatChat (Übungs-PE Oktober 2026)]] · [[PE SpeedyQuiz]]

## Verwandte Themen
[[21 Abstrakte Klassen und Interfaces]] · [[23 Events]] · [[33 Java 8 – Lambdas, Streams, NIO.2]]

## Folien ansehen
![[Material/Folien/22_Innere_Klassen.pdf]]

## Folientext (durchsuchbar)
> [!quote]- Kompletter Folientext – aufklappen
> ```text
> ── Seite 1 ──
> Programmieren II
> Innere Klassen
>    Heusch 10, 13.10
>    Ratz 5.2.1, 9.8
> 
> Institut für Automation und angewandte Informatik
> 
> KIT – Die Forschungsuniversität in der Helmholtz-Gemeinschaft www.kit.edu
> 
> ── Seite 2 ──
> Innere Klassen
> 
>    Bisher kennen wir nur Klassen, die entweder zusammen in
>    Paketen organisiert waren oder in einer Datei.
>    Diese Form von Klassen heißen “Top-Level-Klassen”.
>    Es gibt darüber hinaus die Möglichkeit, eine Klasse
>    innnerhalb einer anderen Klasse zu platzieren und sie
>    damit noch enger aneinander zu binden. Eine Klasse, die
>    so eingebunden wird, heißt “innere Klasse”. Im
>    Allgemeinen sieht dies wie folgt aus:
>    class OuterClass {
>    class InnerClass {
> 
>    }
>    }
> 
> 2 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 3 ──
> Innere Klassen - Überblick
> 
>    Die Java-Sprache definiert vier Typen von inneren Klassen
>    Statische innere Klassen
>    Mitglieds- oder Elementklassen
>    Lokale Klassen
>    Anonyme innere Klassen
> 
> 3 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 4 ──
> Statische innere Klassen (1)
> 
>    Die einfachste Variante einer inneren Klasse wird wie eine
>    statische Eigenschaft (Attribut) in die Klasse eingesetzt.
> 
>    public class Lamp {
> 
>    static String s = "Let there be light...";
>    int i = 1;
> 
>    static class Bulb {
>    void shine() {
>    System.out.println(s);
>    // System.out.println( i );
>    // Fehler (da i nicht statisch)
>    }
>    }
> 
>    }
> 
> 4 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 5 ──
> Statische innere Klassen (2)
> 
>    Die Eigenschaften der statischen inneren Klasse Bulb
>    besitzen Zugriff auf alle statischen Eigenschaften und
>    statischen Methoden der äußeren Klasse Lamp.
>    Zugriff auf Objektvariablen ist aus der statischen inneren
>    Klasse nicht möglich, da sie als extra Klasse gezählt wird,
>    die im gleichen Paket liegt.
>    Die innere Klasse muss einen anderen Namen als die
>    äußere haben.
> 
> 5 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 6 ──
> Mitglieds- oder Elementklassen (1)
> 
>    Eine Mitgliedsklasse (engl. member class), auch
>    Elementklasse genannt, ist ebenfalls vergleichbar mit
>    einem Attribut, nur ist dieses nicht statisch.
>    Die innere Klasse kann auf alle Attribute der äußeren
>    Klasse zugreifen. Dazu zählen auch die privaten
>    Eigenschaften.
>    public class Border {
>    String s = "curly";
> 
>    class Pattern {
>    void standard() {
>    System.out.println(s);
>    }
>    // static void always() { }
>    // Fehler (da innere Klasse Pattern nicht statisch)
>    }
>    }
> 6 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 7 ──
> Mitglieds- oder Elementklassen (2)
> 
>    Die innere Klasse Pattern hat Zugriff auf alle
>    Eigenschaften von Border.
>    Um innerhalb der äußeren Klasse Border eine Instanz
>    von Pattern zu erzeugen, muss ein Objekt der äußeren
>    Klasse Border existieren.
>    Das ist eine wichtige Unterscheidung gegenüber den
>    statischen inneren Klassen. Statische innere Klassen
>    existieren auch ohne Objekt der äußeren Klasse.
>    Seit Java 16 dürfen innere Mitgliedsklassen auch statische
>    Attribute oder Methoden definieren.
> 
> 7 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 8 ──
> Erzeugung von Objekten innerer Klassen von
>    außen (1)
> 
>    Innerhalb der äußeren Klassen kann mit dem new-
>    Operator ein Objekt der inneren Klasse erzeugt werden.
>    Kommen wir von außerhalb und wollen Objekte der
>    inneren Klasse erzeugen, so müssen wir bei
>    Elementklassen sicherstellen, dass es ein Objekt der
>    äußeren Klasse gibt. Die Sprache schreibt eine neue Form
>    für die Erzeugung mit new vor, die das allgemeine Format
> 
>    ref.new InnerClass();   Border b = new Border();
>    Pattern p = b.new Pattern();
> 
>    besitzt.
>    Dabei ist ref eine Objektreferenz der äußeren Klasse.
> 
> 8 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 9 ──
> Erzeugung von Objekten innerer Klassen von
>    außen (2)
>    class House {
>    class Room {
>    }
>    }
> 
>    Um von außen ein Objekt von Room aufzubauen,
>    schreiben wir:
>    House h = new House();
>    Room r = h.new Room();
> 
>    oder auch in einer Zeile:
>    Room r = new House().new Room();
> 
>    Elementklassen können beliebig geschachtelt sein, und da
>    der Name eindeutig ist, gelangen wir immer mit
>    Classname.this an die jeweilige Eigenschaft.
> 9 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 10 ──
> Erzeugung von Objekten innerer Klassen von
>    außen (3)
>    public class House {
>    String s = "House";
> 
>    class Room {
>    String s = "Room";
> 
>    class Chair {
>    String s = "Chair";
> 
>    void output() {   Ausgabe
>    System.out.println(s);   Chair
>    System.out.println(this.s);   Chair
>    System.out.println(Chair.this.s);   Chair
>    System.out.println(Room.this.s);   Room
>    System.out.println(House.this.s);   House
>    }
>    }
>    }
> 
>    public static void main(String args[]) {
>    new House().new Room().new Chair().output();
>    }
>    }
> 
> 10 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 11 ──
> Erzeugung von Objekten innerer Klassen von
>    außen (4)
>    Objekte für die inneren Klassen House, Room und Chair lassen sich
>    auch wie folgt erstellen:
>    House a = new House();   // Exemplar von Haus
>    House.Room b = a.new Room();   // Exemplar von Zimmer in a
>    House.Room.Chair c = b.new Chair(); // Exemplar von Stuhl in b
>    c.output();   // Methode von Stuhl
> 
>    Die Qualifizierung mit dem Punkt bei House.Room.Chair bedeutet
>    nicht, dass House ein Paket mit dem Unterpaket Room ist, in dem die
>    Klasse Chair existiert.
> 
>    Lesbarkeit erschwert, Verwechslungsgefahr zwischen inneren Klassen
>    und Paketen.
>    Deshalb: Namenskonvention befolgen! Klassennamen beginnen mit
>    Großbuchstaben, Paketnamen mit Kleinbuchstaben.
> 
> 11 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 12 ──
> Lokale Klassen (1)
> 
>    Lokale Klassen sind innere Klassen, die jedoch nicht als Eigenschaft
>    direkt in einer Klasse eingesetzt werden. Diese Form der inneren
>    Klasse befindet sich in Anweisungsblöcken von Methoden oder
>    Initialisierungsblöcken.
>    public class ItsFunInside {
> 
>    public static void main(String args[]) {
>    int i = 2;
>    final int j = 3;
>    class In {
>    In() {
>    System.out.println(j);
>    System.out.println(i);
>    }
>    }
>    new In();
>    }
>    Bis Java 8: Fehler; seit Java 8: erlaubt
>    }   Grund: „effectively final“ (ausführlich später bei Java 8)
> 
> 12 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 13 ──
> Lokale Klassen (2)
> 
>    Die Definition der inneren Klasse In ist wie eine
>    Anweisung eingesetzt.
>    Jede lokale Klasse kann auf Methoden der äußeren Klasse
>    zugreifen und zusätzlich auf die lokalen Variablen und
>    Parameter, die mit dem Modifizierer final als
>    unveränderlich ausgezeichnet sind.
>    Liegt die innere Klasse in einer statischen Methode, kann
>    sie jedoch keine Objektmethode aufrufen.
>    Eine weitere Einschränkung im Vergleich zu den
>    Mitgliedsklassen ist, dass die Modifizierer public,
>    protected, private und static nicht erlaubt sind.
> 
> 13 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 14 ──
> Anonyme innere Klassen (1)
> 
>    Anonyme Klassen gehen noch einen Schritt weiter als
>    lokale Klassen. Sie haben keinen Namen und erzeugen
>    immer automatisch ein Objekt.
>    Klassendefinition und Objekterzeugung sind zu einem
>    Sprachkonstrukt verbunden. Die allgemeine Notation ist
>    folgende:
>    new KlasseOderSchnittstelle() {
>    /* Eigenschaften der inneren Klasse */
>    };
> 
>    In dem Block geschweifter Klammern lassen sich nun
>    Methoden und Attribute definieren. Hinter new steht der
>    Name einer Klasse oder Schnittstelle (interface).
> 14 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 15 ──
> Anonyme innere Klassen (2)
> 
>    Wenn hinter new der Klassenname A steht, dann ist die
>    anonyme Klasse eine Unterklasse von A.
>    Wenn hinter new der Name einer Schnittstelle S steht,
>    dann erbt die anonyme Klasse von Object und
>    implementiert die Schnittstelle S.
>    Würde sie die Operationen der Schnittstelle nicht
>    implementieren, hätten wir eine abstrakte innere Klasse,
>    von der kein Objekt erzeugt werden könnte (was wir aber
>    genau an dieser Stelle tun).
>    Für anonyme innere Klassen sind keine zusätzlichen
>    extends- oder implements-Angaben möglich.
> 
> 15 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 16 ──
> Beispiel: Anonyme innere Klassen
>    import java.awt.Point;
> 
>    public class InnerToStringPoint {
> 
>    public static void main(String args[]) {
> 
>    Point p = new Point(10, 12) {
>    public String toString() {
>    return "(" + x + "," + y + ")";
>    }
>    };
>    System.out.println(p);
>    }   Ausgabe
>    (10,12)
>    }
> 
>    Da sofort eine Unterklasse von Point definiert wird, fehlt der Name
>    der inneren Klasse. Das einzige Exemplar dieser anonymen Klasse
>    lässt sich über die Variable p weiterverwenden.
> 
> 16 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 17 ──
> Anonyme innere Klassen (3)
> 
>    Eine anonyme innere Klasse kann nützliche Methoden der
>    Oberklasse überschreiben oder Schnittstellen
>    implementieren.
>    Neue Eigenschaften anzubieten wäre zwar legal, aber
>    nicht sinnvoll. Denn von außen wären diese Methoden und
>    Attribute unbekannt, da die zugänglichen Eigenschaften
>    der Oberklasse den Zugriff festlegen.
>    Deshalb sind auch anonyme Unterklassen von Object
>    (ohne weitere implementierte Schnittstellen) nur selten
>    nützlich.
>    Ein Haupteinsatzgebiet für anonyme innere Klassen ist die
>    Ereignisbehandlung (Event-Handling), z.B. bei Swing.
> 
> 17 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> ```
