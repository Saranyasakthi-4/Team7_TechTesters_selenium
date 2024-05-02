package com.LMS.stepdefenition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.LMS.browserlaunch.Driverfactory;
import com.LMS.pageobjects.ManageProgramValidationPage;
import com.LMS.pageobjects.NavigationValidationfromManageProgramtootherPagesPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigationValidationfromManageProgramtootherPages_SD {

	NavigationValidationfromManageProgramtootherPagesPage nvobj=new NavigationValidationfromManageProgramtootherPagesPage(Driverfactory.getDriver());
	ManageProgramValidationPage Mpoobj1 = new ManageProgramValidationPage(Driverfactory.getDriver());



	//private WebDriver webDriver;
	
@Given("Admin is on Manage Program page")
public void admin_is_on_manage_program_page() {
	Mpoobj1.homeLogin();
}

	
@When("Admin clicks on Batch link on Manage Program page")
public void admin_clicks_on_batch_link_on_manage_program_page() {
    
	nvobj.clickbatchbtn();
	
}

@Then("Admin is re-directed to Batch page")
public void admin_is_re_directed_to_batch_page() {
  String batchurl=nvobj.getbatchUrl();
  Assert.assertEquals(batchurl,"https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/batch");

}

@When("Admin clicks on User link on Manage Program page")
public void admin_clicks_on_user_link_on_manage_program_page() {

	
	nvobj.clickuserbtn();
}

@Then("Admin is re-directed to User page")
public void admin_is_re_directed_to_user_page() {
	  String userurl=nvobj.getuserUrl();
	  Assert.assertEquals(userurl,"https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/user");

}

@When("Admin clicks on Logout link on Manage Program page")
public void admin_clicks_on_logout_link_on_manage_program_page() {
	nvobj.clickLogoutbtn();
}

@Then("Admin is re-directed to Login page")
public void admin_is_re_directed_to_login_page() {
	String userurl=nvobj.getuserUrl();
	  Assert.assertEquals(userurl,"https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/login");
}



}
