package com.compugain.test;

import org.junit.runner.RunWith;

import com.compugain.setup.Setup;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


	@RunWith(Cucumber.class)
	@CucumberOptions(format = {"html:target/cucumber-html"},features={Setup.sCGTTMANAGETIMESHEET})
	public class ReRunFailedCases implements Setup {
	
}
