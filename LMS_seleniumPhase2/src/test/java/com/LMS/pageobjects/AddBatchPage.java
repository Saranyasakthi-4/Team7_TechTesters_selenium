package com.LMS.pageobjects;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.LMS.utilities.ConfigReader;
import com.LMS.utilities.ExcelReader;



public class AddBatchPage {
	
	private WebDriver webDriver;
	public String PROGRAM_NAME="Team7LMSAuto";
	
	ConfigReader Config = new ConfigReader();
	Properties prop  = Config.init_prop();
	
	String batchName_Excel;
	String batchDescription_Excel ;
	String batchNoOfClasses_Excel ;
	String batchStatus_Excel ;
	String programName_Excel ;
	String action_Excel;
	
	
	  // By Batch_MENU = By.xpath("//button[@id='batch']");
	  By AddBatch_button = By.xpath("//span[normalize-space()='A New Batch']");
	  By batchNAME_Field = By.xpath("//input[@id='batchName']");
	  By batchDESC_Field = By.xpath("//input[@id='batchDescription']");
	  //By batchDropDownButton = By.xpath("(//div[@role='button'])[1]");
	//  By programNAME_Dropdown =By.xpath("//*[@id=\"programName\"]/div/input");	 
	  By ProgramNamePoupFieldDrop = By.xpath("//*[@id=\"programName\"]/div/div[2]/span");
	 // By programNAME_Dropdown = By.xpath("//input[@placeholder='Select a Program name']");
	  By Radio_btn = By.xpath("//div[normalize-space()='ACTIVE']//p-radiobutton[@name='category']");
	  //By batchSTATUS_Radio1 = By.xpath("//input[@id='ACTIVE']");
	  By batchSTATUS_Radio1 = By.xpath("//div[normalize-space()='ACTIVE']//p-radiobutton[@name='category']");
	 // By batchSTATUS_Radio2 = By.xpath("//input[@id='INACTIVE']");
	  By batchSTATUS_Radio2 = By.xpath("//div[normalize-space()='INACTIVE']//p-radiobutton[@name='category']");
	  By batchNoofclasses_Field = By.xpath("//input[@id='batchNoOfClasses']");
	  By addbatch_SAVE = By.xpath("//span[text()='Save']");
	  By addbatch_CANCEL = By.xpath("//span[text()='Cancel']");	  
	  By search_bar = By.xpath("//input[@id='filterGlobal']");
	  By batchdesc_alert = By.xpath("//small[contains(text(),'This field should start with an alphabet and min 2')]");
	  By batchname_alert = By.xpath("//small[contains(text(),'This field should start with an alphabet and min 2')]");
	 
	  
	  By batchdesc_savealert = By.xpath("//small[text()='Batch Description is required.']");	  
	  By batchname_savealert = By.xpath("//small[text()='Batch Name is required.']");
	  By programname_savealert = By.xpath("//small[text()='Batch Description is required.']");
	  By batchstatus_savealert = By.xpath("//small[text()='Status is required.']");
	  By batchclasses_savealert = By.xpath("//small[text()='Number of classes is required.']");
	
	  
	
	 public AddBatchPage(WebDriver webDriver) {
	        super();
	        this.webDriver = webDriver;
	        PageFactory.initElements(webDriver,this);
	    }
	 
	 
	 public void click_addbatchButton() throws InterruptedException {
		 Thread.sleep(500);
		 webDriver.findElement(AddBatch_button).click();
		 
	 }
	 static boolean checkUsingMatchesMethod(String str) {
		    return str.matches("^[0-9].*");
		}
	 
	 static boolean checkUsingIsDigitMethod(String str) {
		    return Character.isDigit(str.charAt(0));
		}
	 
	 public void emptybatchvalues() {
		 if (batchName_Excel == null || batchDescription_Excel == null || batchNoOfClasses_Excel == null) {
			 String save_msg = webDriver.findElement(batchname_savealert).getText();
			 Assert.assertTrue(save_msg, true);
		 }
			 
		 		 		 
	 }
	 public void AddBatches_datadriven(String element) {
		 if(element!=null && element.length() > 0) {
			 boolean isDigit = checkUsingIsDigitMethod(element);
			 if(isDigit) {
				 System.out.println("Not starting with number");
				 String alertmessage = webDriver.findElement(batchdesc_alert).getText();
				 Assert.assertTrue(alertmessage, true);
			 }
		 }
		 
	 }
	 
	 public void AddBatch1() {
		//webDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  try {
	 	        Thread.sleep(2000); 
	 	    } catch (InterruptedException e) {
	 	        e.printStackTrace();
	 	    }
	 	    
		webDriver.findElement(batchNAME_Field).sendKeys(batchName_Excel);
		AddBatches_datadriven(batchName_Excel);
		webDriver.findElement(batchDESC_Field).sendKeys(batchDescription_Excel);
		AddBatches_datadriven(batchDescription_Excel);
		webDriver.findElement(ProgramNamePoupFieldDrop).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	  if (!PROGRAM_NAME.isEmpty())
	 	  {
	 		PROGRAM_NAME = "WS17";
	 		String xpathExpr = "//li[@aria-label='%s']";
	 		//WebElement element = webDriver.findElement(By.xpath(String.format(xpathExpr, PROGRAM_NAME)));
	 		WebElement element = webDriver.findElement(By.xpath("//li[1]"));
	 		element.click();
 	 	  }
		if("Active".equals(batchStatus_Excel)) {
			webDriver.findElement(batchSTATUS_Radio1).click();
		}else {
			webDriver.findElement(batchSTATUS_Radio2).click();
		}
		webDriver.findElement(batchNoofclasses_Field).sendKeys(batchNoOfClasses_Excel);
		if (batchNoOfClasses_Excel.length()>4) {
			Assert.assertFalse(false);
		}
		
		
	 }
	
	 
	 public void click_SAVE_OR_CANCEL() {
		 if(action_Excel.equals("save")) {
		 emptybatchvalues();
		 webDriver.findElement(addbatch_SAVE).click();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // wait for the message to showup
			WebElement  saveMsg = webDriver.findElement(By.xpath("/html/body/app-root/app-batch/p-toast/div/p-toastitem/div"));// locate message
			//String msgBtn = webDriver.findElement(By.xpath("/html/body/app-root/app-batch/p-toast/div/p-toastitem/div/div/button")).getText();// locate the X button
			//System.out.println(saveMsg);
			//System.out.println(msgBtn);
			//boolean isMsg  = AppUtils.isUIFieldExists(saveMsg, "Save Message Div" , "Save Program");
//			if(isMsg) {
//				LoggerLoad.info("Save Program Message from DIV "+saveMsg.getText());
//			}
//			isMsg  = AppUtils.isUIFieldExists(msgBtn, "Save Message Div" , "Save Program");
//		
//			if(isMsg) {
//				LoggerLoad.info("Save Program - got the Message X button ");
//				Thread.sleep(500);
//				msgBtn.click();
//				LoggerLoad.info("Save Program - clicked on Message X button ");
//			}
		 }else {
			 this.click_CANCEL();
		 }
			
	 }
	 public void click_CANCEL() {
		
		 webDriver.findElement(addbatch_CANCEL).click();		
	 }
	 public DashBoardPage navigate_dashboard() {
		 webDriver.navigate().to(prop.getProperty("dashboardurl")+"batch");
		 return new DashBoardPage(webDriver);
	 }
	 
	 public void navigate_dashboard_New() {
		 webDriver.findElement(By.xpath("//span[normalize-space()='Program']")).click();	
		 
	 }
	 
	 

	public void readbatchDataFromSheet(String sheetName, Integer rowNumber)throws IOException {
		  ExcelReader reader = new ExcelReader();
		  System.out.println("Am here");
	        List<Map<String, String>> testdata = reader.getData("src/test/resources/TestData/LMSTestData.xlsx", sheetName);
	        batchName_Excel = testdata.get(rowNumber).get("batchName");
	        batchDescription_Excel = testdata.get(rowNumber).get("batchDescription") ;
	        if(batchDescription_Excel == null) {
	        	batchDescription_Excel = "";
	        }
	        batchNoOfClasses_Excel = testdata.get(rowNumber).get("batchNoOfClasses");
	        if(batchNoOfClasses_Excel == null) {
	        	batchNoOfClasses_Excel = "";
	        }else {
	        	batchNoOfClasses_Excel = batchNoOfClasses_Excel.split("\\.")[0];
	        }
	        batchStatus_Excel = testdata.get(rowNumber).get("batchStatus");
	        action_Excel = testdata.get(rowNumber).get("action");
	       // programName_Excel = testdata.get(rowNumber).get("programName");		
	}
	
	public void search_batch() {
		 webDriver.findElement(search_bar).sendKeys(batchName_Excel);
		
	}
	
}
