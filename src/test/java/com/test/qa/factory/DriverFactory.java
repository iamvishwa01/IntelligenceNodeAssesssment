package com.test.qa.factory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.FileDetector;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.test.qa.appHooks.Hooks;
import com.test.qa.util.ConfigReader;
import com.test.qa.util.LogUtility;

/**
 * 
 * ChromeOptions options = new ChromeOptions();
        options.AddArgument("disable-infobars");
        options.AddArgument("enable-automation");
        options.AddArgument("disable-popup-blocking");
        options.AddArgument("ignore-certificate-errors");
        options.AddArgument("start-maximized"); 
        options.AddArgument("disable-infobars"); 
        options.AddArgument("--disable-extensions"); 
        options.AddArgument("--disable-gpu");
        options.AddArgument("--disable-dev-shm-usage"); 
        options.AddArgument("--no-sandbox");
        options.AddArgument("window-size=1920,1080");
 * 
 */
/**
 * @Author -- Pranjal Mudhalwadkar
 **/
public class DriverFactory {
	public Properties prop;
	public ConfigReader config;
	public static ThreadLocal<RemoteWebDriver> rdriver = new ThreadLocal<>();
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();
	LogUtility logger = new LogUtility();
	DesiredCapabilities ds = new DesiredCapabilities();
	
//	FirefoxOptions fo = new FirefoxOptions();
	public void getProperty() {
		config = new ConfigReader();
		prop = config.init_prop();
	}// end of getProperty function

//	public WebDriver init_driver(String browser, String mode) {
//		
//			if (browser.equalsIgnoreCase("chrome") || browser.equalsIgnoreCase("firefox")
//					|| browser.equalsIgnoreCase("edge")) {
//				if (browser.equalsIgnoreCase("chrome")) {
//					ChromeOptions co = new ChromeOptions();
//					if (mode.equals("headless") || mode.equals("normal")) {
//						if (mode.equals("headless")) {
//							co.addArguments("--headless", "--window-size=1920,1080");
//						}
//					} else {
//						System.out.println(
//								"Please pass mode as 'headless/normal'. Execution is starting on default mode");
//					}
//					co.setAcceptInsecureCerts(true);
//					tldriver.set(new ChromeDriver(co));
//				} else if (browser.equalsIgnoreCase("edge")) {
//					EdgeOptions eo = new EdgeOptions();
//					if (mode.equals("headless")) {
//						eo.addArguments("--headless", "--window-size=1920,1080");
//					}
//					eo.addArguments("--start-maximized");
//					ds.setAcceptInsecureCerts(true);
//					tldriver.set(new EdgeDriver(eo));
//				} else if (browser.equalsIgnoreCase("firefox")) {
//					FirefoxOptions options = new FirefoxOptions();
//					if (mode.equals("headless")) {
//						options.addArguments("--headless", "--window-size=1920,1080");
//					}
//					options.addArguments("--start-maximized");
//					ds.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
//					tldriver.set(new FirefoxDriver(options));
//				} else {
//					logger.log().info("Kindly pass correct browser value. i.e: 'chrome','firefox' or 'edge'");
//				}
//			} else {
//				logger.log().info("Please pass valid browser name. i.e: 'chrome', 'firefox','edge'");
//			}
//		getDriver().manage().deleteAllCookies();
//		getDriver().manage().window().maximize();
//		return getDriver();
//	}
//
//	public WebDriver getDriver() {
//		return tldriver.get();
//	}
	
	

	public RemoteWebDriver init_driver(String browser, String mode) throws MalformedURLException {
		getProperty();
		String remoteURL=	prop.getProperty("remoteURL");
		if (browser.equalsIgnoreCase("chrome") || browser.equalsIgnoreCase("firefox")
				|| browser.equalsIgnoreCase("edge")) {
			if (browser.equalsIgnoreCase("chrome")) {
				ChromeOptions co = new ChromeOptions();
				if (mode.equals("headless") || mode.equals("normal")) {
					if (mode.equals("headless")) {
						co.addArguments("--headless", "--window-size=1920,1080");
					}
				} else {
					System.out.println(
							"Please pass mode as 'headless/normal'. Execution is starting on default mode: normal");
				}
				ds.setCapability("enableVNC", true);
				ds.setBrowserName("chrome");
				co.setAcceptInsecureCerts(true);
				co.setCapability("selenoid:options", new HashMap<String, Object>() {{
				    /* How to add test badge */
					put("name", Hooks.getScenario().getName());
				    /* How to set session timeout */
				    put("sessionTimeout", "10m");
				    /* How to set timezone */
				    put("env", new ArrayList<String>() {{
				        add("TZ=IST");
				    }});
				    /* How to add "trash" button */
				    put("labels", new HashMap<String, Object>() {{
				        put("manual", "true");
				    }});    
				    /* How to enable video recording */
				    put("enableVideo", false);
				}});
				ds.setCapability(ChromeOptions.CAPABILITY, co);
				prop.getProperty("remoteURL");
				rdriver.set(new RemoteWebDriver(new URL(remoteURL),ds));
				rdriver.get().setFileDetector(new LocalFileDetector());
			} else if (browser.equalsIgnoreCase("edge")) {
				EdgeOptions eo = new EdgeOptions();
				if (mode.equals("headless") || mode.equals("normal")) {
					if (mode.equals("headless")) {
						eo.addArguments("--headless", "--window-size=1920,1080");
					}
				} else {
					System.out.println(
							"Please pass mode as 'headless/normal'. Execution is starting on default mode: normal");
				}
				eo.setCapability("selenoid:options", new HashMap<String, Object>() {{
				    /* How to add test badge */
					put("name", Hooks.getScenario().getName());
				    /* How to set session timeout */
				    put("sessionTimeout", "10m");
				    /* How to set timezone */
				    put("env", new ArrayList<String>() {{
				        add("TZ=IST");
				    }});
				    /* How to add "trash" button */
				    put("labels", new HashMap<String, Object>() {{
				        put("Automation", "true");
				    }});    
				    /* How to enable video recording */
				    put("enableVideo", false);
				}});
				ds.setCapability("enableVNC", true);
				eo.addArguments("--start-maximized");
				ds.setAcceptInsecureCerts(true);
				ds.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				rdriver.set(new RemoteWebDriver(new URL(remoteURL),ds));
				rdriver.get().setFileDetector(new LocalFileDetector());
				tldriver.set(new EdgeDriver(eo));
			} else if (browser.equalsIgnoreCase("firefox")) {
				FirefoxOptions options = new FirefoxOptions();
				if (mode.equals("headless")) {
					options.addArguments("--headless", "--window-size=1920,1080");
				}
				options.setCapability("selenoid:options", new HashMap<String, Object>() {{
				    /* How to add test badge */
					put("name", Hooks.getScenario().getName());
				    /* How to set session timeout */
				    put("sessionTimeout", "10m");
				    /* How to set timezone */
				    put("env", new ArrayList<String>() {{
				        add("TZ=IST");
				    }});
				    /* How to add "trash" button */
				    put("labels", new HashMap<String, Object>() {{
				        put("manual", "true");
				    }}); 
				    /* How to enable video recording */
				    put("enableVideo", false);
				}});
				ds.setCapability("enableVNC", true);
				ds.setBrowserName("firefox");
				options.addArguments("--start-maximized");
				ds.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
				ds.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				rdriver.set(new RemoteWebDriver(new URL(remoteURL),ds));
				rdriver.get().setFileDetector(new LocalFileDetector());
				tldriver.set(new FirefoxDriver(options));
			} else {
				logger.log().info("Kindly pass correct browser value. i.e: 'chrome','firefox' or 'edge'");
			}
		} else {
			logger.log().info("Please pass valid browser name. i.e: 'chrome', 'firefox','edge'");
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
	return getDriver();	
	}
	
	public RemoteWebDriver getDriver() {
		return rdriver.get();
	}
}
