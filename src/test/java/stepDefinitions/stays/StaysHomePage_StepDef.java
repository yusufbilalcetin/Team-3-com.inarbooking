package stepDefinitions.stays;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stepDefinitions.BaseStep;
import utils.BrowserUtils;

public class StaysHomePage_StepDef extends BaseStep {

	public static final Logger LOGGER = LogManager.getLogger(StaysHomePage_StepDef.class);

	@When("The user click on the Search Hotels button")
	public void theUserClickOnTheSearchHotelsButton() {
		PAGES.getStaysHomePage().clickOnSearchHotelButton();
		LOGGER.debug("The user click on the Search Hotels button");

	}

	@When("The user send {string} to input field")
	public void theUserSendToInputField(String location) {
		PAGES.getStaysHomePage().sendLocationToInputField(location);
		LOGGER.debug("The user send {string} to input field");
	}

	@When("The user send {string} into input field")
	public void theUserSendIntoInputField(String location) {
		PAGES.getStaysHomePage().sendLocationToInputField(location);
		LOGGER.debug("The user send {string} into input field");
	}

	@And("The user choose date of location")
	public void theUserChooseDateOfLocation() {
		PAGES.getStaysHomePage().clickOnDatePicker();
		PAGES.getStaysHomePage().clickOnNextMonthButton();
		BrowserUtils.scrollDownWithPageDownButton(1);
		BrowserUtils.wait(2);
		PAGES.getStaysHomePage().clickOnDayByIndex(3);
		PAGES.getStaysHomePage().clickOnDayByIndex(6);
		LOGGER.debug("The user choose date of location");
	}

	@And("The user choose customer informations")
	public void theUserChooseCustomerInformations() {
		PAGES.getStaysHomePage().clickOnCustumerInformation();
		PAGES.getStaysHomePage().clickOnAdultNumbersUntil(3);
		LOGGER.debug("The user choose customer informations");
	}

}
