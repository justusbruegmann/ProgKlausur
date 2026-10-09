---
tags: ["typ/begriff", "thema/datenstrukturen", "kategorie/datenstrukturen"]
aliases: ["Wildcard", "? extends", "? super", "Kovarianz", "Kontravarianz", "Invarianz", "PECS"]
---

# Wildcards und Varianz

> [!info] Kurz erklärt
> Generics sind **invariant**: `List<Integer>` ist kein `List<Number>`. Mit Wildcards wird man flexibel: `List<? extends Number>` (kovariant, nur lesen), `List<? super Integer>` (kontravariant, schreiben). Merksatz: Producer Extends, Consumer Super.

## Erklärt in
- [[25 Datenstrukturen und Generics]] · Folien S. [[Material/Folien/25_Datenstrukturen.pdf#page=66|66]], [[Material/Folien/25_Datenstrukturen.pdf#page=67|67]], [[Material/Folien/25_Datenstrukturen.pdf#page=68|68]], [[Material/Folien/25_Datenstrukturen.pdf#page=69|69]], [[Material/Folien/25_Datenstrukturen.pdf#page=70|70]], [[Material/Folien/25_Datenstrukturen.pdf#page=71|71]]

## Verwandte Begriffe
[[Generics]]

## Übungen, in denen das gebraucht wird (1)
- [[Ü25 Binärbaum]]
