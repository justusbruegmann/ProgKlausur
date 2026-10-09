---
tags: ["typ/uebung", "thema/xml", "kategorie/datenformate", "semester/2", "hat/musterloesung"]
aliases: ["Gazetteer"]
thema: "[[29 XML]]"
klasse: "Gazetteer"
package: "de.dhbwka.java.exercise.xml"
status: "offen"
---

# Ü29 Google-Maps-Gazetteer-Service

**Thema:** [[29 XML]] · **Bereich:** XML (1) · **Schwierigkeit:** –
**Klasse:** `Gazetteer` · **Package:** `de.dhbwka.java.exercise.xml`

📄 Aufgabe: [[Material/Aufgaben/29_XML_Aufgaben-1.pdf#page=1|29_XML_Aufgaben-1.pdf, S. 1]]
✅ Musterlösung: [[Material/Aufgaben/29_XML_Aufgaben-1_Muster.pdf#page=1|29_XML_Aufgaben-1_Muster.pdf, S. 1]]

> [!question] Kurz gesagt
> Viele WWW-Anwendungen zeigen geografische Daten in speziellen Kartenviewern an. Der bekannteste davon dürfte Google-Maps (https://maps.google.de) sein.

## Aufgabenstellung
```text
Viele WWW-Anwendungen zeigen geografische Daten in speziellen Kartenviewern an. Der
bekannteste davon dürfte Google-Maps (https://maps.google.de) sein.
Eine wesentliche Komponente solcher Dienste sind sog. „Gazetteer-Services“, die textuelle
Suchanfragen, z.B. „Pizza in Karlsruhe“ bearbeiten, und für solche Begriffe, die geografischen
Objekten entsprechen, Koordinaten (z.B. eine Bounding-Box oder einen Mittelpunkt) liefern.

Auch Google bietet einen solchen Gazetteer-Service an. Unter der URL
https://maps.googleapis.com/maps/api/geocode/xml?address=karlsruhe&sensor=false
(oder alternativ: https://www.iai.kit.edu/javavl/data/static/karlsruhe.xml)
kann man sich z.B. die entsprechenden Daten für Karlsruhe abholen (s.u).

Schreiben Sie ein Java-Programm, das eine solche Anfrage an den Gazetteer-Service von Google-
Maps macht, z.B. für Ihren Heimat- oder Wohnort, und die Ergebnisdaten einliest.
Lesen Sie den Namen (formatted_address, long_name des address_component-
Elements mit type="locality") und die Lage (location und bounds) aus und geben Sie
diese auf der Konsole aus. bounds liefert die Begrenzungspunkte im Südwesten und Nordosten, die
ein passendes Rechteck aufspannen, z.B. um die Kartenansicht auf diesen Bereich zu zoomen.

Beispiel: GeoCode-Response-Antwort für „Karlsruhe“:

<?xml version="1.0" encoding="UTF-8"?>
<GeocodeResponse>
      <status>OK</status>
      <result>
             <type>locality</type>
             <type>political</type>
             <formatted_address>Karlsruhe, Deutschland</formatted_address>
             <address_component>
                   <long_name>Karlsruhe</long_name>
                   <short_name>Karlsruhe</short_name>
                   <type>locality</type>
                   <type>political</type>
             </address_component>
             <address_component>
                   <long_name>Karlsruhe</long_name>
                   <short_name>KA</short_name>
                   <type>administrative_area_level_2</type>
                   <type>political</type>
             </address_component>
             <address_component>
                   <long_name>Baden-Württemberg</long_name>
                   <short_name>BW</short_name>
                   <type>administrative_area_level_1</type>
                   <type>political</type>
             </address_component>

             <address_component>
                   <long_name>Deutschland</long_name>
                   <short_name>DE</short_name>
                   <type>country</type>
                   <type>political</type>
             </address_component>
             <geometry>
                   <location>
                          <lat>49.0068901</lat>
                          <lng>8.4036527</lng>
                   </location>
                   <location_type>APPROXIMATE</location_type>
                   <viewport>
                          <southwest>
                                 <lat>48.9404299</lat>
                                 <lng>8.2774097</lng>
                          </southwest>
                          <northeast>
                                 <lat>49.0912684</lat>
                                 <lng>8.5416581</lng>
                          </northeast>
                   </viewport>
                   <bounds>
                          <southwest>
                                 <lat>48.9404299</lat>
                                 <lng>8.2774097</lng>
                          </southwest>
                          <northeast>
                                 <lat>49.0912684</lat>
                                 <lng>8.5416581</lng>
                          </northeast>
                   </bounds>
             </geometry>
             <place_id>ChIJCXjgokgGl0cRf-63THNV_LY</place_id>
      </result>
</GeocodeResponse>

Beispiel für zugehörige Ausgabe:
Adresse: Karlsruhe, Germany
Long Name: Karlsruhe
Location: (latitude=49.0068901, longitude=8.4036527)
Bounds: (east=8.5416581, north=49.0912684, west=8.2774096, south=48.9404298)
```

## Benötigte Begriffe
[[for-Schleife]] · [[break und continue]] · [[Konstruktor]] · [[this]] · [[static]] · [[toString]] · [[Überschreiben]] · [[equals und hashCode]] · [[Wrapperklasse]] · [[Exception]] · [[Swing]] · [[Binärbaum]] · [[XML]] · [[DOM]]

## Weitere Übungen zum Thema
[[Ü29 KML-Raster]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.xml;
> 
> public class Bounds {
>     public double south, north, west, east;
> 
>     public Bounds() {}
> 
>     public Bounds(String east, String north, String west, String south) {
>         this(Double.parseDouble(east), Double.parseDouble(north),
>         Double.parseDouble(west), Double.parseDouble(south));
>     }
> 
>     public Bounds(double east, double north, double west, double south) {
>         this.east = east;
>         this.north = north;
>         this.west = west;
>         this.south = south;
>     }
> 
>     @Override
>     public String toString() {
>         return "Bounds: (east="+east+", north="+north+", west="+west+
>         ", south="+south+")";
>     }
> 
> }
> 
> W. Geiger, T. Schlachter, C. Schmitt, W. Süß
> 
> package de.dhbwka.java.exercise.xml;
> 
> import java.io.IOException;
> import javax.xml.parsers.DocumentBuilder;
> import javax.xml.parsers.DocumentBuilderFactory;
> import javax.xml.parsers.ParserConfigurationException;
> import org.w3c.dom.DOMException;
> import org.w3c.dom.Document;
> import org.w3c.dom.Node;
> import org.w3c.dom.NodeList;
> import org.xml.sax.SAXException;
> 
> public class Gazetteer {
> 
>     public static Bounds getBounds(String queryTerm) {
>         Bounds result = new Bounds();
>         try {
>             DocumentBuilderFactory factory =
>             DocumentBuilderFactory.newInstance();
>             DocumentBuilder parser = factory.newDocumentBuilder();
>             String url =
>             "https://maps.googleapis.com/maps/api/geocode/xml?sensor=false&address="+queryTerm;
>             Document doc = parser.parse(url);
>             // Auf (einzige) formatted_address setzen und...
>             String form_adress = doc.getDocumentElement()
>             .getElementsByTagName("formatted_address")
>             .item(0).getTextContent();
>             System.out.println("Adresse: "+form_adress);
> 
>             String long_name = "kein locality-Name gefunden";
>             NodeList nl = doc.getDocumentElement()
>             .getElementsByTagName("address_component");
>             // evtl. mehrfach vorhanden!
>             for (int i=0; i<nl.getLength(); i++) {
>                 if (getNamedChildNode(nl.item(i),
>                 "type").getTextContent().equals("locality")) {
>                     long_name = getNamedChildNode(nl.item(i),
>                     "long_name").getTextContent();
>                     break;
>                 }
>             }
>             System.out.println("Long Name: "+long_name);
> 
>             //Lage
>             Node loc = doc.getDocumentElement().getElementsByTagName("location")
>             .item(0);
>             String lat = getNamedChildNode(loc, "lat").getTextContent();
>             String lng = getNamedChildNode(loc, "lng").getTextContent();
> 
>             W. Geiger, T. Schlachter, C. Schmitt, W. Süß
> 
>             System.out.println("Location: (latitude=" + lat + ""
>             + ", longitude=" + lng + ")");
> 
>             Node bounds = doc.getDocumentElement().getElementsByTagName("bounds")
>             .item(0);
>             result = new Bounds(
>             getNamedChildNode(getNamedChildNode(bounds,
>             "northeast"),"lng").getTextContent(), // east
>             getNamedChildNode(getNamedChildNode(bounds,
>             "northeast"),"lat").getTextContent(), // north
>             getNamedChildNode(getNamedChildNode(bounds,
>             "southwest"),"lng").getTextContent(), // west
>             getNamedChildNode(getNamedChildNode(bounds,
>             "southwest"),"lat").getTextContent() // south
>             );
>         } catch (ParserConfigurationException | SAXException | IOException
>         | DOMException ex) {
>             System.err.println("Fehler bei getBounds: "+ex.getMessage());
>         }
>         return result;
>     }
> 
>     // Liefert den ersten Kind-Koten mit dem angegebenen Namen
>     public static Node getNamedChildNode(Node n, String name) {
>         NodeList children = n.getChildNodes();
>         for(int i=0; i<children.getLength(); i++)
>         if (children.item(i).getNodeName().equals(name))
>         return children.item(i);
>         return null;
>     }
> 
>     public static void main(String[] args) {
>         System.out.println(getBounds("Karlsruhe"));
>     }
> }
> ```

## Meine Notizen

