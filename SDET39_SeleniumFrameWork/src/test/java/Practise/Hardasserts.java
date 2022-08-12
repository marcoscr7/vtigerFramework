package Practise;


import org.testng.Assert;
import org.testng.annotations.Test;

public class Hardasserts 
{
	@Test 
	public void createCustomer()
	{
		System.out.println("step 1");
		System.out.println("step 2");
		System.out.println("step 3");
		Assert.assertEquals("A","B");
		System.out.println("step 4");
		System.out.println("step 5");
	}
	@Test
	public void modifyCustomer()
	{
		System.out.println("----------------------");
		System.out.println("step 1");
		System.out.println("step 2");
		System.out.println("step 3");
		System.out.println("step 4");
	}

}
