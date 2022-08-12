package comcast.vtiger.object.Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage 
{
	//initialization
	public  CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//declaration
	@FindBy(name="productname")
	private WebElement ProductNameTextField;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement SaveButton;
	
	
	@FindBy(xpath="//input[@title='Delete [Alt+D]']")
	private WebElement DeleteProduct;
	//getter methods

	public WebElement getDeleteProduct()
	{
		return DeleteProduct;
	}

	public WebElement getProductNameTextField()
	{
		return ProductNameTextField;
	}

	public WebElement getSaveButton()
	{
		return SaveButton;
	}
	
	//business Logics
	/**
	 * @param productname
	 * @author vikas
	 */
	 public void createProductPage(String ProductName)
	 {
		 ProductNameTextField.sendKeys(ProductName);
		 SaveButton.click();
	 }
     public void deleteProduct() 
     {
    	 
    	 DeleteProduct.click();
     }
}
