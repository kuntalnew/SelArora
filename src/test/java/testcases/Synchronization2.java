package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Synchronization2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.get("https://www.expedia.co.in/");
		driver.findElement(By.xpath("//button[@data-lob='package']")).click();
		driver.findElement(By.xpath("//input[@id='package-origin-hp-package' and @placeholder='City or airport']")).sendKeys("c");
		driver.findElement(By.xpath("//input[@id='package-origin-hp-package' and @placeholder='City or airport']")).sendKeys(Keys.DOWN);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='package-origin-hp-package' and @placeholder='City or airport']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//input[@id='package-origin-hp-package' and @placeholder='City or airport']")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//input[@id='package-origin-hp-package' and @placeholder='City or airport']")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//input[@id='package-destination-hp-package' and @placeholder='Hotel name, city or airport']")).sendKeys("on");
		driver.findElement(By.xpath("//input[@id='package-destination-hp-package' and @placeholder='Hotel name, city or airport']")).sendKeys(Keys.DOWN);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='package-destination-hp-package' and @placeholder='Hotel name, city or airport']")).sendKeys(Keys.ENTER);
        driver.findElement(By.id("package-departing-hp-package")).sendKeys("20/03/2021");
        driver.findElement(By.id("package-departing-hp-package")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//a[contains(@href, 'Hilton')]")).click();

	}
}
