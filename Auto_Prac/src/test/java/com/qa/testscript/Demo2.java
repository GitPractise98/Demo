package com.qa.testscript;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;

public class Demo2 extends BaseClass
{
	@Test(description=" user should be able to run the Lead Activity job from Automic")	
	public void TC_LA_01()
	{	
//		 test=report.createTest("To Verify user should be able to run the Lead Activity job from Automic"); 
		System.out.println("1st Test Case Executed : ");
		eventDriver.findElement(By.xpath("//*[@id='c-shellmenu_51']")).click();
		
	}
	
	@Test
	public void run2()
	{
		 test=report.createTest("To Verify user should be able to cancel the Lead Activity job from Automic"); 
		System.out.println("hello");
	}
	
	@Test
	public void run3()
	{
		 test=report.createTest("To Verify user should be able to cancel the Lead Activity job from Automic"); 
		System.out.println("World");
	}


}

