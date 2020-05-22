package testcases.testng;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ThreadPoolSize extends BaseTest {
	public static WebDriver driver;
	
	@Test(invocationCount=5, threadPoolSize=5)
	public void launchBrowser(){
		driver=BaseTest.getWebDriver("chrome");
		driver.get("https://www.google.com");
	}
}
