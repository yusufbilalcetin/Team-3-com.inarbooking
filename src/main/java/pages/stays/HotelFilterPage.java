package pages.stays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.BrowserUtils;

import java.util.List;

public class HotelFilterPage extends BasePage {

	@FindBy(xpath = "(//input[@type='text'])[1]")
	private WebElement destinationInputField;

	@FindBy(xpath = "//input[@type='number']")
	private List<WebElement> informationField;

	@FindBy(xpath = "(//input[@type='range'])[1]")
	private WebElement minPrice;

	@FindBy(xpath = "(//input[@type='range'])[2]")
	private WebElement maxPrice;

	@FindBy(css = "div.lsCheckboxItem > span")
	private List<WebElement> checkBoxChoicesList;

	@FindBy(css = "div.search-btn-flight > button")
	private WebElement searchButton;

	@FindBy(css = "button.siCheckButton")
	private List<WebElement> seeAvailabilityButtonList;

	@FindBy(css = ".fs-4.m-0")
	private List<WebElement> hotelLocationİnformations;

	public void sendKeysToDestination(String city) {
		actions.moveToElement(destinationInputField);
		BrowserUtils.wait(3);
		destinationInputField.sendKeys(city);
	}

	public String getNumberOfAdults() {
		return informationField.get(0).getAttribute("value");
	}

	public String getNumberOfChildren() {
		return informationField.get(1).getAttribute("value");
	}

	public void sendKeysToMinPrice(String value) {
		minPrice.sendKeys(value);
	}

	public void sendKeysToMaxPrice(String value) {
		maxPrice.sendKeys(value);
	}

	public void clickOnCheckBoxChoices(String choice) {
		BrowserUtils.scrollDownWithPageDownButton(2);
		checkBoxChoicesList.stream()
			.filter(e -> e.getText().equalsIgnoreCase(choice))
			.findFirst()
			.get()
			.findElement(By.xpath("../input"))
			.click();
	}

	public void clickOnSearchButton() {
		actions.moveToElement(searchButton).build().perform();
		BrowserUtils.wait(4);
		searchButton.click();
	}

	public void clickOnSeeAvailabilityButtonByIndex(int index) {
		if (index < 3) {
			BrowserUtils.scrollUpWithPageUpButton(2);
		}
		else if (index < 5) {
			BrowserUtils.scrollUpWithPageUpButton(1);
		}
		else if (index > 7) {
			BrowserUtils.scrollDownWithPageDownButton(1);
		}
		seeAvailabilityButtonList.get(index - 1).click();
	}

	public String getHotelInformations(int index) {
		return hotelLocationİnformations.get(index - 1).getText();
	}

}
