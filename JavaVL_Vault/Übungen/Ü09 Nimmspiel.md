---
tags: ["typ/uebung", "thema/klassen", "kategorie/oop", "semester/1", "schwierigkeit/3", "hat/musterloesung"]
aliases: ["Nimmspiel"]
thema: "[[09 Klassen und Objekte]]"
klasse: "Nimmspiel"
package: "de.dhbwka.java.exercise.classes"
schwierigkeit: 3
status: "offen"
---

# Ü09 Nimmspiel

**Thema:** [[09 Klassen und Objekte]] · **Bereich:** Klassen (3) · **Schwierigkeit:** ★★★☆☆
**Klasse:** `Nimmspiel` · **Package:** `de.dhbwka.java.exercise.classes`

📄 Aufgabe: [[Material/Aufgaben/09_Klassen_Aufgaben-3.pdf#page=1|09_Klassen_Aufgaben-3.pdf, S. 1]]
✅ Musterlösung: [[Material/Aufgaben/09_Klassen_Aufgaben-3_Muster.pdf#page=1|09_Klassen_Aufgaben-3_Muster.pdf, S. 1]]

> [!question] Kurz gesagt
> Ein Spiel, nennen wir es Nimm-Spiel, hat folgende Regeln: Auf dem Tisch liegen zwei Haufen mit je einer beliebigen Anzahl an Kugeln. Zwei Spieler ziehen abwechselnd.

## Aufgabenstellung
```text
Ein Spiel, nennen wir es Nimm-Spiel, hat folgende Regeln: Auf dem Tisch liegen zwei Haufen mit je
einer beliebigen Anzahl an Kugeln. Zwei Spieler ziehen abwechselnd. Sie müssen dabei jeweils von
einem (nicht-leeren) Haufen eine beliebige Anzahl (> 0 und <= Anzahl der Kugeln auf dem Haufen)
Kugeln entfernen. Es gewinnt derjenige Spieler, der die letzten Kugeln vom Tisch räumt.

Beispiel:

1. Haufen: 5 Kugeln; 2. Haufen: 3 Kugeln

Spieler A: nimmt vom 1. Haufen 2 Kugeln

Spieler B: nimmt vom 2. Haufen 2 Kugeln

Spieler A: nimmt vom 2. Haufen 1 Kugel

Spieler B: nimmt vom 1. Haufen 3 Kugeln und hat gewonnen!

Implementieren Sie eine Klasse, die dieses Nimm-Spiel realisiert. Überlegen Sie, welche Attribute die
Klasse auf jeden Fall haben muss (Spieler, Anzahl der Kugel auf jedem Haufen, welcher Spieler als
nächster an der Reihe ist).

Schreiben Sie dazu einen Konstruktor, der als Parameter die Namen der beiden Spieler erhält. Im
Konstruktor soll die Anzahl der Kugel eines jeden Haufens beliebig erzeugt werden. (Benutzen Sie
dazu die Methode Math.random()).

Implementieren Sie geeignete Methoden (für die Ausgabe (toString), für einen Spielzug, zum
Überprüfen, ob alle Kugeln entfernt sind etc.), so dass zwei menschliche Spieler gegeneinander
spielen können. Geben Sie die Zwischenstände (Anzahl verbliebener Kugeln pro Haufen) nach jedem
Spielzug in geeigneter Form auf den Bildschirm aus, sowie am Schluss eine Nachricht welcher Spieler
gewonnen hat. Sehen Sie in Ihrem Programm vor, dass fehlerhafte Benutzereingaben (wie das
Entfernen von Kugeln von einem leeren Haufen) wiederholt werden müssen!

Beispielausgabe:

Spieler: Alf und Ben, Haufen 1: 5 Kugel(n), Haufen 2: 7 Kugel(n)
Spieler Alf: Von welchem Haufen ziehen Sie Kugeln? 1
Spieler Alf: Wieviele Kugeln ziehen Sie? 4
Spieler: Alf und Ben, Haufen 1: 1 Kugel(n), Haufen 2: 7 Kugel(n)
Spieler Ben: Von welchem Haufen ziehen Sie Kugeln? 2
Spieler Ben: Wieviele Kugeln ziehen Sie? 6
Spieler: Alf und Ben, Haufen 1: 1 Kugel(n), Haufen 2: 1 Kugel(n)
Spieler Alf: Von welchem Haufen ziehen Sie Kugeln? 1
Spieler Alf: Wieviele Kugeln ziehen Sie? 1

Spieler: Alf und Ben, Haufen 1: 0 Kugel(n), Haufen 2: 1 Kugel(n)
Spieler Ben: Von welchem Haufen ziehen Sie Kugeln? 2
Spieler Ben: Wieviele Kugeln ziehen Sie? 1
Spieler: Alf und Ben, Haufen 1: 0 Kugel(n), Haufen 2: 0 Kugel(n)
Spiel beendet.
Gewonnen hat Spieler Ben
```

## Benötigte Begriffe
[[Typkonversion]] · [[Scanner]] · [[Zufallszahlen]] · [[Math-Klasse]] · [[while-Schleife]] · [[Array]] · [[Konstruktor]] · [[toString]]

## Weitere Übungen zum Thema
[[Ü09 Radio]] · [[Ü09 Zweidimensionaler Punkt]] · [[Ü09 Bankkonto]] · [[Ü09 Polynom 2. Grades]] · [[Ü09 Komplexe Zahlen]] · [[Ü09 Polynome und Horner-Schema]] · [[Ü09 Lotto]] · [[Ü09 MasterMind]] · [[Ü09 Wechselspiel (1. Teil)]] · [[Ü09 Wechselspiel (2. Teil)]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.classes;
> 
> public class Nimmspiel {
> 
>     String[] spielerName = new String[2];
>     int[] haufen = new int[2];
>     java.util.Scanner scan;
> 
>     public Nimmspiel(String spieler1, String spieler2) {
>         spielerName[0] = spieler1;
>         spielerName[1] = spieler2;
>         haufen[0] = (int) (Math.random() * 10) + 2;
>         haufen[1] = (int) (Math.random() * 10) + 2;
>     }
> 
>     public void gesamtesSpiel() {
>         scan = new java.util.Scanner(System.in);
>         int spieler = 1;
>         do {
>             if (spieler == 0) {
>                 spieler = 1;
>             } else {
>                 spieler = 0;
>             }
>             spielzug(spieler);
>         } while (!alleKugelnEntfernt());
>         System.out.println("Spiel beendet.");
>         System.out.println("Gewonnen hat Spieler " + spielerName[spieler]
>         + ".");
>     }
> 
>     public void spielzug(int spielerNr) {
>         int haufenNr;
>         int gezogeneKugeln;
>         boolean eingabeFehler = true;
>         do {
>             System.out.print("Spieler " + spielerName[spielerNr]
>             + ": Von welchem Haufen ziehen Sie Kugeln? ");
>             haufenNr = scan.nextInt() - 1;
>             if ((haufenNr < 0) || (haufenNr > 1) || (haufen[haufenNr] == 0)) {
>                 System.out.println("Eingabefehler! Erneute Eingabe.");
>             } else {
>                 eingabeFehler = false;
>             }
>         } while (eingabeFehler);
> 
>         eingabeFehler = true;
>         do {
>             System.out.print("Spieler " + spielerName[spielerNr]
>             + ": Wieviele Kugeln ziehen Sie? ");
>             gezogeneKugeln = scan.nextInt();
>             if ((gezogeneKugeln < 1) || (gezogeneKugeln > haufen[haufenNr])) {
>                 System.out.println("Eingabefehler! Erneute Eingabe.");
>             } else {
>                 eingabeFehler = false;
>             }
>         } while (eingabeFehler);
>         haufen[haufenNr] -= gezogeneKugeln;
>         System.out.println(this);
>     }
> 
>     public boolean alleKugelnEntfernt() {
>         return (haufen[0] == 0) && (haufen[1] == 0);
>     }
> 
>     public String toString() {
>         return "Spieler: " + spielerName[0] + " und " + spielerName[1]
>         + ", Haufen 1: " + haufen[0] + " Kugel(n), Haufen 2: "
>         + haufen[1] + " Kugel(n)";
>     }
> 
>     public static void main(String[] args) {
>         Nimmspiel spiel = new Nimmspiel("Alf", "Ben");
>         // Test-Ausgabe
>         System.out.println(spiel);
>         spiel.gesamtesSpiel();
>     }
> 
> }
> ```

## Meine Notizen

