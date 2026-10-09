---
tags: ["typ/uebung", "thema/interfaces", "kategorie/oop", "semester/2", "schwierigkeit/1", "hat/musterloesung"]
aliases: ["Race"]
thema: "[[21 Abstrakte Klassen und Interfaces]]"
klasse: "Race"
package: "de.dhbwka.java.exercise.classes.abstr"
schwierigkeit: 1
status: "offen"
---

# Ü21 Fahrzeuge, Wettrennen (2)

**Thema:** [[21 Abstrakte Klassen und Interfaces]] · **Bereich:** Abstrakte Klassen · **Schwierigkeit:** ★☆☆☆☆
**Klasse:** `Race` · **Package:** `de.dhbwka.java.exercise.classes.abstr`

📄 Aufgabe: [[Material/Aufgaben/21_Abstrakte_Klassen_Aufgaben.pdf#page=1|21_Abstrakte_Klassen_Aufgaben.pdf, S. 1]]
✅ Musterlösung: [[Material/Aufgaben/21_Abstrakte_Klassen_Aufgaben_Muster.pdf#page=1|21_Abstrakte_Klassen_Aufgaben_Muster.pdf, S. 1]]

> [!question] Kurz gesagt
> Erweitern Sie die Aufgabe „Fahrzeuge, Wettrennen“ (aus dem Aufgabenblatt „Vererbung (1)“) im Folgenden um eine Methode info(), welche den Zustand des Fahrzeugs inklusive aller Besonderheiten (z.B. Anzahl der Räder, Blaulicht an oder aus) auf der Konsole (System.out) ausgeben soll.

## Aufgabenstellung
```text
Erweitern Sie die Aufgabe „Fahrzeuge, Wettrennen“ (aus dem Aufgabenblatt „Vererbung (1)“) im
Folgenden um eine Methode info(), welche den Zustand des Fahrzeugs inklusive aller
Besonderheiten (z.B. Anzahl der Räder, Blaulicht an oder aus) auf der Konsole (System.out)
ausgeben soll.

Erweitern Sie Ihre Lösung zunächst so, dass die Klasse Vehicle als abstract definiert wird.
Wenden Sie wo es sinnvoll ist den Modifier abstract auch auf die Methoden der Klasse an, insb.
die Methode info().

Hinweis:
Erzeugen Sie ein neues Package, s.o., um die bisherigen Lösungen nicht zu überschreiben.
Kopieren Sie die „alten“ Klassen in dieses neue Package hinein!
```

## Benötigte Begriffe
[[Konstruktor]] · [[this]] · [[toString]] · [[Kapselung]] · [[Sichtbarkeitsmodifikatoren]] · [[Vererbung]] · [[Überschreiben]] · [[super]] · [[Abstrakte Klasse]]

## Gleiche Klasse in anderen Übungen (Fortsetzung/Variante)
[[Ü13 Fahrzeuge, Wettrennen]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> Nur die Änderungen gegenüber der Original-Lösung (nur 3 Klassen sind betroffen):
> 
> package de.dhbwka.java.exercise.classes.abstr;
> 
> public abstract class Vehicle {
> 
>     private int wheels;
>     private double speed;
>     private double maxSpeed;
>     private double position;
> 
>     public Vehicle() {
>         this( 0.0 );
>     }
> 
>     public Vehicle( double speed ) {
>         this( 0, speed, 0.0, 0.0 );
>     }
> 
>     protected Vehicle( int wheels, double speed, double maxSpeed,
>     double position ) {
>         this.setWheels( wheels );
>         this.setMaxSpeed( maxSpeed );
>         this.setSpeed( speed ); // after setMaxSpeed!
>         this.setPosition( position );
>     }
> 
>     public abstract void info(); // just the definition, no implementation
> 
>     // further methods ...
> }
> 
> Hinweis:
> Die Konstruktoren bleiben stehen, da sie in den Unterklassen per super(…) verwendet werden.
> 
> package de.dhbwka.java.exercise.classes.abstr;
> 
> public class Car extends Vehicle {
> 
>     // constructors ...
> 
>     @Override
>     public void info() {
>         System.out.println( this.toString() );
>     }
> 
> }
> 
> package de.dhbwka.java.exercise.classes.abstr;
> 
> public class Bicycle extends Vehicle {
> 
>     // constructors ...
> 
>     @Override
>     public void info() {
>         System.out.println( this.toString() );
>     }
> 
> }
> ```

## Meine Notizen

