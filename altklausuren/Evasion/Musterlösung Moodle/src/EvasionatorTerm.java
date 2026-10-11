import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

@SuppressWarnings( "serial" )
public class EvasionatorTerm extends JFrame {

    // wenn man alles im Konstruktor macht braucht man die eigentlich nicht ->
    // koennte man offen lassen?
    // private QuestionCatalogue qCatalog;
    // private AnswerGenerator answerGen;
    // private QuestionnaireTerm questionnaireTerm;

    public EvasionatorTerm( QuestionCatalogue qCatalog, AnswerGenerator answerGen,
                            QuestionnaireTerm questionnaireTerm ) {
        super( "Evasionator\u2122" ); // das TM waere verzichtbar *G*

        // siehe oben
        // this.qCatalog = qCatalog;
        // this.answerGen = answerGen;
        // this.questionnaireTerm = questionnaireTerm;

        JTextField txtTopic = new JTextField();
        JTextField txtCount = new JTextField();
        JPanel panInput = new JPanel( new GridLayout( 2, 2 ) );
        panInput.add( new JLabel( "Topic:" ) );
        panInput.add( txtTopic );
        panInput.add( new JLabel( "Question count:" ) );
        panInput.add( txtCount );

        this.add( panInput, BorderLayout.CENTER );

        JPanel panBtn = new JPanel();
        JButton btnGen = new JButton( "Generate!" );
        JButton btnRandomAnswer = new JButton( "Random Answer" );
        panBtn.add( btnGen );
        panBtn.add( btnRandomAnswer );
        this.add( panBtn, BorderLayout.SOUTH );

        this.pack();
        this.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        this.setVisible( true );

        btnGen.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                String topic = txtTopic.getText();
                if ( Evasionator.containsUnreasonableKeyword( topic ) ) {
                    JOptionPane.showMessageDialog( btnGen, "Sorry, the topic " + topic + " is forbidden" );
                    return;
                }

                try {
                    int count = Integer.parseInt( txtCount.getText() );

                    List<QuestionEvasion> questions = qCatalog.getQuestions( count );

                    // wurde ich offen lassen, ob hier oder in der andern GUI
                    // generiert
                    StringBuilder sb = new StringBuilder();
                    int num = 1;
                    for ( QuestionEvasion q : questions ) {
                        sb.append( "Frage " + num + ": " );
                        sb.append( Evasionator.replaceTopic( q.getText(), topic ) );
                        sb.append( "\n" );
                        sb.append( answerGen.generateAnswer( q, topic ) );
                        sb.append( "\n" );
                        sb.append( "\n" );
                        num++;
                    }
                    questionnaireTerm.setQuestionnaire( sb.toString() );

                } catch ( NumberFormatException nfe ) {
                    JOptionPane.showMessageDialog( btnGen, "Invalid count!" );
                } catch ( EvasionException eve ) {
                    JOptionPane.showMessageDialog( btnGen, eve.getMessage() );
                }
            }
        } );

        btnRandomAnswer.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                Evasion ev = answerGen.getRandomEvasion();
                StringBuilder sb = new StringBuilder();
                sb.append( ev.getText() + " (Suitable for: " );
                boolean first = true;
                for ( QuestionType t : ev.getTypes() ) {
                    if ( first ) {
                        first = false;
                    } else {
                        sb.append( ", " );
                    }
                    sb.append( t.getLabel() );
                }
                sb.append( ")" );

                JOptionPane.showMessageDialog( btnRandomAnswer, sb.toString() );
            }
        } );

    }

}
