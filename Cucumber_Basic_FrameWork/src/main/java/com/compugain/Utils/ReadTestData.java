package com.compugain.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.compugain.setup.Setup;



public class ReadTestData implements Setup {

	public TreeMap<String, LinkedList> excelDataMap;
	private  String sexcelFilepath = null;
	public Iterator<Row> rowIt;
//	Sheet sheetName;
//	Workbook workbook = null;
	public FileInputStream fis = null;
	public Sheet sheetName =null;
	public Workbook workbook = null;
	private static Logger logger = Logger.getLogger(ReadTestData.class);
	
	public ReadTestData()  {

		String stestcaseFile="E:/Cucumber/Cucumber_Basic_FrameWork/Cucumber_Basic_FrameWork/Data.xlsx";
		try{
			if(stestcaseFile.contains("src"))
				sexcelFilepath = FileOperation.getFilePath(stestcaseFile);
		else
			sexcelFilepath =stestcaseFile;
			
		System.out.println("File path"+sexcelFilepath);
		fis = new FileInputStream(sexcelFilepath);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
	public Iterator<Row> excelFileTye(String ssheetname) throws IOException 
	{
	
		if (sexcelFilepath.toLowerCase().endsWith("xls"))
			workbook = new HSSFWorkbook(fis);
			else if (sexcelFilepath.toLowerCase().endsWith("xlsx"))
			workbook = new XSSFWorkbook(fis);
			else
			System.err.println("Invalid cases file Format");
		
		sheetName = workbook.getSheet(ssheetname);
		logger.info( "The sheet name is"+sheetName);
		rowIt = sheetName.iterator();
		logger.info( "The rowIT name is"+rowIt);
		return rowIt;
	}
/*	
	public void closeObjects() 
	{
		try {
			workbook.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
	public static HashMap<String, String> configData=null;
	public  HashMap<String, String> readConfigsheet(String ssheetname,int keyCol,int valueCol) throws IOException
	{
		Integer i=1;
		Iterator<Row>  rowIterator= excelFileTye(ssheetname);
		configData=new HashMap<String, String>();
		Row row;
		row = rowIterator.next();
		while (rowIterator.hasNext()) {
			row = rowIterator.next();
			
		configData.put(row.getCell(keyCol).getStringCellValue(),row.getCell(valueCol).getStringCellValue());
		//i++;
		}
		logger.info("Config Data ::::::::::::: "+configData);
		return configData;
	}
	
	@SuppressWarnings("unchecked")
	public TreeMap<String,LinkedList> readTestCaseExcel(String ssheetName)  {
		LinkedList list;
		Row row;
		String className,methodName,flag;
		excelDataMap = new TreeMap<String, LinkedList>();
		//HashMap<String, String> excelMap=new HashMap<String, String>();
		try{
		excelFileTye(ssheetName).next();
		int i=0;
		while (rowIt.hasNext()) {
			
			row = rowIt.next();
			
			 className = row.getCell(0).getStringCellValue(); 
			 methodName = row.getCell(1).getStringCellValue(); 
			 flag = row.getCell(2).getStringCellValue();
			 
			if (excelDataMap.containsKey(className)) {
				list = excelDataMap.get(className);
				list.add(methodName + "@!@" + flag);
				excelDataMap.put(className, list);
				System.out.println(i+":::IF ::::: ExcelData Map :::"+excelDataMap);
			} else {
				list= new LinkedList();
				list.add(methodName + "@!@" + flag);
				excelDataMap.put(className, list);
				System.out.println(i+"ELSE ::::: ExcelData Map :::"+excelDataMap);
			}
			i++;
		}
		}catch(IOException ioException)
		{
			ioException.printStackTrace();
		}
		
		finally {
		//	closeObjects();
		}
		logger.info(excelDataMap+" :::::excelDataMap");
		System.out.println(excelDataMap+" :::::excelDataMap");
		
		return excelDataMap;
	}


}
