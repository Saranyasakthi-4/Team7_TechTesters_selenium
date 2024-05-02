package com.LMS.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
		// Properties pro;
		  private static Properties prop;

		    public Properties init_prop() {
		        prop = new Properties();
		        try {
		            FileInputStream ip = new FileInputStream("./src/test/resources/configuration/config.properties");
		            prop.load(ip);
		        } catch (FileNotFoundException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        } catch (IOException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
		        return prop;
		    }

		
	    //get URL from config                    
		public String getApplicationURL() {
			String url = prop.getProperty("url");
			return url;
		}
		  //get Invalid URL from config                    
				public String getInvalid_ApplicationURL() {
					String invalidurl = prop.getProperty("invalidurl");
					return invalidurl;
				}
		
		//get browser from config
		public String getbrowser() {
			String browser = prop.getProperty("browser");
			return browser;
		}
		
		//get XLPath from config
		public String getXlpath() {
			String xlPath = prop.getProperty("Xlpath");
			return xlPath;
		}

		
	}




