---
tags: ["typ/uebung", "thema/arrays", "kategorie/grundlagen", "semester/1", "schwierigkeit/3", "hat/musterloesung"]
aliases: ["BubbleSort"]
thema: "[[07 Arrays]]"
klasse: "BubbleSort"
package: "de.dhbwka.java.exercise.arrays"
schwierigkeit: 3
status: "offen"
---

# Ü07 Sortieren mit Bubblesort

**Thema:** [[07 Arrays]] · **Bereich:** Arrays (eindimensional) · **Schwierigkeit:** ★★★☆☆
**Klasse:** `BubbleSort` · **Package:** `de.dhbwka.java.exercise.arrays`

📄 Aufgabe: [[Material/Aufgaben/07_Arrays_Aufgaben-1.pdf#page=6|07_Arrays_Aufgaben-1.pdf, S. 6]]
✅ Musterlösung: [[Material/Aufgaben/07_Arrays_Aufgaben-1_Muster.pdf#page=6|07_Arrays_Aufgaben-1_Muster.pdf, S. 6]]

> [!question] Kurz gesagt
> Der Bubblesort-Sortieralgorithmus arbeitet nach der folgenden Idee: Je zwei nebeneinanderliegende Elemente eines Feldes werden verglichen; sie werden vertauscht, wenn sie in falscher Reihenfolge stehen. Das wird solange wiederholt, bis alle benachbarten Elemente richtig sortiert sind.

## Aufgabenstellung
```text
Der Bubblesort-Sortieralgorithmus arbeitet nach der folgenden Idee:
Je zwei nebeneinanderliegende Elemente eines Feldes werden verglichen; sie werden vertauscht,
wenn sie in falscher Reihenfolge stehen. Das wird solange wiederholt, bis alle benachbarten
Elemente richtig sortiert sind.

Beispiel:
(5,3,1,2)(3,5,1,2)(3,1,5,2)(3,1,2,5)(1,3,2,5)(1,2,3,5)

Schreiben Sie ein Programm BubbleSort zum aufsteigenden Sortieren von ganzen Zahlen!

Lesen Sie die Anzahl n der zu sortierenden Zahlen sowie diese n Zahlen von der Konsole ein und
speichern Sie die Zahlen in einem Array.
Sortieren Sie dann das Array mit Hilfe von Bubblesort in aufsteigender Reihenfolge und geben Sie
am Ende die sortierten Zahlen aus.

Beispielausgabe:

Bitte Anzahl der Elemente n eingeben: 4
Zahl 0 eingeben: 5
Zahl 1 eingeben: 3
Zahl 2 eingeben: 1
Zahl 3 eingeben: 2
Sortiert: 1 2 3 5
```

## Benötigte Begriffe
[[Scanner]] · [[while-Schleife]] · [[for-Schleife]] · [[Array]] · [[Sortieren]]

## Weitere Übungen zum Thema
[[Ü07 Mittelwert und Standardabweichung]] · [[Ü07 Fibonacci-Folge]] · [[Ü07 Sieb des Eratostenes]] · [[Ü07 Betrag eines Vektors]] · [[Ü07 Skalarprodukt zweier Vektoren]] · [[Ü07 Subtraktion zweier Matrizen]] · [[Ü07 Pascalsches Dreieck]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.arrays;
> 
> import java.util.Scanner;
> 
> public class BubbleSort {
> 
>     public static void main(String[] args) {
>         Scanner scan = new Scanner(System.in);
>         System.out.print("Bitte Anzahl der Elemente n eingeben: ");
>         int n = scan.nextInt();
>         int[] x = new int[n];
>         for (int i = 0; i < x.length; i++) {
>             System.out.print("Zahl " + i + " eingeben: ");
>             x[i] = scan.nextInt();
>         }
>         boolean swapped;
>         do {
>             swapped = false;
>             for (int i = 1; i < x.length; i++) {
>                 if (x[i-1]>x[i]) {
>                     int tmp = x[i-1];
>                     x[i-1] = x[i];
>                     x[i] = tmp;
>                     swapped = true;
>                 }
>             }
>         } while (swapped);
>         System.out.print("Sortiert: ");
>         for (int i : x) {
>             System.out.print(i + " ");
>         }
>         scan.close();
>     }
> 
> }
> ```

## Meine Notizen

