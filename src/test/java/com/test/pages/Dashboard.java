package com.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.base.TestBase;

public class Dashboard extends TestBase {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@href='javascript:void(0);']")
	WebElement selectmenu;
	
	@FindBy(xpath="//*[contains(text(),'Logout')]]")
	WebElement logout;
		
	public Dashboard(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void menu() {
		selectmenu.click();
	}
	
	public void clickonlogout() {
		selectmenu.click();
	}
}
