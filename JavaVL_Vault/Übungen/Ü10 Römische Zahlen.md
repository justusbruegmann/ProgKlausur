---
tags: ["typ/uebung", "thema/strings", "kategorie/grundlagen", "semester/1", "schwierigkeit/2", "hat/musterloesung"]
aliases: ["RomanNumber"]
thema: "[[10 Strings und Wrapperklassen]]"
klasse: "RomanNumber"
package: "de.dhbwka.java.exercise.strings"
schwierigkeit: 2
status: "offen"
---

# Ü10 Römische Zahlen

**Thema:** [[10 Strings und Wrapperklassen]] · **Bereich:** Strings · **Schwierigkeit:** ★★☆☆☆
**Klasse:** `RomanNumber` · **Package:** `de.dhbwka.java.exercise.strings`

📄 Aufgabe: [[Material/Aufgaben/10_Strings_Aufgaben.pdf#page=3|10_Strings_Aufgaben.pdf, S. 3]]
✅ Musterlösung: [[Material/Aufgaben/10_Strings_Aufgaben_Muster.pdf#page=3|10_Strings_Aufgaben_Muster.pdf, S. 3]]

> [!question] Kurz gesagt
> Schreiben Sie ein Java-Programm RomanNumber, das eine römische Zahl einliest und diese römische Zahl in eine Dezimalzahl übersetzt. Die Zahlzeichen mit der Bedeutung sind: M \= 1000 D \= 500 C \= 100 L \= 50 X \= 10 V \= 5 I \= 1 Hinweis: Die Subtraktionsregel ist eine heute übliche, verkürzende Schreibweise, mit der es vermieden werden soll, vier gleiche Zahlzeichen in direkter Aufeinanderfolge zu schreiben.

## Aufgabenstellung
```text
Schreiben Sie ein Java-Programm RomanNumber, das eine römische Zahl einliest und diese
römische Zahl in eine Dezimalzahl übersetzt. Die Zahlzeichen mit der Bedeutung sind:

         M         = 1000
         D         = 500
         C         = 100
         L         = 50
         X         = 10
         V         =    5
         I         =    1

Hinweis:
Die Subtraktionsregel ist eine heute übliche, verkürzende Schreibweise, mit der es vermieden
werden soll, vier gleiche Zahlzeichen in direkter Aufeinanderfolge zu schreiben. Sie wurde bereits in
Rom gelegentlich angewandt, ihre konsequente Anwendung erscheint jedoch erst seit dem späteren
Mittelalter, auch dort häufig noch in vermischter Anwendung mit Schreibung einzelner Zahlen ohne
Subtraktionsprinzip, und ist auch seither lediglich eine weithin vorherrschende Konvention
geblieben, von der besonders in der Epigraphie vielfach kein Gebrauch gemacht wird.

Die Subtraktionsregel in ihrer Normalform besagt, dass die Zahlzeichen I, X und C einem ihrer beiden
jeweils nächstgrößeren Zahlzeichen vorangestellt werden dürfen und dann in ihrem Zahlwert von
dessen Wert abzuziehen sind:

         IV        = 4 (statt IIII)
         IX        = 9 (statt VIIII)
         XL        = 40 (statt XXXX)
         XC        = 90 (statt LXXXX)
         CD        = 400 (statt CCCC)
         CM        = 900 (statt DCCCC)

Bei Einhaltung dieser Regel ist es nicht zulässig, das abzuziehende Zeichen auch seinem dritt- oder
viertgrößeren Zeichen voranzustellen, also z.B. IL = 49 (richtig XLIX), IC = 99 (richtig XCIX), XM = 990
(richtig CMXC) zu schreiben, wie es trotzdem aus Unkenntnis der genauen Regel oder der Kürze
halber manchmal geschieht.
Sie dürfen davon ausgehen, dass es sich bei allen Eingaben um korrekte römische Zahlen handelt,
d.h. das Überprüfen, ob es sich bei der Eingabe um eine korrekte römische Zahl handelt, ist nicht
Bestandteil der Aufgabe.

Beispielausgabe:

Bitte geben Sie eine röm. Zahl ein: MCMLXXXIV
Der Wert der Zahl MCMLXXXIV ist 1984
```

## Benötigte Begriffe
[[Bedingungsoperator]] · [[Scanner]] · [[switch]] · [[for-Schleife]] · [[static]] · [[String]] · [[Wrapperklasse]]

## Weitere Übungen zum Thema
[[Ü10 Quersumme]] · [[Ü10 Palindrom]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.strings;
> 
> import java.util.Scanner;
> 
> public class RomanNumber {
> 
>     /** Get the decimal value of a Roman digit.
>      * 0 is returned for invalid chars.
>      * @param c Roman digit (char)
>      * @return decimal value of a single Roman digit */
>     private static int getValue(char c) {
>         switch (Character.toUpperCase(c)) {
>             case 'I' : return 1;
>             case 'V' : return 5;
>             case 'X' : return 10;
>             case 'L' : return 50;
>             case 'C' : return 100;
>             case 'D' : return 500;
>             case 'M' : return 1000;
>         }
>         return 0;
>     }
> 
>     /** Get the decimal value of a Roman number.
>      * The syntax is not checked.
>      * @param c Roman number (String)
>      * @return decimal value of the Roman number */
>     public static int getValue(String s) {
>         int result = 0;
>         // Add all numbers but the last
>         for(int i=0; i<s.length()-1; i++) {
>             int valueAti = getValue(s.charAt(i));
>             result += (valueAti < getValue(s.charAt(i+1)))
>             ? -valueAti : valueAti;
>         }
>         // Add last number
>         result += getValue(s.charAt(s.length()-1));
>         return result;
>     }
> 
>     public static void main(String[] args) {
>         Scanner scan = new Scanner(System.in);
>         System.out.print("Bitte geben Sie eine röm. Zahl ein: ");
>         String rome = scan.nextLine();
>         System.out.println("Der Wert der Zahl " + rome + " ist "
>         + getValue(rome));
>         scan.close();
>     }
> 
> }
> ```

## Meine Notizen

