---
tags: ["typ/uebung", "thema/zeichnen", "kategorie/gui", "semester/2", "schwierigkeit/2"]
aliases: ["ClickRectFiller"]
thema: "[[24 Zeichnen in Swing]]"
klasse: "ClickRectFiller"
package: "de.dhbwka.java.exercise.ui.paint"
schwierigkeit: 2
status: "offen"
---

# Ü24 ClickFiller

**Thema:** [[24 Zeichnen in Swing]] · **Bereich:** Zeichnen · **Schwierigkeit:** ★★☆☆☆
**Klasse:** `ClickRectFiller` · **Package:** `de.dhbwka.java.exercise.ui.paint`

📄 Aufgabe: [[Material/Aufgaben/24_Zeichnen_Aufgaben.pdf#page=1|24_Zeichnen_Aufgaben.pdf, S. 1]]

> [!question] Kurz gesagt
> Erstellen sie eine Klasse ClickRectFiller, welche zunächst 3 gleichartige Rechtecke nebeneinander (oder untereinander) zeichnet. Realisieren Sie die Aufgabe so, dass nicht direkt im JFrame gezeichnet wird, sondern eine eigene Komponente verwendet wird (welche von JComponent erbt).

## Aufgabenstellung
```text
Erstellen sie eine Klasse ClickRectFiller, welche zunächst 3 gleichartige Rechtecke
nebeneinander (oder untereinander) zeichnet. Realisieren Sie die Aufgabe so, dass nicht direkt im
JFrame gezeichnet wird, sondern eine eigene Komponente verwendet wird (welche von
JComponent erbt). Überschreiben Sie zum Zeichnen die paintComponent-Methode der
Komponente!

Implementieren Sie anschließend ein Eventhandling, welches dafür sorgt, dass bei einem Klick in
eines der Rechtecke das entsprechende Rechteck eingefärbt wird. Dabei soll jedes Rechteck in einer
unterschiedlichen Farbe eingefärbt werden. Außerdem soll beim Klick in eines der anderen
Rechtecke nur das zuvor angeklickte Rechteck eingefärbt werden, das zuvor gefärbte Rechteck soll
also in seinen Ursprungszustand zurückkehren. Beim Klick außerhalb der Rechtecke sollen alle
Rechtecke wieder in den Ursprungszustand zurückkehren.

Hinweis:
Das Neuzeichnen einer Komponente kann durch den Aufruf der repaint-Methode ausgelöst
werden. Um eine komplette Neuzeichnung der Komponente zu veranlassen, kann man zu Beginn der
Methode die repaint-Methode der Oberklasse mit dem gleichen Graphics-Objekt aufrufen.
```

## Benötigte Begriffe
[[Vererbung]] · [[Überschreiben]] · [[JFrame]] · [[Farben und Schriften]] · [[Listener]] · [[Zeichnen mit Graphics]]

## Weitere Übungen zum Thema
[[Ü24 Wahl]]

## Meine Notizen

