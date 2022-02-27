@MB-10
  Feature:Validating location api calls
    Scenario: Validating location api calls
      Given User post location api call with data
        |locationCity|Chicago|
        |locationCountry|US |
        |locationState |Illinois|
# |locationId | generate |
      Then User validates 201 status code

     When User sends get location api call with created locationId
    Then User validates 200 status code
    When User sends delete location api call with created locationId
   Then User validates 204 status code
     When User sends get location api call with created locationId
  Then User validates 404 status code