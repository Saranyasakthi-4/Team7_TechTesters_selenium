package com.LMS.stepdefenition;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.Assert;

import com.LMS.browserlaunch.Driverfactory;
import com.LMS.pageobjects.LoginPage;
import com.LMS.pageobjects.ManageProgramValidationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ManageProgramValidation_SD {
	

	ManageProgramValidationPage Mpoobj1 = new ManageProgramValidationPage(Driverfactory.getDriver());
	

@Given("Admin is on dashboard page after Login")
public void admin_is_on_dashboard_page_after_login() {
		
	Mpoobj1.homeLogin();
	}
@When("Admin clicks {string} on the navigation bar")

public void admin_clicks_on_the_navigation_bar(String string) {
		Mpoobj1.clickProgram();
	}
@Then("Admin should see URL with {string}")
public void admin_should_see_url_with(String string) {
		String url=Mpoobj1.getUrl();
		Assert.assertEquals(url,"https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/program");
	}
	


@Then("Admin should see a heading with text {string} on the page")
public void admin_should_see_a_heading_with_text_on_the_page(String string) {
        String header=Mpoobj1.finHeader();
        Assert.assertEquals(header,"Manage Program");
     

}

@Then("Admin should see the text as {string} along with Pagination icon below the table.")
public void admin_should_see_the_text_as_along_with_pagination_icon_below_the_table(String string) {
    String pgtext=Mpoobj1.findPaginationText();
    Assert.assertEquals(pgtext,"Showing 1 to 5 of 8 entries");
	
}

@Then("Admin should see the footer as {string}.")
public void admin_should_see_the_footer_as(String string) {
    String footertext=Mpoobj1.findFootertext();
    Assert.assertEquals(footertext,"In total there are 8 programs.");
}

@Then("Admin should see a Delete button on the top left hand side as Disabled")
public void admin_should_see_a_delete_button_on_the_top_left_hand_side_as_disabled() {

	boolean dlt= Mpoobj1.checkdisabled();
	Assert.assertEquals(dlt,false);
}

@Then("Admin should see a {string} button on the program page above the data table")
public void admin_should_see_a_button_on_the_program_page_above_the_data_table(String string) {
	boolean NewProgram= Mpoobj1.NewProgramButtonFind();
	Assert.assertEquals(NewProgram,true);
}


@Then("Admin should see the number of records \\(rows of data in the table) displayed on the page are {int}")
public void admin_should_see_the_number_of_records_rows_of_data_in_the_table_displayed_on_the_page_are(Integer int1) {
	int RowCountdata= Mpoobj1.FindRowsCount();
	Assert.assertEquals(RowCountdata,5);
}

@Then("Admin should see data table on the Manage Program Page with following column headers \\(Program Name, Program Description, Program Status, Edit,Delete)")
public void admin_should_see_data_table_on_the_manage_program_page_with_following_column_headers_program_name_program_description_program_status_edit_delete() {
	boolean ColmnsPresent= Mpoobj1.VerifyColumns();
	Assert.assertEquals(ColmnsPresent,true);
}

@Then("Admin should see the sort arrow icon beside to each column header except Edit and Delete")
public void admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete() {
	boolean ArrowPresent= Mpoobj1.VerifyArrows();
	Assert.assertEquals(ArrowPresent,true);
}

@Then("Admin should see check box on the left side in all rows of the data table")
public void admin_should_see_check_box_on_the_left_side_in_all_rows_of_the_data_table() {
	boolean chkboxall= Mpoobj1.VerifyCheckBox();
	Assert.assertEquals(chkboxall,true);
}

@Then("Admin should see the Edit and Delete buttons on each row of the data table")
public void admin_should_see_the_edit_and_delete_buttons_on_each_row_of_the_data_table() {
	boolean EditAll5= Mpoobj1.VerifyEditBtn();
	boolean DelAll5= Mpoobj1.VerifyDelBtn();
	Assert.assertEquals(EditAll5,true);
	Assert.assertEquals(DelAll5,true);
}

@Then("Admin should see Search bar with text as {string}")
public void admin_should_see_search_bar_with_text_as(String string) {
	boolean Searchval= Mpoobj1.VerifySearch();
	String SearchText=Mpoobj1.FindSearchText();
	Assert.assertEquals(Searchval,true);
	Assert.assertEquals(SearchText,"Search...");
}





















}
