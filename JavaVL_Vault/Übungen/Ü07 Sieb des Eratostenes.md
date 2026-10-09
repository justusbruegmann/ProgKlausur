---
tags: ["typ/uebung", "thema/arrays", "kategorie/grundlagen", "semester/1", "schwierigkeit/4", "hat/musterloesung"]
aliases: ["Eratostenes"]
thema: "[[07 Arrays]]"
klasse: "Eratostenes"
package: "de.dhbwka.java.exercise.arrays"
schwierigkeit: 4
status: "offen"
---

# Ü07 Sieb des Eratostenes

**Thema:** [[07 Arrays]] · **Bereich:** Arrays (eindimensional) · **Schwierigkeit:** ★★★★☆
**Klasse:** `Eratostenes` · **Package:** `de.dhbwka.java.exercise.arrays`

📄 Aufgabe: [[Material/Aufgaben/07_Arrays_Aufgaben-1.pdf#page=3|07_Arrays_Aufgaben-1.pdf, S. 3]]
✅ Musterlösung: [[Material/Aufgaben/07_Arrays_Aufgaben-1_Muster.pdf#page=3|07_Arrays_Aufgaben-1_Muster.pdf, S. 3]]

> [!question] Kurz gesagt
> Die \*-Aufgaben sind für alle, die schon Erfahrung im Programmieren haben und/oder schon früher fertig geworden sind; manchmal anspruchsvoller, manchmal für Fleißige. Der folgende Algorithmus („Sieb des Eratostenes“) ermittelt alle Primzahlen zwischen 2 und einer vorgegebenen Grenze n: (1) Menge sieve \= alle natürlichen Zahlen von 2 bis n (2) Menge primes \= leere Menge (3) wiederhole die Schritte …

## Aufgabenstellung
```text
Die *-Aufgaben sind für alle, die schon Erfahrung im Programmieren haben und/oder schon früher
fertig geworden sind; manchmal anspruchsvoller, manchmal für Fleißige.

Der folgende Algorithmus („Sieb des Eratostenes“) ermittelt alle Primzahlen zwischen 2 und einer
vorgegebenen Grenze n:

         (1) Menge sieve = alle natürlichen Zahlen von 2 bis n
         (2) Menge primes = leere Menge
         (3) wiederhole die Schritte (4) bis (6) solange, bis sieve leer wird
         (4)     bestimme die kleinste Zahl min in sieve
         (5)     füge min zu primes hinzu
         (6)     entferne min und alle seine ganzzahligen Vielfachen aus sieve

Schreiben Sie ein Programm, das diesen Algorithmus implementiert, z.B. für n = 100.

Tipp:
Sie können ein Array von n (oder auch n+1) boolean-Werten zur Implementierung des Siebs
verwenden.
```

## Benötigte Begriffe
[[for-Schleife]] · [[Array]]

## Weitere Übungen zum Thema
[[Ü07 Mittelwert und Standardabweichung]] · [[Ü07 Fibonacci-Folge]] · [[Ü07 Betrag eines Vektors]] · [[Ü07 Skalarprodukt zweier Vektoren]] · [[Ü07 Sortieren mit Bubblesort]] · [[Ü07 Subtraktion zweier Matrizen]] · [[Ü07 Pascalsches Dreieck]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.arrays;
> 
> public class Eratostenes {
> 
>     public static void main(String[] args) {
>         int max = 100;
>         boolean[] prim = new boolean[max];
>         // initialize array with true
>         for (int i = 2; i < prim.length; i++)
>         prim[i] = true;
>         // eratostenes' sieve
>         for (int i = 2; i < prim.length; i++)
>         if (prim[i])
>         for (int j = i*2; j < prim.length; j+=i)
>         prim[j] = false;
>         // output
>         for (int i = 0; i < prim.length; i++)
>         if (prim[i])
>         System.out.println(i);
>     }
> 
> }
> ```

## Meine Notizen

