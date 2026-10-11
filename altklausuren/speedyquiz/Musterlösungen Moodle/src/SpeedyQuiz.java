import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * Speedy Quiz
 */
public class SpeedyQuiz {

    /**
     * Main method, entry point of application
     *
     * @param args CLI arguments
     */
    public static void main(String[] args) {
        // Set cross platform LAF to get colors to work for sure on MacOS
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
        }

        List<Question> questionPool = loadQuestions();

        try {
            Game game = new Game(questionPool, 10);

            game.registerClient(new GameTerm("Ben", game));
            game.registerClient(new GameTerm("Mia", game));

            game.startGame();
        } catch (GameException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Game Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Load questions
     *
     * @return questions to load
     */
    public static List<Question> loadQuestions() {
        List<Question> questions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("altklausuren/speedyquiz/Musterlösungen Moodle/src/questions.txt"))) {
            while (br.ready()) {
                Question q = parseQuestion(br.readLine());
                if (q != null) {
                    questions.add(q);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error loading questions",
                    JOptionPane.ERROR_MESSAGE);
        }
        return questions;
    }

    /**
     * Parse a question from input line
     *
     * @param line line to parse
     * @return created question instance
     */
    public static Question parseQuestion(String line) {
        try {
            String[] parts = line.split(";");
            if (parts.length == 6) {
                String[] answers = new String[4];
                System.arraycopy(parts, 1, answers, 0, 4);
                return new Question(parts[0], answers, Integer.parseInt(parts[5]));
            }
        } catch (Exception e) {
        }
        return null;
    }
}
