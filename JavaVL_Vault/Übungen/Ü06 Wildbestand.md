---
tags: ["typ/uebung", "thema/kontrollstrukturen", "kategorie/grundlagen", "semester/1", "schwierigkeit/1", "hat/musterloesung"]
aliases: ["Deers"]
thema: "[[06 Kontrollstrukturen]]"
klasse: "Deers"
package: "de.dhbwka.java.exercise.control"
schwierigkeit: 1
status: "offen"
---

# Ü06 Wildbestand

**Thema:** [[06 Kontrollstrukturen]] · **Bereich:** Kontrollstrukturen · **Schwierigkeit:** ★☆☆☆☆
**Klasse:** `Deers` · **Package:** `de.dhbwka.java.exercise.control`

📄 Aufgabe: [[Material/Aufgaben/06_Kontrollstrukturen_Aufgaben.pdf#page=3|06_Kontrollstrukturen_Aufgaben.pdf, S. 3]]
✅ Musterlösung: [[Material/Aufgaben/06_Kontrollstrukturen_Aufgaben_Muster.pdf#page=3|06_Kontrollstrukturen_Aufgaben_Muster.pdf, S. 3]]

> [!question] Kurz gesagt
> Der Wildbestand eines Forstes umfasst zu Beginn 200 Hirsche. Die jährliche Vermehrung beträgt 10% des Jahresanfangsbestands; im Herbst werden 15 Stück zum Abschuss freigegeben.

## Aufgabenstellung
```text
Der Wildbestand eines Forstes umfasst zu Beginn 200 Hirsche.

Die jährliche Vermehrung beträgt 10% des Jahresanfangsbestands; im Herbst werden 15 Stück zum
Abschuss freigegeben.

Wie entwickelt sich der Bestand in den nächsten Jahren?

Erstellen Sie ein Programm Deers, das den jährlichen Wildbestand ermittelt und ausgibt, bis dieser
mindestens die Zahl 300 erreicht hat!

Beispielausgabe:

1: 205 Hirsche
2: 210 Hirsche
3: 216 Hirsche
4: 222 Hirsche
5: 229 Hirsche
6: 236 Hirsche
7: 244 Hirsche
8: 253 Hirsche
9: 263 Hirsche
10: 274 Hirsche
11: 286 Hirsche
12: 299 Hirsche
13: 313 Hirsche
```

## Benötigte Begriffe
[[Typkonversion]] · [[while-Schleife]]

## Weitere Übungen zum Thema
[[Ü06 Schaltjahr]] · [[Ü06 Temperaturtabelle]] · [[Ü06 Einmaleins]] · [[Ü06 Aufsummieren]] · [[Ü06 Schuhgrößen]] · [[Ü06 Babylonisches Wurzelziehen (Heronverfahren)]] · [[Ü06 Zahlenraten]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.control;
> 
> public class Deers {
> 
>     public static void main(String[] args) {
>         int deers = 200;
>         int iteration = 0;
>         do {
>             deers = (int) ((deers * 1.1) - 15);
>             System.out.println(++iteration + ": " + deers + " Hirsche");
>         } while (deers < 300);
>     }
> 
> }
> 
> Beispielausgabe:
> 
> 1: 205 Hirsche
> 2: 210 Hirsche
> 3: 216 Hirsche
> 4: 222 Hirsche
> 5: 229 Hirsche
> 6: 236 Hirsche
> 7: 244 Hirsche
> 8: 253 Hirsche
> 9: 263 Hirsche
> 10: 274 Hirsche
> 11: 286 Hirsche
> 12: 299 Hirsche
> 13: 313 Hirsche
> ```

## Meine Notizen

