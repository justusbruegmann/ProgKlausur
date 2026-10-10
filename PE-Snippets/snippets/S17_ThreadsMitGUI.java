package snippets;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

/*
 * ============================================================================
 * S17  THREADS + GUI
 * ============================================================================
 * Inhalt:
 *   (A) Uhr-Thread pro Fenster, "sekündlich die aktuelle Uhrzeit anzeigen"   (jBay Teilaufgabe e)
 *   (B) Runden-Countdown-Thread, der bei vorzeitiger Antwort verfällt       (SpeedyQuiz-Lösung)
 *   (C) Mehrere Worker-Threads gleichzeitig + EIN Gewinner (synchronized)   (Rennen, Ü13/Ü21 mit Threads)
 *   (D) SwingWorker: lange Arbeit im Hintergrund mit Fortschrittsbalken
 * Folien: 27_Threads (S. 24-25 "Digitale Uhr"), 20_Swing
 *
 * DIE GOLDENE REGEL:
 *   Swing ist NICHT threadsicher. Komponenten nur im Event-Dispatch-Thread (EDT) ändern.
 *   Aus einem eigenen Thread heraus daher:
 *        SwingUtilities.invokeLater(() -> label.setText("..."));
 *   (setText klappt meist auch direkt, aber invokeLater ist der saubere Weg – und bei
 *    Layout-Änderungen, add/remove, repaint-lastigen Sachen wichtig.)
 *   Umgekehrt: im ActionListener (= EDT) NIE lange rechnen oder sleep() -> GUI friert ein.
 *   Einfacher Takt ohne eigene Logik? -> javax.swing.Timer reicht (siehe S09).
 */
public class S17_ThreadsMitGUI extends JFrame {

    private static final long serialVersionUID = 1L;

    // =========================================================================
    // (A) Uhr-Thread: eigene Klasse, bekommt das Label, das er aktualisiert
    // =========================================================================
    static class UhrThread extends Thread {

        private final JLabel label;
        private final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

        UhrThread(JLabel label) {
            this.label = label;
            setDaemon(true);                       // Programm darf trotzdem enden
        }

        @Override
        public void run() {
            while (!isInterrupted()) {
                String zeit = format.format(Calendar.getInstance().getTime());
                SwingUtilities.invokeLater(() -> label.setText(zeit));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;                         // Fenster wurde geschlossen -> Ende
                }
            }
        }
    }

    // ---- Felder ----------------------------------------------------------------
    private final JLabel uhrLabel = new JLabel("--:--:--", SwingConstants.CENTER);
    private final UhrThread uhr = new UhrThread(uhrLabel);

    private final JLabel rundenLabel = new JLabel("Runde: -", SwingConstants.CENTER);
    private volatile int runde = 0;                 // wird von mehreren Threads gelesen

    private final JProgressBar[] bahnen = new JProgressBar[4];
    private final JLabel rennLabel = new JLabel("Rennen: bereit", SwingConstants.CENTER);
    private String gewinner = null;                 // geschützt durch synchronized(this)
    private JButton rennButton;

    private final JProgressBar arbeitsBalken = new JProgressBar(0, 100);
    private final JLabel arbeitsLabel = new JLabel("SwingWorker: bereit", SwingConstants.CENTER);

    public S17_ThreadsMitGUI() {
        super("Threads + GUI");
        setLayout(new GridLayout(0, 1, 6, 6));

        // ---- (A) Uhr ----------------------------------------------------------
        uhrLabel.setFont(uhrLabel.getFont().deriveFont(Font.BOLD, 28f));
        uhrLabel.setBorder(BorderFactory.createTitledBorder("(A) Uhr-Thread"));
        add(uhrLabel);
        uhr.start();

        // ---- (B) Runden-Countdown ----------------------------------------------
        JPanel rundenPanel = new JPanel(new BorderLayout(5, 5));
        rundenPanel.setBorder(BorderFactory.createTitledBorder("(B) Runden-Countdown (5 s)"));
        JButton neueRunde = new JButton("Neue Runde");
        JButton antwort = new JButton("Antworten");
        neueRunde.addActionListener(e -> starteRunde());
        antwort.addActionListener(e -> {
            runde++;                                // alter Countdown-Thread merkt das und endet
            rundenLabel.setText("Beantwortet! (Countdown verworfen)");
        });
        JPanel rundenButtons = new JPanel(new GridLayout(1, 2, 5, 5));
        rundenButtons.add(neueRunde);
        rundenButtons.add(antwort);
        rundenPanel.add(rundenLabel, BorderLayout.CENTER);
        rundenPanel.add(rundenButtons, BorderLayout.SOUTH);
        add(rundenPanel);

        // ---- (C) Rennen ------------------------------------------------------
        JPanel rennPanel = new JPanel(new GridLayout(0, 1, 2, 2));
        rennPanel.setBorder(BorderFactory.createTitledBorder("(C) 4 Threads gleichzeitig, 1 Gewinner"));
        for (int i = 0; i < bahnen.length; i++) {
            bahnen[i] = new JProgressBar(0, 100);
            bahnen[i].setStringPainted(true);      // Prozent/Text im Balken
            bahnen[i].setString("Laeufer " + (i + 1));
            rennPanel.add(bahnen[i]);
        }
        rennButton = new JButton("Rennen starten");
        rennButton.addActionListener(e -> starteRennen());
        rennPanel.add(rennLabel);
        rennPanel.add(rennButton);
        add(rennPanel);

        // ---- (D) SwingWorker ---------------------------------------------------
        JPanel workerPanel = new JPanel(new BorderLayout(5, 5));
        workerPanel.setBorder(BorderFactory.createTitledBorder("(D) SwingWorker"));
        JButton arbeitButton = new JButton("Lange Arbeit starten");
        arbeitButton.addActionListener(e -> starteArbeit(arbeitButton));
        arbeitsBalken.setStringPainted(true);
        workerPanel.add(arbeitsLabel, BorderLayout.NORTH);
        workerPanel.add(arbeitsBalken, BorderLayout.CENTER);
        workerPanel.add(arbeitButton, BorderLayout.SOUTH);
        add(workerPanel);

        // Threads beim Schließen beenden
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                uhr.interrupt();
                runde++;
            }
        });
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(420, 620);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // =========================================================================
    // (B) Countdown-Thread mit Runden-Nummer (Muster aus der SpeedyQuiz-Lösung)
    // =========================================================================
    private void starteRunde() {
        final int meineRunde = ++runde;             // Nummer DIESER Runde merken
        new Thread(() -> {
            for (int sek = 5; sek >= 0; sek--) {
                if (runde != meineRunde) {
                    return;                         // Runde ist schon vorbei (Antwort/neue Runde)
                }
                final int s = sek;
                SwingUtilities.invokeLater(() -> rundenLabel.setText("Runde " + meineRunde + ": noch " + s + " s"));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
            }
            if (runde == meineRunde) {
                runde++;
                SwingUtilities.invokeLater(() -> rundenLabel.setText("Zeit abgelaufen! (Runde " + meineRunde + ")"));
                // -> hier z. B. allen Clients NO_ANSWER setzen und naechsteRunde() aufrufen
            }
        }).start();
    }

    // =========================================================================
    // (C) Mehrere Threads, gemeinsamer Zustand -> synchronized
    // =========================================================================
    private void starteRennen() {
        rennButton.setEnabled(false);
        gewinner = null;
        rennLabel.setText("Rennen laeuft ...");
        Random rnd = new Random();
        for (int i = 0; i < bahnen.length; i++) {
            final JProgressBar bahn = bahnen[i];
            final String name = "Laeufer " + (i + 1);
            bahn.setValue(0);
            new Thread(() -> {
                int pos = 0;
                while (pos < 100) {
                    pos = Math.min(100, pos + 1 + rnd.nextInt(4));
                    final int p = pos;
                    SwingUtilities.invokeLater(() -> bahn.setValue(p));
                    try {
                        Thread.sleep(40 + rnd.nextInt(40));
                    } catch (InterruptedException e) {
                        return;
                    }
                }
                imZiel(name);
            }, name).start();
        }
    }

    /** synchronized: nur EIN Thread gleichzeitig -> es gibt genau einen Gewinner. */
    private synchronized void imZiel(String name) {
        if (gewinner == null) {
            gewinner = name;
            SwingUtilities.invokeLater(() -> {
                rennLabel.setText("Gewinner: " + name);
                rennButton.setEnabled(true);
            });
        }
    }

    // =========================================================================
    // (D) SwingWorker<Ergebnis, Zwischenwert>
    // =========================================================================
    private void starteArbeit(JButton button) {
        button.setEnabled(false);
        SwingWorker<Integer, String> worker = new SwingWorker<Integer, String>() {

            @Override
            protected Integer doInBackground() throws Exception {   // läuft im Hintergrund-Thread
                int summe = 0;
                for (int i = 1; i <= 20; i++) {
                    Thread.sleep(100);              // "lange Arbeit", z. B. Datei laden
                    summe += i;
                    setProgress(i * 5);             // 0..100 -> PropertyChange "progress"
                    publish("Schritt " + i + "/20");  // Zwischenstand an process()
                }
                return summe;
            }

            @Override
            protected void process(List<String> chunks) {   // läuft im EDT
                arbeitsLabel.setText(chunks.get(chunks.size() - 1));
            }

            @Override
            protected void done() {                 // läuft im EDT, wenn fertig
                try {
                    arbeitsLabel.setText("Fertig, Ergebnis = " + get());
                } catch (Exception ex) {
                    arbeitsLabel.setText("Fehler: " + ex.getMessage());
                }
                button.setEnabled(true);
            }
        };
        worker.addPropertyChangeListener(evt -> {
            if ("progress".equals(evt.getPropertyName())) {
                arbeitsBalken.setValue((Integer) evt.getNewValue());
            }
        });
        worker.execute();                           // NICHT run()
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(S17_ThreadsMitGUI::new);   // GUI im EDT starten
    }
}
