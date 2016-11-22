#Story AV-123 : Test login of something

Feature: Navigate to Compugain CGTT

@login
Scenario: Open Compugain CGTT page
Given I go to "url" on "browser"
And I enter text into "usernamelocator" as "username"
And I enter text into "passwordlocator" as "password"
And I click on "submitButton"
Then Search should be "pass"