package gans;

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

	private ChatMessagesComponent chatMessagesComponent = new ChatMessagesComponent();

	private JTextField messageField = new JTextField();

	private JButton sendButton = new JButton("Send");

	private Account account;
	private SnatChatRoom room;

	public SnatChatWindow(SnatChatRoom room, Account account) {
		super(String.format("%s (%s)", account.getName(), room.getName()));
		this.account = account;
		this.room = room;
		this.initUI(account);

		ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (messageField.getText().isBlank()) {
					JOptionPane.showMessageDialog(SnatChatWindow.this, "Empty text field :(");
				} else {
					Message m = new Message(messageField.getText(), account);
					room.sendMessage(m);
				}

			}
		};
		this.sendButton.addActionListener(al);
		this.messageField.addActionListener(al);
	}

	private void initUI(Account account) {
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
			panStateRadios.add(radioButton);

			if (s == account.getState()) {
				radioButton.setSelected(true);
			}

			radioButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String txt = "state of user " + account.getName() + " is now " + s.getLabel();
					room.sendMessage(txt);
				}
			});
		}
		panelSouth.add(panStateRadios, BorderLayout.NORTH);

		this.add(panelSouth, BorderLayout.SOUTH);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(325, 300);
		this.setVisible(true);
	}

	@Override
	public void receiveMessage(Message msg) {
		receiveMsg(msg.getSender().getName() + ": " + msg.getText(), msg.getSender().getColor());
	}

	@Override
	public void receiveMessage(String text) {
		receiveMsg(text, Color.GRAY);
	}

	private void receiveMsg(String text, Color c) {
		JLabel lbl = new JLabel(text);
		lbl.setForeground(c);
		this.chatMessagesComponent.add(lbl);
	}

	@Override
	public Account getAccount() {
		return account;
	}

}
