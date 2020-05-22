package customListener;

import java.util.Arrays;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ExtentListener implements ITestListener{
	static Date d=new Date();
	static String fileName="Extent_"+d.toString().replace(":", "_").replace(" ", "_")+".html";
	private static ExtentReports report=ExtentManager.createInstance(System.getProperty("user.dir")+"\\screenSS\\"+fileName);
	public static ThreadLocal<ExtentTest> testReport=new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) {
		ExtentTest test=report.createTest(result.getTestClass().getName()+"     @TestCase : "+result.getMethod().getMethodName());
		testReport.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"TEST CASE: "+methodName.toUpperCase()+" PASSED"+"</b>";
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		testReport.get().pass(m);
	}
	
	public void onTestFailure(ITestResult result) {
		String exceptionMessage=Arrays.toString(result.getThrowable().getStackTrace());
		testReport.get().fail("<details>"+"<summary>"+"<b>"+"<font color="+"red>"+"Exception occured: Click here"
		+"</font>"+"</b>"+"</summary>"+exceptionMessage.replaceAll(",","<br>")+ "</details>"
		+" \n");
		String failureLog="TEST CASE FAILED";
		Markup m=MarkupHelper.createLabel(failureLog, ExtentColor.RED);
		testReport.get().log(Status.FAIL,m );
	}
	
	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"METHOD: "+methodName.toUpperCase()+" SKIPPED"+"</b>";
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		testReport.get().skip(m);
	}
	
	public void onFinish(ITestContext context) {
		if(report!=null) {
			report.flush();
		}
	}
}
