---
tags: ["typ/uebung", "thema/strings", "kategorie/grundlagen", "semester/1", "schwierigkeit/2", "hat/musterloesung"]
aliases: ["Palindrome"]
thema: "[[10 Strings und Wrapperklassen]]"
klasse: "Palindrome"
package: "de.dhbwka.java.exercise.strings"
schwierigkeit: 2
status: "offen"
---

# Ü10 Palindrom

**Thema:** [[10 Strings und Wrapperklassen]] · **Bereich:** Strings · **Schwierigkeit:** ★★☆☆☆
**Klasse:** `Palindrome` · **Package:** `de.dhbwka.java.exercise.strings`

📄 Aufgabe: [[Material/Aufgaben/10_Strings_Aufgaben.pdf#page=2|10_Strings_Aufgaben.pdf, S. 2]]
✅ Musterlösung: [[Material/Aufgaben/10_Strings_Aufgaben_Muster.pdf#page=2|10_Strings_Aufgaben_Muster.pdf, S. 2]]

> [!question] Kurz gesagt
> Schreiben Sie ein Java-Programm Palindrome, das eine Zeichenkette einliest! Das Programm soll diese umdrehen (d.h. aus „hans“ soll z.B. „snah“ werden) und ausgeben.

## Aufgabenstellung
```text
Schreiben Sie ein Java-Programm Palindrome, das eine Zeichenkette einliest!
Das Programm soll diese umdrehen (d.h. aus „hans“ soll z.B. „snah“ werden) und ausgeben.
Außerdem soll das Programm überprüfen und ausgeben, ob es sich um ein Palindrom handelt.

Hinweise:

Ein Palindrom ist ein Wort, das man von vorne und hinten gleich lesen kann, z.B. „Anna“, „Otto“
oder „EinEsellesenie“.
Groß- bzw. Kleinschreibung spielen dabei keine Rolle!

Verwenden Sie hier die Klasse StringBuffer oder StringBuilder.

Beispielausgabe:

Bitte Wort eingeben: Otto
Umgekehrt: ottO
Otto ist ein Palindrom.
```

## Benötigte Begriffe
[[Bedingungsoperator]] · [[Scanner]] · [[for-Schleife]] · [[static]] · [[toString]] · [[String]] · [[StringBuilder und StringBuffer]]

## Weitere Übungen zum Thema
[[Ü10 Quersumme]] · [[Ü10 Römische Zahlen]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.strings;
> 
> import java.util.Scanner;
> 
> public class Palindrome {
> 
>     public static void main(String[] args) {
>         Scanner scan = new Scanner(System.in);
>         System.out.print("Bitte Wort eingeben: ");
>         String word = scan.nextLine();
>         StringBuilder reverse = Palindrome.reverse(word);
>         // Alternativ
>         //            StringBuilder reverse = new StringBuilder(word).reverse(); // RTFM!
>         System.out.println("Umgekehrt: " + reverse);
>         System.out.println(word + " ist "
>         + (word.equalsIgnoreCase(reverse.toString()) ? "" : "k")
>         + "ein Palindrom.");
>         scan.close();
>     }
> 
>     public static StringBuilder reverse(String s) {
>         StringBuilder sb = new StringBuilder();
>         for (int i=s.length()-1; i>=0; i--)
>         sb.append(s.charAt(i));
>         return sb;
>     }
> 
> }
> ```

## Meine Notizen

