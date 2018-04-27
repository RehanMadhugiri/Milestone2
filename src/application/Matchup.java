package application;

import java.util.Random;

public class Matchup {
	
	Challenger c1;
	Challenger c2;
	
	public Matchup(Challenger c1, Challenger c2){
		this.c1 = c1;
		this.c2 = c2;
	}
	
	// returns the winner of the game (challenger with greater score)
	// if there is a tie, a winner will be picked randomly
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
}
