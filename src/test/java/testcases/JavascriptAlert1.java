package testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptAlert1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.tizag.com/javascriptT/javascriptalert.php");
		driver.findElement(By.xpath("//input[@type='button' and @value='Confirmation Alert']")).click();
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		/*alert.accept();
		driver.findElement(By.xpath("//input[@type='button' and @value='Confirmation Alert']")).click();
		alert=driver.switchTo().alert();*/
		alert.dismiss();
	}
}
