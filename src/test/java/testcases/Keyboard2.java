package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
//This whole code is not working
public class Keyboard2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Actions actions =new Actions(driver);
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("sania");
		driver.findElement(By.xpath("//div[@id='lga']")).click();
		Thread.sleep(3000);
		actions.keyDown(Keys.CONTROL);
		actions.sendKeys("a");
		actions.keyUp(Keys.CONTROL);
		actions.keyDown(Keys.CONTROL);
		actions.sendKeys("c");
		actions.keyUp(Keys.CONTROL);
		//actions.sendKeys(Keys.chord(Keys.CONTROL+ "a")).perform();
		//actions.sendKeys(Keys.chord(Keys.CONTROL+"c")).perform();
		//actions.sendKeys(Keys.CONTROL, "V");
		//driver.findElement(By.xpath("//div[@id='lga']")).sendKeys(Keys.chord(Keys.CONTROL+ "a"));
		//driver.findElement(By.xpath("//div[@id='lga']")).sendKeys(Keys.chord(Keys.CONTROL, "c"));
		driver.findElement(By.name("q")).click();
		actions.keyDown(Keys.CONTROL);
		actions.sendKeys("v");
		actions.keyUp(Keys.CONTROL);
		//actions.sendKeys(Keys.chord(Keys.CONTROL+ "v")).perform();
	}
}
