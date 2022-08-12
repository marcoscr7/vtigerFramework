package comcast.vtiger.genericUtility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class Excel_Utility
{
	/**
	 * This method is used to fetch 
	 */
	public String getDataFromExcel(String sheetName,int RowNumber,int cellNumber) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./data/WorkBook1.xlsx");
		Workbook book=WorkbookFactory.create(fis);
//		Sheet sheet=book.getSheet(sheetName);
//		Row row=sheet.getRow(RowNumber);
//		Cell cell=row.getCell(cellNumber);
//		String cellValue=cell.getStringCellValue();
		
		DataFormatter format=new DataFormatter();
		return format.formatCellValue(book.getSheet(sheetName).getRow(RowNumber).getCell(cellNumber));
		
		
	}

}
