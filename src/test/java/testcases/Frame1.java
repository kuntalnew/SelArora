package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
//Unfortunately switching by webeelement is not successful in this example.
public class Frame1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//WebDriverWait wait=new WebDriverWait(driver, 20);
		driver.manage().window().maximize();
		driver.get("https://paytm.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='Log In/Sign Up']")).click();
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.xpath("//iframe[@src='/v1/api/login?isIframe=true&amp;theme=mp-web']"))));
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(0);
		//Thread.sleep(3000);
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='/v1/api/login?isIframe=true&amp;theme=mp-web']")));
		driver.findElement(By.linkText("Learn More")).click();
		driver.switchTo().parentFrame();
		//The below line also workd fine. In fact the below line works fine always. The above line works fine when only there are one ancestor frame to the current frame.
		//driver.switchTo().defaultContent();
		driver.findElement(By.linkText("X")).click();
		/* The below xpaths are also valid xpaths
		driver.findElement(By.xpath("//a[@title='Close']")).click();
		//driver.findElement(By.xpath("//a[@class='_3i6R']")).click();
		 */
	}
}
