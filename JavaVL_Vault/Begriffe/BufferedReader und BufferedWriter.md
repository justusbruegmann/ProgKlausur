---
tags: ["typ/begriff", "thema/io", "thema/java8", "kategorie/io"]
aliases: ["BufferedReader", "BufferedWriter", "readLine", "newLine"]
---

# BufferedReader und BufferedWriter

> [!info] Kurz erklärt
> Gepufferte Zeichenströme: `BufferedReader.readLine()` liest zeilenweise (liefert `null` am Ende), `BufferedWriter.write(...)` + `newLine()` schreibt. Erzeugt z. B. über `new BufferedReader(new FileReader(datei))` oder `Files.newBufferedReader(path)`.

## Erklärt in
- [[15 Input und Output]] · Folien S. [[Material/Folien/15_InputOutput.pdf#page=20|20]], [[Material/Folien/15_InputOutput.pdf#page=26|26]], [[Material/Folien/15_InputOutput.pdf#page=29|29]], [[Material/Folien/15_InputOutput.pdf#page=30|30]], [[Material/Folien/15_InputOutput.pdf#page=35|35]], [[Material/Folien/15_InputOutput.pdf#page=36|36]], [[Material/Folien/15_InputOutput.pdf#page=37|37]], [[Material/Folien/15_InputOutput.pdf#page=38|38]]
- [[33 Java 8 – Lambdas, Streams, NIO.2]] · Folien S. [[Material/Folien/33_Java8.pdf#page=52|52]], [[Material/Folien/33_Java8.pdf#page=53|53]], [[Material/Folien/33_Java8.pdf#page=56|56]]

## Verwandte Begriffe
[[Reader und Writer]] · [[try-with-resources]] · [[Datei und Pfad]] · [[PrintWriter]]

## Übungen, in denen das gebraucht wird (12)
- [[Ü15 Palindrome speichern]]
- [[Ü15 Teil einer Datei]]
- [[Ü15 Zugriff auf eine Textdatei]]
- [[Ü15 Primzahlen speichern und lesen]]
- [[Ü20 Frame mit Text]]
- [[Ü20 Datei auswählen und zeilenweise darstellen]]
- [[Ü23 Zahlenraten (2)]]
- [[Ü23 Editor]]
- [[Ü23 Hütchenspiel]]
- [[Ü25 Bücherei]]
- [[Ü26 Sortierkriterien]]
- [[Ü27 Suchmaschine]]

## In diesen Programmentwürfen gefragt
[[PE SpeedyQuiz]] · [[PE CHORona]] · [[PE DBVasion]] · [[PE FakeTalk]] · [[PE SnatChat (Übungs-PE Oktober 2026)]]
