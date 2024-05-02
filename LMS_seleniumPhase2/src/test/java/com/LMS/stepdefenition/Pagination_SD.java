package com.LMS.stepdefenition;

import org.junit.Assert;
import static org.testng.AssertJUnit.assertEquals;

import java.util.concurrent.TimeUnit;

import com.LMS.browserlaunch.Driverfactory;
//import com.LMS.pageobjects.ManageProgramValidationPage;
import com.LMS.pageobjects.PaginationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Pagination_SD {

	//ManageProgramValidationPage Mpoobj2 = new ManageProgramValidationPage(Driverfactory.getDriver());
	PaginationPage pp1 = new PaginationPage(Driverfactory.getDriver());

	
@Given("Admin is on Manage Program Page after logged in")
public void admin_is_on_manage_program_page() {
	//pp1.homeLogin();
 
	
}

@When("Admin clicks Next page link on the program table")
public void admin_clicks_next_page_link_on_the_program_table() {
	try {
		Thread.sleep(500);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	pp1.clicknext();
	
	
}

@Then("Admin should see the Pagination has {string} active link")
public void admin_should_see_the_pagination_has_active_link(String string) {
    boolean nextbtn=pp1.VerifyNext();
    Assert.assertEquals(nextbtn, true);
}


@When("Admin clicks Last page link")
public void admin_clicks_last_page_link() {
    pp1.lastpagelink();
}

@Then("Admin should see the last page record on the table with Next page link are disabled")
public void admin_should_see_the_last_page_record_on_the_table_with_next_page_link_are_disabled() {
	boolean lastnextbtn=pp1.VerifyLastNext();
    Assert.assertEquals(false,lastnextbtn);
}

@Given("Admin is on last page of Program table")
public void admin_is_on_last_page_of_program_table() {
	pp1.homeLogin();
	 pp1.lastpagelink();
}

@When("Admin clicks First page link")
public void admin_clicks_first_page_link() {
   pp1.clickfirstpage();
}

@Then("Admin should see the previous page record on the table with pagination has previous page link")
public void admin_should_see_the_previous_page_record_on_the_table_with_pagination_has_previous_page_link() {
  boolean prvspgelink=pp1.verifypreviouspagelink();
  Assert.assertEquals(true,prvspgelink);
}

@Given("Admin is on Previous Program page")
public void admin_is_on_previous_program_page() {
	pp1.homeLogin();
	 pp1.lastpagelink();
}

@When("Admin clicks Start page link")
public void admin_clicks_start_page_link() {
    pp1.startpageclick();
}

@Then("Admin should see the very first page record on the table with Previous page link are disabled")
public void admin_should_see_the_very_first_page_record_on_the_table_with_previous_page_link_are_disabled() {
	  boolean prvspgelink=pp1.verifypreviouspagelinkonstartpage();
	  Assert.assertEquals(false,prvspgelink);
}

}
