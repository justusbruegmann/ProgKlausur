---
tags: ["typ/uebung", "thema/xml", "kategorie/datenformate", "semester/2", "hat/musterloesung"]
aliases: ["Grid"]
thema: "[[29 XML]]"
klasse: "Grid"
package: "de.dhbwka.java.exercise.xml"
status: "offen"
---

# Ü29 KML-Raster

**Thema:** [[29 XML]] · **Bereich:** XML (2) · **Schwierigkeit:** –
**Klasse:** `Grid` · **Package:** `de.dhbwka.java.exercise.xml`

📄 Aufgabe: [[Material/Aufgaben/29_XML_Aufgaben-2.pdf#page=1|29_XML_Aufgaben-2.pdf, S. 1]]
✅ Musterlösung: [[Material/Aufgaben/29_XML_Aufgaben-2_Muster.pdf#page=1|29_XML_Aufgaben-2_Muster.pdf, S. 1]]

> [!question] Kurz gesagt
> In Google Earth, in Google Maps und in Kartenviewern wie dem ATLsoft-Viewer kann man zu Karten eigene Inhalte mit Hilfe verschiedener Dateiformate hinzufügen. Ein solches Format ist die „Keyhole Markup Language“ (KML).

## Aufgabenstellung
```text
In Google Earth, in Google Maps und in Kartenviewern wie dem ATLsoft-Viewer kann man zu Karten
eigene Inhalte mit Hilfe verschiedener Dateiformate hinzufügen. Ein solches Format ist die „Keyhole
Markup Language“ (KML).

KML-Dateien sind XML-Dateien und haben für Ortsmarkierungen etwa dieses Aussehen:

<?xml version="1.0" encoding="UTF-8"?>
<kml xmlns="http://earth.google.com/kml/2.2">
  <Document>
    <Placemark>
       <name>DHBW Karlsruhe</name>
       <description>In diesem Tempel des Wissens...</description>
       <Point>
         <coordinates>8.385401,49.024897</coordinates>
       </Point>
    </Placemark>
  </Document>
</kml>

Dabei entsprechen die Koordinaten dem Längen- bzw. Breitengrad des Ortes als Dezimalzahl.

Sie können diese Datei testen. Sie finden sie unter:
https://www.iai.kit.edu/javavl/data/static/dhbwka.xml

Lokale KML-Dateien lassen sich über Google Earth (muss installiert werden!) anzeigen.

Alternativ kann man zum Testen unter http://kmlviewer.nsspot.net/ KML-Dateien auf der Karte
anzeigen.

Schreiben Sie eine Java-Anwendung, die eine KML-Datei erzeugt. In dieser soll ein „Raster“ (5x5
Punkte) über die in der Aufgabe „Google-Maps-Gazetteer-Service“ ermittelten Koordinaten
(Bounding-Box aus southwest und northeast) Ihrer Stadt gelegt werden, d.h. es sollen 25
Punkte eingefügt werden, die jeweils den gleichen Abstand zu ihren Nachbarpunkten haben! Lassen
Sie sich die KML-Datei mit Google Earth (mit Datei > Öffnen…) oder Google Maps (falls Sie bei
Google angemeldet sind und Karten zu Google hochladen können) oder über den o.g. Dienst von
ATLsoft anzeigen.

Hinweis:
Die Grundstruktur des KML-Dokuments kann man wie folgt erzeugen:

...
DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
DocumentBuilder parser = factory.newDocumentBuilder();
Document doc = parser.newDocument();
Element kml = doc.createElementNS("http://earth.google.com/kml/2.2", "kml");
Element document = doc.createElement("Document");
kml.appendChild(document);
doc.appendChild(kml);
// Die Placemark-Elemente können nun hier erzeugt und an das Dokument angehängt
// werden.
```

## Benötigte Begriffe
[[Konstante]] · [[for-Schleife]] · [[Exception]] · [[Datenströme]] · [[Reader und Writer]] · [[Datei und Pfad]] · [[XML]] · [[DOM]]

## Weitere Übungen zum Thema
[[Ü29 Google-Maps-Gazetteer-Service]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.xml;
> 
> import java.io.File;
> import java.io.FileOutputStream;
> import java.io.OutputStreamWriter;
> import javax.xml.parsers.DocumentBuilder;
> import javax.xml.parsers.DocumentBuilderFactory;
> import javax.xml.transform.OutputKeys;
> import javax.xml.transform.Transformer;
> import javax.xml.transform.TransformerFactory;
> import javax.xml.transform.dom.DOMSource;
> import javax.xml.transform.stream.StreamResult;
> import org.w3c.dom.Document;
> import org.w3c.dom.Element;
> 
> public class Grid {
> 
>     public static final int GRIDS = 5; // Rastergröße
> 
>     public static void main(String[] args) {
>         Bounds kaBounds = Gazetteer.getBounds("Karlsruhe");
>         try {
>             DocumentBuilderFactory factory =
>             DocumentBuilderFactory.newInstance();
>             DocumentBuilder parser = factory.newDocumentBuilder();
>             Document doc = parser.newDocument();
>             Element kml = doc.createElementNS(
>             "http://earth.google.com/kml/2.2", "kml");
>             Element document = doc.createElement("Document");
>             kml.appendChild(document);
>             doc.appendChild(kml);
>             int i = 0;
>             double stepx = (kaBounds.east - kaBounds.west) / (GRIDS-1);
>             double stepy = (kaBounds.north - kaBounds.south) / (GRIDS-1);
>             for (double y = kaBounds.south; y <= kaBounds.north;
>             y += stepy)
>             for (double x = kaBounds.west; x <= kaBounds.east;
>             x += stepx) {
>                 String coord = x + "," + y + ",0";
>                 Element pm = doc.createElement("Placemark");
>                 // Element "name" erzeugen und anhängen
> 
>                 W. Geiger, T. Schlachter, C. Schmitt, W. Süß
> 
>                 Element name = doc.createElement("name");
>                 name.setTextContent("Punkt " + i);
>                 pm.appendChild(name);
>                 // Element "description" erzeugen und anhängen
>                 Element description =
>                 doc.createElement("description");
>                 description.setTextContent("Koordinaten: " +
>                 coord);
>                 pm.appendChild(description);
>                 // Element "point" erzeugen und anhängen
>                 Element point = doc.createElement("Point");
>                 pm.appendChild(point);
>                 // Element "point" erzeugen, an "point" anhängen
>                 Element coordinates =
>                 doc.createElement("coordinates");
>                 coordinates.setTextContent(coord);
>                 point.appendChild(coordinates);
>                 // neues "placemark" an kml anhängen
>                 document.appendChild(pm);
>                 i++;
>             }
>             TransformerFactory tFactory =
>             TransformerFactory.newInstance();
>             tFactory.setAttribute("indent-number", 2);
>             Transformer transformer = tFactory.newTransformer();
>             transformer.setOutputProperty(OutputKeys.INDENT, "yes");
>             DOMSource source = new DOMSource(doc);
>             StreamResult result = new StreamResult(
>             new OutputStreamWriter(new FileOutputStream(
>             new File("karlsruhe.kml")), "UTF-8"));
>             transformer.transform(source, result);
>         } catch (Exception ex) {
>         }
>     }
> 
> }
> ```

## Meine Notizen

