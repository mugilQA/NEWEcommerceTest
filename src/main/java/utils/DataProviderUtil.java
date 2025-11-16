package utils;

import java.io.IOException;
import java.util.Arrays;

import org.testng.annotations.DataProvider;

import base.BaseTest;

public class DataProviderUtil extends BaseTest{
	
	@DataProvider(name="UserDetail")
	 public static Object[][] getUserData() throws IOException {
		String filepath= configred.getProperty("userdetail");
		String Sheetname=configred.getProperty("usersheetName");
		FetchExcel.setExcelFile(filepath, Sheetname);
		
		int totalRow=FetchExcel.getRowCount();
		int totalcol=2;
		
		 Object[][] data = new Object[totalRow - 1][totalcol]; //skip the header row
		 
		 for (int i = 1; i < totalRow; i++) {
	            data[i-1][0] = FetchExcel.getCellData(i, 0); //username column
	            data[i-1][1] = FetchExcel.getCellData(i, 1); //password column
		 }
		 FetchExcel.closeWorkbook();
	      // System.out.println(Arrays.deepToString(data));
		 return data;

	}
}
