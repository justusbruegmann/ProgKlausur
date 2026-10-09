package snippets;

/*
 * ============================================================================
 * S04  EIGENE EXCEPTION + PLAUSIBILITÄTSPRÜFUNG
 * ============================================================================
 * Typische Aufgabe: "Ist dies nicht der Fall, ist eine selbst zu schreibende,
 *   sprechende DBException zu werfen, deren Nachricht auf den gültigen
 *   Wertebereich hinweist!"
 * Vorkommen: DBException (DBVasion), AHAException (CHORona), GameException
 *   (SpeedyQuiz), FakeTalk, ChatterGPT
 * Folien: 14_Exceptions
 *
 * KOPIEREN: Exception-Klasse in eigene Datei, "public class ... extends Exception".
 * Merke:
 *   - extends Exception         -> "checked": Methode braucht "throws XyException"
 *   - extends RuntimeException  -> "unchecked": kein throws nötig
 *   - Nachricht über super(message) weitergeben, dann liefert getMessage() den Text
 */

// ---- 1) Checked Exception ----------------------------------------------------
class TimeException extends Exception {

    private static final long serialVersionUID = 1L;   // optional, vermeidet Warnung

    public TimeException(String message) {
        super(message);
    }

    /** Variante mit Ursache (z. B. NumberFormatException einpacken). */
    public TimeException(String message, Throwable cause) {
        super(message, cause);
    }
}

// ---- 2) Unchecked Variante (falls kein throws gewünscht) ------------------------
class GameRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public GameRuntimeException(String message) {
        super(message);
    }
}

// ---- 3) Klasse, die prüft und wirft ------------------------------------------
class Uhrzeit {

    private final int hour;
    private final int minute;

    public Uhrzeit(int hour, int minute) throws TimeException {
        if (hour < 0 || hour > 23) {
            throw new TimeException("Stunde muss im Bereich 0-23 liegen, war aber " + hour);
        }
        if (minute < 0 || minute > 59) {
            throw new TimeException("Minute muss im Bereich 0-59 liegen, war aber " + minute);
        }
        this.hour = hour;
        this.minute = minute;
    }

    /** "08:15" -> Uhrzeit. Wandelt Parse-Fehler in die eigene Exception um. */
    public static Uhrzeit parse(String hhmm) throws TimeException {
        String[] parts = hhmm.trim().split(":");
        if (parts.length != 2) {
            throw new TimeException("Format muss hh:mm sein: " + hhmm);
        }
        try {
            return new Uhrzeit(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
        } catch (NumberFormatException e) {
            throw new TimeException("Keine Zahl in: " + hhmm, e);
        }
    }

    /** Neue Uhrzeit + Minuten (über Mitternacht hinweg). */
    public Uhrzeit plusMinutes(int minutes) {
        int total = ((hour * 60 + minute + minutes) % (24 * 60) + 24 * 60) % (24 * 60);
        try {
            return new Uhrzeit(total / 60, total % 60);
        } catch (TimeException e) {
            throw new IllegalStateException(e);   // kann hier nicht passieren
        }
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    /** Ausgabe als hh:mm mit führender Null, z. B. 08:05 */
    @Override
    public String toString() {
        return String.format("%02d:%02d", hour, minute);
    }
}

public class S04_EigeneException {

    public static void main(String[] args) {
        // try/catch/finally
        try {
            Uhrzeit t = new Uhrzeit(8, 5);
            System.out.println("ok: " + t + ", +70 min = " + t.plusMinutes(70));
            new Uhrzeit(24, 0);                       // wirft
            System.out.println("wird nicht erreicht");
        } catch (TimeException e) {
            System.out.println("Fehler: " + e.getMessage());
            // In der GUI stattdessen:
            // JOptionPane.showMessageDialog(this, e.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
        } finally {
            System.out.println("finally laeuft immer");
        }

        // Parse-Fehler -> eigene Exception mit Ursache
        try {
            Uhrzeit.parse("ab:cd");
        } catch (TimeException e) {
            System.out.println("Fehler: " + e.getMessage() + " / Ursache: " + e.getCause());
        }

        // Multi-Catch (ab Java 7)
        try {
            Object o = args.length > 99 ? "x" : null;
            o.toString();
        } catch (NullPointerException | IllegalStateException e) {
            System.out.println("Multi-Catch: " + e.getClass().getSimpleName());
        }

        // Unchecked: kein throws nötig, kann trotzdem gefangen werden
        try {
            throw new GameRuntimeException("Spiel schon beendet");
        } catch (GameRuntimeException e) {
            System.out.println("Runtime: " + e.getMessage());
        }
    }
}
