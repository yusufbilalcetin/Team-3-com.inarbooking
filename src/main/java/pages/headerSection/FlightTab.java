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


	@FindBy(css = ".headerSearchInput")
	private List<WebElement> searchBarInputFields;

	@FindBy(css = ".headerSearch > div")
	private List<WebElement> dateAndPassengers;

	@FindBy(css = ".headerSearch > div > button")
	private WebElement searchButton;

	@FindBy(css = "button.rdrDay")
	private List<WebElement> dayButtons;

	@FindBy(xpath = "//input[@placeholder='Early']")
	private WebElement firstDate;

	@FindBy(xpath = "//input[@placeholder='Continuous']")
	private WebElement lastDate;

	public void chooseRoundTrip() {
		flightType.get(0).click();
	}

	public void chooseOneWay() {
		flightType.get(1).click();
	}

	public void chooseFlightType(String flightType) {
		switch (flightType) {
			case "Round Trip" -> chooseRoundTrip();
			case "One Way" -> chooseOneWay();
		}
	}

	public void chooseClass(String className) {
		Select select = new Select(searchBarInputFields.get(0));
		select.selectByVisibleText(className);
	}

	public void chooseDepartureCountry(String departure) {
		Select select = new Select(searchBarInputFields.get(1));
		select.selectByVisibleText(departure);
	}

	public void chooseArrivalCountry(String arrival) {
		Select select = new Select(searchBarInputFields.get(2));
		select.selectByVisibleText(arrival);
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

	public void clickOnDateField() {
		actions.moveToElement(dateAndPassengers.get(2)).click().perform();
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
