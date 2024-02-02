package pages.carRentals;

import io.cucumber.java.sl.In;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;
import utils.BrowserUtils;

import javax.swing.plaf.PanelUI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

	@FindBy(xpath = "//label[text()='Car Specs:']/following-sibling::div/div/input")
	private List<WebElement> carSpecificationsCheckboxes;

	@FindBy(xpath = "//label[text()='Transmission:']/following-sibling::div/div/input")
	private List<WebElement> transmissionCheckboxes;

	@FindBy(xpath = "//label[text()='Car Category:']/following-sibling::div/div/input")
	private List<WebElement> carCategoryCheckboxes;

	@FindBy(xpath = "//label[text()='Car Category:']/following-sibling::div/div/span")
	private List<WebElement> carCategoryCheckboxesText;

	@FindBy(css = ".tab-item-car")
	private List<WebElement> carCategoryImages;

	@FindBy(css = ".tab-item-car-title")
	private List<WebElement> carCategoryImagesText;

	@FindBy(xpath = "//button[text()='Search']")
	private WebElement searchButton;

	@FindBy(css = ".me-4.fs-5")
	private WebElement priceLowestSortButton;

	@FindBy(css = ".me-4.fs-5 ~ button")
	private WebElement priceHighestSortButton;

	@FindBy(css = ".w-10")
	private List<WebElement> listedCarsFrames;

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
	private List<WebElement> viewDealButtonsOfListedCars;

	public String getHeaderText() {
		return headerText.getText();
	}

	public void selectAge(int age) {
		Select select = new Select(driverAgeSelectMenu);
		select.selectByVisibleText("" + age);
	}

	public boolean isAgeBetween30_65Checked() {
		return isAgeBetween30_65Checkbox.isSelected();
	}

	public String getDatesAndLocationBoxes(int index) {
		if (index != 2) {
			return convertDate(datesAndLocationBoxes.get(index).getAttribute("value"));
		}
		return datesAndLocationBoxes.get(index).getAttribute("value");
	}

	public String convertDate(String date) {
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		LocalDate dateObject = LocalDate.parse(date, inputFormatter);
		return dateObject.format(outputFormatter);
	}

	public void selectPriceRange(int index) {
		priceRangeCheckboxes.get(index).click();
	}

	public void selectAllPriceRanges() {
		BrowserUtils.scrollDownWithPageDownButton(1);
		for (int i = 0; i < priceRangeCheckboxes.size(); i++) {
			selectPriceRange(i);
		}
	}

	public void selectCarSpecs(int index) {
		carSpecificationsCheckboxes.get(index).click();
	}

	public void selectCarSpecsRandomly() {
		for (int i = 0; i < 5; i++) {
			selectCarSpecs((int) (Math.random() * 9));
		}
	}

	public void selectTransmission(int index) {
		transmissionCheckboxes.get(index).click();
	}

	public void selectCarCategory(int index) {
		carCategoryCheckboxes.get(index).click();
	}

	public void selectCarCategory(String category) {
		BrowserUtils.scrollDownWithPageDownButton(1);
		for (int i = 0; i < carCategoryCheckboxesText.size(); i++) {
			if (carCategoryCheckboxesText.get(i).getText().equals(category)) {
				selectCarCategory(i);
				break;
			}
		}
	}

	public void selectCarCategoryFromImages(int index) {
		carCategoryImages.get(index).click();
	}

	public boolean isTheCarImageSelected(String category) {
		for (int i = 0; i < carCategoryImages.size(); i++) {
			if (carCategoryImagesText.get(i).getText().equals(category)) {
				return carCategoryImages.get(i).getAttribute("class").contains("active-tb");
			}
		}
		return true;
	}

	public void clickOnSearchButton() {
		actions.scrollToElement(searchButton).perform();
		searchButton.click();
	}

	public boolean isThereAvailableCars() {
		return !listedCarsFrames.isEmpty();
	}
	public int numberOfCarsAvailable(){
		return listedCarsFrames.size();
	}

	public void clickOnSortHighestPrice() {
		BrowserUtils.scrollUpWithPageUpButton(2);
		priceHighestSortButton.click();
	}

	public void clickOnSortLowestPrice() {
		BrowserUtils.scrollUpWithPageUpButton(2);
		priceLowestSortButton.click();
	}

	public List<Integer> getPriceList() {
		List<Integer> priceList = new ArrayList<>();
		for (WebElement pricesOfListedCar : pricesOfListedCars) {
			priceList.add((int) Double.parseDouble(pricesOfListedCar.getText().substring(1)));
		}
		return priceList;
	}

	public boolean areCarsSortedHighestPrice() {
		List<Integer> priceList = getPriceList();
		List<Integer> list = new ArrayList<>(priceList);
		Collections.sort(list);
		return list.equals(priceList);
	}

	public boolean areCarsSortedLowestPrice() {
		List<Integer> priceList = getPriceList();
		List<Integer> list = new ArrayList<>(priceList);
		Collections.sort(list);
		Collections.reverse(list);
		return list.equals(priceList);
	}

	public void enterEmailTextField(String email) {
		emailTextField.clear();
		emailTextField.sendKeys(email);
	}

	public void clickOnSubscribeButton() {
		subscribeButton.click();
	}

	public void clickOnDesiredCarFromListedCars(int index) {
		BrowserUtils.scrollDownWithPageDownButton(1);
		viewDealButtonsOfListedCars.get(index).click();
		BrowserUtils.wait(1);
	}

}
