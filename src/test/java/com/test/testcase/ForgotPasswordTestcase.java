package com.test.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.test.base.TestBase;

public class ForgotPasswordTestcase extends TestBase {

	@Test
	public void mailidblank() throws InterruptedException 
	{
		forgotpassword.clearemailadress();
		test.get().log(Status.INFO, "Clear email address successfull");
		forgotpassword.clickonsubmitbutton();
		test.get().log(Status.INFO, "Click on submit button");
		Assert.assertEquals(forgotpassword.blankemailvalidationverify(), "Email is required.");
		test.get().log(Status.INFO, "Blank email address validation verify");
	}
	
	@Test
	public void invalidmailadress() throws InterruptedException 
	{
		driver.navigate().refresh();
		forgotpassword.clearemailadress();
		test.get().log(Status.INFO, "Clear email address successfull");
		forgotpassword.enteremailadress(excel.getCellData(2, 2, 0));
		test.get().log(Status.INFO, "Enter email address : "+excel.getCellData(2, 2, 0));
		forgotpassword.clickonsubmitbutton();
		test.get().log(Status.INFO, "Click on submit button");
		Assert.assertEquals(forgotpassword.invalidemailvalidationverify(), "Invalid Email Address.");
		test.get().log(Status.INFO, "Invalid email address verify");
	}
	
	@Test
	public void doesnotexistmailadress() throws InterruptedException 
	{
		driver.navigate().refresh();
		forgotpassword.clearemailadress();
		test.get().log(Status.INFO, "Clear email address successfull");
		forgotpassword.enteremailadress(excel.getCellData(2, 3, 0));
		test.get().log(Status.INFO, "Enter email address : "+excel.getCellData(2, 3, 0));
		forgotpassword.clickonsubmitbutton();
		test.get().log(Status.INFO, "Click on submit button");
		Assert.assertEquals(forgotpassword.blankemailvalidationverify(), "Email doesn't exists.");
		test.get().log(Status.INFO, "Email doesn't exists");
	}
	
	@Test
	public void validemailadress() throws InterruptedException 
	{
		driver.navigate().refresh();
		forgotpassword.clearemailadress();
		test.get().log(Status.INFO, "Clear email address successfull");
		forgotpassword.enteremailadress(excel.getCellData(2, 4, 0));
		test.get().log(Status.INFO, "Enter email address : "+excel.getCellData(2, 4, 0));
		forgotpassword.clickonsubmitbutton();
		test.get().log(Status.INFO, "Click on submit button");
		Assert.assertEquals(forgotpassword.blankemailvalidationverify(), "Email sent to user.");
		test.get().log(Status.INFO, "Valid exist mail id will sent mail to user");
		}
	}
