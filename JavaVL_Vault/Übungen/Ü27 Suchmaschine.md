---
tags: ["typ/uebung", "thema/threads", "kategorie/nebenlaeufigkeit", "semester/2", "hat/musterloesung"]
aliases: ["SearchEngine"]
thema: "[[27 Threads]]"
klasse: "SearchEngine"
package: "de.dhbwka.java.exercise.threads.search"
status: "offen"
---

# Ü27 Suchmaschine

**Thema:** [[27 Threads]] · **Bereich:** Threads (2) · **Schwierigkeit:** –
**Klasse:** `SearchEngine` · **Package:** `de.dhbwka.java.exercise.threads.search`

📄 Aufgabe: [[Material/Aufgaben/27_Threads_Aufgaben-2.pdf#page=2|27_Threads_Aufgaben-2.pdf, S. 2]]
✅ Musterlösung: [[Material/Aufgaben/27_Threads_Aufgaben-2_Muster.pdf#page=4|27_Threads_Aufgaben-2_Muster.pdf, S. 4]]

> [!question] Kurz gesagt
> Internet-Suchmaschinen laden Internet-(HTML-)-Dokumente herunter und extrahieren alle Wörter und Links daraus. Die Wörter gehen in den Index der Suchmaschine ein, die Links werden verfolgt und die dahinter stehenden Seiten werden wiederum indiziert.

## Aufgabenstellung
```text
Internet-Suchmaschinen laden Internet-(HTML-)-Dokumente herunter und extrahieren alle Wörter
und Links daraus. Die Wörter gehen in den Index der Suchmaschine ein, die Links werden verfolgt
und die dahinter stehenden Seiten werden wiederum indiziert.

Da das Herunterladen von Dokumenten in der Regel einige Zeit dauert, verwenden diese
Suchmaschinen Threads, um jeweils eine Seite herunterzuladen und diese dann einem Controller-
Programm zur Verarbeitung zu übergeben. Die Verarbeitung des Inhalts (z.B. konvertieren
Suchmaschinen PDF- oder Office-Dokumente zunächst in ein internes Format) könnte dann
ebenfalls wieder über Threads gesteuert werden.

Schreiben Sie eine Klasse PageLoader, welche das Interface Runnable implementiert, und der
im Konstruktor eine URL übergeben werden kann. PageLoader soll den Inhalt dieser URL
herunterladen, muss also als Thread gestartet werden!
Eine Methode pageLoaded() soll true zurückgeben, sobald der Download abgeschlossen ist
(ansonsten false), eine weitere Methode getPageContent() soll dann den Inhalt des
Downloads als String zurückgeben.

Schreiben Sie weiterhin eine Klasse SearchEngine, die eine Liste von URLs, die zeilenweise in
einer Datei abgelegt sind oder in einem Array gespeichert sind, einliest und anschließend alle URLs
herunterlädt.

Jede URL soll dabei von einem eigenen PageLoader-Thread heruntergeladen werden.
SearchEngine soll die Threads regelmäßig darauf abfragen, ob der Download abgeschlossen ist
und sich dann ggf. den Inhalt abholen (und die ersten 40 (oder 60) Zeichen ausgeben).

Erweiterung:
Sorgen Sie dafür, dass SearchEngine gleichzeitig nicht mehr als n (z.B. n=3) PageLoader-
Threads startet.

Hinweise:
Ggf. müssen Sie einen Proxy einstellen um Zugriff zum Web zu haben:
System.setProperty( "proxySet", "true" );
System.setProperty( "proxyHost", "myproxy.domain.de" );
System.setProperty( "proxyPort", "8000" );

Beispiel zum Lesen des HTML-Inhalts von einer URL. Sie können auch diese Klasse nutzen.

package de.dhbwka.java.exercise.threads.search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

/**
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg
 * Cooperative State University.
 *
 * (C) 2016-2018 by N. Doms, T. Schlachter, C. Schmitt, J. Sidler, W. Suess
 *
 * @author DHBW lecturer
 * @version 1.2
 */
public class ReadURLExample {

    public static String getStringContentFromUrl( String url, String encoding ) {
       StringBuilder buffer = new StringBuilder();
       String line = null;
       try ( BufferedReader br = new BufferedReader(
             new InputStreamReader(
                             new URI( url ).toURL().openStream(),encoding ) ) ) {
          while ( (line = br.readLine() ) != null ) {
             buffer.append( line ).append( System.lineSeparator() );
          }
       } catch ( Exception ex ) {    }
       return buffer.toString();
    }

    public static void main( String[] args ) {
       System.out.println( ReadURLExample.getStringContentFromUrl(
             "https://www.tagesschau.de", "UTF-8" ) );
    }

}

Beispiel für Testausgabe
(4 URLs; Maximalzahl gleichzeitiger PageLoader-Threads n=3; Ausgabe jeweils der ersten 40
Zeichen der HTML-Seiten, wobei Zeilenumbrüche durch „##‘“ ersetzt werden):

Gestartet: https://www.tagesschau.de
Gestartet: https://www.sueddeutsche.de
Gestartet: https://www.spiegel.de
Geladen: https://www.tagesschau.de
  Inhalt: <!DOCTYPE html>##<html lang="de">##<head
Gestartet: https://www.kit.edu
Geladen: https://www.sueddeutsche.de
  Inhalt: <!DOCTYPE html>##<html lang="de">##
Geladen: https://www.kit.edu
  Inhalt: <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML
Geladen: https://www.spiegel.de
  Inhalt: <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML
```

## Benötigte Begriffe
[[Konstante]] · [[Bedingungsoperator]] · [[while-Schleife]] · [[for-Schleife]] · [[break und continue]] · [[Array]] · [[Konstruktor]] · [[this]] · [[static]] · [[toString]] · [[Kapselung]] · [[Überschreiben]] · [[Interface]] · [[String]] · [[StringBuilder und StringBuffer]] · [[Exception]] · [[BufferedReader und BufferedWriter]] · [[Datei und Pfad]] · [[List]] · [[Thread]] · [[Runnable]] · [[Executor-Framework]]

## Weitere Übungen zum Thema
[[Ü27 Tanzende Schrift]] · [[Ü27 Ampel]] · [[Ü27 Synchronisation]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.threads.search;
> 
> public class PageLoader implements Runnable {
> 
>     private final static String ENCODING = "UTF-8"; // e.g. "ISO-8859-1", "UTF-8"
>     public String url;
>     private String content;
> 
>     public PageLoader( String url ) {
>         this.url = url;
>         this.content = null;
>     }
> 
>     /**
>      * Check if page was loaded
>      *
>      * @return <code>true</code> if content has been loaded (is not
>      *          <code>null</code>), <code>false</code> otherwise
>      */
>     public boolean pageLoaded() {
>         return this.content != null;
>     }
> 
>     /**
>      * Get the page content, but first test if there is any with
>      * {@link #pageLoaded()}
>      *
>      * @return page content in a single line or <code>null</code> if page was no
>      *          {@link #pageLoaded() loaded}
>      */
>     public String getPageContent() {
>         return this.content != null
>         ? this.content.replaceAll( "(\\r|\\n)+", "##" ) : null;
>     }
> 
>     @Override
>     public void run() {
>         this.content =
>         ReadURLExample.getStringContentFromUrl( this.url, PageLoader.ENCODING );
>     }
> }
> 
> package de.dhbwka.java.exercise.threads.search;
> 
> import java.util.ArrayList;
> import java.util.List;
> import java.util.concurrent.ExecutorService;
> import java.util.concurrent.Executors;
> 
> public class SearchEngine {
> 
>     public static final int MAXTHREADS = 3;
> 
>     private List<PageLoader> pageLoader = new ArrayList<>();
> 
>     public void crawl(String... urls) {
> 
>         ExecutorService exec = Executors.newFixedThreadPool(MAXTHREADS);
> 
>         for (String url : urls) {
>             PageLoader pl = new PageLoader(url);
>             this.pageLoader.add(pl);
>             exec.submit(pl);
>             System.out.println("Gestartet: " + url);
>         }
> 
>         // Keine weiteren Threads mehr zulassen
>         exec.shutdown();
> 
>         while (!pageLoader.isEmpty()) {
>             for (PageLoader pl : pageLoader) {
>                 if (pl.pageLoaded()) {
>                     System.out.println("Loaded: " + pl.url);
>                     System.out.println(" Content: " +
>                     pl.getPageContent().substring(0, 40));
>                     this.pageLoader.remove(pl);
>                     break;
>                 }
>             }
>         }
>     }
> 
>     public static void main(String[] args) {
>         new SearchEngine().crawl("https://www.tagesschau.de",
>         "https://www.sueddeutsche.de",
>         "https://www.spiegel.de",
>         "https://www.kit.edu");
>     }
> }
> ```

## Meine Notizen

