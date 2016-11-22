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



public class ExcelRead implements Setup {

	public TreeMap<String, LinkedList> excelDataMap;
	String sexcelFilepath = null;
	//public Iterator<Row> rowIt;
//	Sheet sheetName;
//	Workbook workbook = null;
	public FileInputStream fis = null;
	public Sheet sheetName =null;
	public Workbook workbook = null;
	private static Logger logger = Logger.getLogger(ReadTestData.class);

	public ExcelRead()  {

		String stestcaseFile= "E:/Cucumber/Cucumber_Basic_FrameWork/Cucumber_Basic_FrameWork/Data.xlsx";
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
		
		System.out.println("excelFileTye-----"+ssheetname);
		
		if (sexcelFilepath.toLowerCase().endsWith("xls"))
			workbook = new HSSFWorkbook(fis);
			else if (sexcelFilepath.toLowerCase().endsWith("xlsx"))
			workbook = new XSSFWorkbook(fis);
			else
				logger.error("Invalid cases file Format");
		if(isNumeric(ssheetname)) {
			System.out.println("Integer.parseInt(ssheetname)"+Integer.parseInt(ssheetname));
			sheetName = workbook.getSheetAt(Integer.parseInt(ssheetname));
			System.out.println("isNumeric"+sheetName);
			}else{
				sheetName = workbook.getSheet(ssheetname);
		}
	//	System.out.println( "The sheet name is"+sheetName);
	//	rowIt = sheetName.iterator();
		//logger.info( "The rowIT name is"+rowIt);
		
	//	System.out.println(sheetName.iterator().hasNext());
		
		
		return sheetName.iterator();
	}
	
	public void closeObjects() 
	{
		try {
			workbook.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
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
		System.out.println("Config Data ::::: "+configData);
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
			System.out.println("readTestCaseExcel----"+ssheetName);
			Iterator<Row> rowIt= excelFileTye(ssheetName);
			rowIt.next();
		
	
		while (rowIt.hasNext()) {
			row = rowIt.next();
			
			 className = row.getCell(0).getStringCellValue(); 
			 methodName = row.getCell(1).getStringCellValue(); 
			 flag = row.getCell(2).getStringCellValue();
			if (excelDataMap.containsKey(className)) {
				list = excelDataMap.get(className);
				list.add(methodName + "@!@" + flag);
				excelDataMap.put(className.trim(), list);
			} else {
				list= new LinkedList();
				list.add(methodName + "@!@" + flag);
				excelDataMap.put(className.trim(), list);
			}
			
			//excelMap.put("emailaddress",row.getCell(colno).getStringCellValue());
			//excelMap.put("browser", )

		}
		}catch(IOException ioException)
		{
			ioException.printStackTrace();
		}
		
		finally {
			closeObjects();
		}
		logger.info(excelDataMap+" :::::excelDataMap");
		
		return excelDataMap;
	}

	public boolean isNumeric(String str){
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
	
/*
	public static void main(String[] args) throws Exception {
		ReadTestData test = new ReadTestData();
		test.readConfigsheet("Config", 0, 1);
	}*/
}

