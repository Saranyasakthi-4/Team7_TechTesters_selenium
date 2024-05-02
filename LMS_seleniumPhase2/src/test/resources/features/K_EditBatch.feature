@tagEditBatch
Feature: EditBatch
  
Background:
#Given Batch Admin is on dashboard page after Login
#Then  Admin clicks batch from navigation bar
	
	Scenario Outline: Validate row level edit icon

	Given Admin is in the Batch Page
	When Search for "<BatchName>" in batch search bar
	Then Batch Admin clicks the edit icon
	Then Admin should see a popup open for batch details with <SAVE> and <CANCEL> button and Close(X) Icon on the top right corner of the window
	Then Admin Edit BatchDiscription "<BatchDiscription>", BatchStatus "<BatchStatus>", NoOfClasses "<NoOfClasses>" and click save
	Then The updated batch details BatchDiscription "<BatchDiscription>", BatchStatus "<BatchStatus>", NoOfClasses "<NoOfClasses>" should appear on the data table
	Examples: 
     | BatchName  |  BatchDiscription 			| BatchStatus 	| NoOfClasses |
     | 	BeastTeam07	|  selenium 						|	INACTIVE 		|	3             |

	
	Scenario Outline: Check if the update throws error with invalid valued
	Given Admin is in the Batch Page
	When Search for "<BatchName>" in batch search bar
	Then Batch Admin clicks the edit icon
	Then Admin give invalid BatchDiscription "<BatchDiscription>" and click save
	Then Error message should appear on batch
	
	  	Examples: 
     |    BatchName   |  BatchDiscription |
     | 		BeastTeam07	|  @##$@            |
	
#	Scenario Outline: Check if you get error message when mandatory fields are erased
#	Given Admin is in the Batch Page
#	When Search for "<BatchName>" in batch search bar
#	Then Batch Admin clicks the edit icon
#	Then  Admin give invalid BatchStatus "<BatchStatus>" and click save
#	Then Error message should appear on batch as "Number of classes is required."
#	
#	   	Examples: 
     #|    BatchName  |  BatchStatus|
     #| 							 |            |
#	
#	Scenario Outline: Check if description field is optional in update
#	Given Admin is in the Batch Page
#	When Search for "<BatchName>" in batch search bar
#	Then Batch Admin clicks the edit icon
#	Then Admin give invalid BatchDiscription "<BatchDiscription>" and click save
#	Then Error message should appear on batch as "Batch Description is required.This field should start with an alphabet and min 2 character."
#	
#	     	Examples: 
     #|    BatchName  |  BatchDiscription |
     #| 							|                  |


