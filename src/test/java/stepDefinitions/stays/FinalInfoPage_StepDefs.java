package stepDefinitions.stays;

import io.cucumber.java.en.And;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stepDefinitions.BaseStep;
import utils.BrowserUtils;

public class FinalInfoPage_StepDefs extends BaseStep {

	public static final Logger LOGGER = LogManager.getLogger(FinalInfoPage_StepDefs.class);

	@And("I write {string} to the phone number input field")
	public void ıWriteToThePhoneNumberInputField(String telNumber) {
		PAGES.getFinalInfoPage().sendTelNumberToInputField(telNumber);
		LOGGER.debug("I write {string} to the phone number input field");
	}

	@And("I write {string} to the cardholders's name input field")
	public void ıWriteToTheCardholdersSNameInputField(String telNumber) {
		PAGES.getFinalInfoPage().sendTelNumberToInputField(telNumber);
		LOGGER.debug("I write {string} to the cardholders's name input field");
	}

	@And("I write {string} to the card number input field")
	public void ıWriteToTheCardNumberInputField(String cardNumber) {
		PAGES.getFinalInfoPage().sendKeysToCardNumberField(cardNumber);
	}

	@And("I write {string} to the expiration date input field")
	public void ıWriteToTheExpirationDateInputField(String expitationDate) {
		PAGES.getFinalInfoPage().sendKeysToExpirationDateField(expitationDate);
		LOGGER.debug("I write {string} to the expiration date input field");
	}

	@And("I write {string} to CVV code input field")
	public void ıWriteToCVVCodeInputField(String cvvCode) {
		PAGES.getFinalInfoPage().sendKeysToCvvCodeField(cvvCode);
		LOGGER.debug("I write {string} to CVV code input field");
	}

	@And("I selected {string} as a Country,Region")
	public void ıSelectedAsACountryRegion(String location) {
		PAGES.getFinalInfoPage().selectCountryName(location);
		LOGGER.debug("I selected {string} as a Country,Region");
	}

	@And("I click confirmation button")
	public void ıClickConfirmationButton() {
		PAGES.getFinalInfoPage().clickConfirmationCheckbox();
		LOGGER.debug("I click confirmation button");
	}

	@And("I click save your details")
	public void ıClickSaveYourDetails() {
		PAGES.getFinalInfoPage().setSaveDetailsCheckBox();
		LOGGER.debug("I click save your details");

	}

	@And("I click consent market emails")
	public void ıClickConsentMarketEmails() {
		PAGES.getFinalInfoPage().clickConsentMarketEmails();
		LOGGER.debug("I click consent market emails");
	}

	@And("I click consent transport details")
	public void ıClickConsentTransportDetails() {
		PAGES.getFinalInfoPage().clickConsentTransportDetails();
		LOGGER.debug("I click consent transport details");
	}

	@And("I click complete booking button")
	public void ıClickCompleteBookingButton() {
		PAGES.getFinalInfoPage().clickCompleteBookingButton();
		BrowserUtils.wait(5);
		LOGGER.debug("I click complete booking button");
	}

}
