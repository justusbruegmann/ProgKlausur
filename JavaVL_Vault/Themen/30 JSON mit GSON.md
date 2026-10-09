---
tags: ["typ/thema", "thema/json", "kategorie/datenformate", "semester/2"]
aliases: ["JSON mit GSON", "Folien 30"]
semester: 2
kategorie: "Datenformate"
folien: "[[Material/Folien/30_GSON.pdf]]"
seiten: 41
---

# 30 JSON mit GSON

← [[29 XML]] · [[Start|🏠 Start]] · [[31 JUnit-Tests]] →

> [!abstract] Worum geht's?
> JSON-Syntax und die Bibliothek GSON: Einbinden in die IDE, Serialisierung und Deserialisierung von Java-Objekten, Einstellungen, Einschränkungen und das zugrunde liegende Reflection-Prinzip.

**Semester:** Programmieren II · **Bereich:** #kategorie/datenformate · **Folien:** [[Material/Folien/30_GSON.pdf|30_GSON.pdf]] (41 Seiten)

## Gliederung der Folien
- [[Material/Folien/30_GSON.pdf#page=2|S. 2]] Motivation
- [[Material/Folien/30_GSON.pdf#page=3|S. 3]] Java und JavaScript
- [[Material/Folien/30_GSON.pdf#page=4|S. 4]] JSON – Syntax
- [[Material/Folien/30_GSON.pdf#page=10|S. 10]] GSON-Download und Installation
- [[Material/Folien/30_GSON.pdf#page=11|S. 11]] Bibliothek einbinden in Eclipse
- [[Material/Folien/30_GSON.pdf#page=13|S. 13]] Bibliothek einbinden in IntelliJ
- [[Material/Folien/30_GSON.pdf#page=15|S. 15]] Einstieg in GSON
- [[Material/Folien/30_GSON.pdf#page=16|S. 16]] Einfache Beispiele zur „Serialisierung“
- [[Material/Folien/30_GSON.pdf#page=17|S. 17]] Einfache Beispiele zur „Deserialisierung“
- [[Material/Folien/30_GSON.pdf#page=18|S. 18]] Ein etwas komplexeres Beispiel
- [[Material/Folien/30_GSON.pdf#page=19|S. 19]] Beispiel Deserialisierung
- [[Material/Folien/30_GSON.pdf#page=31|S. 31]] Beispiel Serialisierung
- [[Material/Folien/30_GSON.pdf#page=34|S. 34]] Einstellungen
- [[Material/Folien/30_GSON.pdf#page=36|S. 36]] Einschränkungen
- [[Material/Folien/30_GSON.pdf#page=37|S. 37]] Wie das Ganze funktioniert: „Reflection“
- [[Material/Folien/30_GSON.pdf#page=38|S. 38]] Aufgabe 1
- [[Material/Folien/30_GSON.pdf#page=39|S. 39]] Aufgabe 1 (Erwartetes Ergebnis)
- [[Material/Folien/30_GSON.pdf#page=40|S. 40]] Aufgabe 2
- [[Material/Folien/30_GSON.pdf#page=41|S. 41]] Aufgabe 2 (JSON-Input)

## Begriffe in diesem Kapitel
- [[Annotation]] (S. [[Material/Folien/30_GSON.pdf#page=35|35]])
- [[JSON]] (S. [[Material/Folien/30_GSON.pdf#page=2|2]], [[Material/Folien/30_GSON.pdf#page=4|4]], [[Material/Folien/30_GSON.pdf#page=5|5]], [[Material/Folien/30_GSON.pdf#page=6|6]], [[Material/Folien/30_GSON.pdf#page=7|7]], [[Material/Folien/30_GSON.pdf#page=8|8]])
- [[GSON]] (S. [[Material/Folien/30_GSON.pdf#page=10|10]], [[Material/Folien/30_GSON.pdf#page=15|15]], [[Material/Folien/30_GSON.pdf#page=16|16]], [[Material/Folien/30_GSON.pdf#page=17|17]], [[Material/Folien/30_GSON.pdf#page=19|19]], [[Material/Folien/30_GSON.pdf#page=20|20]])
- [[Reflection]] (S. [[Material/Folien/30_GSON.pdf#page=37|37]])

## Kommt hier auch vor
[[Array]] · [[Kapselung]] · [[Reader und Writer]]

## Verwandte Themen
[[29 XML]] · [[15 Input und Output]] · [[32 Maven]]

## Folien ansehen
![[Material/Folien/30_GSON.pdf]]

## Folientext (durchsuchbar)
> [!quote]- Kompletter Folientext – aufklappen
> ```text
> ── Seite 1 ──
> Programmieren II
> JavaScript-Objekt-Verarbeitung mit GSON
>    Heusch --
>    Ratz --
> 
> Institut für Automation und angewandte Informatik
> 
> KIT – Die Forschungsuniversität in der Helmholtz-Gemeinschaft www.kit.edu
> 
> ── Seite 2 ──
> Motivation
> 
>    In vielen Web-Anwendungen (HTML5) werden JavaScript-
>    Objekte (JSON = JavaScript Object Notation) verarbeitet
>    Java-Anwendungen können mit Hilfe von Zusatz-
>    Bibliotheken solche JavaScript-Objekte verarbeiten, z.B.
>    Java-Objekte nach JSON konvertieren („Serialisierung“)
>    JSON in Java-Objekte umwandeln („Deserialisierung“)
> 
>    Eine solche Bibliothek ist GSON
> 
>    JSON-Logo
> 
> 2 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 3 ──
> Java und JavaScript
> 
>    Trotz der Ähnlichkeit ihrer Namen besteht zwischen Java
>    und JavaScript ein grundlegender Unterschied:
>    Zwar sind beide objektorientiert, jedoch handelt es sich bei
>    Java um eine Programmiersprache,
>    während JavaScript eine sog. Skriptsprache ist.
> 
>    JavaScript wird meist in Web-Browsern verwendet und
>    dient der Programmierung dynamischer Web-
>    Anwendungen.
>    Dabei unterliegt es aus Gründen der Sicherheit
>    erheblichen Beschränkungen, z.B. was den Zugriff auf
>    lokale Dateien oder Netzwerkverbindungen betrifft.
> 
> 3 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 4 ──
> JSON – Syntax (1)
> 
>    JSON bildet eine Untermenge von JavaScript und dient der
>    Darstellung von JavaScript-Objekten
> 
>    JSON wird häufig zum Datenaustausch in Web-Systemen
>    verwendet und löste hier an vielen Stellen XML ab:
>    es ist „kürzer“ (kompakter) als XML
>    es ist einfacher zu lesen und zu schreiben
>    es kennt Arrays
>    es kann direkt in JavaScript verarbeitet werden (es IST JavaScript!)
> 
> 4 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 5 ──
> JSON – Syntax (2)
> 
>    JSON besteht aus Schlüssel-Wert-Paaren.
>    Der Schlüssel (Attributname) wird in Anführungszeichen
>    gesetzt, der Wert (hier eine Zeichenkette) folgt nach dem
>    Doppelpunkt
>    "prename":"Donald"
> 
>    JSON kennt folgende Wert-Typen:
>    Zahl (number)   (integer oder floating point)
>    Zeichenkette (string)   (in doppelten Anführungszeichen)
>    Logischer Wert (boolean) (true or false)
>    Feld (array)   (in eckigen Klammern [])
>    Objekt (object)   (in geschweiften Klammern {})
>    null
> 
> 5 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 6 ──
> JSON – Syntax (3)
> 
>    Beispiele für die verschiedenen Wert-Typen:
>    "prename":"Donald"   string
> 
>    "surname":"Duck"   string
> 
>    "birthyear":1920   number
> 
>    "size":1.10   number
> 
>    "liaised":true   boolean
> 
>    "partner": {"prename":"Daisy","surname":"Duck"}   object
> 
>    "nephews":[ {"name":"Tick"},{"name":"Trick"},
>    array
>    {"name":"Track"} ]
> 
>    "job":null   null
> 
> 6 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 7 ──
> JSON – Syntax (4)
> 
>    Auch einfache Daten können (ohne Attributnamen) in
>    JSON dargestellt werden, z.B.
>    "Hello World"   string
> 
>    3.1416   number
> 
>    42   number
> 
> 7 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 8 ──
> JSON – Syntax (5)
> 
>    JSON-Objekte werden in geschweiften Klammern
>    geschrieben und können mehrere Schlüssel-Wert-Paare
>    (als Attribute) enthalten.
>    Mehrere Attribute werden durch Kommas getrennt.
>    {
>    "prename":"Donald",
>    "surname":"Duck",
>    "birthyear":1920,
>    "size":1.10,
>    "liaised":true,
>    "partner": {"prename":"Daisy","surname":"Duck"},
>    "nephews":[ {"name":"Tick"},{"name":"Trick"},
>    {"name":"Track"} ],
>    "job":null
>    }
> 
> 8 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 9 ──
> JSON – Syntax (6)
> 
>    JSON-Arrays werden in eckigen Klammern geschrieben.
>    Sie können mehrere Objekte enthalten, die wiederum
>    durch Kommas voneinander getrennt werden:
>    "ducks":[
>    {"prename":"Donald", "surname":"Duck"},
>    {"prename":"Daisy", "surname":"Duck"},
>    {"name":"Phantomias", "alias":"Donald"}
>    ]
> 
>    Anmerkung: Die Objekte haben dabei keinen „Typ“, d.h. sie können
>    unterschiedliche Attribute haben.
> 
> 9 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 10 ──
> GSON-Download und Installation
> 
>    GSON ist eine Bibliothek von Google zum Arbeiten mit
>    JSON-Objekten in Java. Sie ist unter der Apache License
>    2.0 zur Verwendung in eigenen Programmen verfügbar.
> 
>    Quellen:
>    https://github.com/google/gson (Quellcode)
>    https://repo1.maven.org/maven2/com/google/code/gson/gson/2.13.1/gson-2.13.1.jar
>    (JAR-Bibliothek, 2.13.1 momentan aktuelle Version)
>    Maven: https://mvnrepository.com/artifact/com.google.code.gson/gson
> 
>    Die Datei gson-<version>.jar herunterladen und als
>    Bibliothek dem Projekt hinzugefügen.
>    Anmerkung: Einbindung mit Maven machen wir nächstes Mal 
> 10 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 11 ──
> Bibliothek einbinden in Eclipse (1)
> 
>    Mit dem Dateibrowser ins Projekt-Verzeichnis navigieren
>    (hier: Projekt „GsonExample“)
>    Neuen Ordner „lib“ erzeugen und JAR-Datei
>    gson-<version>.jar hineinkopieren
> 
>    Rechtsklick in Eclipse auf
>    JAR-Datei im Ordner „lib“
>    Build Path  Add to Build Path
> 
> 11 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 12 ──
> Bibliothek einbinden in Eclipse (2)
> 
>    Im Package Explorer erscheint
>    nun der Punkt „References
>    Libraries“ mit dem Eintrag
>    gson-<version>.jar
> 
>    Im Project Explorer erscheint
>    nun gson-<version>.jar
>    als weiterer Resourcen-Eintrag.
> 
> 12 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 13 ──
> Bibliothek einbinden in IntelliJ (1)
> 
>    Mit dem Dateibrowser ins Projekt-Verzeichnis navigieren
>    (hier: Projekt „MyGsonProject“)
>    Neuen Ordner „lib“ erzeugen und JAR-Datei
>    gson-<version>.jar hineinkopieren
> 
>    Rechtsklick auf
>    JAR-Datei im Ordner „lib“
>    „Add as Library…“
> 
> 13 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 14 ──
> Bibliothek einbinden in IntelliJ (2)
> 
>    Den folgenden Dialog bestätigen
> 
>    Die Datei gson-<version>.jar ist nun „ausklappbar“
>    und als Bibliothek eingebunden
> 
> 14 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 15 ──
> Einstieg in GSON
> 
>    Die meisten notwendigen Klassen (insbesondere Gson)
>    befinden sich im Package com.google.gson
> 
>    Gson muss instanziiert werden und bieten dann Methoden
>    zum Wandeln von Java-Objekten nach JSON und
>    umgekehrt:
> 
>    Gson gson = new Gson();
>    gson.fromJson( /* .. */ );   // JSON nach Java
>    gson.toJson( /* .. */ );   // Java nach JSON
> 
> 17 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 16 ──
> Einfache Beispiele zur „Serialisierung“
> 
>    Die Methoden .toJson( … ) liefern jeweils einen
>    String zurück – oder haben keinen Rückgabewert, dann
>    wird das Ergebnis in den übergebenen Writer
>    (Appendable oder JsonWriter geschrieben)
>    Gson gson = new Gson();   Ausgabe
>    System.out.println(gson.toJson(1));   1
>    System.out.println(gson.toJson("abcd"));   "abcd"
>    System.out.println(gson.toJson(new Long(10)));   10
>    int[] values = { 1 };
>    System.out.println(gson.toJson(values));   [1]
> 
> 18 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 17 ──
> Einfache Beispiele zur „Deserialisierung“
> 
>    Die Methoden .fromJson( … ) liefern jeweils Objekte
>    Zurück.
>    Der Typ des Rückgabewertes ist generisch.
>    Die zugehörige Klasse wird als zweiter Parameter
>    übergeben.
>    Gson gson = new Gson();
>    int someint = gson.fromJson("1", int.class);
>    Integer someInteger = gson.fromJson("1", Integer.class);
>    Long someLong = gson.fromJson("1", Long.class);
>    Boolean someBoolean = gson.fromJson("false", Boolean.class);
>    String str = gson.fromJson("\"abc\"", String.class);
> 
> 19 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 18 ──
> Ein etwas komplexeres Beispiel
>    http://maps.googleapis.com/maps/api/geocode/json?address=karlsruhe   {
>    Alternativ: https://www.iai.kit.edu/javavl/data/static/karlsruhe.json   "results" : [
>    {
>    "address_components" : [
>    {
>    {   "long_name" : "Karlsruhe",
>    "short_name" : "Karlsruhe",
>    "results" : [   },
>    "types" : [ "locality", "political" ]
> 
>    {
>    {   "long_name" : "Karlsruhe",
>    "short_name" : "KA",
>    "address_components" : [   "types" : [ "administrative_area_level_2", "political" ]
>    },
>    {   {
>    "long_name" : "Baden-Württemberg",
>    "long_name" : "Karlsruhe",   "short_name" : "BW",
>    "types" : [ "administrative_area_level_1", "political" ]
>    "short_name" : "Karlsruhe",   },
>    {
> 
>    "types" : [ "locality", "political" ]   "long_name" : "Deutschland",
>    "short_name" : "DE",
>    "types" : [ "country", "political" ]
>    }   …   }
>    ],
>    ],   "formatted_address" : "Karlsruhe, Deutschland",
>    "geometry" : {
>    "formatted_address" : "Karlsruhe, Deutschland",   "bounds" : {
>    "northeast" : {
>    "geometry" : {   "lat" : 49.0912684,
>    "lng" : 8.541658099999999
>    …   },
>    "southwest" : {
>    "lat" : 48.9404298,
>    "location" : {   "lng" : 8.2774096
>    }
>    "lat" : 49.0068901,   },
>    "location" : {
>    "lng" : 8.4036527   "lat" : 49.0068901,
>    "lng" : 8.4036527
>    },   },
>    "location_type" : "APPROXIMATE",
>    "location_type" : "APPROXIMATE"   "viewport" : {
>    "northeast" : {
> 
>    …   "lat" : 49.0912684,
>    "lng" : 8.541658099999999
>    },
>    },   "southwest" : {
>    "lat" : 48.9404298,
>    "types" : [ "locality", "political" ]   "lng" : 8.2774096
>    }
>    }   },
>    }
> 
>    ],   "place_id" : "ChIJCXjgokgGl0cRf-63THNV_LY",
>    "types" : [ "locality", "political" ]
>    "status" : "OK"   ],
>    }
> 
>    "status" : "OK"
>    }   Ausschnitt   }
>    komplettes Dokument
> 
> 20 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 19 ──
> Beispiel Deserialisierung (1)
>    {
>    "results" : [
> 
>    Aufgabe:   {
>    "address_components" : [
>    {
>    "long_name" : "Karlsruhe",
> 
>    Schreiben Sie Java-Klassen,   },
>    {
>    "short_name" : "Karlsruhe",
>    "types" : [ "locality", "political" ]
> 
>    die zu diesem Beispiel passen!
>    "long_name" : "Karlsruhe",
>    "short_name" : "KA",
>    "types" : [ "administrative_area_level_2", "political" ]
>    },
>    {
>    "long_name" : "Baden-Württemberg",
>    "short_name" : "BW",
>    "types" : [ "administrative_area_level_1", "political" ]
>    },
>    {
>    "long_name" : "Deutschland",
> 
>    Kandidaten hierfür sind:   ],
>    }
>    "short_name" : "DE",
>    "types" : [ "country", "political" ]
> 
>    results (das gesamte Ergebnis)
>    "formatted_address" : "Karlsruhe, Deutschland",
>    "geometry" : {
>    "bounds" : {
>    "northeast" : {
>    "lat" : 49.0912684,
> 
>    address_components   },
>    "lng" : 8.541658099999999
> 
>    "southwest" : {
>    "lat" : 48.9404298,
> 
>    geometry   },
>    }
>    "lng" : 8.2774096
> 
>    "location" : {
> 
>    bounds
>    "lat" : 49.0068901,
>    "lng" : 8.4036527
>    },
>    "location_type" : "APPROXIMATE",
>    "viewport" : {
> 
>    location   "northeast" : {
>    "lat" : 49.0912684,
>    "lng" : 8.541658099999999
>    },
> 
>    viewport   "southwest" : {
>    "lat" : 48.9404298,
>    "lng" : 8.2774096
>    }
> 
>    northeast
>    }
>    },
>    "place_id" : "ChIJCXjgokgGl0cRf-63THNV_LY",
>    "types" : [ "locality", "political" ]
>    }
> 
>    southwest   }
>    ],
>    "status" : "OK"
> 
> 21 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 20 ──
> Beispiel Deserialisierung (2)
>    {
>    "results" : [
> 
>    Beobachtung:   {
>    "address_components" : [
>    {
>    "long_name" : "Karlsruhe",
> 
>    Auf oberster Ebene haben wir   },
>    {
>    "short_name" : "Karlsruhe",
>    "types" : [ "locality", "political" ]
> 
>    ein Objekt mit den Attributen
>    "long_name" : "Karlsruhe",
>    "short_name" : "KA",
>    "types" : [ "administrative_area_level_2", "political" ]
>    },
> 
>    results und status.
>    {
>    "long_name" : "Baden-Württemberg",
>    "short_name" : "BW",
>    "types" : [ "administrative_area_level_1", "political" ]
>    },
> 
>    results ist offenbar ein
>    {
>    "long_name" : "Deutschland",
>    "short_name" : "DE",
>    "types" : [ "country", "political" ]
> 
>    Array von Objekten   ],
>    }
> 
>    "formatted_address" : "Karlsruhe, Deutschland",
>    "geometry" : {
> 
>    status ist offenbar ein
>    "bounds" : {
>    "northeast" : {
>    "lat" : 49.0912684,
>    "lng" : 8.541658099999999
> 
>    einzelner String   },
>    "southwest" : {
>    "lat" : 48.9404298,
>    "lng" : 8.2774096
>    }
>    },
>    "location" : {
>    "lat" : 49.0068901,
>    "lng" : 8.4036527
> 
>    Wir benötigen also eine Klasse
>    },
>    "location_type" : "APPROXIMATE",
>    "viewport" : {
>    "northeast" : {
>    "lat" : 49.0912684,
> 
>    mit genau diesen Attributen!   },
>    "lng" : 8.541658099999999
> 
>    "southwest" : {
>    "lat" : 48.9404298,
>    "lng" : 8.2774096
>    }
>    }
>    },
>    "place_id" : "ChIJCXjgokgGl0cRf-63THNV_LY",
>    "types" : [ "locality", "political" ]
>    }
>    ],
>    "status" : "OK"
>    }
> 
> 22 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 21 ──
> Beispiel Deserialisierung (3)
> 
>    JSON-Arrays können durch GSON entweder in Java-Arrays oder in
>    Java-Collections (z.B. List) umgewandelt werden.
>    Collection-Objekte und Arrays werden bei Bedarf durch GSON
>    instanziiert
> 
>    Das Beispiel zeigt beide Möglichkeiten für GeocodingResult:
>    Implementierung mit List   Implementierung mit einem Array
> 
>    //import java.util.ArrayList;   public class GeocodingResult {
>    import java.util.List;   private Result[] results;
>    private String status;
>    public class GeocodingResult {   // evtl getter/setter
>    private List<Result> results;   }
>    // = new ArrayList<Result>();
>    // nicht unbedingt notwendig!
> 
>    private String status;
>    // evtl getter/setter
>    }
> 
> 23 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 22 ──
> Beispiel Deserialisierung (4)
>    {
>    "results" : [
> 
>    Beobachtung:   {
>    "address_components" : [
>    {
> 
>    Unterhalb von results finden
>    "long_name" : "Karlsruhe",
>    "short_name" : "Karlsruhe",
>    "types" : [ "locality", "political" ]
>    },
>    {
> 
>    wir Objekte mit den folgenden
>    "long_name" : "Karlsruhe",
>    "short_name" : "KA",
>    "types" : [ "administrative_area_level_2", "political" ]
>    },
>    {
> 
>    Attributen:   },
>    "long_name" : "Baden-Württemberg",
>    "short_name" : "BW",
>    "types" : [ "administrative_area_level_1", "political" ]
> 
>    address_components
>    {
>    "long_name" : "Deutschland",
>    "short_name" : "DE",
>    "types" : [ "country", "political" ]
> 
>    Array von Objekten   ],
>    }
> 
>    "formatted_address" : "Karlsruhe, Deutschland",
>    "geometry" : {
> 
>    formatted_address
>    "bounds" : {
>    "northeast" : {
>    "lat" : 49.0912684,
>    "lng" : 8.541658099999999
> 
>    String   },
>    "southwest" : {
>    "lat" : 48.9404298,
>    "lng" : 8.2774096
> 
>    geometry
>    }
>    },
>    "location" : {
>    "lat" : 49.0068901,
> 
>    Objekt   },
>    "lng" : 8.4036527
> 
>    "location_type" : "APPROXIMATE",
>    "viewport" : {
> 
>    place_id
>    "northeast" : {
>    "lat" : 49.0912684,
>    "lng" : 8.541658099999999
>    },
> 
>    String   "southwest" : {
>    "lat" : 48.9404298,
>    "lng" : 8.2774096
>    }
> 
>    types
>    }
>    },
>    "place_id" : "ChIJCXjgokgGl0cRf-63THNV_LY",
>    "types" : [ "locality", "political" ]
> 
>    Array von Strings   ],
>    }
> 
>    "status" : "OK"
>    }
> 
> 24 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 23 ──
> Beispiel Deserialisierung (5)
>    {
>    "results" : [
>    {
>    "address_components" : [
> 
>    Wir fassen diese   {
>    "long_name" : "Karlsruhe",
>    "short_name" : "Karlsruhe",
>    "types" : [ "locality", "political" ]
> 
>    Eigenschaften in einer   },
>    {
>    "long_name" : "Karlsruhe",
>    "short_name" : "KA",
> 
>    Klasse Result zusammen.   ]
>    },
>    {
>    "types" : [ "administrative_area_level_2", "political"
> 
>    "long_name" : "Baden-Württemberg",
> 
>    Den Attributen geben wir die   ]
>    "short_name" : "BW",
>    "types" : [ "administrative_area_level_1", "political"
> 
>    },
> 
>    entsprechenden Namen   {
>    "long_name" : "Deutschland",
>    "short_name" : "DE",
>    "types" : [ "country", "political" ]
> 
>    Zu den Datentypen kommen   ],
>    }
> 
>    "formatted_address" : "Karlsruhe, Deutschland",
>    "geometry" : {
> 
>    wir auf den folgenden Folien   "bounds" : {
>    "northeast" : {
>    "lat" : 49.0912684,
>    "lng" : 8.541658099999999
>    },
>    import java.util.List;   "southwest" : {
>    "lat" : 48.9404298,
>    "lng" : 8.2774096
>    }
>    },
>    public class Result {   "location" : {
>    "lat" : 49.0068901,
>    "lng" : 8.4036527
>    },
>    "location_type" : "APPROXIMATE",
> 
>    private List<AddressComponent> address_components;   "viewport" : {
>    "northeast" : {
>    "lat" : 49.0912684,
>    private String formatted_address;   },
>    "lng" : 8.541658099999999
> 
>    private Geometry geometry;   "southwest" : {
>    "lat" : 48.9404298,
>    "lng" : 8.2774096
>    private String place_id;   }
>    }
> 
>    private String[] types;   },
>    "place_id" : "ChIJCXjgokgGl0cRf-63THNV_LY",
>    "types" : [ "locality", "political" ]
>    // evtl getter/setter   ],
>    }
> 
>    "status" : "OK"
>    }   }
> 
> 25 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 24 ──
> Beispiel Deserialisierung (6)
>    "address_components" : [
> 
>    Für address_components
>    {
>    "long_name" : "Karlsruhe",
>    "short_name" : "Karlsruhe",
>    "types" : [ "locality", "political" ]
>    },
> 
>    fällt auf, dass alle Objekte im   {
>    "long_name" : "Karlsruhe",
>    "short_name" : "KA",
>    "types" : [ "administrative_area_level_2", "political" ]
> 
>    Array dieselben drei Attribute
>    },
>    {
>    "long_name" : "Baden-Württemberg",
>    "short_name" : "BW",
>    "types" : [ "administrative_area_level_1", "political" ]
> 
>    haben. Hierfür bilden wir eine   },
>    {
>    "long_name" : "Deutschland",
>    "short_name" : "DE",
> 
>    neue Klasse, z.B.   ],
>    }
>    "types" : [ "country", "political" ]
> 
>    AddressComponent
>    Die Attributnamen entsprechen
>    denen der JSON-Notation
>    public class AddressComponent {
> 
>    private String long_name;
>    private String short_name;
>    private String[] types;
> 
>    }
> 
> 26 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 25 ──
> Beispiel Deserialisierung (7)
>    "geometry" : {
>    "bounds" : {
> 
>    Beobachtung:   "northeast" : {
>    "lat" : 49.0912684,
>    "lng" : 8.541658099999999
> 
>    Unter geometry beobachten
>    },
>    "southwest" : {
>    "lat" : 48.9404298,
>    "lng" : 8.2774096
>    }
> 
>    wir, dass die Muster von bounds   },
>    "location" : {
>    "lat" : 49.0068901,
>    "lng" : 8.4036527
> 
>    und viewport übereinstimmen.
>    },
>    "location_type" : "APPROXIMATE",
>    "viewport" : {
>    "northeast" : {
>    "lat" : 49.0912684,
>    "lng" : 8.541658099999999
> 
>    Wir bilden dafür eine   },
>    "southwest" : {
>    "lat" : 48.9404298,
>    "lng" : 8.2774096
> 
>    gemeinsame Klasse BBox   },
>    }
>    }
> 
>    public class BBox {
>    Beobachtung:   private LatLon northeast;
>    Auch die Muster für location,   private LatLon southwest;
>    // evtl getter/setter
>    northeast und southwest   }
> 
>    passen zueinander.   public class LatLon {
>    private double lat;
>    Dafür bilden wir die Klasse   private double lng;
>    // evtl getter/setter
>    LatLon   }
> 
> 27 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 26 ──
> Beispiel Deserialisierung (8)
>    "geometry" : {
>    "bounds" : {
> 
>    Beobachtung:   "northeast" : {
>    "lat" : 49.0912684,
>    "lng" : 8.541658099999999
> 
>    geometry selbst besteht aus
>    },
>    "southwest" : {
>    "lat" : 48.9404298,
>    "lng" : 8.2774096
>    }
> 
>    4 Attributen. Wir bilden eine
>    },
>    "location" : {
>    "lat" : 49.0068901,
>    "lng" : 8.4036527
> 
>    Klasse Geometry mit diesen
>    },
>    "location_type" : "APPROXIMATE",
>    "viewport" : {
>    "northeast" : {
>    "lat" : 49.0912684,
> 
>    Attributen und den passenden   },
>    "lng" : 8.541658099999999
> 
>    "southwest" : {
>    "lat" : 48.9404298,
>    "lng" : 8.2774096
> 
>    Typen:   },
>    }
>    }
> 
>    bounds ist vom Typ BBox
>    location ist vom Typ LatLon   public class Geometry {
>    private BBox bounds;
>    location_type ist ein String   private LatLon location;
>    viewport ist vom Typ BBox   private String location_type;
>    private BBox viewport;
>    // evtl getter/setter
>    }
> 
> 28 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 27 ──
> Beispiel Deserialisierung (9)
> 
>    Aus den Kandidaten wurden also folgende Java-Klassen:
>    results    GeocodingResult
>    address_components    AddressComponent
>    geometry    Geometry
>    bounds    BBox
>    location    LatLon
>    viewport    BBox
>    northeast    LatLon
>    southwest    LatLon
>     Result
> 
>    Entscheidend für die Zuordnung sind
>    Attributnamen – nicht Klassennamen!
> 
> 29 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 28 ──
> Beispiel Deserialisierung (10)
> 
>    Damit können wir den JSON-Inhalt deserialisieren:
>    import java.io.*;   import java.net.URL;   import com.google.gson.Gson;
> 
>    public class GeocodingExample {
> 
>    public static void main( String[] args ) throws IOException {
>    StringBuilder content = new StringBuilder();
>    URL url = new URL(
>    "https://www.iai.kit.edu/javavl/data/static/karlsruhe.json" );
>    try ( BufferedReader br = new BufferedReader(
>    new InputStreamReader( url.openConnection().getInputStream() ) ) ) {
>    String line;
>    while ( (line = br.readLine()) != null ) {
>    content.append( line ).append( System.lineSeparator() );
>    }
>    Gson gson = new Gson();
>    GeocodingResult results =
>    gson.fromJson( content.toString(), GeocodingResult.class );
>    // Nun können wir mit dem results-Objekt arbeiten...
>    }
>    }
>    }
> 
> 30 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 29 ──
> Beispiel Deserialisierung (11)
> 
>    …oder noch einfacher (direkt per Reader):
>    import java.io.*;
>    import java.net.URL;
>    import com.google.gson.Gson;
> 
>    public class GeocodingResultWithReader {
> 
>    public static void main( String[] args ) throws IOException {
>    URL url = new URL(
>    "https://www.iai.kit.edu/javavl/data/static/karlsruhe.json" );
>    try ( Reader reader =
>    new InputStreamReader( url.openConnection().getInputStream() ) ) {
> 
>    GeocodingResult results =
>    new Gson().fromJson( reader, GeocodingResult.class );
> 
>    // Nun koennen wir mit dem results-Objekt arbeiten...
>    }
>    }
>    }
> 
> 31 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 30 ──
> Beispiel Deserialisierung (12)
> 
>    Der Debugger zeigt, dass die Objekte entsprechend
>    instanziiert und mit Inhalt gefüllt wurden.
> 
> 32 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 31 ──
> Beispiel Serialisierung (1)
> 
>    Natürlich sollte eine Serialisierung des so erzeugten
>    results-Objektes wieder den Ausgangscode ergeben.
> 
>    Die Standard-Serialisierung liefert einen kompakten String
>    mit einer langen JSON-Zeile, d.h. ohne Umbrüche.
> 
>    Deshalb erzeugen wir uns eine Gson-Instanz mit „Pretty-
>    Printing“-Funktion, der formatierten Variante der Ausgabe.
>    Hierbei hilft uns die GsonBuilder-Klasse:
>    Gson gsonPp = new GsonBuilder().setPrettyPrinting().create();
>    System.out.println(gsonPp.toJson(results));
> 
> 33 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 32 ──
> Beispiel Serialisierung (2)
>    {   {
>    "results" : [   "results": [
>    {   {
>    Bis auf Details   "address_components" : [
>    {
>    "address_components": [
>    {
>    "long_name" : "Karlsruhe",   "long_name": "Karlsruhe",
>    der Formatierung   "short_name" : "Karlsruhe",
>    "types" : [ "locality", "political" ]
>    "short_name": "Karlsruhe",
>    "types": ["locality","political"]
>    },   },
>    ist das Ergebnis   {
>    "long_name" : "Karlsruhe",
>    {
>    "long_name": "Karlsruhe",
>    "short_name" : "KA",   "short_name": "KA",
>    identisch mit dem   },
>    "types" : [ "administrative_area_level_2", "political" ]   "types": ["administrative_area_level_2","political"]
>    },
> 
>    Original.   {
>    "long_name" : "Baden-Württemberg",
>    "short_name" : "BW",
>    {
>    "long_name": "Baden-Württemberg",
>    "short_name": "BW",
>    "types" : [ "administrative_area_level_1", "political" ]   "types": ["administrative_area_level_1","political"]
>    },   },
>    {   {
> 
>    Auch bei der   "long_name" : "Deutschland",
>    "short_name" : "DE",
>    "types" : [ "country", "political" ]
>    "long_name": "Deutschland",
>    "short_name": "DE",
>    "types": ["country", "political"]
> 
>    Serialisierung   ],
>    }
> 
>    "formatted_address" : "Karlsruhe, Deutschland",
>    }
>    ],
>    "formatted_address": "Karlsruhe, Deutschland",
> 
>    werden die   "geometry" : {
>    "bounds" : {
>    "geometry": {
>    "bounds": {
>    "northeast" : {   "northeast": {
>    Attributnamen aus   "lat" : 49.0912684,
>    "lng" : 8.541658099999999
>    "lat": 49.0912684,
>    "lng": 8.5416581,
> 
>    den Java-Klassen
>    },
>    "southwest" : {
>    "lat" : 48.9404298,
>    Deserialisierung   },
>    "southwest": {
>    "lat": 48.9404298,
> 
>    verwendet.   },
>    }
>    "lng" : 8.2774096
>    und erneute   }
>    },
>    "lng": 8.2774096,
> 
>    "location" : {
>    "lat" : 49.0068901,
>    "lng" : 8.4036527
>    Serialisierung   "location": {
>    "lat": 49.0068901,
>    "lng": 8.4036527,
>    },   },
>    "location_type" : "APPROXIMATE",   "location_type": "APPROXIMATE",
>    "viewport" : {   "viewport": {
>    "northeast" : {   "northeast": {
>    "lat" : 49.0912684,   "lat": 49.0912684,
>    "lng" : 8.541658099999999   "lng": 8.5416581,
>    },   },
>    "southwest" : {   "southwest": {
>    "lat" : 48.9404298,   "lat": 48.9404298,
>    "lng" : 8.2774096   "lng": 8.2774096,
>    }   }
>    }   }
>    },   },
>    "place_id" : "ChIJCXjgokgGl0cRf-63THNV_LY",   "place_id": "ChIJCXjgokgGl0cRf-63THNV_LY",
>    "types" : [ "locality", "political" ]   "types": ["locality", "political"]
>    }   }
>    ],   ],
>    "status" : "OK"   "status": "OK"
>    }   Original von Google   }   via GSON serialisiert
> 
> 34 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 33 ──
> Beispiel Serialisierung (3)
> 
>    Änderungen in den Java-Klassen führen
>    automatisch dazu, dass auch der JSON-   Ergebnis der Serialisierung
>    Output sich verändert, z.B. ein   "geometry": {
>    zusätzliches Attribut alt in der   "bounds": {
>    "northeast": {
>    Klasse LatLon:   "lat": 49.0912684,
>    "lng": 8.5416581,
>    "alt": 123.4
>    public class LatLon {   },
>    private double lat;   "southwest": {
>    "lat": 48.9404298,
>    private double lng;   "lng": 8.2774096,
>    private double alt = 123.4;   "alt": 123.4
>    }
>    // evtl getter/setter   },
>    }   "location": {
>    "lat": 49.0068901,
>    "lng": 8.4036527,
>    Der entsprechende Inhalt wird bei der   "alt": 123.4
>    Instanziierung der LatLon-Objekte   },   Ausschnitt
> 
>    erzeugt und kommt nicht aus den
>    deserialisierten JSON-Objekt.
> 
> 35 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 34 ──
> Einstellungen (1)
> 
>    GsonBuilder erlaubt verschiedene Einstellungen, die
>    sich insb. auf die Serialisierung auswirken, z.B.
>    .serializeNulls()
>    Per Default werden Felder mit Wert null ignoriert.
>    .excludeFieldsWithModifiers(Modifier.STATIC,
>    Modifier.TRANSIENT, Modifier.VOLATILE)
>    Die Aufzählung darf alle Modifikatoren enthalten (beliebige Anzahl),
>    die ignoriert werden sollen.
>    .setPrettyPrinting()
>    Formatierte (statt kompakter) Ausgabe
>    .setFieldNamingPolicy(
>    FieldNamingPolicy.UPPER_CAMEL_CASE)
>    Formatierung der Attributnamen (hier: Großbuchstabe am Anfang)
> 
> 36 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 35 ──
> Einstellungen (2)
>    Für Attribute können per Annotation abweichende Namen vergeben werden:
>    public class SomeObject {
>    @SerializedName("custom_naming")
>    private final String someField;
>    private final String someOtherField;
> 
>    public SomeObject(String a, String b) {
>    this.someField = a;
>    this.someOtherField = b;
>    }
>    }
> 
>    Anwendung:
>    SomeObject someObject = new SomeObject("first", "second");
>    Gson gson =
>    new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
>    System.out.println(gson.toJson(someObject));
> 
>    Ausgabe
>    {"custom_naming":"first","SomeOtherField":"second"}
> 
>    Die Formatierung wirkt sich NICHT auf den explizit vergebenen Namen
>    (@SerializedName) aus
> 
> 37 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 36 ──
> Einschränkungen
> 
>    Es gibt einige Beschränkungen, insb. was die
>    Deserialisierung betrifft, z.B.
>    Generische Datentypen wie in class Beispiel<T> müssen
>    explizit angegeben werden
>    Explizite Serialisierung und Deserialisierung:
>    .registerTypeAdapter(AType.class,
>    new ATypeAdapter())
>    ebenso mit Serializer, Deserializer, InstanceCreator
>    z.B. implements JsonSerializer<AType>
> 
>    Details dazu unter
>    https://sites.google.com/site/gson/gson-user-guide
> 
> 38 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 37 ──
> Wie das Ganze funktioniert: „Reflection“
> 
>    Gson betrachtet die übergebenen Klassen und identifiziert
>    die entsprechenden Attribute per Reflection.
>    import java.lang.reflect.Field;
> 
>    public class RelfectionExample {
>    public static void main(String[] args) {
>    Class<?> c = Geometry.class;
>    System.out.println("class " + c.getName() + " {");
>    for (Field publicField : c.getFields()) {
>    String fieldName = publicField.getName();
>    String fieldType = publicField.getType().getName();
>    System.out.printf(" %s %s;%n", fieldType, fieldName);
>    }
>    System.out.println("}");
>    }
>    }
> 
>    Ausgabe
>    class de.dhbwka.java.slides.sem2.gson.Geometry {
>    de.dhbwka.java.slides.sem2.gson.BBox bounds;
>    de.dhbwka.java.slides.sem2.gson.LatLon location;
>    Auf den Folien bisher nicht zu sehen:   java.lang.String location_type;
>    Alle Klassen befinden sich im Package   de.dhbwka.java.slides.sem2.gson.BBox viewport;
>    de.dhbwka.java.slides.sem2.gson   }
> 
> 39 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 38 ──
> Aufgabe 1
> 
>    Erzeugen Sie eine JSON-Repräsentation eines
>    Wettrennens nach Aufgabe „Fahrzeuge“ aus dem
>    Aufgabenblatt „Vererbung (1)“!
> 
>    Hinweis: Falls Sie beim „Wettrennen“ die Fahrzeuge in
>    lokalen Variablen gespeichert haben, bauen Sie die Klasse
>    so um, dass diese in einem Attribut abgelegt und die
>    Fahrzeuge z.B. im Konstruktor hinzugefügt werden.
> 
> 40 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 39 ──
> Aufgabe 1 (Erwartetes Ergebnis)
>    {
>    "fz": [
>    {
>    "position": 80.0,
>    "geschwindigkeit": 20.0,
>    "vmax": 30.0
>    },
>    {
>    "position": 0.0,
>    "geschwindigkeit": 140.0,
>    "vmax": 140.0
>    },
>    {
>    "position": 0.0,
>    "geschwindigkeit": 200.0,
>    "vmax": 220.0
>    },
>    {
>    "blaulicht": false,
>    "position": 0.0,
>    "geschwindigkeit": 80.0,
>    "vmax": 140.0
>    }
>    ]
>    }
> 
> 41 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 40 ──
> Aufgabe 2
> 
>    Unter
>    http://api.geonames.org/citiesJSON?formatted=true&north=49.5&south=48.5&east=8.8&
>    west=8.2&lang=de&username=demo&style=full
>    lassen sich Informationen zu Städten (aus der Wikipedia)
>    als JSON-Datei abrufen.
>    Bauen Sie passende Java-Klassen zu diesem Dienst,
>    sortieren Sie das Ergebnis der Abfrage aufsteigend nach
>    der Bevölkerungsgröße („population“) und geben Sie es
>    auf der Konsole aus!
> 
>    Hinweis: Falls die dynamische Abfrage nicht funktioniert
>    gibt es eine statische JSON-Datei unter
>    https://www.iai.kit.edu/javavl/data/static/cities.json
> 
> 42 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 41 ──
> Aufgabe 2 (JSON-Input)
>    {"geonames": [
>    {
>    "fcodeName": "seat of a third-order administrative division",
>    "toponymName": "Mannheim",
>    "countrycode": "DE",
>    "fcl": "P",
>    "fclName": "city, village,...",
>    "name": "Mannheim",
>    "wikipedia": "en.wikipedia.org/wiki/Mannheim",
>    "lng": 8.479547,
>    "fcode": "PPLA3",
>    "geonameId": 2873891,
>    "lat": 49.496706,
>    "population": 307960
>    }
>    ]
>    }
> 
> 43 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> ```
