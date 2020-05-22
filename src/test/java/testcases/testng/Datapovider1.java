package testcases.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Datapovider1 {
	
	@Test(dataProvider="getCredentials")
	public void test1(String userName, String password) {
		System.out.println(userName+" "+password);
	}
	
	@DataProvider
	public Object[][] getCredentials(){
		Object[][] obj=new Object[3][2];
		obj[0][0]="kuntal1@gmail.com";
		obj[0][1]="abc1";
		obj[1][0]="kunta2@gmail.com";
		obj[1][1]="def";
		obj[2][0]="kuntal3@gmail.com";
		obj[2][1]="ghi";
		
		return obj;		
	}
}