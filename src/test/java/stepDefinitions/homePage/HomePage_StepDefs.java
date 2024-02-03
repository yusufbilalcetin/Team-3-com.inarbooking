package stepDefinitions.homePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.ComparisonFailure;
import org.openqa.selenium.NoSuchElementException;
import stepDefinitions.BaseStep;
import utils.BrowserUtils;

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
		try {
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
		catch (NoSuchElementException e) {
			LOGGER.error("User cannot navigate to the page!");
		}
	}

	@When("they click on the {string} card")
	public void theyClickOnTheCard(String cardName) {
		HOMEPAGE.clickOnPlistElements(cardName);
		LOGGER.debug("User clicked on {} card", cardName);
	}

	@Then("they navigate to Hotels page")
	public void theyNavigateToHotelsPage() {
		then(HOTELSFILTER.getHotelsHeaderText()).isEqualTo("Hotels");
		LOGGER.debug("User sees Hotels header");
	}

	@And("they see {string} in destination field")
	public void theySeeInDestinationField(String country) {
		try {
			then(HOTELSFILTER.getDestinationInputText()).isEqualTo(country);
			LOGGER.debug("User sees {} in destination input field", country);
		}
		catch (ComparisonFailure e) {
			LOGGER.error("User cannot see the right destination!");
			System.out.println(e.getMessage());
		}
	}

	@When("they click on {string} car's Rent Car button")
	public void theyClickOnCarSButton(String carType) {
		HOMEPAGE.clickOnRentCarButton(carType);
		LOGGER.debug("User clicked on {} car's Rent Car button", carType);
	}

	@Then("they navigate to Car rental page")
	public void theyNavigateToCarRentalPage() {
		then(CARSFILTER.getHeaderText()).isEqualTo("Car rental");
		LOGGER.debug("User sees Car rental header");
	}

	@And("they see {string} card is selected")
	public void theySeeCardIsSelected(String carType) {
		assertTrue(CARSFILTER.isSelectedCarImageSameWith(carType));
		LOGGER.debug("User sees {} car image selected", carType);
	}

	@And("they see {string} Car Category is selected")
	public void theySeeCarCategoryIsSelected(String carType) {
		assertTrue(CARSFILTER.isSelectedCarCategorySameWith(carType));
		LOGGER.debug("User sees {} car category selected", carType);
	}

	@And("they see only {string} cars on the list")
	public void theySeeOnlyCarsOnTheList(String carType) {
		assertTrue(CARSFILTER.isCarCardsSpecsCorrect("size", carType));
	}


}
