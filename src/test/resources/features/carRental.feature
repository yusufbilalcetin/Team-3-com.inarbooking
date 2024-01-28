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

@smoke @HotelTab
Feature: Hotel Tab

  Background:
    Given The user navigate to the baseURL
    And The user click on the Booking Link

  Scenario: Validate the Hotel Tab Includes Search Bar for Hotel

    When The user click on the Hotel Tab
    Then The user validate the Hotel Tab Includes Search Bar for Hotel