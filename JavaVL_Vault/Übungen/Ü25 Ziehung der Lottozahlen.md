---
tags: ["typ/uebung", "thema/datenstrukturen", "kategorie/datenstrukturen", "semester/2", "schwierigkeit/2", "hat/musterloesung"]
aliases: ["Lottery"]
thema: "[[25 Datenstrukturen und Generics]]"
klasse: "Lottery"
package: "de.dhbwka.java.exercise.collections"
schwierigkeit: 2
status: "offen"
---

# Ü25 Ziehung der Lottozahlen

**Thema:** [[25 Datenstrukturen und Generics]] · **Bereich:** Datenstrukturen (1) · **Schwierigkeit:** ★★☆☆☆
**Klasse:** `Lottery` · **Package:** `de.dhbwka.java.exercise.collections`

📄 Aufgabe: [[Material/Aufgaben/25_Datenstrukturen_Aufgaben-1.pdf#page=1|25_Datenstrukturen_Aufgaben-1.pdf, S. 1]]
✅ Musterlösung: [[Material/Aufgaben/25_Datenstrukturen_Aufgaben-1_Muster.pdf#page=1|25_Datenstrukturen_Aufgaben-1_Muster.pdf, S. 1]]

> [!question] Kurz gesagt
> Schreiben Sie ein Programm, das die Ziehung der Lottozahlen „6 aus 49 mit Zusatzzahl“ nachbildet. Verwenden Sie dabei eine Datenstruktur des Collection-Frameworks für die Speicherung der Zahlen.

## Aufgabenstellung
```text
Schreiben Sie ein Programm, das die Ziehung der Lottozahlen „6 aus 49 mit Zusatzzahl“ nachbildet.
Verwenden Sie dabei eine Datenstruktur des Collection-Frameworks für die Speicherung der Zahlen.

Das Programm soll wiederholt eine ganzzahlige Zufallszahl aus dem Zahlenbereich 1 bis 49
generieren und jeweils der Collection hinzufügen (insgesamt sieben Zahlen [inkl. Zusatzzahl] in der
Collection; keine Duplikate!).

Es soll anschließend die in der Collection gespeicherten Zahlen auf den Bildschirm (Konsolenfenster)
ausgeben.

Die gezogenen Zahlen sollen aufsteigend sortiert ausgegeben werden, die Zusatzzahl separat, z.B.:

2 6 13 27 28 43 Zusatzzahl: 33

Hinweis:
Die ersten sechs gezogenen Zahlen sollen aufsteigend sortiert ausgegeben werden. Die siebte ist die
Zusatzzahl und wird (unabhängig von ihrem Wert) hinten angestellt.

Frage:
Welches Interface des Collection-Frameworks und welche Implementierung dieses Interfaces eignen
sich für diese Aufgabenstellung am besten?
```

## Benötigte Begriffe
[[Zufallszahlen]] · [[while-Schleife]] · [[for-Schleife]] · [[Sortieren]] · [[Interface]] · [[Set]]

## Weitere Übungen zum Thema
[[Ü25 Bücherei]] · [[Ü25 Binärbaum]] · [[Ü25 Tankstellenpreise]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.collections;
> 
> import java.util.Random;
> import java.util.Set;
> import java.util.TreeSet;
> 
> public class Lottery {
> 
>     public static void main( String[] args ) {
> 
>         // Set => no duplicates
>         // TreeSet => ordered!
>         Set<Integer> numbers = new TreeSet<>();
> 
>         // store number that was added last
>         Integer addNumber = null;
>         Random r = new Random();
> 
>         // Remember: usage of Set prevents duplicates
>         while ( numbers.size() < 7 ) {
>             numbers.add( addNumber = r.nextInt( 49 ) + 1 ); // Autoboxing
>         }
> 
>         // remove last added number => that's the bonus number!
>         numbers.remove( addNumber );
> 
>         for ( Integer no : numbers ) {
>             System.out.print( no + " " );
>         }
>         System.out.println( "Bonus number: " + addNumber );
> 
>     }
> 
> }
> ```

## Meine Notizen

