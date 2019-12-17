package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class BaseClass
{
	String browser=null;
	Properties prop;
	public WebDriver driver;
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
    	driver.manage().window().maximize();
    	driver.get(prop.getProperty("url"));
    	
    }
    
    
	
	  @BeforeMethod 
	  public void beforeMethod(Method m) 
	  {
	  test=report.createTest(m.getName()); 
	  }
	 
    
    
    @AfterMethod
    public void afterMethod(ITestResult result)
    {
    	test=null;
    	if(result.getStatus()==result.FAILURE)
    	{
 String testname=result.getName();
		
		File filesrc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		DateFormat	dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		File targetFile = new File("./Screenshots/" + dateFormat.format(new Date()) + testname +".png");
		try {
			FileUtils.copyFile(filesrc, targetFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	}
    }
   
    

    @AfterClass
    public void tearDown()
    {
    	driver.quit();
    }
    
    @AfterSuite
	public void report_flush()
	{
	report.flush();
    }


}
