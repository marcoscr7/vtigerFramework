package comcast.vtiger.object.Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage 
{
	//Initialization
	public  ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//declaration
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement PlusButtonToCreateProduct;

	//getter methods
	public WebElement getPlusButtonForCreateProduct() 
	{
		return PlusButtonToCreateProduct;
	}
	//Business Logics
	/**
	 * 
	 */
	public void product() 
	{
		PlusButtonToCreateProduct.click();
	}
	

}
