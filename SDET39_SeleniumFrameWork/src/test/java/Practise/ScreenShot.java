package Practise;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class ScreenShot
{
public void screenShot(WebDriver driver) throws Throwable
{
	
	TakesScreenshot ts= (TakesScreenshot)driver;
	File ram=ts.getScreenshotAs(OutputType.FILE);
	File dest=new File("path");
	FileUtils.copyFile(ram, dest);
     
}
}