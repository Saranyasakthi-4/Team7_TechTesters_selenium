
@tagSortingDataOrderingValidation

Feature: SortingDataOrderingValidationone


Scenario: Validates Sorting(data ordering) on the Program Data table1
    Given Admin is on Manage Program page3
    When  Admin clicks the sort icon of program name column
    Then The data get sorted on the table based on the program name column values in ascending order
 
    #Scenario: Validates Sorting(data ordering) on the Program Data table2
    #Given The data is in the ascending order on the table based on Program Name column
    #When  Admin clicks the sort icon of program name column
    #Then The data get sorted on the table based on the program name column values in descending order
    
    Scenario: Validates Sorting(data ordering) on the Program Data table3
    Given Admin is on Manage Program page3
    When  Admin clicks the sort icon of program Desc column
    Then The data get sorted on the table based on the program description column values in ascending order
    
    #Scenario: Validates Sorting(data ordering) on the Program Data table4
    #Given The data is in the ascending order on the table based on Program Description column
    #When  Admin clicks the sort icon of program Desc column
    #Then The data get sorted on the table based on the program description column values in descending order

    Scenario: Validates Sorting(data ordering) on the Program Data table5
    Given Admin is on Manage Program page3
    When  Admin clicks the sort icon of program Status column
    Then The data get sorted on the table based on the program status column values in ascending order
    
    #Scenario: Validates Sorting(data ordering) on the Program Data table6
    #Given The data is in the ascending order on the table based on Program Status column
    #When  Admin clicks the sort icon of program Status column
    #Then The data get sorted on the table based on the program status column values in descending order
    
    Scenario: Validate navigation to Batch Page
		Given Admin is on dashboard page after Login
	  When Admin clicks "Batch" from navigation bar
	  Then Admin gets navigated to batch page
      