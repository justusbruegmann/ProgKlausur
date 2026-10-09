---
tags: ["typ/uebung", "thema/klassen", "kategorie/oop", "semester/1", "schwierigkeit/4", "hat/musterloesung"]
aliases: ["MasterMind"]
thema: "[[09 Klassen und Objekte]]"
klasse: "MasterMind"
package: "de.dhbwka.java.exercise.classes"
schwierigkeit: 4
status: "offen"
---

# Ü09 MasterMind

**Thema:** [[09 Klassen und Objekte]] · **Bereich:** Klassen (3) · **Schwierigkeit:** ★★★★☆
**Klasse:** `MasterMind` · **Package:** `de.dhbwka.java.exercise.classes`

📄 Aufgabe: [[Material/Aufgaben/09_Klassen_Aufgaben-3.pdf#page=5|09_Klassen_Aufgaben-3.pdf, S. 5]]
✅ Musterlösung: [[Material/Aufgaben/09_Klassen_Aufgaben-3_Muster.pdf#page=6|09_Klassen_Aufgaben-3_Muster.pdf, S. 6]]

> [!question] Kurz gesagt
> Beim bekannten Spiel MasterMind ist das Ziel, eine vom Gegenspieler gewählte Farbkombination herauszufinden. Implementieren Sie eine Version von MasterMind mit textueller Ein-/Ausgabe.

## Aufgabenstellung
```text
Beim bekannten Spiel MasterMind ist das Ziel, eine vom Gegenspieler gewählte Farbkombination
herauszufinden. Implementieren Sie eine Version von MasterMind mit textueller Ein-/Ausgabe.

Anstelle von Farben verwenden Sie die Buchstaben A bis H. Gegenspieler ist der Computer. Der
Computer soll eine zufällige Kombination von 5 Buchstaben (aus A bis H) auswählen, wobei ein
Buchstabe auch mehrfach vorkommen kann.

Sie geben dann dem Computer Ihren Tipp ein, den der Computer bewertet, indem er Ihnen die
Anzahl der richtigen Buchstaben auf den richtigen Stellen und die Anzahl der richtigen Buchstaben
auf den falschen Stellen angibt.

Dabei soll Ihr Programm nur eine Höchstanzahl an Versuchen zulassen (z.B. 20), in denen der Spieler
die richtige Kombination erraten haben muss. Eine mögliche Ausgabe sieht wie folgt aus:

Die erste Zahl gibt dabei die Anzahl der richtigen Buchstaben an den richtigen Stellen und die zweite
Zahl die Anzahl der richtigen Buchstaben auf falschen Stellen an.

Für die Bestimmung der einzelnen Buchstaben in dem eingelesenen String können Sie die
Instanzmethode
char charAt(int index) (0 <= index < String-Länge)
der Klasse String verwenden.
```

## Benötigte Begriffe
[[Typkonversion]] · [[Scanner]] · [[Zufallszahlen]] · [[Math-Klasse]] · [[while-Schleife]] · [[for-Schleife]] · [[break und continue]] · [[Array]] · [[Mehrdimensionales Array]] · [[String]] · [[Farben und Schriften]]

## Weitere Übungen zum Thema
[[Ü09 Radio]] · [[Ü09 Zweidimensionaler Punkt]] · [[Ü09 Bankkonto]] · [[Ü09 Polynom 2. Grades]] · [[Ü09 Komplexe Zahlen]] · [[Ü09 Polynome und Horner-Schema]] · [[Ü09 Nimmspiel]] · [[Ü09 Lotto]] · [[Ü09 Wechselspiel (1. Teil)]] · [[Ü09 Wechselspiel (2. Teil)]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.classes;
> 
> public class MasterMind {
> 
>     char[] computerKombination;
>     char[][] spielerKombination;
>     int[] richtigeStellen;
>     int[] falscheStellen;
>     java.util.Scanner scan;
>     int versuch;
> 
>     MasterMind() {
>         computerKombination = new char[5];
>         spielerKombination = new char[50][5];
>         richtigeStellen = new int[50];
>         falscheStellen = new int[50];
>         scan = new java.util.Scanner(System.in);
>     }
> 
>     void spiel() {
>         bestimmeComputerKombination();
>         rateSchleife();
>     }
> 
>     void bestimmeComputerKombination() {
>         for (int i = 0; i < 5; i++) {
>             computerKombination[i] = (char) ('A' + (int) (Math.random() * 8));
>         }
>         // Ausgabe für das Testen
>         System.out.print("Computer-Kombination: ");
>         for (int i = 0; i < 5; i++) {
>             System.out.print(computerKombination[i]);
>         }
>         System.out.println("");
>     }
> 
>     void rateSchleife() {
>         for (versuch = 0; versuch < 50; versuch++) {
>             tippEingabe();
>             bewertung();
>             if (richtigeStellen[versuch] == 5) {
>                 System.out.println("Mit " + (versuch + 1)
>                 + " Versuchen gewonnen!");
>                 break;
>             }
>         }
>         if (versuch == 50) {
>             System.out.println("Spielende. Sie haben verloren.");
>         }
>     }
> 
>     void tippEingabe() {
>         boolean korrekt;
>         do {
>             System.out.print("Geben Sie Ihren Tipp ab: ");
>             String str = scan.next();
>             korrekt = true;
>             if (str.length() == 5) {
>                 for (int i = 0; i < 5; i++) {
>                     spielerKombination[versuch][i] = str.charAt(i);
>                     if ((spielerKombination[versuch][i] >= 'a')
>                     && (spielerKombination[versuch][i] <= 'h')) {
>                         spielerKombination[versuch][i] += ('A' - 'a');
>                     }
>                     if ((spielerKombination[versuch][i] < 'A')
>                     || (spielerKombination[versuch][i] > 'H')) {
>                         korrekt = false;
>                         System.out.println("Falscher Buchstabe enthalten.");
>                         break;
>                     }
>                 }
>             } else {
>                 korrekt = false;
>                 System.out.println("Zu viele oder zu wenige Buchstaben.");
>             }
>         } while (!korrekt);
>     }
> 
>     void bewertung() {
>         System.out.println((versuch + 1) + " bisherige Versuche:");
>         for (int k = 0; k <= versuch; k++) {
>             for (int i = 0; i < 5; i++) {
>                 System.out.print(spielerKombination[k][i]);
>             }
>             richtigeBuchstaben();
>             System.out.println(" " + richtigeStellen[k] + " "
>             + falscheStellen[k]);
>         }
>     }
> 
>     void richtigeBuchstaben() {
>         richtigeStellen[versuch] = 0;
>         falscheStellen[versuch] = 0;
>         for (char ch = 'A'; ch <= 'H'; ch++) {
>             int buchstabeInComputerKombination = 0;
>             int buchstabeInSpielerKombination = 0;
>             int buchstabeUebereinstimmend = 0;
>             for (int i = 0; i < 5; i++) {
>                 if (computerKombination[i] == ch) {
>                     buchstabeInComputerKombination++;
>                     if (spielerKombination[versuch][i] == ch) {
>                         buchstabeUebereinstimmend++;
>                     }
>                 }
>             }
>             for (int i = 0; i < 5; i++) {
>                 if (spielerKombination[versuch][i] == ch) {
>                     buchstabeInSpielerKombination++;
>                 }
>             }
>             richtigeStellen[versuch] += buchstabeUebereinstimmend;
>             falscheStellen[versuch]
>             += Math.min(buchstabeInSpielerKombination,
>             buchstabeInComputerKombination)
>             - buchstabeUebereinstimmend;
>         }
>     }
> 
>     public static void main(String[] args) {
>         MasterMind mm = new MasterMind();
>         mm.spiel();
>     }
> 
> }
> ```

## Meine Notizen

