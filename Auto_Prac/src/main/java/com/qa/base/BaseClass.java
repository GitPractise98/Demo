package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class BaseClass
{
	String browser=null;
	Properties prop;
	WebDriver driver;
	ExtentHtmlReporter htmlreport;
    public ExtentReports report;
	public ExtentTest test;
	
	public BaseClass()
	{
		prop=new Properties();
		try
		{
		FileInputStream inp=new FileInputStream(new File(System.getProperty("user.dir")+
				"/src/main/java/com/qa/resources/app.config"));
		prop.load(inp);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}
	
	@BeforeSuite
	public void Report_setup()
	{
		htmlreport = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\Report\\report.html");
		htmlreport.config().setDocumentTitle("Automation Report");
		htmlreport.config().setReportName("UI Testing report");
		report =  new ExtentReports();
		report.attachReporter(htmlreport);

	}
	
    @BeforeClass
    public void setup()
    {
    	browser=prop.getProperty("browser");
    	if(browser.equals("chrome"))
    	{
    		WebDriverManager.chromedriver().setup(); 
    		driver=new ChromeDriver();
    	}
    	if(browser.equals("firefox"))
    	{
    		WebDriverManager.firefoxdriver().setup(); 
    		driver=new FirefoxDriver();
    	}
    	if(browser.equals("ie"))
    	{
    		WebDriverManager.iedriver().setup(); 
    		driver=new InternetExplorerDriver();
    	}
    	driver.get(prop.getProperty("url"));
    }
    

    @AfterTest
    public void Test_Result()
    {
    	
    }
    
    
    @AfterSuite
    	public void report_flush()
    	{
    	report.flush();
        }
    
    

    @AfterClass
    public void tearDown()
    {
    	driver.quit();
    }

}
