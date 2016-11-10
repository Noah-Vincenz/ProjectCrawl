package Model;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private int identity;
	private int score;
	private Board game;
	List<House> housesToIncrem;
	
	public Player(int identity, Board game) {
		score = 0;
		this.identity = identity;
		this.game = game;
		housesToIncrem = new ArrayList<House>();
	}
	
	public void sowAndCapture(int position) {
		House house = game.getHouses().get(position);
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
			
			House newHouse = game.getHouses().get(newPosition);
			newHouse.incrementSeeds();
			housesToIncrem.add(newHouse);
		}
		for (int i = housesToIncrem.size()-1; i > 0; --i) {
			if (housesToIncrem.get(i).getPlayer() != this && housesToIncrem.get(i).getSeeds() == 2 || housesToIncrem.get(i).getSeeds() == 3) {
				score += housesToIncrem.get(i).getSeeds();
				housesToIncrem.get(i).clearHouse();
			}
			else {
				break;
			}
		}

		
		Board copy = game;
				
		if(newPosition > 6 && identity == 1) {
			House check = game.getHouses().get(newPosition);
			int checkSeeds = check.getSeeds();
		}
		
		if(newPosition < 6 && identity == 2) {
			House check = game.getHouses().get(newPosition);
			int checkSeeds = check.getSeeds();
		}
		
		if(identity == 1) {
			
			int isEmpty = 0;
			
			for(int i = 6; i < 12; ++i) {
				House check = game.getHouses().get(i);
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
				House check = game.getHouses().get(i);
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