package com.test.qa.factory;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.test.qa.util.ConfigReader;
public class DriverFactory {
	public Properties prop;
	public ConfigReader config;
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();
	DesiredCapabilities ds = new DesiredCapabilities();
	public void getProperty() {
		config = new ConfigReader();
		prop = config.init_prop();
	}

	public WebDriver init_driver(String browser, String mode) {

		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions co = new ChromeOptions();
			if (mode.equals("headless") || mode.equals("normal")) {
				if (mode.equals("headless")) {
					co.addArguments("--headless", "--window-size=1920,1080");
				}
			} else {
				System.out.println("Please pass mode as 'headless/normal'. Execution is starting on default mode");
			}
			co.setAcceptInsecureCerts(true);
			tldriver.set(new ChromeDriver(co));
		} else {
			System.out.println("Kindly pass correct browser value as 'chrome'");
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}

	public WebDriver getDriver() {
		return tldriver.get();
	}
}
