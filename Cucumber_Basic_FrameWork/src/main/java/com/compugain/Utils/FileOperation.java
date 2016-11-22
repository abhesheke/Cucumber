package com.compugain.Utils;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.testng.Reporter;

public  class FileOperation {

	private static Logger logger = Logger.getLogger(FileOperation.class);
	
	
	/**
	 * This Method is used to get the Absolute path of the File
	 * @param sFilepath : Contains the Folder Path.
	 * @return : It returns the Path of the File
	 */
	
	
	public static String getFilePath(String sFilepath) {
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
			logger.error("File not Found");
		}
		return sPath;
	}
	
	
	
	
	public static String getFileName(String sFilepath)
	{
		logger.info("File Path is"+sFilepath);
		File file = new File(sFilepath);
		String fileName = file.getName();
		//fileName = fileName.substring(0,fileName.indexOf("."));
		logger.info("File Name is"+fileName);
		return fileName;
	
	}
	
	/**
	 * This provides the List of Response Files generated during the Test-Case Execution
	 * @param sFilepath : Contains the File Path.
	 * @return: Returning the List of Files
	 */
	public ArrayList<String> getResponseFileName(String sFilepath) {
		ArrayList<String> listofFiles = new ArrayList<String>();
		logger.info("The value of path is-------------->"+sFilepath);
		logger.info("In get File Name Method------------>");
		
		File file = new File(sFilepath);
		if(file.exists())
		{
		File[] listoffile = file.listFiles();
		logger.info("The list of files are "+listoffile.toString());
		logger.info("Length of the Files "+listoffile.length);
		for (int i = 0; i < listoffile.length; i++) {
			logger.info("The name given is---------->"+ listoffile[i].getAbsolutePath());
			listofFiles.add(listoffile[i].getAbsolutePath());
		}
		}
		else {
			logger.error("FILE NOT FOUND");
		}
			return listofFiles;
	}
	
	/**
	 * This Method Provide to move the response file for Failed Test-Case to another Folder and Renaming it according to the TestCase Name 
	 * @param sFilepath : Contains the path for the Downloads Folder.
	 * @param destPath : Contains the Path for the Response Folder.
	 * @param sTestcaseName :Contains the Test case name.
	 * @return:Returning only the boolean value
	 * @throws IOException
	 */
	public boolean moveFile(String sFilepath, String destPath,
			String sTestcaseName) throws IOException {
		File file = null;
		logger.info("File path :::"+sFilepath);
		logger.info("DestPath ::::"+destPath);
		logger.info("TestcaseName:::"+sTestcaseName);
		logger.info("In the moveFile Method-------------");
		ArrayList<String> listofFiles  = new ArrayList<String>();
		if(getFileName(sFilepath) != null){
		listofFiles.addAll(getResponseFileName(sFilepath));
		 file = new File(listofFiles.get(0));
		listofFiles=getResponseFileName(sFilepath);  
		//file = new File(listofFiles.toString());
	    //String str=listofFiles.get(0);
		logger.info("The file name is--------" + file.getName());
		logger.info("---------------------The file is being Moved -------------");
		}
		 Reporter.log("<a href=\"" + destPath +"/"+sTestcaseName
				  + "\"target='blank'><p align=\"left\"><h5>Click to get Response Data"
				  + "value" + "</h5></p></a>");
				  logger.info("The file destPath path is--------" + destPath +"/"+sTestcaseName);
		
		return file.renameTo(new File(destPath, sTestcaseName));
		
	}
	
	/**
	 * This Method help us to check the Status of the file wheather it is moved to the new folder and Renamed with the same name as TestCase Name
	 * @param destPath : Contains the path for the Response Folder
	 * @param sTestcaseName : Contains the test-case name.
	 */
	
	
	public void checkFileStatus(String destPath,String sTestcaseName )
	{
	//ArrayList<String> listofFiles = new ArrayList<String>();
		logger.info("In Status Check Method------------>");
		File file = new File(destPath);
		File[] listoffile = file.listFiles();
   
		String slistofFiles;
		for (int i = 0; i < listoffile.length; i++) {
			slistofFiles = listoffile[i].getName();
			   if(sTestcaseName.equalsIgnoreCase(slistofFiles))
			   {
				  boolean var= listoffile[i].exists();
				  logger.info("File is Found"+var); 
			   }
			   else
			   {
				   logger.info("File Not Found in the Folder");
			   }
		}
	}
	
	
	/**
	 * This Method is used to Delete the file from the Folder.
	 * @param sFilepath: Contains the path for the Response Folder.
	 */
	
	public void deleteResponseFile(String sFilepath)
	{
		File file = new File(sFilepath);
		 File[] listofFile = file.listFiles();
		 for(int i=0;i<listofFile.length;i++)
		 {
			 if(listofFile[i].exists())
			 {
				 logger.info("File is Present");
				  boolean status=listofFile[i].delete();
                  logger.info("The File is Deleted-------->"+status);				    
 				 
			 }
			 else
			 {
				 logger.info("File is Not Present");
				 
			 }
			 
		 }
		
		
	}
	
	 
	/**
	 * This Method Creates a Directory which stores all the responses.
	 * @param sFolderName :Contains the path for the DownLoads Folder were Response file is created. 
	 * @param sDestPath : Contains the Path for the Response Folder.
	 */
	
	
	
	
	public void createResponseDirectory(String sFolderName,String sDestPath)
	   {
		  
		   File file1 = new File(getFilePath(sDestPath));
		   File file = new File(getFilePath(sFolderName));
		   //logger.info(file.getAbsolutePath());
		    file1.mkdir();
		   if(file.exists() || file.isDirectory())
		   {
			   logger.info("Folder Exist---------->");
			  logger.info("The value of the Absolute File is--------->"+file.getAbsoluteFile().toString());
			   
			   if(file.getAbsoluteFile().exists())
			   {
				   logger.info("Searching for the File------------->");
				   
				   File[] fileArr = file.getAbsoluteFile().listFiles();
				     logger.info("The Files are Present------------->"+fileArr.toString());
				      logger.info("The Files are Present------------->"+fileArr.length); 
				     
				    for(int i=0;i<fileArr.length;i++)
				    {
				    	if(fileArr[i].exists())
				    	{
				    		fileArr[i].delete();
				    		logger.info("The File is Deleted");
				    	}
				    	else
				    	{
				    		if(file.length()<=0)
				    			{
				    			   logger.info("Folder is Empty");
				    			
				    			}
				    	}
				    	
				    }
			   }
		   }
		   
		   else
		   {
			   file.mkdir();
			   logger.info("The Folder is Created");
		   }
		   
		   
	   }
	   
	/**   
	 * This Method moves  the Response Folder and Html Reports to the Backup Folder in the Framework.
	 * @param sResponseFolder :Contains the Path for the Response Folder.
	 * @param sBackupFolder : Contains the Path for the Backup Folder.
	 * @param sHtmlReportFolder : Contains the path for the HTML Reports.
	 */
	public void moveDataBackup(String sResponseFolder,String sBackupFolder,String sHtmlReportFolder) 
	   {
		   logger.info("In the DataBack_Up Folder");
		   File file = new File(getFilePath(sResponseFolder));
		   File file1 = new File(getFilePath(sBackupFolder));
		   File file2 = new File(getFilePath(sHtmlReportFolder));
		    file1.mkdir();
		    logger.info("The BackUp directory is created");
		   try {
			file.renameTo(new File(file1,file.getName() + new DateTime().yyyyMMDDHHmmssTime()));
			Thread.sleep(5000);
			file2.renameTo(new File(file1,file2.getName() + new DateTime().yyyyMMDDHHmmssTime()));
			logger.info("Folder is Moved-------------");
		     file.mkdir();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   }
	
	/**
	 * 
	 * @param sFilePath
	 * @return
	 */
	
	public boolean fileExist(File sFilePath)
	{
		logger.info("In the File Exist Method");
		boolean status =false;
		if(sFilePath.isFile()){
			logger.info("File is Present-------");
		}
		else
		{
			logger.info("File does not exist.........");
		}
		return status;
	}
	 
	/**
	 *    
	 * @param sFilePath
	 * @return
	 */
	public String[] directoryExist(File sFilePath)
	   {
		String[] list = null;
		if(sFilePath.isDirectory())
		{
			 list=sFilePath.list();
			logger.info("Directoryis fount and files are getting added");
		}
		
		else
		{
			logger.info("The above is not Directory");
			
		}
		return list;
	   }
	
	
	public static ArrayList<String> getAllFileNamesFromDirectory(String filepath)
	 {
	  File folder = new File(filepath);
	  File[] listOfFiles = folder.listFiles();
	       ArrayList<String> filenames= new ArrayList<String>();
	  for (int i = 0; i < listOfFiles.length; i++) {
	   if (listOfFiles[i].isFile()) {
	    logger.info("File " + listOfFiles[i].getName());
	    filenames.add(listOfFiles[i].getName());
	   } else if (listOfFiles[i].isDirectory()) {
	    logger.info("Directory " + listOfFiles[i].getName());
	    filenames.add(listOfFiles[i].getName());
	   }
	  }
	  return filenames;
	 }
	
	public static boolean deleteFileFromDirectory(String filepath,String filename)
	 {
	  boolean filedelete=false;
		File folder = new File(filepath);
	  File[] listOfFiles = folder.listFiles();
	  for (int i = 0; i < listOfFiles.length; i++) {
	   if (listOfFiles[i].isFile()) {
	    logger.info("File " + listOfFiles[i].getName());
	    if(listOfFiles[i].getName().equalsIgnoreCase(filename))
	    {
	    	listOfFiles[i].delete();
	    	logger.info("File Deleted Successfully"+filename);
	    	filedelete=true;
	    }
	   } else if (listOfFiles[i].isDirectory()) {
		   if(listOfFiles[i].getName().equalsIgnoreCase(filename))
		    {
		    	listOfFiles[i].delete();
		    	logger.info("File Deleted Successfully"+filename);
		    	filedelete=true;
		    }
		    logger.info("Directory " + listOfFiles[i].getName());
	   }
	   else 
	     filedelete=false;
	  }
	  logger.info("File deleted status "+filedelete);
	  return filedelete;
	 }
	
	
	
	public static ArrayList<String> ReadCSVFile(String Path) {
		  ArrayList<String> csvfiledata = new ArrayList<String>(); 
		 try { 
				
	      String csvFile = Path;
	      //create BufferedReader to read csv file
	      BufferedReader br = new BufferedReader(new FileReader(csvFile));
	      String line = "";
	      StringTokenizer st = null;
	     
	      int lineNumber = 0; 
	      int tokenNumber = 0;

	      //read comma separated file line by line
	      while ((line = br.readLine()) != null) {
	        lineNumber++;
	  
	        //use comma as token separator
	        st = new StringTokenizer(line, ",");

	        while (st.hasMoreTokens()) {
	          tokenNumber++;

	          //display csv values
	         // System.out.print("The Values in CSV are "+st.nextToken() + "\n");
	          csvfiledata.add(st.nextToken());
	        }

	        System.out.println();

	        //reset token number
	        tokenNumber = 0;
	      }

	    } catch (Exception e) {
	      System.err.println("CSV file cannot be read : " + e);
	    }
		 logger.info("The Array list value of csv file is"+csvfiledata);
	    return csvfiledata;
	  }

	public static void deleteDir(File dir) {
	      try {
			FileUtils.cleanDirectory(dir);
			logger.info("Cleaned the Directory");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.info("Deleting Directory failed");
			e.printStackTrace();
		}
	  }

	public static ArrayList<String> fileReadingNotepad(String Path)
	{
		BufferedReader br = null;
		ArrayList<String> filedata = new ArrayList<String>();
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(Path));
			while ((sCurrentLine = br.readLine()) != null) {
				if (sCurrentLine.isEmpty())
				    continue;
				logger.info(sCurrentLine);
				filedata.add(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			logger.info("current list is"+filedata);
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return filedata;

	}
	
public static boolean deleteFile(String FILE_PATH){
		
		File file = new File(FILE_PATH);
		return file.delete();
	}
	
}


 
   

	
	
	
