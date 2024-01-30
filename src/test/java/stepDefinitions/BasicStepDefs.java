package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import config.ConfigurationManager;

public class BasicStepDefs extends BaseStep {

    @Given("The user navigate to the baseURL")
    public void i_navigate_to_the_base_url() {
        DRIVER.get(ConfigurationManager.getProperty("baseURL"));
    }

    @And("The user click on the Booking Link")
    public void i_click_on_the_booking_link() {
        PAGES.getHomePage().clickBookingLink();
    }



}
