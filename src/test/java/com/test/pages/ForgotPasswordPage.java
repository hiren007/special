package com.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {

	
	WebDriver driver;
	
	@FindBy(xpath="//*[@tabindex='1']")
	WebElement email;
	
	@FindBy(xpath="//*[@tabindex='2']")
	WebElement submitbutton;
	
	@FindBy(xpath="//*[contains(text(),'Email')]")
	WebElement blankemailmessage;
	
	@FindBy(xpath="//*[contains(text(),'Invalid')]")
	WebElement invalidemailmessage;
	
	public ForgotPasswordPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		}
	
	public void clearemailadress() {
		email.clear();
	}
	
	public void enteremailadress(String emailadress) {
		email.sendKeys(emailadress);
	}
	
	public void clickonsubmitbutton() {
		submitbutton.click();
	}
	
	public String blankemailvalidationverify() {
		return blankemailmessage.getText();
	}

	public String invalidemailvalidationverify() {
		return invalidemailmessage.getText();
	}

}
