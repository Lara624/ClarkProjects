Feature: Application login


Scenario Outline: Validating Login with Correct and Incorrect credentials

Given Initialize the chrome browser and enter the web application URL 

When User enters <username> and <password> and logsin

Then Validate login status

And Close the browser 



Examples:
|username		| |password				|
|SN027710		| |Wiskolowiska2025!	|
|sn029034		| |skyNet@1.com			|
