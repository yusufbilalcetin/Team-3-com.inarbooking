package stepDefinitions.flightBooking;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import stepDefinitions.BaseStep;

import static org.assertj.core.api.Java6BDDAssertions.then;

public class FlightVerification_stepDefs extends BaseStep {

    public static final Logger LOGGER = LogManager.getLogger(FlightVerification_stepDefs.class);
    public static String depatureDate;
    public static String returnDate;

    @Given("The user click on the Flights page")
    public void the_user_click_on_the_flights_page() {
        PAGES.getBookingHomePage().clickOnFlightsTab();
        LOGGER.info("I clicked on the Flight Tab");
    }

    @When("The user clicks on the round way radio")
    public void the_user_clicks_on_the_round_way_radio() {
        PAGES.getFlightTabVerification().chooseRoundTrip();
        LOGGER.info("I Choose  on the Round Trip");
    }

    @When("The user selected depature country as a {string}")
    public void the_user_selected_depature_as_a(String string) {
        PAGES.getFlightTabVerification().chooseDepartureCountry(string);
        LOGGER.info("The user selected depature as a " + string);
    }

    @When("The user selected arrival country as a {string}")
    public void the_user_selected_arrival_country_as_a(String string) {
        PAGES.getFlightTabVerification().chooseArrivalCountry(string);
        LOGGER.info("The user selected arrival country as a " + string);
    }

    @When("The user selected depature date as next month of {string} and return date as {string}")
    public void the_user_selected_depature_date_as_and_return_date_as(String string, String string2) {
        PAGES.getFlightTabVerification().clickOnDateField();
        PAGES.getFlightTabVerification().clickOnNextButton();
        PAGES.getFlightTabVerification().chooseDate(Integer.parseInt(string));
        PAGES.getFlightTabVerification().chooseDate(Integer.parseInt(string2));

        LOGGER.info("The user selected depature date as " + string + " and return date as " + string2);
    }

    @When("The user choose the adult number as {string} and the children number as {string}")
    public void the_user_choose_the_adult_number_as_and_the_children_number_as(String string, String string2) {
        PAGES.getFlightTabVerification().clickOnPassengersField();
        PAGES.getFlightTabVerification().positiveButtonForAdult(Integer.parseInt(string));
        PAGES.getFlightTabVerification().positiveButtonForchildren(Integer.parseInt(string2));
        LOGGER.info("The user choose the adult number as " + string + "and the children number as " + string2);
    }

    @When("The user clicks on the search flights button")
    public void the_user_clicks_on_the_search_flights_button() {
        PAGES.getFlightTabVerification().clickOnSearchFlightButton();
        LOGGER.debug("The user clicks on the search flights button");
    }

    @Then("The user should see {string} message")
    public void the_user_should_see_message(String string) {
        then(PAGES.getFlightTabVerification().getfindYourNextFlightMessage())
                .isEqualTo("Find your next flight");
        LOGGER.info("The user should see" + string + " message");
    }

    @Then("The user should see that just list of {string} and {string} are displayed")
    public void the_user_should_see_that_just_list_of_and_are_displayed(String string, String string2) {
        then(PAGES.getFlightTabVerification().getOriginCountry()).isEqualTo(string);
        then(PAGES.getFlightTabVerification().getDestinationCountry()).isEqualTo(string2);
    }

    @Then("the user should see that just list of {string} is displayed")
    public void the_user_should_see_that_just_list_of_is_displayed(String string) {


    }

    @And("the user should see that just round way on the tickets")
    public void theUserShouldSeeThatJustRoundWayOnTheTickets() {
    }

}