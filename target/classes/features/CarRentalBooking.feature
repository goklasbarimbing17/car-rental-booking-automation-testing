Feature: Car rental booking

  Scenario: Book a car rental without a driver
    Given I am on the car rental booking page "http://traveloka.com/car-rental"
    When select the car product
    And select the "Without Driver" tab
    And select pick-up location as "Jakarta"
    And select pick-up date 2 days from today at "09:00"
    And select drop-off date 5 days from today at "11:00"
    And click the search car button
    And select a car from the list
    And select the car provider
    And click the continue button on product detail
    And select rental office pick-up location as "Rental Office"
    And select drop-off location as "Other Location"
    And input Pick-upDrop-off notes
    And click the book now button
    And fill the contact details
    And fill the driver details
    And click continue
    And check all rental requirements
    And click continue to proceed
    And select the payment method "Bank Virtual Account" and proceed payment
    Then the car rental booking should be successful
