package Testing;

import Controller.Controller;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Testing {

	public static void main(String[] args) {

		    // Replace MyTestClass by your JUnit tests class
		    Result result = JUnitCore.runClasses(MyModelTest.class);
		    for (Failure failure : result.getFailures()) {
		      System.out.println(failure.toString());
		    }
		    System.out.println(result.wasSuccessful());
		  }
	}

