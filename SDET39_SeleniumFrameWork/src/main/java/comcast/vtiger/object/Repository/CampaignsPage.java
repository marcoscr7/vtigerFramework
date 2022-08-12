package comcast.vtiger.object.Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage 
{
	public    CampaignsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//declaration
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
    private WebElement PlusButtonToCreateCampaigns;
	
	
	
	//getters method
	public WebElement getPlusButtonToCreateCampaigns() 
	{
		return PlusButtonToCreateCampaigns;
	}
	
	//business Logics
	/**
	 * @author vikas
	 */
	public void campaigns() 
	{
		
		PlusButtonToCreateCampaigns.click();
	}

}
