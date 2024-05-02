package com.LMS.stepdefenition;

import java.io.IOException;

import com.LMS.browserlaunch.Driverfactory;
import com.LMS.pageobjects.AddBatchPage;
import com.LMS.pageobjects.DashBoardPage;
import com.LMS.pageobjects.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddBatch_SD {
	
	LoginPage loginPage = new LoginPage(Driverfactory.getDriver());
	AddBatchPage AddPage = new AddBatchPage(Driverfactory.getDriver());
	
//	@Given("Logged into the LMS portal")
//	public void logged_into_the_lms_portal() throws IOException {
//		Driverfactory.getDriver().get("https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/");
//		
//		loginPage.clickLoginBtn_background("LoginPage",0);
//	}
//
//	@When("Admin is on dashboard page after Login")
//	public void admin_is_on_dashboard_page_after_login() {
//		Driverfactory.getDriver().getCurrentUrl();
//	}

	@Given("Admin clicks {string} button")
	public void admin_clicks_button(String string) throws InterruptedException {
		String currentURL = Driverfactory.getDriver().getCurrentUrl();
		System.out.println(currentURL);
		Thread.sleep(500);
		AddPage.click_addbatchButton();
	   
	}


	@When("Admin enters sheetname {string} and rowNumber {int}")
		public void admin_enters_sheetname_and_row_number(String sheetName, Integer rowNumber) throws IOException{
        System.out.println(sheetName + "   " +rowNumber);
		AddPage.readbatchDataFromSheet(sheetName, rowNumber);
		AddPage.AddBatch1();
	}


	@Then("Admin clicks {string} button in AddBatch")
	public void admin_clicks_button_in_add_batch(String button) {
		  AddPage.click_SAVE_OR_CANCEL();
	}
	@Then("The newly added batch should be present in the data table in ManageBatch page")
	public void the_newly_added_batch_should_be_present_in_the_data_table_in_manage_batch_page() {
		// To use Search bar to find the batch
		//AddPage.search_batch();
		
		
	}
	

}
