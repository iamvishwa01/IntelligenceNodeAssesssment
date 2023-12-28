package com.test.qa.pages;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencsv.exceptions.CsvValidationException;
import com.test.qa.appHooks.Hooks;
import com.test.qa.factory.DriverFactory;
import com.test.qa.util.ExcelReadUtils;
import com.test.qa.util.LogUtility;
import com.test.qa.util.ReadExcelData;
import com.test.qa.util.UtilClass;

import io.cucumber.java.Scenario;

public class IntelligencePage {
	private DriverFactory driverFactory = new DriverFactory();
	WebDriver driver = driverFactory.getDriver();
	UtilClass utilClass ;
	public static Properties prop;
	List<Map<String, String>> testData;
	LogUtility logger = new LogUtility();
	ExcelReadUtils fileReader;
	public Scenario scenario;
	SoftAssertions softAssertions = new SoftAssertions();
	
	public IntelligencePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		utilClass = new UtilClass(driver);
		fileReader = new ExcelReadUtils(driver);
	}
	//WebElements
	@FindBy(xpath = "//a[normalize-space()='Compare']")
	WebElement compareDropdown;
	
	@FindBy(linkText = "MAP Violations")
	WebElement mapViolationdrpDown;
	
	@FindBy(linkText = "Items")
	WebElement itemsdrpDown;
	
	@FindBy(linkText = "Category")
	WebElement categorydrpDown;
	
	@FindBy(xpath = "//div[@class='pull-left paginationList']/span")
	List<WebElement> totalItemCountwithDisplayed;
	
	@FindBy(xpath = "//button[normalize-space()='Apply']")
	WebElement applyButton;
	
	@FindBy(xpath = "//table[@id='compareItemsTable']")
	WebElement tableDisplayCheck;
	
	@FindBy(xpath = "//th[normalize-space()='SKU Id']")
	WebElement checkLoadTable;
	
	@FindBy(xpath = "//li[contains(@class,'sorting-dropdown click-parent')]//address")
	WebElement statusFilterDropdown;
	
	@FindBy(xpath = "//div[@id='discount_options']/ul/li")
	List<WebElement> totalListDropdownItems;
	
	@FindBy(xpath = "//small[normalize-space()='Options']")
	WebElement optionsDropdown;
	
	@FindBy(xpath = "(//div[@class='comparing-dd click-container'])[1]/ul/li")
	List<WebElement> downloadOptionsDropdown;
	
	@FindBy(xpath = "//span[normalize-space()='Items']/preceding-sibling::span[1]")
	WebElement totalItemCountWeb;
	
	@FindBy(xpath = "//*[@id='compareItemsTable']/tbody/tr/td/div/span/span[1]/span[2]/i")
	List<WebElement> allDefferenceButton;
	
	@FindBy(xpath = "//div[contains(@class,'row mainHeadTooltip')]/p")
	WebElement differencePane;
	
	@FindBy(xpath = "//div[@class='col-md-7 mainNavigation']")
	WebElement navigator;
	
	@FindBy(xpath = "(//div[contains(@data-rbd-droppable-id,'filterList')])[1]/ul/li/in-drop-down/span/div/div/div/ng-include/div/span")
	List<WebElement> dragDropItems;
	
	public void compareTabSelects(String string) throws InterruptedException {
		Hooks.getScenario().log("Waiting for few Seconds to load the site properly.");
		if(checkPageLoad(applyButton)==true) {
			Hooks.getScenario().log("Selecting the Compare tab and selecting the "+string+" option.");
			utilClass.moveToElement(compareDropdown);
			if(string.equals("Map Violation")) {
				utilClass.clickElement(mapViolationdrpDown);
			}else if(string.equals("Items")) {
				utilClass.clickElement(itemsdrpDown);
			}else if(string.equals("Categories")) {
				utilClass.clickElement(categorydrpDown);
			}
		}else {
			Hooks.getScenario().log("Page not loaded properly. Please increase 'counter' from 'checkPageLoad' method.");
		}
		
	}
	
	public boolean checkPageLoad(WebElement element) {
		boolean pageLoad = false;
		int counter = 1;
		do {
			try {
				if(element.isDisplayed()) {
					pageLoad = true;
					break;
				}
			}catch (NoSuchElementException e) {
				pageLoad = false;
			}
			counter++;
		}while(counter==20);
		return pageLoad;
	}
	
	public void getTheItemCount() throws InterruptedException {
		Thread.sleep(10000);
		utilClass.scrollToBottom();
		Hooks.getScenario().log("Getting the Item count displayed on the webpage.");
		String totalDsiplayedCount = "";
		for(WebElement el: totalItemCountwithDisplayed) {
			totalDsiplayedCount = totalDsiplayedCount+el.getText()+" ";
		}
		Hooks.getScenario().log("Total Item count is: "+totalDsiplayedCount);
		utilClass.addScreenShotToReport("ItemCountOnWebPage");
	}

	public void getOverPricedItemCount(String string) {
		Hooks.getScenario().log("Filtering "+string+" items.");
		utilClass.clickElement(statusFilterDropdown);
		for(WebElement list: totalListDropdownItems) {
			String filterName = list.getText().trim();
			System.out.println("DropDown items "+filterName);
			if(filterName.equalsIgnoreCase("Overpriced")) {
				utilClass.clickElement(list);
				break;
			}
		}
		//Checking if the page is loaded properly and table displayed for OverPriced items.
		utilClass.scrollToBottom();
		
	}
	
	public void selectsOptionToDownloadCSV(String string) throws CsvValidationException, IOException {
		utilClass.clickElement(optionsDropdown);
		for(WebElement el : downloadOptionsDropdown) {
			String value = utilClass.getText(el);
			System.out.println(value);
			if(value.equals(string)) {
				utilClass.clickElement(el);
				break;
			}
		}
	}
	
	public void compareTableAndCSV() throws CsvValidationException, IOException {
		//Check if the file has downloaded
				//Default downloads is set to Downloads folder but it can be configured to download the files to project directory itself from the DriverFactory class
				String fileNameConvention = "exact_match_data_"+utilClass.getDate("yyyy-MM-dd")+"_US.csv";
				File downloadedFile = new File("C:\\Users\\admin\\Downloads\\"+fileNameConvention);
				if(downloadedFile.exists()) {
					Hooks.getScenario().log("File Downloaded Successfully.");
					int totalItemCount = Integer.parseInt(utilClass.getText(totalItemCountWeb));
					//getting the rows count from the CSV
					int csvItemCount = ReadExcelData.getRowCount(downloadedFile.toString());
					if(totalItemCount==csvItemCount) {
						Hooks.getScenario().log("The count present on WebPage is matching with the downloaded csv file item count.\n"
								+ "WebPage Item Count: "+totalItemCount+"\n"
								+ "CSV File Item Count: "+csvItemCount);
					}else {
						Hooks.getScenario().log("The count present on WebPage is not matching with the downloaded csv file item count.\n"
								+ "CSV Item Count: "+csvItemCount+"\n"
								+ "WebPage Item Count: "+totalItemCount);
					}
				}else {
					Hooks.getScenario().log("Error downloading file.");
					softAssertions.assertThat("Error downloading file.").isEqualTo("File should be downloaded.");
				}
	}

	public void defferenceButtonCheck() throws InterruptedException {
		Hooks.getScenario().log("User checking the Difference button on the page for the items present on the first page.");
		int i =1;
		utilClass.waitForVisibility(tableDisplayCheck, 20);
		try {
			if(utilClass.isElementPresent(tableDisplayCheck)) {
				for(WebElement diff : allDefferenceButton) {
					utilClass.javascriptExecutorScrollBy(100);
					if(diff.isEnabled()) {
						Hooks.getScenario().log("For Item '"+i+"' Difference button is enabled");
						utilClass.clickElement(diff);
						try {
							if(differencePane.isDisplayed()) {
								Hooks.getScenario().log("User is able to click on the difference button to view the difference matches items.");
								utilClass.addScreenShotToReport("OkDifferenceList_"+i);
							}
						}catch (NoSuchElementException e) {
							Hooks.getScenario().log("User tries to click on difference button but difference matches items pane are not being displayed.");
							utilClass.addScreenShotToReport("errorDifferenceMatchesPane");
						}
					}else {
						Hooks.getScenario().log("For Item '"+i+"' Difference button is enabled");
						utilClass.addScreenShotToReport("differenceButtonNotEnabled_"+i);
					}
					try {
						utilClass.actionClassClickElement(navigator);
					}catch (ElementClickInterceptedException e) {
						utilClass.actionClassClickElement(navigator);
					}
					i++;
					utilClass.SHORT_TIMEOUT();
				}
			}
			
		}catch (NoSuchElementException e) {
			Hooks.getScenario().log("Something went wrong. Please check the logs for more details.");
			e.printStackTrace();
		}
	}
	
}
