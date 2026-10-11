
import java.util.List;

import javax.swing.JFrame;

import java.awt.GridLayout;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;

public class ConnectionSelectionTerm extends JFrame {
    private String namePerson;

    public ConnectionSelectionTerm(List<TrainConnection> connections) {
        namePerson = "";
        setTitle("Connections");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel firstPanel = new JPanel(new GridLayout(1, 2));
        JLabel name = new JLabel("Name");
        firstPanel.add(name);
        JTextField nameTextField = new JTextField("");
        firstPanel.add(nameTextField);

        add(firstPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        for (TrainConnection c : connections) {
            JPanel row = new JPanel(new GridLayout(1, 2));

            JButton buttonName = new JButton(c.getName());
            if (c.isRegional()) {
                ImageIcon icon = DBVasion.createDLTicketIcon();
                buttonName.setIcon(icon);
            }
            JButton buttonBuy = new JButton("Buy Ticket");
            buttonBuy.addActionListener(e -> {
                this.namePerson = nameTextField.getText();
                try {
                    buy(c);
                } catch (DBException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            });
            row.add(buttonName);
            row.add(buttonBuy);
            centerPanel.add(row);

        }
        add(centerPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void buy(TrainConnection c) throws DBException {
        System.out.println(namePerson);
        double randomNumber = Math.random();
        if (randomNumber < 0.7) {
            String result = "This connection was cancelled.";
            String title = "Meldung";
            JOptionPane.showMessageDialog(null, result, title, JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (namePerson.equals("")) {
            System.out.println("jetzt");
            String result = "Please enter a name.";
            String title = "Meldung";
            JOptionPane.showMessageDialog(null, result, title, JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        new ConnectionTerm(c);
        // String result = "Regular price: EURO" + c.getPrice()
        // + ". DO you want to by a 'Super-Sparpreis'ticket? (80% discount)";
        // String title = "Meldung";
        // JOptionPane.showMessageDialog(null, result, title,
        // JOptionPane.YES_NO_OPTION);
        boolean discount = JOptionPane.showConfirmDialog(null, "Regular price: EUR " + c.getPrice()
                + ". Do you want to by a 'Super-Sparpreis'ticket? (80% discount)", "Discount?",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

        String result;
        if (discount) {
            double newPrice = c.getPrice() * 0.8;
            result = "Ticket for " + c.getName() + ": " + this.namePerson + " ( EUR " + newPrice
                    + " - Super-Sparpreis)";
        } else {
            result = "Ticket for " + c.getName() + ": " + this.namePerson + " ( EUR " + c.getPrice()
                    + " - Regular)";
        }
        String title = "Meldung";
        JOptionPane.showMessageDialog(null, result, title, JOptionPane.INFORMATION_MESSAGE);

        File f = new File("Probeklausur3_DBVasion/tickets.txt");
        try (BufferedWriter wr = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(f, true), StandardCharsets.UTF_8))) {
            wr.write(result);
            wr.write(System.lineSeparator());
        } catch (IOException e) {
            throw new DBException(e.getMessage());
        }
    }
}
