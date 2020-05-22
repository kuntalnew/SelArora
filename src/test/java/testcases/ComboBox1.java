package testcases;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ComboBox1 {

	public static void main(String[] args) {
		String industry="Education";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.jobserve.com/in/en/Job-Search/");
		driver.findElement(By.xpath("//span[@title='27 Industries Selected']")).click();
		//driver.findElement(By.xpath("//label[contains(text(), 'Select All Industries')]")).click();
		List<WebElement> options=driver.findElements(By.cssSelector("#industryDisplay > div div.ui-dropdownchecklist-dropcontainer.ui-widget-content > div.ui-dropdownchecklist-item.ui-state-default > label"));
		for (int i=1; i<options.size();i++) {
			System.out.println(options.get(i).getText());
        	if (options.get(i).getText().equals(industry)) {
        		options.get(i).click();
        		break;
        	}		
        }
	}
}
