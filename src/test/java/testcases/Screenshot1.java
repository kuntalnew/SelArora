package testcases;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		Actions act=new Actions(driver);
		driver.get("https://www.americangolf.co.uk/");
		WebElement search=driver.findElement(By.xpath("//input[@id='q']"));
		act.moveToElement(search).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File target=new File("E:\\Selenium\\screenshot.png");
		try {
			FileUtils.copyFile(src, target);
		} catch (IOException e) {
			e.printStackTrace();
		};
	}
}
