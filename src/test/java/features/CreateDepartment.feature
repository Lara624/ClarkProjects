Feature: Create Department

Scenario: Validate creation of a new department

Given Chrome Browser is opened

When User has successfully logged into the application

Then User clicks Department 

Then User enters Department name

Then User saves the department

And Department is saved successfully