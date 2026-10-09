package snippets;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

/*
 * ============================================================================
 * S11  EIGENE ZEICHENKOMPONENTE (paintComponent) – Raster/Spielfeld
 * ============================================================================
 * Typische Aufgabe: "Stellen Sie den Raum als Raster dar, die Farbe einer Zelle
 *   entspricht der Viruslast" (CHORona), eigene Komponente wie StopComponent
 *   (DBVasion), Bild-/Fortschrittsanzeige (ChatterGPT), Wahl-Diagramm (Ü24 Wahl)
 * Folien: 24_Zeichnen
 *
 * Merke:
 *   - von JComponent (oder JPanel) erben, paintComponent(Graphics g) überschreiben
 *   - als erstes super.paintComponent(g)
 *   - Koordinaten: (0,0) = OBEN links, y wächst nach UNTEN
 *   - getPreferredSize() überschreiben, sonst ist die Komponente evtl. 0x0 groß
 *   - Daten ändern -> repaint() aufrufen (NIE paintComponent selbst aufrufen)
 *   - Graphics-Methoden: drawLine, drawRect/fillRect, drawOval/fillOval,
 *     drawString, fillPolygon, drawImage; Farbe vorher mit g.setColor(...)
 */
class RasterKomponente extends JComponent {

    private static final long serialVersionUID = 1L;

    private final double[][] werte;     // [x][y], Werte 0.0 .. 1.0
    private final int zellGroesse;
    private int markiertX = -1;
    private int markiertY = -1;

    public RasterKomponente(int breite, int hoehe, int zellGroesse) {
        this.werte = new double[breite][hoehe];
        this.zellGroesse = zellGroesse;

        // Mausklick -> welche Zelle?
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX() / RasterKomponente.this.zellGroesse;
                int y = e.getY() / RasterKomponente.this.zellGroesse;
                if (x < werte.length && y < werte[0].length) {
                    markiertX = x;
                    markiertY = y;
                    setWert(x, y, 1.0);
                }
            }
        });
    }

    public void setWert(int x, int y, double wert) {
        werte[x][y] = Math.max(0, Math.min(1, wert));
        repaint();                                   // neu zeichnen lassen
    }

    public double getWert(int x, int y) {
        return werte[x][y];
    }

    public int getRasterBreite() {
        return werte.length;
    }

    public int getRasterHoehe() {
        return werte[0].length;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(werte.length * zellGroesse + 1, werte[0].length * zellGroesse + 1);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (int x = 0; x < werte.length; x++) {
            for (int y = 0; y < werte[x].length; y++) {
                int px = x * zellGroesse;
                int py = y * zellGroesse;
                g2.setColor(farbeFuer(werte[x][y]));
                g2.fillRect(px, py, zellGroesse, zellGroesse);      // Fläche
                g2.setColor(Color.GRAY);
                g2.drawRect(px, py, zellGroesse, zellGroesse);      // Rahmen
            }
        }
        if (markiertX >= 0) {
            int px = markiertX * zellGroesse;
            int py = markiertY * zellGroesse;
            g2.setColor(Color.BLUE);
            g2.drawOval(px + 3, py + 3, zellGroesse - 6, zellGroesse - 6);   // Kreis in Zelle
            zeichneZentriert(g2, "X", px, py, zellGroesse, zellGroesse);
        }
    }

    /** Farbverlauf grün (0.0) -> gelb -> rot (1.0). */
    static Color farbeFuer(double v) {
        int r = (int) Math.min(255, 510 * v);
        int gr = (int) Math.min(255, 510 * (1 - v));
        return new Color(r, gr, 0);
    }

    /** Text zentriert in ein Rechteck schreiben. */
    static void zeichneZentriert(Graphics g, String text, int x, int y, int w, int h) {
        FontMetrics fm = g.getFontMetrics();
        int tx = x + (w - fm.stringWidth(text)) / 2;
        int ty = y + (h - fm.getHeight()) / 2 + fm.getAscent();
        g.drawString(text, tx, ty);
    }
}

public class S11_EigeneZeichenkomponente {

    public static void main(String[] args) {
        RasterKomponente raster = new RasterKomponente(15, 10, 30);
        Random rnd = new Random();
        // zufällige "Infizierte"
        for (int i = 0; i < 3; i++) {
            raster.setWert(rnd.nextInt(15), rnd.nextInt(10), 1.0);
        }

        JFrame f = new JFrame("Eigene Zeichenkomponente (Klick = Zelle markieren)");
        JLabel info = new JLabel(" Zeitschritt 0");
        f.add(raster, BorderLayout.CENTER);
        f.add(info, BorderLayout.SOUTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);

        // Simulation in Zeitscheiben: Wert breitet sich auf Nachbarn aus (vgl. S09 Timer)
        int[] schritt = { 0 };
        new Timer(500, e -> {
            double[][] neu = new double[raster.getRasterBreite()][raster.getRasterHoehe()];
            for (int x = 0; x < neu.length; x++) {
                for (int y = 0; y < neu[x].length; y++) {
                    double summe = 0;
                    int n = 0;
                    for (int dx = -1; dx <= 1; dx++) {
                        for (int dy = -1; dy <= 1; dy++) {
                            int nx = x + dx;
                            int ny = y + dy;
                            if (nx >= 0 && ny >= 0 && nx < neu.length && ny < neu[x].length) {   // Rand prüfen!
                                summe += raster.getWert(nx, ny);
                                n++;
                            }
                        }
                    }
                    neu[x][y] = Math.max(raster.getWert(x, y), summe / n * 1.1);
                }
            }
            for (int x = 0; x < neu.length; x++) {
                for (int y = 0; y < neu[x].length; y++) {
                    raster.setWert(x, y, neu[x][y]);
                }
            }
            info.setText(" Zeitschritt " + (++schritt[0]));
        }).start();
    }
}
