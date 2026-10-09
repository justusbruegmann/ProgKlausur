---
tags: ["typ/uebung", "thema/dokumentation", "kategorie/werkzeuge", "semester/1", "hat/musterloesung"]
aliases: ["Radio"]
thema: "[[12 Dokumentation mit Javadoc]]"
klasse: "Radio"
package: "de.dhbwka.java.exercise.docu"
status: "offen"
---

# Ü12 Radio kommentiert

**Thema:** [[12 Dokumentation mit Javadoc]] · **Bereich:** Dokumentation · **Schwierigkeit:** –
**Klasse:** `Radio` · **Package:** `de.dhbwka.java.exercise.docu`

📄 Aufgabe: [[Material/Aufgaben/12_Dokumentation_Aufgaben.pdf#page=1|12_Dokumentation_Aufgaben.pdf, S. 1]]
✅ Musterlösung: [[Material/Aufgaben/12_Dokumentation_Aufgaben_Muster.pdf#page=1|12_Dokumentation_Aufgaben_Muster.pdf, S. 1]]

> [!question] Kurz gesagt
> Kommentieren Sie das Programm aus der Aufgabe „Radio“ vom Übungsblatt „Klassen (1)“ ausgiebig und erzeugen Sie mit javadoc die zugehörige Dokumentation. Überprüfen Sie die Dokumentation auf Verständlichkeit für einen Außenstehenden (z.B. tauschen Sie diese mit Ihrem Nachbarn aus), ergänzen Sie ggf. die Dokumentation und erzeugen Sie diese erneut!

## Aufgabenstellung
```text
Kommentieren Sie das Programm aus der Aufgabe „Radio“ vom Übungsblatt „Klassen (1)“ ausgiebig
und erzeugen Sie mit javadoc die zugehörige Dokumentation.

Überprüfen Sie die Dokumentation auf Verständlichkeit für einen Außenstehenden (z.B. tauschen
Sie diese mit Ihrem Nachbarn aus), ergänzen Sie ggf. die Dokumentation und erzeugen Sie diese
erneut!
```

## Benötigte Begriffe
[[this]] · [[toString]] · [[Überschreiben]] · [[Javadoc]]

## Gleiche Klasse in anderen Übungen (Fortsetzung/Variante)
[[Ü09 Radio]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.docu;
> 
> public class Radio {
> 
>     /**
>      * Zustand des Radios. Eingeschaltet oder nicht eingeschaltet.
>      */
>     public boolean eingeschaltet = false;
> 
>     /**
>      * Wie laut spielt das Radio Musik. Die Lautstärke soll nur im Bereich von 0
>      * bis 10 liegen.
>      */
>     public int lautstaerke = 5;
> 
>     /**
>      * Frequenz des gewählten Senders. Erlaubter Frequenzbereich ist zwischen
>      * 85.0 und 110.0.
>      */
>     public double frequenz = 98.4;
> 
>     /**
>      * Erzeugt ein Standard-Radio-Objekt. Standardwerte: eingeschaltet = false,
>      * lautstaerke = 5, frequenz = 98.4
>      */
>     public Radio() {
>     }
> 
>     /**
>      * Erzeugt ein Radio-Objekt mit den angegebenen Attributwerten.
>      *
>      * @param einaus Zustand des Radios: eingeschaltet (true) oder ausgeschaltet
>      * (false)
>      * @param laut Lautstärke
>      * @param freq Frequenz
>      */
>     public Radio(boolean einaus, int laut, double freq) {
> 
>         eingeschaltet = einaus;
>         if (laut >= 0 && laut <= 10) {
>             lautstaerke = laut;
>         }
>         waehleSender(freq);
>     }
> 
>     /**
>      * Reduziert die Lautstärke um eine Einheit. Ist nur möglich im Zustand an.
>      */
>     public void leiser() {
>         if (eingeschaltet && lautstaerke > 0) {
>             lautstaerke--;
>         }
>     }
> 
>     /**
>      * Erhöht die Lautstärke um eine Einheit. Ist nur möglich im Zustand an.
>      */
>     public void lauter() {
>         if (eingeschaltet && lautstaerke < 10) {
>             lautstaerke++;
>         }
>     }
> 
>     /**
>      * Setzt den Zustand des Radios auf eingeschaltet. Das Attribut
>      * eingeschaltet wird auf true gesetzt.
>      */
>     public void an() {
>         eingeschaltet = true;
>     }
> 
>     /**
>      * Setzt den Zustand des Radios auf ausgeschaltet. Das Attribut
>      * eingeschaltet wird auf false gesetzt.
>      */
>     public void aus() {
>         eingeschaltet = false;
>     }
> 
>     /**
>      * Gibt Informationen über den internen Zustand als String zurück. Es wird
>      * eine Zeichenkette der Form "Radio an: Freq=98.4, Laut=2" zurückgeben.
>      */
>     @Override
>     public String toString() {
>         String s = "Radio ";
>         if (eingeschaltet) {
>             s += "an:";
>             s += " Freq=" + frequenz + ", ";
>             s += "Laut=" + lautstaerke + "";
>         } else {
>             s += "aus.";
>         }
>         return s;
>     }
> 
>     /**
>      * Speichert eine Frequenz. Ist die gewählte Frequenz ausserhalb der
>      * erlaubten Frequenzbereichs, so wird die Frequenz 99.9 gewählt.
>      */
>     public void waehleSender(double frequenz) {
>         if ((frequenz <= 110.0) && (frequenz >= 85.0)) {
>             this.frequenz = frequenz;
>         } else {
>             this.frequenz = 99.9;
>         }
>     }
> 
>     /*
>      * Dient zum Testen der Methoden der Klasse Radio.
>      */
>     public static void main(String[] args) {
>         Radio radio = new Radio(true, 8, 99.9);
>         radio.leiser();
>         System.out.println(radio.toString());
>         radio.leiser();
>         System.out.println(radio.toString());
>         radio.lauter();
>         System.out.println(radio.toString());
>         radio.waehleSender(112.8);
>         System.out.println(radio.toString());
>         radio.waehleSender(93.5);
>         System.out.println(radio.toString());
>         radio.aus();
>         System.out.println(radio.toString());
>         radio.leiser();
>         System.out.println(radio.toString());
>         radio.an();
>         System.out.println(radio.toString());
>     }
> }
> ```

## Meine Notizen

