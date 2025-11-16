package utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResuseUtility {

	WebDriver driver;
	
	public  ResuseUtility(WebDriver driver) {
		this.driver=driver;
	}
	
	public void alerthandle() {
		Alert alert=driver.switchTo().alert();
		alert.accept();
	
	}
	
	public void waitforElement(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public String takeScreenshot(String testName, WebDriver driver) {
		   if (driver == null) {
		        throw new IllegalStateException("Driver is not initialized for screenshot capture!");
		    }
		
		 String filePath = System.getProperty("user.dir") + "/reports/screenshots/" + testName + ".png";
	        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        try {
	        	FileUtils.copyFile(src, new File(filePath));
	        }catch(IOException e) {
	        	 e.printStackTrace();
	        }
	        return filePath;
		
	}

	
}
