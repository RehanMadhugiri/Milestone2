package application;

import java.util.ArrayList;

public class Bracket {
	
	private Challenger[] challengersAtStart;
	private ArrayList<Challenger> activeChallengers;
	private int numChallengers;
	private ArrayList<Matchup> matchups = new ArrayList<Matchup>();
	
	public Bracket(ArrayList<Challenger> challengers) { // Or make constructor a static method and name it to generateBracket as originally planned in Milestone1.
		activeChallengers = challengerSorter(challengers);
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
	
	public ArrayList<Matchup> getMatchups() {
		return matchups;
	}
	
	public ArrayList<Challenger> challengerSorter(ArrayList<Challenger> challengerList) {
		ArrayList<Challenger> mergingArray = new ArrayList<Challenger>();
		if(challengerList.size() == 2) {
			return challengerList;
		} else {
			ArrayList<Challenger> half1 = new ArrayList<Challenger>();
			ArrayList<Challenger> half2 = new ArrayList<Challenger>();
			int incrementCount1 = 0;
			int incrementCount2 = 1;
			for(int i=0; i<challengerList.size(); i+=3) {
				half1.add(challengerList.get(i));
				if(incrementCount1 == 1) {
					if(i != challengerList.size() - 1) {
						half1.add(challengerList.get(i+1));
						i++;
					}
				} else {
					incrementCount1++;
				}
			}
			for(int i=1; i<challengerList.size(); i+=3) {
				half2.add(challengerList.get(i));
				if(incrementCount2 == 1) {
					if(i != challengerList.size() - 1) {
						half2.add(challengerList.get(i+1));
						i++;
					}
				} else {
					incrementCount2++;
				}
			}
			ArrayList<Challenger> subArray1 = challengerSorter(half1);
			for(int i=0; i<subArray1.size(); i++) {
				mergingArray.add(subArray1.get(i));
			}
			ArrayList<Challenger> subArray2 = challengerSorter(half2);
			for(int i=0; i<subArray2.size(); i++) {
				mergingArray.add(subArray2.get(i));
			}
			return mergingArray;
		}
	}
	
}
