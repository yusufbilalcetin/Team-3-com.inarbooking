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


  @Flight1
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





