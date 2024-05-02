package com.LMS.stepdefenition;

import org.junit.Assert;

import com.LMS.browserlaunch.Driverfactory;
import com.LMS.pageobjects.EditBatchPage;
import com.LMS.pageobjects.BatchPageValidation;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BatchPageValidation_SD {

	BatchPageValidation pageValidation = new BatchPageValidation(Driverfactory.getDriver());
	EditBatchPage EditPage = new EditBatchPage(Driverfactory.getDriver());

	@Given("Batch Admin is on dashboard page after Login")
	public void batch_admin_is_on_dashboard_page_after_login() {

	}

	@When("Admin clicks batch from navigation bar")
	public void admin_clicks_batch_from_navigation_bar() {
		String currentURL = Driverfactory.getDriver().getCurrentUrl();
		System.out.println(currentURL);
	}

	@Then("Admin should see a popup open for Batch details with empty form along with <SAVE> and <CANCEL> button and Close(X) Icon on the top right corner of the window")
	public void admin_should_see_a_popup_open_for_Batch_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() {

		pageValidation.checkSaveCloseCancel();
	}

	@When("Admin clicks Cancel or Close Icon on Batch Details form")
	public void admin_clicks_cancel_or_close_icon_on_program_details_form() {
		pageValidation.clickCancelClose();
	}

	@Then("Admin should see two input fields and their respective text boxes in the Batch details window")
	public void admin_should_see_two_input_fields_and_their_respective_text_boxes_in_the_Batch_details_window() {

		pageValidation.checkInputFileds();
	}

	@Then("Admin should see the {string} in the header")
	public void admin_should_see_the_in_the_header(String string) {
		pageValidation.verify_ManageBatchHeader();
	}

	@Then("Admin should see a popup open for Batch details with empty form along with <SAVE> and <CANCEL> button and Close\\(X) Icon on the top right corner of the window")
	public void admin_should_see_a_popup_open_for_batch_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() {
		// Write code here that turns the phrase above into concrete actions

		pageValidation.checkSaveCloseCancel();

	}

	@Then("Batch Details popup window should be closed without saving")
	public void batch_details_popup_window_should_be_closed_without_saving() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("Admin should see the Batch_pagination controls under the data table")
	public void admin_should_see_the_batch_pagination_controls_under_the_data_table() {
		String paginationtext = pageValidation.findPaginationText();
		Assert.assertEquals(paginationtext, "Showing");
	}

	@Then("Admin should be able to see the Batch Delete icon button that is disabled")
	public void admin_should_be_able_to_see_the_batch_Delete_button_that_is_disabled() {
		boolean deleteState = pageValidation.checkdisabled();
		Assert.assertEquals(deleteState, false);
	}

	@Then("Each row in the Batch_data table should have a checkbox")
	public void each_row_in_the_batch_data_table_should_have_a_checkbox() {
		boolean chkboxall = pageValidation.VerifyCheckBox();
		Assert.assertEquals(chkboxall, true);
	}

	@Then("Each row in the Batch_data table should have a edit icon that is enabled")
	public void each_row_in_the_batch_data_table_should_have_a_edit_icon_that_is_enabled() {
		boolean EditAll = pageValidation.VerifyEditBtnEnabled();
		Assert.assertEquals(EditAll, true);

	}

	@Then("Each row in the Batch_data table should have a delete icon that is enabled")
	public void each_row_in_the_batch_data_table_should_have_a_delete_icon_that_is_enabled() {
		boolean DelAll = pageValidation.VerifyDelBtnEnabled();
		Assert.assertEquals(DelAll, true);
	}


	@Given("Admin is on {string} Popup window")
	public void admin_is_on_popup_window(String string) {

	}

	@Then("Admin should be able to see the {string} button")
	public void admin_should_be_able_to_see_the_button(String string) {
	}

	@Then("Each row in the data table  of Batch should have a checkbox")
	public void each_row_in_the_data_table_of_batch_should_have_a_checkbox() {
	}

	@Then("Each row in the data table of Batch should have a edit icon that is enabled")
	public void each_row_in_the_data_table_of_batch_should_have_a_edit_icon_that_is_enabled() {
	}

	@Then("Each row in the data table of Batch should have a delete icon that is enabled")
	public void each_row_in_the_data_table_of_batch_should_have_a_delete_icon_that_is_enabled() {
	}

}
