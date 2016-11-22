package com.compugain.Utils;

import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.compugain.Exception.ReasonsTimeOutException;


public abstract class WaitForElements {

	public static Logger logger = Logger.getLogger(WaitForElements.class);
	int poolFlag=4;

	/**
	 * Waits for the visibility of elements Present on the screen
	 * 
	 * @param locator
	 *            : Locator name
	 * @param wait
	 *            : WebDriverWait object
	 * @param sPageTitle
	 *            : Provide information on which page the object is not present.
	 * @return : true if object is Present
	 */
	public boolean waitForElementPresent(String locator, WebDriverWait driverWait) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		boolean flag = false;
		int i = 0;
		try {
			while (flag == false && i <= poolFlag) {
				if (driverWait.until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)))
						.isDisplayed()) {
					// logger.info("The Object is PRESENT on the page with Page title :"+sPageTitle+" with locator");
					// locator);
					flag = true;
				} else {
					/*logger.info("The Object is NOT present on the page with Page title :"
							+ sPageTitle + " with locator" + locator);
				*/	flag = false;
				}
				i++;
			}
		}catch(StaleElementReferenceException staleexception)
		{
			logger.info("Stale Element Exception Block");
			flag = false;
		}
		catch(NoSuchElementException nosuchelement)
		{
			flag = false;
		}
		catch (org.openqa.selenium.TimeoutException e) {

			Reporter.log("<font color='red'>"+"1.The Element is not visible after wait for 120 sec"+"<br>"+"2.The Object Properties have been Modified"+"<br>"+"In Page"
					+ " with locator" + locator+"</font>");
			logger.error("************The Element is not visible after wait for 120 sec:*************"
					+ locator.toString());
			  throw new ReasonsTimeOutException("");
			}
		return flag;
		}
		
	
	/**
	 * Waits for the visibility of elements Present on the screen
	 * 
	 * @param locator
	 *            : Locator name
	 * @param wait
	 *            : WebDriverWait object
	 * @param sPageTitle
	 *            : Provide information on which page the object is not present.
	 * @return : true if object is Present
	 * @throws InterruptedException 
	 */
	public String waitForElementPresentVisible(By locator, WebDriverWait driverWait,
			String sPageTitle)  {
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		String flag = "disabled";
		int i = 0;
		try {
			while (flag.equals("disabled") && i <= poolFlag) {
				if (driverWait.until(
						ExpectedConditions.visibilityOfElementLocated(locator))
						.isDisplayed()) {
					// logger.info("The Object is PRESENT on the page with Page title :"+sPageTitle+" with locator"+
					// locator);
					flag="enabled";
					logger.info("flag value is"+flag);
					logger.info("value of i is"+i);
								} else {
					logger.info("The Object is NOT present on the page with Page title :"
							+ sPageTitle + " with locator" + locator);
					flag = "disabled";
				}
				i++;
			}
		} catch(StaleElementReferenceException staleexception)
		{
			logger.info("Stale Element Exception Block");
			flag ="disabled";
		}
		catch(NoSuchElementException nosuchelement)
		{
			flag ="disabled";
		}
		return flag;
		}	

	/**
	 * Waits for the elements Present on the screen
	 * 
	 * @param locator
	 *            : Locator name
	 * @param wait
	 *            : WebDriverWait object
	 * @param sPageTitle
	 *            : Provide information on which page the object is not present.
	 * @return true if the webElement is enabled
	 */
	public boolean waitForElementEnable(By locator, WebDriverWait driverWait
			) {
		boolean flag = false;
		int i=0;
		try {
		while(flag==false && i<=poolFlag){
		if (driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator))
				.isEnabled()) {
			logger.info("The Object is ENABLED on the page with Page title : with locator"+ locator);
			flag = true;
		} else {
			logger.info("The Object is NOT ENABLED on the page with Page title : with locator"+ locator);
			flag = false;
		}
	
	i++;
	}
	
		}catch (org.openqa.selenium.TimeoutException e) {
			Reporter.log("The Element is not visible after wait for 120 sec: with locator" + locator);
			logger.error("**************The Element is not visible after wait for 120 sec:**************"
					+ locator.toString());
			  throw new ReasonsTimeOutException("");
			}
		return flag;
	}

	/**
	 * Waits for the elements Present on the screen
	 * 
	 * @param locator
	 *            : Locator name
	 * @param wait
	 *            : WebDriverWait object
	 * @param sPageTitle
	 *            : Provide information on which page the object is not present.
	 * @return : True if the text is present on the screen.
	 */
	public boolean waitForTextPresent(By locator, WebDriverWait wait,
			String sText, String sPageTitle) {
		logger.info("The Object to be located in on PAGE :" + sPageTitle);
		boolean flag = false;
		int i=0;
		try
		{
		while(flag==false && i<=poolFlag){
		if (wait.until(ExpectedConditions.textToBePresentInElement(locator,
				sText))) {
			logger.info("The TEXT IS PRESENT on the page :"+sPageTitle+" with text"+ sText);
			flag = true;
		} else {
			logger.info("The TEXT IS NOT PRESENT on the page :"+sPageTitle+" with text"+ sText);
			flag = false;

		}
		i++;
		}
		}catch (org.openqa.selenium.TimeoutException e) {
			Reporter.log("The Element is not visible after wait for 120 sec:"
					+ sPageTitle + " with locator" + locator);
			logger.error("***********The Element is not visible after wait for 120 sec:**************"
					+ locator.toString());
			  throw new ReasonsTimeOutException("");
			}
		return flag;
	}
	
	public boolean waitForElements(By locator, WebDriverWait driverWait, String sPageTitle)
	{
		boolean flag=false;
		if(driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator)) != null)
		{
			flag=true;
		}
		else
			flag=false;
		return flag;
	}
	
	/*public boolean waitforWebElement(WebDriverWait driverWait,WebElement element)
	{
		boolean flag=false;
		if(driverWait.until(ExpectedConditions.elementToBeClickable(element))!=null)
		{
			flag=true;
		}
		else
			flag=false;
		return flag;
	}*/
	public boolean waitForElement(By locator, WebDriverWait driverWait, String sPageTitle)
	{
		boolean flag=false;
		if(driverWait.until(ExpectedConditions.presenceOfElementLocated(locator)) != null)
		{
			flag=true;
		}
		else
			flag=false;
		return flag;
	}
	
	
	
}
