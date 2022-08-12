package Practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMyTrip
{
	  public static void main(String[] args) throws Throwable 
	  {
		  WebDriver driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://www.makemytrip.com/");
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
          WebElement fromCity = driver.findElement(By.xpath("//input[@id='fromCity']"));
          WebElement toCity = driver.findElement(By.xpath("//input[@id='toCity']"));
          fromCity.sendKeys("New Delhi");
          driver.findElement(By.xpath("//p[text()='New Delhi, India']")).click();
          Thread.sleep(1000);
          toCity.sendKeys("Bengaluru");
          Thread.sleep(1000);
          driver.findElement(By.xpath("//p[text()='Bengaluru, India']")).click();
          Thread.sleep(1000);
          driver.findElement(By.xpath("//label[@for='departure']")).click();
          //navigate to departure
          String requiredMonth="November";
          String requiredYear="2022";
          String requiredDate="15";
          String currentMonthYear = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption']/div)[1]")).getText();
          String currentMonth = currentMonthYear.split(" ")[0];
          String currentYear=currentMonthYear.split(" ")[1];
          while(!(currentMonth.equalsIgnoreCase(requiredMonth)&&(currentYear.equals(requiredYear))))
          {
        	  driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
        	  currentMonthYear = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption']/div)[1]")).getText();
        	  currentMonth = currentMonthYear.split(" ")[0];
              currentYear=currentMonthYear.split(" ")[1];
          
          }
//          driver.findElement(By.xpath("(//p[.='"+requiredDate+"'])[1]")).click();
          Thread.sleep(1000);
          driver.findElement(By.xpath("(//p[text()='"+requiredDate+"'])[1]")).click();
          driver.quit();
	  } 
	   

}
