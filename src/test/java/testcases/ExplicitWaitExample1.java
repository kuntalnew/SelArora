package testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitExample1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://way2automation.com");
		WebDriverWait wait=new WebDriverWait(driver, 5);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='https://sso.teachable.com/secure/673/users/sign_in?reset_purchase_session=1']")));
		System.out.println(element.getText());
	    driver.quit();
	}

}
