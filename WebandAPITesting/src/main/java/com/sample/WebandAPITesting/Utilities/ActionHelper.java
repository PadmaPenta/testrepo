package com.sample.WebandAPITesting.Utilities;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;




public class ActionHelper{
	WebDriver driver;
	public ActionHelper(WebDriver driver){
		this.driver=driver;
	
	}
	/**
	 * This method will click on given element
	 * @param locator
	 */
	public void performClick(final By locator){		
		try {
			if(fluentWaitForElementDisplay(locator)){	
			    explicitWaitForElementClickble(locator).click();			
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will clear the textbox default value
	 * @param locator
	 */
	public void performJSClick(final By locator){		
		try {
			if(fluentWaitForElementDisplay(locator)){
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", explicitWaitForElementClickble(locator));
				executor=null;
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * This method will clear the textbox default value
	 * @param locator
	 */
	public void performClear(final By locator){		
		try {
			if(fluentWaitForElementDisplay(locator)){
				driver.findElement(locator).clear();
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will perform switch to a frame
	 * @param locator
	 */
	public void performFrameSwitch(final String frameName){		
		By locator=By.id(frameName);
		try {
			if(fluentWaitForElementDisplay(locator)){
				//explicitWaitForFrameSwitch(locator).switchTo().frame(frameName);
				fluentWaitForElementDisplay(locator);
				driver.switchTo().frame(driver.findElement(locator));
				//driver.switchTo().frame(driver.findElement(By.id("page_4_1")));
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * This method will get the innnertext of element
	 * @param locator
	 */
	public String getAttributeValue(final By locator,final String attrName){
		String text="";
		try {
			if(fluentWaitForElementDisplay(locator)){
			text= driver.findElement(locator).getAttribute(attrName);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return text;
	}
	
	
	/**
	 * This method will get the innnertext of element
	 * @param locator
	 */
	public String getElementText(final By locator){
		String text="";
		try {
			if(fluentWaitForElementDisplay(locator)){
			text= driver.findElement(locator).getText();
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return text;
	}

	/**
	 * This method will enter the given text 
	 * @param locator
	 */
	public void setText(final By locator,final String valueToBeEntered){
		try {
			if(fluentWaitForElementDisplay(locator)){
				driver.findElement(locator).sendKeys(valueToBeEntered);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 
	 * @param locator
	 */
	public void performMovetoEelment(final By locator){
		Actions moveElem = new Actions(driver);
		
		try {
			if(fluentWaitForElementDisplay(locator)){
				moveElem.moveToElement(driver.findElement(locator)).build().perform();
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 
	 * @param locator
	 */
	public int performClickOnTDBasedonText(final String tableLocator,final String text){  
		By  locatorTillTR=By.xpath(tableLocator+"/tbody/tr");
		By locatorTillTD=By.xpath(tableLocator+"/tbody/tr/td");
		boolean gotTd=false;
		int rowNum=-1;
		try {
			if(fluentWaitForElementDisplay(locatorTillTR)){
				 int rowCount=driver.findElements(locatorTillTR).size();
				 System.err.println("Rows:"+rowCount);
				 
				 for(int i=1;i<=rowCount;i++){
					 int tdCount=driver.findElements(By.xpath(tableLocator+"/tbody/tr["+i+"]/td")).size();
					 System.out.println("Tds:"+tdCount);
					 for(int j=1;j<=tdCount;j++){
					if(text.equals(driver.findElement(By.xpath(tableLocator+"/tbody/tr["+i+"]"+"/td["+j+"]")).getText())) {
						driver.findElement(By.xpath(tableLocator+"/tbody/tr["+i+"]"+"/td["+1+"]/div/span")).click();
						gotTd=true;
						break;
					}
					 }
					 if(gotTd){
						 rowNum=i;
						 break;
					 }
				 }
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowNum;
		
	}
	
	/**
	 * This method will scroll the page till the element to be viewed
	 * @param locator
	 */
	public void performScroll(final By locator){
		WebElement element = driver.findElement(locator);
		try {
			if(fluentWaitForElementDisplay(locator)){
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void performPageRefresh(){
		driver.navigate().refresh();
		
		
	}
	
	
	
	
	
	
	/**
	 * Fluent wait for ElementT
	 * @param locator
	 * @return webelement
	 */
	public WebElement fluentWait(final By locator){
	    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	       .withTimeout(30, TimeUnit.SECONDS)
	        .pollingEvery(1, TimeUnit.SECONDS)
	        .ignoring(NoSuchElementException.class)
	        .ignoring(ElementNotVisibleException.class)
	        .ignoring(StaleElementReferenceException.class);

	     	WebElement ele = wait.until(
	        new Function<WebDriver, WebElement>() {
	            public WebElement apply(WebDriver driver) {
	                return driver.findElement(locator);
	            }
	        }
	    );
	    return ele;
	}
	
	
	/**
	 * Fluent wait for ElementDisplay
	 * @param locator
	 * @return true if element display else false
	 */
	public boolean fluentWaitForElementDisplay(final By locator){
	    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	       .withTimeout(30, TimeUnit.SECONDS)
	        .pollingEvery(1000, TimeUnit.MILLISECONDS)
	        .ignoring(NoSuchElementException.class)
	        .ignoring(ElementNotVisibleException.class)
	        .ignoring(StaleElementReferenceException.class)   
	        .ignoring(NoSuchFrameException.class)
	       .ignoring(WebDriverException.class);
	     	Boolean isDisplay = wait.until(
	        new Function<WebDriver, Boolean>() {
	            public Boolean apply(WebDriver driver) {
	                return driver.findElement(locator).isDisplayed();
	            }
	        }
	    );
	    return isDisplay;
	}
	
	
	
	/**
	 * Explicit wait for Element  Clickable
	 * @param locator
	 * @return web element
	 */
	public WebElement explicitWaitForElementClickble(final By locator){
		WebDriverWait wait = new WebDriverWait(driver,30);		
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
		
	}
	
	/**
	 * Explicit wait for frame switch
	 * @param locator
	 * @return
	 */
	public WebDriver explicitWaitForFrameSwitch(final By locator){
		WebDriverWait wait = new WebDriverWait(driver,30);		
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
		
	}
	
	/**
	 * Explicit wait for frame switch
	 * @param locator
	 * @return
	 */
	public Boolean waitforElementNotPresent(final By locator){
		WebDriverWait wait = new WebDriverWait(driver,20);		
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		
	}
	public WebElement waitforElementPresent(final By locator){
		WebDriverWait wait = new WebDriverWait(driver,20);		
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
	
	public void waitUntilSelectOptionsPopulated(final Select select){
	    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	       .withTimeout(30, TimeUnit.SECONDS)
	        .pollingEvery(1000, TimeUnit.MILLISECONDS)
	        .ignoring(NoSuchElementException.class)
	        .ignoring(ElementNotVisibleException.class)
	        .ignoring(StaleElementReferenceException.class)   
	        .ignoring(NoSuchFrameException.class)
	       .ignoring(WebDriverException.class);
	     	wait.until(
	        new Function<WebDriver, Boolean>() {
	            public Boolean apply(WebDriver driver) {
	            	 return (!select.getFirstSelectedOption().getText().equalsIgnoreCase("Select"));
	            }
	        }
	    );
	   
	}
	
	public void sync(){
		try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	


}

