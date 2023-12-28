package stepDefinition;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.test.qa.appHooks.Hooks;
import com.test.qa.factory.DriverFactory;
import com.test.qa.pages.BingPage;
import com.test.qa.util.UtilClass;
import com.test.qa.util.ExcelReadUtils;
import com.test.qa.util.LogUtility;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.When;

public class BingStepDefinition {
	private DriverFactory driverFactory = new DriverFactory();
	private WebDriver driver = driverFactory.getDriver();
	UtilClass elementUtil = new UtilClass(driver);
	public static Properties prop;
	List<Map<String, String>> testData;
	LogUtility logger = new LogUtility();
	ExcelReadUtils fileReader = new ExcelReadUtils(driver);
	Hooks hooks = new Hooks();
	public Scenario scenario;
	BingPage bing = new BingPage(driver);
	
	@When("User opens the Bing site")
	public void user_opens_the_bing_site() {
		bing.SearchSong();
	}
//	@When("User searches for songs on bing")
//	public void user_searches_for_songs_on_bing() {
//	   
//	}
//	@Then("Song name should display")
//	public void song_name_should_display() {
//	    
//	}
}
