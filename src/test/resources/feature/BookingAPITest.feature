@api @MB3-101

Feature: Validating api calls for booking

  Scenario: Validating booking api calls with valid data
    Given user sends create booking api POST call with data
    |firstName| Jim|
    |lastName |Brown|
    |totalPrice| 111|
    |depositPaid| true|
    |checkIn    |2018-01-01|
    |checkOut   |2019-01-01|

    Then user validates status code 201 for booking
    And user validates that booking is created with api get call
    When user updates booking with api Patch call with data
    |firstName| James|
    Then user validates status code 201 for booking
    And user validates that booking is created with api get call
    When user deletes booking with api DELETE call
    Then user validates status code 204 for booking
    And user validates that booking is deleted and get call has 404 status code
