package pages.headerSection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

import java.util.List;

public class CarTab extends BasePage {

	@FindBy(css = ".headerSearchInput")
	private WebElement locationSearchInput;

	@FindBy(css = ".headerDateInput")
	private List<WebElement> dates;

	@FindBy(css = ".form-select")
	private List<WebElement> hours;

	@FindBy(css = ".headerBtn")
	private WebElement searchCarsButton;

	public String getLocationSearchInputPlaceHolder() {
		return locationSearchInput.getAttribute("placeholder");
	}

	public void choosePickUpDate(String date) {
		dates.get(0).sendKeys(date);
	}

	public void chooseDropOffDate(String date) {
		dates.get(1).sendKeys(date);
	}

	public void choosePickUpTime(String time) {
		Select select = new Select(hours.get(0));
		select.selectByVisibleText(time);
	}

	public void chooseDropOffTime(String time) {
		Select select = new Select(hours.get(1));
		select.selectByVisibleText(time);
	}

	public void clickOnSearchCarsButton() {
		searchCarsButton.click();
	}

}
