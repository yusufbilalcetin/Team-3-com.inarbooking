package pages.headerSection;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.BrowserUtils;

import java.util.List;

public class BookingHomePage extends BasePage {

	@FindBy(css = ".headerList > div")
	private List<WebElement> tabList;

	@FindBy(css = ".headerTitle")
	private WebElement headerTitle;

	@FindBy(css = ".headerBtn")
	private WebElement headerButton;

	@FindBy(xpath = "//button[text()='Book Flight']")
	private List<WebElement> bookFlightButtons;

	@FindBy(xpath = "//a[text()='Find a stay']")
	private WebElement findAStayButton;

	@FindBy(xpath = "//a[text()='Find Flights']")
	private WebElement findFlightsButton;

	@FindBy(css = ".pListTitles > h1")
	private List<WebElement> pListTitles;

	@FindBy(css = ".fpName")
	private List<WebElement> carSizeTitles;

	@FindBy(xpath = "//input[@placeholder='Your Email']")
	private WebElement emailInputField;

	@FindBy(xpath = "//button[text()='Subscribe']")
	private WebElement subscribeButton;

	@FindBy(css = ".invalid-email-message")
	private WebElement invalidEmailMessage;

	@FindBy(css = ".modal-footer > button")
	private WebElement modalCloseButton;

	public void clickOnTabs(String tabName) {
		switch (tabName) {
			case "Stays" -> clickOnStaysTab();
			case "Flights" -> clickOnFlightsTab();
			case "Car Rentals" -> clickOnCarRentalsTab();
		}
	}

	public void clickOnStaysTab() {
		tabList.get(0).click();
	}

	public void clickOnFlightsTab() {
		tabList.get(1).click();
	}

	public void clickOnCarRentalsTab() {
		tabList.get(2).click();
	}

	public String getHeaderTitle() {
		return headerTitle.getText();
	}

	public String getHeaderButtonText() {
		return headerButton.getText();
	}

	public void clickOnBookFlightButton(int index) {
		actions.scrollToElement(bookFlightButtons.get(index - 1)).click().build().perform();
	}

	public void clickOnOffersButtons(String pageName) {
		switch (pageName) {
			case "Find a stay" -> actions.scrollToElement(findAStayButton).click().build().perform();
			case "Find Flights" -> actions.scrollToElement(findFlightsButton).click().build().perform();
		}
	}

	public void clickOnPlistElements(String name) {
		pListTitles.stream()
			.filter(element -> element.getText().equalsIgnoreCase(name.toLowerCase()))
			.findFirst()
			.ifPresent(element -> actions.scrollToElement(element).click().build().perform());
	}

	public void clickOnRentCarButton(String carSize) {
		carSizeTitles.stream()
			.filter(element -> element.getText().equalsIgnoreCase(carSize))
			.findFirst()
			.map(buttonElement -> buttonElement.findElement(By.xpath("../button")))
			.ifPresent(element -> {
				actions.scrollToElement(element).perform();
				element.click();
			});
	}

	public void enterSubscribeEmail(String email) {
		emailInputField.sendKeys(email);
	}

	public void clickOnSubscribeButton() {
		subscribeButton.click();
	}

	public boolean isInvalidEmailAddressDisplayed() {
		return invalidEmailMessage.isDisplayed();
	}

	public boolean isSubscribeModalDisplayed() {
		boolean check = modalCloseButton.isDisplayed();
		if (check)
			modalCloseButton.click();
		return check;
	}

}
