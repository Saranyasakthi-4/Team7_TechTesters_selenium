package com.LMS.pageobjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.LMS.utilities.ExcelReader;
import com.mongodb.assertions.Assertions;

public class Program {
	private WebDriver webDriver;
	
	By program = By.xpath("//button[@id='program']");
	By newProgram = By.xpath("//button[@id='new']");
	By save =By.xpath("//span[text()='Save']");
	By cancel =By.xpath("//span[text()='Cancel']");
	By close =By.xpath("//div[@class='p-dialog-header-icons ng-tns-c132-3']/button");
	By pName = By.xpath("//input[@id='programName']");
	By pDesc = By.xpath("//input[@id='programDescription']");
	By pNmaeMsg = By.xpath("//small[text()='Program name is required.']");
	By pDescMsg = By.xpath("//small[text()='Description is required.']");
	By closeBtn = By.xpath("//button[@tabindex='-1']");
	By radio = By.xpath("//div[@class='p-radiobutton p-component']");
	By invalidMsg = By.xpath("//small[contains(text(),'no special char')]");
	By editProgram = By.xpath("//tbody[@class='p-datatable-tbody']/tr[1]/td[5]/div[1]/span[1]/button[1]");
	By searchBtn = By.xpath("//input[@id='filterGlobal']");
	By noPrograms = By.xpath("//div[@class='p-datatable-footer ng-star-inserted']/div");
	By deleteProgram = By.xpath("//tbody/tr[1]/td[5]/div[1]/span[1]/button[2]/span[1]");
	By checkProgram = By.xpath("//tbody/tr[2]/td[1]/p-tablecheckbox[1]/div[1]/div[2]");
	By checkSecondProgram = By.xpath("//tbody/tr[1]/td[1]/p-tablecheckbox[1]/div[1]/div[2]");
	By commonDelete = By.xpath("//button[@class='p-button-danger p-button p-component p-button-icon-only']//span[@class='p-button-icon pi pi-trash']");
	String programNameExcelValue;
	String programDescExcelValue;
	String editInvalidMsg;
	
	public Program(WebDriver webDriver) {
        super();
        this.webDriver = webDriver;
    }
	
	public void clickProgramBtn() {
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        webDriver.findElement(program).click();
       
    }
	public void clickAddNewProgram() {
        webDriver.findElement(newProgram).click();
       
    }
	
	public void checkSaveCloseCancel() {

		boolean isSavePresent = webDriver.findElement(save).isDisplayed();
		Assert.assertTrue(isSavePresent);
		boolean isCancelPresent = webDriver.findElement(cancel).isDisplayed();
		Assert.assertTrue(isCancelPresent);
		//boolean isClosePresent = webDriver.findElement(close).isDisplayed();
		//Assert.assertTrue(isSavePresent);
    }
	public void checkInputFileds() {

		boolean isPnamePresent = webDriver.findElement(pName).isDisplayed();
		Assert.assertTrue(isPnamePresent);
		boolean isPdescPresent = webDriver.findElement(pDesc).isDisplayed();
		Assert.assertTrue(isPdescPresent);
		//boolean isClosePresent = webDriver.findElement(close).isDisplayed();
		//Assert.assertTrue(isSavePresent);
    }
	public void clickEmptySave() {
        webDriver.findElement(save).click();
        webDriver.findElement(closeBtn).click();
    }
	public void getErrorMsg() {

		String errorMsg= "Program name is required.";
		String actualMsg= webDriver.findElement(pNmaeMsg).getText();
		//System.out.println(actualMsg);
		Assert.assertEquals(errorMsg, actualMsg);
    }
	public void clickSavePNAme() {
		clickAddNewProgram();
		webDriver.findElement(pName).sendKeys("LMSProgram");
        webDriver.findElement(save).click();
        webDriver.findElement(closeBtn).click();
    }
	public void SearchProgram() {
		
		webDriver.findElement(searchBtn).sendKeys("Team7");
		
		 webDriver.findElement(editProgram).click();
       // webDriver.findElement(save).click();
        //webDriver.findElement(closeBtn).click();
    }
	public void clickEditProgram() {
		
        webDriver.findElement(editProgram).click();
       
    }
	public void clickEditProgramName() {
		String getPname="";
        webDriver.findElement(editProgram).click();
        getPname=webDriver.findElement(pName).getAttribute("value");
      		System.out.println("the current program name is "+getPname);
      		webDriver.findElement(pName).sendKeys("Edited");
      		//webDriver.findElement(save).click();
    }
	public void clickEditProgramDesc() {
		String getPdesc="";
        webDriver.findElement(editProgram).click();
        getPdesc=webDriver.findElement(pDesc).getAttribute("value");
		System.out.println("the current program desc is "+getPdesc);
		webDriver.findElement(pDesc).sendKeys("Edited");
		webDriver.findElement(save).click();
    }
	
	public void needDescMsg() {

		String errorMsg= "Description is required.";
		String actualMsg= webDriver.findElement(pDescMsg).getText();
		//System.out.println(actualMsg);
		Assert.assertEquals(errorMsg, actualMsg);
    }
	public void clickSavePDesc() {
		clickAddNewProgram();
		webDriver.findElement(pDesc).sendKeys("SeleniumAutomation");
        webDriver.findElement(save).click();
        webDriver.findElement(closeBtn).click();
    }
	public void needPNameMsg() {

		String errorMsg= "Program name is required.";
		String actualMsg= webDriver.findElement(pNmaeMsg).getText();
		Assert.assertEquals(errorMsg, actualMsg);
    }
	public void clickSaveStatus() {
		clickAddNewProgram();
		webDriver.findElement(radio).click();
        webDriver.findElement(save).click();
        webDriver.findElement(closeBtn).click();
    }
	public void clickInvalid()  {
		clickAddNewProgram();
		webDriver.findElement(pName).sendKeys("123#");
		webDriver.findElement(pDesc).sendKeys("123@");
        webDriver.findElement(save).click();
        webDriver.findElement(closeBtn).click();
    }
	
	
	public void invalidMsg() {

		String errorMsg= "This field should start with an alphabet, no special char and min 2 char.";
		String actualMsg= webDriver.findElement(invalidMsg).getText();
		Assert.assertEquals(errorMsg, actualMsg);
    }
	public void invalidEditMsg() {

		String errorMsg= "This field should start with an alphabet, no special char and min 2 char.";
		
		Assert.assertEquals(errorMsg, editInvalidMsg);
    }
	public void clickCancelClose() {
		clickAddNewProgram();
        webDriver.findElement(close).click();
    }
	public void clickCancelEdit() {
		webDriver.findElement(By.xpath("//button[@class='p-paginator-first p-paginator-element p-link p-ripple ng-star-inserted']")).click();
		webDriver.findElement(editProgram).click();
        webDriver.findElement(close).click();
    }
	public void closeProgramWindow() {
		
        webDriver.findElement(close).click();
    }
	public void saveValid() throws IOException {
		clickAddNewProgram();
		readDataFromSheet("Program", 0);
		webDriver.findElement(pName).sendKeys(programNameExcelValue);
		webDriver.findElement(pDesc).sendKeys(programDescExcelValue);
		webDriver.findElement(radio).click();
        webDriver.findElement(save).click();
        webDriver.findElement(closeBtn).click();
    }
	 public void readDataFromSheet(String sheetName, Integer rowNumber) throws IOException {
	        ExcelReader reader = new ExcelReader();
	        List<Map<String, String>> testdata = reader.getData("src/test/resources/TestData/LMSTestData.xlsx", sheetName);
	        programNameExcelValue = testdata.get(rowNumber).get("programName");
	        programDescExcelValue = testdata.get(rowNumber).get("programDesc");
	        //System.out.println(programNameExcelValue);
	        //System.out.println(programDescExcelValue);
	    }
	 
	 public void successAlertMsg() {
		 	
		 	//Alert successAlert = webDriver.switchTo().alert();
		 	//String actualMsg= successAlert.getText();

		 	//System.out.println(actualMsg);
			//String expectedMsg= "Successful Program Created";
			
			//Assert.assertEquals(expectedMsg, actualMsg);
	    }
	 public void EditPName() {
		
		 //no of pages
		 int pages = webDriver.findElements(By.xpath("//span[@class='p-paginator-pages ng-star-inserted']/button")).size();
		 System.out.println("Total no of pages "+pages);
		 for(int p=1;p<=pages;p++) {
			 //active page click
			 WebElement active_page = webDriver.findElement(By.xpath("//button[normalize-space()='"+p+"']"));
			 active_page.click();
			 //System.out.println(p);
			 int noRows = webDriver.findElements(By.xpath("//table[@role='grid']/tbody/tr")).size();
			 //System.out.println(noRows);
			 for(int r=1;r<=noRows;r++) {
				 String programName =  webDriver.findElement(By.xpath("//table[@role='grid']/tbody/tr["+r+"]/td[2]")).getText();
				 //System.out.println("pName"+programName);
				 if(programName.contains("Team7")) {
					 //System.out.println(programName);
					 //webDriver.findElement(By.xpath("//table[@role='grid']/tbody/tr["+r+"]/td[5]//button[1])")).click();
					 webDriver.findElement(By.xpath("//tbody/tr["+r+"]/td[5]/div[1]/span[1]/button[1]/span[1]")).click();
					 webDriver.findElement(pName).sendKeys("Edited");
			      	 webDriver.findElement(save).click();
			      	 webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
					 break;
				 }
				 
			 }
		 }
	 }
	 public void EditPDesc() {
		 
		//reset
		// webDriver.findElement(By.xpath("//span[@class='p-paginator-icon pi pi-angle-double-left']")).click();
		 webDriver.findElement(By.xpath("//button[@class='p-paginator-first p-paginator-element p-link p-ripple ng-star-inserted']")).click();
		 //no of pages
		 
		 int pages = webDriver.findElements(By.xpath("//span[@class='p-paginator-pages ng-star-inserted']/button")).size();
		 System.out.println("Total no of pages "+pages);
		 for(int p=1;p<=pages;p++) {
			 //active page click
			 //webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
			 WebElement active_page = webDriver.findElement(By.xpath("//button[normalize-space()='"+p+"']"));
			 active_page.click();
			 //System.out.println(p);
			 int noRows = webDriver.findElements(By.xpath("//table[@role='grid']/tbody/tr")).size();
			 //System.out.println(noRows);
			 for(int r=1;r<=noRows;r++) {
				 String programName =  webDriver.findElement(By.xpath("//table[@role='grid']/tbody/tr["+r+"]/td[2]")).getText();
				 //System.out.println("pName"+programName);
				 if(programName.contains("Team7")) {
					 //System.out.println(programName);
					
					 //webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
					 webDriver.findElement(By.xpath("//tbody/tr["+r+"]/td[5]/div[1]/span[1]/button[1]/span[1]")).click();
					 webDriver.findElement(pDesc).sendKeys("Edited");
			      	 webDriver.findElement(save).click();
			      	 webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
					 break;
				 }
				 
			 }
		 }
	 }
	
	 public void EditPStatus() {
		 
			//reset
			// webDriver.findElement(By.xpath("//span[@class='p-paginator-icon pi pi-angle-double-left']")).click();
			 webDriver.findElement(By.xpath("//button[@class='p-paginator-first p-paginator-element p-link p-ripple ng-star-inserted']")).click();
			
			 //no of pages
			 int pages = webDriver.findElements(By.xpath("//span[@class='p-paginator-pages ng-star-inserted']/button")).size();
			 System.out.println("Total no of pages "+pages);
			 for(int p=1;p<=pages;p++) {
				 //active page click
				 WebElement active_page = webDriver.findElement(By.xpath("//button[normalize-space()='"+p+"']"));
				 active_page.click();
				 //System.out.println(p);
				 int noRows = webDriver.findElements(By.xpath("//table[@role='grid']/tbody/tr")).size();
				 //System.out.println(noRows);
				 for(int r=1;r<=noRows;r++) {
					 String programName =  webDriver.findElement(By.xpath("//table[@role='grid']/tbody/tr["+r+"]/td[2]")).getText();
					 //System.out.println("pName"+programName);
					 if(programName.contains("Team7")) {
						 //System.out.println(programName);
						 //webDriver.findElement(By.xpath("//table[@role='grid']/tbody/tr["+r+"]/td[5]//button[1])")).click();
						 webDriver.findElement(By.xpath("//tbody/tr["+r+"]/td[5]/div[1]/span[1]/button[1]/span[1]")).click();
						 webDriver.findElement(radio).click();
				      	 webDriver.findElement(save).click();
				      	 webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
						 break;
					 }
					 
				 }
			 }
		 }
	 public void EditInvalidInputs() {
			
		 webDriver.findElement(By.xpath("//button[@class='p-paginator-first p-paginator-element p-link p-ripple ng-star-inserted']")).click();
		 //no of pages
		 int pages = webDriver.findElements(By.xpath("//span[@class='p-paginator-pages ng-star-inserted']/button")).size();
		 System.out.println("Total no of pages "+pages);
		 for(int p=1;p<=pages;p++) {
			 //active page click
			 WebElement active_page = webDriver.findElement(By.xpath("//button[normalize-space()='"+p+"']"));
			 active_page.click();
			 //System.out.println(p);
			 int noRows = webDriver.findElements(By.xpath("//table[@role='grid']/tbody/tr")).size();
			 //System.out.println(noRows);
			 for(int r=1;r<=noRows;r++) {
				 String programName =  webDriver.findElement(By.xpath("//table[@role='grid']/tbody/tr["+r+"]/td[2]")).getText();
				 //System.out.println("pName"+programName);
				 if(programName.contains("Team7")) {
					 //System.out.println(programName);
					 //webDriver.findElement(By.xpath("//table[@role='grid']/tbody/tr["+r+"]/td[5]//button[1])")).click();
					 webDriver.findElement(By.xpath("//tbody/tr["+r+"]/td[5]/div[1]/span[1]/button[1]/span[1]")).click();
					 webDriver.findElement(pName).sendKeys("$#");
					 editInvalidMsg=webDriver.findElement(invalidMsg).getText();
			      	 webDriver.findElement(cancel).click();
			      	 webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
					 break;
				 }
				 
			 }
		 }
	 }
	 
	 public void clickDeleteProgram() {
			
	        webDriver.findElement(deleteProgram).click();
	       
	    }
	 public void clickCanceldelete() {
			
	        webDriver.findElement(By.xpath("//span[@class='pi pi-times ng-tns-c133-4']")).click();
	       
	    }
	 public void clickResetPage() {
			
		 webDriver.findElement(By.xpath("//button[@class='p-paginator-first p-paginator-element p-link p-ripple ng-star-inserted']")).click();
	       
	    }
	 
	 
	 public void validateAlertWindow(String confirm) {

			String conf= "Confirm";
			String noBtn= webDriver.findElement(By.xpath("//span[normalize-space()='No']")).getText();
			//System.out.println(noBtn);
			Assert.assertEquals(noBtn, "No");
			String yesBtn= webDriver.findElement(By.xpath("//span[normalize-space()='Yes']")).getText();
			//System.out.println(yesBtn);
			Assert.assertEquals(yesBtn, "Yes");
			
			
	    }
	 public void validateConfirm(String sureDelete) {

			String confMsg= webDriver.findElement(By.xpath("//span[@class='p-confirm-dialog-message ng-tns-c133-4']")).getText();
			String pDeleteName= webDriver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText();
			String pDMsg = sureDelete+" "+pDeleteName+"?";
			//System.out.println(confMsg);
			//System.out.println(pDMsg);
			Assert.assertEquals(confMsg, pDMsg);
			//webDriver.findElement(By.xpath("//span[@class='pi pi-times ng-tns-c133-4']")).click();
	    }
	 public void clickNoDelete() {
			
		 webDriver.findElement(By.xpath("//span[normalize-space()='No']")).click();
		
	    }
	 public void clickDeleteYes() {
			
		 int pages = webDriver.findElements(By.xpath("//span[@class='p-paginator-pages ng-star-inserted']/button")).size();
		 System.out.println("Total no of pages "+pages);
		 for(int p=1;p<=pages;p++) {
			 //active page click
			 WebElement active_page = webDriver.findElement(By.xpath("//button[normalize-space()='"+p+"']"));
			 active_page.click();
			 //System.out.println(p);
			 int noRows = webDriver.findElements(By.xpath("//table[@role='grid']/tbody/tr")).size();
			 //System.out.println(noRows);
			 for(int r=1;r<=noRows;r++) {
				 String programName =  webDriver.findElement(By.xpath("//table[@role='grid']/tbody/tr["+r+"]/td[2]")).getText();
				 //System.out.println("pName"+programName);
				 if(programName.contains("Team7")) {
					 //System.out.println(programName);
					 //webDriver.findElement(By.xpath("//table[@role='grid']/tbody/tr["+r+"]/td[5]//button[1])")).click();
					 webDriver.findElement(By.xpath("//tbody/tr["+r+"]/td[5]/div[1]/span[1]/button[2]/span[1]")).click();
					// webDriver.findElement(pName).sendKeys("Edited");
			         webDriver.findElement(By.xpath("//span[normalize-space()='Yes']")).click();
			      	 webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
					 break;
				 }
				 
			 }
		 }
	       
	    }
	 public void clickCheckboxProgram() {
			
	        webDriver.findElement(checkProgram).click();
	       System.out.println("first checkbox");
	    }
	 public void clickSecondCheckboxProgram() {
			
	        webDriver.findElement(checkSecondProgram).click();
	        System.out.println("second checkbox");
	    }
	 public void deleteEnable() {

			boolean isDeleteEnable = webDriver.findElement(commonDelete).isEnabled();
			Assert.assertTrue(isDeleteEnable);
			
	    }
	 public void clickCommondelete() {
			
	        webDriver.findElement(commonDelete).click();
	    }
	 public void commonDeleteYes() {
			
		 int pages = webDriver.findElements(By.xpath("//span[@class='p-paginator-pages ng-star-inserted']/button")).size();
		 System.out.println("Total no of pages "+pages);
		 for(int p=1;p<=pages;p++) {
			 //active page click
			 WebElement active_page = webDriver.findElement(By.xpath("//button[normalize-space()='"+p+"']"));
			 active_page.click();
			 //System.out.println(p);
			 int noRows = webDriver.findElements(By.xpath("//table[@role='grid']/tbody/tr")).size();
			 //System.out.println(noRows);
			 for(int r=1;r<=noRows;r++) {
				 String programName =  webDriver.findElement(By.xpath("//table[@role='grid']/tbody/tr["+r+"]/td[2]")).getText();
				 //System.out.println("pName"+programName);
				 if(programName.contains("Team7")) {
					 //System.out.println(programName);
					 //webDriver.findElement(By.xpath("//table[@role='grid']/tbody/tr["+r+"]/td[5]//button[1])")).click();
					 webDriver.findElement(By.xpath("//tbody/tr["+r+"]/td[1]/p-tablecheckbox[1]/div[1]/div[2]")).click();
					 webDriver.findElement(commonDelete).click();
					 webDriver.findElement(By.xpath("//span[normalize-space()='Yes']")).click();
			      	 webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
					 break;
				 }
				 
			 }
		 }
	       
	    }
	 
	 public void clickCommondeleteYesButton() {
			
		 webDriver.findElement(By.xpath("//span[normalize-space()='Yes']")).click();
		
	    }
		
}
