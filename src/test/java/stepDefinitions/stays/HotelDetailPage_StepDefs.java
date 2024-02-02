package stepDefinitions.stays;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stepDefinitions.BaseStep;

import static org.assertj.core.api.BDDAssertions.then;

public class HotelDetailPage_StepDefs extends BaseStep {

	public static final Logger LOGGER = LogManager.getLogger(HotelDetailPage_StepDefs.class);

	@And("I click on the Reserve or Book Now! button")
	public void ıClickOnTheReserveOrBookNowButton() {
		PAGES.getHotelDetailPage().clickReserveOrBookNowButton(1);
		LOGGER.debug("I click on the Reserve or Book Now! button");
	}

	@Then("Validate Hotel name is same with your choice")
	public void validateHotelNameIsSameWithYourChoice() {
		try {
			then(PAGES.getHotelDetailPage().getHotelNameText().equals("Ocean View Resort")).isTrue();
			LOGGER.debug("Validate Hotel name is same with your choice");
		}
		catch (AssertionError e) {
			LOGGER.error("Hotel name is not same");
			throw e;
		}

	}

	@Then("Validate that hotel per night price is correct")
	public void validateThatHotelPerNightPriceIsCorrect() {
		try {
			then(PAGES.getHotelDetailPage().getHotelPrice().equals("$50 per night")).isTrue();
			LOGGER.debug("Validate that hotel per night price is correct");
		}
		catch (AssertionError e) {
			LOGGER.error("Hotel price is nor correct");
			throw e;

		}

	}

}
