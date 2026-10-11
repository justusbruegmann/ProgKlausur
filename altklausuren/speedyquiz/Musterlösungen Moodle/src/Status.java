import java.awt.Color;

/**
 * Status
 */
public enum Status {

    /**
     * Active
     */
    ACTIVE(Color.ORANGE, 0),

    /**
     * Correct
     */
    CORRECT(Color.GREEN, 1),

    /**
     * Wrong
     */
    WRONG(Color.RED, -1),

    /**
     * Pending
     */
    PENDING(Color.WHITE, 0),

    /**
     * No answer
     */
    NO_ANSWER(Color.GRAY, 0);

    /**
     * Color for status
     */
    private final Color color;

    /**
     * Points for status
     */
    private final int points;

    /**
     * Create status
     *
     * @param color  color
     * @param points points
     */
    private Status(Color color, int points) {
        this.color = color;
        this.points = points;
    }

    /**
     * Get color
     *
     * @return color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Get points
     *
     * @return points
     */
    public int getPoints() {
        return points;
    }
}
