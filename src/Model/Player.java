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
		
		for (int i = housesToIncrem.size()-1; i >= 0; --i) {
			if (housesToIncrem.get(i).getPlayer() == this && (housesToIncrem.get(i).getSeeds() == 2 || housesToIncrem.get(i).getSeeds() == 3)) {
				score += housesToIncrem.get(i).getSeeds();
				housesToIncrem.get(i).clearHouse();
			}
			else {
				break;
			}
		}
		
		System.out.println(identity);
		
		if(identity == 1) {
			
			int isEmpty = 0;
			
			for(int j = 0;j < 6; ++j) {
				House check = game.getHouses().get(j);
				if(check.getSeeds() == 0) {
					isEmpty++;
				}
			}
			
			if(isEmpty == 6) {
				System.out.print("P1");
				game = copy;
			}
		}
		
		if(identity == 2) {
			
			int isEmpty = 0;
			
			for(int j = 6; j < 12; ++j) {
				House check = game.getHouses().get(j);
				if(check.getSeeds() == 0) {
					isEmpty++;
				}
			}
			
			if(isEmpty == 6) {
				game = copy;
				System.out.print("P2");
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
