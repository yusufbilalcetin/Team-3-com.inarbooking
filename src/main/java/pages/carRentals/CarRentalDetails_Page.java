package pages.carRentals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

import java.util.List;

public class CarRentalDetails_Page extends BasePage {

	public static final Logger LOGGER = LogManager.getLogger(CarRentalDetails_Page.class);

	@FindBy(css = ".text-left")
	private WebElement headerText;

	@FindBy(css = ".form-select.fs-4")
	private WebElement driverAgeSelectMenu;

	@FindBy(css = "input.h-auto")
	private WebElement isAgeBetween30_65Checkbox;

	@FindBy(css = ".form-control")
	private List<WebElement> datesAndLocationBoxes;// pickUpDate,dropOffDate,Location

	@FindBy(css = "input[value*=\"0-\"]")
	private List<WebElement> priceRangeCheckboxes;

	@FindBy(xpath = "//label[text()='Car Specs:']/following-sibling::div/div")
	private List<WebElement> carSpecificationsCheckboxes;

	@FindBy(xpath = "//label[text()='Transmission:']/following-sibling::div/div")
	private List<WebElement> transmissionCheckboxes;

	@FindBy(xpath = "//label[text()='Car Category:']/following-sibling::div/div")
	private List<WebElement> carCategoryCheckboxes;

	@FindBy(css = ".tab-item-car")
	private List<WebElement> carCategoryImages;

	@FindBy(css = ".active-tb")
	private WebElement selectedCarImage;

	@FindBy(css = "div[class='search-btn-car-rental'] button")
	private WebElement searchButton;

	@FindBy(css = ".me-4.fs-5")
	private WebElement priceLowestSortButton;

	@FindBy(css = ".me-4.fs-5 ~ button")
	private WebElement priceHighestSortButton;

	@FindBy(css = ".mb-0")
	private List<WebElement> pricesOfListedCars;

	@FindBy(css = ".span.fs-4.fw-bold")
	private List<WebElement> locationOfListedCars;

	// 5 features for each listed car
	// 2nd feature is transmission, 4th feature is Car category
	@FindBy(css = "div.my-4 div div ~ span")
	private List<WebElement> featuresOfListedCars;

	@FindBy(css = ".pagination-button")
	private List<WebElement> paginationButtons;

	@FindBy(css = "input[placeholder='Your Email']")
	private WebElement emailTextField;

	@FindBy(css = ".mailInputContainer button")
	private WebElement subscribeButton;

	@FindBy(css = ".btn-blue.w-100")
	private List<WebElement> viewDetailsButtonsOfListedCars;

	@FindBy(xpath = "//input[@type='checkbox']")
	private List<WebElement> checkBoxes;

	@FindBy(css = ".carRentalItemDetails")
	private List<WebElement> carCards;

	public void selectAge(int age) {
		Select select = new Select(driverAgeSelectMenu);
		select.selectByVisibleText("" + age);
	}

	public void selectPriceRange(int index) {
		priceRangeCheckboxes.get(index).click();
	}

	public void selectCarSpecs(int index) {
		carSpecificationsCheckboxes.get(index).click();
	}

	public void selectTransmission(int index) {
		transmissionCheckboxes.get(index).click();
	}

	public void selectCarCategory(int index) {
		carCategoryCheckboxes.get(index).click();
	}

	public void selectCarCategoryFromImages(int index) {
		carCategoryImages.get(index).click();
	}

	public void clickOnSearchButton() {
		actions.scrollToElement(searchButton).perform();
		searchButton.click();
	}

	public void clickOnSortHighestPrice() {
		priceHighestSortButton.click();
	}

	public void clickOnSortLowestPrice() {
		priceLowestSortButton.click();
	}

	public void enterEmailTextField(String email) {
		emailTextField.clear();
		emailTextField.sendKeys(email);
	}

	public void clickOnSubscribeButton() {
		subscribeButton.click();
	}

	public void clickOnDesiredCarFromListedCars(int index) {
		if (!viewDetailsButtonsOfListedCars.isEmpty()) {
			actions.scrollToElement(viewDetailsButtonsOfListedCars.get(index)).perform();
			viewDetailsButtonsOfListedCars.get(index).click();
		}
		else {
			LOGGER.debug("No listed car!");
		}
	}

	public String getHeaderText() {
		return headerText.getText();
	}

	public boolean isSelectedCarImageSameWith(String carType) {
		return selectedCarImage.findElement(By.className("tab-item-car-title")).getText().equalsIgnoreCase(carType);
	}

	public boolean isSelectedCarCategorySameWith(String carType) {
		return checkBoxes.stream()
			.filter(element -> element.getAttribute("value").equalsIgnoreCase(carType))
			.findFirst()
			.map(WebElement::isSelected)
			.orElse(false);

	}

	public void selectCarCategory(String carType) {
		checkBoxes.stream()
			.filter(element -> element.getAttribute("value").equalsIgnoreCase(carType))
			.findFirst()
			.ifPresent(WebElement::click);
	}

	public boolean isCarCardsSpecsCorrect(String spec, String expected) {

		return switch (spec) {
			case "size" -> carCards.stream()
				.allMatch(
						card -> card.findElement(By.xpath(".//div/div[4]/span")).getText().equalsIgnoreCase(expected));
			case "transmission" -> carCards.stream()
				.allMatch(
						card -> card.findElement(By.xpath(".//div/div[2]/span")).getText().equalsIgnoreCase(expected));
			default -> throw new IllegalArgumentException("Invalid specification: " + spec);
		};
	}

	public String getPickupLocation() {
		actions.scrollToElement(datesAndLocationBoxes.get(2)).perform();
		return datesAndLocationBoxes.get(2).getAttribute("value");
	}

	public void enterPickupLocation(String location) {
		actions.scrollToElement(datesAndLocationBoxes.get(2)).perform();
		datesAndLocationBoxes.get(2).clear();
		datesAndLocationBoxes.get(2).sendKeys(location);
	}

}
