---
tags: ["typ/uebung", "thema/operatoren", "kategorie/grundlagen", "semester/1", "schwierigkeit/1", "hat/musterloesung"]
aliases: ["IncrementDecrement"]
thema: "[[05 Operatoren]]"
klasse: "IncrementDecrement"
package: "de.dhbwka.java.exercise.operators"
schwierigkeit: 1
status: "offen"
---

# Ü05 Inkrement und Dekrement

**Thema:** [[05 Operatoren]] · **Bereich:** Operatoren · **Schwierigkeit:** ★☆☆☆☆
**Klasse:** `IncrementDecrement` · **Package:** `de.dhbwka.java.exercise.operators`

📄 Aufgabe: [[Material/Aufgaben/05_Operatoren_Aufgaben.pdf#page=1|05_Operatoren_Aufgaben.pdf, S. 1]]
✅ Musterlösung: [[Material/Aufgaben/05_Operatoren_Aufgaben_Muster.pdf#page=1|05_Operatoren_Aufgaben_Muster.pdf, S. 1]]

> [!question] Kurz gesagt
> Was gibt das folgende Programm IncrementDecrement aus? Lösen Sie die Aufgabe zunächst „auf Papier“, kontrollieren Sie das Ergebnis dann am Rechner!

## Aufgabenstellung
```text
Was gibt das folgende Programm IncrementDecrement aus?

Lösen Sie die Aufgabe zunächst „auf Papier“, kontrollieren Sie das Ergebnis dann am Rechner!

package de.dhbwka.java.exercise.operators;

public class IncrementDecrement {

        public static void main(String[] args) {
          int i=0;
          int j=0;
          j = ++i;
          int k = j++ + ++i;
          System.out.println("k: " + k);
          System.out.println("*: " + j++ + ++i);
          System.out.println(j++ + ++i);
          int m = j++ * ++i;
          System.out.println("m: " + m);
          int n = --j * --i;
          System.out.println("n: " + n);
          System.out.println("i: " + i);
          System.out.println("j: " + j);
        }

}
```

## Benötigte Begriffe
[[Inkrement und Dekrement]]

## Weitere Übungen zum Thema
[[Ü05 Kaufmännisches Runden (2)]] · [[Ü05 Ostertermin berechnen]] · [[Ü05 Vorrang von Operatoren]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.operators;
> 
> public class IncrementDecrement {
> 
>     public static void main(String[] args) {
>         int i=0;
>         int j=0;
>         j = ++i;
>         int k = j++ + ++i;
>         System.out.println("k: " + k);                            k: 3
>         System.out.println("*: " + j++ + ++i);                    *: 23
>         System.out.println(j++ + ++i);                            7
>         int m = j++ * ++i;
>         System.out.println("m: " + m);                            m: 20
>         int n = --j * --i;
>         System.out.println("n: " + n);                            n: 16
>         System.out.println("i: " + i);                            i: 4
>         System.out.println("j: " + j);                            J: 4
>     }
> 
> }
> ```

## Meine Notizen

