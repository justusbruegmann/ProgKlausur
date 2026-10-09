package snippets;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/*
 * ============================================================================
 * S13  ZUFALL UND ZEIT
 * ============================================================================
 * Vorkommen:
 *   Zufall: zufällige Farbe "nicht zu hell" (SnatChat), zufälliger Token-String
 *           (CoronaWarn: UUID), Verspätung auswürfeln (DBVasion), Infizierte
 *           platzieren (CHORona), Fragen mischen (SpeedyQuiz)
 *   Zeit:   Calendar fürs Auktionsende (jBay), new Date() (CoronaWarn),
 *           Unix-Timestamp-Prinzip (Hinweis in 42_ZumPE S. 23), hh:mm (DBVasion)
 * Folien: 07_Arrays (Zufallszahlen), 33_Java8 (java.time nicht explizit; erlaubt)
 */
public class S13_ZufallUndZeit {

    private static final Random RND = new Random();   // EINMAL anlegen, nicht in jeder Schleife neu

    // =========================================================================
    // ZUFALL
    // =========================================================================

    /** Ganzzahl im Bereich [min, max] (beide inklusive). nextInt(n) liefert 0..n-1 */
    static int zufall(int min, int max) {
        return min + RND.nextInt(max - min + 1);
    }

    /** true mit Wahrscheinlichkeit p (0.0 - 1.0), z. B. 0.3 = 30 % */
    static boolean mitWahrscheinlichkeit(double p) {
        return RND.nextDouble() < p;
    }

    /** Zufälliges Element einer Liste (Liste darf nicht leer sein). */
    static <T> T zufaelligesElement(List<T> list) {
        return list.get(RND.nextInt(list.size()));
    }

    /** Zufälliges Element eines Arrays, z. B. zufälliger Enum-Wert: zufaellig(Status.values()) */
    static <T> T zufaellig(T[] arr) {
        return arr[RND.nextInt(arr.length)];
    }

    /** k verschiedene Elemente ziehen (ohne Wiederholung). */
    static <T> List<T> ziehe(List<T> list, int k) {
        List<T> kopie = new ArrayList<>(list);
        Collections.shuffle(kopie, RND);
        return kopie.subList(0, Math.min(k, kopie.size()));
    }

    /** Zufällige Farbe, "nicht zu hell": jeder Kanal max. 199 (oder Helligkeit prüfen, s. u.). */
    static Color zufallsFarbeDunkel() {
        return new Color(RND.nextInt(200), RND.nextInt(200), RND.nextInt(200));
    }

    /** Alternative: so lange würfeln, bis die wahrgenommene Helligkeit unter einem Grenzwert liegt. */
    static Color zufallsFarbeNichtZuHell(double maxHelligkeit) {   // z. B. 0.7
        Color c;
        do {
            c = new Color(RND.nextInt(256), RND.nextInt(256), RND.nextInt(256));
        } while ((0.299 * c.getRed() + 0.587 * c.getGreen() + 0.114 * c.getBlue()) / 255.0 > maxHelligkeit);
        return c;
    }

    /** Zufälliger String, z. B. Token. */
    static String zufallsToken() {
        return UUID.randomUUID().toString();               // z. B. 3f2b1c8e-....
    }

    /** Zufälliger Code aus bestimmten Zeichen, z. B. 6 Großbuchstaben/Ziffern. */
    static String zufallsCode(int laenge) {
        String zeichen = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < laenge; i++) {
            sb.append(zeichen.charAt(RND.nextInt(zeichen.length())));
        }
        return sb.toString();
    }

    // =========================================================================
    // ZEIT
    // =========================================================================
    public static void main(String[] args) throws Exception {
        System.out.println("Wuerfel: " + zufall(1, 6) + ", 30%? " + mitWahrscheinlichkeit(0.3)
                + ", Element: " + zufaelligesElement(Arrays.asList("a", "b", "c"))
                + ", Lotto: " + ziehe(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 3));
        System.out.println("Farbe: " + zufallsFarbeDunkel() + " / " + zufallsFarbeNichtZuHell(0.7));
        System.out.println("Token: " + zufallsToken() + " / Code: " + zufallsCode(6));
        // Reproduzierbarer Zufall (zum Testen): new Random(42)

        // ---- Unix-Zeit: Millisekunden seit 01.01.1970 ------------------------
        long jetztMs = System.currentTimeMillis();
        long jetztSek = jetztMs / 1000;                     // "Unix-Timestamp" in Sekunden
        System.out.println("Unix-Sekunden: " + jetztSek);
        long ablauf = jetztMs + 5_000;                      // in 5 Sekunden
        boolean abgelaufen = System.currentTimeMillis() > ablauf;
        System.out.println("abgelaufen? " + abgelaufen + ", noch "
                + (ablauf - System.currentTimeMillis()) / 1000 + " s");

        // Laufzeit messen
        long start = System.nanoTime();
        Thread.sleep(20);
        System.out.println("Dauer: " + (System.nanoTime() - start) / 1_000_000 + " ms");

        // ---- java.util.Date (alt, aber in PEs vorgegeben) --------------------
        Date jetzt = new Date();                            // aktuelles Datum + Uhrzeit
        SimpleDateFormat fmt = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        System.out.println("Date: " + jetzt + " -> " + fmt.format(jetzt));
        Date geparst = fmt.parse("24.12.2026 18:30:00");    // ParseException möglich
        System.out.println("vorher? " + geparst.before(jetzt) + ", ms: " + geparst.getTime());

        // ---- java.util.Calendar (jBay: Auktionsende in X Minuten) -------------
        Calendar ende = Calendar.getInstance();             // jetzt
        ende.add(Calendar.MINUTE, 3);                       // + 3 Minuten (auch SECOND, HOUR, DAY_OF_MONTH)
        Calendar now = Calendar.getInstance();
        System.out.println("Ende: " + fmt.format(ende.getTime())
                + ", noch nicht vorbei? " + now.before(ende)
                + ", Rest-Sekunden: " + (ende.getTimeInMillis() - now.getTimeInMillis()) / 1000
                + ", Stunde: " + now.get(Calendar.HOUR_OF_DAY));

        // ---- java.time (Java 8+, modern) -----------------------------------
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter f2 = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        System.out.println("LocalDateTime: " + ldt.format(f2) + ", +90 min: " + ldt.plusMinutes(90).format(f2));
        LocalTime abfahrt = LocalTime.parse("08:15");
        LocalTime ankunft = abfahrt.plusMinutes(137);
        System.out.println("Abfahrt " + abfahrt + ", Ankunft " + ankunft + ", Dauer "
                + Duration.between(abfahrt, ankunft).toMinutes() + " min");

        // ---- hh:mm selbst formatieren ----------------------------------------
        int h = 8;
        int m = 5;
        System.out.println(String.format("%02d:%02d", h, m));                 // 08:05
        int sekunden = 125;
        System.out.println(String.format("%d:%02d", sekunden / 60, sekunden % 60));   // 2:05
    }
}
