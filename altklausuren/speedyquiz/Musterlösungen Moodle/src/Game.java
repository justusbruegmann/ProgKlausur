import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Game management
 */
public class Game {

    /**
     * Current question index, initialized with <code>-1</code>
     * so increment at beginning of {@link #nextQuestion()}
     * will result in index 0
     */
    private int currentQuestionIndex = -1;

    /**
     * List of questions
     */
    private List<Question> questions = new LinkedList<>();

    /**
     * Client list
     */
    private List<GameClient> clients = new ArrayList<>();

    /**
     * Time when {@link #startGame()} is called
     */
    private long startTime;

    /**
     * Create game
     *
     * @param questionPool question pool
     * @param count        count of questions to use
     * @throws GameException if too few questions are available
     */
    public Game(List<Question> questionPool, int count) throws GameException {
        if (questionPool.size() < count) {
            throw new GameException("Too few questions available!");
        }

        Collections.shuffle(questionPool);
        for (int i = 0; i < count; i++) {
            questions.add(questionPool.get(i));
        }
    }

    /**
     * Register a client
     *
     * @param client client to register
     */
    public void registerClient(GameClient client) {
        if (this.currentQuestionIndex == -1) { // -1 only if game not started
            this.clients.add(client);
        }
    }

    /**
     * Next question
     */
    private void nextQuestion() {
        this.currentQuestionIndex++;
        if (this.currentQuestionIndex < this.getQuestionsCount()) {
            for (GameClient t : this.clients) {
                t.setQuestion(this.currentQuestionIndex, this.getCurrentQuestion());
            }
            this.startQuestionCountdown();
        } else {
            for (GameClient client : this.clients) {
                client.gameIsOver();
            }
            this.doScoreAndLog();
        }
    }

    /**
     * Do score and logging
     */
    private void doScoreAndLog() {
        long durationSec = (System.currentTimeMillis() - this.startTime) / 1000;

        List<String> scores = new LinkedList<>();
        for (GameClient t : this.clients) {
            scores.add(t.getPlayerName() + " (" + t.getPoints() + ")");
        }
        String score = "Game finished after " + durationSec + " seconds, score: "
                + String.join(", ", scores);

        try (PrintWriter pw = new PrintWriter(new FileWriter("altklausuren/speedyquiz/Musterlösungen Moodle/src/highscore.txt", true))) {
            pw.println(score);
        } catch (Exception e) {
            e.printStackTrace();
        }

        JOptionPane.showMessageDialog(null, score);
    }

    /**
     * Get current question
     *
     * @return current question
     */
    private Question getCurrentQuestion() {
        return this.questions.get(this.currentQuestionIndex);
    }

    /**
     * Get count of questions
     *
     * @return count of questions
     */
    public int getQuestionsCount() {
        return this.questions.size();
    }

    /**
     * Answer selected
     *
     * @param client client
     * @param index  index of answer (0-based)
     */
    public void answerSelected(GameClient client, int index) {
        boolean correct = this.getCurrentQuestion().getCorrectIndex() == index;

        for (GameClient t : this.clients) {
            if (t == client) {
                t.setAnswerState(this.currentQuestionIndex, correct ? Status.CORRECT : Status.WRONG);
            } else {
                t.setAnswerState(this.currentQuestionIndex, Status.NO_ANSWER);
            }
        }
        this.nextQuestion();
    }

    /**
     * Start the game
     */
    public void startGame() {
        this.startTime = System.currentTimeMillis();
        this.nextQuestion();
    }

    /**
     * Start question countdown
     */
    private void startQuestionCountdown() {
        final int questionIndexAtStart = this.currentQuestionIndex;
        new Thread(new Runnable() {

            @Override
            public void run() {
                int remaining = 10;
                while (questionIndexAtStart == currentQuestionIndex && remaining >= 0) {
                    if (remaining == 0) {
                        answerSelected(null, -1);
                    } else {
                        for (GameClient t : Game.this.clients) {
                            t.setRemainingSeconds(remaining);
                        }
                        remaining--;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }, "q-" + questionIndexAtStart + "-countdown").start();
    }
}
