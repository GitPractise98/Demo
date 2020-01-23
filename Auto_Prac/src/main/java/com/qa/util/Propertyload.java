package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Propertyload 
{
	public static void  read_properties(String key) throws FileNotFoundException
	{
		String value=null;
	 InputStream input = new FileInputStream("C:\\Users\\nitin.thalia\\eclipse-workspace\\AS_1\\src\\test\\java\\org\\utiles\\org.properties");
	     Properties prop = new Properties();
	   
		 try {
			prop.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 value=prop.getProperty(key);
		 System.out.println(value);

	}

}
