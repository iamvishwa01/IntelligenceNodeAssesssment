package com.test.qa.pages;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.io.FileWriteMode;
import com.opencsv.exceptions.CsvValidationException;
import com.test.qa.appHooks.Hooks;
import com.test.qa.factory.DriverFactory;
import com.test.qa.util.ReadExcelData;
import com.test.qa.util.UploadFileToDrive;
import com.test.qa.util.UtilClass;

import io.cucumber.java.Scenario;
import io.restassured.response.Response;

public class IntelligencePage {
	private DriverFactory driverFactory = new DriverFactory();
	WebDriver driver = driverFactory.getDriver();
	UtilClass utilClass ;
	public static Properties prop;
	List<Map<String, String>> testData;
	public Scenario scenario;
	SoftAssertions softAssertions = new SoftAssertions();
	
	public IntelligencePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		utilClass = new UtilClass(driver);
	}
	//WebElements
	@FindBy(xpath = "(//a[normalize-space()='Compare']/i)[1]")
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
	WebElement skuIdtableCol;
	
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
	
	@FindBy(xpath = "//div[@dnd-list='xAxisSelectionList']")
	WebElement xAxisBox;
	
	@FindBy(xpath = "//div[contains(@data-rbd-droppable-id,'yAxisSelectionList')]")
	WebElement yAxisBox;
	
	@FindBy(xpath = "//button[normalize-space()='Apply Filter']")
	WebElement applyFilterBtn;
	
	@FindBy(xpath = "//div[contains(@class,'loadHeatMapHere')]")
	WebElement chartMap;
	
	@FindBy(xpath = "//*[name()='svg']//*[name()='g'][8]/*[name()='rect'][14]")
	WebElement anyCellFromChartMap;
	
	@FindBy(xpath = "//a[normalize-space()='Relationship Chart']")
	WebElement relationShipChartLink;
	
	@FindBy(xpath = "//li[@class='activeTab']")
	WebElement activeTab;
	
	@FindBy(xpath = "//div[contains(@dnd-list,'xAxisSelectionList')]//div[contains(@class,'newFeatureTooltip')]")
	WebElement xAxisDragSuccess;
	
	@FindBy(xpath = "//div[contains(@dnd-list,'yAxisSelectionList')]//div[contains(@class,'newFeatureTooltip')]")
	WebElement yAxisDragSuccess;
	
	@FindBy(xpath = "//span[@class='compareItemShowMore']")
	WebElement showMorebtn;
	
	@FindBy(xpath = "//span[@class='bold-text text-padding']")
	WebElement totalItemsCountWeb;
	
	public void compareTabSelects(String string) throws InterruptedException {
		Hooks.getScenario().log("Waiting for few Seconds to load the site properly.");
		utilClass.waitForVisibility(compareDropdown, 10);
		try {
			if(checkPageLoad(compareDropdown)==true) {
				Hooks.getScenario().log("Clicking the Compare tab and selecting the '"+string+"' option.");
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
		}catch (NoSuchElementException e) {
			e.printStackTrace();
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
		utilClass.waitForVisibility(showMorebtn, 10);
		try {
			if (utilClass.getText(showMorebtn).trim().equals("Show More")) {
				Hooks.getScenario().log("Getting the Item count displayed on the webpage.");
				Hooks.getScenario().log("Total Overpriced Item count is: " + utilClass.getText(totalItemsCountWeb));
				utilClass.javascriptExecutorScrollElement(showMorebtn);
				utilClass.addScreenShotToReport("ItemCountOnWebPage");
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		
	}

	public void filterStatus(String string) {
		Hooks.getScenario().log("Filtering '"+string+"' items.");
		utilClass.clickElement(statusFilterDropdown);
		for(WebElement list: totalListDropdownItems) {
			String filterName = list.getText().trim();
			if(filterName.equalsIgnoreCase(string)) {
				utilClass.clickElement(list);
				break;
			}
		}
		utilClass.scrollToBottom();
	}
	
	public void selectsOptionToDownloadCSV(String string) throws CsvValidationException, IOException {
		utilClass.waitForVisibility(skuIdtableCol,10);
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
	
	public void compareTableAndCSVAndUpload() throws CsvValidationException, IOException, InterruptedException {
		//Check if the file has downloaded
				//Default download path is set to Downloads folder but it can be configured to download the files to project directory itself from the DriverFactory class
				String fileNameConvention = "exact_match_data_"+utilClass.getDate("yyyy-MM-dd")+"_US.csv";
				File downloadedFile = new File("C:\\Users\\admin\\Downloads\\"+fileNameConvention);
				
				boolean fileCheck = utilClass.waitForFileToDownload(downloadedFile.toString(), 20);
				if(fileCheck) {
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
					utilClass.javascriptExecutorScrollElement(showMorebtn);
					utilClass.addScreenShotToReport("ItemCount");
					UploadFileToDrive uploadFileToDrive = new UploadFileToDrive();
					FileWriter fw = new FileWriter(System.getProperty("user.dir")+"/fileDetails.json");
					fw.write("{\r\n"
							+ "\"name\" : \""+fileNameConvention+"\",\r\n"
							+ "\"description\" : \""+fileNameConvention+" File Uploaded\"\r\n"
							+ "}");
					fw.close();
					Response response=null;
					response=uploadFileToDrive.upload(downloadedFile.toString(), System.getProperty("user.dir")+"/fileDetails.json");
					if(response.getStatusCode()==200) {
						Hooks.getScenario().log("File '"+fileNameConvention+"' Uploaded to Google Drive.");
						Hooks.getScenario().log("Response: "+response.getBody().asPrettyString());
					}else {
						Hooks.getScenario().log("File could not be uploaded to Google drive.\n"
								+ "Access Token could be expire that could be possible reason. Please generate new access token.\n"
								+ "Response: "+response.getBody().asPrettyString());
						softAssertions.assertThat("File '"+fileNameConvention+"' could not be uploaded to Google drive.").isEqualTo("File should be uploaded to Google drive.");
					}
				}else {
					Hooks.getScenario().log("Error downloading file.");
					softAssertions.assertThat("Error downloading file.").isEqualTo("File should be downloaded.");
				}
				softAssertions.assertAll();
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
					/*Can be optimized more to check the same for all the items present on the page. 
					 * Currently it is checking for one record. if break statement remove then it will check for all the displayed items on the webpage
					 */
					break;
				}
			}
			
		}catch (NoSuchElementException e) {
			Hooks.getScenario().log("Something went wrong. Please check the logs for more details.");
			e.printStackTrace();
		}
	}

	public void loadRelationshipLink() {
		utilClass.clickElement(relationShipChartLink);
	}

	public void generateRelationshipChart(String string, String string2) throws InterruptedException {
		utilClass.TIMEOUT();
		int i = 1;
		for (WebElement draggable : dragDropItems) {
			String value = utilClass.getText(draggable);
			if (value.equals(string)) {
				WebElement match = driver.findElement(By.xpath(
						"((//div[contains(@data-rbd-droppable-id,'filterList')])[1]/ul/li/in-drop-down)[" + i + "]"));
				utilClass.dragAndDrop(match, xAxisBox);
			} else if (value.equals(string2)) {
				WebElement match = driver.findElement(By.xpath(
						"((//div[contains(@data-rbd-droppable-id,'filterList')])[1]/ul/li/in-drop-down)[" + i + "]"));
				utilClass.dragAndDrop(match, yAxisBox);
			}
			i++;
		}
		try {
			if(utilClass.isElementPresent(xAxisDragSuccess) && utilClass.isElementPresent(yAxisDragSuccess)) {
				utilClass.clickElement(applyFilterBtn);
				utilClass.waitForVisibility(chartMap, 20);
				utilClass.actionClassClickElement(anyCellFromChartMap);
			}	
		}catch (NoSuchElementException e) {
			softAssertions.assertThat("Something went wrong while adding attribute to 'x' or 'y' Axix boxes to generate the chart.").isEqualTo("Attribute should be added successfully. ");
			utilClass.addScreenShotToReport("errorAddingAttributetoGenerateRelationShipChart");
			e.printStackTrace();
		}
		softAssertions.assertAll();
	}

	public void getAvailableItemCount() throws InterruptedException {
		//Getting total Item count
		int totalItemsCount = 0;
		int totaloverPricedItems = 0;
		int totalAvailableItemsCount = 0;
		utilClass.waitForVisibility(showMorebtn, 10);
		try {
			if(utilClass.getText(showMorebtn).trim().equals("Show More")) {
				totalItemsCount = Integer.parseInt(utilClass.getText(totalItemsCountWeb));
				filterStatus("Out Of Stock");
				utilClass.waitForVisibility(showMorebtn, 10);
				totaloverPricedItems = Integer.parseInt(utilClass.getText(totalItemsCountWeb));
				totalAvailableItemsCount = totalItemsCount - totaloverPricedItems;
				Hooks.getScenario().log("Total Available Items Count on Compare > Items is :"+totalAvailableItemsCount);
				utilClass.addScreenShotToReport("TotalAvailableItemCount");
			}
		}catch (NoSuchElementException e) {
			Hooks.getScenario().log("Items table not loaded properly.");
			utilClass.addScreenShotToReport("tableNotLoaded");
		}
		
		
		
		
	}

	
}
