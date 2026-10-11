public class QuestionEvasion {

    private String text;
    private boolean start;
    private QuestionType type;

    public QuestionEvasion(String text, boolean start, QuestionType type ) {
        super();
        this.text = text;
        this.start = start;
        this.type = type;
    }

    public String getText() {
        return this.text;
    }

    public void setText( String text ) {
        this.text = text;
    }

    public boolean isStart() {
        return this.start;
    }

    public void setStart( boolean start ) {
        this.start = start;
    }

    public QuestionType getType() {
        return this.type;
    }

    public void setType( QuestionType type ) {
        this.type = type;
    }

}
