package com.LMS.stepdefenition;

import java.time.Duration;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.LMS.browserlaunch.Driverfactory;
import com.LMS.pageobjects.LogoutPage;
import com.LMS.utilities.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Logout_SD {
	
	private WebDriver webDriver;
	LogoutPage logout = new LogoutPage(Driverfactory.getDriver());
	ConfigReader Config = new ConfigReader();
    Properties prop  = Config.init_prop();
	
    @Given("Admin is in dashboard page")
    public void admin_is_in_dashboard_page() throws InterruptedException {
		
		Driverfactory.getDriver().getCurrentUrl();
		//Driverfactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	}
    @When("Admin click Logout button on navigation bar")
    public void admin_click_logout_button_on_navigation_bar() throws InterruptedException {
    	Thread.sleep(30);
    	logout.signout_click();
  
    }

    @Then("Admin should land on login in page")
    public void admin_should_land_on_login_in_page() {
    	String Login_url = Driverfactory.getDriver().getCurrentUrl();
    	Assert.assertEquals(Login_url, prop.getProperty("loginURL"));
		//Driverfactory.closeallDriver();
}

}
