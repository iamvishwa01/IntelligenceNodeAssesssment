package com.test.qa.util;

import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class ReadExcelData {

	    public static int getRowCount(String filePath) throws IOException, CsvValidationException {
	        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
	            int rowCount = 0;
	            String[] nextLine;
	            while ((nextLine = csvReader.readNext()) != null) {
	                for (String field : nextLine) {
	                    if (!field.isEmpty()) {
	                        rowCount++;
	                        break;
	                    }
	                }
	            }
	            return rowCount-1;
	        }
	    }
	
	
}
