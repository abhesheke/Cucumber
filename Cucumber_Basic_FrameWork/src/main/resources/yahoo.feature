Feature: Navigate to Yahoo.com Site

Scenario: Verify Yahoo page is displayed

Given I go to "https://www.yahoo.com/" on "chrome"
Then Expected and Actual Is "yahoo" as "yahoo1"
 
Scenario: Verify Yahoo Mail SignUp using search

Given I go to "https://www.yahoo.com/" on "chrome"
And I click on "flagdropdown"
And I click on "selectusenglish"
And I enter text into "yahoocomsearchbox" as "yahoomail"
And I click on "yahoocomsearchbutton"
And I get text for "yahoomaillink"
Then Expected and Actual "yahoo" as "yahoomaillink" 




