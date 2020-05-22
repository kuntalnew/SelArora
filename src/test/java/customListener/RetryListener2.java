//This code is not working. This is implementation in Testng 7.1.0

package customListener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class RetryListener2 implements IAnnotationTransformer{
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		//Class<? extends IRetryAnalyzer> analyzer=annotation.getRetryAnalyzerClass();
		Class<? extends IRetryAnalyzer> analyzer=annotation.getRetryAnalyzerClass();
		if(analyzer==null) {
			//((Object) annotation).setRetryAnalyzer(RetryFailedTestCases.class);
			annotation.setRetryAnalyzer(RetryFailedTestCases.class);
		}
	}
}