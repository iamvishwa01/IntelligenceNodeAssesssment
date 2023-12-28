package stepDefinition;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.test.qa.appHooks.Hooks;
import com.test.qa.factory.DriverFactory;
import com.test.qa.pages.GooglePage;
import com.test.qa.util.UtilClass;
import com.test.qa.util.ExcelReadUtils;
import com.test.qa.util.LogUtility;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.When;

public class GoogleStepDefinition {
	
	private DriverFactory driverFactory = new DriverFactory();
	private WebDriver driver = driverFactory.getDriver();
	UtilClass elementUtil = new UtilClass(driver);
	public static Properties prop;
	List<Map<String, String>> testData;
	LogUtility logger = new LogUtility();
	ExcelReadUtils fileReader = new ExcelReadUtils(driver);
	Hooks hooks = new Hooks();
	public Scenario scenario;
	GooglePage google = new GooglePage(driver);
	
	
	@When("User opens the Google site")
	public void user_opens_the_google_site() {
		google.SearchSong();
	}
//	@When("User searches for songs")
//	public void user_searches_for_songs() {
//	   
//	}
//	@Then("Song name should visible")
//	public void song_name_should_visible() {
//	   
//	}

}
