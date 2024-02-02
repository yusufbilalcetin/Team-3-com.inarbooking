#Author: AO
#Date: 2024-01-01
#Description: This is a test case for smoke test
#
#Test Case: BK_FL_001
#Test Title: Validate the Flight Tab Includes Search Bar and Options for Flight
#
#Test Steps:
#1. Navigate to the URL: "test.inar-academy.com"
#2. Click on the Booking Link
#3. Click on the Flight Tab
#4. Validate the Flight Tab Includes Search Bar and Options for Flight
#
#@FlightFilter
#Feature: Flight Filtering
#
#  Background:
#    Given The user navigate to the baseURL
#    And The user click on the Booking Link
#
#  Scenario: Validate that the Search Flights filters by Airlane X
#
#    When The user click on the Flight Tab
#    And The user selected "One Way" button
#    And The user User selected button type "Business" travel
#    And the user selected "USA" as depature country
#    And the user selected "Germany" as arrival country
#    And the user selected Departure Date
#    And the user selected passengers
#    And The user click on the Search Flights Button
#    And The user click on the "Airlane X" Check Box on the left side
#    And The user click on the Search button on the left side
#    And The user click on the #1 Flight's See availability Button
#    Then The user validate the Flight has the "Airlane X"
#
#  Scenario: Validate the Flight Tab Includes Search Bar and Options for Flight
#
##    When User clicks on the Flight Tab
#    Then User validates the Flight Tab Includes Search Bar and Options for Flight
#
#
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


@FlightTicket

Feature: Flight Booking

  Background:
    Given The user navigate to the baseURL
    And The user click on the Booking Link


  Scenario Outline: Validate that the User buys the flight ticket successfully

    When The user click on the Flight Tab
    And The user selected "<tripType>" button
    And The user selected button type "<ticketClassType>" travel
    And the user selected "<fromCountry>" as departure country
    And the user selected "<toCountry>" as arrival country
    And the user selected Departure and Return Dates
    And The user click on the Search Flights Button
    Then the user sees the Flights Page

    When the user click on Search Button
    And the user click on "<TicketType>" tab
    And the user click on Select Ticket button
    And the user click on Select Return Ticket Button
    Then the user sees the Choose your fare Page.

    When the user click on "<FareType>" fare
    And the user click on Select Who's flying button
    Then the user sees the Who is flying page

    When the user fills the email box with "<email>"
    And the user selects the phoneNumberType
    And the user fills the phone number box with the "<phoneNumber>"
    And the user selects the Get Free Text Messages Checkbox
    And the user fills the name box with the "<name>"
    And the user fills the surname box with the "<surname>"
    And the user selects the "<gender>"
    And the user selects the birthdate year as "<year>"
    And the user selects the month as "<month>"
    And the user selects the birthdate day as "<day>"
    And the user click on Select Extras button
    Then the user sees Extras for your Flight Page

    When the user selects meal as "<mealType>"
    And the user selects "<extras>"
    And the user click on Go To Checkout Button
    Then the user sees the CheckOut Page

    When the user fills the Cartholder's Name field with "<cardholderName>"
    And the user fills the card Number field with "<cardNumber>"
    And the user fills the expiry date field with "<expiryDate>"
    And the user fills the cvv field with "<cvvNumber>"
    And the user selects the acceptanceCheckBox of updates
    And the user click on Complete Booking button
    Then the user sees the Confirmation Page

    When the user click on Close button
    Then the user sees the HomePage



    Examples:
      | tripType   | ticketClassType | fromCountry | toCountry | TicketType | FareType | email                | phoneNumber | name | surname | gender | year | month | day | mealType            | extras | cardholderName | cardNumber       | expiryDate | cvvNumber |
      | Round Trip | Economy         | USA         | Canada    | Cheapest   | Main     | JohnLennon@gmail.com | 3123123123  | John | John    | Male   | 2005 | 1     | 1   | Standard Meal - $15 | 1      | John Lennon    | 1596369874125454 | 1228       | 864       |







