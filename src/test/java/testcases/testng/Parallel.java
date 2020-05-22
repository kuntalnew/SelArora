package testcases.testng;

import java.util.Date;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parallel {
	
	@Parameters("browser")
	@Test
	public void test1(String browser) {
		Date d=new Date();
		System.out.println(browser+" "+d.toString());
	}
}
