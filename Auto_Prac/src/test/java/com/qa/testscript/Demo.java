package com.qa.testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;

public class Demo extends BaseClass
{
	@Test( )
	public void run()
	{
		System.out.println("hi");
		Assert.assertTrue(false);
	}
	
	@Test(description="test run2")
	public void run2()
	{
		System.out.println("hello");
	}
	
	@Test(description="test run3")
	public void run3()
	{
		System.out.println("World");
	}


}
