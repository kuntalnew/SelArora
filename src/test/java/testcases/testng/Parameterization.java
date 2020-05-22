package testcases.testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameterization {
	
	@Parameters("browser")
	@Test
	public void test1(String browser) {
		System.out.println(browser);
	}
	
	@Parameters({"browser", "responseCode"})
	@Test
	public void test2(String browser, String responseCode) {
		System.out.println(browser+" "+responseCode);
	}
}
