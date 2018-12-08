package com.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.test.base.TestBase;

public class SignUpPage extends TestBase {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id='email']")
	WebElement email;
	
	//for blank validation
	@FindBy(xpath="//*[@class='validation-error']/div")
	WebElement validationblank;
	
	//for exist or not match or not in formate
	@FindBy(xpath="//*/div[@class='validation-error']")
	WebElement existvalidation;
	
	@FindBy(xpath="//form/div[1]/div[1]/div/div")
	WebElement emailValidationnext;
	
	@FindBy(xpath="//form/div[1]/div[2]/div/div")
	WebElement passwordValidationnext;
	
	@FindBy(xpath="//form/div[2]/div[1]/div/div")
	WebElement confirmPasswordValidationnext;
	
	@FindBy(xpath="//*[contains(text(),'First n')]")
	WebElement firstnameblankonnext;
	
	@FindBy(xpath="//*[contains(text(),'Last n')]")
	WebElement lastnameblankonnext;
	
	@FindBy(xpath="//*[contains(text(),'Billing a')]")
	WebElement billingadressblankonnext;
	
	@FindBy(xpath="//*[contains(text(),'City i')]")
	WebElement cityblankclickonnext;
	
	@FindBy(xpath="//*[contains(text(),'State i')]")
	WebElement stateblankclickonnext;
	
	@FindBy(xpath="//*[contains(text(),'Country i')]")
	WebElement countryblankclickonnext;
	
	@FindBy(xpath="//*[contains(text(),'Zip code i')]")
	WebElement zipcodeblankclickonnext;
	
	@FindBy(xpath="//*[contains(text(),'Phone nu')]")
	WebElement phonenumberblankclickonnext;
	
	@FindBy(xpath="//*[contains(text(),'Card n')]")
	WebElement cardnumberblankclickonnext;
	
	@FindBy(xpath="//*[@style='color:red;']")
	WebElement cardnumberincorrect;
	
	@FindBy(xpath="//*[contains(text(),'Card h')]")
	WebElement cardholderblankclickonnext;
	
	@FindBy(xpath="//*[contains(text(),'Card e')]")
	WebElement cardexpblankclickonnext;
	
	@FindBy(xpath="//*[contains(text(),'CVV c')]")
	WebElement cvvcodeblankclickonnext;
	
	@FindBy(xpath="//*[contains(text(),'Please')]")
	WebElement checkboxvalidationblank;
		
	@FindBy(xpath="//*[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//*[@name='submit']")
	WebElement popupclosesign;
	
	@FindBy(xpath="//*[@id='confirmpassword']")
	WebElement confirmpassword;
	
	@FindBy(xpath="//*[@class='btn btn-green mt-27']")
	WebElement signupnextbutton;
	
	@FindBy(xpath="//*[@id='fname']")
	WebElement firstname;
	
	@FindBy(xpath="//*[@id='lname']")
	WebElement lastname;
	
	@FindBy(xpath="//*[@id='billingAddress']")
	WebElement billingadress;
	
	@FindBy(xpath="//*[@id='city']")
	WebElement city;
	
	@FindBy(xpath="//*[@id='state']")
	WebElement state;
	
	@FindBy(xpath="//*[@formcontrolname='country']")
	WebElement country;
	
	@FindBy(xpath="//*[@id='zipCode']")
	WebElement zipcode;
	
	@FindBy(xpath="//*[@name='singupPhoneNumber']")
	WebElement phonenumber;
	
	@FindBy(xpath="//*[@name='clientInfonext']")
	WebElement clientinfonextbutton;
	
	@FindBy(xpath="//*[@formcontrolname='cardNumber']")
	WebElement cardnumber;
	
	@FindBy(xpath="//*[@formcontrolname='cardHolder']")
	WebElement cardholdername;
	
	@FindBy(xpath="//*[@formcontrolname='cardExpMonth']")
	WebElement selectmonth;
	
	@FindBy(xpath="//*[@formcontrolname='cardExpYear']")
	WebElement selectyear;
	
	@FindBy(xpath="//*[@placeholder='Enter cvv code']")
	WebElement cvvcode;
	
	@FindBy(xpath="//*[@formcontrolname='couponCode']")
	WebElement coupancode;
	
	@FindBy(xpath="//*/div[@style='float: right;']")
	WebElement coupancodeapplymessage;
	
	@FindBy(xpath="//*[@class='coupon-applied']")
	WebElement invalidcoupancode;
	
	@FindBy(xpath="//*[@name='applyCoupon']")
	WebElement applycouponbutton;
	
	@FindBy(xpath="//*[@id='termCheckBox']")
	WebElement termsofuse;
	
	@FindBy(xpath="//*[@style='color: red;']")
	WebElement termsofusevalidationmessage;
	
	@FindBy(xpath="//*[@class='alert']")
	WebElement carddeclinedmessage;
	
	@FindBy(xpath="//*[@class='btn btn-green small-width']")
	WebElement paynowbutton;
	
	public SignUpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void dropdown(String status, WebElement element){
	     Select statusDropdown=new Select(element);
	     statusDropdown.selectByVisibleText(status);
	}
	
	public String blankemailclickonnext() {
		return emailValidationnext.getText();
	}
	
	public String blankpasswordclickonnext() {
		return passwordValidationnext.getText();
	}
	
	public String blankconfirmpasswordclickonnext() {
		return confirmPasswordValidationnext.getText();
	}
	
	public String blankfirstnameclickonnext() {
		return firstnameblankonnext.getText();
	}
	
	public String blanklastnameclickonnext() {
		return lastnameblankonnext.getText();
	}
	
	public String blankbillingaddressclickonnext() {
		return billingadressblankonnext.getText();
	}
	
	public String blankcityclickonnext() {
		return cityblankclickonnext.getText();
	}
	
	public String blankstateclickonnext() {
		return stateblankclickonnext.getText();
	}
	
	public String blankcountryclickonnext() {
		return countryblankclickonnext.getText();
	}
	
	public String blankzipcodeclickonnext() {
		return zipcodeblankclickonnext.getText();
	}
	
	public String blankcradnumberclickonnext() {
		return cardnumberblankclickonnext.getText();
	}
	
	public String blankcradholderclickonnext() {
		return cardholderblankclickonnext.getText();
	}
	
	public String blankcradexpclickonnext() {
		return cardexpblankclickonnext.getText();
	}
	
	public String blankcvvcodeclickonnext() {
		return cvvcodeblankclickonnext.getText();
	}
	
	public String checkboxvalidationblankclickonnext() {
		return checkboxvalidationblank.getText();
	}
	
	public String blankphoneclickonnext() {
		return phonenumberblankclickonnext.getText();
	}
	
	public String passwordvalidationforforamte() {
		return existvalidation.getText();
	}
	
	public String emailvalidationverify() {
		return existvalidation.getText();
	}
	
	public String emailvalidationblank() {
		return validationblank.getText();
	}
	
	public String passwordvalidationverify() {
		return validationblank.getText();
		}
	
	public String confirmpasswordvalidationverify() {
		return validationblank.getText();
		}
	
	public String firstnamevalidationverify() {
		return validationblank.getText();
		}
	
	public String lastnamevalidationverify() {
		return validationblank.getText();
		}
	
	public String billingadressvalidationverify() {
		return validationblank.getText();
		}
	
	public String cityvalidationverify() {
		return validationblank.getText();
		}
	
	public String statevalidationverify() {
		return validationblank.getText();
		}
	
	public String countryvalidationverify() {
		return validationblank.getText();
		}
	
	public String zipcodevalidationverify() {
		return validationblank.getText();
		}
	
	public String phonenumbervalidationverify() {
		return validationblank.getText();
		}
	
	public String cardnumbervalidationverify() {
		return validationblank.getText();
		}
	
	public String cardholdernamevalidationverify() {
		return validationblank.getText();
		}
	
	public String cardexpiryvalidationverify() {
		return validationblank.getText();
		}
	
	public String cvvcodevalidationverify() {
		return validationblank.getText();
		}
	
	public String couponcodevalidationverify() {
		return existvalidation.getText();
		}
	
	public String invlalidcouponcodevalidatio() {
		return invalidcoupancode.getText();
		}
	
	public String cardnumberincorrectverify() {
		return cardnumberincorrect.getText();
		}
	
	public void clearEmail() {
		email.clear();
	}
	
	public void enteremail(String mail) {
		email.sendKeys(mail);
	}
	
	public void clearpassWord() {
		password.clear();
	}
	
	public void enterpassword(String pw) {
		password.sendKeys(pw);
	}
	
	public void clearconfirmpassword() {
		confirmpassword.clear();
	}
	
	public void enterconfirmpassword(String cpw) {
		confirmpassword.sendKeys(cpw);
	}
	
	public void signupnextbuttonclick() {
		signupnextbutton.click();
	}
	
	public void clearfirstname() {
		firstname.clear();
	}
	
	public void enterfirstname(String fn) {
		firstname.sendKeys(fn);
	}
	
	public void clearlastname() {
		lastname.clear();
	}
	
	public void enterlastname(String ln) {
		lastname.sendKeys(ln);
	}
	
	public void clearbillingadress() {
		billingadress.clear();
	}
	
	public void enterbillingadress(String ba){
		billingadress.sendKeys(ba);
	}
		
	public void clearcity() {
		city.clear();
	}
	
	public void entercity(String ct) {
		city.sendKeys(ct);
	}
	
	public void selectstate(String value) {
		dropdown(value, state);
	}
	
	public void selectcountry(String value) {
		dropdown(value, country);
	}
	
	public void clearzipcode() {
		zipcode.clear();
	}
	
	public void enterzipcode(String zc) {
		zipcode.sendKeys(zc);
	}
	
	public void clearphonenumber() {
		phonenumber.clear();
	}
	
	public void enterphonenumber(String pn) {
		phonenumber.sendKeys(pn);
	}
	 
	public void clientinfobuttonclick() {
		clientinfonextbutton.click();
	}
	
	public void clearcardnumber() {
		cardnumber.clear();
	}
	
	public void entercardnumber(String cn) {
		cardnumber.sendKeys(cn);	
	}
	
	public void clearcardholdername() {
		cardholdername.clear();
	}
	
	public void entercardholdername(String chn) {
		cardholdername.sendKeys(chn);
	}
	
	public void selectmonth(String value) {
		dropdown(value, selectmonth);
	}
	
	public void selectyear(String value) {
		dropdown(value, selectyear);
	}
	
	public void popupclose() throws InterruptedException{
		Thread.sleep(1000);
		popupclosesign.click();
	}
	
	public void clearcvvcode() {
		cvvcode.clear();
	}
	
	public void entercvvcode(String cvcode) {
		cvvcode.sendKeys(cvcode);
	}
	
	public void clearcoupancode() {
		coupancode.clear();
	}
	
	public void entercoupancode(String couponc) {
		coupancode.sendKeys(couponc);
	}
	
	public void applycouponbuttonclick() {
		applycouponbutton.click();
	}
	
	public void termsofusecheckbox() {
		termsofuse.click();
	}
	
	public void paynowbuttonclick() {
		paynowbutton.click();
	}
}
