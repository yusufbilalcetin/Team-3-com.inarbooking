package stepDefinitions.stays;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stepDefinitions.BaseStep;
import utils.BrowserUtils;
import static org.assertj.core.api.BDDAssertions.then;

public class HotelYourDetailPage_StepDef extends BaseStep {

	public static final Logger LOGGER = LogManager.getLogger(HotelYourDetailPage_StepDef.class);

	@And("I write {string} to the first name field")
	public void ıWriteToTheFirstNameField(String name) {
		PAGES.getYourDetailsPage().sendFirstNameToInputField(name);
		LOGGER.debug("I write {string} to the first name field");
	}

	@And("I write {string} to the last name field")
	public void ıWriteToTheLastNameField(String lastName) {
		PAGES.getYourDetailsPage().sendLastNameToInputField(lastName);
		LOGGER.debug("I write {string} to the last name field");
	}

	@And("I write {string} to the e mail address field")
	public void ıWriteToTheEMailAddressField(String email) {
		PAGES.getYourDetailsPage().sendEmailInputField(email);
		LOGGER.debug("I write {string} to the e mail address field");
	}

	@And("I write {string} to the special requests field")
	public void ıWriteToTheSpecialRequestsField(String request) {
		PAGES.getYourDetailsPage().sendKeysToRequestsSection(request);
		LOGGER.debug("I write {string} to the special requests field");
	}

	@And("I select I don't know for the Your arrival time selector")
	public void ıSelectIDonTKnowForTheYourArrivalTimeSelector() {
		PAGES.getYourDetailsPage().selectArrivalTime("I don't know");
		LOGGER.debug("I select I don't know for the Your arrival time selector");
	}

	@And("I clicked Next, Final Details button")
	public void ıClickedNextFinalDetailsButton() {
		PAGES.getYourDetailsPage().clickNextFinalDetailButton();
		BrowserUtils.wait(3);
		LOGGER.debug("I clicked Next, Final Details button");
	}

	@And("I click on the I'm booking for someone else button")
	public void ıClickOnTheIMBookingForSomeoneElseButton() {
		PAGES.getYourDetailsPage().clickOnWhoBookingButton();
		LOGGER.debug("I click on the I'm booking for someone else button");
	}

	@Then("Valiate that hotel fee is correct after tax")
	public void valiateThatHotelFeeIsCorrectAfterTax() {
		then(String.valueOf(PAGES.getYourDetailsPage().getTotalPrice()).equalsIgnoreCase("483.00"));
		LOGGER.debug("Valiate that hotel fee is correct after tax");
	}

}
