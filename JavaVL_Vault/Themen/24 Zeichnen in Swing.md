---
tags: ["typ/thema", "thema/zeichnen", "kategorie/gui", "semester/2"]
aliases: ["Zeichnen in Swing", "Folien 24"]
semester: 2
kategorie: "GUI"
folien: "[[Material/Folien/24_Zeichnen.pdf]]"
seiten: 20
---

# 24 Zeichnen in Swing

← [[23 Events]] · [[Start|🏠 Start]] · [[24A Swing vs. JavaFX]] →

> [!abstract] Worum geht's?
> Eigene Grafik in Swing-Komponenten: paintComponent, das Grafik-Koordinatensystem, Methoden der Klasse Graphics und Reagieren auf Maus-Events.

**Semester:** Programmieren II · **Bereich:** #kategorie/gui · **Folien:** [[Material/Folien/24_Zeichnen.pdf|24_Zeichnen.pdf]] (20 Seiten)

## Gliederung der Folien
- [[Material/Folien/24_Zeichnen.pdf#page=2|S. 2]] Zeichnen in Swing-Komponenten
- [[Material/Folien/24_Zeichnen.pdf#page=6|S. 6]] Erstes Beispiel (Version 1)
- [[Material/Folien/24_Zeichnen.pdf#page=7|S. 7]] Erstes Beispiel (Version 2)
- [[Material/Folien/24_Zeichnen.pdf#page=8|S. 8]] Erstes Beispiel (Version 2a)
- [[Material/Folien/24_Zeichnen.pdf#page=9|S. 9]] Erstes Beispiel (Version 3)
- [[Material/Folien/24_Zeichnen.pdf#page=10|S. 10]] Grafik-Koordinatensystem
- [[Material/Folien/24_Zeichnen.pdf#page=11|S. 11]] Eine Zeichnung mit Ovalen
- [[Material/Folien/24_Zeichnen.pdf#page=12|S. 12]] Einige Methoden der Klasse Graphics
- [[Material/Folien/24_Zeichnen.pdf#page=14|S. 14]] Beispiel: Formen
- [[Material/Folien/24_Zeichnen.pdf#page=15|S. 15]] Beispiel: Datum und Uhrzeit
- [[Material/Folien/24_Zeichnen.pdf#page=16|S. 16]] Einige weitere Methoden der Klasse
- [[Material/Folien/24_Zeichnen.pdf#page=18|S. 18]] Weiteres Beispiel: Reagieren auf MouseEvents
- [[Material/Folien/24_Zeichnen.pdf#page=20|S. 20]] Online-Literatur

## Begriffe in diesem Kapitel
- [[Swing]] (S. [[Material/Folien/24_Zeichnen.pdf#page=2|2]], [[Material/Folien/24_Zeichnen.pdf#page=3|3]], [[Material/Folien/24_Zeichnen.pdf#page=4|4]], [[Material/Folien/24_Zeichnen.pdf#page=5|5]], [[Material/Folien/24_Zeichnen.pdf#page=6|6]], [[Material/Folien/24_Zeichnen.pdf#page=7|7]])
- [[JPanel]] (S. [[Material/Folien/24_Zeichnen.pdf#page=2|2]], [[Material/Folien/24_Zeichnen.pdf#page=6|6]], [[Material/Folien/24_Zeichnen.pdf#page=7|7]], [[Material/Folien/24_Zeichnen.pdf#page=8|8]], [[Material/Folien/24_Zeichnen.pdf#page=11|11]], [[Material/Folien/24_Zeichnen.pdf#page=14|14]])
- [[Farben und Schriften]] (S. [[Material/Folien/24_Zeichnen.pdf#page=5|5]], [[Material/Folien/24_Zeichnen.pdf#page=11|11]], [[Material/Folien/24_Zeichnen.pdf#page=12|12]], [[Material/Folien/24_Zeichnen.pdf#page=14|14]], [[Material/Folien/24_Zeichnen.pdf#page=15|15]], [[Material/Folien/24_Zeichnen.pdf#page=17|17]])
- [[MouseListener]] (S. [[Material/Folien/24_Zeichnen.pdf#page=18|18]], [[Material/Folien/24_Zeichnen.pdf#page=19|19]])
- [[Zeichnen mit Graphics]] (S. [[Material/Folien/24_Zeichnen.pdf#page=2|2]], [[Material/Folien/24_Zeichnen.pdf#page=3|3]], [[Material/Folien/24_Zeichnen.pdf#page=4|4]], [[Material/Folien/24_Zeichnen.pdf#page=5|5]], [[Material/Folien/24_Zeichnen.pdf#page=6|6]], [[Material/Folien/24_Zeichnen.pdf#page=7|7]])

## Kommt hier auch vor
[[Vererbung]] · [[Überschreiben]] · [[JFrame]]

## Übungen
- [ ] [[Ü24 ClickFiller]] ★★☆☆☆
- [ ] [[Ü24 Wahl]] ★★★★☆ ✅ Musterlösung

## Relevant für diese Programmentwürfe
[[PE CHORona]] · [[PE ChatterGPT Validator]] · [[PE DBVasion]] · [[PE SnatChat (Übungs-PE Oktober 2026)]]

## Verwandte Themen
[[20 Grafische Oberflächen mit Swing]] · [[23 Events]] · [[27 Threads]]

## Folien ansehen
![[Material/Folien/24_Zeichnen.pdf]]

## Folientext (durchsuchbar)
> [!quote]- Kompletter Folientext – aufklappen
> ```text
> ── Seite 1 ──
> Programmieren II
> Zeichnen in Swing-Komponenten
>    Heusch 18
>    Ratz 16.1
> 
> Institut für Automation und angewandte Informatik
> 
> KIT – Die Forschungsuniversität in der Helmholtz-Gemeinschaft www.kit.edu
> 
> ── Seite 2 ──
> Zeichnen in Swing-Komponenten (1)
> 
>    Eine Swing-Komponente (JComponent) kann nicht nur eine
>    grafisch vorgefertigte Komponente sein (z.B. ein Button).
>    Sie kann auch selbst grafisch gestaltet werden.
>    In diesem Kapitel wird behandelt, wie man in einer Swing-
>    Komponente eigene grafische Elemente zeichnen kann,
>    indem man die Methode, die für das Zeichnen der
>    Komponente zuständig ist, überschreibt.
> 
>    Für die Darstellung der einzelnen Swing-Komponenten ist
>    der Repaint-Manager zuständig.
>    Dieser veranlasst, dass für das erstmalige Erscheinen einer
>    Komponente sowie bei Änderungen die Darstellung der
>    Komponente aktiviert bzw. aktualisiert wird.
> 2 W. Süß, T. Schlachter, J. Sidler, N. Doms, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 3 ──
> Zeichnen in Swing-Komponenten (2)
> 
>    Hierzu ruft der Repaint-Manager die von Component geerbte
>    Instanzmethode
>    void repaint()
>    der Komponente auf.
>    Die Methode repaint() bewirkt einen Aufruf der Methode
>    void paint(Graphics g)
>    der Komponente.
>    Die paint-Methode ist die Zeichenmethode für die
>    Darstellung der jeweiligen Komponente.
> 
> 3 W. Süß, T. Schlachter, J. Sidler, N. Doms, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 4 ──
> Zeichnen in Swing-Komponenten (3)
> 
>    Die paint-Methode wiederrum verteilt den Aufruf intern
>    weiter auf die Methoden:
>    protected void paintComponent(Graphics g)
>    zeichnet den eigentlichen Inhalt der Komponente
>    protected void paintBorder(Graphics g)
>    zeichnet einen (optionalen) Rahmen
>    protected void paintChildren(Graphics g)
>    zeichnet alle Unterkomponenten (nur bei Containern)
>    Wenn die grafische Darstellung (der Inhalt) einer Kompo-
>    nente festgelegt oder verändert werden soll, muss die
>    (geerbte) paintComponent-Methode der Komponente
>    überschrieben werden.
> 
> 4 W. Süß, T. Schlachter, J. Sidler, N. Doms, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 5 ──
> Zeichnen in Swing-Komponenten (4)
> 
>    Der Parameter Graphics g der verschiedenen paintXXX-
>    Methoden liefert einen Bezug zum grafischen Kontext), in
>    den gezeichnet werden soll (Grafik-Fenster auf dem
>    Ausgabegerät).
>    Die Klasse Graphics enthält verschiedene Methoden zum
>    Zeichnen, wie z.B. drawString() zum „Zeichnen“ einer
>    Zeichenkette und setColor() zum Setzen der aktuellen
>    Farbe.
> 
> 5 W. Süß, T. Schlachter, J. Sidler, N. Doms, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 6 ──
> Erstes Beispiel (Version 1)
>    import java.awt.Graphics;
>    import javax.swing.*;
> 
>    public class FirstPaint1 extends JComponent {
> 
>    @Override
>    protected void paintComponent(Graphics g) {
>    g.drawString("Hello World", 25, 50);
>    }
> 
>    public static void main(String[] args) {
>    JFrame f = new JFrame();
>    f.setTitle("First Paint");
>    f.add(new FirstPaint1());
>    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
>    f.setSize(300, 200);
>    f.setVisible(true);
>    }
> 
>    }
> 
> 6 W. Süß, T. Schlachter, J. Sidler, N. Doms, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 7 ──
> Erstes Beispiel (Version 2)
>    import java.awt.Graphics;
>    import javax.swing.JComponent;
> 
>    public class DrawComponent extends JComponent {
>    @Override
>    protected void paintComponent(Graphics g) {
>    g.drawString("Hello World", 25, 50);
>    }
>    }
> 
>    import javax.swing.JFrame;
> 
>    public class FirstPaint2 extends JFrame {
>    public FirstPaint2() {
>    this.setTitle("First Paint 2");
>    this.setSize(300, 200);
>    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
>    this.add(new DrawComponent());
>    this.setVisible(true);
>    }
>    public static void main(String[] args) {
>    new FirstPaint2();
>    }
>    }
> 
> 7 W. Süß, T. Schlachter, J. Sidler, N. Doms, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 8 ──
> Erstes Beispiel (Version 2a)
>    import java.awt.BorderLayout;
>    import javax.swing.*;
> 
>    public class FirstPaint2a extends JFrame {
> 
>    public FirstPaint2a() {
>    this.setLayout(new BorderLayout());
>    this.setTitle("First Paint 2a");
>    this.setSize(300, 200);
>    JPanel panel = new JPanel();
>    panel.add(new JButton("Links"));
>    panel.add(new JButton("Rechts"));
>    this.add(panel,BorderLayout.NORTH);
>    this.add(new DrawComponent(),BorderLayout.CENTER);
>    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
>    this.setVisible(true);
>    }
> 
>    public static void main(String[] args) {
>    new FirstPaint2a();
>    }
> 
>    }
> 
> 8 W. Süß, T. Schlachter, J. Sidler, N. Doms, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 9 ──
> Erstes Beispiel (Version 3)
>    import java.awt.Graphics;
>    import javax.swing.JFrame;
> 
>    public class FirstPaint3 extends JFrame {
>    public FirstPaint3() {
>    this.setTitle("First Paint 3"); this.setSize(300, 200);
>    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
>    this.setVisible(true);
>    }
> 
>    // Zeichnen direkt in JFrame (nicht in hinzugefügte Komponente)
>    // daher direktes Überschreiben der Methode paint!
>    @Override
>    public void paint(Graphics g) {
>    // super.paint(g); // Darstellung enthaltener Komponenten
>    g.clearRect(0,0,this.getWidth(),this.getHeight());
>    g.drawString("Hello World", 25, 50);
>    }
> 
>    public static void main(String[] args) {
>    new FirstPaint3();
>    }
>    }
> 
> 9 W. Süß, T. Schlachter, J. Sidler, N. Doms, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 10 ──
> Grafik-Koordinatensystem
> 
>    Dem Grafiksystem liegt ein zweidimensionales Pixel-
>    Koordinatensystem zugrunde
>    0 1   5   10
>    0   x
>    1
> 
>    5
> 
>    y
> 
>    Der Koordinatenursprung (0,0) liegt in der linken oberen
>    Ecke.
>    Die y-Achse verläuft von oben nach unten.
> 10 W. Süß, T. Schlachter, J. Sidler, N. Doms, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 11 ──
> Eine Zeichnung mit Ovalen
>    import java.awt.*;
>    import javax.swing.*;
> 
>    public class SecondPaint extends JComponent {
>    @Override
>    protected void paintComponent(Graphics g) {
>    // The pink oval
>    g.setColor(Color.PINK);
>    g.fillOval(10, 10, 330, 100);
>    g.setColor(Color.RED);
>    g.drawOval(10, 10, 330, 100);
>    g.drawOval(9, 9, 332, 102);
>    g.drawOval(8, 8, 334, 104);
>    g.drawOval(7, 7, 336, 106);
>    // The text
>    g.setColor(Color.BLACK);
>    g.setFont(new Font("Helvetica", Font.BOLD, 40));
>    g.drawString("Hello World", 40, 75);
>    }
>    public static void main(String[] args) {
>    JFrame f = new JFrame();
>    f.setTitle("Second Paint");
>    f.add(new SecondPaint());
>    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
>    f.setSize(370, 160);
>    f.setVisible(true);
>    }
>    }
> 
> 11 W. Süß, T. Schlachter, J. Sidler, N. Doms, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 12 ──
> Einige Methoden der Klasse Graphics (1)
> 
>    Die Klasse java.awt.Graphics bietet zahlreiche Methoden
>    für das Zeichnen von Grafikobjekten. Auswahl:
>    void setFont(Font font)
>    Legt den Font für die folgenden Grafik-Operationen fest
>    void setColor(Color c)
>    Legt die Farbe für die folgenden Grafik-Operationen fest
>    void drawString(String str, int x, int y)
>    Zeichnet eine Zeichenkette. (x,y: linke untere Ecke des 1. Zeichens)
>    void drawLine(int x1, int y1, int x2, int y2)
>    Zeichnet eine Linie
>    void drawRect(int x, int y, int width, int height)
>    Zeichnet ein Rechteck. x, y: Koordinaten des linken oberen Ecks
>    width, height: Breite und Höhe des Rechtecks (in Pixeln)
>    void fillRect(…)
>    Zeichnet ein gefülltes Rechteck
> 12 W. Süß, T. Schlachter, J. Sidler, N. Doms, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 13 ──
> Einige Methoden der Klasse Graphics (2)
> 
>    void drawOval(int x, int y, int width, int height)
>    Zeichnet ein Oval. Bedeutung der Argumente: wie oben
>    void fillOval(…)
>    Zeichnet ein gefülltes Oval.
>    void drawArc(int x, int y, int width, int height,
>    int startAngle, int arcAngle)
>    Zeichnet einen Ellipsen- oder Kreisbogen. startAngle: Startwinkel,
>    arcAngle: eigentlicher Winkel des Bogens (jeweils in Grad)
>    void fillArc(int x, int y, int width, int height,
>    int startAngle, int arcAngle)
>    Zeichnet einen gefüllten Kreisbogen (Sektor).
> 
>    Weitere Methoden später
> 
> 13 W. Süß, T. Schlachter, J. Sidler, N. Doms, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 14 ──
> Beispiel: Formen
>    import java.awt.*;
>    import javax.swing.*;
> 
>    public class FirstShapes extends JComponent {
>    @Override
>    protected void paintComponent(Graphics g) {
>    g.drawRect(30, 30, 80, 40);
>    g.drawOval(120, 30, 50, 50);
>    g.setColor(Color.BLACK);
>    g.fillRect(30, 100, 80, 40);
>    g.fillOval(120, 100, 50, 50);
>    g.drawLine(30, 160, 130, 170);
>    g.drawArc(30, 180, 50, 50, 60, 40);
>    g.fillArc(120, 180, 50, 50, 60, 40);
>    }
> 
>    public static void main(String[] args) {
>    JFrame f = new JFrame();
>    f.add(new FirstShapes());
>    f.setTitle("First Shapes");
>    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
>    f.setSize(300, 300); f.setVisible(true);
>    }
>    }
> 
> 14 W. Süß, T. Schlachter, J. Sidler, N. Doms, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 15 ──
> Beispiel: Datum und Uhrzeit
>    import java.awt.*;
>    import java.util.Date;
>    import javax.swing.*;
> 
>    public class DigitalClock extends JComponent {
> 
>    @Override
>    protected void paintComponent(Graphics g) {
>    g.setFont(new Font("Consolas", Font.BOLD, 24));
>    Date theDate = new Date();
>    g.drawString(theDate.toString(), 50, 50);
>    }
> 
>    public static void main(String[] args) {
>    JFrame f = new JFrame();
>    f.add(new DigitalClock());
>    f.setTitle("Date and Time");
>    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
>    f.setSize(500, 120);
>    f.setVisible(true);
>    }
>    Bei jeder Ausgabe oder erneuten Ausgabe
>    des Fensters wird repaint() aufgerufen,
>    }   z.B. auch bei Änderung der Fenstergröße.
> 
> 15 W. Süß, T. Schlachter, J. Sidler, N. Doms, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 16 ──
> Einige weitere Methoden der Klasse
>    java.awt.Graphics (1)
>    void clearRect(int x, int y, int width, int height)
>    void copyArea(int x, int y, int width, int height, int dx,
>    int dy)
>    void draw3DRect(int x, int y, int width, int height,
>    boolean raised)
>    void fill3DRect(int x, int y, int width, int height,
>    boolean raised)
>    void drawRoundRect(int x, int y, int width, int height,
>    int arcWidth, int arcHeight)
>    void drawPolygon(int[] xPoints, int[] yPoints,
>    int nPoints)
>    void drawImage(Image img, int x, int y, ImageObserver obs)
>    void setClip(int x, int y, int width, int height)
>    Shape getClip()
>    Rectangle getClipBounds()
>    void clipRect(int x, int y, int width, int height)
> 16 W. Süß, T. Schlachter, J. Sidler, N. Doms, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 17 ──
> Einige weitere Methoden der Klasse
>    java.awt.Graphics (2)
> 
>    Color getColor()
>    Font getFont()
> 
>    Weitere fill… - analog zu draw… (s.o.)
>    Weitere set… - analog zu get… (s.o.)
> 
>    Verschiedene Varianten von drawImage()
> 
> 17 W. Süß, T. Schlachter, J. Sidler, N. Doms, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 18 ──
> Weiteres Beispiel: Reagieren auf MouseEvents (1)
> 
>    Im folgenden Beispiel wird das Zeichnen über Maus-
>    Ereignisse gesteuert.
>    D.h. das Zeichnen erfolgt hier mithilfe von Methoden, die über das
>    Event-Handling aufgerufen werden, nicht mithilfe der Methode
>    paint() einer GUI-Komponente, die über den Repaint-Manager
>    aufgerufen wird.
>    Für Maus-Ereignisse wie „Drücken auf eine Maustaste“ und
>    „Bewegen der Maus“ gibt es die Event-Klasse MouseEvent
>    und die zugehörigen Listener-Schnittstellen MouseListener
>    und MouseMotionListener.
>    Gezeichnet wird hier direkt in ein JFrame-Fenster.
>    Der grafische Kontext (Möglichkeit zum Zeichen) wird
>    erzeugt mit der JFrame-Methode
>    Graphics getGraphics()
> 18 W. Süß, T. Schlachter, J. Sidler, N. Doms, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 19 ──
> Weiteres Beispiel: Reagieren auf MouseEvents (2)
>    import java.awt.*;   import java.awt.event.*; import javax.swing.*;
> 
>    public class Scribble extends JFrame implements MouseListener, MouseMotionListener {
>    private int lastX, lastY;
>    Graphics g;
> 
>    public Scribble() {   public void mouseReleased(MouseEvent e) {
>    this.setDefaultCloseOperation(   }
>    JFrame.EXIT_ON_CLOSE);   public void mouseClicked(MouseEvent e) {
>    this.addMouseListener(this);   }
>    this.addMouseMotionListener(this);   public void mouseEntered(MouseEvent e) {
>    this.setSize(200, 200);   }
>    this.setVisible(true);   public void mouseExited(MouseEvent e) {
>    this.g = this.getGraphics();   }
>    }   public void mouseMoved(MouseEvent e) {
>    public void mousePressed(MouseEvent e) {   }
>    this.lastX = e.getX();   public static void main(String[] args) {
>    this.lastY = e.getY();   new Scribble();
>    }   }
>    public void mouseDragged(MouseEvent e) {
>    int x = e.getX(), y = e.getY();
>    this.g.drawLine(this.lastX,
>    this.lastY, x, y);
>    this.lastX = x;
>    this.lastY = y;
>    }
> 
>    }
> 
> 19 W. Süß, T. Schlachter, J. Sidler, N. Doms, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 20 ──
> Online-Literatur
> 
>    „Painting in AWT and Swing“ von Oracle
>    http://www.oracle.com/technetwork/java/painting-
>    140037.html
> 
> 20 W. Süß, T. Schlachter, J. Sidler, N. Doms, C. Schmitt Institut für Automation und angewandte Informatik
> ```
