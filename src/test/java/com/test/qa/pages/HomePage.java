package com.test.qa.pages;

import org.openqa.selenium.NoSuchElementException;

/*
 * Class Description :
 * Class namely HomePage is a class involving different methods which are used to navigate to different menus
 * in YES BANK TPH Application
 */

//imports
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.qa.util.ElementUtil;

public class HomePage {
	private WebDriver driver;
	ElementUtil elementUtil;

	



	// HomePage Class Constructor
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.elementUtil = new ElementUtil(driver);
	}// end


	

}// end of main class HomePage
