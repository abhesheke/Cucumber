package com.compugain.Utils;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.compugain.setup.Setup;

public class ReadAndWriteToJSON implements Setup{
	
	private static Logger logger = Logger.getLogger(ReadAndWriteToJSON.class);
	@SuppressWarnings("unchecked")
	public static void writeZoneSetupDataToJson(Map<String, String> zonesetupdetails)
	{
		JSONObject obj = new JSONObject();
		obj.put("ZoneSetupDetails", zonesetupdetails);

		try {

			File file = new File("src/test/resources/DataSource/ActiveDevicesData.json");
			
			if(!file.exists()){
				file.createNewFile();
				logger.info("Creating a new File");
			}
			FileWriter filewriter = new FileWriter(file.getPath());
			filewriter.write(obj.toJSONString());
			filewriter.flush();
			filewriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.print("Zone logic setup file details"+ obj);
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String, String> readZoneDataFromJson() 
	{
		// TODO Auto-generated method stub

		  JSONParser parser = new JSONParser();

		  JSONObject jsonObject = null;
		  try {
		   jsonObject = (JSONObject) parser.parse(new FileReader("src/test/resources/DataSource/ActiveDevicesData.json"));
		   
		  } catch (FileNotFoundException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  } catch (IOException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		  
		 return (Map<String, String>) jsonObject.get("ZoneSetupDetails");
	}
	
	@SuppressWarnings("unchecked")
	public static String readDataFromJson(String usernumber) 
	{
		JSONParser parser = new JSONParser();
		Object obj;
		String datavalue = null;
		try {
			obj = parser.parse(new FileReader(sTESTDATAJSON));
			JSONObject jsonObject = (JSONObject) obj;
			datavalue= (String) jsonObject.get("RMN");
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         return  datavalue; 
	}
	
	@SuppressWarnings("unchecked")
	public static JSONObject readDataFromJson() 
	{
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = null;
		Object obj;
		try {
			obj = parser.parse(new FileReader(sTESTDATAJSON));
			jsonObject = (JSONObject) obj;
			//System.out.println("RMNNNNNNNNNNNNNNNNNNNNNNN" +(String) jsonObject.get("RMN"));
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
         return  jsonObject; 
	}
	
	
}

