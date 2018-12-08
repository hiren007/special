package com.test.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.test.base.TestBase;

public class SignInTestcase extends TestBase {

	@Test
	public void withoutcredentialclickonsignin() throws InterruptedException {
		homepage.clearemailadress();
		test.get().log(Status.INFO, "Clear email address successfull");
		homepage.clearpassword();
		test.get().log(Status.INFO, "Clear password successfull");
		homepage.clickonsignin();
		test.get().log(Status.INFO, "Click on signin button");
		Assert.assertEquals(homepage.blankemailvalidationverify(), "Email is required.");
		test.get().log(Status.INFO, homepage.blankemailvalidationverify()+ " verified");
		Assert.assertEquals(homepage.blankpasswordvalidationverify(), "Password is required.");
		test.get().log(Status.INFO, homepage.blankpasswordvalidationverify()+ " verified");
		test.get().log(Status.INFO, "Without credentials click on signin button velidation verify");
	}

	@Test
	public void emailadressblank() throws InterruptedException {
		driver.navigate().refresh();
		homepage.clearemailadress();
		test.get().log(Status.INFO, "Clear email address successfull");
		homepage.enteremail(excel.getCellData(1, 2, 0));
		test.get().log(Status.INFO, "Enter email adress : " +excel.getCellData(1, 2, 0));
		homepage.clearpassword();
		test.get().log(Status.INFO, "Clear password successfull");
		homepage.enterpassword(excel.getCellData(1, 2, 1));
		test.get().log(Status.INFO, "Enter Password : " +excel.getCellData(1, 2, 1));
		homepage.clickonsignin();
		test.get().log(Status.INFO, "Click on signin");
		Assert.assertEquals(homepage.blankemailvalidationverify(), "Email is required.");
		test.get().log(Status.INFO, "Blank email validation verify");
	}

	@Test
	public void invalidemailaddress() throws InterruptedException {
		driver.navigate().refresh();
		homepage.clearemailadress();
		test.get().log(Status.INFO, "Clear email address successfull");
		homepage.enteremail(excel.getCellData(1, 3, 0));
		test.get().log(Status.INFO, "Enter email adress : " +excel.getCellData(1, 3, 0));
		homepage.clearpassword();
		test.get().log(Status.INFO, "Clear password successfull");
		homepage.enterpassword(excel.getCellData(1, 3, 1));
		test.get().log(Status.INFO, "Enter password : " +excel.getCellData(1, 3, 1));
		homepage.clickonsignin();
		test.get().log(Status.INFO, "Click on signin");
		Assert.assertEquals(homepage.invalidemailvalidationverify(), "Invalid Email Address.");
		test.get().log(Status.INFO, "Invalid emailid validation verify");
	}

	@Test
	public void passwordblank() throws InterruptedException {
		driver.navigate().refresh();
		homepage.clearemailadress();
		test.get().log(Status.INFO, "Clear email address successfull");
		homepage.enteremail(excel.getCellData(1, 4, 0));
		test.get().log(Status.INFO, "Enter email adress : " +excel.getCellData(1, 4, 0));
		homepage.clearpassword();
		test.get().log(Status.INFO, "Clear password successfull");
		homepage.enterpassword(excel.getCellData(1, 4, 1));
		test.get().log(Status.INFO, "Enter password : " +excel.getCellData(1, 4, 1));
		homepage.clickonsignin();
		test.get().log(Status.INFO, "Click on signin");
		Assert.assertEquals(homepage.blankpasswordvalidationverify(), "Password is required.");
		test.get().log(Status.INFO, "Password blank validation verify");
	}

	@Test
	public void passwordformate() throws InterruptedException {
		driver.navigate().refresh();
		homepage.clearemailadress();
		test.get().log(Status.INFO, "Clear email address successfull");
		homepage.enteremail(excel.getCellData(1, 5, 0));
		test.get().log(Status.INFO, "Enter email address : " +excel.getCellData(1, 5, 0));
		homepage.clearpassword();
		test.get().log(Status.INFO, "Clear password successfull");
		homepage.enterpassword(excel.getCellData(1, 5, 1));
		test.get().log(Status.INFO, "Enter password : " +excel.getCellData(1, 5, 1));
		homepage.clickonsignin();
		test.get().log(Status.INFO, "Click on signin");
		Assert.assertEquals(homepage.blankpasswordvalidationverify(),"Password must be at least 8 characters long.");
		test.get().log(Status.INFO, "Password formate validation verify");
	}

	@Test
	public void emailcradentialwrong() throws InterruptedException {
		driver.navigate().refresh();
		homepage.clearemailadress();
		test.get().log(Status.INFO, "Clear email address successfull");
		homepage.enteremail(excel.getCellData(1, 6, 0));
		test.get().log(Status.INFO, "Enter email address : " +excel.getCellData(1, 6, 0));
		homepage.clearpassword();
		test.get().log(Status.INFO, "Clear password successfull");
		homepage.enterpassword(excel.getCellData(1, 6, 1));
		test.get().log(Status.INFO, "Enter password : " +excel.getCellData(1, 6, 1));
		homepage.clickonsignin();
		test.get().log(Status.INFO, "Click on signin");
		Assert.assertEquals(homepage.invalidloginattemptverify(), "Invalid login attempt.");
		test.get().log(Status.INFO, "Invalid email adress(Invalid login attempt.)");
	}

	@Test
	public void passwordcradentialwrong() throws InterruptedException {
		driver.navigate().refresh();
		homepage.clearemailadress();
		test.get().log(Status.INFO, "Clear email address successfull");
		homepage.enteremail(excel.getCellData(1, 7, 0));
		test.get().log(Status.INFO, "Enter email address : " +excel.getCellData(1, 7, 0));	
		homepage.clearpassword();
		test.get().log(Status.INFO, "Clear password successfull");
		homepage.enterpassword(excel.getCellData(1, 7, 1));
		test.get().log(Status.INFO, "Enter password : " +excel.getCellData(1, 7, 1));
		homepage.clickonsignin();
		test.get().log(Status.INFO, "Click on signin");
		Assert.assertEquals(homepage.invalidloginattemptverify(), "Invalid login attempt.");
		test.get().log(Status.INFO, "Invalid password(Invalid login attempt.)");
	}

	@Test
	public void validcradentialverify() throws InterruptedException {
		driver.navigate().refresh();
		homepage.clearemailadress();
		test.get().log(Status.INFO, "Clear email address successfull");
		homepage.enteremail(excel.getCellData(1, 8, 0));
		test.get().log(Status.INFO, "Enter email address : " +excel.getCellData(1, 8, 0));	
		homepage.clearpassword();
		test.get().log(Status.INFO, "Clear password successfull");
		homepage.enterpassword(excel.getCellData(1, 8, 1));
		test.get().log(Status.INFO, "Enter password : " +excel.getCellData(1, 8, 1));
		homepage.clickonsignin();
		test.get().log(Status.INFO, "Click on signin");
		Thread.sleep(3000);
		System.out.println(homepage.loginsucessfullverify());
		test.get().log(Status.INFO, "LogIn successfull");
		dashboard.menu();
		dashboard.clickonlogout();
		test.get().log(Status.INFO, "LogOut successfull");
	}
}
