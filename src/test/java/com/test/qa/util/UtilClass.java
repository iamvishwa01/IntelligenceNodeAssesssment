package com.test.qa.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
//imports
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.qa.appHooks.Hooks;
import com.test.qa.factory.DriverFactory;

import io.cucumber.java.Scenario;


/**
 * @Author -- Pranjal Mudhalwadkar
 **/

public class UtilClass {
	private DriverFactory driverFactory = new DriverFactory();
	public WebDriver driver = driverFactory.getDriver() ;
	LogUtility logger = new LogUtility();	
	Hooks  hooks = new Hooks();
	public static final long waitt = 30;

	//ElementUtil Page Class Constructor
	public UtilClass(WebDriver driver) {
		this.driver= driver;	
		PageFactory.initElements(driver, this);
		
	}//end 
	public boolean isPageLoaded() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    return wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
	}
	// Method to perform Click action on element
	public void clickElement(WebElement element) {
		waitForVisibility(element, waitt);
		element.click();
	}//end 
	
	public void waitForVisibility(WebElement element,long waitaa) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitaa));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Method to enter text into input text field
	public void enterText(WebElement element, String Text) {
		element.sendKeys(Text);
	}//end 

	// Switching the Frame
	public void GoToFrame(String FrameIDName) {
		try {
			driver.switchTo().frame(FrameIDName);
		} catch (NoSuchElementException e) {
			logger.log().error("Exception Occured : \n" +e);
		}

	}//end

	// Method to Clear TextField
	public void clearText(WebElement element) {
		try {
			element.clear();
		} catch (NoSuchElementException e) {
			logger.log().error("Exception Occured : \n" +e);
		}

	}//end 

	// Method for Checking element is present
	public boolean isElementPresent(WebElement element) {
		boolean flag=false;
		if(element.isDisplayed())
		{
			return true;
		}

		return flag;
	}//end

	//Method to switch to Parent Frame
	public void GoToparentFrame() {
		try {
			driver.switchTo().parentFrame();
		} catch (NoSuchElementException e) {
			logger.log().error("Exception Occured : \n" +e);
		}

	}//end

	//Method for Checking element is enabled
	public void isElementEnabled(WebElement element) {
		element.isEnabled();
	}//end

	//Method To MoveToElement
	public void moveToElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();

	}//end

	// Context Click or Right Click on element
	public void rightClickOnElement(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick().build().perform();


	}//end

	//Selecting dropdown values by visible Text
	public void selectDropDownByVisibleText(WebElement element, String visibleText) throws InterruptedException {

		SHORT_TIMEOUT();
		element.click();
		SHORT_TIMEOUT();
		Select sel = new Select(element);
		SHORT_TIMEOUT();
		sel.selectByVisibleText(visibleText);

	}//end

	// Selecting dropdown values by visible Text
	public void selectDropDownByVisibleText1(WebElement element, String visibleText) throws InterruptedException {
		SHORT_TIMEOUT();
		Select sel = new Select(element);
		SHORT_TIMEOUT();
		sel.selectByVisibleText(visibleText);

	}//end

	// Selecting dropdown values by Value Text-Method specific to one of the field
	//in Customer screen
	public void selectElementValue_FromList(WebElement element, String values[]) throws InterruptedException {
		for(int i=0;i<values.length;i++)
		{
			//System.out.println("values " + values[i]);
			Select sel = new Select(element);
			SHORT_TIMEOUT();
			sel.selectByValue(values[i]);

		}//end of for

	}//end

	// Selecting dropdown values by Value Text-Method specific to one of the field
	//in Customer screen
	public void deselectingElementValue_FromList(WebElement element, String values[]) throws InterruptedException {
		for(int i=0;i<values.length;i++)
		{
			//System.out.println("values " + values[i]);
			Select select = new Select(element);
			SHORT_TIMEOUT();
			select.deselectByValue(values[i]);

		}//end of for

	}//end

	// Selecting dropdown values by value
	public void selectDropDownByValue(WebElement element, String dropDownValue) {

		element.click();
		Select sel = new Select(element);
		sel.selectByValue(dropDownValue);


	}//end

	// Selecting dropDown values by Index
	public void selectDropDownByIndex(WebElement element, int index) {
		try {
			element.click();
			Select sel = new Select(element);
			sel.selectByIndex(index);
		} catch (NoSuchElementException e) {
			logger.log().error("Exception Occured : \n" +e);
		}

	}//end

	// Selecting values from List box
	public void selectElementFromListBox(WebElement element,String visibletext) throws InterruptedException {
		Select s=new Select(element);
		List<WebElement> allvals=s.getOptions();

		for(int i=0;i<allvals.size();i++)
		{
			Thread.sleep(1000);
			System.out.println("CheckBox:"+ allvals.get(i).getAttribute("value"));
			s.selectByIndex(i); //select one by one
		}
	}//end

	// Handling the Windows
	public void handlewin(WebDriver driver) throws InterruptedException {

		Set<String> s1 = driver.getWindowHandles();
		String menuWindow = driver.getWindowHandle();
		s1.remove(menuWindow);

		Iterator<String> i1 = s1.iterator();
		String child = null;

		while (i1.hasNext()) {
			child = (String) i1.next();
			driver.switchTo().window(child);
		}
	}

	public WebDriver handlewin1(WebDriver driver) {
		driver.getWindowHandle();
		String childWindow = driver.getWindowHandle();
		Set<String> pops=driver.getWindowHandles();
		{
			Iterator<String> it =pops.iterator();
			while (it.hasNext()) {
				String menuWindow=it.next().toString();
				System.out.println("menu window : " +menuWindow);
				if(!menuWindow.contains(childWindow))
				{
					System.out.println("in if");
					WebDriver driver1 = driver;
					driver1.close();
					driver.switchTo().window(menuWindow);
					System.out.println("Pop Up Title: "+ driver.switchTo().window(menuWindow).getTitle());

				}
			}
		}
		return driver;
	}//end

	// Accepting the Alert Window
	public void acceptAlert() throws InterruptedException {
		try {
			SHORT_TIMEOUT();
			driver.switchTo().alert().accept();
		} catch (NoSuchElementException e) {
			logger.log().error("Exception Occcured : \n" +e);
		}

	}//end

	// Dismissing the Alert Window
	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
		} catch (NoSuchElementException e) {
			logger.log().error("Exception Occcured : \n" +e);
		}

	}//end

	// Entering Text into Alert WindowBox
	public void enterTextInAlertBox(String alertText) throws InterruptedException {

		try {
			driver.switchTo().alert().sendKeys(alertText);
		} catch (NoSuchElementException e) {
			logger.log().error("Exception Occcured : \n" +e);
		}

	}

	//clicking on element using Action Class
	public void actionClassClickElement(WebElement Element) throws InterruptedException
	{
		Actions actions = new Actions(driver);
		SHORT_TIMEOUT();
		actions.moveToElement(Element).click().perform();
	}

	public void javascriptExecutorScrollElement(WebElement Element) throws InterruptedException
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		SHORT_TIMEOUT();
		jse.executeScript("arguments[0].scrollIntoView()", Element); 
	}
	public void javascriptExecutorScrollBy(int pixels) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        // Assuming SHORT_TIMEOUT() is a method you've defined elsewhere
        SHORT_TIMEOUT();

        // Using JavascriptExecutor to scroll by a certain amount (in pixels)
        jse.executeScript("window.scrollBy(0, arguments[0])", pixels);
    }
	public void javascriptExecutorClickElement(WebElement Element) throws InterruptedException
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		SHORT_TIMEOUT();
		jse.executeScript("arguments[0].click()", Element); 
	}

	// Closing browser
	public void quitBrowser() {
		driver.quit();
	}

	// Short Timeout
	public void SHORT_TIMEOUT() throws InterruptedException {
		Thread.sleep(1000);
	}

	// Timeout
	public void TIMEOUT() throws InterruptedException {
		Thread.sleep(3000);
	}

	// Long Timeout
	public void LONG_TIMEOUT() throws InterruptedException {
		Thread.sleep(20000);
	}


//	public void explicitWait(String locator)
//	{
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		WebElement element = wait.until(
//				ExpectedConditions.visibilityOfElementLocated(By.name(locator)));
//	}

	public void implicitWait()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	// Getting text from field
	public String getText(WebElement element) {
		waitForVisibility(element, waitt);
		return element.getText();
	}

	// Getting value from field
	public String getAttribute(WebElement element) {
		return element.getAttribute("value");
	}

	public void explicitWait(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120, 1));
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
	}

	// To Select checkbox
	public void isElementSelected(WebElement element, String checkbox) {
		if (checkbox.equals("Select") && !element.isSelected()) {
			element.click();

		} else {
			//For Deselect
			if (element.isSelected() == true) {
				element.click();

			}
		}

	}

	//get selecteddropdown value
	public String getSelectedDropDown(WebElement element) {
		Select select = new Select(element);
		WebElement option = select.getFirstSelectedOption();
		String defaultItem = option.getText();
		return defaultItem;
	}
	//checking CheckBox Selection And Performing Action 
	public void CheckBoxSelectAndDeslection(WebElement element, String checkbox) throws InterruptedException {
		if(element.isSelected()==true && checkbox.equals("DeSelect"))
		{
			//System.out.println("in select");
			clickElement(element);
		}//end 
		else if(element.isSelected()==false && checkbox.equals("Select"))
		{
			//System.out.println("in deslect");
			clickElement(element);
		}//end
		else
		{
			//System.out.println("No Operation Performed");
		}//end
	}//end of CheckBoxSelectAndDeslection function

	//Method Specific to Customer->Menu(Selecting checkboxes)
	public boolean selectCheckBoxes(String[] checkBoxNo) throws InterruptedException
	{
		boolean flag=false;
		List <WebElement> AllSchemeFormatMapping_Checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']")) ;

		for (String string : checkBoxNo) {
			int recordNo=Integer.parseInt(string);
			for(int i=0;i<AllSchemeFormatMapping_Checkboxes.size();i++)
			{

				if(i==recordNo)
				{
					SHORT_TIMEOUT();
					AllSchemeFormatMapping_Checkboxes.get(recordNo).click();
					flag=true;
				}
				else
				{
					//System.out.println("in else");
				}
			}//end of for
		}
		return flag;
	}//end of selectCheckBoxes function

	//Scroll down to the bottom of the webPage
	public void ScrollToBottom() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println("Scroll Worked...");
	}
	public void scrollToBottom() {
        try {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
            Thread.sleep(500);  // Optional: Add a small delay to allow time for the scrolling effect
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	public void scrollToElement(WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(500);  
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

	//Scroll Up to the Top of the webPage
	public void ScrollToTop() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
	}


	public String failcaptureScreenshot(WebDriver driver,Scenario scenario,  String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmm").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/FailedScreenshots/"+Hooks.getScenario().getName()+"/"+screenshotName + dateName+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	
	/**
	 * <b>Method to add screenshot in the JVM reports
	 */
	public void addScreenShotToReport(String screenShotName) {
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		Hooks.getScenario().attach(screenshot, "image/png",screenShotName);	
	}

	//get Text of the elements
	public String getTextofElement(By locator) {
		String displayedText = driver.findElement(locator).getText();
		if (displayedText.isEmpty()) {
			return driver.findElement(locator).getAttribute("value");
		} else {
			return displayedText;
		}
	}

	public void navigateTo(String url) {
		driver.get(url);	
	}

	public boolean reloadAndAccept() {
		driver.navigate().refresh();
		try {
			driver.switchTo().alert().accept();	
			 return true; 
		}catch(Exception e) {
			return false; 
		}
		
	}

	/**
	 * Method use to move to element
	 * @param element
	 */
	public void scrolltoElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}
	
	public String getPageTitle() {
	 return driver.getTitle();
	}
	public String getDate(String string) {
        SimpleDateFormat sdf = new SimpleDateFormat(string);
        Date currentDate = new Date();
        String formattedDate = sdf.format(currentDate);
        return formattedDate;
	}

}
