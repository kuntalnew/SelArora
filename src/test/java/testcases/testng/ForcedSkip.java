package testcases.testng;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ForcedSkip {
	
	@Test(priority=0)
	public void testing() {
		System.out.println("Testing");	
	}
	
	@Test()
	public void developing1() {
		System.out.println("Developing 1");	
	}
	
	@Test(priority=1)
	public void developing2() {
		//We can use if condition. If a condition matches then throw the SkipException
		throw new SkipException("Skipping the test case");
	}
	
	@BeforeMethod
	public void openBrowser() {
		System.out.println("Opening browser");	
	}
	
	@AfterMethod
	public void closeBrowser() {
		System.out.println("Closing browser");	
	}
	
	@BeforeTest
	public void openDatabaseConn() {
		System.out.println("Opening database");	
	}
	
	@AfterTest
	public void closeDatabaseConn() {
		System.out.println("Closing database");	
	}	
}
