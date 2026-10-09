---
tags: ["typ/thema", "thema/programmentwurf", "kategorie/pruefung", "semester/2"]
aliases: ["Zum Programmentwurf", "Folien 35"]
semester: 2
kategorie: "Prüfung"
folien: "[[Material/Folien/35_ZumProgrammentwurfUpdate2026.pdf]]"
seiten: 15
---

# 35 Zum Programmentwurf

← [[33 Java 8 – Lambdas, Streams, NIO.2]] · [[Start|🏠 Start]] · [[42 Vorbereitung Programmentwurf (Oktoberübung)]] →

> [!abstract] Worum geht's?
> Informationen zur Prüfung: Termin, relevante Inhalte, erstmals zweiteilig (Theorie + Praxis), Beispielfragen für den Theorieteil und was im praktischen Teil erlaubt ist.

**Semester:** Programmieren II · **Bereich:** #kategorie/pruefung · **Folien:** [[Material/Folien/35_ZumProgrammentwurfUpdate2026.pdf|35_ZumProgrammentwurfUpdate2026.pdf]] (15 Seiten)

## Gliederung der Folien
- [[Material/Folien/35_ZumProgrammentwurfUpdate2026.pdf#page=2|S. 2]] Termin
- [[Material/Folien/35_ZumProgrammentwurfUpdate2026.pdf#page=3|S. 3]] Relevante Inhalte
- [[Material/Folien/35_ZumProgrammentwurfUpdate2026.pdf#page=4|S. 4]] Erstmalig: Zweiteilige Prüfung!
- [[Material/Folien/35_ZumProgrammentwurfUpdate2026.pdf#page=5|S. 5]] Und was erwartet mich in der Theorie?
- [[Material/Folien/35_ZumProgrammentwurfUpdate2026.pdf#page=7|S. 7]] Beispiel 1: Schnittstellen Methoden 1
- [[Material/Folien/35_ZumProgrammentwurfUpdate2026.pdf#page=8|S. 8]] Beispiel 2: Schnittstellen Methoden 2
- [[Material/Folien/35_ZumProgrammentwurfUpdate2026.pdf#page=9|S. 9]] Beispiel 3: Welche Konstanten gibt es?
- [[Material/Folien/35_ZumProgrammentwurfUpdate2026.pdf#page=10|S. 10]] Beispiel 4: Folien auswendig lernen?!?
- [[Material/Folien/35_ZumProgrammentwurfUpdate2026.pdf#page=11|S. 11]] Beispiel 5: Themen
- [[Material/Folien/35_ZumProgrammentwurfUpdate2026.pdf#page=12|S. 12]] Beispiel 6: Ja, nein, vielleicht?
- [[Material/Folien/35_ZumProgrammentwurfUpdate2026.pdf#page=13|S. 13]] Und was erwartet mich im praktischen Teil?
- [[Material/Folien/35_ZumProgrammentwurfUpdate2026.pdf#page=14|S. 14]] Was ist alles erlaubt?
- [[Material/Folien/35_ZumProgrammentwurfUpdate2026.pdf#page=15|S. 15]] Übung

## Begriffe in diesem Kapitel
- [[Programmentwurf]] (S. [[Material/Folien/35_ZumProgrammentwurfUpdate2026.pdf#page=4|4]], [[Material/Folien/35_ZumProgrammentwurfUpdate2026.pdf#page=5|5]], [[Material/Folien/35_ZumProgrammentwurfUpdate2026.pdf#page=12|12]], [[Material/Folien/35_ZumProgrammentwurfUpdate2026.pdf#page=14|14]], [[Material/Folien/35_ZumProgrammentwurfUpdate2026.pdf#page=15|15]])

## Relevant für diese Programmentwürfe
[[PE CHORona]] · [[PE ChatterGPT Validator]] · [[PE CoronaWarn]] · [[PE DBVasion]] · [[PE FakeTalk]] · [[PE SnatChat (Übungs-PE Oktober 2026)]] · [[PE SpeedyQuiz]] · [[PE jBay]]

## Verwandte Themen
[[42 Vorbereitung Programmentwurf (Oktoberübung)]] · [[00 Überblick Programmieren I]] · [[00 Überblick Programmieren II]] · [[26 Aufzählungstypen (Enums)]]

## Folien ansehen
![[Material/Folien/35_ZumProgrammentwurfUpdate2026.pdf]]

## Folientext (durchsuchbar)
> [!quote]- Kompletter Folientext – aufklappen
> ```text
> ── Seite 1 ──
> Programmieren II
> Zum Programmentwurf
> 
> Institut für Automation und angewandte Informatik
> 
> KIT – Die Forschungsuniversität in der Helmholtz-Gemeinschaft www.kit.edu
> 
> ── Seite 2 ──
> Termin
> 
>    Wahrscheinlich
> 
>    Donnerstag, 15. Oktober 2026 oder
>    Freitag, 16. Oktober 2026
> 
>    im jeweiligen Kursraum des dritten Theoriesemesters
> 
>    ➔ Rechtzeitige Info vorab!
> 
> 2 A. Koubaa, J. Sidler, W. Süß, T. Schlachter, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 3 ──
> Relevante Inhalte
> 
>    Stoff 1. Semester   ✓
>    Primitive Datentypen, Kontrollstrukturen, Arrays
>    Klassen, Vererbung, Strings, Wrapperklassen, Pakete
>    Exceptions, I/O
>    Interfaces, innere und anonyme Klassen   ✓
>    GUI mit Swing inkl. Eventbehandlung, Zeichnen   ✓
>    Datenstrukturen (Collection-API), enum   ✓
>    Threads   ✓
>    Java 8-Features   (erlaubt, aber nicht gefordert)   ✓
>    Maven   
>    XML   
>    JUnit, GSON   
> 3 A. Koubaa, J. Sidler, W. Süß, T. Schlachter, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 4 ──
> Erstmalig: Zweiteilige Prüfung!
> 
>    Am selben Termin, direkt hintereinander
>    Teil 1: „Theorie“ (auf Papier, Verständnis- & Wissensfragen)
> 
>    Teil 2: „Praxis“ (am Laptop, Programmieraufgabe)
> 
>    Gesamtdauer: 120 Minuten netto
>    Reine Bearbeitungszeit, ohne Erläuterungen o. Ä.
> 
>    Wahrscheinlich:
>    Teil 1: 30 Minuten
>    Teil 2: 90 Minuten
> 
> 4 A. Koubaa, J. Sidler, W. Süß, T. Schlachter, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 5 ──
> Und was erwartet mich in der Theorie?
> 
>    Prinzipiell alles, was wir durchgenommen haben! ☺
>    Liste relevanter Themen zählt natürlich auch für Theorie
> 
>    Für den theoretischen Teil der Prüfung sind keine
>    Hilfsmittel erlaubt (in der Praxis dann schon)
> 
>    Fokus liegt auf Verständnisfragen, kann aber auch
>    Wissensfragen beinhalten
> 
> 5 A. Koubaa, J. Sidler, W. Süß, T. Schlachter, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 6 ──
> Und was erwartet mich in der Theorie?
> 
>    Keine langen Prosa-Texte als Antwort, eher
>    Multiple Choice
>    Lückentexte
>    Kurze Freitext-Antworten
>    Code-Snippets mit zu findenden Fehlern
>    Disclaimer: die Liste erhebt keinen finalen Anspruch auf Vollständigkeit!
> 
>    Es folgen ein paar Beispiele, nach denen wir nicht fragen
>    werden (und warum).
> 
> 6 A. Koubaa, J. Sidler, W. Süß, T. Schlachter, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 7 ──
> Beispiel 1: Schnittstellen Methoden 1
> 
>    Welche Methoden gehören zum Interface
>    java.awt.event.MouseListener?
>    [ ] A: mouseClicked(MouseEvent e)
>    [ ] B: mousePressed(MouseEvent e)
>    [ ] C: mouseDragged(MouseEvent e)
>    [ ] D: mouseReleased(MouseEvent e)
>    [ ] E: mouseMoved(MouseEvent e)
>    [ ] F: keine der anderen Möglichkeiten
> 
>    → uns kommt es nicht auf einzelne Methoden einer Schnittstelle an
>    → Frage wäre wenn inhaltlicher Natur: Was ist der Unterschied
>    zwischen MouseListener und MouseMotionListener
> 
> (Korrekt: A, B und D, Antworten C und E sind MouseMotionListener)
> 
> 7 A. Koubaa, J. Sidler, W. Süß, T. Schlachter, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 8 ──
> Beispiel 2: Schnittstellen Methoden 2
> 
>    Wo liegt der Fehler in diesem Code?
> 
>    → in Comparator heißt die Methode compare
>    in Comparable ist es compareTo
>    → Der Unterschied ist marginal und inhaltlich in der falschen
> 
>    Form zu plausibel.
>    Das ist Kategorie „Falle“ nicht „Fehler den man sehen sollte“
>    → Vorstellbar als „Fehlersuche“: das zweite Argument der Methode
>    weglassen und im Rumpf mit this arbeiten wie bei Comparable
> 
> 8 A. Koubaa, J. Sidler, W. Süß, T. Schlachter, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 9 ──
> Beispiel 3: Welche Konstanten gibt es?
> 
>    Welche der folgenden Werte können an
>    setDefaultCloseOperation(…) von javax.swing.JFrame
>    übergeben werden?
>    [ ] A: WindowConstants.DO_NOTHING_ON_CLOSE
>    [ ] B: WindowConstants.DANCE_CLOSE
>    [ ] C: WindowConstants.EXIT_ON_CLOSE
>    [ ] D: WindowConstants.TERMINATE_ON_CLOSE
>    [ ] E: WindowConstants.DISPOSE_ON_CLOSE
>    [ ] F: 999
>    [ ] G: keine der anderen Möglichkeiten
> 
>    → F ist schlicht eine miese Falle (da alle int-Werte möglich sind)
>    → Alle Konstanten, die es dafür gibt müssen Sie nicht im Kopf haben
> 
>    → Zweck gängiger Konstanten erklären wäre aber denkbar
> 
> (Korrekt: A, C, E und F, Antworten B und D sind frei erfunden)
> 
> 9 A. Koubaa, J. Sidler, W. Süß, T. Schlachter, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 10 ──
> Beispiel 4: Folien auswendig lernen?!?
> 
>    Welche Attribute (mit Typ) hatte die Klasse Person aus
>    den Folien zu Vererbung?
> 
>    _____________________________________________
> 
>    → Es müssen keine Folien auswendig gelernt sondern
>    „lediglich“ verstanden werden ☺
>    → Fragen werden immer den kompletten Kontext haben
> 
> (Korrekt: userId (int), name, phoneNo (beide Strings))
> 
> 10 A. Koubaa, J. Sidler, W. Süß, T. Schlachter, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 11 ──
> Beispiel 5: Themen
> 
>    Welche der folgenden Schreibweisen ist valide und
>    äquivalent zu
> 
>    ?
> 
>    [ ] A:
>    [ ] B:
>    [ ] C:
>    [ ] D: keine der anderen Möglichkeiten
> 
>    → Im Prinzip eine wunderbare Frage!
>    → Aber aus einem Thema, was wir als „gerne Nutzen“, aber „nicht
>    verpflichtend“ kommuniziert haben
> (Korrekt: A, B, C)
> 
> 11 A. Koubaa, J. Sidler, W. Süß, T. Schlachter, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 12 ──
> Beispiel 6: Ja, nein, vielleicht?
> 
>    Wo liegt der Fehler in diesem Code:   ?
> 
>    [ ] A: ______________________________________
>    [ ] B: Es gibt keinen Fehler
> 
>    → Hier kommt es auf die Java-Version an
>    → Fragen werden so eindeutig wie möglich sein und nicht bewusst
> 
>    solche Uneindeutigkeiten beinhalten
>    →   Als Frage in der Vorlesung mal ganz nett, aber nicht in einer Prüfung
>    →   Falls Sie doch zweifeln: immer von Java 8 oder neuer ausgehen
> 
> (Korrekt: JDK bis 1.4 → B, JDK ab 1.5 → A: enum ist Schlüsselwort und damit kein gültiger Bezeichner)
> 
> 12 A. Koubaa, J. Sidler, W. Süß, T. Schlachter, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 13 ──
> Und was erwartet mich im praktischen Teil?
> 
>    Wie bisher: Programmieraufgabe am Rechner
> 
>    Minimal erwartete Java-Version: 1.8 SE
>    Es werden auch Lösungen auf Basis neuerer Java-Versionen
>    akzeptiert
> 
>    Abgabe: Java-Quellcode auf USB-Stick
> 
>    Verwendete Bibliotheken, die nicht zum Java SE-Standard
>    gehören, müssen der Lösung beigelegt werden.
> 
> 13 A. Koubaa, J. Sidler, W. Süß, T. Schlachter, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 14 ──
> Was ist alles erlaubt?
> 
>    Die Idee der Prüfung: SIE sollen programmieren
> 
>    Funktionsfähigkeit des Laptops
>    Erlaubte Hilfsmittel   ist Ihre Verantwortung!
> 
>    „Stand-Alone“ Laptop mit IDE
>    Vorlesungsfolien + Übungsaufgaben (inkl. Ihrer & Musterlösungen)
>    JavaDoc auf Laptop (Offline!)
>    Bücher zur Java-Programmierung
> 
>    Nicht erlaubte Hilfsmittel
>    Internet / WLAN und sonstige Verbindungen mit anderen Geräten
>    Lokale LLMs
>    Abschreiben / Teamarbeit
>    ➔ wer erwischt wird: Ausschluss von der Prüfung + durchgefallen
> 
> 14 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 15 ──
> Übung
> 
>    ??, 0?. Oktober 2026
>    ??:?? Uhr
>    Audimax
>    Gute Gelegenheit Wissen kurz vor der Prüfung
>    aufzufrischen und Fragen zu stellen
>    Gemeinsames Erarbeiten („live“) einer Lösung einer
>    vergleichbaren Aufgabe
> 
> 15 A. Koubaa, J. Sidler, W. Süß, T. Schlachter, C. Schmitt Institut für Automation und angewandte Informatik
> ```
