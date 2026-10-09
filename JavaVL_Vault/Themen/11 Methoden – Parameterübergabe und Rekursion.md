---
tags: ["typ/thema", "thema/methoden", "kategorie/grundlagen", "semester/1"]
aliases: ["Methoden – Parameterübergabe und Rekursion", "Folien 11"]
semester: 1
kategorie: "Grundlagen"
folien: "[[Material/Folien/11_Methoden-Special.pdf]]"
seiten: 16
---

# 11 Methoden – Parameterübergabe und Rekursion

← [[10 Strings und Wrapperklassen]] · [[Start|🏠 Start]] · [[12 Dokumentation mit Javadoc]] →

> [!abstract] Worum geht's?
> Wie Parameter übergeben werden (Call-by-Value vs. Referenzkopie) – für primitive Typen, Wrapper, String, StringBuffer und Arrays – sowie Rekursion am Beispiel Fakultät und ggT.

**Semester:** Programmieren I · **Bereich:** #kategorie/grundlagen · **Folien:** [[Material/Folien/11_Methoden-Special.pdf|11_Methoden-Special.pdf]] (16 Seiten)

## Gliederung der Folien
- [[Material/Folien/11_Methoden-Special.pdf#page=2|S. 2]] Parameterübergabe: Wertkopie („Call-By-Value“)
- [[Material/Folien/11_Methoden-Special.pdf#page=3|S. 3]] Parameterübergabe: Referenzkopie („Call-By-Reference“)
- [[Material/Folien/11_Methoden-Special.pdf#page=4|S. 4]] Unterschied Call-By-Reference in Java und C
- [[Material/Folien/11_Methoden-Special.pdf#page=5|S. 5]] Parameterübergabe: Wrapperklasse
- [[Material/Folien/11_Methoden-Special.pdf#page=6|S. 6]] Parameterübergabe: String
- [[Material/Folien/11_Methoden-Special.pdf#page=7|S. 7]] Parameterübergabe: StringBuffer
- [[Material/Folien/11_Methoden-Special.pdf#page=8|S. 8]] Parameterübergabe: Array
- [[Material/Folien/11_Methoden-Special.pdf#page=9|S. 9]] Rekursion
- [[Material/Folien/11_Methoden-Special.pdf#page=10|S. 10]] Berechnung der Fakultät
- [[Material/Folien/11_Methoden-Special.pdf#page=11|S. 11]] Ablauf einer rekursiven Methode (1): Fakultät
- [[Material/Folien/11_Methoden-Special.pdf#page=12|S. 12]] Ablauf einer rekursiven Methode (2): Fakultät
- [[Material/Folien/11_Methoden-Special.pdf#page=13|S. 13]] Größter gemeinsamer Teiler (ggT)
- [[Material/Folien/11_Methoden-Special.pdf#page=14|S. 14]] Beispiel: Größter gemeinsamer Teiler
- [[Material/Folien/11_Methoden-Special.pdf#page=15|S. 15]] Vor- und Nachteile rekursiver Algorithmen
- [[Material/Folien/11_Methoden-Special.pdf#page=16|S. 16]] Rekursion in Programmiersprachen

## Begriffe in diesem Kapitel
- [[Arrays kopieren]]
- [[Sortieren]]
- [[Methode]] (S. [[Material/Folien/11_Methoden-Special.pdf#page=5|5]], [[Material/Folien/11_Methoden-Special.pdf#page=6|6]], [[Material/Folien/11_Methoden-Special.pdf#page=7|7]], [[Material/Folien/11_Methoden-Special.pdf#page=9|9]], [[Material/Folien/11_Methoden-Special.pdf#page=10|10]], [[Material/Folien/11_Methoden-Special.pdf#page=11|11]])
- [[StringBuilder und StringBuffer]] (S. [[Material/Folien/11_Methoden-Special.pdf#page=7|7]])
- [[Wrapperklasse]] (S. [[Material/Folien/11_Methoden-Special.pdf#page=3|3]], [[Material/Folien/11_Methoden-Special.pdf#page=4|4]], [[Material/Folien/11_Methoden-Special.pdf#page=5|5]])
- [[Call-by-Value und Referenzen]] (S. [[Material/Folien/11_Methoden-Special.pdf#page=2|2]], [[Material/Folien/11_Methoden-Special.pdf#page=3|3]], [[Material/Folien/11_Methoden-Special.pdf#page=4|4]], [[Material/Folien/11_Methoden-Special.pdf#page=5|5]], [[Material/Folien/11_Methoden-Special.pdf#page=6|6]], [[Material/Folien/11_Methoden-Special.pdf#page=7|7]])
- [[Rekursion]] (S. [[Material/Folien/11_Methoden-Special.pdf#page=9|9]], [[Material/Folien/11_Methoden-Special.pdf#page=10|10]], [[Material/Folien/11_Methoden-Special.pdf#page=11|11]], [[Material/Folien/11_Methoden-Special.pdf#page=12|12]], [[Material/Folien/11_Methoden-Special.pdf#page=14|14]], [[Material/Folien/11_Methoden-Special.pdf#page=15|15]])
- [[Binärbaum]]

## Übungen
- [ ] [[Ü11 Potenzen]] ★☆☆☆☆
- [ ] [[Ü11 Fibonacci-Zahlen rekursiv]] ★☆☆☆☆
- [ ] [[Ü11 Quicksort]] ★★★☆☆

## Verwandte Themen
[[09 Klassen und Objekte]] · [[07 Arrays]] · [[10 Strings und Wrapperklassen]]

## Folien ansehen
![[Material/Folien/11_Methoden-Special.pdf]]

## Folientext (durchsuchbar)
> [!quote]- Kompletter Folientext – aufklappen
> ```text
> ── Seite 1 ──
> Programmieren I
> Methoden-Special
>    Heusch ---
>    Ratz 6.1, 6.2
> 
> Institut für Automation und angewandte Informatik
> 
> KIT – Die Forschungsuniversität in der Helmholtz-Gemeinschaft www.kit.edu
> 
> ── Seite 2 ──
> Parameterübergabe: Wertkopie („Call-By-Value“)
>    public class MethodParameters {
> 
>    public static void someMethod(int a) {
>    a += 2;
>    }
> 
>    public static void main(String[] args) {
>    int x = 3;
> 
>    System.out.println("x: " + x);   > java MethodParameters
>    someMethod(x);   x: 3
>    System.out.println("x: " + x);   x: 3
>    }
> 
>    }
> 
>    Der Parameter wird als Kopie des Wertes (Wertkopie, „Call-By-Value“)
>    übergeben. Keine Veränderung des ursprünglichen Wertes!
> 2 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 3 ──
> Parameterübergabe: Referenzkopie („Call-By-Reference“)
>    public class MyInteger {
>    int a;
>    public MyInteger( int a ){ this.a = a; }
>    public String toString() {
>    return "MyInteger{a=" + a + "}";
>    }
>    }
> 
>    public class MethodParameters {
>    Parameter ma enthält
>    public static void someMethod(MyInteger ma){   eine Kopie der Referenz
>    ma.a += 2;   des Objektes.
>    }   → Veränderung des
>    Objektes!
>    public static void main(String[] args) {
>    MyInteger mi = new MyInteger(3);
>    System.out.println(mi);
>    someMethod(mi);
>    System.out.println(mi);   > java MethodParameters
>    }   MyInteger{a=3}
>    MyInteger{a=5}
>    }
> 
> 3 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 4 ──
> Unterschied Call-By-Reference in Java und C
>    public class MyInteger {
>    int a;
>    public MyInteger( int a ){ this.a = a; }   Referenzkopie
>    public String toString() {   (Kein echtes „Call-By-
>    return "MyInteger{a=" + a + "}";   Reference“ wie z.B. in C)
>    }
>    }
> 
>    public class MethodParameters {
> 
>    public static void someMethod(MyInteger ma){   Der Parameter ma
>    ma = new MyInteger(6);   enthält die Kopie der
>    }   Referenz des Objektes.
> 
>    public static void main(String[] args) {
>    MyInteger mi = new MyInteger(3);
>    System.out.println(mi);
>    someMethod(mi);
>    System.out.println(mi);   > java MethodParameters
>    }   MyInteger{a=3}
>    MyInteger{a=3}
>    }
> 
> 4 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 5 ──
> Parameterübergabe: Wrapperklasse
>    public class MethodParameters {   Wrapperklassen-Objekte sind
>    public static void someMethod(Integer a){   immutable (unveränderbar)
>    a += 2;
>    Bei der Addition wird ein
>    System.out.println("a: " + a);   a: 5   neues Integer-Objekt
>    }
>    zugewiesen, das
>    public static void main(String[] args) {   ursprüngliche Integer-
>    Integer y = 3;   Objekt bleibt unangetastet
>    System.out.println("y: " + y);   y: 3   Keine Veränderung des
>    someMethod(y);   Parameters y sichtbar, da die
>    System.out.println("y: " + y);   y: 3   kopierte Referenz a beim
>    }   Beenden der Methode
>    }   verloren geht
> 
>    Zur Verdeutlichung die ausführliche Schreibweise:
>    //...
>    public static void someMethod(Integer a){
>    a = new Integer(a.intValue() + 2);
>    }
>    //...
> 
> 5 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 6 ──
> Parameterübergabe: String
>    public class MethodParameters {   String-Objekte sind
>    public static void aMethod(String a){
>    immutable
>    a += "Hello";
>    (unveränderbar)
>    System.out.println("a: " + a);
>    }
>    a: TestHello
>    Bei a += "Hello";
>    public static void main(String[] args) {   wird ein neues String-
>    String s = "Test";   Objekt angelegt. Die
>    System.out.println("s: " + s);   s: Test   einzige Referenz a
>    aMethod(s);   darauf geht beim
>    System.out.println("s: " + s);   s: Test   Verlassen der Methode
>    }   aMethod verloren.
>    }
> 
>    Zur Verdeutlichung die ausführliche Schreibweise:
>    //...
>    public static void aMethod(String a){
>    a = new String(a + "Hello");
>    }
>    //...
> 
> 6 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 7 ──
> Parameterübergabe: StringBuffer
>    public class MethodParameters {
>    public static void anotherMethod(StringBuffer a){
>    a.append("Hello");
>    System.out.println("a: " + a);   a: TestHello
>    }
> 
>    public static void main(String[] args) {
>    StringBuffer sb = new StringBuffer("Test");
>    System.out.println("sb: " + sb);   sb: Test
>    anotherMethod(sb);
>    System.out.println("sb: " + sb);   sb: TestHello
>    }
>    }
> 
>    StringBuffer-Objekte sind mutable (veränderbar)
> 
>    Das referenzierte StringBuffer-Objekt selbst wird in der Methode
>    anotherMethod mit append() verändert.
>    Dadurch ist die Änderung auch über die Referenz sb sichtbar.
> 7 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 8 ──
> Parameterübergabe: Array
>    public class ArrayParameters {
> 
>    int[] nums;
> 
>    public void setArray1(int[] nums) {
>    this.nums = nums;
>    }
> 
>    public void setArray2(int... nums) {
>    this.nums = nums;   Ab Java 1.5
>    }
> 
>    public static void main(String[] args) {
>    ArrayParameters ap = new ArrayParameters();
> 
>    int[] n = { 1, 2, 3, 4, 5, 6 };
>    ap.setArray1(n);
>    ap.setArray2(1, 2, 3, 4, 5, 6, 7);
>    ap.setArray2(n);
>    }
> 
>    }
> 
> 8 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 9 ──
> Rekursion
> 
>    Innerhalb des Anweisungsblocks einer Methode können
>    wiederum Methodenaufrufe stehen
>    Methoden können nicht nur andere Methoden aufrufen,
>    sondern auch sich selbst
>    Eine Methode m() heißt rekursiv, wenn sie sich selbst aufruft
> 
>    m(…) ⇒ m(…)   direkt rekursiv
>    m(…) ⇒ n(…) ⇒ m(…)   indirekt rekursiv
> 
>    Viele Probleme (in der Informatik) lassen sich durch Rekursion
>    besonders einfach und elegant lösen
>    Schon die Beschreibung eines Problems kann iterativ oder rekursiv
>    geschehen
> 
> 9 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 10 ──
> Berechnung der Fakultät
>    rekursive Definition
>    iterative Definition
>    (n-1)! * n   für n > 1
>    n! = 1 * 2 * 3 * ... * (n-1) * n   n!=
>    1   für n = 1 und n = 0
> 
>    Iterative Methode zur Berechnung der Fakultät
>    long fact (int n) {
>    long result = 1;
>    for (int i = 2; i <= n; i++)
>    result *= i;
>    return result;
>    }
> 
>    Rekursive Methode zur Berechnung der Fakultät
>    long fact(int n) {   Allgemeines Muster
>    if (n == 0 || n == 1)
>    return 1;   if ( Problem klein genug )
>    else   nichtrekursiver Zweig
>    return fact(n - 1) * n;   else
>    }   rekursiver Zweig
> 
> 10 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 11 ──
> Ablauf einer rekursiven Methode (1): Fakultät
>    n==4   24
>    long fact(int n) {   Jede Aktivierung von fact hat ihr eigenes n
>    if (n == 0 || n == 1) return 1;
>    else return fact(n - 1) * n;
>    und rettet es über den rekursiven Aufruf
>    }   hinweg.
>    n==3   6
>    long fact(int n) {
>    if (n == 0 || n == 1) return 1;
>    else return fact(n - 1) * n;
>    }
>    n==2   2
>    long fact(int n) {
>    if (n == 0 || n == 1) return 1;
>    else return fact(n - 1) * n;
>    }
>    n==1   1
>    long fact(int n) {
>    if (n == 0 || n == 1) return 1;
>    else return fact(n - 1) * n;
>    }
> 11 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 12 ──
> Ablauf einer rekursiven Methode (2): Fakultät
>    long fact(int n) {
>    if (n == 0 || n == 1) return 1;
>    else return fact(n - 1) * n;
>    }
> 
> Beispiel: Aufruf von fact(4)
> Rekursiver Zweig:
>    1. fact(4) ruft fact(3) auf, bewahrt den Wert 4 in lokaler Variable n
>    2. fact(3) ruft fact(2) auf, bewahrt den Wert 3 in lokaler Variable n
>    (verschieden von n aus 1.)
>    3. fact(2) ruft fact(1) auf, bewahrt den Wert 2 in lokaler Variable n
>    (wiederum neue Variable)
>    Nicht rekursiver Zweig
>    – fact(1) gibt den Wert 1 zurück
>    – Auf dem Weg nach oben wird der vor dem rekursiven Aufruf ermittelte Wert
>    mit der jeweiligen lokalen Variablen n des Rufers multipliziert und das
>    Ergebnis weiter nach oben gegeben.
> 12 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 13 ──
> Größter gemeinsamer Teiler (ggT)
> 
>    Algorithmus:
>    Bestimme ggT von zwei positiven Zahlen,
>    z.B. von 24 und 15:
> 
>    24 : 15 = 1 Rest 9
>    15 : 9 = 1 Rest 6
>    9 : 6 = 1 Rest 3
>    6 : 3 = 2 Rest 0
> 
>    ggT = 3
> Immer: „größere durch kleinere Zahl“
> 
> 13 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 14 ──
> Beispiel: Größter gemeinsamer Teiler
> 
>    rekursiv   iterativ
> 
>    static int gcd(int x, int y) {   static int gcd(int x, int y) {
>    int rest = x % y;   int rest = x % y;
>    if (rest == 0) {   while (rest != 0){
>    return y;   x = y;
>    } else {   y = rest;
>    return gcd(y, rest);   rest = x % y;
>    }   }
>    }   return y;
>    }
> 
> 14 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 15 ──
> Vor- und Nachteile rekursiver Algorithmen
> 
>    Anmerkung
>    zu jedem rekursiv formulierten Algorithmus gibt es einen äquivalenten iterativen
>    Algorithmus
>    Vorteile rekursiver Algorithmen
>    kürzere Formulierung
>    leichter verständliche Lösung
>    Einsparung von Variablen
>    teilweise sehr effiziente Problemlösungen (z.B. Quicksort)
>    Bei rekursiven Datenstrukturen (zum Beispiel Bäume, Graphen) besonders
>    empfehlenswert
>    Nachteile rekursiver Algorithmen
>    oft weniger effizientes Laufzeitverhalten (Overhead bei Funktionsaufruf)
>    Verständnisprobleme bei Programmieranfängern
>    Konstruktion rekursiver Algorithmen "gewöhnungsbedürftig“
> 
> 15 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 16 ──
> Rekursion in Programmiersprachen
> 
>    Nicht alle Programmiersprachen unterstützen rekursive Algorithmen
>    Rekursion erlaubt:
>    ALGOL-Familie (ALGOL 60, Simula 67, ALGOL 68, PASCAL, MODULA-2, Ada)
>    viele Skriptsprachen: Python, Ruby, Javascript, …
>    C und C++
>    Java
>    C#
>    Rekursion nicht möglich:
>    FORTRAN
>    COBOL
>    LISP arbeitet überwiegend mit rekursiven Algorithmen
>    (gilt i.d.R. auch für PROLOG)
> 
> 16 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> ```
