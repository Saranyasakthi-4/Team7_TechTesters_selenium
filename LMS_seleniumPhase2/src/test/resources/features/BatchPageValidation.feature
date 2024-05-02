@tagBatchPageValidation
Feature: BatchPageValidation 
  
 #Background:
 #Given Admin logged on LMS portal
 #Given Admin is on dashboard page after Login
 #Given clicks on Batch from navigation bar
  
  
  Scenario: Validate landing in Batch page
  Given Batch Admin is on dashboard page after Login
  When Admin clicks Batch from navigation bar
  Then Admin should see the "Manage Batch" in the URL
  Then Admin should see the "Manage Batch" in the header
  Then Admin should see the Batch_pagination controls under the data table
  Then Admin should be able to see the Batch Delete icon button that is disabled
  Then Admin should be able to see the "+ A New batch" button
  Then Each row in the data table  of Batch should have a checkbox
  Then Each row in the data table of Batch should have a edit icon that is enabled
  Then Each row in the data table of Batch should have a delete icon that is enabled
  
  Scenario: Validate pop up for adding Batch
  Given Admin is on dashboard page after Login
  When Admin clicks "+ A New Batch" button
  Then Admin should see two input fields and their respective text boxes in the Batch details window
  Then Admin should see a popup open for Batch details with empty form along with <SAVE> and <CANCEL> button and Close(X) Icon on the top right corner of the window 
  
  Scenario: Validate Cancel/Close(X) icon on Batch Details form
			Given Admin is on "Batch" Popup window
	   	When Admin clicks Cancel or Close Icon on Batch Details form
	    Then Batch Details popup window should be closed without saving
  

   