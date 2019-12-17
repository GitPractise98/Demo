package com.qa.testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;

public class Demo extends BaseClass
{
	@Test
	public void run()
	{
		System.out.println("hi");
		Assert.assertTrue(false);
	}
	
	@Test
	public void run2()
	{
		System.out.println("hello");
	}
	
	@Test
	public void run3()
	{
		System.out.println("World");
	}


}
