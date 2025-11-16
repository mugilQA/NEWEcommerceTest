package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pagesource.Cart;
import pagesource.CheckOut;
import pagesource.Product;
import utils.FetchExcel;

public class CheckOutApplication extends BaseTest {

	@Test

	public void inputdata() throws IOException {

		Product productobj = logobj.login(configred.getProperty("username"), configred.getProperty("password"));
		Cart cartobj = productobj.addproduct("backpack");
		Assert.assertEquals(cartobj.cartcheck(), "Sauce Labs Backpack");
		CheckOut checkoutobj = cartobj.checkout();

		String filepath = configred.getProperty("inputdata");
		String Sheetname = configred.getProperty("sheetName");
		FetchExcel.setExcelFile(filepath, Sheetname);
		String fname = null;
		String lname = null;
		String pcode = null;

		int totalrow = FetchExcel.getRowCount();

		fname = FetchExcel.getCellData(0, 1);
		lname = FetchExcel.getCellData(1, 1);
		pcode = FetchExcel.getCellData(2, 1);

//System.out.println(fname + lname+pcode);

		checkoutobj.inputdata(fname, lname, pcode);
		String msg= checkoutobj.orderconfirmation();
		Assert.assertTrue(msg.equalsIgnoreCase("Thank you for your order!"));
		log.info("CheckoutApplication completed");

	}

}
