package com.LMS.pageobjects;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserPageValidationPage
{

	private WebDriver webDriver;
	
    By user = By.xpath("//button[@id='user']");
    By header = By.xpath("//html/body/app-root/app-user/div/mat-card/mat-card-title/div[1]");
    By PaginationSize = By.xpath("/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/p-paginator/div/span[2]/button[1]");
    
    By PaginationText = By.xpath("//span[@class='p-paginator-pages ng-star-inserted']");
    By id = By.xpath("//th[normalize-space()='ID']");
    By name = By.xpath("//th[normalize-space()='Name']");    
    By loc = By.xpath("//th[normalize-space()='Location']");
    By phoneno = By.xpath("//th[normalize-space()='Phone Number']");
    By editdelete= By.xpath("//th[normalize-space()='Edit / Delete']");
    By deletemain = By.xpath("//button[@class='p-button-danger p-button p-component p-button-icon-only']");
    By addnewuser = By.xpath("//span[text()='Add New User']");		
    By Verifysearch = By.xpath("//input[@id='filterGlobal']");
    By assignstudent = By.xpath("//span[text()='Assign Student']");
    By assignstaff = By.xpath("//span[text()='Assign Staff']");
    By entries = By.xpath("//span[text()='Showing 0 to 0 of 0 entries']");
    By paginationentry = By.xpath("//span[text()='Showing 1 to 5 of 396 entries']");
    By RowCount = By.xpath("//table[@role='grid']//tr//td[1]");
    
    By chkbox1 = By.xpath("//tbody/tr[1]/td[1]/p-tablecheckbox[1]/div[1]/div[2]");
    By chkbox2 = By.xpath("//tbody/tr[2]/td[1]/p-tablecheckbox[1]/div[1]/div[2]");
    By chkbox3 = By.xpath("//tbody/tr[3]/td[1]/p-tablecheckbox[1]/div[1]/div[2]");
    By chkbox4 = By.xpath("//tbody/tr[4]/td[1]/p-tablecheckbox[1]/div[1]/div[2]");
    By chkbox5 = By.xpath("//tbody/tr[5]/td[1]/p-tablecheckbox[1]/div[1]/div[2]");
    
    By editcolumn1 = By.xpath("//tbody/tr[1]/td[6]/div[1]/span[1]/button[1]/span[1]");
    By editcolumn2 = By.xpath("//tbody/tr[2]/td[6]/div[1]/span[1]/button[1]/span[1]");
    By editcolumn3 = By.xpath("//tbody/tr[3]/td[6]/div[1]/span[1]/button[1]/span[1]");
    By editcolumn4 = By.xpath("//tbody/tr[4]/td[6]/div[1]/span[1]/button[1]/span[1]");
    By editcolumn5 = By.xpath("//tbody/tr[5]/td[6]/div[1]/span[1]/button[1]/span[1]");
    
    By delcolumn1 = By.xpath("//tbody/tr[1]/td[6]/div[1]/span[1]/button[2]/span[1]");
    By delcolumn2 = By.xpath("//tbody/tr[2]/td[6]/div[1]/span[1]/button[2]/span[1]");
    By delcolumn3 = By.xpath("//tbody/tr[3]/td[6]/div[1]/span[1]/button[2]/span[1]");
    By delcolumn4 = By.xpath("//tbody/tr[4]/td[6]/div[1]/span[1]/button[2]/span[1]");
    By delcolumn5 = By.xpath("//tbody/tr[5]/td[6]/div[1]/span[1]/button[2]/span[1]");
    
	public UserPageValidationPage(WebDriver webDriver)
	 {
	        super();
	        System.out.println("initialized");
	        this.webDriver = webDriver;
	    }
	public void GetStartedClick()
	{
		webDriver.findElement(user).click();
		
	}	
	public String Header() 
	{
		String headertext = webDriver.findElement(header).getText();
		return headertext;
	}
	public String findPaginationText()
	{
		webDriver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		String pgtext = webDriver.findElement(PaginationText).getText();
		
		return pgtext;
		
	}
	public boolean VerifyColumns()
	{
		 boolean verifycolumns = (webDriver.findElement(id).isDisplayed()&&webDriver.findElement(name).isDisplayed()
		 &&webDriver.findElement(loc).isDisplayed()&&webDriver.findElement(phoneno).isDisplayed()&&webDriver.findElement(editdelete).isDisplayed());
		 return verifycolumns;
	}
	
	public boolean checkdisabled() 
	{
		boolean delstatus = webDriver.findElement(deletemain).isEnabled();
		return delstatus;
	}
	public boolean NewUserButton() {
		boolean NewUser = webDriver.findElement(addnewuser).isDisplayed();
		return NewUser;
	}
	public boolean assignStudentButton() {
		boolean assignStudent = webDriver.findElement(assignstudent).isDisplayed();
		return assignStudent;
	}
	public boolean assignStaffButton() {
		boolean assignStaff = webDriver.findElement(assignstaff).isDisplayed();
		return assignStaff;
	}
	
	public boolean Verifysearch() {
		boolean VerifySearchbox = webDriver.findElement(Verifysearch).isDisplayed();
		return VerifySearchbox ;
	}
	public String FindSearchText() {
		String printsearch = webDriver.findElement(Verifysearch).getAttribute("placeholder");
		return printsearch;		
	}
	
	public String getUrl() {
		
			String url=webDriver.getCurrentUrl();
			return url;
	}
	
	public int FindRowsCount() {
		List<WebElement> rowcount = webDriver.findElements(RowCount);
		int RCount = rowcount.size();
		return RCount;
	}
	public boolean VerifyCheckBox()
	{
		boolean chkbox = (webDriver.findElement(chkbox1).isDisplayed()&&webDriver.findElement(chkbox2).isDisplayed()
				 &&webDriver.findElement(chkbox3).isDisplayed()&&webDriver.findElement(chkbox4).isDisplayed()&&webDriver.findElement(chkbox5).isDisplayed());
				 return chkbox; 
	}
	
	public boolean VerifyEditButton()
	{
		boolean editbutton = (webDriver.findElement(editcolumn1).isDisplayed()&&webDriver.findElement(editcolumn2).isDisplayed()
				 &&webDriver.findElement(editcolumn3).isDisplayed()&&webDriver.findElement(editcolumn4).isDisplayed()&&webDriver.findElement(editcolumn5).isDisplayed());
				 return editbutton; 
	}
	public boolean VerifyDelButton() {
		boolean delbutton = (webDriver.findElement(delcolumn1).isDisplayed()&&webDriver.findElement(delcolumn2).isDisplayed()
				 &&webDriver.findElement(delcolumn3).isDisplayed()&&webDriver.findElement(delcolumn4).isDisplayed()&&webDriver.findElement(delcolumn5).isDisplayed());
				 return delbutton; 
		
	}
	public void invalidsearch()
	{
		webDriver.findElement(Verifysearch).sendKeys("UIHackathon@02");	
	}
	public String displaymsg()
	{
		String text = webDriver.findElement(entries).getText();
	    return text;
	}
	public String displaymsg1()
	{
		String text1 = webDriver.findElement(paginationentry).getText();
	    return text1;
	}
	public boolean VerifySearchName()
	{
		boolean VerifySearchname = webDriver.findElement(name).isDisplayed();
		return VerifySearchname;
		
	}
	
	}
	
	

