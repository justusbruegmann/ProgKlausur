---
tags: ["typ/thema", "thema/ide", "kategorie/werkzeuge", "semester/1"]
aliases: ["Entwicklungsumgebungen Eclipse und IntelliJ", "Folien 02"]
semester: 1
kategorie: "Werkzeuge"
folien: "[[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf]]"
seiten: 44
---

# 02 Entwicklungsumgebungen Eclipse und IntelliJ

← [[01 Die Programmiersprache Java]] · [[Start|🏠 Start]] · [[03 Java Packages]] →

> [!abstract] Worum geht's?
> Arbeiten mit den IDEs Eclipse und IntelliJ IDEA: Projekte anlegen, kompilieren und ausführen, Tastenkürzel und Code-Templates sowie Chancen und Grenzen von KI-Programmierhilfen.

**Semester:** Programmieren I · **Bereich:** #kategorie/werkzeuge · **Folien:** [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf|02_IDEs_Eclipse_IntelliJIDEA.pdf]] (44 Seiten)

## Gliederung der Folien
- [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=2|S. 2]] Was ist Programmieren
- [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=3|S. 3]] Vereinfachung: Ein Tool für alles!
- [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=4|S. 4]] Entwicklungsumgebungen für Java
- [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=5|S. 5]] Neues Projekt – Eclipse I
- [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=6|S. 6]] Neues Projekt – Eclipse II
- [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=7|S. 7]] Neues Projekt – IntelliJ IDEA I
- [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=8|S. 8]] Neues Projekt – IntelliJ IDEA II
- [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=9|S. 9]] Neues Projekt – IntelliJ IDEA III
- [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=10|S. 10]] Projekt compilieren
- [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=11|S. 11]] Dateien und Dateibaum im Projektverzeichnis
- [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=12|S. 12]] Programm ausführen
- [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=13|S. 13]] Effektives Arbeiten: Tastaturkürzel / Hotkeys
- [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=14|S. 14]] Systemweite Tastenkombinationen
- [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=15|S. 15]] Man kann damit sogar reich werden!
- [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=16|S. 16]] Positionierung des Cursors mit der Tastatur
- [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=17|S. 17]] Selektieren von Text mit der Tastatur
- [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=18|S. 18]] Positionierung des Cursors mit der Maus
- [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=19|S. 19]] Tastenkombinationen in Eclipse
- [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=20|S. 20]] Tastenkombinationen in IntelliJ IDEA
- [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=21|S. 21]] Nützliche Beispiele (Linux + Windows)
- [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=22|S. 22]] Nützliche Beispiele (MacOS)
- [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=23|S. 23]] Code-Templates
- [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=24|S. 24]] Code-Templates - Eclipse
- [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=25|S. 25]] Code-Templates - IntelliJ IDEA
- [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=26|S. 26]] Weitere Hilfen
- [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=27|S. 27]] Programmierunterstützung per KI
- [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=29|S. 29]] Einfaches Beispiel
- [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=30|S. 30]] Zur Wahrheit gehört auch…
- [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=31|S. 31]] „Uffbasse!“
- [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=32|S. 32]] Noch ein drittes Beispiel
- [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=34|S. 34]] Probieren wir es doch mal aus!
- [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=35|S. 35]] Jeder hat eine zweite Chance verdient!
- [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=36|S. 36]] Ok, machen wir‘s einfacher!
- [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=37|S. 37]] Update Januar 2026 – GPT-5
- [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=38|S. 38]] Update Januar 2026 – GPT-5 mini
- [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=39|S. 39]] Update Januar 2026 – Claude Sonnet 4.5
- [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=40|S. 40]] KIT-KI-Toolbox
- [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=42|S. 42]] Oder anders gefragt:
- [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=43|S. 43]] Fazit?!
- [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=44|S. 44]] Programmieren@DHBW und KI

## Begriffe in diesem Kapitel
- [[IDE]] (S. [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=5|5]], [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=6|6]], [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=7|7]], [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=8|8]], [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=9|9]], [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=19|19]])
- [[KI-Programmierhilfe]] (S. [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=27|27]], [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=28|28]], [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=37|37]], [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=38|38]], [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=39|39]], [[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf#page=40|40]])

## Kommt hier auch vor
[[Arrays kopieren]]

## Verwandte Themen
[[01 Die Programmiersprache Java]] · [[03 Java Packages]] · [[12 Dokumentation mit Javadoc]] · [[32 Maven]]

## Folien ansehen
![[Material/Folien/02_IDEs_Eclipse_IntelliJIDEA.pdf]]

## Folientext (durchsuchbar)
> [!quote]- Kompletter Folientext – aufklappen
> ```text
> ── Seite 1 ──
> Programmieren I
> Entwicklungsumgebungen Eclipse und IntelliJ IDEA
> 
> Institut für Automation und angewandte Informatik
> 
> KIT – Die Forschungsuniversität in der Helmholtz-Gemeinschaft www.kit.edu
> 
> ── Seite 2 ──
> Was ist Programmieren
> 
>    Quellcode schreiben
> 
>    Der Maschine verständlich
>    machen („kompilieren“)
> 
>    Mit Standardbibliotheken verknüpfen („linken“) // nicht in Java
> 
>    Erzeugtes Programm ausführen
>    und Fehler beheben („Debuggen“)
> 2 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 3 ──
> Vereinfachung: Ein Tool für alles!
> 
>    Entwicklungsumgebungen bieten typischerweise
>    Werkzeuge zum
>    Quellcode editieren
>    Code übersetzen
>    Linken
>    Ausführen
>    Debuggen
> 
>    Auch meist vorhanden:
>    Syntax-Highlighting
>    „Live“-Anzeige von Syntax-Fehlern
>    Unterstützung in Form verschiedener Code-Generatoren
>    Integration in verschiedene Tools (z.B. Versionskontrollsysteme)
> 
> 3 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 4 ──
> Entwicklungsumgebungen für Java
> 
>    Java Development Kit (JDK)
>    openJDK, bspw. Eclipse Temurin: https://adoptium.net/de/temurin
> 
>    Englisch: Integrated Development Environment → IDE
> 
>    Eclipse (aktuell: Version 2025-12 / 4.38)
>    http://www.eclipse.org/
> 
>    IntelliJ IDEA (aktuell: Version 2025.3.1)
>    https://www.jetbrains.com/idea/
> 
>    Stand: 05. Januar 2026
> 
> 4 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 5 ──
> Neues Projekt (1) – Eclipse I
>    Schritt 1   Schritt 2
> 
>    Schritt 3
> 
>    Später hier: Editor
> 
>    Projects
> 
>    Später hier: Console
> 
> 5 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 6 ──
> Neues Projekt (2) – Eclipse II
>    Schritt 4
>    Schritt 5
> 
>    Schritt 6
> 
>    Editor
>    Projects
> 
>    Später hier: Console
> 
> 6 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 7 ──
> Neues Projekt (3) – IntelliJ IDEA I
>    Schritt 2
> 
>    Schritt 1
> 
>    Create
> 
> 7 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 8 ──
> Neues Projekt (4) – IntelliJ IDEA II
> 
>    Schritt 3: Projekt bereits startklar!
> 
> 8 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 9 ──
> Neues Projekt (5) – IntelliJ IDEA III
> Schritt 4 Schritt 5
> 
>    Schritt 6: Ready to start
>    coding!
> 
> 9 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 10 ──
> Projekt compilieren
> 
>    IDEs übersetzen Java-Dateien beim Speichern in der
>    Regel automatisch und zeigen ggf. Fehler an
> 
> 10 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 11 ──
> Dateien und Dateibaum im Projektverzeichnis
>    src („Source“)
>    → Quellcode / .java-Dateien
> 
>    bin (Eclipse)
>    out (IntelliJ IDEA)
>    → Bytecode / .class-Dateien
> 
> 11 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 12 ──
> Programm ausführen
> 
>    Eclipse   IntelliJ IDEA
> 
>    Weitere Einstellungen:
>    „Run Configurations…“
> 
>    Weitere Einstellungen:
>    „Edit Configurations…“
> 
> 12 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 13 ──
> Effektives Arbeiten: Tastaturkürzel / Hotkeys
> 
>    Viele Aktionen können durch geschickten Einsatz von
>    Tastatur oder Maus vereinfacht werden
>    → Beschleunigung des Arbeitsablaufs
> 
>    Viele Tastatur- und Mausaktionen sind
>    programmübergreifend gleich
> 
>    Viele Werkzeuge halten Standards zu Tastaturbelegungen
>    bereit
> 
> 13 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 14 ──
> Systemweite Tastenkombinationen
> 
>    Strg   + C   Selektierten Text kopieren (in Zwischenablage)
> 
>    Strg   + X   Selektierten Text ausschneiden (in Zwischenablage)
>    Strg   + V   Inhalt der Zwischenablage einfügen
>    Strg   + P   Drucken
>    Strg   + S   Speichern
>    Strg   +   Z   Aktion rückgängig machen („Undo“)
>    Strg   + Y   Aktion erneut ausführen („Redo“)
>    Strg   + A   Gesamten Text selektieren
> 
> 14 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 15 ──
> Man kann damit sogar reich werden!
> 
>    Quelle: RTL Television / „Wer wird Millionär? Für den Verein zur Million“ (11.12.2017)
> 
> 15 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 16 ──
> Positionierung des Cursors mit der Tastatur
> 
>    Frage: Wozu? Dafür gibt es ja die Maus!
> 
>    Antwort: Meist viel schneller, da Texteingabe sowieso mit Tastatur
> 
>    Den Cursor …
>    … um einzelne Zeichen und Zeilen versetzen:   →         
> 
>    … um einzelne Worte versetzen:   Strg   +   → / 
> 
>    … an Anfang/Ende der Zeile versetzen:   Pos1   Ende
> 
>    … an Anfang/Ende der Datei versetzen:   Strg   +   Pos1 / Ende
> 
>    … an zuletzt editierte Position springen:   Strg   +   Q
> 
>    Shift   +   F5
> 
> 16 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 17 ──
> Selektieren von Text mit der Tastatur
> 
>    Frage: Wozu? Dafür gibt es ja die Maus!
> 
>    Antwort: Innerhalb eines Absatzes meist schneller
> 
>    Selektion (von der aktuellen Cursorposition aus) …
>    … einzelner Zeichen:   Shift   +   → / 
> 
>    … einzelner Zeilen:   Shift   +    / 
> 
>    ... einzelner Worte:   Strg   +   Shift   +   → / 
> 
>    … bis Anfang/Ende der Zeile:   Shift   +   Pos1 /   Ende
> 
>    … bis Anfang/Ende der Datei:   Strg   +   Shift   +   Pos1 /   Ende
> 
> 17 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 18 ──
> Positionierung des Cursors mit der Maus
> 
>    Vorteil der Maus: „große Strecken“ zurücklegen
> 
>    Selektion (ohne Rücksicht auf aktuelle Cursorposition) …
> 
>    … einzelner Worte   2x
>    (zwischen 2 Trennzeichen, z.B   Doppelklick
>    Leerzeichen, Punkt oder Klammer)
>    3x
> 
>    … einzelner Zeilen   Dreifach-Klick
>    
>    … Selektion erweitern   gedrückt halten
>    und Maus
>    ziehen
> 
> 18 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 19 ──
> Tastenkombinationen in Eclipse
> 
>    Window
> 
>    Preferences
> 
>    General
> 
>    Editors
> 
>    Keys
> 
> 19 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 20 ──
> Tastenkombinationen in IntelliJ IDEA
> 
>    File
> 
>    Settings
> 
>    Keymap
> 
> 20 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 21 ──
> Nützliche Beispiele (Linux + Windows)
> 
>    Aktion   Eclipse   IntelliJ IDEA
>    Programm ausführen
>    STRG + F11   SHIFT + F10
> 
>    Aktuelle Zeile löschen
>    STRG + D   STRG + Y
> 
>    Aktuelle Zeile kopieren   STRG+ALT +
>    STRG + D
>    /
>    In aktueller Datei
>    suchen   STRG + F   STRG + F
> 
>    Im Projekt suchen   STRG + H   STRG + SHIFT + F
>    Parameter-Info   STRG+SPACE
>    (am Anfang der Argumente)
>    STRG + P
> 
> 21 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 22 ──
> Nützliche Beispiele (MacOS)
> 
>    Aktion   Eclipse   IntelliJ IDEA
>    Programm ausführen
>    Cmd + Shift + F11   Ctrl + Option + R
> 
>    Aktuelle Zeile löschen
>    Cmd + D   Cmd + Backspace
> 
>    Aktuelle Zeile kopieren   Option + Cmd +
>    Cmd + D
>    /
>    In aktueller Datei
>    suchen   Cmd + F   Cmd + F
> 
>    Im Projekt suchen   Cmd + H   Cmd + Shift + F
>    Parameter-Info   Cmd + Space
>    (am Anfang der Argumente)
>    Cmd + P
> 
> 22 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 23 ──
> Code-Templates
> 
>    Code-Templates sind vorgefertigte Schablonen für längere
>    (und häufig genutzte) Quellcode-Fragmente, die aus
>    Abkürzungen erzeugt werden können
> 
>    Gerade zu Beginn häufiges Beispiel: Ausgabe auf Konsole
> 
>    Statt System.out.println(""); nur sysout bzw. sout tippen
> 
>    Abkürzungen und Anwendung können sich je nach IDE
>    unterscheiden
> 
> 23 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 24 ──
> Code-Templates - Eclipse
> 
>    Anwendung:   Strg   +   Space
> 
>    Window
> 
>    Preferences
> 
>    Java
> 
>    Editor
> 
>    Templates
> 
> 24 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 25 ──
> Code-Templates - IntelliJ IDEA
> 
>    Anwendung: meist einfach Tippen
> 
>    File
> 
>    Settings
> 
>    Editor
> 
>    General
> 
>    Postfix
>    Completion
> 
> 25 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 26 ──
> Weitere Hilfen
> 
>    Wichtig:
>    Werkzeug zum täglichen Arbeiten sollte man gut kennen!
> 
>    Lästige „Standard-Arbeiten“ können einem moderne
>    Entwicklungsumgebungen oft abnehmen
> 
>    Üben, Üben, Üben …
> 
>    ➔ Resultat:
>    große Zeitersparnis und effektiveres Programmieren
> 
>    selbst ausprobieren
> 
> 26 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 27 ──
> Programmierunterstützung per KI (1)
> 
>    Seit einigen Jahren können KI-basierte Tools beim
>    Programmieren unterstützen, bieten z.B. eine erweiterte
>    Code-Completion bis hin zur Erzeugung von ganzen
>    Klassen(-strukturen), Methoden, etc.
> 
>    Beispiele:
>    GitHub Copilot / Microsoft 365 Copilot
>    Claude.ai
>    Google Gemini
>    Tabnine
>    Figstack
>    SourceGraph
>    Mutable.ai
>    …
> 27 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 28 ──
> Programmierunterstützung per KI (2)
> 
>    Die Verfügbarkeit dieser Tools hat Auswirkungen auf das
>    Berufsbild von Programmierern/Software-Ingenieuren:
> 
>    Entlastung von Routineaufgaben
>    Automatisierung von Standard-Prozessen
>    Kompetenz, erzeugten Code auf Eignung und Qualität hin zu
>    überprüfen und ggf. anzupassen
> 
>    Echt?!
>    Quelle: https://youtu.be/8PpEgeAbua0
> 
> 28 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 29 ──
> Einfaches Beispiel
> 
>    Problem 1: Gefragt wurde nach
>    einer Methode, generiert wurde eine
>    komplette Klasse mit der Methode
>    drin und einem Beispiel
> 
>    Problem 2: So darf die Klasse in der
>    Datei „Text.java“ nicht heißen
> 
>    Genutzte KI: GitHub Copilot Business, Dez. 2024
> 29 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 30 ──
> Zur Wahrheit gehört auch…
> 
>    Versuch 2 mit Dateinamen der
>    beabsichtigt war (Test statt Text)
>    funktioniert ohne Änderung
>    tadellos.
> 
>    (Ist aber nach wie vor nicht genau
>    das, wonach gefragt wurde!)
> 
>    Genutzte KI: GitHub Copilot Business, Dez. 2024
> 30 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 31 ──
> „Uffbasse!“
> 
>    Das ist ein sehr trivialer Fall, zeigt aber:
>    Ahnungslose…
>    … haben keine Ahnung, warum Beispiel 1 vom Compiler nicht
>    akzeptiert wird, Beispiel 2 aber schon
>    … merken nicht, dass sie nicht genau das bekommen haben,
>    wonach gefragt wurde
>    … würden ggf. Programme voller nutzloser Beispiele produzieren
> 
>    Was ist dann erst mit
>    inhaltlichen Fehlern, die nicht
>    trivial zu erkennen sind?
> 
>    Echt?!
>    Quelle: https://youtu.be/8PpEgeAbua0
> 
> 31 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 32 ──
> Noch ein drittes Beispiel
> 
>    Kompliziert zu lesen für Menschen, aber für Maschinen
>    sehr trivial:
> 
>    int c = 1 +-+-+-+-+ 1
> 
>    kannst du mir sagen, was dies bedeutet?
> 
>    An diesem Beispiel wollen wir uns auch die „Evolution“ der
>    KI-Modelle anschauen
>    → daher zunächst die Antworten von vor einem Jahr!
> 
> 32 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 33 ──
> Noch ein drittes Beispiel
> 
>    Genutzte KI: gpt-4o via GitHub Copilot Business, Dez. 2024
> 
> 33 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 34 ──
> Probieren wir es doch mal aus!
> 
>    Sch
> 
>    Schade!
>    Genutzte KI: gpt-4o via GitHub Copilot Business, Dez. 2024
> 
> 34 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 35 ──
> Jeder hat eine zweite Chance verdient!
> 
>    Jammerschade!
> 
>    Genutzte KI: gpt-4o via GitHub Copilot Business, Dez. 2024
> 
> 35 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 36 ──
> Ok, machen wir‘s einfacher!
> 
>    Wird nicht
>    besser…
>    Genutzte KI: gpt-4o via GitHub Copilot Business, Dez. 2024
> 
> 36 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 37 ──
> Update Januar 2026 – GPT-5
> 
>    Ein + zu viel…
> 
>    1, 2, 3, 4?
> 
>    *
> 
>    * Ergebnis: Top
>    Erklärung: Ausbaufähig…
> 
>    Genutzte KI: GPT-5 via GitHub Copilot Business, Jan. 2026
> 
> 37 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 38 ──
> Update Januar 2026 – GPT-5 mini
> 
> Inzwischen können bei
> GitHub Copilot verschiedene
> Modelle ausgewählt werden
> 
> → Nutzen wir dies!
> 
>    Genutzte KI: GPT-5 mini via GitHub Copilot Business, Jan. 2026
> 
> 38 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 39 ──
> Update Januar 2026 – Claude Sonnet 4.5
> 
>    1 Ebene zu wenig…
> 
>    „Blindes Vertrauen“ ist also weiterhin
>    fehl am Platz!
> 
>    Auch wenn als Coding-Assistent Claude
>    aktuell unserer Meinung nach besser
>    performt als GPT5!   Genutzte KI: Claude Sonnet 4.5 via GitHub Copilot Business, Jan. 2026
> 
> 39 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 40 ──
> KIT-KI-Toolbox (1)
> 
>    Wir wollen noch ein paar mehr Modelle mitmischen lassen!
> 
>    Fun Fact zu „Standard-Local“:
> 
>    KIT-KI-Toolbox, Modelle siehe Spalte, Januar 2026
> 
> 40 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 41 ──
> KIT-KI-Toolbox (2)
> 
>    Noch mehr!
> 
>    KIT-KI-Toolbox, Modelle siehe Spalte, Januar 2026
> 
> 41 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 42 ──
> Oder anders gefragt:
> 
>    Würdet Ihr Euch in ein
>    Flugzeug setzen, dessen
>    Steuerungssoftware durch
>    eine KI erzeugt wurde?
> 
>    Bild: CC BY-SA 3.0 / https://commons.wikimedia.org/wiki/File:1976_Zagreb_mid-air_collision_computer_graphics.png
> 
>    https://arxiv.org/pdf/2108.09293
> 
> 42 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 43 ──
> Fazit?!
> 
>    Ein qualifizierter Blick sowie ein tiefes Verständnis der
>    Programmiersprache und der zugehörigen APIs
>    sind – Stand heute – nach wie vor notwendig!
> 
>    ➔ Das (und mehr ☺) sollt Ihr hier lernen!
> 
>    Zu Risiken und Nebenwirkungen von KI-Tools lesen Sie die
>    Nutzungsbedingungen und Fragen auch eine Person
>    (am besten sich selbst!), die sich damit auskennt!
> 
> 43 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 44 ──
> Programmieren@DHBW und KI
> 
>    Und hier in der Vorlesung/Übung?!
>    Wir verbieten erstmal nichts!
>    Ja, KI-Assistenten können einen Großteil der unserer Aufgaben
>    (perfekt) lösen.
>    Aber:
>    Es geht um Euer Lernen, Euer Können, Eure Kompetenz!
>    Übungen sind sicher wirksamer, wenn Ihr Aufgaben selbst löst!
>    In der Prüfung sind alle „online“-Dienste tabu!
> 
>    Empfehlung:
> 
>    In diesem Kurs sitzen Eure „Copilots“ neben Euch!
> 
>    (Die können viel mehr als nur beim Programmieren assistieren!)
> 
> 44 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> ```
