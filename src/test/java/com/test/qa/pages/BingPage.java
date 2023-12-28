package com.test.qa.pages;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.test.qa.appHooks.Hooks;
import com.test.qa.factory.DriverFactory;
import com.test.qa.util.UtilClass;
import com.test.qa.util.ExcelReadUtils;
import com.test.qa.util.LogUtility;

import io.cucumber.java.Scenario;

public class BingPage {
	private DriverFactory driverFactory = new DriverFactory();
	WebDriver driver = driverFactory.getDriver();
	UtilClass elementUtil ;
	public static Properties prop;
	List<Map<String, String>> testData;
	LogUtility logger = new LogUtility();
	ExcelReadUtils fileReader;
	Hooks hooks = new Hooks();
	public Scenario scenario;
	SoftAssertions softAssertions = new SoftAssertions();

	// LoginPage Constructor
	public BingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtil = new UtilClass(driver);
		fileReader = new ExcelReadUtils(driver);
	}// end

	public void SearchSong() {
		
		for(int i =1; i <=1; i++) {
			Hooks.getScenario().log("######################################################### For record id "+i+" #########################################################");
			elementUtil.navigateTo("https://bing.com");
			Hooks.getScenario().log("Navigated to "+elementUtil.getPageTitle());
			Hooks.getScenario().log("[FAIL]: TITLE IS INCORRECT");
			logger.log().info("Checking Logs...............................");
			softAssertions.assertThat("TITLE IS INCORRECT ").isEqualTo("but TITLE SHOULD CORRECT");
			elementUtil.addScreenShotToReport("BingSite");
			elementUtil.navigateTo("https://wwe.com");
			Hooks.getScenario().log("[FAIL]: TITLE IS INCORRECT");
			logger.log().info("Checking Logs...............................");
			softAssertions.assertThat("failing ").isEqualTo("but shoild not fail");
			Hooks.getScenario().log("Navigated to "+elementUtil.getPageTitle());
			elementUtil.addScreenShotToReport("WWECOM");
			logger.log().info("Checking Logs...............................");
			elementUtil.navigateTo("https://www.youtube.com/");
			Hooks.getScenario().log("[SUCCESS]: TITLE IS CORRECT");
			logger.log().info("Checking Logs...............................");
			Hooks.getScenario().log("Navigated to "+elementUtil.getPageTitle());
			elementUtil.addScreenShotToReport("YOUTUBE");
			logger.log().info("Checking Logs...............................");
		}
		logger.log().info("Checking Logs...Done........................");
		softAssertions.assertAll();
	}
}
