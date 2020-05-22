package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class IsElementPresent1 {
	public static WebDriver driver;
	public static boolean isElementPresent(By by) {
		try{
			driver.findElement(by);
			return true;
		}catch(Throwable t) {
			return false;	
		}
	}

	public static void main(String[] args) {
		String xpathString="//*[@id='searchLanguage']";
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.navigate().to("https://www.wikipedia.org/");
		System.out.println(isElementPresent(By.xpath(xpathString)));
		System.out.println(driver.findElement(By.xpath("//*[@id='searchLanguage']")).isEnabled());
		System.out.println(driver.findElement(By.xpath("//*[@id='searchLanguage']")).isDisplayed());
		
	}

}
