package com.qa.TestScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;

public class Demo extends BaseClass
{
	@Test
	public void run()
	{
		test = report.createTest("Login");
		System.out.println("hi");
	}
	@Test
	public void run1()
	{
		test = report.createTest("Maths");
		int i=6;
		int j=5;
		Assert.assertEquals(i, j);
	}

}
