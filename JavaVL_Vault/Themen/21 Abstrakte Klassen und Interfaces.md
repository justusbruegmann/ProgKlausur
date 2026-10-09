---
tags: ["typ/thema", "thema/interfaces", "kategorie/oop", "semester/2"]
aliases: ["Abstrakte Klassen und Interfaces", "Folien 21"]
semester: 2
kategorie: "Objektorientierung"
folien: "[[Material/Folien/21_Abstrakte_Klassen_Interfaces.pdf]]"
seiten: 20
---

# 21 Abstrakte Klassen und Interfaces

← [[20 Grafische Oberflächen mit Swing]] · [[Start|🏠 Start]] · [[22 Innere Klassen]] →

> [!abstract] Worum geht's?
> Abstrakte Klassen und Interfaces im Vergleich, Interface-Erweiterungen in Java 8 sowie Komposition, Aggregation und Delegation als Alternativen zur Vererbung.

**Semester:** Programmieren II · **Bereich:** #kategorie/oop · **Folien:** [[Material/Folien/21_Abstrakte_Klassen_Interfaces.pdf|21_Abstrakte_Klassen_Interfaces.pdf]] (20 Seiten)

## Gliederung der Folien
- [[Material/Folien/21_Abstrakte_Klassen_Interfaces.pdf#page=2|S. 2]] Abstrakte Klassen: Motivation
- [[Material/Folien/21_Abstrakte_Klassen_Interfaces.pdf#page=3|S. 3]] Abstrakte Klassen: Definition
- [[Material/Folien/21_Abstrakte_Klassen_Interfaces.pdf#page=4|S. 4]] Abstrakte Klassen: Beispiel
- [[Material/Folien/21_Abstrakte_Klassen_Interfaces.pdf#page=8|S. 8]] Interfaces: Konzept
- [[Material/Folien/21_Abstrakte_Klassen_Interfaces.pdf#page=9|S. 9]] Interfaces: Beispiel
- [[Material/Folien/21_Abstrakte_Klassen_Interfaces.pdf#page=13|S. 13]] Abstrakte Klassen und Interfaces: Vergleich
- [[Material/Folien/21_Abstrakte_Klassen_Interfaces.pdf#page=14|S. 14]] Erweiterungen, die zu Interfaces in Java 8
- [[Material/Folien/21_Abstrakte_Klassen_Interfaces.pdf#page=16|S. 16]] © Monty Python‘s Flying Circus
- [[Material/Folien/21_Abstrakte_Klassen_Interfaces.pdf#page=17|S. 17]] Subobjekt, Komposition, Aggregation, Delegation
- [[Material/Folien/21_Abstrakte_Klassen_Interfaces.pdf#page=18|S. 18]] Subobjekte/Komposition
- [[Material/Folien/21_Abstrakte_Klassen_Interfaces.pdf#page=20|S. 20]] Subobjekte: Delegation

## Begriffe in diesem Kapitel
- [[Mehrfachvererbung]] (S. [[Material/Folien/21_Abstrakte_Klassen_Interfaces.pdf#page=8|8]], [[Material/Folien/21_Abstrakte_Klassen_Interfaces.pdf#page=14|14]])
- [[Abstrakte Klasse]] (S. [[Material/Folien/21_Abstrakte_Klassen_Interfaces.pdf#page=2|2]], [[Material/Folien/21_Abstrakte_Klassen_Interfaces.pdf#page=3|3]], [[Material/Folien/21_Abstrakte_Klassen_Interfaces.pdf#page=4|4]], [[Material/Folien/21_Abstrakte_Klassen_Interfaces.pdf#page=5|5]], [[Material/Folien/21_Abstrakte_Klassen_Interfaces.pdf#page=6|6]], [[Material/Folien/21_Abstrakte_Klassen_Interfaces.pdf#page=7|7]])
- [[Interface]] (S. [[Material/Folien/21_Abstrakte_Klassen_Interfaces.pdf#page=8|8]], [[Material/Folien/21_Abstrakte_Klassen_Interfaces.pdf#page=9|9]], [[Material/Folien/21_Abstrakte_Klassen_Interfaces.pdf#page=10|10]], [[Material/Folien/21_Abstrakte_Klassen_Interfaces.pdf#page=11|11]], [[Material/Folien/21_Abstrakte_Klassen_Interfaces.pdf#page=12|12]], [[Material/Folien/21_Abstrakte_Klassen_Interfaces.pdf#page=13|13]])
- [[Default-Methode]] (S. [[Material/Folien/21_Abstrakte_Klassen_Interfaces.pdf#page=14|14]], [[Material/Folien/21_Abstrakte_Klassen_Interfaces.pdf#page=15|15]])
- [[Komposition und Delegation]] (S. [[Material/Folien/21_Abstrakte_Klassen_Interfaces.pdf#page=17|17]], [[Material/Folien/21_Abstrakte_Klassen_Interfaces.pdf#page=18|18]], [[Material/Folien/21_Abstrakte_Klassen_Interfaces.pdf#page=19|19]], [[Material/Folien/21_Abstrakte_Klassen_Interfaces.pdf#page=20|20]])

## Kommt hier auch vor
[[Vererbung]] · [[Polymorphismus]] · [[Zeichnen mit Graphics]]

## Übungen
- [ ] [[Ü21 Fahrzeuge, Wettrennen (2)]] ★☆☆☆☆ ✅ Musterlösung

## Relevant für diese Programmentwürfe
[[PE CHORona]] · [[PE ChatterGPT Validator]] · [[PE CoronaWarn]] · [[PE FakeTalk]] · [[PE SnatChat (Übungs-PE Oktober 2026)]] · [[PE SpeedyQuiz]]

## Verwandte Themen
[[13 Vererbung]] · [[22 Innere Klassen]] · [[23 Events]] · [[33 Java 8 – Lambdas, Streams, NIO.2]]

## Folien ansehen
![[Material/Folien/21_Abstrakte_Klassen_Interfaces.pdf]]

## Folientext (durchsuchbar)
> [!quote]- Kompletter Folientext – aufklappen
> ```text
> ── Seite 1 ──
> Programmieren II
> Abstrakte Klassen, Interfaces
>    Heusch 13.8, 13.9
>    Ratz 9.6
> 
> Institut für Automation und angewandte Informatik
> 
> KIT – Die Forschungsuniversität in der Helmholtz-Gemeinschaft www.kit.edu
> 
> ── Seite 2 ──
> Abstrakte Klassen: Motivation
> 
>    Prinzip der Vererbung:
>    Aus existierenden Klassen können spezialisierte Klassen abgeleitet
>    werden
>    Prinzip der abstrakten Klassen:
>    Aus mehreren ähnlichen Klassen kann eine gemeinsame
>    Oberklasse abstrahiert werden
>    Sinn und Zweck: Ausnutzung der Polymorphie!
>    public class Rectangle {   public class Line {
>    void draw() { /* ... */ }   void draw() { /* ... */ }
>    // ...   // ...
>    }   }
> 
>    public class Circle {   public abstract class Graphic {
>    void draw() { /* ... */ }   abstract void draw();
>    // ...   }
>    }
> 
> 2 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 3 ──
> Abstrakte Klassen: Definition
> 
>    Konzept : Abstrakte Klasse
>    Eine abstrakte Klasse ist eine bewusst unvollständige Oberklasse,
>    in der von einzelnen Methodenimplementierungen abstrahiert wird
>    („abstrakte“ Methoden!)
>    Fehlende Methodenrümpfe werden erst in abgeleiteten
>    Unterklassen implementiert
>    Die Instanziierung abstrakter Klassen ist nicht möglich
>    Modifikator (modifier): Java-Schlüsselwort abstract
> 
>    public abstract class Graphic {
>    abstract void draw(); // Kein Methodenrumpf!
>    }
> 
> 3 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 4 ──
> Abstrakte Klassen: Beispiel (1)
>    public abstract class Graphic {
>    String name;
> 
>    public String getName() {
>    return this.name;
>    }
> 
>    abstract void draw(); // nur Methodendeklaration
>    }   // ohne Methodenrumpf { ... }
> 
>    public class Rectangle extends Graphic {
>    float width, height;
> 
>    public Rectangle(String str, float w, float h) {
>    this.name = str;
>    this.width = w;
>    this.height = h;
>    }
>    // geerbt: getName - ist bereits in Graphic implementiert
> 
>    void draw() {   // wird erst hier implementiert
>    System.out.println("Rectangle: " + this.name);
>    }
>    // weitere Methoden...
>    }
> 
> 4 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 5 ──
> Abstrakte Klassen: Beispiel (2)
>    public class Circle extends Graphic {
>    private float radius;
> 
>    public Circle(String str, float r) {
>    this.name = str;
>    this.radius = r;
>    }
>    // geerbt: getName weitere Methoden ...
>    // implementiert:
>    void draw() {
>    System.out.println("Circle: " + this.name + this.radius);
>    }
>    }
>    public class Line extends Graphic {
>    // ...
>    // implementiert:
>    void draw() {
>    System.out.println("Line: " + this.name);
>    }
>    }
> 
> 5 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 6 ──
> Abstrakte Klassen: Beispiel (3)
>    public class GraphicColl {   // Zur Speicherung einer Menge
>    // von Graphic-Objekten
>    private Graphic[] elems;
>    private int next;
> 
>    public GraphicColl(int size) {
>    this.elems = new Graphic[size];
>    this.next = 0;
>    }
> 
>    public void add(Graphic obj) {
>    if (this.next < this.elems.length){
>    this.elems[this.next++] = obj;
>    }
>    }
> 
>    public Graphic[] get() {
>    return this.elems;
>    }
>    }
> 
> 6 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 7 ──
> Abstrakte Klassen: Beispiel (4)
>    public class Probe {
>    public static void main(String[] args) {
>    Rectangle r1 = new Rectangle("Rectangle 1", 10, 20);
>    Circle c1 = new Circle("Circle 1", 50);
>    Line l1 = new Line("Line 1");
>    Rectangle r2 = new Rectangle("Rectangle 2", 15, 15);
>    Graphic g1 = new Graphic("Graphic 1"); // Fehlermeldung!
>    // "Cannot instantiate the type Graphic"
>    GraphicColl coll = new GraphicColl(6);
>    coll.add(r1);
>    coll.add(r2);
>    coll.add(c1);
>    coll.add(l1);
> 
>    Graphic[] elements = coll.get();
>    for (int i = 0; i < elements.length; i++)
>    if (elements[i] != null)
>    elements[i].draw(); // Polymorphie
>    }
>    }
> 
> 7 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 8 ──
> Interfaces: Konzept
> 
>    Interfaces dienen dazu, gleiche Schnittstellen in unter-
>    schiedlichen Klassen zu definieren
>    Ein Interface ist eine Art Klasse (ist aber keine Klasse), die
>    ausschließlich Konstanten und abstrakte Instanzmethoden
>    deklariert
>    Java-Schlüsselwörter interface und implements
>    Von Interfaces können mit new keine Instanzen erstellt werden.
>    Es kann aber als „Variablen-/Referenzen-Typ“ verwendet werden
>    Sinn: Ersatz für in Java nicht mögliche Mehrfachvererbung
>    public interface Graphic {
>    public void draw(); // Methodenrumpf nicht erlaubt!
>    }
>    public class Line implements Graphic {
>    public void draw() {
>    System.out.println(".....");
>    }
>    }
> 
> 8 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 9 ──
> Interfaces: Beispiel (1)
>    public interface LandVehicle {
>    public void drive(); // kein Methodenrumpf!
>    }
> 
>    public interface Watercraft {
>    public void swim(); // kein Methodenrumpf!
>    }
> 
>    public class Vehicle {
>    private Motor m;
>    // ...
>    }
> 
>    public class Car extends Vehicle implements LandVehicle {
>    public void drive() {
>    // Implementierung der Methode
>    }
>    }
> 
> 9 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 10 ──
> Interfaces: Beispiel (2)
>    public interface LandVehicle {
>    public void drive(); // kein Methodenrumpf!
>    }
> 
>    public interface Watercraft {
>    public void swim(); // kein Methodenrumpf!
>    }
> 
>    public class Vehicle {
>    private Motor m;
>    // ...
>    }
> 
>    public class MotorBoat extends Vehicle implements Watercraft {
>    public void swim() {
>    // Implementierung der Methode
>    }
>    }
> 
> 10 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 11 ──
> Interfaces: Beispiel (3)
>    public interface LandVehicle {
>    public void drive(); // kein Methodenrumpf!
>    }
> 
>    public interface Watercraft {
>    public void swim(); // kein Methodenrumpf!
>    }
> 
>    public class Vehicle {
>    private Motor m;
>    // ...
>    }
> 
>    public class AmphibiousVehicle
>    extends Vehicle implements LandVehicle, Watercraft {
> 
>    public void drive() { /* Implementierung der Methode */ }
> 
>    public void swim() { /* Implementierung der Methode */ }
>    }
> 
> 11 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 12 ──
> Interfaces: Beispiel (4)
> 
>    <type> x = new AmphibiousVehicle();
> 
>    Was darf hier für <type> stehen?
> 
> 12 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 13 ──
> Abstrakte Klassen und Interfaces: Vergleich
> 
>    Abstrakte Klassen:
>    abgeleiteten Klassen soll bereits ein bestimmtes Grundverhalten
>    zur Verfügung gestellt werden (➔ Vererbung)
>    (Einfach-)Polymorphie
> 
>    Interfaces:
>    ausschließliche Definition des Protokolls („Methodenköpfe“),
>    keine Implementierung erlaubt
>    (Mehrfach-)Polymorphie
> 
>    Bis Java 1.7
> 13 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 14 ──
> Erweiterungen, die zu Interfaces in Java 8
>    eingeführt wurden (1)
> 
>    Statische Methoden in Interfaces
>    Mit Java 8 ist es möglich, auch statische Methoden in Interfaces zu
>    implementieren.
> 
>    Default-Methoden
>    Bisher mussten Methoden in Interfaces abstrakt sein. Eine
>    Implementierung (Rumpf) konnten sie nicht haben.
>    Nun kann in einem Interface mittels einer Default-Methode auch eine
>    Methode mit Implementierung zur Verfügung gestellt werden.
>    Java-Schlüsselwort: default
>    Diese Methoden werden dann auch wie üblich vererbt.
>    Dadurch ist auch eine Mehrfachvererbung von Funktionalität möglich.
> 
>    Ab Java 1.8
> 14 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 15 ──
> Erweiterungen, die zu Interfaces in Java 8
>    eingeführt wurden (2)
>    public interface InterfaceA {
> 
>    default void methodA() {
>    System.out.println("Invoked <InterfaceA>.methodA()");
>    }
> 
>    }
> 
>    public class ClassA implements InterfaceA {
> 
>    public static void main(String[] args) {
>    ClassA cl = new ClassA();
>    cl.methodA();
>    }
> 
>    }
> 
>    Ausgabe
>    Invoked <InterfaceA>.methodA()   Ab Java 1.8
> 15 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 16 ──
> © Monty Python‘s Flying Circus
> 
> 16 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 17 ──
> Subobjekt, Komposition, Aggregation, Delegation
> 
>    Definitionen
>    Subobjekt
>    ein Attribut vom Typ einer Klasse
>    Komposition
>    Zusammensetzung eines Objektes aus mehreren Subobjekten
>    „part-of-Beziehung“ (z.B. Bestandteile eines Autos)
>    (Vererbung: „is-a-Beziehung“)
>    Aggregation
>    Loser Verbund von Subobjekten (z.B. Vögel in einem Schwarm)
>    Subobjekte haben ihre eigene Identität
>    Delegation
>    Prinzip der Implementierung einer Methode durch Weiterreichen
>    eines Methodenaufrufs an ein Subobjekt
> 17 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 18 ──
> Subobjekte/Komposition (1)
>    public class Brain {
>    public void remember(Object info) { /* ... */ }
> 
>    public Object think() { /* ... */ }
>    }
> 
>    public class Heart {
>    public void beat(int count) { /* ... */ }
>    }
> 
>    public class Arm {
>    public void bend(double degrees) { /* ... */ }
> 
>    public void lift(Object load) { /* ... */ }
>    }
> 
> 18 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 19 ──
> Subobjekte/Komposition (2)
>    public class Human {
>    Brain brain; // Subobjekt
>    Heart heart; // Subobjekt
>    Arm[] arms; // mehrere Subobjekte (in Array)
> 
>    public Human() {
>    this.brain = new Brain();
>    this.heart = new Heart();
>    this.arms = new Arm[2];
>    this.arms[0] = new Arm();
>    this.arms[1] = new Arm();
>    }
> 
>    public Object think() {
>    return this.brain.think();
>    }
> 
>    public void doSports() {
>    this.heart.beat(180);
>    }
> 
>    public void sleep() {
>    this.heart.beat(50);
>    }
>    }
> 
> 19 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 20 ──
> Subobjekte: Delegation
>    public class LandVehicle {   public class Watercraft {
>    public void drive() {   public void swim() {
>    // ...   // ...
>    }   }
>    }   }
> 
>    public class AmphibiousVehicle {
>    LandVehicle land;   // Subobjekte
>    Watercraft water;
>    // ...
> 
>    public void drive() {
>    this.land.drive(); // Delegation
>    }
> 
>    public void swim() {
>    this.water.swim(); // Delegation
>    }
>    }   Hier gibt es keine Vererbung!
> 20 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> ```
