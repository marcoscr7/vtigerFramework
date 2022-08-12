package com.crm.Sdet.campagin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import comcast.vtiger.genericUtility.BaseClass;
import comcast.vtiger.genericUtility.Excel_Utility;
import comcast.vtiger.genericUtility.Java_Utility;
import comcast.vtiger.genericUtility.Property_Utility;
import comcast.vtiger.genericUtility.WebDriver_Utility;
import comcast.vtiger.object.Repository.CampaignValidation;
import comcast.vtiger.object.Repository.CampaignsPage;
import comcast.vtiger.object.Repository.CreateCampainsPage;
import comcast.vtiger.object.Repository.CreateProductPage;
import comcast.vtiger.object.Repository.HomePage;
import comcast.vtiger.object.Repository.LoginPage;
import comcast.vtiger.object.Repository.ProductPage;
import comcast.vtiger.object.Repository.Product_PopUp;


public class CreateCampaignWithProductTest extends BaseClass
{
	@Test(groups= {"smokeTest","regressionTest"})
       public void createProductWithProduct() throws Throwable 
       {

    	  
    	   Java_Utility jlib=new Java_Utility();
    	   Excel_Utility elib=new Excel_Utility();
    	   WebDriver_Utility wlib=new WebDriver_Utility(); 
   		  driver.manage().window().maximize();
   		  wlib.waitForPageToLoad(driver);

       	 HomePage homepage=new HomePage(driver);
       	 homepage.productModule();
       	ProductPage productpage=new ProductPage(driver);
       	productpage.product();


         int RanNum = jlib.getRandomNum();

	    String productName=elib.getDataFromExcel("Product", 1,0)+RanNum;
	    CreateProductPage createproductpage=new CreateProductPage(driver);
	    createproductpage.createProductPage(productName);
	    
	    WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
	    wlib.mouseHoverOnElement(driver, ele1);
	    homepage.campaignsModule();
	    
	    CampaignsPage campaignspage=new CampaignsPage(driver);
	    campaignspage.campaigns();
		int RanNum1= jlib.getRandomNum();

		String campaignName=elib.getDataFromExcel("Campaign",1,0)+RanNum1;

		CreateCampainsPage createcampainspage=new CreateCampainsPage(driver);
		createcampainspage.addProduct();

		wlib.switchToWindow(driver, "Products&action");
		Product_PopUp ppop=new Product_PopUp(driver);
		ppop.addProduct(productName);


		wlib.switchToWindow(driver, "Campaigns&action");
        
		createcampainspage.createCampaignsPageOnly(campaignName);
		createcampainspage.saveCampaignsPage();
          
		CampaignValidation actualCampaignName=new CampaignValidation(driver);
		String actualCampaignData = actualCampaignName.actualCampaignName();
		Assert.assertEquals(actualCampaignData.contains(campaignName),true);


	    WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wlib.mouseHoverOnElement(driver, ele);
		homepage.signout();

		driver.quit();
}
}
