---
tags: ["typ/thema", "thema/strings", "kategorie/grundlagen", "semester/1"]
aliases: ["Strings und Wrapperklassen", "Folien 10"]
semester: 1
kategorie: "Grundlagen"
folien: "[[Material/Folien/10_Strings_Wrapper.pdf]]"
seiten: 26
---

# 10 Strings und Wrapperklassen

← [[09 Klassen und Objekte]] · [[Start|🏠 Start]] · [[11 Methoden – Parameterübergabe und Rekursion]] →

> [!abstract] Worum geht's?
> Die Klasse String (Vergleich, Methoden, Formatierung), veränderliche Zeichenketten mit StringBuffer/StringBuilder sowie Wrapper-Klassen, Typumwandlungen und Autoboxing.

**Semester:** Programmieren I · **Bereich:** #kategorie/grundlagen · **Folien:** [[Material/Folien/10_Strings_Wrapper.pdf|10_Strings_Wrapper.pdf]] (26 Seiten)

## Gliederung der Folien
- [[Material/Folien/10_Strings_Wrapper.pdf#page=2|S. 2]] Die Klasse String
- [[Material/Folien/10_Strings_Wrapper.pdf#page=3|S. 3]] String-Objekte
- [[Material/Folien/10_Strings_Wrapper.pdf#page=4|S. 4]] Zeilenumbrüche und Stringausgabe
- [[Material/Folien/10_Strings_Wrapper.pdf#page=5|S. 5]] Eingabe von Strings
- [[Material/Folien/10_Strings_Wrapper.pdf#page=6|S. 6]] Strings verketten und vergleichen
- [[Material/Folien/10_Strings_Wrapper.pdf#page=8|S. 8]] Strings inhaltlich vergleichen
- [[Material/Folien/10_Strings_Wrapper.pdf#page=9|S. 9]] Strings lexikografisch oder Teile vergleichen
- [[Material/Folien/10_Strings_Wrapper.pdf#page=10|S. 10]] Vorsicht beim Vergleich von Strings mit \=\=
- [[Material/Folien/10_Strings_Wrapper.pdf#page=11|S. 11]] Methoden der Klasse String
- [[Material/Folien/10_Strings_Wrapper.pdf#page=14|S. 14]] Strings formatieren mit format
- [[Material/Folien/10_Strings_Wrapper.pdf#page=15|S. 15]] Strings formatieren mit Formatter-Klassen
- [[Material/Folien/10_Strings_Wrapper.pdf#page=16|S. 16]] Die Klasse StringBuffer
- [[Material/Folien/10_Strings_Wrapper.pdf#page=17|S. 17]] StringBuffer erzeugen und umwandeln
- [[Material/Folien/10_Strings_Wrapper.pdf#page=18|S. 18]] Methoden der Klasse StringBuffer
- [[Material/Folien/10_Strings_Wrapper.pdf#page=20|S. 20]] Die Klasse StringBuilder
- [[Material/Folien/10_Strings_Wrapper.pdf#page=21|S. 21]] Wrapper-Klassen
- [[Material/Folien/10_Strings_Wrapper.pdf#page=22|S. 22]] Wrapper-Klassen verwenden
- [[Material/Folien/10_Strings_Wrapper.pdf#page=23|S. 23]] Methoden der Wrapper-Klasse Integer
- [[Material/Folien/10_Strings_Wrapper.pdf#page=24|S. 24]] Beispiele
- [[Material/Folien/10_Strings_Wrapper.pdf#page=25|S. 25]] Übersicht: Konvertierung zwischen verschiedenen
- [[Material/Folien/10_Strings_Wrapper.pdf#page=26|S. 26]] Autoboxing

## Begriffe in diesem Kapitel
- [[Typkonversion]] (S. [[Material/Folien/10_Strings_Wrapper.pdf#page=25|25]])
- [[Formatierte Ausgabe]] (S. [[Material/Folien/10_Strings_Wrapper.pdf#page=4|4]], [[Material/Folien/10_Strings_Wrapper.pdf#page=14|14]], [[Material/Folien/10_Strings_Wrapper.pdf#page=15|15]])
- [[Scanner]] (S. [[Material/Folien/10_Strings_Wrapper.pdf#page=5|5]])
- [[Identität und Gleichheit]] (S. [[Material/Folien/10_Strings_Wrapper.pdf#page=8|8]], [[Material/Folien/10_Strings_Wrapper.pdf#page=9|9]], [[Material/Folien/10_Strings_Wrapper.pdf#page=10|10]])
- [[String]] (S. [[Material/Folien/10_Strings_Wrapper.pdf#page=2|2]], [[Material/Folien/10_Strings_Wrapper.pdf#page=3|3]], [[Material/Folien/10_Strings_Wrapper.pdf#page=4|4]], [[Material/Folien/10_Strings_Wrapper.pdf#page=5|5]], [[Material/Folien/10_Strings_Wrapper.pdf#page=6|6]], [[Material/Folien/10_Strings_Wrapper.pdf#page=7|7]])
- [[StringBuilder und StringBuffer]] (S. [[Material/Folien/10_Strings_Wrapper.pdf#page=16|16]], [[Material/Folien/10_Strings_Wrapper.pdf#page=17|17]], [[Material/Folien/10_Strings_Wrapper.pdf#page=18|18]], [[Material/Folien/10_Strings_Wrapper.pdf#page=19|19]], [[Material/Folien/10_Strings_Wrapper.pdf#page=20|20]])
- [[Wrapperklasse]] (S. [[Material/Folien/10_Strings_Wrapper.pdf#page=21|21]], [[Material/Folien/10_Strings_Wrapper.pdf#page=22|22]], [[Material/Folien/10_Strings_Wrapper.pdf#page=23|23]], [[Material/Folien/10_Strings_Wrapper.pdf#page=24|24]], [[Material/Folien/10_Strings_Wrapper.pdf#page=25|25]], [[Material/Folien/10_Strings_Wrapper.pdf#page=26|26]])
- [[Autoboxing]] (S. [[Material/Folien/10_Strings_Wrapper.pdf#page=26|26]])

## Kommt hier auch vor
[[Konstruktor]] · [[toString]]

## Übungen
- [ ] [[Ü10 Quersumme]] ★☆☆☆☆ ✅ Musterlösung
- [ ] [[Ü10 Palindrom]] ★★☆☆☆ ✅ Musterlösung
- [ ] [[Ü10 Römische Zahlen]] ★★☆☆☆ ✅ Musterlösung

## Relevant für diese Programmentwürfe
[[PE CHORona]] · [[PE ChatterGPT Validator]] · [[PE CoronaWarn]] · [[PE DBVasion]] · [[PE FakeTalk]] · [[PE SnatChat (Übungs-PE Oktober 2026)]] · [[PE SpeedyQuiz]]

## Verwandte Themen
[[04 Primitive Datentypen]] · [[05 Operatoren]] · [[11 Methoden – Parameterübergabe und Rekursion]]

## Folien ansehen
![[Material/Folien/10_Strings_Wrapper.pdf]]

## Folientext (durchsuchbar)
> [!quote]- Kompletter Folientext – aufklappen
> ```text
> ── Seite 1 ──
> Programmieren I
> Strings und Wrapperklassen
>    Heusch 7.3
>    Ratz 6.5.2
> 
> Institut für Automation und angewandte Informatik
> 
> KIT – Die Forschungsuniversität in der Helmholtz-Gemeinschaft www.kit.edu
> 
> ── Seite 2 ──
> Die Klasse String
>    Für Zeichenketten gibt es in Java die Klasse String
>    String ist kein primitiver Datentyp, sondern eine Klasse.
>    Die Klasse String besitzt Methoden zum Arbeiten mit Zeichenketten
>    Sonderform, Objekte müssen nicht mit new erzeugt werden.
>    Die Klasse String ist final, keine weiteren Klassen ableitbar.
>    Keine Setter-Methoden zum Ändern der gespeicherten Zeichenkette.
>    Daher werden String-Objekte auch immutable (unveränderbar)
>    bezeichnet.
>    Inhalt und Länge eines Strings sind immer konstant.
>    Die Zuweisung einer neuen Zeichenkette erzeugt ein neues String-
>    Objekt und gibt das alte frei.
>    Zeichenketten besteht aus Unicode-Zeichen.
>    Zeichenketten im Quellprogramm (Literale) werden in doppelte
>    Anführungszeichen eingeschlossen.
>    Die leere Zeichenkette "" hat die Länge 0.
> 2 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 3 ──
> String-Objekte
> 
>    Deklaration von String-Variablen und Erzeugung von Strings:
>    String identifier;
>    identifier = "Text";
> 
>    String identifier = "Text";
> 
>    Zuweisung einer neuen Zeichenkette:
>    String s = "Good bye";
>    // ...
>    s = new String("Auf Wiedersehen");
> 
>    s   Good Bye   s   Good Bye
> 
>    Auf Wiedersehen
> 
> 3 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 4 ──
> Zeilenumbrüche und Stringausgabe
> 
>    Mit der Escape-Sequenz "\n", die man als Text in einen
>    String eingeben kann, wird bei der Ausgabe des Strings
>    ein Zeilenumbruch erzeugt.
>    Strings mit der Methode System.out.printf ausgeben:
>    Neben der Methoden System.out.print und
>    System.out.println können Strings auch mit der Methode
>    System.out.printf ausgegeben werden:
>    String text = "rectangle";
>    int i = 4;
>    System.out.printf("A %s has %d corners.\n", text, i);
>    // auch %n möglich
> 
>    Ausgabe
>    A rectangle has 4 corners.
> 
> 4 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 5 ──
> Eingabe von Strings
> 
>    Für die Eingabe von Strings mit der Klasse
>    java.util.Scanner (vgl. Kapitel „Primitive Datentypen“)
>    hat diese Klasse u.a. die Methoden
>    String next()
>    Es werden die Zeichen bis zum nächsten Trennzeichen
>    (Leerzeichen, Tabulator, Zeilentrenner) eingelesen (ein Token).
>    String nextLine()
>    Es werden die Zeichen bis zum nächsten Zeilentrenner eingelesen.
> 
>    Beispiel für das Einlesen eines Token von der Standardeingabe:
>    java.util.Scanner scan = new java.util.Scanner(System.in);
>    String s = scan.next(); // Einlesen eines String Tokens
> 
> 5 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 6 ──
> Strings verketten und vergleichen (1)
> 
>    Strings verketten
>    String s1 = "Develop";   s1   Develop   s1   Develop
>    String s2 = "ment";
>    String s = s1 + s2;   s2
>    s2   ment   ment
>    Inhalte
>    kopieren
> 
>    s   Development
> 
>    String s1 = "Develop";   Development
>    String s2 = "ment";   Inhalte
>    kopieren
>    s1 = s1 + s2;   s2   ment   s2   ment
>    // oder: s1 += s2;
> 
>    s1   Develop   s1   Develop
> 
>    Wird vom GarbageCollector eingesammelt sofern keine andere Referenz besteht
> 
> 6 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 7 ──
> Strings verketten und vergleichen (2)
> 
>    Strings vergleichen
> 
>    Interne Verwaltung von Strings:
> 
>    Strings, deren Inhalt beim Compilieren bereits feststeht,
>    z.B. String s="Hallo", werden nur einmal angelegt (ein „String-
>    Pool“ wird erzeugt). Existieren während des Kompilierens weitere
>    Strings mit dem gleichen Inhalt, verweisen alle auf die gleiche
>    interne Zeichenkette "Hallo", d.h. auf dasselbe String-Objekt.
> 
>    Für Strings, die dynamisch, d.h. erst zur Laufzeit eines Programms,
>    gebildet werden, erzeugt Java immer ein neues separates String-
>    Objekt.
> 
> 7 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 8 ──
> Strings inhaltlich vergleichen
> 
>    Für den inhaltlichen Vergleich von Strings gibt es in der
>    Klasse String die Instanzmethoden:
>    boolean equals(Object o)
>    vergleicht die Inhalte von String-Objekten, d.h. die Zeichenketten
>    selbst, und liefert als Ergebnis entsprechend true oder false.
>    boolean equalsIgnoreCase(String s)
>    überprüft den String auf inhaltliche Gleichheit mit einem anderen
>    String, ignoriert aber die Groß-/Kleinschreibung.
>    String s1 = "text";
>    String s2 = new String("Text");
>    Ausgabe
> 
>    System.out.println(s1.equals(s2));   false
>    System.out.println(s1.equalsIgnoreCase(s2));   true
> 
> 8 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 9 ──
> Strings lexikografisch oder Teile vergleichen
> 
>    int compareTo(String s)
>    Mit dieser Methode können Strings lexikografisch verglichen
>    werden. Rückgabewerte sind 0 (bei Gleichheit) oder entsprechend
>    der lexikografischen Ordnung kleiner oder größer 0.
>    boolean contains(CharSequence s)
>    Diese Methode überprüft ob eine Zeichenkette in einer anderen
>    enthalten ist.
>    Beispiel:
>    String s1 = "text";
>    String s2 = new String("Text");
>    String s3 = new String("Context");
>    Ausgabe
> 
>    System.out.println(s1.compareTo(s2));   32
>    System.out.println(s2.compareTo(s1));   -32
>    System.out.println(s3.contains(s1));   true
>    System.out.println(s3.contains(s2));   false
> 9 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 10 ──
> Vorsicht beim Vergleich von Strings mit ==
>    String s1 = "Text";
>    String s2 = "Text";
>    String s3 = new String("Text");
>    String s4 = new String("Text");
>    Ausgabe
> 
>    System.out.println(s1==s2);   true
>    System.out.println(s2==s3);   false
>    System.out.println(s3==s4);   false
> 
>    Beim Vergleich von Referenzen auf String-Objekte mit dem
>    Operator == kann es unterschiedliche Ergebnisse geben:
>    Beim Vergleich von zwei identischen String-Literalen liefert == das
>    Ergebnis true, da es sich um Referenzen auf dasselbe String-
>    Objekt im String-Pool handelt
>    Werden Strings im Programm dynamisch mit identischem Inhalt
>    erzeugt, liefert der Vergleich der Referenzvariablen den Wert
>    false, da es sich um verschiedene String-Objekte handelt
> 
> 10 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 11 ──
> Methoden der Klasse String (1)
> 
>    char charAt(int index)
>    Liefert das Zeichen an der Position index
>    char c = "abc".charAt(1);
> 
>    boolean endsWith(String value)
>    Überprüft, ob der String mit value endet
>    String s1 = "Text";
>    if ( s1.endsWith("xt") ) { /*...*/ }
> 
>    int indexOf(String value)
>    Liefert den Index innerhalb eines Strings, an dem value
>    beginnt. Falls nicht vorhanden, wird -1 geliefert.
>    String s = "Application";
>    int i = s.indexOf("atio"); // liefert 6
> 
> 11 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 12 ──
> Methoden der Klasse String (2)
>    String s = "Application";
>    int length()
>    Liefert die Länge der Zeichenkette
>    int len = s.length(); // 11
> 
>    String replace(char oldC, char newC)
>    Ersetzt alle vorkommenden Zeichen oldC durch newC
>    String s2 = s.replace('c', 'k');
>    // nun sind s="Application" bzw. s2="Applikation"
> 
>    String substring(int s)
>    String substring(int s, int s1)
>    Liefert einen Teil-String beginnend beim Index s bis zum
>    Ende bzw. bis zu s1-1
>    String s3 = s.substring(2, 4);
>    // nun ist s3="pl"
> 
> 12 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 13 ──
> Methoden der Klasse String (3)
> 
>    static String valueOf(type var)
>    Liefert die String-Darstellung des Datentyps bzw. Objekts
> 
>    boolean matches(String regex)
>    ermittelt, ob ein String dem regulären   Ab Java 1.4
>    Ausdruck regex entspricht
> 
>    String replaceAll(String regex,
>    String replacement)
>    Ersetzt alle Vorkommen von regex   Ab Java 1.4
>    durch replacement. regex ist ein
>    regulärer Ausdruck
> 
> 13 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 14 ──
> Strings formatieren mit format
> 
>    Beispiel: Datum formatieren und ausgeben
>    GregorianCalendar date = new GregorianCalendar();
>    String s = String.format("Date: %04d,%02d,%02d",
>    date.get(Calendar.YEAR),
>    date.get(Calendar.MONTH) + 1, // month: 0 based
>    date.get(Calendar.DAY_OF_MONTH));
>    System.out.println(s);
> 
>    Ausgabe (für Silvester 2015)
>    Date: 2015,12,31
> 
>    Die Parameter für die Formatierung sind dabei dieselben
>    wie bei printf (siehe Folien zu Operatoren).
> 
> 14 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 15 ──
> Strings formatieren mit Formatter-Klassen
> 
>    Datumsformatierungen noch einfacher mit der Klasse
>    java.text.SimpleDateFormat
>    Angabe eines Musters („Pattern“) für die Ausgabe des Datums
>    SimpleDateFormat sdf = new SimpleDateFormat(“yyyy,MM,dd");
>    Date date = new Date();
>    System.out.println("Date: " + sdf.format(date));
>    yyyy   Jahr, 4-stellig
>    Ausgabe (für Silvester 2015)
>    MM   Monat, 2-stellig
>    Date: 2015,12,31
>    dd   Tag des Monats, 2-stellig
> 
>    Dokumentation der möglichen Pattern-Bestandteile:
>    https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/text/SimpleDateFormat.html
> 
>    Weitere Formatter-Klasse: java.text.DecimalFormat
>    Formatierte Ausgabe von Zahlen, bspw. maximale Anzahl von
>    Nachkommastellen
> 
> 15 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 16 ──
> Die Klasse StringBuffer
> 
>    Veränderliche Zeichenketten
>    Die Klasse String bietet keine Möglichkeit, einen String
>    nachträglich zu ändern. Ersetzt man z.B. Zeichen eines Strings,
>    wird immer ein neues String-Objekt erzeugt
>    Die Klasse StringBuffer stellt einen Datentyp bereit, bei dem
>    Strings verändert werden können und sich die Größe dynamisch
>    der gespeicherten Zeichenkette anpasst
> 
>    Eigenschaften der Klasse StringBuffer:
>    Verwalten und bearbeiten von veränderlichen Zeichenketten
>    Schnelligkeit, Faktor 10-20 schneller als Strings aufgrund der
>    dynamischen Verwaltung der Zeichenketten
>    Dynamische Anpassung des Puffers an die Größe des Strings,
>    (i.d.R. größer als die gespeicherte Zeichenkette)
> 
> 16 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 17 ──
> StringBuffer erzeugen und umwandeln
> 
>    StringBuffer();
>    Erzeugt ein StringBuffer-Objekt mit der vorgegebenen
>    Kapazität von 16 Zeichen und einer leeren Zeichenkette.
>    StringBuffer(int length);
>    Erzeugt einen StringBuffer mit der Initialkapazität von
>    length Zeichen.
>    StringBuffer(String str);
>    Eine Kopie von str wird im StringBuffer erzeugt. Die
>    Kapazität wird der Größe von str angepasst.
>    StringBuffer sb = new StringBuffer("Text");
>    String s = sb.toString();
>    s = new String(sb);
> 
> 17 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 18 ──
> Methoden der Klasse StringBuffer (1)
> 
>    StringBuffer append(type value)
>    value wird in einen String gewandelt und an den Puffer
>    angehängt.
>    StringBuffer s;
>    s = new StringBuffer();
>    s.append("1 + 2 = ");
>    s.append(1 + 2);
> 
>    int capacity()
>    Liefert die aktuelle Kapazität des Puffers.
>    char charAt(int index)
>    Liefert das Zeichen mit dem betreffenden Index.
>    void setCharAt(int index, char c)
>    Ändert das Zeichen mit dem betreffenden Index.
> 
> 18 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 19 ──
> Methoden der Klasse StringBuffer (2)
> 
>    StringBuffer insert(int index, type value)
>    Fügt ab der Position index die String-Repräsentation des
>    Parameters value ein
>    StringBuffer s = new StringBuffer();
>    s.append("1 + 2 = 3");
>    s.insert(0, "(");
>    s.insert(6, ")");
>    // im Puffer: "(1 + 2) = 3"
> 
>    int length()
>    Liefert die Länge des gespeicherten Strings
>    String toString()
>    Liefert die String-Repäsentation des Puffers
> 
> 19 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 20 ──
> Die Klasse StringBuilder
> 
>    Im JDK 5 wurde die Klasse StringBuilder ergänzt
>    Diese Klasse entspricht in der Funktionsweise der Klasse
>    StringBuffer
>    StringBuilder sind allerdings nicht synchronisiert. Das
>    bedeutet, dass sie nicht für den Zugriff von mehreren
>    Threads (gleichzeitig ausgeführten Programmmodulen)
>    geeignet sind
>    Da gleichzeitig ablaufende Programmmodule nicht
>    überwacht werden, ergeben sich in vielen
>    Anwendungsfällen durch den Einsatz der Klasse
>    StringBuilder nochmals Reduktionen der
>    Ausführungszeit (StringBuilder ist noch schneller als
>    StringBuffer)
>    Ab Java 1.5
> 
> 20 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 21 ──
> Wrapper-Klassen
> 
>    Viele Methoden innerhalb Java erwarten als Parameter
>    einen Object-Typ. Da von primitiven Datentypen keine
>    Objekte gebildet werden können, stellt Java für jeden
>    primitiven Datentyp eine so genannte Wrapper-Klasse.
>    Die Klassen besitzen ein gekapseltes Attribut, das den
>    Wert speichert und Methoden um beispielsweise den
>    entsprechenden primitiven Datentyp oder eine
>    Konvertierung von String-Typen in den betreffenden
>    Datentyp vorzunehmen.
>    Wrapper-Klassen im package java.lang:
>    Void
>    Byte   Short   Integer   Long
>    Float   Double
>    Boolean   Heusch 7.4
>    Character   Ratz 12.2
> 
> 21 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 22 ──
> Wrapper-Klassen verwenden
> 
>    Am Beispiel der Wrapper Klasse Integer werden im
>    Folgenden einige Methoden und Konstruktoren der
>    Klassen vorgestellt.
>    Für die anderen Wrapper-Klassen der anderen primitiven
>    Datentypen existieren ähnliche Methoden.
>    Informationen hierzu findet man in der Java-Dokumentation
>    (https://docs.oracle.com/en/java/javase/index.html)
>    Konstruktor der Wrapper-Klasse:
>    Mit new wird ein Objekt der betreffenden Wrapper-Klasse erstellt.
>    Dazu stehen mehrere Konstruktoren zur Verfügung.
>    Integer(int value)   Der Wert des Integer-Objektes kann im Konstruktor als
>    Integer(String s)   int oder als String angegeben werden. Der
>    Konstruktor versucht den String s in einen int-Wert
>    zu konvertieren. Ist dies nicht möglich tritt ein
>    Laufzeitfehler ein (NumberFormatException)
> 22 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 23 ──
> Methoden der Wrapper-Klasse Integer
> 
>    Methode   Beschreibung
>    Diese Methode liefert den gespeicherten int-Wert
> int intValue()
>    zurück
>    Versucht den String s in einen int-Wert zu
>    konvertieren. Falls eine Konvertierung nicht
> static int parseInt(String s)
>    möglich ist, wird eine
>    NumberFormatException ausgelöst.
>    Liefert einen String zurück, der den
> String toString()
>    gespeicherten Wert repräsentiert.
>    Liefert einen String zurück, der den Wert von
> static String toString(int value)
>    value repräsentiert.
>    Erzeugt mit dem Wert von value ein Integer-
> static Integer valueOf(int value)
>    Objekt und liefert dieses zurück.
>    Versucht den String s in einen int-Wert zu
>    konvertieren, erzeugt mit diesem Wert ein
> static Integer valueOf(String s) Integer-Objekt und liefert dieses zurück. Falls
>    eine Konvertierung nicht möglich ist, wird eine
>    NumberFormatException ausgelöst.
> 
> 23 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 24 ──
> Beispiele
> 
> Integer i1 = new Integer(10); // neues Integer-Objekt mit Wert 10
> Integer i2 = new Integer("12"); // neues Integer-Objekt mit Wert 12
> Integer i3 = Integer.valueOf("24"); // neues Integer-Objekt mit Wert 24
> int i = i1.intValue(); // gespeicherten int-Wert von i1 liefern
> int j = Integer.parseInt("35"); // Stringkonvertierung nach int
> String s1 = i2.toString(); // int-Wert von i2 in einen String umwandeln
> String s2 = Integer.toString(74); // Umwandlung einer int-Zahl in einen String
> 
>    Die Wrapper-Klassen besitzen keine Methoden zum
>    Ändern des gespeicherten Wertes (Setter-Methoden).
>    Durch die Verwendung von Wrapper-Klassen können
>    keine Parameter an Methoden übergeben werden, die
>    veränderlich sind
>    Die Erzeugung von Wrapper-Instanzen mit dem
>    Konstruktor ist seit Java 9 deprecated  Nutzung der
>    statischen valueOf-Methoden empfohlen!
> 24 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 25 ──
> Übersicht: Konvertierung zwischen verschiedenen
>    Datentypen, am Beispiel von int / Integer / String
> 
>    Integer.valueOf(int)
> 
>    int   Integer
>    Objektreferenz.intValue()
> 
>    String
> 
>    Konstruktoren mit Typumwandlungen sind hier nicht aufgeführt.
>    Bei Klassen-Methoden ist die Klasse angegeben.
>    Bei Instanzmethoden wird über eine entspr. Objektreferenz aufgerufen.
> 25 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 26 ──
> Autoboxing
> 
>    Die Konvertierung in ein Objekt der entsprechenden
>    Wrapper-Klasse wird Boxing genannt.
>    Die Rückumwandlung in einen primitiven Datentyp heißt
>    Unboxing.
>    Ab Java 5 gibt es eine automatische   Ab Java 1.5
>    Umwandlung (Autoboxing).
>    Vereinfachte Schreibweise
>    Ausführliche Schreibweise
>    mit Autoboxing
> 
>    int i = 10;   int i = 10;
> 
>    Boxing   Integer j = Integer.valueOf(i);   Integer j = i;
> 
>    Unboxing   int k = j.intValue();   int k = j;
> 
> 26 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> ```
