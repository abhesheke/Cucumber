package com.compugain.beanfactory;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;

import com.compugain.Utils.ReadAndWriteToJSON;
import com.compugain.dao.LoginBeanPage;
import com.compugain.setup.Setup;

public class BeanFactory implements Setup,DataInterface{
	
	JSONObject jsonObject;

	public BeanFactory() {
	
		// String param=sREADDATAFROMJSON;
		if (sREADDATAFROMJSON.equalsIgnoreCase("yes")) {
			try {
				this.jsonObject=ReadAndWriteToJSON.readDataFromJson();
				//System.out.println("---------------------"+ReadAndWriteToJSON.readDataFromJson());
			} catch (java.lang.NullPointerException e) {
				e.printStackTrace();
			}

		}

	}
	
	
	public void loginPageBean(LoginBeanPage loginbean){
		
		String username="rohith.kakumani";
		String password="rohith";
		loginbean.setUsername(username);
		loginbean.setPassword(password);
	}

	public String emailRandomValuesGeneration( ){
	return	RandomStringUtils.randomAlphabetic(5).toLowerCase()+"@sharklasers.com";
	    
	  }

	
	public String switchMaptoJSON(String key)
	{
		
		//System.out.println("the value is@@@@@@@@@@@@@@@@@@@@@@@@"+string);
		if(sREADDATAFROMJSON.equalsIgnoreCase("yes")){
		System.out.println("I am in Test Data JSON");
		System.out.println("The present is "+key);
		System.out.println("THe json object is"+jsonObject);
		System.out.println("JSON@@@@@@@@@@@@@@@@@@@@@@@@@@@"+(String) jsonObject.get(key));
		return (String) jsonObject.get(key);
		}
		else 
			return key;
	}
	
	public Map<String, String> getUserDetails(){
		
		Map<String, String> map=new HashMap<String, String>();
		map.put("tataskyRMN",switchMaptoJSON("tataskyRMN"));
		map.put("tataskyprofilepassword",switchMaptoJSON("tataskyprofilepassword"));
		map.put("cgttusername",switchMaptoJSON("cgttusername"));
		map.put("cgttpassword",switchMaptoJSON("cgttpassword"));
		map.put("salesforceRegfirstname",switchMaptoJSON("salesforceRegfirstname"));
		map.put("salesforceReglastname",switchMaptoJSON("salesforceReglastname"));
		map.put("salesforceRegemail",switchMaptoJSON("salesforceRegemail"));
		map.put("salesforceRegphone",switchMaptoJSON("salesforceRegphone"));
		map.put("salesforceRegcompany",switchMaptoJSON("salesforceRegcompany"));
		map.put("salesforceRegemployeesdropdownlocator",switchMaptoJSON("salesforceRegemployeesdropdownlocator"));
		map.put("salesforceRegepostalcode",switchMaptoJSON("salesforceRegepostalcode"));
		map.put("emailRandomValue",switchMaptoJSON("emailRandomValue"));
		map.put("carwaleusername",switchMaptoJSON("carwaleusername"));
		map.put("carwaleuseremail",switchMaptoJSON("carwaleuseremail"));
		map.put("carwaleuserconfirmemail",switchMaptoJSON("carwaleuserconfirmemail"));
		map.put("carwaleuserpassword",switchMaptoJSON("carwaleuserpassword"));
		map.put("carwaleuserconfirmpassword",switchMaptoJSON("carwaleuserconfirmpassword"));
		map.put("carwaleforgotpasswordmail",switchMaptoJSON("carwaleforgotpasswordmail"));
		map.put("iphone",switchMaptoJSON("iphone"));
		map.put("iphone6s",switchMaptoJSON("iphone6s"));
		map.put("bag",switchMaptoJSON("bag"));
		//map.put("amazonemail",switchMaptoJSON("amazonemail"));
		map.put("amazonemail","arjun.abhesheke@compugain.com");
		map.put("amazonpassword","Testing@1#");

	//	map.put("amazonpassword",switchMaptoJSON("amazonpassword"));
		map.put("shippingaddresserrormsg",switchMaptoJSON("shippingaddresserrormsg"));
		map.put("yahoomail",switchMaptoJSON("yahoomail"));
		map.put("tataskyrechargeamount", switchMaptoJSON("tataskyrechargeamount"));
		//Avenger
		map.put("avengerusername", switchMaptoJSON("avengerusername"));
		map.put("avengerpassword", switchMaptoJSON("avengerpassword"));
		map.put("avengerusercreationfirstname", switchMaptoJSON("avengerusercreationfirstname"));
		map.put("avengerusercreationlastname", switchMaptoJSON("avengerusercreationlastname"));
		map.put("avengeruserusername", switchMaptoJSON("avengeruserusername"));
		map.put("avengerusercreationemail", switchMaptoJSON("avengerusercreationemail"));
		map.put("avengeruserlanguage", switchMaptoJSON("avengeruserlanguage"));
		map.put("avengeruseraccountsadminrole", switchMaptoJSON("avengeruseraccountsadminrole"));
		map.put("avengernewuserpassword", switchMaptoJSON("avengernewuserpassword"));
		map.put("avengernewusersecurityanswer", switchMaptoJSON("avengernewusersecurityanswer"));
		map.put("avengernewusersecurityquestion", "What was your first car?");
		
		
		return map;
		
		}
	
	
}
