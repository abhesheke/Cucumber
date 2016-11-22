Feature: Navigate to TataSky and Get Subscription Package Details 

Scenario: Get TataSky Subscription Package Details

Given I go to "https://www.mytatasky.com/web/portal/home/-/portal/login/" on "Chrome"
And I enter text into "rmntextbox" as "tataskyRMN"
And I click on "tataskylogin"
And I get text for "subcriptionID"
And I get text for "accountbalance"
And I get text for "rechargeduedate"
And I get text for "recommendedrecharge"
And I click on "view/modifypackagestab"
And I enter text into "profilepasswordtextbox" as "tataskyprofilepassword"
And I click on "submitbutton"
And I get text for "basicpackpresent"
And I get text for "basicpacknamepresent"
And I get text for "basicpackprice"
And I get text for "freepacks"
And I get text for "hdprice"
And I clicked "99packradiobutton"
And I clicked "99packchangepackbutton"
Then I Verify element displayed on Screen "true" is "proceedbutton" 

@TataskyFailScenario 
Scenario: Trying to Recharge account with "0" Rs  

Given I go to "https://www.mytatasky.com/web/portal/home/-/portal/login/" on "Chrome"
And I enter text into "rmntextbox" as "tataskyRMN"
And I click on "tataskylogin"
And I click on "rechargetab"
And I enter text into "tataskyrechargeamounttextbox" as "tataskyrechargeamount"
And I click on "tataskyrechargeamountgobutton"
Then I Verify element displayed on Screen "true" is "proceedtorecharge" 