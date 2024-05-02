package com.LMS.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

public class PageValidation {

	private WebDriver webDriver;
	
	  By Batch_MENU = By.xpath("//span[normalize-space()='Batch']");
	  By AddBatch_button = By.xpath("//span[normalize-space()='A New Batch']");
	  By batchNAME_Field = By.xpath("//input[@id='batchName']");
	  By batchDESC_Field = By.xpath("//input[@id='batchDescription']");
	  By batchDropDownButton = By.xpath("(//div[@role='button'])[1]");
	  By programNAME_Dropdown = By.xpath("//input[@placeholder='Select a Program name']");
	  By batchSTATUS_Radio = By.xpath("//div[@class='p-radiobutton p-component']");
	  By batchNoofclasses_Field = By.xpath("//input[@id='batchNoOfClasses']");
	  By addbatch_SAVE = By.xpath("//span[text()='Save']");
	  By addbatch_CANCEL = By.xpath("//span[text()='Cancel']");
	  By search_bar = By.xpath("//input[@id='filterGlobal']");
	  By batchdesc_alert = By.xpath("//small[@id='text-danger']");
	  By manage_Batch = By.xpath("//div[@class='box']");
	  public By PaginationText=By.xpath("//*[@class=\"p-paginator-current ng-star-inserted\"]");
	  public By Deletemain=By.xpath("//*[@class=\\\"p-button-danger p-button p-component p-button-icon-only\\\"]");
	  public By Chkbox=By.xpath("//tbody/tr[1]/td[1]/p-tablecheckbox[1]/div[1]/div[2]");	
	  public By EditButton=By.xpath("(//span[@aria-hidden='true'])[4]");
	  public By DeleteButton=By.xpath("(//span[@aria-hidden='true'])[6]");
	
	  


		By Batch = By.xpath("//button[@id='batch']");
		By newBatch = By.xpath("//button[@id='new']");
		By save =By.xpath("//span[text()='Save']");
		By cancel =By.xpath("//span[text()='Cancel']");
		//By close =By.xpath("//span[text()='Cancel']");
		By bName = By.xpath("//input[@id='batchName']");
		By bDesc = By.xpath("//input[@id='batchDescription']");
		By bNmaeMsg = By.xpath("//small[text()='Batch name is required.']");
		By bDescMsg = By.xpath("//small[text()='Description is required.']");
		By closeBtn = By.xpath("//button[@tabindex='-1']");
		By radio = By.xpath("//div[@class='p-radiobutton p-component']");
		By invalidMsg = By.xpath("//small[contains(text(),'no special char')]");
		String batchNameExcelValue;
		String batchDescExcelValue;
	
	
	public PageValidation(WebDriver webDriver) {
			super();
	        this.webDriver = webDriver;
	        PageFactory.initElements(webDriver,this);
	}
	
	public void checkSaveCloseCancel() {
		boolean isSavePresent = webDriver.findElement(save).isDisplayed();
		Assert.assertTrue(isSavePresent);
		boolean isCancelPresent = webDriver.findElement(cancel).isDisplayed();
		Assert.assertTrue(isCancelPresent);
	}

	public void clickCancelClose() {
		 webDriver.findElement(closeBtn).click();
		
	}

	public void checkInputFileds() {
		boolean isBnamePresent = webDriver.findElement(bName).isDisplayed();
		Assert.assertTrue(isBnamePresent);
		boolean isBdescPresent = webDriver.findElement(bDesc).isDisplayed();
		Assert.assertTrue(isBdescPresent);
	}

	public void verify_ManageBatchHeader() {
		 boolean isManageBatchPresent = webDriver.findElement(manage_Batch).isDisplayed();
	        System.out.println("isManageBatchPresent " + isManageBatchPresent);
			Assert.assertTrue(isManageBatchPresent);
		
	}

	public String findPaginationText() {
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String PageText=webDriver.findElement(PaginationText).getText();
		return PageText.split(" ")[0];
	}

	public boolean checkdisabled() {
		boolean deleteStat= webDriver.findElement(Deletemain).isEnabled();
		return deleteStat;
	}

	public boolean VerifyCheckBox() {
		boolean chkbox=(webDriver.findElement(Chkbox).isDisplayed());
		return chkbox;
	}

	public boolean VerifyEditBtnEnabled() {
		boolean editbtn=(webDriver.findElement(EditButton).isDisplayed());
		return editbtn;
	}

	public boolean VerifyDelBtnEnabled() {
		boolean dltbtn=(webDriver.findElement(DeleteButton).isDisplayed());
		return dltbtn;
	}

}
