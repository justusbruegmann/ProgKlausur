public enum QuestionType {
    YES_NO("Yes/No question"),
    WITNESS("Witness may be involved"),
    GENERAL("General question");

    private String label;

    private QuestionType( String label ) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

}
