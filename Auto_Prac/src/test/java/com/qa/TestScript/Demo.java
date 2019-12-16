package com.qa.TestScript;

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

}
