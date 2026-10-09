---
tags: ["typ/uebung", "thema/klassen", "kategorie/oop", "semester/1", "schwierigkeit/5"]
aliases: ["Wechselspiel"]
thema: "[[09 Klassen und Objekte]]"
klasse: "Wechselspiel"
package: "de.dhbwka.java.exercise.classes"
schwierigkeit: 5
status: "offen"
---

# Ü09 Wechselspiel (1. Teil)

**Thema:** [[09 Klassen und Objekte]] · **Bereich:** Klassen\* · **Schwierigkeit:** ★★★★★
**Klasse:** `Wechselspiel` · **Package:** `de.dhbwka.java.exercise.classes`

📄 Aufgabe: [[Material/Aufgaben/09_Klassen_Aufgaben-Sternchen.pdf#page=1|09_Klassen_Aufgaben-Sternchen.pdf, S. 1]]

> [!question] Kurz gesagt
> Diese Aufgabe ist für „sehr gute“ Studierende, denen die anderen Aufgaben „zu einfach“ sind. Sie geht weit über das erwartete Niveau zu diesem Zeitpunkt der Vorlesung hinaus!

## Aufgabenstellung
```text
Diese Aufgabe ist für „sehr gute“ Studierende, denen die anderen Aufgaben „zu einfach“ sind. Sie
geht weit über das erwartete Niveau zu diesem Zeitpunkt der Vorlesung hinaus!

Schreiben Sie eine Klasse Spielfeld, welche die Logik des folgenden Spiels implementiert:

Es gibt ein Spielfeld mit 9x9 Feldern. Jedes Feld hat eine aus insgesamt 7 Farben.

Am Anfang wird das Spielfeld zufällig so mit Farben initialisiert, dass an keiner Stelle 3 neben- oder
übereinander liegende Felder dieselbe Farbe haben (Diagonalen spielen keine Rolle), z.B.:

                                     A B C D         E   F   G H     I
                                 1
                                 2
                                 3
                                 4
                                 5
                                 6
                                 7
                                 8
                                 9

Der Spieler darf nun in jeder Spielrunde zwei horizontal oder vertikal nebeneinander liegende Felder
miteinander tauschen, jedoch nur dann, wenn dadurch eine senkrechte oder waagrechte Reihe mit
mindestens 3 gleichfarbigen Feldern entsteht. (Beispiel: Tausche die Felder B4 und C4.) Macht der
Spieler einen ungültigen Zug, wird dieser ignoriert.

                                     A B C D         E   F   G H     I
                                 1
                                 2
                                 3
                                 4
                                 5
                                 6
                                 7
                                 8
                                 9

Durch eine solche Tauschoperation („Wechsel“) ist nun mindestens eine Reihe (im Beispiel
C2,C3,C4) von mindestens 3 gleichfarbigen Feldern entstanden – es können im Allgemeinen aber
auch mehrere gleichfarbige Reihen entstanden sein.

Für eine Reihe von 3 gleichfarbigen Feldern erhält der Spieler 30 Punkte, für 4 Felder 40 Punkte, für
5 Felder 50 Punkte. (Mehr als 5 Felder können durch einmaliges Tauschen nicht in einer Reihe
entstehen, der Beweis dafür sei als weitere Übungsaufgabe überlassen… )
Sind mehrere wertbare Reihen entstanden, erhält der Spieler die Summe der Einzelwertungen. Ein
einzelnes Feld kann dabei auch Bestandteil von zwei Reihen (einer senkrechten und einer
waagrechten) sein.

Nach der Punktwertung werden die Farben der Reihe(n) entfernt. Alle „über“ einem so frei
gewordenen Feld gelegenen Felder rutschen nun so lange nach unten „wie Platz ist“ – alle Spalten
haben danach nur noch „von oben her“ freie Felder (in der folgenden Abbildung schwarz).

                                     A B C D        E   F    G H    I
                                 1
                                 2
                                 3
                                 4
                                 5
                                 6
                                 7
                                 8
                                 9

Die nun vorhandenen freien Zellen werden wieder zufällig mit Farben gefüllt.

Entstehen dabei wieder Reihen von 3 bis 5 gleichfarbigen Zellen, wiederholen sich die
Punktewertung, das Herunterfallen und das Auffüllen so lange, bis keine wertbaren Reihen mehr
entstehen.

                                     A B C D        E   F    G H    I
                                 1
                                 2
                                 3
                                 4
                                 5
                                 6
                                 7
                                 8
                                 9

Hier entstand durch das Auffüllen erneut eine 3er-Reihe (B2, C2, D2).
Es findet also eine erneute Punktwertung statt, die Reihe wird ausgeschnitten, die oberhalb
liegenden Felder „fallen“ nach unten und es wird wieder von oben zufällig aufgefüllt.

                                     A B C D        E   F    G H   I
                                 1
                                 2
                                 3
                                 4
                                 5
                                 6
                                 7
                                 8
                                 9

                                     A B C D        E   F    G H   I
                                 1
                                 2
                                 3
                                 4
                                 5
                                 6
                                 7
                                 8
                                 9

Entwickeln Sie eine Klasse Spielfeld, welche die Spiellogik und alle notwendigen Methoden
enthält um das Spiel „von außerhalb“ der Klasse zu steuern und den Zustand abzufragen!

Implementieren Sie diese Klasse so flexibel, dass das Spielfeld abhängig von Konstanten eine
beliebige Größe annehmen kann und man auch die Anzahl der Farben variieren kann. Die Farbwerte
sollen durch ganze Zahlen von 0 bis n-1 repräsentiert werden.

Die Klasse Spielfeld soll grundsätzlich unabhängig von der Benutzeroberfläche funktionieren.

Implementieren Sie eine weitere Klasse Wechselspiel mit einer main-Methode, welche das
Spiel auf der Konsole durchführt. Der Spieler soll das Spielfeld als textuelle Ausgabe präsentiert
bekommen (die Farben werden durch Zahlwerte von 0 bis n-1 dargestellt). Ein Raster (hier A-I bzw.
0-9) sollte ebenfalls ausgegeben werden. Nach jeder Runde soll auch der Spielstand (Punkte)
ausgegeben werden.

Der Spieler soll Eingaben der Form „B2B3“ machen können, um die Spielzüge zu wählen.
(In einer weiteren Teilaufgabe wird es darum gehen, für dieses Spiel eine grafische
Benutzeroberfläche zu implementieren.)

Wenn es sinnvoll und möglich ist implementieren Sie Teile des Spiels in eigenen Klassen!
```

## Benötigte Begriffe
[[Konstante]] · [[Zufallszahlen]] · [[Array]] · [[Swing]] · [[Farben und Schriften]]

## Weitere Übungen zum Thema
[[Ü09 Radio]] · [[Ü09 Zweidimensionaler Punkt]] · [[Ü09 Bankkonto]] · [[Ü09 Polynom 2. Grades]] · [[Ü09 Komplexe Zahlen]] · [[Ü09 Polynome und Horner-Schema]] · [[Ü09 Nimmspiel]] · [[Ü09 Lotto]] · [[Ü09 MasterMind]] · [[Ü09 Wechselspiel (2. Teil)]]

## Meine Notizen

