package testcases;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckboxRadioButtonLinks {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://echoecho.com/htmlforms10.htm");
		Thread.sleep(3000);
		List<WebElement> group1=driver.findElements(By.xpath("//input[@type='radio'][@name='group1']"));
		System.out.println(group1.size());
		for (int i=0; i<group1.size();i++) {
	        	System.out.println(group1.get(i).getAttribute("value"));
	        	if(group1.get(i).getAttribute("value").contentEquals("Cheese")) {
	        		group1.get(i).click();
	        		
	        	}
		}
		
		driver.get("https://www.hollisterco.com/shop/wd");
		Thread.sleep(3000);
		List<WebElement> elems=driver.findElements(By.cssSelector("div.footer__info-links > ul > li"));
		System.out.println(elems.size());
		for (WebElement elem:elems) {
			System.out.println(elem.getText());
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");			
			List<WebElement> links=elem.findElements(By.tagName("a"));
			for (WebElement link:links) {
				System.out.println(link.getText());
			}
		}

	}	
}
