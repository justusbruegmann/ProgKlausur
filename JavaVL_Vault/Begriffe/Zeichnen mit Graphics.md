---
tags: ["typ/begriff", "thema/zeichnen", "kategorie/gui"]
aliases: ["paintComponent", "Graphics", "Graphics2D", "repaint", "drawLine", "fillRect", "drawOval", "Koordinatensystem"]
---

# Zeichnen mit Graphics

> [!info] Kurz erklärt
> Eigene Grafik: in einer `JComponent`/`JPanel`-Unterklasse `paintComponent(Graphics g)` überschreiben (zuerst `super.paintComponent(g)`), dann mit `g.drawLine`, `fillRect`, `drawOval`, `drawString` … zeichnen. Ursprung (0,0) ist **oben links**. Neu zeichnen mit `repaint()`.

## Erklärt in
- [[24 Zeichnen in Swing]] · Folien S. [[Material/Folien/24_Zeichnen.pdf#page=2|2]], [[Material/Folien/24_Zeichnen.pdf#page=3|3]], [[Material/Folien/24_Zeichnen.pdf#page=4|4]], [[Material/Folien/24_Zeichnen.pdf#page=5|5]], [[Material/Folien/24_Zeichnen.pdf#page=6|6]], [[Material/Folien/24_Zeichnen.pdf#page=7|7]], [[Material/Folien/24_Zeichnen.pdf#page=12|12]], [[Material/Folien/24_Zeichnen.pdf#page=13|13]]

## Kommt auch vor in
- [[21 Abstrakte Klassen und Interfaces]] · S. [[Material/Folien/21_Abstrakte_Klassen_Interfaces.pdf#page=2|2]], [[Material/Folien/21_Abstrakte_Klassen_Interfaces.pdf#page=3|3]], [[Material/Folien/21_Abstrakte_Klassen_Interfaces.pdf#page=4|4]], [[Material/Folien/21_Abstrakte_Klassen_Interfaces.pdf#page=5|5]], [[Material/Folien/21_Abstrakte_Klassen_Interfaces.pdf#page=7|7]]

## Verwandte Begriffe
[[JPanel]] · [[Farben und Schriften]] · [[MouseListener]] · [[Thread]]

## Übungen, in denen das gebraucht wird (4)
- [[Ü24 ClickFiller]]
- [[Ü24 Wahl]]
- [[Ü27 Tanzende Schrift]]
- [[Ü27 Ampel]]

## In diesen Programmentwürfen gefragt
[[PE CHORona]] · [[PE DBVasion]] · [[PE ChatterGPT Validator]] · [[PE SnatChat (Übungs-PE Oktober 2026)]]
