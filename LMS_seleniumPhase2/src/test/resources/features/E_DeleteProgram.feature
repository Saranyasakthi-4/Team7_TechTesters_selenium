@tagDeleteProgram
Feature: Delete Program

Background:
    Given Admin is on dashboard page after Login
    ##And  clicks Program on the navigation bar
   
		Scenario: Delete Feature
			Given Admin is on Manage Program Page
	   	When Admin clicks <Delete> button on the data table for any row of Delete Program
	    Then Admin should see a alert open with heading "Confirm" along with  <YES> and <NO> button for deletion
	    
	  Scenario: Validate details for Confirm Deletion form
			Given Admin is on Program Details Popup window to Edit
	   	##When Admin clicks <Delete> button on the data table for any row of Delete Program
	    Then Admin should see a message "Are you sure you want to delete" <Program name>? in Delete Program
	    
	  
	  Scenario: Click No on deletion window
			Given Admin is on Confirm Deletion alert
	   	When Admin clicks <NO> button on the alert of the delete program
	    Then Admin can see the deletion alert disappears without deleting
	    
	  Scenario: Click Yes on deletion window
			Given Admin is on Confirm Deletion alert
	   	When Admin clicks <YES> button on the alert of Delete Program
	    Then Admin gets a message "Successful Program Deleted" alert and able to see that program deleted in the data table
	  
	    
	   Scenario: Validate Cancel/Close(X) icon on Confirm Deletion alert
			Given Admin is on Confirm Deletion alert
	   	When Admin clicks Cancel or Close Icon on Deletion alert
	    Then Admin can see the deletion alert disappears without any changes
	  
	   