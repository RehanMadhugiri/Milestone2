/**
 * Project: Tournament Bracket Project
 * Authors: Rehan Madhugiri, Nick Merfeld, Xianjia Shao, Andy Waldron
 * E-mail: madhugiri@wisc.edu, nmerfeld@wisc.edu, xshao36@wisc.edu, awaldron2@wisc.edu
 * Due: 5/3/2018
 * Files: Milestone3/src/application/Main.java, Milestone3/src/application/Bracket.java,
 *        Milestone3/src/application/Challenger.java, Milestone3/src/application/Matchup.java
 * Other Sources Used: None.
 * Known Bugs:
 */

package application;

import java.util.ArrayList;

public class Bracket {
	
	private Challenger[] challengersAtStart;
	private ArrayList<Challenger> activeChallengers;
	private int numChallengers;
	private ArrayList<ArrayList<Matchup>> matchups = new ArrayList<ArrayList<Matchup>>();
	
	public Bracket(ArrayList<Challenger> challengers) {
		activeChallengers = challengerSorter(challengers);
		challengersAtStart = new Challenger[challengers.size()];
		for(int i=0; i<challengers.size(); i++) {
			challengersAtStart[i] = activeChallengers.get(i);
		}
		numChallengers = challengers.size();
	}
	
	/**
	 * This method returns all challengers present at the beginning of the tournament.
	 * 
	 * @param No parameters.
	 * @return An array of challengers at the beginning of the tournament.
	 */
	public Challenger[] getAllChallengers() {
		return challengersAtStart;
	}
	
	/**
	 * This method returns the active challengers still alive in the tournament.
	 * 
	 * @param No parameters.
	 * @return The ArrayList of challengers still in the tournament.
	 */
	public ArrayList<Challenger> getActiveChallengers() {
		return activeChallengers;
	}
	
//	public void eliminateChallenger(Challenger c) {
//		activeChallengers.remove(c);
//	}
	
	public ArrayList<ArrayList<Matchup>> getMatchups() {
		return matchups;
	}
	
	public Challenger getThirdPlace() {
		int numRounds = (int) (Math.log(numChallengers) / Math.log(2));
		ArrayList<Matchup> semifinalRound = matchups.get(numRounds-2);
		Matchup m1 = semifinalRound.get(0);
		Matchup m2 = semifinalRound.get(1);
		Challenger team1 = null;
		Challenger team2 = null;
		System.out.println(m1.getC1().getLoss());
		System.out.println(m1.getC2().getLoss());
		System.out.println(m2.getC1().getLoss());
		System.out.println(m2.getC2().getLoss());
		if(m1.getC1().getLoss() == numRounds-1) {
			team1 = m1.getC1();
		}
		else if(m1.getC2().getLoss() == numRounds-1) {
			team1 = m1.getC2();
		}
		
		if(m2.getC1().getLoss() == numRounds-1) {
			team2 = m2.getC1();
		}
		if(m2.getC2().getLoss() == numRounds-1) {
			team2 = m2.getC2();
		}
		return m1.getWinner(team1, team2);
	}
	
	
	/**
	 * This method takes the ArrayList of challengers and sorts them in the order of where they
	 * would appear on the bracket. For example, in a sixteen team bracket the order would be 1,
	 * 16, 8, 9, 4, 13, and so on down the bracket. The method takes the ArrayList which is already
	 * in numerical order and breaks the ArrayList in half. The first half starts at the first
	 * element, skips over two elements to the fourth element, goes to the fifth element, skips
	 * over two elements to the eighth element, goes to the ninth element and so on. The same thing
	 * is done for the second half except it starts at the second element, goes to the third
	 * element, and then skips two elements to get to the sixth element. This process is done
	 * recursively on smaller and smaller halves until the ArrayLists are of size two, in which the
	 * two elements are the correct opponents of each other. While going back up the recursion,
	 * the ArrayLists are added together to make a single complete ArrayList with the teams in
	 * "bracket" order.
	 * 
	 * @param challengerList ArrayList of challengers to be sorted. Challenger list must be in
	 * numerical order.
	 * @return An ArrayList with the challengers sorted in "bracket" order.
	 */
	public ArrayList<Challenger> challengerSorter(ArrayList<Challenger> challengerList) {
		ArrayList<Challenger> mergingArray = new ArrayList<Challenger>();
		if(challengerList.size() == 2) {
			return challengerList;
		} else {
			ArrayList<Challenger> half1 = new ArrayList<Challenger>();
			ArrayList<Challenger> half2 = new ArrayList<Challenger>();
			int incrementCount1 = 0;
			int incrementCount2 = 1;
			for(int i=0; i<challengerList.size(); i+=3) { // First half: If number of teams = 16, half1
				half1.add(challengerList.get(i));         // would contain 1,4,5,8,9,12,13,16.
				if(incrementCount1 == 1) {
					if(i != challengerList.size() - 1) {
						half1.add(challengerList.get(i+1));
						i++;
					}
				} else {
					incrementCount1++;
				}
			}
			for(int i=1; i<challengerList.size(); i+=3) { // Second half: If number of teams = 16, half2
				half2.add(challengerList.get(i));         // would contain 2,3,6,7,10,11,14,15.
				if(incrementCount2 == 1) {
					if(i != challengerList.size() - 1) {
						half2.add(challengerList.get(i+1));
						i++;
					}
				} else {
					incrementCount2++;
				}
			}
			ArrayList<Challenger> subArray1 = challengerSorter(half1); // Recurse through until base case.
			for(int i=0; i<subArray1.size(); i++) { // Add elements from subArray to current mergingArray.
				mergingArray.add(subArray1.get(i));
			}
			ArrayList<Challenger> subArray2 = challengerSorter(half2); // Recurse through until base case.
			for(int i=0; i<subArray2.size(); i++) { // Add elements from subArray to current mergingArray.
				mergingArray.add(subArray2.get(i));
			}
			return mergingArray;
		}
	}
	
}
