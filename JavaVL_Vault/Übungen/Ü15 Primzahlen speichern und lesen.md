---
tags: ["typ/uebung", "thema/io", "kategorie/io", "semester/1", "schwierigkeit/3", "hat/musterloesung"]
aliases: ["PrimesFile"]
thema: "[[15 Input und Output]]"
klasse: "PrimesFile"
package: "de.dhbwka.java.exercise.io"
schwierigkeit: 3
status: "offen"
---

# Ü15 Primzahlen speichern und lesen

**Thema:** [[15 Input und Output]] · **Bereich:** Input/Output (3) · **Schwierigkeit:** ★★★☆☆
**Klasse:** `PrimesFile` · **Package:** `de.dhbwka.java.exercise.io`

📄 Aufgabe: [[Material/Aufgaben/15_IO_Aufgaben-3.pdf#page=3|15_IO_Aufgaben-3.pdf, S. 3]]
✅ Musterlösung: [[Material/Aufgaben/15_IO_Aufgaben-3_Muster.pdf#page=5|15_IO_Aufgaben-3_Muster.pdf, S. 5]]

> [!question] Kurz gesagt
> Schreiben Sie per Programm PrimesFile alle Primzahlen kleiner 100.000 in eine Datei „primes.txt“. Erweitern Sie dazu die Aufgabe „Sieb von Eratostenes“ um eine Ausgabekomponente, welche diese Datei erzeugt.

## Aufgabenstellung
```text
Schreiben Sie per Programm PrimesFile alle Primzahlen kleiner 100.000 in eine Datei
„primes.txt“. Erweitern Sie dazu die Aufgabe „Sieb von Eratostenes“ um eine Ausgabekomponente,
welche diese Datei erzeugt.

Schreiben Sie anschließend eine zweite Klasse PrimesTest, welche die Frage, ob eine
eingegebene Zahl (<100.000) eine Primzahl ist, anhand der in dieser Datei gespeicherten Liste
beantwortet.
Alternativ können Sie auch eine Reihe zufällig erzeugter Zahlen auf ihre Primzahl-Eigenschaft hin
überprüfen.

Hinweis:
Die *-Aufgabe ist für alle, die schon Erfahrung im Programmieren haben und/oder schon früher fertig
geworden sind, manchmal anspruchsvoller, manchmal für Fleißige, manchmal vielleicht sogar
ungelöst (für alle, die berühmt werden wollen…)
```

## Benötigte Begriffe
[[Konstante]] · [[Zufallszahlen]] · [[while-Schleife]] · [[for-Schleife]] · [[Array]] · [[static]] · [[Wrapperklasse]] · [[Exception]] · [[try-with-resources]] · [[Reader und Writer]] · [[BufferedReader und BufferedWriter]] · [[PrintWriter]] · [[Datei und Pfad]] · [[List]]

## Weitere Übungen zum Thema
[[Ü15 Arbeiten mit Dateien]] · [[Ü15 Quersummen speichern]] · [[Ü15 Palindrome speichern]] · [[Ü15 Teil einer Datei]] · [[Ü15 Zugriff auf eine Textdatei]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.io;
> 
> import java.io.File;
> import java.io.FileWriter;
> import java.io.IOException;
> import java.io.PrintWriter;
> 
> public class PrimesFile {
> 
>     public static final int MAX = 100000;
>     public static final String PRIM_FILENAME = "primes.txt";
> 
>     public static void main(String[] args) {
>         savePrimes(getPrimes(MAX), PRIM_FILENAME);
>         System.out.println("prime numbers up to " + MAX + " saved to " +
>         PRIM_FILENAME);
>     }
> 
>     public static void savePrimes(boolean[] prim, String filename) {
>         try {
>             PrintWriter pw = new PrintWriter(new FileWriter(
>             new File(filename)));
>             for (int i = 0; i < prim.length; i++) {
>                 if (prim[i])
>                 pw.println(i);
>             }
>             pw.close();
>         } catch (IOException e) {
>             System.err.println("Error writing numbers to " + filename);
>         }
>     }
> 
>     public static boolean[] getPrimes(int max) {
>         boolean[] prim = new boolean[max];
>         // initialize array with true
>         for (int i = 2; i < prim.length; i++)
>         prim[i] = true;
>         // eratostenes' sieve
>         for (int i = 2; i < prim.length; i++)
>         if (prim[i])
>         for (int j = i * 2; j < prim.length; j += i)
> 
>         prim[j] = false;
>         return prim;
>     }
> 
> }
> 
> package de.dhbwka.java.exercise.io;
> 
> import java.io.BufferedReader;
> import java.io.File;
> import java.io.FileReader;
> import java.io.IOException;
> import java.util.Random;
> 
> public class PrimesTest {
> 
>     public static void main(String[] args) {
>         boolean[] prim = loadPrimes(PrimesFile.PRIM_FILENAME);
>         if (prim!=null && prim.length>0) {
>             Random rnd = new Random();
>             // Test for 10 random numbers if they are prime
>             for (int i=0; i<10; i++) {
>                 int number = rnd.nextInt(prim.length);
>                 System.out.println(number + " is " +
>                 (prim[number]?"":"not ") + "prime.");
>             }
>         }
>     }
> 
>     public static boolean[] loadPrimes(String filename) {
>         boolean[] prim = new boolean[PrimesFile.MAX];
>         // read lines using try-with-resources statement
>         try (BufferedReader br2 = new BufferedReader(new FileReader(
>         new File(filename)))) {
>             while (br2.ready()) {
>                 prim[Integer.parseInt(br2.readLine())] = true;
>             }
>         } catch (IOException e) {
>             System.err.println("Error reading from "+filename);
>         }
>         return prim;
>     }
> }
> ```

## Meine Notizen

