package application;

public class Challenger {
	
	private String name;
	private int score;
	
	public Challenger(String name) {
		this.name = name;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int newScore) {
		score = newScore;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return name;
	}
}
