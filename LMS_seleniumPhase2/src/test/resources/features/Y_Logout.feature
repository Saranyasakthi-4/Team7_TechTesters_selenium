@tagLogoutPage
Feature: Logging out from LMS UI portal

#Background: Admin is in LMS Dashboard Page_logout

Scenario: Admin logout of LMS Web Application
		Given Admin is in dashboard page
		When Admin click Logout button on navigation bar
		Then Admin should land on login in page

 