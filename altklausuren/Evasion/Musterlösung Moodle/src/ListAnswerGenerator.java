import java.util.List;

public class ListAnswerGenerator implements AnswerGenerator {

    private List<Evasion> evasions;

    public ListAnswerGenerator( List<Evasion> evasions ) {
        super();
        this.evasions = evasions;
    }

    @Override
    public String generateAnswer(QuestionEvasion q, String topic ) {
        // 10x versuchen eine zufaellige Antwort -> Fallback dann falls keine
        // gefunden (spart Kopfschmerzen zu checken ob wir passende Kombis haben
        // fuer alles :-)
        for ( int i = 0; i < 10; i++ ) {
            Evasion randEv = this.evasions.get( (int) (Math.random() * this.evasions.size()) );
            if ( randEv.isEvasionFor( q ) ) {
                return Evasionator.replaceTopic( randEv.getText(), topic );
            }
        }
        return "Keine Antwort ist auch eine Antwort, gelle?";
    }

    @Override
    public Evasion getRandomEvasion() {
        return this.evasions.get( (int) (Math.random() * this.evasions.size()) );
    }

}
