@stays
Feature: Stays Filtering

  Background:
    Given The user navigate to the baseURL
    And The user click on the Booking Link

  Scenario: Validate that the Hotel Search Filters by Hotel Name
    When The user click on the Search Hotels button
    And The user send "Italy" to destination field
    And The user click on Search button
    And I click on the #1 Hotel's See availability button
    And I click on the Reserve or Book Now! button
    And I write "MyName" to the first name field
    And I write "MyLastName" to the last name field
    And I write "MyEmailAdress@gmail.com" to the e mail address field
    And I click on the I'm booking for someone else button
    And I write "nutella" to the special requests field
    And I select I don't know for the Your arrival time selector
    And I clicked Next, Final Details button
    And I selected "United States" as a Country,Region
    And I write "4353436343" to the phone number input field
    And I click confirmation button
    And I click save your details
    And I click consent market emails
    And I click consent transport details
    And I write "Taha" to the cardholders's name input field
    And I write "4444444444444444" to the card number input field
    And I write "0326" to the expiration date input field
    And I write "345" to CVV code input field
    And I click complete booking button
    Then I validate booking from hotel name

    Scenario Outline:Validate that selected hotel location information is true
      When The user send "<location>" to input field
      And The user click on the Search Hotels button
      And The user choose "<feature of hotel>" of checkbox activities
      And The user click Search button
      Then Validate hotel "<Location informations>"
      Examples:
        | location | feature of hotel   | Location informations |  |
        | Istanbul | Baggage storage    | Turkey                |  |
        | Berlin   | 24-hour front desk | Germany               |  |
        | Istanbul | Elevator           | Turkey                |  |
        | Tokyo    | Walking Tours      | Japan                 |  |
        | Paris    | Riverside Inn      | France                |  |
        | Paris    | Private Parking    | France                |  |

    Scenario: Validate that selected hotel name is correct
      When The user send "Netherlands" into input field
      And The user click on the Search Hotels button
      And The user choose "Daily housekeeping" of the Checkbox activities
      And The user click Search button
      And The user click on #1 See Availability button
      Then Validate Hotel name is same with your choice

    Scenario: Validate hotel fee is correct
      When The user send "Istanbul" into input field
      And The user choose date of location
      And The user choose customer informations
      And The user click on the Search Hotels button
      And The user choose "Baggage storage" of the Checkbox activities
      And The user click Search button
      And The user click on #1 See Availability button
      And I click on the Reserve or Book Now! button
      Then Valiate that hotel fee is correct after tax

      Scenario: Validate that hotel per night price is correct
        When The user send "Italy" into input field
        And The user click on the Search Hotels button
        And The user choose "Daily housekeeping" of the Checkbox activities
        And The user click Search button
        And The user click on #1 See Availability button
        Then Validate that hotel per night price is correct











