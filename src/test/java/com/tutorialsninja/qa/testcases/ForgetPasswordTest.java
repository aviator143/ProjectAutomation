package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pageobjects.ForgetPasswordPage;
import com.tutorialsninja.qa.pageobjects.HomePage;
import com.tutorialsninja.qa.pageobjects.LoginPage;
import com.tutorialsninja.qa.utilities.Utility;

public class ForgetPasswordTest extends Base {
	
	HomePage homePage;
	LoginPage loginPage;
	ForgetPasswordPage forgetPassword;
	
	
public ForgetPasswordTest() {
super();	
}

public WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver=initializeBrowserAndOpenURL(prop.getProperty("browserName"));
	    homePage=new HomePage(driver);
		loginPage=homePage.navigateToLoginPage();
		 forgetPassword=loginPage.clickOnForgotOptionLink();
		
		//driver.findElement(By.xpath(" //span[text()=\"My Account\"]")).click();
		//driver.findElement(By.xpath("//a[text()='Login']")).click();
		
	}
	@Test(priority=1)
	public void verifyForgetPasswordWithValidEmail() {
		// forgetPassword=loginPage.clickOnForgotOptionLink(); This has been moved to setup method
		//forgetPassword=new ForgetPasswordPage(driver);
		//forgetPassword.clickOnForgetPasswordLink();
		//forgetPassword.enterEmailAddress(prop.getProperty("validEmail"));
		//forgetPassword.clickOnContinueButton();
		 forgetPassword.forgetPasswordWithEmailAddress(prop.getProperty("validEmail"));
		
		//String actulMessage=forgetPassword.retrieveEmailConfiremationWarningMessage();
		Assert.assertEquals(forgetPassword.retrieveEmailConfiremationWarningMessage(),(dataprop.getProperty("emailConfirmationWarning")),"Invalid Email Address");
		
	}
	@Test(priority = 2)
	public void verifyForgetPasswordWithInvalidEmailAddress() {
		//ForgetPasswordPage forgetPassword=new ForgetPasswordPage(driver);
		//forgetPassword=loginPage.clickOnForgotOptionLink();
		//forgetPassword.enterEmailAddress(Utility.genrateEmailWithTimeStamp());
		//forgetPassword.clickOnContinueButton();
		
		
         forgetPassword.forgetPasswordWithEmailAddress(Utility.genrateEmailWithTimeStamp());	
		//String actualWarning=forgetPassword.retriveEmailAddressNotMatchingText();
		Assert.assertEquals(forgetPassword.retriveEmailAddressNotMatchingText(),(dataprop.getProperty("emailAddressNotFoundWarning")),"Actual Warning message is not displayed.");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
