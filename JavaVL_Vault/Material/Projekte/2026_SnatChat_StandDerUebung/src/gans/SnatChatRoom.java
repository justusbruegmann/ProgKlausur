package gans;

import java.util.LinkedList;
import java.util.List;

public class SnatChatRoom {
	
	private String name; // name statt roomName auch OK!

	private List<SnatChatFrontend> frontends = new LinkedList<>();
	
	public SnatChatRoom(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void register(SnatChatFrontend s) {
		this.frontends.add(s);
	}
	public void unregister(SnatChatFrontend s) {
		this.frontends.remove(s);
	}
	
	public void sendMessage(Message m) {
		for ( SnatChatFrontend f : this.frontends ) {
			f.receiveMessage(m);
		}
	}
	
	public void sendMessage(String text) {
		for ( SnatChatFrontend f : this.frontends ) {
			f.receiveMessage(text);
		}
	}

}
