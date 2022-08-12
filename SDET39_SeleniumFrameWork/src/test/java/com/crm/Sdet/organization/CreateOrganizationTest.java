package com.crm.Sdet.organization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import comcast.vtiger.genericUtility.BaseClass;
import comcast.vtiger.genericUtility.Excel_Utility;
import comcast.vtiger.genericUtility.Java_Utility;
import comcast.vtiger.genericUtility.Property_Utility;
import comcast.vtiger.genericUtility.WebDriver_Utility;
import comcast.vtiger.object.Repository.CreateOrganizationsPage;
import comcast.vtiger.object.Repository.HomePage;
import comcast.vtiger.object.Repository.OrganizationValidation;
import comcast.vtiger.object.Repository.OrganizationsPage;

public class CreateOrganizationTest extends BaseClass
{
	
//	@Test
//	public void modifyContact()
//	{
//		System.out.println("Contact Modified");
//		
//	}
	
	
	@Test(groups= {"smokeTest","regressionTest"})
	public void createOrganization() throws Throwable 
	{

  	     Property_Utility plib=new Property_Utility();
  	     Java_Utility jlib=new Java_Utility();
  	     Excel_Utility elib=new Excel_Utility();
  	     WebDriver_Utility wlib=new WebDriver_Utility(); 
 		 driver.manage().window().maximize();
 		 wlib.waitForPageToLoad(driver);


 	   HomePage homepage=new HomePage(driver);
 	   homepage.organizationsModule();
 	    
 	    
 	    OrganizationsPage organizationspage=new OrganizationsPage(driver);
 	    organizationspage.organizations();
 	    
 	  

		int RanNum = jlib.getRandomNum();

		String orgName=elib.getDataFromExcel("Organization",1,0)+RanNum;
		CreateOrganizationsPage createorganizations=new CreateOrganizationsPage(driver);
		createorganizations.createOrganizationsPage(orgName);
		createorganizations.getSaveButton();
		OrganizationValidation actualOrganizationName=new OrganizationValidation(driver);
		String actualOrganizationData = actualOrganizationName.actualOrganizationName();
		Assert.assertEquals(actualOrganizationData.contains(orgName),true);

		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

		wlib.mouseHoverOnElement(driver, ele);
		homepage.signout();

		driver.quit();
		
		
		
	}

}
