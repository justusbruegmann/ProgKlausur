public interface AnswerGenerator {
    String generateAnswer(QuestionEvasion q, String topic );
    Evasion getRandomEvasion();
}
