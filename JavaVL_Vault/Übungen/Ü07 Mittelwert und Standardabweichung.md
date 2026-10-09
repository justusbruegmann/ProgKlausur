---
tags: ["typ/uebung", "thema/arrays", "kategorie/grundlagen", "semester/1", "schwierigkeit/2", "hat/musterloesung"]
aliases: ["StandardDeviation"]
thema: "[[07 Arrays]]"
klasse: "StandardDeviation"
package: "de.dhbwka.java.exercise.arrays"
schwierigkeit: 2
status: "offen"
---

# Ü07 Mittelwert und Standardabweichung

**Thema:** [[07 Arrays]] · **Bereich:** Arrays (eindimensional) · **Schwierigkeit:** ★★☆☆☆
**Klasse:** `StandardDeviation` · **Package:** `de.dhbwka.java.exercise.arrays`

📄 Aufgabe: [[Material/Aufgaben/07_Arrays_Aufgaben-1.pdf#page=1|07_Arrays_Aufgaben-1.pdf, S. 1]]
✅ Musterlösung: [[Material/Aufgaben/07_Arrays_Aufgaben-1_Muster.pdf#page=1|07_Arrays_Aufgaben-1_Muster.pdf, S. 1]]

> [!question] Kurz gesagt
> Schreiben Sie ein Programm StandardDeviation, das von den zufällig erzeugten Werten eines Arrays beliebiger Größe den Mittelwert und die Standardabweichung berechnet. Die Formel für den Mittelwert ist: 1 n x  xi n i 1 Die Formel für die Standardabweichung lautet (ohne die Wurzel haben wir die Varianz)\*: 1 n sx   n  1 i1 ( xi  x ) 2 Das Array soll eine Größe von n \= 100 haben, die …

## Aufgabenstellung
```text
Schreiben Sie ein Programm StandardDeviation, das von den zufällig erzeugten Werten eines
Arrays beliebiger Größe den Mittelwert und die Standardabweichung berechnet.
Die Formel für den Mittelwert ist:

                                                   1 n
                                              x      xi
                                                   n i 1

Die Formel für die Standardabweichung lautet (ohne die Wurzel haben wir die Varianz)*:

                                              1 n
                                       sx       
                                            n  1 i1
                                                      ( xi  x ) 2

Das Array soll eine Größe von n = 100 haben, die zufälligen Werte können mit Hilfe der Methode
Math.random() oder der Klasse java.util.Random erzeugt werden und sollen ganzzahlige
Werte zwischen 0 und 10 haben.

Hinweis:
Potenzen können mit der Methode Math.pow(double basis, double exponent),
Quadratwurzeln mit der Methode Math.sqrt(double zahl) berechnet werden.

Beispielausgabe:

Mittelwert: 5.35
Standardabweichung: 3.2887165529514033

*( Es existieren auch abweichende Definitionen bei denen durch n dividiert wird.
```

## Benötigte Begriffe
[[Zufallszahlen]] · [[Math-Klasse]] · [[for-Schleife]] · [[Array]]

## Weitere Übungen zum Thema
[[Ü07 Fibonacci-Folge]] · [[Ü07 Sieb des Eratostenes]] · [[Ü07 Betrag eines Vektors]] · [[Ü07 Skalarprodukt zweier Vektoren]] · [[Ü07 Sortieren mit Bubblesort]] · [[Ü07 Subtraktion zweier Matrizen]] · [[Ü07 Pascalsches Dreieck]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.arrays;
> 
> import java.util.Random;
> 
> public class StandardDeviation {
> 
>     public static void main(String[] args) {
>         int n = 100;
>         Random rnd = new Random();
>         int[] x = new int[n];
> 
>         // generate random numbers and calculate average
>         int sum = 0;
>         for (int i = 0; i < x.length; i++) {
>             x[i] = rnd.nextInt(11); // 0..10
>             sum += x[i]; // sum up the x[i]
>         }
>         double average = 1. * sum / n;
>         System.out.println("Mittelwert: "+average);
> 
>         // calculate standard deviation
>         double devSum = 0;
>         for (int i = 0; i < x.length; i++) {
>             devSum += Math.pow(x[i] - average, 2);
>         }
>         double deviation = Math.sqrt(devSum / (n - 1));
>         System.out.println("Standardabweichung: "+deviation);
>     }
> 
> }
> ```

## Meine Notizen

