@JDBC
Feature: Validate create employee functionality

  @JDBC_TC01
  Scenario: Validate create employee persisted in Database
    Given User navigates to login page
    When user logs in to HR App
    And user creates new employee
    Then user validates new employee is created in Data Base