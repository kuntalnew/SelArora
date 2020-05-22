package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NumberofLinksonaPage {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
		
		List<WebElement> list_of_countries=driver.findElements(By.tagName("a"));
		for (WebElement elem:list_of_countries)
			System.out.println(elem.getText()+" "+elem.getAttribute("href"));
		System.out.println("===============================================");
		System.out.println("===============================================");
		
		//The below code is not working
		WebElement countries_block=driver.findElement(By.xpath("//select[@id='searchLanguage']"));
		list_of_countries=countries_block.findElements(By.tagName("a"));
		System.out.println(list_of_countries.size());
		for (WebElement elem:list_of_countries)
			System.out.println(elem.getText()+" "+elem.getAttribute("href"));
		
	}
	   

}
