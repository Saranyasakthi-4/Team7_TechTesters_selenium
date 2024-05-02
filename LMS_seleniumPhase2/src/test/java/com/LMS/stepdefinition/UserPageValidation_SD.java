package com.LMS.stepdefinition;

import java.io.IOException;

import org.testng.Assert;

import com.LMS.browserlaunch.Driverfactory;
import com.LMS.pageobjects.LoginPage;
import com.LMS.pageobjects.UserPageValidationPage;

import io.cucumber.java.en.*;

public class UserPageValidation_SD 
{
	
	UserPageValidationPage userPage = new UserPageValidationPage(Driverfactory.getDriver());
	
	
	@Given("Admin is on the DashboardPage after login")
	public void admin_is_on_the_dashboard_page_after_login() 
	{		
	
	}

	@When("Admin clicks {string} from Navigation bar")
	public void admin_clicks__from_navigation_bar(String string)
	{
		
		userPage.GetStartedClick();
		
	}

	@Then("Admin should see the {string} in the URL")
	public void admin_should_see_the_in_the_url(String mUser) 
	{  
		String url= userPage.getUrl();
		System.out.println("Url "+url);
		Assert.assertEquals(url,"https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/user");
		
		
	}

	@Then("Admin should see the heading with text {string} on the page")
	public void admin_should_see_the_heading_with_text_on_the_page(String ExpTitle) 
	{  
		String heading = userPage.Header();
		System.out.println("heading is :" +heading);
		Assert.assertEquals(heading,"Manage User");
		
	}
    /*@Then("Admin should see the text as {string} along with Pagination icon below the table")
    public void admin_should_see_the_text_as_along_with_pagination_icon_below_the_table(String string) 
	{  
    	String pgtext = userPage.findPaginationText();
    	String msg1 = userPage.displaymsg1();
    	System.out.println("Total number of Pages:" +msg1);
    	
    	System.out.println("Total number of Pages:" +pgtext);
    	
    	//Assert.assertEquals(pgtext, msg1);
	}*/
    @Then("Admin Should see the data table with column names")
    public void admin_should_see_the_data_table_with_column_names() 
    {
    	boolean ColumnsPresent = userPage.VerifyColumns();
	    Assert.assertEquals(ColumnsPresent, true);
    }
	
    @Then("Admin should see a Delete button on the top left hand side as Disabled")
    public void admin_should_see_a_delete_button_on_the_top_left_hand_side_as_disabled()
    {
    	boolean del = userPage.checkdisabled();
    	Assert.assertEquals(del, false);
    }
    @Then("Admin should be able to see the {string} button above the data table")
    public void admin_should_be_able_to_see_the_button_above_the_data_table(String string)
    {
    	boolean newUser = userPage.NewUserButton();
    	 Assert.assertEquals(newUser, true);
    }
    	
    @Then("Admin should be able to see a {string} button above the data table")
    public void admin_should_be_able_to_see_a_button_above_the_data_table(String string)
    {
    	boolean assignStudent = userPage.assignStudentButton();
   	    Assert.assertEquals(assignStudent, true);
    			
    }
   
    @Then("Admin should be able to see {string} button above data table")
    public void admin_should_be_able_to_see_button_above_data_table(String string)
    {
    	boolean assignStaff = userPage.assignStaffButton();
   	    Assert.assertEquals(assignStaff, true); 
    }
    @Then("Admin should be able to see the search text box above the data table")
    public void admin_should_be_able_to_see_the_search_text_box_above_the_data_table() {
       boolean searchval = userPage.Verifysearch();
       String searchtext= userPage.FindSearchText();
       Assert.assertEquals(searchval, true);
       Assert.assertEquals(searchtext,"Search...");
       
    }

    /*@Then("Admin should see the number of records \\(rows of data in the table) displayed on the page are {int}")
    public void admin_should_see_the_number_of_records_rows_of_data_in_the_table_displayed_on_the_page_are(Integer int1) 
    {
      int Rowcount = userPage.FindRowsCount();
      System.out.println("Number of Rows present:" +Rowcount);
      
      //Assert.assertEquals(Rowcount,);
    }*/

    @Then("Each row in the data table should have a checkbox")
    public void each_row_in_the_data_table_should_have_a_checkbox() {
       boolean chkbox = userPage.VerifyCheckBox();
       Assert.assertEquals(chkbox,true);
    }

    @Then("Each row in the data table should have a edit icon that is enabled")
    public void each_row_in_the_data_table_should_have_a_edit_icon_that_is_enabled() {
       boolean editIcon = userPage.VerifyEditButton();
       Assert.assertEquals(editIcon, true);
    }

    @Then("Each row in the data table should have a delete icon that is enabled")
    public void each_row_in_the_data_table_should_have_a_delete_icon_that_is_enabled() {
    	 boolean deleteIcon = userPage.VerifyDelButton();
         Assert.assertEquals(deleteIcon, true); 
    }
    
    @Then("Admin should see user displayed with the entered name")
    public void admin_should_see_user_displayed_with_the_entered_name(){
   
        boolean searchval1 = userPage.VerifySearchName();
        String searchtext= userPage.FindSearchText();
        Assert.assertEquals(searchval1, true);
        Assert.assertEquals(searchtext,"Search...");
    }   
    @When("Admin enters the keywords not present in the data table on the Search box")
    public void admin_enters_the_keywords_not_present_in_the_data_table_on_the_search_box()
    {
    	userPage.invalidsearch();
    }
    @Then("Admin should see zero entries on the data table")
    public void admin_should_see_zero_entries_on_the_data_table()
    {   
    	String msg = userPage.displaymsg();
    	System.out.println("Admin should see zero entries on the data table");
    	Assert.assertEquals(msg, "Showing 0 to 0 of 0 entries");
    }
    




}
