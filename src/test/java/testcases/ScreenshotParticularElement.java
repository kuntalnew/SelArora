package testcases;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotParticularElement {
	
	public static WebDriver driver;
	
	public static void captureScreenshot(WebElement elem) throws IOException {
		Date d=new Date();
		String fileName=d.toString().replace(" ", "_").replace(":", "_");
		File screenshot=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		BufferedImage fullImage=ImageIO.read(screenshot);
		Point p=elem.getLocation();
		int eleWidth=elem.getSize().getWidth();
		int eleHeight=elem.getSize().getHeight();
		BufferedImage eleScreenshot=fullImage.getSubimage(p.getX(),  p.getY(),  eleWidth, eleHeight);
		ImageIO.write(eleScreenshot, "jpg", screenshot);
		File screenshotLocation=new File(".\\screenshot\\"+fileName+".jpg");
		FileUtils.copyFile(screenshot, screenshotLocation);	
	}

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//WebDriverWait wait=new WebDriverWait(driver, 20);
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		WebElement canvas=driver.findElement(By.xpath("//div[@class='ddlmdsb-a ddlmdsb-pc ddlmdsb-mc ddlmdsb-nc']"));
		captureScreenshot(canvas);
	}
}
