---
tags: ["typ/uebung", "thema/io", "kategorie/io", "semester/1", "schwierigkeit/2", "hat/musterloesung"]
aliases: ["TextfileLines"]
thema: "[[15 Input und Output]]"
klasse: "TextfileLines"
package: "de.dhbwka.java.exercise.io"
schwierigkeit: 2
status: "offen"
---

# Ü15 Teil einer Datei

**Thema:** [[15 Input und Output]] · **Bereich:** Input/Output (2) · **Schwierigkeit:** ★★☆☆☆
**Klasse:** `TextfileLines` · **Package:** `de.dhbwka.java.exercise.io`

📄 Aufgabe: [[Material/Aufgaben/15_IO_Aufgaben-2.pdf#page=2|15_IO_Aufgaben-2.pdf, S. 2]]
✅ Musterlösung: [[Material/Aufgaben/15_IO_Aufgaben-2_Muster.pdf#page=3|15_IO_Aufgaben-2_Muster.pdf, S. 3]]

> [!question] Kurz gesagt
> Erzeugen Sie eine Textdatei mit dem Texteditor! Fügen Sie so mindestens 8 Zeilen ein!

## Aufgabenstellung
```text
Erzeugen Sie eine Textdatei mit dem Texteditor!
Fügen Sie so mindestens 8 Zeilen ein!
Geben Sie per Java-Programm TextfileLines die Inhalte der Zeilen 2-5 dieser Datei sowie
anschließend eine Zeichenkette aus, in welcher der Inhalt dieser vier Zeilen aneinandergehängt ist!

Beispieldatei „beispiel.txt“:

Lorem
ipsum
dolor
4
5
6
7
the
end is
near!

Beispielausgabe:

ipsum
dolor
4
5
Zeile 2-5: ipsumdolor45
```

## Benötigte Begriffe
[[while-Schleife]] · [[toString]] · [[String]] · [[StringBuilder und StringBuffer]] · [[Exception]] · [[try-with-resources]] · [[Reader und Writer]] · [[BufferedReader und BufferedWriter]] · [[Datei und Pfad]]

## Weitere Übungen zum Thema
[[Ü15 Arbeiten mit Dateien]] · [[Ü15 Quersummen speichern]] · [[Ü15 Palindrome speichern]] · [[Ü15 Zugriff auf eine Textdatei]] · [[Ü15 Primzahlen speichern und lesen]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.io;
> 
> import java.io.BufferedReader;
> import java.io.File;
> import java.io.FileReader;
> import java.io.IOException;
> 
> public class TextfileLines {
> 
>     public static void main(String[] args) {
>         File textFile = new File("beispiel.txt");
>         StringBuilder result = new StringBuilder();
>         if (textFile.exists()) {
>             try (BufferedReader br = new BufferedReader(
>             new FileReader(textFile)))
>             {
>                 int count = 0;
>                 while (br.ready()) {
>                     count++;
>                     String line = br.readLine();
>                     if (count>=2 && count<=5) {
>                         System.out.println(line);
>                         result.append(line);
>                     }
>                 }
>                 System.out.println("Zeile 2-5: " + result.toString());
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

