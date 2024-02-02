package pages.stays;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;
import utils.BrowserUtils;

import java.util.List;

public class FinalInfoPage extends BasePage {

	@FindBy(xpath = "//select[@name='country']")
	private WebElement countrySelectionDropdown;

	@FindBy(xpath = "//select[@name='phoneCountry']")
	private WebElement countryNumberCode;

	@FindBy(xpath = "(//div/input[@type='text'])[2]")
	private WebElement telNumberInputField;

	@FindBy(xpath = "//input[@name='freeConfirmation']")
	private WebElement confirmationCheckBox;

	@FindBy(xpath = "//input[@name='saveDetails']")
	private WebElement saveDetailsCheckBox;

	@FindBy(xpath = "//input[@name='consentMarketingEmails']")
	private WebElement consentMarketEmails;

	@FindBy(xpath = "//input[@name='consentTransportDeals']")
	private WebElement consentTransPortDeals;

	@FindBy(xpath = "//input[@name='cardholderName']")
	private WebElement cardHoldersNameField;

	@FindBy(xpath = "//input[@name='cardNumber']")
	private WebElement cardNumberField;

	@FindBy(xpath = "//input[@name='expirationDate']")
	private WebElement expirationDateField;

	@FindBy(xpath = "//input[@name='cvv']")
	private WebElement cvvCodeField;

	@FindBy(css = "button.btn-blue")
	private List<WebElement> buttons;

	public void selectCountryName(String countryName) {
		BrowserUtils.wait(4);
		actions.moveToElement(countrySelectionDropdown).build().perform();
		Select dropdown = new Select(countrySelectionDropdown);
		dropdown.selectByVisibleText(countryName);
	}

	public void selectCountryNumberCode(String numberCode) {
		Select dropdown = new Select(countryNumberCode);
		dropdown.selectByVisibleText(numberCode);
	}

	public void sendTelNumberToInputField(String telNumber) {
		telNumberInputField.sendKeys(telNumber);
	}

	public void clickConfirmationCheckbox() {
		actions.moveToElement(confirmationCheckBox).build().perform();
		confirmationCheckBox.click();
	}

	public void setSaveDetailsCheckBox() {
		actions.moveToElement(saveDetailsCheckBox).build().perform();
		saveDetailsCheckBox.click();

	}

	public void clickConsentMarketEmails() {
		actions.moveToElement(consentMarketEmails).build().perform();
		consentMarketEmails.click();
	}

	public void clickConsentTransportDetails() {
		actions.moveToElement(consentTransPortDeals).build().perform();
		consentTransPortDeals.click();
	}

	public void sendKeysToCardHoldersName(String name) {
		cardHoldersNameField.sendKeys(name);
	}

	public void sendKeysToCardNumberField(String number) {
		cardNumberField.sendKeys(number);
	}

	public void sendKeysToExpirationDateField(String date) {
		expirationDateField.sendKeys(date);
	}

	public void sendKeysToCvvCodeField(String cvvCode) {
		cvvCodeField.sendKeys(cvvCode);
	}

	public void clickCompleteBookingButton() {
		actions.moveToElement(buttons.get(1)).build().perform();
		buttons.get(1).click();
	}

}
