package customListener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTestCases implements IRetryAnalyzer{
	int retryCount=0;
	int maxRetryCount=3;

	public boolean retry(ITestResult result) {
		if(retryCount < maxRetryCount) {
			System.out.println("Retrying test "+result.getName()+" with status "+getResultStatusName(result.getStatus())+" for the "+(retryCount+1)+ " times.");
			retryCount++;
			return true;
		}
		return false;
	}
	
	public String getResultStatusName(int status) {
		String resultName=null;
		if(status==1) {
			resultName="SUCCESS";		
		}else if(status==2) {
			resultName="FAILURE";
		}else if(status==3) {
			resultName="SKIP";
		}
		return resultName;
	}
}
