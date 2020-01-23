package com.qa.testscript;


import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.Login;

public class TC2 extends BaseClass

{
	Login log;

	@Test
	public void run2()
	{
		 test=report.createTest("To Verify user should be able to cancel the Lead Activity job from Automic"); 
		 log = new Login(driver);
		 log.setEmail("practice");
		 log.setPassword("1234");
		 
		 
	}


}
