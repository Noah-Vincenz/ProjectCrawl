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
	
	public void sowAndCapture(int position) {
		House house = game.getBoard().get(position);
		int seeds = house.getSeeds();
		house.clearHouse();
		int newPosition = position;
				
		for(int i = 0; i < seeds; ++i) {
			newPosition--;
			
			if(newPosition < 0) {
				newPosition = 11;
			}
			
			if(newPosition == position) {
				newPosition--;
			}
			
			House newHouse = game.getBoard().get(newPosition);
			newHouse.setSeeds();
		}
		
		Board copy = game;
				
		if(newPosition > 6 && identity == 1) {
			House check = game.getBoard().get(newPosition);
			int checkSeeds = check.getSeeds();
			
			while(newPosition > 6) {
				if(checkSeeds == 2 || checkSeeds == 3) {
					this.setScore(checkSeeds);
					check.clearHouse();
				} else {
					break;
				}
				newPosition++;
			}
		}
		
		if(newPosition < 6 && identity == 2) {
			House check = game.getBoard().get(newPosition);
			int checkSeeds = check.getSeeds();
			
			while(newPosition < 6) {
				if(checkSeeds == 2 || checkSeeds == 3) {
					this.setScore(checkSeeds);
					check.clearHouse();
				} else {
					break;
				}
				newPosition++;
			}
		}
		
		if(identity == 1) {
			
			int isEmpty = 0;
			
			for(int i = 6; i < 12; ++i) {
				House check = game.getBoard().get(i);
				if(check.getSeeds() == 0) {
					isEmpty ++;
				}
			}
			
			if(isEmpty == 6) {
				game = copy;
			}
		}
		
		if(identity == 2) {
			
			int isEmpty = 0;
			
			for(int i = 0; i < 6; ++i) {
				House check = game.getBoard().get(i);
				if(check.getSeeds() == 0) {
					isEmpty ++;
				}
			}
			
			if(isEmpty == 6) {
				game = copy;
			}
		}
	
	}
	
	void setScore(int points) {
		score += points;
	}
}
