---
tags: ["typ/uebung", "thema/klassen", "kategorie/oop", "semester/1", "schwierigkeit/1", "hat/musterloesung"]
aliases: ["Radio"]
thema: "[[09 Klassen und Objekte]]"
klasse: "Radio"
package: "de.dhbwka.java.exercise.classes"
schwierigkeit: 1
status: "offen"
---

# Ü09 Radio

**Thema:** [[09 Klassen und Objekte]] · **Bereich:** Klassen (1) · **Schwierigkeit:** ★☆☆☆☆
**Klasse:** `Radio` · **Package:** `de.dhbwka.java.exercise.classes`

📄 Aufgabe: [[Material/Aufgaben/09_Klassen_Aufgaben-1.pdf#page=1|09_Klassen_Aufgaben-1.pdf, S. 1]]
✅ Musterlösung: [[Material/Aufgaben/09_Klassen_Aufgaben-1_Muster.pdf#page=1|09_Klassen_Aufgaben-1_Muster.pdf, S. 1]]

> [!question] Kurz gesagt
> a) Implementieren Sie eine Klasse Radio mit folgenden Attributen:  on, ob das Radio an (true) oder aus (false) ist  volume, wie laut spielt das Radio Musik? (Die Lautstärke soll nur im Bereich von 0 bis 10 liegen und ganzzahlig sein)  frequency, gibt die Frequenz des gewählten Senders an (Erlaubter Frequenzbereich ist von 85.0 bis 110.0) b) Implementieren Sie zu der Klasse zwei Konstruktoren …

## Aufgabenstellung
```text
a) Implementieren Sie eine Klasse Radio mit folgenden Attributen:
     on, ob das Radio an (true) oder aus (false) ist
     volume, wie laut spielt das Radio Musik?
        (Die Lautstärke soll nur im Bereich von 0 bis 10 liegen und ganzzahlig sein)
     frequency, gibt die Frequenz des gewählten Senders an
        (Erlaubter Frequenzbereich ist von 85.0 bis 110.0)

b) Implementieren Sie zu der Klasse zwei Konstruktoren der Art:
     Radio() mit sinnvollen Startwerten
     Radio(boolean on, int volume, double frequency)

c) Zu der Klasse Radio sollen folgende Methoden implementiert werden:
     void incVolume(), void decVolume()
        Diese Methoden sollen die Lautstärke um 1 Einheit ändern (nur möglich im Zustand an).
     void turnOn(),void turnOff()
        Diese Methoden sollen den Zustand des Attributs eingeschaltet (on) ändern.
     void setFrequency(double frequency)
        Diese Methode soll eine Frequenz speichern. Ist die gewählte Frequenz außerhalb des
        erlaubten Frequenzbereichs, soll die Frequenz 99.9 gewählt werden.
     public String toString()
        Diese Methode soll Informationen über den internen Zustand als String zurückgeben.
        Sie soll eine Zeichenkette der Form "Radio an: Freq=98.4, Laut=2" zurückgeben.

d) Testen Sie Ihre Klasse mit der main()-Methode oder aus einer anderen Klasse heraus!

Beispiel für eine Testmethode:
public static void main(String[] args) {
      Radio radio = new Radio(false, 7, 93.5);
      System.out.println(radio);
      radio.turnOn();
      System.out.println(radio);
      radio.incVolume(); radio.incVolume();
      System.out.println(radio);
      radio.incVolume();
      radio.incVolume();
      System.out.println(radio);
      radio.decVolume();
      System.out.println(radio);
      radio.setFrequency(97.8);
      System.out.println(radio);
      radio.setFrequency(112.7);
      System.out.println(radio);
      radio.turnOff();
      System.out.println(radio);

}
Zugehörige Ausgabe:
Radio aus; Lautstärke 7; Frequenz 93.5 MHz
Radio an; Lautstärke 7; Frequenz 93.5 MHz
Radio an; Lautstärke 9; Frequenz 93.5 MHz
Radio an; Lautstärke 10; Frequenz 93.5 MHz
Radio an; Lautstärke 9; Frequenz 93.5 MHz
Radio an; Lautstärke 9; Frequenz 97.8 MHz
Radio an; Lautstärke 9; Frequenz 99.9 MHz
Radio aus; Lautstärke 9; Frequenz 99.9 MHz
```

## Benötigte Begriffe
[[Bedingungsoperator]] · [[Konstruktor]] · [[this]] · [[toString]] · [[Überschreiben]] · [[String]]

## Gleiche Klasse in anderen Übungen (Fortsetzung/Variante)
[[Ü12 Radio kommentiert]]

## Weitere Übungen zum Thema
[[Ü09 Zweidimensionaler Punkt]] · [[Ü09 Bankkonto]] · [[Ü09 Polynom 2. Grades]] · [[Ü09 Komplexe Zahlen]] · [[Ü09 Polynome und Horner-Schema]] · [[Ü09 Nimmspiel]] · [[Ü09 Lotto]] · [[Ü09 MasterMind]] · [[Ü09 Wechselspiel (1. Teil)]] · [[Ü09 Wechselspiel (2. Teil)]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.classes;
> 
> public class Radio {
> 
>     boolean on;
>     int volume;
>     double frequency;
> 
>     public Radio() {
>         this(true, 5, 98.4);
>     }
> 
>     public Radio(boolean on, int volume, double frequency) {
>         this.on = on;
>         if (volume < 0) {
>             this.volume = 0;
>         } else if (volume > 10) {
>             this.volume = 10;
>         } else {
>             this.volume = volume;
>         }
>         this.setFrequency(frequency);
>     }
> 
>     public void turnOn() {
>         this.on = true;
>     }
> 
>     public void turnOff() {
>         this.on = false;
>     }
> 
>     public void incVolume() {
>         if (on && volume<10)
>         volume++;
>     }
> 
>     public void decVolume() {
>         if (on && volume>0)
>         volume--;
>     }
> 
>     public void setFrequency(double freq) {
>         if (freq >= 85.0 && freq < 110.0)
>         this.frequency = freq;
>         else
>         this.frequency = 99.9; // standard freq.
>     }
> 
>     @Override
>     public String toString() {
>         return "Radio " + (on ? "an" : "aus")
>         + "; Lautstärke " + volume
>         + "; Frequenz " + frequency + " MHz";
>     }
> 
>     public static void main(String[] args) {
>         Radio radio = new Radio(false, 7, 93.5);
>         System.out.println(radio);
>         radio.turnOn();
>         System.out.println(radio);
>         radio.incVolume();
>         radio.incVolume();
>         System.out.println(radio);
>         radio.incVolume();
>         radio.incVolume();
>         System.out.println(radio);
>         radio.decVolume();
>         System.out.println(radio);
>         radio.setFrequency(97.8);
>         System.out.println(radio);
>         radio.setFrequency(112.7);
>         System.out.println(radio);
>         radio.turnOff();
>         System.out.println(radio);
>     }
> 
> }
> ```

## Meine Notizen

