#Author: YBC
#Date: 2024-02-01
#Description: This is a test case for smoke test

#Test Case: BK_FL_001
#Test Title: Validate the Flight Tab Includes Search Bar and Options for Flight

#Test Steps:
#1. Navigate to the URL: "test.inar-academy.com"
#2. Click on the Booking Link
#3. Click on the Flight Tab
#4. Validate the Flight Tab Includes Search Bar and Options for Flight

@verification
Feature: Flight tabs

  Background:
    Given The user navigate to the baseURL
    And The user click on the Booking Link
  @verificationmessage
  Scenario:Verification of Flights Home Page tabs
    When The user click on the Flight Tab
    Then The user should see "Find your next flight" message

  @verification
  Scenario Outline:Verification of Flight Home Page tabs
    Given The user click on the Flights page
    When The user clicks on the round way radio
    And The user selected depature country as a "<departure country>"
    And The user selected arrival country as a "<arrival country>"
    And The user selected depature date as next month of "<depature date>" and return date as "<return date>"
    And The user choose the adult number as "<adult number>" and the children number as "<children number>"
    And The user clicks on the search flights button

    Then The user should see "Find your next flight" message
    And The user should see that just list of "<departure country>" and "<arrival country>" are displayed
    And the user should see that just list of "<departure date>" is displayed
    And the user should see that just round way on the tickets
    Examples:
      | departure country | arrival country | depature date | return date | adult number | children number |
      | Canada            | Spain           | 7             | 12          | 20           | 4               |
      | USA               | Spain           | 7             | 12          | 20           | 4               |
      | Australia         | United Kingdom  | 8             | 4           | 100          | 100             |