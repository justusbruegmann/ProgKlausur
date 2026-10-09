---
tags: ["typ/uebung", "thema/kontrollstrukturen", "kategorie/grundlagen", "semester/1", "schwierigkeit/2", "hat/musterloesung"]
aliases: ["Babylon"]
thema: "[[06 Kontrollstrukturen]]"
klasse: "Babylon"
package: "de.dhbwka.java.exercise.control"
schwierigkeit: 2
status: "offen"
---

# Ü06 Babylonisches Wurzelziehen (Heronverfahren)

**Thema:** [[06 Kontrollstrukturen]] · **Bereich:** Kontrollstrukturen · **Schwierigkeit:** ★★☆☆☆
**Klasse:** `Babylon` · **Package:** `de.dhbwka.java.exercise.control`

📄 Aufgabe: [[Material/Aufgaben/06_Kontrollstrukturen_Aufgaben.pdf#page=7|06_Kontrollstrukturen_Aufgaben.pdf, S. 7]]
✅ Musterlösung: [[Material/Aufgaben/06_Kontrollstrukturen_Aufgaben_Muster.pdf#page=8|06_Kontrollstrukturen_Aufgaben_Muster.pdf, S. 8]]

> [!question] Kurz gesagt
> Das Babylonische Wurzelziehen (oft auch Heron-Verfahren) ist ein alter iterativer Algorithmus zur Bestimmung einer rationalen Näherung der Quadratwurzel einer Zahl. Es ist ein Spezialfall des Newton-Verfahrens.

## Aufgabenstellung
```text
Das Babylonische Wurzelziehen (oft auch Heron-Verfahren) ist ein alter iterativer Algorithmus zur
Bestimmung einer rationalen Näherung der Quadratwurzel einer Zahl. Es ist ein Spezialfall des
Newton-Verfahrens.

Die Iterationsvorschrift lautet:
                                                             a
                                                      xn +
                                                             xn
                                           x n +1 =
                                                        2

Hierbei steht a für die Zahl, deren Quadratwurzel bestimmt werden soll. Der Startwert x0 der
Iteration kann, solange er nicht gleich 0 (Null) ist, beliebig festgesetzt werden, wobei zu beachten
ist, dass negative Werte gegen die negative Quadratwurzel konvergieren.

Implementieren Sie das Babylonische Wurzelziehen so, dass eine Zahl eingelesen und deren Wurzel
auf 6 Stellen hinter dem Komma genau berechnet wird (bzw. bis der Betrag von xn+1 - xn kleiner als
10-6 ist)! Geben Sie zur Kontrolle die Werte der einzelnen Berechnungsschritte aus!

Hinweis:
Zur Berechnung des Betrages können Sie die Methode Math.abs() benutzen.

Beispieldialog:

Wurzel aus welcher Zahl ziehen? 25
xn: 1.0
xn: 13.0
xn: 7.461538461538462
xn: 5.406026962727994
xn: 5.015247601944898
xn: 5.000023178253949
xn: 5.000000000053722

Die Wurzel aus 25.0 ist 5.0
```

## Benötigte Begriffe
[[Scanner]] · [[Math-Klasse]] · [[while-Schleife]]

## Weitere Übungen zum Thema
[[Ü06 Schaltjahr]] · [[Ü06 Temperaturtabelle]] · [[Ü06 Wildbestand]] · [[Ü06 Einmaleins]] · [[Ü06 Aufsummieren]] · [[Ü06 Schuhgrößen]] · [[Ü06 Zahlenraten]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.control;
> 
> import java.util.Scanner;
> 
> public class Babylon {
> 
>     public static void main(String[] args) {
>         Scanner scan = new Scanner(System.in);
>         System.out.print("Wurzel aus welcher Zahl ziehen? ");
>         double a = scan.nextDouble();
>         scan.close();
> 
>         double xn = 1.0; // randomly selected as x0
>         double oldxn;
>         do {
>             oldxn = xn;
>             xn = (xn + (a / xn)) / 2;
>         } while (Math.abs(oldxn-xn)>=10E-6);
>         System.out.println("Die Wurzel aus " + a + " ist " + xn);
>     }
> 
> }
> 
> Beispielausgabe:
> 
> Wurzel aus welcher Zahl ziehen? 25
> xn: 1.0
> xn: 13.0
> xn: 7.461538461538462
> xn: 5.406026962727994
> xn: 5.015247601944898
> xn: 5.000023178253949
> xn: 5.000000000053722
> Die Wurzel aus 25.0 ist 5.0
> ```

## Meine Notizen

