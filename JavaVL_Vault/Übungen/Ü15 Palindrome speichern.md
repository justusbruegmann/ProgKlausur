---
tags: ["typ/uebung", "thema/io", "kategorie/io", "semester/1", "schwierigkeit/1", "hat/musterloesung"]
aliases: ["PalindromeFile"]
thema: "[[15 Input und Output]]"
klasse: "PalindromeFile"
package: "de.dhbwka.java.exercise.io"
schwierigkeit: 1
status: "offen"
---

# Ü15 Palindrome speichern

**Thema:** [[15 Input und Output]] · **Bereich:** Input/Output (2) · **Schwierigkeit:** ★☆☆☆☆
**Klasse:** `PalindromeFile` · **Package:** `de.dhbwka.java.exercise.io`

📄 Aufgabe: [[Material/Aufgaben/15_IO_Aufgaben-2.pdf#page=1|15_IO_Aufgaben-2.pdf, S. 1]]
✅ Musterlösung: [[Material/Aufgaben/15_IO_Aufgaben-2_Muster.pdf#page=1|15_IO_Aufgaben-2_Muster.pdf, S. 1]]

> [!question] Kurz gesagt
> Erweitern Sie die Palindrom-Aufgabe vom Aufgabenblatt „Strings“ derart, dass wenn die eingelesene Zeichenkette ein Palindrom ist, diese in eine Datei geschrieben wird (neue Palindrome werden an die bestehende immer angehängt). Am Ende des Programmlaufs sollen dann alle gespeicherten Palindrome aus dem File ausgelesen und auf die Konsole ausgegeben werden.

## Aufgabenstellung
```text
Erweitern Sie die Palindrom-Aufgabe vom Aufgabenblatt „Strings“ derart, dass wenn die
eingelesene Zeichenkette ein Palindrom ist, diese in eine Datei geschrieben wird (neue Palindrome
werden an die bestehende immer angehängt). Am Ende des Programmlaufs sollen dann alle
gespeicherten Palindrome aus dem File ausgelesen und auf die Konsole ausgegeben werden.

Hinweis zur Vereinfachung:
Duplikate sind in der Datei zulässig!

Beispielausgabe:

Bitte Wort eingeben: Lagerregal
Umgekehrt: lagerregaL
Lagerregal ist ein Palindrom.
Alle bisher gefundenen Palindrome:
Anna
Otto
EinEsellesenie
Otto
mnbvbnm
Lagerregal
```

## Benötigte Begriffe
[[Bedingungsoperator]] · [[Scanner]] · [[while-Schleife]] · [[toString]] · [[String]] · [[StringBuilder und StringBuffer]] · [[Exception]] · [[try-with-resources]] · [[Reader und Writer]] · [[BufferedReader und BufferedWriter]] · [[PrintWriter]] · [[Datei und Pfad]]

## Weitere Übungen zum Thema
[[Ü15 Arbeiten mit Dateien]] · [[Ü15 Quersummen speichern]] · [[Ü15 Teil einer Datei]] · [[Ü15 Zugriff auf eine Textdatei]] · [[Ü15 Primzahlen speichern und lesen]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.io;
> 
> import java.io.BufferedReader;
> import java.io.File;
> import java.io.FileReader;
> import java.io.FileWriter;
> import java.io.IOException;
> import java.io.PrintWriter;
> import java.util.Scanner;
> 
> public class PalindromeFile {
> 
>     public static void main(String[] args) {
>         Scanner scan = new Scanner(System.in);
>         System.out.print("Bitte Wort eingeben: ");
>         String word = scan.next();
>         StringBuilder reverse = new StringBuilder(word).reverse(); // RTFM!
>         System.out.println("Umgekehrt: " + reverse);
> 
>         boolean isPalindrome = word.equalsIgnoreCase(reverse.toString());
> 
>         System.out.println(word + " ist "
>         + (isPalindrome ? "" : "k")
>         + "ein Palindrom.");
>         scan.close();
> 
>         File palFile = new File("palindromes.txt");
>         // if palindrome: write it to palindrome file
>         if (isPalindrome) {
>             try (PrintWriter pw = new PrintWriter(
>             new FileWriter(palFile,true))) // true for "append"
>             {
>                 pw.println(word);
>             } catch (IOException e) {
>                 System.err.println("Fehler beim Schreiben: " +
>                 e.getMessage());
>             }
>         }
> 
>         // Read all palindromes
>         if (palFile.exists()) {
>             System.out.println("Alle bisher gefundenen Palindrome:");
>             try (BufferedReader br = new BufferedReader(
>             new FileReader(palFile)))
>             {
>                 while (br.ready())
>                 System.out.println(br.readLine());
>             } catch (IOException e) {
>                 System.err.println("Fehler beim Lesen: " +
>                 e.getMessage());
>             }
>         }
>     }
> 
> }
> ```

## Meine Notizen

