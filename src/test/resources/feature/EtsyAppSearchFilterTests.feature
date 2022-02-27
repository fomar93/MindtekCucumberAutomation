Feature: Validating Etsy application search and filter functionalities

  #@Before method will run
  Scenario: Validating price range filter functionality for searched items
    Given user navigates to Etsy application
    When user searched for "Carpet"
    And user applies price filter over 1000
    Then user validates that item prices are over 1000

    #@After method will run
  Scenario: Validating price range filter functionality for searched items
    Given user navigates to Etsy application
    When user searched for "Carpet"
    Then user validate search results items contain keyword "Carpet"
    # @After method will run



