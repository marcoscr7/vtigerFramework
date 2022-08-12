package Practise;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataFromWQorkBook 
{
	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis=new FileInputStream("./data/WorkBook1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet1");
		Row row=sh.createRow(4);
		Cell cell=row.createCell(4);
		cell.setCellValue("Vikas");
		FileOutputStream fos=new FileOutputStream("./data/WorkBook1.xlsx");
		wb.write(fos);
		wb.close();
		
	}

}
