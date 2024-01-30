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

@smoke @FlightTab
Feature: Flight Tab
#
  Background:
    Given I navigate to the baseURL
    And I click on the Booking Link

  Scenario: Validate the Flight Tab Includes Search Bar and Options for Flight

    When User clicks on the Flight Tab
    Then User validates the Flight Tab Includes Search Bar and Options for Flight