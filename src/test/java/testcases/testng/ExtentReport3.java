package testcases.testng;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class ExtentReport3 {

	
	@Test
	public void doPass(){
		System.out.println("Passing test");
		Assert.assertEquals(true, true);
		
	}
	
	@Test
	public void doFail() {
		System.out.println("Failing test");
		Assert.fail("The test case is failed");
		
	}
	
	@Test
	public void doSkip() {
		System.out.println("Skipping test");
		throw new SkipException("Skipping the test case");
		
	}
}