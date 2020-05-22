package testcases.testng;

import java.util.Date;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParallelThroughDataprovider {
	
	@Test(dataProvider="getData")
	public void test1(String browser) {
		Date d=new Date();
		System.out.println(browser+" "+d.toString());
	}
	
	@DataProvider(parallel=true)
	public Object[][] getData(){
		Object[][] data=new Object[2][1];
		data[0][0]="firefox";
		data[1][0]="chrome";
		return data;
		
	}
}
