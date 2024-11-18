package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	private FileInputStream fi =null;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	public ExcelUtility(String path , String sheetname) {
		//Initialize the excel to be used
		try {
			fi = new FileInputStream(path);
			workbook = new XSSFWorkbook(fi);
			sheet = workbook.getSheet(sheetname);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	//RowCount in the current sheet
	public int getRowCount() {
		return getWs().getPhysicalNumberOfRows();
	}
	//ColumnCount in the current sheet
	public int getColumnCount() {
		return getWs().getRow(0).getPhysicalNumberOfCells();
	}
	//Returns the current Worksheet
	public XSSFSheet getWs() {
		return sheet;
	}
	//Used to get the value from the cell
	public Object getData(int row , int col) {
		Object cellData = null;
		cellData = getWs().getRow(row).getCell(col);
		return cellData;
	}
}
