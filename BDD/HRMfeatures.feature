@OrangeHRMActivities
Feature: Application testing OrangeHRM
  
  @activity2_1
  Scenario: To create a job vacancy for "DevOps Engineer" 
    Given Navigate to the "Recruitment" page
    And Click on the "Vacancies" menu item to navigate to the vacancies page
    When Click on the "Add" button to navigate to the "Add Job Vacancy" form
    And  Fill out the necessary details and Click the "Save" button
    Then Verify that the vacancy was created


  @activity2_2
  Scenario: Add information about a candidate for recruitment
    Given Navigate to the "Recruitment" page
    When Click on the "Add" button to navigate to the candidate information form
    And Fill out the necessary details and Upload a resume to the form
    And Fill out the necessary details and Click the "Save" button
    Then Navigate back to the Recruitments page to confirm candidate entry
    
  @activity2_3
  Scenario Outline: Add multiple employees using an the Examples table
    Given Navigate to the PIM page
    When Click on the "Add" button to navigate to the employee information form
    And Fill out "<firstName>" and "<lastName>" and "<username>" and Create Login Details checkbox is checked
    And Fill out the necessary details and Click the "Save" button
    Then Navigate back to the employee page to confirm employee "<firstName>" entry
    
    Examples:
		    | firstName   | lastName 		| username |
		    | john				| Automation 	| kush01  |
		    | jagadish    | Automation	| kush01  |

		    
	@activity2_4
  Scenario Outline: Creating multiple vacancies using data the Examples tables
    Given Navigate to the "Recruitment" page
    And Click on the "Vacancies" menu item to navigate to the vacancies page
    When Click on the "Add" button to navigate to Add Job Vacancy form
    And Fill out "<Job_Title>" and "<JobVacancy_name>" and "<hiringManager>" and "<noOfPositions>" and Click the "Save" button
    Then Verify that the vacancy "<JobVacancy_name>" was created
    
    Examples:
									|Job_Title    | JobVacancy_name   | hiringManager 		| noOfPositions |
									| 1           | SDET1 Automation		| Test Tester 			| 1  			|
									| 2          	| SDET2 Automation   | Test Tester				| 1  			|
									|	3          	| SDET3 Automation			| Test Tester				| 1				|
	