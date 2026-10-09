---
tags: ["typ/uebung", "thema/klassen", "kategorie/oop", "semester/1", "schwierigkeit/3", "hat/musterloesung"]
aliases: ["Horner"]
thema: "[[09 Klassen und Objekte]]"
klasse: "Horner"
package: "de.dhbwka.java.exercise.classes"
schwierigkeit: 3
status: "offen"
---

# Ü09 Polynome und Horner-Schema

**Thema:** [[09 Klassen und Objekte]] · **Bereich:** Klassen (2) · **Schwierigkeit:** ★★★☆☆
**Klasse:** `Horner` · **Package:** `de.dhbwka.java.exercise.classes`

📄 Aufgabe: [[Material/Aufgaben/09_Klassen_Aufgaben-2.pdf#page=4|09_Klassen_Aufgaben-2.pdf, S. 4]]
✅ Musterlösung: [[Material/Aufgaben/09_Klassen_Aufgaben-2_Muster.pdf#page=6|09_Klassen_Aufgaben-2_Muster.pdf, S. 6]]

> [!question] Kurz gesagt
> Das Horner-Schema (nach William George Horner) ist ein Umformungsverfahren für Polynome, um die Berechnung von Funktionswerten so einfach wie möglich zu machen. Bei Polynomen in einer Variablen x erfordert das Auswerten an einer Stelle x \= a in der klassischen Form die Berechnung der Potenzen ak.

## Aufgabenstellung
```text
Das Horner-Schema (nach William George Horner) ist ein Umformungsverfahren für Polynome, um
die Berechnung von Funktionswerten so einfach wie möglich zu machen.

Bei Polynomen in einer Variablen x erfordert das Auswerten an einer Stelle x = a in der klassischen
Form die Berechnung der Potenzen ak. Die Umformung des Polynoms nach dem Horner-Schema
beschleunigt die Berechnung, indem überflüssige Berechnungen bei den Potenzen vermieden
werden. Erfolgt die Auswertung durch Gleitkommaoperationen, so wird darüber hinaus auch der
Rechenfehler geringer gehalten.
Durch fortgesetztes Ausklammern der freien Polynomvariablen x wird das Polynom als Schachtelung
von Produkten und Summen dargestellt. In der umgewandelten Darstellung kommt keine
Potenzfunktion, sondern nur noch Multiplikation und Addition vor.

Beispiel:
Zur Illustration an einem Beispiel sortieren wir die Terme des Polynoms nach aufsteigenden
Potenzen; das Ausklammern zur Überführung in das Horner-Schema arbeitet die Terme dann von
rechts nach links ab:

Die Beschleunigung der Auswertung an einer Stelle x kann man an diesem Beispiel wie folgt
quantifizieren: In der klassischen Darstellung (linke Seite) werden 7 Multiplikationen benötigt, davon
3 zur Bildung der Potenzen x2, x3, x4. Im Horner-Schema (rechte Seite) kommt man dagegen mit 4
Multiplikationen aus. Die Zahl der – rechnerisch weniger aufwendigen – Additionen ist in beiden
Fällen gleich, nämlich 4.
Generell wird der Aufwand für Multiplikationen durch die Anwendung des Horner-Schemas auf fast
die Hälfte reduziert.

    a) Schreiben Sie eine Klasse Horner, welche Polynome beliebigen Grades darstellen kann!
    b) Erstellen Sie Konstruktor(en) zum Erzeugen eines beliebigen Polynoms!
    c) Implementieren Sie eine Methode getValue(double x), welche für eine beliebige
       Gleitkommazahl x den Funktionswert des Polynoms gemäß dem Hornerschema berechnet!
    d) Implementieren Sie eine Methode toString() zur Darstellung als Zeichenkette
    e) Testen Sie Ihre Klasse mit Polynomen 10. Grades!

Beispielausgabe:

Polynomial f: 0.5*x^10 -3.0*x^9 +2.0*x^8 +4.0*x^7 +3.0*x^6 -10.0*x^5
+8.0*x^4 +4.5*x^3 +3.0*x^2 -2.0*x^1 +1.0*x^0
f(1.5) = 51.77587890625
```

## Benötigte Begriffe
[[for-Schleife]] · [[Array]] · [[Sortieren]] · [[Konstruktor]] · [[this]] · [[toString]] · [[Überschreiben]] · [[String]] · [[StringBuilder und StringBuffer]]

## Weitere Übungen zum Thema
[[Ü09 Radio]] · [[Ü09 Zweidimensionaler Punkt]] · [[Ü09 Bankkonto]] · [[Ü09 Polynom 2. Grades]] · [[Ü09 Komplexe Zahlen]] · [[Ü09 Nimmspiel]] · [[Ü09 Lotto]] · [[Ü09 MasterMind]] · [[Ü09 Wechselspiel (1. Teil)]] · [[Ü09 Wechselspiel (2. Teil)]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.classes;
> 
> public class Horner {
> 
>     // coefficients coeff[0] for x^0, coeff[1] for x^1, etc.
>     double[] coeff;
> 
>     Horner() {
>         this(new double[0]);
>     }
> 
>     Horner(double[] coeff) {
>         this.coeff = coeff;
>     }
> 
>     /** calculate value of Polynomial for a given x
>      * using Horner scheme
>      * @param x
>      * @return value of Polynomial for a given x
>      */
>     public double getValue(double x) {
>         if (coeff.length>0) {
>             double sum = coeff[coeff.length-1];
>             for (int i = coeff.length-2; i >= 0; i--)
>             sum = sum * x + coeff[i];
>             return sum;
>         } else
>         return 0;
>     }
> 
>     @Override
>     public String toString() {
>         StringBuffer s = new StringBuffer("");
>         for (int i = coeff.length-1; i >= 0; i--) {
>             s.append(coeff[i]+"*x^"+i+" ");
>             if (i>0 && coeff[i-1] >= 0)
>             s.append("+");
>         }
>         return s.toString();
>     }
> 
>     public static void main(String[] args) {
>         double[] k = {1,-2,3,4.5,8,-10,3,4,2,-3,0.5};
>         Horner p = new Horner(k);
>         double x = 1.5;
>         System.out.println("Polynomial f: " + p.toString());
>         System.out.println("f(" + x + ") = " + p.getValue(x));
>     }
> 
> }
> ```

## Meine Notizen

