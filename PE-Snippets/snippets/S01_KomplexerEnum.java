package snippets;

import java.awt.Color;
import java.util.EnumMap;
import java.util.Map;

/*
 * ============================================================================
 * S01  KOMPLEXER AUFZÄHLUNGSTYP (enum mit Attributen)
 * ============================================================================
 * Typische Aufgabe: "Schreiben Sie einen komplexen Aufzählungstyp X. Neben der
 *   Konstante speichert er ein Label (label), eine Farbe (color) und ..."
 * Vorkommen: 7 von 8 Probe-PEs. Beispiele: State (SnatChat), Variant (CHORona),
 *   WarnStatus (CoronaWarn), StopStatus (DBVasion), QuoteType (FakeTalk),
 *   ClassificationResultType (ChatterGPT), Status (SpeedyQuiz)
 * Folien: 26_Enum
 *
 * KOPIEREN: den gewünschten enum-Block in eine eigene Datei <Name>.java legen
 *           und "public" davor schreiben.
 * Typische Fehler:
 *   - Semikolon nach der letzten Konstante vergessen (nötig, sobald Attribute folgen)
 *   - Konstruktor "public" machen -> nicht erlaubt (ist automatisch private)
 *   - im switch "case Status.AWAY:" schreiben -> in Java 8 nur "case AWAY:"
 */

// ---- 1) Einfacher Enum ------------------------------------------------------
enum Richtung {
    NORD, OST, SUED, WEST
}

// ---- 2) Komplexer Enum (Label + Farbe + Zahl) -------------------------------
enum Status {
    AVAILABLE("Available", Color.GREEN, 3),
    AWAY("Away", Color.ORANGE, 1),
    DND("Do not disturb", new Color(200, 0, 0), 0);   // <- Semikolon!

    private final String label;
    private final Color color;
    private final int score;

    // Konstruktor: automatisch private, KEIN public davor
    Status(String label, Color color, int score) {
        this.label = label;
        this.color = color;
        this.score = score;
    }

    public String getLabel() {
        return label;
    }

    public Color getColor() {
        return color;
    }

    public int getScore() {
        return score;
    }

    /** Für JComboBox / JLabel / println: zeigt "Away" statt "AWAY". */
    @Override
    public String toString() {
        return label;
    }

    /** Nächster Wert, nach dem letzten wieder der erste (z. B. Status per Klick durchschalten). */
    public Status next() {
        Status[] all = values();
        return all[(ordinal() + 1) % all.length];
    }

    /** Wert anhand des Labels finden (z. B. beim Einlesen aus einer Datei). */
    public static Status fromLabel(String label) {
        for (Status s : values()) {
            if (s.label.equalsIgnoreCase(label.trim())) {
                return s;
            }
        }
        throw new IllegalArgumentException("Unbekannter Status: " + label);
    }
}

// ---- 3) Enum mit Text- UND Hintergrundfarbe (wie StopStatus in DBVasion) ----
enum Ampel {
    GRUEN("Fahren", Color.BLACK, new Color(0, 150, 0)),
    GELB("Achtung", Color.BLACK, Color.YELLOW),
    ROT("Stopp", Color.WHITE, Color.RED);

    private final String text;
    private final Color textColor;
    private final Color backgroundColor;

    Ampel(String text, Color textColor, Color backgroundColor) {
        this.text = text;
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;
    }

    public String getText() {
        return text;
    }

    public Color getTextColor() {
        return textColor;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    /** Label direkt einfärben, z. B. ampel.applyTo(statusLabel); */
    public void applyTo(javax.swing.JLabel label) {
        label.setOpaque(true);   // sonst wird der Hintergrund nicht gemalt!
        label.setText(text);
        label.setForeground(textColor);
        label.setBackground(backgroundColor);
    }
}

// Enum mit Icon (FakeTalk/ChatterGPT): Attribut einfach vom Typ javax.swing.ImageIcon,
//   z. B.  HOT_SHIT("Hot shit", FakeTalkIcons.ICON_HOT_SHIT, Color.GREEN)

public class S01_KomplexerEnum {

    public static void main(String[] args) {
        // alle Werte durchlaufen
        for (Status s : Status.values()) {
            System.out.println(s.name() + " | toString=" + s + " | score=" + s.getScore()
                    + " | ordinal=" + s.ordinal());
        }

        // Aus String: exakter Konstantenname -> valueOf, Label -> eigene Methode
        Status a = Status.valueOf("AWAY");
        Status b = Status.fromLabel("do not disturb");
        System.out.println(a + " -> next: " + a.next() + "   " + b + " -> next: " + b.next());

        // switch über Enum: im case OHNE "Status."
        switch (b) {
            case AVAILABLE:
                System.out.println("online");
                break;
            case AWAY:
                System.out.println("weg");
                break;
            default:
                System.out.println("bitte nicht stoeren");
        }

        // Vergleich: bei Enums ist == richtig (es gibt jede Konstante nur einmal)
        if (a == Status.AWAY) {
            System.out.println("a ist AWAY");
        }

        // Zähler pro Enum-Wert (z. B. wie viele Antworten richtig/falsch)
        Map<Status, Integer> count = new EnumMap<>(Status.class);
        for (Status s : new Status[] { Status.AWAY, Status.DND, Status.AWAY }) {
            count.put(s, count.getOrDefault(s, 0) + 1);
        }
        System.out.println(count);

        // Summe über ein Enum-Attribut
        int sum = 0;
        for (Status s : Status.values()) {
            sum += s.getScore();
        }
        System.out.println("Summe Scores: " + sum);

        System.out.println(Ampel.ROT + " -> " + Ampel.ROT.getText());
    }
}
