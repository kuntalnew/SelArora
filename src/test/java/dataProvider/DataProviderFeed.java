package dataProvider;

import java.lang.reflect.Method;
import org.testng.annotations.DataProvider;

public class DataProviderFeed {
	
	@DataProvider
	public Object[][] getOldCredentials(){
		Object[][] obj=new Object[2][2];
		obj[0][0]="kuntal1@gmail.com";
		obj[0][1]="abc";
		obj[1][0]="kunta2@gmail.com";
		obj[1][1]="def";
		
		return obj;		
	}
	
	@DataProvider
	public Object[][] getNewCredentials(){
		Object[][] obj=new Object[2][3];
		obj[0][0]="kuntal1";
		obj[0][1]="abc";
		obj[0][2]="kunta1@gmail.com";
		obj[1][0]="kuntal2";
		obj[1][1]="def";
		obj[1][2]="kuntal2@gmail.com";
		
		return obj;		
	}
	
	@DataProvider
	public Object[][] getCredentials(Method m){
		Object[][] data=null;
		if(m.getName().equals("signUp")) {
			data=new Object[2][2];
		    data[0][0]="kuntal1@gmail.com";
			data[0][1]="abc";
			data[1][0]="kunta2@gmail.com";
			data[1][1]="def";	
		} else if(m.getName().equals("login")){
			data=new Object[2][3];
			data[0][0]="kuntal1";
			data[0][1]="abc";
			data[0][2]="kunta1@gmail.com";
			data[1][0]="kuntal2";
			data[1][1]="def";
			data[1][2]="kuntal2@gmail.com";	
		}
		return data;	
	}
}