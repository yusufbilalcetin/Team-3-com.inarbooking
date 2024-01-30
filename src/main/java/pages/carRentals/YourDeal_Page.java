package pages.carRentals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import javax.swing.text.html.CSS;
import java.util.List;

public class YourDeal_Page extends BasePage {

	@FindBy(css = ".h2.mb-0 strong")
	private WebElement headerText;

	// 5 features for selected car
	// 2nd feature is transmission, 4th feature is Car category
	@FindBy(css = ".my-4.row.m-0")
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

}
