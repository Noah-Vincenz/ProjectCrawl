package Testing;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import Controller.Controller;

public class MyModelTest {

    Controller c = new Controller();
//	
//	c.getManual_Player2().sowAndCapture(0);
//	
//	if(c.getBoard().getHouses().get(0).getSeeds() == 0) {
//		System.out.println("Passed: initial step of sowing");
//	} else {
//		System.out.println("Failed: initial step of sowing");
//	}
//	
//	int test2 = 0;
//	
//	for(int i = 11; i > 7; --i) {
//		if(c.getBoard().getHouses().get(i).getSeeds() == 5) {
//			test2++;
//		}
//	}
//	
//	if(test2 == 4) {
//		System.out.println("Passed: sowing seeds");
//	} else {
//		System.out.println("Failed: sowing seeds");
//	}
//	
//	c.getCpu_Player1().sowAndCapture(6);
//	c.getManual_Player2().sowAndCapture(5);
//	c.getCpu_Player1().sowAndCapture(9);
//	c.getManual_Player2().sowAndCapture(0);
//	c.getCpu_Player1().sowAndCapture(10);
//	
//	if(c.getCpu_Player1().getScore() == 2) {
//		System.out.println("Passed: capturing and setting player score");
//	} else {
//		System.out.println("Failed: capturing and setting player score");
//	}
//	
//	c.getBoard().getHouses().get(10).setSeeds(12);
//	c.getCpu_Player1().sowAndCapture(10);
//	
//	if(c.getBoard().getHouses().get(9).getSeeds() == 3) {
//		System.out.println("Passed: sowing a house with 12 seeds works correctly");
//	} else {
//		System.out.println("Failed: sowing a house with 12 seeds works correctly");
//	}
    	
	@Test
	public void seedsShouldbeClearedWhenSown() {

	    c.getManual_Player2().sowAndCapture(0);
		assertEquals(0, c.getBoard().getHouses().get(0).getSeeds());
		
	}


	@Test
	public void seedsShouldIncrementCorrectlyAfterSowing() {

	    c.getManual_Player2().sowAndCapture(0);
	    
	    assertEquals(5, c.getBoard().getHouses().get(11).getSeeds());
	    assertEquals(5, c.getBoard().getHouses().get(10).getSeeds());
	    assertEquals(5, c.getBoard().getHouses().get(9).getSeeds());
	    assertEquals(5, c.getBoard().getHouses().get(8).getSeeds());
	    assertEquals(4, c.getBoard().getHouses().get(7).getSeeds());
	}
	
	@Test
	public void scoreIncreasesWhenPlayerCapturesHouse() {

	    c.getManual_Player2().sowAndCapture(0);
		c.getCpu_Player1().sowAndCapture(6);
		c.getManual_Player2().sowAndCapture(5);
		c.getCpu_Player1().sowAndCapture(9);
		c.getManual_Player2().sowAndCapture(0);
		c.getCpu_Player1().sowAndCapture(10);
	    
	    assertEquals(2, c.getCpu_Player1().getScore());
	}
	
	@Test
	public void HouseIsClearedWhenCaptureOccurs() {

	    c.getManual_Player2().sowAndCapture(0);
		c.getCpu_Player1().sowAndCapture(6);
		c.getManual_Player2().sowAndCapture(5);
		c.getCpu_Player1().sowAndCapture(9);
		c.getManual_Player2().sowAndCapture(0);
		c.getCpu_Player1().sowAndCapture(10);
	    
	    assertEquals(0, c.getBoard().getHouses().get(5).getSeeds());
	}
	
	@Test
	public void HousesAreNotCapturedWhenNoSeedsAreLeft() {

		for(int i = 2; i < 6; ++i) {
			c.getBoard().getHouses().get(i).setSeeds(1);
		}
		
		c.getBoard().getHouses().get(0).setSeeds(0);
		c.getBoard().getHouses().get(1).setSeeds(0);
		
	    c.getCpu_Player1().sowAndCapture(6);
	    
	    assertEquals(2, c.getBoard().getHouses().get(5).getSeeds());
	    assertEquals(2, c.getBoard().getHouses().get(4).getSeeds());
	    assertEquals(2, c.getBoard().getHouses().get(3).getSeeds());
	    assertEquals(2, c.getBoard().getHouses().get(2).getSeeds());

	}
}
