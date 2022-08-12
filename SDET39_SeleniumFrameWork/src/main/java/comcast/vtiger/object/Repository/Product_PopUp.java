package comcast.vtiger.object.Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product_PopUp 
{
	//Initialization
	public  Product_PopUp(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//Declaration
	
	@FindBy(name="search_text")
	private WebElement ProductTextField;
	
	@FindBy(name="search")
	private WebElement SearchTextField;
	
	@FindBy(xpath="//a[@href='javascript:window.close();']")
	private WebElement ClickOnProduct;
	
	//getter methods

	public WebElement getProductTextField() 
	{
		return ProductTextField;
	}

	public WebElement getSearchTextField() 
	{
		return SearchTextField;
	}

	public WebElement getClickOnProduct() 
	{
		return ClickOnProduct;
	}
	
	public void addProduct(String AddProduct)
	{
		ProductTextField.sendKeys(AddProduct);
		SearchTextField.click();
		ClickOnProduct.click();
	}
	
	

}
