package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pageobjects.HomePage;
import com.tutorialsninja.qa.pageobjects.SearchPage;

public class SearchTest extends Base {
	HomePage homePage;
	SearchPage searchPage;
public SearchTest() {
	super();
}

public WebDriver driver;
	@BeforeMethod
	public void setup() {
		driver=initializeBrowserAndOpenURL(prop.getProperty("browserName"));
		homePage=new HomePage(driver);
		
	}
	@Test(priority = 1)
	public void verifySearchWithExistingProduct() {
		
		
	/*	homePage.enterValidProductInSearchBoxField(dataprop.getProperty("validProduct"));
		searchPage=homePage.clickOnSeachButton();
		
	  */  
		searchPage =homePage.searchForProduct(dataprop.getProperty("validProduct"));
		
	//String actualProduct=searchPage.retrieveValidProductName();	
		
        Assert.assertTrue(searchPage.retrieveValidProductName().contains("HP LP3065"),"Enter Valid Product in Search Box");	
	
	}
	@Test(priority = 2)
	public void verifySearchWithNonExistingProduct() {		
	/*
		homePage.enterValidProductInSearchBoxField(dataprop.getProperty("invalidProduct"));
		searchPage=homePage.clickOnSeachButton();
		*/
		searchPage=homePage.searchForProduct(dataprop.getProperty("invalidProduct"));
		
		//String actualWarning=searchPage.retrieveInvalidProductText();
        Assert.assertTrue(searchPage.retrieveInvalidProductText().contains(dataprop.getProperty("noProductMatchWarning")),"Expected Warning is not displayed");
	}
	
	@Test(priority = 3)
	public void verifySearchWithoutAnyProduct() {
		
		
		
		
		searchPage=homePage.clickOnSeachButton();
		//driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		//String actualWarning=searchPage.retriveNoProductWarningText();
        Assert.assertTrue(searchPage.retriveNoProductWarningText().contains(dataprop.getProperty("noProductMatchWarning")),"Expected Warning is not displayed");
	
	
	
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
