---
tags: ["typ/uebung", "thema/arrays", "kategorie/grundlagen", "semester/1", "schwierigkeit/1", "hat/musterloesung"]
aliases: ["Norm"]
thema: "[[07 Arrays]]"
klasse: "Norm"
package: "de.dhbwka.java.exercise.arrays"
schwierigkeit: 1
status: "offen"
---

# Ü07 Betrag eines Vektors

**Thema:** [[07 Arrays]] · **Bereich:** Arrays (eindimensional) · **Schwierigkeit:** ★☆☆☆☆
**Klasse:** `Norm` · **Package:** `de.dhbwka.java.exercise.arrays`

📄 Aufgabe: [[Material/Aufgaben/07_Arrays_Aufgaben-1.pdf#page=4|07_Arrays_Aufgaben-1.pdf, S. 4]]
✅ Musterlösung: [[Material/Aufgaben/07_Arrays_Aufgaben-1_Muster.pdf#page=4|07_Arrays_Aufgaben-1_Muster.pdf, S. 4]]

> [!question] Kurz gesagt
> Der Betrag eines Vektors x \= (x1, x2, ..., xn) ist definiert als x1  x1  x2  x2    xn  xn Erstellen Sie ein Programm Norm, das einen Vektor mit n Komponenten in ein Array einliest, den Betrag des Vektors berechnet und das Ergebnis ausgibt! Lesen Sie zunächst n ein!

## Aufgabenstellung
```text
Der Betrag eines Vektors x = (x1, x2, ..., xn) ist definiert als

                                         x1  x1  x2  x2    xn  xn

Erstellen Sie ein Programm Norm, das einen Vektor mit n Komponenten in ein Array einliest, den
Betrag des Vektors berechnet und das Ergebnis ausgibt!
Lesen Sie zunächst n ein!

Beispielausgabe:

Bitte Anzahl der Elemente n eingeben: 3
Bitte x_0 eingeben: 1
Bitte x_1 eingeben: 2
Bitte x_2 eingeben: 4
Der Betrag von x ist 4.58257569495584
```

## Benötigte Begriffe
[[Scanner]] · [[Math-Klasse]] · [[for-Schleife]] · [[Array]]

## Weitere Übungen zum Thema
[[Ü07 Mittelwert und Standardabweichung]] · [[Ü07 Fibonacci-Folge]] · [[Ü07 Sieb des Eratostenes]] · [[Ü07 Skalarprodukt zweier Vektoren]] · [[Ü07 Sortieren mit Bubblesort]] · [[Ü07 Subtraktion zweier Matrizen]] · [[Ü07 Pascalsches Dreieck]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.arrays;
> 
> import java.util.Scanner;
> 
> public class Norm {
> 
>     public static void main(String[] args) {
>         Scanner scan = new Scanner(System.in);
>         System.out.print("Bitte Anzahl der Elemente n eingeben: ");
>         int n = scan.nextInt();
>         int[] x = new int[n];
>         int norm = 0;
>         for (int i = 0; i < x.length; i++) {
>             System.out.print("Bitte x_" + i + " eingeben: ");
>             x[i] = scan.nextInt();
>         }
>         // this loop could be integrated with the preceding one
>         for (int i = 0; i < x.length; i++)
>         norm += x[i] * x[i];
>         System.out.println("Der Betrag von x ist " + Math.sqrt(norm));
>         scan.close();
>     }
> 
> }
> ```

## Meine Notizen

