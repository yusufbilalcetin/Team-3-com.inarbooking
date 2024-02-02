package pages.carRentals.carRentalsS;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.BrowserUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class CarRentalYourDeal_Page extends BasePage {

	@FindBy(css = ".mb-0 strong")
	private WebElement headerText;

	// 5 features for selected car
	// 2nd feature is transmission, 4th feature is Car category
	@FindBy(css = ".my-4.row.m-0 div span")
	private List<WebElement> featuresOfSelectedCar;

	@FindBy(css = ".mb-2")
	private List<WebElement> pickupAndDropoffDatesAndHours;

	@FindBy(css = ".carDate-area .fw-bold.fs-4")
	private List<WebElement> locationText;// 2 webelement

	@FindBy(css = ".py-3 span + span")
	private List<WebElement> prices;// 1st rental fee,2nd tax ,3rd 30+ fee(if),4th
									// insurance(if),5th total fee

	@FindBy(css = "button.py-3")
	private List<WebElement> bookWithFullProtectionButtons;// 1st is on the right 2nd is

	// at the bottom

	@FindBy(css = ".me-4 div.check-option")
	private List<WebElement> noInsuranceOrFullProtectionRadioButtons;// 1st no insurance

	// 2nd full
	// protection

	@FindBy(css = ".fs-3.mt-4")
	private List<WebElement> noInsuranceOrFullProtectionPrices;// 1st no insurance 2nd

	// full protection

	@FindBy(css = ".pickup-and-drop-off-item > div:nth-child(2)")
	private WebElement pickupDropOffLoc;

	public String getPickupDropOffLocation() {
		actions.scrollToElement(pickupDropOffLoc).perform();
		return pickupDropOffLoc.getText();
	}

	public String getHeaderText() {
		return headerText.getText();
	}

	public String getPickupDate() {
		String[] parts = pickupAndDropoffDatesAndHours.get(0).getText().split(", ");
		String date = parts[0] + ", " + parts[1];
		return convertDate(date);
	}

	public String getDropoffDate() {
		String[] parts = pickupAndDropoffDatesAndHours.get(1).getText().split(", ");
		String date = parts[0] + ", " + parts[1];
		return convertDate(date);
	}

	public String convertDate(String date) {
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
		LocalDate dateObject = LocalDate.parse(date, inputFormatter);
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		return dateObject.format(outputFormatter);
	}

	public String getCategory() {
		return featuresOfSelectedCar.get(3).getText();
	}

	public void clickOnNoInsuranceOrFullProtectionRadioButton(String insurance) {
		BrowserUtils.scrollDownWithPageDownButton(1);
		if (insurance.equals("No Insurance")) {
			noInsuranceOrFullProtectionRadioButtons.get(0).click();
		}
		else {
			noInsuranceOrFullProtectionRadioButtons.get(1).click();
		}
	}

	public boolean isPriceCorrect(int age, String insurance) {
		boolean ageOver30 = (age >= 30);
		boolean fullProtection = insurance.equals("Full Protection");
		double carRentalFee = Double.parseDouble(prices.get(0).getText().substring(1));
		double tax = Double.parseDouble(prices.get(1).getText().substring(1));
		double ageFee = 0;
		double insuranceFee = 0;
		double totalPrice = 0;
		if (ageOver30 && fullProtection) {
			ageFee = Double.parseDouble(prices.get(2).getText().substring(1));
			insuranceFee = Double.parseDouble(prices.get(3).getText().substring(1));
			totalPrice = Double.parseDouble(prices.get(4).getText().substring(1));
		}
		if (ageOver30 && !fullProtection) {
			ageFee = Double.parseDouble(prices.get(2).getText().substring(1));
			totalPrice = Double.parseDouble(prices.get(3).getText().substring(1));
		}
		if (!ageOver30 && fullProtection) {
			insuranceFee = Double.parseDouble(prices.get(2).getText().substring(1));
			totalPrice = Double.parseDouble(prices.get(3).getText().substring(1));
		}
		if (!ageOver30 && !fullProtection) {
			totalPrice = Double.parseDouble(prices.get(2).getText().substring(1));
		}
		return totalPrice == (carRentalFee + tax + ageFee + insuranceFee);
	}

	public void clickOnBookButton() {
		bookWithFullProtectionButtons.get(0).click();
	}

}
