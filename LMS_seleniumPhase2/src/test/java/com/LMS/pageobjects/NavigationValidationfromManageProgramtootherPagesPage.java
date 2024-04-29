package com.LMS.pageobjects;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.LMS.utilities.ExcelReader;

public class NavigationValidationfromManageProgramtootherPagesPage {

	private WebDriver webDriver;  
	
    By username = By.xpath("//input[@id='username']");
    By password = By.xpath("//input[@id='password']");
    By loginBtn = By.xpath("//span[@class='mat-button-wrapper']");
    String userNameExcelValue;
    String passwordExcelValue;
    public By batchbtn = By.xpath("//span[normalize-space()='Batch']");
    public By userbtn = By.xpath("//span[normalize-space()='User']");

    	public DashBoardPage clickLoginBtn_background(String sheetName, Integer rowNumber) throws IOException {
    	     
    	     readDataFromSheet(sheetName, rowNumber);
    	     sendUsername();
    	     sendPassword();
    	     webDriver.findElement(loginBtn).click();
    	     return new DashBoardPage(webDriver);     }
	   
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
	
	 public NavigationValidationfromManageProgramtootherPagesPage(WebDriver webDriver) {
	        super();
	        this.webDriver = webDriver;
	        PageFactory.initElements(webDriver,this);
	    }

	public void clickbatchbtn() {
		webDriver.findElement(batchbtn).click(); //SM: To find xpath for batch link
		
	}


	public String getbatchUrl() {
		// TODO Auto-generated method stub
		String batchurl=webDriver.getCurrentUrl();
		return batchurl;
	}
	
	public void clickuserbtn() {
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		webDriver.findElement(userbtn).click(); 
		
	}

	public String getuserUrl() {
		// TODO Auto-generated method stub
		String userurl=webDriver.getCurrentUrl();
		return userurl;
	}
	 
	 
}
