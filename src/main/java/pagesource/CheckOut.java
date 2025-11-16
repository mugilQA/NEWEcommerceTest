package pagesource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ResuseUtility;

public class CheckOut extends ResuseUtility {
	private static final Logger log = LogManager.getLogger(CheckOut.class);
	
	WebDriver driver;
	
	public CheckOut(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="firstName")
	WebElement firstname;
	
	@FindBy(name="lastName")
	WebElement lastname;
	
	@FindBy(name="postalCode")
	WebElement postalcode;
	
	@FindBy(id="continue")
	WebElement ContinueButton;
	
	@FindBy(id="finish")
	public WebElement finishbutton;
	
	@FindBy(xpath="//h2[@class='complete-header']")
	WebElement successmsg;
	
	
	public void inputdata(String fname, String lname, String pcode) {
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		postalcode.sendKeys(pcode);
		ContinueButton.click();
	}
	
	public String orderconfirmation() {
		waitforElement(finishbutton);
		finishbutton.click();
		return successmsg.getText();
		
	}
	
	
	
		
	

}
