package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown1 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
		WebElement countries=driver.findElement(By.id("searchLanguage"));
		Select select=new Select(countries);
		select.selectByIndex(0);
		select.selectByVisibleText("English");
		select.selectByValue("da");
		List<WebElement> list_of_countries=select.getOptions();
		for (WebElement elem:list_of_countries)
			System.out.println(elem.getText());
		System.out.println("===================================================");
		list_of_countries=driver.findElements(By.xpath("//select[@id='searchLanguage']/option"));
		for (WebElement elem:list_of_countries)
			System.out.println(elem.getText());
		System.out.println("***************************************************");
		list_of_countries=driver.findElements(By.tagName("option"));
		for (WebElement elem:list_of_countries)
			System.out.println(elem.getAttribute("lang")+" "+elem.getText());
		
	}

}
