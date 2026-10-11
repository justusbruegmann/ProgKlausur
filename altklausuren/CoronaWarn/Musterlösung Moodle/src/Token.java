
import java.util.Date;

public class Token {
    private final String value;
    private final Date date;

    public Token() {
        this.value = java.util.UUID.randomUUID().toString();
        this.date = new Date();
    }

    public Token(String value, Date date) {
        this.value = value;
        this.date = date;
    }

    public String getValue() {
        return value;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return this.value + "@" + this.date;
    }
}
