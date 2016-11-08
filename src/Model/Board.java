package Model;

import java.util.ArrayList;

public class Board {
	
	private ArrayList<House> game;
	
	public Board() {
		game = new ArrayList<House>();
		
		Player first = new Player(1, this);
		Player second = new Player(2, this);
		
		for(int i = 0; i < 12; ++i) {
			if(i < 6) {
				game.add(new House(first));
			} else {
				game.add(new House(second));
			}
		}
	}
	
	public ArrayList<House> getBoard() {
		return game;
	}
}
