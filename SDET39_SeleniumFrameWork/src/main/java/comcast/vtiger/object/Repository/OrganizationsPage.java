package comcast.vtiger.object.Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage
{
	//initializations
	public  OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//declaration
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement PlusButtonToOrganizations;
	
	
	//getter methods
	public WebElement getPlusButtonToOrganizations()
	{
		return PlusButtonToOrganizations;
	}
	// business Logics
	/**
	 * 
	 */
	public void organizations()
	{
		PlusButtonToOrganizations.click();
	}
	
	
	

}
