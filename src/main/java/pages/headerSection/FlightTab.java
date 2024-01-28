package pages.headerSection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

import java.util.List;

public class FlightTab extends BasePage {

	@FindBy(xpath = "//*/input[@value='roundTrip']")
	private WebElement roundTrip;

	@FindBy(xpath = "//*/input[@value='oneWay']")
	private WebElement oneWay;

	@FindBy(className = ".headerSearchInput")
	private List<WebElement> searchBarInputFields;

	@FindBy(css = ".headerSearch > div")
	private List<WebElement> dateAndPassengers;

	@FindBy(css = ".headerSearch > div > button")
	private WebElement searchButton;

	public void chooseRoundTrip() {
		roundTrip.click();
	}

	public void chooseOneWay() {
		oneWay.click();
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
		dateAndPassengers.get(3).click();
	}

	public void clickOnSearchFlight() {
		dateAndPassengers.get(4).click();
	}

	public String getSearchFlightsButtonText() {
		return dateAndPassengers.get(4).getText();
	}

}
