package Practise;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest
{
	@Test(dataProvider="dataProvider_Test")
	public void bookTicket(String source,String destination)
	{
		System.out.println("Book tickets from "+source+" to "+destination);
	}
	
	@DataProvider
	public Object[][] dataProvider_Test()
	{
		Object[][] objArr=new Object[5][2]; 
		objArr[0][0]="bangalore";
		objArr[0][1]="chennai";
		
		objArr[1][1]="bangalore";
		objArr[1][1]="varanasi";
		
		objArr[2][1]="bangalore";
		objArr[2][1]="mumbai";
		objArr[3][1]="bangalore";
		objArr[3][1]="nepal";
		objArr[4][1]="bangalore";
		objArr[4][1]="bhopal";
		return objArr;
		
	}

}
