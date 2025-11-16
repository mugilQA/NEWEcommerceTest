package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BaseTest;

public class ExtentTestListener extends BaseTest implements ITestListener {
	
	ExtentReports extent = ExtentManager.getObject();
    ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    
    public void onTestStart(ITestResult result) {
    	ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }
    
    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, "Test Passed: " + result.getMethod().getMethodName());
    }
	
    
    public void onTestFailure(ITestResult result) {
    	 Object retryCountObj = result.getAttribute("retryCount");
         int retryCount = (retryCountObj != null) ? (int) retryCountObj : 0;
         System.out.println("   Retry attempt: " + retryCount);
        test.get().log(Status.FAIL, "Test Failed: " + result.getThrowable());
        
        Object currentClass = result.getInstance();
        WebDriver driver = ((base.BaseTest) currentClass).driver;
        
        String screenshot=((base.BaseTest) currentClass).Resuseuti.takeScreenshot(result.getMethod().getMethodName(), driver);
        test.get().addScreenCaptureFromPath(screenshot);
    }
    
    public void onTestSkipped(ITestResult result) {
        test.get().log(Status.SKIP, "Test Skipped: " + result.getMethod().getMethodName());
    }
    @Override
    public void onFinish(ITestContext context) {
        extent.flush(); // Generate report after all tests
    }
    

}
