/*package com.compugain.api;


import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.compugain.setup.TestBase;




public class UserCreationApiTest extends TestBase implements ConstantsValue,Setup{

	public static final String NoUserData="withOutUserName";
	public static final String validData="allmandatory";

	
	private WebDriver driver;

	private AvengerLoginPage loginPage;
	private AvengerHomePage homePage;
	private List<String> statusValue;
	private CustomReport customReport;
	private Reasons reasons;
	private String sTestcaseName;
	private ResourceBundle bundle;
	private Locale locale;
	private BeanFactory accountBeansFactory;
	private AvengerUserDashboardPage avengeruserdashboardpage;
	private AvengerAddUserPage avengeradduserpage;
	private AddUserBeanPage adduserbeanpage;
	private AvengerConfirmPasswordPage avengerconfirmpasswordpage;
	private CreatePasswordBeanPage createpasswordbeanpage;
	private BasePage basePage;
	private AvengerEditRootAccountPage editrootaccountpage;
	private UserCreationUtility userCreationUtility;
	
	private static Logger logger = Logger.getLogger(UserCreationApiTest.class);

	
	@BeforeClass(alwaysRun=true)
	public void beforeClass(ITestContext ctx) throws Exception {
		reasons= new Reasons("");
		statusValue=new ArrayList<String>();
		customReport = new CustomReport();
		accountBeansFactory=new BeanFactory();
		adduserbeanpage=new AddUserBeanPage();
		createpasswordbeanpage=new CreatePasswordBeanPage();
		locale = new Locale("en");
		basePage = new  BasePage();
		}

	@BeforeMethod(alwaysRun=true)
	@Parameters(value = {"sbrowser","sgrid" , "surl", "sUserName", "sPassword"})
	public void setUP(@Optional(SBROWSER)String sbrowser,@Optional(SVERSION) String sgrid, String sUserName,String sPassword) throws MalformedURLException 
	{
		logger.info("Version value is"+sgrid);
		driver = initializeDriver(sbrowser,sgrid, surl ,sversion,sPlatform );
		customReport.reset();
		logger.info("The driver value is "+driver);
		bundle=ResourceBundle.getBundle("ResourceBundle.BundleFile",locale);
		logger.info("value in bundle is"+bundle.getKeys());
		basePage= new BasePage(driver,customReport, new BasePage());
		loginPage = basePage.avengerLoginPage(driver,customReport, basePage);
		driver.manage().window().maximize();
		accountBeansFactory.CreatePasswordBean(createpasswordbeanpage);
		accountBeansFactory.AddUserBean(adduserbeanpage);
		launchURL(baseUrl,driver);
	}
	
	public JSONObject createUserJSON(CreateUserDetails createUserDetails) {

		JSONObject userDetailsJson = new JSONObject();
//		userDetailsJson.put("PhoneNumber", createUserDetails.getPhoneNumber());
		userDetailsJson.put("email", createUserDetails.getEmail());
		userDetailsJson.put("firstName", createUserDetails.getFirstName());

		userDetailsJson.put("language", createUserDetails.getLanguage());

		userDetailsJson.put("lastName", createUserDetails.getLastName());

//		userDetailsJson.put("title", createUserDetails.getTitle());

		userDetailsJson.put("username", createUserDetails.getUsername());
		
		JSONArray myArray = new JSONArray();
		myArray.add(createUserDetails.getRoleId());
		userDetailsJson.put("roleIds", myArray);

		System.out.println("JOSN is " + userDetailsJson);

		return userDetailsJson;
	}

	
	
	@Test(description="To create Account Admin user")
	public void TC_01_POST_Create_Account_Admin_User_Postive(){
		
		homePage = loginPage.loginAs(USERNAME,PASSWORD);
		homePage.clickSettingsLink();
		
		//Creating Object to UserCreateApi
		
		UserCreateApi userCreateApi=new UserCreateApi();
		//Calling Authentication API
		String authenToken =userCreateApi.doAuthorization();
		//Calling User Login API
		String acessToken=userCreateApi.doUserLoginApi(authenToken);
		//Calling  Get Role Id API
		//Calling Creating User APi
		CreateUserDetails createUserDetails = new CreateUserDetails();
		ArrayList<String> roleID = userCreateApi.userRolesApi(acessToken,accountAdmin);
		
		for (int i = 31; i <40; i++) {
			avengeruserdashboardpage=homePage.clickUsersLink();
			createUserDetails.setEmail("griduser"+i+"@test.com");
			createUserDetails.setFirstName("griduser"+i);
			adduserbeanpage.setFirstname("griduser"+i);
			
			adduserbeanpage.setLastname("griduser"+i);
			createUserDetails.setLastName("griduser"+i);
			
			adduserbeanpage.setUsername("griduser"+i);
			createUserDetails.setUsername("griduser"+i);
			createUserDetails.setRoleId(roleID.get(1));
			
			
		userCreateApi.createUserAPI(roleID,validData,createUserDetails,createUserJSON(createUserDetails));
		System.out.println("First Name:"+createUserDetails.getFirstName());
		System.out.println("Last Name:"+createUserDetails.getLastName());
		System.out.println("Email :"+createUserDetails.getEmail());
		System.out.println("Phone Number:"+createUserDetails.getPhoneNumber());
		System.out.println("Title:"+createUserDetails.getTitle());
		System.out.println("Username:"+createUserDetails.getUsername());
		System.out.println("Role ID:"+createUserDetails.getRoleId());
		
		//Validation details using Selenium 
		editrootaccountpage=avengeruserdashboardpage.clicknewuser_link(adduserbeanpage);
		avengerconfirmpasswordpage=editrootaccountpage.click_UserConfirmationURL();
		createpasswordbeanpage.setPassword(SANITYPASSWORD);
		createpasswordbeanpage.setConfirmpassword(SANITYPASSWORD);
		createpasswordbeanpage.setSecurityquestion("What was your first car?");
		createpasswordbeanpage.setTypeyouranswer("BMW");
		loginPage= avengerconfirmpasswordpage.passwordCreation(createpasswordbeanpage);
		homePage.clickSettingsLink();
		}
		
		//Assert.assertEquals(true, avengeruserdashboardpage.verifyUserCreated(createUserDetails.username,createUserDetails.firstName,createUserDetails.lastName));

		
		
		
	}
	
	@Test(description="To create Media Admin user")
	public void TC_02_POST_Create_Media_Admin_User_Postive(){
		
		//Creating Object to UserCreateApi
		
		UserCreateApi userCreateApi=new UserCreateApi();
		//Calling Authentication API
		String authenToken =userCreateApi.doAuthorization();
		//Calling User Login API
		String acessToken=userCreateApi.doUserLoginApi(authenToken);
		//Calling  Get Role Id API
		ArrayList<String> roleID = userCreateApi.userRolesApi(acessToken,ConstantsValue.mediaAdmin);
		//Calling Creating User APi
		userCreateApi.createUserAPI(roleID,validData);
		
		//Validation details using Selenium 
		
		
	}
	
	@Test(description="To create Media Viewer user")
	public void TC_03_POST_Create_Media_Viewer_User_Postive(){
		
		//Creating Object to UserCreateApi
		
		UserCreateApi userCreateApi=new UserCreateApi();
		//Calling Authentication API
		String authenToken =userCreateApi.doAuthorization();
		//Calling User Login API
		String acessToken=userCreateApi.doUserLoginApi(authenToken);
		//Calling  Get Role Id API
		ArrayList<String> roleID = userCreateApi.userRolesApi(acessToken,ConstantsValue.mediaViewer);
		//Calling Creating User APi
		userCreateApi.createUserAPI(roleID,validData);
		
		//Validation details using Selenium 
		
		
	}
	
	@Test(description="To create Event Admin user")
	public void TC_04_POST_Create_Event_Event_Admin_Postive(){
		
		//Creating Object to UserCreateApi
		
		UserCreateApi userCreateApi=new UserCreateApi();
		//Calling Authentication API
		String authenToken =userCreateApi.doAuthorization();
		//Calling User Login API
		String acessToken=userCreateApi.doUserLoginApi(authenToken);
		//Calling  Get Role Id API
		ArrayList<String> roleID = userCreateApi.userRolesApi(acessToken,ConstantsValue.mediaAdmin);
		//Calling Creating User APi
		userCreateApi.createUserAPI(roleID,validData);
		
		//Validation details using Selenium 
		
		
	}
	@Test(description="To create Media Contributor user")
	public void TC_05_POST_Create_Media_Contributor_User_Postive(){
		
		//Creating Object to UserCreateApi
		
		UserCreateApi userCreateApi=new UserCreateApi();
		//Calling Authentication API
		String authenToken =userCreateApi.doAuthorization();
		//Calling User Login API
		String acessToken=userCreateApi.doUserLoginApi(authenToken);
		//Calling  Get Role Id API
		ArrayList<String> roleID = userCreateApi.userRolesApi(acessToken,ConstantsValue.mediaContributor);
		//Calling Creating User APi
		userCreateApi.createUserAPI(roleID,validData);
		
		//Validation details using Selenium 
		
		
	}
	
	@Test(description="To Create user withmissing Mandatory filed UserName filed  ...")
	public void TC_06_POST_CreateUser_with_Blank_UserName_Negative(){
	
	   //Creating Object to UserCreateApi
		UserCreateApi userCreateApi=new UserCreateApi();
		//Calling Authentication API
		String authenToken =userCreateApi.doAuthorization();
		//Calling User Login API
		String acessToken=userCreateApi.doUserLoginApi(authenToken);
		//Calling  Get Role Id API
		ArrayList<String> roleID = userCreateApi.userRolesApi(acessToken,ConstantsValue.mediaContributor);
		//Calling Creating User APi
		HashMap<String,String> responseData=userCreateApi.createUserAPI(roleID,NoUserData);
		
	     Assert.assertEquals(ConstantsValue.errorcode, responseData.get("code"));
	     Assert.assertEquals(ConstantsValue.detailError, responseData.get("detail"));
	}

 
		
		
	}
	
	
	
 */