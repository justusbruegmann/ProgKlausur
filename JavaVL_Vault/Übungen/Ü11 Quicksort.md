---
tags: ["typ/uebung", "thema/methoden", "kategorie/grundlagen", "semester/1", "schwierigkeit/3"]
aliases: ["Quicksort"]
thema: "[[11 Methoden – Parameterübergabe und Rekursion]]"
klasse: "Quicksort"
package: "de.dhbwka.java.exercise.methods"
schwierigkeit: 3
status: "offen"
---

# Ü11 Quicksort

**Thema:** [[11 Methoden – Parameterübergabe und Rekursion]] · **Bereich:** Methoden-Spezial · **Schwierigkeit:** ★★★☆☆
**Klasse:** `Quicksort` · **Package:** `de.dhbwka.java.exercise.methods`

📄 Aufgabe: [[Material/Aufgaben/11_Methoden-Special_Aufgaben.pdf#page=3|11_Methoden-Special_Aufgaben.pdf, S. 3]]
⚠️ Zu diesem Blatt gibt es auf der Webseite keine Musterlösung (Link defekt).

> [!question] Kurz gesagt
> Quicksort ist ein schneller, rekursiver, nicht-stabiler Sortieralgorithmus, der nach dem Prinzip „teile und herrsche“ arbeitet. Er wurde ca. 1960 von C.

## Aufgabenstellung
```text
Quicksort ist ein schneller, rekursiver, nicht-stabiler Sortieralgorithmus, der nach dem Prinzip „teile
und herrsche“ arbeitet. Er wurde ca. 1960 von C. Antony R. Hoare in seiner Grundform entwickelt
und seitdem von vielen Forschern verbessert. Der Algorithmus hat den Vorteil, dass er über eine
sehr kurze innere Schleife verfügt (was die Ausführungsgeschwindigkeit stark erhöht) und ohne
zusätzlichen Speicherplatz auskommt (abgesehen von dem für die Rekursion zusätzlichen benötig-
ten Platz auf dem Aufruf-Stack).
                                                        [Quelle und weitere Info inkl. Beispiel: Wikipedia]

Implementieren Sie “Quicksort” in Java für Arrays von int-Werten! Die Methoden sollen neben der
linken und rechten Grenze jeweils auch eine Referenz auf ein Array bekommen.
Implementieren Sie auch eine (statische) Methode
public static void sort(int[] array),
die ein beliebig großes Array (ohne die Angabe von Grenzen) sortieren kann!

Beispielausgabe:

Unsortierte Zahlenfolge:
9 2 5 7 8 3 4 10 1 6

Sortierte Zahlenfolge:
1 2 3 4 5 6 7 8 9 10

Algorithmus „Quicksort“ s. nächste Seite.

Der Quicksort-Algorithmus

daten[] = { …… } // Aufzählung von Elementen, hierauf operiert Quicksort
quicksort(0, daten.length-1)

funktion quicksort(links, rechts)
     falls links < rechts dann
          teiler := teile(links, rechts)
          quicksort(links, teiler-1)
          quicksort(teiler+1, rechts)
     ende
ende

funktion teile(links, rechts)
    // Ziel ist es hier, das Array in zwei Teile zu teilen.
    // Dazu wählen wir ein Pivotelement, mit dem wir alle Elemente des
    // Arrays vergleichen. Wir legen die beiden Teile des Arrays so an,
    // dass der linke alle kleineren Elemente enthält, der rechte Teil
    // alle größeren.
    // Wir tauschen hierzu, falls notwendig nicht passende Elemente.

       // wähle rechtes Element als Pivotelement aus
       // und starte mit j links vom Pivotelement
       i := links
       j := rechts - 1
       pivot := daten[rechts]

       wiederhole
           // Suche von links ein Element, das größer als das Pivot ist
           wiederhole solange daten[i] ≤ pivot und i < rechts
                i := i + 1
           ende
           // Suche von rechts ein Element, das kleiner als das Pivot ist
           wiederhole solange daten[j] ≥ pivot und j > links
                 j := j - 1
           ende
           falls i < j dann
                tausche daten[i] mit daten[j]
           ende
       solange i < j // solange i an j nicht vorbeigelaufen ist

       // Tausche das Pivotelement mit seiner endgültigen Position i
       falls daten[i] > pivot dann
            tausche daten[i] mit daten[rechts]
       ende
       // gib die Position des Pivotelements zurück
       antworte i
ende
```

## Benötigte Begriffe
[[Array]] · [[Sortieren]] · [[Rekursion]] · [[Stack]]

## Weitere Übungen zum Thema
[[Ü11 Potenzen]] · [[Ü11 Fibonacci-Zahlen rekursiv]]

## Meine Notizen

