---
tags: ["typ/uebung", "thema/io", "kategorie/io", "semester/1", "schwierigkeit/1", "hat/musterloesung"]
aliases: ["FileExperiments"]
thema: "[[15 Input und Output]]"
klasse: "FileExperiments"
package: "de.dhbwka.java.exercise.io"
schwierigkeit: 1
status: "offen"
---

# Ü15 Arbeiten mit Dateien

**Thema:** [[15 Input und Output]] · **Bereich:** Input/Output (1) · **Schwierigkeit:** ★☆☆☆☆
**Klasse:** `FileExperiments` · **Package:** `de.dhbwka.java.exercise.io`

📄 Aufgabe: [[Material/Aufgaben/15_IO_Aufgaben-1.pdf#page=1|15_IO_Aufgaben-1.pdf, S. 1]]
✅ Musterlösung: [[Material/Aufgaben/15_IO_Aufgaben-1_Muster.pdf#page=1|15_IO_Aufgaben-1_Muster.pdf, S. 1]]

> [!question] Kurz gesagt
> Schreiben Sie eine Klasse FileExperiments, welche in einem von Ihnen festgelegten Verzeichnis (siehe Hinweis unten) ein neues Verzeichnis „myDir“ anlegt und in diesem drei leere Dateien („foo1“, „foo2“ und „foo3“) anlegt! Geben Sie weiterhin den absoluten Pfad sowie den Inhalt (die Dateinamen) des Verzeichnisses „myDir“ aus!

## Aufgabenstellung
```text
Schreiben Sie eine Klasse FileExperiments, welche in einem von Ihnen festgelegten Verzeichnis
(siehe Hinweis unten) ein neues Verzeichnis „myDir“ anlegt und in diesem drei leere Dateien
(„foo1“, „foo2“ und „foo3“) anlegt!

Geben Sie weiterhin den absoluten Pfad sowie den Inhalt (die Dateinamen) des Verzeichnisses
„myDir“ aus!

Kontrollieren Sie (z.B. im Windows-Explorer), ob die Dateien und das Verzeichnis tatsächlich
angelegt wurden! Löschen Sie diese manuell!

Erweitern Sie anschließend die Klasse so, dass die drei Dateien und das Verzeichnis automatisch
wieder gelöscht werden.

Für das Auflisten von Dateien lohnt ein Blick auf folgende Methoden:
    - IO/File: myfile.listFiles / myfile.list
    - NIO/Path+Files: Files.newDirectoryStream

Hinweis:
Stellen Sie Ihre Entwicklungsumgebung so ein, dass die in diesen I/O-Übungsaufgaben erzeugten und
gelesenen Dateien in einem von Ihnen neu angelegten Verzeichnis liegen.
(In Eclipse: Im Package Explorer Rechtsklick auf das Projekt > Run As > Run Configurations > Java
Application auswählen > Reiter (x) Arguments anklicken > Working Directory: Other, über
Workspace Verzeichnis auswählen.
In NetBeans: File > Project-Properties > Run > Working Directory)
```

## Benötigte Begriffe
[[for-Schleife]] · [[Array]] · [[Exception]] · [[Datei und Pfad]]

## Weitere Übungen zum Thema
[[Ü15 Quersummen speichern]] · [[Ü15 Palindrome speichern]] · [[Ü15 Teil einer Datei]] · [[Ü15 Zugriff auf eine Textdatei]] · [[Ü15 Primzahlen speichern und lesen]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.io;
> 
> import java.io.File;
> import java.io.IOException;
> 
> public class FileExperiments {
> 
>     public static void main(String[] args) {
> 
>         File myDir = new File("myDir");
>         myDir.mkdir();
> 
>         File[] fooFiles = new File[3];
>         for (int i = 0; i < fooFiles.length; i++) {
>             fooFiles[i] = new File(myDir,"foo"+(i+1));
>             try {
>                 fooFiles[i].createNewFile();
>             } catch (IOException e) {
>                 System.err.println("Error creating File " +
>                 fooFiles[i].getAbsolutePath());
>             }
>         }
> 
>         System.out.println(myDir.getAbsolutePath());
>         for (File f : myDir.listFiles())
>         System.out.println(f.getAbsolutePath());
> 
>         // Erweiterung: Alles wieder löschen
>         for (File f : fooFiles)
>         f.delete();
>         myDir.delete();
> 
>     }
> 
> }
> ```

## Meine Notizen

