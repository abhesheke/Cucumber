package com.compugain.test;
import org.junit.runner.RunWith;

import com.compugain.setup.Setup;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)

@CucumberOptions(strict = false,features = {Setup.sAMAZONCOMBAGSEARCH},  format = { "pretty","html:target/site/cucumber-pretty","html:target/cucumber-html-report", "json:target/cucumber.json" }, monochrome = false)
//@CucumberOptions(strict = false,features={Setup.sTATASKY},  format = { "pretty","html:target/site/cucumber-pretty","html:target/cucumber-html-report", "json:target/cucumber.json" }, monochrome = false)
public class UI extends AbstractTestNGCucumberTests {
}
        