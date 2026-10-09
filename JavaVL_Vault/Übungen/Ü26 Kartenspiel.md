---
tags: ["typ/uebung", "thema/enum", "kategorie/oop", "semester/2", "schwierigkeit/3", "hat/musterloesung"]
aliases: ["CardGame"]
thema: "[[26 Aufzählungstypen (Enums)]]"
klasse: "CardGame"
package: "de.dhbwka.java.exercise.enums.cards"
schwierigkeit: 3
status: "offen"
---

# Ü26 Kartenspiel

**Thema:** [[26 Aufzählungstypen (Enums)]] · **Bereich:** Aufzählungstypen · **Schwierigkeit:** ★★★☆☆
**Klasse:** `CardGame` · **Package:** `de.dhbwka.java.exercise.enums.cards`

📄 Aufgabe: [[Material/Aufgaben/26_Enum_Aufgaben.pdf#page=2|26_Enum_Aufgaben.pdf, S. 2]]
✅ Musterlösung: [[Material/Aufgaben/26_Enum_Aufgaben_Muster.pdf#page=3|26_Enum_Aufgaben_Muster.pdf, S. 3]]

> [!question] Kurz gesagt
> Implementieren Sie einige Grundlagen (Basisklassen) für ein Kartenspiel. Schreiben Sie eine Klasse PlayingCard.

## Aufgabenstellung
```text
Implementieren Sie einige Grundlagen (Basisklassen) für ein Kartenspiel.

Schreiben Sie eine Klasse PlayingCard. Eine Spielkarte besteht dabei aus einer Farbe (Karo, Herz,
Pik, Kreuz) sowie einem Kartenwert (7, 8, 9, Bube, Dame, König, 10, Ass).
Für die Farbe (Suit) und den Kartenwert (CardValue) können Sie Aufzählungstypen (enum)
verwenden.

Hinweis:
Farben in Englisch: Diamonds (Karo), Heart (Herz), Spade (Pik), Clubs (Kreuz)
Werte in Englisch: Ace (Ass), King (König), Queen (Dame), Jack (Bube)

Die Klasse PlayingCard sollte folgende Methoden haben:
    • String toString() – gibt die Spielkarte als String aus (Farbe und Kartenwert)
    • int compareTo(PlayingCard c) – vergleicht eine Spielkarte mit einer anderen
        (positiver/ negativer Rückgabewert entsprechend der Reihenfolge der Farben und
        Kartenwerte oben).
        Hinweis: Implementieren Sie dazu Comparable<PlayingCard>

Schreiben Sie eine Klasse CardGame, deren Objekte ein Kartenspiel (ein Stapel Karten) enthalten.
Die Klasse CardGame soll folgende Methoden haben:
    • Konstruktor CardGame() – erzeugt ein neues komplettes (ungemischtes) Kartenspiel
        (Stapel mit 32 Karten)
    • void shuffle() – mischt die Karten im Kartenspiel (Stapel)
    • void sort() – sortiert die Karten im Stapel aufsteigend (auch wenn schon welche
        entfernt wurden!) nach Farben und innerhalb der Farben nach Kartenwert
    • PlayingCard get() – gibt die „oberste“ Karte des Spiels (Stapels) zurück und entfernt
        sie aus dem Stapel
    • List<PlayingCard> all() – liefert eine Liste der (verbliebenen) Karten im Stapel

Schreiben Sie außerdem eine Klasse TestGame, die
    • ein neues Kartenspiel (Stapel) erzeugt,
    • es mischt,
    • nacheinander 10 Karten vom Stapel entnimmt, ausgibt (auf Bildschirm) und sie dabei mit
        der „Herz 7“ vergleicht (auch Vergleichsergebnis ausgeben),
    • die restlichen Karten sortiert
    • und auflistet (am Bildschirm)!
```

## Benötigte Begriffe
[[for-Schleife]] · [[Sortieren]] · [[Konstruktor]] · [[this]] · [[toString]] · [[Kapselung]] · [[Überschreiben]] · [[Interface]] · [[Enum]] · [[String]] · [[Wrapperklasse]] · [[Farben und Schriften]] · [[List]] · [[Stack]] · [[Comparable und Comparator]] · [[Collections-Klasse]]

## Weitere Übungen zum Thema
[[Ü26 Monate]] · [[Ü26 Sortierkriterien]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.enums.cards;
> 
> public enum Suit {
> 
>     DIAMONDS("Karo", 9),
>     HEART("Herz", 10),
>     SPADE("Pik", 11),
>     CLUBS("Kreuz", 12);
> 
>     private final String name;
>     private final int value;
> 
>     private Suit( String name, int value ) {
>         this.name = name;
>         this.value = value;
>     }
> 
>     @Override
>     public String toString() {
>         return this.name;
>     }
> 
>     public String getName() {
>         return this.name;
>     }
> 
>     public int getValue() {
>         return this.value;
>     }
> 
> }
> 
> // Continued on next page
> 
> Aufgaben Enum                                 Musterlösung                        3 / 13
> 
> package de.dhbwka.java.exercise.enums.cards;
> 
> public enum CardValue {
> 
>     SEVEN("7", "7"),
>     EIGHT("8", "8"),
>     NINE("9", "9"),
>     JACK("B", "Bube"),
>     QUEEN("D", "Dame"),
>     KING("K", "K\u00F6nig"),
>     TEN("10", "10"),
>     ACE("A", "Ass");
> 
>     private final String name;
>     private final String longName;
> 
>     private CardValue( String name, String longName ) {
>         this.name = name;
>         this.longName = longName;
>     }
> 
>     @Override
>     public String toString() {
>         return this.longName;
>     }
> 
>     public String getName() {
>         return this.name;
>     }
> 
>     public String getLongName() {
>         return this.longName;
>     }
> 
> }
> 
> // Continued on next page
> 
> Aufgaben Enum                                 Musterlösung           4 / 13
> 
> package de.dhbwka.java.exercise.enums.cards;
> 
> public class PlayingCard implements Comparable<PlayingCard> {
> 
>     private Suit suit;
>     private CardValue value;
> 
>     public PlayingCard() {
>     }
> 
>     public PlayingCard( Suit suit, CardValue value ) {
>         this.suit = suit;
>         this.value = value;
>     }
> 
>     @Override
>     public String toString() {
>         return this.suit + " " + this.value;
>     }
> 
>     @Override
>     public int compareTo( PlayingCard ok ) {
>         return (Integer.valueOf( this.getOrderValue() )
>         .compareTo( ok.getOrderValue() ));
>     }
> 
>     private int getOrderValue() {
>         return this.suit.ordinal() * 10 + this.value.ordinal();
>     }
> 
>     public Suit getSuit() {
>         return this.suit;
>     }
> 
>     public void setSuit( Suit suit ) {
>         this.suit = suit;
>     }
> 
>     public CardValue getValue() {
>         return this.value;
>     }
> 
>     public void setValue( CardValue value ) {
>         this.value = value;
>     }
> 
> }
> 
> Aufgaben Enum                                 Musterlösung           5 / 13
> 
> package de.dhbwka.java.exercise.enums.cards;
> 
> import java.util.ArrayList;
> import java.util.Collections;
> import java.util.List;
> 
> public class CardGame {
> 
>     private List<PlayingCard> deck;
> 
>     public CardGame() {
>         this.deck = new ArrayList<>();
>         for ( Suit f : Suit.values() ) {
>             for ( CardValue w : CardValue.values() ) {
>                 this.deck.add( new PlayingCard( f, w ) );
>             }
>         }
>     }
> 
>     public void shuffle() {
>         Collections.shuffle( this.deck );
>     }
> 
>     public void sort() {
>         Collections.sort( this.deck );
>     }
> 
>     public PlayingCard get() {
>         if ( this.deck.isEmpty() ) {
>             return null;
>         }
>         return this.deck.remove( 0 );
>     }
> 
>     public List<PlayingCard> all() {
>         return this.deck;
>     }
> 
> }
> 
> // Continued on next page
> 
> Aufgaben Enum                                 Musterlösung           6 / 13
> 
> package de.dhbwka.java.exercise.enums.cards;
> 
> public class TestGame {
> 
>     public static void main( String[] args ) {
>         CardGame deck = new CardGame();
>         deck.shuffle();
>         PlayingCard card = deck.get();
>         PlayingCard heartSeven = new PlayingCard( Suit.HEART, CardValue.SEVEN );
> 
>         System.out.println( "10 Karten ziehen und vergleichen:" );
>         for ( int i = 0; i < 10; i++ ) {
>             System.out.println( card + " verglichen mit " +
>             heartSeven + ": " + card.compareTo( heartSeven ) );
>             card = deck.get();
>         }
>         deck.sort();
> 
>         System.out.println( "\u00DCbrige Karten sortiert:" );
>         for ( PlayingCard cd : deck.all() ) {
>             System.out.println( cd );
>         }
>     }
> 
> }
> 
> Aufgaben Enum                                 Musterlösung                        7 / 13
> ```

## Meine Notizen

