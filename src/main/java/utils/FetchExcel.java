package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FetchExcel {
	
	private static XSSFWorkbook workbook;
	private static Sheet worksheet;
	
	public static void setExcelFile(String filePath, String sheetName) throws IOException {
		FileInputStream file=new FileInputStream(filePath);
		workbook= new XSSFWorkbook(file);
		worksheet=workbook.getSheet(sheetName);
	}

	public static String getCellData(int rowNum, int colNum) {
		Row row = worksheet.getRow(rowNum);
        Cell cell = row.getCell(colNum);
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell);
	}
	
	
	   public static int getRowCount() {
	        return worksheet.getPhysicalNumberOfRows();
	    }

	    public static void closeWorkbook() throws IOException {
	        workbook.close();
	        
	    }
}
