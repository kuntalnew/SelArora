package testcases;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkboxes {
	public static WebDriver driver;
	public static boolean isElementPresent(By by) {
		try{
			driver.findElement(by);
			return true;
		}catch(Throwable t) {
			return false;	
		}
	}
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
		//xpath for soccer checkbox=/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]/input[1]
		//xpath for football checkbox=/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]/input[2]
		//xpath for baseball checkbox=/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]/input[3]
		//xpath for basketball checkbox=/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]/input[4]
	    for (int i=1; i<=4;i++) {
	    	driver.findElement(By.xpath("//div[4]/input["+i+"]")).click();
	    	
	    }
	    
	    //second approach
	    int i=1;
	    int count=0;
	    while(isElementPresent(By.xpath("//div[4]/input["+i+"]"))) {
	    	driver.findElement(By.xpath("//div[4]/input["+i+"]")).click();
	    	i++;
	    	count++;
	    	
	    }
	    System.out.println("Total number of checkboxes is: "+count);
	    List<WebElement> sports=driver.findElements(By.name("sports"));
	    System.out.println("Total number of checkboxes is: "+sports.size());
	    for (int j=0;j<sports.size();j++)
	    	sports.get(j).click();
	    System.out.println("==================================================");
	    for (WebElement elem:sports) {
	    	elem.click();
	    }
	    WebElement sportsBlock=driver.findElement(By.className("display"));
	    List<WebElement> sportss=sportsBlock.findElements(By.name("sports"));
	    System.out.println("Total number of checkboxes is: "+sportss.size());
	    for (WebElement elem:sportss) {
	    	elem.click();
	    }

	}
}
