package testcases;

import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelDemo {

	public static void main(String[] args) throws IOException {
		ReadingFromExcel rfe=new ReadingFromExcel();
		ArrayList<String> testCaseData=rfe.getData("TC3");
		System.out.println(testCaseData.get(0));
		System.out.println(testCaseData.get(1));
		System.out.println(testCaseData.get(2));
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(testCaseData.get(1));
	}
}
