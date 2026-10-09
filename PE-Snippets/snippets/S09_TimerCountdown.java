package snippets;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/*
 * ============================================================================
 * S09  TIMER, COUNTDOWN, "SELBSTZERSTÖRUNG", THREAD MIT SLEEP
 * ============================================================================
 * Typische Aufgabe: "Für jede Frage steht nur ein kurzer Antwortzeitraum zur
 *   Verfügung (10 Sekunden) ..." / "Nachrichten sind nur kurze Zeit lesbar und
 *   zerstören sich danach selbst" / "Simulieren Sie die Fahrt in Zeitschritten"
 * Vorkommen: SpeedyQuiz (Countdown), SnatChat (Nachrichten verschwinden),
 *   ChatterGPT (Zeitlimit), CHORona (Zeitscheiben), jBay (Auktionsende)
 * Folien: 27_Threads; javax.swing.Timer steht in der Java-API-Doku
 *
 * Merke:
 *   - javax.swing.Timer (NICHT java.util.Timer!) -> Code läuft im GUI-Thread,
 *     man darf direkt Labels ändern. Erste Wahl in der Prüfung.
 *   - NIE Thread.sleep(...) in einem ActionListener -> GUI friert ein.
 *   - Eigener Thread: GUI-Änderungen über SwingUtilities.invokeLater(...)
 *   - Timer beim Schließen des Fensters stoppen (sonst läuft er weiter)
 */
public class S09_TimerCountdown extends JFrame {

    private static final long serialVersionUID = 1L;

    private static final int START_SEKUNDEN = 10;

    private final JLabel countdownLabel = new JLabel(String.valueOf(START_SEKUNDEN), SwingConstants.CENTER);
    private int verbleibend = START_SEKUNDEN;
    private Timer countdownTimer;

    private final DefaultListModel<String> nachrichten = new DefaultListModel<>();

    private final JLabel threadLabel = new JLabel("Thread: -", SwingConstants.CENTER);
    private volatile boolean threadLaeuft = false;   // volatile: von mehreren Threads gelesen
    private Thread worker;

    public S09_TimerCountdown() {
        super("Timer & Countdown");
        countdownLabel.setFont(countdownLabel.getFont().deriveFont(Font.BOLD, 40f));
        countdownLabel.setOpaque(true);
        countdownLabel.setBackground(Color.WHITE);
        add(countdownLabel, BorderLayout.NORTH);

        // =====================================================================
        // 1) COUNTDOWN mit javax.swing.Timer (feuert alle 1000 ms)
        // =====================================================================
        countdownTimer = new Timer(1000, e -> {
            verbleibend--;
            countdownLabel.setText(String.valueOf(verbleibend));
            if (verbleibend <= 3) {
                countdownLabel.setBackground(Color.ORANGE);
            }
            if (verbleibend <= 0) {
                countdownTimer.stop();                    // WICHTIG: anhalten
                countdownLabel.setBackground(Color.RED);
                countdownLabel.setText("Zeit abgelaufen!");
                // -> hier z. B. naechsteFrage() aufrufen
            }
        });

        JButton start = new JButton("Countdown (neu) starten");
        start.addActionListener(e -> starteCountdown());

        // =====================================================================
        // 2) EINMALIGER Timer: Nachricht verschwindet nach 3 Sekunden
        // =====================================================================
        JButton senden = new JButton("Nachricht (3 s sichtbar)");
        senden.addActionListener(e -> {
            String msg = "Geheim #" + (nachrichten.size() + 1);
            nachrichten.addElement(msg);
            Timer selbstzerstoerung = new Timer(3000, ev -> nachrichten.removeElement(msg));
            selbstzerstoerung.setRepeats(false);          // nur einmal ausführen
            selbstzerstoerung.start();
        });

        // =====================================================================
        // 3) EIGENER THREAD mit sleep (z. B. Simulation in Zeitschritten)
        // =====================================================================
        JButton threadStart = new JButton("Thread start/stop");
        threadStart.addActionListener(e -> {
            if (threadLaeuft) {
                stoppeThread();
            } else {
                starteThread();
            }
        });

        JPanel buttons = new JPanel(new GridLayout(0, 1, 4, 4));
        buttons.add(start);
        buttons.add(senden);
        buttons.add(threadStart);
        buttons.add(threadLabel);
        add(buttons, BorderLayout.CENTER);
        add(new JScrollPane(new JList<>(nachrichten)), BorderLayout.SOUTH);

        // Timer/Thread beim Schließen beenden
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                countdownTimer.stop();
                stoppeThread();
            }
        });
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(320, 360);
        setLocationRelativeTo(null);
        setVisible(true);
        starteCountdown();
    }

    private void starteCountdown() {
        verbleibend = START_SEKUNDEN;
        countdownLabel.setText(String.valueOf(verbleibend));
        countdownLabel.setBackground(Color.WHITE);
        countdownTimer.restart();                         // stoppt + startet neu
    }

    private void starteThread() {
        threadLaeuft = true;
        worker = new Thread(() -> {
            int schritt = 0;
            while (threadLaeuft) {
                schritt++;
                final int s = schritt;                    // effectively final für invokeLater
                SwingUtilities.invokeLater(() -> threadLabel.setText("Thread: Schritt " + s));
                try {
                    Thread.sleep(500);                    // 0,5 s warten
                } catch (InterruptedException ex) {
                    break;                                // bei interrupt() sauber beenden
                }
            }
        });
        worker.setDaemon(true);                           // hält das Programm nicht am Leben
        worker.start();                                   // start(), NICHT run()!
    }

    private void stoppeThread() {
        threadLaeuft = false;
        if (worker != null) {
            worker.interrupt();
        }
    }

    // ---- Bonus: verbleibende Sekunden als mm:ss ----------------------------
    static String mmss(int sekunden) {
        return String.format("%02d:%02d", sekunden / 60, sekunden % 60);
    }

    public static void main(String[] args) {
        System.out.println("125 s = " + mmss(125));
        new S09_TimerCountdown();
    }
}
