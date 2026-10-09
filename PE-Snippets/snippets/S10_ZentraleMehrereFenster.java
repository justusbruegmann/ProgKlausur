package snippets;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * ============================================================================
 * S10  ZENTRALE + MEHRERE FENSTER (Beobachter-Muster / Observer)
 * ============================================================================
 * Typische Aufgabe: "Im Hintergrund nutzen alle SnatChatWindows zur Kommunikation
 *   einen SnatChatRoom, um Nachrichten an alle Nutzer zu verteilen."
 *   Gleiches Prinzip: Game + mehrere GameTerm-Clients (SpeedyQuiz),
 *   Auktionshaus + mehrere BieterTerminals (jBay), CoronaWarnAPI + JPhones.
 * Folien: 21_Abstrakte_Klassen_Interfaces, 23_Events (Beobachter-Prinzip)
 *
 * Schema:
 *     Fenster 1 ─┐                       ┌─> Fenster 1.receive(...)
 *     Fenster 2 ─┼─ room.send(...) ─────>├─> Fenster 2.receive(...)
 *     Fenster 3 ─┘   (Zentrale)          └─> Fenster 3.receive(...)
 *
 *   1. Interface für alle Teilnehmer (Methoden aus der Aufgabe)
 *   2. Zentrale hält List<Teilnehmer>, register()/unregister(), schickt an alle
 *   3. Jedes Fenster implementiert das Interface, kennt die Zentrale,
 *      meldet sich im Konstruktor an und beim Schließen ab
 */

// ---- 1) Interface ---------------------------------------------------------------
interface ChatTeilnehmer {

    void receiveMessage(String absender, String text);

    String getUserName();
}

// ---- 2) Zentrale ----------------------------------------------------------------
class ChatRaum {

    private final List<ChatTeilnehmer> teilnehmer = new ArrayList<>();

    public void register(ChatTeilnehmer t) {
        teilnehmer.add(t);
        sendSystem(t.getUserName() + " ist beigetreten");
    }

    public void unregister(ChatTeilnehmer t) {
        teilnehmer.remove(t);
        sendSystem(t.getUserName() + " hat den Raum verlassen");
    }

    /** An ALLE verteilen (inkl. Absender). Nur an andere: if (t != absender) */
    public void send(ChatTeilnehmer absender, String text) {
        for (ChatTeilnehmer t : new ArrayList<>(teilnehmer)) {   // Kopie: falls sich die Liste währenddessen ändert
            t.receiveMessage(absender.getUserName(), text);
        }
    }

    private void sendSystem(String text) {
        for (ChatTeilnehmer t : new ArrayList<>(teilnehmer)) {
            t.receiveMessage("System", text);
        }
    }

    public int getAnzahl() {
        return teilnehmer.size();
    }
}

// ---- 3) Fenster = Teilnehmer ------------------------------------------------------
class ChatFenster extends JFrame implements ChatTeilnehmer {

    private static final long serialVersionUID = 1L;

    private final ChatRaum raum;
    private final String name;
    private final JTextArea verlauf = new JTextArea(10, 25);

    public ChatFenster(ChatRaum raum, String name, int x, int y) {
        super("Chat: " + name);
        this.raum = raum;
        this.name = name;

        JLabel kopf = new JLabel(" Angemeldet als " + name);
        kopf.setOpaque(true);
        kopf.setBackground(new Color(220, 230, 255));
        add(kopf, BorderLayout.NORTH);

        verlauf.setEditable(false);
        add(new JScrollPane(verlauf), BorderLayout.CENTER);

        JTextField eingabe = new JTextField();
        JButton senden = new JButton("Senden");
        senden.addActionListener(e -> {
            String text = eingabe.getText().trim();
            if (!text.isEmpty()) {
                raum.send(this, text);             // an die Zentrale
                eingabe.setText("");
            }
        });
        eingabe.addActionListener(e -> senden.doClick());   // Enter = Senden
        JPanel unten = new JPanel(new BorderLayout());
        unten.add(eingabe, BorderLayout.CENTER);
        unten.add(senden, BorderLayout.EAST);
        add(unten, BorderLayout.SOUTH);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                raum.unregister(ChatFenster.this);  // abmelden!
            }
        });
        pack();
        setLocation(x, y);
        setVisible(true);

        raum.register(this);                        // anmelden (zum Schluss, wenn alles fertig ist)
    }

    @Override
    public void receiveMessage(String absender, String text) {
        verlauf.append(absender + ": " + text + "\n");
    }

    @Override
    public String getUserName() {
        return name;
    }
}

public class S10_ZentraleMehrereFenster {

    public static void main(String[] args) {
        ChatRaum raum = new ChatRaum();
        String[] namen = { "Anna", "Ben", "Cem" };
        for (int i = 0; i < namen.length; i++) {
            new ChatFenster(raum, namen[i], 50 + i * 330, 100);   // nebeneinander anordnen
        }
    }
}
