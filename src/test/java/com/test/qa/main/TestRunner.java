package com.test.qa.main;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
	    plugin = { 
	        "html:target/cucumber/cucumber.html",
	        "json:target/cucumber.json","summary",
	        "me.jvt.cucumber.report.PrettyReports:target/cucumber/",
	    },
	    glue = {"com.test.qa.appHooks", "stepDefinition"},
	    features = {"src/test/resources/Features"},
	    dryRun = false,
	    tags = "@All"
	)
public class TestRunner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = false) //set to false as Website is taking too much time to load/render if executed in parallel
	public Object[][] scenarios() {
		return super.scenarios();
	}
}