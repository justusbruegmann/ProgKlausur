import javax.swing.JLabel;

/**
 * Question number label
 */
@SuppressWarnings("serial")
public class QuestionNumberLabel extends JLabel {

    /**
     * Current status
     */
    private Status status;

    /**
     * Create the question number label
     *
     * @param number number
     */
    public QuestionNumberLabel(int number) {
        super(Integer.toString(number), JLabel.CENTER);
        this.setOpaque(true);
        this.setStatus(Status.PENDING);
    }

    /**
     * Set the status (and adapt background)
     *
     * @param status status to set
     */
    public void setStatus(Status status) {
        this.status = status;
        this.setBackground(status.getColor());
    }

    /**
     * Get the status
     *
     * @return status
     */
    public Status getStatus() {
        return this.status;
    }
}
