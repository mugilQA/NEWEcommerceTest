package pagesource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class Login {
	private static final Logger log = LogManager.getLogger(Login.class);
	
	
	WebDriver driver;
	
	public Login(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id= "user-name")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id= "login-button")
	WebElement submit;
	
	@FindBy(className="title")
	WebElement pagetitle;
	
	public void launchURL(String url) {
		driver.get(url);
		
	}
	
	public Product login(String user, String pwd) {
		username.sendKeys(user);
		password.sendKeys(pwd);
		submit.click();
		return new Product(driver);
	}
	
	public String loginvalidation() {
		return pagetitle.getText();
	}
	
	
	
}
