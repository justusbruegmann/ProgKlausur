---
tags: ["typ/uebung", "thema/strings", "kategorie/grundlagen", "semester/1", "schwierigkeit/1", "hat/musterloesung"]
aliases: ["CrossTotal"]
thema: "[[10 Strings und Wrapperklassen]]"
klasse: "CrossTotal"
package: "de.dhbwka.java.exercise.strings"
schwierigkeit: 1
status: "offen"
---

# Ü10 Quersumme

**Thema:** [[10 Strings und Wrapperklassen]] · **Bereich:** Strings · **Schwierigkeit:** ★☆☆☆☆
**Klasse:** `CrossTotal` · **Package:** `de.dhbwka.java.exercise.strings`

📄 Aufgabe: [[Material/Aufgaben/10_Strings_Aufgaben.pdf#page=1|10_Strings_Aufgaben.pdf, S. 1]]
✅ Musterlösung: [[Material/Aufgaben/10_Strings_Aufgaben_Muster.pdf#page=1|10_Strings_Aufgaben_Muster.pdf, S. 1]]

> [!question] Kurz gesagt
> Schreiben Sie ein Java-Programm CrossTotal, das eine natürliche Zahl als String einliest, von dieser Zahl mit Hilfe von Wrapper-Klassen die Quersumme berechnet und diese Quersumme am Ende ausgibt! Hinweis: Verwenden Sie hier ausschließlich Methoden der Klasse String, nicht der Klassen StringBuffer und StringBuilder.

## Aufgabenstellung
```text
Schreiben Sie ein Java-Programm CrossTotal, das eine natürliche Zahl als String einliest, von
dieser Zahl mit Hilfe von Wrapper-Klassen die Quersumme berechnet und diese Quersumme am
Ende ausgibt!

Hinweis:

Verwenden Sie hier ausschließlich Methoden der Klasse String, nicht der Klassen
StringBuffer und StringBuilder.

Beispielausgabe:

Bitte Zahl für Quersumme eingeben: 369246
Die Quersumme von 369246 ist 30

Zusatz:
Wem die Aufgabe sehr leicht fällt, kann versuchen, die Quersumme ohne die Nutzung von
Methoden von Wrapper-Klassen (wie z.B. Integer.parseInt) zu bilden!
```

## Benötigte Begriffe
[[Scanner]] · [[for-Schleife]] · [[String]] · [[StringBuilder und StringBuffer]] · [[Wrapperklasse]]

## Weitere Übungen zum Thema
[[Ü10 Palindrom]] · [[Ü10 Römische Zahlen]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.strings;
> 
> import java.util.Scanner;
> 
> public class CrossTotal {
> 
>     public static void main(String[] args) {
>         Scanner scan = new Scanner(System.in);
>         System.out.print("Bitte Zahl für Quersumme eingeben: ");
>         String number = scan.next();
>         int total = 0;
>         for(char c : number.toCharArray())
>         total += Character.getNumericValue(c);
>         // Alternative Implementierung
>         //            for (char c : number.toCharArray())
>         //                   total += (c - '0');
>         System.out.println("Die Quersumme von " + number +
>         " ist " + total);
>         scan.close();
>     }
> }
> ```

## Meine Notizen

