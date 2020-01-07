package com.qa.util;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helper 
{
	public static void Link_Verification(WebDriver driver)
	{
		String url;
		List<String> Stringlink = null;
	//	List<String> Stringfaillink = null;
		HttpURLConnection huc = null;
	    int respCode = 200;
		List<WebElement> links=driver.findElements(By.tagName("a"));
		Iterator<WebElement> it = links.iterator();
        while(it.hasNext())
        {
            url = it.next().getAttribute("href");
            System.out.println(url);
            if(url == null || url.isEmpty())
            {
            System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }
            
            try {
                huc = (HttpURLConnection)(new URL(url).openConnection());
                
                huc.setRequestMethod("HEAD");
                
                huc.connect();
                
                respCode = huc.getResponseCode();
                
                if(respCode >= 400)
                {
                	
                 Stringlink = new ArrayList<>();
                 System.out.println(url + "is not working");
                }
                else
                {
                       //System.out.println("Is working");	
                }
            }
            
            catch (Exception e) 
            {
            	System.out.println(e.getMessage());
			}
           
        }
		

	}

}