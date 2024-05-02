package com.LMS.stepdefenition;

import com.LMS.browserlaunch.Driverfactory;
import com.LMS.pageobjects.Program;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditProgram_SD {
	
	Program program = new Program(Driverfactory.getDriver());
	
	@When("Admin clicks <Edit> program button on the data table for any row")
	public void admin_clicks_edit_program_button_on_the_data_table_for_any_row() {
		program.clickEditProgram();
	}
	@Then("Admin should see a popup open for Program details to edit")
	public void admin_should_see_a_popup_open_for_program_details_to_edit() {
		program.checkSaveCloseCancel();
		program.closeProgramWindow();
	}
	@Given("Admin is on Program Details Popup window to Edit")
	public void admin_is_on_program_details_popup_window_to_edit() {
	    
	}
	@When("Admin edits the program Name column and clicks save button")
	public void admin_edits_the_program_name_column_and_clicks_save_button() {
		
		program.EditPName();
	}
	@Then("Admin gets a message {string} alert and able to see the updated program name in the table for the particular program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_program_name_in_the_table_for_the_particular_program(String string) {
	  
	}
	@When("Admin edits the program Description column and clicks save button")
	public void admin_edits_the_program_description_column_and_clicks_save_button() {
		program.EditPDesc();
	}
	@Then("Admin gets a message {string} alert and able to see the updated program description in the table for the particular program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_program_description_in_the_table_for_the_particular_program(String string) {
	   
	}
	@When("Admin changes the program Status and clicks save button")
	public void admin_changes_the_program_status_and_clicks_save_button() {
		program.EditPStatus();
	}
	@Then("Admin gets a message {string} alert and able to see the updated program status in the table for the particular program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_program_status_in_the_table_for_the_particular_program(String string) {
	    
	}
	@When("Admin enters only numbers or special char in program name and program desc column")
	public void admin_enters_only_numbers_or_special_char_in_program_name_and_program_desc_column() {
		program.EditInvalidInputs();
	}
	@Then("Admin gets an Error message alert on edit program")
	public void admin_gets_an_error_message_alert_on_edit_program() {
		program.invalidEditMsg();
	}
	@When("Admin clicks <Cancel>button on edit popup")
	public void admin_clicks_cancel_button_on_edit_popup() {
		program.clickCancelEdit();
	}
	@Then("Admin can see the Program details popup disappears and can see nothing changed for particular program")
	public void admin_can_see_the_program_details_popup_disappears_and_can_see_nothing_changed_for_particular_program() {
	   
	}
	@When("Admin clicks <Save>button on edit popup")
	public void admin_clicks_save_button_on_edit_popup() {
	    
	}
	@Then("Admin gets a message {string} alert and able to see the updated details in the table for the particular program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_details_in_the_table_for_the_particular_program(String string) {
	    
	}
	

}
