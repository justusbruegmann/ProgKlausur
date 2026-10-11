/**
 * Game client interface
 */
public interface GameClient {

    /**
     * Set the answer state
     *
     * @param questionIndex index of question (0-based)
     * @param status        status to set
     */
    public void setAnswerState(int questionIndex, Status status);

    /**
     * Get points
     *
     * @return points
     */
    public int getPoints();

    /**
     * Set the question
     *
     * @param questionIndex index of question
     * @param q             question itself
     */
    public void setQuestion(int questionIndex, Question q);

    /**
     * Set remaining seconds
     *
     * @param seconds seconds to set
     */
    public void setRemainingSeconds(int seconds);

    /**
     * Get the player name
     *
     * @return player name
     */
    public String getPlayerName();

    /**
     * To be called when game is over
     */
    public void gameIsOver();
}
