package com.crm.Sdet.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import comcast.vtiger.genericUtility.BaseClass;
import comcast.vtiger.genericUtility.Excel_Utility;
import comcast.vtiger.genericUtility.Java_Utility;
import comcast.vtiger.genericUtility.Property_Utility;
import comcast.vtiger.genericUtility.WebDriver_Utility;
import comcast.vtiger.object.Repository.CreateProductPage;
import comcast.vtiger.object.Repository.HomePage;
import comcast.vtiger.object.Repository.LoginPage;
import comcast.vtiger.object.Repository.ProductPage;

public class CreateProductDeleteProductTest extends BaseClass
{
	@Test(groups= {"smokeTest","regressionTest"})
	public void createProductDeleteProduct() throws Throwable 
	{
		 
  	     Property_Utility plib=new Property_Utility();
  	     Java_Utility jlib=new Java_Utility();
  	     Excel_Utility elib=new Excel_Utility();
  	     WebDriver_Utility wlib=new WebDriver_Utility();
	   
 	     HomePage homepage=new HomePage(driver);
 	     homepage.productModule();
 	  
 	     ProductPage productpage=new ProductPage(driver);
 	     productpage.product();
 	

		 int RanNum = jlib.getRandomNum();

		 String orgName=elib.getDataFromExcel("Product",1,0)+RanNum;
		
		CreateProductPage createproductpage=new CreateProductPage(driver);
		createproductpage.createProductPage(orgName);
		createproductpage.getSaveButton();
		createproductpage.deleteProduct();
		wlib.switchToAlertAndAccept(driver);



	    WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wlib.mouseHoverOnElement(driver, ele);
        homepage.signout();
		
		driver.quit();
	}

}
