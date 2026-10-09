---
tags: ["typ/begriff", "thema/datenstrukturen", "kategorie/datenstrukturen"]
aliases: ["Enumeration", "hasNext", "ConcurrentModificationException", "Iterable"]
---

# Iterator

> [!info] Kurz erklärt
> Objekt zum schrittweisen Durchlaufen einer Collection: `while (it.hasNext()) { x = it.next(); }`. Mit `it.remove()` kann man sicher während der Iteration löschen; `list.remove(...)` in einer for-each-Schleife wirft dagegen eine `ConcurrentModificationException`.

## Erklärt in
- [[25 Datenstrukturen und Generics]] · Folien S. [[Material/Folien/25_Datenstrukturen.pdf#page=43|43]], [[Material/Folien/25_Datenstrukturen.pdf#page=44|44]], [[Material/Folien/25_Datenstrukturen.pdf#page=49|49]], [[Material/Folien/25_Datenstrukturen.pdf#page=50|50]], [[Material/Folien/25_Datenstrukturen.pdf#page=51|51]]

## Verwandte Begriffe
[[Collection API]] · [[for-Schleife]] · [[List]]
