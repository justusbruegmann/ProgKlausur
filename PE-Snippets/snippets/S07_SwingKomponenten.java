package snippets;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

/*
 * ============================================================================
 * S07  SWING-KOMPONENTEN: alles, was in PE-Hinweisen immer wieder steht
 * ============================================================================
 * Inhalt (Suchbegriffe):
 *   [LABEL]     farbiges Label: setOpaque, setBackground, zentriert, feste Höhe, Tooltip, HTML-Umbruch
 *   [ICON]      Icon auf Button/Label
 *   [TEXTFIELD] Zahl aus Textfeld lesen mit Fehlerbehandlung
 *   [TEXTAREA]  mehrzeilige Ausgabe mit Scrollbalken, Text anhängen
 *   [COMBOBOX]  Auswahlbox mit eigenen Objekten (laut PE-Vorbereitung "oft vergessen"!)
 *   [JLIST]     Liste mit DefaultListModel (Einträge hinzufügen/entfernen)
 *   [CHECKBOX] / [RADIO]
 *   [DIALOG]    JOptionPane: Meldung, Fehler, Eingabe, Ja/Nein, eigene Buttons
 * Vorkommen: Hinweise in CoronaWarn, SpeedyQuiz, DBVasion; ComboBox in 42_ZumPE S. 20-22
 * Folien: 20_Swing
 */
public class S07_SwingKomponenten extends JFrame {

    private static final long serialVersionUID = 1L;

    // ---- [COMBOBOX] Modellklasse: toString() bestimmt den angezeigten Text! ----
    static class Spieler {

        private final String name;
        private int punkte;

        Spieler(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name;            // <- wird in JComboBox/JList angezeigt
        }
    }

    private final JTextArea ausgabe = new JTextArea(6, 30);

    public S07_SwingKomponenten() {
        super("Swing-Komponenten");
        // Formular: Zeilen untereinander (BoxLayout), jede Zeile = Beschriftung links + Komponente rechts
        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        form.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // ---- [LABEL] farbiges, zentriertes Label mit fester Höhe + Tooltip ------
        JLabel status = new JLabel("ALARM", SwingConstants.CENTER);  // oder status.setHorizontalAlignment(JLabel.CENTER)
        status.setOpaque(true);                       // OHNE das kein Hintergrund!
        status.setBackground(Color.RED);
        status.setForeground(Color.WHITE);
        status.setFont(status.getFont().deriveFont(Font.BOLD, 16f));
        status.setPreferredSize(new Dimension(0, 50)); // Höhe 50px
        status.setToolTipText("Token: 1234-abcd (Tooltip beim Drueberfahren)");
        form.add(zeile("Status-Label:", status));

        // Zeilenumbruch im Label: HTML
        form.add(zeile("Mehrzeilig:", new JLabel("<html>Zeile 1<br><b>Zeile 2 fett</b></html>")));

        // ---- [ICON] Icon auf Button ------------------------------------------
        JButton iconButton = new JButton("Ticket kaufen");
        iconButton.setIcon(kreisIcon(Color.ORANGE, 20));      // button.setIcon(icon) bzw. new JButton(text, icon)
        iconButton.setEnabled(true);                          // setEnabled(false) = ausgegraut
        form.add(zeile("Button mit Icon:", iconButton));

        // ---- [TEXTFIELD] Zahl einlesen ----------------------------------------
        JTextField zahlFeld = new JTextField("42");
        JButton zahlButton = new JButton("Verdoppeln");
        zahlButton.addActionListener(e -> {
            try {
                int z = Integer.parseInt(zahlFeld.getText().trim());
                zahlFeld.setText(String.valueOf(z * 2));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Bitte eine ganze Zahl eingeben!", "Fehler",
                        JOptionPane.ERROR_MESSAGE);
                zahlFeld.requestFocus();
            }
        });
        zahlFeld.addActionListener(e -> zahlButton.doClick());   // Enter im Textfeld = Button klicken
        form.add(zeile("Textfeld:", nebeneinander(zahlFeld, zahlButton)));

        // ---- [COMBOBOX] mit eigenen Objekten ----------------------------------
        java.util.List<Spieler> spieler = new java.util.ArrayList<>();
        spieler.add(new Spieler("Anna"));
        spieler.add(new Spieler("Ben"));
        spieler.add(new Spieler("Cem"));
        // Konstruktor nimmt nur Array (oder Vector) -> Liste umwandeln:
        JComboBox<Spieler> combo = new JComboBox<>(spieler.toArray(new Spieler[0]));
        JButton comboButton = new JButton("Punkt fuer Auswahl");
        comboButton.addActionListener(e -> {
            Spieler s = (Spieler) combo.getSelectedItem();   // liefert Object -> Cast
            // Alternative: spieler.get(combo.getSelectedIndex());
            s.punkte++;
            log(s.getName() + " hat jetzt " + s.punkte + " Punkte");
        });
        // auf Auswahl-Änderung reagieren:
        combo.addActionListener(e -> log("Ausgewaehlt: " + combo.getSelectedItem()));
        form.add(zeile("ComboBox:", nebeneinander(combo, comboButton)));
        // Enum in ComboBox: new JComboBox<>(Status.values())

        // ---- [JLIST] mit DefaultListModel -------------------------------------
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("Eintrag 1");
        listModel.addElement("Eintrag 2");
        JList<String> liste = new JList<>(listModel);
        liste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JButton entfernen = new JButton("Auswahl entfernen");
        entfernen.addActionListener(e -> {
            int idx = liste.getSelectedIndex();     // -1 = nichts ausgewählt
            if (idx >= 0) {
                listModel.remove(idx);
            } else {
                listModel.addElement("Eintrag " + (listModel.size() + 1));
            }
        });
        JScrollPane listScroll = new JScrollPane(liste);
        listScroll.setPreferredSize(new Dimension(150, 70));
        form.add(zeile("JList:", nebeneinander(listScroll, entfernen)));

        // ---- [CHECKBOX] / [RADIO] ---------------------------------------------
        JCheckBox check = new JCheckBox("Sound an", true);
        check.addActionListener(e -> log("Checkbox: " + check.isSelected()));
        JPanel radios = new JPanel();
        JRadioButton leicht = new JRadioButton("leicht", true);
        JRadioButton schwer = new JRadioButton("schwer");
        ButtonGroup gruppe = new ButtonGroup();     // nur einer gleichzeitig wählbar
        gruppe.add(leicht);
        gruppe.add(schwer);
        radios.add(leicht);
        radios.add(schwer);
        schwer.addActionListener(e -> log("Modus: schwer"));
        leicht.addActionListener(e -> log("Modus: leicht"));
        form.add(zeile("Check/Radio:", nebeneinander(check, radios)));

        // ---- [DIALOG] Buttons, die die Dialoge zeigen -------------------------
        JButton dialogButton = new JButton("Dialoge zeigen");
        dialogButton.addActionListener(e -> dialogDemo());
        form.add(zeile("JOptionPane:", dialogButton));

        // ---- [TEXTAREA] Ausgabe unten -----------------------------------------
        ausgabe.setEditable(false);
        ausgabe.setLineWrap(true);
        ausgabe.setWrapStyleWord(true);

        add(form, BorderLayout.CENTER);
        add(new JScrollPane(ausgabe), BorderLayout.SOUTH);      // Scrollbalken!
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /** Eine Formularzeile: Beschriftung (feste Breite) links, Komponente rechts. */
    private static JPanel zeile(String beschriftung, JComponent komponente) {
        JPanel p = new JPanel(new BorderLayout(8, 0));
        JLabel l = new JLabel(beschriftung);
        l.setPreferredSize(new Dimension(110, 0));
        p.add(l, BorderLayout.WEST);
        p.add(komponente, BorderLayout.CENTER);
        p.setBorder(BorderFactory.createEmptyBorder(3, 0, 3, 0));
        p.setMaximumSize(new Dimension(Integer.MAX_VALUE, p.getPreferredSize().height));
        return p;
    }

    /** Zwei Komponenten nebeneinander: links breit, rechts so breit wie nötig. */
    private static JPanel nebeneinander(JComponent links, JComponent rechts) {
        JPanel p = new JPanel(new BorderLayout(5, 0));
        p.add(links, BorderLayout.CENTER);
        p.add(rechts, BorderLayout.EAST);
        return p;
    }

    /** [TEXTAREA] Zeile anhängen und nach unten scrollen. */
    private void log(String text) {
        ausgabe.append(text + "\n");
        ausgabe.setCaretPosition(ausgabe.getDocument().getLength());
    }

    /** [DIALOG] Die wichtigsten JOptionPane-Varianten. */
    private void dialogDemo() {
        // 1) Info-Meldung
        JOptionPane.showMessageDialog(this, "Gespeichert!");
        // 2) Fehler/Warnung: ERROR_MESSAGE, WARNING_MESSAGE, INFORMATION_MESSAGE, PLAIN_MESSAGE
        JOptionPane.showMessageDialog(this, "Datei fehlt!", "Fehler", JOptionPane.ERROR_MESSAGE);
        // 3) Texteingabe (null = Abbrechen)
        String name = JOptionPane.showInputDialog(this, "Dein Name?", "Spieler");
        if (name != null && !name.trim().isEmpty()) {
            log("Name: " + name);
        }
        // 4) Ja/Nein
        int antwort = JOptionPane.showConfirmDialog(this, "Wirklich beenden?", "Frage",
                JOptionPane.YES_NO_OPTION);
        log(antwort == JOptionPane.YES_OPTION ? "Ja gewaehlt" : "Nein gewaehlt");
        // 5) Eigene Buttons -> Index des geklickten Buttons (-1 = Fenster zu)
        String[] optionen = { "Hot shit", "Bullshit", "Weiss nicht" };
        int wahl = JOptionPane.showOptionDialog(this, "Wie ordnest du das Zitat ein?", "Auswahl",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, optionen, optionen[0]);
        log("Option: " + (wahl >= 0 ? optionen[wahl] : "abgebrochen"));
        // 6) Auswahl aus Liste
        Object auswahl = JOptionPane.showInputDialog(this, "Variante?", "Auswahl",
                JOptionPane.QUESTION_MESSAGE, null, optionen, optionen[1]);
        log("Liste: " + auswahl);
    }

    /** Hilfsmethode: farbiges Kreis-Icon erzeugen (ohne Bilddatei). */
    static ImageIcon kreisIcon(Color c, int size) {
        BufferedImage img = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        java.awt.Graphics2D g = img.createGraphics();
        g.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(c);
        g.fillOval(0, 0, size - 1, size - 1);
        g.dispose();
        return new ImageIcon(img);
    }

    /** Icon aus Datei laden und skalieren (siehe auch S14). */
    static ImageIcon ladeIcon(String pfad, int w, int h) {
        ImageIcon icon = new ImageIcon(pfad);
        Image scaled = icon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return new ImageIcon(scaled);
    }

    public static void main(String[] args) {
        new S07_SwingKomponenten();
    }
}
