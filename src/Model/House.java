package Model;

/**
 * Simple class which represents the house object on the Oware board. Stores the ownership of
 * a house and the amount of seeds it contains.
 * 
 */
public class House {

    private int seeds;
    private Player ownership;

    /**
     * When a house is created the seeds of the house is automatically set to 4.
     * 
     * @param player Player object which will be used to assign a house to a player.
     */
    public House(Player player) {
        ownership = player;
        seeds = 4;
    }
    
    /**
     * The only way the seeds value can be changed is by calling this method which increments
     * the amount of seeds the house holds.
     * 
     */
    public void incrementSeeds() {
        seeds++;
    }

    /**
     * Method is called whenever a house is captured or sowed.
     * 
     */
    public void clearHouse() {
        seeds = 0;
    }

    /**
     * Method used often in the controller to set a players score or see how to sow a house correctly. 
     * 
     * @return the seeds a house holds
     */
    public int getSeeds() {
        return seeds;
    }

    /**
     * Method used to see what player owns this house
     * 
     * @return Player object that owns this house.
     */
    public Player getPlayer() {
        return ownership;
    }
}
