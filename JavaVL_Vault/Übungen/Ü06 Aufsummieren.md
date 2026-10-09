---
tags: ["typ/uebung", "thema/kontrollstrukturen", "kategorie/grundlagen", "semester/1", "schwierigkeit/1", "hat/musterloesung"]
aliases: ["AddUp"]
thema: "[[06 Kontrollstrukturen]]"
klasse: "AddUp"
package: "de.dhbwka.java.exercise.control"
schwierigkeit: 1
status: "offen"
---

# Ü06 Aufsummieren

**Thema:** [[06 Kontrollstrukturen]] · **Bereich:** Kontrollstrukturen · **Schwierigkeit:** ★☆☆☆☆
**Klasse:** `AddUp` · **Package:** `de.dhbwka.java.exercise.control`

📄 Aufgabe: [[Material/Aufgaben/06_Kontrollstrukturen_Aufgaben.pdf#page=5|06_Kontrollstrukturen_Aufgaben.pdf, S. 5]]
✅ Musterlösung: [[Material/Aufgaben/06_Kontrollstrukturen_Aufgaben_Muster.pdf#page=5|06_Kontrollstrukturen_Aufgaben_Muster.pdf, S. 5]]

> [!question] Kurz gesagt
> Entwickeln Sie ein Programm AddUp, das beliebig viele positive Zahlen von der Konsole einliest und diese Zahlen aufsummiert! Verwenden Sie als Abbruchkriterium die Eingabe einer negativen Zahl (diese soll nicht mehr hinzugezählt werden).

## Aufgabenstellung
```text
Entwickeln Sie ein Programm AddUp, das beliebig viele positive Zahlen von der Konsole einliest und
diese Zahlen aufsummiert!

Verwenden Sie als Abbruchkriterium die Eingabe einer negativen Zahl (diese soll nicht mehr
hinzugezählt werden).
Am Ende soll die Summe aller eingegebenen positiven Zahlen ausgegeben werden.

Realisieren Sie AddUp einmal mit einer while-Schleife und einmal mit einer do-while-Schleife!

Beispieldialog:

Zahl eingeben (<0 für Abbruch): 4
Zahl eingeben (<0 für Abbruch): 3
Zahl eingeben (<0 für Abbruch): 7
Zahl eingeben (<0 für Abbruch): 2
Zahl eingeben (<0 für Abbruch): -1
Summe: 16
```

## Benötigte Begriffe
[[Scanner]] · [[while-Schleife]] · [[Array]]

## Weitere Übungen zum Thema
[[Ü06 Schaltjahr]] · [[Ü06 Temperaturtabelle]] · [[Ü06 Wildbestand]] · [[Ü06 Einmaleins]] · [[Ü06 Schuhgrößen]] · [[Ü06 Babylonisches Wurzelziehen (Heronverfahren)]] · [[Ü06 Zahlenraten]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.control;
> 
> import java.util.Scanner;
> 
> public class AddUp {
> 
>     public static void main(String[] args) {
>         Scanner scan = new Scanner(System.in);
>         int input = 0;
>         int sum = 0;
>         while (input>=0) {
>             sum += input;
>             System.out.print("Zahl eingeben (<0 für Abbruch): ");
>             input = scan.nextInt();
>         };
>         System.out.println("Summe: "+sum);
>         scan.close();
>     }
> 
>     /**
>      * alternative implementation with do-while
>      */
>     public static void mainAlternative(String[] args) {
>         Scanner scan = new Scanner(System.in);
>         int input = 0;
>         int sum = 0;
>         do {
>             sum += input;
>             System.out.print("Zahl eingeben (<0 für Abbruch): ");
>             input = scan.nextInt();
>         } while (input >= 0);
>         System.out.println("Summe: "+sum);
>         scan.close();
>     }
> 
> }
> 
> Beispielausgabe:
> 
> Zahl eingeben (<0 für Abbruch): 4
> Zahl eingeben (<0 für Abbruch): 3
> Zahl eingeben (<0 für Abbruch): 7
> Zahl eingeben (<0 für Abbruch): 2
> Zahl eingeben (<0 für Abbruch): -1
> Summe: 16
> ```

## Meine Notizen

