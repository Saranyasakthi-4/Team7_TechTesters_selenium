package com.LMS.stepdefenition;

import com.LMS.browserlaunch.Driverfactory;
import com.LMS.pageobjects.DeleteBatchPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteBatch_SD {

	DeleteBatchPage batch = new DeleteBatchPage(Driverfactory.getDriver());
	
	@Given("Admin is on Manage Batch Page")
	public void admin_is_on_manage_batch_page() {
	    
	}

	@When("Admin clicks <Delete> button on the data table for any row of Delete Batch")
	public void admin_clicks_delete_button_on_the_data_table_for_any_row_of_delete_batch() {
		batch.clickDeleteBatch();
	}

	@Then("Admin should see a alert open with heading {string} along with  <YES> and <NO> button for Batch deletion")
	public void admin_should_see_a_alert_open_with_heading_along_with_yes_and_no_button_for_batch_deletion(String confirm) {
		batch.validateAlertWindow(confirm);
	}

	@Given("Admin is on Batch Details Popup window to Edit")
	public void admin_is_on_batch_details_popup_window_to_edit() {
	    
	}

	@Then("Admin should see a message {string} <Batch name>? in Delete Batch")
	public void admin_should_see_a_message_Batch_name_in_delete_batch(String sureDelete) {
		batch.validateConfirm(sureDelete);
	}

	@Given("Admin is on Confirm Deletion Batch alert")
	public void admin_is_on_confirm_deletion_batch_alert() {
	    
	}

	@When("Admin clicks <NO> button on the alert of the delete Batch")
	public void admin_clicks_no_button_on_the_alert_of_the_delete_batch() {
		batch.clickNoDelete();
	}

	@Then("Admin can see the Batch deletion alert disappears without deleting")
	public void admin_can_see_the_batch_deletion_alert_disappears_without_deleting() {
	    
	}

	@When("Admin clicks <YES> button on the alert of Delete Batch")
	public void admin_clicks_yes_button_on_the_alert_of_delete_batch() {
	 
		batch.clickDeleteYes();
	}

	@Then("Admin gets a message {string} alert and able to see that Batch deleted in the data table")
	public void admin_gets_a_message_alert_and_able_to_see_that_batch_deleted_in_the_data_table(String string) {
	    
	}

	@Given("Admin is on Confirm Batch Deletion alert")
	public void admin_is_on_confirm_batch_deletion_alert() {
	    
	}

	@When("Admin clicks Cancel or Close Icon on Batch Deletion alert")
	public void admin_clicks_cancel_or_close_icon_on_batch_deletion_alert() {
	    
		batch.clickResetPage();
		batch.clickDeleteBatch();
		batch.clickCanceldelete();
	}

	@Then("Admin can see the Batch deletion alert disappears without any changes")
	public void admin_can_see_the_batch_deletion_alert_disappears_without_any_changes() {
	    
	}
	
	
}
