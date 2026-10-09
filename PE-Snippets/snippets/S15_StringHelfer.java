package snippets;

import java.util.Arrays;
import java.util.List;

/*
 * ============================================================================
 * S15  STRING-HELFER: format, split, Vergleich, StringBuilder, sicher parsen
 * ============================================================================
 * Vorkommen: toString-Methoden ("Werte hintereinander hängen"), Ausgaben in Labels,
 *   Zeilen zerlegen beim Einlesen, Eingaben aus Textfeldern prüfen
 * Folien: 10_Strings_Wrapper, 05_Operatoren (printf)
 */
public class S15_StringHelfer {

    /** Zahl sicher parsen: bei Fehler Standardwert statt Exception. */
    static int parseIntOder(String s, int standard) {
        try {
            return Integer.parseInt(s.trim());
        } catch (NumberFormatException | NullPointerException e) {
            return standard;
        }
    }

    static double parseDoubleOder(String s, double standard) {
        try {
            return Double.parseDouble(s.trim().replace(',', '.'));   // "12,5" erlauben
        } catch (NumberFormatException | NullPointerException e) {
            return standard;
        }
    }

    /** String n-mal wiederholen (String.repeat gibt es erst ab Java 11). */
    static String wiederhole(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    /** Auf maximale Länge kürzen, mit "..." */
    static String kuerze(String s, int max) {
        return s.length() <= max ? s : s.substring(0, max - 3) + "...";
    }

    public static void main(String[] args) {
        // ---- format: %s String, %d Ganzzahl, %.2f Kommazahl, %5d rechtsbündig, %-10s linksbündig
        // ACHTUNG Locale: auf deutschem Windows liefert %.2f "3,14" (Komma)!
        //   Für Dateien, die wieder mit Double.parseDouble gelesen werden: String.format(Locale.US, "%.2f", x)
        String zeile = String.format("%-8s|%5d|%8.2f EUR|%s", "Anna", 42, 3.14159, true);
        System.out.println(zeile);
        System.out.printf("%02d:%02d Uhr%n", 8, 5);                 // %n = Zeilenumbruch
        System.out.println(String.format("%.1f %%", 12.345));       // Prozentzeichen: %%

        // ---- split -------------------------------------------------------------
        String csv = "ICE-509;Hamburg;;Muenchen;178.30";
        String[] teile = csv.split(";");                             // leere Felder in der Mitte bleiben
        System.out.println(teile.length + " Teile: " + Arrays.toString(teile));
        System.out.println(Arrays.toString("a;b;;".split(";")));      // leere Felder am ENDE fallen weg!
        System.out.println(Arrays.toString("a;b;;".split(";", -1)));  // -1 = alle behalten
        System.out.println(Arrays.toString("a|b.c".split("\\||\\."))); // | und . sind Regex -> escapen
        System.out.println(Arrays.toString("  viele   Leerzeichen ".trim().split("\\s+")));

        // ---- Vergleichen ------------------------------------------------------
        String a = "hallo";
        String b = new String("hallo");
        System.out.println("== " + (a == b) + " | equals " + a.equals(b)        // IMMER equals!
                + " | ignoreCase " + "Hallo".equalsIgnoreCase(a)
                + " | compareTo " + "Anna".compareTo("Ben"));                    // <0: alphabetisch vorher
        String eingabe = null;
        System.out.println("null-sicher: " + "ja".equals(eingabe));            // Konstante zuerst

        // ---- Untersuchen / Umbauen ----------------------------------------------
        String s = "Der Apfel faellt nicht weit vom Stamm";
        System.out.println(s.length() + " | " + s.charAt(4) + " | " + s.indexOf("Apfel")
                + " | " + s.contains("Stamm") + " | " + s.startsWith("Der") + " | " + s.endsWith("!")
                + " | " + s.substring(4, 9) + " | " + s.toUpperCase() + " | " + s.replace(" ", "_"));
        int vokale = 0;
        for (char c : s.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) {
                vokale++;
            }
        }
        System.out.println("Vokale: " + vokale + " | Ziffer? " + Character.isDigit('7')
                + " | Buchstabe? " + Character.isLetter('x'));

        // ---- StringBuilder (in Schleifen statt +=) --------------------------------
        StringBuilder sb = new StringBuilder();
        List<String> namen = Arrays.asList("Anna", "Ben", "Cem");
        for (int i = 0; i < namen.size(); i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(namen.get(i));
        }
        System.out.println(sb + " | join: " + String.join(" / ", namen)
                + " | reverse: " + new StringBuilder("Lagerregal").reverse());

        // ---- Zahl <-> String ---------------------------------------------------------
        int zahl = parseIntOder(" 42 ", 0);
        int kaputt = parseIntOder("4x2", -1);
        double d = parseDoubleOder("12,5", 0);
        String alsText = String.valueOf(zahl) + "" + Integer.toString(7);
        System.out.println(zahl + " " + kaputt + " " + d + " " + alsText + " | binaer: "
                + Integer.toBinaryString(10) + " | aus binaer: " + Integer.parseInt("1010", 2));

        System.out.println(wiederhole("=-", 10) + " | " + kuerze("Ein sehr langer Zitattext", 15));

        // ---- Zeilenumbruch in JLabel: HTML ----------------------------------------------
        String labelText = "<html>Frage 1:<br>" + "Antwort &lt;A&gt;" + "</html>";
        System.out.println(labelText);
    }
}
