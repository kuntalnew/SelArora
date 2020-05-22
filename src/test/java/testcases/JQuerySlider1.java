package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class JQuerySlider1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/resources/demos/slider/default.html");
		driver.manage().window().maximize();
		Actions actions=new Actions(driver);
		WebElement slider=driver.findElement(By.xpath("//div[@id='slider']/span"));
		WebElement sliderPath=driver.findElement(By.xpath("//div[@id='slider']"));
		//actions.dragAndDropBy(slider, 500, 0).perform();
		//At the center
		int width=sliderPath.getSize().width/2;
		actions.dragAndDropBy(slider, width, 0).perform();
	}
}
