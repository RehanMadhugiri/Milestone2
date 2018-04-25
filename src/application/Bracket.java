package application;

import java.util.ArrayList;

public class Bracket {
	
	private Challenger[] challengersAtStart;
	private ArrayList<Challenger> activeChallengers;
	private int numChallengers;
	private ArrayList<Matchup> matchups;
	
	public Bracket(ArrayList<Challenger> challengers) { // Or make constructor a static method and name it to generateBracket as originally planned in Milestone1.
		activeChallengers = challengers;
		challengersAtStart = new Challenger[challengers.size()];
		for(int i=0; i<challengers.size(); i++) {
			challengersAtStart[i] = activeChallengers.get(i);
		}
		numChallengers = challengers.size();
	}
	
	public Challenger[] getAllChallengers() {
		return challengersAtStart;
	}
	
	public ArrayList<Challenger> getActiveChallengers() {
		return activeChallengers;
	}
	
	public void eliminateChallenger(Challenger c) {
		activeChallengers.remove(c);
	}
	
}
