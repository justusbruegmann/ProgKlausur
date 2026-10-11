
public interface FakeTalkClient {

    String getPlayerName();

    void setQuote(Quote q);

    void addPoints(int points);

    int getPoints();
}
