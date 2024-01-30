package pages.carRentals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

import java.util.List;

public class CarRentalDetails_Page extends BasePage {

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
		viewDetailsButtonsOfListedCars.get(index).click();
	}

}
