package com.LMS.stepdefenition;

import java.util.Properties;

import com.LMS.browserlaunch.Driverfactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.LMS.pageobjects.DashBoardPage;
import com.LMS.pageobjects.SortingDataOrderingValidationPage;
import com.LMS.utilities.ConfigReader;
public class SortingDataOrderingValidation_SD {

	//ManageProgramValidationPage Mpoobj1 = new ManageProgramValidationPage(Driverfactory.getDriver());
	SortingDataOrderingValidationPage srt1 = new SortingDataOrderingValidationPage(Driverfactory.getDriver());
	DashBoardPage dashboard = new DashBoardPage(Driverfactory.getDriver());
	ConfigReader Config = new ConfigReader();
    Properties prop  = Config.init_prop();
	
	@Given("Admin is on Manage Program page3")
	public void admin_is_on_manage_program_page() {
		srt1.homeLogin();
	}

@When("Admin clicks the sort icon of program name column")
public void admin_clicks_the_sort_icon_of_program_name_column() {
  
}

@Then("The data get sorted on the table based on the program name column values in ascending order")
public void the_data_get_sorted_on_the_table_based_on_the_program_name_column_values_in_ascending_order() {
	srt1.ValidateAscendingSorting();
}

@Given("The data is in the ascending order on the table based on Program Name column")
public void the_data_is_in_the_ascending_order_on_the_table_based_on_program_name_column() {
    
}

@Then("The data get sorted on the table based on the program name column values in descending order")
public void the_data_get_sorted_on_the_table_based_on_the_program_name_column_values_in_descending_order() {
    srt1.ValidateDescendingSorting();
}

@When("Admin clicks the sort icon of program Desc column")
public void admin_clicks_the_sort_icon_of_program_desc_column() {
   
}

@Then("The data get sorted on the table based on the program description column values in ascending order")
public void the_data_get_sorted_on_the_table_based_on_the_program_description_column_values_in_ascending_order() {
   srt1.ValidateAscendingSortingPrgmDesc();
}

@Given("The data is in the ascending order on the table based on Program Description column")
public void the_data_is_in_the_ascending_order_on_the_table_based_on_program_description_column() {


}

@Then("The data get sorted on the table based on the program description column values in descending order")
public void the_data_get_sorted_on_the_table_based_on_the_program_description_column_values_in_descending_order() {


}

@When("Admin clicks the sort icon of program Status column")
public void admin_clicks_the_sort_icon_of_program_status_column() {


}

@Then("The data get sorted on the table based on the program status column values in ascending order")
public void the_data_get_sorted_on_the_table_based_on_the_program_status_column_values_in_ascending_order() {
srt1.ValidateAscendingSortingPrgmStatus();

}

@Given("The data is in the ascending order on the table based on Program Status column")
public void the_data_is_in_the_ascending_order_on_the_table_based_on_program_status_column() {

}

@Then("The data get sorted on the table based on the program status column values in descending order")
public void the_data_get_sorted_on_the_table_based_on_the_program_status_column_values_in_descending_order() {

}
@Given("Admin is on dashboard page after Login")
public void admin_is_on_dashboard_page_after_login() {
   
}
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
