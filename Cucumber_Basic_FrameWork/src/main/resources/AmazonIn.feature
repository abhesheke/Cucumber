Feature: Navigate to Amazon Site

Scenario: Open Amazon.in and search for IPhone

Given I go to "http://www.amazon.in/" on "chrome"
And I enter text into "amazonsearchbox" as "iphone"
And I click on "amazonsearchbutton"
And I click on "amazoniphone6srosecolor"
And I want to switch window on "childwindow"
And I get text for "iphone6srosecolorprice"
Then Search should be "pass"

