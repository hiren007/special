package com.test.testcase;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.test.base.TestBase;

public class HomeTestcase extends TestBase{

	@Test
	public void clickonsignup() throws InterruptedException, IOException
	{
		homepage.clickonsignup();
		test.get().log(Status.INFO, "Click on signup");
	}
	
	@Test
	public void clickonforgotpassword() throws InterruptedException, IOException
	{
		homepage.clickonforgotpassword();
		test.get().log(Status.INFO, "Click on forgotpassword");
	}
}