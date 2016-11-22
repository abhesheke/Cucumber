Feature: Verify User Creation Using API

Scenario: Creating a user in API and verifying same user in UI

Given I go to "https://qa-u1204-ha-31.lab.vbrick.com/" on "firefox"
And I enter text into "avengerusernametextbox" as "avengerusername"
And I enter text into "avengerpasswordtextbox" as "avengerpassword"
And I click on "avengerloginsubmitbutton"
And I click on "avengerhomepagesettingslinks"
And I create user from api "avengeruseraccountsadminrole" 
And I click on "Avengeruserslink"
And I click on "avengeruserfromuserdropdown"
And I enter text into "Avengerusersearchbox" as "avengerusercreationfirstname"
And I click enter on "Avengerusersearchbox"
Then I Verify element displayed on Screen "true" is "Avengernewuseraftersearch" 
