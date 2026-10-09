---
tags: ["typ/uebung", "thema/datentypen", "kategorie/grundlagen", "semester/1", "schwierigkeit/1", "hat/musterloesung"]
aliases: ["Round"]
thema: "[[04 Primitive Datentypen]]"
klasse: "Round"
package: "de.dhbwka.java.exercise.datatypes"
schwierigkeit: 1
status: "offen"
---

# Ü04 Kaufmännisches Runden (1)

**Thema:** [[04 Primitive Datentypen]] · **Bereich:** Primitive Datentypen · **Schwierigkeit:** ★☆☆☆☆
**Klasse:** `Round` · **Package:** `de.dhbwka.java.exercise.datatypes`

📄 Aufgabe: [[Material/Aufgaben/04_Primitive_Datentypen_Aufgaben.pdf#page=2|04_Primitive_Datentypen_Aufgaben.pdf, S. 2]]
✅ Musterlösung: [[Material/Aufgaben/04_Primitive_Datentypen_Aufgaben_Muster.pdf#page=3|04_Primitive_Datentypen_Aufgaben_Muster.pdf, S. 3]]

> [!question] Kurz gesagt
> Das „Casten“ (dt. die Typumwandlung) von Gleitkommazahlen in ganze Zahlen bedeutet im Allgemeinen einen Informationsverlust, denn die Nachkommastellen werden abgeschnitten, z.B. erfolgt im folgenden Programmstück die Ausgabe von 3 bzw. 2 für die ganzzahligen Varianten von Pi bzw. e. double pi \= 3.1415926; // Naeherung der Kreiszahl Pi double e \= 2.7182818; // Naeherung der Eulerschen Zahl e

## Aufgabenstellung
```text
Das „Casten“ (dt. die Typumwandlung) von Gleitkommazahlen in ganze Zahlen bedeutet im
Allgemeinen einen Informationsverlust, denn die Nachkommastellen werden abgeschnitten, z.B.
erfolgt im folgenden Programmstück die Ausgabe von 3 bzw. 2 für die ganzzahligen Varianten von Pi
bzw. e.

        double pi = 3.1415926;        // Naeherung der Kreiszahl Pi
        double e = 2.7182818;         // Naeherung der Eulerschen Zahl e

        int piInt = (int) pi;
        int eInt = (int) e;

        System.out.println("Pi ganzzahlig: " + piInt); // Ausgabe: 3
        System.out.println("e ganzzahlig: " + eInt); // Ausgabe: 2

Mit anderen Worten: Nachkommastellen werden immer abgeschnitten bzw. es wird unabhängig
vom Wert der Nachkommastellen immer abgerundet.

Schreiben Sie ein Programm Round, welches das obige Programm-Fragment so abändert, dass die
Zahlen Pi bzw. e kaufmännisch gerundet werden, d.h. wenn der Nachkommawert >= 0.5 ist wird
aufgerundet, ansonsten abgerundet!
```

## Benötigte Begriffe
[[Typkonversion]] · [[Bedingungsoperator]]

## Gleiche Klasse in anderen Übungen (Fortsetzung/Variante)
[[Ü05 Kaufmännisches Runden (2)]]

## Weitere Übungen zum Thema
[[Ü04 Überlauf, Zweierkomplement]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.datatypes;
> 
> public class Round {
>     public static void main(String[] args) {
>         double pi = 3.1415926; // Naeherung der Kreiszahl Pi
>         double e = 2.7182818; // Naeherung der Eulerschen Zahl e
>         // Positive Zahlen
>         System.out.println("Runden positiver Zahlen");
>         int piInt = (int) (pi + 0.5);
>         int eInt = (int) (e + 0.5);
>         System.out.println("Pi ganzzahlig: " + piInt); // Ausgabe: 3
>         System.out.println("e ganzzahlig: " + eInt);    // Ausgabe: 3
> 
>         // Naiver Versuch mit negativen Zahlen:
>         System.out.println("Runden negativer Zahlen (fehlerhaft)");
>         pi = -pi;
>         e = -e;
>         piInt = (int) (pi + 0.5);
>         eInt = (int) (e + 0.5);
>         System.out.println("-Pi ganzzahlig: " + piInt); // Ausgabe: -2
>         System.out.println("-e ganzzahlig: " + eInt);   // Ausgabe: -2
> 
>         // So klappt es negativ wie positiv
>         System.out.println("Runden pos. und negativer Zahlen (korrekt)");
>         // pi und e sind noch negativ
>         piInt = (int) (pi + ( (pi>0) ? 0.5 : -0.5));
>         eInt = (int) (e + ( (e>0) ? 0.5 : -0.5));
>         System.out.println("-Pi ganzzahlig: " + piInt); // Ausgabe: -3
>         System.out.println("-e ganzzahlig: " + eInt);   // Ausgabe: -3
>         // pi und e sind positiv machen
>         pi = -pi;
>         e = -e;
>         piInt = (int) (pi + ( (pi>0) ? 0.5 : -0.5));
>         eInt = (int) (e + ( (e>0) ? 0.5 : -0.5));
>         System.out.println("Pi ganzzahlig: " + piInt); // Ausgabe: 3
>         System.out.println("e ganzzahlig: " + eInt);    // Ausgabe: 3
>     }
> }
> ```

## Meine Notizen

