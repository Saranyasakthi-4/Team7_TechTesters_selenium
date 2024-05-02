@tagEditProgram
Feature: Edit Program

Background:
    Given Admin is on dashboard page after Login
    ##And  clicks Program on the navigation bar
   
		Scenario: Validate Edit Feature
			Given Admin is on Manage Program Page
	   	When Admin clicks <Edit> program button on the data table for any row
	    Then Admin should see a popup open for Program details to edit
	    
	  Scenario: Edit Program Name
			Given Admin is on Program Details Popup window to Edit
	   	When Admin edits the program Name column and clicks save button
	    Then Admin gets a message "Successful Program Updated" alert and able to see the updated program name in the table for the particular program
	    
	   Scenario: Edit Program description
			Given Admin is on Program Details Popup window to Edit
	   	When Admin edits the program Description column and clicks save button
	    Then Admin gets a message "Successful Program Updated" alert and able to see the updated program description in the table for the particular program
	  
	  Scenario: Change Program Status
			Given Admin is on Program Details Popup window to Edit
	   	When Admin changes the program Status and clicks save button
	    Then Admin gets a message "Successful Program Updated" alert and able to see the updated program status in the table for the particular program
	    
	   Scenario: Validate invalid values on the text column
			Given Admin is on Program Details Popup window to Edit
	   	When Admin enters only numbers or special char in program name and program desc column
	    Then Admin gets an Error message alert on edit program
	  
	   Scenario: Validate Cancel button on Edit popup
			Given Admin is on Program Details Popup window to Edit
	   	When Admin clicks <Cancel>button on edit popup
	    Then Admin can see the Program details popup disappears and can see nothing changed for particular program
	   
	   Scenario: Validate Save button on Edit popup
			Given Admin is on Program Details Popup window to Edit
	   	When Admin clicks <Save>button on edit popup
	    Then Admin gets a message "Successful Program Updated" alert and able to see the updated details in the table for the particular program
	   
	   
	    
	    