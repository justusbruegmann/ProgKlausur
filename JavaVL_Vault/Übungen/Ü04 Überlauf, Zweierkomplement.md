---
tags: ["typ/uebung", "thema/datentypen", "kategorie/grundlagen", "semester/1", "schwierigkeit/1", "hat/musterloesung"]
aliases: ["ShortValue"]
thema: "[[04 Primitive Datentypen]]"
klasse: "ShortValue"
package: "de.dhbwka.java.exercise.datatypes"
schwierigkeit: 1
status: "offen"
---

# Ü04 Überlauf, Zweierkomplement

**Thema:** [[04 Primitive Datentypen]] · **Bereich:** Primitive Datentypen · **Schwierigkeit:** ★☆☆☆☆
**Klasse:** `ShortValue` · **Package:** `de.dhbwka.java.exercise.datatypes`

📄 Aufgabe: [[Material/Aufgaben/04_Primitive_Datentypen_Aufgaben.pdf#page=1|04_Primitive_Datentypen_Aufgaben.pdf, S. 1]]
✅ Musterlösung: [[Material/Aufgaben/04_Primitive_Datentypen_Aufgaben_Muster.pdf#page=1|04_Primitive_Datentypen_Aufgaben_Muster.pdf, S. 1]]

> [!question] Kurz gesagt
> Schreiben Sie ein Programm ShortValue, in dem Sie eine short-Variable mit dem Wert 32767 initialisieren und den Wert der Variablen ausgeben! Erhöhen Sie dann den Wert der Variablen um 1 und geben Sie den neuen Wert der Variablen aus!

## Aufgabenstellung
```text
Schreiben Sie ein Programm ShortValue, in dem Sie eine short-Variable mit dem Wert 32767
initialisieren und den Wert der Variablen ausgeben!
Erhöhen Sie dann den Wert der Variablen um 1 und geben Sie den neuen Wert der Variablen aus!
Welcher Wert wird ausgegeben und warum? Gibt es eine Fehlermeldung des Laufzeitsystems?

Hinweis:
Für die Ausgabe der Variablenwerte kann das Beispielprogramm Quotient im Kapitel „Die
Programmiersprache Java“ als Vorbild genommen werden.
```

## Benötigte Begriffe
[[Überlauf und Zweierkomplement]]

## Weitere Übungen zum Thema
[[Ü04 Kaufmännisches Runden (1)]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> In der (bei Java verwendeten) Zweierkomplement-Darstellung für ganze Zahlen gibt es kein
> „Vorzeichen-Bit“, sondern der Wert des höchstwertigen („ersten“, „linken“) Bits wird als negativer
> Wert interpretiert, im Falle von short (16 Bit) hat das höchstwertige Bit also einen Wert
> von -215 = -32768(10). Alle anderen Bits haben den entsprechenden positiven Wert.
> Negative Zahlen sind also solche Zahlen, bei denen das höchstwertige („erste“, „linke“) Bit gesetzt
> ist.
> 
> Die Vorteile dieser Methode sind, dass man im Zweierkomplement ohne Unterscheidung von
> positiven und negativen Zahlen rechnen kann, und dass es genau eine Darstellung der Zahl 0 (Null)
> gibt.
> Allerdings ergibt sich daraus eben auch, dass bei einem Überlauf (größtmögliche Zahl wird erhöht)
> ein Übergang zu den negativen Zahlen stattfindet, wie es diese Aufgabe zeigen soll.
> 
> Die Binärdarstellung der 16-Bit-Zahl 32767(10) ist
> 2-15    214     213     212    211    210     29    28    27    26   25    24   23   22   21   20
> -32768   16384   8192    4096   2048    1024    512   256   128   64   32    16   8    4    2    1
> 0       1       1      1       1       1     1      1     1     1   1     1    1    1    1    1
> bzw. kurz:
> 0111111111111111(2)
> 
> Das Addieren von 1(10)
> 0000000000000001(2)
> 
> resultiert in der Rechnung
> 0111111111111111(2) // 32767(10)
> + 0000000000000001(2) //      1(10)
> ------------------
> 1000000000000000(2) // -32768(10) (-32768(10) + 0(10)).
> 
> Schreibweisen:
> N(10) Dezimalzahl
> N(2) Dualzahl/Binärzahl
> 
> Kurz gesagt werden beim Zweierkomplement negative Zahlen aus positiven Zahlen erzeugt
> (Multiplikation mit -1), indem die einzelnen Bits invertiert werden (daher der Name „Komplement“)
> und anschließend eine 1 addiert wird (damit es keine zwei Nullen gibt), z.B. bei der Zahl 4711(10):
> 
> 0001001001100111(2) // 4711(10)
> 1110110110011000(2) // bitweise invertiert
> + 0000000000000001(2) // +1(10)
> ------------------
> 1110110110011001(2) // -4711(10)
> 
> 2-15       214    213    212    211    210    29    28    27    26   25   24   23   22   21   20
> -32768     16384   8192   4096   2048   1024   512   256   128   64   32   16   8    4    2    1
> 1         1       1      0      1      1     0     1     1     0    0    1    1    0    0    1
> 
> „Gegenprobe“:
> 
> 0110110110011001(2) // 28057(10) (ohne höchstes Bit)
> // -4711(10) = -32768(10) + 28057(10) ✓
> 
> package de.dhbwka.java.exercise.datatypes;
> 
> public class ShortValue {
> 
>     public static void main(String[] args) {
>         short val = 32767;
>         System.out.println("val:   "+val);
>         val++;
>         System.out.println("val+1: "+val);
>     }
> 
> }
> ```

## Meine Notizen

