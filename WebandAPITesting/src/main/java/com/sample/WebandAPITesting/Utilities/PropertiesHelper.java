package com.sample.WebandAPITesting.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHelper {
	
	public static String getProperty(String fileName,String key){
		
		Properties prop = new Properties();
		InputStream input = null;
		String value="";

		try {
			if("config".equalsIgnoreCase(fileName)){
			input = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties");
			}else if("testdata".equalsIgnoreCase(fileName)){
				input = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\testdata.properties");	
			}
			prop.load(input);
			value=prop.getProperty(key);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return value;
		
	}

}
