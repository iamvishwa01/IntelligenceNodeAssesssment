package com.test.qa.util;

import java.io.File;
//imports
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ExcelReadUtils {
	WebDriver driver;
	UtilClass elementUtils;
	ReadExcelData excelReader = new ReadExcelData();
	List<Map<String, String>> testData;
	String Commonpath = ""+File.separator+"src"+File.separator+"test"+File.separator+"java"+File.separator+"com"+File.separator+"yesbank"+File.separator+"qa"+File.separator+"config";

	public ExcelReadUtils(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public List<Map<String, String>> readBeneficiaryMaintenanceExcel(String SheetName)
			throws InvalidFormatException, IOException {
		testData = excelReader.getData(
				System.getProperty("user.dir") + ""+Commonpath+"/BeneficiaryMaintenance.xlsx",
				SheetName);
		return testData;
	}

	

}
