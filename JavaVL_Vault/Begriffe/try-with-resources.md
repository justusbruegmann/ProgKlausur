---
tags: ["typ/begriff", "thema/exceptions", "thema/io", "kategorie/fehlerbehandlung"]
aliases: ["AutoCloseable", "Ressourcen schließen", "try ( )"]
---

# try-with-resources

> [!info] Kurz erklärt
> Seit Java 7: `try (BufferedReader br = …) { … }` schließt die Ressource am Ende automatisch, auch bei Exceptions. Funktioniert mit allem, was `AutoCloseable` implementiert. Ebenfalls seit Java 7: Multi-Catch `catch (A | B e)`.

## Erklärt in
- [[14 Exceptions]] · Folien S. [[Material/Folien/14_Exceptions.pdf#page=17|17]]
- [[15 Input und Output]] · Folien S. [[Material/Folien/15_InputOutput.pdf#page=2|2]], [[Material/Folien/15_InputOutput.pdf#page=21|21]], [[Material/Folien/15_InputOutput.pdf#page=22|22]], [[Material/Folien/15_InputOutput.pdf#page=32|32]], [[Material/Folien/15_InputOutput.pdf#page=33|33]], [[Material/Folien/15_InputOutput.pdf#page=35|35]], [[Material/Folien/15_InputOutput.pdf#page=36|36]], [[Material/Folien/15_InputOutput.pdf#page=37|37]]

## Kommt auch vor in
- [[25 Datenstrukturen und Generics]] · S. [[Material/Folien/25_Datenstrukturen.pdf#page=6|6]], [[Material/Folien/25_Datenstrukturen.pdf#page=35|35]], [[Material/Folien/25_Datenstrukturen.pdf#page=36|36]], [[Material/Folien/25_Datenstrukturen.pdf#page=38|38]], [[Material/Folien/25_Datenstrukturen.pdf#page=39|39]]
- [[33 Java 8 – Lambdas, Streams, NIO.2]] · S. [[Material/Folien/33_Java8.pdf#page=52|52]], [[Material/Folien/33_Java8.pdf#page=53|53]], [[Material/Folien/33_Java8.pdf#page=56|56]]

## Verwandte Begriffe
[[Exception]] · [[Datenströme]] · [[BufferedReader und BufferedWriter]]

## Übungen, in denen das gebraucht wird (13)
- [[Ü15 Quersummen speichern]]
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
- [[Ü33 Zahlenraten (3)]]

## In diesen Programmentwürfen gefragt
[[PE SpeedyQuiz]] · [[PE ChatterGPT Validator]] · [[PE SnatChat (Übungs-PE Oktober 2026)]]
