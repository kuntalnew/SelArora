package testcases;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Xpath1 {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://way2automation.com/way2auto_jquery/index.php");
	    driver.findElement(By.name("name")).sendKeys("name22");
	    driver.findElement(By.name("phone")).sendKeys("ggjgj");
	    driver.findElement(By.name("email")).sendKeys("username22@gmail.com");
	    driver.findElement(By.name("city")).sendKeys("ggjgj");
	    driver.findElement(By.xpath("(//input[@type='text'][@name='username'])[2]")).sendKeys("username22");
	    driver.findElement(By.xpath("(//input[@type='password'][@name='password'])[2]")).sendKeys("password22");
		WebElement submit_btn=driver.findElement(By.xpath("(//input[@type='submit' and @value='Submit'])[2]"));
		submit_btn.click();	
		Actions actions=new Actions(driver);
		driver.navigate().refresh();
		WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement dynamic_elements=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='javascript:'])[3]")));
		actions.moveToElement(dynamic_elements).perform();
		List<WebElement> sub_menus=driver.findElements(By.xpath("//*[@id=\"toggleNav\"]/li[5]/ul/li"));
		for (int i=0;i<sub_menus.size();i++) {
			String innerHtml=sub_menus.get(i).getAttribute("innerHTML");
			System.out.println(sub_menus.get(i).getAttribute("innerHTML"));
			if(innerHtml.contains("clicked")) {
				sub_menus.get(i).click();
			    break;
			}	
		}
			
		WebElement submit_button_clicked=driver.findElement(By.xpath("//a[@href='submit_button_clicked.php']"));
		submit_button_clicked.click();
		//driver.findElement(By.xpath("//input[@type='button'][@name='submit' and @value='submit']")).click();
	}
}
