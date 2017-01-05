Feature: Navigate to Amazon.Com Site

Scenario: Open Amazon.com and search for IPhone

Given I go to "http://www.amazon.com/" on "chrome"
And I select Amazoncom "stayonamazoncom"
And I enter text into "amazonsearchbox" as "iphone6s"
And I click on "amazonsearchbutton"
And I click on "amazoncomiphone6s"
And I get text for "iphone6srosecolorprice"
Then Expected and ActualAssertion "iphone6srosecolorprice" as "$489.95"

Scenario: Verify checkout address for amazon.com

Given I go to "http://www.amazon.com/" on "chrome"
And I select Amazoncom "stayonamazoncom"
And I enter text into "amazonsearchbox" as "bag"
And I click on "amazonsearchbutton"
And I click on "amazoncomselectedbag"
And I click on "amazoncomselecteditemaddtocart"
And I click on "amazonproceedtocheckout"
And I enter text into "amazonsigninemailtextbox" as "amazonemail"
And I enter text into "amazonsigninpasswordtextbox" as "amazonpassword"
And I click on "amazonsiginbutton"
And I click on "amazonshippingaddress"
And I get text for "amazonshippingerrormeg"
Then Search should be "pass"


