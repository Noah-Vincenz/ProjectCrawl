package Model;

public class House {
	
	private int seeds;
	private Player ownership;
	
	public House(Player player) {
		ownership = player;
		seeds = 4;
	}
	
	public void setOwnership(Player player) {
		ownership = player;
	}

	public void setSeeds()  {
		seeds++;
	}
	
	public void clearHouse() {
		seeds = 0;
	}
	
	public int getSeeds() {
		return seeds;
	}
	
	public Player getPlayer() {
		return ownership;
	}
}

