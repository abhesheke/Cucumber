package com.compugain.test;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.compugain.Utils.CustomReport;
import com.compugain.Utils.EmailUtility;
import com.compugain.Utils.ReadAndWriteToJSON;
import com.compugain.Utils.WebElements;
import com.compugain.api.CreateUserDetails;
import com.compugain.api.UserCreateApi;
import com.compugain.beanfactory.BeanFactory;
import com.compugain.beanfactory.PropertiesFactory;
import com.compugain.setup.TestBase;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepDef extends TestBase  {

	private WebDriver driver = null;

	private WebDriverWait driverWait;
	// Properties object = null;

	String emailvalue;

	private static Logger logger = Logger.getLogger(StepDef.class);

	private Map<String, String> userdetailsmap ;
	public Map<String, String> PropertiesMap;
	private BeanFactory beanfactory = new BeanFactory();
	private PropertiesFactory propertiesfactory;
	private EmailUtility emailutil;
	private WebElements webelements;
	private ReadAndWriteToJSON readdatajson;
	private UserCreateApi userCreationApi;
	public static final String validData="allmandatory";
	private CustomReport customreport = new CustomReport();
	private List<String> statusValue;
	private String sTestcaseName;
	int i=1;

	private Scenario scenario;
	
	@Before
	 public void setUp(Scenario scenario) {
        System.out.println("@@@@@#########::::::::::::"+scenario.getName());

    }

	/*public void before(Scenario scenario) {
	    this.scenario = scenario;
	    scenario.getName();
	    //scenario.getSourceTagNames();
	    //scenario.getStatus();
	    logger.info("The Scenario names are::::::"+scenario.getName());
	    System.out.println("The Scenario names are::::::"+scenario.getName());
	   // System.out.println("The Tag names are::::::"+ scenario.getSourceTagNames());
	    //System.out.println("The Scenario status are::::::"+ scenario.getStatus());
	}*/
	
	public void setUP() {
		if(i==1)
		beanfactory = new BeanFactory();
		propertiesfactory = new PropertiesFactory();
		userdetailsmap = beanfactory.getUserDetails(); // testdata
		PropertiesMap = propertiesfactory.getObjectProperties(); // locators
		emailvalue = beanfactory.emailRandomValuesGeneration();
		readdatajson=new ReadAndWriteToJSON();
		userCreationApi = new UserCreateApi();
		long threadId = Thread.currentThread().getId();
		String processName = ManagementFactory.getRuntimeMXBean().getName();
		System.out.println("Started in thread: " + threadId + ", in JVM: " + processName);
		statusValue = new ArrayList<String>();
		
	}

	@Given("^I go to \"([^\"]*)\" on \"([^\"]*)\"$")
	public void I_go_to(String url, String Browser) {
		driver = openBrowser(Browser);
		driverWait = new WebDriverWait(driver, 10);
		emailutil = new EmailUtility(driver, driverWait);
		webelements = new WebElements(driver, driverWait);
		//System.out.println("I am going to " + url + " on " + Browser);
		logger.info("The driver value is " + Browser);
		logger.info("I am going to " + url + " on " + Browser);
		//logger.info("The url value is " + url);
		// webelements.openBrowser(sBROWSER);
		webelements.navigateBrowser(url);
	}

	//static LinkedHashMap<String, ArrayList<String>> featurefilename=new LinkedHashMap<>();
	
	public static ArrayList<String> featurelist=new ArrayList<String>();
	@And("^I get Feature Name is \"([^\"]*)\"$")
	public ArrayList<String> I_get_Feature_Name(String FeatureName) {
		featurelist.add(FeatureName);
		//System.out.println("FeatureNameLIST ::::::: "+featurelist);
		//logger.info("FeatureNameLIST ::::::: "+featurelist);
		return featurelist;
	} 
	
	public static ArrayList<String> scenariosList=new ArrayList<String>();
	@And("^I get Scenario Name is \"([^\"]*)\"$")
	public ArrayList<String> I_get_Scenario_Name(String ScenarioName) {
		//logger.info("ScenarioName ::::::: "+ScenarioName);
		//System.out.println("ScenarioName ::::::: "+ScenarioName);
		scenariosList.add(ScenarioName);
		//logger.info("ScenarioName LIST ::::::: "+scenariosList);
		//System.out.println("ScenarioName LIST ::::::: "+scenariosList);
	return scenariosList;
	} 
	
	/*static LinkedHashMap<ArrayList<String>, ArrayList<String>> featurescenarionames;
	public LinkedHashMap<ArrayList<String>, ArrayList<String>> getScenarioName_FeatureName(String FeatureName, String ScenarioName){
		featurescenarionames.put(featurelist, scenariosList);
	return featurescenarionames;
	}*/
	
	
	
	@And("^I enter text into \"([^\"]*)\" as \"([^\"]*)\"$")
	public void I_enter_text_into(String objectprop, String text) throws Exception {
		//logger.info("Webelemt" + webelements);
		//logger.info("driverWait" + driverWait);
		logger.info("userdetailsmap.get(text)" + userdetailsmap.get(text));
		logger.info("webelements.getpageTitle()" + webelements.getpageTitle());
		//String valuefrombean=beanfactory.getdata(text);
		/*logger.info("@@@@0-prop------"+PropertiesMap.get(objectprop));
		logger.info("@@@@0-driverWait------"+driverWait);*/
    	/*logger.info("@@@@0-userdetailsmap.get(text).toString()------"+userdetailsmap.get(text).toString());
*/
		Thread.sleep(5000);
		webelements.enterText(PropertiesMap.get(objectprop), driverWait, userdetailsmap.get(text).toString());
	}

	@And("^I create user \"([^\"]*)\"$")

	public void I_Create_users(String users) {
		webelements.creatingusers(users);
	}

	@And("^I click on \"([^\"]*)\"$")
	public void I_click_on(String objectprop) {
		logger.info("clicking on" + objectprop);
		System.out.println("clicking on" + objectprop);
		webelements.click(propertiesfactory.getObjectProperties().get(objectprop));
	}
	
	@And("^I clicked \"([^\"]*)\"$")
			public void I_clicked(String objectprop) {
		webelements.clickUsingSwitch(propertiesfactory.getObjectProperties().get(objectprop), driverWait);
			}
			
	@And("^I want to switch window on \"([^\"]*)\"$")
	public void I_want_to_switch_window_on(String objectprop){
		webelements.shiftnewindow();
		System.out.println("I have switched to child window");
		logger.info("I have switched to child window");
	}
	
	@And("^I get text for \"([^\"]*)\"$")
		public void I_get_text_for(String objectprop) throws Exception {
		System.out.println("Object displayed on screen" + objectprop);
		logger.info("Object displayed on screen" + objectprop);
		//PropertiesMap = propertiesfactory.getObjectProperties();
		//String stext=webelements.getTextfromscreen(PropertiesMap.get(objectprop));
		Thread.sleep(5000);
		PropertiesMap.put(objectprop, webelements.getTextfromscreen(PropertiesMap.get(objectprop)));
		//System.out.println("IS DISPLAYED----------"+PropertiesMap.get(objectprop));
		}
	
	// Amazon Application Specific
	@And("^I select Amazoncom \"([^\"]*)\"$")
	public void I_select_Amazoncom(String objectprop){
		if (webelements.isDisplayedWithoutException(propertiesfactory.getObjectProperties().get(objectprop))) {
			webelements.click( propertiesfactory.getObjectProperties().get(objectprop));
			System.out.println("clicking on" + objectprop);
			logger.info("clicking on" + objectprop);
		}
		else {
			System.out.println("POP up is not visible on the page");
			logger.info("POP up is not visible on the page");
		}
		
	}
	
	// Avenger Application Specific API
	static ArrayList<String> roleID;
	static HashMap<String ,String> responsedata;
	
	@And ("I create user from api \"([^\"]*)\"$")
	public void I_create_user_from_api(String userrole){
		System.out.println("I am in user creation API"+userrole);
		String authenToken =userCreationApi.doAuthorization();
		String acessToken=userCreationApi.doUserLoginApi(authenToken);
		CreateUserDetails createUserDetails = new CreateUserDetails();
		System.out.println("The role is"+userdetailsmap.get(userrole));
		roleID = userCreationApi.userRolesApi(acessToken,userdetailsmap.get(userrole));
		responsedata=userCreationApi.createUserAPI(roleID, validData, createUserDetails, createUserJSON(roleID.get(1)));
	}
	
	
	@And("I delete user from api \"([^\"]*)\"$")
	public void I_delete_user_from_api(ArrayList<String> acTokenAndUserId){
		logger.info("I am in Delete user from API method");
		logger.info("The response data map is"+responsedata);
		System.out.println("I am in Delete user from API method");
		System.out.println("The response data map is"+responsedata);
		userCreationApi.deleteUserApi(responsedata);
		
	}
	
	
	@And("I click enter on \"([^\"]*)\"$")
	public void I_click_enter_on(String objectprop){
		webelements.clickEnter(propertiesfactory.getObjectProperties().get(objectprop), driverWait);
	}
	
	@Then("^I Verify element displayed on Screen \"([^\"]*)\" is \"([^\"]*)\"$")
	public void I_Verify_element_displayed_on_Screen(String expected,String objectprop) throws InterruptedException{
		logger.info("clicking on" + objectprop);
		System.out.println("clicking on" + objectprop);
		PropertiesMap = propertiesfactory.getObjectProperties();
		/*System.out.println("The expected value sent is"+expected);
		System.out.println("object property is"+objectprop);
		System.out.println("Actual value"+webelements.isDisplayedWithoutException(PropertiesMap.get(objectprop)));*/
		//Assert.assertTrue(webelements.isDisplayedWithoutException(objectprop) == Boolean.getBoolean(expected));
		Thread.sleep(5000);
		Assert.assertEquals(expected,String.valueOf(webelements.isDisplayedWithoutException(PropertiesMap.get(objectprop))));
	}
	
	
	@Then("^Expected and Actual \"([^\"]*)\" as \"([^\"]*)\"$")
	public void Expected_And_Actual (String expectedResult, String ActualResult) {
		logger.info("Expected" + expectedResult);
		logger.info("Actual" + PropertiesMap.get(ActualResult));
		System.out.println("Expected" + expectedResult);
		System.out.println("Actual" + PropertiesMap.get(ActualResult));
		Assert.assertEquals(true,expectedResult.contains(PropertiesMap.get(ActualResult)));
		/*
		 * boolean result = webelements.isDisplayed(webElement) String
		 * actualResult = null;
		 * 
		 * if(result) actualResult="success"; else actualResult="failure";
		 * Assert.assertEquals(expectedResult, actualResult);
		 */
	}
	
	@Then("^Expected and Actual Is \"([^\"]*)\" as \"([^\"]*)\"$")
	public void Expected_And_Actual_Is (String expectedResult, String ActualResult) {
		logger.info("Expected" + ActualResult);
		logger.info("Actual" + PropertiesMap.get(ActualResult));
		System.out.println("Expected" + ActualResult);
		System.out.println("Actual" + PropertiesMap.get(ActualResult));
		Assert.assertEquals(expectedResult,ActualResult);
		/*
		 * boolean result = webelements.isDisplayed(webElement) String
		 * actualResult = null;
		 * 
		 * if(result) actualResult="success"; else actualResult="failure";
		 * Assert.assertEquals(expectedResult, actualResult);
		 */
	}

	@Then("^Expected and Actual \"([^\"]*)\" as \"([^\"]*)\" as \"([^\"]*)\"$"  )
	public void Expected_Actual(String expectedResult, String Actual, String i) {
		System.out.println("Expected" + expectedResult);
		System.out.println("Actual" + expectedResult);
		logger.info("Expected" + expectedResult);
		logger.info("Actual" + expectedResult);
		switch (Integer.parseInt(i)) {
		case INTEGER:
				Assert.assertEquals(Integer.valueOf(expectedResult), Integer.valueOf(Actual));
			break;
		case STRING:
			Assert.assertEquals(String.valueOf(expectedResult), String.valueOf(Actual));
			break;
		case DOUBLE:
			Assert.assertEquals(Double.valueOf(expectedResult),Double.valueOf(Actual));
			break;
		case FLOAT:
			Assert.assertEquals(Float.valueOf(expectedResult),Float.valueOf(Actual));
			break;
			
		default:
			
			break;
			}
		}
	
	@Then("^Expected and ActualAssertion \"([^\"]*)\" as \"([^\"]*)\"$")
	public void ExpectedActual_Assertion(String expectedResult, String Actual) {
		logger.info("Expected" + expectedResult);
		logger.info("Actual" + expectedResult);
		logger.info("###############"+PropertiesMap.get(expectedResult));
		System.out.println("Expected" + expectedResult);
		System.out.println("Actual" + expectedResult);
		System.out.println("###############"+PropertiesMap.get(expectedResult));
		Assert.assertEquals(expectedResult,Actual);
		customreport.customizedReport(PropertiesMap.get(expectedResult), Actual, statusValue, driver, sTestcaseName);
	}
	
	@Then("^I Verify CheckingList \"([^\"]*)\"$")
	public void I_Verify_CheckingList(String statusvalue) {
		System.out.println("I am in Checking list");
		logger.info("I am in Checking list");
		customreport.checkinglist(statusValue);
	}
	
	
	//Avenger Application Specific
	public JSONObject createUserJSON(String roleid) {
		JSONObject userDetailsJson = new JSONObject();
		userDetailsJson.put("email", userdetailsmap.get("avengerusercreationemail"));
		userDetailsJson.put("firstName", userdetailsmap.get("avengerusercreationfirstname"));
		userDetailsJson.put("language", userdetailsmap.get("avengeruserlanguage"));
		userDetailsJson.put("lastName",userdetailsmap.get("avengerusercreationlastname"));
		userDetailsJson.put("username", userdetailsmap.get("avengeruserusername"));
		JSONArray myArray = new JSONArray();
		myArray.add(roleid);
		userDetailsJson.put("roleIds", myArray);
		logger.info("JOSN is " + userDetailsJson);
		System.out.println("JOSN is " + userDetailsJson);
		return userDetailsJson;
	}

	 
	@After
	/*public void before(Scenario scenario) {
	    this.scenario = scenario;
	    scenario.getName();
	    //scenario.getSourceTagNames();
	    scenario.getStatus();
	    System.out.println("The Scenario names are::::::"+scenario.getName());
	   // System.out.println("The Tag names are::::::"+ scenario.getSourceTagNames());
	    System.out.println("The Scenario status are::::::"+ scenario.getStatus());
	}
	*/
	public void embedScreenshot(Scenario scenario) {
		 this.scenario = scenario;
		 scenario.getStatus();
		 logger.info("The Scenario status are::::::"+ scenario.getStatus());
		 System.out.println("The Scenario status are::::::"+ scenario.getStatus());
		if(scenario.isFailed()) {
		try {
		scenario.write("Current Page URL is " + driver.getCurrentUrl());
		byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		
		scenario.embed(screenshot, "image/png");
		} 
		catch (WebDriverException somePlatformsDontSupportScreenshots) {
		System.err.println(somePlatformsDontSupportScreenshots.getMessage());
		} 
		}
		webelements.browserQuit();
	}
}
