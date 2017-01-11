package com.compugain.test;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.compugain.Utils.CustomReport;
import com.compugain.Utils.ReadAndWriteToJSON;
import com.compugain.Utils.WebElements;
import com.compugain.api.UserCreateApi;
import com.compugain.beanfactory.BeanFactory;
import com.compugain.beanfactory.PropertiesFactory;
import com.compugain.config.objectProperties;
import com.compugain.setup.TestBase;

import cucumber.api.Scenario;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gherkin.formatter.model.Feature;


public class RightStartStefDef extends TestBase{

	private BeanFactory beanfactory;
	private PropertiesFactory propertiesfactory;
	private Map<String,By> rightstartproperties;
	private WebDriverWait driverWait;
	private WebElements webelements;
	private Map<String, String> userdetailsmap ;
	private WebDriver driver=null;
	private Scenario scenario;
	private Feature feature;
	public static List<String> scenariolist=new ArrayList<String>();
	public static List<String> featurelist=new ArrayList<String>();
	private CustomReport customreport=new CustomReport();
	
	@Before
	public void setUP(Scenario scenario) {
		
		this.scenario=scenario;
		beanfactory = new BeanFactory();
		userdetailsmap=beanfactory.getrightstartdata();
		propertiesfactory = new PropertiesFactory();
		rightstartproperties=propertiesfactory.getRightStartProeprties();
		//PropertiesMap=new HashMap<String, String>();
		long threadId = Thread.currentThread().getId();
		String processName = ManagementFactory.getRuntimeMXBean().getName();
		System.out.println("Started in thread: " + threadId + ", in JVM: " + processName);	
	}
	
	@Given("^I Goto \"([^\"]*)\" on \"([^\"]*)\"$")
	public void I_goto(String url, String Browser) {
		driver = openBrowser(Browser);
		driverWait = new WebDriverWait(driver, 10);	
		webelements = new WebElements(driver, driverWait);
		webelements.navigateBrowser(url);
	}
	@And("^I enterdata into \"([^\"]*)\" as \"([^\"]*)\"$")
	public void I_enter_text_into(String objectprop, String text) throws Exception {
		webelements.enterText(rightstartproperties.get(objectprop), driverWait, userdetailsmap.get(text));
	}
	@And("^I Click On \"([^\"]*)\"$")
	public void I_click_on(String objectprop){
		webelements.click(rightstartproperties.get(objectprop));
	}
	
	@And("^I select \"([^\"]*)\" value as \"([^\"]*)\"$")
	public void I_select(String objectprop,String option){
		webelements.selectValuefromDropDown(rightstartproperties.get(objectprop), driverWait, userdetailsmap.get(option));
	}
	
	@And("^I Get Value from \"([^\"]*)\" as \"([^\"]*)\"$")
	public void I_getvalue(String objectprop,String option){
		String value=webelements.getAttribute(rightstartproperties.get(objectprop), option,driverWait);
		System.out.println("Get Attribute Value as :::::: "+value);
	}
	@And("^I Clear Data from \"([^\"]*)\"$")
	public void I_ClearData(String objectprop){
		webelements.clearWebElementText(rightstartproperties.get(objectprop), driverWait);
	}
	
	@Then("I Close Browser")
	public void quiteBrowser(){
		webelements.browserQuit();
	}
	
	@Then("^I Get Scenario Name")
	public void getScenarioname(){
		//System.out.println(" ::::::: "+feature.getName());
		System.out.println(" ::::::: "+scenario.getName());
		scenariolist.add(scenario.getName());
	//	featurelist.add(feature.getName());
		customreport.checkinglist(scenariolist);
	}
	@Then("^I Get Feature Name \"([^\"]*)\"$")
	public void I_get_Feature_Name(String FeatureName) {
		featurelist.add(FeatureName);
	
	} 
	@After
	public void after(){
		System.out.println("scenariolist :::::: "+scenariolist+" ::::: feature list "+featurelist);
		
	}
}
