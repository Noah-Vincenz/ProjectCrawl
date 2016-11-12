package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Player class contains all the methods that a player can call when playing
 * the game.
 * 
 * @author hanitawil
 *
 */
public class Player {

	private int identity;
	private int score;
	private Board game;
	List<House> housesToIncrem;
	private int tempScore;
	
	/**
	 * 
	 * 
	 * @param identity
	 * @param game
	 */
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
		Board copy = game;
		
		for(int i = 0; i < seeds; ++i) {			
			newPosition--;
			
			if(newPosition < 0) {
				newPosition = 11;
			}
			
			if(newPosition == position) {
				newPosition--;
				if(newPosition < 0) {
					newPosition = 11;
				}
			}
			
			ArrayList<House> testing = game.getHouses();
			House newHouse = testing.get(newPosition);
			newHouse.incrementSeeds();
			housesToIncrem.add(newHouse);
		}

		ArrayList<Integer> temp = new ArrayList<Integer>();	
		
		for(int i = 0; i < game.getHouses().size(); ++i) {
			temp.add(game.getHouses().get(i).getSeeds());
		}
		
		tempScore = score;

		for (int i = housesToIncrem.size()-1; i >= 0; --i) {
			if (housesToIncrem.get(i).getPlayer() == this && (housesToIncrem.get(i).getSeeds() == 2 || housesToIncrem.get(i).getSeeds() == 3)) {
				score += housesToIncrem.get(i).getSeeds();
				housesToIncrem.get(i).clearHouse();
			}
			else {
				break;
			}
		}		
		
		if(identity == 1) {
			
			int isEmpty = 0;
			
			for(int j = 0; j < 6; ++j) {
				House check = game.getHouses().get(j);
				if(check.getSeeds() == 0) {
					isEmpty++;
				}
			}
			
			if(isEmpty == 6) {

				for(int i = 0; i < game.getHouses().size(); ++i) {
					game.getHouses().get(i).setSeeds(temp.get(i));
					score = tempScore;
				}
			}
		}
		
		if(identity == 2) {
			
			int isEmpty = 0;
			
			for(int i = 6; i < 12; ++i) {
				House check = game.getHouses().get(i);
				if(check.getSeeds() == 0) {
					isEmpty ++;
				}
			}
			
			if(isEmpty == 6) {
				for(int i = 0; i < game.getHouses().size(); ++i) {
					game.getHouses().get(i).setSeeds(temp.get(i));
					score = tempScore;
				}
			}
		}
	
	}
	public int getScore() {
		return score;
	}
	
	public int setInitialScore(int i){
		score = i;
		return score;
	}
}
