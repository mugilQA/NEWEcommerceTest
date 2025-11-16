package tests;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pagesource.Login;
import pagesource.Product;
import utils.DataProviderUtil;

public class LoginApplication extends BaseTest{
	
	
	@Test
	public void login() {
		Product  productobj=logobj.login(configred.getProperty("username"), configred.getProperty("password"));
		String currentURL=driver.getCurrentUrl();
		Assert.assertTrue(currentURL.contains("saucedemo"),"Login failed!");
		log.info("LoginApplication completed");
	}

	@Test(dataProvider="UserDetail",dataProviderClass=DataProviderUtil.class)
	public void loginfailure(String username, String password) {
		logobj.login(username, password);
		
		softAssert.assertTrue(logobj.loginvalidation().contains("Products"), "Login Failed!");
		 log.info("Invalid login test completed with soft assertions.");
		 softAssert.assertAll();
	
	}
}
