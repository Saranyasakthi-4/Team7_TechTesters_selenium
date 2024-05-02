@tagNavigationValidationfromManageProgramtootherPages

Feature: NavigationValidationfromManageProgramtootherPagesone
     

  Scenario: Batch link on navigation bar 
    Given Admin is on Manage Program page
    When  Admin clicks on Batch link on Manage Program page
    Then Admin is re-directed to Batch page
  
    Scenario: User link on navigation bar
    Given Admin is on Manage Program page
    When  Admin clicks on User link on Manage Program page
    Then Admin is re-directed to User page
    
    Scenario: Logout link on navigation bar
    Given Admin is on Manage Program page
    When  Admin clicks on Logout link on Manage Program page
    Then Admin is re-directed to Login page
    
