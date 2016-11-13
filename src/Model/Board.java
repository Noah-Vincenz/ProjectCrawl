package Model;

import java.util.ArrayList;

/**
 * Board class which represents the Oware board itself. The class stores an 
 * arraylist which contains house. It also stores the players that are playing the game.
 * 
 * @author hanitawil
 *
 */
public class Board {

    private ArrayList<House> houses;
    Player firstPlayer;
    Player secondPlayer;

    /**
     * When a board is constructed, the constructor creates 2 players and creates houses 
     * which are assigned to their players depending on where they are placed in the arraylist.
     * 
     */
    public Board() {
        houses = new ArrayList<House>();

        firstPlayer = new Player(1, this);
        secondPlayer = new Player(2, this);

        for (int i = 0; i < 12; ++i) {
            if (i < 6) {
                houses.add(new House(firstPlayer));
            } else {
                houses.add(new House(secondPlayer));
            }
        }
    }

    /**
     * Getter method to get the houses are board contains.
     * 
     * @return an arraylist of houses.
     */
    public ArrayList<House> getHouses() {
        return houses;
    }
    
    /**
     * Get player 1
     * @return
     */
    public Player getPlayer1(){
        return firstPlayer;
    }
    
    /**
     * Get player 2
     * @return
     */
    public Player getPlayer2(){ 
        return secondPlayer;
    }
    
    /**
     * Method called after every move to check if a player is a winner or
     * if the game ended in a draw.
     * 
     * @return the method returns 1 if the first player won, 2 if the second player won, 3 if the game ended in a draw.
     */
    public int checkWin() {
    	if(firstPlayer.getScore() >= 25) {
    		return 1;
    	} else if(secondPlayer.getScore() >= 25) {
    		return 2;
    	} else if(firstPlayer.getScore() == 24 && secondPlayer.getScore() == 24) {
    		return 3;
    	} else {
    		return 0;
    	}
    }
}