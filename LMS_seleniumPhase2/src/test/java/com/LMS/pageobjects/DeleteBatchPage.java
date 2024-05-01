package com.LMS.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

public class DeleteBatchPage {

	private WebDriver webDriver;
	
    public By Chkbox1=By.xpath("//tbody/tr[1]/td[1]/p-tablecheckbox[1]/div[1]/div[2]");
    public By Chkbox2=By.xpath("//tbody/tr[2]/td[1]/p-tablecheckbox[1]/div[1]/div[2]");
    public By Chkbox3=By.xpath("//tbody/tr[3]/td[1]/p-tablecheckbox[1]/div[1]/div[2]");
    public By Chkbox4=By.xpath("//tbody/tr[4]/td[1]/p-tablecheckbox[1]/div[1]/div[2]");
    public By Chkbox5=By.xpath("//tbody/tr[5]/td[1]/p-tablecheckbox[1]/div[1]/div[2]");
    public By YestoDelete=By.xpath("//span[normalize-space()='Yes']");
    
    public By deleteIconStatusPath=By.xpath("//*[@class=\"p-button-danger p-button p-component p-button-icon-only\"]");
	
	
    
    
 
	By deleteBatch = By.xpath("(//span[@aria-hidden='true'])[6]");
	
	 public DeleteBatchPage(WebDriver webDriver) {
	        super();
	        this.webDriver = webDriver;
	        PageFactory.initElements(webDriver,this);
	    }

	public void clickDeleteBatch() {
		webDriver.findElement(deleteBatch).click();
		
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

		String confMsg= webDriver.findElement(By.xpath("(//span[@class='p-confirm-dialog-message ng-tns-c133-25'])[1]")).getText();
		String bDeleteName= webDriver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText();
		String bDMsg = sureDelete+" "+bDeleteName+"?";
		System.out.println("confMsg:" + confMsg);
		System.out.println("bDMsg:" + bDMsg);
		Assert.assertEquals(confMsg, bDMsg);
		//webDriver.findElement(By.xpath("//span[@class='pi pi-times ng-tns-c133-4']")).click();
    }

	public void clickDeleteYes() {
		
		 int pages = webDriver.findElements(By.xpath("//span[@class='p-paginator-pages ng-star-inserted']/button")).size();
		 System.out.println("Total no of pages "+pages);
		 for(int p=1;p<=pages;p++) {
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

	 public void clickNoDelete() {
			
		 webDriver.findElement(By.xpath("//span[normalize-space()='No']")).click();
	       
	    }

	 public void clickCanceldelete() {
			
	      //  webDriver.findElement(By.xpath("(//button[@class='ng-tns-c133-25 p-confirm-dialog-reject p-ripple p-button p-component ng-star-inserted'])[1]")).click();
		 webDriver.findElement(By.xpath("(span[normalize-space()='No']")).click();
	       
	    }
	 public void clickResetPage() {
			
		 webDriver.findElement(By.xpath("//button[@class='p-paginator-first p-paginator-element p-link p-ripple ng-star-inserted']")).click();
	       
	    }

	public boolean VerifyCheckboxUnChecked() {
		
		 //String webDriver.findElement(By.xpath("//div[@class='p-checkbox-box']")).getAttribute("aria-checked");
		 
		boolean chkbox=(webDriver.findElement(Chkbox1).isSelected()&&webDriver.findElement(Chkbox2).isSelected()&&webDriver.findElement(Chkbox3).isSelected()&&webDriver.findElement(Chkbox4).isSelected()&&webDriver.findElement(Chkbox5).isSelected());
		return chkbox;
		
	}

	public boolean VerifyDeleteIcondisabled() {
		
		boolean deleteIconStatus= webDriver.findElement(deleteIconStatusPath).isEnabled();
		return deleteIconStatus;
	}

	public void enableCheckBox4OneRecord() {
		webDriver.findElement(Chkbox1).click();
	}

	public void clickDelete() {
		webDriver.findElement(deleteIconStatusPath).click();	
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void Record_deleted_successfully() {
		
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//	String Alert = webDriver.findElement(By.xpath("//div[text() = 'Successfully']")).getText();
	//	System.out.println("Alert : " + Alert);
	}

	public void enableCheckBox4TwoRecord() {
		webDriver.findElement(Chkbox1).click();
		webDriver.findElement(Chkbox2).click();
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	public void clickYestoDelete() {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		webDriver.findElement(YestoDelete).click();
		
	}
	
	
	
	
	
	
}
