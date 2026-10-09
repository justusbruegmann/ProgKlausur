package gans;

public interface SnatChatFrontend {

	void receiveMessage(Message msg);
	void receiveMessage(String text);
	Account getAccount();
}
