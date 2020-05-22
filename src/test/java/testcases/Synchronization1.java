package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Synchronization1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://alaskatrips.poweredbygps.com/");
		driver.findElement(By.xpath("//input[@placeholder='City or airport'][@id='package-origin-hp-package']")).sendKeys("nyc");
		driver.findElement(By.xpath("//input[@placeholder='City or airport'][@id='package-origin-hp-package']")).sendKeys(Keys.ARROW_DOWN); //Both Keys.DOWN and Keys.ARROW_DOWN works same here.
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='City or airport'][@id='package-origin-hp-package']")).sendKeys(Keys.ENTER);
	}
}
