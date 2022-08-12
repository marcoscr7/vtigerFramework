package comcast.vtiger.object.Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampainsPage
{
	//Initialization
	public  CreateCampainsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//declaration
	@FindBy(name="campaignname")
	private WebElement CampaignNamesTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveButton;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement AddProduct;

	
	
	public WebElement getCampaignNamesTextField()
	{
		return CampaignNamesTextField;
	}

	public WebElement getAddProduct()
	{
		return AddProduct;
	}

	//getters methods
	public WebElement getCampaignName() 
	{
		return CampaignNamesTextField;
	}

	public WebElement getSaveButton()
	{
		return SaveButton;
	}
	
	//business Logics
	/**
	 * @param CampaignName
	 * @author vikas
	 */
	public void createCampaignsPage(String CampaignName)
	{
		CampaignNamesTextField.sendKeys(CampaignName);
		SaveButton.click();
	}
	public void createCampaignsPageOnly(String CampaignName)
	{
		CampaignNamesTextField.sendKeys(CampaignName);
	}
	public void saveCampaignsPage()
	{
		SaveButton.click();
	}
	public void addProduct()
	{
		AddProduct.click();
	}
}
