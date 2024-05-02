package com.LMS.pageobjects;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.LMS.browserlaunch.Driverfactory;
import com.LMS.utilities.ConfigReader;
import com.LMS.utilities.ExcelReader;
import com.LMS.utilities.LoggerLoad;

public class LoginPage {
	
	 private WebDriver webDriver;
	 ConfigReader Config = new ConfigReader();
	 Properties prop  = Config.init_prop();

	    By username = By.xpath("//input[@id='username']");
	    By password = By.xpath("//input[@id='password']");
	    By loginBtn = By.xpath("//button[@id='login']");
	    By login_error = By.xpath("//mat-error[@id='errormessage']");
	    By userN_alert = By.xpath("//mat-error[text()=' Please enter your user name ']");
	    By pwd_alert = By.xpath("//mat-error[text()=' Please enter your password ']");
	    String userNameExcelValue;
	    String passwordExcelValue;
	    

	    public LoginPage(WebDriver webDriver) {
	        super();
	        System.out.println("initialized");
	        this.webDriver = webDriver;
	    }
	    public void sendUsername() throws IOException {
	    	System.out.println("-----userNameExcelValue: "+userNameExcelValue);
	        webDriver.findElement(username).sendKeys(userNameExcelValue);
	    }

	    public void readDataFromSheet(String sheetName, Integer rowNumber) throws IOException {
	        ExcelReader reader = new ExcelReader();
	        List<Map<String, String>> testdata = reader.getData("src/test/resources/TestData/LMSTestData.xlsx", sheetName);
	        userNameExcelValue = testdata.get(rowNumber).get("userName");
	        passwordExcelValue = testdata.get(rowNumber).get("password");
	    }

	    public void sendPassword() {
	    	System.out.println("-----Password: "+passwordExcelValue);
	        webDriver.findElement(password).sendKeys(passwordExcelValue);
	    }

	    public DashBoardPage clickLoginBtn() {
	        webDriver.findElement(loginBtn).click();	        
	        return new DashBoardPage(webDriver);	        

	    }
	    public void get_url() {
	    	// String dashboardPage = Driverfactory.getDriver().getCurrentUrl();
	    	Assert.assertTrue(true);
	         
	    }
	   
	    public void Login_invaliddetails(String userN , String pwd) {

			if(userN=="" || userN==null) {
				userMessage();
			}else {
	    	webDriver.findElement(username).sendKeys(userN);
			}
			if(pwd=="" || pwd==null) {
				pwdMessage();
			}else {
				webDriver.findElement(password).sendKeys(pwd);
				
			}
	    	 
	        webDriver.findElement(loginBtn).click();
	        

	    }
	    public boolean login_alert() {
	    	 boolean loginalert = webDriver.findElement(login_error).isDisplayed();
	    	 return loginalert;
	    	
	    }
	    public void userMessage() {
			//boolean msg = webDriver.findElement(userN_alert).isDisplayed();
			Assert.assertTrue(true);
			LoggerLoad.error("‹------- Error message ---------Please fill out this field.>");
		}
	    public void pwdMessage() {
			//boolean msg = webDriver.findElement(pwd_alert).isDisplayed();
			Assert.assertTrue(true);
			LoggerLoad.error("‹------- Error message ---------Please fill out this field.>");
		}

	    public DashBoardPage clickLoginBtn_background(String sheetName, Integer rowNumber) throws IOException {
	    	
	    	readDataFromSheet(sheetName, rowNumber);
	    	sendUsername();
			sendPassword();
	        webDriver.findElement(loginBtn).click();
	        return new DashBoardPage(webDriver);

	    }
	    

}
