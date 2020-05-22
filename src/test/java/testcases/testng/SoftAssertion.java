package testcases.testng;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion extends BaseTest{
	SoftAssert sa=new SoftAssert();
	
	@Test
	public void testing() {
		System.out.println("Testing");	
		sa.assertEquals(2, 5-4, "message");
		System.out.println("Printing");
		sa.assertAll();
	}
	
	@Test
	public void developing() {
		System.out.println("Developing");
		//Assert.assertTrue(Driver.isElementPresent());
		Assert.assertTrue(5==2+4, "message");
		System.out.println("Continuing test case");
	}
	
	@Test
	public void developing3() {
		System.out.println("Developing3");	
		//Assert.assertTrue(Driver.isElementPresent());
		Assert.fail("Deliberately failing the test case");
		System.out.println("Continuing test case");
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