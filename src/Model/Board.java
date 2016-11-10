package Model;

import java.util.ArrayList;

public class Board {

    private ArrayList<House> houses;
    Player firstPlayer;
    Player secondPlayer;

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

    public ArrayList<House> getHouses() {
        return houses;
    }
    public Player getPlayer1(){
        return firstPlayer;
    }
    public Player getPlayer2(){ 
        return secondPlayer;
    }
}
