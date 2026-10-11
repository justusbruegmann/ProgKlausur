import java.util.List;

public class Evasion {
    private String text;
    private List<QuestionType> types;

    public Evasion( String text, List<QuestionType> types ) {
        super();
        this.text = text;
        this.types = types;
    }

    public String getText() {
        return this.text;
    }

    public void setText( String text ) {
        this.text = text;
    }

    public List<QuestionType> getTypes() {
        return this.types;
    }

    public void setTypes( List<QuestionType> types ) {
        this.types = types;
    }

    public boolean isEvasionFor( QuestionEvasion q ) {
        return this.types.contains( q.getType() );
    }
}
