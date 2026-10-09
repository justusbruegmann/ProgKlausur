package snippets;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/*
 * ============================================================================
 * S06  SWING-GRUNDGERÜST: Fenster-Klasse mit BorderLayout + Grid + Buttonleiste
 * ============================================================================
 * Typische Aufgabe: "Schreiben Sie eine Klasse XyzWindow/XyzTerm, welche eine
 *   grafische Nutzeroberfläche ... erzeugt. Im oberen Bereich ein Label ...,
 *   darunter ... Buttons, unten ..."
 * Vorkommen: in JEDEM PE (SnatChatWindow, GameTerm, BieterTerminal, ConnectionTerm ...)
 * Folien: 20_Swing (Layoutmanager S. 28 ff.)
 *
 * Aufbau-Schema (fast immer passend):
 *
 *   +------------------ JFrame (BorderLayout) ------------------+
 *   |  NORTH:  Status-Label (farbig)                             |
 *   |  CENTER: JPanel mit GridLayout (Buttons/Felder)            |
 *   |  SOUTH:  JPanel mit FlowLayout (Aktions-Buttons)           |
 *   +-----------------------------------------------------------+
 *
 * Merke:
 *   - JFrame hat standardmäßig BorderLayout, JPanel hat FlowLayout
 *   - Pro BorderLayout-Bereich nur EINE Komponente -> mehrere? erst in ein JPanel
 *   - setVisible(true) als LETZTES (nach add + pack)
 *   - Mehrere Fenster: DISPOSE_ON_CLOSE (nur dieses Fenster) statt EXIT_ON_CLOSE (alles beenden)
 */
public class S06_SwingGrundgeruest extends JFrame {

    private static final long serialVersionUID = 1L;

    private final JLabel statusLabel = new JLabel("Bereit", SwingConstants.CENTER);
    private final JPanel gridPanel = new JPanel();
    private int counter = 0;

    public S06_SwingGrundgeruest(String title, int x, int y) {
        super(title);                                     // Fenstertitel

        // ---- NORTH: farbiges Status-Label ------------------------------------
        statusLabel.setOpaque(true);                      // sonst kein Hintergrund!
        statusLabel.setBackground(new Color(0, 150, 0));
        statusLabel.setForeground(Color.WHITE);
        statusLabel.setFont(statusLabel.getFont().deriveFont(Font.BOLD, 18f));
        statusLabel.setPreferredSize(new Dimension(0, 60)); // Höhe 60px, Breite egal
        add(statusLabel, BorderLayout.NORTH);

        // ---- CENTER: Raster -------------------------------------------------
        gridPanel.setLayout(new GridLayout(0, 3, 5, 5));  // 0 Zeilen = beliebig viele, 3 Spalten, Abstände 5px
        gridPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Innenabstand
        fillGrid(6);
        add(gridPanel, BorderLayout.CENTER);

        // ---- SOUTH: Buttonleiste --------------------------------------------
        JPanel south = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton addButton = new JButton("Mehr");
        JButton resetButton = new JButton("Reset");
        JButton closeButton = new JButton("Schliessen");
        addButton.addActionListener(e -> fillGrid(gridPanel.getComponentCount() + 3));
        resetButton.addActionListener(e -> {
            counter = 0;
            statusLabel.setText("Reset");
        });
        closeButton.addActionListener(e -> dispose());    // nur dieses Fenster schließen
        south.add(addButton);
        south.add(resetButton);
        south.add(closeButton);
        add(south, BorderLayout.SOUTH);

        // ---- Fenster-Einstellungen ------------------------------------------
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);       // bei nur einem Fenster: EXIT_ON_CLOSE
        pack();                                           // Größe aus Inhalt berechnen (oder setSize(w, h))
        setLocation(x, y);                                // oder setLocationRelativeTo(null) = Mitte
        setVisible(true);
    }

    /**
     * Inhalt eines Panels neu aufbauen: removeAll() + add(...) + revalidate() + repaint().
     * (Braucht man z. B., wenn sich eine Liste von Buttons ändert.)
     */
    private void fillGrid(int count) {
        gridPanel.removeAll();
        for (int i = 1; i <= count; i++) {
            final int nr = i;                             // effectively final -> im Lambda nutzbar
            JButton b = new JButton("Feld " + nr);
            b.addActionListener(e -> {
                counter++;
                statusLabel.setText("Feld " + nr + " geklickt (" + counter + "x)");
            });
            gridPanel.add(b);
        }
        gridPanel.revalidate();                           // Layout neu berechnen
        gridPanel.repaint();                              // neu zeichnen
        if (isDisplayable()) {
            pack();
        }
    }

    public static void main(String[] args) {
        // Zwei Fenster nebeneinander (wie z. B. zwei Bieter- oder Chat-Fenster)
        new S06_SwingGrundgeruest("Fenster 1", 100, 100);
        new S06_SwingGrundgeruest("Fenster 2", 500, 100);
    }
}
