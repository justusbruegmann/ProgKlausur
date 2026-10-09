---
tags: ["typ/thema", "thema/events", "kategorie/gui", "semester/2"]
aliases: ["Events", "Folien 23"]
semester: 2
kategorie: "GUI"
folien: "[[Material/Folien/23_Events.pdf]]"
seiten: 29
---

# 23 Events

← [[22 Innere Klassen]] · [[Start|🏠 Start]] · [[24 Zeichnen in Swing]] →

> [!abstract] Worum geht's?
> Das Java-Event-Modell (ab 1.1) mit Listener-Interfaces, Event-Handling über implementierte Listener, anonyme Klassen oder Vererbung, Datenweitergabe an Handler und Popup-Menüs.

**Semester:** Programmieren II · **Bereich:** #kategorie/gui · **Folien:** [[Material/Folien/23_Events.pdf|23_Events.pdf]] (29 Seiten)

## Gliederung der Folien
- [[Material/Folien/23_Events.pdf#page=2|S. 2]] Event-Modelle in Java
- [[Material/Folien/23_Events.pdf#page=3|S. 3]] Das Java Event-Modell 1.1
- [[Material/Folien/23_Events.pdf#page=6|S. 6]] Listener-Interfaces in java.awt.event
- [[Material/Folien/23_Events.pdf#page=7|S. 7]] Java Events 1.1 und Design-Patterns
- [[Material/Folien/23_Events.pdf#page=10|S. 10]] Eigenschaften des 1.1-Modells
- [[Material/Folien/23_Events.pdf#page=11|S. 11]] Beispiel
- [[Material/Folien/23_Events.pdf#page=12|S. 12]] Weiteres Beispiel
- [[Material/Folien/23_Events.pdf#page=14|S. 14]] Events mit anonymen inneren Klassen
- [[Material/Folien/23_Events.pdf#page=15|S. 15]] Screenshot zum vorherigen Beispiel
- [[Material/Folien/23_Events.pdf#page=16|S. 16]] Verschiedene Arten des Event-Handling
- [[Material/Folien/23_Events.pdf#page=18|S. 18]] Listener implementieren vs. anonyme Event-Klassen
- [[Material/Folien/23_Events.pdf#page=19|S. 19]] Event-Verarbeitung: Daten „durchreichen“
- [[Material/Folien/23_Events.pdf#page=24|S. 24]] Erweitertes Beispiel für Button-Name
- [[Material/Folien/23_Events.pdf#page=25|S. 25]] Weitere Möglichkeit: Vererbung
- [[Material/Folien/23_Events.pdf#page=27|S. 27]] Popup-Menüs
- [[Material/Folien/23_Events.pdf#page=28|S. 28]] Popup-Menü: Beispiel
- [[Material/Folien/23_Events.pdf#page=29|S. 29]] Doku und Tutorial

## Begriffe in diesem Kapitel
- [[Interface]] (S. [[Material/Folien/23_Events.pdf#page=5|5]], [[Material/Folien/23_Events.pdf#page=6|6]], [[Material/Folien/23_Events.pdf#page=11|11]], [[Material/Folien/23_Events.pdf#page=12|12]], [[Material/Folien/23_Events.pdf#page=16|16]], [[Material/Folien/23_Events.pdf#page=17|17]])
- [[Anonyme innere Klasse]] (S. [[Material/Folien/23_Events.pdf#page=14|14]], [[Material/Folien/23_Events.pdf#page=16|16]], [[Material/Folien/23_Events.pdf#page=18|18]])
- [[Swing]] (S. [[Material/Folien/23_Events.pdf#page=9|9]], [[Material/Folien/23_Events.pdf#page=11|11]], [[Material/Folien/23_Events.pdf#page=12|12]], [[Material/Folien/23_Events.pdf#page=14|14]], [[Material/Folien/23_Events.pdf#page=16|16]], [[Material/Folien/23_Events.pdf#page=17|17]])
- [[Menü]] (S. [[Material/Folien/23_Events.pdf#page=27|27]], [[Material/Folien/23_Events.pdf#page=28|28]])
- [[Listener]] (S. [[Material/Folien/23_Events.pdf#page=2|2]], [[Material/Folien/23_Events.pdf#page=3|3]], [[Material/Folien/23_Events.pdf#page=4|4]], [[Material/Folien/23_Events.pdf#page=5|5]], [[Material/Folien/23_Events.pdf#page=6|6]], [[Material/Folien/23_Events.pdf#page=7|7]])
- [[MouseListener]] (S. [[Material/Folien/23_Events.pdf#page=6|6]], [[Material/Folien/23_Events.pdf#page=28|28]])
- [[Timer]]

## Kommt hier auch vor
[[Vererbung]] · [[JFrame]] · [[Swing-Komponenten]] · [[Layoutmanager]] · [[List]]

## Übungen
- [ ] [[Ü23 Währungsumrechner (2)]] ★☆☆☆☆ ✅ Musterlösung
- [ ] [[Ü23 Body-Mass-Index (BMI)]] ★★☆☆☆ ✅ Musterlösung
- [ ] [[Ü23 Binäre Zahlen]] ★★☆☆☆ ✅ Musterlösung
- [ ] [[Ü23 Zahlenraten (2)]] ★★★☆☆ ✅ Musterlösung
- [ ] [[Ü23 Editor]] ★★★☆☆ ✅ Musterlösung
- [ ] [[Ü23 Hütchenspiel]] ★★★☆☆ ✅ Musterlösung

## Relevant für diese Programmentwürfe
[[PE CoronaWarn]] · [[PE SnatChat (Übungs-PE Oktober 2026)]] · [[PE SpeedyQuiz]] · [[PE jBay]]

## Verwandte Themen
[[20 Grafische Oberflächen mit Swing]] · [[22 Innere Klassen]] · [[24 Zeichnen in Swing]] · [[21 Abstrakte Klassen und Interfaces]]

## Folien ansehen
![[Material/Folien/23_Events.pdf]]

## Folientext (durchsuchbar)
> [!quote]- Kompletter Folientext – aufklappen
> ```text
> ── Seite 1 ──
> Programmieren II
> Events (Ereignisse)
>    Heusch 16.6 (2. Bd)
>    Ratz 15
> 
> Institut für Automation und angewandte Informatik
> 
> KIT – Die Forschungsuniversität in der Helmholtz-Gemeinschaft www.kit.edu
> 
> ── Seite 2 ──
> Event-Modelle in Java
> 
>    Graphische Anwendungen
>    werden über
>    Events gesteuert.
>    Sie machen nichts,
>    solange der Benutzer
>    nicht die Maus bewegt,
>    einen Button anklickt
>    oder eine Taste drückt.
>    Es gibt unterschiedliche
>    Eventmodelle bei Java 1.0
>    und Java 1.1.
>    Wir verwenden nur noch das
>    Event-Modell 1.1.
> 2 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 3 ──
> Das Java Event-Modell 1.1 (1)
> 
>    Das Java Event-Modell 1.1 basiert auf dem Konzept des
>    „Event-Listeners“.
>    Ein Event-Listener ist ein Objekt, das Events abfangen
>    möchte.
>    Ein Objekt, das Events generiert (eine Event-Quelle, „event
>    source“),
>    pflegt Listen von Listenern, die über auftretende Events informiert
>    werden wollen. Diese Listen unterscheiden sich nach dem Typ des
>    Events, auf das reagiert werden soll.
>    stellt Methoden bereit, um Listener in diese Liste einzutragen bzw.
>    sie wieder aus ihr zu entfernen
> 
> 3 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 4 ──
> Das Java Event-Modell 1.1 (2)
> 
>    Verschiedene Event-Typen werden jeweils durch eigene
>    Java-Klassen repräsentiert.
>    Jedes Event ist eine Subklasse von
>    java.util.EventObject
>    java.util.EventObject
>    |
>    +--java.awt.AWTEvent
>    |
>    +--java.awt.event.ActionEvent
>    +--java.awt.event.AdjustmentEvent
>    +--java.awt.event.ComponentEvent
>    .   |
>    .   +--java.awt.event.FocusEvent
>    .   +--java.awt.event.WindowEvent
>    +-- …
> 
> 4 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 5 ──
> Das Java Event-Modell 1.1 (3)
> 
>    Wird ein Event ausgelöst, benachrichtigt die Event-Quelle alle in
>    der entsprechenden Liste eingetragenen Listener-Objekte, dass
>    ein Event aufgetreten ist.
>    Eine Event-Quelle benachrichtigt ein Event-Listener-Objekt
>    durch den Aufruf einer Methode und die Übergabe eines Event-
>    Objektes.
>    Damit eine Quelle eine Methode des Listeners aufrufen kann,
>    müssen alle Listener die verlangte Methode implementieren.
>    Das wird dadurch sichergestellt, dass alle Event-Listener eines
>    bestimmten Event-Typs ein entsprechendes Interface
>    implementieren, z.B.
>    interface ActionListener
>    mit seiner (einzigen) Methode
>    void actionPerformed(ActionEvent e)
> 5 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 6 ──
> Listener-Interfaces in java.awt.event
>    ActionListener
>    AdjustmentListener
>    AWTEventListener
>    ComponentListener
>    ContainerListener
>    FocusListener
>    HierarchyBoundsListener
>    HierarchyListener
>    InputMethodListener
>    ItemListener
>    KeyListener
>    MouseListener
>    MouseMotionListener
>    MouseWheelListener
>    TextListener
>    WindowFocusListener
>    WindowListener
>    WindowStateListener
> 
> 6 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 7 ──
> Java Events 1.1 und Design-Patterns (1)
> 
>    Die Java-Events entsprechen dem allgemeinen
>    objektorientierten Entwurfsmuster (Design Pattern)
>    „Observer“ (s. Vorlesung Softwareengineering)
>    „Event-Quelle“   „Listener“
> 
>    Quelle: http://www.it-academy.cc/images/paedubucher/1517/observer.png
> 
> 7 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 8 ──
> Java Events 1.1 und Design-Patterns (2)
> 
>    Beispiel für mehrere Observer auf einem Subjekt:
> 
>    „Listener 1“   „Listener 2“   „Listener 3“
> 
>    „Event-Quelle“
>    Quelle und weitere Infos: http://userpages.umbc.edu/~tarr/dp/lectures/Observer.pdf
> 
> 8 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 9 ──
> Java Events 1.1 und Design-Patterns (3)
> 
>    Das Java 1.1-Eventmodell eignet sich dank der
>    Entkopplung von GUI und Eventhandling gut für die
>    Implementierung des „Model-View-Controller“-Patterns.
>    Trennung von
>    Datenmodell (Model)
>    Darstellung im GUI (View, z.B. Swing-Komponente)
>    Vermittlung zwischen beiden durch Controller
>    (z.B. ActionListener)
>    View   Controller   Model
> 
>    Event e
> 
>    Button   ActionListener   KlasseX
> 
> 9 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 10 ──
> Eigenschaften des 1.1-Modells
> 
>    Hohe Flexibilität
>    Durch die Registrierung von Listenern kann man Eventströme frei
>    steuern, je nachdem, wie man sie braucht.
>    Eine saubere Trennung des GUI vom restlichen Programmcode
>    wird ermöglicht.
>    Man kann auch zur Laufzeit Listener hinzufügen, entfernen oder
>    austauschen.
>    Geringer Overhead
>    Ein Objekt erhält ausschließlich die Event-Typen, die es auch
>    verarbeitet bzw. weiterleitet.
>    Einfachere Event-Identifizierung
>    Events sind sofort anhand ihrer Klasse identifizierbar. Jeder Event-
>    Typ wird von einer eigenen Listener-Methode behandelt, so dass
>    eine weitere Typprüfung entfallen kann.
> 
> 10 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 11 ──
> Beispiel
>    import java.awt.Toolkit;
>    import java.awt.event.*;
>    import javax.swing.*;
> 
>    public class Beep extends JFrame implements ActionListener {
>    JButton button = new JButton("Click me!");
> 
>    public Beep() {
>    this.add(this.button);
>    this.button.addActionListener(this);
>    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
>    this.setSize(200, 150);
>    this.setVisible(true);
>    }
> 
>    public void actionPerformed(ActionEvent e) {
>    Toolkit.getDefaultToolkit().beep();
>    }
> 
>    public static void main(String[] args) {
>    new Beep();
>    }
>    }
> 
> 11 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 12 ──
> Weiteres Beispiel (1)
>    import java.awt.FlowLayout; import java.awt.event.*; import javax.swing.*;
> 
>    public class ButtonEventDemo implements ActionListener {
>    JFrame f = new JFrame("Event Frame");
>    JTextField text = new JTextField("enter text...");
>    JButton button1 = new JButton("Button 1");
>    JButton button2 = new JButton("Button 2");
> 
>    public ButtonEventDemo() {
>    this.f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
>    this.f.getContentPane().setLayout(new FlowLayout());
>    this.f.add(this.text);
>    this.text.addActionListener(this);
>    this.f.add(this.button1);
>    this.button1.addActionListener(this);
>    this.f.add(this.button2);
>    this.button2.addActionListener(this);
>    this.f.setSize(400, 100);
>    this.f.setVisible(true);
>    }
>    public static void main(String[] args) {
>    ButtonEventDemo demo = new ButtonEventDemo();
>    }
>    public void actionPerformed(ActionEvent e) {
>    if (e.getSource() == this.text) System.out.println("Text changed");
>    else System.out.println(((JButton) e.getSource()).getText() + " pressed.");
>    }
>    }
> 
> 12 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 13 ──
> Weiteres Beispiel (2)
> 
>    Oder ganz „generisch“:
>    public void actionPerformed(ActionEvent e) {
>    if (e.getSource() == component1) {
>    // Aktion 1
>    }
>    if (e.getSource() == component2) {
>    // Aktion 2
>    }
>    if (e.getSource() == component3) {
>    // Aktion 3
>    }
>    // Bis alle Events abgearbeitet sind ...
>    }
> 
>    Mit getSource() erhält man die Objektreferenz auf die
>    GUI-Komponente, für die das Event ausgelöst wurde, z.B.
>    auf den Button, der gerade angeklickt wurde.
> 13 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 14 ──
> Events mit anonymen inneren Klassen
>    behandeln
>    import java.awt.event.*;
>    import java.awt.*;
>    import javax.swing.*;
> 
>    public class EventsWithAnonymousClasses extends JFrame {
> 
>    JTextField text = new JTextField("Whatever");
>    JButton button = new JButton("Button");
> 
>    EventsWithAnonymousClasses() {
>    this.setLayout(new FlowLayout());
>    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
>    this.add(this.text);
>    this.add(this.button);
>    this.button.addActionListener(new ActionListener() {
>    public void actionPerformed(ActionEvent e) {
>    button.setText(text.getText());
>    }
>    });   Die innere Klasse kann auf
>    this.setSize(400, 300);
>    alle Attribute der Klasse und
>    this.setVisible(true);
>    }   alle Methoden zugreifen -
>    allerdings nicht auf lokale
>    public static void main(String[] args) {   Variablen des Konstruktors
>    new EventsWithAnonymousClasses();   (es sei denn, dass diese
>    }   Variablen als final
>    deklariert sind)!
>    }
> 
> 14 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 15 ──
> Screenshot zum vorherigen Beispiel
> 
>    Fenster nach dem Starten der Applikation
> 
>    Fenster nach dem Klicken des Buttons
> 
> 15 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 16 ──
> Verschiedene Arten des Event-Handling (1)
> 
> import java.awt.Toolkit; import java.awt.Toolkit;
> import java.awt.event.*; import java.awt.event.*;
> import javax.swing.*; import javax.swing.*;
> 
> public class Beep1 extends JFrame public class Beep2 extends JFrame {
>    implements ActionListener {   JButton button = new JButton("Click me!");
> 
>    JButton button = new JButton("Click me!");   public Beep2() {
>    this.add(this.button);
>    public Beep1() {   this.button.addActionListener(
>    this.add(this.button);   new ActionListener() {
>    this.button.addActionListener(this);   public void actionPerformed(ActionEvent e){
>    Toolkit.getDefaultToolkit().beep();
>    this.setDefaultCloseOperation(   }
>    JFrame.EXIT_ON_CLOSE);   });
>    this.setSize(200, 150);
>    this.setVisible(true);
>    }   this.setDefaultCloseOperation(
>    JFrame.EXIT_ON_CLOSE);
>    public void actionPerformed(ActionEvent e){   this.setSize(200, 150);
>    Toolkit.getDefaultToolkit().beep();   this.setVisible(true);
>    }   }
> } }
> 
>    hier: Methode des Listener-Interfaces   hier: in anonymer innerer Klasse
>    in der Klasse selbst implementiert
> 
> 16 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 17 ──
> Verschiedene Arten des Event-Handling (2)
> 
> import java.awt.Toolkit; import java.awt.Toolkit;
> import java.awt.event.*; import java.awt.event.*;
> import javax.swing.*; import javax.swing.*;
> 
> public class Beep3 extends JFrame { public class Beep4 extends JFrame {
>    JButton button = new JButton("Click me!");   ActionClass ac;
>    JButton button = new JButton("Click me!");
>    public Beep3() {
>    this.add(this.button);   public Beep4() {
>    this.button.addActionListener(   this.add(this.button);
>    new ActionClass());   this.ac = new ActionClass();
>    this.setDefaultCloseOperation(   this.button.addActionListener(this.ac);
>    JFrame.EXIT_ON_CLOSE);   this.setDefaultCloseOperation(
>    this.setSize(200, 150);   JFrame.EXIT_ON_CLOSE);
>    this.setVisible(true);   this.setSize(200, 150);
>    }   this.setVisible(true);
>    }
> } }
> 
> class ActionClass implements ActionListener { class ActionClass implements ActionListener {
>    public void actionPerformed(ActionEvent e){   public void actionPerformed(ActionEvent e) {
>    Toolkit.getDefaultToolkit().beep();   Toolkit.getDefaultToolkit().beep();
>    }   }
> } }
> 
>    hier: mit Referenz auf Listener-Objekt der
>    hier: in separater Klasse   sep. Klasse, das dann mehrfach nutzbar wäre
> 17 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 18 ──
> Listener implementieren vs. anonyme Event-Klassen
> 
>    Listener implementieren   Anonyme Event-Klasse
>    Unterscheidung nach   keine Unterscheidung der
>    auslösender Komponente   auslösenden Komponente nötig
>    Alles in einer Methode bzw.   Eine Methode je Event
>    wenigen Methoden   Ein Listener lässt sich an
>    mehrere Komponenten hängen
> 
>    ➔ geht schneller bei kleinen   ➔ etwas mehr Aufwand bei
>    GUIs mit wenigen Events   kleinen GUIs
>    ➔ wird bei größeren GUIs   ➔ übersichtlicher bei großen
>    extrem schnell unübersichtlich   GUIs, da Events sich auf das
>    Programm aufteilen lassen
> 
> 18 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 19 ──
> Event-Verarbeitung: Daten „durchreichen“ (1)
> 
>    Drücken eines Buttons löst ein Event aus
>    ➔ Wie kann ich feststellen, welcher Button es war?
>    ➔ Allgemeiner: wie kann ich für Events „Daten“ mitgeben?
> 
>    Möglichkeit 1: Button-Text (vgl. Folie 12)
>    Nur geeignet falls Texte unterschiedlich
>    // (...)
> 
>    JButton btn1 = new JButton( "1" );
>    JButton btn2 = new JButton( "2" );
> 
>    ActionListener listener = new ActionListener() {
>    public void actionPerformed( ActionEvent e ) {
>    String text = ((JButton)e.getSource()).getText();
>    System.out.println( text );
>    }
>    };
> 
>    btn1.addActionListener( listener );   Ausgabe bei Klick
>    btn2.addActionListener( listener );
>    2
>    // (...)
> 
> 19 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 20 ──
> Event-Verarbeitung: Daten „durchreichen“ (2)
> 
>    Möglichkeit 2: Objektreferenz (vgl. Folie 13)
>    Nur anwendbar, wenn Referenzen gespeichert werden
>    (bspw. in Instanzvariablen)
>    public class EventData extends JFrame {
> 
>    private JButton btn1 = new JButton( "OK" );
>    private JButton btn2 = new JButton( "OK" );
> 
>    public EventData() {
>    // (...)
>    ActionListener listener = new ActionListener() {
>    public void actionPerformed( ActionEvent e ) {
>    if ( e.getSource() == btn1 ) {
>    System.out.println( "First OK" );
>    }
>    else if ( e.getSource() == btn2 ) {
>    System.out.println( "Second OK" );
>    }
>    }
>    };
>    btn1.addActionListener( listener );
>    btn2.addActionListener( listener );
>    // (...)
>    }   Ausgabe bei Klick
>    // (...)
>    }   Second OK
> 
> 20 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 21 ──
> Event-Verarbeitung: Daten „durchreichen“ (3)
> 
>    Möglichkeit 3: separate ActionListener-Instanzen
>    Meistens anwendbar
>    bläht jedoch Code auf
>    kann ggf. leicht zu redundantem Code führen
>    // (...)
> 
>    JButton btn1 = new JButton( "OK" );
>    JButton btn2 = new JButton( "OK" );
> 
>    btn1.addActionListener( new ActionListener() {
>    public void actionPerformed( ActionEvent e ) {
>    System.out.println( "Button1" );
>    }
>    });
>    btn2.addActionListener( new ActionListener() {
>    public void actionPerformed( ActionEvent e ) {
>    System.out.println( "Button2" );
>    }
>    });
>    // (...)   Ausgabe bei Klick
>    Button2
> 
> 21 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 22 ──
> Event-Verarbeitung: Daten „durchreichen“ (4)
> 
>    Möglichkeit 4: ActionCommand
>    Nur anwendbar, falls sinnvolle Command-Namen vorhanden
>    // (...)
> 
>    JButton btn1 = new JButton( "OK" );
>    JButton btn2 = new JButton( "OK" );
>    btn1.setActionCommand( "Button1" );
>    btn2.setActionCommand( "Button2" );
> 
>    ActionListener listener = new ActionListener() {
>    public void actionPerformed( ActionEvent e ) {
>    String cmd = e.getActionCommand();
>    System.out.println( cmd );
>    }
>    };
> 
>    btn1.addActionListener( listener );
>    btn2.addActionListener( listener );   Ausgabe bei Klick
>    Button2
>    // (...)
> 
> 22 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 23 ──
> Event-Verarbeitung: Daten „durchreichen“ (5)
> 
>    Möglichkeit 5: Button-Name
>    Nur anwendbar, falls sinnvolle Namen vorhanden
>    Nutzt von Component geerbte Methoden
>    void setName(String name)und String getName()
>    // (...)
> 
>    JButton btn1 = new JButton( "OK" );
>    JButton btn2 = new JButton( "OK" );
>    btn1.setName( "Button1" );
>    btn2.setName( "Button2" );
> 
>    ActionListener listener = new ActionListener() {
>    public void actionPerformed( ActionEvent e ) {
>    String text = ((JButton)e.getSource()).getName();
>    System.out.println( text );
>    }
>    };
> 
>    btn1.addActionListener( listener );
>    btn2.addActionListener( listener );   Ausgabe bei Klick
>    // (...)   Button2
> 
> 23 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 24 ──
> Erweitertes Beispiel für Button-Name
>    import java.awt.event.*; import javax.swing.*;
>    public class MultipleButtonName2 {
>    public MultipleButtonName2() {
>    JFrame frame = new JFrame("Frame with buttons");
>    JPanel jp = new JPanel();
>    ActionListener listener = new ActionListener() {
>    public void actionPerformed( ActionEvent e ) {
>    String buttonName = ((JButton)e.getSource()).getName();
>    System.out.println( buttonName );
>    }
>    };
>    for ( int i = 1; i <= 3; i++ ) {
>    final JButton button = new JButton( "Button" );
>    Ausgabe bei Klick
>    jp.add( button );
>    button.setName( "#" + i );   #3
>    button.addActionListener( listener );
>    }
>    frame.add(jp); frame.setSize(250, 100);
>    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); frame.setVisible(true);
>    }
>    public static void main( String[] args ) { new MultipleButtonName2(); }
>    }
>    Erweiterung und Modifikation des Beispiels MultiButton in Folie 34 des Kapitels „GUI/Swing“
> 
> 24 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 25 ──
> Weitere Möglichkeit: Vererbung (1)
> 
>    Möglichkeit 6: Unterklasse von Button
>    Ermöglicht Erzeugen beliebiger weiterer Attribute
>    public class MyJButton extends JButton {
> 
>    private int myNumber;
> 
>    public MyJButton(String text, int myNumber) {
>    super(text);
>    this.myNumber = myNumber;
>    }
> 
>    public int getMyNumber() {
>    return myNumber;
>    }
> 
>    public void setMyNumber( int myNumber ) {
>    this.myNumber = myNumber;
>    }
> 
>    }
> 
> 25 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 26 ──
> Weitere Möglichkeit: Vererbung (2)
>    // (...)
> 
>    MyJButton btn1 = new MyJButton( "OK", 1 );
>    MyJButton btn2 = new MyJButton( "OK", 2 );
> 
>    ActionListener listener = new ActionListener() {
>    public void actionPerformed( ActionEvent e ) {
>    int num = ((MyJButton)e.getSource()).getMyNumber();
>    System.out.println( Integer.toString( num ) );
>    }
>    };
> 
>    btn1.addActionListener( listener );
>    btn2.addActionListener( listener );
>    // (...)
> 
>    Ausgabe bei Klick
>    2
> 
> 26 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 27 ──
> Popup-Menüs
> 
>    Popup-Menüs funktionieren analog zu JMenuBar, nur
>    oberstes Element ist stattdessen JPopupMenu
>    Das JPopupMenu selbst muss der UI nicht hinzugefügt
>    werden, stattdessen muss ähnlich wie bei Dialogen beim
>    öffnen ein Eltern-Element angegeben werden
>    Geöffnet wird ein Popup-Menü zumeist mit der Maus
>    Es muss ein Listener für Maus-Klick-Ereignisse registriert werden
>    Nur bei der rechten Maustaste soll etwas passieren
> 
> 27 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 28 ──
> Popup-Menü: Beispiel
> import java.awt.BorderLayout; import java.awt.event.MouseAdapter; import java.awt.event.MouseEvent;
> import javax.swing.JFrame; import javax.swing.JLabel; import javax.swing.JMenuItem; import javax.swing.JPopupMenu;
> import javax.swing.SwingUtilities; import javax.swing.WindowConstants;
> 
> public class PopupMenuExample {
> 
>    public static void main(String args[]) {
>    final JFrame frame = new JFrame("Popup Menu Example");
>    final JPopupMenu popup = new JPopupMenu(); // Popup menu with 5 entries
>    for (int i = 1; i <= 5; i++) {
>    JMenuItem item = new JMenuItem("Entry " + i);
>    popup.add(item);
>    }
>    JLabel label = new JLabel("Popup trigger");
>    label.addMouseListener(new MouseAdapter() {
>    public void mouseClicked(MouseEvent e) {
>    if (SwingUtilities.isRightMouseButton(e)) { // Only if right mouse button
>    popup.show(label, e.getX(), e.getY()); // Show at the location where the mouse was clicked
>    }
>    }
>    });
>    frame.add(label, BorderLayout.NORTH);
>    frame.setSize(400, 300);
>    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
>    frame.setVisible(true);
>    }
> }
> 
> 28 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 29 ──
> Doku und Tutorial
> 
>    Javadoc:
>    http://docs.oracle.com/javase/6/docs/api/index.html?overview-summary.html
>    http://docs.oracle.com/javase/6/docs/api/javax/swing/package-frame.html
> 
>    Event-Tutorial:
>    Lesson: Writing Event Listeners
>    http://docs.oracle.com/javase/tutorial/uiswing/events/index.html
> 
> 29 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> ```
