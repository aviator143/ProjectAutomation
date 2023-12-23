package com.tutorialsninja.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgetPasswordPage {
	WebDriver driver;
	

	@FindBy(xpath="//input[@id='input-email']")
	private WebElement emailAddressField;
	
	@FindBy(xpath="//input[@value=\"Continue\"]")
	private WebElement continueButton;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
    private WebElement emailConfermationWarningMessage;	
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement emailAddressNotFoundWarningMessage;
	
	
	
	public ForgetPasswordPage(WebDriver driver) {
	
	this.driver=driver;
	PageFactory.initElements(driver,this);
	
	}
	 
	
	 
/*	public void enterEmailAddress(String emailText) {
		emailAddressField.sendKeys(emailText);
	}
 public void clickOnContinueButton() {
	 continueButton.click();
 }
 */
 public String retrieveEmailConfiremationWarningMessage() {
	 String actualWarningMessage=emailConfermationWarningMessage.getText();
	 return actualWarningMessage;
 }
 public String retriveEmailAddressNotMatchingText() {
	 String emailAddressNotMatchingText=emailAddressNotFoundWarningMessage.getText();
	 return emailAddressNotMatchingText;
 }
 
 public void forgetPasswordWithEmailAddress(String emailText) {
	 emailAddressField.sendKeys(emailText);
	 continueButton.click();
	 
	 
 }
}
