package snippets;

import java.util.Objects;

/*
 * ============================================================================
 * S03  DATENKLASSE (Attribute, Konstruktoren, Getter, toString, equals, compareTo)
 * ============================================================================
 * Typische Aufgabe: "Schreiben Sie eine Klasse Message, die den Inhalt (text) und
 *   eine Referenz auf den Absender speichert. Der Konstruktor nimmt die Werte in
 *   exakt dieser Reihenfolge entgegen ..."
 * Vorkommen: in JEDEM PE (Account/Message, Question, Bieter/Ware/Gebot, Token/JPhone,
 *   Time/Stop, Quote, ImageDescription ...)
 * Folien: 09_Klassen_und_Objekte, 13_Vererbung (equals), 25_Datenstrukturen (hashCode, Comparable)
 *
 * TIPP Eclipse:  Rechtsklick > Source > Generate Constructor using Fields / Getters and Setters
 *                / toString() / hashCode() and equals()
 * TIPP IntelliJ: Alt+Einfg (Generate)
 * -> das ist erlaubte "deterministische Code-Completion".
 *
 * Merke:
 *   - Parameter-Reihenfolge im Konstruktor EXAKT wie in der Aufgabe (vorgegebene Klassen rufen ihn auf!)
 *   - Attributnamen wie in der Aufgabe in Klammern angegeben, z. B. (text), (sender)
 *   - Getter für boolean heißt isXxx()
 */
class Nachricht implements Comparable<Nachricht> {

    // Klassenvariable (static): EIN Zähler für alle Objekte -> fortlaufende IDs
    private static int nextId = 1;

    // Konstante
    public static final int MAX_LENGTH = 140;

    // Instanzvariablen
    private final int id;
    private final String text;
    private final String sender;
    private final long timestamp;   // Millisekunden seit 1970 (System.currentTimeMillis())
    private boolean read;           // Standardwert false

    /** Konstruktor wie in der Aufgabe gefordert. */
    public Nachricht(String text, String sender) {
        this(text, sender, System.currentTimeMillis());   // Constructor Chaining
    }

    /** Zweiter Konstruktor (überladen), z. B. beim Einlesen aus Datei. */
    public Nachricht(String text, String sender, long timestamp) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Text darf nicht leer sein");
        }
        this.id = nextId++;
        this.text = text.length() > MAX_LENGTH ? text.substring(0, MAX_LENGTH) : text;
        this.sender = sender;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getSender() {
        return sender;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    @Override
    public String toString() {
        return String.format("#%d %s: %s%s", id, sender, text, read ? " (gelesen)" : "");
    }

    /** Inhaltliche Gleichheit (hier: gleiche ID). Wer equals überschreibt, überschreibt auch hashCode! */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Nachricht)) {
            return false;
        }
        Nachricht other = (Nachricht) o;
        return id == other.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /** Natürliche Ordnung: nach Zeitstempel (für Collections.sort / TreeSet). */
    @Override
    public int compareTo(Nachricht other) {
        return Long.compare(this.timestamp, other.timestamp);
    }
}

// ---- Vererbung mit super(...) und toString-Erweiterung ------------------------
class Person {

    private final String vorname;
    private final String nachname;

    public Person(String vorname, String nachname) {
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public String getFullName() {
        return vorname + " " + nachname;
    }

    @Override
    public String toString() {
        return getFullName();
    }
}

class Bieter extends Person {

    private double guthaben;

    public Bieter(String vorname, String nachname, double guthaben) {
        super(vorname, nachname);
        this.guthaben = guthaben;
    }

    public double getGuthaben() {
        return guthaben;
    }

    public void abbuchen(double betrag) {
        if (betrag > guthaben) {
            throw new IllegalStateException("Nicht genug Guthaben");
        }
        guthaben -= betrag;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" (%.2f EUR)", guthaben);
    }
}

public class S03_Datenklasse {

    public static void main(String[] args) {
        Nachricht n1 = new Nachricht("Hallo!", "Anna");
        Nachricht n2 = new Nachricht("Alter Text", "Ben", System.currentTimeMillis() - 60_000);
        n2.setRead(true);
        System.out.println(n1);
        System.out.println(n2);
        System.out.println("n1.equals(n2)? " + n1.equals(n2) + ", compareTo: " + n1.compareTo(n2));

        java.util.List<Nachricht> list = new java.util.ArrayList<>(java.util.Arrays.asList(n1, n2));
        java.util.Collections.sort(list);          // nutzt compareTo
        System.out.println("sortiert: " + list);

        Bieter b = new Bieter("Micky", "Maus", 100);
        b.abbuchen(25.5);
        System.out.println(b + " / " + b.getFullName());
    }
}
