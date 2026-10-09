---
tags: ["typ/uebung", "thema/vererbung", "kategorie/oop", "semester/1", "schwierigkeit/2"]
aliases: ["PeriodicTable"]
thema: "[[13 Vererbung]]"
klasse: "PeriodicTable"
package: "de.dhbwka.java.exercise.classes.periodic"
schwierigkeit: 2
status: "offen"
---

# Ü13 Periodensystem

**Thema:** [[13 Vererbung]] · **Bereich:** Vererbung (2) · **Schwierigkeit:** ★★☆☆☆
**Klasse:** `PeriodicTable` · **Package:** `de.dhbwka.java.exercise.classes.periodic`

📄 Aufgabe: [[Material/Aufgaben/13_Vererbung_Aufgaben-2.pdf#page=1|13_Vererbung_Aufgaben-2.pdf, S. 1]]

> [!question] Kurz gesagt
> Entwickeln Sie einige Klassen zur Darstellung des Periodensystems der Elemente! Die Klasse Element soll folgende gekapselte Attribute speichern:  Name: String  Symbol: String (z.B. „H“ für Wasserstoff)  Ordnungszahl (auch: Kernladungszahl, engl. „ordinal“): int  Schale (engl. „shell“): char  Aggregatzustand (engl. „phase“) bei 25°C (298K): int (SOLID\=1, LIQUID\=2, GAS\=3)  …

## Aufgabenstellung
```text
Entwickeln Sie einige Klassen zur Darstellung des Periodensystems der Elemente!
Die Klasse Element soll folgende gekapselte Attribute speichern:
     Name: String
     Symbol: String (z.B. „H“ für Wasserstoff)
     Ordnungszahl (auch: Kernladungszahl, engl. „ordinal“): int
     Schale (engl. „shell“): char
     Aggregatzustand (engl. „phase“) bei 25°C (298K): int (SOLID=1, LIQUID=2, GAS=3)
     Hauptgruppe/Nebengruppe (H/N): boolean (MAIN=true, SIDE=false)
Implementieren Sie geeignete Konstruktoren zur Erzeugung neuer Element-Objekte!
Implementieren Sie Methoden zum Lesen und Setzen („getter-/setter“) der Attribute!
Implementieren Sie eine Methode public String toString(), die umfassend Auskunft
über das Element gibt!
Implementieren Sie eine Methode public boolean equals(Object o), die genau dann
true ist, wenn es sich bei o um ein Element (inkl. Unterklassen) handelt und die Ordnungszahlen
von o und this. gleich sind!

Die Klasse Metal soll von Element erben und folgende zusätzliche Eigenschaften haben:
     metalloid: boolean (true wenn es sich um ein Halbmetall (engl. „metalloid“) handelt)
     conductivity: double (Leitfähigkeit,  (sigma, Unicode-Zeichen \u03C3))
Implementieren Sie auch hierfür die entsprechenden getter-/setter-Methoden!
Erweitern Sie die Konstruktoren für Metal für diese Eigenschaften!
Überschreiben Sie die Methode toString() so, dass auch die zusätzlichen Eigenschaften von
Metall ausgegeben werden.

Schreiben Sie eine Klasse PeriodicTable (Periodensystem), die alle 118 Elemente speichern
kann. Verwenden Sie zum Speichern der Elemente ein Array!

Schreiben Sie folgende Methoden:
     public void addElement(Element e): Fügt ein Element hinzu, wenn es dieses
        noch nicht gibt (Kriterium: Ordnungszahl)
     public boolean hasElement(int o): true genau dann, wenn es ein Element
        mit der Ordnungszahl o gibt
     public Element getElement(int o): Liefert ein Element anhand seiner
        Ordnungszahl o
     public Element[] getMetals(): Liefert ein Array aller Metalle

Erzeugen Sie in der Klasse PeriodicTable exemplarisch folgende Elemente bzw. Metalle und
geben Sie diese mittels einer for-Schleife auf der Konsole aus!

  Symbol          Name           O    Schale    Aggreg.      H/N      Halbm.       Leitfähigkeit
     H         Wasserstoff       1      K        gasf.       H
    He            Helium         2      K        gasf.       H
    Na           Natrium         11     M         fest       H         false       21 · 106 S/m
     Fe            Eisen         26     N         fest       N         false      10,02 · 106 S/m
    Ge         Germanium         32     N         fest       N          true         1,45 S/m
     Br            Brom          35     N       flüssig      H
    Te             Tellur        52     O         fest       H          true        0,005 S/m
    Au             Gold          79     P         fest       N         false      44,0 · 106 S/m
S/m = Siemens/Meter = -1m-1

Geben Sie anschließend eine Liste aller Metalle aus!

Geben Sie außerdem Informationen zum Element mit der Ordnungszahl 79 aus!

Beispielausgabe (für Metalle):

Metalle:
Natrium (Na,11) Schale: M, fest, Gruppe: Hauptgruppe, σ: 2.1E7
Eisen (Fe,26) Schale: N, fest, Gruppe: Nebengruppe, σ: 1.002E7
Germanium (Ge,32) Schale: N, fest, Gruppe: Nebengruppe, Halbleiter, σ: 1.45
Tellur (Te,52) Schale: O, fest, Gruppe: Hauptgruppe, Halbleiter, σ: 0.005
Gold (Au,79) Schale: P, fest, Gruppe: Nebengruppe, σ: 4.4E7

Gold:
Gold (Au,79) Schale: P, fest, Gruppe: Nebengruppe, σ: 4.4E7

                                                                   Quelle Periodensystem: Wikipedia
```

## Benötigte Begriffe
[[Array]] · [[Konstruktor]] · [[toString]] · [[Kapselung]] · [[Vererbung]] · [[Überschreiben]] · [[equals und hashCode]] · [[List]]

## Weitere Übungen zum Thema
[[Ü13 Fahrzeuge, Wettrennen]]

## Meine Notizen

