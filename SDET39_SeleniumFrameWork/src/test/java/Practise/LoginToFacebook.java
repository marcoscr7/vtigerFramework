package Practise;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginToFacebook 
{
	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis=new FileInputStream("./data/CommonFile.properties");
		Properties p=new Properties();
		p.load(fis);
		String URL=p.getProperty("url2");
		String Name=p.getProperty("name");
		String Password=p.getProperty("password1");
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		driver.findElement(By.id("email")).sendKeys(Name);
		driver.findElement(By.id("pass")).sendKeys(Password);
		driver.findElement(By.name("login")).click();
		
	}

}
