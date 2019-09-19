Feature: Confirmation of the Invite a Friend Feature

Scenario: Validate that a User can invite a friend on the web application

Given User is logged into the  application

When User clicks the Freunde einladen

Then User scrolls to the per E-mail einladen text box 

Then User clicks the E-mail einladen

And User verifies that an onscreen notification message is recieved