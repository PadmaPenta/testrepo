package com.sample.WebandAPITesting.Tests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sample.WebandAPITesting.Pages.SignupPage;
import com.sample.WebandAPITesting.Utilities.BaseTest;

public class SignUpTest extends BaseTest{	
	WebDriver driver = null;;
	SoftAssert softAssert = new SoftAssert();
	SignupPage signUpPage = null;
	
	@BeforeSuite
	public void setUp(){
		driver = getDriverInstance();
		signUpPage=new SignupPage(driver);
	}
	
	
	@Test(priority=1)
	public void createAccountWithoutEmail(){	
		logger = extent.startTest("TestCase : 'createAccountWithoutEmail' has been started");
		boolean isEmailErrorExists=signUpPage.createAccountWithoutEmail();
		softAssert.assertTrue(isEmailErrorExists, "Trying to create an account without email");
	}
	
	@Test(priority=2)
	public void createAccountWithoutReTypeEmail(){	
		logger = extent.startTest("TestCase : 'createAccountWithoutReTypeEmail' has been started");
		boolean isEmailReTypeErrorExists=signUpPage.createAccountWithoutReTypeEmail();
		softAssert.assertTrue(isEmailReTypeErrorExists, "Trying to create an account without re-typing email");
	}
	
	@Test(priority=3)
	public void createAccountWithoutPassword(){	
		logger = extent.startTest("TestCase : 'createAccountWithoutPassword' has been started");
		boolean isPwdErrorExists=signUpPage.createAccountWithoutPassword();
		softAssert.assertTrue(isPwdErrorExists, "Trying to create an account without password");
	}
	
	@Test(priority=4)
	public void createAccountWithoutdata(){	
		logger = extent.startTest("TestCase : 'createAccountWithoutData' has been started");
		boolean areEmailandPwdErrorExists=signUpPage.createAccountWithoutdata();		
		softAssert.assertTrue(areEmailandPwdErrorExists, "Trying to create an account without email and password");
	}
	
	@Test(priority=5)
	public void createAccountWithPwdLessthan8chars(){	
		logger = extent.startTest("TestCase : 'createAccountWithPwdLessthan8chars' has been started");
		boolean isPwdErrorExists=signUpPage.createAccountWithPwdLessthan8chars();	
		softAssert.assertTrue(isPwdErrorExists, "Trying to create an account with lessthan 8 chars in pwd");
	}
	
	@Test(priority=6)
	public void createAccountWithinvalidEmail(){	
		logger = extent.startTest("TestCase : 'createAccountWithinvalidEmail' has been started");
		boolean isEmailErrorExists=signUpPage.createAccountWithinvalidEmail();
		softAssert.assertTrue(isEmailErrorExists, "Trying to create an account with invalid email id");
	}
	
	@Test(priority=7)
	public void createAccountWithMismatchReTypeEmail(){	
		logger = extent.startTest("TestCase : 'createAccountWithMismatchReTypeEmail' has been started");
		boolean isReTypeEmailErrorExists=signUpPage.createAccountWithMismatchReTypeEmail();
		softAssert.assertTrue(isReTypeEmailErrorExists, "Trying to create an account with a mismatch in Email Retype input");
	}
	
	@Test(priority=8)
	public void createAccountWithValidData(){	
		logger = extent.startTest("TestCase : 'createAccountWithValidData' has been started");
		boolean isSignedIn=signUpPage.createAccountWithValidData();
		softAssert.assertTrue(isSignedIn, "Create An Account with Valid data");
	}
	
	
	 @AfterSuite
	  public void tearDown(){
		  driver.quit();
	  }
	
	
	
	
}