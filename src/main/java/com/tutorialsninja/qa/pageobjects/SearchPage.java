package com.tutorialsninja.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	 WebDriver driver;
	

	@FindBy(linkText = "HP LP3065")
	private WebElement validProductName;
	
	
	
	@FindBy(xpath="//input[@id='button-search']/following-sibling::p")
	private WebElement invalidProductWarningText;
	
	@FindBy(xpath="//input[@id='button-search']/following-sibling::p")
	private WebElement noproductMatchingText;
	
	public SearchPage(WebDriver driver) {
	
	this.driver=driver;	
	PageFactory.initElements(driver,this);
	
	
	}
	
	
	public String retrieveValidProductName() {
	String validProductText=validProductName.getText();
	return validProductText;
}
    public String retrieveInvalidProductText() {
    String invalidProductText=invalidProductWarningText.getText();
    return invalidProductText;
}

    public String retriveNoProductWarningText() {
    	String noproductWarningText=noproductMatchingText.getText();
    	return noproductWarningText;
    }

}
