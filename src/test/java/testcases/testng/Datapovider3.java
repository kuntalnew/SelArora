package testcases.testng;

import org.testng.annotations.Test;

public class Datapovider3 {
	
	@Test(dataProviderClass=dataProvider.DataProviderFeed.class, dataProvider="getCredentials")
	public void signUp(String userName, String password) {
		System.out.println(userName+" "+password);
	}
	
	@Test(dataProviderClass=dataProvider.DataProviderFeed.class, dataProvider="getCredentials")
	public void login(String userName, String password, String email) {
		System.out.println(userName+" "+password+" "+email);
	}
}