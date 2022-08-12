package Practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginToVtiger
{
	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis=new FileInputStream("./data/CommonFile.properties");
		Properties p=new Properties();
		p.load(fis);
		String URL=p.getProperty("url");
		String UserName=p.getProperty("username");
		String Password=p.getProperty("password");
		
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UserName);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
		
		
	}

}
