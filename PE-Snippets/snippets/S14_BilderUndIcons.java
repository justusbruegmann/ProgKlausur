package snippets;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/*
 * ============================================================================
 * S14  BILDER UND ICONS
 * ============================================================================
 * Vorkommen: QuoteType-Icons (FakeTalk), mainImage/referenceImage als ImageIcon
 *   (ChatterGPT), Ticket-Icon auf Button (DBVasion), JToggleButton-Icons (Ü23)
 * Folien: 20_Swing (Grundkomponenten), 24_Zeichnen
 *
 * Merke:
 *   - new ImageIcon("pfad.png") wirft KEINEN Fehler, wenn die Datei fehlt!
 *     -> icon.getIconWidth() == -1 heißt: nicht gefunden (Pfad prüfen, s. S05)
 *   - Relativer Pfad = Projektordner. Aus dem src/Classpath: getResource("/bilder/x.png")
 *   - Oft liefert die Vorgabe-Klasse die Icons schon fertig (FakeTalkIcons, createDLTicketIcon)
 */
public class S14_BilderUndIcons {

    /** Icon aus Datei laden; null, wenn nicht vorhanden. */
    static ImageIcon ladeIcon(String pfad) {
        ImageIcon icon = new ImageIcon(pfad);
        if (icon.getIconWidth() <= 0) {
            System.err.println("Bild nicht gefunden: " + new File(pfad).getAbsolutePath());
            return null;
        }
        return icon;
    }

    /** Icon aus dem Classpath (Bild liegt im src-Ordner, z. B. src/bilder/x.png). */
    static ImageIcon ladeIconAusClasspath(String pfad) {   // pfad z. B. "/bilder/x.png"
        URL url = S14_BilderUndIcons.class.getResource(pfad);
        return url == null ? null : new ImageIcon(url);
    }

    /** Icon skalieren (Seitenverhältnis: eine Seite -1 setzen). */
    static ImageIcon skaliere(ImageIcon icon, int breite, int hoehe) {
        Image img = icon.getImage().getScaledInstance(breite, hoehe, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    /** Icon selbst zeichnen (wenn kein Bild vorhanden ist oder als Platzhalter). */
    static ImageIcon erzeugeIcon(Color farbe, String text, int groesse) {
        BufferedImage img = new BufferedImage(groesse, groesse, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(farbe);
        g.fillRoundRect(0, 0, groesse - 1, groesse - 1, 12, 12);
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(2));
        g.drawRoundRect(1, 1, groesse - 3, groesse - 3, 12, 12);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, groesse / 3));
        int tw = g.getFontMetrics().stringWidth(text);
        g.drawString(text, (groesse - tw) / 2, groesse / 2 + groesse / 8);
        g.dispose();
        return new ImageIcon(img);
    }

    public static void main(String[] args) throws Exception {
        // Demo-Bild auf Platte speichern und wieder laden (ImageIO)
        File datei = new File("snippet-demo-bild.png");
        BufferedImage bild = new BufferedImage(120, 80, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bild.createGraphics();
        g.setColor(new Color(70, 130, 180));
        g.fillRect(0, 0, 120, 80);
        g.setColor(Color.WHITE);
        g.drawString("Demo-Bild", 30, 45);
        g.dispose();
        ImageIO.write(bild, "png", datei);

        ImageIcon geladen = ladeIcon(datei.getPath());
        ImageIcon klein = skaliere(geladen, 60, -1);       // Breite 60, Höhe passend
        ladeIcon("gibt-es-nicht.png");                     // zeigt die Fehlermeldung
        datei.delete();

        JFrame f = new JFrame("Bilder & Icons");
        f.setLayout(new FlowLayout());

        f.add(new JLabel(geladen));                        // Bild als Label

        JLabel mitText = new JLabel("Text unter Bild", klein, SwingConstants.CENTER);
        mitText.setHorizontalTextPosition(SwingConstants.CENTER);
        mitText.setVerticalTextPosition(SwingConstants.BOTTOM);
        f.add(mitText);

        JButton button = new JButton("Hot shit", erzeugeIcon(Color.GREEN, "HOT", 48));
        JButton button2 = new JButton(erzeugeIcon(Color.LIGHT_GRAY, "?", 48));   // nur Icon
        button.addActionListener(e -> button.setIcon(erzeugeIcon(Color.RED, "BS", 48)));   // Icon wechseln
        f.add(button);
        f.add(button2);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
