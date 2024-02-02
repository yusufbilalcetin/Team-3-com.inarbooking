package pages.carRentals.carRentalsS;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;
import utils.BrowserUtils;

import java.util.List;

public class CarRentalBilling_Page extends BasePage {

	@FindBy(css = ".mb-3.fw-bold")
	private WebElement frameName;

	@FindBy(id = "firstName")
	private WebElement nameTextField;

	@FindBy(id = "lastName")
	private WebElement lastNameTextField;

	@FindBy(css = "select[name='phoneCountry']")
	private WebElement phoneCountryCode;

	@FindBy(css = ".p-3.fs-4.w-100")
	private WebElement phoneTextField;

	@FindBy(id = "country")
	private WebElement countryTextField;

	@FindBy(id = "address")
	private WebElement addressTextField;

	@FindBy(id = "city")
	private WebElement cityTextField;

	@FindBy(id = "postalCode")
	private WebElement postalCodeTextField;

	@FindBy(css = ".form-check input.fs-4")
	private List<WebElement> businesBookingOrNotRadioButtons;

	@FindBy(css = "input[placeholder=\"Cardholder's Name\"]")
	private WebElement cardholderNameTextField;

	@FindBy(css = "input[placeholder='**** **** **** ****']")
	private WebElement cardNumberField;

	@FindBy(css = "input[placeholder='MM/YY or MMYY']")
	private WebElement expirationDateField;

	@FindBy(css = "input[placeholder='CVV/CVC ( 3 or 4 number length)']")
	private WebElement cvvCodeField;

	@FindBy(css = ".form-check input.fs-4")
	private List<WebElement> markettingEmailsCheckboxes;

	@FindBy(css = ".btn-danger")
	private WebElement backButton;

	@FindBy(css = ".btn-blue")
	private WebElement bookNowButton;

	public String getFrameName() {
		return frameName.getText();
	}

	public void setName(String name) {
		nameTextField.sendKeys(name);
	}

	public void setLastName(String lastName) {
		lastNameTextField.sendKeys(lastName);
	}

	public void selectCountryCode(int countryCodeIndex) {
		Select select = new Select(phoneCountryCode);
		select.selectByIndex(countryCodeIndex);
	}

	public void setPhoneNumber(String phoneNumber) {
		phoneTextField.sendKeys(phoneNumber);
	}

	public void setCountry(String country) {
		countryTextField.sendKeys(country);
	}

	public void setAddress(String address) {
		addressTextField.sendKeys(address);
	}

	public void setCity(String city) {
		cityTextField.sendKeys(city);
	}

	public void setPostalCode(String postalCode) {
		postalCodeTextField.sendKeys(postalCode);
	}

	public void setBusinessOrNot(int index) {
		businesBookingOrNotRadioButtons.get(index).click();
	}

	public void setBillingAddressInformation(String name, String lastName, int countryCodeIndex, String phoneNumber,
			String country, String address, String city, String postalCode, int isBusiness) {
		// BrowserUtils.scrollDownWithPageDown();
		setName(name);
		setLastName(lastName);
		selectCountryCode(countryCodeIndex);
		setPhoneNumber(phoneNumber);
		setCountry(country);
		setAddress(address);
		setCity(city);
		setPostalCode(postalCode);
		setBusinessOrNot(isBusiness);
		BrowserUtils.wait(5);
	}

	public void setCardholderName(String name) {
		cardholderNameTextField.sendKeys(name);
	}

	public void setCardNumber(String cardNumber) {
		cardNumberField.sendKeys(cardNumber);
	}

	public void setExpirationDate(String expirationDate) {
		expirationDateField.sendKeys(expirationDate);
	}

	public void setCvvCode(String cvvCode) {
		cvvCodeField.sendKeys(cvvCode);
	}

	public void setCardInformation(String cardHolderName, String cardNumber, String expirationDate, String cvvCode) {
		setCardholderName(cardHolderName);
		setCardNumber(cardNumber);
		setExpirationDate(expirationDate);
		setCvvCode(cvvCode);
		BrowserUtils.scrollDownWithPageDown();
	}

	public void clickOnBackButton() {
		backButton.click();
	}

	public void clickOnBookNowButton() {
		BrowserUtils.scrollUpWithPageUpButton(1);
		BrowserUtils.scrollDownWithPageDown();
		bookNowButton.click();
	}

}
