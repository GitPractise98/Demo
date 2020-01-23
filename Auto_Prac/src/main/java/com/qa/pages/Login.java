package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Login 
{
	public WebDriver driver;
	public Login(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	 @FindBy(how = How.XPATH, using ="//*[@id='login_field']") 
	    WebElement username; 
	  
    @FindBy(how = How.XPATH, using ="//*[@id='password'] " ) 
	    WebElement password; 
	
    public void setEmail(String strEmail) { 
    	username.sendKeys(strEmail); 
    } 

public void setPassword(String strPassword) { 
	password.sendKeys(strPassword); 
	
}
    
}
