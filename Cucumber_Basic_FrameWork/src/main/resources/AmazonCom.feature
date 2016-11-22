

Feature: Navigate to Amazon.Com Site

Scenario: Open Amazon.com and search for IPhone

Given I go to "http://www.amazon.com" on "chrome"
And I enter text into "amazonsearchbox" as "iphone6s"
And I click on "amazonsearchbutton"
And I click on "amazoncomiphone6s"
And I get text for "iphone6srosecolorprice"
Then Search should be "pass"

