---
tags: ["typ/thema", "thema/packages", "kategorie/grundlagen", "semester/1"]
aliases: ["Java Packages", "Folien 03"]
semester: 1
kategorie: "Grundlagen"
folien: "[[Material/Folien/03_Packages.pdf]]"
seiten: 7
---

# 03 Java Packages

← [[02 Entwicklungsumgebungen Eclipse und IntelliJ]] · [[Start|🏠 Start]] · [[04 Primitive Datentypen]] →

> [!abstract] Worum geht's?
> Strukturierung von Programmen mit Paketen: Pakete deklarieren und importieren, Paket-Hierarchien und Namenskonventionen sowie eine Ordnerstruktur für die Übungsaufgaben.

**Semester:** Programmieren I · **Bereich:** #kategorie/grundlagen · **Folien:** [[Material/Folien/03_Packages.pdf|03_Packages.pdf]] (7 Seiten)

## Gliederung der Folien
- [[Material/Folien/03_Packages.pdf#page=2|S. 2]] Java Packages – Programme strukturieren
- [[Material/Folien/03_Packages.pdf#page=3|S. 3]] Pakete deklarieren
- [[Material/Folien/03_Packages.pdf#page=4|S. 4]] Pakete importieren
- [[Material/Folien/03_Packages.pdf#page=5|S. 5]] Paket-Hierarchien
- [[Material/Folien/03_Packages.pdf#page=6|S. 6]] Namenskonvention für Pakete
- [[Material/Folien/03_Packages.pdf#page=7|S. 7]] Vorschlag: Struktur für Übungsaufgaben

## Begriffe in diesem Kapitel
- [[Package]] (S. [[Material/Folien/03_Packages.pdf#page=2|2]], [[Material/Folien/03_Packages.pdf#page=3|3]], [[Material/Folien/03_Packages.pdf#page=4|4]], [[Material/Folien/03_Packages.pdf#page=5|5]], [[Material/Folien/03_Packages.pdf#page=6|6]])
- [[Bezeichner und Namenskonventionen]] (S. [[Material/Folien/03_Packages.pdf#page=3|3]], [[Material/Folien/03_Packages.pdf#page=6|6]])

## Übungen
- [ ] [[Ü03 Hallo Welt]] –

## Verwandte Themen
[[01 Die Programmiersprache Java]] · [[02 Entwicklungsumgebungen Eclipse und IntelliJ]] · [[13 Vererbung]]

## Folien ansehen
![[Material/Folien/03_Packages.pdf]]

## Folientext (durchsuchbar)
> [!quote]- Kompletter Folientext – aufklappen
> ```text
> ── Seite 1 ──
> Programmieren I
> Java Packages
> 
> Institut für Automation und angewandte Informatik
> 
> KIT – Die Forschungsuniversität in der Helmholtz-Gemeinschaft www.kit.edu
> 
> ── Seite 2 ──
> Java Packages – Programme strukturieren
> 
>    Strukturierung der unterschiedlichen Aufgaben mittels
>    Paketen (engl: package)
> 
>    Ein Paket ist eine Gruppe von thematisch
>    zusammengehörigen Klassen.
>    Diese befinden sich normalerweise in einem Verzeichnis.
>    Der Name des Verzeichnisses ist gleich dem Paketnamen.
> 
>    Bildquelle: http://publicdomainvectors.org
> 
> 2 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 3 ──
> Pakete deklarieren
> 
>    Beispiel:
>    package goodies;
> 
>    public class Chocolate {
> 
>    }
> 
>    Die Klasse, die in dieser Datei implementiert wird, gehört
>    zum Paket goodies. Diese Zugehörigkeit wird durch das
>    Schlüsselwort package ausgedrückt.
> 
> 3 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 4 ──
> Pakete importieren
> 
>    Um in einem anderen Paket die Klassen zu nutzen, wird der Compiler
>    mit import auf die Klassen im Paket hingewiesen.
>    Die Klasse kann dann einfach mit dem Klassennamen (d.h. ohne
>    Angabe das Paketnamens) in der Datei referenziert werden:
>    package treat;   package goodies;
> 
>    public class Chocolate {
>    import goodies.Chocolate;
>    }
> 
>    class ChocolateBunny {
>    Chocolate choc;   // sonst: goodies.Chocolate
>    }
>    Damit nicht alle genutzten Klassen eines Pakets einzeln aufgeführt
>    werden müssen, lässt sich mit dem Sternchen (“*”) als einer Art
>    Wildcard auf alle public-Klassen des Pakets hinweisen.
>    Häufig Gebrauch machen davon Programme mit grafischer
>    Benutzeroberfläche. In den ersten Zeilen steht dann z.B.:
>    import javax.swing.*;
> 
> 4 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 5 ──
> Paket-Hierarchien
> 
>    Pakete sind oft in Hierarchien geordnet
>    (hauptpaket.unterpaket etc.).
>    Die Pakethierarchie wird dann auch auf die Verzeichnis-
>    struktur des Dateisystems abgebildet.
>    Zu einem Paket gehören oft mehrere Unterpakete.
>    Mit der Anweisung
>    import hauptpaketname.*;
> 
>    werden nicht automatisch auch die
>    Klassen der Unterpakete mit eingebunden.
>    Die import-Anweisung bezieht sich nur auf ein (Haupt-
>    bzw. Unter-)Paket und schließt dessen Unterpakete nicht
>    mit ein.   Bildquelle: http://publicdomainvectors.org
> 
> 5 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 6 ──
> Namenskonvention für Pakete
> 
>    Um eine bessere Unterscheidung zu Klassennamen zu
>    gewährleisten, werden Paketnamen per Konvention
>    komplett klein geschrieben.
> 
>    Z.B.
>    java.io
>    java.lang
>    java.lang.annotation
>    …
>    java.util
>    java.util.concurrent
>    de.dhbw.karlsruhe.programmieren
> 
> 6 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 7 ──
> Vorschlag: Struktur für Übungsaufgaben
> 
>    Ein Projekt in der IDE für sämtliche Übungsaufgaben
> 
>    Pro Aufgabe ein Basis-Package
> 
>    Vorschlag: de.dhbwka.java.exercise.aufgabe
>    → steht auch auf den Übungsblättern
> 
> 7 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> ```
