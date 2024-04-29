package com.LMS.pageobjects;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.LMS.utilities.ExcelReader;

public class LoginPage {
	
	 private WebDriver webDriver;

	    By username = By.xpath("//input[@id='username']");
	    By password = By.xpath("//input[@id='password']");
	    By loginBtn = By.xpath("//span[@class='mat-button-wrapper']");
	    String userNameExcelValue;
	    String passwordExcelValue;
	    
	    public DashBoardPage clickLoginBtn_background(String sheetName, Integer rowNumber) throws IOException {
	        
	        readDataFromSheet(sheetName, rowNumber);
	        sendUsername();
	   sendPassword();
	           webDriver.findElement(loginBtn).click();
	           return new DashBoardPage(webDriver);     }


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

}
