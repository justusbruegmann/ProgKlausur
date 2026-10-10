import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;

public class BieterTerminal {
    private final Bieter bidder;
    private final Auktionshaus ah;
    private ArrayList<JLabel[]> priceLabels = new ArrayList<JLabel[]>();
    JLabel timeLabel;

    public BieterTerminal(Bieter bidder, Auktionshaus ah) {
        this.bidder = bidder;
        this.ah = ah;
        this.ah.registerTerminal(this);

        // Update the time label every second by using a Thread
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                updateTimeLabel();
            }
        }).start();

        ui();
    }

    private void ui() {
        JFrame frame = new JFrame(this.bidder.getFullName() + "'s Terminal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        this.timeLabel = new JLabel(Calendar.getInstance().getTime().toString());
        frame.add(timeLabel, BorderLayout.NORTH);

        JPanel gridPanel = new JPanel(new GridLayout(this.ah.getAuktionen().size(), 5));

        for (Auktion a : this.ah.getAuktionen()) {
            JLabel entryTitle = new JLabel(a.getWare().getTitle());
            JLabel priceLabel = new JLabel(String.valueOf(a.getCurrentPrice()));
            JLabel highestBidderLabel = new JLabel(a.getCurrentHighestBid() != null ? a.getCurrentHighestBid().bidder().getFullName() : "---");
            JLabel endTimeLabel = new JLabel(a.getEnd().getTime().toString());
            JButton biddingButton = new JButton("Gebot");
            biddingButton.addActionListener(e -> gebotPopup(a, priceLabel, highestBidderLabel));

            priceLabels.add(new JLabel[]{priceLabel, highestBidderLabel});

            gridPanel.add(entryTitle);
            gridPanel.add(priceLabel);
            gridPanel.add(highestBidderLabel);
            gridPanel.add(endTimeLabel);
            gridPanel.add(biddingButton);
        }


        frame.add(gridPanel, BorderLayout.CENTER);
        frame.setSize(600, 400);
        frame.setVisible(true);
    }

    public void updateUi() {
        for (int i = 0; i < this.priceLabels.size(); i++) {
            JLabel[] labels = this.priceLabels.get(i);
            JLabel priceLabel = labels[0];
            JLabel highestBidderLabel = labels[1];

            Auktion a = this.ah.getAuktionen().get(i);
            priceLabel.setText(String.valueOf(a.getCurrentPrice()));
            highestBidderLabel.setText(a.getCurrentHighestBid() != null ? a.getCurrentHighestBid().bidder().getFullName() : "---");
        }
    }

    private void gebotPopup(Auktion a, JLabel priceLabel, JLabel highestBidderLabel) {
        {
            String input = JOptionPane.showInputDialog(null, "Bitte neues Gebot eingeben. Mindestgebot: " + (a.getCurrentPrice() + a.getIncrement()) + " Euro", "Submit Bid", JOptionPane.PLAIN_MESSAGE);

            if (a.getEnd().before(Calendar.getInstance())) {
                JOptionPane.showMessageDialog(null, "Die Auktion ist leider schon vorbei.");
                return;
            }

            if (input != null && !input.isEmpty()) {
                try {
                    double bidAmount = Double.parseDouble(input);
                    Gebot gebot = new Gebot(this.bidder, bidAmount);

                    boolean success = a.gebotAbgeben(gebot);
                    if (success) {
                        JOptionPane.showMessageDialog(null, "Sie sind Höchstbietender!");
                        priceLabel.setText(String.valueOf(a.getCurrentPrice()));
                        highestBidderLabel.setText(a.getCurrentHighestBid().bidder().getFullName());
                        jBay.updateUi();
                    } else {
                        JOptionPane.showMessageDialog(null, "Bid was not successful. Please try again.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Gebot zu gering.");
                }
            }
        }
    }


    private void updateTimeLabel() {
        timeLabel.setText(Calendar.getInstance().getTime().toString());
    }
}