package pagesource;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product {
	
	WebDriver driver;
	private static final Logger log = LogManager.getLogger(Product.class);
	

	public Product(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='inventory_item_name ']")
	List<WebElement> productlist;

	@FindBy(xpath = "//div[@class='inventory_item_price']/following::button")
	List<WebElement> addtocartlist;

	@FindBy(name = "add-to-cart-sauce-labs-backpack")
	WebElement addbackpack;

	@FindBy(xpath = "//span[@class='title']")
	WebElement producttitle;

	@FindBy(xpath = "//div[@class='inventory_item_name']")
	WebElement cartproduct;

	public String producttitlecheck() {
		return producttitle.getText();
	}

	public void productlistmethod() {
		System.out.println("===== Product List =====");
		for (WebElement product : productlist)
			System.out.println(product.getText());
	}

	public Cart addproduct(String productname) {

		for (WebElement cart : addtocartlist) {

			String desiredproduct = cart.getAttribute("name");

			if (desiredproduct.contains(productname)) {
				System.out.println(desiredproduct);
				cart.click();
			}
		}

		return new Cart(driver);
	}

}
