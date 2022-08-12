package com.crm.Sdet.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import comcast.vtiger.genericUtility.BaseClass;
import comcast.vtiger.genericUtility.Excel_Utility;
import comcast.vtiger.genericUtility.Java_Utility;
import comcast.vtiger.genericUtility.Property_Utility;
import comcast.vtiger.genericUtility.WebDriver_Utility;
import comcast.vtiger.object.Repository.CreateProductPage;
import comcast.vtiger.object.Repository.HomePage;
import comcast.vtiger.object.Repository.ProductPage;
import comcast.vtiger.object.Repository.ProductValidation;


public class CreateProductTest extends BaseClass
{
	@Test(groups= {"smokeTest","regressionTest"})
	public void createProduct() throws Throwable 
	{

  	     Property_Utility plib=new Property_Utility();
  	     Java_Utility jlib=new Java_Utility();
  	     Excel_Utility elib=new Excel_Utility();
  	     WebDriver_Utility wlib=new WebDriver_Utility();
  	     
 		 driver.manage().window().maximize();
 		 wlib.waitForPageToLoad(driver);
 	    
 	    HomePage homepage=new HomePage(driver);
 	    homepage.productModule();
 	   
 	    ProductPage productpage=new ProductPage (driver);
 	    productpage.product();
 	     

		int RanNum = jlib.getRandomNum();
		String orgName=elib.getDataFromExcel("Product",1,0)+RanNum;
		CreateProductPage createproduct=new CreateProductPage(driver);
		createproduct.createProductPage(orgName);
		createproduct.getSaveButton();
	
		ProductValidation actualProductName=new ProductValidation(driver);
		String actualProductData = actualProductName.actualProductName();
		Assert.assertEquals(actualProductData.contains(orgName),true);

		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

		wlib.mouseHoverOnElement(driver,ele);
		homepage.signout();
		driver.quit();
		

		
	}

}
