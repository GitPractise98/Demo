package com.qa.util;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShot
{
	public static void take_screenshot(WebDriver driver,String testname) throws Exception
	{
		String path1 = "C:\\Users\\nitin.thalia\\Desktop\\Git\\Auto_Prac\\ScreenShot\\screenshot";	
		File filesrc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		DateFormat	dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		File targetFile = new File(path1 + dateFormat.format(new Date()) + testname +".png");
		FileUtils.copyFile(filesrc, targetFile);
	}

}
