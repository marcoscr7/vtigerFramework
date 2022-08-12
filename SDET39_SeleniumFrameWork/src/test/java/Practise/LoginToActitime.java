package Practise;

import java.io.FileInputStream;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginToActitime
{
	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis=new FileInputStream("./data/CommonFile.properties");
		Properties p=new Properties();
		p.load(fis);
		String URL=p.getProperty("url1");
		String UserName=p.getProperty("username1");
		String Password=p.getProperty("password1");
		
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		driver.findElement(By.name("username")).sendKeys(UserName);
		driver.findElement(By.name("pwd")).sendKeys(Password);
		driver.findElement(By.linkText("Login")).click();
		
		
	}
	

}
