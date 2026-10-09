---
tags: ["typ/programmentwurf", "kategorie/pruefung", "thema/operatoren", "thema/kontrollstrukturen", "thema/arrays", "thema/objektorientierung", "thema/klassen", "thema/strings", "thema/vererbung", "thema/exceptions", "thema/io", "thema/swing", "thema/interfaces", "thema/innere-klassen", "thema/events", "thema/datenstrukturen", "thema/enum", "thema/threads", "thema/java8", "thema/programmentwurf"]
art: "Frühere Prüfungsaufgabe"
status: "offen"
bearbeitungszeit: "120 Minuten"
---

# PE SpeedyQuiz

[[Programmentwurf – Übersicht|⬆ Programmentwurf – Übersicht]] · [[Start|🏠 Start]]

**Art:** Frühere Prüfungsaufgabe · **Bearbeitungszeit:** 120 Minuten

> [!abstract] Worum geht's?
> Quiz-Spiel, bei dem ein oder mehrere Spieler gegen die Zeit Fragen beantworten. Sobald die Zeit abläuft oder jemand antwortet, kommt die nächste Frage. Gefordert sind eine Klasse `Question`, das Interface `GameClient`, ein Status-Enum, eine eigene `GameException` und ein Swing-Client (`GameTerm`) mit Countdown.

📄 Aufgabenstellung: [[Material/Projekte/40_Aufgabe_SpeedyQuiz_Download/40_Aufgabe_SpeedyQuiz.pdf|40_Aufgabe_SpeedyQuiz.pdf]]
✅ Musterlösung: [[Material/Aufgaben/40_Aufgabe_SpeedyQuiz_Muster.pdf|40_Aufgabe_SpeedyQuiz_Muster.pdf]]

## Teilaufgaben
- [ ] **a)** Schreiben Sie eine Klasse Question zur Repräsentation einer Frage! Eine Frage besteht aus dem Fragentext (questionText), den vier möglichen Antworten (answers) sowie dem Index der korrekten Antwort (correctIndex, 0-basierte Zählweise).
- [ ] **b)** Um im Falle eines großen Erfolgs des Spiels für Erweiterungen (die dann natürlich kostenpflichtig angeboten werden) gerüstet zu sein, definieren Sie zunächst die allgemeine Schnittstelle, die jeder Client für einen Spieler bedienen muss. Implementieren Sie hierfür ein Java-Interface GameClient, welches folgende Methoden definiert: • public String getPlayerName(): liefert den Namen des Spielers • …
- [ ] **c)** Schreiben Sie eine Klasse Game, welche als Verwaltungsinstanz für ein Spiel dienen soll! Sie verwaltet sowohl den Fragenkatalog, als auch sämtliche angemeldeten Clients und nimmt die Auswahl der Antworten im laufenden Spiel entgegen.
- [ ] **d)** Entwickeln Sie eine Klasse GameTerm, welche eine einfache Nutzeroberfläche für ein SpeedyQuiz-Spiel erzeugt! Die Nutzeroberfläche ist selbstverständlich ein Client und implementiert daher das Interface GameClient und realisiert die Funktionalität der zu implementierenden Methoden gemäß der Beschreibung in Teilaufgabe b).
- [ ] **e)** Ändern Sie die Implementierung der Methode loadQuestions der gegebenen Klasse SpeedyQuiz (siehe Anhänge) so, dass die ebenfalls bereitgestellte Textdatei „questions.txt“ zeilenweise eingelesen wird! Dabei soll jede Zeile mit Hilfe der gegebenen Methode parseQuestion in ein Question-Objekt umgewandelt werden.
- [ ] **f)** Erweitern Sie die Klasse Game dahingehend, dass nach dem Ende des Spiels eine Auswertung stattfindet! Zeigen Sie einen Nachrichten-Dialog, welcher die Dauer des Spiels seit dem Aufruf von startGame in Sekunden, sowie die Namen und zugehörigen Punkte der Spieler anzeigt, bspw: Die Nachricht des Dialogs soll auch in eine Textdatei mit dem Namen „highscore.txt“ geschrieben werden.
- [ ] **g)** Erweitern Sie die Klasse Game um eine weitere Funktionalität! Diese soll beim Start einer Frage einen nebenläufigen Countdown starten, der von bei 10 beginnend sekundenweise herunterzählt.

## Benötigte Begriffe
[[Arithmetische Operatoren]] · [[Bedingungsoperator]] · [[Formatierte Ausgabe]] · [[Zufallszahlen]] · [[Math-Klasse]] · [[while-Schleife]] · [[for-Schleife]] · [[Array]] · [[Mehrdimensionales Array]] · [[Arrays kopieren]] · [[Konstruktor]] · [[this]] · [[static]] · [[toString]] · [[Kapselung]] · [[Vererbung]] · [[Überschreiben]] · [[super]] · [[Interface]] · [[Anonyme innere Klasse]] · [[Enum]] · [[String]] · [[StringBuilder und StringBuffer]] · [[Wrapperklasse]] · [[Exception]] · [[Eigene Exception]] · [[try-with-resources]] · [[Reader und Writer]] · [[BufferedReader und BufferedWriter]] · [[PrintWriter]] · [[Datei und Pfad]] · [[Swing]] · [[JFrame]] · [[JPanel]] · [[Swing-Komponenten]] · [[Layoutmanager]] · [[Look and Feel]] · [[Dialoge]] · [[Farben und Schriften]] · [[Listener]] · [[List]] · [[Set]] · [[Collections-Klasse]] · [[Thread]] · [[Runnable]] · [[Synchronisation]] · [[Timer]] · [[Lambda-Ausdruck]] · [[Programmentwurf]]

## Dafür wiederholen (Themen)
**Schwerpunkte:** [[08 Objektorientierung]] · [[09 Klassen und Objekte]] · [[13 Vererbung]] · [[14 Exceptions]] · [[15 Input und Output]] · [[20 Grafische Oberflächen mit Swing]] · [[21 Abstrakte Klassen und Interfaces]] · [[22 Innere Klassen]] · [[23 Events]] · [[25 Datenstrukturen und Generics]] · [[26 Aufzählungstypen (Enums)]] · [[27 Threads]] · [[33 Java 8 – Lambdas, Streams, NIO.2]]

**Grundlagen:** [[05 Operatoren]] · [[06 Kontrollstrukturen]] · [[07 Arrays]] · [[10 Strings und Wrapperklassen]]

## Dateien
- [40_Aufgabe_SpeedyQuiz.pdf](<Material/Projekte/40_Aufgabe_SpeedyQuiz_Download/40_Aufgabe_SpeedyQuiz.pdf>)
- [SpeedyQuiz.java](<Material/Projekte/40_Aufgabe_SpeedyQuiz_Download/SpeedyQuiz.java>)
- [questions.txt](<Material/Projekte/40_Aufgabe_SpeedyQuiz_Download/questions.txt>)
- [speedy/Game.java (Lösung)](<Material/Projekte/40_speedy-loesung/speedy/Game.java>)
- [speedy/GameClient.java (Lösung)](<Material/Projekte/40_speedy-loesung/speedy/GameClient.java>)
- [speedy/GameException.java (Lösung)](<Material/Projekte/40_speedy-loesung/speedy/GameException.java>)
- [speedy/GameTerm.java (Lösung)](<Material/Projekte/40_speedy-loesung/speedy/GameTerm.java>)
- [speedy/Question.java (Lösung)](<Material/Projekte/40_speedy-loesung/speedy/Question.java>)
- [speedy/QuestionNumberLabel.java (Lösung)](<Material/Projekte/40_speedy-loesung/speedy/QuestionNumberLabel.java>)
- [speedy/SpeedyQuiz.java (Lösung)](<Material/Projekte/40_speedy-loesung/speedy/SpeedyQuiz.java>)
- [speedy/Status.java (Lösung)](<Material/Projekte/40_speedy-loesung/speedy/Status.java>)

## Vorgegebener Code
> [!example]- SpeedyQuiz.java
> ```java
> import java.util.ArrayList;
> import java.util.List;
> 
> import javax.swing.JOptionPane;
> import javax.swing.UIManager;
> 
> /**
>  * Speedy Quiz
>  */
> public class SpeedyQuiz {
> 
>     /**
>      * Main method, entry point of application
>      *
>      * @param args CLI arguments
>      */
>     public static void main(String[] args) {
>         // Set cross platform LAF to get colors for sure to work on MacOS
>         try {
>             UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
>         } catch (Exception e) {
>         }
> 
>         List<Question> questionPool = loadQuestions();
> 
>         try {
>             Game game = new Game(questionPool, 10);
> 
>             game.registerClient( new GameTerm("Mia", game) );
>             game.registerClient( new GameTerm("Ben", game) );
> 
>             game.startGame();
>         } catch (GameException e) {
>             JOptionPane.showMessageDialog(null, e.getMessage(), "Game Error", JOptionPane.ERROR_MESSAGE);
>         }
> 
>     }
> 
>     /**
>      * Load questions
>      *
>      * @return questions to load
>      */
>     public static List<Question> loadQuestions(){
>         List<Question> questions = new ArrayList<>();
> 
>         // replace this code
>         // Generates 15 dummy questions, the first answer is always correct
>         for (int i = 1; i <= 15; i++) {
>             String line = String.format("Generated question %s;Answer 1;Answer 2;Answer 3;Answer 4;0", i);
>             Question q = parseQuestion(line);
>             if ( q != null ){
>                 questions.add(q);
>             }
>         }
>         // end replace this code
> 
>         return questions;
>     }
> 
>     /**
>      * Parse a question from input line
>      *
>      * @param line line to parse
>      * @return created question instance
>      */
>     public static Question parseQuestion( String line ){
>         try {
>             String[] parts = line.split(";");
>                 if ( parts.length == 6 ){
>                 String[] answers = new String[4];
>                 System.arraycopy(parts, 1, answers, 0, 4);
>                 return new Question(parts[0], answers, Integer.parseInt(parts[5]));
>             }
>         } catch (Exception e) {
>         }
>         return null;
>     }
> 
> }
> ```

## Lösung
> [!success]- speedy/Game.java
> ```java
> package de.dhbwka.exam.speedy;
> 
> import java.io.File;
> import java.io.FileWriter;
> import java.io.IOException;
> import java.io.PrintWriter;
> import java.util.ArrayList;
> import java.util.HashSet;
> import java.util.List;
> import java.util.Random;
> import java.util.Set;
> 
> import javax.swing.JOptionPane;
> 
> public class Game {
> 
>     private final Random RND = new Random();
>     private int questionCount;
>     private List<GameClient> clients = new ArrayList<>();
>     private List<Question> selectedQuestions;
>     private int round = 0;
>     private int time = 0;
>     private long start = 0L;
>     
>     public Game( List<Question> questionPool, int questionCount ) throws GameException {
>         this.questionCount = questionCount;
>         if (questionPool.size() < questionCount)
>             throw new GameException("Too few questions available");
>         Set<Question> selectedQuestionsSet = new HashSet<>();
>         while (selectedQuestionsSet.size() < questionCount) {
>             selectedQuestionsSet.add( questionPool.get( RND.nextInt(questionPool.size() ) ) );
>         }
>         selectedQuestions = new ArrayList<Question>( selectedQuestionsSet );
>     }
> 
>     public void registerClient( GameClient gameTerm ) {
>         if (! clients.contains( gameTerm ))    
>             clients.add( gameTerm );
>     }
> 
>     public int getQuestionCount() {
>         return questionCount;
>     }
>     
>     public void startGame() {
>         if (start==0L)
>             start=System.currentTimeMillis();
>         for (GameClient c : clients) {
>             c.setQuestion( round, selectedQuestions.get(round) );
>         }
>         final int actualRound = round;
> 
>         // Nach sptestens 10 Sekunden ist die Runde zu Ende!
>         time = 10;
>         new Thread( () -> { 
>             while (time>0 && actualRound==round) {
>                 for (GameClient c : clients)
>                     c.setRemainingSeconds( time );
>                 try {
>                     Thread.sleep(1000);
>                 } catch (InterruptedException e) { }
>                 if (--time<=0) {
>                     for (GameClient c : clients) 
>                         c.setAnswerState( round, Status.NO_ANSWER );
>                     round++;
>                     nextRound();
>                 }
>             }
>         }).start();
>     }
>     
>     public void answerSelected(GameClient client, int answerIndex) {
>         Question currentQuestion = selectedQuestions.get(round);
>         client.setAnswerState(round, answerIndex == currentQuestion.getCorrectIndex() ? Status.CORRECT : Status.WRONG);
>         for (GameClient c : clients) {
>             if (c != client)
>                 c.setAnswerState(round, Status.NO_ANSWER);
>         }
>         round++;
>         nextRound();
>     }
> 
>     void nextRound() {
>         if (round<questionCount)
>             startGame();
>         else {
>             // Spielende
>             long duration = (System.currentTimeMillis() - start) / 1000;
>             StringBuffer results = new StringBuffer();
>             for (GameClient c : clients) {
>                 c.gameIsOver();
>                 results.append( c.getPlayerName() + "(" + c.getPoints() + "), " );
>             }            
>             String resultString = results.substring(0, results.length()-2);
>             
>             // Sieger mitteilen
>             String msg = "Game finished after " + duration + " seconds, score: " + resultString;
>             JOptionPane.showMessageDialog(null, msg);
>             
>             // Ergebnis in highscore schreiben
>             try (PrintWriter pw = new PrintWriter( new FileWriter( new File("highscore.txt"), true) ) ) {
>                 pw.println(msg);
>             } catch (IOException e) {
>             }
>         }        
>     }
> }
> ```

> [!success]- speedy/GameClient.java
> ```java
> package de.dhbwka.exam.speedy;
> 
> public interface GameClient {
>     
>     public String getPlayerName();
>     
>     public int getPoints();
>         
>     public void setQuestion( int questionIndex, Question q );
>     
>     public void setRemainingSeconds( int seconds );
>     
>     public void gameIsOver();
>     
>     public void setAnswerState( int questionIndex, Status status );
>     
> 
> }
> ```

> [!success]- speedy/GameException.java
> ```java
> package de.dhbwka.exam.speedy;
> 
> @SuppressWarnings("serial")
> public class GameException extends Exception {
> 
>     public GameException() {
>         super();
>     }
> 
>     public GameException( String msg ) {
>         super( msg );
>     }
>     
> }
> ```

> [!success]- speedy/GameTerm.java
> ```java
> package de.dhbwka.exam.speedy;
> 
> import java.awt.BorderLayout;
> import java.awt.GridLayout;
> import java.awt.event.ActionEvent;
> import java.awt.event.ActionListener;
> import java.util.ArrayList;
> import java.util.List;
> 
> import javax.swing.JButton;
> import javax.swing.JFrame;
> import javax.swing.JLabel;
> import javax.swing.JPanel;
> 
> public class GameTerm implements GameClient {
> 
>     private Game game;
>     private String name;
>     private List<QuestionNumberLabel> labels = new ArrayList<>();
>     private List<JButton> answers = new ArrayList<>();
>     private JLabel questionLbl = new JLabel( "", JLabel.CENTER );
>     private JLabel secondsLbl = new JLabel( "", JLabel.CENTER );
>     private JFrame frame = new JFrame();
>     private JPanel labelPanel = new JPanel();
>     private JPanel questionPanel = new JPanel();
>     private JPanel answerPanel = new JPanel();
>     
>     public GameTerm( String name, Game game ) {
>         this.name = name;
>         this.game = game;
>         this.game.registerClient( this );
>         
>         frame.setTitle( name );
>         
>         labelPanel.setLayout( new GridLayout(1, game.getQuestionCount(), 0, 5));
>         questionPanel.setLayout( new GridLayout(2, 1, 0, 5));
>         answerPanel.setLayout( new GridLayout(2, 2, 5, 5));
>         
>         for(int i=0; i<game.getQuestionCount(); i++) {
>             QuestionNumberLabel qnl = new QuestionNumberLabel( "" + i );
>             labels.add( qnl );
>             labelPanel.add( qnl );
>         }
> 
>         questionPanel.add( questionLbl );
>         questionPanel.add( secondsLbl );
>         
>         for (int i=0; i<4; i++) {
>             JButton but = new JButton();
>             but.setActionCommand( String.valueOf( i ) );
>             but.addActionListener( new ActionListener() {    
>                 @Override
>                 public void actionPerformed(ActionEvent e) {
>                     GameTerm.this.game.answerSelected( GameTerm.this, Integer.parseInt( e.getActionCommand() ) );
>                 }
>             });
>             answers.add( but );
>             answerPanel.add( but );
>         }
>         
>         frame.add( labelPanel, BorderLayout.NORTH );
>         frame.add( questionPanel, BorderLayout.CENTER );
>         frame.add( answerPanel, BorderLayout.SOUTH );
>         frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
>         frame.setSize( 600, 150 );
>         frame.setVisible( true );
>     }
> 
>     @Override
>     public String getPlayerName() {
>         return name;
>     }
> 
>     @Override
>     public int getPoints() {
>         int points = 0;
>         for (QuestionNumberLabel qnl : labels) {
>             points += qnl.getPoints();
>         }
>         return points>0 ? points : 0;
>     }
> 
>     @Override
>     public void setQuestion(int questionIndex, Question q) {
>         questionLbl.setText(q.getQuestionText());
>         for (int i=0; i<q.getAnswers().length; i++) {
>             answers.get(i).setText( q.getAnswers()[i] );
>         }
>     }
> 
>     @Override
>     public void setRemainingSeconds(int seconds) {
>         secondsLbl.setText( "" + seconds );
>     }
> 
>     @Override
>     public void gameIsOver() {
>         for(JButton but : answers) 
>             but.setEnabled( false );
>     }
> 
>     @Override
>     public void setAnswerState(int questionIndex, Status status) {
>         labels.get( questionIndex ).setStatus( status );
>     }
> 
> }
> ```

> [!success]- speedy/Question.java
> ```java
> package de.dhbwka.exam.speedy;
> 
> public class Question {
> 
>     private String questionText;
>     private String[] answers;
>     private int correctIndex;
>     
>     public Question( String questionText, String[] answers, int correctIndex ) {
>         this.questionText = questionText;
>         this.answers = answers;
>         this.correctIndex = correctIndex;
>     }
> 
>     public String getQuestionText() {
>         return questionText;
>     }
> 
>     public void setQuestionText(String questionText) {
>         this.questionText = questionText;
>     }
> 
>     public String[] getAnswers() {
>         return answers;
>     }
> 
>     public void setAnswers(String[] answers) {
>         this.answers = answers;
>     }
> 
>     public int getCorrectIndex() {
>         return correctIndex;
>     }
> 
>     public void setCorrectIndex(int correctIndex) {
>         this.correctIndex = correctIndex;
>     }
> 
> }
> ```

> [!success]- speedy/QuestionNumberLabel.java
> ```java
> package de.dhbwka.exam.speedy;
> 
> import javax.swing.JLabel;
> 
> @SuppressWarnings("serial")
> public class QuestionNumberLabel extends JLabel {
> 
>     private Status status;
> 
>     public QuestionNumberLabel( String text ) {
>         super( text );
>         this.setOpaque( true );
>         this.setHorizontalAlignment( JLabel.CENTER );
>     }
> 
>     public int getPoints() {
>         return status.getPoints();
>     } 
> 
>     public void setStatus( Status status ) {
>         this.status = status;
>         this.setBackground( status.getColor() );
>     } 
>     
> }
> ```

> [!success]- speedy/SpeedyQuiz.java
> ```java
> package de.dhbwka.exam.speedy;
> 
> import java.io.BufferedReader;
> import java.io.File;
> import java.io.FileReader;
> import java.io.IOException;
> import java.nio.charset.Charset;
> import java.util.ArrayList;
> import java.util.List;
> 
> import javax.swing.JOptionPane;
> import javax.swing.UIManager;
> 
> /**
>  * Speedy Quiz
>  */
> public class SpeedyQuiz {
> 
>     /**
>      * Main method, entry point of application
>      *
>      * @param args CLI arguments
>      */
>     public static void main(String[] args) {
>         // Set cross platform LAF to get colors for sure to work on MacOS
>         try {
>             UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
>         } catch (Exception e) {
>         }
> 
>         List<Question> questionPool = loadQuestions();
> 
>         try {
>             Game game = new Game(questionPool, 10);
> 
>             game.registerClient( new GameTerm("Mia", game) );
>             game.registerClient( new GameTerm("Ben", game) );
> 
>             game.startGame();
>         } catch (GameException e) {
>             JOptionPane.showMessageDialog(null, e.getMessage(), "Game Error", JOptionPane.ERROR_MESSAGE);
>         }
> 
>     }
> 
>     /**
>      * Load questions
>      *
>      * @return questions to load
>      */
>     public static List<Question> loadQuestions(){
>         List<Question> questions = new ArrayList<>();
> 
>         try (BufferedReader br = new BufferedReader(new FileReader( new File("questions.txt"), Charset.forName("UTF-8")))) {
>             while (br.ready()) {
>                 Question q = parseQuestion(br.readLine());
>                 if (q!=null)
>                     questions.add(q);
>             }
>         } catch (IOException e) {
>             JOptionPane.showMessageDialog(null, e.getMessage());
>         }
>         
>         // replace this code
> //        // Generates 15 dummy questions, the first answer is always correct
> //        for (int i = 1; i <= 15; i++) {
> //            String line = String.format("Generated question %s;Answer 1;Answer 2;Answer 3;Answer 4;0", i);
> //            Question q = parseQuestion(line);
> //            if ( q != null ){
> //                questions.add(q);
> //            }
> //        }
> //        // end replace this code
> 
>         return questions;
>     }
> 
>     /**
>      * Parse a question from input line
>      *
>      * @param line line to parse
>      * @return created question instance
>      */
>     public static Question parseQuestion( String line ){
>         try {
>             String[] parts = line.split(";");
>                 if ( parts.length == 6 ){
>                 String[] answers = new String[4];
>                 System.arraycopy(parts, 1, answers, 0, 4);
>                 return new Question(parts[0], answers, Integer.parseInt(parts[5]));
>             }
>         } catch (Exception e) {
>         }
>         return null;
>     }
> 
> }
> ```

> [!success]- speedy/Status.java
> ```java
> package de.dhbwka.exam.speedy;
> 
> import java.awt.Color;
> 
> public enum Status {
>     
>     ACTIVE(Color.ORANGE, 0),
>     CORRECT(Color.GREEN, 1),
>     WRONG(Color.RED, -1),
>     PENDING(Color.WHITE, 0),
>     NO_ANSWER(Color.GRAY, 0);
>     
>     private Color color;
>     private int points;
>     
>     private Status( Color color, int points ) {
>         this.color = color;
>         this.points = points;
>     }
> 
>     public Color getColor() {
>         return color;
>     }
> 
>     public int getPoints() {
>         return points;
>     }
> 
> }
> ```

## Aufgabenstellung ansehen
![[Material/Projekte/40_Aufgabe_SpeedyQuiz_Download/40_Aufgabe_SpeedyQuiz.pdf]]

## Aufgabentext (durchsuchbar)
> [!quote]- Kompletter Aufgabentext – aufklappen
> ```text
> W. Süß, J. Sidler, T. Schlachter, N. Doms, C. Schmitt
> 
> Bereich: 1. + 2. Semester
> 
> SpeedyQuiz
> Package: de.dhbwka.java.exercise.speedy
> 
> Aufgabenstellung:
> Schreiben Sie eine Java-Anwendung „SpeedyQuiz“, die es einem Spieler ermöglicht allein zu
> „quizzen“ oder gegen andere anzutreten!
> Für jede Frage steht dabei nur ein kurzer Antwortzeitraum zur Verfügung. Ist die Zeit abgelaufen oder
> gibt ein Spieler eine Antwort, ist die aktuelle Fragerunde für alle Spieler beendet und die nächste
> Frage erscheint direkt im Anschluss.
> 
> Teilaufgabe a)
> Schreiben Sie eine Klasse Question zur Repräsentation einer Frage! Eine Frage besteht aus dem
> Fragentext (questionText), den vier möglichen Antworten (answers) sowie dem Index der
> korrekten Antwort (correctIndex, 0-basierte Zählweise). Wählen Sie jeweils geeignete
> Datentypen!
> Definieren Sie auch einen Konstruktor, dessen Struktur durch die bereitgestellte Klasse
> SpeedyQuiz (siehe Anhänge) bereits vorgegeben ist!
> 
> Teilaufgabe b)
> Um im Falle eines großen Erfolgs des Spiels für Erweiterungen (die dann natürlich kostenpflichtig
> angeboten werden) gerüstet zu sein, definieren Sie zunächst die allgemeine Schnittstelle, die jeder
> Client für einen Spieler bedienen muss. Implementieren Sie hierfür ein Java-Interface GameClient,
> welches folgende Methoden definiert:
> 
>     •   public String getPlayerName(): liefert den Namen des Spielers
>     •   public int getPoints(): liefert die Anzahl der Punkte (jede richtige Antwort zählt 1
>         Punkt, für jede falsche Antwort wird ein Punkt abgezogen. Wäre die Gesamtpunktzahl
>         negativ ist 0 zurückzugeben)
>     •   public void setQuestion(int questionIndex, Question q): übergibt dem
>         Client den 0-basierten Index der Frage (in der Liste der für das Spiel ausgewählten Fragen),
>         sowie die Fragen-Instanz. Beim Aufruf soll jeder Client implizit für die Frage in den Zustand
>         ACTIVE (siehe Tabelle unten) übergehen.
> 
> SpeedyQuiz                                                                                          1/5
> W. Süß, J. Sidler, T. Schlachter, N. Doms, C. Schmitt
> 
>     •   public void setRemainingSeconds(int seconds): teilt dem Client die Anzahl der
>         verbleibenden Sekunden für die aktuelle Frage mit.
>     •   public void gameIsOver(): teilt dem Client mit, dass die letzte Frage gespielt und das
>         Spiel zu Ende ist
>     •   public void setAnswerState(int questionIndex, Status status): teilt dem
>         Client mit, welchen Zustand er für die Frage mit dem gegeben, 0-basierten Index annehmen
>         soll.
> Der Zustand soll in Form eines komplexen Aufzählungstyps (Status) realisiert werden und neben
> dem Zustand auch die Farbcodierung sowie die zu verrechnenden Punkte für diesen Zustand
> festlegen:
>  Zustand         Farbe                Punkte     Bedeutung
>  ACTIVE          Color.ORANGE            0       aktuell gestellte Frage
>  CORRECT         Color.GREEN            +1       richtig beantwortete Frage
>  WRONG           Color.RED              -1       falsch beantwortete Frage
>  PENDING         Color.WHITE             0       noch nicht gespielte/ausstehende Frage
>  NO_ANSWER       Color.GRAY              0       Frage auf die ein anderer Spieler geantwortet hat
> Sollte eine Implementierung des Interface GameClient eine Benutzeroberfläche bereitstellen
> (bspw. GameTerm, vgl. Teilaufgabe d)), ist diese selbstverständlich bei jeder der o.g. Methoden-
> Implementierungen entsprechend zu aktualisieren (bspw. auf der UI sichtbarer Fragentext,
> Antworten, etc. bei setQuestion).
> 
> Teilaufgabe c)
> Schreiben Sie eine Klasse Game, welche als Verwaltungsinstanz für ein Spiel dienen soll! Sie verwaltet
> sowohl den Fragenkatalog, als auch sämtliche angemeldeten Clients und nimmt die Auswahl der
> Antworten im laufenden Spiel entgegen.
> Zur Initialisierung soll ein Konstuktor, welcher die Liste möglicher Fragen sowie die Anzahl der Fragen
> für dieses Spiel entgegen nimmt (vgl. Verwendung in bereitgestellter Klasse SpeedyQuiz, siehe
> Anhänge).
> 
> Der Konstruktor soll aus dem bereitgestellten Fragenpool zufällig die übergebene Anzahl an Fragen
> auswählen und für das Spiel speichern. Duplikate sind zu vermeiden.
> Sollte die Menge der Fragen nicht ausreichen für die übergebene Anzahl, soll eine sprechende
> GameException geworfen werden, der die Nachricht „Too few questions available“
> übergeben wird.
> Für den weiteren Verlauf des Spiels sollen zum Konstruktor noch (mind.) folgende Methoden
> implementiert werden:
>      • public void registerClient(GameClient client): Anmelden eines Clients für das Spiel.
>          Der Client soll nur aufgenommen werden wenn das Spiel noch nicht gestartet wurde.
>      • public int getQuestionsCount(): Liefert Anzahl der Fragen dieses Spiels.
>      • public void startGame(): Startet das Spiel für alle angemeldeten Clients (wird aufgerufen
>          innerhalb der bereitgestellten Klasse SpeedyQuiz, siehe Anhänge). Der Aufruf soll allen
>          Clients die erste Frage übermitteln.
> 
> SpeedyQuiz                                                                                         2/5
> W. Süß, J. Sidler, T. Schlachter, N. Doms, C. Schmitt
> 
>     •   public void answerSelected(GameClient client, int index): Teilt der Spielinstanz
>         mit, dass in einem Client die Antwort mit dem gegebenen Index (0-basierte Zählweise)
>         ausgewählt wurde. Beim Auswählen einer Antwort soll allen Clients ein Zustandsupdate für
>         die aktuelle Frage mitgeteilt werden, d.h.:
>         ▪ Der Client, welcher die Antwort ausgewählt hat bekommt bei richtiger Antwort den
>             Zustand Status.CORRECT, andernfalls Status.WRONG.
>          ▪ Alle anderen Clients bekommen für diese Frage den Zustand Status.NO_ANSWER.
> Im Anschluss an das Zustandsupdate soll direkt die nächste Frage gestellt (d.h. an alle Clients verteilt)
> werden.
> Ist keine weitere Frage mehr vorhanden, ist sämtlichen Clients das Ende des Spiels mitzuteilen.
> Hinweis: diese Funktionalität wird in den Teilaufgaben f) und g) erweitert
> Teilaufgabe d)
> Entwickeln Sie eine Klasse GameTerm, welche eine einfache Nutzeroberfläche für ein
> SpeedyQuiz-Spiel erzeugt! Die Nutzeroberfläche ist selbstverständlich ein Client und
> implementiert daher das Interface GameClient und realisiert die Funktionalität der zu
> implementierenden Methoden gemäß der Beschreibung in Teilaufgabe b).
> Dem Konstruktor von GameTerm sollen als Parameter der Name des Spielers sowie eine Game-
> Instanz übergeben werden (vgl. gegebene Klasse SpeedyQuiz, siehe Anhänge).
> 
> GameTerm soll ein neues Fenster mit sinnvoll gewählter Größe öffnen. Der Fenstertitel ist auf den
> übergebenen Namen des Spielers zu setzen.
> Im oberen Teil soll für jede Frage des übergebenen Spiels ein Label die Anzeige des Fragenzustands
> (vgl. Teilaufgabe a)) für den aktuellen Spieler eingefügt werden.
> Schreiben Sie hierfür eine Klasse QuestionNumberLabel, welche von JLabel erbt und ein
> weiteres Attribut für den Zustand der Frage enthält! Wird dieser Zustand aktualisiert soll sich die
> Hintergrundfarbe entsprechend auf die Farbe des Status-Objekts anpassen. Initial ist jedes
> QuestionNumberLabel im Zustand Status.PENDING und sein Hintergrund somit weiß.
> Hinweis: Damit der Hintergrund des QuestionNumberLabels angezeigt wird, rufen Sie in dessen
> Kontruktor this.setOpaque(true) auf. Die zentrierte Darstellung innerhalb eines JLabel erreicht
> man durch Aufruf von this.setHorizontalAlignment(JLabel.CENTER)
> Unterhalb der Labels für die Zustände der Fragen soll der eigentliche Fragentext angezeigt werden.
> Direkt darunter dann die verbleibende Zeit in Sekunden (setzten Sie diese zunächst auf 10). Am
> unteren Rand sind die Buttons für die vier Antwortmöglichkeiten als 2x2-Matrix hinzuzufügen.
> Erweitern Sie die Buttons für die Antworten von GameTerm nun so, dass bei Auswahl eines Antwort-
> Buttons der zugehörige Antwort-Index an die Game-Instanz (mit dem aktuellen GameTerm als
> übermittelnden GameClient) gesendet wird!
> Ist das Spiel zu Ende (Aufruf von gameIsOver()) sind alle Buttons zu deaktivieren.
> 
> SpeedyQuiz                                                                                           3/5
> W. Süß, J. Sidler, T. Schlachter, N. Doms, C. Schmitt
> 
> Teilaufgabe e)
> Ändern Sie die Implementierung der Methode loadQuestions der gegebenen Klasse
> SpeedyQuiz (siehe Anhänge) so, dass die ebenfalls bereitgestellte Textdatei „questions.txt“
> zeilenweise eingelesen wird! Dabei soll jede Zeile mit Hilfe der gegebenen Methode
> parseQuestion in ein Question-Objekt umgewandelt werden.
> Die so eingelesenen Fragen aus der Datei sollen dann anstatt der bisherigen generierten Fragen
> zurückgeliefert werden.
> Zeigen Sie im Falle eines Fehlers die Message der Exception als Nachricht in einer Error-Dialogbox
> (achten Sie auf das Icon!) mit dem Titel „Error loading questions“ an (im Beispiel fehlen die Lese-
> Rechte für die Datei):
> 
> Teilaufgabe f)
> Erweitern Sie die Klasse Game dahingehend, dass nach dem Ende des Spiels eine Auswertung
> stattfindet! Zeigen Sie einen Nachrichten-Dialog, welcher die Dauer des Spiels seit dem Aufruf von
> startGame in Sekunden, sowie die Namen und zugehörigen Punkte der Spieler anzeigt, bspw:
> 
> Die Nachricht des Dialogs soll auch in eine Textdatei mit dem Namen „highscore.txt“
> geschrieben werden. Sofern die Datei bereits existiert soll die Nachricht in einer neuen Zeile
> angehängt werden.
> 
> Teilaufgabe g)
> Erweitern Sie die Klasse Game um eine weitere Funktionalität! Diese soll beim Start einer Frage einen
> nebenläufigen Countdown starten, der von bei 10 beginnend sekundenweise herunterzählt. Jede
> Sekunde ist allen registrierten GameClient-Instanzen die verbleibende Zeit mit Hilfe der
> setRemainingSeconds-Methode mitzuteilen.
> Die Nebenläufigkeit endet,
>     ▪ wenn der Countdown bei 0 angekommen ist (dann ist sämtlichen Clients für die aktuelle
>         Frage der Zustand Status.NO_ANSWER zu geben und die nächste Frage zu starten)
>     ▪ oder einer der Spieler eine Antwort gibt
> Hinweis: Zur Vereinfachung ist keine Synchronisierung zur Vermeidung von Kollisionen bei quasi-zeitgleichem
> Countdown-Ablauf und Antwort-Abgabe vorzunehmen
> 
> SpeedyQuiz                                                                                              4/5
> W. Süß, J. Sidler, T. Schlachter, N. Doms, C. Schmitt
> 
> Allgemeine Hinweise
> Starten
> Starten Sie die Anwendung mit der gegebenen Klasse SpeedyQuiz (siehe Anhänge).
> 
> Schließen eines Fensters
> Beim Schließen eines Fensters soll die komplette Anwendung beendet werden.
> 
> Sichtbarkeit von Instanz-Attributen
> Sämtliche Instanz-Attribute sind privat zu definieren und ggf. mittels Getter- und/oder Setter-
> Methoden von außerhalb der Klasse zu verwenden.
> 
> Farben bei MacOS
> Um Probleme mit (Hintergrund-)Farben beim Java Standard Look-And-Feel unter MacOS zu
> vermeiden erzwingt die main-Methode der o.g. Klasse SpeedyQuiz die Verwendung des Cross-
> Platform Look-And-Feels. Auf Windows- und Linux-Systemen wäre dies nicht notwendig (ist jedoch
> auch kein Problem).
> 
> Anhänge:
> • SpeedyQuiz.java
> • questions.txt
> 
> SpeedyQuiz                                                                                        5/5
> ```

## Meine Notizen

