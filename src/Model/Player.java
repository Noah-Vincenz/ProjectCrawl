package Model;

public class Player {

	private int identity;
	private int score;
	private Board game;
	
	public Player(int identity, Board game) {
		score = 0;
		this.identity = identity;
		this.game = game;
	}
	
	public void sow() {
		
	}
	
//	public void capture() {
//		
//	}
	
	void setScore(int points) {
		score += points;
	}
}
