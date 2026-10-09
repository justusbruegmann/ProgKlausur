---
tags: ["typ/uebung", "thema/arrays", "kategorie/grundlagen", "semester/1", "schwierigkeit/1", "hat/musterloesung"]
aliases: ["DotProduct"]
thema: "[[07 Arrays]]"
klasse: "DotProduct"
package: "de.dhbwka.java.exercise.arrays"
schwierigkeit: 1
status: "offen"
---

# Ü07 Skalarprodukt zweier Vektoren

**Thema:** [[07 Arrays]] · **Bereich:** Arrays (eindimensional) · **Schwierigkeit:** ★☆☆☆☆
**Klasse:** `DotProduct` · **Package:** `de.dhbwka.java.exercise.arrays`

📄 Aufgabe: [[Material/Aufgaben/07_Arrays_Aufgaben-1.pdf#page=5|07_Arrays_Aufgaben-1.pdf, S. 5]]
✅ Musterlösung: [[Material/Aufgaben/07_Arrays_Aufgaben-1_Muster.pdf#page=5|07_Arrays_Aufgaben-1_Muster.pdf, S. 5]]

> [!question] Kurz gesagt
> Das Skalarprodukt zweier Vektoren x \= (x1, x2, …, xn) und y \= (y1, y2, ..., yn) ist definiert als x1  y1  x2  y 2    xn  y n Erstellen Sie ein Programm DotProduct, das zwei Vektoren mit jeweils n Komponenten jeweils in ein Array einliest, dann das Skalarprodukt der beiden Vektoren berechnet und schließlich das Ergebnis ausgibt! Lesen Sie zunächst n ein!

## Aufgabenstellung
```text
Das Skalarprodukt zweier Vektoren x = (x1, x2, …, xn) und y = (y1, y2, ..., yn) ist definiert als

                                       x1  y1  x2  y 2    xn  y n

Erstellen Sie ein Programm DotProduct, das zwei Vektoren mit jeweils n Komponenten jeweils in
ein Array einliest, dann das Skalarprodukt der beiden Vektoren berechnet und schließlich das
Ergebnis ausgibt!
Lesen Sie zunächst n ein!

Beispielausgabe:

Bitte Anzahl der Elemente n eingeben: 3
Bitte x_0 eingeben: 5
Bitte x_1 eingeben: 3
Bitte x_2 eingeben: 1
Bitte y_0 eingeben: -2
Bitte y_1 eingeben: 4
Bitte y_2 eingeben: 9
Das Skalarprodukt von x und y ist 11
```

## Benötigte Begriffe
[[Scanner]] · [[for-Schleife]] · [[Array]]

## Weitere Übungen zum Thema
[[Ü07 Mittelwert und Standardabweichung]] · [[Ü07 Fibonacci-Folge]] · [[Ü07 Sieb des Eratostenes]] · [[Ü07 Betrag eines Vektors]] · [[Ü07 Sortieren mit Bubblesort]] · [[Ü07 Subtraktion zweier Matrizen]] · [[Ü07 Pascalsches Dreieck]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.arrays;
> 
> import java.util.Scanner;
> 
> public class DotProduct {
> 
>     public static void main(String[] args) {
>         Scanner scan = new Scanner(System.in);
>         System.out.print("Bitte Anzahl der Elemente n eingeben: ");
>         int n = scan.nextInt();
>         int[] x = new int[n];
>         int[] y = new int[n];
>         int dotProduct = 0;
>         for (int i = 0; i < x.length; i++) {
>             System.out.print("Bitte x_" + i + " eingeben: ");
>             x[i] = scan.nextInt();
>         }
>         for (int i = 0; i < y.length; i++) {
>             System.out.print("Bitte y_" + i + " eingeben: ");
>             y[i] = scan.nextInt();
>         }
>         // this loop could be integrated with the preceding one
>         for (int i = 0; i < x.length; i++)
>         dotProduct += x[i] * y[i];
>         System.out.println("Das Skalarprodukt von x und y ist "
>         +dotProduct);
>         scan.close();
>     }
> 
> }
> ```

## Meine Notizen

