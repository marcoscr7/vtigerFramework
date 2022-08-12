package Practise;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class LoginToActitimeExcelSheet 
{
	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis=new FileInputStream("./data/WorkBook1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet=wb.getSheet("Sheet1");
		int count=sheet.getLastRowNum();
		Row row=sheet.getRow(1);
		Cell cell=row.getCell(0);
		String data=cell.getStringCellValue();
		System.out.println(data);
	}

}
