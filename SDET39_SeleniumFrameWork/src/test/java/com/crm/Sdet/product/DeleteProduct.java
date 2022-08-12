package com.crm.Sdet.product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DeleteProduct
{
	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis=new FileInputStream("./data/CommonFile.properties");
		Properties p=new Properties();
		p.load(fis);
		String URL=p.getProperty("url");
		String UN=p.getProperty("username");
		String Pass=p.getProperty("password");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(Pass);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.name("selected_id")).click();
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		Alert a = driver.switchTo().alert();
		a.accept();
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions ac=new Actions(driver);
		ac.moveToElement(ele).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit();
	}

}
