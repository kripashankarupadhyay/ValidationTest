package common;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static XSSFRow Row;

	// open excel file
	public static void setExcelFile(String Path, String SheetName) throws Exception {

		try {

			// Open the Excel file

			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

		} catch (Exception e) {

			System.out.println("File not found");
			throw (e);

		}

	}

	// Get data from excel
	public static String getCellData(int RowNum, int ColNum) throws Exception {

		try {

			int row = ExcelWSheet.getLastRowNum();
			System.out.println("Total Row in sheet" + row);

			// int col=ExcelWSheet.getColumn();

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			String CellData = Cell.getStringCellValue();
			System.out.println(CellData);

			return CellData;

		} catch (Exception e) {
			System.out.println("Error in getcell data");
			return "";

		}

	}
}
