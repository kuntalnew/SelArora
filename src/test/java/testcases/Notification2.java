package testcases;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Notification2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		/*DesiredCapabilities cap=DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		ChromeOptions options=new ChromeOptions();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		WebDriver driver=new ChromeDriver(options);*/
		//To handle unwanted chrome pop-up, the below code i working fine but the above code is not working.
		Map<String, Object> prefs=new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
	    WebDriver driver=new ChromeDriver(options);
		driver.get("https://www.cleartrip.com");
	}
}
