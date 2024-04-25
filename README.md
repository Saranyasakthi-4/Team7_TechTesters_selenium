# Team7_TechTesters_selenium

How to use the Tech Testers Repo

Below is the github repository branching structure to be followed by team

                                    main
                                     |
                                     |
          --------------------------------------------------------------
         |                     |                     |                  |    
         |                     |                     |                  |
         |                     |                     |                  |
    feature/feature1     feature/feature2      feature/feature3     feature/feature4
         |                     |                     |                  | 
         |                     |                     |                  | 
    jira-ticket-no        jira-ticket-no        jira-ticket-no      jira-ticket-no
 
 Guidelines for branching to work on a new feature
 -------------------------------------------------
  1. create a new branch from main with the name feature/<your feature name>
  2. switch you branch to newly created feature/<your feature name> branch
  3. Next step create a new branch from feature/<your feature name> with the jira ticket no you are currently working on.
  4. Switch to new jira no branch and commit your changes and push to github after testing it locally.
  5. Once you are confident with local testing create a pull request from jira-ticket-no branch to feature/<your feature branch>. Have the PR reviewed by your team members
  6. Team members or lead can approve the PR or provide comments. Once PR is passes the review merge the PR to feature/<your feature branch>
  7. Repeat step 3 to 6 for every jira until you finish the feature.
  
  Example:
  1.clone your repo
  2.checkout main branch
  3. create new feature branch called feature/login-module from main
  4. checkout feature/login-module
  5. create new branch jira-20_create_step_def from  feature/login-module
  6. checkout jira-20_create_step_def and commit and push your changes after testing locally
  7. Once development is complete for jira-20_create_step_def raise PR to merge jira-20_create_step_def and feature/login-module
  8. Have the PR reviewed by the team members
  9. Once PR is approved merge jira-20_create_step_def to feature/login-module
  10. repeate 5 to 9 for all the identified jira stories or task.
  
  Guidelines to merge all features to main
  -----------------------------------------
  
  1. Riase a PR from feature1 to main