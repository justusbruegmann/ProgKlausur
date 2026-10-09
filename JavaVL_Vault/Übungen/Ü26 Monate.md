---
tags: ["typ/uebung", "thema/enum", "kategorie/oop", "semester/2", "schwierigkeit/1", "hat/musterloesung"]
aliases: ["Months"]
thema: "[[26 Aufzählungstypen (Enums)]]"
klasse: "Months"
package: "de.dhbwka.java.exercise.enums"
schwierigkeit: 1
status: "offen"
---

# Ü26 Monate

**Thema:** [[26 Aufzählungstypen (Enums)]] · **Bereich:** Aufzählungstypen · **Schwierigkeit:** ★☆☆☆☆
**Klasse:** `Months` · **Package:** `de.dhbwka.java.exercise.enums`

📄 Aufgabe: [[Material/Aufgaben/26_Enum_Aufgaben.pdf#page=1|26_Enum_Aufgaben.pdf, S. 1]]
✅ Musterlösung: [[Material/Aufgaben/26_Enum_Aufgaben_Muster.pdf#page=1|26_Enum_Aufgaben_Muster.pdf, S. 1]]

> [!question] Kurz gesagt
> Entwerfen Sie einen Aufzählungstyp Months, der für jeden Monat dessen Namen, die Anzahl der Tage (der Februar hat in dieser Aufgabe immer 28 Tage) und die alten deutschen Monatsnamen kennt! Monat Tage Altdeutsche Namen Januar 31 Hartung, Eismond Februar 28 Hornung, Schmelzmond, Taumond, Narrenmond, Rebmond, Hintester März 31 Lenzing, Lenzmond April 30 Launing, Ostermond Mai 31 Winnemond\*, …

## Aufgabenstellung
```text
Entwerfen Sie einen Aufzählungstyp Months, der für jeden Monat dessen Namen, die Anzahl der
Tage (der Februar hat in dieser Aufgabe immer 28 Tage) und die alten deutschen Monatsnamen
kennt!

 Monat              Tage   Altdeutsche Namen

 Januar              31    Hartung, Eismond

 Februar             28    Hornung, Schmelzmond, Taumond, Narrenmond, Rebmond, Hintester

 März                31    Lenzing, Lenzmond

 April               30    Launing, Ostermond

 Mai                 31    Winnemond*, Blumenmond

 Juni                30    Brachet, Brachmond

 Juli                31    Heuert, Heumond

 August              31    Ernting, Erntemond, Bisemond

 September           30    Scheiding, Herbstmond

 Oktober             31    Gilbhart, Gilbhard, Weinmond

 November            30    Nebelung, Windmond, Wintermond

 Dezember            31    Julmond, Heilmond, Christmond, Dustermond

*Weidemonat: heute zu Wonnemonat umgedeutet

Geben Sie im Hauptprogramm die Daten zum aktuellen Monat aus, z.B.
Der Juni hat 30 Tage und hieß früher 'Brachet, Brachmond'

Hinweis:
Den aktuellen Monat bekommen Sie mit
    new Date().getMonth()
oder seit JDK 1.1 besser:
   Calendar.getInstance().get(Calendar.MONTH)
als int (Zählung beginnt bei 0).
```

## Benötigte Begriffe
[[for-Schleife]] · [[this]] · [[toString]] · [[Kapselung]] · [[Überschreiben]] · [[Enum]]

## Weitere Übungen zum Thema
[[Ü26 Kartenspiel]] · [[Ü26 Sortierkriterien]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.enums;
> 
> import java.util.Calendar;
> 
> public enum Months {
> 
>     JANUARY("Januar", 31, "Hartung, Eismond"),
>     FEBRUARY("Februar", 28,
>     "Hornung, Schmelzmond, Taumond, Narrenmond, Rebmond, Hintester"),
>     MARCH("M\u00E4rz", 31, "Lenzing, Lenzmond"),
>     APRIL("April", 30, "Launing, Ostermond"),
>     MAY("Mai", 31, "Winnemond*, Blumenmond"),
>     JUNE("Juni", 30, "Brachet, Brachmond"),
>     JULY("Juli", 31, "Heuert, Heumond"),
>     AUGUST("August", 31, "Ernting, Erntemond, Bisemond"),
>     SEPTEMBER("September", 30, "Scheiding, Herbstmond"),
>     OCTOBER("Oktober", 31, "Gilbhart, Gilbhard, Weinmond"),
>     NOVEMBER("November", 30, "Nebelung, Windmond, Wintermond"),
>     DECEMBER("Dezember", 31, "Julmond, Heilmond, Christmond, Dustermond");
> 
>     private String name;
>     private int days;
>     private String altNames;
> 
>     private Months( String name, int days, String altNames ) {
>         this.name = name;
>         this.days = days;
>         this.altNames = altNames;
>     }
> 
>     @Override
>     public String toString() {
>         return "Der " + this.name + " hat " + this.days
>         + " Tage und hie\u00DF fr\u00FCher '" + this.altNames + "'";
>     }
> 
>     public String getName() {
>         return this.name;
>     }
> 
>     Aufgaben Enum                                 Musterlösung                        1 / 13
> 
>     public int getDays() {
>         return this.days;
>     }
> 
>     public String getAltNames() {
>         return this.altNames;
>     }
> 
>     public static void main( String[] args ) {
>         int thisMonth = Calendar.getInstance().get( Calendar.MONTH );
>         for ( Months month : Months.values() ) {
>             if ( month.ordinal() == thisMonth ) {
>                 System.out.println( month );
>             }
>         }
>         System.out.println( Months.values()[thisMonth] );
>     }
> 
> }
> 
> Aufgaben Enum                                 Musterlösung             2 / 13
> ```

## Meine Notizen

