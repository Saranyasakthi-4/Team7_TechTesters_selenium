package com.LMS.stepdefenition;

import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;

import com.LMS.browserlaunch.Driverfactory;
import com.LMS.pageobjects.DashBoardPage;
import com.LMS.pageobjects.LoginPage;
import com.LMS.utilities.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginPageSD {
	LoginPage loginPage = new LoginPage(Driverfactory.getDriver());
	//DashBoardPage dashboard = new DashBoardPage(Driverfactory.getDriver());
	 ConfigReader Config = new ConfigReader();
	 Properties prop  = Config.init_prop();
	
    
    @Given("Admin is in LMS Home Page")
    public void admin_is_in_lms_home_page() {
    	
    	Driverfactory.getDriver().get(prop.getProperty("url"));		
		System.out.println("inside apll");
    	
    }
	
    @Given("Admin is in Home Page")
	public void admin_is_in_Home_Page() {
		
	}


	@When("Enter username {string} and password {string} and click on login button_invalid credentials")
	public void enter_username_and_password_and_click_on_login_button_invalid_credentials(String userName, String password) {
	
		loginPage.Login_invaliddetails(userName,password);

	}

	@Then("User gets the message {string}.")
	public void user_gets_the_message(String string) {
		Assert.assertTrue(loginPage.login_alert());
		

	}

	

	@When("User enters sheetname {string} and rownumber {int}")
	public void user_enters_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws IOException {
		
		loginPage.readDataFromSheet(sheetName, rowNumber);

}

	@When("Enter username {string} and password {string} and click on login button")
	public void enter_username_and_password_and_click_on_login_button(String string, String string2) throws IOException {
		loginPage.sendUsername();
		loginPage.sendPassword();
		
        //dashboard.pageLoadTime() ;

}

	@Then("User navigates to DashBoard Page")
	public void user_navigates_to_DashBoard_Page() {
		loginPage.clickLoginBtn();	
		loginPage.get_url();
  
}
}
