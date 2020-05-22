package testcases;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class CaptureScreenshotAShot {
	
	public static WebDriver driver;
	public static Date date;
	public static String fileName;
	
	public static void captureWholeScreenScreenshot(WebDriver driver) throws IOException {	
		date=new Date();
		fileName=date.toString().replace(":", "_").replace(" ", "_");
		Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(), "png", new File(".\\screenshot\\"+fileName+".png"));
	}
	
	public static void captureWholeElementScreenshot(WebDriver driver, WebElement elem) throws IOException {
		date=new Date();
		fileName=date.toString().replace(":", "_").replace(" ", "_");
		Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver, elem);
		ImageIO.write(screenshot.getImage(), "png", new File(".\\screenshot\\"+fileName+".png"));
	}
	
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://way2automation.com");
		WebElement elem=driver.findElement(By.xpath("//img[@class='header-logo__img']"));
		captureWholeElementScreenshot(driver, elem);
		captureWholeScreenScreenshot(driver);
	}
}