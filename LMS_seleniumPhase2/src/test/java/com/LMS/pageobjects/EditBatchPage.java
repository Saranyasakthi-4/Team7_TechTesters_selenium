package com.LMS.pageobjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.LMS.utilities.ExcelReader;

public class EditBatchPage {

	

	private WebDriver webDriver;

	String batchName_Excel;
	String batchDescription_Excel ;
	String batchNoOfClasses_Excel ;
	String batchStatus_Excel ;
	String programName_Excel ;

	  By Batch_MENU = By.xpath("//span[normalize-space()='Batch']");
	  By AddBatch_button = By.xpath("//span[normalize-space()='A New Batch']");
	  By save =By.xpath("//span[text()='Save']");
	  By cancel =By.xpath("//span[text()='Cancel']");
	  By batchNAME_Field = By.xpath("//input[@id='batchName']");
	  By batchDESC_Field = By.xpath("//input[@id='batchDescription']");
	  By batchDropDownButton = By.xpath("(//div[@role='button'])[1]");
	  By programNAME_Dropdown = By.xpath("//input[@placeholder='Select a Program name']");
	  By batchSTATUS_Radio = By.xpath("//div[@class='p-radiobutton p-component']");
	  By batchNoofclasses_Field = By.xpath("//input[@id='batchNoOfClasses']");
	  By addbatch_SAVE = By.xpath("//span[text()='Save']");
	  By addbatch_CANCEL = By.xpath("//span[text()='Cancel']");
	  By Editbatch_CANCEL = By.xpath("//span[normalize-space()='Cancel']");
	  By search_bar = By.xpath("//input[@id='filterGlobal']");
	  By batchdesc_alert = By.xpath("//small[@id='text-danger']");
	  By batchDiscriptionPath = By.xpath("//input[@id='batchDescription']");
	 // By batchStatusPath = By.xpath("(//span[@class='p-radiobutton-icon'])[1]");
	  By batchStatusPath = By.xpath("//div[@class='p-radiobutton p-component']");
	  By noOfClassesPath = By.xpath("(//input[@id='batchNoOfClasses'])");
	  By edit_SAVE = By.xpath("//span[normalize-space()='Save']");
	  By invalidMsg = By.xpath("//small[@id='text-danger']");
	  
		public By username = By.xpath("//input[@id='username']");
		public By password= By.xpath("//input[@id='password']");
	    public By loginbutton=By.xpath("//span[@class='mat-button-wrapper']");
	    public By SearchBox=By.xpath("//input[@id='filterGlobal']");
	    String editInvalidMsg;
	    
	    By Edit = By.xpath("(//tr[1]/td/div[1]/span[1]/button[1][@icon='pi pi-pencil'])[1]");
	    

	 public EditBatchPage(WebDriver webDriver) {
	        super();
	        this.webDriver = webDriver;
	        PageFactory.initElements(webDriver,this);
	    }

	 public void click_batch() {
		 webDriver.findElement(Batch_MENU).click();

	 }
	 public void click_addbatchButton() {
		 webDriver.findElement(AddBatch_button).click();

	 }
	 public void AddBatch() {

	  webDriver.findElement(batchNAME_Field).sendKeys(batchName_Excel);
	    if(batchDescription_Excel!=null) {
		webDriver.findElement(batchDESC_Field).sendKeys(batchDescription_Excel);
	    }else {
	    	webDriver.findElement(batchdesc_alert).click();
	    }
		webDriver.findElement(batchNoofclasses_Field).sendKeys(batchNoOfClasses_Excel);
		webDriver.findElement(batchSTATUS_Radio).click();
		webDriver.findElement(batchDropDownButton).click();
		webDriver.findElement(programNAME_Dropdown).sendKeys(programName_Excel);
		//Select programoption = new Select(webDriver.findElement(programNAME_Dropdown));
		//programoption.selectByVisibleText("programName_Excel");

	 }

	 public void click_SAVE() {
		 webDriver.findElement(addbatch_SAVE).click();
			webDriver.findElement(addbatch_CANCEL).click();
	 }

	public void readbatchDataFromSheet(String sheetName, Integer rowNumber)throws IOException {
		  ExcelReader reader = new ExcelReader();
		  System.out.println("Am here");
	        List<Map<String, String>> testdata = reader.getData("src/test/resources/TestData/LMSTestData.xlsx", sheetName);
	        batchName_Excel = testdata.get(rowNumber).get("batchName");
	        batchDescription_Excel = testdata.get(rowNumber).get("batchDescription");
	        batchNoOfClasses_Excel = testdata.get(rowNumber).get("batchNoOfClasses");
	        batchStatus_Excel = testdata.get(rowNumber).get("batchStatus");
	        programName_Excel = testdata.get(rowNumber).get("programName");
	}

	public void search_batch() {
		 webDriver.findElement(search_bar).sendKeys(batchName_Excel);

	}

	public void homeLoginBatch() {
		
		
		webDriver.get("https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/");
		webDriver.findElement(username).sendKeys("sdetorganizers@gmail.com");		
		webDriver.findElement(password).sendKeys("UIHackathon@02");	
		webDriver.findElement(loginbutton).click();
		
		
	}
	
	public boolean VerifySearch() {
		 
		boolean VerifySearchCheckbox=webDriver.findElement(SearchBox).isDisplayed();
		return VerifySearchCheckbox;
	}

	public String FindSearchText() {
		String printserach= webDriver.findElement(SearchBox).getAttribute("placeholder");
		return printserach;
	}
	
	public void Search(String string) {
		webDriver.findElement(SearchBox).clear();
		webDriver.findElement(SearchBox).sendKeys(string);
		//webDriver.findElement(SearchBox).click();
	}

	public void ClickEdit() {
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-tns-c132-6.p-dialog-mask")));
		webDriver.findElement(Edit).click();
	}

	public void checkSaveCloseCancel() {

		boolean isSavePresent = webDriver.findElement(save).isDisplayed();
		Assert.assertTrue(isSavePresent);
		boolean isCancelPresent = webDriver.findElement(cancel).isDisplayed();
		Assert.assertTrue(isCancelPresent);
		//boolean isClosePresent = webDriver.findElement(close).isDisplayed();
		//Assert.assertTrue(isSavePresent);
    }

	public void EditValueWith(String batchDiscription, String batchStatus,  String noOfClasses) {
		
		
	
		webDriver.findElement(batchDiscriptionPath).clear();;
		webDriver.findElement(batchDiscriptionPath).sendKeys(batchDiscription);
		String Active= webDriver.findElement(By.xpath("//input[@id='ACTIVE']")).getAttribute("aria-checked");
		//String Active= webDriver.findElement(batchStatusPath).getAttribute("aria-checked");
		System.out.println("getAccessibleName : " + Active);
	    if(Active.equals("false") && batchStatus.equalsIgnoreCase("Active"))
	      webDriver.findElement(batchStatusPath).sendKeys(batchStatus);
		else if(Active.equals("true") && batchStatus.equalsIgnoreCase("INActive")) 
		{
		    By batchStatusPath = By.xpath("//div[@class='p-radiobutton p-component']");
			//webDriver.findElement(batchStatusPath).sendKeys(batchStatus);
		    webDriver.findElement(batchStatusPath).click();
		}
		//int number = Integer.parseInt(noOfClasses);
		//webDriver.findElement(noOfClassesPath).sendKeys(noOfClasses);
		webDriver.findElement(edit_SAVE).click();
	}

	public void VerifyEditedValue(String batchDiscription, String batchStatus, String noOfClasses) {
		
		/*
		 * By batchDiscriptionPath = By.xpath("//tbody/tr[1]/td[2]"); By batchStatusPath
		 * = By.xpath("//div[text()=' ACTIVE ']"); By noOfClassesPath =
		 * By.xpath("//small[@id='text-danger']"); String actualMsg=
		 * webDriver.findElement(batchDiscriptionPath).getText();
		 */
		//Assert.assertEquals(batchDiscription, actualMsg);
		
	}

	public void EditBatchDiscriptionWith(String batchDiscription) {
		System.out.println("Enter EditBatchDiscriptionWith: ");
		webDriver.findElement(batchDiscriptionPath).clear();
		webDriver.findElement(batchDiscriptionPath).sendKeys(batchDiscription);
		System.out.println("invalidMsg: " + invalidMsg);
		editInvalidMsg=webDriver.findElement(invalidMsg).getText();
		System.out.println("editInvalidMsg: " + editInvalidMsg);
	}

	public void invalidEditMsg() {

		String errorMsg= "This field should start with an alphabet and min 2 character.";
		
		Assert.assertEquals(errorMsg, editInvalidMsg);
		
		webDriver.findElement(Editbatch_CANCEL).click();
    }




	

}
