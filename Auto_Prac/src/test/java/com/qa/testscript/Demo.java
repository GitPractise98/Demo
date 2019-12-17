package com.qa.testscript;

import java.util.List;
import org.testng.annotations.Test;
import com.qa.base.BaseClass;
import com.qa.util.Helper;

public class Demo extends BaseClass
{
	@Test
	public void run()
	{
		System.out.println("hi");
	}
	
	@Test
	public void run2()
	{
		System.out.println("hello");
	}
	
	@Test
	public void run3()
	{
		System.out.println("World");
	}
	@Test
	public void link_verification_home()
	{
		Helper.Link_Verification(driver);

	}

}
