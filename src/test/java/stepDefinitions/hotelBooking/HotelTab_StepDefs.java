package stepDefinitions.hotelBooking;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stepDefinitions.BaseStep;
import static org.assertj.core.api.BDDAssertions.then;

public class HotelTab_StepDefs extends BaseStep {

	public static final Logger LOGGER = LogManager.getLogger(HotelTab_StepDefs.class);

	// implement log factory

	@When("The user click on the Hotel Tab")
	public void i_click_on_the_hotel_tab() {
		PAGES.getBookingHomePage().clickOnStaysTab();
		LOGGER.info("I clicked on the Hotel Tab");
	}

	@Then("The user validate the Hotel Tab Includes Search Bar for Hotel")
	public void i_validate_the_hotel_tab_includes_search_bar_for_hotel() {
		then(PAGES.getHotelTab().getSearchHotelsButtonText()).as("The Button text does not equal to the Search Hotels")
			.isEqualTo("Search Hotels");
		then(PAGES.getHotelTab().getSearchBarInputFieldPlaceholder())
			.as("The Input Field does not equal to the Wheare are you going?")
			.isEqualTo("Where are you going?");
		LOGGER.info("I validated the Hotel Tab Includes Search Bar for Hotel");
	}

	@And("The user click on the Search Hotels Button")
	public void iClickOnTheSearchHotelsButton() {
		PAGES.getHotelTab().clickOnSearchButton();
		LOGGER.info("I clicked on the Search Hotels Button");
	}

}
