package com.test.qa.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.qa.appHooks.Hooks;
import com.test.qa.factory.DriverFactory;
public class UtilClass {
	private DriverFactory driverFactory = new DriverFactory();
	public WebDriver driver = driverFactory.getDriver() ;
	Hooks  hooks = new Hooks();
	public static final long waitt = 30;

	public UtilClass(WebDriver driver) {
		this.driver= driver;	
		PageFactory.initElements(driver, this);
	} 
	
	public void reInitializeElements() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isPageLoaded() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    return wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
	}

	public void clickElement(WebElement element) {
		waitForVisibility(element, waitt);
		element.click();
	}
	
	public void waitForVisibility(WebElement element,long waitaa) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitaa));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public  boolean waitForFileToDownload(String filePath, int timeoutInSeconds) {
	    boolean fileDownload = false;    
		File file = new File(filePath);
	        long end = System.currentTimeMillis() + timeoutInSeconds * 1000;
	        while (System.currentTimeMillis() < end) {
	            if (file.exists()) {
	                System.out.println("File is downloaded successfully.");
	                fileDownload=true;
	                return fileDownload;
	            }
	        }
	        throw new RuntimeException("Timeout waiting for file download.");
	    }

	public boolean isElementPresent(WebElement element) {
		boolean flag=false;
		if(element.isDisplayed())
		{
			return true;
		}
		return flag;
	}

	public void moveToElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public void actionClassClickElement(WebElement Element) throws InterruptedException
	{
		Actions actions = new Actions(driver);
		SHORT_TIMEOUT();
		actions.moveToElement(Element).click().perform();
	}
	
	
	public void dragAndDrop(WebElement sourceElement, WebElement targetElement) {
		Actions ac = new Actions(driver);
		ac.dragAndDrop(sourceElement, targetElement).perform();
	}
	
	public void dragAndDropByActionClass(WebElement source,WebElement target) {
		Actions ac = new Actions(driver);
		ac.clickAndHold(source).moveByOffset(0, 10).moveToElement(target).release().build().perform();
	}

	public void javascriptExecutorScrollElement(WebElement Element) throws InterruptedException
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		SHORT_TIMEOUT();
		jse.executeScript("arguments[0].scrollIntoView()", Element); 
	}
	
	public void javascriptExecutorScrollBy(int pixels) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        SHORT_TIMEOUT();
        jse.executeScript("window.scrollBy(0, arguments[0])", pixels);
    }
	
	public void javascriptExecutorClickElement(WebElement Element) throws InterruptedException
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		SHORT_TIMEOUT();
		jse.executeScript("arguments[0].click()", Element); 
	}


	public void SHORT_TIMEOUT() throws InterruptedException {
		Thread.sleep(1000);
	}

	public void TIMEOUT() throws InterruptedException {
		Thread.sleep(3000);
	}
	public void CUSTOME_TIMEOUT(int timeout) throws InterruptedException {
		Thread.sleep(timeout);
	}
	
	public void LONG_TIMEOUT() throws InterruptedException {
		Thread.sleep(20000);
	}

	public void implicitWait()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public String getText(WebElement element) {
		waitForVisibility(element, waitt);
		return element.getText();
	}

	public void ScrollToBottom() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println("Scroll Worked...");
	}
	public void scrollToBottom() {
        try {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
            Thread.sleep(500);  
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

	/**
	 * <b>Method to add screenshot in the JVM reports
	 */
	public void addScreenShotToReport(String screenShotName) {
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		Hooks.getScenario().attach(screenshot, "image/png",screenShotName);	
	}

	public String getDate(String string) {
        SimpleDateFormat sdf = new SimpleDateFormat(string);
        Date currentDate = new Date();
        String formattedDate = sdf.format(currentDate);
        return formattedDate;
	}
}
