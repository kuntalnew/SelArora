package customListener;

import java.io.IOException;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import testcases.testng.MonitoringMail;
import testcases.testng.TestConfig;
import testcases.testng.TestUtil;

public class CustomtListenerNew extends TestUtil implements ITestListener{

	  public void onTestFailure(ITestResult result) {
		  String methodName=result.getName().toString().trim();
		  try {
			  TestUtil.captureScreenshot(methodName);
		  }catch(IOException ex) {
			  ex.printStackTrace();
		  } 
	  }
	  
	  public void onFinish(ITestContext context) {
		  TestUtil.zip(System.getProperty("user.dir")+"\\screens\\");
		  MonitoringMail mail=new MonitoringMail();
		  try {
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody, TestConfig.attachmentPath, TestConfig.attachmentName);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
	}
}