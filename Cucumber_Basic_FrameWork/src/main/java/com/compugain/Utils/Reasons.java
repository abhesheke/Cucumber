package com.compugain.Utils;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;


/**
 * Contains all the methods for verification and for generating reports.
 * 
 */

public class Reasons extends AssertionError {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(Reasons.class);

	public Reasons(String message) {
		super(message);
	}

	/*public Throwable fillInStackTrace(String message) {
		String detailMessage = message;
		logger.info("Detail Stack Trace is"+detailMessage);
		return null;
	}*/
/**
 * customizedAssertEquals method is used to run the assertion if fails also and stores the values in a status list 
 * @param sActual :Actual value passed
 * @param sExpected :Expected value passed
 * @param reportMap  
 * @param status
 * @return
 */
	
	
	public Map<String, String> customizedAssertEquals(String sActual,
			String sExpected, Map<String, String> reportMap, List<String> status) {
		if (sExpected.equals(sActual)) {
			
			reportMap.put(sExpected, sActual);
			status.add("PASS");
		} else {
			reportMap.put(sExpected, sActual);
			status.add("FAIL");
		}
		return reportMap;
	}

	Iterator<String> itrmap,iterator ;
	
	
	
	
	/*@SuppressWarnings("static-access")
	public void AssertionTest(Map<String, String> reportMap,
		List<String> status, WebDriver driver,String sTestcaseName) {
		String sPassdata = "", sFaildata = "", sTotaltest = "";
		String key = null,value = null;
		//Set<String> keys = reportMap.keySet();
		iterator = status.iterator();
		int i=0;
		for (Map.Entry<String, String> entry : reportMap.entrySet()) {
			key = (String) entry.getKey();
			value = (String) entry.getValue();
			if ("PASS".equals(iterator.next())) 
			{
				logger.info("PASS");
				logger.info("Expected ---->" + key );
				logger.info("  Actual ---->" + value);
				sPassdata += "Expected : " + key +  "\n" + " Actual : " + value + "\n";
				logger.info("value of pass data" + sPassdata);
			
			} //if 
			else {
				logger.info("FAIL");
				logger.info("Expected ---->" + key );
				logger.info("  Actual ---->" + value);
				sFaildata += "Expected" + key +  "\n"+  " Actual " + value  + "\n";
				
			}

		i++;} 

	
		if (sFaildata != "") {
			sTotaltest = sPassdata + sFaildata;	
			Color c = new Color(23,32,43);
			sTotaltest.valueOf(c.getRGB());
			
			throw new Reasons(sTotaltest);
		}
		else
		{
			Reporter.log(sPassdata);

		}

	}*/

	public String concat(String str1, String str2) {
		String rVal = null;
		if (str1 != null || str2 != null) {
			rVal = "";
			if (str1 != null) {
				rVal += str1;
			}
			if (str2 != null) {
				rVal += str2;
			}
		}
		return rVal;
	}

	public String getFilePath(String sFilepath) {
		char cforwardslash = (char) 47;
		char cbackslash = (char) 92;
		String sPath = System.getProperty("user.dir").replace(cbackslash,
				cforwardslash)
				+ sFilepath;

		File file = new File(sPath);
		/*if (file.exists()) {
			sPath = file.getAbsolutePath();
			logger.info("The File Path is " + sPath);
		} else {
			logger.error("File not Found");
		}*/
		logger.info("The File path is"+file.getAbsolutePath());
		return file.getAbsolutePath();
	}
	
	
	/*function to create reports */
	
	public void ResultsOutput(ITestResult result,WebDriver driver,String sTestcaseName)
	{
		String sScreenshots = "/Screenshots";
		logger.info("result" + result);
	    String methodName = result.getName();
	    String sFilepath=getFilePath(sScreenshots)+"\\";
	    logger.info(methodName);
	    System.setProperty("org.uncommons.reportng.escape-output", "false");
	    if (!result.isSuccess()) {
	        try {
	        	DateTime dateTime = new DateTime();
				String sScreenshotName=sTestcaseName +dateTime.yyyyMMDDHHmmssTime()+ ".png";
				logger.info("sTestcaseName:::::" + sScreenshotName);
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile,new File(sFilepath+sScreenshotName));
				 Reporter.setCurrentTestResult(result);
	        logger.info(scrFile.getAbsolutePath());
	    	Reporter.log("<a href=\""+sFilepath+sScreenshotName+ "\"><p align=\"left\">Error screenshot at " +sScreenshotName+ "</p></a>");
			 Reporter.setCurrentTestResult(null); 
        
	        } catch (Exception e1) {
	            e1.printStackTrace();
	        }
	}
	}
	}

	
	
	
	

