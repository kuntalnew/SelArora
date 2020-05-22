package testcases;

import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hollisterco.com/shop/wd");
		Thread.sleep(3000);
		WebElement elem=driver.findElement(By.cssSelector("div.footer__info-links.grid-col.grid-col-2 ul ul"));
		String openInNewTab=Keys.chord(Keys.CONTROL, Keys.ENTER);
		List<WebElement> links=elem.findElements(By.tagName("a"));
		String mainWindow=driver.getWindowHandle();
		for (WebElement link:links) {
			link.sendKeys(openInNewTab);	
		}
		Set<String> handles=driver.getWindowHandles();
		for (String handle:handles) {
			if(!(handle.equals(mainWindow))) {
				driver.switchTo().window(handle);
				System.out.println(driver.getTitle());
				System.out.println(driver.getCurrentUrl());
			}
		}
		driver.switchTo().window(mainWindow);
		System.out.println(driver.getTitle());
	}
}