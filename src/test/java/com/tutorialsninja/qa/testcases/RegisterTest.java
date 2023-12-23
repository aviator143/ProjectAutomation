package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pageobjects.AccountSuccessPage;
import com.tutorialsninja.qa.pageobjects.HomePage;
import com.tutorialsninja.qa.pageobjects.RegisterPage;
import com.tutorialsninja.qa.utilities.Utility;




public class RegisterTest extends Base {
	HomePage homePage;
	RegisterPage registerPage;
    AccountSuccessPage accountSuccessPage;	
	public RegisterTest() {
	super();
	}
	

public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver=initializeBrowserAndOpenURL(prop.getProperty("browserName"));
	    homePage=new HomePage(driver);
		registerPage=homePage.navigateTORegisterPage();
		
	}
	
	@Test(priority = 1)
	public void verifyRegisterAccountWithMandatoryFields() {
		//click on my account select login 
        /* Pom with page factory xpaths are not hardcoded 
		 * 
		registerPage.enterFirstName(dataprop.getProperty("firstName"));
		registerPage.enterLastName(dataprop.getProperty("lastName"));
		registerPage.enterEmailAddress(Utility.genrateEmailWithTimeStamp());
		registerPage.entertelephhoneNumber(dataprop.getProperty("telephoneNumber"));
		registerPage.enterPasswordField(prop.getProperty("validPassword"));
		registerPage.enterConfirmPasswordField(prop.getProperty("validPassword"));
		registerPage.clickonPrivacyPolicyCheckBox();
		accountSuccessPage=registerPage.clickOnConinuteButton();
		 */
		
	
				
		/*
		 * old code with xpath hardcoding
		 * 
		 * driver.findElement(By.xpath("//input[@id=\"input-firstname\"]")).sendKeys(dataprop.getProperty("firstName"));    
        driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(dataprop.getProperty("lastName"));
        
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utility.genrateEmailWithTimeStamp());
        
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(dataprop.getProperty("telephoneNumber"));
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("ValidPassword"));
        driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(prop.getProperty("ValidPassword"));
	    driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	    driver.findElement(By.xpath("//input[@class=\"btn btn-primary\"]")).click();
	    String actualSuccessHeading=driver.findElement(By.xpath("//div[@id=\"content\"]/h1")).getText();
	    
	     String actualSuccessHeading=accountSuccessPage.retriveAccountSuccessPageHeading();
	    
	    String expectedAccountCreatedHeading=dataprop.getProperty("expectedAccountCreatedHeading");
	*/
		
		accountSuccessPage=registerPage.registerWithMandatoryFields(dataprop.getProperty("firstName"), dataprop.getProperty("lastName"), Utility.genrateEmailWithTimeStamp(), dataprop.getProperty("telephoneNumber"), prop.getProperty("validPassword"), prop.getProperty("validPassword"));
        Assert.assertEquals(accountSuccessPage.retriveAccountSuccessPageHeading(),dataprop.getProperty("expectedAccountCreatedHeading"),("Warning: E-Mail Address is already registered!"));
	  

	  
	 
	}
	@Test(priority=2)
	
	public void verifyRegisterPageByProvidingAllTheFields() {
		
		/*
		  registerPage.enterFirstName(dataprop.getProperty("firstName"));
		 
		registerPage.enterLastName(dataprop.getProperty("lastName"));
		registerPage.enterEmailAddress(Utility.genrateEmailWithTimeStamp());
		registerPage.entertelephhoneNumber(dataprop.getProperty("telephoneNumber"));
		registerPage.enterPasswordField(prop.getProperty("validPassword"));
		registerPage.enterConfirmPasswordField(prop.getProperty("validPassword"));
	    registerPage.clickOnyesNewsletterOption();
		registerPage.clickonPrivacyPolicyCheckBox();
		accountSuccessPage=registerPage.clickOnConinuteButton();

		String actualSuccessHeading=accountSuccessPage.retriveAccountSuccessPageHeading();
	    Reporter.log(actualSuccessHeading,true);	   
	    String expectedAccountCreatedHeading=dataprop.getProperty("expectedAccountCreatedHeading");
	    Assert.assertEquals(actualSuccessHeading,expectedAccountCreatedHeading,("Warning: E-Mail Address is already registered!"));
	  */
		accountSuccessPage=registerPage.registerWithAllFields(dataprop.getProperty("firstName"), dataprop.getProperty("lastName"), Utility.genrateEmailWithTimeStamp(), dataprop.getProperty("telephoneNumber"), prop.getProperty("validPassword"), prop.getProperty("validPassword"));
	    Assert.assertEquals(accountSuccessPage.retriveAccountSuccessPageHeading(),dataprop.getProperty("expectedAccountCreatedHeading"),("Warning: E-Mail Address is already registered!"));

		 
        
        	}
	
@Test(priority=3)
public void verifyRegstringByProvidingExistingAccountDetails() {
	
	/*	
		registerPage.enterFirstName(dataprop.getProperty("firstName"));
		registerPage.enterLastName(dataprop.getProperty("lastName"));
		registerPage.enterEmailAddress(prop.getProperty("validEmail"));
		registerPage.entertelephhoneNumber(dataprop.getProperty("telephoneNumber"));
		registerPage.enterPasswordField(prop.getProperty("validPassword"));
		registerPage.enterConfirmPasswordField(prop.getProperty("validPassword"));
	    registerPage.clickOnyesNewsletterOption();
		registerPage.clickonPrivacyPolicyCheckBox();
		accountSuccessPage=registerPage.clickOnConinuteButton();
	    String actualWarningHeading=registerPage.retrieveExistingAccountWarningMessage();
*/
		
	    accountSuccessPage=registerPage.registerWithAllFields(dataprop.getProperty("firstName"), dataprop.getProperty("lastName"), prop.getProperty("validEmail"), dataprop.getProperty("telephoneNumber"), prop.getProperty("validPassword"), prop.getProperty("validPassword"));
	
		Assert.assertEquals(registerPage.retrieveExistingAccountWarningMessage(),(dataprop.getProperty("duplicateEmailWarning")),"Warning message reguarding duplicate email is not displayed");
	
}
	@Test(priority=4)
public void verifyRegisterAccountWithoutFillingAnyDetails() {
	
	    registerPage.clickOnContinueButton();
	   
	    /* 	    
	   // String actualPrivacyPolicyWarning=registerPage.retrievePrivacyPolicyWarning();
	    Assert.assertTrue(registerPage.retrievePrivacyPolicyWarning().contains(dataprop.getProperty("actualPrivacyWarning")),"privacy policy warning message is not displayed");
	    
	    //String firstNameWarning=registerPage.retrieveFirstNameWarning();
	    Assert.assertTrue(registerPage.retrieveFirstNameWarning().contains(dataprop.getProperty("firstNameWarning")),"First Name Warning message is not displayed.");
	    
	    //String lastNameWarning=registerPage.retriveLastNameWarning();
	    Assert.assertTrue(registerPage.retriveLastNameWarning().contains(dataprop.getProperty("lastNameWarning")),"Last Name Warning messages is not displayed.");
	    
	   // String emailWarning=registerPage.retriveEmailNameWarning();
	    Assert.assertTrue(registerPage.retriveEmailNameWarning().contains(dataprop.getProperty("emailWarning")),"Email Warning message is not displayed");
	    
	    //String telephoneWarning=registerPage.retriveTelephoneWarning();
	    Assert.assertTrue(registerPage.retriveTelephoneWarning().contains(dataprop.getProperty("telephoneWarning")),"Telephone Warning message is not displayed");
	    
	   // String passwordWarning=registerPage.retrivepasswordWarning();
	    Assert.assertTrue(registerPage.retrivepasswordWarning().contains(dataprop.getProperty("passwordWarning")),"Expected warning message is not displayed");
	    */
	    
	    registerPage.displayStatusOfWarningMessages(dataprop.getProperty("actualPrivacyWarning"), dataprop.getProperty("firstNameWarning"), dataprop.getProperty("lastNameWarning"), dataprop.getProperty("emailWarning"), dataprop.getProperty("telephoneWarning"), dataprop.getProperty("passwordWarning"));

	
	}
	
	
	@AfterMethod
	public void tearDown() {
	driver.quit();
	}
	
		
	}

