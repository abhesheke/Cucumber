Feature: Navigate to Amazon.Com 

Scenario: Open Amazon.com and search for IPhone

Given I go to "http://www.amazon.com" on "chrome"
And I get Feature Name is "Navigate to Amazon.Com" 
And I get Scenario Name is "Open Amazon.com and search for IPhone"
And I enter text into "amazonsearchbox" as "iphone6s"
And I click on "amazonsearchbutton"
And I click on "amazoncomiphone6s"
Then Expected and ActualAssertion "iphone6srosecolorprice" as "$469.15"
