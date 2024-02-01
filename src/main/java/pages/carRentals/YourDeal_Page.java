package pages.carRentals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import javax.swing.text.html.CSS;
import java.util.List;

public class YourDeal_Page extends BasePage {

	@FindBy(tagName = "strong")
	private WebElement headerText;

	// 5 features for selected car
	// 2nd feature is transmission, 4th feature is Car category
	@FindBy(css = ".my-4.row.m-0 > div")
	private List<WebElement> featuresOfSelectedCar;

	@FindBy(css = ".mb-2")
	private List<WebElement> pickupAndDropoffDatesAndHours;

	@FindBy(css = "div span[class='fw-bold fs-4']")
	private List<WebElement> locationText;// 4 webelement

	@FindBy(css = ".py-3 span")
	private List<WebElement> prices;// 2nd rental fee,4th tax ,6th total fee

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

	public String getCarSize() {
		return featuresOfSelectedCar.get(3).getText();
	}

}
