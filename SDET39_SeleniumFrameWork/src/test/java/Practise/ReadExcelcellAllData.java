package Practise;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcelcellAllData 
{
	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis=new FileInputStream("./data/Countryname.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Country");
		int count=sh.getLastRowNum();
		
		
		for(int i=1;i<count;i++) 
		{
			Row row=sh.getRow(i);
			String firstcoldata=row.getCell(0).getStringCellValue();
			String secondcoldata=row.getCell(1).getStringCellValue();
			System.out.println("Capital of"+"\t"+firstcoldata+"\t"+"is"+secondcoldata);
		}
				
	}

}
