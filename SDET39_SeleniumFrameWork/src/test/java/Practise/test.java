package Practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import comcast.vtiger.genericUtility.Excel_Utility;
import comcast.vtiger.genericUtility.Java_Utility;
import comcast.vtiger.genericUtility.Property_Utility;
import comcast.vtiger.genericUtility.WebDriver_Utility;

public class test
{

	public static void main(String[] args) throws Throwable {
		
		 
		 
		 //GenericLib methods object creation
		WebDriver driver=new ChromeDriver();
 	   Property_Utility plib=new Property_Utility();
 	   Java_Utility jlib=new Java_Utility();
 	   Excel_Utility elib=new Excel_Utility();
 	   WebDriver_Utility wlib=new WebDriver_Utility(); 
		 
		
		 driver.manage().window().maximize();
		 wlib.waitForPageToLoad(driver);
		 String Url=plib.getPropertyKeyValue("url");
		 String UN=plib.getPropertyKeyValue("username");
		 String PW=plib.getPropertyKeyValue("password");
		 driver.get(Url);
		 driver.findElement(By.name("user_name")).sendKeys(UN);
		 driver.findElement(By.name("user_password")).sendKeys(PW);
		 driver.findElement(By.id("submitButton")).click();
		 driver.findElement(By.xpath("(//a[text()='Products'])[1]")).click();
		 driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		 
		//Java Utility Used
		 int RanNum = jlib.getRandomNum();
		 //Excel Utility Used
		 String productName = elib.getDataFromExcel("Product",1,0)+RanNum;
		   
		 System.out.println(productName);
			
			driver.findElement(By.name("productname")).sendKeys(productName);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			WebElement element = driver.findElement(By.xpath("//a[text()='More']"));

			//mouseOveronElement used
			 wlib.mouseHoverOnElement(driver,element);
				
			 driver.findElement(By.name("Campaigns")).click();
				
				driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();	
				driver.findElement(By.xpath("//img[@title='Select']")).click();
				
				String campaignName = elib.getDataFromExcel("Campaign",2,0)+RanNum;
				System.out.println(campaignName);
				
				driver.findElement(By.name("campaignname")).sendKeys(campaignName);
				driver.findElement(By.xpath("//img[@title='Select']")).click();
				Thread.sleep(3000);
				//Window Switching
				wlib.switchToWindow(driver,"Products&action");
				



					driver.findElement(By.name("search")).click();
					driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
					//Window switching
					wlib.switchToWindow(driver,"Campaigns&action");
					
					driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
					String actData = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
					
					if(actData.contains(campaignName))
					{
						System.out.println("pass");
					}
					else
					{
						System.out.println("Fail");
					}
					
					WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

					
					wlib.mouseHoverOnElement(driver,ele);
						
					driver.findElement(By.linkText("Sign Out")).click();

					 
					 driver.close();
				
				}
				
			
				
				

	}