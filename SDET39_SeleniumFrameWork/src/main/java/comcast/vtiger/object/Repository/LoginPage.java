package comcast.vtiger.object.Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	
	// initalization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);	
	}
	//declaration
	@FindBy(name="user_name")
	private WebElement UserNameTextField;
	@FindBy(name="user_password")
	private WebElement UserPasswordTextField;
	@FindBy(id="submitButton")
	private WebElement SubmitButton;
	
	
	
	//getter methods
	public WebElement getUserNameTextField() 
	{
		return UserNameTextField;
	}
	public WebElement getUserPasswordTextField() 
	{
		return UserPasswordTextField;
	}
	public WebElement getSubmitButton()
	{
		return SubmitButton;
	}
	
	//Business Logics
	/**
	 * 
	 * @param userName
	 * @param password
	 * @author vikas
	 */
	
	public void login(String userName,String password) 
	{
		UserNameTextField.sendKeys(userName);
		UserPasswordTextField.sendKeys(password);
		SubmitButton.click();
	}
	
}
