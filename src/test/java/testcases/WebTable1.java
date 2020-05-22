package testcases;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		List<WebElement> rowNum=driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
		List<WebElement> colNum=driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[1]/td"));
		System.out.println("Number of rows: "+rowNum.size());
	    System.out.println("Number of columns: "+colNum.size());
	    for (int i=1;i<=rowNum.size();i++) {
	    	for (int j=1;j<=colNum.size();j++) {
	    		//System.out.println(driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+rowNum.get(i)+"]/td["+colNum.get(j)+"]")).getText());
	    		System.out.print(driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+i+"]/td["+j+"]")).getText()+" ");
	    	}
	    	System.out.println();
	    }

	}

}
