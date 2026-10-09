---
tags: ["typ/uebung", "thema/datenstrukturen", "kategorie/datenstrukturen", "semester/2", "schwierigkeit/4", "hat/musterloesung"]
aliases: ["BinaryTree"]
thema: "[[25 Datenstrukturen und Generics]]"
klasse: "BinaryTree"
package: "de.dhbwka.java.exercise.collections"
schwierigkeit: 4
status: "offen"
---

# Ü25 Binärbaum

**Thema:** [[25 Datenstrukturen und Generics]] · **Bereich:** Datenstrukturen (2) · **Schwierigkeit:** ★★★★☆
**Klasse:** `BinaryTree` · **Package:** `de.dhbwka.java.exercise.collections`

📄 Aufgabe: [[Material/Aufgaben/25_Datenstrukturen_Aufgaben-2.pdf#page=1|25_Datenstrukturen_Aufgaben-2.pdf, S. 1]]
✅ Musterlösung: [[Material/Aufgaben/25_Datenstrukturen_Aufgaben-2_Muster.pdf#page=1|25_Datenstrukturen_Aufgaben-2_Muster.pdf, S. 1]]

> [!question] Kurz gesagt
> Im Foliensatz zu „Datenstrukturen“ gibt es eine Folie „Unsere erste generische Klasse“, in der eine Klasse MyLinkedList\<T\> vorgestellt wird. Schreiben Sie nach diesem Vorbild eine Klasse BinaryTree\<T\>, die einen Knoten in einem Binärbaum beschreiben soll. (Eine Referenz auf die Wurzel erreicht also den ganzen Baum.) • Jeder BinaryTree\<T\> soll einen Wert vom Typ T speichern können • Jeder …

## Aufgabenstellung
```text
Im Foliensatz zu „Datenstrukturen“ gibt es eine Folie „Unsere erste generische Klasse“, in der eine
Klasse MyLinkedList<T> vorgestellt wird.

Schreiben Sie nach diesem Vorbild eine Klasse BinaryTree<T>, die einen Knoten in einem
Binärbaum beschreiben soll. (Eine Referenz auf die Wurzel erreicht also den ganzen Baum.)
    • Jeder BinaryTree<T> soll einen Wert vom Typ T speichern können
    • Jeder BinaryTree<T> hat genau zwei Nachfolger: left und right
        (Jeder Nachfolger darf auch null sein)
    • T soll mindestens das Interface Comparable implementieren (s. „Kovarianz“):
        T extends Comparable<T>

Für jeden Knoten k im Binärbaum soll gelten:
    • Der Wert von k muss definiert sein (!=null) , sobald k einen linken und/oder rechten
        Nachfolger (!=null) hat
    • Hat k einen Nachfolger left (!=null), so ist dessen Wert echt kleiner als der von k oder
        (noch) nicht gesetzt
    • Hat k einen Nachfolger right (!=null), so ist dessen Wert echt größer als der von k oder
        (noch) nicht gesetzt

Korollar: In diesem Binärbaum gibt es keine Duplikate.

BinaryTree<T> soll folgende Methoden zur Verfügung stellen:

public boolean add(T newValue)
fügt einen neuen Wert nach den obigen Regeln in den Binärbaum ein, sofern dieser noch nicht
vorhanden ist. Ist der Wert bereits vorhanden, wird false zurückgegeben, sonst true.

public T getValue()
liefert den Wert eines Knotens zurück.

public List<T> traverse()
traversiert den Baum und liefert eine sortierte (!) Liste aller enthaltenen Werte zurück.
Hinweis: Wählen Sie den Algorithmus der Traversierung so, dass „automatisch“ eine sortierte Liste
entsteht. Collections.sort ist hier verboten!

Testen Sie Ihre Klasse:
    1. Erzeugen Sie einen leeren Binärbaum!
    2. Fügen Sie 10 Zufallszahlen ein (und geben sie diese zur Kontrolle auf der Konsole aus).
        Hinweis: Wählen oder erzeugen Sie einen geeigneten Datentyp dafür!
    3. Traversieren Sie den Baum und geben das Ergebnis ebenfalls auf der Konsole aus!
```

## Benötigte Begriffe
[[Zufallszahlen]] · [[for-Schleife]] · [[Sortieren]] · [[this]] · [[toString]] · [[Kapselung]] · [[Vererbung]] · [[Interface]] · [[String]] · [[List]] · [[Comparable und Comparator]] · [[Collections-Klasse]] · [[Generics]] · [[Wildcards und Varianz]] · [[Binärbaum]]

## Weitere Übungen zum Thema
[[Ü25 Ziehung der Lottozahlen]] · [[Ü25 Bücherei]] · [[Ü25 Tankstellenpreise]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.collections;
> 
> import java.util.LinkedList;
> import java.util.List;
> 
> public class BinaryTree<T extends Comparable<T>> {
> 
>     private T value;
>     private BinaryTree<T> left;
>     private BinaryTree<T> right;
> 
>     public BinaryTree() {
>     }
> 
>     /**
>      * Recursive adding of newValue (no duplicates allowed).
>      *
>      * @param newValue
>      *            new value to add
>      *
>      * @return <code>true</code> if value has been added, <code>false</code>
>      *          otherwise
>      */
>     public boolean add( T newValue ) {
>         if ( this.value == null ) {
>             this.value = newValue;
>         } else if ( this.value.compareTo( newValue ) == 0 ) {
>             return false;
>         } else if ( this.value.compareTo( newValue ) > 0 ) {
>             return this.getLeft().add( newValue );
>         } else if ( this.value.compareTo( newValue ) < 0 ) {
>             return this.getRight().add( newValue );
>         }
>         return true;
>     }
> 
>     // Continued on next page
> 
>     /**
>      * Get the node's value
>      */
>     public T getValue() {
>         return this.value;
>     }
> 
>     /**
>      * Get left node, if none is present (<code>this.left==null</code>) create a
>      * new node
>      *
>      * @return left
>      */
>     private BinaryTree<T> getLeft() {
>         if ( this.left == null ) {
>             this.left = new BinaryTree<>();
>         }
>         return this.left;
>     }
> 
>     /**
>      * Get right node, if none is present (<code>this.left==null</code>) create a
>      * new node
>      *
>      * @return right
>      */
>     private BinaryTree<T> getRight() {
>         if ( this.right == null ) {
>             this.right = new BinaryTree<>();
>         }
>         return this.right;
>     }
> 
>     /**
>      * Traverse BinaryTree in ascending order and
>      *
>      * @return all values in an ordered List<T>
>      */
>     public List<T> traverse() {
>         List<T> l = new LinkedList<>();
>         this.doTraverse( l );
>         return l;
>     }
> 
>     // Continued on next page
> 
>     /**
>      * Traverse BinaryTree in ascending order and add all values to list.
>      *
>      * @param list
>      *            list to add values to
>      */
>     private void doTraverse( List<T> list ) {
>         if ( this.left != null ) {
>             this.left.doTraverse( list );
>         }
>         if ( this.value != null ) {
>             list.add( this.value );
>         }
>         if ( this.right != null ) {
>             this.right.doTraverse( list );
>         }
>     }
> 
> }
> 
> package de.dhbwka.java.exercise.collections;
> 
> import java.util.Random;
> 
> public class BinaryTreeTest {
> 
>     public static void main( String[] args ) {
>         Random rnd = new Random();
> 
>         BinaryTree<Integer> tree = new BinaryTree<>();
> 
>         for ( int i = 0; i < 10; i++ ) {
>             Integer newInt = rnd.nextInt( 20 );
>             System.out.print( newInt );
>             System.out.println( " " + tree.add( newInt ) );
>         }
> 
>         System.out.println( "------------" );
>         for ( Integer t : tree.traverse() ) {
>             System.out.println( t.toString() );
>         }
>     }
> 
> }
> ```

## Meine Notizen

