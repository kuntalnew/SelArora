package testcases;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Frame3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//WebDriverWait wait=new WebDriverWait(driver, 20);
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		List<WebElement> frames=driver.findElements(By.tagName("a"));
		System.out.println(frames.size());
		for (WebElement frame:frames) {
			System.out.println(frame.getAttribute("id"));
		}
		/*for (int i=0;i<frames.size();i++) {
			driver.switchTo().frame(i);
			System.out.println(driver.findElements(By.xpath("//button[text()='Try it']")).size());
			driver.switchTo().defaultContent();
		}*/
		//The above for loop proves that the 1st frame consists the element. So we can switch by index 0.		
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
    }	
}