
@tagLoginPage
Feature: Signing into LMS UI portal

Background:
Given Admin is in LMS Home Page

  Scenario Outline: Validate login with Invalid credentials
    Given Admin is in Home Page
    When Enter username "<userName>" and password "<password>" and click on login button_invalid credentials
    Then User gets the message "Invalid username and password Please try again".
    Examples:
      | userName    | password		 |
	    | Invaliduser | Invalidpwd   |
	   
	    

  Scenario Outline: Validate login with valid credentials
    Given Admin is in Home Page
    When User enters sheetname "<sheetName>" and rownumber <rowNumber>
    And Enter username "<userName>" and password "<password>" and click on login button
    Then User navigates to DashBoard Page
    Examples:
      | sheetName | rowNumber |
	    | LoginPage | 0       	|
	      
 
     
   