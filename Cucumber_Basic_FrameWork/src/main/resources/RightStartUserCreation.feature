Feature: RightStart UserCreation

Scenario: Create An Account in RightStat Application
Then I Get Scenario Name
Then I Get Feature Name "RightStart UserCreation" 
Given I Goto "https://www.rightstart.com/customer/account/login" on "chrome"
And I Click On "guestCheckoutLocator"
And I enterdata into "firstname" as "testdata1"
And I enterdata into "lastname" as "testdata2"
And I enterdata into "emailaddress" as "testdata3"
And I select "hearaboutdropdown" value as "testdata4"
And I enterdata into "password" as "testdata5"
And I enterdata into "confirmpassword" as "testdata6"
And I Click On "CreateAccountButton"
Then I Close Browser

Scenario: Edit Account Details in Right Start Application
Then I Get Scenario Name
Then I Get Feature Name "RightStart UserCreation"
Given I Goto "https://www.rightstart.com/customer/account/login" on "chrome"
And I Click On "guestCheckoutLocator"
And I enterdata into "firstname" as "testdata1"
And I enterdata into "lastname" as "testdata2"
And I enterdata into "emailaddress" as "testdata3"
And I select "hearaboutdropdown" value as "testdata4"
And I enterdata into "password" as "testdata5"
And I enterdata into "confirmpassword" as "testdata6"
And I Click On "CreateAccountButton"
And I Click On "editbutton"
And I Clear Data from "firstname"
And I enterdata into "firstname" as "testdata7"
And I Clear Data from "lastname"
And I enterdata into "lastname" as "testdata8"
And I Click On "editsavebutton"
Then I Close Browser