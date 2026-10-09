---
tags: ["typ/uebung", "thema/klassen", "kategorie/oop", "semester/1", "schwierigkeit/2", "hat/musterloesung"]
aliases: ["Point"]
thema: "[[09 Klassen und Objekte]]"
klasse: "Point"
package: "de.dhbwka.java.exercise.classes"
schwierigkeit: 2
status: "offen"
---

# Ü09 Zweidimensionaler Punkt

**Thema:** [[09 Klassen und Objekte]] · **Bereich:** Klassen (1) · **Schwierigkeit:** ★★☆☆☆
**Klasse:** `Point` · **Package:** `de.dhbwka.java.exercise.classes`

📄 Aufgabe: [[Material/Aufgaben/09_Klassen_Aufgaben-1.pdf#page=3|09_Klassen_Aufgaben-1.pdf, S. 3]]
✅ Musterlösung: [[Material/Aufgaben/09_Klassen_Aufgaben-1_Muster.pdf#page=3|09_Klassen_Aufgaben-1_Muster.pdf, S. 3]]

> [!question] Kurz gesagt
> Die Klasse Point soll einen Punkt in einem zweidimensionalen Koordinatensystem repräsentieren. Ein Punkt besteht aus folgenden Komponenten:  X-Koordinate  Y-Koordinate a) Legen sie die Attribute dieser Klasse fest! b) Schreiben Sie sinnvolle Konstruktoren für die Klasse! c) Erzeugen Sie getter- und setter-Methoden für die Attribute und setzen Sie die Modifikatoren für Methoden und Attribute so, …

## Aufgabenstellung
```text
Die Klasse Point soll einen Punkt in einem zweidimensionalen Koordinatensystem repräsentieren.
Ein Punkt besteht aus folgenden Komponenten:
     X-Koordinate
     Y-Koordinate

a) Legen sie die Attribute dieser Klasse fest!

b) Schreiben Sie sinnvolle Konstruktoren für die Klasse!

c) Erzeugen Sie getter- und setter-Methoden für die Attribute und setzen Sie die
   Modifikatoren für Methoden und Attribute so, dass das Prinzip der Kapselung für die Attribute
   gilt, d.h. auf die Attribute soll von außerhalb der Klasse Punkt nur über die getter- bzw.
   setter-Methoden zugegriffen werden können!

d) Schreiben Sie Methoden mit dem folgenden Verhalten zu dieser Klasse:
    public String toString()
    Abstand des Punktes zum Ursprung
    Spiegelung des Punktes an der X-Achse (Ergebnis soll ein neuer Punkt sein!)
    Spiegelung des Punktes an der Y-Achse (Ergebnis soll ein neuer Punkt sein!)
    Spiegelung des Punktes am Ursprung (Ergebnis soll ein neuer Punkt sein!)
    Abstand des Punktes zu einem anderen Punkt.

e) Schreiben Sie ein Hauptprogramm, das alle Methoden ausgiebig testet!

Hinweise:
    Wählen Sie „sprechende“ Namen für Ihre Methoden!
    Der Typ des Rückgabewertes einer Methode kann auch ein Referenztyp sein und deshalb
       auch vom Typ Point.

Beispiel für eine Testmethode:
public static void main(String[] args) {
    Point pointA = new Point(4.0, 2.0);
    System.out.println("A: " + pointA);
    Point pointB = new Point(-1.0, -1.0);
    System.out.println("B: " + pointB);
    System.out.println("Abstand A-B: "
            + pointA.getDistance(pointB));
    pointA = pointA.mirrorOrigin();
    System.out.println("A': " + pointA);
    System.out.println("Abstand A’-B: "
            + pointA.getDistance(pointB));
}

Zugehörige Ausgabe:
A: Punkt (4.0,2.0)
B: Punkt (-1.0,-1.0)
Abstand A-B: 5.830951894845301
A': Punkt (-4.0,-2.0)
Abstand A‘-B: 3.1622776601683795
```

## Benötigte Begriffe
[[Math-Klasse]] · [[Mehrdimensionales Array]] · [[Konstruktor]] · [[this]] · [[toString]] · [[Kapselung]] · [[Überschreiben]] · [[super]]

## Weitere Übungen zum Thema
[[Ü09 Radio]] · [[Ü09 Bankkonto]] · [[Ü09 Polynom 2. Grades]] · [[Ü09 Komplexe Zahlen]] · [[Ü09 Polynome und Horner-Schema]] · [[Ü09 Nimmspiel]] · [[Ü09 Lotto]] · [[Ü09 MasterMind]] · [[Ü09 Wechselspiel (1. Teil)]] · [[Ü09 Wechselspiel (2. Teil)]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.classes;
> 
> public class Point {
> 
>     // Attributes (encapsulated)
>     private double x, y;
> 
>     /**
>      * Constructs and initializes a point at the origin (0, 0) of the coordinate
>      * space.
>      */
>     public Point() {
>         this(0.0, 0.0);
>     }
> 
>     /**
>      * Constructs and initializes a point at the specified (x,y) location in the
>      * coordinate space.
>      *
>      * @param x x coordinate
>      * @param y y coordinate
>      */
>     public Point(double x, double y) {
>         super();
>         this.x = x;
>         this.y = y;
>     }
> 
>     /**
>      * Returns the x coordinate of this Point.
>      *
>      * @return x coordinate of this Point
>      */
>     public double getX() {
>         return x;
>     }
> 
>     /**
>      * Sets the x coordinate of this Point to the specified value.
> 
>      *
>      * @param x x coordinate
>      */
>     public void setX(double x) {
>         this.x = x;
>     }
> 
>     /**
>      * Returns the y coordinate of this Point.
>      *
>      * @return y coordinate of this Point
>      */
>     public double getY() {
>         return y;
>     }
> 
>     /**
>      * Sets the y coordinate of this Point to the specified value.
>      *
>      * @param y y coordinate
>      */
>     public void setY(double y) {
>         this.y = y;
>     }
> 
>     /**
>      * Returns a new Point with the coordinates of this Point mirrored (flipped)
>      * at the x axis.
>      *
>      * @return the resulting Point
>      */
>     public Point mirrorXAxis() {
>         return new Point(x, -y);
>     }
> 
>     /**
>      * Returns a new Point with the coordinates of this Point mirrored (flipped)
>      * at the y axis.
>      *
>      * @return the resulting Point
>      */
>     public Point mirrorYAxis() {
>         return new Point(-x, y);
>     }
> 
>     /**
>      * Returns a new Point with the coordinates of this Point mirrored (flipped)
>      * at the origin (0, 0) of the coordinate space.
>      *
>      * @return the resulting Point
>      */
>     public Point mirrorOrigin() {
>         return new Point(-x, -y);
>     }
> 
>     /**
>      * Returns the distance of this Point from the Point given.
>      *
> 
>      * @param p the Point of which the distance from this Point shall be
>      * calculated
>      * @return distance of this Point from the the origin (0, 0)
>      */
>     public double getDistance(Point p) {
>         double dx = x - p.x;
>         double dy = y - p.y;
>         return Math.sqrt(dx * dx + dy * dy);
>     }
> 
>     /**
>      * Returns the distance of this Point from the the origin (0, 0).
>      */
>     public double getMagnitude() {
>         return getDistance(new Point(0.0, 0.0));
>     }
> 
>     /**
>      * Returns a string representation of this Point.
>      *
>      * @return string representation of this Point
>      */
>     @Override
>     public String toString() {
>         return "Punkt (" + x + "," + y + ")";
>     }
> 
>     /**
>      * main method, only for test purposes of class Point.
>      *
>      * @param args start parameters (not used)
>      */
>     public static void main(String[] args) {
>         Point pointA = new Point(4.0, 2.0);
>         System.out.println("A: " + pointA);
>         System.out.println("Betrag: " + pointA.getMagnitude());
>         Point pointB = new Point(-1.0, -1.0);
>         System.out.println("B: " + pointB);
>         System.out.println("Abstand: "
>         + pointA.getDistance(pointB));
>         pointA = pointA.mirrorOrigin();
>         System.out.println("A': " + pointA);
>         System.out.println("Abstand: "
>         + pointA.getDistance(pointB));
>     }
> 
> }
> ```

## Meine Notizen

