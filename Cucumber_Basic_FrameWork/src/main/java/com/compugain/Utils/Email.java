/*package com.compugain.Utils;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.compugain.beanfactory.BeanFactory;
import com.compugain.test.Yahoo_Login_Test;

public class Email  {
	private static Logger logger = Logger.getLogger(Email.class);
	
	
	
	WebDriver driver;
	
	WebDriverWait driverWait;
	WebElements webelements=new WebElements(driver, driverWait);
	
	
	public Email(WebDriver driver,WebDriverWait driverWait)
	{
	
		this.driver=driver;
		
		this.driverWait=driverWait;
		BeanFactory beanfactory=new BeanFactory();
		Map<String, String> map=beanfactory.getUserDetails();
	}

	
	public void emailVerfication(String emailId,String value, Map<String, String> map ) {
		  if(driver!=null)
		  {
		  
		   if(emailId.contains("@mailinator.com"))
		   {
		   By completeregistrationlocator=By.xpath("//div[@class='mailview']/a");
		   By userlink=By.xpath("//*[contains(text(),'"+value+"')]");
		   driver.findElement(By.id("inboxfield")).sendKeys(emailId);
		   driver.findElement(By.xpath("//*[contains(text(),'Check it')]")).click();
		//   pause(5000);
		  // waitForElementPresent(userlink, driverWait, ""); 
		   driver.findElement(userlink).click();
		   Thread.sleep(5000);
		   driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='mailshowdivbody']/iframe")));
		   map.setEmaillink(driver.findElement(completeregistrationlocator).getAttribute("href"));
		   logger.info("Value of the Email Link is"+mailbean.getEmaillink());
		   driver.navigate().to(driver.findElement(completeregistrationlocator).getAttribute("href"));
		   driver.switchTo().defaultContent();
		   }
		   if(emailId.contains("@sharklasers.com"))
		   {
		    logger.info("value is"+value);
		    By userlink=By.xpath("//*[contains(text(),'system@vbrick.com')]/..//*[starts-with(text(),'"+value+"')]");
		    By registrationlink = By.xpath("//a[contains(@href,'user-confirmation')]");
		    webelements.uncheck_Checkbox(By.id("use-alias"), driverWait, webelements.getpageTitle());
		    
		    driver.findElement((By.id("inbox-id"))).click();
		    driver.findElement(By.xpath("//span[@class='editable button edit-in-progress']/input")).clear();
		    driver.findElement(By.xpath("//span[@class='editable button edit-in-progress']/input")).sendKeys(emailId);
		    driver.findElement(By.xpath("//span[@id='inbox-id']/button[1]")).click();
		    Thread.sleep(5000);
		    //waitForElementPresent(userlink, driverWait, "");
		    driver.findElement(userlink).click();
		    Thread.sleep(5000);
		    mailbean.setEmaillink(driver.findElement(registrationlink).getAttribute("href"));
		    logger.info("Value of the Email Link is"+mailbean.getEmaillink());
		    driver.navigate().to(driver.findElement(registrationlink).getAttribute("href"));
		        
		   }
		  }
		  else
		  {
		   logger.info("Driver is null");
		  }
		  
		 
		  }
	
	
	
}*/
