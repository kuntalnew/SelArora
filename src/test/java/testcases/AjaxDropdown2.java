package testcases;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AjaxDropdown2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://in.yahoo.com/?p=us");
		driver.findElement(By.id("header-search-input")).sendKeys("hello");
		Thread.sleep(3000);
		WebElement suggestion_container=driver.findElement(By.xpath("//div[@type='normal']"));
		List<WebElement> suggestions=suggestion_container.findElements(By.xpath("//ul[@role='listbox']/li/span/span"));
		for (WebElement elem:suggestions) {
			System.out.println(elem.getText());
		}
		
		//The below code also works fine. 
		/*List<WebElement> suggestions=driver.findElements(By.xpath("//div[@type='normal']"));
		for (int i=0; i<suggestions.size();i++) {
			System.out.println(suggestions.get(i).getText());
			
		}*/
	}
}
