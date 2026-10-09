---
tags: ["typ/uebung", "thema/kontrollstrukturen", "kategorie/grundlagen", "semester/1", "schwierigkeit/1", "hat/musterloesung"]
aliases: ["LeapYear"]
thema: "[[06 Kontrollstrukturen]]"
klasse: "LeapYear"
package: "de.dhbwka.java.exercise.control"
schwierigkeit: 1
status: "offen"
---

# Ü06 Schaltjahr

**Thema:** [[06 Kontrollstrukturen]] · **Bereich:** Kontrollstrukturen · **Schwierigkeit:** ★☆☆☆☆
**Klasse:** `LeapYear` · **Package:** `de.dhbwka.java.exercise.control`

📄 Aufgabe: [[Material/Aufgaben/06_Kontrollstrukturen_Aufgaben.pdf#page=1|06_Kontrollstrukturen_Aufgaben.pdf, S. 1]]
✅ Musterlösung: [[Material/Aufgaben/06_Kontrollstrukturen_Aufgaben_Muster.pdf#page=1|06_Kontrollstrukturen_Aufgaben_Muster.pdf, S. 1]]

> [!question] Kurz gesagt
> Schreiben Sie ein Programm LeapYear, das eine Jahreszahl von der Konsole einliest und dann bestimmt, ob es sich bei diesem Jahr um ein Schaltjahr handelt! Das Ergebnis soll auf der Konsole ausgegeben werden.

## Aufgabenstellung
```text
Schreiben Sie ein Programm LeapYear, das eine Jahreszahl von der Konsole einliest und dann
bestimmt, ob es sich bei diesem Jahr um ein Schaltjahr handelt!
Das Ergebnis soll auf der Konsole ausgegeben werden.

Ein Jahr ist ein Schaltjahr, wenn es durch vier teilbar ist, nicht aber wenn es durch 100 teilbar ist, es
sei denn, es ist durch 400 teilbar.

Beispieldialog:
Welches Jahr soll auf Schaltjahr geprüft werden? 2018
2018 ist kein Schaltjahr

Welches Jahr soll auf Schaltjahr geprüft werden? 2020
2020 ist ein Schaltjahr

Welches Jahr soll auf Schaltjahr geprüft werden? 2000
2000 ist ein Schaltjahr

Welches Jahr soll auf Schaltjahr geprüft werden? 2100
2100 ist kein Schaltjahr
```

## Benötigte Begriffe
[[Arithmetische Operatoren]] · [[Bedingungsoperator]] · [[Scanner]]

## Weitere Übungen zum Thema
[[Ü06 Temperaturtabelle]] · [[Ü06 Wildbestand]] · [[Ü06 Einmaleins]] · [[Ü06 Aufsummieren]] · [[Ü06 Schuhgrößen]] · [[Ü06 Babylonisches Wurzelziehen (Heronverfahren)]] · [[Ü06 Zahlenraten]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.control;
> 
> import java.util.Scanner;
> 
> public class LeapYear {
> 
>     public static void main(String[] args) {
>         Scanner scan = new Scanner(System.in);
>         System.out.print("Welches Jahr auf Schaltjahr pruefen? ");
>         int year = scan.nextInt();
>         scan.close();
>         boolean isLeapYear = false;
>         if (year % 400 == 0) {
>             isLeapYear = true;
>         } else if (year % 100 == 0) {
>         } else if (year % 4 == 0) {
>             isLeapYear = true;
>         }
>         System.out.println(year + " ist " +
>         (isLeapYear ? "ein" : "kein") +
>         " Schaltjahr");
>     }
> 
> }
> 
> Beispielausgaben:
> Welches Jahr auf Schaltjahr prüfen? 2016
> 2016 ist ein Schaltjahr
> 
> Welches Jahr auf Schaltjahr prüfen? 2017
> 2017 ist kein Schaltjahr
> 
> Welches Jahr auf Schaltjahr prüfen? 2000
> 2000 ist ein Schaltjahr
> 
> Welches Jahr auf Schaltjahr prüfen? 1900
> 1900 ist kein Schaltjahr
> ```

## Meine Notizen

