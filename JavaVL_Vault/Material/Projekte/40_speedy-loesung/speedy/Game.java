package de.dhbwka.exam.speedy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.swing.JOptionPane;

public class Game {

	private final Random RND = new Random();
	private int questionCount;
	private List<GameClient> clients = new ArrayList<>();
	private List<Question> selectedQuestions;
	private int round = 0;
	private int time = 0;
	private long start = 0L;
	
	public Game( List<Question> questionPool, int questionCount ) throws GameException {
		this.questionCount = questionCount;
		if (questionPool.size() < questionCount)
			throw new GameException("Too few questions available");
		Set<Question> selectedQuestionsSet = new HashSet<>();
		while (selectedQuestionsSet.size() < questionCount) {
			selectedQuestionsSet.add( questionPool.get( RND.nextInt(questionPool.size() ) ) );
		}
		selectedQuestions = new ArrayList<Question>( selectedQuestionsSet );
	}

	public void registerClient( GameClient gameTerm ) {
		if (! clients.contains( gameTerm ))	
			clients.add( gameTerm );
	}

	public int getQuestionCount() {
		return questionCount;
	}
	
	public void startGame() {
		if (start==0L)
			start=System.currentTimeMillis();
		for (GameClient c : clients) {
			c.setQuestion( round, selectedQuestions.get(round) );
		}
		final int actualRound = round;

		// Nach spätestens 10 Sekunden ist die Runde zu Ende!
		time = 10;
		new Thread( () -> { 
			while (time>0 && actualRound==round) {
				for (GameClient c : clients)
					c.setRemainingSeconds( time );
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) { }
				if (--time<=0) {
					for (GameClient c : clients) 
						c.setAnswerState( round, Status.NO_ANSWER );
					round++;
					nextRound();
				}
			}
		}).start();
	}
	
	public void answerSelected(GameClient client, int answerIndex) {
		Question currentQuestion = selectedQuestions.get(round);
		client.setAnswerState(round, answerIndex == currentQuestion.getCorrectIndex() ? Status.CORRECT : Status.WRONG);
		for (GameClient c : clients) {
			if (c != client)
				c.setAnswerState(round, Status.NO_ANSWER);
		}
		round++;
		nextRound();
	}

	void nextRound() {
		if (round<questionCount)
			startGame();
		else {
			// Spielende
			long duration = (System.currentTimeMillis() - start) / 1000;
			StringBuffer results = new StringBuffer();
			for (GameClient c : clients) {
				c.gameIsOver();
				results.append( c.getPlayerName() + "(" + c.getPoints() + "), " );
			}			
			String resultString = results.substring(0, results.length()-2);
			
			// Sieger mitteilen
			String msg = "Game finished after " + duration + " seconds, score: " + resultString;
			JOptionPane.showMessageDialog(null, msg);
			
			// Ergebnis in highscore schreiben
			try (PrintWriter pw = new PrintWriter( new FileWriter( new File("highscore.txt"), true) ) ) {
				pw.println(msg);
			} catch (IOException e) {
			}
		}		
	}
}
