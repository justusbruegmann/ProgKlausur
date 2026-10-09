---
tags: ["typ/uebung", "thema/kontrollstrukturen", "kategorie/grundlagen", "semester/1", "schwierigkeit/1", "hat/musterloesung"]
aliases: ["TemperatureTable"]
thema: "[[06 Kontrollstrukturen]]"
klasse: "TemperatureTable"
package: "de.dhbwka.java.exercise.control"
schwierigkeit: 1
status: "offen"
---

# Ü06 Temperaturtabelle

**Thema:** [[06 Kontrollstrukturen]] · **Bereich:** Kontrollstrukturen · **Schwierigkeit:** ★☆☆☆☆
**Klasse:** `TemperatureTable` · **Package:** `de.dhbwka.java.exercise.control`

📄 Aufgabe: [[Material/Aufgaben/06_Kontrollstrukturen_Aufgaben.pdf#page=2|06_Kontrollstrukturen_Aufgaben.pdf, S. 2]]
✅ Musterlösung: [[Material/Aufgaben/06_Kontrollstrukturen_Aufgaben_Muster.pdf#page=2|06_Kontrollstrukturen_Aufgaben_Muster.pdf, S. 2]]

> [!question] Kurz gesagt
> Erstellen Sie ein Programm zur Berechnung und Ausgabe einer Temperaturtabelle von Fahrenheit (f) nach Celsius (c)! Die Tabelle soll bei 0° F beginnen und bei 300° F enden.

## Aufgabenstellung
```text
Erstellen Sie ein Programm zur Berechnung und Ausgabe einer Temperaturtabelle von Fahrenheit (f)
nach Celsius (c)!
Die Tabelle soll bei 0° F beginnen und bei 300° F enden. Die Abstände der Stützstellen sollen 20° F
betragen.
Der funktionale Zusammenhang von c und f ist gegeben durch die Formel:

         c = (5 / 9) * ( f - 32)

Beispielausgabe:

Fahrenheit | Celsius
-----------+--------
  0        | -17.8
...
300        | 148.9
```

## Benötigte Begriffe
[[Formatierte Ausgabe]] · [[for-Schleife]]

## Weitere Übungen zum Thema
[[Ü06 Schaltjahr]] · [[Ü06 Wildbestand]] · [[Ü06 Einmaleins]] · [[Ü06 Aufsummieren]] · [[Ü06 Schuhgrößen]] · [[Ü06 Babylonisches Wurzelziehen (Heronverfahren)]] · [[Ü06 Zahlenraten]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.control;
> 
> public class TemperatureTable {
> 
>     public static void main(String[] args) {
>         System.out.println("Fahrenheit | Celsius");
>         System.out.println("-----------+--------");
>         for (int fahrenheit=0; fahrenheit<=300; fahrenheit+=20) {
>             double celsius = (5./9) * (fahrenheit - 32);
>             System.out.printf("%3d        | %5.1f",
>             fahrenheit,
>             celsius);
>             System.out.println();
>         }
>     }
> 
> }
> 
> Beispielausgabe:
> 
> Fahrenheit | Celsius
> -----------+--------
> 0          | -17.8
> ...
> 300        | 148.9
> ```

## Meine Notizen

