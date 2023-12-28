package com.test.qa.util;

import java.io.File;
//imports
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FileReadUtils {

	/*
	 * Class Description : Class namely FileReadUtils is a generic class for all
	 * Menus in the application which is used to read the excel workbook,sheet once
	 * get data from it and forward the data back so that it can be used wherever
	 * required
	 */

	private WebDriver driver;
	ElementUtil elementUtils;
	ExcelReader excelReader = new ExcelReader();
	List<Map<String, String>> testData;
	String Commonpath = ""+File.separator+"src"+File.separator+"test"+File.separator+"java"+File.separator+"com"+File.separator+"yesbank"+File.separator+"qa"+File.separator+"config";

	// constructor of FileReadUtils Page
	public FileReadUtils(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;
	}// end of constructor

	// Generic Method to read excel sheet data from BeneficiaryMaintenance.xlsx
	public List<Map<String, String>> readBeneficiaryMaintenanceExcel(String SheetName)
			throws InvalidFormatException, IOException {
		testData = excelReader.getData(
				System.getProperty("user.dir") + ""+Commonpath+"/BeneficiaryMaintenance.xlsx",
				SheetName);

		return testData;
	}// end of readBeneficiaryMaintenanceExcel function

	// Generic Method to read excel sheet data from DBLoads.xlsx
	public List<Map<String, String>> readDBLoadsExcel(String SheetName) throws InvalidFormatException, IOException {
		testData = excelReader.getData(
				System.getProperty("user.dir") + ""+Commonpath+"/DBLoads.xlsx", SheetName);

		return testData;
	}// end of readDBLoadsExcel function

	// Generic Method to read excel sheet data from PurposeCode.xlsx
	public List<Map<String, String>> readPurposeCodeExcel(String SheetName) throws InvalidFormatException, IOException {
		testData = excelReader.getData(
				System.getProperty("user.dir") + ""+Commonpath+"/PurposeCode.xlsx", SheetName);

		return testData;
	}// end of readPurposeCodeExcel function

	// Generic Method to read excel sheet data from Customer.xlsx
	public List<Map<String, String>> readCustomerExcel(String SheetName) throws InvalidFormatException, IOException {
		testData = excelReader.getData(
				System.getProperty("user.dir") + ""+Commonpath+"/Customer.xlsx", SheetName);

		return testData;
	}// end of readCustomerExcel function

	// Generic Method to read excel sheet data from Accounts.xlsx
	public List<Map<String, String>> readAccountsExcel(String SheetName) throws InvalidFormatException, IOException {
		testData = excelReader.getData(
				System.getProperty("user.dir") + ""+Commonpath+"/Accounts.xlsx", SheetName);

		return testData;
	}// end of readAccountsExcel function

	// Generic Method to read excel sheet data from Accounts.xlsx
	public List<Map<String, String>> readDealerExcel(String SheetName) throws InvalidFormatException, IOException {
		testData = excelReader.getData(
				System.getProperty("user.dir") + ""+Commonpath+"/MasterDataMaintenance.xlsx", SheetName);

		return testData;
	}// end of readAccountsExcel function

	// Generic Method to read excel sheet data from IFSC_CODE.xlsx
	public List<Map<String, String>> readIFSCCodeExcel(String SheetName) throws InvalidFormatException, IOException {
		testData = excelReader.getData(
				System.getProperty("user.dir") + ""+Commonpath+"/IFSCCode.xlsx", SheetName);

		return testData;
	}// end of readIFSCCodeExcel function

	// Generic Method to read excel sheet data from NEFTOutwardPaymentFlow_NOC.xlsx
	public List<Map<String, String>> readNEFTOutwardPaymentFlowExcel_NOC(String SheetName)
			throws InvalidFormatException, IOException {
		System.out.println("in read excel function");
		testData = excelReader.getData(
				System.getProperty("user.dir") + ""+Commonpath+"/NEFTOutwardPaymentFlow_NOC.xlsx",SheetName);

		return testData;
	}// end of readNEFTOutwardPaymentFlowExcel_NOC function

	// Generic Method to read excel sheet data from NEFTOutwardPaymentFlow_IGTB.xlsx
	public List<Map<String, String>> readNEFTOutwardPaymentFlowExcel_IGTB(String SheetName)
			throws InvalidFormatException, IOException {
		testData = excelReader.getData(System.getProperty("user.dir")
				+ ""+Commonpath+"/NEFTOutwardPaymentFlow_IGTB.xlsx", SheetName);

		return testData;
	}// end of readNEFTOutwardPaymentFlowExcel_IGTB function

	// Generic Method to read excel sheet data from
	// NEFTOutwardPaymentFlow_Branch.xlsx
	public List<Map<String, String>> readNEFTOutwardPaymentFlowExcel_Branch(String SheetName)
			throws InvalidFormatException, IOException {
		testData = excelReader.getData(System.getProperty("user.dir")
				+ ""+Commonpath+"/NEFTOutwardPaymentFlow_Branch.xlsx", SheetName);

		return testData;
	}// end of readNEFTOutwardPaymentFlowExcel_Branch function

	// Generic Method to read excel sheet data from
	// NEFTInwardPaymentFlowAccTypeNRE.xlsx
	public List<Map<String, String>> readNEFTInwardPaymentFlowExcel_NRE(String SheetName)
			throws InvalidFormatException, IOException {
		testData = excelReader.getData(System.getProperty("user.dir")
				+ ""+Commonpath+"/NEFTInwardPaymentFlow_AccTypeNRE.xlsx", SheetName);

		return testData;
	}// end of readNEFTInwardPaymentFlowExcel_NRE function

	// Generic Method to read excel sheet data from
	// NEFTInwardPaymentFlow_AccTypeCESC.xlsx
	public List<Map<String, String>> readNEFTInwardPaymentFlowExcel_CESC(String SheetName)
			throws InvalidFormatException, IOException {
		testData = excelReader.getData(System.getProperty("user.dir")
				+ ""+Commonpath+"/NEFTInwardPaymentFlow_AccTypeCESC.xlsx", SheetName);

		return testData;
	}// end of readNEFTInwardPaymentFlowExcel_CESC function

	// Generic Method to read excel sheet data from
	// NEFTInwardPaymentFlow_AccTypeEcollectsubmember.xlsx
	public List<Map<String, String>> readNEFTInwardPaymentFlowExcel_EcollectSubmember(String SheetName)
			throws InvalidFormatException, IOException {
		testData = excelReader.getData(
				System.getProperty("user.dir")
				+ ""+Commonpath+"/NEFTInwardPaymentFlow_AccTypeEcollectSubmember.xlsx",
				SheetName);
		return testData;
	}// end of readNEFTInwardPaymentFlowExcel_EcollectSubmember function

	// Generic Method to read excel sheet data from
	// NEFTInwardPaymentFlow_AccTypeFCRA.xlsx
	public List<Map<String, String>> readNEFTInwardPaymentFlowExcel_FCRA(String SheetName)
			throws InvalidFormatException, IOException {
		testData = excelReader.getData(System.getProperty("user.dir")
				+ ""+Commonpath+"/NEFTInwardPaymentFlow_AccTypeFCRA.xlsx", SheetName);

		return testData;
	}// end of readNEFTInwardPaymentFlowExcel_FCRA function

	// Generic Method to read excel sheet data from
	// NEFTInwardPaymentFlowAccTypeNRE.xlsx
	public List<Map<String, String>> readNEFTInwardPaymentFlowExcel_GL(String SheetName)
			throws InvalidFormatException, IOException {
		testData = excelReader.getData(System.getProperty("user.dir")
				+ ""+Commonpath+"/NEFTInwardPaymentFlow_AccTypeGL.xlsx", SheetName);

		return testData;
	}// end of readNEFTInwardPaymentFlowExcel_GL function

	// Generic Method to read excel sheet data from
	// NEFTInwardPaymentFlow_AccTypeEEFC_FD_RD.xlsx
	public List<Map<String, String>> readNEFTInwardPaymentFlowExcel_EEFC_FD_RD(String SheetName)
			throws InvalidFormatException, IOException {
		testData = excelReader.getData(
				System.getProperty("user.dir")
				+ ""+Commonpath+"/NEFTInwardPaymentFlow_AccTypeEEFC_FD_RD.xlsx",
				SheetName);

		return testData;
	}// end of NEFTInwardPaymentFlow_AccTypeEEFC_FD_RD function

	// Generic Method to read excel sheet data from
	// NEFTInwardPaymentFlow_AccTypeCASA.xlsx
	public List<Map<String, String>> readNEFTInwardPaymentFlowExcel_CASA(String SheetName)
			throws InvalidFormatException, IOException {
		testData = excelReader.getData(System.getProperty("user.dir")
				+ ""+Commonpath+"/NEFTInwardPaymentFlow_AccTypeCASA.xlsx", SheetName);

		return testData;
	}// end of NEFTInwardPaymentFlow_AccTypeCASA function

	// Generic Method to read excel sheet data from
	// NEFTOutwardPaymentValidationFlow_BranchValidation.xlsx
	public List<Map<String, String>> readNEFTOutwardPaymentValidationFlowExcel_Branch(String sheetName)
			throws InvalidFormatException, IOException {
		testData = excelReader.getData(
				System.getProperty("user.dir")
				+ ""+Commonpath+"/NEFTOutwardPaymentValidationFlow_Branch.xlsx",
				sheetName);

		return testData;
	}// end of readNEFTOutwardPaymentValidationFlowExcel_Branch function

	// Generic Method to read excel sheet data from
	// NEFTOutwardPaymentValidation_IGTB.xlsx
	public List<Map<String, String>> readNEFTOutwardPaymentValidationExcel_IGTB(String SheetName)
			throws InvalidFormatException, IOException {
		testData = excelReader.getData(System.getProperty("user.dir")
				+ ""+Commonpath+"/NEFTOutwardPaymentValidation_IGTB.xlsx", SheetName);

		return testData;
	}// end of readNEFTOutwardPaymentValidationExcel_IGTB function

	// Generic Method to read excel sheet data from
	// NEFTOutwardPaymentValidation_NOC.xlsx
	public List<Map<String, String>> readNEFTOutwardPaymentValidationExcel_NOC(String SheetName)
			throws InvalidFormatException, IOException {
		System.out.println("in read excel function");
		testData = excelReader.getData(System.getProperty("user.dir")
				+ ""+Commonpath+"/NEFTOutwardPaymentValidation_NOC.xlsx", SheetName);

		return testData;
	}// end of readNEFTOutwardPaymentValidationExcel_NOC function

	// Generic Method to read excel sheet data from NEFTInwardPaymentFlowExcel.xlsx
	public List<Map<String, String>> readNEFTInwardPaymentFlowExcel(String SheetName)
			throws InvalidFormatException, IOException {
		testData = excelReader.getData(System.getProperty("user.dir")
				+ ""+Commonpath+"/NEFTInwardPaymentFlow_QualifyReceive.xlsx", SheetName);

		return testData;
	}// end of readNEFTInwardPaymentFlowExcel function

	// Generic Method to read excel sheet data from Setup.xlsx
	public List<Map<String, String>> readSetupExcel(String SheetName) throws InvalidFormatException, IOException {
		System.out.println("in read excel function");
		testData = excelReader
				.getData(System.getProperty("user.dir") + ""+Commonpath+"/Setup.xlsx", SheetName);

		return testData;
	}//

	// Generic Method to read excel sheet data from
	// NEFTInwardPaymentValidationFlow.xlsx
	public List<Map<String, String>> readNEFTInwardPaymentValidationFlowExcel(String SheetName)
			throws InvalidFormatException, IOException {
		testData = excelReader.getData(System.getProperty("user.dir")
				+ ""+Commonpath+"/NEFTInwardPaymentValidationFlow.xlsx", SheetName);

		return testData;
	}// end of readNEFTInwardPaymentValidationFlowExcel function

	// Generic Method to read excel sheet data from MasterDataMaintenance.xlsx
	public List<Map<String, String>> readMasterDataMaintenanceExcel(String SheetName)
			throws InvalidFormatException, IOException {
		testData = excelReader.getData(
				System.getProperty("user.dir") + ""+Commonpath+"/MasterDataMaintenance.xlsx", SheetName);

		return testData;
	}// end of readMasterDataMaintenanceExcel function
	
	// Generic Method to read excel sheet data from
	// BlockList_Account.xlsx
	public List<Map<String, String>> readBlockListAccountExcel(String SheetName)
			throws InvalidFormatException, IOException {
		testData = excelReader.getData(
				System.getProperty("user.dir") + ""+Commonpath+"/BlockList_Account.xlsx",
				SheetName);

		return testData;
	}// end of readBlockListAccountExcel function
	
	// Generic Method to read excel sheet data from
		// NEFTOutwardPaymentFlow_Branch_LMT.xlsx
		public List<Map<String, String>> readNEFTOutwardPaymentFlow_Branch_LMT(String SheetName)
				throws InvalidFormatException, IOException {
			testData = excelReader.getData(
					System.getProperty("user.dir")  + ""+Commonpath+"/NEFTOutwardPaymentFlow_Branch_LMT.xlsx",
					SheetName);

			return testData;
		}// end of readNEFTOutwardPaymentFlow_Branch function
//	NEFTOutwardPaymentFlow_Branch_LMT.xlsx

}// end of main class FileReadUtils
