
import javax.swing.JButton;

public class QuoteButton extends JButton {
    private QuoteType type;
    private Quote quote;

    public QuoteType getType() {
        return type;
    }

    public Quote getQuote() {
        return quote;
    }

    public QuoteButton(Quote quote) {
        this.quote = quote;
        this.type = QuoteType.UNKNOWN;
    }

    public void setType(QuoteType type) {
        this.type = type;
        setBackground(type.getColor());
        setIcon(type.getIcon());
    }

    public boolean isUnknown() {
        return (type == QuoteType.UNKNOWN);
    }

}
