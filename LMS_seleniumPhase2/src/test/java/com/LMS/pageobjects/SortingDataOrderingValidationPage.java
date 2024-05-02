package com.LMS.pageobjects;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SortingDataOrderingValidationPage {

    static String sort;
	//String[] beforesort;
	//String[] aftersort;
	
    public By ProgramNameClm=By.xpath("//table[@role=\"grid\"]//tr/td[2]");
    public By ProgramDescClm=By.xpath("//table[@role=\"grid\"]//tr/td[3]");
    public By ProgramStatusClm=By.xpath("//table[@role=\"grid\"]//tr/td[4]");
    public By ProgramNameArrow=By.xpath("//th[normalize-space()='Program Name']//i");
    public By ProgramDescArrow=By.xpath("//th[normalize-space()='Program Description']//i");
    public By ProgramStatusArrow=By.xpath("//th[normalize-space()='Program Status']//i");
    public By username = By.xpath("//input[@id='username']");
	 public By password= By.xpath("//input[@id='password']");
	 public By loginbutton=By.xpath("//span[@class='mat-button-wrapper']");
	 public By nextbtn= By.xpath("//*[@class='p-paginator-icon pi pi-angle-right']");
	 public By lastnextbtn= By.xpath("//*[@class='p-paginator-last p-paginator-element p-link p-ripple ng-star-inserted p-disabled']"); 
	 
	 
	private WebDriver webDriver;
    public SortingDataOrderingValidationPage(WebDriver webDriver) {
        super();
        System.out.println("initialized");
        this.webDriver = webDriver;
        //List<WebElement> colname= webDriver.findElements(ProgramNameClm);
        //System.out.println(webDriver);
       // System.out.println(colname);
        
    }

    //List<WebElement> colname= webDriver.findElements(ProgramNameClm);
    //List<WebElement> rowcountval= webDriver.findElements(RowCount);
    
    public void homeLogin() {
    	
    	
    	webDriver.get("https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/");
    	webDriver.findElement(username).sendKeys("sdetorganizers@gmail.com");		
    	webDriver.findElement(password).sendKeys("UIHackathon@02");	
    	webDriver.findElement(loginbutton).click();
    	
    	
    }
    public void beforePrint()
    {
    	//List<WebElement> colname= webDriver.findElements(ProgramNameClm);
       	String[] beforesort=new String[115];
     	//List<WebElement> colname= webDriver.findElements(ProgramNameClm);
//    	//System.out.println("Before values..");
       // String[] beforesort=new String[colname.size()];
    	System.out.println("#########################Original values###########################");
    	int j=0;
    	try {
    		
    		//int k=0;
    		while(webDriver.findElement(nextbtn).isEnabled()==true) {
        		List<WebElement> colname= webDriver.findElements(ProgramNameClm);
            	//String[] beforesort=new String[colname.size()];
        		 //System.out.println(j);
        		for (int i=0;i<colname.size();i++)
            	{
        			
        			beforesort[j]=colname.get(i).getText().trim();
           
        		   System.out.println(beforesort[j]);
        		   j=j+1;
            	}
            	//j=j+colname.size();
            	//System.out.println(j);
        		
        		
    			webDriver.findElement(nextbtn).click();
    			
        	}
    		
    		
    		
    		System.out.println("#######################Sorted using Java function###################################");
        	
    		//List<WebElement> colname1= webDriver.findElements(ProgramNameClm);
       	//String[] beforesort1=new String[colname1.size()];

//        	for (int i=0;i<colname1.size();i++)
//        	{
//        		Arrays.sort(beforesort1);
//        		sort=beforesort1[i];
//        		System.out.println(sort);
//        		
//        	}
    		
  
    		Arrays.sort(beforesort);

    	}
    	
    	catch(Exception e)
		{
    		//System.out.println("Fail");	
		}
    	System.out.println(j);
    	System.out.println("#######################Testing Java function###################################");
    	//System.out.println(Arrays.toString(beforesort));
    	Arrays.sort(beforesort);
    	for (int i=0;i<beforesort.length;i++)
    	{
    		//Arrays.sort(beforesort);
    		sort=beforesort[i];
    		System.out.println(sort);
    		
    	}

			
        	//System.out.println("Final values: "+sort);
//			webDriver.findElement(nextbtn).click();
//			
//    	}


    }
    
    public void afterPrint()
    {
    
    	System.out.println("#############################Sorted using Application################################");
    	try {
    		while(webDriver.findElement(nextbtn).isEnabled()==true) {
        		List<WebElement> colname= webDriver.findElements(ProgramNameClm);
            	String[] aftersort=new String[colname.size()];

        		for (int i=0;i<colname.size();i++)
            	{
            		aftersort[i]=colname.get(i).getText().trim();
           
        		   System.out.println(aftersort[i]);
            	}
    			
    			webDriver.findElement(nextbtn).click();
    			
        	}
    		
    		
    	}
    	catch(Exception e)
		{
    		//System.out.println("Fail");	
		}
	
      
    		
    		
    }
	public void sortOnProgramName() {
		beforePrint();
		webDriver.findElement(ProgramNameArrow).click();
		afterPrint();
		//assert.assertEquals(aftersort, beforesort);
		
	}
    
	
	
	
	
	
	
	public void ValidateAscendingSorting()
	{
		String[] beforesort1=new String[120];
		
		//String[] beforesort;
		String[] aftersort1=new String[120];

		System.out.println("#########################Original values###########################");
		int j=0;
		
		try {
			while(webDriver.findElement(nextbtn).isEnabled()==true) {
	    		List<WebElement> colname= webDriver.findElements(ProgramNameClm);
	    		for (int i=0;i<colname.size();i++)
	        	{
	    			
	    			beforesort1[j]=colname.get(i).getText().trim();
	       
	    		   System.out.println(beforesort1[j]);
	    		   j=j+1;
	        	}  		
	    		
				webDriver.findElement(nextbtn).click();
				
	    	}
			
		}
		
		catch(Exception e)
		{
			//System.out.println("Fail");	
		}
		
		System.out.println("#######################Testing Java function###################################");
		Arrays.sort(beforesort1);
		for (int i=0;i<beforesort1.length;i++)
		{
			//Arrays.sort(beforesort);
			sort=beforesort1[i];
			System.out.println(sort);
			
		}

		webDriver.findElement(ProgramNameArrow).click();

		System.out.println("#############################Sorted using Application################################");
		int k=0;
		try {
			while(webDriver.findElement(nextbtn).isEnabled()==true) {
	    		List<WebElement> colname= webDriver.findElements(ProgramNameClm);
	        	//String[] aftersort=new String[colname.size()];

	    		for (int i=0;i<colname.size();i++)
	        	{
	        		aftersort1[k]=colname.get(i).getText().trim();
	       
	    		   System.out.println(aftersort1[k]);
	        		k=k+1;
	        	}
				
				webDriver.findElement(nextbtn).click();
				
	    	}
					
		}
		catch(Exception e)
		{
			//System.out.println("Fail");	
		}
		
		Assert.assertEquals(aftersort1, beforesort1,"Failed");
		
	}
    
	
	public void ValidateDescendingSorting()
	{
		String[] beforesort=new String[131];
		
		//String[] beforesort;
		String[] aftersort=new String[131];

		System.out.println("#########################Original values###########################");
		int j=0;
		
		try {
			while(webDriver.findElement(nextbtn).isEnabled()==true) {
	    		List<WebElement> colname= webDriver.findElements(ProgramNameClm);
	    		
	    		for (int i=0;i<colname.size();i++)
	        	{
	    			
	    			beforesort[j]=colname.get(i).getText().trim();
	       
	    		   System.out.println(beforesort[j]);
	    		   j=j+1;
	        	}  		
	    		
				webDriver.findElement(nextbtn).click();
				
	    	}
			
		}
		
		catch(Exception e)
		{
			//System.out.println("Fail");	
		}
		
		System.out.println("#######################Testing Java function###################################");
		Arrays.sort(beforesort,Collections.reverseOrder());
		for (int i=0;i<beforesort.length;i++)
		{
			//Arrays.sort(beforesort);
			sort=beforesort[i];
			System.out.println(sort);
			
		}

		webDriver.findElement(ProgramNameArrow).click();
		webDriver.findElement(ProgramNameArrow).click();

		System.out.println("#############################Sorted using Application################################");
		int k=0;
		try {
			while(webDriver.findElement(nextbtn).isEnabled()==true) {
	    		List<WebElement> colname= webDriver.findElements(ProgramNameClm);
	        	//String[] aftersort=new String[colname.size()];

	    		for (int i=0;i<colname.size();i++)
	        	{
	        		aftersort[k]=colname.get(i).getText().trim();
	       
	    		   System.out.println(aftersort[k]);
	        		k=k+1;
	        	}
				
				webDriver.findElement(nextbtn).click();
				
	    	}
					
		}
		catch(Exception e)
		{
			//System.out.println("Fail");	
		}
		
		Assert.assertEquals(aftersort, beforesort,"Failed");
		
	}
	
	public void ValidateAscendingSortingPrgmDesc()
	{
		String[] beforesort=new String[100];
		
		//String[] beforesort;
		String[] aftersort=new String[100];

		System.out.println("#########################Original values###########################");
		int j=0;
		
		try {
			while(webDriver.findElement(nextbtn).isEnabled()==true) {
	    		List<WebElement> colname= webDriver.findElements(ProgramDescClm);
	    		System.out.println(colname.size());
	    		for (int i=0;i<colname.size();i++)
	        	{
	    			
	    			beforesort[j]=colname.get(i).getText().trim();
	       
	    		   System.out.println(beforesort[j]);
	    		   j=j+1;
	        	}  		
	    		
				webDriver.findElement(nextbtn).click();
				
	    	}
			
		}
		
		catch(Exception e)
		{
			//System.out.println("Fail");	
		}
		
		System.out.println("#######################Testing Java function###################################");
		Arrays.sort(beforesort);
		for (int i=0;i<beforesort.length;i++)
		{
			//Arrays.sort(beforesort);
			sort=beforesort[i];
			System.out.println(sort);
			
		}

		webDriver.findElement(ProgramDescArrow).click();

		System.out.println("#############################Sorted using Application################################");
		int k=0;
		try {
			while(webDriver.findElement(nextbtn).isEnabled()==true) {
	    		List<WebElement> colname= webDriver.findElements(ProgramDescClm);
	        	//String[] aftersort=new String[colname.size()];

	    		for (int i=0;i<colname.size();i++)
	        	{
	        		aftersort[k]=colname.get(i).getText().trim();
	       
	    		   System.out.println(aftersort[k]);
	        		k=k+1;
	        	}
				
				webDriver.findElement(nextbtn).click();
				
	    	}
					
		}
		catch(Exception e)
		{
			//System.out.println("Fail");	
		}
		
		Assert.assertEquals(aftersort, beforesort,"Failed");
		
	}
	
	public void ValidateAscendingSortingPrgmStatus()
	{
		String[] beforesort=new String[100];
		
		//String[] beforesort;
		String[] aftersort=new String[100];

		System.out.println("#########################Original values###########################");
		int j=0;
		
		try {
			while(webDriver.findElement(nextbtn).isEnabled()==true) {
	    		List<WebElement> colname= webDriver.findElements(ProgramStatusClm);
	    		System.out.println(colname.size());
	    		for (int i=0;i<colname.size();i++)
	        	{
	    			
	    			beforesort[j]=colname.get(i).getText().trim();
	       
	    		   System.out.println(beforesort[j]);
	    		   j=j+1;
	        	}  		
	    		
				webDriver.findElement(nextbtn).click();
				
	    	}
			
		}
		
		catch(Exception e)
		{
			//System.out.println("Fail");	
		}
		
		System.out.println("#######################Testing Java function###################################");
		Arrays.sort(beforesort);
		for (int i=0;i<beforesort.length;i++)
		{
			//Arrays.sort(beforesort);
			sort=beforesort[i];
			System.out.println(sort);
			
		}

		webDriver.findElement(ProgramStatusArrow).click();

		System.out.println("#############################Sorted using Application################################");
		int k=0;
		try {
			while(webDriver.findElement(nextbtn).isEnabled()==true) {
	    		List<WebElement> colname= webDriver.findElements(ProgramStatusClm);
	        	//String[] aftersort=new String[colname.size()];

	    		for (int i=0;i<colname.size();i++)
	        	{
	        		aftersort[k]=colname.get(i).getText().trim();
	       
	    		   System.out.println(aftersort[k]);
	        		k=k+1;
	        	}
				
				webDriver.findElement(nextbtn).click();
				
	    	}
					
		}
		catch(Exception e)
		{
			//System.out.println("Fail");	
		}
		
		Assert.assertEquals(aftersort, beforesort,"Failed");
		
	}
}
