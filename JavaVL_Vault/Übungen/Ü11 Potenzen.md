---
tags: ["typ/uebung", "thema/methoden", "kategorie/grundlagen", "semester/1", "schwierigkeit/1"]
aliases: ["Exponentiation"]
thema: "[[11 Methoden – Parameterübergabe und Rekursion]]"
klasse: "Exponentiation"
package: "de.dhbwka.java.exercise.methods"
schwierigkeit: 1
status: "offen"
---

# Ü11 Potenzen

**Thema:** [[11 Methoden – Parameterübergabe und Rekursion]] · **Bereich:** Methoden-Spezial · **Schwierigkeit:** ★☆☆☆☆
**Klasse:** `Exponentiation` · **Package:** `de.dhbwka.java.exercise.methods`

📄 Aufgabe: [[Material/Aufgaben/11_Methoden-Special_Aufgaben.pdf#page=1|11_Methoden-Special_Aufgaben.pdf, S. 1]]
⚠️ Zu diesem Blatt gibt es auf der Webseite keine Musterlösung (Link defekt).

> [!question] Kurz gesagt
> Die n-te Potenz einer reellen Zahl x kann auch rekursiv über folgende Rechenvorschrift berechnet werden (n: ganze Zahl, n  0): 1 für n  0 xn   n 1  x x für n  0 Schreiben Sie eine Klasse Exponentiation mit einer (statischen) rekursiven Methode

## Aufgabenstellung
```text
Die n-te Potenz einer reellen Zahl x kann auch rekursiv über folgende Rechenvorschrift berechnet
werden (n: ganze Zahl, n  0):

                   1           für n  0
              xn       n 1
                    x x       für n  0

Schreiben Sie eine Klasse Exponentiation mit einer (statischen) rekursiven Methode
public static double xPowerN(double x,int n),
welche xn entsprechend dieser Rechenvorschrift berechnet. Verwenden Sie diese Methode in einer
main-Methode (oder in einer anderen Klasse), welche die Basis x und den Exponenten n einliest
sowie xn mit Hilfe der Methode xPowerN bestimmt und ausgibt.

Beispieldialog:

Geben Sie bitte die Basis ein: 3,0
Geben Sie bitte den positiven ganzzahligen Exponenten ein: 3
3.0^ 3 = 27.0

Hinweis:
Schauen Sie sich die Parameter- und Rückgabewerte mit Hilfe des Debuggers oder mit Hilfe von
Kontrollausgaben an.
```

## Benötigte Begriffe
[[Rekursion]]

## Weitere Übungen zum Thema
[[Ü11 Fibonacci-Zahlen rekursiv]] · [[Ü11 Quicksort]]

## Meine Notizen

