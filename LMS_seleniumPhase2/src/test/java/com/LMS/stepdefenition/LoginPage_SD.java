package com.LMS.stepdefenition;

import java.io.IOException;

import com.LMS.browserlaunch.Driverfactory;
import com.LMS.pageobjects.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginPage_SD {
	LoginPage loginPage = new LoginPage(Driverfactory.getDriver());

	@Given("Admin is in Home Page")
	public void admin_is_in_Home_Page() {
		Driverfactory.getDriver().get("https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/");
		System.out.println("inside apll");
	}


	@When("User enters sheetname {string} and rownumber {int}")
	public void user_enters_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws IOException {
		
		loginPage.readDataFromSheet(sheetName, rowNumber);

}

	@When("Enter username {string} and password {string} and click on login button")
	public void enter_username_and_password_and_click_on_login_button(String string, String string2) throws IOException {
		loginPage.sendUsername();
		loginPage.sendPassword();
		loginPage.clickLoginBtn();

}

	@Then("User navigates to DashBoard Page")
	public void user_navigates_to_DashBoard_Page() {
  
}

	@When("when user completes all operations")
	public void when_user_completes_all_operations() {
  
}

	@Then("User click on Signout")
	public void user_click_on_Signout() {
  
}

}
