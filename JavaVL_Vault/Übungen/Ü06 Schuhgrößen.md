---
tags: ["typ/uebung", "thema/kontrollstrukturen", "kategorie/grundlagen", "semester/1", "schwierigkeit/2", "hat/musterloesung"]
aliases: ["ShoeSize"]
thema: "[[06 Kontrollstrukturen]]"
klasse: "ShoeSize"
package: "de.dhbwka.java.exercise.control"
schwierigkeit: 2
status: "offen"
---

# Ü06 Schuhgrößen

**Thema:** [[06 Kontrollstrukturen]] · **Bereich:** Kontrollstrukturen · **Schwierigkeit:** ★★☆☆☆
**Klasse:** `ShoeSize` · **Package:** `de.dhbwka.java.exercise.control`

📄 Aufgabe: [[Material/Aufgaben/06_Kontrollstrukturen_Aufgaben.pdf#page=6|06_Kontrollstrukturen_Aufgaben.pdf, S. 6]]
✅ Musterlösung: [[Material/Aufgaben/06_Kontrollstrukturen_Aufgaben_Muster.pdf#page=7|06_Kontrollstrukturen_Aufgaben_Muster.pdf, S. 7]]

> [!question] Kurz gesagt
> Für die Umrechnung der in Deutschland üblichen Schuhgrößen in Zentimeter gilt die folgende Beziehung: Schuhgröße \= Zentimeter \* 1,5 Entwickeln Sie ein Programm ShoeSize, das eine Tabelle der folgenden Art berechnet und ausgibt! Zentimeter \| Größe --------------+------ 19,33 - 20,00 \| 30 20,00 - 20,67 \| 31 20,67 - 21,33 \| 32 21,33 - 22,00 \| 33 22,00 - 22,67 \| 34 22,67 - 23,33 \| 35 23,33 - 24,00 \| …

## Aufgabenstellung
```text
Für die Umrechnung der in Deutschland üblichen Schuhgrößen in Zentimeter gilt die folgende
Beziehung:

         Schuhgröße = Zentimeter * 1,5

Entwickeln Sie ein Programm ShoeSize, das eine Tabelle der folgenden Art berechnet und
ausgibt!

Zentimeter    | Größe
--------------+------
19,33 - 20,00 | 30
20,00 - 20,67 | 31
20,67 - 21,33 | 32
21,33 - 22,00 | 33
22,00 - 22,67 | 34
22,67 - 23,33 | 35
23,33 - 24,00 | 36
24,00 - 24,67 | 37
24,67 - 25,33 | 38
25,33 - 26,00 | 39
26,00 - 26,67 | 40
26,67 - 27,33 | 41
27,33 - 28,00 | 42
28,00 - 28,67 | 43
28,67 - 29,33 | 44
29,33 - 30,00 | 45
30,00 - 30,67 | 46
30,67 - 31,33 | 47
31,33 - 32,00 | 48
32,00 - 32,67 | 49
```

## Benötigte Begriffe
[[Formatierte Ausgabe]] · [[for-Schleife]]

## Weitere Übungen zum Thema
[[Ü06 Schaltjahr]] · [[Ü06 Temperaturtabelle]] · [[Ü06 Wildbestand]] · [[Ü06 Einmaleins]] · [[Ü06 Aufsummieren]] · [[Ü06 Babylonisches Wurzelziehen (Heronverfahren)]] · [[Ü06 Zahlenraten]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.control;
> 
> public class ShoeSize {
> 
>     public static void main(String[] args) {
>         System.out.println("Zentimeter     | Größe");
>         System.out.println("--------------+------");
>         for (int size=30; size<50; size++) {
>             double length = size / 1.5;
>             System.out.printf("%5.2f - %5.2f | %2d",
>             (length - 2./3),
>             length,
>             size);
>             System.out.println();
>         }
>     }
> 
> }
> ```

## Meine Notizen

