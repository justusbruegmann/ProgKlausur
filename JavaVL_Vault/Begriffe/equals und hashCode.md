---
tags: ["typ/begriff", "thema/vererbung", "thema/datenstrukturen", "kategorie/oop"]
aliases: ["equals", "hashCode", "equals()", "hashCode()"]
---

# equals und hashCode

> [!info] Kurz erklärt
> `equals` definiert inhaltliche Gleichheit, `hashCode` liefert einen dazu passenden Hashwert. Regel: Wer `equals` überschreibt, muss auch `hashCode` überschreiben, sonst funktionieren `HashSet`/`HashMap` nicht korrekt.

## Erklärt in
- [[13 Vererbung]] · Folien S. [[Material/Folien/13_Vererbung.pdf#page=41|41]], [[Material/Folien/13_Vererbung.pdf#page=42|42]], [[Material/Folien/13_Vererbung.pdf#page=43|43]], [[Material/Folien/13_Vererbung.pdf#page=44|44]]
- [[25 Datenstrukturen und Generics]] · Folien S. [[Material/Folien/25_Datenstrukturen.pdf#page=26|26]], [[Material/Folien/25_Datenstrukturen.pdf#page=27|27]], [[Material/Folien/25_Datenstrukturen.pdf#page=37|37]], [[Material/Folien/25_Datenstrukturen.pdf#page=38|38]], [[Material/Folien/25_Datenstrukturen.pdf#page=39|39]], [[Material/Folien/25_Datenstrukturen.pdf#page=46|46]], [[Material/Folien/25_Datenstrukturen.pdf#page=47|47]], [[Material/Folien/25_Datenstrukturen.pdf#page=48|48]]

## Kommt auch vor in
- [[29 XML]] · S. [[Material/Folien/29_XML.pdf#page=33|33]], [[Material/Folien/29_XML.pdf#page=35|35]], [[Material/Folien/29_XML.pdf#page=36|36]], [[Material/Folien/29_XML.pdf#page=37|37]]
- [[33 Java 8 – Lambdas, Streams, NIO.2]] · S. [[Material/Folien/33_Java8.pdf#page=34|34]], [[Material/Folien/33_Java8.pdf#page=60|60]], [[Material/Folien/33_Java8.pdf#page=61|61]]

## Verwandte Begriffe
[[Identität und Gleichheit]] · [[Object]] · [[Set]] · [[Map]]

## Übungen, in denen das gebraucht wird (3)
- [[Ü13 Periodensystem]]
- [[Ü23 Editor]]
- [[Ü29 Google-Maps-Gazetteer-Service]]

## In diesen Programmentwürfen gefragt
[[PE CHORona]]
