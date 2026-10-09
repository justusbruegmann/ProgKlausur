package de.dhbwka.exam.speedy;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class QuestionNumberLabel extends JLabel {

	private Status status;

	public QuestionNumberLabel( String text ) {
		super( text );
		this.setOpaque( true );
		this.setHorizontalAlignment( JLabel.CENTER );
	}

	public int getPoints() {
		return status.getPoints();
	} 

	public void setStatus( Status status ) {
		this.status = status;
		this.setBackground( status.getColor() );
	} 
	
}
