
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SnatChatWindow extends JFrame implements SnatChatFrontend {
    private SnatChatRoom room;
    private final Account account;
    private ChatMessagesComponent chatMessagesComponent = new ChatMessagesComponent();
    private JTextField messageField = new JTextField();
    private JButton sendButton = new JButton("Send");

    public SnatChatWindow(SnatChatRoom room, Account account) {
        super(String.format("%s (%s)", account.getName(),
                room.getRoomName()));
        this.account = account;
        this.room = room;
        this.initUI();
    }

    private void initUI() {
        this.setLayout(new BorderLayout(5, 5));
        JLabel labelName = new JLabel(account.getName(), JLabel.CENTER);
        labelName.setForeground(account.getColor());
        this.add(labelName, BorderLayout.NORTH);
        this.add(this.chatMessagesComponent, BorderLayout.CENTER);
        JPanel panelSouth = new JPanel(new BorderLayout(5, 5));
        panelSouth.add(this.messageField, BorderLayout.CENTER);
        panelSouth.add(this.sendButton, BorderLayout.EAST);
        ButtonGroup btnGrp = new ButtonGroup();
        JPanel panStateRadios = new JPanel(new FlowLayout());
        for (final State s : State.values()) {
            JRadioButton radioButton = new JRadioButton(s.getLabel());
            btnGrp.add(radioButton);
            radioButton.setSelected(s == account.getState());
            radioButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    account.setState(s);
                    room.sendMessage(
                            String.format("State of user '%s' is now '%s'",
                                    account.getName(), s.getLabel()));
                }
            });
            panStateRadios.add(radioButton);
        }
        panelSouth.add(panStateRadios, BorderLayout.NORTH);
        this.add(panelSouth, BorderLayout.SOUTH);
        this.sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        // Zusatzpunkt
        this.messageField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessage();
                }
            }
        });
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(325, 300);
        this.setVisible(true);
    }

    @Override
    public void receiveMessage(String text) {
        this.receiveMessage(text, Color.GRAY);
    }

    @Override
    public void receiveMessage(Message msg) {
        this.receiveMessage(msg.toString(), msg.getSender().getColor());
    }

    @Override
    public Account getAccount() {
        return this.account;
    }

    private void receiveMessage(final String text, Color color) {
        JLabel messageLabel = new JLabel(text);
        messageLabel.setForeground(color);
        new Thread() {
            public void run() {
                int seconds = 30;
                while (seconds >= 0) {
                    messageLabel.setText(text + " [ " + seconds-- + " ]");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
                SnatChatWindow.this.chatMessagesComponent.remove(messageLabel);
            };
        }.start();
        this.chatMessagesComponent.add(messageLabel);
    }

    private void sendMessage() {
        if (!this.messageField.getText().isEmpty()) {
            this.room.sendMessage(
                    new Message(this.account, this.messageField.getText()));
            this.messageField.setText("");
        } else {
            JOptionPane.showMessageDialog(this,
                    String.format("Dear %s, please enter a message",
                            this.account.getName()),
                    "Warning!", JOptionPane.WARNING_MESSAGE);
        }
    }
}