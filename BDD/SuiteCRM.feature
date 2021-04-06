@SuiteCRMActivities
Feature: Application testing on SuiteCRM Site


	Background: User is Logged In CMR Site
    Given I navigate to the login page
    When I submit username and password
    Then I should be logged in

  @activity3_1
  Scenario: Open the homepage and count the number of the dashlets on the page
    Given Login to CRM Site
    When main page is displayed
    Then Count the number of Dashlets on the homepage
    And Print the number and title of each Dashlet into the console
    And Close the browser


	@activity3_2
	Scenario: Open the Leads page and add multiple lead accounts using values passed from  Feature file
		Given Navigate to Create Lead page
    When Fill in the necessary details "Mr." and "Jags" and "BR"
    Then Click Save to finish
    And Navigate to the View Leads page to see "Mr. Jags BR"
    And Close the browser

	@activity3_3
	Scenario Outline: To schedule a meeting and include at least 3 invitees
		Given Navigate to Meeting setup page
    When Enter the details of the meeting
    Then The names "<Invitee1>" and "<Invitee2>" and "<Invitee3>" and Click Save
    And Navigate to View Meetings page and confirm creation of the meeting
    And Close the browser
    
   Examples:
		    | Invitee1  | Invitee2 		| Invitee3 |
		    | Test			| Inchar      | Jag      |
		
		
	@activity3_4
	Scenario Outline: To use an external Excel to add products
		Given Navigate to Create product page
    When Enter the details of the product "<name>" and "<price>"
    Then Click Save
    And Go to the "View Products" page to see product "<name>" listed
    And Close the browser
    
   Examples:
		    | name  		| price|
		    | Ball			| 2    |
		    | Chocolate | 3 	 |