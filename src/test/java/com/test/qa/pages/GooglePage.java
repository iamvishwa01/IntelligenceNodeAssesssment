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

public class GooglePage {
	private DriverFactory driverFactory = new DriverFactory();
	private WebDriver driver = driverFactory.getDriver();
	UtilClass elementUtil = new UtilClass(driver);
	public static Properties prop;
	List<Map<String, String>> testData;
	LogUtility logger = new LogUtility();
	ExcelReadUtils fileReader = new ExcelReadUtils(driver);
	Hooks hooks = new Hooks();
	public Scenario scenario;
	SoftAssertions softAssertions = new SoftAssertions();
	public GooglePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}// end

	public void SearchSong() {
		elementUtil.navigateTo("https://bing.com");
		Hooks.getScenario().log("Navigated to "+elementUtil.getPageTitle());
		Hooks.getScenario().log("Navigated to "+elementUtil.getPageTitle());
		Hooks.getScenario().log("Navigated to "+elementUtil.getPageTitle());
		Hooks.getScenario().log("Navigated to "+elementUtil.getPageTitle());
		Hooks.getScenario().log("Navigated to "+elementUtil.getPageTitle());
		Hooks.getScenario().log("Navigated to "+elementUtil.getPageTitle());
		Hooks.getScenario().log("Navigated to "+elementUtil.getPageTitle());
		Hooks.getScenario().log("Navigated to "+elementUtil.getPageTitle());
		Hooks.getScenario().log("Navigated to "+elementUtil.getPageTitle());
		Hooks.getScenario().log("Navigated to "+elementUtil.getPageTitle());
		elementUtil.navigateTo("https://wwe.com");
//		softAssertions.assertThat("failing ").isEqualTo("but shoild not fail");
		Hooks.getScenario().log("Navigated to "+elementUtil.getPageTitle());
		Hooks.getScenario().log("Navigated to "+elementUtil.getPageTitle());
		Hooks.getScenario().log("Navigated to "+elementUtil.getPageTitle());
		Hooks.getScenario().log("Navigated to "+elementUtil.getPageTitle());
		Hooks.getScenario().log("Navigated to "+elementUtil.getPageTitle());
		Hooks.getScenario().log("Navigated to "+elementUtil.getPageTitle());
		elementUtil.navigateTo("https://www.youtube.com/");
//		softAssertions.assertThat("failing333333333333333333 ").isEqualTo("but shoild not fail333333333333333333333");
		Hooks.getScenario().log("Navigated to "+elementUtil.getPageTitle());
		Hooks.getScenario().log("Navigated to "+elementUtil.getPageTitle());
		Hooks.getScenario().log("Navigated to "+elementUtil.getPageTitle());
		Hooks.getScenario().log("Navigated to "+elementUtil.getPageTitle());
		Hooks.getScenario().log("Navigated to "+elementUtil.getPageTitle());
		Hooks.getScenario().log("Navigated to "+elementUtil.getPageTitle());
		softAssertions.assertAll();
	}
}
