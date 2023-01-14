package com.test.qa.main;

//imports
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/*
 * Class namely CreateCucumberOptions is a class, involving functions performing different operations related to 
 * external user input through file. 
 */

public class CreateCucumberOptions {

	public static Properties prop;
	private static final String KEY = "cucumber.options";
	public void loadPropertiesFile(){
		System.out.println("in loadproperties file");
		FileInputStream input;  
		try{
			prop=new Properties();
			input=new FileInputStream(System.getProperty("user.dir") + "/cucumberOptions.properties");
			prop.load(input);
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			/*if(input!=null) {
	            try {
	                input.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }*/
			//}
		}
	}//end

	public String createAndGetCucumberOption(){       
		System.out.println("in create and get cucumber option method");
		StringBuilder sb = new StringBuilder();
		System.out.println(sb);
		String featureFilesPath = 
				prop.getProperty("cucumber.options.feature");
		System.out.println(featureFilesPath);

		String htmlOutputReport = 
				prop.getProperty("cucumber.options.report.html");
		System.out.println(htmlOutputReport);

		String jsonReport=
				prop.getProperty("cucumber.options.report.json");

		String xmlReport=
				prop.getProperty("cucumber.options.report.xml");
	
		sb.append(htmlOutputReport);
		sb.append(" ");
		sb.append(jsonReport);
		sb.append(" ");
		sb.append(xmlReport);
		sb.append(" ");
		sb.append(featureFilesPath);
	
		System.out.println(sb);
		return sb.toString();
	}//end

	public void setOptions(){
		System.out.println("in set options");
		String value=createAndGetCucumberOption();
		System.out.println("Value " + value);
		System.setProperty(KEY, value);
	}//end







}//end of main class CreateCucumberOptions
