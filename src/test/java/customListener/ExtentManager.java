package customListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	private static ExtentReports report;
	
	public static ExtentReports createInstance(String fileName) {
		ExtentSparkReporter htmlReporter=new ExtentSparkReporter(fileName);
		// htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"\\screen\\"+"Extent reports.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle(fileName);
		htmlReporter.config().setReportName(fileName);
		htmlReporter.config().setTheme(Theme.STANDARD);
		//htmlReporter.config().setTheme(Theme.DARK);
		report=new ExtentReports();
		report.attachReporter(htmlReporter);
		report.setSystemInfo("Automation tester", "Kuntal Basu");
		report.setSystemInfo("Organization", "Mphasis");
		report.setSystemInfo("Build Number", "R12");
		return report;		
	}
}