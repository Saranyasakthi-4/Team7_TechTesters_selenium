package com.LMS.Runner;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.LMS.stepdefenition"},    
        plugin = {"pretty","html:target/HtmlReport/report.html",
        		"json:target/JSONReport/report.json",
        		"junit:target/JUnitReport/report.xml",
        		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
        		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = "@tagLoginPage or @tagMultipleDeleteProgram",
        
        monochrome=false
		
		)


public class TestRunner {
	
	@Test
	public void runTest() {
		
	}

}