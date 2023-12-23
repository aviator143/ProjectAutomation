package com.tutorialsninja.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

	 WebDriver driver;
	
	@FindBy(xpath = "//div[@id='content']/h2[text()='My Account']")
	private WebElement title;
	
	public AccountPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
		
	}
	
	public String retriveMyAccountTitle() {
	 String myAccounttitle=title.getText();
	return myAccounttitle;
	
		
	}
	
}
