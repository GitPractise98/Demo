package com.qa.testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;

public class Dynamic extends BaseClass
{
	
	@Test
	public void test() throws InterruptedException
	{
		String value = "test@test.co.za";
		Thread.sleep(1000);
		WebElement click =	driver.findElement(By.xpath("//div[contains(text(),'"+value+"')]//parent::div/following-sibling::div[5]/user-click-select/div/button"));
		Actions action = new Actions(driver);
		action.moveToElement(click).doubleClick().perform();
		Thread.sleep(5000);
	}

}
