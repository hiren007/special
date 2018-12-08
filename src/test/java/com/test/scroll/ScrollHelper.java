package com.test.scroll;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.base.TestBase;

public class ScrollHelper {

	WebDriver driver;
	static JavascriptExecutor js = (JavascriptExecutor) TestBase.driver;
	
	public ScrollHelper(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
	}

	public void scrollbyPixel() throws InterruptedException {
		js.executeScript("window.scrollBy(0,150)");
		Thread.sleep(3000);
	}

	public static synchronized boolean ScrollPageUpToVisibilityOfElement(WebElement Element)throws InterruptedException {
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Thread.sleep(3000);
		return true;
	}

	public void scrollbyPage() throws Exception {
		try {
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println("e.printStackTrace()" + e);
		}
	}

	public void scrollHorizontally() throws InterruptedException {
		WebElement Element = driver.findElement(By.linkText("VBScript"));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Thread.sleep(3000);
	}
}