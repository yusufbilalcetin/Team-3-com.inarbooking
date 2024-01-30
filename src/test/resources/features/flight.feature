#Author: AO
#Date: 2024-01-01
#Description: This is a test case for smoke test

#Test Case: BK_FL_001
#Test Title: Validate the Flight Tab Includes Search Bar and Options for Flight

#Test Steps:
#1. Navigate to the URL: "test.inar-academy.com"
#2. Click on the Booking Link
#3. Click on the Flight Tab
#4. Validate the Flight Tab Includes Search Bar and Options for Flight

@FlightFilter
Feature: Flight Filtering

  Background:
    Given The user navigate to the baseURL
    And The user click on the Booking Link

  Scenario: Validate that the Search Flights filters by Airlane X

    When The user click on the Flight Tab
    And The user selected "One Way" button
    And The user User selected button type "Business" travel
    And the user selected "USA" as depature country
    And the user selected "Germany" as arrival country
    And the user selected Departure Date
    And the user selected passengers
    And The user click on the Search Flights Button
    And The user click on the "Airlane X" Check Box on the left side
    And The user click on the Search button on the left side
    And The user click on the #1 Flight's See availability Button
    Then The user validate the Flight has the "Airlane X"

  Scenario: Validate the Flight Tab Includes Search Bar and Options for Flight

#    When User clicks on the Flight Tab
    Then User validates the Flight Tab Includes Search Bar and Options for Flight


#  Scenario: Validate that the Hotel Search filters by Free Parking
#
#    When The user click on the Hotel Tab
#    And The user click on the Search Hotels Button
#    And The user click on the "Free parking" Check Box on the left side
#    And The user click on the Search button on the left side
#    And The user click on the #1 Hotel's See availability Button
#    Then The user validate the Hotel has the "Free Parking"
#
#
#  Scenario Outline: Validate that the Hotel Search filters by selected choice
#
#    When The user click on the Hotel Tab
#    And The user click on the Search Hotels Button
#    And The user click on the "<filter>" Check Box on the left side
#    And The user click on the Search button on the left side
#    And The user click on the #1 Hotel's See availability Button
#    Then The user validate the Hotel has the "<filter>"
#
#    Examples:
#      | filter         |
#      | Free parking   |
#      | Fitness center |
#      | Free WiFi      |
#      | Cycling        |

