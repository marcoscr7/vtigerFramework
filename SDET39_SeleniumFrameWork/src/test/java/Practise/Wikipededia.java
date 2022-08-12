package Practise;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Wikipededia 
{
	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis=new FileInputStream("./data/Wikipedia.properties");
		Properties p=new Properties();
		p.load(fis);
		String Url=p.getProperty("url");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Url);
		FileInputStream fis1=new FileInputStream("./data/Countryname.xlsx");
		Workbook book=WorkbookFactory.create(fis1);
		Sheet sheet=book.getSheet("Country");
		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++)
		{
			Row row=sheet.getRow(i);
			Cell cell=row.getCell(0);
			String data = cell.getStringCellValue();
		    driver.findElement(By.name("search")).sendKeys(data);
			driver.findElement(By.xpath("//i[text()='Search']")).click();
			WebElement capital = driver.findElement(By.xpath("(//tr//th[text()='Capital']//following-sibling::td[1]//a)[1]"));
			System.out.println("Country : "+data+" || Capital : "+capital.getText());
			driver.navigate().back();
			driver.findElement(By.name("search")).clear();
		    
		}
		
		driver.close();
		
	}

}
