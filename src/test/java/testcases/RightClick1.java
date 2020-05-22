package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClick1 {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://deluxe-menu.com/popup-mode-sample.html");
		WebElement image=driver.findElement(By.xpath("//img[@src='data-samples/images/popup_pic.gif']"));
		Actions actions=new Actions(driver);
		actions.contextClick(image).perform();
		//driver.findElement(By.id("dm2m1i2it")).click();
		WebElement sample=driver.findElement(By.id("dm2m1i2it"));
		actions.moveToElement(sample).perform();
		Thread.sleep(3000);
		driver.findElement(By.id("dm2m8i5it")).click();
	}
}
