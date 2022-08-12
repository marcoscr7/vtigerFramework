 package comcast.vtiger.genericUtility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriver_Utility
{
	/**
	 * wait for page to load before identifying any synchronized element in DOM
	 * @param driver
	 * @author Vikas
	 */
	public void waitForPageToLoad(WebDriver driver)
	{
	 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);	
    }
	/**
	 * After every action it will wait for the next action to perform
	 * @param driver
	 * @author vikas
	 */
	public void scriptTimeOut(WebDriver driver)
	{
		driver.manage().timeouts().setScriptTimeout(20,TimeUnit.SECONDS);
	}
	/**
	 * used to wait for element to be clickable in GUI and check for specific element for every 500milliSeconds 
	 * @param driver 
	 * @param Element
	 * @author vikas
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement Element)
	{
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.elementToBeClickable(Element));
	}
	/**
	 * used to wait for element to be clickable in GUI and check for specific element for every 500milliSeconds
	 *@param driver
	 *@param Element
	 *@param pollinTime
	 * @author vikas 
	 */
	   public void waitForElementWithCustomTimeOut(WebDriver driver,WebElement Element,int pollingTime)
	   {
		   FluentWait wait=new FluentWait(driver);
		   wait.pollingEvery(Duration.ofSeconds(20));
		   wait.until(ExpectedConditions.elementToBeClickable(Element));
		   
	   }
	   /**
	    * switch to any window based on window title
	    * param driver
	    * param PartialWindowTitle
	    * @author vikas
	    */
	   public void switchToWindow(WebDriver driver,String PartialWindowTitle)
	   {
		   Set<String> allId = driver.getWindowHandles();
			Iterator<String> it = allId.iterator();
			while(it.hasNext())
			{
				String wid = it.next();
				driver.switchTo().window(wid);
				if(driver.getTitle().contains(PartialWindowTitle))
				{
					break;
				}
	   }
	   }
	 
	   /**
	    * Used to switch to alert window and accept(click on ok button)
	    * @param driver
	    * @author vikas
	    */
	   public void switchToAlertAndAccept(WebDriver driver)
	   {
		   driver.switchTo().alert().accept();
	   }
	   /**
	    *  Used to switch to alert window and dismiss(click on cancel button)
	    *  @param driver
	    */
	   public void switchToAlertAndCancel(WebDriver driver)
	   {
		   driver.switchTo().alert().dismiss();
	   }
	   /**
	    * used to switch frame window based on Index
	    * param driver
	    * param index
	    * @author vikas 
	    */
	   public void switchToFrame(WebDriver driver,int index)
	   {
		   driver.switchTo().frame(index);
	   }
	   /**
	    * used to switch to frame window based on id or name attribute
	    * param driver
	    * param id_name_attribute
	    */
	   public void switchToFrame(WebDriver driver,String id_name_Attribute)
	   {
		   driver.switchTo().frame(id_name_Attribute);
	   }
	   /**
	    * used to select value from drop down based on index
	    * @param element 
	    * @param index
	    * @author vikas 
	    */
	   public void select(WebElement element,int index)
	   {
		   Select s=new Select(element);
		   s.selectByIndex(index);
	   }
	   /**
	    * used to select value from drop down based on  text
	    * param element 
	    * param text
	    * @author vikas 
	    */
	   public void select(WebElement element,String text)
	   {
		   Select s=new Select(element);
		   s.selectByVisibleText(text);
	   }
	   /**
	    * used to place mouse cursor on specified element
	    * param driver
	    * param element
	    * @author vikas
	    */
	   public void mouseHoverOnElement(WebDriver driver,WebElement element)
	   {
		   Actions a=new Actions(driver);
		   a.moveToElement(element).perform();
	   }
	   /**
	    * used to roght click on specific element 
	    * @param element
	    * @param driver
	    * @author vikas
	    */
	   public void rightClickOnElement(WebDriver driver,WebElement element)
	   {
		   Actions a=new Actions(driver);
		   a.contextClick(element).perform();
	   }
	   
}
