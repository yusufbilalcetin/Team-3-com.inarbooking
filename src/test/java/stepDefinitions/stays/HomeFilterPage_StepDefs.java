package stepDefinitions.stays;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stepDefinitions.BaseStep;

import static org.assertj.core.api.BDDAssertions.then;

public class HomeFilterPage_StepDefs extends BaseStep {

	public static final Logger LOGGER = LogManager.getLogger(HomeFilterPage_StepDefs.class);

	@And("The user send {string} to destination field")
	public void theUserSendToDestinationField(String location) {
		PAGES.getHotelFilterPage().sendKeysToDestination(location);
		LOGGER.debug("The user send {string} to destination field");
	}

	@And("The user click on Search button")
	public void theUserClickOnSearchButton() {
		PAGES.getHotelFilterPage().clickOnSearchButton();
		LOGGER.debug("The user click on Search button");
	}

	@And("I click on the #{int} Hotel's See availability button")
	public void ıClickOnTheHotelSSeeAvailabilityButton(int index) {
		PAGES.getHotelFilterPage().clickOnSeeAvailabilityButtonByIndex(index);
		LOGGER.debug("I click on the #{int} Hotel's See availability button");
	}

	@And("The user choose {string} of checkbox activities")
	public void theUserChooseOfCheckboxActivities(String location) {
		PAGES.getHotelFilterPage().clickOnCheckBoxChoices(location);
		LOGGER.debug("The user choose {string} of checkbox activities");
	}

	@And("The user click Search button")
	public void theUserClickSearchButton() {
		PAGES.getHotelFilterPage().clickOnSearchButton();
		LOGGER.debug("The user click Search button");
	}

	@Then("Validate hotel Location informations")
	public void validateHotelLocationInformations() {
		LOGGER.debug("Validate hotel Location informations");

	}

	@Then("Validate hotel {string}")
	public void validateHotel(String location) {
		then(location.equalsIgnoreCase(PAGES.getHotelFilterPage().getHotelInformations(1)));
		LOGGER.debug("Validate hotel {string}");
	}

	@And("The user choose {string} of the Checkbox activities")
	public void theUserChooseOfTheCheckboxActivities(String feature) {
		PAGES.getHotelFilterPage().clickOnCheckBoxChoices(feature);
		LOGGER.debug("The user choose {string} of the Checkbox activities");
	}

	@And("The user click on #{int} See Availability button")
	public void theUserClickOnSeeAvailabilityButton(int index) {
		PAGES.getHotelFilterPage().clickOnSeeAvailabilityButtonByIndex(index);
		LOGGER.debug("The user click on #{int} See Availability button");
	}

}
