/*package com.compugain.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJson {

	ReadPropertiesFile propertiesFile;

	*//**
	 * Will return the path of the config properties file.
	 * @return :
	 *//*
	public String getconfigFilePath()
	{
		File file= new File(System.getProperty("user.dir")+"/src/test/resources/config.properties");
		//System.out.println("The path of the Jason TestData file is"+file.getAbsolutePath());
		return file.getAbsolutePath();
	}
	
	
	*//**
	 * Will the return the Key value from the json file
	 *//*
	public String getkeyValueFromTestData()
	{                                                        
		 char cforwardslash = (char) 47;
		 char cbackslash = (char) 92;
		propertiesFile = new ReadPropertiesFile();
		String sysPath=System.getProperty("user.dir").replace(cbackslash, cforwardslash);
		return sysPath+propertiesFile.readData("jsonTestData", getconfigFilePath());
	}
	
	
	public String getDataFromJson(String sKey) {
	     JSONObject jsonObject = null;
		 JSONParser parser = new JSONParser();
		try {
		//	System.out.println("The jason file path"+getkeyValueFromTestData().replace(cforwardslash, cbackslash));
			Object obj = parser.parse(new FileReader(getkeyValueFromTestData()));
			 jsonObject = (JSONObject) obj;
		//	String name = (String) jsonObject.get(sKey);
			System.out.println((String) jsonObject.get(sKey));
	 

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return (String) jsonObject.get(sKey);

	}
	
}
*/