package testcases;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Notification3Firefox {

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions options=new FirefoxOptions();
		FirefoxProfile profile=new FirefoxProfile(new File("C:\\Users\\91900\\AppData\\Roaming\\Mozilla\\Firefox"));
		options.setProfile(profile);
	    WebDriver driver=new FirefoxDriver(options);
		driver.get("https://www.cleartrip.com");
	}
}
