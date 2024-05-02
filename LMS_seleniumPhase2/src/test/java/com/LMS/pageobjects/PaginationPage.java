package com.LMS.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.api.model.Driver;

public class PaginationPage {
	
	 //public By nextbtn= By.xpath("//button[@class='p-paginator-next p-paginator-element p-link p-ripple']");
	 public By nextbtn= By.xpath("//*[@class='p-paginator-icon pi pi-angle-right']");
	 public By lastnextbtn= By.xpath("//*[@class='p-paginator-next p-paginator-element p-link p-ripple p-disabled']");
	 public By lastpagebrn= By.xpath("//span[@class='p-paginator-icon pi pi-angle-double-right']");
	 public By firstpagelink= By.xpath("//button[@class='p-paginator-prev p-paginator-element p-link p-ripple']");
	 public By startpagelink=By.xpath("//span[@class='p-paginator-icon pi pi-angle-double-left']");
	 
	 public By prvsonfirst=By.xpath("//button[@class='p-paginator-prev p-paginator-element p-link p-ripple p-disabled']");
	// public By paginationfirst= By.className("p-paginator-first p-paginator-element p-link p-ripple ng-star-inserted");
	// public By pagination2= By.className("p-paginator-next p-paginator-element p-link p-ripple p-disabled");
	// public By paginationlast= By.className ("p-paginator-last p-paginator-element p-link p-ripple ng-star-inserted p-disabled");
	 public By username = By.xpath("//input[@id='username']");
	 public By password= By.xpath("//input[@id='password']");
	 public By loginbutton=By.xpath("//span[@class='mat-button-wrapper']");
	    
	 private WebDriver webDriver;



	    public PaginationPage(WebDriver webDriver) {
	        super();
	        System.out.println("initialized");
	        this.webDriver = webDriver;
	    }
	 
		//ChromeDriver driver= new ChromeDriver();
	    
	    public void homeLogin() {
	    	
	    	
	    	webDriver.get("https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/");
	    	webDriver.findElement(username).sendKeys("sdetorganizers@gmail.com");		
	    	webDriver.findElement(password).sendKeys("UIHackathon@02");	
	    	webDriver.findElement(loginbutton).click();
	    	
	    	
	    }
	 
	    
		public void clicknext() {
			
			webDriver.findElement(nextbtn).click();	
			
			
		}

		public boolean VerifyNext() {
			boolean nextBtnexist= webDriver.findElement(nextbtn).isEnabled();
			return nextBtnexist;
		}

		public void lastpagelink() {
			//webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			webDriver.findElement(lastpagebrn).click();	
			
		}

		public boolean VerifyLastNext() {
			boolean lastnextBtnexist= webDriver.findElement(lastnextbtn).isEnabled();
			return lastnextBtnexist;
		}

		public void clickfirstpage() {
			webDriver.findElement(firstpagelink).click();	
			
		}

		public boolean verifypreviouspagelink() {
			boolean prvpagelink=webDriver.findElement(firstpagelink).isEnabled();
			return prvpagelink;
			
		}

		public void startpageclick() {
			
			webDriver.findElement(startpagelink).click();	
		}

		public boolean verifypreviouspagelinkonstartpage() {
			boolean prvpagelinkonstart=webDriver.findElement(prvsonfirst).isEnabled();
			return prvpagelinkonstart;
		}
	 
		
}
