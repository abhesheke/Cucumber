

package com.compugain.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;

public class CustomReport {
	public WebDriver driver;


	/**
	 * @param args
	 */

	private static Logger logger = Logger.getLogger(CustomReport.class);
	int i=1;

	public int getI() {
		return i;
	}


	public void setI(int i) {
		this.i = 1;
	}



	public void customAssertion(boolean expected,boolean actual,String locatorvalue)
	{
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@Expected Value is"+expected);
		logger.info("****************************Actual Value is"+actual);
		
		if(actual==false && expected==false)
		{
			/*logger.info(" I am in Role Access Exception");
			Reporter.log("<font color='green'>"+"Expected:As Per the Role These"+locatorvalue+" Should Not Be Visible"+expected+"</font>");
			Reporter.log("<font color='green'>"+"Actual:As Per the Role These"+locatorvalue+" Should Not Be Visible"+actual+"</font>");
			throw new RoleAccessException("Roles");*/
		}	
		else if(actual==true && expected==false)
		{
			Reporter.log("<font color='red'>"+"Expected:As Per the Role These"+locatorvalue+" Should not Be Visible."+expected+"</font>");
			Reporter.log("<font color='red'>"+"Actual:As Per the Role These"+locatorvalue+" Should not Be Visible."+actual+"</font>");
			Assert.assertEquals(expected, actual);
		}
		else if(actual==false && expected==true)
		{
			Reporter.log("<font color='red'>"+"Expected:As Per the Role These"+locatorvalue+" Should Be Visible But it is not Visible."+expected+"</font>");
			Reporter.log("<font color='red'>"+"Actual:As Per the Role These"+locatorvalue+" Should Be Visible But it is not Visible."+actual+"</font>");
			Assert.assertEquals(expected, actual);
		}


	}
	static int j=1;
	/**
	 * Comparing two string values and determined whether the case is passed or failed
	 * @param sExpected
	 * @param sActual
	 * @param statusValue
	 * @param driver
	 * @param sTestcaseName
	 */
	public void customizedReport(String sExpected , String sActual,
			List<String> statusValue,WebDriver driver,String sTestcaseName) {
		this.driver = driver;
		logger.info("Expected value is"+sExpected);
		logger.info("Actual  value  is"+sActual);

		if ((sExpected.trim().toLowerCase()).equalsIgnoreCase(sActual.trim().toLowerCase())) {
			/*Reasons.reporter("Expected Value " + sExpected + "</br>" + "Actual Value"
					+ sActual + "::PASS", "");*/
			System.setProperty("org.uncommons.reportng.escape-output", "false");
			reporter("Expected Value : " + sExpected + "</br>" + "Actual Value :"
					+ sActual + "::PASS","");
			statusValue.add("PASS");
			
			logger.info("sTestcaseName ::::"+sTestcaseName+"::::"+"Sequence:::::"+j);
			logger.info("sTestcaseName"+sTestcaseName+"::::"+"PASSED");
			j=j+1;

		} else {
			/*Reasons.reporter("Expected Value " + sExpected + "\n" + "Actual Value"	+ sActual + "::Fail" + AssertionresultOutput(driver,sTestcaseName),"");*/
			reporter("<font color='red'>"+"Expected Value " + sExpected + "\n" + "Actual Value"	+ sActual + "::Fail" + AssertionresultOutput(driver,sTestcaseName)+"</font>","");
			statusValue.add("FAIL");
			logger.error("*************sTestcaseName"+sTestcaseName+"::::"+"FAILED");
		}
	}


	public void customizedReport(int sExpected , int sActual,
			List<String> statusValue,WebDriver driver,String sTestcaseName) {
		this.driver = driver;
		logger.info("Expected value is"+sExpected);
		logger.info("Actual  value  is"+sActual);
		if (sExpected==sActual) {
			/*Reasons.reporter("Expected Value " + sExpected + "</br>" + "Actual Value"
					+ sActual + "::PASS", "");*/
			System.setProperty("org.uncommons.reportng.escape-output", "false");
			reporter("Expected Value : " + sExpected + "</br>" + "Actual Value :"
					+ sActual + "::PASS","");
			statusValue.add("PASS");
			
			logger.info("sTestcaseName ::::"+sTestcaseName+"::::"+"Sequence:::::"+j);
			logger.info("sTestcaseName"+sTestcaseName+"::::"+"PASSED");
			j=j+1;

		} else {
			/*Reasons.reporter("Expected Value " + sExpected + "\n" + "Actual Value"	+ sActual + "::Fail" + AssertionresultOutput(driver,sTestcaseName),"");*/
			reporter("<font color='red'>"+"Expected Value " + sExpected + "\n" + "Actual Value"	+ sActual + "::Fail" + AssertionresultOutput(driver,sTestcaseName)+"</font>","");
			statusValue.add("FAIL");
			logger.error("*************sTestcaseName"+sTestcaseName+"::::"+"FAILED");
		}
	}
	
	/*static int count=0;
        public int  myMethod() {
            synchronized(this) {
              count++;
            }
			return count;
          }
	 */
	/*static int i=1;
	 public void reporter(String sValue,String sValue1) {

	   Reporter.log(myMethod() + sValue +sValue1 +"</br>");

	   if(sValue.equals("val1")&&sValue.equals("val2"))
	   {
		   count=0;
	   }
	  i++;
	 }*/


	public void customizedReport(boolean sExpected,String expected,String actual,List<String> statusValue,WebDriver driver,String sTestcaseName) {
		this.driver = driver;
		//		RTM rtm = new RTM();
		logger.info("@@@@Expected ::::"+expected);
		logger.info("@@@@sActual ::::"+actual);
		
		if (String.valueOf(sExpected).equals(String.valueOf(expected.contains(actual)))) {
			/*Reasons.reporter("Expected Value " + sExpected + "</br>" + "Actual Value"
					+ sActual + "::PASS", "");*/
			System.setProperty("org.uncommons.reportng.escape-output", "false");
			logger.info("I am in customized report expected equals");
			logger.info("driver value in customize report "+driver.toString());
			reporter("Expected Value : " + expected + "</br>" + "Actual Value :"
					+ actual + "::PASS","");
			statusValue.add("PASS");
			logger.info("sTestcaseName"+sTestcaseName+"::::"+"PASSED");
			/*try {
				rtm.headingOfCSV();
				rtm.testcaseRTM(sTestcaseName);
				rtm.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/


		} else {
			/*Reasons.reporter("Expected Value " + sExpected + "\n" + "Actual Value"	+ sActual + "::Fail" + AssertionresultOutput(driver,sTestcaseName),"");*/
			reporter("<font color='red'>"+"Expected Value " + sExpected +  "Actual Value"	+ actual + "::Fail" + AssertionresultOutput(driver,sTestcaseName)+"</font>","");
			statusValue.add("FAIL");
			try{
			if(driver.findElement(By.cssSelector("body")).getText().contains("please contact"))
			{
				reporter("@@@@@@", "UNHANDLED ERROR IN APPLICATION");
			}
			}catch(Exception e)
			{
				logger.error("-----No Error displayed");
			}

			logger.error("*************sTestcaseName"+sTestcaseName+"::::"+"FAILED");
			/*try {
				rtm.headingOfCSV();
				rtm.testcaseRTM(sTestcaseName);
				rtm.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 */
		}
	}

	
	
	public void customizedReport(boolean sExpected , boolean sActual,
			List<String> statusValue,WebDriver driver,String sTestcaseName) {
		this.driver = driver;
		//		RTM rtm = new RTM();
		logger.info("@@@@Expected ::::"+sExpected);
		logger.info("@@@@sActual ::::"+sActual);
		if (String.valueOf(sExpected).equals(String.valueOf(sActual))) {
			/*Reasons.reporter("Expected Value " + sExpected + "</br>" + "Actual Value"
					+ sActual + "::PASS", "");*/
			System.setProperty("org.uncommons.reportng.escape-output", "false");
			logger.info("I am in customized report expected equals");
			logger.info("driver value in customize report "+driver.toString());
			reporter("Expected Value : " + sExpected + "</br>" + "Actual Value :"
					+ sActual + "::PASS","");
			statusValue.add("PASS");
			logger.info("sTestcaseName"+sTestcaseName+"::::"+"PASSED");
			/*try {
				rtm.headingOfCSV();
				rtm.testcaseRTM(sTestcaseName);
				rtm.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/


		} else {
			/*Reasons.reporter("Expected Value " + sExpected + "\n" + "Actual Value"	+ sActual + "::Fail" + AssertionresultOutput(driver,sTestcaseName),"");*/
			reporter("<font color='red'>"+"Expected Value " + sExpected +  "Actual Value"	+ sActual + "::Fail" + AssertionresultOutput(driver,sTestcaseName)+"</font>","");
			statusValue.add("FAIL");
			try{
			if(driver.findElement(By.cssSelector("body")).getText().contains("please contact"))
			{
				reporter("@@@@@@", "UNHANDLED ERROR IN APPLICATION");
			}
			}catch(Exception e)
			{
				logger.error("-----No Error displayed");
			}

			logger.error("*************sTestcaseName"+sTestcaseName+"::::"+"FAILED");
			/*try {
				rtm.headingOfCSV();
				rtm.testcaseRTM(sTestcaseName);
				rtm.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 */
		}
	}



	public void  reporter(String sValue,String sValue1) {
		logger.info("In Reporter Method:::"+sValue+","+sValue1);
		Reporter.log("Step-"+getI()+":"+ sValue +sValue1+"<br>");
		i++;
	} 

	/**
	 * This Method is used to get the Absolute path of the File
	 * @param sFilepath
	 * @return :It returns the Path of the File
	 */

	public String getFilePath(String sFilepath) {
		char cforwardslash = (char) 47;
		char cbackslash = (char) 92;
		String sPath = System.getProperty("user.dir").replace(cbackslash,
				cforwardslash)
				+ sFilepath;

		File file = new File(sPath);
		/*
		 * if (file.exists()) { sPath = file.getAbsolutePath();
		 * logger.info("The File Path is " + sPath); } else {
		 * logger.error("File not Found"); }
		 */
		logger.info("The File path is" + file.getAbsolutePath());
		return file.getAbsolutePath();
	}

	public String AssertionresultOutput(WebDriver driver, String sTestcaseName) {
	/*	String sScreenshots = "/target/surefire-reports/Screenshots";
		String sFilepath = getFilePath(sScreenshots) + "\\";
		String sScreenshotName = null;
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {
			DateTime dateTime = new DateTime();
			sScreenshotName = sTestcaseName
					+ dateTime.yyyyMMDDHHmmssTime() + ".png";
			logger.info("sTestcaseName:::::" + sScreenshotName);
			
			Screenshot 	screenshot = new AShot().shootingStrategy(new ViewportPastingStrategy(1000)).takeScreenshot(driver);
			ImageIO.write(screenshot.getImage(), "PNG", new File(sFilepath + sScreenshotName));

			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(sFilepath + sScreenshotName));
			logger.info("SRC FIle Location for ScreenShot" + "::::"
					+ scrFile.getAbsolutePath());
			logger.info("The screenshot stored in location" + sFilepath
					+ sScreenshotName);

		} catch (Exception e1) {
			// logger.error("Exception caught in screenshotcreation block");
			e1.printStackTrace();
		}
		return "<a href=\""+sFilepath+"" + sScreenshotName
				+ "\"><p align=\"left\"><h5>Error screenshot :: "
				+ sScreenshotName + "</h5></p></a>";*/
	    return "value";    
	}

	/**
	 * This Method Provides the Reasons for the Test-Case Faliure in the Report and also Request&Response 
	 * @param ls
	 * @param file
	 * @param fileOperation
	 * @param sTestcaseName
	 * @throws IOException
	 * @throws InterruptedException 
	 */

	public void checkinglist(List<String> statusValue,FileOperation fileOperation,String sTestcaseName,String sFilepath,String sdestPath) throws IOException, InterruptedException {
		//  reporter("val1","val2");

		logger.info("driver value is" +driver.toString());
		if(driver.toString().contains("Firefox"))
		{
			logger.info("The value of driver is----------------->"+driver.toString());
			logger.info("Browser is  FireFox-------");
			setI(i);
			for (String  temp: statusValue) {
				if (temp.equals("FAIL")) {
					Thread.sleep(5000);
					fileOperation.moveFile(sFilepath, sdestPath,sTestcaseName);
					fileOperation.checkFileStatus(sdestPath,sTestcaseName);
					statusValue.clear();
					throw new Reasons("FAIL");
				}

				else
				{
					logger.info("The Test Case is Passed......In the Pass Method");
					fileOperation.deleteResponseFile(sFilepath);
				}

			}
		}

		else
		{
			logger.info("Browser is not FireFox-------");
			setI(i);
			for (String  temp: statusValue) {
				if (temp.equals("FAIL")) {
					statusValue.clear();
					throw new Reasons("FAIL");
				}
			}

		}

	}

	/**
	 * This method will determine whether the testcases is passed or failed.
	 * @param ls
	 */
	public void checkinglist(List<String> ls) {
		for (String  temp: ls) {
			if (temp.equals("FAIL")) {
				throw new Reasons("FAIL");
			}
		}
	}

	/*public void checkingRolelist(List<String> ls) {
		for (String  temp: ls) {
			if (temp.equals("FAIL")) {
				throw new Reasons("FAIL");
			}

			else
				throw new RoleAccessException("Passed");

		}
	}*/
	public void reset()
	{
		setI(i);
	}


	public void BackUpReport(String sourcepath,String destinationpath) throws Exception
	{
		DateTime dateTime = new DateTime();
		String val = dateTime.yyyyMMDDHHmmssTime();
		File srcFolder = new File("C:\\Users\ntemkar\\VBrickMainProject\\vBricksTest\\test-output\\html");
		File destFolder = new File("C:\\Users\\ntemkar\\Desktop"+val);
		copyFolder(srcFolder, destFolder);
		logger.info(" I am in backupreport");
	}

	public  void copyFolder(File src, File dest)throws IOException{
		if(src.isDirectory()){
			//if directory not exists, create it
			if(!dest.exists()){
				dest.mkdir();
				logger.info("Directory copied from " 
						+ src + "  to " + dest);
			}
			//list all the directory contents
			String files[] = src.list();
			for (String file : files) {
				//construct the src and dest file structure
				File srcFile = new File(src, file);
				File destFile = new File(dest, file);
				//recursive copy
				copyFolder(srcFile,destFile);
			}

		}else{
			//if file, then copy it
			//Use bytes stream to support all file types
			InputStream in = new FileInputStream(src);
			OutputStream out = new FileOutputStream(dest); 
			byte[] buffer = new byte[1024];
			int length;
			//copy the file content in bytes 
			while ((length = in.read(buffer)) > 0){
				out.write(buffer, 0, length);
			}
			in.close();
			out.close();
			// logger.info("File copied from " + src + " to " + dest);
		}
	}

	FileWriter fw = null;
	PrintWriter pw = null;

	public void headingOfCSV() throws IOException {
		//VerifyValidusernamepassword_Sprint17_RequirmentID01_TestcaseID01();
		// Write to file for the second row
		@SuppressWarnings("deprecation")
		String sRTMFile="D:/RTM"+new Date().getSeconds()+".csv";
		System.out.println("THe file name"+sRTMFile);
		File file = new File(sRTMFile);
		file.createNewFile();
		System.out.println("File Created "+file.exists());
		fw = new FileWriter(sRTMFile);
		pw = new PrintWriter(fw);
		pw.print("TestCase Title");
		pw.print(",");
		pw.print("Sprint No");
		pw.print(",");
		pw.print("Requirement ID");
		pw.print(",");
		pw.print("TestCase ID");
		pw.print(",");
		pw.print("Status");
		pw.println();
	}

	public void testcaseRTM(String sTestcaseName) throws IOException {
		//		String TCName = "Verify_Validusernamepassword_Sprint17_TC01_Req01";

		String[] strings = sTestcaseName.split("_");
		for (int i = 0; i < strings.length; i++) {
			System.out.println("The strings[i]" + strings[i]);
			pw.print(strings[i]);
			pw.print(",");
			//pw.append(strings[i]);
		}
		pw.println();

	}
	public void close() throws IOException {

		pw.flush();
		// Close the Print Writer
		pw.close();
		// Close the File Writer
		fw.close();
	}


}

