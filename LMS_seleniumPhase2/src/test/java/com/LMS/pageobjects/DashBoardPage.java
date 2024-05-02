package com.LMS.pageobjects;

import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.LMS.utilities.ConfigReader;

public class DashBoardPage {
	
	
	  By LMSTitle = By.xpath("//mat-toolbar/span[text()=' LMS - Learning Management System ']");
	  By LMSHeader = By.xpath("//div[normalize-space()='Manage Program']");
	  By Batch_MENU = By.xpath("//span[normalize-space()='Batch']");
	
	 private WebDriver webDriver;
		ConfigReader Config = new ConfigReader();
	    Properties prop  = Config.init_prop();
	
    public DashBoardPage(WebDriver webDriver) {
        super();
        this.webDriver = webDriver;
    }
    public void getHeader() {
    	
        String actual = webDriver.findElement(LMSHeader).getText();
    	String expected = "Manage Program";
    	Assert.assertEquals(expected,actual);
        }
    public void getTitle() throws InterruptedException {
    Thread.sleep(100);	
    System.out.println("current page:"+webDriver.getCurrentUrl());	
    String actualTitle = webDriver.findElement(LMSTitle).getText();
    
	String expectedTitle = "LMS - Learning Management System";
	Assert.assertEquals(expectedTitle,actualTitle);
    }
    
    public int pageLoadTime() {   
    long start = System.currentTimeMillis();
    webDriver.get(prop.getProperty("dashboardurl"));
    long finish = System.currentTimeMillis();
    long totalTime = finish - start; 
    System.out.println("Total Time for page load - "+totalTime); 
    return (int) totalTime;
    
    }
    
    public boolean top_left_title() {
    	 WebElement titleElement = webDriver.findElement(LMSTitle);

         // Get the position of the title element relative to the top left corner of the page
         int titleXPosition = titleElement.getLocation().getX();
         int titleYPosition = titleElement.getLocation().getY();

         // Validate that the title is on the top left
         if (titleXPosition == 0 && titleYPosition == 0) {
             System.out.println("Title is located at the top left of the web application.");
             return true;
         } else {
             System.out.println("Title is not located at the top left of the web application.");
             return false;
         }
    }
    
    public boolean checkSpelling(String field) {

    	boolean match = false;

    	List<WebElement> myList = webDriver.findElements(By.xpath("//*[contains(text(),field)]"));
    	

    	for(WebElement we : myList){
    		for(int i = 0; i<myList.size() ; i++){
    			if(we.getText().equals(field)){

    				System.out.println("Matched" );
    				match = true;
    				
    			}
    		}
    	}
    	return match;
      }
    public  AddBatchPage click_batch() throws InterruptedException {
		 //webDriver.navigate().to(prop.getProperty("dashboardurl"));
		 Thread.sleep(10);
		 
		 webDriver.findElement(Batch_MENU).click();
		 return new AddBatchPage(webDriver);
		 
	 }
}
