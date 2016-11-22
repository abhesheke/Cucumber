package com.compugain.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailUtility extends WebElements{
	
	
	WebDriver driver;
	WebDriverWait driverWait;
	private static Logger logger = Logger.getLogger(EmailUtility.class);
	WebElements webelements= new WebElements(driver, driverWait);
	/**
	 * Parameterized Constructor of EmailUtility
	 * @param driver
	 * @param driverWait
	 * @param customReport
	 */
	public EmailUtility(WebDriver driver,WebDriverWait driverWait)
	{
		super(driver, driverWait);
		this.driver=driver;
		this.driverWait=driverWait;
	}

	/**
	 * Returning only email Body - Using String
	 * @param emailId
	 * @param emailName
	 * @return email Body
	 */
	public String returnEmailBodyData(String emailId,String emailName){
		
		logger.info("Class = "+logger.getName()+"\tMethod = "+new Object(){}.getClass().getEnclosingMethod().getName());
		String emailBody="";
		if(emailId.contains("sharklasers.com")){
			driver.navigate().to("https://www.guerrillamail.com");
			webelements.click("//span[@id='inbox-id']");
			webelements.clearWebElementText("//span[@class='editable button edit-in-progress']/input", driverWait);
			webelements.enterText("//span[@class='editable button edit-in-progress']/input", driverWait, emailId);
			webelements.click("//span[@id='inbox-id']/button[1]");
			webelements.click("//td[contains(text(),'"+emailName+"')]/span");
			emailBody = webelements.getText("//div[@class='email_body']/pre", driverWait);
			logger.info("Email Body Value is"+emailBody);
			return emailBody;
		}
		
		else if(emailId.contains("mailinator.com"))
		{
			driver.navigate().to("https://www.mailinator.com/");
			webelements.enterText("inboxfield", driverWait, emailId);
			webelements.click("//btn[@class='btn btn-success']");
			webelements.click("//*[contains(text(),'"+emailName+"')]");
			webelements.waitForElementPresent("//div[@class='mailview']/a", driverWait);
			emailBody = webelements.getText(("//*[@class='mailview']"), driverWait);
			
			return emailBody;
		}
		else{
			return null;
		}
	}
		
	/**
	 * Returning Email data,Email Sender,Email recipient and Email Date - Using Map
	 * @param emailId
	 * @param emailName
	 * @return Map containing emailBody,emailSender,emailRecipient,emailDate
	 */
	public Map<String,String> returnUserEmailData(String emailId,String emailName){
		logger.info("Class = "+logger.getName()+"\tMethod = "+new Object(){}.getClass().getEnclosingMethod().getName());
		Map<String,String> emailData = new HashMap<String, String>();
		if(emailId.contains("sharklasers.com")){
			driver.navigate().to("https://www.guerrillamail.com");
			webelements.click("inbox-id");
			webelements.clearWebElementText("//span[@class='editable button edit-in-progress']/input", driverWait);
			webelements.enterText("//span[@class='editable button edit-in-progress']/input", driverWait, emailId);
			webelements.click("//span[@id='inbox-id']/button[1]");
			logger.info("//td[contains(text(),'"+emailName+"')]/span");
			webelements.click("//td[contains(text(),'"+emailName+"')]/span");
			
			emailData.put("emailBody",webelements.getText(("//div[@class='email_body']/pre"), driverWait));
			emailData.put("emailSender",webelements.getText(("//div[@class='email']/p/strong[@class='email_from']"), driverWait));
			emailData.put("emailRecipient", webelements.getText(("//div[@class='email']/p/strong[@class='email_to']"), driverWait));
			emailData.put("emailDate",webelements.getText(("//div[@class='email']/p/strong[@class='email_date']"), driverWait) );
			return emailData;
		}
		else if(emailId.contains("mailinator.com"))
		{
			driver.navigate().to("https://www.mailinator.com/");
			webelements.enterText("inboxfield", driverWait, emailId);
			webelements.click("//*[contains(text(),'Check it')]");
			webelements.click("//*[contains(text(),'"+emailName+"')]");
			webelements.waitForElementPresent(("//div[@class='mailview']/a"),driverWait);
			emailData.put("emailBody", webelements.getText(("//*[@class='mailview']"), driverWait));
			return emailData;
		}
		else{
			return null;
		}
	}

	public boolean returnConformationCode(String semailId,String semailName){
		String conformationCode="Confirmation Code";
		String termsandconditions="complete online acceptance of Exostar's terms and conditions";
		    if(returnEmailBodyData(semailId, semailName).contains(conformationCode) && (returnEmailBodyData(semailId, semailName).contains(termsandconditions))){
		    	return true;
		    }
		    else{
		    	return false;
		    }
	}
	
	/**
	 * Fetching the email Bodies of all the mails within a particular mail id
	 * @param emailId
	 * @return Email body List
	 */
	public List<String> fetchAllEmailsBody(String emailId){
		driver.navigate().to("https://www.guerrillamail.com");
		
		webelements.click(("//span[@id='inbox-id']"));
		webelements.clearWebElementText(("//span[@class='editable button edit-in-progress']/input"), driverWait);
		webelements.enterText(("//span[@class='editable button edit-in-progress']/input"), driverWait, emailId);
		webelements.click(("//span[@id='inbox-id']/button[1]"));
		WebElement table =  driver.findElement(By.id("email_list"));
		List<WebElement> list = table.findElements(By.xpath("//tr/td[3]"));
		List<String> list2=new ArrayList<String>();
		for (WebElement webElement : list) {
			webElement.click();
			String emailBody = webelements.getText(("//div[@class='email_body']/pre"), driverWait);
			list2.add(emailBody);
			webelements.click(("back_to_inbox_link"));
		}
		return list2; 
	}
}
