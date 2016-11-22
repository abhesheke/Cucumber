
package com.compugain.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.compugain.setup.Setup;


/**
 * 
 * All the WebElements would be handled here.
 * 
 */
public class WebElements extends WaitForElements implements Setup {

	/*WebDriver driver;*/
	WebDriverWait driverWait;
	public int grid=1;
	public long WAIT = 60;
	public WebDriver driver;
	public WebDriverWait wait;
	public FirefoxProfile profile;
	public String surl,sUserName,sPassword,sEnvironment;
    public static final String language="en";
    Properties object = null;
//	private static Logger logger = Logger.getLogger(TestBase.class);
	
	

private static Logger logger = Logger.getLogger(WebElements.class);

	int maxTimeout=60;
	
	public WebElements(WebDriver driver, WebDriverWait driverWait) {
		this.driver = driver;
		this.driverWait = driverWait;
		if(object==null){
			try{
			/**
			 * intializing object.properties file
			 */
			
			object = new Properties();
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+sOBJECT_PROPERTIESPATH);
			object.load(fs);
			
			
		}catch( Exception e){
			System.out.println("Error on intialising property files");
		}
		
	 }
	}
	
	public Map<String,WebElement> validateLocators(Map<String, String> locatorsmap,WebDriver driver)
	{
	 WebElement element = null;
	 Map<String, WebElement> map= new HashMap<String, WebElement>();
	 System.out.println("@@@@@@@@@@@@@@@@@@@"+locatorsmap.get("Name"));
	 System.out.println("@@@@@@@@@@@@@@@@@@@"+locatorsmap.get("ID"));
	 System.out.println("@@@@@@@@@@@@@@@@@@@"+locatorsmap.get("Xpath"));
	logger.info("The value in webelemt map is"+locatorsmap.get("DXpath"));


	for(Map.Entry<String, String> entry: locatorsmap.entrySet()){
		logger.info("i am in locators map block");
		System.out.println("The entry value is"+entry.getKey());
		if (entry.getKey().equalsIgnoreCase("Name")) {
			logger.info(" Name block");
			
			
			//if (waitForElementPresent((By.name(locatorsmap.get("Name"))),driverWait, getpageTitle())) {
				logger.info("name block");
				element=driver.findElement(By.name(locatorsmap.get("Name")));
				map.put("Name", element);
				break;
//			}
		}
			else if (entry.getKey().equalsIgnoreCase("ID")){
			logger.info("ID block");
			//if(waitForElementPresent((By.id(locatorsmap.get("ID"))),driverWait, getpageTitle())) 
			{
				element = driver.findElement(By.id(locatorsmap.get("ID")));
				map.put("ID", element);
				break;
			}
			}
			else if (entry.getKey().equalsIgnoreCase("Xpath")){
			logger.info("Xpath Block");
			//if(waitForElementPresent((By.xpath(locatorsmap.get("Xpath"))), 	driverWait, getpageTitle())) {
				logger.info("Xpath Block");
				element=driver.findElement(By.xpath(locatorsmap.get("Xpath")));
				map.put("Xpath", element);
				break;
			//}
		}
				else if (entry.getKey().equalsIgnoreCase("DXpath")){
				//if(waitForElementPresent((By.xpath(locatorsmap.get("DXpath"))), driverWait, getpageTitle())) {
					logger.info("DXpath Block");
					element=driver.findElement(By.xpath(locatorsmap.get("DXpath")));
					map.put("DXpath", element);
					break;
			}
		}
	//
	
	return map ;
}
	public boolean isElement(String objectName){
		 int count = driver.findElements(By.xpath(object.getProperty(objectName))).size();
	 if(count==0){
		 return false;
		 }
	 
	else{
		return true;
		}
	}
	
		
	public void type(String text, String objectName){
		driver.findElement(By.xpath(object.getProperty(objectName))).sendKeys(text);
		
	}
	
	public String emailRandomValuesGeneration( ){
	    
	return	RandomStringUtils.randomAlphanumeric(5)+"@sharklasers.com";
	    
	  }
	
	public void click(String ObjectName){
		System.out.println("object name is"+ObjectName);
		pause(3000);
		driver.findElement(By.xpath(ObjectName)).click();
	}

	/**
	 * Close browser
	 */
	public void quitBrower()
	{
		driver.close();
	}

	/**
	 * Navigate from current working browser
	 */

	public void navigateBrowser(String url)
	{
		driver.navigate().to(url);
	}

	/**
	 * Navigate to backward screen
	 */

	public void navigateBackward()
	{
		driver.navigate().back();

	}
	
/*public WebDriver initializeDriver(String sbrowser, String sversion1) {
		
		if(sversion1.equalsIgnoreCase(""))
		{
			initializeDriver(sbrowser);
		}
		else if (!sversion1.equalsIgnoreCase("")){
                logger.info("I am in Grid Intialization");
			DesiredCapabilities capabilities = new DesiredCapabilities();
		URL hubUrl = null;
		try {
			hubUrl = new URL("http://localhost:4444/wb/hub");
			if (sbrowser.equalsIgnoreCase("firefox")) {
				FirefoxProfile profile = new FirefoxProfile();
				profile.setPreference("browser.download.folderList", 2);
				capabilities.setBrowserName(DesiredCapabilities.firefox()
						.getBrowserName());
				capabilities.setPlatform(Platform.WINDOWS);
				driver = new RemoteWebDriver(new URL(
						"http://localhost:4444/wd/hub"), capabilities);
			}
			if (sbrowser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						getFilePath(sCHROMEPATH));
				capabilities.setBrowserName(DesiredCapabilities.chrome()
						.getBrowserName());
				capabilities.setPlatform(Platform.WINDOWS);
				driver = new RemoteWebDriver(new URL(
						"http://localhost:4444/wd/hub"), capabilities);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		}
		else
		{
			logger.error("Configuration problem with version");
		}
		return driver;
	} 

public  WebDriver initializeDriver(String sbrowser,String surl) {
	 
	logger.info("Browser Name:"+sbrowser);
	if(driver==null)
	{
	if (sbrowser.equalsIgnoreCase("firefox")) {
		

		FirefoxProfile profile = new FirefoxProfile();
		profile.setEnableNativeEvents(true);
	logger.info("enabled events are"+profile.areNativeEventsEnabled());
		driver = new FirefoxDriver();
	}
	else if(sbrowser.equalsIgnoreCase("Chrome")){
	System.setProperty("webdriver.chrome.driver",
			getFilePath(sCHROMEPATH));
	logger.info("Setting a Chrome Driver.");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--always-authorize-plugins");
	options.addArguments("--ignore-certificate-errors");
	driver= new ChromeDriver(options);
}
	else if(sbrowser.equalsIgnoreCase("IE"))
	{
		 System.setProperty("webdriver.ie.driver",
	    		 getFilePath(sIEPATH));
		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		caps.setCapability(
			    InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
			    true);
		caps.setCapability("ignoreZoomSetting", true);
		caps.setCapability("ignoreProtectedModeSettings" , true);
		try {
			Runtime.getRuntime().exec("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 255");
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver= new InternetExplorerDriver(caps);
	}
	else if(sbrowser.equalsIgnoreCase("Safari"))
	{
		DesiredCapabilities capabilities = DesiredCapabilities.safari();
		driver = new SafariDriver(capabilities);
	}
	
	}
	driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
	return driver;
}*/

public String getFilePath(String sFilepath) {
	char cforwardslash = (char) 47;
	char cbackslash = (char) 92;
	logger.info("File path is "+sFilepath);
	String sPath = System.getProperty("user.dir").replace(cbackslash,
			cforwardslash);
	return sPath;
}

	/**
	 *Refresing Browser 
	 */
	public void refreshBrowser()
	{
		driver.navigate().refresh();
	}

	/**
	 * To scroll page up
	 */

	public void pageUp(){

		driver.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_UP);

	}
	/**
	 * To scroll page down
	 */

	public void pageDown(){

		driver.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);

	}
	
	/**
	 * Taking control to alert
	 */
	public boolean switchTOAlert(String salertText) {
		boolean flag = false;
		Alert alert = driver.switchTo().alert();

		logger.info("Expected Text :::"+ salertText);
		logger.info("Actual Text :::"+alert.getText());

		if (alert.getText().contains(salertText)) {

			logger.info("Alert displayed in loop"+alert.getText());
			flag = true;

		} else {
			logger.info("Alert is not displayed.");
			flag = false;
		}
		return flag;

	}

	/**
	 * Accepting alert
	 */
	public void acceptAlert()
	{
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	/**
	 *Dismissing alert
	 */
	public void dismissAlert()
	{
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	/**
	 *Element displayed on not.
	 */
	public boolean isDisplayed(WebElement webElement)
	{
		return  webElement.isDisplayed();
	}
	
	public boolean isDisplayedWithoutException(String locator)
	{
		pause(5000);
		boolean displayedvalue=false;
		try{
			displayedvalue=driver.findElement(By.xpath(locator)).isDisplayed();
		}catch(Exception e)
		{
			displayedvalue=false;
		}
		System.out.println("the displayed value is"+displayedvalue);
		return displayedvalue;

	}
	
	
	
	/**
	 *click on multiple elements
	 *@param by
	 *          : the property of the object
	 * 
	 *
	 */
	public void clickElements(By by)
	{
		List<WebElement> elements = driver.findElements(by);
		for(int i=0;i<elements.size();i++)
		{
			logger.info("ELement is"+i+isDisplayed(elements.get(i)));
			if(isDisplayed(elements.get(i))){
				elements.get(i).click();
			}
		}

	}
	/**
	 *Page load time out.
	 */
	public void pageLoadTimout()
	{
		try
		{
			//	driver.manage().timeouts().pageLoadTimeout(maxTimeout,TimeUnit.SECONDS);
		}
		catch(TimeoutException timeoutexception)
		{
			logger.info("Page Load TimeOut Exception is Thrown After waiting for"+maxTimeout+"Seconds");
		}
	}
	/**
	 *To get page title.
	 */
	public String getpageTitle()
	{
		pageLoadTimout();
		return driver.getTitle();
	}
	 public void browserQuit()
	 {
	  driver.quit();
	  driver=null;
	 }
	/**
	 *To get file path.
	 */
	/*public String getFilePath(String sFilepath) {
		return null;
	}*/

	/**
	 * Click on any Specific elements based on the property.
	 * 
	 * @param locator
	 *            : the property of the object
	 * @param driverWait
	 *            : The driverwait object
	 * @param sPageTitle
	 *            : Page title of page the driver is.
	 */
	/*public void click(By locator, WebDriverWait driverWait, String sPageTitle) {

		if (waitForElementEnable(locator, driverWait, sPageTitle)) {
			
			if(driver.toString().contains("InternetExplorer")){
				
				clickEnterButton(locator, driverWait, getpageTitle());
			}
			else
			{
			WebElement element = driver.findElement(locator);
			 driver.findElement(locator).click();
			//}
		}

	}
*/	/**
	 * Click on any Specific element based on the property x axis and y axis.
	 * 
	 * @param locator
	 *            : the property of the object
	 * @param driverWait
	 *            : The driverwait object
	 * @param sPageTitle
	 *            : Page title of page the driver is.
	 */
	

	public void scrollClick(By locator, WebDriverWait driverWait){
		
		if (waitForElementEnable(locator, driverWait)) {
			//logger.info("The driver value  inside click "+driver);
			 WebElement element = driver.findElement(locator);
			 JavascriptExecutor executor = (JavascriptExecutor)driver;
			 int X=element.getLocation().x;
			 int Y=element.getLocation().y;
			 executor.executeScript("window.scrollTo(" +X+ ","+ (Y - 100) + ");");
			 driver.findElement(locator).click();
		}

	}
	
	/**
	 * Click on any Specific elements based on the property.
	 * 
	 * @param locator
	 *            : the property of the object
	 * @param driverWait
	 *            : The driverwait object
	 * @param sPageTitle
	 *            : Page title of page the driver is.
	 */
	public void clickUsingSwitch(String locatorvalue, WebDriverWait driverWait) {
	
		By locator=By.xpath(locatorvalue);
		WebElement element = driver.findElement( locator);
					JavascriptExecutor executor = (JavascriptExecutor)driver;
					executor.executeScript("arguments[0].click();", element);
					logger.info("Clicked using executor");
		
		}
	
	public void clickOptions(By locator, WebDriverWait driverWait){
		
		if(waitForElementEnable(locator, driverWait)){
			
		}
		
	}

		/**
		 * Click on any Specific elements based on the property.
		 * 
		 * @param locator
		 *            : the property of the object
		 * @param driverWait
		 *            : The driverwait object
		 * @param sPageTitle
		 *            : Page title of page the driver is.
		 */
		public void click_coordinates(By locator, WebDriverWait driverWait) {

			if (waitForElementEnable(locator, driverWait)) {

				WebElement element = driver.findElement(locator);
				Point location = element.getLocation();
				Actions actions = new Actions(driver);
				actions.moveToElement(element).moveByOffset(location.x+5, location.y+5).click().build().perform();
			}

		}

		/**
		 * Checks a Checkbox if is not selected
		 * 
		 * @param locator
		 *            : the property of the object
		 * @param driverWait
		 *            : The driverwait object
		 * @param sPageTitle
		 *            : Page title of page the driver is.
		 */
		public void check_Checkbox(String locator, WebDriverWait driverWait,
				String sPageTitle) {
			logger.info("locator value is" + locator);
			if (waitForElementPresent(locator, driverWait)
					&& !driver.findElement(By.xpath(locator)).isSelected()) {
				driver.findElement(By.xpath(locator)).click();
			}
		}

		/**
		 * Checks a Checkbox if is not selected
		 * 
		 * @param locator
		 *            : the property of the object
		 * @param driverWait
		 *            : The driverwait object
		 * @param sPageTitle
		 *            : Page title of page the driver is.
		 */
		public void check_CheckboxMultiple(String locator, WebDriverWait driverWait,
				String sPageTitle, int index) {
			logger.info("locator value is" + locator);
			if (waitForElementPresent(locator, driverWait)
					&& !driver.findElements(By.xpath(locator)).get(index).isSelected()) {
				driver.findElement(By.xpath(locator)).click();
			}
		}

		/**
		 * UnChecks a Checkbox if is selected
		 * 
		 * @param locator
		 *            : the property of the object
		 * @param driverWait
		 *            : The driverwait object
		 * @param sPageTitle
		 *            : Page title of page the driver is.
		 */
		public void uncheck_Checkbox(String locator, WebDriverWait driverWait) {
			logger.info("locator value is" + locator);
			if (waitForElementPresent(locator, driverWait)
					&& driver.findElement(By.xpath(locator)).isSelected()) {
				driver.findElement(By.xpath(locator)).click();
			}

		}


		/**
		 * UnChecks a Checkbox if is selected
		 * 
		 * @param locator
		 *            : the property of the object
		 * @param driverWait
		 *            : The driverwait object
		 * @param sPageTitle
		 *            : Page title of page the driver is.
		 */
		public void uncheck_CheckboxMultiple(String locator, WebDriverWait driverWait,
				int index) {
			logger.info("locator value is" + locator);
			if (waitForElementPresent(locator, driverWait)
					&& driver.findElements(By.xpath(locator)).get(index).isSelected()) {
				driver.findElement(By.xpath(locator)).click();
			}

		}
		/**
		 * clicks on the visible element
		 * 
		 * @param by
		 *            : the property of the object
		
		 * @param sPageTitle
		 *            : Page title of page the driver is.
		 */

		/*public void clickInElements(By by,String pageTitle)
		{
			waitForElementPresent(by, driverWait, pageTitle);
			int j=0;
			logger.info("The by value is"+by);
			List<WebElement> elements= driver.findElements(by);
			for(int i=0 ;i<=elements.size();i++){
				driver.findElements(by).get(i).click();
				j=j+1;
				if(j==1)
				{
					logger.info("The element found and i am in Break statement");
					break;
				}
			}
		}*/

		/*
		 * public void clickLink(By locator, WebDriverWait driverWait,String
		 * sPageTitle) { if(waitForElementPresent(locator,driverWait,sPageTitle)) {
		 * driver.findElement(locator).click(); } }
		 */

		/**
		 * Enters text in the Textbox.
		 *  @param locator
		 *            : the property of the object
		 * @param driverWait
		 *            : The driverwait object
		 * @param sPageTitle
		 *            : Page title of page the driver is.
		 * @param stextValue
		 *            : value which is going to be entered in the text box.
		 */
		public void enterText(String locator, WebDriverWait driverWait,	String stextValue) {
			driver.findElement(By.xpath(locator)).clear();
			driver.findElement(By.xpath(locator)).sendKeys(stextValue);
			}
			

		/**
		 * Enters text in the textboxes with same locator.
		 *  @param locator
		 *            : the property of the object
		 * @param driverWait
		 *            : The driverwait object
		 * @param sPageTitle
		 *            : Page title of page the driver is.
		 * @param stextValue
		 *            : value which is going to be entered in the text box.
		 * @param   index
		 *             :text box number.            
		 */
		public void enterTextMultiple(String locator, WebDriverWait driverWait,
				String stextValue, String sPageTitle , int index) {
			if (waitForElementPresent(locator, driverWait)) {
				driver.findElements(By.xpath(locator)).get(index).clear();
				driver.findElements(By.xpath(locator)).get(index).sendKeys(stextValue);
			}
		}

		/**
		 * provides the count of the elements
		 * @param locator
		 * @return
		 */
		public int elements(By locator)
		{
			List<WebElement> elements=driver.findElements(locator);
			logger.info("Size of elements"+elements.size());
			return elements.size();
		}
		/**
		 * Verifies element visible or not.
		 * @param locator
		 *               :the property of the object
		 */
		public boolean elementVisibility(By locator)
		{
			boolean sflag=false;
			try{
				driver.findElement(locator).sendKeys("value");
				sflag=true;

			}catch(org.openqa.selenium.ElementNotVisibleException e)
			{
				logger.error("I am in exception :"+sflag);
				sflag=false;
			}
			logger.info("I am in out of catch block :"+sflag);
			return sflag;

		}


		/**
		 * Uploads a file in the Web Page.
		 *  @param locator
		 *            : the property of the object
		 * @param driverWait
		 *            : The driverwait object
		 * @param sPageTitle
		 *            : Page title of page the driver is.
		 * @param stextValue
		 *            : value which is going to be entered in the text box.
		 */

		public void enterText_FileUpload(By locator,WebDriverWait driverWait,String stextValue,String sPageTitle)
		{
			//if(waitForElementPresent(locator, driverWait, sPageTitle)){
			try{
				WebElement fileUpload=driver.findElement(locator);
				((RemoteWebElement)fileUpload).setFileDetector(new LocalFileDetector());
				fileUpload.sendKeys(stextValue);
			}
			catch(Exception e)
			{
				logger.info("Object not found"+locator+"Page Title"+sPageTitle);
				e.printStackTrace();
			}


		}

		/**
		 * It checks whether an element is enabled and returns a value.
		 *  @param locator
		 *            : the property of the object
		 * @param driverWait
		 *            : The driverwait object
		 * @param sPageTitle
		 *            : Page title of page the driver is. 
		 */

		public boolean isEnabled(String locator, WebDriverWait driverWait,
				String sPageTitle) {
			boolean status = false;
			if (waitForElementPresent(locator, driverWait)) {
				status = driver.findElement(By.xpath(locator)).isEnabled();
				logger.info("The Submit button is "+status);
			}
			return status;
		}

		/**
		 * selectValuefromDropDown selects the value from dropdown list which has
		 * been passed selectedValue as parameter
		 *  @param locator
		 *            : the property of the object
		 * @param driverWait
		 *            : The driverwait object
		 * @param sPageTitle
		 *            : Page title of page the driver is. 
		 */
		public void selectValuefromDropDown(String locator, WebDriverWait driverWait,String selectedValue) {
			logger.info("In dropdown selection method");
			/*if (waitForElementPresent(locator, driverWait, sPageTitle)) {
				logger.info("The value is "
						+ waitForElementPresent(locator, driverWait, sPageTitle));*/
				new Select(driver.findElement(By.xpath(locator)))
				.selectByVisibleText(selectedValue);
				logger.info("The value to be selected" + selectedValue);
			/*} else {
				logger.info("Drop down not found");
			}*/
		}

		/**
		 * Returns the DOM value of the  Web Element 
		 *  @param locator
		 *            : the property of the object
		 * @param driverWait
		 *            : The driverwait object
		 * @param sPageTitle
		 *            : Page title of page the driver is. 
		 * @param  locatorName  
		 *            : key for attribute value.            
		 */
		public String getAttribute(By locator, String locatorName,
				WebDriverWait driverWait,String sPageTitle) {
			logger.info("value of getattribute is"
					+ driver.findElement(locator).getAttribute(locatorName));
			return driver.findElement(locator).getAttribute(locatorName);
		}

		/*It will return the text box values as per Index */
		/**
		 * Returns the DOM value of the  Web Element 
		 *  @param locator
		 *            : the property of the object
		 * @param driverWait
		 *            : The driverwait object
		 * @param sPageTitle
		 *            : Page title of page the driver is. 
		 * @param  locatorName  
		 *            : key for attribute value.  
		 * @param  index
		 *            : attribute number.                      
		 */
		public String getAttributeMultiple(By locator, String locatorName,
				WebDriverWait driverWait,String sPageTitle, int index) {
			logger.info("value of getattribute is"+ driver.findElements(locator).get(index).getAttribute(locatorName));
			return driver.findElements(locator).get(index).getAttribute(locatorName);
		}

		/**
		 *clicks on multiple elements with same property according to int value
		 *  @param locator
		 *            : the property of the object
		 * @param  i
		 *            : on which property it should click.                      
		 */
		
		
		public void clickElements(By by,int i)
		{
			List<WebElement> element= driver.findElements(by);
			logger.info("The size of the list is"+element.size());
			WebElement element2=element.get(i);
			/*for (int j = 0; j < element.size(); j++) {
				String text=element.get(i).getText();
				logger.info("The values are "+element.get(i).getText());

			}*/


			/*if(waitforWebElement(driverWait,element2))
			{
				element2.click();
				logger.info("Element Clicked");
			}*/

		}


		/**
		 * Returns all the Dropdown values.
		 *  @param locator
		 *            : the property of the object
		 * @param driverWait
		 *            : The driverwait object
		 * @param sPageTitle
		 *            : Page title of page the driver is. 
		 */
		public ArrayList<String> getDropdownValue(By locator,
				WebDriverWait driverWait, String sPageTitle) {
			WebElement ele = driver.findElement(locator);
			ArrayList<WebElement> dropdownList = new ArrayList<WebElement>();
			dropdownList.addAll(ele.findElements(By.tagName("option")));
			ArrayList<String> dropdownlistValues = new ArrayList<String>();
			// after sorted
			logger.info("ArrayList is sorted");
			for (WebElement temp : dropdownList) {
				dropdownlistValues.add(temp.getText());
			}
			Collections.sort(dropdownlistValues);
			/*for (String values : dropdownlistValues) {
			// logger.info("country value" + values);
		}*/

			return dropdownlistValues;
		}

		/**
		 * Clears the data from the TextBox using Locator.
		 * 
		 * @param locator
		 *            : Property of the WebElement.
		 * @param driverWait
		 *            :Waits until the Visibilty of Element.
		 * @param sPageTitle
		 *            : Gives the Title of the page.
		 */
		public void clearWebElementText(String locator, WebDriverWait driverWait) {
			logger.info("size of locator is"
					+ driver.findElement(By.xpath(locator)).getText());
			if (waitForElementPresent(locator, driverWait)) 
			{
				driver.findElement(By.xpath(locator)).clear();
			}

		}

		/**
		 * Clears the WebElement data using keyboard event(Back Space) 
		 * @param locator
		 *              : Property of the WebElement.
		 * @param driverWait
		 *               :Waits until the Visibilty of Element.
		 * @param sPageTitle
		 *               : Gives the Title of the page.
		 */
		public void clearWebElementTextusingbackspaceUsingAttribute(By locator,
				WebDriverWait driverWait, String sPageTitle) {
			//logger.info("The string length is"+getAttribute(locator, "value", driverWait, sPageTitle).length());
			//for (int i = 0; i <=getAttribute(locator, "value", driverWait, sPageTitle).length(); i++) {

			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys("a");
			driver.findElement(locator).sendKeys(Keys.BACK_SPACE);
			//driver.findElement(locator).sendKeys(Keys.BACK_SPACE);
		}

		/**
		 * Clears the WebElement data using keyboard event(Back Space) 
		  * @param locator
		 *              : Property of the WebElement.
		 * @param driverWait
		 *               :Waits until the Visibilty of Element.
		 * @param sPageTitle
		 *               : Gives the Title of the page.
		 * @param nooftimes
		 */
		public void clearWebElementTextusingbackspace(By locator,
				WebDriverWait driverWait, String sPageTitle, int nooftimes) {
			logger.info("The string length is"+nooftimes);
			for (int i = 0; i <=nooftimes; i++) {
				driver.findElement(locator).sendKeys(Keys.BACK_SPACE);
			}
		}

		/**
		 * Returns the text for the locator
		 * @param locator
		 *              : Property of the WebElement.
		 * @param driverWait
		 *               :Waits until the Visibilty of Element.
		 * @param sPageTitle
		 *               : Gives the Title of the page.
		 * @return
		 */

		public String getText(String locator, WebDriverWait driverWait) {
			String sText = "";
			if (waitForElementPresent(locator, driverWait)) {
				sText = driver.findElement(By.xpath(locator)).getText();
			}
			return sText;
		}

		/**
		 * Determine whether or not this element is selected or not. This operation only applies to input
		 * elements such as checkboxes, options in a select and radio buttons.
		 * 
		 * @return True if the element is currently selected or checked, false otherwise.
		 */
		public boolean isSelected(By locator,
				WebDriverWait driverWait, String sPageTitle) {

			logger.info("it returns the selected radio button or checkbox value" +driver.findElement(locator).isSelected());
			return driver.findElement(locator).isSelected();
		}

		
		/**
		 * drags the element and drops in the target location.
		 * @param sourcelocator
		 *              : Property of the WebElement from which it should drag.
		 * @param targetlocator
		 *              : Property of the WebElement where it should drop.             
		 * @param driverWait
		 *               :Waits until the Visibilty of Element.
		 * @param sPageTitle
		 *               : Gives the Title of the page.
		 * @return
		 */

		public void dragAndDrop(By sourcelocator,By targetlocator,WebDriverWait driverWait, String sPageTitle)
		{
			WebElement drag=driver.findElement(sourcelocator);
			WebElement drop=driver.findElement(targetlocator);
			Actions builder = new Actions(driver);
			builder.moveToElement(drag).clickAndHold();
			pause(2000);
			builder.moveToElement(drop).click().perform();

		}

		/* Returns all the text for a particular Block  */

		/**
		 * Returns the all webelements in list.
		 * @param locator
		 *              : Property of the WebElement.
		 * @param driverWait
		 *               :Waits until the Visibilty of Element.
		 * @param sPageTitle
		 *               : Gives the Title of the page.
		 * @return
		 */
		public List<WebElement> getAllWebElementValues(By locator,WebDriverWait driverWait, String sPageTitle) 
		{
			//waitForElementPresent(locator, driverWait, sPageTitle);
			List<WebElement> allwebelements = driver.findElements(locator);
			return allwebelements;
		}

		/**
		 *Element is displayed or not.
		 * @param locator
		 *              : Property of the WebElement.
		 * @param driverWait
		 *               :Waits until the Visibilty of Element.
		 * @param sPageTitle
		 *               : Gives the Title of the page.
		 * 
		 */
		
		
		public boolean isDisplayed(By locator,WebDriverWait driverWait, String sPageTitle)
		{
			pause(5000);
			return driver.findElement(locator).isDisplayed();

		}

		/**
		 *Returns text  of the selected value from dropdown. 
		 * @param locator
		 *              : Property of the WebElement.
		 * @param driverWait
		 *               :Waits until the Visibilty of Element.
		 * @param sPageTitle
		 *               : Gives the Title of the page.
		 * 
		 */
		
		public String getDropDownSelectedOption(By locator,WebDriverWait driverWait, String sPageTitle)
		{
			Select select = new Select(driver.findElement(locator));
			WebElement option = select.getFirstSelectedOption();
			logger.info("Option Selected in Drop Down is"+option.getText());
			return option.getText();

		}
		/**
		 *Returns text according to index value of which drop down. 
		 * @param locator
		 *              : Property of the WebElement.
		 * @param driverWait
		 *               :Waits until the Visibilty of Element.
		 * @param sPageTitle
		 *               : Gives the Title of the page.
		 * 
		 */
		
		public String getDropDownSelectedOptionMultiple(By locator,WebDriverWait driverWait, String sPageTitle ,int index)
		{
			Select select = new Select(driver.findElements(locator).get(index));
			WebElement option = select.getFirstSelectedOption();
			logger.info("Option Selected in Drop Down is"+option.getText());
			return option.getText();

		}

		/**
		 * waits for milliseconds time specified in the method
		 * @param pausetime
		 */
		
		
		public void pause(long pausetime)
		{
			try
			{
				Thread.sleep(pausetime);
			}catch(Exception e)
			{
				logger.info("I am In catch Block of Thread.sleep");
			}
		}
		/**
		 * Will make the textbox active by clicking first and will then perform operation
		 * @param locator
		 *              : Property of the WebElement.
		 * @param driverWait
		 *               :Waits until the Visibilty of Element.
		 * @param sPageTitle
		 *               : Gives the Title of the page.
		 */
		public void clickEnter(String locator,WebDriverWait driverWait)
		{
			click(locator);
			driver.findElement(By.xpath(locator)).sendKeys(Keys.ENTER);
			logger.info("Clicked on Enter key");
		}
		
		
		/**
		 * Will make the textbox active by clicking first and will then perform operation
		 * @param locator
		 *              : Property of the WebElement.
		 * @param driverWait
		 *               :Waits until the Visibilty of Element.
		 * @param sPageTitle
		 *               : Gives the Title of the page.
		 */
		public void clickEnterButton(By locator,WebDriverWait driverWait, String sPageTitle)
		{
			driver.findElement(locator).sendKeys(Keys.ENTER);
			logger.info("Clicked on Enter key");
		}
		
		/**
		 * Returns the state of video.
		 * @param videoname
		 *                 : specifies video name .
		 * @param functionname              
		 *                 :specifies which action should perform. 
		 */
		public String videoUtilFunctions(String videoname,String functionname)
		{
			String videostatus="";
			if(functionname.equalsIgnoreCase("play"))
			{
				((JavascriptExecutor) driver).executeScript("document.getElementById('"+videoname+"').play2();");
				logger.info("Video is Played");
				videostatus="play";
				pause(5000);
			}
			else if(functionname.equalsIgnoreCase("pause"))
			{
				((JavascriptExecutor) driver).executeScript("document.getElementById('"+videoname+"').pause();");
				pause(5000);
				logger.info("Video is Paused");
				videostatus="pause";
			}
			else if(functionname.equalsIgnoreCase("stop"))
			{
				((JavascriptExecutor) driver).executeScript("document.getElementById('"+videoname+"').pause();");
				pause(5000);
				logger.info("Video is stopped");
				videostatus="stop";
			}
			else
			{
				logger.info("Not A valid Function Passed");
				Reporter.log("Not A valid Function Passed in Videos Page");
			}
			return videostatus;
		}

		/**
		 * When multiple check boxes with same property are there the below method checks a check box if it is not selected. 
		 * 
		 * @param locator
		 *            : the property of the object
		 * @param driverWait
		 *            : The driver wait object
		 * @param sPageTitle
		 *            : Page title of page the driver is.
		 * @param  i
		 * 			  :index of the check box in list
		 *           
		 */

		public void click_Checkbox(String locator, WebDriverWait driverWait,int i) {
			logger.info("locator value is" + locator);
			if (waitForElementPresent(locator, driverWait) && (!driver.findElements(By.xpath(locator)).get(i).isSelected())) {
				logger.info("I am in click check box");
				driver.findElements(By.xpath(locator)).get(i).click();
			}
		}
		/**
		 * selectValuefromDropDown selects the value from dropdown list which has
		 * been passed selectedValue as parameter
		 * 
		 * 
		 */
		public void selectValuefromDropDown_multiple(String locator, WebDriverWait driverWait,String selectedValue, String sPageTitle , int i) {
			logger.info("In dropdown selection method");
			if (waitForElementPresent(locator, driverWait)) 
			{
				logger.info("The value is " + waitForElementPresent(locator, driverWait));
				new Select(driver.findElements(By.xpath(locator)).get(i)).selectByVisibleText(selectedValue);
				logger.info("The value to be selected" + selectedValue);
			} else {
				logger.info("Drop down not found");
			}
		}
		/**
		 * Returns the text for the locator
		* @param locator
		 *            : the property of the object
		 * @param driverWait
		 *            : The driver wait object
		 * @param sPageTitle
		 *            : Page title of page the driver is.
		 * @return
		 */

		public String getTextMultiple(String locator, WebDriverWait driverWait,String sPageTitle,int i) {
			String sText = "";
			if (waitForElementPresent(locator, driverWait)) {
				sText = driver.findElements(By.xpath(locator)).get(i).getText();
			}
			return sText;
		}



		/**	
		 * Used for opening a new tab. 	
		 *          	
		 */	
		/*public void openANewTab()	
		{	
			EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
			eventFiringWebDriver.getKeyboard().pressKey(Keys.CONTROL);
			eventFiringWebDriver.getKeyboard().pressKey("t");
			eventFiringWebDriver.getKeyboard().releaseKey(Keys.CONTROL);

		}	*/

		/**
		 * Submit a form.
		 * 
		 * @param locator
		 *            : the property of the object
		 * @param driverWait
		 *            : The driverwait object
		 * @param sPageTitle
		 *            : Page title of page the driver is.
		 */
		public void submit(String locator, WebDriverWait driverWait, String sPageTitle)
		{
			if (waitForElementPresent(locator, driverWait)) {
				//logger.info("The driver value  inside click "+driver);
				driver.findElement(By.xpath(locator)).submit();
			}
		}

		/**
		 * moves mouse to particular locator
		 * @param locator
		 *               : the property of the object
		 */
		
		public void mouseOver(By locator)
		{
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(locator));
			actions.perform();
		}
		/**
		 * Getting driver current url.
		 * @return
		 */
		public String getCurrentURL(){
			return driver.getCurrentUrl();
		}

      /**
       * moves mouse randomly in sourcelocator
       * @param sourcelocator
       *                  : the property of the object
       */
		public void moveMouseRandomly(By sourcelocator)
		{
			WebElement canvasElement = driver.findElement(sourcelocator);
			Actions builder = new Actions(driver);
			pause(2000);
			builder.clickAndHold(canvasElement).moveByOffset(Integer.parseInt(RandomStringUtils.randomNumeric(2)),Integer.parseInt(RandomStringUtils.randomNumeric(2))).
			moveByOffset(Integer.parseInt(RandomStringUtils.randomNumeric(2)),Integer.parseInt(RandomStringUtils.randomNumeric(2))).
			moveByOffset(-Integer.parseInt(RandomStringUtils.randomNumeric(2)),-Integer.parseInt(RandomStringUtils.randomNumeric(2))).
			moveByOffset(-Integer.parseInt(RandomStringUtils.randomNumeric(2)),-Integer.parseInt(RandomStringUtils.randomNumeric(2))).release().perform();
			pause(2000);
		}

       /**
        * switches from sub window to main window.
        * @param driver
        *             :control moves to driver.  
        */
		public void switchToMainWindow(WebDriver driver)
		{
			driver.switchTo().window(driver.getWindowHandle());
			logger.info("The Control is to the Required Window");
		}
		
		public void shiftnewindow(){
			Set<String> handles=driver.getWindowHandles();
		 	for (String winHandle : driver.getWindowHandles()) {
		 	    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		 	}
			logger.info("moved to next tab");
			
		}
		
		 /**
		   * Return an opaque handle to this window that uniquely identifies it within this driver instance.
		   * This can be used to switch to this window at a later date
		   */

		public Set<String> getAllWindowHandles(WebDriver driver)
		{
			Set<String> handle = driver.getWindowHandles();	
			return handle;
		}
		public String emailRandomValues( ){
		    
			return	RandomStringUtils.randomAlphabetic(5).toLowerCase()+"@sharklasers.com";
			    
			  }
		
		public void creatingusers(String n){
			
			int users=Integer.parseInt(n);
			
			for(int i=1;i<=users;i++){
				driver.get("http://www.carwale.com/users/register.aspx");
				driver.findElement(By.xpath("//input[@id='ctlRegister_txtName']")).sendKeys("rohith");
				String email=emailRandomValues();
				driver.findElement(By.xpath("//input[@id='ctlRegister_txtEmail']")).sendKeys(email);
				driver.findElement(By.xpath("//*[@id='ctlRegister_txtEmailConf']")).sendKeys(email);
				driver.findElement(By.xpath("//*[@id='ctlRegister_txtPassword']")).sendKeys("testing123");
				driver.findElement(By.xpath("//*[@id='ctlRegister_txtConfirmPassword']")).sendKeys("testing123");
				driver.findElement(By.xpath("//*[@id='ctlRegister_btnRegister']")).click(); 
				
				
			}
			
			
		}
		
		public String getTextfromscreen(String ObjectName) {
			String sText = "";
				sText = driver.findElement(By.xpath(ObjectName)).getText();
				System.out.println("the text from screen is"+ sText);
			return sText;
		}
		
		/**
		 * control switches from one browser to another browser.
		 * @param stext
		 */
		
		public void browserSwitch(String stext)
		{
			
			Set<String> browserHandle = getAllWindowHandles(driver);
		List<String> list = new ArrayList<String>(browserHandle);
			logger.info("The size of windows"+list.size());
			 for(int i=0;i<list.size();i++)
			{
				logger.info("Inside For Loop");
		    	driver.switchTo().window(list.get(i));
					    logger.info("Element is found on New Browser"); 
					    
					    if(driver.findElement(By.cssSelector("body")).getText().contains(stext))
					    {
					    	logger.info("The value of i"+ i);
					    	break;
					    }
					    //logger.info(""+driver.findElement(By.cssSelector("body")).getText());
			}
			}
		/*It Will return texts  */
	/*	 public String getlabel(String labelname,int type)
	   {
	  By by;
	    String flag=null;
	    switch (type) {
	 case LABEL:
	   by = By.xpath("//label[contains(text(),'"+labelname+"')]");
	  flag=getText(by, driverWait, getpageTitle());
	 break;
	  case BUTTON:
	    by = By.xpath("//button[contains(text(),'"+labelname+"')]");
	   flag=getText(by, driverWait, getpageTitle());
	  break;
	  case A:
	  by=By.xpath("//a[contains(text(),'"+labelname+"')]");
	  flag=getText(by, driverWait, getpageTitle());
	  break;
	  case H4:
		   by=By.xpath("//h4[contains(text(),'"+labelname+"')]");
		   flag=getText(by, driverWait, getpageTitle());
		   break;
	  case SPAN:
		   by=By.xpath("//span[contains(text(),'"+labelname+"')]");
		   flag=getText(by, driverWait, getpageTitle());
		   break;
	  case DIV:
		   by=By.xpath("//div[contains(text(),'"+labelname+"')]");
		   flag=getText(by, driverWait, getpageTitle());
		   break;  
	  case STAR:
		   by=By.xpath("//*[contains(text(),'"+labelname+"')]");
		   flag=getText(by, driverWait, getpageTitle());
		   break;  	 
		case XPATH:
		  by=By.xpath(labelname);
		   flag=getText(by, driverWait, getpageTitle());
		   break;  
	 	  
		   
	 default:
	  logger.info("Switch type not specfied");
	  break;
	 }
	    return flag;
	   }*/
	}
