package base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import pagesource.Login;
import utils.ConfigReader;
import utils.ResuseUtility;

public class BaseTest {
	
	static {
        System.setProperty("log4j.configurationFile", "src/main/java/resources/log4j2.xml");
    }
	
	public static final Logger log = LogManager.getLogger(BaseTest.class);

	public WebDriver driver;
	public Login logobj;
	public static ConfigReader configred;
	public ResuseUtility Resuseuti;
	 public SoftAssert softAssert;

	String browsername;

	public WebDriver intializeDriver() {

		

		configred = new ConfigReader();
		browsername = configred.getProperty("browser");

		if (browsername.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--disable-save-password-bubble");
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);
		}
		if (browsername.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();

		}
		if (browsername.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		return driver;
	}

	@BeforeMethod
	public void setup() {
		driver = intializeDriver();
		Resuseuti = new ResuseUtility(driver);
		   log.info("Browser launched successfully");
		logobj = new Login(driver);
		softAssert = new SoftAssert();
		logobj.launchURL(configred.getProperty("url"));
	}

	@AfterMethod
	public void teardown() {
		if (driver != null)
			driver.quit();
		 log.info("========== Test Completed ==========");
	}

}
