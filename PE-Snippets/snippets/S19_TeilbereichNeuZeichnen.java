package snippets;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
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
 * S19  NUR EINEN TEIL EINES FENSTERS NEU ZEICHNEN / AUSTAUSCHEN
 * ============================================================================
 * Das Fenster ist in Sektionen aufgeteilt. Jede Sektion zählt mit, wie oft sie
 * gezeichnet wurde (Anzeige unten), so sieht man, dass nur der betroffene Teil neu
 * gemalt wird.
 *
 *   +-------------------- NORTH: Kopfbereich (eigene Komponente) ----------------+
 *   | CENTER: Spielfeld (eigene Komponente,         | EAST: Seitenleiste         |
 *   |   einzelne Zellen per repaint(x,y,w,h))       |   (CardLayout: Liste/Info/ |
 *   |                                               |    Malen mit BufferedImage)|
 *   +---------- SOUTH: Wechselbereich (Inhalt austauschen) + Buttons -------------+
 *
 * WELCHE METHODE WANN?
 *   - Standard-Komponente geändert (label.setText, setBackground, setIcon, setEnabled)
 *       -> NICHTS tun, Swing zeichnet sie selbst neu.
 *   - Daten einer EIGENEN Zeichenkomponente geändert
 *       -> komponente.repaint()             (nur diese Komponente, nicht das ganze Fenster)
 *   - nur ein kleiner Bereich der Komponente betroffen
 *       -> komponente.repaint(x, y, breite, hoehe)
 *          paintComponent bekommt dann einen "Clip"; g.getClipBounds() sagt, welcher
 *          Bereich gezeichnet werden muss (optional: nur den zeichnen = schneller)
 *   - Komponenten in einem Panel hinzugefügt/entfernt (Struktur geändert)
 *       -> panel.revalidate(); panel.repaint();   (Layout neu berechnen + neu malen)
 *   - zwischen fertigen Ansichten wechseln
 *       -> CardLayout: cards.show(panel, "name") / cards.next(panel)
 *   - Zeichnung soll "stehen bleiben" (Malprogramm, Spuren)
 *       -> in ein BufferedImage malen, paintComponent zeigt nur das Bild
 *
 *   NICHT machen:
 *   - paintComponent(...) selbst aufrufen          -> immer repaint()
 *   - mit getGraphics() direkt auf die Komponente malen -> verschwindet beim nächsten repaint
 *   - Ganzes Fenster repainten, wenn nur ein Label/Feld betroffen ist (geht, ist aber unnötig)
 *   - repaint() aus einem eigenen Thread ist erlaubt (threadsicher), Daten-/Layout-
 *     änderungen aber per SwingUtilities.invokeLater (siehe S17)
 * Folien: 24_Zeichnen, 20_Swing (Layoutmanager)
 */
public class S19_TeilbereichNeuZeichnen extends JFrame {

    private static final long serialVersionUID = 1L;

    // =========================================================================
    // Sektion 1: Kopfbereich – eigene Komponente, wird komplett neu gezeichnet
    // =========================================================================
    static class Kopfbereich extends JComponent {

        private static final long serialVersionUID = 1L;
        private int punkte = 0;
        int paintZaehler = 0;

        public void setPunkte(int punkte) {
            this.punkte = punkte;
            repaint();                             // NUR der Kopfbereich wird neu gezeichnet
        }

        public int getPunkte() {
            return punkte;
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(0, 50);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            paintZaehler++;
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setPaint(new GradientPaint(0, 0, new Color(40, 80, 160), getWidth(), 0, new Color(90, 160, 220)));
            g2.fillRect(0, 0, getWidth(), getHeight());
            g2.setColor(Color.WHITE);
            g2.setFont(getFont().deriveFont(Font.BOLD, 22f));
            g2.drawString("Punkte: " + punkte, 15, 33);
        }
    }

    // =========================================================================
    // Sektion 2: Spielfeld – einzelne Zellen neu zeichnen mit repaint(x, y, w, h)
    // =========================================================================
    static class Spielfeld extends JComponent {

        private static final long serialVersionUID = 1L;
        private static final Color[] FARBEN = { Color.WHITE, new Color(255, 200, 80), new Color(120, 200, 120),
                new Color(120, 160, 240) };

        private final int[][] feld;
        private final int zelle;
        private Point zuletzt = null;              // zuletzt geänderte Zelle (wird markiert)
        int paintZaehler = 0;
        int zellenImLetztenPaint = 0;

        Spielfeld(int breite, int hoehe, int zelle) {
            this.feld = new int[breite][hoehe];
            this.zelle = zelle;
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    int x = e.getX() / Spielfeld.this.zelle;
                    int y = e.getY() / Spielfeld.this.zelle;
                    if (x < feld.length && y < feld[0].length) {
                        setZelle(x, y, (feld[x][y] + 1) % FARBEN.length);
                    }
                }
            });
        }

        /**
         * Eine Zelle ändern und NUR diese Zelle (+ die vorher markierte) neu zeichnen.
         * Hinweis: Mehrere repaint(...)-Aufrufe vor dem nächsten Zeichnen fasst Swing zu
         * EINEM umschließenden Rechteck zusammen (daher evtl. etwas mehr als 2 Zellen).
         */
        public void setZelle(int x, int y, int wert) {
            feld[x][y] = wert;
            if (zuletzt != null) {
                repaint(zellRechteck(zuletzt.x, zuletzt.y));   // alte Markierung entfernen
            }
            zuletzt = new Point(x, y);
            repaint(zellRechteck(x, y));           // <- nur dieses Rechteck
        }

        /** Alles ändern -> ganze Komponente neu zeichnen. */
        public void leeren() {
            for (int[] spalte : feld) {
                java.util.Arrays.fill(spalte, 0);
            }
            zuletzt = null;
            repaint();
        }

        public int getBreiteInZellen() {
            return feld.length;
        }

        public int getHoeheInZellen() {
            return feld[0].length;
        }

        private Rectangle zellRechteck(int x, int y) {
            return new Rectangle(x * zelle, y * zelle, zelle + 1, zelle + 1);   // +1 für den Rahmen
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(feld.length * zelle + 1, feld[0].length * zelle + 1);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            paintZaehler++;
            // Nur die Zellen zeichnen, die im neu zu zeichnenden Bereich (Clip) liegen
            Rectangle clip = g.getClipBounds();
            int x0 = Math.max(0, clip.x / zelle);
            int y0 = Math.max(0, clip.y / zelle);
            int x1 = Math.min(feld.length - 1, (clip.x + clip.width - 1) / zelle);
            int y1 = Math.min(feld[0].length - 1, (clip.y + clip.height - 1) / zelle);
            int anzahl = 0;
            for (int x = x0; x <= x1; x++) {
                for (int y = y0; y <= y1; y++) {
                    g.setColor(FARBEN[feld[x][y]]);
                    g.fillRect(x * zelle, y * zelle, zelle, zelle);
                    g.setColor(Color.GRAY);
                    g.drawRect(x * zelle, y * zelle, zelle, zelle);
                    anzahl++;
                }
            }
            if (zuletzt != null) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.RED);
                g2.setStroke(new BasicStroke(3));
                g2.drawRect(zuletzt.x * zelle + 2, zuletzt.y * zelle + 2, zelle - 4, zelle - 4);
            }
            zellenImLetztenPaint = anzahl;
        }
    }

    // =========================================================================
    // Malfläche: Striche bleiben in einem BufferedImage, repaint nur um den neuen Strich
    // =========================================================================
    static class Malflaeche extends JComponent {

        private static final long serialVersionUID = 1L;
        private final BufferedImage bild = new BufferedImage(180, 220, BufferedImage.TYPE_INT_RGB);
        private Point letzter;

        Malflaeche() {
            Graphics2D g = bild.createGraphics();
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, bild.getWidth(), bild.getHeight());
            g.dispose();
            MouseAdapter maus = new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    letzter = e.getPoint();
                }

                @Override
                public void mouseDragged(MouseEvent e) {
                    Point p = e.getPoint();
                    strich(letzter, p);
                    letzter = p;
                }
            };
            addMouseListener(maus);
            addMouseMotionListener(maus);       // für mouseDragged nötig!
        }

        /** Linie ins Bild malen und nur das umgebende Rechteck neu zeichnen. */
        void strich(Point a, Point b) {
            Graphics2D g = bild.createGraphics();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setColor(new Color(30, 60, 150));
            g.setStroke(new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g.drawLine(a.x, a.y, b.x, b.y);
            g.dispose();
            Rectangle r = new Rectangle(a);
            r.add(b);
            r.grow(4, 4);                          // Strichbreite berücksichtigen
            repaint(r);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(bild.getWidth(), bild.getHeight());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(bild, 0, 0, null);         // Bild zeigen, Clip sorgt für Teilbereich
        }
    }

    // =========================================================================
    // Seitenleiste mit Zähler (JPanel, das mitzählt)
    // =========================================================================
    static class ZaehlPanel extends JPanel {

        private static final long serialVersionUID = 1L;
        int paintZaehler = 0;

        ZaehlPanel(java.awt.LayoutManager layout) {
            super(layout);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            paintZaehler++;
        }
    }

    // ---- Felder ----------------------------------------------------------------
    private final Kopfbereich kopf = new Kopfbereich();
    private final Spielfeld spielfeld = new Spielfeld(10, 8, 34);
    private final CardLayout cards = new CardLayout();
    private final ZaehlPanel seitenleiste = new ZaehlPanel(cards);
    private final DefaultListModel<String> zuege = new DefaultListModel<>();
    private final JPanel wechselbereich = new JPanel(new BorderLayout());
    private final JLabel statistik = new JLabel(" ", SwingConstants.CENTER);
    private final Random rnd = new Random();
    private Timer autoDemo;
    private boolean wechselZustand = false;

    public S19_TeilbereichNeuZeichnen() {
        super("Teilbereiche neu zeichnen");

        add(kopf, BorderLayout.NORTH);

        JPanel mitte = new JPanel(new BorderLayout());
        mitte.setBorder(BorderFactory.createTitledBorder("Spielfeld (Klick = Zelle aendern)"));
        mitte.add(spielfeld, BorderLayout.CENTER);
        add(mitte, BorderLayout.CENTER);

        // ---- Seitenleiste: drei "Karten" -------------------------------------
        seitenleiste.setBorder(BorderFactory.createTitledBorder("Seitenleiste (CardLayout)"));
        seitenleiste.add(new JScrollPane(new JList<>(zuege)), "liste");
        seitenleiste.add(new JLabel("<html><b>Info-Karte</b><br>Umschalten mit<br>cards.next(panel)<br>"
                + "oder cards.show(panel, \"info\")</html>"), "info");
        JPanel malKarte = new JPanel(new BorderLayout());
        malKarte.add(new JLabel("Mit der Maus malen:"), BorderLayout.NORTH);
        malKarte.add(new Malflaeche(), BorderLayout.CENTER);
        seitenleiste.add(malKarte, "malen");
        seitenleiste.setPreferredSize(new Dimension(200, 0));
        add(seitenleiste, BorderLayout.EAST);

        // ---- Unten: Wechselbereich + Buttons + Statistik ----------------------
        wechselbereich.setBorder(BorderFactory.createTitledBorder("Wechselbereich (removeAll/add/revalidate)"));
        wechselbereich.add(new JLabel("Ansicht A: nur ein Label", SwingConstants.CENTER));

        JButton kopfButton = new JButton("Kopf: Punkte +1");
        kopfButton.addActionListener(e -> kopf.setPunkte(kopf.getPunkte() + 1));
        JButton zelleButton = new JButton("Zufaellige Zelle");
        zelleButton.addActionListener(e -> zufallsZelle());
        JButton leerenButton = new JButton("Spielfeld leeren");
        leerenButton.addActionListener(e -> spielfeld.leeren());
        JButton karteButton = new JButton("Seitenleiste: naechste Karte");
        karteButton.addActionListener(e -> cards.next(seitenleiste));
        JButton tauschButton = new JButton("Wechselbereich tauschen");
        tauschButton.addActionListener(e -> tauscheWechselbereich());
        JButton demoButton = new JButton("Auto-Demo an/aus");
        demoButton.addActionListener(e -> {
            if (autoDemo.isRunning()) {
                autoDemo.stop();
            } else {
                autoDemo.start();
            }
        });

        JPanel buttons = new JPanel(new GridLayout(2, 3, 4, 4));
        buttons.add(kopfButton);
        buttons.add(zelleButton);
        buttons.add(leerenButton);
        buttons.add(karteButton);
        buttons.add(tauschButton);
        buttons.add(demoButton);

        statistik.setFont(statistik.getFont().deriveFont(Font.PLAIN, 12f));
        JPanel unten = new JPanel(new BorderLayout(4, 4));
        unten.add(wechselbereich, BorderLayout.NORTH);
        unten.add(buttons, BorderLayout.CENTER);
        unten.add(statistik, BorderLayout.SOUTH);
        add(unten, BorderLayout.SOUTH);

        // Auto-Demo: ändert regelmäßig eine Zelle -> nur das Spielfeld wird (teilweise) neu gemalt
        autoDemo = new Timer(400, e -> zufallsZelle());
        autoDemo.start();
        // Statistik-Anzeige aktualisieren (ist ein Label -> zeichnet sich selbst neu)
        new Timer(250, e -> statistik.setText(String.format(
                "gezeichnet:  Kopf %dx  |  Spielfeld %dx (zuletzt %d von %d Zellen)  |  Seitenleiste %dx",
                kopf.paintZaehler, spielfeld.paintZaehler, spielfeld.zellenImLetztenPaint,
                spielfeld.getBreiteInZellen() * spielfeld.getHoeheInZellen(),
                seitenleiste.paintZaehler))).start();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void zufallsZelle() {
        int x = rnd.nextInt(spielfeld.getBreiteInZellen());
        int y = rnd.nextInt(spielfeld.getHoeheInZellen());
        int wert = 1 + rnd.nextInt(3);
        spielfeld.setZelle(x, y, wert);
        zuege.addElement("Zelle (" + x + "," + y + ") = " + wert);   // JList aktualisiert sich selbst
    }

    /** Inhalt einer Sektion austauschen: removeAll + add + revalidate + repaint. */
    private void tauscheWechselbereich() {
        wechselbereich.removeAll();
        wechselZustand = !wechselZustand;
        if (wechselZustand) {
            JPanel b = new JPanel(new GridLayout(1, 3, 4, 4));
            for (int i = 1; i <= 3; i++) {
                final int nr = i;
                JButton knopf = new JButton("B" + i);
                knopf.addActionListener(e -> kopf.setPunkte(kopf.getPunkte() + nr));
                b.add(knopf);
            }
            wechselbereich.add(b, BorderLayout.CENTER);
        } else {
            wechselbereich.add(new JLabel("Ansicht A: nur ein Label", SwingConstants.CENTER), BorderLayout.CENTER);
        }
        wechselbereich.revalidate();               // Layout neu berechnen
        wechselbereich.repaint();                  // neu zeichnen (sonst bleiben evtl. Reste stehen)
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(S19_TeilbereichNeuZeichnen::new);
    }
}
