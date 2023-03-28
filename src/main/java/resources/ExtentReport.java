package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	public ExtentReports report;
	public String sourcePath;
	
	public ExtentReports getExtentReport()
	{
		sourcePath = System.getProperty("user.dir")+"\\report\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(sourcePath);
		reporter.config().setReportName("Test Result");
		reporter.config().setDocumentTitle("Test Result");
		
		report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Tester", "Agnivo");
		
		return report;
	}

}
