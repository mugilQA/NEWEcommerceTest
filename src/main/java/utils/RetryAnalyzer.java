package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	    private int retryCount = 0;             // Counter for retries
	    private static final int maxRetryCount = 2; // Number of times to retry

	    @Override
	    public boolean retry(ITestResult result) {
	        if (retryCount < maxRetryCount) {
	            retryCount++;
	            System.out.println("Retrying test " + result.getName() + 
	                               " for the " + retryCount + " time(s).");
	            // Set the retry count in the test result (so listener can read it)
	            result.setAttribute("retryCount", retryCount);
	            return true; // Tells TestNG to rerun the test
	        }
	        return false; // No more retries
	    }
	}


