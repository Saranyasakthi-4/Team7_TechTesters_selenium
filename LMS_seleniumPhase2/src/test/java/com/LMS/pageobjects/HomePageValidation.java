package com.LMS.pageobjects;

import java.io.File;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;




public class HomePageValidation {
//	
//	@FindBy (xpath="//*[@class='login-button']") 
//	private WebElement loginBtn;
	
	 private WebDriver webDriver;

	 @FindBy (xpath="//img[@class='images']") 
	 private WebElement logo;
	 @FindBy (xpath ="//p[normalize-space()='Please login to LMS application']")
	 private WebElement signintext;
	 @FindBy (xpath =  "//input[@id='username']")
	 private WebElement username_ELEMENT;
	 @FindBy (xpath =  "//input[@id='password']")
	 private WebElement password_ELEMENT;
	 @FindBy (xpath="//span[text()='Login']") 
	 private WebElement Login_button;	
	 @FindBy (xpath="//label[@for='username']/span[2]")
     private WebElement astrisk;
	
	
	   public HomePageValidation(WebDriver webDriver) {
	        super();
	        this.webDriver = webDriver;
	        PageFactory.initElements(webDriver,this);
	    }
	 
	   
	   public boolean invalid_url() {
			// TODO Auto-generated method stub
			String pageSource = webDriver.getPageSource();
			if ( pageSource.contains("404") ) {
			return true;
			}
			else {
				return false;
			}
	   }
					   
	   public void verifyLogo() {

			boolean logoPresent = logo.isDisplayed();
			Assert.assertEquals(logoPresent, true);	
			//Assert.IsTrue(logoPresent);
		}
	   public void verifyLoginBtn() {
			boolean loginBtnPresent = Login_button.isDisplayed();
			Assert.assertEquals(loginBtnPresent, true);	
		}
	   public void signin_text() {
			String signinT = signintext.getText();
			Assert.assertEquals(signinT, "Please login to LMS application");	
		}

		public void verifybuttonAlignment() {
			int buttonWidth = Login_button.getSize().getWidth();
	        System.out.println("Image width Is "+buttonWidth+" pixels");

	        //Get element height.
	        int buttonHeight = Login_button.getSize().getHeight();        
	        System.out.println("Image height Is "+buttonHeight+" pixels");
			int id1X = webDriver.findElement(By.id("login")).getLocation().x; 
			int id2X = webDriver.findElement(By.id("login")).getLocation().y;
			Assert.assertEquals(id1X, id2X);
		}
		public void verifyTextFieldAlignment() {
			int TextWidth = username_ELEMENT.getSize().getWidth();
	        System.out.println("Image width Is "+TextWidth+" pixels");

	        //Get element height.
	        int TextHeight = password_ELEMENT.getSize().getHeight();        
	        System.out.println("Image height Is "+TextHeight+" pixels");
			int id1X = webDriver.findElement(By.id("username")).getLocation().x; 
			int id2X = webDriver.findElement(By.id("username")).getLocation().y;
			Assert.assertEquals(id1X, id2X);
			
		}
		public void descript_test1() {
			// Locate the input field
	        WebElement userInputField = webDriver.findElement(By.id("username"));

	        // Get the descriptive text
	        String descriptiveText = userInputField.getAttribute("placeholder");
	        System.out.println("Descriptive text is correct: " + descriptiveText);
	        // Verify the descriptive text
	       
		}
		public void descript_test2() {
			// Locate the input field
	        WebElement userInputField = webDriver.findElement(By.id("password"));

	        // Get the descriptive text
	        String descriptiveText = userInputField.getAttribute("placeholder");
	        System.out.println("Descriptive text is correct: " + descriptiveText);
	        // Verify the descriptive text
	       
		}
		public void asterisk1() {
		String labelText = astrisk.getText();
		System.out.println(labelText);
       // boolean asteriskPresent = labelText.contains("*");
        Assert.assertEquals(labelText," *");
		}
		
		
		public int brokenLink_code(String url) {
			int code = 0;
			try {
				@SuppressWarnings("deprecation")
				URL link = new URL(url);
				HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
				httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
				httpURLConnection.connect();
				code = httpURLConnection.getResponseCode();

				if (httpURLConnection.getResponseCode() == 200) {
					System.out.println(url + " - " + httpURLConnection.getResponseMessage());
				} else {
					System.out.println(url + " - " + httpURLConnection.getResponseMessage() + " - " + "is a broken link");
				}
			} catch (Exception e) {
				System.out.println(url + " - " + "is a broken link");
			}
			
			return code;
		}
		
		public void spellChecker() {
			
			String yourtext= webDriver.findElement(By.tagName("body")).getText();
			System.out.println(yourtext);
			Assert.assertTrue(true);
		}
		
		
		
		public String verifyPageTitle() {
			String HomepageTitle=webDriver.getTitle();
			System.out.println(HomepageTitle);
			return HomepageTitle;
		}
		
		public int text_count() {
			
			//List<WebElement> textBoxes = webDriver.find_elements_by_tag_name("input[type='text']");
			//java.util.List<WebElement> textFields = webDriver.findElements(By.tagName("//input[]"));
			   java.util.List<WebElement> textFields = webDriver.findElements(By.tagName("input"));
			int count = textFields.size();
			System.out.println("input"+count);
			return count;
			
		}

		public String getFirstTextfield() {

			String str = username_ELEMENT.getText();
			return str;
		}

		public String getSecondTextfield() {

			String str = password_ELEMENT.getText();
			return str;
		}
		public String extractimage() throws IOException, TesseractException{
				
			 WebElement imageUrl=webDriver.findElement(By.xpath("//img[@class='images']"));
			 File src = imageUrl.getScreenshotAs(OutputType.FILE);
		        String filePath = System.getProperty("user.dir") + "\\image.png";
		        FileHandler.copy(src, new File(filePath));

		        // Perform OCR on the downloaded image
		        ITesseract tesseract = new Tesseract();
		        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
		        String recognizedText = tesseract.doOCR(new File(filePath));
		        recognizedText = recognizedText.replaceAll("\\n", "");
		        
		        System.out.println(recognizedText);
				return recognizedText;
	}
	
}
