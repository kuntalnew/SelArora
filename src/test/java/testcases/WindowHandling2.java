package testcases;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		//To handle unwanted chrome pop-up
		Map<String, Object> prefs=new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options=new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.hdfc.com/");
		driver.findElement(By.xpath("//div[@id='HomepageModalVideo']//button[@type='button' and @class='close' and @data-dismiss='modal']")).click();
		driver.findElement(By.linkText("Blogs")).click();
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> iter=handles.iterator();
		String mainWindow=iter.next();
		System.out.println(mainWindow);
		while(iter.hasNext()) {
			    //System.out.println(iter.next());
				driver.switchTo().window(iter.next());
				System.out.println(driver.getTitle());					
		}
		driver.switchTo().window(mainWindow);
		System.out.println(driver.getTitle());	
	}
}