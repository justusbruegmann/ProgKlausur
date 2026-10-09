---
tags: ["typ/uebung", "thema/threads", "kategorie/nebenlaeufigkeit", "semester/2", "hat/musterloesung"]
aliases: ["MyBuffer"]
thema: "[[27 Threads]]"
klasse: "MyBuffer"
package: "de.dhbwka.java.exercise.threads.buffer"
status: "offen"
---

# Ü27 Synchronisation

**Thema:** [[27 Threads]] · **Bereich:** Threads (2) · **Schwierigkeit:** –
**Klasse:** `MyBuffer` · **Package:** `de.dhbwka.java.exercise.threads.buffer`

📄 Aufgabe: [[Material/Aufgaben/27_Threads_Aufgaben-2.pdf#page=1|27_Threads_Aufgaben-2.pdf, S. 1]]
✅ Musterlösung: [[Material/Aufgaben/27_Threads_Aufgaben-2_Muster.pdf#page=1|27_Threads_Aufgaben-2_Muster.pdf, S. 1]]

> [!question] Kurz gesagt
> Erweitern Sie das MyBuffer-Beispiel aus den Vorlesungsfolien (Abschnitt „Synchronisation mit wait und notify“) so, dass der interne Puffer (Speicher) mehrere Elemente enthalten kann. Für die Anzahl der Elemente im Puffer soll es eine Obergrenze geben (symbolische Konstante MAXSIZE, z.B.

## Aufgabenstellung
```text
Erweitern Sie das MyBuffer-Beispiel aus den Vorlesungsfolien (Abschnitt „Synchronisation mit
wait und notify“) so, dass der interne Puffer (Speicher) mehrere Elemente enthalten kann.
Für die Anzahl der Elemente im Puffer soll es eine Obergrenze geben (symbolische Konstante
MAXSIZE, z.B. MAXSIZE=3).

Erweitern Sie die Klassen ProducerThread und ConsumerThread entsprechend, um die
Funktion zu demonstrieren.

Hinweise:
•   Verwenden Sie für die interne Speicherung der Elemente eine Datenstruktur
    LinkedList<Integer>.
•   Um beim Ablauf etwas Zufall (und damit Dynamik) ins Spiel zu bringen, lassen Sie die beiden
    Threads nach jedem get() bzw. put() jeweils eine zufällige Anzahl von Millisekunden warten
    (z.B. zwischen 0 und 1000).
•   Geben Sie zum Testen nach jedem get() bzw. put()den Füllstand des Puffers (Anzahl der
    Elemente im Puffer) auf die Konsole aus.

Beispielausgabe (Einfügen/Auslesen von 7 Elementen):

Put: 0
Fill level after put: 1
Get: 0
Fill level after get: 0
Puffer leer - warten!
Put: 1
Fill level after put: 1
Get: 1
Fill level after get: 0
Put: 2
Fill level after put: 1
Put: 3
Fill level after put: 2
Get: 2
Fill level after get: 1
Put: 4
Fill level after put: 2
Put: 5
Fill level after put: 3
Puffer voll - warten!
Get: 3
Fill level after get: 2
Put: 6
Fill level after put: 3
...
```

## Benötigte Begriffe
[[Konstante]] · [[Zufallszahlen]] · [[for-Schleife]] · [[Array]] · [[this]] · [[static]] · [[Kapselung]] · [[Überschreiben]] · [[Interface]] · [[Innere Klasse]] · [[Exception]] · [[List]] · [[Thread]] · [[Runnable]] · [[Synchronisation]] · [[wait und notify]]

## Weitere Übungen zum Thema
[[Ü27 Tanzende Schrift]] · [[Ü27 Ampel]] · [[Ü27 Suchmaschine]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.threads.buffer;
> 
> import java.util.LinkedList;
> import java.util.List;
> 
> public class MyBuffer {
> 
>     private final static int MAXSIZE = 3;
>     private List<Integer> values = new LinkedList<>();
> 
>     /**
>      * The producer routine
>      *
>      * @param value
>      *            value to put in buffer
>      */
>     public synchronized void put( int value ) {
>         if ( !(this.values.size() < MyBuffer.MAXSIZE) ) {
>             System.out.println( "Buffer full - wait!" );
>             try {
>                 this.wait();
>             } catch ( InterruptedException e ) {
>             }
>         } // buffer is empty, fill it!
>         this.values.add( new Integer( value ) );
>         // notify waiting consumer via notify()
>         this.notify();
>         System.out.println( "Put: " + value );
>     }
> 
>     // Continued on next page
> 
>     /**
>      * The consumer routine
>      *
>      * @return value from buffer
>      */
>     public synchronized int get() {
>         // consumer must wait until buffer is not empty
>         if ( this.values.size() == 0 ) {
>             try {
>                 System.out.println( "Buffer empty - wait!" );
>                 this.wait();
>             } catch ( InterruptedException e ) {
>             }
>         }
>         // buffer has at least one Element, remove it!
>         int value = this.values.remove( 0 );
>         // notify waiting producer via notify()
>         this.notify();
>         System.out.println( "Get: " + value );
>         return value;
>     }
> 
> }
> 
> package de.dhbwka.java.exercise.threads.buffer;
> 
> import java.util.Random;
> 
> public class BufferDemo {
> 
>     private static final int TESTDATASIZE = 7;
>     private static final int MAXDELAY = 500;
>     private static final Random RND = new Random();
> 
>     /**
>      * Inner class for Producer-Thread
>      */
>     static class ProducerThread implements Runnable {
>         private MyBuffer buffer;
> 
>         public ProducerThread( MyBuffer b ) {
>             this.buffer = b;
>         }
> 
>         // Continued on next page
> 
>         @Override
>         public void run() {
>             for ( int i = 0; i < BufferDemo.TESTDATASIZE; i++ ) {
>                 this.buffer.put( i );
>                 // simulate data calculation time by random waiting
>                 try {
>                     Thread.sleep( BufferDemo.RND.nextInt( BufferDemo.MAXDELAY ) );
>                 } catch ( InterruptedException ex ) {
>                 }
>             }
>         }
>     }
> 
>     /**
>      * Inner class for Consumer-Thread
>      */
>     static class ConsumerThread implements Runnable {
>         private MyBuffer buffer;
> 
>         public ConsumerThread( MyBuffer b ) {
>             this.buffer = b;
>         }
> 
>         @Override
>         public void run() {
>             for ( int i = 0; i < BufferDemo.TESTDATASIZE; i++ ) {
>                 this.buffer.get();
>                 // Simulate data processing time by random waiting
>                 try {
>                     Thread.sleep( BufferDemo.RND.nextInt( BufferDemo.MAXDELAY ) );
>                 } catch ( InterruptedException ex ) {
>                 }
>             }
>         }
>     }
> 
>     public static void main( String args[] ) {
>         MyBuffer buf = new MyBuffer();
>         // Create one producer and one consumer
>         new Thread( new ProducerThread( buf ) ).start();
>         new Thread( new ConsumerThread( buf ) ).start();
>     }
> 
> }
> ```

## Meine Notizen

