package gans;

public class Message {

	private String text;
	private Account sender;
	public Message(String text, Account sender) {
		super();
		this.text = text;
		this.sender = sender;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Account getSender() {
		return sender;
	}
	public void setSender(Account sender) {
		this.sender = sender;
	}
	
	
}
