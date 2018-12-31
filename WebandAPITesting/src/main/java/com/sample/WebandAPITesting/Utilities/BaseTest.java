
package com.sample.WebandAPITesting.Utilities;

import java.text.SimpleDateFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest{
	protected WebDriver driver=null;
	protected ExtentReports extent;
	protected ExtentTest logger;
	
  
	public WebDriver getDriverInstance() {
	  DesiredCapabilities handlSSLErr = DesiredCapabilities.chrome ();
	  handlSSLErr.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(PropertiesHelper.getProperty("config","url"));	
		driver.manage().window().maximize();
		return driver;
		
	}
  @BeforeTest
	 public void startReport(){		
	 try {
		 
		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		 String currentTimeStamp=simpleDateFormat.format(System.currentTimeMillis());
		 extent = new ExtentReports (System.getProperty("user.dir") +"\\ExtentReporting\\"+currentTimeStamp+"-report.html",false);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 }
  @AfterMethod
	 public void getResult(ITestResult result){
	 if(result.getStatus() == ITestResult.FAILURE){
	 logger.log(LogStatus.FAIL, "Test CaseName : " +result.getName());	 
	 logger.log(LogStatus.FAIL, "Reason : " +result.getThrowable());
	 }
	 else if(result.getStatus() == ITestResult.SUCCESS){
		 logger.log(LogStatus.PASS, "Test Case got passed");	
	}else if(result.getStatus() == ITestResult.SKIP){
	 logger.log(LogStatus.SKIP, "TestCase Name : " + result.getName());	
	 }
	 extent.endTest(logger);
	}
  @AfterTest
	 public void endReport(){
	        extent.flush();
	        extent.close();
	    }
}