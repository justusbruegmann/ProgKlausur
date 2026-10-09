---
tags: ["typ/uebung", "thema/klassen", "kategorie/oop", "semester/1", "schwierigkeit/2", "hat/musterloesung"]
aliases: ["Polynomial"]
thema: "[[09 Klassen und Objekte]]"
klasse: "Polynomial"
package: "de.dhbwka.java.exercise.classes"
schwierigkeit: 2
status: "offen"
---

# Ü09 Polynom 2. Grades

**Thema:** [[09 Klassen und Objekte]] · **Bereich:** Klassen (2) · **Schwierigkeit:** ★★☆☆☆
**Klasse:** `Polynomial` · **Package:** `de.dhbwka.java.exercise.classes`

📄 Aufgabe: [[Material/Aufgaben/09_Klassen_Aufgaben-2.pdf#page=1|09_Klassen_Aufgaben-2.pdf, S. 1]]
✅ Musterlösung: [[Material/Aufgaben/09_Klassen_Aufgaben-2_Muster.pdf#page=1|09_Klassen_Aufgaben-2_Muster.pdf, S. 1]]

> [!question] Kurz gesagt
> Schreiben Sie eine Klasse Polynomial, die Polynome 2. Grades repräsentiert!

## Aufgabenstellung
```text
Schreiben Sie eine Klasse Polynomial, die Polynome 2. Grades repräsentiert!
Ein Polynom dieser Klasse hat allgemein das folgende Aussehen:

                                             ax 2  bx  c

Erstellen Sie einen oder mehrere geeignete Konstruktoren!

Erstellen Sie Instanzenmethoden für folgende Operationen:
     String-Darstellung eines Polynoms (z.B. “1.0x^2 -2.0x +3.0“)
     Berechnen des Funktionswertes f(x) eines Polynoms.
     Addition/Subtraktion zweier Polynome. Das Ergebnis ist ein neues Polynom.
     Multiplikation mit einem Skalar. Das Ergebnis ist ein neues Polynom.
     Berechnung der reellen Nullstellen des Polynoms.

Testen Sie Ihre Klasse mit einer main()-Methode oder mit einer anderen Klasse.

Hinweis:
Als Rückgabewert der Methode für die Berechnung der Nullstellen kann man ein Array mit
geeigneter Länge verwenden (Länge 0 wenn es keine reelle Nullstelle gibt, 1 bei einer und 2 bei zwei
reellen Nullstellen).

Beispielausgabe:

P1: 2.0x^2 +0.0x +0.0
P2: 0.0x^2 -4.0x +1.0
P3 = P1 + P2: 2.0x^2 -4.0x +1.0
P3 = 2.0 * P3: 4.0x^2 -8.0x +2.0
Nullstellen von P3 (4.0x^2 -8.0x +2.0):
1.7071067811865475 0.2928932188134524
```

## Benötigte Begriffe
[[Math-Klasse]] · [[for-Schleife]] · [[Array]] · [[Konstruktor]] · [[this]] · [[toString]] · [[Überschreiben]] · [[super]]

## Weitere Übungen zum Thema
[[Ü09 Radio]] · [[Ü09 Zweidimensionaler Punkt]] · [[Ü09 Bankkonto]] · [[Ü09 Komplexe Zahlen]] · [[Ü09 Polynome und Horner-Schema]] · [[Ü09 Nimmspiel]] · [[Ü09 Lotto]] · [[Ü09 MasterMind]] · [[Ü09 Wechselspiel (1. Teil)]] · [[Ü09 Wechselspiel (2. Teil)]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.classes;
> 
> public class Polynomial {
> 
>     /* polynomial 2nd degree like ax^2 + bx + c */
>     double a, b, c;
> 
>     public Polynomial() {
>         this(0.0, 0.0, 0.0);
>     }
> 
>     public Polynomial(double a, double b, double c) {
>         super();
>         this.a = a;
>         this.b = b;
>         this.c = c;
>     }
> 
>     public double f(double x) {
>         return a*x*x + b*x + c;
>     }
> 
>     public Polynomial sub(Polynomial p) {
>         return new Polynomial(a-p.a,b-p.b,c-p.c);
>     }
> 
>     public Polynomial add(Polynomial p) {
>         return new Polynomial(a+p.a,b+p.b,c+p.c);
>     }
> 
>     public Polynomial scale(double factor) {
>         return new Polynomial(factor*a,factor*b,factor*c);
>     }
> 
>     /** get zeros using the 'midnight formula'
>     /* x1/2 = ( -b +/- sqrt(b*b-4*a*c) ) / 2a */
>     public double[] getZeros() {
>         if (a == 0) {
>             if (b == 0) { // no zeros
>                 return new double[0];
>             } else { // 1 zero
>                 return new double[]{-c / b};
>             }
>         } else if (b * b < 4 * a * c) // no zeros
>         return new double[0];
>         else if (b*b==4*a*c) // 1 zero
>         return new double[] { -b/(2*a) };
>         else // 2 zeros
>         return new double[] {
>             (-b+Math.sqrt(b*b-4*a*c))/(2*a),
>             (-b-Math.sqrt(b*b-4*a*c))/(2*a)
>         };
>     }
> 
>     @Override
>     public String toString() {
>         return a+"x^2 " + (b>=0 ? "+":"") + b+"x "
>         + (c>=0 ? "+":"") + c;
>     }
> 
>     public static void main(String[] args) {
>         Polynomial pol1 = new Polynomial(2,0,0);
>         System.out.println("P1: " + pol1);
>         Polynomial pol2 = new Polynomial(0,-4,1);
>         System.out.println("P2: " + pol2);
>         Polynomial pol3 = pol1.add(pol2);
>         System.out.println("P3 = P1 + P2: " + pol3);
>         pol3 = pol3.scale(2.0);
>         System.out.println("P3 = 2.0 * P3: " + pol3);
>         double[] zeros = pol3.getZeros();
>         System.out.println("Nullstellen von P3 (" + pol3 + "): ");
>         for(double zero : zeros)
>         System.out.print(zero + " ");
>     }
> 
> }
> ```

## Meine Notizen

