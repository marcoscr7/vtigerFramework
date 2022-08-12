package comcast.vtiger.object.Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import comcast.vtiger.genericUtility.WebDriver_Utility;

public class HomePage 
{
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
		//declaration
		@FindBy(xpath="//a[text()='Products']")
		private WebElement ProductModuleButton;
		
		@FindBy(xpath="(//a[text()='Organizations'])[1]")
		private WebElement OrganizationsModuleButton;
		
     	@FindBy(xpath="//img[@src='themes/softed/images/menuDnArrow.gif']")
		private WebElement MoreButtonMouseHover;
		
		@FindBy(name="Campaigns")
		private WebElement CampaignsModuleButton;
		
//		@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
//		private WebElement SignOutMouseHover;
		
		@FindBy(xpath="//a[text()='Sign Out']")
		private WebElement SignOutModule;
		

		//getter methods
		public WebElement getProductModuleButton() 
		
		{
			return ProductModuleButton;
		}

		public WebElement getOrganizationsModuleButton() 
		{
			return OrganizationsModuleButton;
		}

	   public WebElement getMoreButtonMouseHover() 
		{
			return MoreButtonMouseHover;
		}

		public WebElement getCampaignsModuleButton()
		{
			return CampaignsModuleButton;
		}

//		public WebElement getSignOutMouseHover() 
//		{
//			return SignOutMouseHover;
//		}

		public WebElement getSignOutModule()
		{
			return SignOutModule;
		}
		
		//Business Logics
		/**
		 * @author vikas
		 */
	   public void productModule() 
	   {
		   ProductModuleButton.click();
		   }
	   public void organizationsModule()
	   {
		   OrganizationsModuleButton.click();
	   }
	   public void campaignsModule() 
	   {
		   CampaignsModuleButton.click();
		   
	   }
	   public void signoutmodule()
	   {
		   SignOutModule.click();
	   }
	   public void signout()
	   {
		   SignOutModule.click();
	   }

	   public void moreLink(WebDriver driver)
	   {
		   WebDriver_Utility wlib=new WebDriver_Utility();
		   wlib.mouseHoverOnElement(driver, CampaignsModuleButton);
	   }
	 
	   
	   
      

        }
