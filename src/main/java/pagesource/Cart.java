package pagesource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart {
	private static final Logger log = LogManager.getLogger(Cart.class);
	
	WebDriver driver;
	
	public Cart(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	WebElement cart;
	
	@FindBy(xpath="//div[@class='inventory_item_name']")
	WebElement cartproduct;
	
	@FindBy(xpath="//span[@class='title']")
	WebElement carttitle;
	
	@FindBy(id="checkout")
	WebElement checkout;
	
	public String carttitlecheck() {
		return carttitle.getText();
	}
	
	public String cartcheck() {
		cart.click();
		String productname=cartproduct.getText();
		return productname;
	}
	
	public CheckOut checkout() {
		checkout.click();
		System.out.println("Navigated to Checkout Page");
		return new CheckOut(driver);
	}
}
