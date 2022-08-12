package com.crm.Sdet.campagin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import comcast.vtiger.genericUtility.BaseClass;
import comcast.vtiger.genericUtility.Excel_Utility;
import comcast.vtiger.genericUtility.Java_Utility;
import comcast.vtiger.genericUtility.Property_Utility;
import comcast.vtiger.genericUtility.WebDriver_Utility;
import comcast.vtiger.object.Repository.CampaignValidation;
import comcast.vtiger.object.Repository.CampaignsPage;
import comcast.vtiger.object.Repository.CreateCampainsPage;
import comcast.vtiger.object.Repository.HomePage;
@Listeners(comcast.vtiger.genericUtility.ListnerImplementationClass.class)
public class CreateCampaignTest extends BaseClass
{ 
	
//	@Test
//	public void createContact()
//	{
//		System.out.println("contact Created");
//	}
	
	
	
	@Test(groups= {"smokeTest","regressionTest"})
	public void createProduct() throws Throwable 
	{
	

	   
	    Java_Utility jlib=new Java_Utility();
	    Excel_Utility elib=new Excel_Utility();
	    WebDriver_Utility wlib=new WebDriver_Utility();
	    driver.manage().window().maximize();
   		wlib.waitForPageToLoad(driver);

 	    HomePage homepage=new HomePage(driver);
 	    

	    WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));

	    wlib.mouseHoverOnElement(driver, ele1);
	    homepage.campaignsModule();
	    CampaignsPage campaignspage=new CampaignsPage(driver);
	    campaignspage.campaigns();
	    
		int RanNum=jlib.getRandomNum();
		String orgName1=elib.getDataFromExcel("Campaign",1,0)+RanNum;
			
		CreateCampainsPage createcampainspage=new CreateCampainsPage(driver);
		createcampainspage.createCampaignsPage(orgName1);
//		 Assert.assertEquals(false,true);
		CampaignValidation actualCampaignName=new CampaignValidation(driver);
		String actualCampaignData = actualCampaignName.actualCampaignName();
		Assert.assertEquals(actualCampaignData.contains(orgName1),true);
       
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		wlib.mouseHoverOnElement(driver, ele);
		homepage.signout();
		driver.quit();
		
		
		
		
	}

}
