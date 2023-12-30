package com.test.qa.pages;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.test.qa.appHooks.Hooks;
import com.test.qa.factory.DriverFactory;
import com.test.qa.util.UtilClass;

import io.cucumber.java.Scenario;

public class LoginPage {
	private DriverFactory driverFactory = new DriverFactory();
	private WebDriver driver = driverFactory.getDriver();
	UtilClass elementUtil = new UtilClass(driver);
	public static Properties prop;
	List<Map<String, String>> testData;
	Hooks hooks = new Hooks();
	public Scenario scenario;

	// LoginPage Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}// end
	
	


}
