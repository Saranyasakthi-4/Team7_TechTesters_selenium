@tagDeleteBatchpage
Feature: DeleteBatchPage
 
 Background:
    #Given Admin is on dashboard page after Login
    ##And  clicks Batch on the navigation bar
   
		Scenario: Delete Feature
			Given Batch Admin is on dashboard page after Login
			And Admin clicks Batch from navigation bar
	   	When Admin clicks <Delete> button on the data table for any row of Delete Batch
	    Then Admin should see a alert open with heading "Confirm" along with  <YES> and <NO> button for Batch deletion
	    
	  Scenario: Validate details for Confirm Deletion Batch form
			Given Admin is on Batch Details Popup window to Edit
	   	##When Admin clicks <Delete> button on the data table for any row of Delete Batch
	    Then Admin should see a message "Are you sure you want to delete" <Batch name>? in Delete Batch
	    
	  
	  Scenario: Click No on deletion window
			Given Admin is on Confirm Deletion Batch alert
	   	When Admin clicks <NO> button on the alert of the delete Batch
	    Then Admin can see the Batch deletion alert disappears without deleting
	    
	  Scenario: Click Yes on deletion window
			Given Admin is on Confirm Deletion Batch alert
	   	When Admin clicks <YES> button on the alert of Delete Batch
	    Then Admin gets a message "Successful Program Deleted" alert and able to see that Batch deleted in the data table
	  
	    
	   Scenario: Validate Cancel/Close(X) icon on Confirm Batch Deletion alert
			Given Admin is on Confirm Batch Deletion alert
	   	When Admin clicks Cancel or Close Icon on Batch Deletion alert
	    Then Admin can see the Batch deletion alert disappears without any changes
	  
	   