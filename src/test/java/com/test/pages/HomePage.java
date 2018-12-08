package com.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	@FindBy(xpath = "//*[@type='email']")
	WebElement email;

	@FindBy(xpath = "//*[@type='password']")
	WebElement password;

	@FindBy(xpath = "//*[@value='SIGN IN']")
	WebElement signinbuton;

	@FindBy(xpath = "//*[@routerlink='/forgotpassword']")
	WebElement forgotpassword;

	@FindBy(xpath = "//*[@routerlink='/plans']")
	WebElement signUp;

	@FindBy(xpath = "//*[contains(text(),'Email')]")
	WebElement blankemailmessage;

	@FindBy(xpath = "//*[contains(text(),'Pass')]")
	WebElement blankepasswordmessage;

	@FindBy(xpath = "//*[contains(text(),'Invalid')]")
	WebElement invalidcradentilmessage;

	@FindBy(xpath = "//*[contains(text(),'BUY')]")
	WebElement loginverify;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void clickonsignup() {
		signUp.click();
	}

	public void clickonsignin() {
		signinbuton.click();
	}

	public void clickonforgotpassword() {
		forgotpassword.click();
	}

	public void clearemailadress() {
		email.clear();
	}

	public void clearpassword() {
		password.clear();
	}

	public void enteremail(String emailid) {
		email.sendKeys(emailid);
	}

	public void enterpassword(String epassword) {
		password.sendKeys(epassword);
	}

	public String blankemailvalidationverify() {
		return blankemailmessage.getText();
	}

	public String invalidemailvalidationverify() {
		return invalidcradentilmessage.getText();
	}

	public String blankpasswordvalidationverify() {
		return blankepasswordmessage.getText();
	}

	public String invalidloginattemptverify() {
		return invalidcradentilmessage.getText();
	}

	public String loginsucessfullverify() {
		return loginverify.getText();
	}
}
