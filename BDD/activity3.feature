@activity3
Feature: Post a Job
Scenario Outline: Post Job
Given User Navigate to Alchemy Job page
Then user Go to Post a Job page
When user enters the Job details "<Email>" and "<JobTitle>" and "<Description>" and "<ApplicationEmail>" and "<CompanyName>"
And Submit the Job
Then Verify the "<JobTitle>" listed on Jobs page

 Examples:
    | Email							| JobTitle 			|Description	|ApplicationEmail	|CompanyName|
    | Jobpost6@test.com  | TestEngineer |Automation 	|send6@email.com		|IBM				|
