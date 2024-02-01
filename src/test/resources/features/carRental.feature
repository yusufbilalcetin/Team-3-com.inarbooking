#Author: AO
#Date: 2024-01-01
#Description: This is a test case for smoke test

#Test Case: BK_HT_001
#Test Title: Validate the Hotel Tab Includes Search Bar for Hotel

#Test Steps:
#1. Navigate to the URL: "test.inar-academy.com"
#2. Click on the Booking Link
#3. Click on the Hotel Tab
#4. Validate the Hotel Tab Includes Search Bar for Hotel

@smoke @carrental
Feature: Car Rental Page

  Background:
    Given The user navigate to the baseURL
    And The user click on the Booking Link

  Scenario Outline: Validate pickup location

    When they click on "<CarType>" car's Rent Car button
    Then They see the same "<PickupLocation>" with the card
    When The user changes Pickup location as "<NewLocation>"
    And They click on View Deal button
    Then They see the same pickup location "<NewLocation>" on the page

    Examples:
      | CarType | PickupLocation   | NewLocation        |
      | Medium  | Central Park     | Golden Gate Bridge |
      | Large   | Heathrow Airport | Grand Bazaar       |

  Scenario Outline: Validate car size
    When They navigate to the car rental page
    And They choose "<CarType>" Car Category
    Then They see only "<CarType>" cars
    When They click on the first car's View Deal button
    Then They navigate to the Deal Page
    And They see "<CarType>" size on the car details

    Examples:
      | CarType |
      | Small   |
      | Medium  |
      | Large   |
      | Minivan |
      | SUV     |