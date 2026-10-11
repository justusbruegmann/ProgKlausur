import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * Game terminal
 */
@SuppressWarnings("serial")
public class GameTerm extends JFrame implements GameClient {

    /**
     * The game reference
     */
    private final Game game;

    /**
     * Name of the player
     */
    private final String playerName;

    /**
     * The button for the answers
     */
    private final JButton[] btnAnswers = new JButton[4];

    /**
     * Label for question text
     */
    private final JLabel lblQuestionText = new JLabel("", JLabel.CENTER);

    /**
     * Label for countdown
     */
    private final JLabel lblCountdown = new JLabel("", JLabel.CENTER);

    /**
     * Array with all question number labels
     */
    private final QuestionNumberLabel[] lblQNumbers;

    /**
     * Create game terminal
     *
     * @param playerName name of player
     * @param game       game reference
     */
    public GameTerm(String playerName, Game game) {
        super(playerName);
        this.game = game;
        this.playerName = playerName;
        this.lblQNumbers = new QuestionNumberLabel[game.getQuestionsCount()];

        this.initUI();
    }

    /**
     * Initialize user interface
     */
    private void initUI() {
        this.setLayout(new BorderLayout(5, 5));

        JPanel panQNumLabels = new JPanel(new GridLayout(1, this.game.getQuestionsCount(), 5, 5));
        for (int i = 0; i < this.lblQNumbers.length; i++) {
            this.lblQNumbers[i] = new QuestionNumberLabel(i + 1);
            panQNumLabels.add(this.lblQNumbers[i]);
        }

        JPanel panQLabelCountdown = new JPanel(new GridLayout(2, 1));
        panQLabelCountdown.add(this.lblQuestionText);
        panQLabelCountdown.add(this.lblCountdown);

        JPanel panButtons = new JPanel(new GridLayout(2, 2, 5, 5));
        for (int i = 0; i < this.btnAnswers.length; i++) {
            this.btnAnswers[i] = new JButton("");
            final int index = i;
            this.btnAnswers[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    GameTerm.this.game.answerSelected(GameTerm.this, index);
                }
            });
            panButtons.add(this.btnAnswers[i]);
        }

        this.add(panQNumLabels, BorderLayout.NORTH);
        this.add(panQLabelCountdown, BorderLayout.CENTER);
        this.add(panButtons, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(600, 150);
        this.setVisible(true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAnswerState(int questionIndex, Status status) {
        this.lblQNumbers[questionIndex].setStatus(status);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getPoints() {
        int cnt = 0;
        for (QuestionNumberLabel l : this.lblQNumbers) {
            cnt += l.getStatus().getPoints();
        }
        return Math.max(0, cnt);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setQuestion(int questionIndex, Question q) {
        this.lblQuestionText.setText(q.getQuestionText());
        this.setAnswerState(questionIndex, Status.ACTIVE);

        String[] answers = q.getAnswers();
        for (int i = 0; i < this.btnAnswers.length; i++) {
            this.btnAnswers[i].setText(answers[i]);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setRemainingSeconds(int seconds) {
        this.lblCountdown.setText(Integer.toString(seconds));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPlayerName() {
        return this.playerName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void gameIsOver() {
        for (JButton btn : this.btnAnswers) {
            btn.setEnabled(false);
        }
    }
}
