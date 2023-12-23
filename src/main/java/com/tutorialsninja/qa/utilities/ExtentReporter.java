 package com.tutorialsninja.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static ExtentReports genrateExtentReports() {
		 ExtentReports extentReport=new ExtentReports();
		 
		 File extentReportFile=new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentreport.html");
		 ExtentSparkReporter sparkReporter=new ExtentSparkReporter(extentReportFile);
		 sparkReporter.config().setTheme(Theme.DARK);
		 sparkReporter.config().setReportName("Tutorials Ninja Test Report");
		 sparkReporter.config().setDocumentTitle("TN test result");
		 sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		 
		   extentReport.attachReporter(sparkReporter);
		   
		 Properties configProp=new Properties();
		 File configPropFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
		 FileInputStream fisconfigProperties = null;
		try {
			fisconfigProperties = new FileInputStream(configPropFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		try {
			configProp.load(fisconfigProperties);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		  
		   extentReport.setSystemInfo("Application URL", configProp.getProperty("url"));
		   extentReport.setSystemInfo("Browser Name", configProp.getProperty("browserName"));
		   extentReport.setSystemInfo("Email ", configProp.getProperty("validEmail"));
		   extentReport.setSystemInfo("Password",configProp.getProperty("validPassword"));
		   extentReport.setSystemInfo("Operating System",System.getProperty("os.name"));
		   extentReport.setSystemInfo("User Name",System.getProperty("user.name"));
		   extentReport.setSystemInfo("Java version",System.getProperty("java.version"));
		   
		   return extentReport;
		   
		 
	}
}
