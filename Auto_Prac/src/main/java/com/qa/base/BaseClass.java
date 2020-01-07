package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qa.util.EventHandler;
import com.qa.util.TakeScreenShot;




public class BaseClass
{
	String browser=null;
	Properties prop;
	protected WebDriver driver;
	ExtentHtmlReporter htmlreport;
    public ExtentReports report;
	public ExtentTest test;
	protected EventFiringWebDriver eventDriver;
	
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
    	 EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
    	 EventHandler handler = new EventHandler();
    	 eventDriver.register(handler);
    	 eventDriver.manage().window().maximize();
    	eventDriver.get(prop.getProperty("url"));
    }

	  @BeforeMethod 
	  public void beforeMethod(ITestResult itr) 
	  {
	  test=report.createTest (itr.getMethod().getMethodName()+";"+itr.getMethod().getDescription()); 
	  }

	@AfterMethod
	public void afterMethod(ITestResult result)
	 {
		try
		{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "Test Case is failed : " + result.getName());
			test.log(Status.FAIL, "Test Case is failed : " + result.getThrowable());
		try
		   {
			TakeScreenShot.take_screenshot(driver, result.getName());
	    	} 
		catch (Exception e) 
			{
				e.printStackTrace();
			}
					
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "Test case is pass : " + result.getName());
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.PASS, "Test case is pass : " + result.getName());
			test.log(Status.FAIL, "Test Case is failed : " + result.getThrowable());

		}		
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	
	}
    @AfterClass
    public void tearDown()
    {
  
    }
    
    @AfterSuite
	public void report_flush()
	{
	report.flush();
  	driver.quit();
    }


}
