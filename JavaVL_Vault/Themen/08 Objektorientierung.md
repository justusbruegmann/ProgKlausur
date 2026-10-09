---
tags: ["typ/thema", "thema/objektorientierung", "kategorie/oop", "semester/1"]
aliases: ["Objektorientierung", "Folien 08"]
semester: 1
kategorie: "Objektorientierung"
folien: "[[Material/Folien/08_Objektorientierung.pdf]]"
seiten: 23
---

# 08 Objektorientierung

← [[07 Arrays]] · [[Start|🏠 Start]] · [[09 Klassen und Objekte]] →

> [!abstract] Worum geht's?
> Grundideen der objektorientierten Softwareentwicklung: Klassifikation, Identität, Kapselung, Vererbung und Polymorphismus, inklusive eines Blicks auf Mehrfachvererbung.

**Semester:** Programmieren I · **Bereich:** #kategorie/oop · **Folien:** [[Material/Folien/08_Objektorientierung.pdf|08_Objektorientierung.pdf]] (23 Seiten)

## Gliederung der Folien
- [[Material/Folien/08_Objektorientierung.pdf#page=2|S. 2]] Objektorientierte Softwarenentwicklung
- [[Material/Folien/08_Objektorientierung.pdf#page=3|S. 3]] Eigenschaften von Objekten: Klassifikation
- [[Material/Folien/08_Objektorientierung.pdf#page=4|S. 4]] Klasse in Java: Grundlegendes
- [[Material/Folien/08_Objektorientierung.pdf#page=5|S. 5]] Klasse: Beispiel
- [[Material/Folien/08_Objektorientierung.pdf#page=6|S. 6]] Klasse: Konstruktoren
- [[Material/Folien/08_Objektorientierung.pdf#page=7|S. 7]] Eigenschaften von Objekten: Identität
- [[Material/Folien/08_Objektorientierung.pdf#page=8|S. 8]] Identität und inhaltliche Gleichheit
- [[Material/Folien/08_Objektorientierung.pdf#page=9|S. 9]] Identität: Beispiel
- [[Material/Folien/08_Objektorientierung.pdf#page=10|S. 10]] Eigenschaften von Objekten: Kapselung
- [[Material/Folien/08_Objektorientierung.pdf#page=11|S. 11]] Kapselung: Beispiel
- [[Material/Folien/08_Objektorientierung.pdf#page=13|S. 13]] Klasse: Eigenschaften und Verhalten
- [[Material/Folien/08_Objektorientierung.pdf#page=14|S. 14]] Eigenschaften von Objekten: Vererbung
- [[Material/Folien/08_Objektorientierung.pdf#page=15|S. 15]] Beispiel: Vererbung – Klassen-Deklaration
- [[Material/Folien/08_Objektorientierung.pdf#page=16|S. 16]] Beispiel: Vererbung – Objekte
- [[Material/Folien/08_Objektorientierung.pdf#page=17|S. 17]] Eigenschaften von Objekten: Polymorphismus
- [[Material/Folien/08_Objektorientierung.pdf#page=18|S. 18]] Beispiel für Überladung
- [[Material/Folien/08_Objektorientierung.pdf#page=19|S. 19]] Beispiel Polymorphismus
- [[Material/Folien/08_Objektorientierung.pdf#page=21|S. 21]] Mehrfachvererbung
- [[Material/Folien/08_Objektorientierung.pdf#page=22|S. 22]] Mehrfachvererbung in C++
- [[Material/Folien/08_Objektorientierung.pdf#page=23|S. 23]] Zusammenfassung

## Begriffe in diesem Kapitel
- [[Klasse]] (S. [[Material/Folien/08_Objektorientierung.pdf#page=3|3]], [[Material/Folien/08_Objektorientierung.pdf#page=4|4]], [[Material/Folien/08_Objektorientierung.pdf#page=5|5]], [[Material/Folien/08_Objektorientierung.pdf#page=6|6]], [[Material/Folien/08_Objektorientierung.pdf#page=13|13]], [[Material/Folien/08_Objektorientierung.pdf#page=14|14]])
- [[Objekt]] (S. [[Material/Folien/08_Objektorientierung.pdf#page=2|2]], [[Material/Folien/08_Objektorientierung.pdf#page=3|3]], [[Material/Folien/08_Objektorientierung.pdf#page=4|4]], [[Material/Folien/08_Objektorientierung.pdf#page=7|7]], [[Material/Folien/08_Objektorientierung.pdf#page=10|10]], [[Material/Folien/08_Objektorientierung.pdf#page=14|14]])
- [[Attribut]] (S. [[Material/Folien/08_Objektorientierung.pdf#page=3|3]], [[Material/Folien/08_Objektorientierung.pdf#page=4|4]], [[Material/Folien/08_Objektorientierung.pdf#page=5|5]], [[Material/Folien/08_Objektorientierung.pdf#page=6|6]], [[Material/Folien/08_Objektorientierung.pdf#page=7|7]], [[Material/Folien/08_Objektorientierung.pdf#page=8|8]])
- [[Konstruktor]] (S. [[Material/Folien/08_Objektorientierung.pdf#page=6|6]], [[Material/Folien/08_Objektorientierung.pdf#page=14|14]])
- [[Überladen]] (S. [[Material/Folien/08_Objektorientierung.pdf#page=17|17]], [[Material/Folien/08_Objektorientierung.pdf#page=18|18]])
- [[Kapselung]] (S. [[Material/Folien/08_Objektorientierung.pdf#page=2|2]], [[Material/Folien/08_Objektorientierung.pdf#page=6|6]], [[Material/Folien/08_Objektorientierung.pdf#page=10|10]], [[Material/Folien/08_Objektorientierung.pdf#page=11|11]], [[Material/Folien/08_Objektorientierung.pdf#page=12|12]], [[Material/Folien/08_Objektorientierung.pdf#page=23|23]])
- [[Vererbung]] (S. [[Material/Folien/08_Objektorientierung.pdf#page=2|2]], [[Material/Folien/08_Objektorientierung.pdf#page=14|14]], [[Material/Folien/08_Objektorientierung.pdf#page=15|15]], [[Material/Folien/08_Objektorientierung.pdf#page=16|16]], [[Material/Folien/08_Objektorientierung.pdf#page=19|19]], [[Material/Folien/08_Objektorientierung.pdf#page=23|23]])
- [[Überschreiben]]
- [[Polymorphismus]] (S. [[Material/Folien/08_Objektorientierung.pdf#page=2|2]], [[Material/Folien/08_Objektorientierung.pdf#page=17|17]], [[Material/Folien/08_Objektorientierung.pdf#page=19|19]], [[Material/Folien/08_Objektorientierung.pdf#page=20|20]], [[Material/Folien/08_Objektorientierung.pdf#page=23|23]])
- [[Mehrfachvererbung]] (S. [[Material/Folien/08_Objektorientierung.pdf#page=21|21]], [[Material/Folien/08_Objektorientierung.pdf#page=22|22]])
- [[Identität und Gleichheit]] (S. [[Material/Folien/08_Objektorientierung.pdf#page=2|2]], [[Material/Folien/08_Objektorientierung.pdf#page=7|7]], [[Material/Folien/08_Objektorientierung.pdf#page=8|8]], [[Material/Folien/08_Objektorientierung.pdf#page=9|9]], [[Material/Folien/08_Objektorientierung.pdf#page=12|12]], [[Material/Folien/08_Objektorientierung.pdf#page=23|23]])

## Relevant für diese Programmentwürfe
[[PE CHORona]] · [[PE ChatterGPT Validator]] · [[PE CoronaWarn]] · [[PE DBVasion]] · [[PE FakeTalk]] · [[PE SnatChat (Übungs-PE Oktober 2026)]] · [[PE SpeedyQuiz]] · [[PE jBay]]

## Verwandte Themen
[[09 Klassen und Objekte]] · [[13 Vererbung]] · [[21 Abstrakte Klassen und Interfaces]]

## Folien ansehen
![[Material/Folien/08_Objektorientierung.pdf]]

## Folientext (durchsuchbar)
> [!quote]- Kompletter Folientext – aufklappen
> ```text
> ── Seite 1 ──
> Programmieren I
> Überblick „Objektorientierung“
>    Heusch 12
>    Ratz 7
> 
> Institut für Automation und angewandte Informatik
> 
> KIT – Die Forschungsuniversität in der Helmholtz-Gemeinschaft www.kit.edu
> 
> ── Seite 2 ──
> Objektorientierte Softwarenentwicklung
> 
>    Was ist das grundlegende Konzept der Objektorientierung?
>    Ein Programm wird als eine Ansammlung diskreter Objekte
>    betrachten, die sowohl Daten als auch Verhalten in sich vereinen.
>    Dies steht im Gegensatz zur konventionellen Programmierung, bei
>    der Datenstruktur und Verhalten nur lose miteinander verbunden
>    sind.
>    Zentrale Eigenschaften des objektorientierten Ansatzes:
>    Klassifikation
>    Identität
>    Kapselung
>    Vererbung/Generalisierung
>    Polymorphismus (auch: Polymorphie; dt. „Vielgestaltigkeit“)
> 
> 2 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 3 ──
> Eigenschaften von Objekten: Klassifikation
> 
>    Objekte mit den gleichen Daten (Attributen) und dem
>    gleichen Verhalten (Operationen) werden zu Objekten
>    einer Klasse gruppiert.
>    Die Klasse selbst ist eine Abstraktion, welche die
>    Eigenschaften beschreibt, die für eine Anwendung wichtig
>    sind, und den Rest ignoriert. Die Wahl von Klassen ist
>    immer beliebig und hängt von der Anwendung ab.
>    Jede Klasse beschreibt eine möglicherweise unendliche
>    Menge individueller Objekte. Jedes Objekt wird als eine
>    Instanz seiner Klasse bezeichnet.
>    Jede Instanz der Klasse besitzt eigene Werte für alle ihre
>    Attribute, während sie die Attributnamen und Operationen
>    mit anderen Instanzen der Klasse teilt.
> 
> 3 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 4 ──
> Klasse in Java: Grundlegendes
> 
>    Eine Klasse besteht aus:
>    Attributen (Daten)
>    Methoden
>    Die Attribute beschreiben die Daten (Eigenschaften) eines
>    Objektes der Klasse.
>    Die Methoden beschreiben das Verhalten von Objekten
>    der Klasse.
>    Eine Klasse (class) in Java ist ein benutzerdefinierter
>    (Daten-)Typ.
>    Eine Variable, die Teil einer Klasse ist und diese
>    beschreibt, heißt Objektvariable oder Instanzvariable.
> 
> 4 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 5 ──
> Klasse: Beispiel
> 
>    Deklaration von Objektvariablen
>    und Erzeugen von Objekten
>    Deklaration der Klasse   (Instanzen) der Klasse
>    class Cat {   public static void main(String args[]) {
>    // Attribute = Daten   Cat frisky = new Cat();
>    int age;   frisky.setAge(5);
>    frisky.meow();
>    // Methoden = Verhalten
>    int getAge() {   Cat tony;
>    return age;   tony = new Cat();
>    }   tony.setAge(6);
>    tony.meow();
>    void setAge(int a) {   }
>    age = a;
>    }
> 
>    void meow() {
>    System.out.println("Meow!");
>    }
>    }
> 
> 5 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 6 ──
> Klasse: Konstruktoren
> 
> class Cat { public static void main(String args[]) {
>    // Attribute = Daten   Cat frisky = new Cat();
>    int age;   // via setter-Methode
>    frisky.setAge(5);
>    // Konstruktoren   frisky.meow();
>    Cat() {
>    }   Cat tony;
>    // via Konstruktor
>    Cat(int a) {   tony = new Cat(6);
>    age = a;   tony.meow();
>    }   }
> 
>    // Methoden = Verhalten
>    int getAge() { return age; }
>    void setAge(int a) { age = a; }
> 
>    void meow() {
>    System.out.println("Meow!");
>    }
> }
> 
> 6 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 7 ──
> Eigenschaften von Objekten: Identität
> 
>    Identität heißt, dass Daten diskrete, unterscheidbare
>    Entitäten - Objekte - zugeordnet werden. Beispiele:
>    Absatz in einem Dokument
>    Fenster auf einer Workstation
>    Figur in einem Schachspiel
>    Jedes Objekt besitzt eine eigene inhärente ("ihm
>    innewohnende") Identität.
>    Mit anderen Worten, zwei Objekte sind klar voneinander
>    unterscheidbar, selbst wenn alle ihre Attributwerte (wie
>    „Name“ oder „Größe“) identisch sind.
> 
> 7 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 8 ──
> Identität und inhaltliche Gleichheit
> 
>    Zwei (verschiedene) Objekte können also die gleichen
>    Attributwerte haben (also gleichartig „aussehen“), sich
>    dennoch in ihrer Identität unterscheiden.
>    In Java ergibt sich die Identität eines Objektes aus der
>    Position des Objektes auf dem Heap (also der
>    „Speicheradresse“), und ist daher eindeutig.
>    Die Identität zweier Objekte kann man mithilfe des
>    Gleichheits-Operators „==“ überprüfen, während man für
>    die inhaltliche Überprüfung auf Gleichheit die Methode
>    .equals(…) verwendet.
>    „==“ beantwortet also (bei Referenzdatentypen) die Frage,
>    ob es sich bei den Operanden um ein und dasselbe Objekt
>    handelt.
> 8 J. Sidler, W. Süß, T. Schlachter, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 9 ──
> Identität: Beispiel
> 
>    public static void main(String args[]) {
> 
>    Cat frisky = new Cat( 5 );
>    Cat tony = new Cat( 5 );
>    Cat leikki = frisky;
> 
>    System.out.println( frisky == tony );   // false
>    System.out.println( frisky == leikki ); // true
>    System.out.println( tony == leikki );   // false
> 
>    }
> 
>    frisky: engl. „verspielt“
>    leikkisä: finn. „verspielt“
> 
> 9 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 10 ──
> Eigenschaften von Objekten: Kapselung
> 
>    Unter Kapselung versteht man das Verbergen von Daten
>    oder Informationen vor dem Zugriff von außen.
>    Der direkte Zugriff auf interne Daten wird unterbunden und
>    erfolgt statt dessen über definierte Schnittstellen (auch
>    bekannt als „Black-Box-Modell“).
>    Mit der Kapselung ist in Java eng die Verwendung von
>    Modifikatoren verbunden.
> 
>    Heusch 12.7
>    Ratz 7.3.3
> 
> 10 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 11 ──
> Kapselung: Beispiel (1)
>    public class Fraction {
> 
>    public int numerator = 0;   // public --> Variablen nach
>    public int denominator = 1;   // außen sichtbar
> 
>    }
> 
> 11 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 12 ──
> Kapselung: Beispiel (2)
>    public class Fraction {
> 
>    private int numerator = 0;   // private --> Variablen nicht
>    private int denominator = 1; // nach außen sichtbar
> 
>    /**
>    * Setzen des Nenners (divisors). Bei Übergabe
>    * von divisor==0 wird der Nenner nicht gesetzt
>    */
>    public void setDenominator(int divisor) {
>    if (divisor != 0) {   // Fehlervermeidung
>    denominator = divisor;
>    }
>    }
> 
>    public int getDenominator() {
>    return denominator;
>    }
> 
>    }
> 
> 12 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 13 ──
> Klasse: Eigenschaften und Verhalten
>    Attribute (Eigenschaften)
> class Cat { class Dog {
>    int age;   int age;
> 
>    Cat() {   Dog() {
>    }   }
> 
>    Cat(int a) {   Dog(int a) {
>    age = a;   age = a;
>    }   }
> 
>    int getAge() { return age; }   int getAge() { return age; }
>    void setAge(int a) { age = a; }   void setAge(int a) { age = a; }
> 
>    void meow() {   void bark() {
>    System.out.println("Meow!");   System.out.println("Woof!");
>    }   }
> } }
> 
>    Methoden (Verhalten)
> 13 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 14 ──
> Eigenschaften von Objekten: Vererbung
> 
>    Es können sehr allgemeine Klassen definiert werden und
>    diese dann in immer detailliertere Unterklassen verfeinert
>    werden.
>    Jede Unterklasse übernimmt oder erbt alle Attribute
>    (Eigenschaften) und Methoden ihrer Oberklasse
>    Daneben fügt sie ihre eigenen individuellen Attribute und
>    Methoden hinzu.
> 
>    Aber: Konstruktoren werden nicht vererbt.
> 
> 14 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 15 ──
> Beispiel: Vererbung (1) - Klassen-Deklaration
>    Oberklasse
>    class Animal {
>    int age;
> 
>    Animal() { }
>    Animal(int a) { age = a; }
> 
>    int getAge() { return age; }
>    void setAge(int a) { age = a; }
>    }
> 
>    Unterklassen
> class Cat extends Animal { class Dog extends Animal {
>    void meow() {   void bark() {
>    System.out.println("Meow!");   System.out.println("Woof!");
>    }   }
> } }
> 
> 15 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 16 ──
> Beispiel: Vererbung (2) - Objekte
> 
>    Deklaration von Objektvariablen
>    und Erzeugen von Objekten der
>    Klassen Animal, Cat und Dog
> 
>    Das geht nicht:
> public static void main(String args[]){ public static void main(String args[]){
>    Cat frisky = new Cat();   Cat frisky = new Cat(5);
>    frisky.setAge(5);   Dog pluto;
>    frisky.meow();   pluto = new Dog(4);
>    Animal hugo = new Animal(4);
>    Dog pluto = new Dog();   hugo.bark();
>    pluto.setAge(5);   }
>    pluto.bark();
> 
>    Animal hugo = new Animal();
>    hugo.setAge(4);
> }
> 
> 16 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 17 ──
> Eigenschaften von Objekten: Polymorphismus
> 
>    Polymorphismus ist ein weiteres Konzept der
>    objektorientierten Software-Technologie.
>    Möglichkeit Methoden mit gleichen Namen für unterschiedliche
>    Objekte zu implementieren.
>    Das objektorientierte Softwaresystem sucht sich zur Laufzeit,
>    abhängig vom Typ des Objektes, die richtige Methode aus.
>    Überladung ist kein Polymorphismus.
>    Überladung:
>    Der Typ der Argumente entscheidet über die aufgerufene
>    Funktion/Methode. Überladung wird immer zur Übersetzungszeit
>    aufgelöst.
>    Polymorphismus:
>    Der Typ des Objekts entscheidet   Heusch 12.3.4
>    - zur Laufzeit - über die aufgerufene Methode.   Ratz 7.3.4
> 
> 17 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 18 ──
> Beispiel für Überladung
>    class Bird {
> 
>    void move() {
>    System.out.println("I fly up in the air: flutter flutter!");
>    }
> 
>    void move(String parameter) {
>    System.out.println("I fly up in the air: " + parameter);
>    }
> 
>    public static void main(String[] args) {
>    Bird b = new Bird();
>    b.move();
>    b.move("glide glide!");
>    }
>    }
> 
>    > java Bird
>    I fly up in the air: flutter flutter!
>    I fly up in the air: glide glide!
> 
> 18 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 19 ──
> Beispiel Polymorphismus (1)
>    class Bird {
>    void move(){
>    System.out.println("I fly up in the air: flutter flutter!");
>    }
>    }
> 
>    class Songbird extends Bird {
> 
>    }
> 
>    class Penguin extends Bird {
>    void move() {
>    System.out.println("I swim in the water: float float!");
>    }
>    }
> 
> 19 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 20 ──
> Beispiel Polymorphismus (2)
>    public static void main(String[] args) {
>    Bird b = new Bird();
>    b.move();
> 
>    Songbird s = new Songbird();   Ausgabe
>    s.move();   I fly up in the air: flutter flutter!
>    I fly up in the air: flutter flutter!
>    Penguin p = new Penguin();   I swim in the water: float float!
>    p.move();   I swim in the water: float float!
> 
>    Bird b2;
>    b2 = p;   // zulässig
>    b2.move();   // Polymorphismus
>    }
> 
> 20 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 21 ──
> Mehrfachvererbung
> 
>    In Java gibt es keine echte Mehrfachvererbung
>    Über Schnittstellen (Interfaces) ist eine Art
>    Mehrfachvererbung möglich
>    Das folgende Beispiel aus C++ zeigt eine mögliche
>    Mehrfachvererbung
> 
> 21 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 22 ──
> Mehrfachvererbung in C++
> 
> class Bird class Cat
> { {
> public: private:
>    void move()   int age;
>    {   public:
>    cout<<"I fly up in the air: flutter!";   int getAge();
>    };   void setAge(int a);
> }; void meow();
>    };
> 
> class FlyingCat: public Cat, public Bird int main()
> { {
> }; FlyingCat superCat;
>    superCat.setAge(5);
>    superCat.meow();
>    superCat.move();
>    return 0;
>    Objekt wird implizit bei der Deklaration erzeugt   };
> 22 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 23 ──
> Zusammenfassung
> 
>    Erläuterung der Begriffe:
>    Klassifikation
>    Identität
>    Kapselung
>    Vererbung/Generalisierung
>    Polymorphismus
>    Grober Überblick über den Klassenbegriff in Java
> 
> 23 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> ```
