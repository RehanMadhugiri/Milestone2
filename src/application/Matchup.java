/**
 * Project: Tournament Bracket Project
 * Authors: Rehan Madhugiri, Nick Merfeld, Xianjia Shao, Andy Waldron
 * E-mails: madhugiri@wisc.edu, nmerfeld@wisc.edu, xshao36@wisc.edu, awaldron2@wisc.edu
 * Due: 5/3/2018
 * Files: Milestone3/src/application/Main.java, Milestone3/src/application/Bracket.java,
 *        Milestone3/src/application/Challenger.java, Milestone3/src/application/Matchup.java
 * Other Sources Used: None.
 * Known Bugs:
 */

package application;

import java.util.Random;

import javafx.scene.control.Button;

/**
 * @authors Rehan Madhugiri, Nick Merfeld, Xianjia Shao, Andy Waldron
 * 
 * Matchup class that contains pertinent information on who is play who and gets the contains a
 * method to determine a winner. Matchup objects are also assigned a submit button to help in the
 * JavaFX action event implementation.
 */
public class Matchup {
	
	Challenger c1; // First challenger.
	Challenger c2; // Second challenger.
	Button button; // Submit button.
	
	/**
	 * The constructor method sets the c1 field to the first challenger and the c2 field to the
	 * second challenger. It also sets a button to the button field for the matchup.
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
	public Challenger getWinner() {
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
	
	/**
	 * This method returns the submit button of this particular matchup object.
	 * 
	 * @param No parameters.
	 * @return Nothing returned.
	 */
	public Button getButton(){
		return button;
	}
	
	/**
	 * This method returns the first challenger of the matchup object. Useful for getting
	 * the challenger and changing its name.
	 * 
	 * @param No parameters.
	 * @return First challenger of the matchup.
	 */
	public Challenger getC1() {
		return c1;
	}

	/**
	 * This method returns the second challenger of the matchup object. Useful for getting
	 * the challenger and changing its name.
	 * 
	 * @param No parameters.
	 * @return Second challenger of the matchup.
	 */
	public Challenger getC2() {
		return c2;
	}
	
	/**
	 * This method adds a challenger to the matchup whose initial challenger names are set to "TBD"
	 * by changing "TBD" to whatever the name of the challenger is. In other words, it doesn't
	 * actually add a new object, it just changes the name of the already existing challenger
	 * object whose name is "TBD."
	 * 
	 * @param team The name of the challenger to be added.
	 * @return Nothing returned.
	 */
	public void addChallenger(String team) {
		if(c1.getName().equals("TBD")) c1.setName(team);
		else if(c2.getName().equals("TBD")) c2.setName(team);
	}
	
}
