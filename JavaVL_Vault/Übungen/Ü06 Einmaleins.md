---
tags: ["typ/uebung", "thema/kontrollstrukturen", "kategorie/grundlagen", "semester/1", "schwierigkeit/1", "hat/musterloesung"]
aliases: ["MultiplicationTable"]
thema: "[[06 Kontrollstrukturen]]"
klasse: "MultiplicationTable"
package: "de.dhbwka.java.exercise.control"
schwierigkeit: 1
status: "offen"
---

# Ü06 Einmaleins

**Thema:** [[06 Kontrollstrukturen]] · **Bereich:** Kontrollstrukturen · **Schwierigkeit:** ★☆☆☆☆
**Klasse:** `MultiplicationTable` · **Package:** `de.dhbwka.java.exercise.control`

📄 Aufgabe: [[Material/Aufgaben/06_Kontrollstrukturen_Aufgaben.pdf#page=4|06_Kontrollstrukturen_Aufgaben.pdf, S. 4]]
✅ Musterlösung: [[Material/Aufgaben/06_Kontrollstrukturen_Aufgaben_Muster.pdf#page=4|06_Kontrollstrukturen_Aufgaben_Muster.pdf, S. 4]]

> [!question] Kurz gesagt
> Entwickeln Sie ein Programm MultiplicationTable, welches das kleine Einmaleins in Tabellenform (10x10-Tabelle) berechnet und ausgibt! Beispielausgabe: 1 2 3 4 5 6 7 8 9 10 2 4 6 8 10 12 14 16 18 20 3 6 9 12 15 18 21 24 27 30 4 8 12 16 20 24 28 32 36 40 5 10 15 20 25 30 35 40 45 50 6 12 18 24 30 36 42 48 54 60 7 14 21 28 35 42 49 56 63 70 8 16 24 32 40 48 56 64 72 80 9 18 27 36 45 54 63 72 81 90 …

## Aufgabenstellung
```text
Entwickeln Sie ein Programm MultiplicationTable, welches das kleine Einmaleins in
Tabellenform (10x10-Tabelle) berechnet und ausgibt!

Beispielausgabe:

    1      2      3     4       5    6    7    8    9 10
    2      4      6     8      10   12   14   16   18 20
    3      6      9    12      15   18   21   24   27 30
    4      8     12    16      20   24   28   32   36 40
    5     10     15    20      25   30   35   40   45 50
    6     12     18    24      30   36   42   48   54 60
    7     14     21    28      35   42   49   56   63 70
    8     16     24    32      40   48   56   64   72 80
    9     18     27    36      45   54   63   72   81 90
   10     20     30    40      50   60   70   80   90 100
```

## Benötigte Begriffe
[[Formatierte Ausgabe]] · [[for-Schleife]]

## Weitere Übungen zum Thema
[[Ü06 Schaltjahr]] · [[Ü06 Temperaturtabelle]] · [[Ü06 Wildbestand]] · [[Ü06 Aufsummieren]] · [[Ü06 Schuhgrößen]] · [[Ü06 Babylonisches Wurzelziehen (Heronverfahren)]] · [[Ü06 Zahlenraten]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.control;
> 
> public class MultiplicationTable {
> 
>     public static void main(String[] args) {
>         // multiplication table 10x10
>         for (int i = 1; i <= 10; i++) {
>             for (int j = 1; j <= 10; j++) {
>                 System.out.printf("%4d",i*j);
>             }
>             System.out.println(); // next line
>         }
>     }
> 
> }
> 
> Beispielausgabe:
> 
> 1    2    3    4     5    6     7    8     9 10
> 2    4    6    8    10   12    14   16    18 20
> 3    6    9   12    15   18    21   24    27 30
> 4    8   12   16    20   24    28   32    36 40
> 5   10   15   20    25   30    35   40    45 50
> 6   12   18   24    30   36    42   48    54 60
> 7   14   21   28    35   42    49   56    63 70
> 8   16   24   32    40   48    56   64    72 80
> 9   18   27   36    45   54    63   72    81 90
> 10   20   30   40    50   60    70   80    90 100
> ```

## Meine Notizen

