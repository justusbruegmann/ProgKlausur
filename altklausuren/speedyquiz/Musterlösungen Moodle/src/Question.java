/**
 * Question
 */
public class Question {

    /**
     * Text of question
     */
    private final String questionText;

    /**
     * Answers
     */
    private final String[] answers;

    /**
     * Correct index
     */
    private final int correctIndex;

    /**
     * Create question
     *
     * @param questionText text of question
     * @param answers      answers
     * @param correctIndex correct index
     */
    public Question(String questionText, String[] answers, int correctIndex) {
        super();
        this.questionText = questionText;
        this.answers = answers;
        this.correctIndex = correctIndex;
    }

    /**
     * Get the answers
     *
     * @return answers
     */
    public String[] getAnswers() {
        return answers;
    }

    /**
     * Get the correct index
     *
     * @return correct index
     */
    public int getCorrectIndex() {
        return correctIndex;
    }

    /**
     * Get the question text
     *
     * @return question text
     */
    public String getQuestionText() {
        return questionText;
    }
}
