@tagDeleteMultipleBatches
Feature: Delete Mutiple batches
  
 
	Scenario: Validate the delete icon below the header 
	Given Batch Admin is on dashboard page after Login
	And Admin clicks Batch from navigation bar
	When None of the checkboxes in data table are selected
	Then The delete icon under the Manage Batch header should be disabled
	
	Scenario: Check for single row delete
	Given One of the checkbox is selected
	When Click delete icon below Manage Batch header
	Then Record should be deleted successfully
	
	Scenario: Check for multi row delete
	Given Two checkboxes are selected
	When Click delete icon below Manage Batch header
	Then Record should be deleted successfully
	
	
	
	 

   