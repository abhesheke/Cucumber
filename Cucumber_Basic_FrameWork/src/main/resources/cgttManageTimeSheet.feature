#Story AV-123 : Test login of something

Feature: Navigate to Compugain CGTT

Navigate to Compugain CGTT page
Enter Username and Password
checking manage time sheet
Login should be success

@login
Scenario: Open CGTT Manage Time Sheet page

Given I go to "url" on "browser"
And I enter text into "usernamelocator" as "cgttusername"
And I enter text into "passwordlocator" as "cgttpassword"
And I click on "submitButton"
And I click on "managetimesheetlink"
Then Search should be "pass"
 
 