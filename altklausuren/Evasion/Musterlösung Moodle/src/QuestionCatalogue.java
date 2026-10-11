import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class QuestionCatalogue {

    private List<QuestionEvasion> startQuestions = new LinkedList<>();
    private List<QuestionEvasion> questions = new LinkedList<>();

    public void addQuestion( QuestionEvasion q ) {
        if ( q.isStart() ) {
            this.startQuestions.add( q );
        } else {
            this.questions.add( q );
        }
    }

    public List<QuestionEvasion> getStartQuestions() {
        return this.startQuestions;
    }

    public List<QuestionEvasion> getQuestions() {
        return this.questions;
    }

    public List<QuestionEvasion> getQuestions(int n ) throws EvasionException {
        if ( n > this.questions.size() + 1 ) {
            throw new EvasionException( "Too few questions available" );
        }

        List<QuestionEvasion> result = new LinkedList<>();

        Collections.shuffle( this.startQuestions );
        Collections.shuffle( this.questions );

        result.add( this.startQuestions.get( 0 ) );
        result.addAll( this.questions.subList( 0, n - 1 ) );

        return result;
    }

}
