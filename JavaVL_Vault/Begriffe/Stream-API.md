---
tags: ["typ/begriff", "thema/java8", "kategorie/funktional"]
aliases: ["Stream", "Streams", "filter", "map", "collect", "forEach", "reduce", "Collectors", "IntStream", "Streaming-API", "Zwischenfunktion", "Terminalfunktion"]
---

# Stream-API

> [!info] Kurz erklärt
> Deklarative Verarbeitung von Datenfolgen: `liste.stream().filter(p -> p.alter > 18).map(Person::getName).sorted().collect(Collectors.toList())`. **Zwischenfunktionen** (filter, map, sorted, distinct, skip, flatMap, peek) sind lazy; erst eine **Terminalfunktion** (forEach, collect, reduce, count, sum) startet die Verarbeitung. Auch parallel möglich.

## Erklärt in
- [[33 Java 8 – Lambdas, Streams, NIO.2]] · Folien S. [[Material/Folien/33_Java8.pdf#page=21|21]], [[Material/Folien/33_Java8.pdf#page=23|23]], [[Material/Folien/33_Java8.pdf#page=24|24]], [[Material/Folien/33_Java8.pdf#page=25|25]], [[Material/Folien/33_Java8.pdf#page=26|26]], [[Material/Folien/33_Java8.pdf#page=27|27]], [[Material/Folien/33_Java8.pdf#page=28|28]], [[Material/Folien/33_Java8.pdf#page=44|44]]

## Kommt auch vor in
- [[15 Input und Output]] · S. [[Material/Folien/15_InputOutput.pdf#page=12|12]], [[Material/Folien/15_InputOutput.pdf#page=13|13]], [[Material/Folien/15_InputOutput.pdf#page=14|14]], [[Material/Folien/15_InputOutput.pdf#page=15|15]], [[Material/Folien/15_InputOutput.pdf#page=16|16]]

## Verwandte Begriffe
[[Lambda-Ausdruck]] · [[Methodenreferenz]] · [[Collection API]] · [[Funktionales Interface]] · [[Datei und Pfad]]

## Übungen, in denen das gebraucht wird (2)
- [[Ü33 Arbeiten mit Streams]]
- [[Ü33 Zahlenraten (3)]]
