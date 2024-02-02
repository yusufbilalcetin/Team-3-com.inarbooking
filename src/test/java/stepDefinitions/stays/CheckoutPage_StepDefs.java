package stepDefinitions.stays;

import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stepDefinitions.BaseStep;
import stepDefinitions.homePage.HomePage_StepDefs;
import utils.BrowserUtils;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.Assert.assertTrue;

public class CheckoutPage_StepDefs extends BaseStep {

	public static final Logger LOGGER = LogManager.getLogger(CheckoutPage_StepDefs.class);

	@Then("I validate booking from hotel name")
	public void ıValidateBookingFromHotelName() {
		BrowserUtils.wait(5);
		then(PAGES.getCheckoutPage().getHotelTitle().contains("Ocean View Resort")).isTrue();
		LOGGER.debug("I validate booking from hotel name");

	}

}
