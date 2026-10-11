
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class QuoteSelectionTerm extends JFrame {
    private List<FakeTalkClient> clients;
    private List<Quote> quotesInGame;
    private List<QuoteButton> buttons;

    private JLabel pointsLabel;
    private JLabel currentPlayerLabel;

    private boolean started = false;
    private int currentPlayer = 0;

    private Thread pointsCounter;
    private int points;

    public QuoteSelectionTerm(List<Quote> quotes, int zeile, int spalte) throws FakeNewsException {
        int anzahlQuotes = zeile * spalte;
        if (quotes.size() < anzahlQuotes) {
            throw new FakeNewsException("Provided quote catalog does not contain enough (hot|bull)shit!");
        } else {
            quotesInGame = new ArrayList<>();
            buttons = new ArrayList<>();
            clients = new ArrayList<>();
            while (quotesInGame.size() < anzahlQuotes) {
                int randomNumber = (int) (Math.random() * quotes.size());
                if (!(quotesInGame.contains(quotes.get(randomNumber)))) {
                    quotesInGame.add(quotes.get(randomNumber));
                }
            }

            setTitle("FakeTalk");
            setSize(800, 600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new BorderLayout());

            currentPlayerLabel = new JLabel("");
            add(currentPlayerLabel, BorderLayout.NORTH);

            JPanel matrixPanel = new JPanel(new GridLayout(zeile, spalte));
            for (Quote q : quotesInGame) {
                QuoteButton b = new QuoteButton(q);
                b.addActionListener(e -> {
                    for (QuoteButton b2 : buttons) {
                        b2.setEnabled(false);
                    }
                    clients.get(currentPlayer).setQuote(q);
                    this.pointsCounter();

                });
                buttons.add(b);
                matrixPanel.add(b);
            }

            add(matrixPanel, BorderLayout.CENTER);

            pointsLabel = new JLabel("10 Points");
            add(pointsLabel, BorderLayout.SOUTH);

            setVisible(true);
        }
    }

    public void register(FakeTalkClient client) throws FakeNewsException {
        if (started) {
            throw new FakeNewsException("The game has already been started");
        }
        clients.add(client);
        // System.out.print(clients.get(0).getPlayerName());
        // Ermöglicht das Registrieren eines Clients. Diese müssen in einer geeigneten
        // Datenstruktur abgelegt werden. Sollte das Spiel bereits gestartet worden sein
        // (siehe darunter) ist eine FakeNewsException mit einer entsprechenden
        // Nachricht zu werfen
    }

    public void start() throws FakeNewsException {
        if (started) {
            return;
        }
        if (clients.size() < 2) {
            throw new FakeNewsException("Not enough clients");
        }
        started = true;

        currentPlayerLabel.setText("Pick a quote: " + clients.get(currentPlayer).getPlayerName());
        // Starten des Spiels. Sollten sich beim Aufruf der Methode weniger als 2
        // Clients in der o.g. Datenstruktur befinden, ist eine FakeNewsException mit
        // entsprechender Fehlermeldung zu werfen. Wenn alles passt soll das Spiel
        // gestartet werden und der erste Client zur Auswahl eines Zitats aufgefordert
        // werden (vgl. Screenshot oben). Wurde das Spiel bereits gestartet soll nichts
        // passieren
    }

    public void answerSelected(FakeTalkClient client, Quote q, QuoteType selectedType) throws FakeNewsException {
        pointsCounter.interrupt();
        // Teilt eine selektierte Antwort mit. Dabei sind folgende Schritte
        // durchzuführen
        // o Es ist ein Dialog mit dem eigentlichen Typ des Zitats sowie
        // dessen Quellenangabe (getCitation- Methode) anzuzeigen (vgl. Screenshots
        // unten links).
        StringBuilder sb = new StringBuilder();
        sb.append("This quote is ").append(q.getType().getLabel()).append("! \n");
        sb.append(q.getCitation());
        String result = sb.toString();
        JOptionPane.showMessageDialog(null, result, "Meldung", JOptionPane.INFORMATION_MESSAGE);
        // o Ist der ausgewählte Zitat-Typ selectedType richtig, sind die
        // entsprechenden Punkte (aktuell immer 10, siehe Hinweise) dem Spieler
        // hinzuzufügen, ansonsten sind sie abzuziehen. Das Label für die Punkte ist
        // ebenfalls entsprechend zu aktualisieren.
        if (q.getType() == selectedType) {
            client.addPoints(this.points);
        } else {
            client.addPoints(-(this.points));
        }
        // pointsLabel.setText(client.getPoints() + " Points");
        pointsLabel.setText("10 Points");

        // o Der QuoteButton für das übergebene
        // Zitat ist auf den korrekten Zitat-Typ zu setzen
        // o Alle QuoteButtons, die noch
        // im Zustand UNKNOWN sind, sind wieder zu aktivieren
        boolean stillUnknown = false;
        for (QuoteButton b : buttons) {
            if (b.getQuote() == q) {
                b.setType(q.getType());
            }
            if (b.getType() == QuoteType.UNKNOWN) {
                b.setEnabled(true);
                stillUnknown = true;

            }

        }

        // ▪ Ist kein QuoteButton
        // mehr im Zustand UNKNOWN (d.h. alle Zitate wurden bereits gespielt) ist ein
        // Dialog mit den Punkten aller Spieler anzuzeigen, der über das Ende des Spiels
        // informiert (vgl. Screenshot unten rechts).
        if (!stillUnknown) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Game finished. Score: ");
            for (FakeTalkClient c : clients) {
                sb2.append(c.getPlayerName()).append(" (").append(c.getPoints()).append(") ");
            }
            String result2 = sb2.toString();
            JOptionPane.showMessageDialog(null, result2, "Game finished!", JOptionPane.INFORMATION_MESSAGE);

            File f = new File("altklausuren/FakeTalk/Lösungsvorschlag Miriam/src/fake-score.txt");

            try (BufferedWriter wr = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(f, true),
                            StandardCharsets.UTF_8))) {
                wr.write(result2);
                wr.write(System.lineSeparator());
            } catch (IOException e) {
                throw new FakeNewsException(e.getMessage());
            }

        } else {
            // ▪ Ansonsten ist der nächste Spieler an der Reihe und soll zur Auswahl eines
            // Zitats aufgefordert werden (Label am oberen Rand).
            currentPlayer++;
            if (currentPlayer >= clients.size()) {
                currentPlayer = 0;
            }
            currentPlayerLabel.setText("Pick a quote: " + clients.get(currentPlayer).getPlayerName());
        }
    }

    public void pointsCounter() {
        // System.out.println("Thread started");
        pointsCounter = new Thread(() -> {
            try {
                for (int i = 10; i >= 1; i--) {
                    // System.out.println("+ sec");
                    this.points = i;
                    pointsLabel.setText(i + " Points");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
            }
        });
        pointsCounter.start();
    }
}
