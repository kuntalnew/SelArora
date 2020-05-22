package customListener;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustListener implements ITestListener{

	  public void onTestFailure(ITestResult result) {
		  System.setProperty("org.uncommons.reportng.escape-output", "false");
		  Reporter.log("The test case is failed: "+result.getName());
		  Reporter.log("<a href=\"E:\\Selenium\\SeleniumBasicsWithMaven\\screenshot\\error.png\" target=\"_blank\">Screenshot here </a>");
		  Reporter.log("<br>");
		  //Reporter.log("<img src=\"E:\\Selenium\\SeleniumBasicsWithMaven\\screenshot\\error.png\" height=200 width=200 /img>");
		  Reporter.log("<a href=\"E:\\Selenium\\SeleniumBasicsWithMaven\\screenshot\\error.png\" target=\"_blank\"><img src=\"E:\\Selenium\\SeleniumBasicsWithMaven\\screenshot\\error.png\" height=200 width=200 /></a>");

	  }
}
