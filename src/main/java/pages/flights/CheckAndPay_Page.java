package pages.flights;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.Pages;

import java.util.List;

public class CheckAndPay_Page extends BasePage {

	@FindBy(xpath = "//span[contains(text(),'Check and pay')]")
	private WebElement checkAndPayPageText;

	@FindBy(css = "div>input")
	private List<WebElement> fieldsAndCheckBoxesList;

	@FindBy(xpath = "//span[contains(text(),'Complete Booking')]")
	private WebElement completeBookingButton;

	public String getCheckAndPayPageText() {
		return checkAndPayPageText.getText();
	}

	public void enterCardHoldersName(String string) {
		fieldsAndCheckBoxesList.get(0).sendKeys(string);
	}

	public void enterCardNumber(String string) {
		fieldsAndCheckBoxesList.get(1).sendKeys(string);
	}

	public void enterExpirationDate(String string) {
		fieldsAndCheckBoxesList.get(2).sendKeys(string);
	}

	public void enterCvvCode(String string) {
		fieldsAndCheckBoxesList.get(3).click();
		fieldsAndCheckBoxesList.get(3).sendKeys(string);
	}

	public void click_On_Accept_For_Deals_CheckBox() {
		fieldsAndCheckBoxesList.get(4).click();
	}

	public void click_On_Accept_For_Transportation_CheckBox() {
		fieldsAndCheckBoxesList.get(5).click();
	}

	public void clickOnCompleteBookingButton() {
		completeBookingButton.click();
	}

}
