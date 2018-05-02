/**
 * Project: Tournament Bracket Project
 * Authors: Rehan Madhugiri, Nick Merfeld, Xianjia Shao, Andy Waldron
 * E-mail: awaldron2@wisc.edu
 * Due: 5/3/2018
 * Files: Milestone3/src/application/Main.java, Milestone3/src/application/Bracket.java,
 *        Milestone3/src/application/Challenger.java, Milestone3/src/application/Matchup.java
 * Other Sources Used: None.
 * Known Bugs:
 */

package application;

import java.util.Random;

import javafx.scene.control.Button;

public class Matchup {
	
	Challenger c1; // First challenger.
	Challenger c2; // Second challenger.
	Button button;
	
	/**
	 * The constructor method sets the c1 field to the first challenger and the c2 field to the
	 * second challenger.
	 * 
	 * @param c1 First challenger.
	 * @param c2 Second challenger.
	 * @return Nothing returned.
	 */
	public Matchup(Challenger c1, Challenger c2, Button button){
		this.c1 = c1;
		this.c2 = c2;
		this.button = button;
	}
	
	/**
	 * This method returns the challenger with the greater score. If the scores are equal, the
	 * winner is chosen randomly.
	 * 
	 * @param c1 First challenger.
	 * @param c2 Second challenger.
	 * @return The challenger with the greater score.
	 */
	public Challenger getWinner(Challenger c1, Challenger c2) {
		// Tie 
		if(c1.getScore() == c2.getScore()){
			Random random = new Random(2);
			int result = random.nextInt();
			if(result == 0) return c1;
			else return c2;
		}
		
		// c1's score is greater
		if(c1.getScore() > c2.getScore()){
			return c1;
		}
		
		// c2's score is greater
		return c2;
	}
	
	public Button getButton(){
		return button;
	}
}
