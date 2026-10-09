---
tags: ["typ/uebung", "thema/arrays", "kategorie/grundlagen", "semester/1", "schwierigkeit/3", "hat/musterloesung"]
aliases: ["Pascal"]
thema: "[[07 Arrays]]"
klasse: "Pascal"
package: "de.dhbwka.java.exercise.arrays"
schwierigkeit: 3
status: "offen"
---

# Ü07 Pascalsches Dreieck

**Thema:** [[07 Arrays]] · **Bereich:** Arrays (mehrdimensional) · **Schwierigkeit:** ★★★☆☆
**Klasse:** `Pascal` · **Package:** `de.dhbwka.java.exercise.arrays`

📄 Aufgabe: [[Material/Aufgaben/07_Arrays_Aufgaben-2.pdf#page=2|07_Arrays_Aufgaben-2.pdf, S. 2]]
✅ Musterlösung: [[Material/Aufgaben/07_Arrays_Aufgaben-2_Muster.pdf#page=3|07_Arrays_Aufgaben-2_Muster.pdf, S. 3]]

> [!question] Kurz gesagt
> Ein Pascalsches Dreieck hat den folgenden Aufbau: 1 1 1 1 2 1 1 3 3 1 1 4 6 4 1 ... In der ersten Zeile steht eine 1.

## Aufgabenstellung
```text
Ein Pascalsches Dreieck hat den folgenden Aufbau:

                                                         1
                                                     1       1
                                                 1       2       1
                                             1       3       3       1
                                         1       4    6 4                1
                                                     ...

In der ersten Zeile steht eine 1.
In allen weiteren Zeilen berechnet sich der Wert jeder Zahl aus der Summe der beiden Zahlen rechts
und links oberhalb. Befindet sich nur eine Zahl oberhalb eines Feldes (am linken oder rechten Rand),
so entspricht der Wert der unteren Zahl dem der oberen (immer 1).

Schreiben Sie ein Programm Pascal, das die ersten 9 Zeilen eines Pascalschen Dreiecks ausgibt!

Gehen Sie dazu folgendermaßen vor:
   1. Generieren Sie eine entsprechende mehrdimensionale Arraystruktur zur Aufnahme der
       Zahlen!
   2. Initialisieren Sie die erzeugte Struktur gemäß der obigen Regel!
       (das Feld in der obersten Reihe wird per Definition auf 1 gesetzt).
   3. Geben Sie die erzeugte Struktur auf dem Bildschirm aus!

Hinweis:
Bei der Ausgabe muss das Dreieck nicht unbedingt zentriert dargestellt werden.
```

## Benötigte Begriffe
[[Formatierte Ausgabe]] · [[for-Schleife]] · [[Array]] · [[Mehrdimensionales Array]]

## Weitere Übungen zum Thema
[[Ü07 Mittelwert und Standardabweichung]] · [[Ü07 Fibonacci-Folge]] · [[Ü07 Sieb des Eratostenes]] · [[Ü07 Betrag eines Vektors]] · [[Ü07 Skalarprodukt zweier Vektoren]] · [[Ü07 Sortieren mit Bubblesort]] · [[Ü07 Subtraktion zweier Matrizen]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.arrays;
> 
> public class Pascal {
> 
>     public static void main(String[] args) {
>         int maxRows = 9;
>         int[][] pascal = new int[maxRows][];
>         for (int i = 0; i < pascal.length; i++) {
>             pascal[i] = new int[i+1];
>             pascal[i][0] = 1;
>             pascal[i][pascal[i].length - 1] = 1;
>             if (i>1) {
>                 for (int j = 1; j < pascal[i].length-1; j++) {
>                     pascal[i][j] = pascal[i-1][j-1]
>                     + pascal[i-1][j];
>                 }
>             }
>         }
>         for (int i = 0; i < pascal.length; i++) {
>             // insert blanks for centered output
>             for (int j = 1; j < maxRows-i; j++)
>             System.out.print(" ");
>             // output one row
>             for (int j : pascal[i])
>             System.out.printf(" %2d ",j);
>             System.out.println();
>         }
>     }
> 
> }
> ```

## Meine Notizen

