package testcases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Calendar1 {

	public static void main(String[] args) throws ParseException {
		String d="31/03/2021";
		String[] months= {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		Date myDate=df.parse(d);
		Calendar cal=Calendar.getInstance();
		cal.setTime(myDate);
		int day=cal.get(Calendar.DAY_OF_MONTH);
		int month=cal.get(Calendar.MONTH); //This will print 2 as Jan=0, Feb=1 etc.
		int year=cal.get(Calendar.YEAR);
		System.out.println(day +"/"+month+"/"+year);
		System.out.println(day +"/"+months[month]+"/"+year);
		String travelMonth=months[month]+" "+year;
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.id("departureCalendar")).click();
		WebElement nextBtn=driver.findElement(By.cssSelector(".DayPicker-NavButton--next"));
		WebElement displayedDate=driver.findElement(By.xpath("//div[@class='DayPicker-Caption' and @role='heading']"));
		while(!(displayedDate.getText().equals(travelMonth))){
			nextBtn.click();
		}
		List<WebElement> datesInDesiredMonth=driver.findElements(By.cssSelector("div[id^='fare_']"));
		for (WebElement elem:datesInDesiredMonth) {
			if(elem.getText().equals("17")) {
				elem.click();
			}
		}
	}
}
