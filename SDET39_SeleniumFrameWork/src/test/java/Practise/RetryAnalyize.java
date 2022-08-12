package Practise;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyize
{
	@Test(retryAnalyzer=comcast.vtiger.genericUtility.ReTryImpClass.class)
	public void modifyContact()
	{
		Assert.assertEquals(false,true);
		System.out.println("modified Contact");
	}
	@Test(retryAnalyzer=comcast.vtiger.genericUtility.ReTryImpClass.class)
	public void createContact()
	{
	
		System.out.println("Contact created");
	}
	

}
