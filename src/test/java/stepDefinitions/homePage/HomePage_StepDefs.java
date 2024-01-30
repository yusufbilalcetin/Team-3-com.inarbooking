package stepDefinitions.homePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.flights.Flights_FilterAndList_Page;
import stepDefinitions.BaseStep;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.Assert.assertTrue;

public class HomePage_StepDefs extends BaseStep {

	public static final Logger LOGGER = LogManager.getLogger(HomePage_StepDefs.class);

	@When("they click on the {string} tab")
	public void they_click_on_the_tab(String tabName) {
		HOMEPAGE.clickOnTabs(tabName);
		LOGGER.debug("User clicked on {} tab", tabName);
	}

	@Then("the header title should be {string}")
	public void the_header_title_should_be(String title) {
		then(HOMEPAGE.getHeaderTitle()).isEqualTo(title);
		LOGGER.debug("User sees {} title", title);
	}

	@Then("the header button text should be {string}")
	public void the_header_button_text_should_be(String buttonText) {
		then(HOMEPAGE.getHeaderButtonText()).isEqualTo(buttonText);
		LOGGER.debug("User sees {} button", buttonText);
	}

	@When("they click on the {int} button")
	public void they_click_on_the_button(int flightButton) {
		HOMEPAGE.clickOnBookFlightButton(flightButton);
		LOGGER.debug("User clicked on Book Flight button {}", flightButton);
	}

	@Then("they navigate to the Flights page")
	public void they_navigate_to_the_Flights_page() {
		then(FLIGHTSFILTER.getFlightsHeaderText()).isEqualTo("Flights");
		LOGGER.debug("User sees Flights header");
	}

	@And("see flights filtered from {string} to {string}")
	public void see_flights_filtered_from_to(String departureCountry, String destinationCountry) {
		then(FLIGHTSFILTER.getDepartureCountrySelectText()).isEqualTo(departureCountry);
		LOGGER.debug("User sees {} selected as departure country", departureCountry);
		then(FLIGHTSFILTER.getArrivalCountrySelectText()).isEqualTo(destinationCountry);
		LOGGER.debug("User sees {} selected as destination country", destinationCountry);
	}

	@And("see all flights from {string} to {string}")
	public void see_all_flights_from_to(String departureCountry, String destinationCountry) {
		assertTrue(FLIGHTSFILTER.isAllFlightsDepartureCountryCorrect(departureCountry));
		LOGGER.debug("User sees all listed flights are from {}", departureCountry);
		assertTrue(FLIGHTSFILTER.isAllFlightsArrivalCountryCorrect(destinationCountry));
		LOGGER.debug("User sees all listed flights are to {}", destinationCountry);
	}

	@When("they click on the {string} button")
	public void theyClickOnTheButton(String offersButton) {
		HOMEPAGE.clickOnOffersButtons(offersButton);
		LOGGER.debug("User clicked on {} button", offersButton);
	}

	@Then("they navigate to the {string} page")
	public void theyNavigateToThePage(String page) {
		switch (page) {
			case "Flights" -> {
				then(FLIGHTSFILTER.getFlightsHeaderText()).isEqualTo("Flights");
				LOGGER.debug("User sees Flights header");
			}
			case "Hotels" -> {
				then(HOTELSFILTER.getHotelsHeaderText()).isEqualTo("Hotels");
				LOGGER.debug("User sees Hotels header");
			}
		}
	}

}
