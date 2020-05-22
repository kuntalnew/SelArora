package testcases.testng;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Dependency {
	
	@Test(groups= {"testing"})
	public void testing1() {
		System.out.println("Testing 1");
		Assert.fail("Failing");
	}
	
	@Test(dependsOnMethods= {"testing1"}, groups= {"testing"})
	public void testing2() {
		System.out.println("Testing 2");	
	}
	
	@Test(dependsOnMethods= {"testing2"}, groups= {"testing", "lecturing"})
	public void testing3() {
		System.out.println("Testing 3");	
	}
	
	@Test(groups= {"developing", "lecturing"})
	public void developing1() {
		System.out.println("Developing 1");	
		Assert.fail("Failing");
	}
	
	@Test(groups= {"developing"})
	public void developing2() {
		System.out.println("Developing 2");	
	}
	
	@Test(dependsOnMethods= {"developing2", "developing1"})
	public void developing3() {
		System.out.println("Developing 3");	
	}
	
	@Test(groups= {"producing"})
	public void producing1() {
		System.out.println("producing 1");
		Assert.fail("Failing");
	}
	
	@Test(groups= {"producing", "lecturing"}, dependsOnMethods= {"producing1"}, alwaysRun=true)
	public void producing2() {
		System.out.println("producing 2");	
	}
	
	@Test(groups= {"producing"})
	public void producing3() {
		System.out.println("producing 3");	
	}
	
	@Test(groups= {"managing"})
	public void managing1() {
		System.out.println("managing 1");	
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