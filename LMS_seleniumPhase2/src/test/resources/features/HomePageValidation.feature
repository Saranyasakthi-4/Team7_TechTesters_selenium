@tagHomePageValidation
Feature: Home Page UI Validation
	
	 Scenario: Verify admin is able to land on home page
   Given Admin launch the browser_HomePage
   When Admin gives the correct LMS portal URL_HomePage
    Then Admin should land on the home page_HomePage
     
   Scenario: Verify admin is able to land on home page with invalid URL
   Given Admin launch the browser_HomePage
   When Admin gives the invalid LMS portal URL_HomePage
   Then Admin should receive 404 page not found error_HomePage
     
   Scenario: Verify for broken link
   Given Admin launch the browser_HomePage
   When Admin gives the correct LMS portal URL_HomePage
   Then HTTP response >= 400. Then the link is broken_HomePage
   
   Scenario: Verify the text spelling in the page  
   Given Admin launch the browser_HomePage
   When Admin gives the correct LMS portal URL_HomePage
   Then Admin should see correct spellings in all fields_HomePage  
   
   Scenario: Verify the logo of the LMS
   Given Admin launch the browser_HomePage
   When Admin gives the correct LMS portal URL_HomePage
   Then Admin should see correct logo of the LMS_HomePage
   
   Scenario: Verify the Application Name properly aligned
   Given Admin launch the browser_HomePage
   When Admin gives the correct LMS portal URL_HomePage
   Then Admin should see  LMS - Learning Management System_HomePage
   
   Scenario: Verify company name
   Given Admin launch the browser_HomePage
   When Admin gives the correct LMS portal URL_HomePage
   Then Admin should see company name below the app name_HomePage
   
     Scenario: Validate sign in content
   Given Admin launch the browser_HomePage
   When Admin gives the correct LMS portal URL_HomePage
   Then Admin should see "Please login to LMS application"_HomePage
   
     Scenario: Verify text field is present
   Given Admin launch the browser_HomePage
   When Admin gives the correct LMS portal URL_HomePage
   Then Admin should see two text field_HomePage
   
     Scenario: Verify text on the first text field
   Given Admin launch the browser_HomePage
   When Admin gives the correct LMS portal URL_HomePage
   Then Admin should "user" in the first text field_HomePage
   
     Scenario: Verify asterik next to user text
   Given Admin launch the browser_HomePage
   When Admin gives the correct LMS portal URL_HomePage
   Then Admin should see * symbol next to user text_HomePage
   
     Scenario: Verify text on the second text field
   Given Admin launch the browser_HomePage
   When Admin gives the correct LMS portal URL_HomePage
   Then Admin should "password" in the second text field_HomePage
   
     Scenario: Verify asterik next to password text
   Given Admin launch the browser_HomePage
   When Admin gives the correct LMS portal URL_HomePage
   Then Admin should see * symbol next to password text_HomePage
   
     Scenario: Verify the alignment input field for the login
   Given Admin launch the browser_HomePage
   When Admin gives the correct LMS portal URL_HomePage
   Then Admin should see input field on the centre of the page_HomePage
   
   Scenario: Verify login button is present
   Given Admin launch the browser_HomePage
   When Admin gives the correct LMS portal URL_HomePage
   Then Admin should see login button _HomePage
   
    Scenario: Verify the alignment of the login button
   Given Admin launch the browser_HomePage
   When Admin gives the correct LMS portal URL_HomePage
   Then Admin should see login button on the centre of the page_HomePage
   