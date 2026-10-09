---
tags: ["typ/begriff", "thema/events", "thema/swing", "kategorie/gui"]
aliases: ["Event", "Events", "ActionListener", "EventListener", "Event-Handling", "Event-Modell", "actionPerformed", "ActionEvent", "Ereignis"]
---

# Listener

> [!info] Kurz erklärt
> Swing meldet Benutzeraktionen als **Events** an registrierte **Listener** (Beobachter-Muster): `button.addActionListener(e -> …)` bzw. eine Klasse, die `ActionListener` mit `actionPerformed(ActionEvent e)` implementiert. Weitere Listener sind z. B. `MouseListener`, `KeyListener`, `WindowListener` und `ItemListener`. Adapterklassen ersparen leere Methoden.

## Erklärt in
- [[23 Events]] · Folien S. [[Material/Folien/23_Events.pdf#page=2|2]], [[Material/Folien/23_Events.pdf#page=3|3]], [[Material/Folien/23_Events.pdf#page=4|4]], [[Material/Folien/23_Events.pdf#page=5|5]], [[Material/Folien/23_Events.pdf#page=6|6]], [[Material/Folien/23_Events.pdf#page=7|7]], [[Material/Folien/23_Events.pdf#page=8|8]], [[Material/Folien/23_Events.pdf#page=9|9]]
- [[20 Grafische Oberflächen mit Swing]] · Folien S. [[Material/Folien/20_Swing.pdf#page=3|3]], [[Material/Folien/20_Swing.pdf#page=24|24]], [[Material/Folien/20_Swing.pdf#page=48|48]]

## Verwandte Begriffe
[[Swing]] · [[Anonyme innere Klasse]] · [[Lambda-Ausdruck]] · [[Interface]] · [[MouseListener]]

## Übungen, in denen das gebraucht wird (12)
- [[Ü20 Editor]]
- [[Ü23 Währungsumrechner (2)]]
- [[Ü23 Body-Mass-Index (BMI)]]
- [[Ü23 Binäre Zahlen]]
- [[Ü23 Zahlenraten (2)]]
- [[Ü23 Editor]]
- [[Ü23 Hütchenspiel]]
- [[Ü24 ClickFiller]]
- [[Ü25 Bücherei]]
- [[Ü25 Tankstellenpreise]]
- [[Ü26 Sortierkriterien]]
- [[Ü33 Zahlenraten (3)]]

## In diesen Programmentwürfen gefragt
[[PE SpeedyQuiz]] · [[PE CoronaWarn]] · [[PE SnatChat (Übungs-PE Oktober 2026)]]
