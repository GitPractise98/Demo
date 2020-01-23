package com.qa.testscript;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.base.BaseClass;
import com.qa.util.Retry;


public class TC1 extends BaseClass
{	
	@Test
	public void run2()
	{
		 test=report.createTest("To Verify user should be able to cancel the Lead Activity job from Automic"); 
		 driver.navigate().to("https://www/google.com");;
	}
	
	@Test(retryAnalyzer = Retry.class)
	public void run3()
	{
		 test=report.createTest("To Verify user should be able to cancel the Lead Activity job from Automic"); 
		 Assert.assertEquals(4,5);
	}


}
