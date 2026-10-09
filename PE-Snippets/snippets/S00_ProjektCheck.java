package snippets;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/*
 * ============================================================================
 * S00  PROJEKT-CHECK  (VOR der Prüfung einmal ausführen!)
 * ============================================================================
 * Zweck:  Prüfen, ob dein Prüfungsprojekt Swing kann und welche Java-Version läuft.
 *
 * Wenn "javax.swing ... is not accessible" oder "package javax.swing does not exist":
 *   -> Dein Projekt hat eine module-info.java. Dort muss stehen:
 *          requires java.desktop;
 *      (Vorlage: ../module-info.java.vorlage)
 *   -> ODER die module-info.java einfach löschen (dann "klassischer" Classpath).
 *
 * Folien: 42_ZumPE_Oktoberuebung S. 16 ("Projekt auch mit kleiner GUI-Testanwendung ausprobieren")
 */
public class S00_ProjektCheck {

    public static void main(String[] args) {
        System.out.println("Java-Version: " + System.getProperty("java.version"));
        System.out.println("Arbeitsverzeichnis (hier landen relative Dateipfade): "
                + new java.io.File(".").getAbsolutePath());

        // GUI immer im Event-Dispatch-Thread starten (sauber, aber in der Prüfung optional)
        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame("Projekt-Check");
            JLabel label = new JLabel("Swing laeuft! Java " + System.getProperty("java.version"),
                    SwingConstants.CENTER);
            JButton button = new JButton("Klick mich");
            button.addActionListener(e -> label.setText("Events funktionieren auch :)"));

            f.add(label, BorderLayout.CENTER);
            f.add(button, BorderLayout.SOUTH);
            f.setSize(380, 150);
            f.setLocationRelativeTo(null); // Bildschirmmitte
            f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            f.setVisible(true);
        });
    }
}
