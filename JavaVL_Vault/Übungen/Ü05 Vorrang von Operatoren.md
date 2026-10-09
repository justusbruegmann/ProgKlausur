---
tags: ["typ/uebung", "thema/operatoren", "kategorie/grundlagen", "semester/1", "schwierigkeit/1", "hat/musterloesung"]
aliases: ["Priority"]
thema: "[[05 Operatoren]]"
klasse: "Priority"
package: "de.dhbwka.java.exercise.operators"
schwierigkeit: 1
status: "offen"
---

# Ü05 Vorrang von Operatoren

**Thema:** [[05 Operatoren]] · **Bereich:** Operatoren · **Schwierigkeit:** ★☆☆☆☆
**Klasse:** `Priority` · **Package:** `de.dhbwka.java.exercise.operators`

📄 Aufgabe: [[Material/Aufgaben/05_Operatoren_Aufgaben.pdf#page=4|05_Operatoren_Aufgaben.pdf, S. 4]]
✅ Musterlösung: [[Material/Aufgaben/05_Operatoren_Aufgaben_Muster.pdf#page=3|05_Operatoren_Aufgaben_Muster.pdf, S. 3]]

> [!question] Kurz gesagt
> Was gibt das folgende Programm Priority aus? Lösen Sie die Aufgabe zunächst „auf Papier“, kontrollieren Sie das Ergebnis dann am Rechner!

## Aufgabenstellung
```text
Was gibt das folgende Programm Priority aus?

Lösen Sie die Aufgabe zunächst „auf Papier“, kontrollieren Sie das Ergebnis dann am Rechner!

package de.dhbwka.java.exercise.operators;

public class Priority {

        public static void main(String[] args) {
              System.out.println("1: " + (5 / 2 * 2));
              System.out.println("2: " + (9. / 2 * 5));

                boolean a = true, b = false, c = false;
                System.out.println("3: " + (a && b || c));

                char ch = 'c';
                System.out.println("4: " + ('a' + 1 < ch));

                int i = 1, j = 2, k = 3;
                System.out.println("5: " + (-i - 5 * j >= k + 1));

                i = 1;
                if (a || (++i == 2)) {
                       System.out.println("6: " + i);
                }

                i = 1;
                if (a | (++i == 2)) {
                       System.out.println("7: " + i);
                }
        }

}
```

## Benötigte Begriffe
[[Operatorpriorität]]

## Weitere Übungen zum Thema
[[Ü05 Inkrement und Dekrement]] · [[Ü05 Kaufmännisches Runden (2)]] · [[Ü05 Ostertermin berechnen]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.operators;
> 
> public class Priority {
> 
>     public static void main(String[] args) {
>         System.out.println("1: " + (5 / 2 * 2));                      4
>         System.out.println("2: " + (9. / 2 * 5));                     22.5
> 
>         boolean a = true, b = false, c = false;
>         System.out.println("3: " + (a && b || c));                   false
> 
>         char ch = 'c';
>         System.out.println("4: " + ('a' + 1 < ch));                  true
> 
>         int i = 1, j = 2, k = 3;
>         System.out.println("5: " + (-i - 5 * j >= k + 1)); false
> 
>         i = 1;
>         if (a || (++i == 2)) {
>             System.out.println("6: " + i);                           1
>         }
> 
>         i = 1;
>         if (a | (++i == 2)) {
>             System.out.println("7: " + i);                           2
>         }
>     }
> 
> }
> ```

## Meine Notizen

