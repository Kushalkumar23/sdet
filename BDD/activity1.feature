@activity1
Feature: Login Test
Scenario: Testing Login
    Given User is on Login page
    When User enters username and password
    And Locate the AddNew button and click it
    When User enters new user details
    And Verify new user has been created
    And Close the Browser