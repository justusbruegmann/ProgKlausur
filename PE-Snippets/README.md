# PE-Snippets – Vorlagen für den Programmentwurf

Kopiervorlagen für Teil II (Praxis) des Programmentwurfs Programmieren I+II.
Jede Datei behandelt ein Thema. Sie ist kommentiert, lauffähig (eigene `main`-Methode) und
**Java-8-kompatibel**, getestet mit `javac --release 8`.

> Laut den Folien der Vorbereitungsveranstaltung (*42_ZumPE_Oktoberuebung*, S. 9) ist
> „vorbereiteter Code für 1:1 Copy&Paste + selbst anpassen“ erlaubt. In Teil I (Theorie, Papier)
> sind keine Hilfsmittel erlaubt.

## Benutzung

- **Nachschlagen:** Den Ordner `PE-Snippets` einfach neben `src` ins Projekt legen. Er wird nicht
  mitkompiliert, du öffnest die Dateien nur zum Kopieren.
- **Ausprobieren:** Den Unterordner `snippets` in `src` kopieren. Dann lässt sich jede Datei per
  *Run As → Java Application* starten (Package `snippets`). Vor der Abgabe wieder löschen.
- **Beim Kopieren:** `package`-Zeile anpassen. Bei Klassen/Enums/Interfaces aus einer Datei mit
  mehreren Typen: in eine eigene Datei `<Name>.java` legen und `public` davorschreiben.
- Die Kommentare enthalten Umlaute (UTF-8). Falls sie kaputt aussehen: Eclipse → *Window →
  Preferences → General → Workspace → Text file encoding: UTF-8*.

## Übersicht

| Datei | Inhalt | Typische Aufgabe / Vorkommen |
|---|---|---|
| `S00_ProjektCheck` + `module-info.java.vorlage` | Läuft Swing? Welche Java-Version? Wo ist das Arbeitsverzeichnis? | **Vor der Prüfung ausführen!** Bei Fehler `requires java.desktop;` |
| `S01_KomplexerEnum` | Enum mit Label/Farbe/Zahl, Konstruktor, Getter, `toString`, `next()`, `fromLabel()`, `switch`, `EnumMap`, Label einfärben | 7 von 8 Probe-PEs: State, Variant, WarnStatus, StopStatus, QuoteType … |
| `S02_InterfaceUndVererbung` | Interface (+ default-Methode), Implementierung, anonyme Implementierung, abstrakte Klasse, `super`, `instanceof` | SnatChatFrontend, GameClient, IRoom, CoronaWarnClient … |
| `S03_Datenklasse` | Attribute, Konstruktor-Chaining, statischer ID-Zähler, Getter/Setter, `toString`, `equals`/`hashCode`, `Comparable`, Vererbung | in jedem PE (Account, Message, Question, Bieter, Token, Quote …) |
| `S04_EigeneException` | checked/unchecked Exception, Plausibilitätsprüfung, `parse` mit Fehlerumwandlung, Multi-Catch, `hh:mm` | DBException, AHAException, GameException |
| `S05_DateiLesenSchreiben` | Zeilenweise lesen (**UTF-8!**), `split(";")`, fehlerhafte Zeilen überspringen, schreiben, Log anhängen | alle 8 PEs: connections.txt, questions.txt, corona.csv … |
| `S06_SwingGrundgeruest` | JFrame-Unterklasse: BorderLayout + GridLayout + Buttonleiste, Panel neu aufbauen, mehrere Fenster | jedes PE (…Window, …Term, …Terminal) |
| `S07_SwingKomponenten` | farbiges Label (`setOpaque`!), Tooltip, HTML-Umbruch, Icon-Button, Zahl aus Textfeld, **JComboBox**, JList, Check-/Radiobuttons, alle **JOptionPane**-Varianten | Hinweise in CoronaWarn/SpeedyQuiz/DBVasion, ComboBox-Folien der Vorbereitung |
| `S08_Events` | Listener als Lambda / anonyme Klasse / `this` + `getSource()`, Button-Raster mit Index, Enter/Tasten, Maus + Popupmenü, Schließen abfangen | jedes PE ab Teilaufgabe c)/d) |
| `S09_TimerCountdown` | `javax.swing.Timer`-Countdown, einmaliger Timer („Selbstzerstörung“), eigener Thread mit `sleep` + `invokeLater` | SpeedyQuiz, SnatChat, ChatterGPT, CHORona |
| `S10_ZentraleMehrereFenster` | Zentrale mit `List<Teilnehmer>` verteilt an alle Fenster, An-/Abmelden | SnatChatRoom, Game + GameTerms, Auktionshaus + BieterTerminals |
| `S11_EigeneZeichenkomponente` | `paintComponent`, Raster mit Farbverlauf, Text zentrieren, Mausklick → Zelle, Simulation in Zeitschritten | CHORona, StopComponent (DBVasion), Ü24 |
| `S12_Collections` | List/Map/Set/Queue, sortieren (`Comparator.comparing`, anonym), Top-N, Löschen beim Iterieren, Zählen/Gruppieren, Streams | überall |
| `S13_ZufallUndZeit` | Zufall im Bereich, Wahrscheinlichkeit, zufälliges Element/Enum, **nicht zu helle Zufallsfarbe**, UUID, Unix-Zeit, `Date`, `Calendar`, `java.time`, `%02d:%02d` | SnatChat, CoronaWarn, jBay, DBVasion |
| `S14_BilderUndIcons` | ImageIcon laden (Fehler erkennen!), skalieren, aus Classpath, selbst zeichnen, Text unter Bild | FakeTalk, ChatterGPT, DBVasion |
| `S15_StringHelfer` | `String.format` (+ Locale-Falle), `split`-Fallen, `equals` vs. `==`, StringBuilder, sicher parsen | toString-Methoden, Eingaben, Dateien |

## Vorgehen in der Prüfung (90 Minuten)

1. **Aufgabe einmal komplett lesen.** Vorgegebene Klassen anschauen: Sie zeigen, wie deine Klassen
   aufgerufen werden (Konstruktor-Reihenfolge, Methodennamen).
2. **Schnelle Punkte zuerst:** Interface (S02), Enum (S01), Datenklassen (S03), Exception (S04).
3. **Signaturen exakt** wie in der Aufgabe: Namen, Parameter-Reihenfolge, Rückgabetyp, Attributnamen in Klammern.
4. **Das Programm muss immer starten.** In den Probe-PEs gab es 25 % der Punkte über Funktionstests. Lieber eine
   Teilaufgabe weglassen, als Compile-Fehler abzugeben.
5. Dateien aus der Aufgabe in den **Projektordner** legen (nicht in `src`) und mit UTF-8 lesen (S05).
6. Abgabe: **Quellcode auf USB-Stick**. Rechtzeitig vor Schluss kopieren!

## Typische Fehler (die dich Zeit kosten)

- Label ohne `setOpaque(true)` → Hintergrundfarbe unsichtbar
- `setVisible(true)` vor `add(...)`/`pack()` → leeres Fenster
- Strings mit `==` vergleichen statt `equals`
- `Thread.sleep` im ActionListener → GUI friert ein (stattdessen `javax.swing.Timer`, S09)
- `new ImageIcon("x.png")` meldet keinen Fehler, wenn die Datei fehlt (Breite = −1, S14)
- `String.format("%.2f")` schreibt auf deutschem Windows ein Komma → beim Wiedereinlesen `NumberFormatException`
- `list.remove(...)` in einer for-each-Schleife → `ConcurrentModificationException` (Iterator/`removeIf`, S12)
- Enum: Semikolon nach der letzten Konstante vergessen; im `switch` `case AWAY:` statt `case Status.AWAY:`
- Mehrere Fenster mit `EXIT_ON_CLOSE` → ein Fenster schließen beendet alles (sonst `DISPOSE_ON_CLOSE`)

## Vor Montag erledigen

- [ ] `S00_ProjektCheck` im Prüfungsprojekt laufen lassen (ohne Internet!)
- [ ] Java-API-Doku offline verfügbar (siehe Folien 12_Dokumentation, Anhang)
- [ ] Folien + Übungen + Musterlösungen offline auf dem Laptop (Obsidian-Vault `JavaVL_Vault`)
- [ ] Test: Kann der Laptop fremde USB-Sticks lesen/beschreiben?
- [ ] Netzteil, Studierendenausweis, Stifte
