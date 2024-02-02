package pages.stays;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;
import utils.BrowserUtils;

import java.util.List;

public class HotelYourDetailsPage extends BasePage {

	@FindBy(css = ".d-flex >.pe-3 >.fs-4 >input")
	private List<WebElement> travelingForWorkYesNoRadio;

	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement firstNameInputField;

	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastNameInputField;

	@FindBy(xpath = "(//input[@type='text'])[3]")
	private WebElement emailInputField;

	@FindBy(css = ".hotel-title")
	private WebElement hotelName;

	@FindBy(xpath = "//textarea[@placeholder='Enter your special requests...']")
	private WebElement requestsSection;

	@FindBy(xpath = "//select[@class='form-select fs-4']")
	private WebElement arrivalTimeSelect;

	@FindBy(xpath = ".d-flex.flex-column>div>div>span")
	private List<WebElement> additionalFees;

	@FindBy(xpath = "//span[@class='m-0']")
	private WebElement totalPrice;

	@FindBy(css = "button.btn-blue")
	private WebElement nextFinalDetailsButton;

	@FindBy(xpath = "//input[@value='buy for someone else']")
	private WebElement whoBookingButton;

	public void clickTravelingForWorkYesRadio() {
		travelingForWorkYesNoRadio.get(0).click();
	}

	public void clickTravelingForWorkNoRadio() {
		travelingForWorkYesNoRadio.get(1).click();
	}

	public void sendFirstNameToInputField(String firstName) {
		firstNameInputField.sendKeys(firstName);
	}

	public void sendLastNameToInputField(String lastName) {
		lastNameInputField.sendKeys(lastName);
	}

	public void sendEmailInputField(String email) {
		emailInputField.sendKeys(email);
	}

	public void sendKeysToRequestsSection(String requests) {
		actions.moveToElement(requestsSection).perform();
		requestsSection.sendKeys(requests);
	}

	public String getSelectedHotelName() {
		return hotelName.getText();
	}

	public void selectArrivalTime(String arrivalTime) {
		Select time = new Select(arrivalTimeSelect);
		time.selectByVisibleText(arrivalTime);
	}

	public double getTaxAndFeeValues(int index) {
		return Double.parseDouble(additionalFees.get(index).getText().substring(1));
	}

	public double getTaxAndFeeValuesForFirstValue() {
		return Double.parseDouble(additionalFees.get(0).getText().substring(3));
	}

	public Double getTotalPrice() {
		return Double.parseDouble(totalPrice.getText().substring(1));
	}

	public void clickNextFinalDetailButton() {
		BrowserUtils.scrollDownWithPageDownButton(1);
		BrowserUtils.wait(3);
		// actions.moveToElement(nextFinalDetailsButton).build().perform();
		nextFinalDetailsButton.click();
	}

	public void clickOnWhoBookingButton() {
		whoBookingButton.click();
	}

}
