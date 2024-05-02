#@UserPageValidation
#Feature: User Page Validation
   #
   #
   #Scenario: Validating landing in User page
   #Given Admin is on the DashboardPage after login
   #When Admin clicks "User" from Navigation bar
   #Then Admin should see the "Manage User" in the URL
    #
    #
   #Scenario: Validate the heading
   #Given Admin is on the DashboardPage after login
   #When Admin clicks "User" from Navigation bar
   #Then Admin should see the heading with text "Manage user" on the page
   #
    #Scenario: Validate the text and pagination icon below the data table
    #Given Admin is on the DashboardPage after login
    #When Admin clicks "User" from Navigation bar
    #Then Admin should see the text as "Showing x to y of z entries" along with Pagination icon below the table 
   #
    #Scenario: Validate data table headers in the User Page
    #Given Admin is on the DashboardPage after login
    #When Admin clicks "User" from Navigation bar
    #Then Admin Should see the data table with column names 
                                                            #
    #
    #Scenario: Validating the default state of Delete button
    #Given Admin is on the DashboardPage after login
    #When Admin clicks "User" from Navigation bar
    #Then Admin should see a Delete button on the top left hand side as Disabled
    #
    #Scenario: Validate Add New user button 
    #Given Admin is on the DashboardPage after login
    #When Admin clicks "User" from Navigation bar
    #Then Admin should be able to see the "+ Add New User" button above the data table
     #
   #
    #Scenario: Validate "+ Assign student"  button in User page     
    #Given Admin is on the DashboardPage after login
    #When Admin clicks "User" from Navigation bar
    #Then Admin should be able to see the "+ Assign student" button above the data table
    #
    #Scenario: Validate "+ Assign staff"  button in User page     
    #Given Admin is on the DashboardPage after login
    #When Admin clicks "User" from Navigation bar
    #Then Admin should be able to see the "+ Assign staff" button above the data table
    #
    #Scenario: Validate search box  in User page     
    #Given Admin is on the DashboardPage after login
    #When Admin clicks "User" from Navigation bar
    #Then Admin should be able to see the search text box above the data table
#
 #
    #Scenario: Validate the number of records (rows of data in the table) displayed
    #Given Admin is on the DashboardPage after login
    #When Admin clicks "User" from Navigation bar
    #Then Admin should see the number of records (rows of data in the table) displayed on the page are 2
                                                    #
    #Scenario: Verify Check box on the data table
    #Given Admin is on the DashboardPage after login
    #When Admin clicks "User" from Navigation bar
    #Then Each row in the data table should have a checkbox
    #
    #Scenario: Verify edit icon on the data table
    #Given Admin is on the DashboardPage after login
    #When Admin clicks "User" from Navigation bar
    #Then Each row in the data table should have a edit icon that is enabled
   #
    #Scenario: Verify delete icon on the data table
    #Given Admin is on the DashboardPage after login
    #When Admin clicks "User" from Navigation bar
    #Then  Each row in the data table should have a delete icon that is enabled
    #
    #Scenario: Search user by name
    #Given Admin is on the DashboardPage after login
    #When Admin clicks "User" from Navigation bar
    #Then Admin should see user displayed with the entered name
    #
    #Scenario: Validating the Search with unrelated keyword
    #Given Admin is on the DashboardPage after login
    #When Admin enters the keywords not present in the data table on the Search box 
    #Then  Admin should see zero entries on the data table
    