package testcases.testng;

import org.testng.annotations.Test;

public class Datapovider2 {
	
	@Test(dataProviderClass=dataProvider.DataProviderFeed.class, dataProvider="getOldCredentials")
	public void sign(String userName, String password) {
		System.out.println(userName+" "+password);
	}
	
	@Test(dataProviderClass=dataProvider.DataProviderFeed.class, dataProvider="getNewCredentials")
	public void test1(String userName, String password, String email) {
		System.out.println(userName+" "+password+" "+email);
	}
}