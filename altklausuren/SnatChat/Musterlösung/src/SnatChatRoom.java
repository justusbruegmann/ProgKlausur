
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class SnatChatRoom {
    private String roomName;
    private List<SnatChatFrontend> frontends = new ArrayList<>();

    public SnatChatRoom(String roomName) {
        super();
        this.roomName = roomName;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public void sendMessage(Message message) {
        this.logMessage(message.toString());
        for (SnatChatFrontend s : this.frontends) {
            s.receiveMessage(message);
        }
    }

    public void sendMessage(String text) {
        this.logMessage(text);
        for (SnatChatFrontend s : this.frontends) {
            s.receiveMessage(text);
        }
    }

    public void register(SnatChatFrontend frontend) {
        this.frontends.add(frontend);
        for (String logMsg : this.loadLogFile()) {
            frontend.receiveMessage(logMsg);
        }
    }

    public void unregister(SnatChatFrontend frontend) {
        this.frontends.remove(frontend);
    }

    private List<String> loadLogFile() {
        List<String> log = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(this.roomName + ".txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                log.add(Message.rot13(line));
            }
        } catch (Exception e) {
        }
        // Erweiterung max 10 Nachrichten
        if (log.size() > 10) {
            log = log.subList(log.size() - 10, log.size());
        }
        return log;
    }

    private void logMessage(String text) {
        try (PrintWriter pw = new PrintWriter(
                new FileWriter(this.roomName + ".txt", true))) {
            pw.println(Message.rot13(text));
        } catch (Exception e) {
        }
    }
}
