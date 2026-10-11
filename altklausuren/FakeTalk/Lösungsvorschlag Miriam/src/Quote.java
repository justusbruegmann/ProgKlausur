
public class Quote {
    private String text;
    private String person;
    private String role;
    private String source;
    private QuoteType type;

    public QuoteType getType() {
        return type;
    }

    public String getText() {
        return text;
    }

    public String getPerson() {
        return person;
    }

    public String getRole() {
        return role;
    }

    public String getSource() {
        return source;
    }

    public Quote(String text, String person, String role, String source, QuoteType type) {
        this.text = text;
        this.person = person;
        this.role = role;
        this.source = source;
        this.type = type;
    }

    public String getCitation() {
        StringBuilder sb = new StringBuilder();
        // sb.append("This quote is ").append(type.getLabel()).append("!");
        // sb.append("From: (").append(person).append(", ").append(role).append(",
        // ").append(source);
        sb.append(person).append(" (").append(role).append(", ").append(source).append(")");
        String result = sb.toString();
        return result;
    }

}
