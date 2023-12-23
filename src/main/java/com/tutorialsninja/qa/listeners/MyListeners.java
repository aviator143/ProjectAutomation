package com.tutorialsninja.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialsninja.qa.utilities.ExtentReporter;
import com.tutorialsninja.qa.utilities.Utility;

public class MyListeners implements ITestListener {
	
	ExtentReports extentReport;
	ExtentTest extentTest;
	String testName;
	
	@Override
	public void onStart(ITestContext context) {
	
	 extentReport=ExtentReporter.genrateExtentReports();
		
		
		
	}
	

	@Override
	public void onTestStart(ITestResult result) {
		
		 testName=result.getName();
	    extentTest = extentReport.createTest(testName);
	    extentTest.log(Status.INFO, testName+"Start Executing");
	    		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		extentTest.log(Status.PASS,testName+"got succesfully executed");
		
			
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
		//first of all retrive the driver
		WebDriver driver=null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			
			e.printStackTrace();
		}
		String destScreenshotPath = Utility.captureScreenshot(driver,result.getTestName());
		
        extentTest.addScreenCaptureFromPath(destScreenshotPath);
        extentTest.log(Status.INFO,result.getThrowable());
        extentTest.log(Status.FAIL,testName+"got Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		 testName=result.getName();
		extentTest.log(Status.INFO,result.getThrowable());
		extentTest.log(Status.SKIP,testName+"got skipped");
		System.out.println(testName+"Test is skipped");
		System.out.println(result.getThrowable());
	}



	@Override
	public void onFinish(ITestContext context) {
		
		extentReport.flush();
		 String extentReportPath=System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentreport.html";
		File destExtentRepot=new File(extentReportPath);
		 
		 try {
			Desktop.getDesktop().browse(destExtentRepot.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
