package stepDefinitions.carRental;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stepDefinitions.BaseStep;

import static org.assertj.core.api.BDDAssertions.then;

public class CarRental_StepDefs extends BaseStep {

    public static final Logger LOGGER = LogManager.getLogger(CarRental_StepDefs.class);

    @Then("They see the same {string} with the card")
    public void they_see_the_same_pickup_location_with_the_card(String location) {
        then(CARSFILTER.getPickupLocation()).isEqualTo(location);
        LOGGER.debug("They see the same location in input field");
    }
    @When("The user changes Pickup location as {string}")
    public void theUserChangesPickupLocationAndClickSearchButton(String newLocation) {
        CARSFILTER.enterPickupLocation(newLocation);
        LOGGER.debug("They change the pickup location as {}", newLocation);
    }
    @When("They click on View Deal button")
    public void they_click_on_view_deal_button() {
        CARSFILTER.clickOnDesiredCarFromListedCars(0);
        LOGGER.debug("They click on the first View Deal button");
    }

    @Then("They see the same pickup location {string} on the page")
    public void they_see_the_same_pickup_location_on_the_page(String location) {
        then(CARDEALPAGE.getPickupDropOffLocation()).isEqualTo(location);
        LOGGER.debug("They see the same pickup location {} on the page", location);
    }
}
