@tagdashboardPage
Feature: Validation of LMS Dashboard Page

Scenario: Verify after login admin lands on manage program as dashboard page
   Given Admin is in Home Page_dashboard
   When Admin enter valid credentials  and clicks login button_dashboard
   Then Admin should see manage program as header_dashboard

Scenario: Verify the response time
   Given Admin is in Home Page_dashboard
   When Admin enter valid credentials  and clicks login button_dashboard
   Then  Maximum navigation time in milliseconds, defaults to 30 seconds_dashboard
   
Scenario: Verify broken link
   Given Admin is in Home Page_dashboard
   When Admin enter valid credentials  and clicks login button_dashboard
   Then HTTP response >= 400. Then the link is broken_dashboard
   
Scenario: Verify LMS title 
   Given Admin is in Home Page_dashboard
   When Admin enter valid credentials  and clicks login button_dashboard
   Then Admin should see LMS -Learning management system  as title _dashboard
   
Scenario: Verify  LMS title alignment
   Given Admin is in Home Page_dashboard
   When Admin enter valid credentials  and clicks login button_dashboard
   Then LMS title should be on the top left corner of page_dashboard
   
Scenario: Validate navigation bar text
   Given Admin is in Home Page_dashboard
   When Admin enter valid credentials  and clicks login button_dashboard
   Then Admin should see correct spelling in navigation bar text_dashboard
   
Scenario: Validate LMS title has correct spelling ang space
   Given Admin is in Home Page_dashboard
   When Admin enter valid credentials  and clicks login button_dashboard
   Then Admin should see correct spelling and space in LMS title_dashboard
   
Scenario: Validate alignment for navigation bar
   Given Admin is in Home Page_dashboard
   When Admin enter valid credentials  and clicks login button_dashboard
   Then Admin should see the navigation bar text on the top right side_dashboard
   
Scenario: Validate navigation bar order  1st Program
   Given Admin is in Home Page_dashboard
   When Admin enter valid credentials  and clicks login button_dashboard
   Then Admin should see program in the 1st place_dashboard
   
Scenario: Validate navigation bar order  2nd Batch
   Given Admin is in Home Page_dashboard
   When Admin enter valid credentials  and clicks login button_dashboard
   Then Admin should see batch in the 2nd place _dashboard
   
Scenario: Validate navigation bar order 3rd User
   Given Admin is in Home Page_dashboard
   When Admin enter valid credentials  and clicks login button_dashboard
   Then Admin should see user in the  3rd place_dashboard
   
Scenario: Validate navigation bar order 4th Logout 
   Given Admin is in Home Page_dashboard
   When Admin enter valid credentials  and clicks login button_dashboard
   Then Admin should see logout in the 4th place_dashboard


