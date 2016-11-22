/*package com.compugain.Utils;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import com.compugain.setup.Setup;

public class Webconnector implements Setup{
	
	Properties object = null;
	Properties config = null;
	WebDriver driver = null;
	WebDriver mozilla = null;
	WebDriver chrome = null;
	WebDriver ie = null;
	static Webconnector w;

		public Webconnector(){
		if(object==null){
			try{
			*//**
			 * intializing object.properties file
			 *//*
			
			object = new Properties();
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+Object_propertiesPath);
			object.load(fs);
			
			
		}catch( Exception e){
			System.out.println("Error on intialising property files");
		}
		
	 }
	
	}
		*//**
		 * intializing Browser
		 *//*
		public void openBrowser(String browserType){
			if(browserType.equals("Mozilla")){
				driver = new FirefoxDriver();
			}
			else if(browserType.equals("Chrome")){
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+CHROMEPATH);
				driver = new ChromeDriver();
			}
			else if(browserType.equals("IE")){
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"IEPATH");
				driver = new InternetExplorerDriver();
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
		}
		
		*//**
		 *Load a new web page in the current browser window.
		 *//*
		public void navigate(String URL){
			driver.get(object.getProperty(URL));
			
		}
		
		*//**
		 * Method is used to click 
		 *//*
		public void click(String ObjectName){
			driver.findElement(By.xpath(object.getProperty(ObjectName))).click();
		}
		
		*//**
		 * Method is used to enter text in a textbox
		 *//*
		
		public void type(String text, String objectName){
			driver.findElement(By.xpath(object.getProperty(objectName))).sendKeys(text);
			
		}
		
		*//**
		 * 
		 *//*
		public void select(String text, String objectName){
			driver.findElement(By.xpath(object.getProperty(objectName))).click();
		}
		
		*//**
		 * 
		 *//*
		public boolean isElement(String objectName){
			 int count = driver.findElements(By.xpath(object.getProperty(objectName))).size();
		 if(count==0){
			 return false;
			 }
		 
		else{
			return true;
			}
		}
		
		*//**
		 * Method is for mousehover
		 *//*
		public void mouseHover(String objectName){
			   Actions actions = new Actions(driver);
			   actions.moveToElement(driver.findElement(By.xpath(object.getProperty(objectName))));
			   actions.perform();
		}
		public void sendkeys() {
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.ESCAPE);
		}
		
		*//**
		 * 
		 *//*
		public static  Webconnector getInstance(){
			if(w==null);
			w= new Webconnector();
		return w;
		}
		
		
}


*/