@activity2
Feature: Search Job
Scenario: Searching Job
    Given User Navigate to Alchemy Job page
    When User Search for full time job
    Then Find a job listing using XPath and it to see job details
    And Find and Click on the Apply for job button
    And Close the browser