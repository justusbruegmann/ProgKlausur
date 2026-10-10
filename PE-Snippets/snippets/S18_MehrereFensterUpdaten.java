package snippets;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/*
 * ============================================================================
 * S18  MEHRERE FENSTER AKTUALISIEREN
 * ============================================================================
 * Szenario: eine Auktion, mehrere Bieter-Fenster + ein Hauptfenster (wie jBay:
 *   Auktionshaus + BieterTerminals). Alle zeigen denselben ZUSTAND an.
 *
 * Drei Wege, andere Fenster zu aktualisieren (alle drei sind unten eingebaut):
 *
 *   (1) MODELL + LISTENER (Beobachter-Muster) – die saubere Standardlösung
 *       Modell (Auktion) hat List<AuktionsListener>. Jede Änderung -> benachrichtigeAlle()
 *       -> jedes Fenster holt sich die neuen Werte und aktualisiert seine Labels.
 *       Vorteil: Modell kennt keine konkreten Fensterklassen.
 *
 *   (2) ELTERN-REFERENZ – Kind-Fenster bekommt im Konstruktor das Hauptfenster und ruft
 *       direkt dessen Methoden auf (parent.log(...), parent.fensterGeschlossen(this)).
 *       Typisch: "Bei Klick auf ... ist ein neues Fenster mit Details zu öffnen" (DBVasion).
 *
 *   (3) FENSTERLISTE – Hauptfenster merkt sich List<BieterFenster> und ruft für alle
 *       eine Methode auf (Hinweis an alle, alle nach vorne, alle schließen).
 *
 * Dazu: Änderungen aus einem HINTERGRUND-THREAD (Countdown, Robo-Bieter) -> Fenster
 *   werden per SwingUtilities.invokeLater im Event-Dispatch-Thread aktualisiert.
 *
 * Unterschied zu S10: S10 verteilt Nachrichten (Ereignisse), hier teilen alle Fenster
 *   einen gemeinsamen Zustand und zeigen ihn jeweils unterschiedlich an.
 * Folien: 21 (Interfaces), 23_Events (Beobachter), 27_Threads
 */

// ---- (1) Listener-Interface ---------------------------------------------------
interface AuktionsListener {

    /** Zustand der Auktion hat sich geändert -> Anzeige aktualisieren. */
    void auktionGeaendert(Auktion auktion);
}

// ---- (1) Modell -----------------------------------------------------------------
class Auktion {

    public static final double INCREMENT = 1.0;

    private final String ware;
    private double preis;
    private String hoechstbieter;              // null = noch kein Gebot
    private int restSekunden;
    private boolean beendet;

    // CopyOnWriteArrayList: Fenster dürfen sich während der Benachrichtigung an-/abmelden
    private final List<AuktionsListener> listener = new CopyOnWriteArrayList<>();

    public Auktion(String ware, double startpreis, int dauerSekunden) {
        this.ware = ware;
        this.preis = startpreis;
        this.restSekunden = dauerSekunden;
    }

    public void addListener(AuktionsListener l) {
        listener.add(l);
        l.auktionGeaendert(this);              // neues Fenster zeigt sofort den aktuellen Stand
    }

    public void removeListener(AuktionsListener l) {
        listener.remove(l);
    }

    /** Gebot abgeben. synchronized, weil auch der Robo-Bieter-Thread bietet. */
    public synchronized boolean bieten(String bieter, double betrag) {
        if (beendet || betrag < preis + INCREMENT || bieter.equals(hoechstbieter)) {
            return false;
        }
        preis = betrag;
        hoechstbieter = bieter;
        benachrichtigeAlle();
        return true;
    }

    /** Wird jede Sekunde vom Countdown-Thread aufgerufen. */
    public synchronized void tick() {
        if (beendet) {
            return;
        }
        restSekunden--;
        if (restSekunden <= 0) {
            beendet = true;
        }
        benachrichtigeAlle();
    }

    /** Countdown in eigenem Thread. */
    public void starteCountdown() {
        Thread t = new Thread(() -> {
            while (!isBeendet()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
                tick();
            }
        }, "Auktions-Countdown");
        t.setDaemon(true);
        t.start();
    }

    /** ALLE Listener informieren – immer im Event-Dispatch-Thread, egal wer aufruft. */
    private void benachrichtigeAlle() {
        if (SwingUtilities.isEventDispatchThread()) {
            for (AuktionsListener l : listener) {
                l.auktionGeaendert(this);
            }
        } else {
            SwingUtilities.invokeLater(this::benachrichtigeAlle);
        }
    }

    public String getWare() {
        return ware;
    }

    public synchronized double getPreis() {
        return preis;
    }

    public synchronized String getHoechstbieter() {
        return hoechstbieter;
    }

    public synchronized int getRestSekunden() {
        return restSekunden;
    }

    public synchronized boolean isBeendet() {
        return beendet;
    }
}

// ---- Bieter-Fenster: (1) Listener, (2) kennt sein Hauptfenster -----------------------
class BieterFenster extends JFrame implements AuktionsListener {

    private static final long serialVersionUID = 1L;

    private final Auktion auktion;
    private final String bieterName;
    private final HauptFenster haupt;          // (2) Eltern-Referenz

    private final JLabel preisLabel = new JLabel("", SwingConstants.CENTER);
    private final JLabel statusLabel = new JLabel("", SwingConstants.CENTER);
    private final JLabel zeitLabel = new JLabel("", SwingConstants.CENTER);
    private final JLabel hinweisLabel = new JLabel(" ", SwingConstants.CENTER);
    private final JButton bietenButton = new JButton("+1 EUR bieten");

    public BieterFenster(Auktion auktion, String bieterName, HauptFenster haupt, int x, int y) {
        super("Bieter: " + bieterName);
        this.auktion = auktion;
        this.bieterName = bieterName;
        this.haupt = haupt;

        setLayout(new GridLayout(0, 1, 4, 4));
        JLabel wareLabel = new JLabel(auktion.getWare(), SwingConstants.CENTER);
        wareLabel.setFont(wareLabel.getFont().deriveFont(Font.BOLD, 16f));
        preisLabel.setFont(preisLabel.getFont().deriveFont(Font.BOLD, 22f));
        statusLabel.setOpaque(true);
        add(wareLabel);
        add(preisLabel);
        add(statusLabel);
        add(zeitLabel);
        add(hinweisLabel);
        add(bietenButton);

        bietenButton.addActionListener(e -> {
            double gebot = auktion.getPreis() + Auktion.INCREMENT;
            if (auktion.bieten(bieterName, gebot)) {
                haupt.log(bieterName + " bietet " + String.format("%.2f", gebot));      // (2)
            } else {
                haupt.log(bieterName + ": Gebot abgelehnt");
            }
        });

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                auktion.removeListener(BieterFenster.this);   // (1) abmelden!
                haupt.fensterGeschlossen(BieterFenster.this); // (2) Hauptfenster informieren
            }
        });
        setSize(240, 260);
        setLocation(x, y);
        setVisible(true);
        auktion.addListener(this);             // zum Schluss anmelden
    }

    /** (1) Wird vom Modell aufgerufen – jedes Fenster zeigt den Zustand aus SEINER Sicht. */
    @Override
    public void auktionGeaendert(Auktion a) {
        preisLabel.setText(String.format("%.2f EUR", a.getPreis()));
        zeitLabel.setText("noch " + a.getRestSekunden() + " s");
        boolean vorne = bieterName.equals(a.getHoechstbieter());
        if (a.getHoechstbieter() == null) {
            statusLabel.setText("noch kein Gebot");
            statusLabel.setBackground(Color.LIGHT_GRAY);
        } else if (vorne) {
            statusLabel.setText("Du bist Hoechstbieter");
            statusLabel.setBackground(new Color(120, 220, 120));
        } else {
            statusLabel.setText("Ueberboten von " + a.getHoechstbieter());
            statusLabel.setBackground(new Color(240, 120, 120));
        }
        if (a.isBeendet()) {
            bietenButton.setEnabled(false);
            statusLabel.setText(vorne ? "GEWONNEN!" : "Auktion beendet");
        }
    }

    /** (3) Wird vom Hauptfenster über die Fensterliste aufgerufen. */
    public void zeigeHinweis(String text) {
        hinweisLabel.setText(text);
    }

    public String getBieterName() {
        return bieterName;
    }
}

// ---- Hauptfenster: (1) Listener, (3) Fensterliste ---------------------------------
class HauptFenster extends JFrame implements AuktionsListener {

    private static final long serialVersionUID = 1L;

    private final Auktion auktion;
    private final List<BieterFenster> offeneFenster = new ArrayList<>();   // (3)
    private final JLabel uebersicht = new JLabel("", SwingConstants.CENTER);
    private final JTextArea logArea = new JTextArea(8, 30);
    private volatile boolean roboLaeuft = false;

    public HauptFenster(Auktion auktion) {
        super("Auktionshaus");
        this.auktion = auktion;

        uebersicht.setOpaque(true);
        uebersicht.setBackground(new Color(220, 230, 255));
        uebersicht.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        add(uebersicht, BorderLayout.NORTH);

        logArea.setEditable(false);
        add(new JScrollPane(logArea), BorderLayout.CENTER);

        JTextField nameFeld = new JTextField("Goofy");
        JButton oeffnen = new JButton("Bieterfenster oeffnen");
        oeffnen.addActionListener(e -> oeffneBieterFenster(nameFeld.getText().trim()));
        JButton hinweis = new JButton("Hinweis an alle");
        hinweis.addActionListener(e -> {
            for (BieterFenster f : offeneFenster) {          // (3) über die Liste
                f.zeigeHinweis("Nur noch " + auktion.getRestSekunden() + " s!");
            }
        });
        JButton vorne = new JButton("Alle nach vorne");
        vorne.addActionListener(e -> offeneFenster.forEach(JFrame::toFront));
        JButton schliessen = new JButton("Alle schliessen");
        schliessen.addActionListener(e -> {
            for (BieterFenster f : new ArrayList<>(offeneFenster)) {   // Kopie: dispose() ändert die Liste!
                f.dispose();
            }
        });
        JButton robo = new JButton("Robo-Bieter (Thread) an/aus");
        robo.addActionListener(e -> toggleRoboBieter());

        JPanel buttons = new JPanel(new GridLayout(0, 2, 4, 4));
        buttons.add(nameFeld);
        buttons.add(oeffnen);
        buttons.add(hinweis);
        buttons.add(vorne);
        buttons.add(schliessen);
        buttons.add(robo);
        add(buttons, BorderLayout.SOUTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);   // Hauptfenster zu -> ganze Anwendung beenden
        auktionGeaendert(auktion);                 // Text setzen, damit pack() die richtige Größe kennt
        pack();
        setLocation(40, 40);
        setVisible(true);
        auktion.addListener(this);
    }

    public void oeffneBieterFenster(String name) {
        if (name.isEmpty()) {
            return;
        }
        int x = 40 + getWidth() + 10 + offeneFenster.size() * 250;   // nebeneinander
        BieterFenster f = new BieterFenster(auktion, name, this, x, 40);
        offeneFenster.add(f);
        log("Fenster geoeffnet: " + name + " (" + offeneFenster.size() + " offen)");
    }

    /** (2) Wird vom Kind-Fenster aufgerufen. */
    public void fensterGeschlossen(BieterFenster f) {
        offeneFenster.remove(f);
        log("Fenster geschlossen: " + f.getBieterName() + " (" + offeneFenster.size() + " offen)");
        auktionGeaendert(auktion);             // Übersicht (Anzahl Fenster) aktualisieren
    }

    /** (2) Wird von Kind-Fenstern aufgerufen. Kann auch aus Threads kommen -> invokeLater. */
    public void log(String text) {
        SwingUtilities.invokeLater(() -> {
            logArea.append(text + "\n");
            logArea.setCaretPosition(logArea.getDocument().getLength());
        });
    }

    /** (1) Übersicht aktualisieren. */
    @Override
    public void auktionGeaendert(Auktion a) {
        String bieter = a.getHoechstbieter() == null ? "-" : a.getHoechstbieter();
        uebersicht.setText(String.format("<html><b>%s</b><br>Preis: %.2f EUR | Hoechstbieter: %s<br>"
                + "Restzeit: %d s | offene Bieterfenster: %d%s</html>",
                a.getWare(), a.getPreis(), bieter, a.getRestSekunden(), offeneFenster.size(),
                a.isBeendet() ? " | <font color='red'>BEENDET</font>" : ""));
        if (a.isBeendet()) {
            roboLaeuft = false;
        }
    }

    /** Hintergrund-Thread, der automatisch bietet -> alle Fenster aktualisieren sich über (1). */
    private void toggleRoboBieter() {
        if (roboLaeuft) {
            roboLaeuft = false;
            return;
        }
        roboLaeuft = true;
        Thread robo = new Thread(() -> {
            Random rnd = new Random();
            while (roboLaeuft && !auktion.isBeendet()) {
                double gebot = auktion.getPreis() + 1 + rnd.nextInt(3);
                if (auktion.bieten("Robo", gebot)) {
                    log("Robo bietet " + String.format("%.2f", gebot) + " (aus " + Thread.currentThread().getName() + ")");
                }
                try {
                    Thread.sleep(1500 + rnd.nextInt(1000));
                } catch (InterruptedException e) {
                    return;
                }
            }
        }, "Robo-Thread");
        robo.setDaemon(true);
        robo.start();
        log("Robo-Bieter gestartet");
    }
}

public class S18_MehrereFensterUpdaten {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Auktion auktion = new Auktion("Retro-Gameboy", 10.0, 90);
            HauptFenster haupt = new HauptFenster(auktion);
            haupt.oeffneBieterFenster("Micky");
            haupt.oeffneBieterFenster("Donald");
            auktion.starteCountdown();
        });
    }
}
