---
tags: ["typ/uebung", "thema/arrays", "kategorie/grundlagen", "semester/1", "schwierigkeit/2", "hat/musterloesung"]
aliases: ["MatrixSubtraction"]
thema: "[[07 Arrays]]"
klasse: "MatrixSubtraction"
package: "de.dhbwka.java.exercise.arrays"
schwierigkeit: 2
status: "offen"
---

# Ü07 Subtraktion zweier Matrizen

**Thema:** [[07 Arrays]] · **Bereich:** Arrays (mehrdimensional) · **Schwierigkeit:** ★★☆☆☆
**Klasse:** `MatrixSubtraction` · **Package:** `de.dhbwka.java.exercise.arrays`

📄 Aufgabe: [[Material/Aufgaben/07_Arrays_Aufgaben-2.pdf#page=1|07_Arrays_Aufgaben-2.pdf, S. 1]]
✅ Musterlösung: [[Material/Aufgaben/07_Arrays_Aufgaben-2_Muster.pdf#page=1|07_Arrays_Aufgaben-2_Muster.pdf, S. 1]]

> [!question] Kurz gesagt
> Schreiben Sie ein Programm MatrixSubtraction, das zwei n x m Matrizen X und Y mit ganzen Zahlen elementweise subtrahiert. Hinweis: Sie können die beiden Matrizen X und Y entweder mit Zufallszahlen füllen oder per Hand eingeben lassen.

## Aufgabenstellung
```text
Schreiben Sie ein Programm MatrixSubtraction, das zwei n x m Matrizen X und Y mit ganzen
Zahlen elementweise subtrahiert.

Hinweis:
Sie können die beiden Matrizen X und Y entweder mit Zufallszahlen füllen oder per Hand eingeben
lassen. Im Falle von Zufallszahlen geben Sie auch die ursprünglichen Matrizen X und Y aus!

Beispielausgabe (4 x 4-Matrizen mit Zufallszahlen von 0 bis 99):

Bitte Anzahl der Zeilen n eingeben: 4
Bitte Anzahl der Spalten m eingeben: 4
X:
  47 29 73     2
  67 42 93     9
   6   4 36 86
  70 57 18 43
Y:
  90 58 97 96
   6 60    0 46
  46 11 55 96
  33 95 71     7
X-Y:
 -43 -29 -24 -94
  61 -18 93 -37
 -40 -7 -19 -10
  37 -38 -53 36
```

## Benötigte Begriffe
[[Formatierte Ausgabe]] · [[Scanner]] · [[Zufallszahlen]] · [[for-Schleife]] · [[Array]] · [[Mehrdimensionales Array]]

## Weitere Übungen zum Thema
[[Ü07 Mittelwert und Standardabweichung]] · [[Ü07 Fibonacci-Folge]] · [[Ü07 Sieb des Eratostenes]] · [[Ü07 Betrag eines Vektors]] · [[Ü07 Skalarprodukt zweier Vektoren]] · [[Ü07 Sortieren mit Bubblesort]] · [[Ü07 Pascalsches Dreieck]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.arrays;
> 
> import java.util.Random;
> import java.util.Scanner;
> 
> public class MatrixSubtraction {
> 
>     public static void main(String[] args) {
>         Scanner scan = new Scanner(System.in);
>         Random rnd = new Random();
>         System.out.print("Bitte Anzahl der Zeilen n eingeben: ");
>         int n = scan.nextInt();
>         System.out.print("Bitte Anzahl der Spalten m eingeben: ");
>         int m = scan.nextInt();
>         int[][] x = new int [n][m];
>         int[][] y = new int [n][m];
>         // fill arrays with random numbers
>         for (int i = 0; i < n; i++) {
>             for (int j = 0; j < m; j++) {
>                 x[i][j] = rnd.nextInt(100);
>                 y[i][j] = rnd.nextInt(100);
>             }
>         }
>         // output matrix x
>         System.out.println("X:");
>         for (int i = 0; i < n; i++) {
>             for (int res : x[i]) {
>                 System.out.printf("%4d",res);
>             }
>             System.out.println();
>         }
>         // output matrix y
>         System.out.println("Y:");
>         for (int i = 0; i < n; i++) {
>             for (int res : y[i]) {
>                 System.out.printf("%4d",res);
>             }
>             System.out.println();
>         }
> 
>         // output result x-y
>         System.out.println("X-Y:");
>         for (int i = 0; i < n; i++) {
>             for (int j = 0; j < m; j++) {
>                 System.out.printf("%4d",x[i][j] - y[i][j]);
>             }
>             System.out.println();
>         }
>         scan.close();
>     }
> 
> }
> ```

## Meine Notizen

