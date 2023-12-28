package com.test.qa.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.test.qa.util.UtilClass;

public class HomePage {
	 WebDriver driver;
	UtilClass elementUtil;

	



	// HomePage Class Constructor
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.elementUtil = new UtilClass(driver);
	}// end


	

}// end of main class HomePage
