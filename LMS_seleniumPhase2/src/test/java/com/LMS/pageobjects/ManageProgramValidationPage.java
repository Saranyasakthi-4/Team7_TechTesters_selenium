package com.LMS.pageobjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ManageProgramValidationPage {

	private WebDriver webDriver;
	public By username = By.xpath("//input[@id='username']");
	public By password= By.xpath("//input[@id='password']");
    public By loginbutton=By.xpath("//span[@class='mat-button-wrapper']");
    public By headertext= By.xpath("/html/body/app-root/app-program/div/mat-card/mat-card-title/div[1]");
    public By Program1=By.xpath("//*[@id=\"program\"]");
    public By PaginationText=By.xpath("//*[@class=\"p-paginator-current ng-star-inserted\"]");
    public By FooterText=By.xpath("//*[@class=\"p-d-flex p-ai-center p-jc-between ng-star-inserted\"]");
    public By Deletemain=By.xpath("//*[@class=\"p-button-danger p-button p-component p-button-icon-only\"]");
    public By ANewProgram=By.xpath("//*[@id=\"new\"]");
    
    public By ProgramNameClm=By.xpath("//th[normalize-space()='Program Name']");
    public By ProgramDescClm=By.xpath("//th[normalize-space()='Program Description']");
    public By ProgramStatusClm=By.xpath("//th[normalize-space()='Program Status']");
    public By EditDeleteClm=By.xpath("//th[normalize-space()='Edit / Delete']");
    public By ProgramNameArrow=By.xpath("//th[normalize-space()='Program Name']//i");
    public By ProgramDescArrow=By.xpath("//th[normalize-space()='Program Description']//i");
    public By ProgramStatusArrow=By.xpath("//th[normalize-space()='Program Status']//i");
    
    
    public By Editcolm1=By.xpath("//tbody/tr[1]/td[5]/div[1]/span[1]/button[1]/span[1]");
    public By Deleteco1m1=By.xpath("//tbody/tr[1]/td[5]/div[1]/span[1]/button[2]/span[1]");
    public By Editcolm2=By.xpath("//tbody/tr[2]/td[5]/div[1]/span[1]/button[1]/span[1]");
    public By Deleteco1m2=By.xpath("//tbody/tr[2]/td[5]/div[1]/span[1]/button[2]/span[1]");
    public By Editcolm3=By.xpath("//tbody/tr[3]/td[5]/div[1]/span[1]/button[1]/span[1]");
    public By Deleteco1m3=By.xpath("//tbody/tr[3]/td[5]/div[1]/span[1]/button[2]/span[1]");
    public By Editcolm4=By.xpath("//tbody/tr[4]/td[5]/div[1]/span[1]/button[1]/span[1]");
    public By Deleteco1m4=By.xpath("//tbody/tr[4]/td[5]/div[1]/span[1]/button[2]/span[1]");
    public By Editcolm5=By.xpath("//tbody/tr[5]/td[5]/div[1]/span[1]/button[1]/span[1]");
    public By Deleteco1m5=By.xpath("//tbody/tr[5]/td[5]/div[1]/span[1]/button[2]/span[1]");
    
    public By Chkbox1=By.xpath("//tbody/tr[1]/td[1]/p-tablecheckbox[1]/div[1]/div[2]");
    public By Chkbox2=By.xpath("//tbody/tr[2]/td[1]/p-tablecheckbox[1]/div[1]/div[2]");
    public By Chkbox3=By.xpath("//tbody/tr[3]/td[1]/p-tablecheckbox[1]/div[1]/div[2]");
    public By Chkbox4=By.xpath("//tbody/tr[4]/td[1]/p-tablecheckbox[1]/div[1]/div[2]");
    public By Chkbox5=By.xpath("//tbody/tr[5]/td[1]/p-tablecheckbox[1]/div[1]/div[2]");
    
    public By RowCount=By.xpath("//table[@role=\"grid\"]//tr//td[1]");
    
    public By VerifySearchBox=By.xpath("//input[@id='filterGlobal']");
   
   
	//ChromeDriver driver= new ChromeDriver();
	
    public ManageProgramValidationPage(WebDriver webDriver) {
        super();
        System.out.println("initialized");
        this.webDriver = webDriver;
    }

public void homeLogin() {
	
	
	webDriver.get("https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/");
	webDriver.findElement(username).sendKeys("sdetorganizers@gmail.com");		
	webDriver.findElement(password).sendKeys("UIHackathon@02");	
	webDriver.findElement(loginbutton).click();
	
	
}
	
	public void clickProgram() {
	
		webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		
		webDriver.manage().window().maximize();
		webDriver.findElement(Program1).click();
                 
	}
	
	public String getUrl() {
		// TODO Auto-generated method stub
		String url=webDriver.getCurrentUrl();
		return url;
	}

	public String finHeader() {
		String headerText=webDriver.findElement(headertext).getText();
		return headerText;
	}
	
	public String findPaginationText()
	{
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String PgText=webDriver.findElement(PaginationText).getText();
		return PgText;
	}

	public String findFootertext() {
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String footerText=webDriver.findElement(FooterText).getText();
		return footerText;
	}

	public boolean checkdisabled() {
		boolean dltstat= webDriver.findElement(Deletemain).isEnabled();
		return dltstat;
	}

	public boolean NewProgramButtonFind() {
		boolean NewProgramButtonF=webDriver.findElement(ANewProgram).isDisplayed();
		return NewProgramButtonF;
	}

	public boolean VerifyColumns() {
		boolean verifyclms= (webDriver.findElement(ProgramNameClm).isDisplayed()&&webDriver.findElement(ProgramDescClm).isDisplayed()&&webDriver.findElement(ProgramStatusClm).isDisplayed()&&webDriver.findElement(EditDeleteClm).isDisplayed());
		return verifyclms;
	}

	public boolean VerifySearch() {
	 
		boolean VerifySearchCheckbox=webDriver.findElement(VerifySearchBox).isDisplayed();
		return VerifySearchCheckbox;
	}

	public String FindSearchText() {
		String printserach= webDriver.findElement(VerifySearchBox).getAttribute("placeholder");
		return printserach;
	}

	public boolean VerifyEditBtn() {
	boolean editbtn=(webDriver.findElement(Editcolm1).isDisplayed()&&webDriver.findElement(Editcolm2).isDisplayed()&&webDriver.findElement(Editcolm3).isDisplayed()&&webDriver.findElement(Editcolm4).isDisplayed()&&webDriver.findElement(Editcolm5).isDisplayed());
		return editbtn;
	}
	
	public boolean VerifyDelBtn() {
	boolean dltbtn=(webDriver.findElement(Deleteco1m1).isDisplayed()&&webDriver.findElement(Deleteco1m2).isDisplayed()&&webDriver.findElement(Deleteco1m3).isDisplayed()&&webDriver.findElement(Deleteco1m4).isDisplayed()&&webDriver.findElement(Deleteco1m5).isDisplayed());
		return dltbtn;
	}
	
	public boolean VerifyCheckBox() {
	boolean chkbox=(webDriver.findElement(Chkbox1).isDisplayed()&&webDriver.findElement(Chkbox2).isDisplayed()&&webDriver.findElement(Chkbox3).isDisplayed()&&webDriver.findElement(Chkbox4).isDisplayed()&&webDriver.findElement(Chkbox5).isDisplayed());
		return chkbox;
	}

	public int FindRowsCount() {
		List<WebElement> rowcountval= webDriver.findElements(RowCount);
		int RCount= rowcountval.size();
		return RCount;
	}

	public boolean VerifyArrows() {
		boolean arrowfind=(webDriver.findElement(ProgramNameArrow).isDisplayed()&&webDriver.findElement(ProgramDescArrow).isDisplayed()&&webDriver.findElement(ProgramStatusArrow).isDisplayed());
		return arrowfind;
	}
	
	
}
	

