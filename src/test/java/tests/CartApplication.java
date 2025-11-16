package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pagesource.Cart;
import pagesource.Product;

public class CartApplication extends BaseTest{
	
	
	@Test
	public void checkout() {
		 Product productobj=logobj.login(configred.getProperty("username"), configred.getProperty("password"));
		 Cart cartobj = productobj.addproduct("backpack");
		Assert.assertEquals(cartobj.cartcheck(),"Sauce Labs Backpack");
		Assert.assertEquals(cartobj.carttitlecheck(), "Your Cart");
		cartobj.checkout();
		log.info("CartApplication completed");
	}

}
