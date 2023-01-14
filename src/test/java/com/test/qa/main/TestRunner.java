package com.test.qa.main;

//imports

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/resources/Features/setupFeatures"},
		monochrome=true,
		dryRun=false,
		glue= {"com.test.qa.appHooks","stepDefinition"},
		tags= "@Google",
		plugin =  {"json:target/cucumber.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}

		/**
		 * 
		 * @author admin
		 *"json:target/cucumber.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		 */
		)

public class TestRunner {

//		public static void main(String[] args) {
//		    System.out.println("in main method");
////		    PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/main/resources/log4j.properties");
////		    BasicConfigurator.configure();
//		    CreateCucumberOptions cucumberOptions = new CreateCucumberOptions();
//		    ExtentReportGenerator reportGenerator=new ExtentReportGenerator();
//		    JUnitCore junitRunner = new JUnitCore();
//			cucumberOptions.loadPropertiesFile();
//			cucumberOptions.setOptions();
//		    System.out.println(TestRunner.class.getName()); 
//		    junitRunner.run(TestRunner.class);
//		    reportGenerator.generateReport();
//		    System.out.println("end");
//		    System.exit(0);
//		  }//end of main
	
}
