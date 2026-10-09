package snippets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * ============================================================================
 * S05  DATEI ZEILENWEISE EINLESEN, PARSEN, SCHREIBEN, ANHÄNGEN (Log)
 * ============================================================================
 * Typische Aufgabe: "Ändern Sie die loadXyz-Methode so ab, dass die Daten aus der
 *   bereitgestellten Textdatei xyz.txt zeilenweise eingelesen werden."
 *   Zeilenformat meist mit ; getrennt, z. B.
 *     ICE-509;Hamburg Altona;München Hbf;false;178.30      (DBVasion connections.txt)
 *     Frage;Antwort1;Antwort2;Antwort3;Antwort4;2          (SpeedyQuiz questions.txt)
 *     WILD_TYPE,10                                          (CHORona, Komma!)
 * Vorkommen: alle 8 Probe-PEs lesen oder schreiben Dateien
 * Folien: 15_InputOutput, 33_Java8 (NIO.2: Files/Paths)
 *
 * WICHTIG (Umlaute!): Die PE-Dateien sind UTF-8. new FileReader(datei) nimmt bis Java 17
 *   unter Windows den Windows-Zeichensatz -> aus "München" wird "MÃ¼nchen".
 *   Darum IMMER mit StandardCharsets.UTF_8 lesen/schreiben (siehe unten).
 *
 * Relative Pfade ("connections.txt") beziehen sich auf das ARBEITSVERZEICHNIS
 *   = Projektordner in Eclipse/IntelliJ (nicht der src-Ordner!).
 *   Dateien aus der Aufgabe also in den Projektordner legen (neben src).
 */
public class S05_DateiLesenSchreiben {

    // ---- Modellklasse für das Beispiel ---------------------------------------
    static class Verbindung {

        final String id;
        final String von;
        final String nach;
        final boolean regional;
        final double preis;

        Verbindung(String id, String von, String nach, boolean regional, double preis) {
            this.id = id;
            this.von = von;
            this.nach = nach;
            this.regional = regional;
            this.preis = preis;
        }

        @Override
        public String toString() {
            return String.format("%s: %s -> %s (%s) %.2f EUR", id, von, nach, regional ? "regional" : "fern", preis);
        }
    }

    // =========================================================================
    // 1) EINLESEN mit BufferedReader (Klassiker, Java 8)
    // =========================================================================
    public static List<Verbindung> ladeVerbindungen(String dateiname) throws IOException {
        List<Verbindung> result = new ArrayList<>();
        // try-with-resources: Datei wird automatisch geschlossen
        try (BufferedReader br = Files.newBufferedReader(Paths.get(dateiname), StandardCharsets.UTF_8)) {
            String line;
            int lineNo = 0;
            while ((line = br.readLine()) != null) {      // null = Dateiende
                lineNo++;
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) {
                    continue;                              // Leer-/Kommentarzeilen überspringen
                }
                String[] p = line.split(";");              // bei "|" oder "." escapen: split("\\|")
                if (p.length < 5) {
                    System.err.println("Zeile " + lineNo + " unvollstaendig: " + line);
                    continue;
                }
                try {
                    result.add(new Verbindung(
                            p[0].trim(),
                            p[1].trim(),
                            p[2].trim(),
                            Boolean.parseBoolean(p[3].trim()),     // "true"/"false"
                            Double.parseDouble(p[4].trim())));     // Dezimalpunkt! "12.90"
                } catch (NumberFormatException e) {
                    System.err.println("Zeile " + lineNo + " fehlerhaft: " + e.getMessage());
                }
            }
        }
        return result;
    }

    // =========================================================================
    // 2) EINLESEN, kurz: alle Zeilen auf einmal (Java 8, NIO.2)
    // =========================================================================
    public static List<String> alleZeilen(String dateiname) throws IOException {
        return Files.readAllLines(Paths.get(dateiname), StandardCharsets.UTF_8);
    }

    // Variante: Datei pro Objekt, z. B. "ICE-509.txt" zur Verbindung ICE-509
    public static List<String> zeilenZuId(String id) throws IOException {
        Path p = Paths.get(id + ".txt");
        if (!Files.exists(p)) {
            return new ArrayList<>();    // oder eigene Exception werfen
        }
        return Files.readAllLines(p, StandardCharsets.UTF_8);
    }

    // =========================================================================
    // 3) SCHREIBEN (Datei wird überschrieben)
    // =========================================================================
    public static void speichere(String dateiname, List<Verbindung> list) throws IOException {
        try (PrintWriter pw = new PrintWriter(
                new OutputStreamWriter(new FileOutputStream(dateiname), StandardCharsets.UTF_8))) {
            for (Verbindung v : list) {
                // gleiches Format wie beim Einlesen -> kann wieder geladen werden
                // (Zahlen NICHT mit String.format("%.2f") schreiben: deutsches Windows -> "12,90",
                //  das kann Double.parseDouble nicht lesen. Wenn formatiert: String.format(Locale.US, ...))
                pw.println(v.id + ";" + v.von + ";" + v.nach + ";" + v.regional + ";" + v.preis);
            }
        }
    }

    // =========================================================================
    // 4) ANHÄNGEN (Log-Datei), append = true
    // =========================================================================
    private static final SimpleDateFormat LOG_FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public static void log(String dateiname, String text) {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(dateiname, true), StandardCharsets.UTF_8)))) {   // true = anhängen
            pw.println("[" + LOG_FORMAT.format(new Date()) + "] " + text);
        } catch (IOException e) {
            e.printStackTrace();    // Log-Fehler sollen das Programm nicht abbrechen
        }
    }

    // =========================================================================
    // Demo
    // =========================================================================
    public static void main(String[] args) throws IOException {
        System.out.println("Arbeitsverzeichnis: " + new File(".").getAbsolutePath());

        String datei = "snippet-demo-connections.txt";
        // Testdatei erzeugen
        Files.write(Paths.get(datei), java.util.Arrays.asList(
                "# id;von;nach;regional;preis",
                "ICE-1171;Berlin Hbf;Basel SBB;false;176.20",
                "IRE-19673;Karlsruhe Hbf;Aalen Hbf;true;12.90",
                "",
                "KAPUTT;nur;drei",
                "IC-2036;Leipzig Hbf;Norddeich Mole;false;abc"), StandardCharsets.UTF_8);

        List<Verbindung> verbindungen = ladeVerbindungen(datei);
        verbindungen.forEach(System.out::println);

        speichere("snippet-demo-out.txt", verbindungen);
        System.out.println("Zurueckgelesen: " + alleZeilen("snippet-demo-out.txt"));

        log("snippet-demo.log", "Verbindungen geladen: " + verbindungen.size());
        log("snippet-demo.log", "Ticket gekauft: " + verbindungen.get(0).id);
        System.out.println("Log: " + alleZeilen("snippet-demo.log"));

        // Demo-Dateien wieder entfernen
        for (String f : new String[] { datei, "snippet-demo-out.txt", "snippet-demo.log" }) {
            Files.deleteIfExists(Paths.get(f));
        }
    }
}
