package com.qa.base;

import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class BaseClass
{
	public ExtentHtmlReporter htmlreport;
	public ExtentReports report;
	
	@BeforeSuite
	public void Report_setup()
	{
		htmlreport = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\Report\\report.html");
		htmlreport.config().setDocumentTitle("Automation Report");
		htmlreport.config().setReportName("UI Testing report");
		report =  new ExtentReports();
		report.attachReporter(htmlreport);
	}

}
