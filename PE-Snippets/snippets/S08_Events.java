package snippets;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/*
 * ============================================================================
 * S08  EVENTS: alle Arten, einen Listener zu schreiben
 * ============================================================================
 * Inhalt:
 *   (A) Lambda                      -> kürzeste Variante (Java 8+)
 *   (B) anonyme innere Klasse       -> "klassisch", geht immer
 *   (C) Fenster implementiert ActionListener + getSource()
 *   (D) Button-Raster per Schleife, jeder Button kennt seinen Index
 *   (E) Enter im Textfeld / Tastendruck
 *   (F) Maus: Klick-Position, Rechtsklick-Popupmenü
 *   (G) Fenster schließen abfangen (z. B. vorher speichern / nachfragen)
 * Vorkommen: in jedem PE ab Teilaufgabe c)/d) ("Die Buttons sollen nun um
 *   Interaktivität erweitert werden ...")
 * Folien: 23_Events, 22_Innere_Klassen, 33_Java8 (Lambdas)
 *
 * Merke: Variablen, die im Lambda / in der anonymen Klasse benutzt werden,
 *        müssen (effectively) final sein -> Schleifenvariable in "final int idx = i" kopieren.
 */
public class S08_Events extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private final JLabel info = new JLabel("Klick irgendwo hin", SwingConstants.CENTER);
    private final JButton buttonC1 = new JButton("C1");
    private final JButton buttonC2 = new JButton("C2");
    private int treffer = 0;

    public S08_Events() {
        super("Events");
        info.setOpaque(true);
        info.setBackground(Color.LIGHT_GRAY);
        add(info, BorderLayout.NORTH);

        JPanel center = new JPanel(new GridLayout(0, 4, 4, 4));

        // (A) Lambda --------------------------------------------------------
        JButton a = new JButton("A Lambda");
        a.addActionListener(e -> info.setText("Lambda geklickt"));
        center.add(a);

        // (B) anonyme innere Klasse -----------------------------------------
        JButton b = new JButton("B anonym");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                info.setText("Anonyme Klasse: " + e.getActionCommand());   // = Button-Text
            }
        });
        center.add(b);

        // (C) das Fenster selbst ist der Listener -> actionPerformed unten -----
        buttonC1.addActionListener(this);
        buttonC2.addActionListener(this);
        center.add(buttonC1);
        center.add(buttonC2);

        // (D) Button-Raster per Schleife ------------------------------------
        int geheim = new java.util.Random().nextInt(8);
        for (int i = 0; i < 8; i++) {
            final int idx = i;                         // effectively final Kopie!
            JButton feld = new JButton("Feld " + i);
            feld.addActionListener(e -> {
                JButton source = (JButton) e.getSource();
                if (idx == geheim) {
                    source.setBackground(Color.GREEN);
                    info.setText("Treffer in Feld " + idx + "!  (" + (++treffer) + ")");
                } else {
                    source.setBackground(Color.RED);
                    source.setEnabled(false);          // nicht nochmal klickbar
                    info.setText("Feld " + idx + " leer");
                }
            });
            center.add(feld);
        }
        add(center, BorderLayout.CENTER);

        // (E) Enter im Textfeld + einzelne Tasten -----------------------------
        JTextField eingabe = new JTextField();
        eingabe.addActionListener(e -> {               // feuert bei ENTER
            info.setText("Eingegeben: " + eingabe.getText());
            eingabe.setText("");
        });
        eingabe.addKeyListener(new KeyAdapter() {       // Adapter: nur benötigte Methode überschreiben
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    eingabe.setText("");
                }
            }
        });
        add(eingabe, BorderLayout.SOUTH);

        // (F) Maus: Klickposition + Popupmenü (Rechtsklick) auf dem Label --------
        JPopupMenu popup = new JPopupMenu();
        JMenuItem reset = new JMenuItem("Zuruecksetzen");
        reset.addActionListener(e -> info.setText("Popup: reset"));
        popup.add(reset);
        info.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    info.setText("Linksklick bei x=" + e.getX() + ", y=" + e.getY()
                            + (e.getClickCount() == 2 ? " (Doppelklick)" : ""));
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popup.show(e.getComponent(), e.getX(), e.getY());
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {      // Windows: Popup-Trigger beim Loslassen
                if (e.isPopupTrigger()) {
                    popup.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

        // (G) Schließen abfangen ---------------------------------------------
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int a = JOptionPane.showConfirmDialog(S08_Events.this, "Wirklich beenden?",
                        "Beenden", JOptionPane.YES_NO_OPTION);
                if (a == JOptionPane.YES_OPTION) {
                    // hier z. B. speichern / Log schreiben / bei Zentrale abmelden
                    dispose();                         // oder System.exit(0) für ALLE Fenster
                }
            }
        });

        setSize(560, 260);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /** (C) EIN Listener für mehrere Buttons: über getSource() unterscheiden. */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonC1) {
            info.setText("C1 ueber getSource()");
        } else if (e.getSource() == buttonC2) {
            info.setText("C2 ueber getSource()");
        }
    }

    public static void main(String[] args) {
        new S08_Events();
    }
}
