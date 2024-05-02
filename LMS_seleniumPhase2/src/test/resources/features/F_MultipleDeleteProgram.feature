@tagMultipleDeleteProgram
Feature: Multiple Delete Program

Background:
    Given Admin is on dashboard page after Login
    ##And  clicks Program on the navigation bar
   
		Scenario: Validate Common Delete button enabled after clicking on any checkbox
			Given Admin is on Manage Program Page
	   	When Admin clicks any checkbox in the data table to delete program
	    Then Admin should see common delete option enabled under header Manage Program
	    
	    Scenario: Validate multiple program deletion by selecting Single checkbox No
			Given Admin is on Confirm Deletion alert after selecting the checkbox in the data table of delete program
	   	When Admin clicks <No> button on the alert to delete program
	    Then Admin should land on Manage Program page and can see the selected program is not deleted from the data table
	    
	    
	  Scenario: Validate multiple program deletion by selecting Single checkbox Yes
			Given Admin is on Confirm Deletion alert for <YES> after selecting the checkbox in the data table of delete program
	   	When Admin clicks <YES> button on the alert to delete program
	    Then Admin should land on Manage Program page and can see the selected program is deleted from the data table
	    
	  
	  Scenario: Validate multiple program deletion by selecting multiple check boxes No
			Given Admin is on Confirm Deletion alert after selecting multiple checkbox in the data table of delete program
	   	When Admin clicks <No> button on the alert to delete multiple program
	    Then Admin should land on Manage Program page and can see the selected multiple programs are not deleted from the data table
	    
	  Scenario: Validate multiple program deletion by selecting multiple check boxes Yes
			Given Admin is on Confirm Deletion alert for <YES> after selecting multiple checkbox in the data table of delete program 
	   	When Admin clicks <YES> button on the alert to delete multiple program
	    Then Admin should land on Manage Program page and can see the selected multiple programs are deleted from the data table
	    
	   Scenario: Validate navigation to Batch Page
		Given Admin is on dashboard page after Login
	  When Admin clicks "Batch" from navigation bar
	  Then Admin gets navigated to batch page
      
	    