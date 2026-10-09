---
tags: ["typ/uebung", "thema/java8", "kategorie/funktional", "semester/2", "schwierigkeit/3", "hat/musterloesung"]
aliases: ["Soccer"]
thema: "[[33 Java 8 – Lambdas, Streams, NIO.2]]"
klasse: "Soccer"
package: "de.dhbwka.java.exercise.java8.soccer"
schwierigkeit: 3
status: "offen"
---

# Ü33 Arbeiten mit Streams

**Thema:** [[33 Java 8 – Lambdas, Streams, NIO.2]] · **Bereich:** Java 8 · **Schwierigkeit:** ★★★☆☆
**Klasse:** `Soccer` · **Package:** `de.dhbwka.java.exercise.java8.soccer`

📄 Aufgabe: [[Material/Aufgaben/33_Java8_Aufgaben.pdf#page=1|33_Java8_Aufgaben.pdf, S. 1]]
✅ Musterlösung: [[Material/Aufgaben/33_Java8_Aufgaben_Muster.pdf#page=1|33_Java8_Aufgaben_Muster.pdf, S. 1]]
📦 Zusatzdateien: [33_Java8_Aufgaben_TeamDE.txt](<Material/Projekte/33_Java8_Aufgaben_TeamDE/33_Java8_Aufgaben_TeamDE.txt>)

> [!question] Kurz gesagt
> a) Schreiben Sie eine Applikation zur „Analyse“ des deutschen Kaders bei der Fußball- Europameisterschaft der Herren 2024. Schreiben Sie hierfür zunächst eine Klasse Player, welche die Daten für einen einzelnen Spieler als Instanz-Attribute enthält:  Trikotnummer (int number)  Name (String name)  Position (String position)  Geburtsdatum (String birthday)  Verein (String club)  Anzahl der …

## Aufgabenstellung
```text
a) Schreiben Sie eine Applikation zur „Analyse“ des deutschen Kaders bei der Fußball-
Europameisterschaft der Herren 2024.

Schreiben Sie hierfür zunächst eine Klasse Player, welche die Daten für einen einzelnen Spieler als
Instanz-Attribute enthält:
     Trikotnummer (int number)
     Name (String name)
     Position (String position)
     Geburtsdatum (String birthday)
     Verein (String club)
     Anzahl der Länderspiele (int games)
     Anzahl der Länderspiel-Tore (int goals)

Natürlich sind sämtliche Instanz-Attribute privat, von außen über Getter-Methoden auslesbar. Die
Werte können per Konstruktor gesetzt werden. Schreiben Sie ebenso eine toString-Methode,
welche sämtliche der Werte ausgibt.

Schreiben Sie nun eine Klasse Soccer, deren main-Methode die bereitgestellte CSV-Datei (siehe
Download zum Aufgabenblatt) mit allen Spielern des deutschen Kaders einliest. Die Reihenfolge der
Werte in der CSV-Datei stimmt mit der obigen Attribut-Liste überein, Trenner ist ein Semikolon.

Nutzen Sie für das Einlesen der Datei die Klasse java.nio.file.Files und verarbeiten sie jede
Zeile mittels Java 8-Streams um daraus eine Liste mit Player-Objekten zu erzeugen (vgl. Bücherei-
Beispiel am Ende der Java 8-Folien).

Schreiben Sie nun Methoden, welche jeweils zwei Player-Objekte entgegennehmen und
entsprechend Ihrem Namen eine Vergleichsoperation durchführen:
        static int comparePlayerByNumber( Player p1, Player p2 )
        static int comparePlayerByName( Player p1, Player p2 )

Geben Sie nun folgende Spielerlisten auf die Konsole aus:
    Alle Spieler, sortiert nach Rückennummer
    Alle Spieler, mit mehr als 50 Länderspielen, sortiert nach (Vor-)Name
    Sämtliche Clubs der Spieler, wobei jeder Club nur genau 1x ausgegeben werden soll

Geben Sie ebenso aus
    wie viele der Spieler weniger als 5 Tore geschossen haben und
    wie viele Tore alle Spieler des Kaders insgesamt erzielt haben.

Für alle Ausgaben gilt: Nutzen Sie die Streaming API und Lambda-Expressions! Keine klassischen
Schleifen, keine Zwischenergebnisse als Listen, keine Sets!

b) Ersetzen Sie in einer zweiten Variante die Klasse Player durch einen (Java 14) record!

                                           Beispielausgabe

Players sorted by number:
  1 | Manuel Neuer, Torwart, 27.03.1986, FC Bayern München, 124 games, 0 goals
  2 | Antonio Rüdiger, Abwehr, 03.03.1993, Real Madrid, 82 games, 3 goals
  3 | Waldemar Anton, Abwehr, 20.07.1996, Borussia Dortmund, 12 games, 0 goals
  4 | Jonathan Tah, Abwehr, 11.02.1996, FC Bayern München, 45 games, 1 goals
  5 | Aleksandar Pavlovic, Abwehr, 03.05.2004, FC Bayern München, 9 games, 1 goals
  6 | Joshua Kimmich, Abwehr, 08.02.1995, FC Bayern München, 108 games, 10 goals
  7 | Kai Havertz, Sturm, 11.06.1999, Arsenal FC, 57 games, 21 goals
  8 | Leon Goretzka, Mittelfeld, 06.02.1995, FC Bayern München, 69 games, 15 goals
  9 | Jamie Leweling, Sturm, 26.02.2001, VfB Stuttgart, 4 games, 1 goals
 10 | Jamal Musiala, Mittelfeld, 26.02.2003, FC Bayern München, 40 games, 8 goals
 11 | Nick Woltemade, Sturm, 14.02.2002, Newcastle United, 10 games, 4 goals
 12 | Oliver Baumann, Torwart, 02.06.1990, TSG Hoffenheim, 11 games, 0 goals
 13 | Pascal Groß, Abwehr, 15.06.1991, Brighton Hove & Albion, 18 games, 1 goals
 14 | Maximilian Beier, Sturm, 17.10.2002, Borussia Dortmund, 7 games, 0 goals
 15 | Nico Schlotterbeck, Abwehr, 01.12.1999, Borussia Dortmund, 25 games, 0 goals
 16 | Angelo Stiller, Mittelfeld, 04.04.2001, VfB Stuttgart, 7 games, 0 goals
 17 | Florian Wirtz, Mittelfeld, 03.05.2003, FC Liverpool, 39 games, 10 goals
 18 | Nathaniel Brown, Abwehr, 16.06.2003, Eintracht Frankfurt, 3 games, 0 goals
 19 | Leroy Sané, Sturm, 11.01.1996, Galatasaray Istanbul, 74 games, 16 goals
 20 | Nadiem Amiri, Mittelfeld, 27.10.1996, 1.FSV Mainz 05, 9 games, 1 goals
 21 | Alexander Nübel, Torwart, 30.09.1996, VfB Stuttgart, 3 games, 0 goals
 22 | David Raum, Abwehr, 22.04.1998, RB Leipzig, 36 games, 1 goals
 23 | Felix Nmecha, Abwehr, 10.10.2000, Borussia Dortmund, 6 games, 1 goals
 24 | Malick Thiaw, Abwehr, 08.08.2001, Newcastle United, 5 games, 0 goals
 25 | Lennart Karl, Sturm, 22.02.2008, FC Bayern München, 2 games, 0 goals
 26 | Deniz Undav, Sturm, 19.07.1996, VfB Stuttgart, 7 games, 4 goals
-----
Players with more than 50 games, sorted by name:
  2 | Antonio Rüdiger, Abwehr, 03.03.1993, Real Madrid, 82 games, 3 goals
  6 | Joshua Kimmich, Abwehr, 08.02.1995, FC Bayern München, 108 games, 10 goals
  7 | Kai Havertz, Sturm, 11.06.1999, Arsenal FC, 57 games, 21 goals
  8 | Leon Goretzka, Mittelfeld, 06.02.1995, FC Bayern München, 69 games, 15 goals
 19 | Leroy Sané, Sturm, 11.01.1996, Galatasaray Istanbul, 74 games, 16 goals
  1 | Manuel Neuer, Torwart, 27.03.1986, FC Bayern München, 124 games, 0 goals
-----
All clubs of the players:
FC Bayern München
TSG Hoffenheim
VfB Stuttgart
Borussia Dortmund
Eintracht Frankfurt
Brighton Hove & Albion
RB Leipzig
Real Madrid
Newcastle United
1.FSV Mainz 05
FC Liverpool
Arsenal FC
Galatasaray Istanbul
-----
Count of players with less than 5 goals: 20
Count of goals of all players: 98
```

## Benötigte Begriffe
[[Typkonversion]] · [[Formatierte Ausgabe]] · [[Array]] · [[Sortieren]] · [[Konstruktor]] · [[this]] · [[static]] · [[toString]] · [[Kapselung]] · [[Überschreiben]] · [[super]] · [[Record]] · [[String]] · [[Wrapperklasse]] · [[Exception]] · [[Datei und Pfad]] · [[List]] · [[Comparable und Comparator]] · [[Lambda-Ausdruck]] · [[Methodenreferenz]] · [[Stream-API]]

## Weitere Übungen zum Thema
[[Ü33 Zahlenraten (3)]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> a)
> package de.dhbwka.java.exercise.java8.soccer;
> 
> public class Player {
> 
>     /**
>      * Number of player
>      */
>     private final int number;
> 
>     /**
>      * Name of player
>      */
>     private final String name;
> 
>     /**
>      * Position of player
>      */
>     private final String position;
> 
>     /**
>      * Birthday of player
>      */
>     private final String birthday;
> 
>     /**
>      * Club of player
>      */
>     private final String club;
> 
>     /**
>      * Games of player
>      */
>     private final int games;
> 
>     /**
>      * Goals of player
>      */
>     private final int goals;
> 
>     Aufgaben Java 8                               Musterlösung                        1 / 13
> 
>     /**
>      * Create player
>      *
>      * @param number number of the player
>      * @param name name of the player
>      * @param position position of the player
>      * @param birthday birthday of the player
>      * @param club club of the player
>      * @param games games of the player
>      * @param goals goals of the player
>      */
>     public Player( int number, String name, String position, String birthday,
>     String club, int games, int goals ) {
>         super();
>         this.number = number;
>         this.name = name;
>         this.position = position;
>         this.birthday = birthday;
>         this.club = club;
>         this.games = games;
>         this.goals = goals;
>     }
> 
>     /**
>      * Get the number of the player
>      * @return number of the player
>      */
>     public int getNumber() {
>         return this.number;
>     }
> 
>     /**
>      * Get the name of the player
>      * @return name of the player
>      */
>     public String getName() {
>         return this.name;
>     }
> 
>     /**
>      * Get the position of the player
>      * @return position of the player
>      */
>     public String getPosition() {
>         return this.position;
>     }
> 
>     /**
>      * Get the birthday of the player
>      * @return birthday of the player
>      */
>     public String getBirthday() {
>         return this.birthday;
>     }
> 
>     Aufgaben Java 8                               Musterlösung                      2 / 13
> 
>     /**
>      * Get the club of the player
>      * @return club of the player
>      */
>     public String getClub() {
>         return this.club;
>     }
> 
>     /**
>      * Get the games of the player
>      * @return games of the player
>      */
>     public int getGames() {
>         return this.games;
>     }
> 
>     /**
>      * Get the goals of the player
>      * @return goals of the player
>      */
>     public int getGoals() {
>         return this.goals;
>     }
> 
>     /**
>      * {@inheritDoc}
>      */
>     @Override
>     public String toString() {
>         return String.format( "%3d", this.number ) + " | " + this.name + ", "
>         + this.position + ", " + this.birthday + ", " + this.club + ", "
>         + this.games + " games, " + this.goals + " goals";
>     }
> 
> }
> 
> package de.dhbwka.java.exercise.java8.soccer;
> 
> import java.io.IOException;
> import java.nio.charset.StandardCharsets;
> import java.nio.file.Files;
> import java.nio.file.Path;
> import java.nio.file.Paths;
> import java.util.Comparator;
> import java.util.List;
> import java.util.Objects;
> import java.util.stream.Collectors;
> 
> public class Soccer {
> 
>     /**
>      * Application entry point
>      *
>      * @param args
>      *            command line arguments
>      */
>     public static void main( String[] args ) {
>         try {
>             Path path = Paths.get( "33_Java8_Aufgaben_TeamDE.txt" );
> 
>             List<Player> players =
>             Files.readAllLines( path, StandardCharsets.UTF_8 )
>             .stream().map( Soccer::parsePlayer )
>             .filter( Objects::nonNull )
>             .collect( Collectors.toList() );
> 
>             System.out.println( "Players sorted by number:" );
>             players.stream().sorted( Soccer::comparePlayerByNumber )
>             .forEach( System.out::println );
> 
>             System.out.println( "-----" );
>             System.out
>             .println( "Players with more than 50 games, sorted by name:" );
>             players.stream().filter( p -> p.getGames() > 50 )
>             .sorted( Soccer::comparePlayerByName )
>             .forEach( System.out::println );
> 
>             System.out.println( "-----" );
>             System.out.println( "All clubs of the players:" );
>             players.stream().map( Player::getClub ).distinct()
>             .forEach( System.out::println );
> 
>             System.out.println( "-----" );
>             System.out.println( "Count of players with less than 5 goals: "
>             + players.stream().filter( p -> p.getGoals() < 5 ).count() );
>             System.out.println( "Count of goals of all players: "
>             + players.stream().mapToInt( Player::getGoals ).sum() );
>         } catch ( IOException e ) {
>             e.printStackTrace();
>         }
>     }
> 
>     // continued on next page
> 
>     Aufgaben Java 8                               Musterlösung                          4 / 13
> 
>     /**
>      * Parse player from CSV line
>      *
>      * @param line
>      *            line to parse
>      * @return created player instance
>      */
>     public static Player parsePlayer( String line ) {
>         String[] p = line.split( ";" );
> 
>         if ( p.length == 7 ) {
>             return new Player( Integer.parseInt( p[0] ), p[1], p[2], p[3], p[4],
>             Integer.parseInt( p[5] ), Integer.parseInt( p[6] ) );
>         } else {
>             return null;
>         }
>     }
> 
>     /**
>      * Compare player by number
>      *
>      * @param p1
>      *            player 1
>      * @param p2
>      *            player 2
>      * @return result for {@link Comparator#compare(Object, Object) comparison}
>      *          of number of the players
>      */
>     public static int comparePlayerByNumber( Player p1, Player p2 ) {
>         return p1.getNumber() - p2.getNumber();
>     }
> 
>     /**
>      * Compare player by name
>      *
>      * @param p1
>      *            player 1
>      * @param p2
>      *            player 2
>      * @return result for {@link Comparator#compare(Object, Object) comparison}
>      *          of name of the players
>      */
>     public static int comparePlayerByName( Player p1, Player p2 ) {
>         return p1.getName().compareTo( p2.getName() );
>     }
> 
> }
> 
> Aufgaben Java 8                               Musterlösung                         5 / 13
> 
> b) Für diesen Teil der Lösung müssen Sie mindestens Java 14 intsalliert/aktiviert haben!
> 
> package de.dhbwka.java.exercise.java8.soccer.b;
> 
> public record Player ( int number, String name, String position, String birthday,
> String club, int games, int goals ) { }
> 
> package de.dhbwka.java.exercise.java8.soccer.b;
> 
> import java.io.IOException;
> import java.nio.charset.StandardCharsets;
> import java.nio.file.Files;
> import java.nio.file.Path;
> import java.nio.file.Paths;
> import java.util.Comparator;
> import java.util.List;
> import java.util.Objects;
> import java.util.stream.Collectors;
> 
> public class Soccer {
> 
>     /**
>      * Application entry point
>      *
>      * @param args
>      *            command line arguments
>      */
>     public static void main( String[] args ) {
>         try {
>             Path path = Paths.get( "33_Java8_Aufgaben_TeamDE.txt" );
> 
>             List<Player> players =
>             Files.readAllLines( path, StandardCharsets.UTF_8 )
>             .stream().map( Soccer::parsePlayer )
>             .filter( Objects::nonNull )
>             .collect( Collectors.toList() );
>             // continued on next page
> 
>             Aufgaben Java 8                                  Musterlösung                              6 / 13
> 
>             System.out.println( "Players sorted by number:" );
>             players.stream().sorted( Soccer::comparePlayerByNumber )
>             .forEach( System.out::println );
> 
>             System.out.println( "-----" );
>             System.out
>             .println( "Players with more than 50 games, sorted by name:" );
>             players.stream().filter( p -> p.games() > 50 )
>             .sorted( Soccer::comparePlayerByName )
>             .forEach( System.out::println );
> 
>             System.out.println( "-----" );
>             System.out.println( "All clubs of the players:" );
>             players.stream().map( Player::club ).distinct()
>             .forEach( System.out::println );
> 
>             System.out.println( "-----" );
>             System.out.println( "Count of players with less than 5 goals: "
>             + players.stream().filter( p -> p.goals() < 5 ).count() );
>             System.out.println( "Count of goals of all players: "
>             + players.stream().mapToInt( Player::goals ).sum() );
>         } catch ( IOException e ) {
>             e.printStackTrace();
>         }
>     }
> 
>     /**
>      * Parse player from CSV line
>      *
>      * @param line
>      *            line to parse
>      * @return created player instance
>      */
>     public static Player parsePlayer( String line ) {
>         String[] p = line.split( ";" );
> 
>         if ( p.length == 7 ) {
>             return new Player( Integer.parseInt( p[0] ), p[1], p[2], p[3], p[4],
>             Integer.parseInt( p[5] ), Integer.parseInt( p[6] ) );
>         } else {
>             return null;
>         }
>     }
> 
>     /**
>      * Compare player by number
>      *
>      * @param p1
>      *            player 1
>      * @param p2
>      *            player 2
>      * @return result for {@link Comparator#compare(Object, Object) comparison}
>      *          of number of the players
>      */
>     public static int comparePlayerByNumber( Player p1, Player p2 ) {
>         return p1.number() - p2.number();
>     }
> 
>     Aufgaben Java 8                               Musterlösung                          7 / 13
> 
>     /**
>      * Compare player by name
>      *
>      * @param p1
>      *            player 1
>      * @param p2
>      *            player 2
>      * @return result for {@link Comparator#compare(Object, Object) comparison}
>      *          of name of the players
>      */
>     public static int comparePlayerByName( Player p1, Player p2 ) {
>         return p1.name().compareTo( p2.name() );
>     }
> 
> }
> 
> Aufgaben Java 8                               Musterlösung                         8 / 13
> ```

## Meine Notizen

