---
tags: ["typ/begriff", "thema/threads", "kategorie/nebenlaeufigkeit"]
aliases: ["Threads", "Nebenläufigkeit", "Concurrency", "Parallelität", "Prozess", "start()", "sleep"]
---

# Thread

> [!info] Kurz erklärt
> Ein Thread ist ein eigenständiger Ausführungsstrang innerhalb eines Prozesses. Erzeugung über eine Unterklasse von `Thread` oder (besser) über ein [[Runnable]]; Start mit `start()` (nicht `run()`!). Dazu gehören `sleep`, `join`, `interrupt` und ein Lebenszyklus (new → runnable → blocked/waiting → terminated).

## Erklärt in
- [[27 Threads]] · Folien S. [[Material/Folien/27_Threads.pdf#page=2|2]], [[Material/Folien/27_Threads.pdf#page=3|3]], [[Material/Folien/27_Threads.pdf#page=5|5]], [[Material/Folien/27_Threads.pdf#page=6|6]], [[Material/Folien/27_Threads.pdf#page=11|11]], [[Material/Folien/27_Threads.pdf#page=12|12]], [[Material/Folien/27_Threads.pdf#page=14|14]], [[Material/Folien/27_Threads.pdf#page=18|18]]

## Verwandte Begriffe
[[Runnable]] · [[Synchronisation]] · [[wait und notify]] · [[Executor-Framework]] · [[Zeichnen mit Graphics]]

## Übungen, in denen das gebraucht wird (4)
- [[Ü27 Tanzende Schrift]]
- [[Ü27 Ampel]]
- [[Ü27 Synchronisation]]
- [[Ü27 Suchmaschine]]

## In diesen Programmentwürfen gefragt
[[PE SpeedyQuiz]] · [[PE jBay]] · [[PE SnatChat (Übungs-PE Oktober 2026)]]
