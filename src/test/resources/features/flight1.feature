@Flight1
Feature: Flight Filtering

  Background:
    Given The user navigate to the baseURL
    And The user click on the Booking Link

  Scenario: Validate that the Search Flights filters by Airline C

    When The user clicks on the Flight Tab
    And The user selects One Way button
    And The user selects button type First Clas travel
    And the user selects "France" as departure country
    And the user selects "China" as arrival country
    And the user selects Departure Date
    And the user selects passengers
    And The user clicks on the Search Flights Button
    And The user clicks on the Airline C Check Box on the left side
    And The user clicks on the Search button on the left side
    Then The user clicks on the See Availability button on Airline C

