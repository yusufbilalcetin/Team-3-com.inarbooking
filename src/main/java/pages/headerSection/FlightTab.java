package pages.headerSection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

import java.util.List;

public class FlightTab extends BasePage {

	@FindBy(css = ".me-3")
	private List<WebElement> flightType;

	@FindBy(className = ".headerSearchInput")
	private List<WebElement> searchBarInputFields;

	@FindBy(css = ".headerSearch > div")
	private List<WebElement> dateAndPassengers;

	@FindBy(css = ".headerSearch > div > button")
	private WebElement searchButton;

	public void chooseRoundTrip() {
		flightType.get(0).click();
	}

	public void chooseOneWay() {
		flightType.get(1).click();
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

	public void clickOnDateField() {
		dateAndPassengers.get(2).click();
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
