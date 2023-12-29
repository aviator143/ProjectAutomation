package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pageobjects.AccountPage;
import com.tutorialsninja.qa.pageobjects.HomePage;
import com.tutorialsninja.qa.pageobjects.LoginPage;
import com.tutorialsninja.qa.utilities.Utility;

public class LoginTest extends Base {
LoginPage loginPage;
AccountPage accountPage;
	
	public LoginTest() {
	super();
	}
//new comment
public WebDriver driver;
@BeforeMethod
public void setup() {
	driver=initializeBrowserAndOpenURL(prop.getProperty("browserName"));
	HomePage homePage=new HomePage(driver);
	loginPage=homePage.navigateToLoginPage();
	}


	@Test(priority=1, dataProvider = "supplyData")
	public void verifyLoginDetailsWithValidCredentials(String email,String password) {
		
		//LoginPage loginPage=new LoginPage(driver);
		//String actualTitle=accountPage.retriveMyAccountTitle();
		//String ExpectedTitle=(dataprop.getProperty("title"));
		accountPage=loginPage.login(email, password); 
		Assert.assertEquals(accountPage.retriveMyAccountTitle(),(dataprop.getProperty("title")),"Warning: No match for E-Mail Address and/or Password.");
	
	} 
	
	@DataProvider
	public Object[][] supplyData() {
		Object[][]data= Utility.getDataFromExcelSheet("Login");
		return data;
	}
	
	
	//new line
	@Test(priority =2)
	public void verifyLoginWithInvalidCredentials() {
		//LoginPage loginPage=new LoginPage(driver);
		loginPage.login(Utility.genrateEmailWithTimeStamp(), dataprop.getProperty("invalidPassword"));
		
		/*loginPage.enterEmailAddress(Utility.genrateEmailWithTimeStamp());
		loginPage.enterPasswordText(dataprop.getProperty("invalidPassword"));
		loginPage.clickOnLoginButton();
		*/
		//String errorMessage=loginPage.retrieveEmailPasswordNotMatchingText();
		
		Assert.assertTrue(loginPage.retrieveEmailPasswordNotMatchingText().contains(dataprop.getProperty("emailPasswordNoMatchWarning")));
		
	}
	//updated
	@Test(priority=3 ,invocationCount=2)
	public void verifyLoginWithInvalidEmailAndValidPassword() {
		
		/*LoginPage loginPage=new LoginPage(driver);
		loginPage.enterEmailAddress(Utility.genrateEmailWithTimeStamp());
		loginPage.enterPasswordText(prop.getProperty("validPassword"));
		loginPage.clickOnLoginButton();
		*/
		
		
	  //  String errorMessage=loginPage.retrieveEmailPasswordNotMatchingText();
		//optimized code of login
		loginPage.login(Utility.genrateEmailWithTimeStamp(),prop.getProperty("validPassword")); 		
	    Assert.assertTrue(loginPage.retrieveEmailPasswordNotMatchingText().contains(dataprop.getProperty("emailPasswordNoMatchWarning")));
	}
	
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
