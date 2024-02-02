package pages.stays;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class StaysHomePage extends BasePage {

	@FindBy(xpath = "//button[text()='Search Hotels']")
	private WebElement searchHotelButton;

	@FindBy(xpath = "(//input[@type='text'])[1]")
	private WebElement locationInputField;

	@FindBy(css = ".headerSearchItem")
	private List<WebElement> tabs;

	@FindBy(css = "button.rdrNextPrevButton")
	private List<WebElement> prevNextMonthButton;

	@FindBy(css = "button.rdrDay")
	private List<WebElement> dayButtons;

	@FindBy(css = ".optionCounterNumber")
	private List<WebElement> counterNumbers;

	@FindBy(className = "optionCounterButton")
	private List<WebElement> counterButtons;

	public void clickOnSearchHotelButton() {
		searchHotelButton.click();
	}

	public void sendLocationToInputField(String city) {
		locationInputField.sendKeys(city);
	}

	public void clickOnDatePicker() {
		tabs.get(1).click();
	}

	public void clickOnCustumerInformation() {
		actions.moveToElement(tabs.get(2)).build().perform();
		tabs.get(2).click();
	}

	public void clickOnNextMonthButton() {
		prevNextMonthButton.get(1).click();
	}

	public void clickOnDayByIndex(int index) {
		// dayButtons.get(10).click();
		List<WebElement> filteredDays = dayButtons.stream()
			.filter(button -> !button.getAttribute("class").contains("rdrDayPassive"))
			.toList();
		filteredDays.get(index - 1).click();
	}

	public String getTextDefaultAdultCounterNumbers() {
		return counterNumbers.get(0).getText();
	}

	public void clickOnAdultNumbersUntil(int input) {
		int defNumber = Integer.parseInt(getTextDefaultAdultCounterNumbers());
		while (defNumber < input) {
			counterButtons.get(1).click();
			defNumber++;

		}
	}

	public String getTextDefaultChilderenCounterNumbers() {
		return counterNumbers.get(1).getText();
	}

	public void clickOnChilderenNumbersUntil(int input) {
		int defNumber = Integer.parseInt(getTextDefaultChilderenCounterNumbers());
		while (defNumber < input) {
			counterButtons.get(3).click();
			defNumber++;

		}
	}

	public String getTextDefaultRoomCounterNumbers() {
		return counterNumbers.get(2).getText();
	}

	public void clickOnRoomNumbersUntil(int input) {
		int defNumber = Integer.parseInt(getTextDefaultRoomCounterNumbers());
		while (defNumber < input) {
			counterButtons.get(5).click();
			defNumber++;

		}
	}

}
