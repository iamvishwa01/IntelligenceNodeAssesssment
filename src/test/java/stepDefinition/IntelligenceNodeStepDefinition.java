package stepDefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.opencsv.exceptions.CsvValidationException;
import com.test.qa.appHooks.Hooks;
import com.test.qa.factory.DriverFactory;
import com.test.qa.pages.IntelligencePage;
import com.test.qa.util.UtilClass;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class IntelligenceNodeStepDefinition {
	private DriverFactory driverFactory = new DriverFactory();
	private WebDriver driver = driverFactory.getDriver();
	UtilClass elementUtil = new UtilClass(driver);
	public static Properties prop;
	List<Map<String, String>> testData;
	Hooks hooks = new Hooks();
	public Scenario scenario;
	IntelligencePage intelligencePage = new IntelligencePage(driver);
	/**
	 * 1st Case
	 * @param string
	 * @throws InterruptedException 
	 */
	@Given("User loads the application and clicks on compare tab Selects the {string}")
	public void user_loads_the_application_and_clicks_on_compare_tab_selects_the(String string) throws InterruptedException {
		intelligencePage.compareTabSelects(string);
	}
	
	@Then("get the available item count")
	public void get_the_available_item_count() throws InterruptedException {
		intelligencePage.getAvailableItemCount();
	}
	
	@Then("captures the item count details")
	public void captures_the_item_count_details() throws InterruptedException {
	    intelligencePage.getTheItemCount();
	}
	
	/**
	 * 2nd Case
	 * 
	 */
	@Then("User selects the {string} option from the Status dropdown")
	public void user_selects_the_option_from_the_status_dropdown(String string) {
		 intelligencePage.filterStatus(string);
	}
	
	/**
	 * 3rd Case
	 * @throws IOException 
	 * @throws CsvValidationException 
	 */
	
	@Then("User clicks the Options dropdown and selects the {string} value from the dropdown")
	public void user_clicks_the_options_dropdown_and_selects_the_value_from_the_dropdown(String string) throws CsvValidationException, IOException {
		intelligencePage.selectsOptionToDownloadCSV(string);
	}
	@Then("compare the total itmes count and downloaded csv items count and upload")
	public void compare_the_total_itmes_count_and_downloaded_csv_items_count_and_upload() throws CsvValidationException, IOException, InterruptedException {
		intelligencePage.compareTableAndCSVAndUpload();
	}
	
//	4th Case
	@Then("User check if the difference button is enabled and user able to click that display differences.")
	public void user_check_if_the_difference_button_is_enabled_and_user_able_to_click_that_display_differences() throws InterruptedException {
		intelligencePage.defferenceButtonCheck();
	}
	
	//5th Case
	@Given("User loads the application and clicks on Relationship link")
	public void user_loads_the_application_and_clicks_on_relationship_link() {
		intelligencePage.loadRelationshipLink();
	}
	@Then("User drags {string} and {string} to X and Y axis then click on Apply Filter buttton and then clicks on any generated cell")
	public void user_drags_and_to_x_and_y_axis_then_click_on_apply_filter_buttton_and_then_clicks_on_any_generated_cell(String string, String string2) throws InterruptedException {
		intelligencePage.generateRelationshipChart(string,string2);
	}
}
