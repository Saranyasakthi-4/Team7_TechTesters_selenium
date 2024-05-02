package com.LMS.stepdefenition;

import com.LMS.browserlaunch.Driverfactory;
import com.LMS.pageobjects.Program;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteProgram_SD {
	
	Program program = new Program(Driverfactory.getDriver());
	
	@When("Admin clicks <Delete> button on the data table for any row of Delete Program")
	public void admin_clicks_delete_button_on_the_data_table_for_any_row_of_delete_program() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		program.clickDeleteProgram();
	}
	@Then("Admin should see a alert open with heading {string} along with  <YES> and <NO> button for deletion")
	public void admin_should_see_a_alert_open_with_heading_along_with_yes_and_no_button_for_deletion(String confirm) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		program.validateAlertWindow(confirm);

	}
	
	@Then("Admin should see a message {string} <Program name>? in Delete Program")
	public void admin_should_see_a_message_program_name_in_delete_program(String sureDelete) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		program.validateConfirm(sureDelete);
	}

	@Given("Admin is on Confirm Deletion alert")
	public void admin_is_on_confirm_deletion_alert() {
	    
	}

	@When("Admin clicks <YES> button on the alert of Delete Program")
	public void admin_clicks_yes_button_on_the_alert_of_delete_program() {
		program.clickDeleteYes();
	}

	@Then("Admin gets a message {string} alert and able to see that program deleted in the data table")
	public void admin_gets_a_message_alert_and_able_to_see_that_program_deleted_in_the_data_table(String string) {
	    
	}

	@When("Admin clicks <NO> button on the alert of the delete program")
	public void admin_clicks_no_button_on_the_alert_of_the_delete_program() {
		program.clickNoDelete();
	}

	@Then("Admin can see the deletion alert disappears without deleting")
	public void admin_can_see_the_deletion_alert_disappears_without_deleting() {
	    
	}

	@When("Admin clicks Cancel or Close Icon on Deletion alert")
	public void admin_clicks_cancel_or_close_icon_on_deletion_alert() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		program.clickResetPage();
		program.clickDeleteProgram();
		program.clickCanceldelete();
	}

	@Then("Admin can see the deletion alert disappears without any changes")
	public void admin_can_see_the_deletion_alert_disappears_without_any_changes() {
	    
	}


}
