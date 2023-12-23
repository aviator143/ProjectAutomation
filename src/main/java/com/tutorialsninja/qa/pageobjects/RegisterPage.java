package com.tutorialsninja.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
WebDriver driver;

	@FindBy (xpath = "//input[@id='input-firstname']")
	private WebElement firstNameField;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	private WebElement lastNameField;
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement emailAddressField;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	private WebElement telephoneField;
	
	@FindBy(xpath="//input[@id='input-password']")
    private WebElement passwordField;
	
	@FindBy (xpath= "//input[@id='input-confirm']")
	private WebElement confirmPasswordField;

	@FindBy (xpath="//input[@type='checkbox']")
	private WebElement privacyPolicyCheckBox;
	
	@FindBy (xpath="//input[@class='btn btn-primary']")
	private WebElement continueButton;

	
	@FindBy(xpath="//input[@name='newsletter'][@value=1]")
	private WebElement yesNewsletterOption;
	
	
	@FindBy(xpath="//div[contains(@class,'alert')]")
	private WebElement existingpAccountWarningMessage;
	
	@FindBy(xpath="//div[contains(@class,'alert')]")
	private WebElement privacyPolicyWarning;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement fistNameWarning;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement emailwarning;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;
	
	
	
	
	public RegisterPage(WebDriver driver) {
		
	this.driver=driver;	
   PageFactory.initElements(driver,this);
   
   
   
	}
	
	
	
	public AccountSuccessPage clickOnContinueButton() {
       continueButton.click();
       return new AccountSuccessPage(driver);
	
	}
	
	public AccountSuccessPage registerWithMandatoryFields(String firstNameText,String lastNameText,String emailAddressText,String telephoneText ,String passwordFieldText,String confirmPasswordFiledText) {
		
		firstNameField.sendKeys(firstNameText);
		lastNameField.sendKeys(lastNameText);
		emailAddressField.sendKeys(emailAddressText);
		telephoneField.sendKeys(telephoneText);
		passwordField.sendKeys(passwordFieldText);
		confirmPasswordField.sendKeys(confirmPasswordFiledText);
		privacyPolicyCheckBox.click();
		continueButton.click();
		return new AccountSuccessPage(driver);
	
	}
	
	public AccountSuccessPage registerWithAllFields(String firstNameText,String lastNameText,String emailAddressText,String telephoneText ,String passwordFieldText,String confirmPasswordFiledText) {
		firstNameField.sendKeys(firstNameText);
		lastNameField.sendKeys(lastNameText);
		emailAddressField.sendKeys(emailAddressText);
		telephoneField.sendKeys(telephoneText);
		passwordField.sendKeys(passwordFieldText);
		confirmPasswordField.sendKeys(confirmPasswordFiledText);
		yesNewsletterOption.click();
		privacyPolicyCheckBox.click();
		continueButton.click();
		return new AccountSuccessPage(driver);
	
		
	}
	
	
	
	public String retrieveExistingAccountWarningMessage() {
    String duplicateWarningMessage=existingpAccountWarningMessage.getText();
	
	return duplicateWarningMessage;
			
	}
	/*
	public String retrievePrivacyPolicyWarning() {
    String privacyPolicyWarningText=privacyPolicyWarning.getText();
	
	return privacyPolicyWarningText;
	}
	public String retrieveFirstNameWarning() {
		String firstNameWarningText=fistNameWarning.getText();
		return firstNameWarningText;
	}
	
	public String retriveLastNameWarning() {
		String lastNameWarningText=lastNameWarning.getText();
		return lastNameWarningText;
	}
	public String retriveEmailNameWarning() {
		String emailWarningText=emailwarning.getText();
		return emailWarningText;
	}
	public String retriveTelephoneWarning() {
		String TelephoneWarningText=telephoneWarning.getText();
		return TelephoneWarningText;
	}
   
	 
	public String retrivepasswordWarning() {
		String passwordWarningText=passwordWarning.getText();
		return passwordWarningText;
	}
	*/
	
	public boolean displayStatusOfWarningMessages(String expectedPrivacyPolicyWarning,String expectedFirstNameWarning,String expectedLastNameWarning,String expectedEmailWarning,String expectedTelephoneWarning,String expectedPasswordWarning) {
	    boolean privacyPolicyWarningStatus=privacyPolicyWarning.getText().contains(expectedPasswordWarning);
	    boolean firstNameWarningStatus=fistNameWarning.getText().contains(expectedFirstNameWarning);
	    boolean LastNameWarningStatus=lastNameWarning.getText().contains(expectedLastNameWarning);
	    boolean emailWarningStatus=emailwarning.getText().contains(expectedEmailWarning);
	    boolean telephoneWarningStatus=telephoneWarning.getText().contains(expectedTelephoneWarning);
	    boolean passwordWarningStatus=passwordWarning.getText().contains(expectedPasswordWarning);
		return privacyPolicyWarningStatus && firstNameWarningStatus &&LastNameWarningStatus && emailWarningStatus &&telephoneWarningStatus &&passwordWarningStatus;
		
		
		
	}


}





