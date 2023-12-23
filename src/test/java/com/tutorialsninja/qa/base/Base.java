package com.tutorialsninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tutorialsninja.qa.utilities.Utility;

public class Base {
 public WebDriver driver;
 public Properties prop;
public Properties dataprop;

public Base() {

	  prop=new Properties();
	  File propFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
	
      dataprop=new Properties();
	  File datapropFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\testdata.properties");
	
			 
	try { 
	 FileInputStream fisData=new FileInputStream(datapropFile);
	 dataprop.load(fisData);
	}
	catch(Throwable e) {
		e.printStackTrace();
	}
	 
	 
	 try {
	 FileInputStream fis=new FileInputStream(propFile)	;
	 prop.load(fis);
	}catch (Throwable e) {
		e.printStackTrace();
	}
	}
	
	public WebDriver initializeBrowserAndOpenURL(String browserName) {
		
		
		
		if(browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utility.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utility.PAGE_LOAD_TIME ));
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		
		 
		return driver;
	}
	
	
	
	
}
