package com.test.qa.appHooks;
import java.net.MalformedURLException;
//imports
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.test.qa.factory.DriverFactory;
import com.test.qa.pages.HomePage;
import com.test.qa.pages.LoginPage;
import com.test.qa.util.ConfigReader;
import com.test.qa.util.UtilClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks {
	private DriverFactory driverFactory = new DriverFactory();
	private WebDriver driver;
	private ConfigReader configReader;
	public Properties prop;
	HomePage homePage;
	LoginPage loginPage;
	public static ThreadLocal<Scenario> scenario = new ThreadLocal<>();
	Logger log = LogManager.getLogger(Hooks.class);
	String scenarioName = "";
	String browserName = System.getProperty("browser", "chrome");
	String mode = System.getProperty("mode", "normal");
    String remoteURL = "http://192.168.1.208:4444/wd/hub";
	public Hooks() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}

	public static Scenario getScenario() {
		return scenario.get();
	}

	/**
	 * @param scenario
	 */
	@Before(order = 0)
	public void getProperty(Scenario scenario) {
		Hooks.scenario.set(scenario);
		log.info("****LAUNCH BROWSER****");
		log.info("------------------------------------------------------------");
		log.info("" + Hooks.getScenario().getName());
		log.info("------------------------------------------------------------");
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}// end of getProperty function

	@Before(order = 1)
	public void initBrowser(Scenario scenario) throws MalformedURLException {
		driverFactory = new DriverFactory();
		
			driver = driverFactory.init_driver(browserName,mode);
			try {
				if (driver != null) {
					driverFactory.getDriver().get(prop.getProperty("URL_Master"));
					UtilClass elementUtil = new UtilClass(driver);
					elementUtil.addScreenShotToReport("URLLoaded");
				}
			} catch (Exception e) {
				System.out.println("Please check the browser information provided in the command prompt.");
				e.printStackTrace();
			}
	}

	@After
	public void quitBrowser(Scenario scenario) {
		if (scenario.isFailed()) {
			Hooks.getScenario().log("There are failures in the test.");
			driver.quit();
		}else {
			driver.quit();
		}
	}
}
