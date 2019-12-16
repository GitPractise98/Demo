package com.qa.base;

import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


public class BaseClass
{
	@BeforeSuite
	public void Report_setup()
	{
		ExtentReports reports = new ExtentReports(System.getProperty("user.dir")+"/Reports/myreport.html");
		
	}

}
