---
tags: ["typ/thema", "thema/klassen", "kategorie/oop", "semester/1"]
aliases: ["Klassen und Objekte", "Folien 09"]
semester: 1
kategorie: "Objektorientierung"
folien: "[[Material/Folien/09_Klassen_und_Objekte.pdf]]"
seiten: 35
---

# 09 Klassen und Objekte

← [[08 Objektorientierung]] · [[Start|🏠 Start]] · [[10 Strings und Wrapperklassen]] →

> [!abstract] Worum geht's?
> Eigene Klassen schreiben: Attribute, Konstruktoren, Methoden, this, Überladen, Constructor Chaining, statische Klassenvariablen/-methoden, toString() und die main-Methode.

**Semester:** Programmieren I · **Bereich:** #kategorie/oop · **Folien:** [[Material/Folien/09_Klassen_und_Objekte.pdf|09_Klassen_und_Objekte.pdf]] (35 Seiten)

## Gliederung der Folien
- [[Material/Folien/09_Klassen_und_Objekte.pdf#page=2|S. 2]] Klassen, Objekte und Instanzen (Wiederholung)
- [[Material/Folien/09_Klassen_und_Objekte.pdf#page=3|S. 3]] Klassen – selbstdefinierte Datentypen erstellen
- [[Material/Folien/09_Klassen_und_Objekte.pdf#page=4|S. 4]] Attribute versus lokale Variablen
- [[Material/Folien/09_Klassen_und_Objekte.pdf#page=5|S. 5]] Instanzvariablen
- [[Material/Folien/09_Klassen_und_Objekte.pdf#page=6|S. 6]] Konstruktoren
- [[Material/Folien/09_Klassen_und_Objekte.pdf#page=7|S. 7]] Erzeugung von Objekten, Referenzvariablen
- [[Material/Folien/09_Klassen_und_Objekte.pdf#page=9|S. 9]] Attribute von Objekten: Zugriff
- [[Material/Folien/09_Klassen_und_Objekte.pdf#page=10|S. 10]] Methoden – die Funktionalität der Klassen
- [[Material/Folien/09_Klassen_und_Objekte.pdf#page=11|S. 11]] Methoden deklarieren
- [[Material/Folien/09_Klassen_und_Objekte.pdf#page=12|S. 12]] Beispiel: Klasse Rectangle
- [[Material/Folien/09_Klassen_und_Objekte.pdf#page=13|S. 13]] Weitere Methoden der Klasse Rectangle
- [[Material/Folien/09_Klassen_und_Objekte.pdf#page=14|S. 14]] Instanz- bzw. Objektmethoden
- [[Material/Folien/09_Klassen_und_Objekte.pdf#page=16|S. 16]] Beispiel: Rectangle-Objekte verwenden
- [[Material/Folien/09_Klassen_und_Objekte.pdf#page=17|S. 17]] Verwendung von this bei Kapselung von Attributen
- [[Material/Folien/09_Klassen_und_Objekte.pdf#page=18|S. 18]] Überladen
- [[Material/Folien/09_Klassen_und_Objekte.pdf#page=19|S. 19]] Mehrere Konstruktoren und Zuweisung von Objektreferenzen
- [[Material/Folien/09_Klassen_und_Objekte.pdf#page=20|S. 20]] Constructor Chaining
- [[Material/Folien/09_Klassen_und_Objekte.pdf#page=21|S. 21]] ÜBUNG
- [[Material/Folien/09_Klassen_und_Objekte.pdf#page=22|S. 22]] Klassenvariablen und -methoden
- [[Material/Folien/09_Klassen_und_Objekte.pdf#page=23|S. 23]] Syntax der Deklaration von Klassenvariablen
- [[Material/Folien/09_Klassen_und_Objekte.pdf#page=24|S. 24]] Beispiel: Klassenvariablen
- [[Material/Folien/09_Klassen_und_Objekte.pdf#page=25|S. 25]] Beispiel: Klassenmethoden
- [[Material/Folien/09_Klassen_und_Objekte.pdf#page=27|S. 27]] Statischer Initialisierer (static-Block)
- [[Material/Folien/09_Klassen_und_Objekte.pdf#page=28|S. 28]] Beispiel: Initialisierung von Klassenvariablen
- [[Material/Folien/09_Klassen_und_Objekte.pdf#page=29|S. 29]] Klasse mit gemischten Attributen
- [[Material/Folien/09_Klassen_und_Objekte.pdf#page=30|S. 30]] Methode toString()
- [[Material/Folien/09_Klassen_und_Objekte.pdf#page=31|S. 31]] Die main-Methode
- [[Material/Folien/09_Klassen_und_Objekte.pdf#page=32|S. 32]] Parameterübergabe per IDE - Eclipse
- [[Material/Folien/09_Klassen_und_Objekte.pdf#page=33|S. 33]] Parameterübergabe per IDE - IntelliJ
- [[Material/Folien/09_Klassen_und_Objekte.pdf#page=34|S. 34]] Was gibt dieses Programm aus?
- [[Material/Folien/09_Klassen_und_Objekte.pdf#page=35|S. 35]] Ergebnis

## Begriffe in diesem Kapitel
- [[main-Methode]] (S. [[Material/Folien/09_Klassen_und_Objekte.pdf#page=4|4]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=9|9]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=12|12]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=16|16]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=19|19]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=30|30]])
- [[Variable]] (S. [[Material/Folien/09_Klassen_und_Objekte.pdf#page=2|2]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=4|4]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=7|7]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=9|9]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=22|22]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=28|28]])
- [[Konstante]] (S. [[Material/Folien/09_Klassen_und_Objekte.pdf#page=24|24]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=25|25]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=28|28]])
- [[Klasse]] (S. [[Material/Folien/09_Klassen_und_Objekte.pdf#page=2|2]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=3|3]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=10|10]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=12|12]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=13|13]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=22|22]])
- [[Objekt]] (S. [[Material/Folien/09_Klassen_und_Objekte.pdf#page=2|2]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=5|5]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=7|7]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=8|8]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=9|9]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=14|14]])
- [[Attribut]] (S. [[Material/Folien/09_Klassen_und_Objekte.pdf#page=2|2]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=3|3]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=4|4]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=5|5]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=6|6]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=9|9]])
- [[Methode]] (S. [[Material/Folien/09_Klassen_und_Objekte.pdf#page=2|2]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=3|3]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=4|4]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=10|10]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=11|11]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=13|13]])
- [[Konstruktor]] (S. [[Material/Folien/09_Klassen_und_Objekte.pdf#page=2|2]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=6|6]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=18|18]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=19|19]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=20|20]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=24|24]])
- [[this]] (S. [[Material/Folien/09_Klassen_und_Objekte.pdf#page=13|13]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=17|17]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=19|19]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=20|20]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=24|24]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=26|26]])
- [[static]] (S. [[Material/Folien/09_Klassen_und_Objekte.pdf#page=2|2]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=22|22]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=23|23]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=24|24]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=25|25]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=26|26]])
- [[Überladen]] (S. [[Material/Folien/09_Klassen_und_Objekte.pdf#page=18|18]])
- [[toString]] (S. [[Material/Folien/09_Klassen_und_Objekte.pdf#page=13|13]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=16|16]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=30|30]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=34|34]])
- [[Kapselung]] (S. [[Material/Folien/09_Klassen_und_Objekte.pdf#page=17|17]])
- [[Sichtbarkeitsmodifikatoren]] (S. [[Material/Folien/09_Klassen_und_Objekte.pdf#page=4|4]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=5|5]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=6|6]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=9|9]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=11|11]], [[Material/Folien/09_Klassen_und_Objekte.pdf#page=12|12]])

## Übungen
- [ ] [[Ü09 Radio]] ★☆☆☆☆ ✅ Musterlösung
- [ ] [[Ü09 Zweidimensionaler Punkt]] ★★☆☆☆ ✅ Musterlösung
- [ ] [[Ü09 Bankkonto]] ★★☆☆☆ ✅ Musterlösung
- [ ] [[Ü09 Polynom 2. Grades]] ★★☆☆☆ ✅ Musterlösung
- [ ] [[Ü09 Komplexe Zahlen]] ★★★☆☆ ✅ Musterlösung
- [ ] [[Ü09 Polynome und Horner-Schema]] ★★★☆☆ ✅ Musterlösung
- [ ] [[Ü09 Nimmspiel]] ★★★☆☆ ✅ Musterlösung
- [ ] [[Ü09 Lotto]] ★★★☆☆ ✅ Musterlösung
- [ ] [[Ü09 MasterMind]] ★★★★☆ ✅ Musterlösung
- [ ] [[Ü09 Wechselspiel (1. Teil)]] ★★★★★
- [ ] [[Ü09 Wechselspiel (2. Teil)]] ★★★★★

## Relevant für diese Programmentwürfe
[[PE CHORona]] · [[PE ChatterGPT Validator]] · [[PE CoronaWarn]] · [[PE DBVasion]] · [[PE FakeTalk]] · [[PE SnatChat (Übungs-PE Oktober 2026)]] · [[PE SpeedyQuiz]] · [[PE jBay]]

## Verwandte Themen
[[08 Objektorientierung]] · [[11 Methoden – Parameterübergabe und Rekursion]] · [[13 Vererbung]] · [[10 Strings und Wrapperklassen]]

## Folien ansehen
![[Material/Folien/09_Klassen_und_Objekte.pdf]]

## Folientext (durchsuchbar)
> [!quote]- Kompletter Folientext – aufklappen
> ```text
> ── Seite 1 ──
> Programmieren I
> Klassen und Objekte
>    Heusch 12-13
>    Ratz 7-9
> 
> Institut für Automation und angewandte Informatik
> 
> KIT – Die Forschungsuniversität in der Helmholtz-Gemeinschaft www.kit.edu
> 
> ── Seite 2 ──
> Klassen, Objekte und Instanzen (Wiederholung)
> 
>    Klasse: Sammlung aller Eigenschaften und Methoden der
>    Objekte. Konstruktoren legen deren Erzeugung fest.
>    „Instanz einer Klasse“: tatsächliches Objekt.
>    (Klasse = abstrakte, Instanz = konkrete Darstellung)
>    Jede Klasse besteht im allgemeinen aus zwei Komponenten:
>    Attribute und Methoden.
>    Die Daten (Eigenschaften) werden durch Variablen
>    (Attribute) definiert (Instanzvariablen und Klassenvariablen).
>    Das Verhalten wird durch Methoden bestimmt. Methoden
>    regeln, was Objekte alles machen können und was man mit
>    Objekten machen kann. Methoden sind Funktionen, die
>    innerhalb von Klassen definiert (Instanzmethoden und
>    Klassenmethoden) sind.
> 2 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 3 ──
> Klassen – selbstdefinierte Datentypen erstellen
> 
>    Einfache Datentypen können nur einen Wert speichern.
>    Eine Klasse beschreibt einen "neuen Datentyp", der sich
>    durch verschiedene Attribute und eine spezielle
>    Funktionalität auszeichnet.
>    Java baut als objektorientierte Programmiersprache auf
>    diesem Konzept auf. Sämtlicher Programmcode befindet
>    sich innerhalb von Klassenbeschreibungen.
>    Attribute und Methoden sind immer innerhalb einer Klasse
>    beschrieben.
>    Syntax einer Klassendefinition in Java:
>    class class_name {
>    { attribute }
>    { constructor }
>    { method }
>    }
> 3 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 4 ──
> Attribute versus lokale Variablen
> 
>    Lokale Variablen werden innerhalb einer Methode in einem
>    Anweisungsblock definiert und sind auch nur in diesem
>    Bereich gültig.
>    Neben lokalen Variablen (innerhalb von Methoden) kennt
>    Java so genannte Attribute. Attribute werden außerhalb
>    einer Methode in der Klassenbeschreibung definiert.
>    class Rectangle {
>    int width;   Attribute
>    int height;
> 
>    // ...
>    public static void main(String args[]) {
>    int i = 1;
>    // ...   Lokale Variable
>    }
>    }
> 
> 4 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 5 ──
> Instanzvariablen
> 
>    Attribute gehören standardmäßig (keine Verwendung des
>    Modifikators static) zu den Objekten der Klasse. Sie
>    werden deshalb auch Instanzvariablen genannt.
>    Instanzvariablen stellen die Eigenschaften des Objektes
>    dar.
>    Sie existieren erst wenn ein Objekt existiert.
>    Jedes Objekt einer Klasse hat die gleichen
>    Instanzvariablen, besitzt aber eine eigene Identität.
> 
> 5 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 6 ──
> Konstruktoren
> 
>    Konstruktoren werden nur bei der Instanziierung
>    (Erzeugung) eines Objektes der Klasse aufgerufen. Sie
>    tragen den Namen der Klasse.
>    class Rectangle {
> 
>    int width;   // Attribut für die Breite
>    int height;   // Attribut für die Höhe
> 
>    public Rectangle() { // Konstruktor ohne Parameter
>    width = 0;
>    height = 0;
>    }
> 
>    public Rectangle(int w, int h) { // Konstruktor mit Parametern
>    width = w;
>    height = h;
>    }
>    Heusch 12.4
>    // ...
>    Ratz 8.4
>    }
> 
> 6 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 7 ──
> Erzeugung von Objekten, Referenzvariablen (1)
> 
>    Klassen werden zur Übersetzungszeit angelegt (im
>    erzeugten Programmcode).
>    Objekte werden hingegen erst zur Laufzeit erzeugt ➔
>    Mechanismus zur Instanziierung notwendig.
>    In Java gibt es keine Variablen, deren Wert ein Objekt ist
>    (wie bei primitiven Datentypen).
>    Es gibt nur Variablen, in denen eine Referenz - ein Verweis
>    - auf ein Objekt abgelegt werden kann (Referenzvariablen).
>    Die Objektreferenz wird beim Erzeugen des Objekts
>    geliefert.
> 
> 7 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 8 ──
> Erzeugung von Objekten, Referenzvariablen (2)
> 
>    Deklaration von Referenzvariablen. Syntax und Beispiel:
>    class_name variable_name {, variable_name } ;
>    rect1   rect2   rect3
>    Rectangle rect1;
>    Rectangle rect2, rect3;   ●   ●   ●
> 
>    Erzeugung von Objekten mit Hilfe von new und
>    Zuweisung der Objekt-Referenzen an Referenzvariablen:
>    variable_name = new class_name ( [ parameter_list ] ) ;
>    rect1   rect2   rect3
>    rect1 = new Rectangle();
>    ●   ●   ●
>    rect2 = new Rectangle(2, 3);
>    rect3 = rect2;
>    width = 2
>    width = 0   height = 3
>    height = 0
>    Objekt der Klasse
>    Objekt der Klasse   Rectangle
>    Rectangle
> 8 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 9 ──
> Attribute von Objekten: Zugriff
> 
>    Der Zugriff auf Attribute (und auch Methoden) erfolgt mit Hilfe
>    des Dereferenzierungsoperators "." (Punkt).
>    Syntax:
>    variable_name . attribut_name
>    variable_name: Name der Variablen, in der die Referenz auf das
>    Objekt gespeichert ist.
>    Beispiel:
>    class Geometry {
>    public static void main(String[] args) {
>    Rectangle a = new Rectangle(2, 3);
>    Rectangle b = new Rectangle(4, 5);
> 
>    a.height = b.height;
>    b.height = 10;
>    }
>    }
> 9 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 10 ──
> Methoden – die Funktionalität der Klassen
> 
>    Neben den Attributen können auch Methoden zu einer
>    Klasse gehören.
>    Mit Hilfe von Methoden wird das Verhalten
>    (Funktionalität) der Objekte eine Klasse ausgedrückt.
>    Methoden werden wie die Attribute innerhalb einer Klasse
>    beschrieben.
>    Methoden gehören immer zu der Klasse.
>    Eine Klasse kann mehrere Methoden haben, wobei die Methoden
>    in beliebiger Reihenfolge beschrieben werden können.
>    Methoden können nicht geschachtelt werden.
> 
>    Heusch 9.2
>    Ratz 6.1
> 
> 10 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 11 ──
> Methoden deklarieren
> 
>    Beschreibung einer Methode   int getArea()
>    erfolgt durch Methodenkopf
>    {
>    und Methodenrumpf.   int result = height * width;
>    Methodenkopf besteht aus   return result;
>    dem Namen, einer Parameterliste, }
>    dem Typ des Rückgabewertes und
>    einem Sichtbarkeitsmodifikator, z.B. „public“ oder „private“.
>    Der Methodenrumpf besteht aus einem Block mit Anweisungen, der
>    in geschweifte Klammern { } gesetzt wird.
>    Mit der Anweisung return Ausdruck; wird ein Rückgabewert
>    festgelegt, dessen Typ dem deklarierten Rückgabe-Typ entsprechen
>    muss.
>    Wird anstelle eines Rückgabe-Typs das Schlüsselwort void
>    verwendet, hat die Methode keinen Rückgabewert.
> 
> 11 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 12 ──
> Beispiel: Klasse Rectangle
>    public class Rectangle {
>    int width;
>    int height;
> 
>    public Rectangle(int w, int h) {
>    width = w;
>    height = h;
>    }
> 
>    public int getArea(){
>    return height * width;
>    }
> 
>    public void scale(int factor){
>    width = width * factor;
>    height *= factor;
>    }
> 
>    public static void main(String[] args) {
>    Rectangle a = new Rectangle(3, 4);
>    a.scale(3);
>    System.out.println(a.getArea());
>    }   > java Rectangle
>    }   108
> 
> 12 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 13 ──
> Weitere Methoden der Klasse Rectangle
>    public class Rectangle {
>    int width;
>    int height;
>    // ...
> 
>    public void setWidth(int width) {
>    this.width = width;
>    }
>    public void setHeight(int h) {
>    height = h;
>    }
> 
>    @Override
>    public String toString() {
>    String res;
>    res = "Rectangle Width: " + width + "\n";
>    res += "   Height: " + height + "\n";
>    return res;
>    }
>    //...
>    }
> 
> 13 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 14 ──
> Instanz- bzw. Objektmethoden (1)
> 
>    Die bisher behandelten Methoden müssen von einem
>    Objekt aus aufgerufen werden.
>    Man nennt sie deshalb Objekt- bzw. Instanzmethoden.
>    Der Aufruf erfolgt in der Form
>    object_name . method_name ( [ parameter_list ] )
> 
>    Rectangle a = new Rectangle(3, 4);
>    a.scale(3);
> 
>    Methodennamen beginnen üblicherweise mit einem
>    Kleinbuchstaben (Konvention, nicht Pflicht).
>    Wird ein Attribut oder eine Methode aus einer Methode
>    derselben Klasse aufgerufen, braucht keine Objektreferenz
>    angegeben werden.
> 14 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 15 ──
> Instanz- bzw. Objektmethoden (2)
> 
>    Im Gegensatz zum Zugriff auf Attribute wird der Zugriff auf
>    Methoden durch folgende runde Klammern () hinter dem
>    Namen gekennzeichnet.
>    Objekte müssen nach ihrer Benutzung nicht explizit
>    gelöscht werden, dies übernimmt der Garbage Collector.
> 
> 15 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 16 ──
> Beispiel: Rectangle-Objekte verwenden
>    public class Geometry {
> 
>    public static void main(String[] args) {
>    Rectangle a = new Rectangle(3, 4);
>    Rectangle b = new Rectangle(1, 2);
> 
>    System.out.println(a.toString());
>    System.out.println(b);
>    a.scale(3);
>    b.setWidth(2);
>    System.out.println(a.getArea());
>    int area = b.getArea();
>    System.out.println(area);
> 
>    System.out.println(a);
>    System.out.println(b.toString());
>    }
>    Ausgabe?
>    }
> 
> 16 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 17 ──
> Verwendung von this bei Kapselung von Attributen
> 
>    Von der Entwicklungsumgebung erzeugte getter- und setter-Methoden.
>    Eclipse: Source (Shift+Alt+S) > Generate Getters and Setters
>    Intellij: Right Click (Atl+i) > Generate > Getters and Setters
> public class Fraction { public void setNumerator(int numerator) {
>    this.numerator = numerator;
>    private int numerator = 0;   }
>    private int denominator = 1;   public double getValue(){
>    return getNumerator()
>    / (double)getDenominator();
>    public void setDenominator(int d) {   }
>    if (d != 0)
>    denominator = d;   public static void main
>    }   (String[] args) {
>    Fraction f = new Fraction();
>    public int getDenominator() {   f.setNumerator(1);
>    return denominator;   f.setDenominator(2);
>    }   System.out.println
>    ("Value: " + f.getValue());
>    public int getNumerator() {   }
>    return numerator;
>    }   }
> 
> 17 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 18 ──
> Überladen
>    Innerhalb einer Klasse können mehrere Methoden (und auch
>    Konstruktoren) mit demselben Namen existieren.
>    Sie müssen sich jedoch hinsichtlich der Anzahl und/oder des
>    Datentyps der Parameter unterscheiden.
>    Die Programmierung mehrerer Methoden innerhalb einer Klasse mit
>    gleichem Namen und unterschiedlicher Anzahl von Parametern wird oft
>    auch Überladen (Overloading) genannt. Die Auswahl der geeigneten
>    Methode geschieht zur Compilezeit.
>    Beispiel für das Überladen von Methoden:
>    public void resize(int factor) {
>    height *= factor;
>    width *= factor;
>    }
> 
>    public void resize(int newWidth, int newHeight) {
>    width = newWidth;
>    height = newHeight;   Heusch 12.3.4
>    }   Ratz 6.1.5
> 
> 18 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 19 ──
> Mehrere Konstruktoren und Zuweisung von Objektreferenzen
> public class Circle { public class Test {
>    // Instanzvariablen   public static void main(String[] args) {
>    public double x, y, r;   Circle c1 = new Circle();
>    Circle c2 = new Circle(2,2,4);
>    // Konstruktoren
>    public Circle(double x, double y, double r) {   System.out.println("Area c1: "+c1.getArea());
>    this.x = x;   System.out.println("Area c2: "+c2.getArea());
>    this.y = y;
>    this.r = r;   c2 = c1;
>    }   System.out.println("Area c1: "+c1.getArea());
>    System.out.println("Area c2: "+c2.getArea());
>    public Circle(double r) {
>    this(0, 0, r);   c1.r = 2;
>    }   System.out.println("Area c1: "+c1.getArea());
>    System.out.println("Area c2: "+c2.getArea());
>    public Circle(Circle c) {   }
>    this(c.x, c.y, c.r);   }
>    }
> 
>    public Circle() {
>    this(0, 0, 1);   > java Test
>    }   Area c1: 3.14159
>    Area c2: 50.26544
>    // Methoden
>    Area c1: 3.14159
>    public double getArea() {
>    return 3.14159 * r * r;   Area c2: 3.14159
>    }   Area c1: 12.56636
> } Area c2: 12.56636
> 
> 19 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 20 ──
> Constructor Chaining
> 
>    verschiedene Konstruktoren können von anderen
>    Konstruktoren aus aufgerufen werden
>    Verwendung des Schlüsselworts this
>    Parameterliste des jeweiligen Konstruktors wird
>    anschließend übergeben
>    Beispiele siehe eingekreiste Aufrufe in vorheriger
>    Folie
> 
> 20 J. Sidler, W. Süß, T. Schlachter, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 21 ──
> ÜBUNG
> 
> 21 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 22 ──
> Klassenvariablen und -methoden
>    Werden definiert durch Verwendung des Schlüsselworts static.
>    Sind nicht an die Existenz eines Objektes einer Klasse gebunden.
>    Im Gegensatz zu Objektvariablen gehören statische Variablen zu der
>    Klasse selbst. Sie werden daher auch Klassenvariablen genannt.
>    Klassenvariablen existieren genau einmal, wobei es nicht erforderlich
>    ist, dass Objekte (Instanzen) von der Klasse existieren
>    Ebenso ist die Festlegung von statischen Methoden
>    (Klassenmethoden) möglich.
>    Statische Methoden arbeiten unabhängig von den Attributen der
>    Klasse.
>    Der Zugriff auf statische Variablen und Methoden erfolgt über den
>    Klassennamen.
> 
>    Heusch 12.8
>    Ratz 8.3
> 
> 22 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 23 ──
> Syntax der Deklaration von Klassenvariablen
>    und -methoden
> 
>    Deklaration von Klassenvariablen und Beispiel:
>    { modifier } static type variable_name [= value]
>    {, variable_name [= value]} ;
> 
>    public static int numCircles = 0;
> 
>    Deklaration von Klassenmethoden und Beispiel:
>    { modifier } static type method_name ( [type parameter_name
>    {, type parameter_name}] ) {
>    method_body
>    }
> 
>    public static double abs(double x) {
>    if (x < 0) {
>    return -x;
>    } else {
>    return x;
>    }
>    }
> 
> 23 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 24 ──
> Beispiel: Klassenvariablen
>    public class Circle {
>    // Klassenvariable: erzeugte Kreise
>    public static int numCircles = 0;
>    // Zugriff auf Klassenvariablen
>    // Konstante   System.out.println(
>    public static final double PI = 3.14159265;   "Circles: " + Circle.numCircles
>    );
>    // Instanzvariablen
>    public double x, y, r;   System.out.println("Pi: "+Circle.PI);
> 
>    // Konstruktoren
>    public Circle(double x, double y, double r) {
>    this.x = x; this.y = y; this.r = r;
>    numCircles++;
>    }
>    public Circle(double r) {
>    this(0,0,r);
>    }
> 
>    // Methoden
>    public double getCircumference() {
>    return 2 * PI * r;
>    }
>    public double getArea() {
>    return PI * r * r;
>    }
>    }
> 24 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 25 ──
> Beispiel: Klassenmethoden (1)
>    public class Circle {   // Aufruf der Instanzmethode
>    Circle a = new Circle(1,2,3);
>    // Klassenvariable: erzeugte Kreise   System.out.println(
>    public static int numCircles = 0;   "inside: " + a.isInside(0,0)
>    // Konstante   );
>    public static final double PI = 3.14159265;
>    // Instanzvariablen
>    public double x, y, r;
> 
>    // Konstruktor
>    // ...
> 
>    // Liegt Punkt (a,b) innerh. des Kreises?
>    public boolean isInside(double a, double b) {
>    double dx = a - x;
>    double dy = b - y;
>    double distance = Math.sqrt(dx*dx+dy*dy);
>    return distance <= r;
>    }   Math.sqrt() ist ein Aufruf
>    // ...
>    }   einer Klassenmethode
>    (statische Methode), die in der
>    Klasse Math definiert ist.
> 
> 25 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 26 ──
> Beispiel: Klassenmethoden (2)
>    public class Circle {
>    // ...   // Aufruf der Instanzmethode
>    // Instanzvariablen   Circle a = new Circle(2);
>    public double x, y, r;   Circle b = new Circle(3);
>    // ...   Circle c = a.bigger(b);
>    // oder: b.bigger(a);
>    // Instanzmethode,
>    // liefert den größeren Kreis   // Aufruf der Klassenmethode
>    public Circle bigger(Circle c) {   Circle a = new Circle(2);
>    return c.r > r ? c : this;   Circle b = new Circle(3);
>    }   Circle c = Circle.bigger(a,b);
> 
>    // Klassenmethode, liefert den größeren Kreis
>    public static Circle bigger(Circle a, Circle b) {
>    if ( a.r > b.r )
>    return a;
>    else
>    return b;
>    }
> 
>    // ...
>    }
> 
> 26 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 27 ──
> Statischer Initialisierer (static-Block)
> 
>    Ein static-Block ist eine Art Konstruktor für das Klassenobjekt
>    selbst (und nicht für eine Instanz der Klasse).
>    In ihm können statische Komponenten einer Klasse, z.B.
>    Klassenvariablen, initialisiert werden.
>    Syntax:
>    static {
>    { statement }
>    }
> 
>    Statische Initialisierer haben nur Zugriff auf statische
>    Komponenten einer Klasse, nicht auf Instanzkomponenten.
>    Ein static-Block wird beim Start ausgeführt (wenn die Klasse
>    geladen wird, zur Übersetzungszeit).
> 
> 27 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 28 ──
> Beispiel: Initialisierung von Klassenvariablen
>    public class RandomNumbers {
> 
>    private static final int MAX = 20;
>    private static int[] randomNumbers;
> 
>    static {
>    RandomNumbers.randomNumbers = new int[RandomNumbers.MAX];
>    // Lokale Variable rand ist nicht static!
>    Random rand = new Random();
>    for (int i = 0; i < RandomNumbers.MAX; i++) {
>    RandomNumbers.randomNumbers[i] = rand.nextInt(50);
>    }
>    }
> 
>    // ...
> 
>    }
> 
> 28 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 29 ──
> Klasse mit gemischten Attributen
>    public class Mix {
>    protected int a;
>    protected static int b;
> 
>    public Mix(int val) {
>    a = val;
>    b = 17;
>    }
> 
>    public void print() {
>    System.out.println(a + "   " + b);
>    }
> 
>    public void setAundB(int val1, int val2) {
>    a = val1;
>    b = val2;
>    }
> 
>    public static void setAundBStatic(int val1, int val2) {
>    a = val1;   // Compiler-Fehler!
>    b = val2;   Zugriff auf ein nicht-statisches
>    }
>    }
>    Attribut a (Instanzvariable) aus
>    einer statischen Methode heraus.
> 29 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 30 ──
> Methode toString()
>    public class Circle {
> 
>    public double x, y, r; // Instanzvariablen
> 
>    // Konstruktor
>    public Circle(double x, double y, double r) {
>    this.x = x;
>    this.y = y;
>    this.r = r;
>    }
> 
>    @Override
>    public String toString() {
>    return "Circle with center at: (" + x + "," + y + ") and radius: " + r;
>    }
> 
>    public static void main(String args[]) {
>    Circle kreis = new Circle(3.0, 3.0, 2.0);
>    System.out.println(kreis.toString());
>    System.out.println(kreis);
>    }
>    > java Circle
>    }   Circle with center at: (3.0,3.0) and radius: 2.0
>    Circle with center at: (3.0,3.0) and radius: 2.0
> 
> 30 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 31 ──
> Die main-Methode
>    Eine Java-Applikation benötigt eine main-Methode (auch Hauptprogramm
>    genannt).
>    public class ReadParams {
>    public static void main(String[] args) {
>    for (int i = 0; i < args.length; i++) {
>    System.out.println("Parameter " + i + ": " + args[i]);
>    }
>    }
>    }
> 
>    Die Methode main(String args[]) verwendet Argumente. Auf diese
>    Weise lassen sich beim Programmstart Parameter übergeben.
> 
>    Beispiel für Aufruf der Anwendung mit Übergabe der Parameter:
> 
>    > java ReadParams 123 karl 9.345
>    Parameter 0: 123
>    Parameter 1: karl
>    Parameter 2: 9.345   Heusch 4.1.12
>    Ratz 6.3
> 
> 31 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 32 ──
> Parameterübergabe per IDE - Eclipse
> 
>    Rechtsklick
>    auf die Klasse
>    im Package
>    Explorer
> 
>    Run as..
> 
>    Run
>    Configurations
>    (Reiter „Arguments“)
> 
> 32 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 33 ──
> Parameterübergabe per IDE - IntelliJ
> 
>    Gewünschte
>    config
>    auswählen
> 
>    Edit Confi-
>    gurations
> 
> 34 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 34 ──
> Was gibt dieses Programm aus?
> public class Exam { public String toString() {
>    return "Exam: " + f;
>    float f;   }
> 
>    Exam(float z) {   public static void main(String[] args) {
>    f = z;   Exam g = new Exam(2);
>    }   Exam h;
>    Exam i;
>    public Exam method1(float i) {   h = g.method1(3);
>    return new Exam(f * i);   System.out.println(g);
>    }   System.out.println(h);
>    i = h.method2(1);
>    public Exam method2(float i) {   System.out.println(g);
>    f += i;   System.out.println(h);
>    return this;   System.out.println(i);
>    }   i = g.method3(h);
>    System.out.println(g);
>    public Exam method3(Exam h) {   System.out.println(h);
>    f = h.getValue() + this.getValue();   System.out.println(i);
>    h.f = h.getValue() + getValue();   }
>    return this;
>    }   }
> 
>    public float getValue() {
>    return f;
>    }
> 
> 35 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 35 ──
> Ergebnis
>    Exam g = new Exam(2);   h = g.method1(3);
>    Exam h;
>    Exam i;   g   h   i
> 
>    g   h   i   ●   ●   ●
>    ●   ●   ●
> 
>    f=2   f=6
>    f=2
> 
>    i = h.method2(1);   i = g.method3(h);
>    g   h   i   g   h   i
> 
>    ●   ●   ●   ●   ●   ●
> 
>    f=2   f=7   f=9   f=16
> 
> 36 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> ```
