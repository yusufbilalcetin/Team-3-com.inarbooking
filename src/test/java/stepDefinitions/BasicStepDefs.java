package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import config.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BasicStepDefs extends BaseStep {

	public static final Logger LOGGER = LogManager.getLogger(BasicStepDefs.class);

	@Given("The user navigate to the baseURL")
	public void i_navigate_to_the_base_url() {
		DRIVER.get(ConfigurationManager.getProperty("baseURL"));
		LOGGER.info("User navigates to baseURL");
	}

	@And("The user click on the Booking Link")
	public void i_click_on_the_booking_link() {
		PAGES.getHomePage().clickBookingLink();
		LOGGER.info("User clicks on Booking link");
	}

}
