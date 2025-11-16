package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pagesource.Cart;
import pagesource.Product;
import utils.ResuseUtility;

public class ProductApplication extends BaseTest {

	@Test
	public void product() {
		Product productobj = logobj.login(configred.getProperty("username"), configred.getProperty("password"));
		Assert.assertEquals(productobj.producttitlecheck(), "Products");
		productobj.productlistmethod();
		Cart cartobj = productobj.addproduct("backpack");
		log.info("ProductApplication completed");

	}

}
