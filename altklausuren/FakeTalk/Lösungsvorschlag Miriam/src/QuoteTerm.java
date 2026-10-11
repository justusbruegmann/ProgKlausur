
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class QuoteTerm extends JFrame implements FakeTalkClient {

    private String playerName;
    private int points;
    private Quote currentQuote;

    private QuoteDisplay quoteDisplay;
    private JButton hotShitButton;
    private JButton bullshitButton;
    private JLabel pointsLabel;

    public QuoteTerm(String playerName, QuoteSelectionTerm selectionTerm) {
        this.playerName = playerName;
        setTitle(playerName);
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel center = new JPanel(new GridLayout(2, 1));
        quoteDisplay = new QuoteDisplay();
        center.add(quoteDisplay);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        hotShitButton = new JButton(FakeTalkIcons.ICON_HOT_SHIT);
        bullshitButton = new JButton(FakeTalkIcons.ICON_BULLSHIT);

        hotShitButton.setEnabled(false);
        bullshitButton.setEnabled(false);

        hotShitButton.addActionListener(e -> {
            hotShitButton.setEnabled(false);
            bullshitButton.setEnabled(false);

            try {
                selectionTerm.answerSelected(this, currentQuote, QuoteType.HOT_SHIT);
            } catch (FakeNewsException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });

        bullshitButton.addActionListener(e -> {
            hotShitButton.setEnabled(false);
            bullshitButton.setEnabled(false);

            try {
                selectionTerm.answerSelected(this, currentQuote, QuoteType.BULLSHIT);
            } catch (FakeNewsException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });

        buttonPanel.add(hotShitButton);
        buttonPanel.add(bullshitButton);
        center.add(buttonPanel);

        add(center, BorderLayout.CENTER);

        pointsLabel = new JLabel(String.valueOf(points));
        add(pointsLabel, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public String getPlayerName() {
        return playerName;
    }

    @Override
    public void setQuote(Quote q) {
        this.currentQuote = q;
        quoteDisplay.setText(currentQuote.getText());
        hotShitButton.setEnabled(true);
        bullshitButton.setEnabled(true);
    }

    @Override
    public void addPoints(int points) {
        this.points += points;
        pointsLabel.setText(String.valueOf(this.points));
    }

    @Override
    public int getPoints() {
        return points;
    }

}
