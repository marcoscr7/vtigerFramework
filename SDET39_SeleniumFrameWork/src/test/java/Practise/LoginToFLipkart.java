package Practise;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginToFLipkart 
{
	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis=new FileInputStream("./data/CommonFile.properties");
		Properties p=new Properties();
		p.load(fis);
		String URL=p.getProperty("url3");
		String Mobile=p.getProperty("mobileno");
		String Password=p.getProperty("pass");
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		driver.findElement(By.xpath("(//input[@autocomplete='off'])[2]")).sendKeys(Mobile);
		driver.findElement(By.xpath("(//input[@autocomplete='off'])[3]")).sendKeys(Password);
		driver.findElement(By.xpath("(//span[text()='Login'])[2]")).click();
		
	}

}
