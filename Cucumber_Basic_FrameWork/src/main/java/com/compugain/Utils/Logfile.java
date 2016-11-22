package com.compugain.Utils;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Logfile {
	public static Logger logger = Logger.getLogger(Logfile.class);

	/**
	 * This method will configure log4j properties with respect to the
	 * properties given in the property file.
	 * 
	 */
	
	/**
	 * logFile method is used to set the properties of log4j
	 */
	public void logFile() {

		try {
			PropertyConfigurator
					.configure(getFilePath("/src/test/resources/log4j.properties"));
			logger.info("Logging is started");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Logging is started");

	}
/**
 *  getFilePath method is used to replace backslash with forward slash 
 * @param sFilepath
 * @return
 */
	
	public String getFilePath(String sFilepath) {
		char cforwardslash = (char) 47;
		char cbackslash = (char) 92;
		String sPath = System.getProperty("user.dir").replace(cbackslash,
				cforwardslash)
				+ sFilepath;
		File file = new File(sPath);
		if (file.exists()) {
			sPath = file.getAbsolutePath();
			logger.info("The File Path is " + sPath);
		} else {
			logger.error("**************File not Found*********************");
		}
		return sPath;
	}
}
