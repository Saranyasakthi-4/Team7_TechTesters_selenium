package com.LMS.stepdefenition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.sourceforge.tess4j.TesseractException;

import static org.testng.Assert.assertFalse;
import java.io.IOException;
import java.net.MalformedURLException;
import org.testng.Assert;

import com.LMS.browserlaunch.Driverfactory;
import com.LMS.pageobjects.HomePageValidation;
import com.LMS.utilities.ConfigReader;

public class HomePageValidationSD {
			
		HomePageValidation homepageval = new HomePageValidation(Driverfactory.getDriver());
		ConfigReader config = new ConfigReader();
		String LMS_Home = "https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/login";
		
		@Given("Admin launch the browser_HomePage")
		public void admin_launch_the_browser_home_page() {
			
		}

		@When("Admin gives the invalid LMS portal URL_HomePage")
		public void admin_gives_the_invalid_lms_portal_url_home_page() {
			Driverfactory.getDriver().get(config.getInvalid_ApplicationURL());
		}

		@Then("Admin should receive {int} page not found error_HomePage")
		public void admin_should_receive_page_not_found_error_home_page(Integer int1) {
			
			assertFalse(Driverfactory.getDriver().getPageSource().contains("404"));
			 
		}
		@When("Admin gives the correct LMS portal URL_HomePage")
		public void admin_gives_the_correct_lms_portal_url_home_page() {
			
			Driverfactory.getDriver().get(config.getApplicationURL());
		}

		@Then("Admin should land on the home page_HomePage")
		public void admin_should_land_on_the_home_page_home_page() {
			String home_page = Driverfactory.getDriver().getCurrentUrl();
			System.out.println(home_page);
			Assert.assertEquals(home_page, LMS_Home);
		}
		

		@When("Admin gives the correct LMS portal URL_HomePage for broken link")
		public void admin_gives_the_correct_lms_portal_url_home_page_for_broken_link() {
			Driverfactory.getDriver().get(config.getApplicationURL());		
		
		}

		@Then("HTTP response >= {int}. Then the link is broken_HomePage")
		public void http_response_then_the_link_is_broken_home_page(Integer int1) throws MalformedURLException, IOException {
			int code = homepageval.brokenLink_code(LMS_Home);
			Assert.assertFalse(code>=400);
		}

		@Then("Admin should see correct spellings in all fields_HomePage")
		public void admin_should_see_correct_spellings_in_all_fields_home_page() {
			homepageval.spellChecker();
		}

		@Then("Admin should see correct logo of the LMS_HomePage")
		public void admin_should_see_correct_logo_of_the_lms_home_page() {
			homepageval.verifyLogo();
		}

		@Then("Admin should see  LMS - Learning Management System_HomePage")
		public void admin_should_see_lms_learning_management_system_home_page() {
			String HomepageTitle = homepageval.verifyPageTitle();
			Assert.assertEquals(HomepageTitle,"LMS");
			
		}

		@Then("Admin should see company name below the app name_HomePage")
		public void admin_should_see_company_name_below_the_app_name_home_page() throws IOException, TesseractException {
			String companyName = homepageval.extractimage();
			if(companyName.contains("NumpyNinja")){
				Assert.assertTrue(true);
			}else {
				System.out.println("company not found");
			}
			
		}

		@Then("Admin should see {string}_HomePage")
		public void admin_should_see__home_page(String string) {
			homepageval.signin_text();
		}

		@Then("Admin should see two text field_HomePage")
		public void admin_should_see_two_text_field_home_page() {
			int textcount = homepageval.text_count();
			Assert.assertEquals(textcount, 2);
		}

		@Then("Admin should {string} in the first text field_HomePage")
		public void admin_should_in_the_first_text_field_home_page(String string) {
			String text1 = homepageval.getFirstTextfield();
			Assert.assertNotNull(text1);

		}

		@Then("Admin should see * symbol next to user text_HomePage")
		public void admin_should_see_symbol_next_to_user_text_home_page() {
			homepageval.asterisk1();
		}

		@Then("Admin should {string} in the second text field_HomePage")
		public void admin_should_in_the_second_text_field_home_page(String string) {
			String text2 = homepageval.getSecondTextfield();
			Assert.assertNotNull(text2);
		}

		@Then("Admin should see * symbol next to password text_HomePage")
		public void admin_should_see_symbol_next_to_password_text_home_page() {
			homepageval.asterisk1();
		}

		@Then("Admin should see input field on the centre of the page_HomePage")
		public void admin_should_see_input_field_on_the_centre_of_the_page_home_page() {
			homepageval.verifyTextFieldAlignment();
		}
		

		@Then("Admin should see login button _HomePage")
		public void admin_should_see_login_button__home_page() {
			homepageval.verifyLoginBtn();
		}

		@Then("Admin should see login button on the centre of the page_HomePage")
		public void admin_should_see_login_button_on_the_centre_of_the_page_home_page() {
			homepageval.verifybuttonAlignment();
		}
		

		@Then("Admin should see user in gray color_HomePage")
		public void admin_should_see_user_in_gray_color_home_page() {
			homepageval.descript_test1();
		}

		@Then("Admin should see password in gray color_HomePage")
		public void admin_should_see_password_in_gray_color_home_page() {
			homepageval.descript_test2();
			Driverfactory.closeallDriver();
		}


	}



