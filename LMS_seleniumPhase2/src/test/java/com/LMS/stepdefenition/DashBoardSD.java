package com.LMS.stepdefenition;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.testng.Assert;

import com.LMS.browserlaunch.Driverfactory;
import com.LMS.pageobjects.AddBatchPage;
import com.LMS.pageobjects.DashBoardPage;
import com.LMS.pageobjects.HomePageValidation;
import com.LMS.pageobjects.LoginPage;
import com.LMS.utilities.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tech.grasshopper.pdf.section.dashboard.Dashboard;

public class DashBoardSD {
	
	
	
	LoginPage loginPage = new LoginPage(Driverfactory.getDriver());
	DashBoardPage dashboard = new DashBoardPage(Driverfactory.getDriver());
	//AddBatchPage AddPage = new AddBatchPage(Driverfactory.getDriver());
	
	HomePageValidation homepageval = new HomePageValidation(Driverfactory.getDriver());
	ConfigReader Config = new ConfigReader();
    Properties prop  = Config.init_prop();

//	@Given("Logged into the LMS portal")
//	public void logged_into_the_lms_portal() throws IOException {
//		Driverfactory.getDriver().get("https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/");
//		
//		loginPage.clickLoginBtn_background("LoginPage",0);
//	}
//
//	@Then("Admin is on dashboard page after Login")
//	public void admin_is_on_dashboard_page_after_login() {
//		Driverfactory.getDriver().getCurrentUrl();
//	}
//	
	@Given("Admin is in Home Page_dashboard")
	public void admin_is_in_home_page_dashboard() throws IOException {
	
		String currentURL = Driverfactory.getDriver().getCurrentUrl();
		System.out.println(currentURL);
	}

	@When("Admin enter valid credentials  and clicks login button_dashboard")
	public void admin_enter_valid_credentials_and_clicks_login_button_dashboard() {
		System.out.println("Admin is logged in already");
	}

	@Then("Admin should see manage program as header_dashboard")
	public void admin_should_see_manage_program_as_header_dashboard() {
		
		dashboard.getHeader();
	}

	@Then("Maximum navigation time in milliseconds, defaults to {int} seconds_dashboard")
	public void maximum_navigation_time_in_milliseconds_defaults_to_seconds_dashboard(Integer int1) {		
//		int loadtime = dashboard.pageLoadTime();
//		System.out.println(loadtime);
//		Assert.assertTrue(loadtime < 30000);
		
	}

	@Then("HTTP response >= {int}. Then the link is broken_dashboard")
	public void http_response_then_the_link_is_broken_dashboard(Integer int1) {
		int code = homepageval.brokenLink_code(prop.getProperty("dashboardurl"));
		Assert.assertFalse(code>=400);
	}

	@Then("Admin should see LMS -Learning management system  as title _dashboard")
	public void admin_should_see_lms_learning_management_system_as_title__dashboard() throws InterruptedException {
//		Driverfactory.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
//		Driverfactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(100);
		dashboard.getTitle();
		
	}

	@Then("LMS title should be on the top left corner of page_dashboard")
	public void lms_title_should_be_on_the_top_left_corner_of_page_dashboard() {
		
		Assert.assertTrue(dashboard.top_left_title());
	}

	@Then("Admin should see correct spelling in navigation bar text_dashboard")
	public void admin_should_see_correct_spelling_in_navigation_bar_text_dashboard() {
	}

	@Then("Admin should see correct spelling and space in LMS title_dashboard")
	public void admin_should_see_correct_spelling_and_space_in_lms_title_dashboard() {
	}

	@Then("Admin should see the navigation bar text on the top right side_dashboard")
	public void admin_should_see_the_navigation_bar_text_on_the_top_right_side_dashboard() {
	}

	@Then("Admin should see program in the 1st place_dashboard")
	public void admin_should_see_program_in_the_1st_place_dashboard() {
	}

	@Then("Admin should see batch in the 2nd place _dashboard")
	public void admin_should_see_batch_in_the_2nd_place__dashboard() {
	}

	@Then("Admin should see user in the  3rd place_dashboard")
	public void admin_should_see_user_in_the_3rd_place_dashboard() {
	}

	@Then("Admin should see logout in the 4th place_dashboard")
	public void admin_should_see_logout_in_the_4th_place_dashboard() throws InterruptedException {
		
		
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
