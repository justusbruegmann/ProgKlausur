---
tags: ["typ/uebung", "thema/klassen", "kategorie/oop", "semester/1", "schwierigkeit/3", "hat/musterloesung"]
aliases: ["Complex"]
thema: "[[09 Klassen und Objekte]]"
klasse: "Complex"
package: "de.dhbwka.java.exercise.classes"
schwierigkeit: 3
status: "offen"
---

# Ü09 Komplexe Zahlen

**Thema:** [[09 Klassen und Objekte]] · **Bereich:** Klassen (2) · **Schwierigkeit:** ★★★☆☆
**Klasse:** `Complex` · **Package:** `de.dhbwka.java.exercise.classes`

📄 Aufgabe: [[Material/Aufgaben/09_Klassen_Aufgaben-2.pdf#page=2|09_Klassen_Aufgaben-2.pdf, S. 2]]
✅ Musterlösung: [[Material/Aufgaben/09_Klassen_Aufgaben-2_Muster.pdf#page=3|09_Klassen_Aufgaben-2_Muster.pdf, S. 3]]

> [!question] Kurz gesagt
> Eine komplexe Zahl ist durch einen Realteil a und Imaginärteil b gegeben. Komplexe Zahlen werden meist in der Form a+bi angegeben. i ist eine imaginäre Zahl mit i2 \= -1.

## Aufgabenstellung
```text
Eine komplexe Zahl ist durch einen Realteil a und Imaginärteil b gegeben. Komplexe Zahlen werden
meist in der Form a+bi angegeben. i ist eine imaginäre Zahl mit i2 = -1.

Mit komplexen Zahlen lassen sich zum Beispiel für alle reellwertigen Polynome Nullstellen finden. So
sind i (also 0+1i) und -i (also 0+(–1)i) Nullstellen von x2+1.

Das Symbol „+“ verhält sich wie eine „normale“ Addition reeller Zahlen.
Zwei komplexe Zahlen a+bi und c+di werden wie folgt addiert, subtrahiert, multipliziert und
dividiert:

        Addition:         (a + bi) + (c + di) = a + c + (b+d)i

        Subtraktion:      (a + bi) – (c + di) = a – c + (b–d)i

        Multiplikation:   (a + bi) * (c + di) = ac – bd + (ad + bc)i

                           a  bi (a  bi)(c  di) ac  bd bc  ad
        Division:                                                  i
                           c  di (c  di)(c  di) c 2  d 2 c 2  d 2

Implementieren Sie eine Klasse Complex für komplexe Zahlen mit den Instanzenmethoden
    getReal()
    getImag()
    add(Complex comp)
    sub(Complex comp)
    mult(Complex comp)
    div(Complex comp)
    toString()
sowie dem Konstruktor
    Complex(double real, double imag)
Wählen Sie jeweils geeignete Rückgabewerte!

(Fortsetzung auf der nächsten Seite)

Die komplexen Zahlen C sind im Gegensatz zu den reellen Zahlen kein geordneter Körper, d. h. es
gibt keine mit der Körperstruktur verträgliche Ordnungsrelation „“ auf C.
Von zwei unterschiedlichen komplexen Zahlen kann man daher nicht sagen, welche von beiden „die
größere“ bzw. „die kleinere“ Zahl ist.

Dennoch gibt es für die komplexen Zahlen eine Quasi-Ordnung, die über ihren (reellen) Betrag

                               a  bi  (a  bi)(a  bi)  a 2  b 2

definiert ist.

Implementieren Sie zunächst eine Methode getMagnitude(), welche den Betrag einer
komplexen Zahl liefert und anschließend eine Methode isLess(Complex comp), die als
Ergebnis einen booleschen Wert liefert, der genau dann true ist, wenn der Betrag der komplexen
Zahl, für welche die Methode aufgerufen wurde, kleiner ist als der Betrag der übergebenen Zahl
comp.

Erzeugen Sie 10 zufällige komplexe Zahlen und geben Sie diese aufsteigend nach ihrem Betrag
sortiert aus. Passen Sie zum Beispiel den Bubblesort-Algorithmus (vgl. Übungsblatt „Arrays (1)“)
entsprechend an. Sehen die Zahlen nun „sortiert“ aus?

Beispielausgabe:

C1:     Complex 1.0 2.0i
C2:     Complex 2.0 1.0i
C1+C2: Complex 3.0 3.0i
C1-C2: Complex -1.0 1.0i
C1*C2: Complex 0.0 5.0i
C1/C2: Complex 0.8 0.6i
C1<C2?: false
Unsortiert:
5,037 + 8,190i Betrag: 9,615
5,832 + 0,398i Betrag: 5,846
6,726 + 3,479i Betrag: 7,573
5,501 + 4,718i Betrag: 7,247
5,010 + 6,658i Betrag: 8,332
8,535 + 3,448i Betrag: 9,205
0,609 + 0,278i Betrag: 0,669
0,910 + 5,862i Betrag: 5,933
8,571 + 9,513i Betrag: 12,805
6,567 + 7,344i Betrag: 9,852
Sortiert:
0,609 + 0,278i Betrag: 0,669
5,832 + 0,398i Betrag: 5,846
0,910 + 5,862i Betrag: 5,933
5,501 + 4,718i Betrag: 7,247
6,726 + 3,479i Betrag: 7,573
5,010 + 6,658i Betrag: 8,332
8,535 + 3,448i Betrag: 9,205
5,037 + 8,190i Betrag: 9,615
6,567 + 7,344i Betrag: 9,852
8,571 + 9,513i Betrag: 12,805
```

## Benötigte Begriffe
[[Formatierte Ausgabe]] · [[Zufallszahlen]] · [[Math-Klasse]] · [[for-Schleife]] · [[Array]] · [[Sortieren]] · [[Konstruktor]] · [[this]] · [[static]] · [[toString]] · [[Kapselung]] · [[super]]

## Weitere Übungen zum Thema
[[Ü09 Radio]] · [[Ü09 Zweidimensionaler Punkt]] · [[Ü09 Bankkonto]] · [[Ü09 Polynom 2. Grades]] · [[Ü09 Polynome und Horner-Schema]] · [[Ü09 Nimmspiel]] · [[Ü09 Lotto]] · [[Ü09 MasterMind]] · [[Ü09 Wechselspiel (1. Teil)]] · [[Ü09 Wechselspiel (2. Teil)]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.classes;
> 
> public class Complex {
> 
>     private double real = 0.0;
>     private double imag = 0.0;
> 
>     public Complex() {
>         this(0.0, 0.0);
>     }
> 
>     public Complex(double real, double imag) {
>         super();
>         this.real = real;
>         this.imag = imag;
>     }
> 
>     public double getReal() {
>         return real;
>     }
> 
>     public double getImag() {
>         return imag;
>     }
> 
>     /** Complex addition
>      * @param comp the complex number to add
>      * @return a new complex as result of addition */
>     public Complex add(Complex comp) {
>         return new Complex(this.real+comp.real, this.imag+comp.imag);
>     }
> 
>     /** Complex subtraction
>      * @param comp the complex number to subtract
>      * @return a new complex as result of subtraction */
>     public Complex sub(Complex comp) {
>         return new Complex(this.real-comp.real, this.imag-comp.imag);
>     }
> 
>     /** Complex multiplication
>      * @param comp the complex number to multiply
>      * @return a new complex as result of multiplication */
>     public Complex mult(Complex comp) {
>         return new Complex(this.real*comp.real-this.imag*comp.imag,
>         this.real*comp.imag+this.imag*comp.real);
>     }
> 
>     /** Complex division
>      * @param comp the complex number to divide
>      * @return a new complex as result of division */
>     public Complex div(Complex comp) {
>         double denom = comp.real*comp.real + comp.imag*comp.imag;
>         return new Complex((this.real*comp.real+this.imag*comp.imag)/denom,
>         (this.imag*comp.real-this.real*comp.imag)/denom);
>     }
> 
>     /** Complex as String */
>     public String toString() {
>         return "Complex " + real + " " + imag + "i";
>     }
> 
>     /** Magnitude of a complex number */
>     public double getMagnitude() {
>         return Math.sqrt(real*real+imag*imag);
>     }
> 
>     /** true if magnitude if comp is bigger */
>     public boolean isLess(Complex comp) {
>         return (this.getMagnitude()<comp.getMagnitude());
>     }
> 
>     /** Sort an array of complex numbers with bubblesort */
>     public static void sortComplexArray(Complex[] comps) {
>         int n = comps.length;
>         for(int i=1; i<n; i++)
>         for(int j=n-1; j>=i; j--)
>         // falls x[j-1] größer als x[j]
>         if (comps[j-1].getMagnitude() >
>         comps[j].getMagnitude()) {
>             Complex tmp = comps[j-1]; // swap
>             comps[j-1]=comps[j];
>             comps[j]=tmp;
>         }
>     }
> 
>     public static void main(String[] argv) {
>         Complex c1 = new Complex(1.0,2.0);
>         Complex c2 = new Complex(2.0,1.0);
>         System.out.println("C1:     " + c1);
>         System.out.println("C2:     " + c2);
>         System.out.println("C1+C2: " + c1.add(c2));
>         System.out.println("C1-C2: " + c1.sub(c2));
>         System.out.println("C1*C2: " + c1.mult(c2));
>         System.out.println("C1/C2: " + c1.div(c2));
>         System.out.println("C1<C2?: " + c1.isLess(c2));
>         // create an array of 10 random complex numbers
>         Complex[] comps = new Complex[10];
>         for(int i=0; i<comps.length; i++)
>         comps[i]=new Complex(Math.random()*10,Math.random()*10);
>         System.out.println("Unsortiert:");
>         for(Complex c : comps)
>         System.out.printf("%5.3f + %5.3fi Betrag: %5.3f\n",
>         c.getReal(),c.getImag(),c.getMagnitude());
>         // sort array
>         sortComplexArray(comps);
>         System.out.println("Sortiert:");
>         for(Complex c : comps)
>         System.out.printf("%5.3f + %5.3fi Betrag: %5.3f\n",
>         c.getReal(),c.getImag(),c.getMagnitude());
>     }
> 
> }
> ```

## Meine Notizen

