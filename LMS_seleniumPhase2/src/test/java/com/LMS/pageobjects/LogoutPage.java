package com.LMS.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	
	private WebDriver webDriver;
	
	By Logout_Button = By.xpath("//mat-toolbar/button[4][@id='logout']");
	
	 public LogoutPage(WebDriver webDriver) {
	        super();
	        this.webDriver = webDriver;
	        PageFactory.initElements(webDriver,this);
	    }
	 
	 public void signout_click() throws InterruptedException {
		  Thread.sleep(30);  
		 webDriver.findElement(Logout_Button).click();
		 
	 }

}
