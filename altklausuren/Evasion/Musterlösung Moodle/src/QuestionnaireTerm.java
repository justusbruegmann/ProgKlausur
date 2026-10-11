import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

@SuppressWarnings( "serial" )
public class QuestionnaireTerm extends JFrame {

    private JTextArea txtQuestionnaire = new JTextArea();

    public QuestionnaireTerm() {
        super( "Questionnaire" );

        JButton btnSave = new JButton( "Save" );

        this.txtQuestionnaire.setEditable( false );
        this.add( new JScrollPane( this.txtQuestionnaire ), BorderLayout.CENTER );

        JPanel panBtn = new JPanel();
        panBtn.add( btnSave );
        this.add( panBtn, BorderLayout.SOUTH );

        btnSave.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                String txt = QuestionnaireTerm.this.txtQuestionnaire.getText();
                if ( txt.isEmpty() ) {
                    JOptionPane.showMessageDialog( btnSave, "Cannot save empty questionnaire." );
                } else {
                    try ( BufferedWriter br = new BufferedWriter( new FileWriter(
                            "files/exams/evasionator/questionnaires.txt", true ) ) ) {
                        br.write( "---" );
                        br.newLine();
                        br.write( txt );
                        br.newLine();
                    } catch ( Exception e2 ) {
                        JOptionPane.showMessageDialog( btnSave, "Error saving questionnaire." );
                    }
                }
            }
        } );

        this.setSize( 800, 600 );
        this.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        this.setVisible( true );
    }

    public void setQuestionnaire( String text ) {
        this.txtQuestionnaire.setText( text );

        Runnable r = new Runnable() {
            @Override
            public void run() {
                for ( int remaining = 10; remaining >= 0; remaining-- ) {
                    if ( QuestionnaireTerm.this.txtQuestionnaire.getText().equals( text ) ) {
                        QuestionnaireTerm.this.setTitle( "Questionnaire [" + remaining + "]" );
                        try {
                            Thread.sleep( 1000 );
                        } catch ( InterruptedException e ) {
                            e.printStackTrace();
                        }
                    } else {
                        return; // wuerde ich optional sehen, Hauptsache keine
                        // Aktualisierung mehr
                    }
                }

                if ( QuestionnaireTerm.this.txtQuestionnaire.getText().equals( text ) ) {
                    QuestionnaireTerm.this.setTitle( "Questionnaire" );
                    QuestionnaireTerm.this.txtQuestionnaire.setText( "" );
                }

            }
        };
        new Thread( r ).start();
    }

}
