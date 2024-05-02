package com.LMS.stepdefenition;

import org.testng.Assert;

import com.LMS.browserlaunch.Driverfactory;
import com.LMS.pageobjects.AddBatchPage;
import com.LMS.pageobjects.EditBatchPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditBatch_SD {
	private static String UpdatedBatch = null;
	AddBatchPage AddPage = new AddBatchPage(Driverfactory.getDriver());
	EditBatchPage EditPage = new EditBatchPage(Driverfactory.getDriver());



	@Given("Admin is in the Batch Page")
	public void admin_is_in_the_batch_page() {
		System.out.println( Driverfactory.getDriver().getCurrentUrl());
	}

	 @When("Search for {string} in batch search bar")
	 public void search_for_in_batch_search_bar(String string) {
	     // Write code here that turns the phrase above into concrete actions
		 EditPage.Search(string);
		 UpdatedBatch =string;
	 }
	 @Then("Batch Admin clicks the edit icon")
	 public void admin_clicks_the_edit_icon() {
	     // Write code here that turns the phrase above into concrete actions
		 EditPage.ClickEdit();
	 }
	 @Then("Admin should see a popup open for batch details with <SAVE> and <CANCEL> button and Close\\(X) Icon on the top right corner of the window")
	 public void admin_should_see_a_popup_open_for_batch_details_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() {
		
		 EditPage.checkSaveCloseCancel();
	 }
	 
	 
	 @Then("Admin Edit BatchDiscription {string}, BatchStatus {string}, NoOfClasses {string} and click save")
	 public void admin_edit_batch_discription_batch_status_no_of_classes_and_click_save(String BatchDiscription, String BatchStatus, String NoOfClasses) {
	     // Write code here that turns the phrase above into concrete actions
		 EditPage.EditValueWith(BatchDiscription, BatchStatus, NoOfClasses);
	 }



	 @Then("The updated batch details BatchDiscription {string}, BatchStatus {string}, NoOfClasses {string} should appear on the data table")
	 public void the_updated_batch_details_batch_status_no_of_classes_should_appear_on_the_data_table(String BatchDiscription, String BatchStatus, String NoOfClasses) {
	     // Write code here that turns the phrase above into concrete actions
		 EditPage.Search(UpdatedBatch);
		 EditPage.VerifyEditedValue(BatchDiscription, BatchStatus, NoOfClasses);
	 }
	 
	 @Then("Admin give invalid BatchDiscription {string} and click save")
	 public void admin_give_invalid_batch_discription_and_click_save(String BatchDiscription) {
		// EditPage.EditBatchDiscriptionWith(BatchDiscription);
	 }
	 
	 @Then("Error message should appear on batch")
	 public void error_message_should_appear_on_batch() {
	  
	 }
}
