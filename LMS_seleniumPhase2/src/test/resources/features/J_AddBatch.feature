@AddBatchPage
Feature: Add new Batch

Background:
#Given Logged into the LMS portal
#When Admin is on dashboard page after Login
Given Admin clicks "Batch" from navigation bar

Scenario Outline: Checking add batch using multiple input values
    #Given Admin clicks "Batch" from navigation bar
    Given Admin clicks "+ A New Batch" button
    When Admin enters sheetname "<sheetName>" and rowNumber <rowNumber>
    #And Enter "<batchDescription>", "<batchName>" , "<batchNoOfClasses>" ,"<batchStatus>" and "<programName>"
    Then Admin clicks "save or cancel" button in AddBatch
    And The newly added batch should be present in the data table in ManageBatch page
    
    Examples:
      | sheetName | rowNumber |
	    | BatchPage | 0         |
	    | BatchPage | 1         |
	    | BatchPage | 2         |
	    | BatchPage | 3         |
	    | BatchPage | 4         |
	    | BatchPage | 5         |
	    | BatchPage | 6         |
	    | BatchPage | 7         |
	    | BatchPage | 8         |
	    | BatchPage | 9         |

