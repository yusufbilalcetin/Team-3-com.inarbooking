package pages.carRentals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class CarRentalConfirmation_Page extends BasePage {

	@FindBy(css = ".fs-2 .fw-bold")
	private WebElement location;

	@FindBy(css = ".fs-3.fw-bold")
	private WebElement carModel;

	@FindBy(css = ".text-muted")
	private List<WebElement> dates;// 1st check-in 2nd check-out 3rd total days

	@FindBy(css = ".confirmation-number")
	private WebElement confirmationText;

	@FindBy(css = ".btn-danger")
	private WebElement closeButton;

	@FindBy(css = ".w-100.d-flex button")
	private WebElement printTextButton;

	public void clickOnCloseButton() {
		closeButton.click();
	}

	public void clickOnPrintTextButton() {
		printTextButton.click();
	}

	public String getConfirmationPageText() {
		return confirmationText.getText();
	}

	public String getLocation() {
		return location.getText();
	}

	public String getPickupDate() {
		return convertDate(dates.get(0).getText());
	}

	public String getDropoffDate() {
		return convertDate(dates.get(1).getText());
	}

	public String convertDate(String date) {
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.ENGLISH);
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		LocalDate dateObject = LocalDate.parse(date, inputFormatter);
		return dateObject.format(outputFormatter);
	}

}
