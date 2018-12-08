package com.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlanSelectPage {

	WebDriver driver;
	
	@FindBy(xpath="/html//div[2]/div/div/div[5]/a")
	WebElement getStartedgrowth;
	
	@FindBy(xpath="//*[@class='btn']")
	public
	WebElement requestaquote;
	
	public PlanSelectPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		}

	public void getStartedButton() {
		getStartedgrowth.click();
	}
	
}
