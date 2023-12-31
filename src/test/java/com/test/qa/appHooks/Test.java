package com.test.qa.appHooks;
import com.github.webdriverextensions.WebDriverExtensionsContext;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.github.webdriverextensions.WebDriverExtensionsContext;
import com.google.api.client.util.Key;

import org.openqa.selenium.Point;
public class Test {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.get("https://qaportal.intelligencenode.com/?app_key=9fb211ff9d4e64a7fc09fda6661d5ef7#!/relationship-chart");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	 WebElement draggable = driver.findElement(By.xpath("(//div[@id='single-button'])[2]"));
     WebElement droppable = driver.findElement(By.xpath("//div[@dnd-list='xAxisSelectionList']"));
     Actions ac = new Actions(driver);
     ac.clickAndHold(draggable).moveByOffset(0, 10).moveToElement(droppable).release().build().perform();
     
     Thread.sleep(10000);
}
}
