package stepDefinitions.flightBooking;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stepDefinitions.BaseStep;

import static org.assertj.core.api.BDDAssertions.then;

public class FlightTab_StepDefs extends BaseStep {

	public static final Logger LOGGER = LogManager.getLogger(FlightTab_StepDefs.class);

	// implement log factory

	@When("User clicks on the Flight Tab")
	public void user_clicks_on_the_flight_tab() {
		PAGES.getBookingHomePage().clickOnFlightsTab();
		LOGGER.info("I clicked on the Flight Tab");
	}


	@Then("User validates the Flight Tab Includes Search Bar and Options for Flight")
	public void user_validates_the_flight_tab_includes_search_bar_and_options_for_flight() {
		then(PAGES.getFlightTab().getSearchFlightsButtonText())
			.as("The Button text does not equal to the Search Flight")
			.isEqualTo("Search Flights");
		// then(PAGES.getFlightTab().clickOnPassengersField(););
		// LOGGER.info("I validated the Hotel Tab Includes Search Bar for Hotel");
	}

}
