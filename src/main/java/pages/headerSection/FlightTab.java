package pages.headerSection;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;
import utils.BrowserUtils;

import java.util.List;

public class FlightTab extends BasePage {

	@FindBy(css = ".me-3")
	private List<WebElement> flightType;

	@FindBy(xpath = "//select[@class='headerSearchInput w-100']")
	private List<WebElement> searchBarInputFields;

	@FindBy(css = ".headerSearch > div")
	private List<WebElement> dateAndPassengers;

	@FindBy(css = ".headerSearch > div > button")
	private WebElement searchButton;

	@FindBy(xpath = "//input[@value='Airline C']")
	private WebElement airlineCInTheLeftSide;

	@FindBy(xpath = "//select[@class='headerSearchInput w-100 form-select fs-4']")
	private WebElement flightTypeButton;

	@FindBy(xpath = "//div[@class='search-btn-flight']")
	private WebElement searchFlightButton;

	@FindBy(css = ".form-select:nth-child(2)")
	private WebElement dateField;

	@FindBy(xpath = "//button[text()='+']")
	private WebElement increaseAdult;

	@FindBy(css = ".flight-button.text-center")
	private WebElement seeAvailabilityButton;

	public void clickOnSeeAvailabilityButton() {
		BrowserUtils.wait(4);
		seeAvailabilityButton.click();

	}

	public void increaseAdultPassenger() {
		increaseAdult.click();
	}

	public void clickSearchFlightButton() {
		actions.moveToElement(searchFlightButton).click();
	}

	public void selectAirlineC() {
		actions.moveToElement(airlineCInTheLeftSide).click();
		BrowserUtils.wait(2);

	}

	public void chooseRoundTrip() {
		flightType.get(0).click();
	}

	@FindBy(css = "button.rdrDay")
	private List<WebElement> dayButtons;

	@FindBy(xpath = "//input[@placeholder='Early']")
	private WebElement firstDate;

	@FindBy(xpath = "//input[@placeholder='Continuous']")
	private WebElement lastDate;

	public void chooseOneWay() {
		flightType.get(1).click();
	}

	public void chooseClassBySelection(String className) {
		Select select = new Select(flightTypeButton);
		select.selectByVisibleText(className);
	}

	public void chooseFlightType(String flightType) {
		switch (flightType) {
			case "Round Trip" -> chooseRoundTrip();
			case "One Way" -> chooseOneWay();
		}
	}

	public void chooseClass(String className) {
		Select select = new Select(flightTypeButton);
		select.selectByVisibleText(className);
	}

	public void chooseDepartureCountry(String departure) {
		Select select = new Select(searchBarInputFields.get(0));
		select.selectByVisibleText(departure);
	}

	public void chooseArrivalCountry(String arrival) {
		Select select = new Select(searchBarInputFields.get(1));
		select.selectByVisibleText(arrival);
	}

	public void clickOnDateField() {
		dateAndPassengers.get(2).click();
	}

	public void selectFirstDate(int index) {
		List<WebElement> filterButton = dayButtons.stream()
			.filter(button -> !button.getAttribute("class").contains("rdrDayPassive")
					&& !button.getAttribute("class").contains("rdrDayDisabled"))
			.toList();
		BrowserUtils.clickOnElement(filterButton.get(index - 1));
	}

	public void selectLastDate(int index) {
		List<WebElement> filterButton = dayButtons.stream()
			.filter(button -> !button.getAttribute("class").contains("rdrDayPassive")
					&& !button.getAttribute("class").contains("rdrDayDisabled"))
			.toList();
		BrowserUtils.clickOnElement(filterButton.get(index - 1));

	}

	public void clickOnDayByIndex(int index) {
		List<WebElement> filterButton = dayButtons.stream()
			.filter(button -> !button.getAttribute("class").contains("rdrDayPassive")
					&& !button.getAttribute("class").contains("rdrDayDisabled"))
			.toList();
		BrowserUtils.clickOnElement(filterButton.get(index - 1));
	}

	public void sendDate(String date) {
		dateField.sendKeys(date);
		BrowserUtils.wait(3);

	}

	public void clickOnPassengersField() {
		actions.moveToElement(dateAndPassengers.get(3)).click().build().perform();
	}

	public void clickOnSearchFlight() {
		actions.moveToElement(dateAndPassengers.get(4)).click().build().perform();
	}

	public String getSearchFlightsButtonText() {
		return dateAndPassengers.get(4).getText();
	}

}
