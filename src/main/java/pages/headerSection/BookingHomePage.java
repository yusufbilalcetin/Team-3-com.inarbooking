package pages.headerSection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

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
	private List<WebElement> rentCarButtons;

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
		bookFlightButtons.get(index - 1).click();
	}

	public void clickOnOffersButtons(String pageName) {
		switch (pageName) {
			case "Find a stay" -> findAStayButton.click();
			case "Find Flights" -> findFlightsButton.click();
		}
	}

	public void clickOnPlistElements(String name) {
		pListTitles.stream()
			.filter(element -> element.getText().equalsIgnoreCase(name.toLowerCase()))
			.findFirst()
			.ifPresent(WebElement::click);
	}

	public void clickOnRentCarButton(String carSize) {
		rentCarButtons.stream()
			.filter(element -> element.getText().equalsIgnoreCase(carSize))
			.findFirst()
			.map(buttonElement -> buttonElement.findElement(By.xpath("..//button")))
			.ifPresent(WebElement::click);
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
