package com.tutorialsninja.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	@FindBy(id="input-email")
	private WebElement emailField; 
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;
	
	
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement emailPasswordNotMachingWarningMessage;
	
	
	

	@FindBy(linkText = "Forgotten Password")
	private WebElement forgetenPasswordlink;
	
    
    public LoginPage(WebDriver driver ) {
          
    	this.driver=driver;
    	PageFactory.initElements(driver,this);
    	
    	
	}
    
    
    
   
    
    public AccountPage login(String emailText,String passwordText) {
    	emailField.sendKeys(emailText);
    	passwordField.sendKeys(passwordText);
    	loginButton.click();
    	return new AccountPage(driver);
    }
    
    
    public String retrieveEmailPasswordNotMatchingText() {
    	String warningText=emailPasswordNotMachingWarningMessage.getText();
    	return warningText;
    }
   
    public ForgetPasswordPage clickOnForgotOptionLink() {
    	
    	forgetenPasswordlink.click();
    	
    	return new ForgetPasswordPage(driver);
    }
    
}
