package stepDefinitions.flightBooking;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.devtools.v85.page.Page;
import stepDefinitions.BaseStep;

public class flight1_test extends BaseStep {

	public static final Logger LOGGER = LogManager.getLogger(flight1_test.class);

	@When("The user clicks on the Flight Tab")
	public void the_user_click_on_the_flight_tab() {
		PAGES.getBookingHomePage().clickOnFlightsTab();
		LOGGER.debug("The user clicked on the Flight Tab");

	}

	@When("The user selects One Way button")
	public void the_user_selects_button() {
		PAGES.getFlightTab().chooseOneWay();
		LOGGER.debug("The user selected One Way button");
	}

	@And("The user selects button type First Clas travel")
	public void theUserSelectedButtonTypeFirstClassTravel() {
		PAGES.getFlightTab().chooseClass("First Class");
		LOGGER.debug("The user selected First Class for flight type");
	}

	@When("the user selects {string} as departure country")
	public void the_user_selects_as_departure_country(String departure) {
		PAGES.getFlightTab().chooseDepartureCountry(departure);
		LOGGER.debug("The user selected France for departure country");
	}

	@When("the user selects {string} as arrival country")
	public void the_user_selects_as_arrival_country(String arrival) {
		PAGES.getFlightTab().chooseArrivalCountry(arrival);
		LOGGER.debug("The user selected China for arrival country");
	}

	@When("the user selects Departure Date")
	public void the_user_selects_departure_date() {
		PAGES.getFlightTab().clickOnDateField();
		PAGES.getFlightTab().sendDate("02.10.2024");
		LOGGER.debug("The user set 02.10.2024 for departure date");
	}

	@When("the user selects passengers")
	public void the_user_selects_passengers() {
		PAGES.getFlightTab().clickOnPassengersField();
		PAGES.getFlightTab().increaseAdultPassenger();
		LOGGER.debug("The user increased the number of adult passengers by one");
	}

	@When("The user clicks on the Search Flights Button")
	public void the_user_click_on_the_search_flights_button() {
		PAGES.getFlightTab().clickOnSearchFlight();
		LOGGER.debug("The user click Search Flight button");
	}

	@When("The user clicks on the Airline C Check Box on the left side")
	public void the_user_click_on_the_check_box_on_the_left_side() {
		PAGES.getFlightTab().selectAirlineC();
		LOGGER.debug("The user click on the Airline C checkbox");
	}

	@And("The user clicks on the Search button on the left side")
	public void theUserClickOnTheSearchButtonOnTheLeftSide() {
		PAGES.getFlightTab().clickSearchFlightButton();
		LOGGER.debug("The user click on the Search button again");

	}

	@Then("The user clicks on the See Availability button on Airline C")
	public void theUserClickOnTheSeeAvailabilityButtonOnAirlineC() {
		PAGES.getFlightTab().clickOnSeeAvailabilityButton();
		LOGGER.debug("The user click on the See Availability button on Airline C");
	}

}
