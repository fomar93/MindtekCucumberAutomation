@PorscheApp

Feature: Validating Porsche App functionality

Scenario: Validating Porsche Price
Given user navigates to Porsche application
When user stores the "price" and selects the model 718 Cayman
Then user validates Base price is matched with listed price
@PorcheApp2
Scenario: Validating Porsche Price For Equipment
Given user navigates to Porsche application
When user stores the "price" and "selects" the model 718 Cayman
And user adds Power Sport Seats (14-way) with Memory Package
Then user validates that Price For Equipment is added and price matches