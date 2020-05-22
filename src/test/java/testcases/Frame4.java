package testcases;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frame4 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://paytm.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='Log In/Sign Up']")).click();
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		String mainFrame=driver.getWindowHandle();
		System.out.println(mainFrame);
		driver.switchTo().frame(0);
		Set<String> handles=driver.getWindowHandles();
		/*for (int i=0;i<handles.size();i++) {
			System.out.println(handles.get(i));
			
		}*/ //  I really don't know why this for loop is throwing error.
		for(String handle: handles) {
			System.out.println(handle);
			
		}
		driver.findElement(By.linkText("Learn More")).click();
		//driver.findElement(By.linkText("X")).click();

	}
}
