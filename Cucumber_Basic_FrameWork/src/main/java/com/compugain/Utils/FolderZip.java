package com.compugain.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.log4j.Logger;


class FolderZip extends FileOperation
 
{
   public static Logger logger = Logger.getLogger(FolderZip.class); 
	private List<String> fileList;
 
    public FolderZip(){
	fileList = new ArrayList<String>();
    }
 
    /**
     * Zip it
     * @param szipFilePath output ZIP file location
     */
    public void zipIt(String sOutputFolder,String sSourceFolder){
 
    	//logger.info("In the Zip it Method");
    	
     byte[] buffer = new byte[10240];
 
     try{
        //logger.info("Outpur Folder is-------->"+sOutputFolder);
    	FileOutputStream fos = new FileOutputStream(sOutputFolder);
    	ZipOutputStream zipOutputStream = new ZipOutputStream(fos);
 
    	////logger.info("Output to Zip : " + szipFilePath);
 
    	    for(String file : this.fileList){
    		////logger.info("File Added : " + file);
    		ZipEntry ze= new ZipEntry(file);
    		zipOutputStream.putNextEntry(ze);
 
        	//Provide the Path where Source Folder is located to read the values-----------
    		FileInputStream in = 
                       new FileInputStream(sSourceFolder + File.separator + file);
 
        	int len;
        	while ((len = in.read(buffer)) > 0) {
        		zipOutputStream.write(buffer, 0, len);
        	}
 
        	in.close();
    	}
 
    	    zipOutputStream.closeEntry();
    	//remember close it
    	    zipOutputStream.close();
 
    	////logger.info("Zip Folder Created for Reports");
    }catch(IOException ex){
    	//logger.error("Unable to create Zip Folder Exception Caught");
       ex.printStackTrace();   
    }
   }
 
   /**
    * 
    * @param node
    * @param sSourceFolder
    */
    public void generateFileList(File node,String sSourceFolder){
    
   // //logger.info("The value of node is--------"+node.toString());	
    	//add file only
    ////logger.info("In the generate File Method--------->");
	 if(node.isFile()){
		//logger.info("The value is File-------------"+node.getAbsoluteFile().toString());
		fileList.add(generateZipEntry(node.getAbsoluteFile().toString(),sSourceFolder));
	    //logger.info("the value of File is-------->"+fileList.toString());
	}
 
	if(node.isDirectory()){
		//logger.info("The value is Directory-------------");
	    String[] listOfDir=directoryExist(node);
		for(String filename : listOfDir){
			generateFileList(new File(node,filename),sSourceFolder);
		}
	}
 
    }
 
 
    /*public void generateFileListFromDirectory(File node,String sSourceFolder)
    {
    	//logger.info("In generate File List from Directory-------->");
    	 if(node.isDirectory())
    	 {
    	String[] arrFile=directoryExist(node);
		for(String filename : arrFile){
	    fileList.add(generateZipEntry(filename, sSourceFolder));	
		//generateFileList(new File(node, filename),sOutputZipFileReports,sOutFolder,sSourceFolder);
		}
    	 }
	}
 */
 
    /**
     * Format the file path for zip
     * @param file file path
     * @return Formatted file path
     */
    private String generateZipEntry(String file,String sSourceFolder){
    	return file.substring(sSourceFolder.length()+1,file.length());
    }
}