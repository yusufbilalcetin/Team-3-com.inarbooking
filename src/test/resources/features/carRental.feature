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


  @smoke @CarRentalsTab
  Scenario Outline: Search for a Volkswagen Polo in Heatrow Airport,which is manual and small, and validate rental details
    When The user click on the Car Rental Tab
    And The user enters pickup "<Location>"
    And The user enters "<PickupDate>" "<DropoffDate>" "<PickupHour>" "<DropoffHour>"
    And The user clicks on the search cars button
    Then The user should see car rental details page.
    And The user should see "<Location>" "<PickupDate>" "<DropoffDate>"  correctly
    When The user selects <Age>
    Then The user should see the correct age checkbox reaction according to <Age>
    When The user checks the all price ranges
    And The user checks the car specifications
    #And The user checks the car's "<Transmission>"
    And The user checks the  "<CarCategory>"
    Then The user should see the car image is selected corresponding to "<CarCategory>"
    When The user clicks on the search button
    Then The user should see that the available cars are listed
    When The user clicks on the "<SortType>" button
    Then The user should see the prices sorted according to "<SortType>"
    When The user clicks on the desired car's view deal button
    Then The user should see deal page
    And The user should see the "<Location>" "<PickupDate>" "<DropoffDate>" "<CarCategory>" as desired
    When The user selects "<Insurance>"
    Then The user should see the Total Car Price Breakdown correctly according to <Age> "<Insurance>"
    When The user clicks on book button
    Then The user should see the billing page
    When The user enters billing information
    And The user enters card information with "<CardNumber>" "<ExpDate>" "<CVV>"
    And The user click on Book button
    Then The user should see the confirmation page
    Then The user should see "<Location>" "<PickupDate>" "<DropoffDate>" on confirmation page

    Examples:
      | Location           | PickupDate | DropoffDate | PickupHour | DropoffHour | Age | Transmission | CarCategory | SortType      | Insurance       | CardNumber       | ExpDate | CVV  |
      | Heathrow Airport   | 02.04.2024 | 02.05.2024  | 06:30      | 11:00       | 25  | Automatic    | Small       | Price Highest | Full Protection | 4565865898797576 | 1225    | 1234 |
      | Central Park       | 02.04.2024 | 02.05.2024  | 08:30      | 23:00       | 30  | Automatic    | Medium      | Price Lowest  | No Insurance    | 4565865898797576 | 1235    | 132  |
      | Sydney Opera House | 02.04.2024 | 02.05.2024  | 11:30      | 20:00       | 65  | Manual       | SUV         | Price Highest | Full Protection | 4565865898797576 | 0828    | 723  |

  Scenario: Bug Scenario: The user selects car specifications without transmission and then selects transmission options.
    When The user click on the Car Rental Tab
    And The user enters pickup "Heathrow Airport"
    And The user enters "02.04.2024" "02.05.2024" "06:30" "11:00"
    And The user clicks on the search cars button
    Then The user should see car rental details page.
    And The user should see "Heathrow Airport" "02.04.2024" "02.05.2024"  correctly
    When The user selects 30
    Then The user should see the correct age checkbox reaction according to 30
    When The user checks the all price ranges
    And The user checks the car specifications
    And The user checks the  "Small"
    Then The user should see the car image is selected corresponding to "Small"
    When The user clicks on the search button
    Then The user should see that the available cars are listed
    When The user returns to the transmission options section
    And The user checks the car's "Automatic"
    And The user checks the car's "Manual"
    When The user clicks on the search button again
    Then The user should see that the available cars are listed
    And The user should see the same listed cars




