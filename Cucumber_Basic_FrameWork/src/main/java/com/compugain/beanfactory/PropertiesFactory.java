package com.compugain.beanfactory;

import java.util.HashMap;
import java.util.Map;

public class PropertiesFactory {

	public Map<String, String> getObjectProperties(){
		Map<String, String> map = new HashMap<String, String>();
		//CGTT
		map.put("usernamelocator", "//input[@id='ctl00_ContentPlaceHolder1_txtUserName']");
		//map.put("usernamelocator", "//input[@id='ctl00_ContentPlaceHolder1_txt']");
		map.put("passwordlocator", "//input[@id='ctl00_ContentPlaceHolder1_txtPassword']");
		map.put("submitButton", "//input[@id='ctl00_ContentPlaceHolder1_btnSubmit']");
		map.put("managetimesheetlink", "//a[@id='ctl00_dlMenus_ctl02_HyperLink1']");
		
		/*Salesforce*/
		  map.put("salesforceRegfirstnamelocator", "//input[@id='UserFirstName']");
		  map.put("salesforceReglastnamelocator", "//input[@id='UserLastName']");
		  map.put("salesforceRegemaillocator", "//input[@id='UserEmail1']");
		  map.put("salesforceRegphonelocator", "//input[@id='UserPhone']");
		  map.put("salesforceRegcompanylocator", "//input[@id='CompanyName']");
		  map.put("salesforceRegemployeesdropdownlocator", "//select[@id='CompanyEmployees']");
		  map.put("selectedemployees","//select[@id='CompanyEmployees']/option[2]");
		  map.put("salesforceRegepostalcodelocator", "//input[@id='CompanyPostalCode']");
		  map.put("salesforceRegsignmeuplocator", "//span[contains(text(),'sign me up')]");
		  
		  //Guerilla Email Properties
		  map.put("guerillatestbutton", "//span[@id='inbox-id']");
		  map.put("guerillatextbox", "//span[@class='editable button edit-in-progress']/input");
		  map.put("guerillasetbuttonlocator", "//span[@id='inbox-id']/button[1]");
		  map.put("guerillaResetPasswordEmail", "//span[contains(text(),'To reset your CarWale password')]");
		  map.put("guerillaResetlink", "//*[@id='display_email']/div/div[2]/div/p[3]/a");
		  
		  
	//carwale
		  
		  map.put("carwaleRegnametextboxlocator", "//input[@id='ctlRegister_txtName']");
		  map.put("carwaleRegemailtextboxlocator", "//input[@id='ctlRegister_txtEmail']");
		  map.put("carwaleRegconfirmemailtextboxlocator", "//*[@id='ctlRegister_txtEmailConf']");
		  map.put("carwaleRegpassword", "//*[@id='ctlRegister_txtPassword']");
		  map.put("carwaleRegconfirmpassword", "//*[@id='ctlRegister_txtConfirmPassword']");
		  map.put("carwaleregbuttonlocator", "//*[@id='ctlRegister_btnRegister']");
		  map.put("carwalelogoutlocator", "//*[@id='login1_hrefLogin']");
		  map.put("carwaleloginlinklocator", "//*[@id='firstLogin']");
   //carwale
		  
		  map.put("carwaleforgotpassword", "//*[@id='forgotpass']");
		  map.put("carwaleforgotpasswordtextboxlocator", "//input[@id='txtForgotPass']");
		  map.put("carwaleforgotpasswordsendlocator", "//*[@id='frgPwd']");
		  
	//Amazon.in
		  
		  map.put("amazonsearchbox", "//input[@id='twotabsearchtextbox']");
		  map.put("amazonsearchbutton", "//*[@class='nav-search-submit nav-sprite']/input");
		  map.put("amazoniphone6srosecolor", "//h2[contains(text(),'Apple iPhone 6s (Rose Gold, 16GB)')]");
		  map.put("iphone6srosecolorprice", "//*[@id='priceblock_ourprice']");
		  
	//Amazon.com
		  map.put("stayonamazoncom", "//*[@id='redir-stay-at-www']");
		  map.put("amazoncomiphone6s", "(//h2[contains(text(),'Apple iPhone 6s ')])[1]");
		  map.put("amazoncomselectedbag", "(//h2)[2]");
		  map.put("amazoncomselecteditemaddtocart", "//*[@id='submit.add-to-cart-announce']/..");
		  map.put("amazonproceedtocheckout", "//*[@id='huc-v2-order-row-buttons']//*[@id='hlb-ptc-btn']/span[@class='a-button-inner']");
		  map.put("amazonsigninemailtextbox", "//*[@id='ap_email']");
		  map.put("amazonsigninpasswordtextbox","//*[@id='ap_password']");
		  map.put("amazonsiginbutton", "//*[@id='signInSubmit']/..");
		  map.put("amazonshippingaddress", "//*[@id='address-book-entry-2']/div[2]/span/a");
		  map.put("amazonshippingerrormeg", "//*[@class='alertMessage']");
		  
	//Yahoo.IN
		  map.put("yahoomail", "html/body/div[3]/div[4]/div[2]/div/div[1]/div[1]/div/div/ul[1]/li[1]/a");
		  map.put("yahoosignup", "html/body/div[1]/main/div/div[1]/div[1]/div[1]/div[2]/div[4]/div/a");
		  map.put("yahoosignuptext", "//h1");
		  map.put("yahoosearchbox", "//*[@id='UHSearchBox']");
		  map.put("yahoosearchbutton", "html/body/div[3]/div[2]/div[3]/table/tbody/tr/td[2]/form/table/tbody/tr/td[2]/input");
		  map.put("yahoomaillink", "(//h3/a/b/b)[2]");
		  map.put("flagdropdown", "html/body/div[3]/div[2]/div[2]/ul/div/a/i[2]");
		  map.put("selectusenglish", "html/body/div[3]/div[2]/div[2]/ul/div/div/div/div/div/div[3]/ul[2]/li[3]/a");
	//Yahoo.com
		  map.put("yahoomail", "html/body/div[4]/div/div[2]/div[2]/div[1]/div/div/div/ul/li[1]/a/span");
		  map.put("yahoocomsearchbox", "html/body/div[2]/div/div/div/div/div/div/div[2]/div/form/table/tbody/tr/td[1]/input[1]");
		  map.put("yahoocomsearchbutton", "html/body/div[2]/div/div/div/div/div/div/div[2]/div/form/table/tbody/tr/td[3]/button");
		  map.put("yahoocomdnthaveaccountmsg", "html/body/div[1]/main/div/div[1]/div[1]/div[1]/div[2]/div[4]/div/span");
	//Tatasky
		  map.put("rmntextbox", "//*[@id='rmn']");
		  map.put("tataskylogin", "//*[@class='but-bl P10']//*[@type='submit']");
		  map.put("subcriptionID", "(//*[@class='rboxtable']/tbody/tr)[1]/td[2]");
		  map.put("accountbalance", "html/body/form/div[3]/div[2]/div[3]/table/tbody/tr/td[2]");
		  map.put("rechargeduedate", "html/body/form/div[3]/div[2]/div[4]/table/tbody/tr/td[2]");
		  map.put("recommendedrecharge", "html/body/form/div[3]/div[2]/div[5]/table/tbody/tr/td[2]");
		  map.put("hometab", "//*[@id='nav']/a[1]");
		  map.put("a/cdetailstab", "//*[@id='nav']/a[2]");
		  map.put("rechargetab", "//*[@id='nav']/a[3]");
		  map.put("view/modifypackagestab", "//*[@id='nav']/a[4]");
		  map.put("mobileservicestab", "//*[@id='nav']/a[5]");
		  map.put("ordershowcasetab", "//*[@id='nav']/a[6]");
		  map.put("recordshowstab", "//*[@id='nav']/a[7]");
		  map.put("uploadreceipstab", "//*[@id='nav']/a[8]");
		  map.put("helpdesktab", "//*[@id='nav']/a[9]");
		  map.put("profilepasswordtextbox", "//*[@id='passwordMsg']/../td[2]/input");
		  map.put("submitbutton", "//*[@id='loginID']");
		  map.put("cancelbutton", "//*[@id='cancelID']");
		  map.put("forgetpasswordlink", "//*[@id='forgotpassword']");
		  map.put("basicpackpresent", "(//*[@class='statementFont'])[1]");
		  map.put("basicpacknamepresent", "//*[@class='packbox6']/h1");
		  map.put("basicpackprice", "//*[@class='pack-box-text2']/table[2]");
		  map.put("freepacks", "//*[@class='pack-box-text2']/table[4]");
		  map.put("hdprice", "//*[@class='pack-box-text2']/table[6]");
		  map.put("99packradiobutton", "//*[contains(text(),'Rs 99')]/../input");
		  map.put("99packchangepackbutton", "//h1[contains(text(),'99 Pack')]/../a//*[@class='imageStyle']");
		  map.put("proceedbutton", "//*[contains(text(),'PROCEED')]");
		  map.put("proceedtorecharge", "//*[contains(@class,'pro_recharge')]");
		  map.put("tataskyrechargeamounttextbox", "//*[@id='j_id3:Amount']");
		  map.put("tataskyrechargeamountgobutton", "//*[@id='j_id3:goButton']");
	//Avenger
		  map.put("avengerusernametextbox", "//div[@class='username']/input");
		  map.put("avengerpasswordtextbox", "//div[@class='password']/input");
		  map.put("avengerloginsubmitbutton", "//button[@type='submit']");
		  map.put("avengerhomepagesettingslinks", "//*[contains(@class,'cogwheel')]/..");
		  map.put("Avengeruserslink", "//*[contains(@class,'dropdown-toggle') and contains(text(),'Users')]");
		  map.put("avengeruserfromuserdropdown", "//div[@class='list-group']/a[contains(text(),'Users')]");
		  map.put("avengeradduserbutton", "//*[contains(text(),'Add User')]");
		  map.put("Avengeradduserfirstnametextbox", "//input[@ng-model='user.firstName']");
		  map.put("Avengeradduserlastnametextbox", "//input[@ng-model='user.lastName']");
		  map.put("Avengeradduseremailtextbox", "//input[@ng-model='user.email']");
		  map.put("Avengeradduserusernametextbox", "username");
		  map.put("Avengeradduserlanguagetextbox", "language");
		  map.put("Avengeradduserassignroleslocator", "//*[@ng-click='remove(role)']");
		  map.put("Avengeradduseraddrolessearchboxlocator", "//*[@class='available-items']/ancestor::*//*[contains(@ng-model,'availableFilterTxt') and contains(@placeholder,'Roles')]");
		  map.put("Avengeradduseravailableroleslocator", "//*[@ng-click='add(role)']");
		  map.put("Avengerusercreationsubmitbutton", "//*[contains(@class,'footer')]//*[@type='submit']");
		  map.put("Avengerusersearchbox", "//*[contains(@ng-submit,'searchUsers')]/input");
		  map.put("Avengerusersearchresult", "//*[contains(text(),'griduser300')]");
		  map.put("Avengeruserconformationbutton", "//*[@ng-click='getConfirmationToken()']");
		  map.put("Avengeruserconformationurl", "//*[@ng-click='getConfirmationToken()']");
		  map.put("Avengernewuserpasswordtextbox", "password");
		  map.put("Avengeruserconformationpasswordtextbox", "conformationpassword");
		  map.put("Avengersecurityquestiondropdown", "//select");
		  map.put("Avengernewusersecurityanswertextbox", "securtyAnswer");
		  map.put("Avengerpassconformationsubmitbutton", "//button[@ng-click='close()']");
		  map.put("Avengerlogoutbutton", "div#account .glyphicons.user");
		  map.put("Avengernewuseraftersearch","(//*[contains(text(),'griduser507')])[1]");
		return map;
		
	}
	
	
}
