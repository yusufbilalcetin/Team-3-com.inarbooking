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

@smoke @example @home
Feature: User Navigation on Booking Home Page

  Background:
    Given I navigate to the baseURL
    And I click on the Booking Link

  Scenario Outline: Navigate and Verify Tabs
    When they click on the "<Tab>" tab
    Then the header title should be "<ExpectedTitle>"
    And the header button text should be "<ExpectedButtonText>"

    Examples:
      | Tab         | ExpectedTitle            | ExpectedButtonText |
      | Stays       | Find your next stay      | Search Hotels      |
      | Flights     | Find your next flight    | Search Flights     |
      | Car Rentals | Rent a Car for Your Trip | Search Cars        |


  Scenario Outline: Navigate to Flights Page and Filter by Country via three pictures
    When they click on the <FlightButton> button
    Then they navigate to the Flights page
    And see flights filtered from "<DepartureCountry>" to "<DestinationCountry>"
    And see all flights from "<DepartureCountry>" to "<DestinationCountry>"

    Examples:
      | FlightButton | DepartureCountry | DestinationCountry |
      | 1            | Spain            | Canada             |
      | 2            | Italy            | United Kingdom     |
      | 3            | Germany          | France             |


  Scenario Outline: Navigate to Hotels and Flights pages via Offers section buttons
    When they click on the "<PageButton>" button
    Then they navigate to the "<Page>" page

    Examples:
      | PageButton  | Page    |
      | Book Flight | Flights |
      | Find a stay | Hotels  |

