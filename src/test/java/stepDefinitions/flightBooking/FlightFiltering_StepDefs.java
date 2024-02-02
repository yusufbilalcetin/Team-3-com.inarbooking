package stepDefinitions.flightBooking;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stepDefinitions.BaseStep;

public class FlightFiltering_StepDefs extends BaseStep {

	public static final Logger LOGGER = LogManager.getLogger(FlightTab_StepDefs.class);

	@When("The user click on the Flight Tab")
	public void i_click_on_the_flight_tab() {
		PAGES.getFlightTab().chooseOneWay();
	}

	@When("The user selected {string} button")
	public void the_user_selected_button(String string) {

	}

	@When("The user User selected button type {string} travel")
	public void the_user_user_selected_button_type_travel(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("the user selected {string} as depature country")
	public void the_user_selected_as_depature_country(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("the user selected {string} as arrival country")
	public void the_user_selected_as_arrival_country(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("the user selected a date")
	public void the_user_selected_a_date() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("the user selected passengers")
	public void the_user_selected_passengers() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("The user click on the Search Flights Button")
	public void the_user_click_on_the_search_flights_button() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("The user click on the {string} Check Box on the left side")
	public void the_user_click_on_the_check_box_on_the_left_side(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("The user click on the Search button on the left side")
	public void the_user_click_on_the_search_button_on_the_left_side() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("The user click on the #{int} Flight's See availability Button")
	public void the_user_click_on_the_flight_s_see_availability_button(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("The user validate the Flight has the {string}")
	public void the_user_validate_the_flight_has_the(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
