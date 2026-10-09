package de.dhbwka.exam.speedy;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameTerm implements GameClient {

	private Game game;
	private String name;
	private List<QuestionNumberLabel> labels = new ArrayList<>();
	private List<JButton> answers = new ArrayList<>();
	private JLabel questionLbl = new JLabel( "", JLabel.CENTER );
	private JLabel secondsLbl = new JLabel( "", JLabel.CENTER );
	private JFrame frame = new JFrame();
	private JPanel labelPanel = new JPanel();
	private JPanel questionPanel = new JPanel();
	private JPanel answerPanel = new JPanel();
	
	public GameTerm( String name, Game game ) {
		this.name = name;
		this.game = game;
		this.game.registerClient( this );
		
		frame.setTitle( name );
		
		labelPanel.setLayout( new GridLayout(1, game.getQuestionCount(), 0, 5));
		questionPanel.setLayout( new GridLayout(2, 1, 0, 5));
		answerPanel.setLayout( new GridLayout(2, 2, 5, 5));
		
		for(int i=0; i<game.getQuestionCount(); i++) {
			QuestionNumberLabel qnl = new QuestionNumberLabel( "" + i );
			labels.add( qnl );
			labelPanel.add( qnl );
		}

		questionPanel.add( questionLbl );
		questionPanel.add( secondsLbl );
		
		for (int i=0; i<4; i++) {
			JButton but = new JButton();
			but.setActionCommand( String.valueOf( i ) );
			but.addActionListener( new ActionListener() {	
				@Override
				public void actionPerformed(ActionEvent e) {
					GameTerm.this.game.answerSelected( GameTerm.this, Integer.parseInt( e.getActionCommand() ) );
				}
			});
			answers.add( but );
			answerPanel.add( but );
		}
		
		frame.add( labelPanel, BorderLayout.NORTH );
		frame.add( questionPanel, BorderLayout.CENTER );
		frame.add( answerPanel, BorderLayout.SOUTH );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setSize( 600, 150 );
		frame.setVisible( true );
	}

	@Override
	public String getPlayerName() {
		return name;
	}

	@Override
	public int getPoints() {
		int points = 0;
		for (QuestionNumberLabel qnl : labels) {
			points += qnl.getPoints();
		}
		return points>0 ? points : 0;
	}

	@Override
	public void setQuestion(int questionIndex, Question q) {
		questionLbl.setText(q.getQuestionText());
		for (int i=0; i<q.getAnswers().length; i++) {
			answers.get(i).setText( q.getAnswers()[i] );
		}
	}

	@Override
	public void setRemainingSeconds(int seconds) {
		secondsLbl.setText( "" + seconds );
	}

	@Override
	public void gameIsOver() {
		for(JButton but : answers) 
			but.setEnabled( false );
	}

	@Override
	public void setAnswerState(int questionIndex, Status status) {
		labels.get( questionIndex ).setStatus( status );
	}

}
