package com.LMS.stepdefenition;

import java.util.Properties;

import com.LMS.browserlaunch.Driverfactory;
import com.LMS.pageobjects.DashBoardPage;
import com.LMS.pageobjects.Program;
import com.LMS.utilities.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MultipleDeleteProgram_SD {
	
	Program program = new Program(Driverfactory.getDriver());
	DashBoardPage dashboard = new DashBoardPage(Driverfactory.getDriver());
	ConfigReader Config = new ConfigReader();
    Properties prop  = Config.init_prop();
	
	@When("Admin clicks any checkbox in the data table to delete program")
	public void admin_clicks_any_checkbox_in_the_data_table_to_delete_program() {
		program.clickCheckboxProgram();
	}

	@Then("Admin should see common delete option enabled under header Manage Program")
	public void admin_should_see_common_delete_option_enabled_under_header_manage_program() {
		program.deleteEnable();
	}

	@Given("Admin is on Confirm Deletion alert after selecting the checkbox in the data table of delete program")
	public void admin_is_on_confirm_deletion_alert_after_selecting_the_checkbox_in_the_data_table_of_delete_program() {
		program.clickCommondelete();
		program.clickNoDelete();
	}

	@When("Admin clicks <No> button on the alert to delete program")
	public void admin_clicks_no_button_on_the_alert_to_delete_program() {
		
	}

	@Then("Admin should land on Manage Program page and can see the selected program is not deleted from the data table")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_program_is_not_deleted_from_the_data_table() {
		program.clickCheckboxProgram();
	}
	@Given("Admin is on Confirm Deletion alert for <YES> after selecting the checkbox in the data table of delete program")
	public void admin_is_on_confirm_deletion_alert_for_yes_after_selecting_the_checkbox_in_the_data_table_of_delete_program() {
		program.commonDeleteYes();
		program.clickCommondelete();
	}

	@When("Admin clicks <YES> button on the alert to delete program")
	public void admin_clicks_yes_button_on_the_alert_to_delete_program() {
		//program.clickCommondeleteYesButton();
	}

	@Then("Admin should land on Manage Program page and can see the selected program is deleted from the data table")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_program_is_deleted_from_the_data_table() {
		program.deleteAlertMsg();
		program.clickResetPage();
		
	}

	@Given("Admin is on Confirm Deletion alert after selecting multiple checkbox in the data table of delete program")
	public void admin_is_on_confirm_deletion_alert_after_selecting_multiple_checkbox_in_the_data_table_of_delete_program() {
		program.clickCheckboxProgram();
		program.clickSecondCheckboxProgram();
		program.clickCommondelete();
	}
	@When("Admin clicks <No> button on the alert to delete multiple program")
	public void admin_clicks_no_button_on_the_alert_to_delete_multiple_program() {
		program.clickNoDelete();
	}

	@Then("Admin should land on Manage Program page and can see the selected multiple programs are not deleted from the data table")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_multiple_programs_are_not_deleted_from_the_data_table() {
		program.clickCheckboxProgram();
		program.clickSecondCheckboxProgram();
	}
	
	@Given("Admin is on Confirm Deletion alert for <YES> after selecting multiple checkbox in the data table of delete program")
	public void admin_is_on_confirm_deletion_alert_for_yes_after_selecting_multiple_checkbox_in_the_data_table_of_delete_program() {
		program.commonDeleteYes();
		//program.clickCommondelete();
	}

	@When("Admin clicks <YES> button on the alert to delete multiple program")
	public void admin_clicks_yes_button_on_the_alert_to_delete_multiple_program() {
		//program.clickCommondeleteYesButton();
	}
	@Then("Admin should land on Manage Program page and can see the selected multiple programs are deleted from the data table")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_multiple_programs_are_deleted_from_the_data_table() {
		program.deleteAlertMsg();
		program.clickResetPage();
	}
//	
//	@Given("Admin is on dashboard page after Login")
//	public void admin_is_on_dashboard_page_after_login() {
//	   
//	}
	@When("Admin clicks {string} from navigation bar")
	public void admin_clicks_from_navigation_bar(String string) throws InterruptedException {
		//AddPage.navigate_dashboard();
		if(!Driverfactory.getDriver().getCurrentUrl().equals(prop.getProperty("batchUrl"))){
			dashboard.click_batch();
		}
		
	   
	}

	@Then("Admin gets navigated to batch page")
	public void admin_gets_navigated_to_batch_page() {
		String currentURL = Driverfactory.getDriver().getCurrentUrl();
		System.out.println(currentURL);
	}



}
