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
}