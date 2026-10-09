---
tags: ["typ/begriff", "thema/threads", "kategorie/nebenlaeufigkeit"]
aliases: ["wait", "notify", "notifyAll", "Erzeuger-Verbraucher", "Producer-Consumer"]
---

# wait und notify

> [!info] Kurz erklärt
> Innerhalb von `synchronized` wartet ein Thread mit `wait()` auf eine Bedingung und gibt den Monitor frei; ein anderer weckt ihn mit `notify()`/`notifyAll()`. Klassisches Beispiel: Erzeuger-Verbraucher-Puffer.

## Erklärt in
- [[27 Threads]] · Folien S. [[Material/Folien/27_Threads.pdf#page=20|20]], [[Material/Folien/27_Threads.pdf#page=31|31]], [[Material/Folien/27_Threads.pdf#page=32|32]], [[Material/Folien/27_Threads.pdf#page=33|33]], [[Material/Folien/27_Threads.pdf#page=34|34]], [[Material/Folien/27_Threads.pdf#page=35|35]], [[Material/Folien/27_Threads.pdf#page=36|36]], [[Material/Folien/27_Threads.pdf#page=37|37]]

## Verwandte Begriffe
[[Synchronisation]] · [[Thread]]

## Übungen, in denen das gebraucht wird (1)
- [[Ü27 Synchronisation]]
