package Practise;

import org.testng.annotations.Test;

public class TestngSample2 
{
@Test
	
	public void createContact()
	{
		System.out.println("contact created");
		int [] arr= {1,2,3,4};
		System.out.println(arr[5]);
		
	}
	@Test(dependsOnMethods="createContact")
	public void modifyContact()
	{
		System.out.println("contact modified");
	}
	@Test(dependsOnMethods="createContact")
	public void deleteContact()
	{
		System.out.println("contact deleted");
	}

}
