package testcases;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotWithTimestamp1 {
	
	public static WebDriver driver;
	
	public static void captureScreenshot() throws IOException {
		Date d=new Date();
		String fileName=d.toString().replace(" ", "_").replace(":", "_");
		File screenshot=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".\\screenshot\\"+fileName+".png"));	
	}

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//WebDriverWait wait=new WebDriverWait(driver, 20);
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		List<WebElement> frames=driver.findElements(By.tagName("a"));
		System.out.println(frames.size());
		for (WebElement frame:frames) {
			System.out.println(frame.getAttribute("id"));
		}
		driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("myFunction()");
		js.executeScript("arguments[0].style.border='3px solid red'", driver.findElement(By.id("mySubmit")));
		captureScreenshot();
	}
}
