package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.BaseTest;

public class ExtentManager extends BaseTest {
	
	public static ExtentReports extent;
	
	  public static ExtentReports getObject() {
		  if(extent==null) {
			  String timestamp=new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			  String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport_" + timestamp + ".html";
			  ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
			  spark.config().setTheme(Theme.DARK);
			  spark.config().setDocumentTitle("Automation Test Report");
			  spark.config().setReportName("New Ecommerce Sel-TestNG Framework");
			  
			  extent=new ExtentReports();
			  extent.attachReporter(spark);
			  
			  extent.setSystemInfo("Tester", "Mugilarasi");
			  extent.setSystemInfo("Browser", "chrome");
			  extent.setSystemInfo("OS", System.getProperty("os.name"));
		  }
		  return extent;
	  }

}
