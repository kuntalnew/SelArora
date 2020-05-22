package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AjaxDropdown1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/flights/");
		driver.findElement(By.cssSelector("label[for='fromCity'] > span")).click();
		driver.findElement(By.xpath("//input[@type='text'][@aria-autocomplete='list']")).sendKeys("del");
		//Keys.DOWN selects the autosuggestion
		driver.findElement(By.xpath("//input[@type='text'][@aria-autocomplete='list']")). sendKeys(Keys.DOWN);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='text'][@aria-autocomplete='list']")).sendKeys(Keys.ENTER);
	}

}
