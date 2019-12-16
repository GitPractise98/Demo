package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass
{
	String browser=null;
	Properties prop;
	WebDriver driver;
	
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
    
}
