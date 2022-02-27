@HrAppNewEmployee
Feature:  create a new employee in Hr App
 Scenario Outline: User creates a new employee in Hr App
   Given User navigates to HR App "<Login>" page
   When user enters "Mindtek" for username and "MindtekStudent" for password and clicks login button
   And User provides data for the input fields and clicks on SAVE button
   Then User validates new employee is created

   Examples:
     | Login                                      |
     | https://devenv-webhr-arslan.herokuapp.com/ |
     | https://qeenv-webhr-arslan.herokuapp.com/  |



