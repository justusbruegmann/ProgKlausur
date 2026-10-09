---
tags: ["typ/uebung", "thema/kontrollstrukturen", "kategorie/grundlagen", "semester/1", "schwierigkeit/2", "hat/musterloesung"]
aliases: ["NumberGuess"]
thema: "[[06 Kontrollstrukturen]]"
klasse: "NumberGuess"
package: "de.dhbwka.java.exercise.control"
schwierigkeit: 2
status: "offen"
---

# Ü06 Zahlenraten

**Thema:** [[06 Kontrollstrukturen]] · **Bereich:** Kontrollstrukturen · **Schwierigkeit:** ★★☆☆☆
**Klasse:** `NumberGuess` · **Package:** `de.dhbwka.java.exercise.control`

📄 Aufgabe: [[Material/Aufgaben/06_Kontrollstrukturen_Aufgaben.pdf#page=8|06_Kontrollstrukturen_Aufgaben.pdf, S. 8]]
✅ Musterlösung: [[Material/Aufgaben/06_Kontrollstrukturen_Aufgaben_Muster.pdf#page=9|06_Kontrollstrukturen_Aufgaben_Muster.pdf, S. 9]]

> [!question] Kurz gesagt
> Schreiben Sie eine Java-Applikation NumberGuess, die ein einfaches Ratespiel implementiert! Bei diesem Ratespiel muss der Benutzer eine zufällig erzeugte Zahl zwischen 1 und 100 erraten.

## Aufgabenstellung
```text
Schreiben Sie eine Java-Applikation NumberGuess, die ein einfaches Ratespiel implementiert!

Bei diesem Ratespiel muss der Benutzer eine zufällig erzeugte Zahl zwischen 1 und 100 erraten.
Als Hinweis bekommt er jeweils angezeigt, ob er zu hoch oder zu niedrig getippt hat.
Die Anzahl der Versuche, die er benötigt, wird mitgezählt.

Der Benutzer soll folgendes eingeben können:
    • Spielername
    • Jeweils die nächste zu tippende Zahl
    • Endabfrage, ob die Applikation beendet werden (Eingabewert: „0“)
       oder ein weiteres Spiel durchgeführt werden soll (Eingabewert: „1“).

Das Programm soll nach Eingabe eines Tipps prüfen, ob die aktuelle Eingabe höher, niedriger oder
gleich der gesuchten Zahl ist.
Es soll dann die Nummer des Versuches ausgeben und ob der Tipp zu hoch, zu niedrig oder korrekt
war.

Hinweis: Mit Math.random() können reelle Zufallszahlen aus dem Bereich [0,1) erzeugt werden.

Beispieldialog:

Wie ist Dein Name? Donald
Donald, rate eine Zahl [1-100]: 50
Versuch 1: 50 ist zu hoch.
Donald, rate eine Zahl [1-100]: 25
Versuch 2: 25 ist zu hoch.
Donald, rate eine Zahl [1-100]: 12
Versuch 3: 12 ist zu hoch.
Donald, rate eine Zahl [1-100]: 6
Versuch 4: 6 ist zu niedrig.
Donald, rate eine Zahl [1-100]: 9
Versuch 5: 9 ist zu hoch.
Donald, rate eine Zahl [1-100]: 7
Versuch 6: 7 ist korrekt.
Was möchtest Du tun?
0 - Das Spiel beenden
1 - Das Spiel fortsetzen 0
```

## Benötigte Begriffe
[[Typkonversion]] · [[Scanner]] · [[Zufallszahlen]] · [[Math-Klasse]] · [[while-Schleife]]

## Gleiche Klasse in anderen Übungen (Fortsetzung/Variante)
[[Ü23 Zahlenraten (2)]]

## Weitere Übungen zum Thema
[[Ü06 Schaltjahr]] · [[Ü06 Temperaturtabelle]] · [[Ü06 Wildbestand]] · [[Ü06 Einmaleins]] · [[Ü06 Aufsummieren]] · [[Ü06 Schuhgrößen]] · [[Ü06 Babylonisches Wurzelziehen (Heronverfahren)]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.control;
> 
> import java.util.Scanner;
> 
> public class NumberGuess {
> 
>     public static void main(String[] args) {
>         int limit = 100;
>         int end;
>         Scanner scan = new Scanner(System.in);
>         String bestPlayer = "";
>         int leastTrials = -1;      // negativer Wert: bisher wurde noch kein
>         // Spiel durchgeführt
> 
>         do {
>             int numberToGuess = (int) (Math.random() * limit + 1);
>             // System.out.println("#### Zu erratende Zahl: "
>             //         + zuErratendeZahl + " ####");
>             int trials = 0;
>             boolean guessed = false;
>             System.out.print("Geben Sie bitte Ihren Namen ein: ");
>             String name = scan.next();
> 
>             do {
>                 System.out.print("Geben Sie bitte eine Zahl aus dem Bereich "
>                 + "1 und 100 ein: ");
>                 int tip = scan.nextInt();
> 
>                 trials++;
>                 if (tip > numberToGuess) {
>                     System.out.println("Versuch Nr. " + trials + ": " + tip
>                     + " zu hoch!");
>                 } else if (tip < numberToGuess) {
>                     System.out.println("Versuch Nr. " + trials + ": " + tip
>                     + " zu niedrig!");
>                 } else {
>                     System.out.println("Versuch Nr. " + trials
>                     + ": Sie haben die Zahl erraten!!!");
>                     guessed = true;
>                     if ((leastTrials<0) | (trials<leastTrials)) {
>                         leastTrials = trials;
>                         bestPlayer = name;
> 
>                     }
>                 }
>             } while (!guessed);
> 
>             do {
>                 System.out.print("Wollen Sie das Spiel beenden (0), fortsetzen "
>                 + "(1) oder den bisher besten Spieler(in) ausgeben "
>                 + "lassen (2)? ");
>                 end = scan.nextInt();
>                 if ((end<0) || (end>2))
>                 System.out.println("Eingabefehler!");
>                 if (end == 2) {
>                     System.out.println("Bisher beste/r Spieler/in: "
>                     + bestPlayer
>                     + ", geringste Anzahl Versuche: "
>                     + leastTrials);
>                 }
>             } while ((end<0) || (end>1));
> 
>         } while (end == 1);
>     }
> }
> ```

## Meine Notizen

