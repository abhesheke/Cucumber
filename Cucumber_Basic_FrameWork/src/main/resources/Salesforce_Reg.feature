#Story: Salesforce Registartion 

Feature: Navigate to Salesforce Registartion page

Navigate to Saleforce Registartion page
Enter all the feilds

@salesforceRegistartion
Scenario: Open SalesForce Registartion page

Given I go to "url" on "browser"
And I enter text into "salesforceRegfirstnamelocator" as "salesforceRegfirstname"
And I enter text into "salesforceReglastnamelocator" as "salesforceReglastname"
And I enter text into "salesforceRegemaillocator" as "salesforceRegemail"
And I enter text into "salesforceRegphonelocator" as "salesforceRegphone"
And I enter text into "salesforceRegcompanylocator" as "salesforceRegcompany"
And I click on "salesforceRegemployeesdropdownlocator"
And I click on "selectedemployees"
And I enter text into "salesforceRegepostalcodelocator" as "salesforceRegepostalcode"
And I click on "salesforceRegsignmeuplocator"
Then Search should be "pass"