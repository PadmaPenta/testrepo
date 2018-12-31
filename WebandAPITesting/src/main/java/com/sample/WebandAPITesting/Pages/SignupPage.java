package com.sample.WebandAPITesting.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sample.WebandAPITesting.Utilities.ActionHelper;
import com.sample.WebandAPITesting.Utilities.PropertiesHelper;

public class SignupPage extends ActionHelper{
	
	public SignupPage(WebDriver driver) {
		super(driver);
	}
	By signin = By.linkText("Sign in");
	
	By createAccountLink = By.xpath("//span[contains(text(),'Not a member? Create an account free')]");
	
	By emailInput =  By.id("register_email");
	
	By emailRetypeInput = By.id("register_retype_email");
	
	By pwdInput = By.id("register_password");
	
	By createAccountButton = By.xpath("//button[contains(text(),'Create Account')]");
	
	By pwdError = By.id("label-register_password-error");
	
	By emailEror = By.id("label-register_email-error");
	
	By emailReTypeError = By.id("label-register_retype_email-error");
	
	/**
	 * 
	 * @return
	 */
	public boolean createAccountWithoutEmail(){
		boolean isEmailErrorExists=false;
		performClick(signin);
		performClick(createAccountLink);
		setText(pwdInput,PropertiesHelper.getProperty("testdata","validpwd"));
		performClick(createAccountButton);
		String actualEmailErrorText=getElementText(emailEror);	
		if(PropertiesHelper.getProperty("testdata","emailerrortext").equalsIgnoreCase(actualEmailErrorText)){
			isEmailErrorExists=true;			
		}
		performPageRefresh();
		return isEmailErrorExists;
	}
	/**
	 * 
	 * @return
	 */
	public boolean createAccountWithoutReTypeEmail(){
		boolean isEmailReTypeErrorExists=false;		
		setText(emailInput,PropertiesHelper.getProperty("testdata","validemail"));
		setText(pwdInput,PropertiesHelper.getProperty("testdata","validpwd"));
		performClick(createAccountButton);
		String actualEmailReTypeErrorText=getElementText(emailReTypeError);	
		if(PropertiesHelper.getProperty("testdata","emailretypeerrortext").equalsIgnoreCase(actualEmailReTypeErrorText)){
			isEmailReTypeErrorExists=true;			
		}	
		performPageRefresh();
		performClear(emailInput);
		return isEmailReTypeErrorExists;
	}
	/**
	 * 
	 * @return
	 */
	public boolean createAccountWithoutPassword(){
		boolean isPwdErrorExists=false;
		setText(emailInput,PropertiesHelper.getProperty("testdata","validemail"));
		setText(emailRetypeInput,PropertiesHelper.getProperty("testdata","validemail"));
		performClick(createAccountButton);
		String actualPwdErrorText=getElementText(pwdError);	
		if(PropertiesHelper.getProperty("testdata","pwderrortext").equalsIgnoreCase(actualPwdErrorText)){
			isPwdErrorExists=true;			
		}	
		performPageRefresh();
		performClear(emailInput);
		return isPwdErrorExists;
	}
	/**
	 * 
	 * @return
	 */
	public boolean createAccountWithoutdata(){
		boolean areEmailandPwdErrorExists=false;
		performClick(createAccountButton);
		String actualEmailErrorText=getElementText(emailEror);
		String actualPwdErrorText=getElementText(pwdError);
		String expectedEmailErrorText= PropertiesHelper.getProperty("testdata","emailerrortext");
		String expectedPwdErrorText= PropertiesHelper.getProperty("testdata","pwderrortext");
		if((expectedEmailErrorText.equalsIgnoreCase(actualEmailErrorText))&&(expectedPwdErrorText.equalsIgnoreCase(actualPwdErrorText))){
			areEmailandPwdErrorExists=true;			
		}
		performPageRefresh();
		return areEmailandPwdErrorExists;
	}
	/**
	 * 
	 * @return
	 */
	public boolean createAccountWithPwdLessthan8chars(){
		boolean isPwdErrorExists=false;
		String email=PropertiesHelper.getProperty("testdata","validemail");
		setText(emailInput,email);
		setText(emailRetypeInput,email);
		setText(pwdInput,PropertiesHelper.getProperty("testdata","invalidpwd"));
		performClick(createAccountButton);
		String actualPwdErrorText=getElementText(pwdError);	
		if(PropertiesHelper.getProperty("testdata","pwderrortextforlessthan3chars").equalsIgnoreCase(actualPwdErrorText)){
			isPwdErrorExists=true;			
		}	
		performPageRefresh();
		performClear(emailInput);
		return isPwdErrorExists;
	}
	public boolean createAccountWithinvalidEmail(){
		boolean isEmailErrorExists=false;
		String email=PropertiesHelper.getProperty("testdata","invalidemail");
		setText(emailInput,email);
		setText(emailRetypeInput,email);
		setText(pwdInput,PropertiesHelper.getProperty("testdata","validpwd"));
		performClick(createAccountButton);
		String actualEmailErrorText=getElementText(emailEror);	
		if(PropertiesHelper.getProperty("testdata","invalidemailaddresserrortext").equalsIgnoreCase(actualEmailErrorText)){
			isEmailErrorExists=true;			
		}	
		performPageRefresh();
		performClear(emailInput);
		return isEmailErrorExists;
	}
	public boolean createAccountWithMismatchReTypeEmail(){
		boolean isReTypeEmailErrorExists=false;
		String email=PropertiesHelper.getProperty("testdata","validemail");
		String reTypeEmail=PropertiesHelper.getProperty("testdata","mismatchemail");
		setText(emailInput,email);
		setText(emailRetypeInput,reTypeEmail);
		setText(pwdInput,PropertiesHelper.getProperty("testdata","validpwd"));
		performClick(createAccountButton);
		String actualReTypeEmailErrorExists=getElementText(emailReTypeError);	
		if(PropertiesHelper.getProperty("testdata","mismatchwithretypeemail").equalsIgnoreCase(actualReTypeEmailErrorExists)){
			isReTypeEmailErrorExists=true;			
		}	
		performPageRefresh();
		performClear(emailInput);
		return isReTypeEmailErrorExists;
	}
	/**
	 * 
	 * @return
	 */
	public boolean createAccountWithValidData(){
		boolean isSignedIn;
		String email=PropertiesHelper.getProperty("testdata","validemail");
		setText(emailInput,email);
		setText(emailRetypeInput,email);
		setText(pwdInput,PropertiesHelper.getProperty("testdata","validpwd"));
		performClick(createAccountButton);
		By userEmailInHomePage=By.xpath("//span[contains(text(),'"+email+"')]");
		isSignedIn=fluentWaitForElementDisplay(userEmailInHomePage);
		return isSignedIn;		
	}
}
