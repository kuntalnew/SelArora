package testcases.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest2{
	
	@Test
	public void doLogin() {
		Assert.assertEquals("hsgdhg", driver.getTitle());
	}
}
