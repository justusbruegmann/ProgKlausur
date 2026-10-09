---
tags: ["typ/uebung", "thema/io", "kategorie/io", "semester/1", "schwierigkeit/1", "hat/musterloesung"]
aliases: ["CrossTotalFile"]
thema: "[[15 Input und Output]]"
klasse: "CrossTotalFile"
package: "de.dhbwka.java.exercise.io"
schwierigkeit: 1
status: "offen"
---

# Ü15 Quersummen speichern

**Thema:** [[15 Input und Output]] · **Bereich:** Input/Output (1) · **Schwierigkeit:** ★☆☆☆☆
**Klasse:** `CrossTotalFile` · **Package:** `de.dhbwka.java.exercise.io`

📄 Aufgabe: [[Material/Aufgaben/15_IO_Aufgaben-1.pdf#page=2|15_IO_Aufgaben-1.pdf, S. 2]]
✅ Musterlösung: [[Material/Aufgaben/15_IO_Aufgaben-1_Muster.pdf#page=2|15_IO_Aufgaben-1_Muster.pdf, S. 2]]

> [!question] Kurz gesagt
> Erweitern Sie die Quersummenaufgabe CrossTotal vom Aufgabenblatt „Strings“ derart, dass jede berechnete Quersumme und die zugehörige Zahl in ein mit einem Texteditor lesbares File geschrieben werden! Neue Ergebnisse sollen jeweils angehängt werden.

## Aufgabenstellung
```text
Erweitern Sie die Quersummenaufgabe CrossTotal vom Aufgabenblatt „Strings“ derart, dass
jede berechnete Quersumme und die zugehörige Zahl in ein mit einem Texteditor lesbares File
geschrieben werden! Neue Ergebnisse sollen jeweils angehängt werden.

Hinweis:
Kopieren Sie dazu die Klasse CrossTotal in das o.g. Package.

Beispielausgabe im File „crosstotals.txt“:

Quersumme von 17 ist 8
Quersumme von 234 ist 9
Quersumme von 1024 ist 7
```

## Benötigte Begriffe
[[Scanner]] · [[for-Schleife]] · [[String]] · [[Exception]] · [[try-with-resources]] · [[Reader und Writer]] · [[PrintWriter]] · [[Datei und Pfad]]

## Weitere Übungen zum Thema
[[Ü15 Arbeiten mit Dateien]] · [[Ü15 Palindrome speichern]] · [[Ü15 Teil einer Datei]] · [[Ü15 Zugriff auf eine Textdatei]] · [[Ü15 Primzahlen speichern und lesen]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.io;
> 
> import java.io.FileWriter;
> import java.io.IOException;
> import java.io.PrintWriter;
> import java.util.Scanner;
> 
> public class CrossTotalFile {
> 
>     public static void main(String[] args) {
>         Scanner scan = new Scanner(System.in);
>         System.out.print("Bitte Zahl für Quersumme eingeben: ");
>         String number = scan.next();
>         int total = 0;
>         for (char c : number.toCharArray())
>         total += (c-'0');
>         System.out.println("Die Quersumme von " + number +
>         " ist " + total);
>         scan.close();
>         try (PrintWriter pw = new PrintWriter(
>         new FileWriter("crosstotals.txt",true))) // true for "append"
>         {
>             pw.println("Quersumme von " + number + " ist " + total);
>         } catch (IOException e) {
>             System.err.println("Fehler beim Schreiben: " +
>             e.getMessage());
>         }
>     }
> 
> }
> ```

## Meine Notizen

