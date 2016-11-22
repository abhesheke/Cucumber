package com.compugain.setup;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public class TestBase implements Setup{

	public int grid=1;
	public long WAIT = 60;
	public WebDriver driver;
	public WebDriverWait wait;
	public FirefoxProfile profile;
	public String surl,sUserName,sPassword,sEnvironment;
    public static final String language="en";
	private static Logger logger = Logger.getLogger(TestBase.class);
	
public WebDriver initializeDriver(String sbrowser, String sversion1) {
		
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
public  WebDriver initializeDriver(String sbrowser/*,String surl*/) {
	 
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
		
		logger.info("running in chrome browser");
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
}

public String getFilePath(String sFilepath) {
	char cforwardslash = (char) 47;
	char cbackslash = (char) 92;
	logger.info("File path is "+sFilepath);
	String sPath = System.getProperty("user.dir").replace(cbackslash,
			cforwardslash)
			+ sFilepath;
	
	File file = new File(sPath);
	if (file.exists()) {
		sPath = file.getAbsolutePath();
		logger.info("The File Path is " + sPath);
	} else {
	}
	return sPath;
	
}

public WebDriver openBrowser(String browserType) {
	if (browserType.equalsIgnoreCase("firefox")) {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		profile.setPreference("browser.download.dir", sDOWNLOADSPATH);
		profile.setPreference("browser.helperApps.neverAsk.openFile",
				"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
		profile.setPreference("browser.helperApps.alwaysAsk.force", false);
		profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
		profile.setPreference("browser.download.manager.focusWhenStarting", false);
		profile.setPreference("browser.download.manager.useWindow", false);
		profile.setPreference("browser.download.manager.showAlertOnComplete", false);
		profile.setPreference("browser.download.manager.closeWhenDone", false);
		profile.setPreference("xpinstall.signatures.required", false);
		logger.info("The Profile Setup Data");
		driver = new FirefoxDriver(profile);
	} else if (browserType.equalsIgnoreCase("Chrome")) {
		logger.info("Running on chrome browser");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + sCHROMEPATH);
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		// chromePrefs.put("download.default_directory", downloadFilepath);
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("--test-type");
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		options.addArguments("--always-authorize-plugins");
		options.addArguments("--ignore-certificate-errors");
		logger.info("The Chrome Profile is setup");
		driver = new ChromeDriver(options);
	} else if (browserType.equals("IE")) {
		System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") +sIEPATH);
		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		caps.setCapability(
				InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
				true);
		caps.setCapability("ignoreZoomSetting", true);
		caps.setCapability("ignoreProtectedModeSettings" , true);
		caps.setCapability("enablePersistentHover", true);
		caps.setCapability("nativeEvents",false);
		try {
			Runtime.getRuntime().exec("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 255");
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver= new InternetExplorerDriver(caps);
	}

	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	return driver;
}

}
