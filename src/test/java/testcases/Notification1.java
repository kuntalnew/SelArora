package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Notification1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("-- disable-notifications");
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://www.cleartrip.com");
		// I got some issues with the wbove example. So many tabs opens and shows that something is disabled and the addresses cannot be reached.
	}
}
