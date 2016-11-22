#story:carwale registration

Feature: carwale registration page

@carwaleRegistration
Scenario: carwale registration

Given I go to "http://www.carwale.com/users/register.aspx" on "chrome"
And I enter text into "carwaleRegnametextboxlocator" as "carwaleusername"
And I enter text into "carwaleRegemailtextboxlocator" as "carwaleuseremail"
And I enter text into "carwaleRegconfirmemailtextboxlocator" as "carwaleuserconfirmemail"
And I enter text into "carwaleRegpassword" as "carwaleuserpassword"
And I enter text into "carwaleRegconfirmpassword" as "carwaleuserconfirmpassword"
And I click on "carwaleregbuttonlocator"
Then Search should be "pass"


@carwaleForgotPassword
Scenario: carwale reset forgot password

Given I go to "http://www.carwale.com/users/register.aspx" on "chrome"
And I click on "carwaleloginlinklocator"
And I click on "carwaleforgotpassword"
And I enter text into "carwaleforgotpasswordtextboxlocator" as "carwaleuseremail"
And I click on "carwaleforgotpasswordsendlocator"
 
 
@GuerillaMail 
Scenario: Guerilla mail

Given I go to "https://www.guerrillamail.com" on "chrome"
And I click on "guerillatestbutton"
And I enter text into "guerillatextbox" as "emailRandomValue"
And I click on "guerillasetbuttonlocator"
And I click on "guerillaResetPasswordEmail"
And I click on "guerillaResetlink"



