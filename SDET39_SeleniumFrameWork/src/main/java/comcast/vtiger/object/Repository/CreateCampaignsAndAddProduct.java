package comcast.vtiger.object.Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignsAndAddProduct 
{
	public  CreateCampaignsAndAddProduct(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//declaration
		@FindBy(xpath="campaignname")
		private WebElement CampaignNamesTextField;
		
		@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
		private WebElement PlusButtonToAddProduct;
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement SaveButton;
		

		//getters methods
		public WebElement getCampaignNamesTextField() 
		{
			return CampaignNamesTextField;
		}

		public WebElement getPlusButtonToAddProduct() 
		{
			return PlusButtonToAddProduct;
		}
		
		 public WebElement getSaveButton()
	      {
				return SaveButton;
			}
		//business logics
		/**
		 * 
		 */
		public void createCampaignsAddProduct(String CampaignsName)
		{
			CampaignNamesTextField.sendKeys(CampaignsName);
			PlusButtonToAddProduct.click();
			SaveButton.click();
		}

	
}
