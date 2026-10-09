---
tags: ["typ/uebung", "thema/klassen", "kategorie/oop", "semester/1", "schwierigkeit/3", "hat/musterloesung"]
aliases: ["Lotto"]
thema: "[[09 Klassen und Objekte]]"
klasse: "Lotto"
package: "de.dhbwka.java.exercise.classes"
schwierigkeit: 3
status: "offen"
---

# Ü09 Lotto

**Thema:** [[09 Klassen und Objekte]] · **Bereich:** Klassen (3) · **Schwierigkeit:** ★★★☆☆
**Klasse:** `Lotto` · **Package:** `de.dhbwka.java.exercise.classes`

📄 Aufgabe: [[Material/Aufgaben/09_Klassen_Aufgaben-3.pdf#page=3|09_Klassen_Aufgaben-3.pdf, S. 3]]
✅ Musterlösung: [[Material/Aufgaben/09_Klassen_Aufgaben-3_Muster.pdf#page=3|09_Klassen_Aufgaben-3_Muster.pdf, S. 3]]

> [!question] Kurz gesagt
> Bei einem (vereinfachten) deutschen Lottospiel werden 6 Kugeln aus einer Anzahl von 49 Kugeln gezogen. Implementieren Sie eine Klasse, die ein beliebiges Lottospiel simuliert. a) Implementieren Sie dazu einen geeigneten Konstruktor der Art: Lotto(int m, int n) Damit soll ein Lottospiel der Art m Kugeln aus n erzeugt werden.

## Aufgabenstellung
```text
Bei einem (vereinfachten) deutschen Lottospiel werden 6 Kugeln aus einer Anzahl von 49 Kugeln
gezogen. Implementieren Sie eine Klasse, die ein beliebiges Lottospiel simuliert.

a) Implementieren Sie dazu einen geeigneten Konstruktor der Art:
    Lotto(int m, int n)
    Damit soll ein Lottospiel der Art m Kugeln aus n erzeugt werden. Das deutsche Lotto müsste
    damit wie folgt erzeugt werden:
    Lotto deutschesLotto = new Lotto(6,49);

b) Die Klasse Lotto soll folgende Attribute besitzen:
     ein Attribut, das die Anzahl der zu ziehenden Kugel beschreibt,
     ein Attribut, das die Gesamtzahl der Kugel beschreibt,
     ein Array, das Ihren Tipp enthält,
     ein Array, das die gezogenen Zahlen enthält.

c) Schreiben Sie zu der Klasse Lotto die folgenden Methoden:
    <Typ> tippen()
    Diese Methode frägt Sie nach Ihrem Tipp. Die Methode muss sicherstellen, dass die getippten
    Zahlen im erlaubten Zahlenbereich sind.
    <Typ> tippen(int[] tipp)
    Diese Methode fragt Sie nicht nach Ihrem Tipp sondern erhält ein Array von Zahlen mit Ihrem
    Tipp. (Gut geeignet zum Testen der Klasse, damit man nicht immer alle Zahlen eingeben muss.)
    <Typ> ziehen()
    Diese Methode führt eine Ziehung der Zahlen durch, d.h. erstellt eine entsprechende Anzahl an
    zufälligen Zahlen.
    int richtige()
    Diese Methode ermittelt, wie viele richtige Zahlen Sie bei Ihrem Tipp hatten.
    public String toString()
    Diese Methode gibt den Zustand Ihres Lottospiels aus. Falls sie schon getippt haben, soll Ihr Tipp
    ausgegeben werden. Falls die Ziehung schon erfolgte, sollen auch die gezogenen Zahlen
    ausgegeben werden. Die Zahlen sollen dabei in aufsteigender Reihenfolge ausgegeben werden.
    Am besten sortieren Sie dazu die beiden Arrays, die die Klasse als Attribute besitzt.

Beispielausgabe:

Geben Sie bitte Ihren Tipp für die 1. Zahl ein: 22
Geben Sie bitte Ihren Tipp für die 2. Zahl ein: 11
Geben Sie bitte Ihren Tipp für die 3. Zahl ein: 33
Geben Sie bitte Ihren Tipp für die 4. Zahl ein: 1
Geben Sie bitte Ihren Tipp für die 5. Zahl ein: 49

Geben Sie bitte Ihren Tipp für die 6. Zahl ein: 17
Tipp: 1 11 17 22 33 49

Tipp: 1 11 17 22 33 49
Gezogene Zahlen: 6 11 32 35 47 49

Richtige: 2
```

## Benötigte Begriffe
[[Typkonversion]] · [[Scanner]] · [[Zufallszahlen]] · [[while-Schleife]] · [[for-Schleife]] · [[Array]] · [[Sortieren]] · [[Konstruktor]] · [[this]] · [[toString]]

## Weitere Übungen zum Thema
[[Ü09 Radio]] · [[Ü09 Zweidimensionaler Punkt]] · [[Ü09 Bankkonto]] · [[Ü09 Polynom 2. Grades]] · [[Ü09 Komplexe Zahlen]] · [[Ü09 Polynome und Horner-Schema]] · [[Ü09 Nimmspiel]] · [[Ü09 MasterMind]] · [[Ü09 Wechselspiel (1. Teil)]] · [[Ü09 Wechselspiel (2. Teil)]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.classes;
> 
> public class Lotto {
> 
>     int anzahlZuZiehendeKugeln;
>     int gesamtzahlKugeln;
>     int[] tipp;
>     int[] gezogeneZahlen;
>     java.util.Scanner scan;
> 
>     Lotto(int m, int n) {
>         anzahlZuZiehendeKugeln = m;
>         gesamtzahlKugeln = n;
>         tipp = new int[anzahlZuZiehendeKugeln];
>         gezogeneZahlen = new int[anzahlZuZiehendeKugeln];
>         scan = new java.util.Scanner(System.in);
>     }
> 
>     void spiel() {
>         tippen();
>         sortiere(tipp);
>         ziehen();
>         sortiere(gezogeneZahlen);
>         // Test-Ausgabe
>         System.out.println(this.toString());
>         System.out.println("Richtige: " + richtige());
>     }
> 
>     void tippen() {
>         boolean eingabeFehler;
>         for (int i = 0; i < anzahlZuZiehendeKugeln; i++) {
>             do {
>                 System.out.print("Geben Sie bitte Ihren Tipp für die " + (i + 1)
>                 + ". Zahl ein: ");
>                 eingabeFehler = false;
>                 tipp[i] = scan.nextInt();
>                 if ((tipp[i] < 1) || (tipp[i] > 49)) {
>                     System.out.println("Eingabefehler: Zahl zu groß oder"
>                     + " zu klein.");
>                     eingabeFehler = true;
>                 }
>                 for (int k = 0; k < i; k++) {
>                     if (tipp[k] == tipp[i]) {
>                         System.out.println("Eingabefehler: Zahl schon "
>                         + "getippt.");
>                         eingabeFehler = true;
>                     }
>                 }
>             } while (eingabeFehler);
>         }
>     }
> 
>     void sortiere(int[] feld) {
>         int temp;
>         boolean tausch = true;
>         while (tausch) {
>             tausch = false;
>             for (int i = 0; i < anzahlZuZiehendeKugeln - 1; i++) {
>                 if (feld[i] > feld[i + 1]) {
>                     temp = feld[i];
>                     feld[i] = feld[i + 1];
>                     feld[i + 1] = temp;
>                     tausch = true;
>                 }
>             }
>         }
>     }
> 
>     void ziehen() {
>         boolean schonVorhanden;
>         for (int i = 0; i < anzahlZuZiehendeKugeln; i++) {
>             do {
>                 schonVorhanden = false;
>                 gezogeneZahlen[i] = (int) (Math.random() * 49 + 1);
>                 for (int k = 0; k < i; k++) {
>                     if (gezogeneZahlen[k] == gezogeneZahlen[i]) {
>                         schonVorhanden = true;
>                     }
>                 }
>             } while (schonVorhanden);
>         }
>     }
> 
>     int richtige() {
>         int anzRichtige = 0;
>         for (int i = 0; i < anzahlZuZiehendeKugeln; i++) {
>             for (int k = 0; k < anzahlZuZiehendeKugeln; k++) {
>                 if (tipp[i] == gezogeneZahlen[k]) {
>                     anzRichtige++;
>                 }
>             }
>         }
>         return anzRichtige;
>     }
> 
>     public String toString() {
>         String str = "";
>         if (tipp[0] != 0) {
>             str += "Tipp: ";
>             for (int i = 0; i < anzahlZuZiehendeKugeln; i++) {
>                 str = str + tipp[i] + " ";
>             }
>             str += "\n";
>         }
>         if (gezogeneZahlen[0] != 0) {
>             str += "Gezogene Zahlen: ";
>             for (int i = 0; i < anzahlZuZiehendeKugeln; i++) {
>                 str = str + gezogeneZahlen[i] + " ";
>             }
>             str += "\n";
>         }
>         return str;
>     }
> 
>     public static void main(String[] args) {
>         Lotto deutschesLotto = new Lotto(6, 49);
>         deutschesLotto.spiel();
>     }
> 
> }
> ```

## Meine Notizen

