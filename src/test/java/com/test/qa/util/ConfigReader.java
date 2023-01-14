package com.test.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @Author -- Pranjal Mudhalwadkar
 **/
public class ConfigReader {

	public Properties prop;

	public Properties init_prop() {

		prop = new Properties();

		try {
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/com/test/qa/config/config.properties");
			prop.load(ip);
//			System.out.println("Config data loaded");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;

	}
}
