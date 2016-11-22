package com.compugain.api;

import static com.jayway.restassured.RestAssured.given;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.json.simple.JSONObject;

import com.google.gson.JsonObject;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

public class UserCreateApi implements ConstantsValue {

//	public String url=ConstantsValue.baseUrl;
//	public String APIkey=ConstantsValue.APIkey;
//	public String secretkey=ConstantsValue.secretkey;
	public Response response;
	public CreateUserDetails createUserDetails;
	
	
	public String hmac_sha256(String secretKey, String data) {
		String authCode = null;
		try {

			Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
			SecretKeySpec secret_key = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
			sha256_HMAC.init(secret_key);

			authCode = new String(Base64.encodeBase64(sha256_HMAC.doFinal(data.getBytes())));

			System.out.println("--Authentication------------->" + authCode);
		} catch (Exception e) {
			System.out.println("Error");
		}
		return authCode;

	}

	public static String dateStampUTC() {

		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a");
		String timeStamp = sdf.format(date);
		System.out.println("Date format-->" + timeStamp);
		return timeStamp;

	}

	
	public String doAuthorization( ) {

		String dstamp = dateStampUTC();

		String data = "" + APIkey + ":" + dstamp + "";
		String sKey = hmac_sha256(secretkey, data);
		String oAuth = "" + APIkey + "::" + dstamp + "::" + sKey + "";

		try {
			
			response = given()
					         .header("ApiAuthorization", oAuth)
					         .when()
					         .post(baseUrl + "/api/v1/auth");
			
			System.out.println("Authentication --->" + response.asString());
			response.path("authorization");
			System.out.println("AuthenToken" + response.path("authorization"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response.path("authorization").toString();
	}

	
	public String doUserLoginApi(String AuthenToken) {

		LoginUserDetails logindetails = new LoginUserDetails(USERNAME,PASSWORD );
		try {
			response = given()
							.header("Authorization", "VBrick" + " " + AuthenToken)
							.contentType(ContentType.JSON)
							.body(logindetails)
							.when()
							.post(baseUrl + "/api/v1/user/login");
			
			System.out.println("AuthenToken-----------------" + response.path("token"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response.path("token");
	}

	/**
	 * 
	 * @param AcessToken
	 * @param roleType  : Event,Account,Media
	 * @return
	 */
	public ArrayList<String> userRolesApi(String AcessToken,String roleType) {
		String roleId = null;

		ArrayList<String> data = new ArrayList<String>();
		
		if(roleType.equalsIgnoreCase("AccountAdmin")){
			
		try {
			response = given()
							.header("Authorization", "VBrick" + " " + AcessToken)
							.contentType(ContentType.JSON)
							.when()
							.get(baseUrl + "/api/v1/users/roles");
			
			System.out.println("User Roles Details-----------------" + response.asString());

			JsonPath path = JsonPath.from(response.asString());

			System.out.println("-------------" + path.getString("id[0]"));

			roleId = path.getString("id[0]").toString();
			System.out.println("Role id---------"+roleId);
			data.add(AcessToken);
			data.add(roleId);
			System.out.println("The value of array is"+data);
		}
		
	 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	} else if(roleType.equalsIgnoreCase("Media Admin")){
		
		try {
			response = given()
							.header("Authorization", "VBrick" + " " + AcessToken)
							.contentType(ContentType.JSON)
							.when()
							.get(baseUrl + "/api/v1/users/roles");
			
			System.out.println("User Roles Details-----------------" + response.asString());

			JsonPath path = JsonPath.from(response.asString());

			System.out.println("-------------" + path.getString("id[1]"));

			roleId = path.getString("id[1]").toString();
			data.add(AcessToken);
			data.add(roleId);
		}
		
	 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	} else if(roleType.equalsIgnoreCase("Media Viewer")){
		try {
			response = given()
							.header("Authorization", "VBrick" + " " + AcessToken)
							.contentType(ContentType.JSON)
							.when()
							.get(baseUrl + "/api/v1/users/roles");
			
			System.out.println("User Roles Details-----------------" + response.asString());

			JsonPath path = JsonPath.from(response.asString());

			System.out.println("-------------" + path.getString("id[2]"));

			roleId = path.getString("id[2]").toString();
			data.add(AcessToken);
			data.add(roleId);
		}
		
	 
		catch (Exception e) {
			e.printStackTrace();
		}
	} else if(roleType.equalsIgnoreCase("Event Admin")){
		try {
			response = given()
							.header("Authorization", "VBrick" + " " + AcessToken)
							.contentType(ContentType.JSON)
							.when()
							.get(baseUrl + "/api/v1/users/roles");
			
			System.out.println("User Roles Details-----------------" + response.asString());

			JsonPath path = JsonPath.from(response.asString());

			System.out.println("-------------" + path.getString("id[3]"));

			roleId = path.getString("id[3]").toString();
			data.add(AcessToken);
			data.add(roleId);
		}
		
	 
		catch (Exception e) {
			e.printStackTrace();
		}
	} else if(roleType.equalsIgnoreCase("Media Contributor")){
		try {
			response = given()
							.header("Authorization", "VBrick" + " " + AcessToken)
							.contentType(ContentType.JSON)
							.when()
							.get(baseUrl + "/api/v1/users/roles");
			
			System.out.println("User Roles Details-----------------" + response.asString());

			JsonPath path = JsonPath.from(response.asString());

			System.out.println("-------------" + path.getString("id[4]"));

			roleId = path.getString("id[4]").toString();
			data.add(AcessToken);
			data.add(roleId);
		}
		
	 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
		return data;

	}

	public 	HashMap<String ,String> createUserAPI(ArrayList<String> data,String fileds,CreateUserDetails createUserDetails,JSONObject sJsonObject) {
		/*Random r = new Random();
		int countryCode = r.nextInt((1900 - 500) + 1) + 500;
		int localCode = r.nextInt((1500 - 400) + 1) + 400;
		int phNumber = r.nextInt((19000 - 4500) + 1) + 4500;
		*//*** PhoneNumber *****//*
		String phoneNumber = "(" + countryCode + ") " + localCode + "-" + phNumber + "";

		*//*** Email Id *****//*
		int emailRND = r.nextInt((1100 - 210) + 1) + 210;
		String emailId = "apiuser" + emailRND + "@gmail.com";
		*//*** firstName ***//*
		int fnameRND = r.nextInt((1100 - 10) + 1) + 10;
		String fname = "fnameAPiuser" + fnameRND;

		String language = "en";

		*//*** lastName ***//*
		int lnameRND = r.nextInt((1100 - 10) + 1) + 10;
		String lname = "lnameAPiuser" + lnameRND;
		*//*** title ***//*
		String title = fname;
		*//*** userName ***//*
		String userName = fname;
		System.out.println("UserName is--->" + userName);*/
		String validData="allmandatory";
		String withOutUserName="withOutUserName";
		 
		HashMap<String ,String> responedata=new HashMap<String,String>();
		if(fileds.equals(validData)){
			
			createUserDetails.userType(data.get(1));
		      try {
					
		    	  
					response = given()
									.header("Authorization", "VBrick" + " " + data.get(0))
									.contentType(ContentType.JSON)
									.body(sJsonObject)
									.when()
									.post(baseUrl + "/api/v1/users");
					
					System.out.println("User Roles Details-----------------" + response.asString());
					
					JsonPath path = JsonPath.from(response.asString());
					responedata.put("userId", path.getString("userId"));
					responedata.put("accesstoken", data.get(0));
					
				} catch (Exception e) {
					e.printStackTrace();
				}

		}else if(fileds.equalsIgnoreCase(withOutUserName))
		{
			createUserDetails.CreateUserDetails_withoutUsername(data.get(1));
 
		try {
			
 
			response = given()
							.header("Authorization", "VBrick" + " " + data.get(0))
							.contentType(ContentType.JSON)
							.body(sJsonObject)
							.when()
							.post(baseUrl + "/api/v1/users");
			
			System.out.println("User Roles Details-----------------" + response.asString());
			
			JsonPath path = JsonPath.from(response.asString());
			responedata.put("code", path.getString("code"));
			responedata.put("detail", path.getString("detail"));
		 
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		}
		return responedata; 
	}
	 

	/*public static void main(String[] args) {
		UserCreateApi dp = new UserCreateApi();
		// dp.doAuthorization();
	//	String AcessToken = dp.doUserLoginApi(dp.doAuthorization());
	//	ArrayList<String> inputs = dp.userRolesApi(ConstantsValue.accountAdmin);
	//	 dp.createUserAPI(inputs);
	}*/
	
	public void deleteUserApi(Map<String, String> responsedata){
		 // System.out.println("the id is"+acTokenAndUserId.get(0));
		  //System.out.println("the role is"+acTokenAndUserId.get(1));
		  
		  
		  try{
		  response=given()
		           .header("Authorization","VBrick"+" "+responsedata.get("userId"))
		           .contentType(ContentType.JSON)
		           .pathParam("userId",responsedata.get("accesstoken"))
		           .when()
		           .delete(baseUrl +"/api/v1/users/{userId}");
		   System.out.println("User Roles Details-----------------"+response.asString());
		  }
		  catch(Exception e){
		   e.printStackTrace();
		   }
		 }

}
