package customListener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class RetryListener implements IAnnotationTransformer{
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		//Class<? extends IRetryAnalyzer> analyzer=annotation.getRetryAnalyzerClass();
		IRetryAnalyzer analyzer=annotation.getRetryAnalyzer();
		if(analyzer==null) {
			//((Object) annotation).setRetryAnalyzer(RetryFailedTestCases.class);
			annotation.setRetryAnalyzer(RetryFailedTestCases.class);
		}
	}
}