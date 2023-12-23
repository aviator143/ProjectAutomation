package com.tutorialsninja.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
    @FindBy(xpath = "//span[text()='My Account']")
    
	private WebElement myAccountDropMenu;
	
    @FindBy(linkText = "Register")
    private WebElement registerOption;
    
    @FindBy(xpath="//a[text()='Login']")
    private WebElement loginOption;
    
	@FindBy(xpath="//input[@class='form-control input-lg']")
	private WebElement searchBoxField;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;
	
    
    public HomePage(WebDriver driver) {
          
    	this.driver=driver;
    	PageFactory.initElements(driver,this);
    	
    	
	}
    
    
    public LoginPage navigateToLoginPage() {
    	myAccountDropMenu.click();
    	
    	loginOption.click();
    	return new LoginPage(driver);	
    }
    
    
    

    public RegisterPage navigateTORegisterPage() {
    	myAccountDropMenu.click();
    	registerOption.click();
		return new RegisterPage(driver);
    	
    	
    }
    /*
 
    public void enterValidProductInSearchBoxField(String validProdctText) {
		searchBoxField.sendKeys(validProdctText);
		
	}*/
    
	public SearchPage clickOnSeachButton() {
		searchButton.click();
		return new SearchPage(driver);
	}
	
	public SearchPage searchForProduct(String validProductText) {
		searchBoxField.sendKeys(validProductText);
		searchButton.click();
		return new  SearchPage(driver);
		
	}
	
    
    
}
