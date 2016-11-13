package Testing;

import Controller.Controller;
//import org.junit.runner.JUnitCore;
//import org.junit.runner.Result;
//import org.junit.runner.notification.Failure;

public class Testing {

	public static void main(String[] args) {

		Controller c = new Controller();
		
		c.getManual_Player2().sowAndCapture(0);
		
		if(c.getBoard().getHouses().get(0).getSeeds() == 0) {
			System.out.println("Passed: initial step of sowing");
		} else {
			System.out.println("Failed: initial step of sowing");
		}
		
		int test2 = 0;
		
		for(int i = 11; i > 7; --i) {
			if(c.getBoard().getHouses().get(i).getSeeds() == 5) {
				test2++;
			}
		}
		
		if(test2 == 4) {
			System.out.println("Passed: sowing seeds");
		} else {
			System.out.println("Failed: sowing seeds");
		}
		
		c.getCpu_Player1().sowAndCapture(6);
		c.getManual_Player2().sowAndCapture(5);
		c.getCpu_Player1().sowAndCapture(9);
		c.getManual_Player2().sowAndCapture(0);
		c.getCpu_Player1().sowAndCapture(10);
		
		if(c.getCpu_Player1().getScore() == 2) {
			System.out.println("Passed: capturing and setting player score");
		} else {
			System.out.println("Failed: capturing and setting player score");
		}
		
		c.getBoard().getHouses().get(10).setSeeds(12);
		c.getCpu_Player1().sowAndCapture(10);
		
		if(c.getBoard().getHouses().get(9).getSeeds() == 3) {
			System.out.println("Passed: sowing a house with 12 seeds works correctly");
		} else {
			System.out.println("Failed: sowing a house with 12 seeds works correctly");
		}

//		    // Replace MyTestClass by your JUnit tests class
//		    Result result = JUnitCore.runClasses(MyPrimeTest.class);
//		    for (Failure failure : result.getFailures()) {
//		      System.out.println(failure.toString());
//		    }
//		    System.out.println(result.wasSuccessful());
//		  }
	}

}
