---
tags: ["typ/uebung", "thema/arrays", "kategorie/grundlagen", "semester/1", "schwierigkeit/1", "hat/musterloesung"]
aliases: ["Fibonacci"]
thema: "[[07 Arrays]]"
klasse: "Fibonacci"
package: "de.dhbwka.java.exercise.arrays"
schwierigkeit: 1
status: "offen"
---

# Ü07 Fibonacci-Folge

**Thema:** [[07 Arrays]] · **Bereich:** Arrays (eindimensional) · **Schwierigkeit:** ★☆☆☆☆
**Klasse:** `Fibonacci` · **Package:** `de.dhbwka.java.exercise.arrays`

📄 Aufgabe: [[Material/Aufgaben/07_Arrays_Aufgaben-1.pdf#page=2|07_Arrays_Aufgaben-1.pdf, S. 2]]
✅ Musterlösung: [[Material/Aufgaben/07_Arrays_Aufgaben-1_Muster.pdf#page=2|07_Arrays_Aufgaben-1_Muster.pdf, S. 2]]

> [!question] Kurz gesagt
> Mit den Startwerten f0 \= 0 und f1 \= 1 wird die Folge der Fibonacci-Zahlen erklärt durch fn \= fn-1 + fn-2 Schreiben Sie ein Programm Fibonacci, das die ersten 20 (50) Fibonacci-Zahlen berechnet, gemäß ihrem Index in einem Array speichert und die Zahlen anschließend ausgibt!

## Aufgabenstellung
```text
Mit den Startwerten f0 = 0 und f1 = 1 wird die Folge der Fibonacci-Zahlen erklärt durch

         fn = fn-1 + fn-2

Schreiben Sie ein Programm Fibonacci, das die ersten 20 (50) Fibonacci-Zahlen berechnet,
gemäß ihrem Index in einem Array speichert und die Zahlen anschließend ausgibt!
```

## Benötigte Begriffe
[[Formatierte Ausgabe]] · [[for-Schleife]] · [[Array]]

## Gleiche Klasse in anderen Übungen (Fortsetzung/Variante)
[[Ü11 Fibonacci-Zahlen rekursiv]]

## Weitere Übungen zum Thema
[[Ü07 Mittelwert und Standardabweichung]] · [[Ü07 Sieb des Eratostenes]] · [[Ü07 Betrag eines Vektors]] · [[Ü07 Skalarprodukt zweier Vektoren]] · [[Ü07 Sortieren mit Bubblesort]] · [[Ü07 Subtraktion zweier Matrizen]] · [[Ü07 Pascalsches Dreieck]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.arrays;
> 
> public class Fibonacci {
> 
>     public static void main(String[] args) {
>         int n = 20; // or 50
>         int[] fib = new int[n];
>         fib[0] = fib[1] = 1;
>         for (int i = 2; i < fib.length; i++) {
>             fib[i] = fib[i - 1] + fib[i - 2];
>         }
>         // output
>         for (int i = 0; i < fib.length; i++) {
>             System.out.printf("%2d.: %d",i,fib[i]);
>             System.out.println();
>         }
>     }
> 
> }
> ```

## Meine Notizen

