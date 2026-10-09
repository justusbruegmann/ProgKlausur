---
tags: ["typ/uebung", "thema/operatoren", "kategorie/grundlagen", "semester/1", "schwierigkeit/1", "hat/musterloesung"]
aliases: ["Easter"]
thema: "[[05 Operatoren]]"
klasse: "Easter"
package: "de.dhbwka.java.exercise.operators"
schwierigkeit: 1
status: "offen"
---

# Ü05 Ostertermin berechnen

**Thema:** [[05 Operatoren]] · **Bereich:** Operatoren · **Schwierigkeit:** ★☆☆☆☆
**Klasse:** `Easter` · **Package:** `de.dhbwka.java.exercise.operators`

📄 Aufgabe: [[Material/Aufgaben/05_Operatoren_Aufgaben.pdf#page=3|05_Operatoren_Aufgaben.pdf, S. 3]]
✅ Musterlösung: [[Material/Aufgaben/05_Operatoren_Aufgaben_Muster.pdf#page=2|05_Operatoren_Aufgaben_Muster.pdf, S. 2]]

> [!question] Kurz gesagt
> Berechnen Sie in einem Java-Programm Easter den Ostertermin für das Jahr „jahr“ nach der von Gauß im Jahr 1816 veröffentlichten Formel (hier für den gregorianischen Kalender). a \= jahr mod 19 b \= jahr mod 4 c \= jahr mod 7 k \= jahr div 100 p \= (8k + 13) div 25 q \= k div 4 m \= (15 + k - p - q) mod 30 n \= (4 + k - q) mod 7 d \= (19a + m) mod 30 e \= (2b + 4c + 6d + n) mod 7 ostern \= (22 + d + e) …

## Aufgabenstellung
```text
Berechnen Sie in einem Java-Programm Easter den Ostertermin für das Jahr „jahr“ nach der von
Gauß im Jahr 1816 veröffentlichten Formel (hier für den gregorianischen Kalender).

        a = jahr mod 19
        b = jahr mod 4
        c = jahr mod 7
        k = jahr div 100
        p = (8k + 13) div 25
        q = k div 4
        m = (15 + k - p - q) mod 30
        n = (4 + k - q) mod 7
        d = (19a + m) mod 30
        e = (2b + 4c + 6d + n) mod 7
        ostern = (22 + d + e)   (bezogen auf 1. März)

Der „32. März“ entspricht also dem 1. April usw.

Lassen Sie die Jahreszahl vom Nutzer eingeben und geben Sie den passenden Ostertermin aus!

Hinweise:
div liefert den Ganzzahlanteil des Ergebnisses der ganzzahligen Division.
mod (Modulo-Funktion) liefert den Divisionsrest bei ganzzahliger Division.
```

## Benötigte Begriffe
[[Arithmetische Operatoren]] · [[Bedingungsoperator]] · [[Scanner]]

## Weitere Übungen zum Thema
[[Ü05 Inkrement und Dekrement]] · [[Ü05 Kaufmännisches Runden (2)]] · [[Ü05 Vorrang von Operatoren]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.operators;
> 
> import java.util.Scanner;
> 
> public class Easter {
> 
>     public static void main(String[] args) {
>         Scanner scan = new Scanner(System.in);
>         System.out.print("Ostertermin fuer welches Jahr berechnen? ");
>         int year = scan.nextInt();
>         scan.close();
>         int a = year % 19;
>         int b = year % 4;
>         int c = year % 7;
>         int k = year / 100;
>         int p = (8 * k + 13) / 25;
>         int q = k / 4;
>         int M = (15 + k - p - q) % 30;
>         int N = (4 + k - q) % 7;
>         int d = (19 * a + M) % 30;
>         int e = (2 * b + 4 * c + 6 * d + N) % 7;
>         int easter = (22 + d + e);
>         System.out.println("Im Jahr " + year +
>         " ist der Ostersonntag am "+
>         (easter<32 ? easter : easter-31) + ". " +
>         (easter<32 ? "März" : "April"));
>     }
> }
> 
> Beispielausgaben:
> 
> Ostertermin für welches Jahr berechnen? 2016
> Im Jahr 2016 ist der Ostersonntag am 27. März
> 
> Ostertermin für welches Jahr berechnen? 2019
> Im Jahr 2019 ist der Ostersonntag am 21. April
> ```

## Meine Notizen

