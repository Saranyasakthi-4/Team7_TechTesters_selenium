
@tagLoginPage
Feature: Signing into LMS UI portal

  Scenario Outline: Validate login with valid credentials
    Given Admin is in Home Page
    When User enters sheetname "<sheetName>" and rownumber <rowNumber>
    And Enter username "<userName>" and password "<password>" and click on login button
    Then User navigates to DashBoard Page
    Examples:
      | sheetName | rowNumber |
	    | LoginPage | 0       |
	      
Scenario: User click on Signout
		When when user completes all operations
		Then User click on Signout
 
     
   