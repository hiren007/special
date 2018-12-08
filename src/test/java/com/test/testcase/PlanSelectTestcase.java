
package com.test.testcase;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.test.base.TestBase;

public class PlanSelectTestcase extends TestBase {
	 @Test
	 public void planselect() throws Exception
	 {
		 planselectpage.getStartedButton();
		 test.get().log(Status.INFO, "Growth best saller plan selected.");
	 }
}

