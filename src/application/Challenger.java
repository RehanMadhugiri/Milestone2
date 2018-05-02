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

import javafx.scene.control.Label;

public class Challenger {
	
	private String name;
	private int score;
	private Label label;
	
	public Challenger(String name) {
		this.name = name;
		label = new Label(name);
	}
	
	public int getScore() {
		return score;
	}
	
	public Label getLabel() {
		return label;
	}
	
	public void setScore(int newScore) {
		score = newScore;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public String toString() {
		return name;
	}
}
