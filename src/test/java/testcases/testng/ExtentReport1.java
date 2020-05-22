package testcases.testng;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport1 {
	
	public ExtentSparkReporter htmlReporter;
	public ExtentReports report;
	public ExtentTest test;
	
	@BeforeTest
	public void setReports() {
		htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"\\screen\\"+"Extent reports.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Maven automation reports");
		htmlReporter.config().setReportName("Automation test resuts");
		//htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTheme(Theme.DARK);
		report=new ExtentReports();
		report.attachReporter(htmlReporter);
		report.setSystemInfo("Automation tester", "Kuntal Basu");
		report.setSystemInfo("Organization", "Mphasis");
		report.setSystemInfo("Build Number", "R12");
	}
	
	@AfterTest
	public void endReports() {
		report.flush();
	}
	
	@Test
	public void doPass(){
		test=report.createTest("Passing test");
		Assert.assertEquals(true, true);
		
	}
	
	@Test
	public void doFail() {
		test=report.createTest("Failing test");
		Assert.fail("The test case is failed");
		
	}
	
	@Test
	public void doSkip() {
		test=report.createTest("Skipping test");
		throw new SkipException("Skipping the test case");
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			String methodName=result.getMethod().getMethodName();
			String logText="<br>"+"METHOD: "+methodName.toUpperCase()+" FAILED"+"</br>";
			Markup m=MarkupHelper.createLabel(logText, ExtentColor.RED);
			test.fail(m);
		}else if(result.getStatus()==ITestResult.SUCCESS) {
			String methodName=result.getMethod().getMethodName();
			String logText="<br>"+"METHOD: "+methodName.toUpperCase()+" PASSED"+"</br>";
			Markup m=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
			test.pass(m);
		}else if(result.getStatus()==ITestResult.SKIP) {
			String methodName=result.getMethod().getMethodName();
			String logText="<br>"+"METHOD: "+methodName.toUpperCase()+" SKIPPED"+"</br>";
			Markup m=MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
			test.skip(m);
		}
	}
}
