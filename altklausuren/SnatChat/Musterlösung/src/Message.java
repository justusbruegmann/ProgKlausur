
public class Message {
    private Account sender;
    private String text;

    public Message(Account sender, String text) {
        super();
        this.sender = sender;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public Account getSender() {
        return sender;
    }

    @Override
    public String toString() {
        return this.sender.getName() + ": " + this.text;
    }

    public static String rot13(String text) {
        char[] textArray = text.toCharArray();
        for (int i = 0; i < textArray.length; i++) {
            char ch = textArray[i];
            if (ch >= 'a' && ch <= 'm' || ch >= 'A' && ch <= 'M') {
                ch += 13;
            } else if (ch >= 'n' && ch <= 'z' || ch >= 'N' && ch <= 'Z') {
                ch -= 13;
            }
            textArray[i] = ch;
        }
        return new String(textArray);
    }
}