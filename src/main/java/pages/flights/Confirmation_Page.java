package pages.flights;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class Confirmation_Page extends BasePage {

	@FindBy(xpath = "//span[contains(text(),'Confirmation Number')]")
	private WebElement confirmationText;

	@FindBy(xpath = "//button[contains(text(),'Get Print Version')]")
	private List<WebElement> printButtons;

	@FindBy(xpath = "//button[contains(text(),'Close')]")
	private WebElement closeButton;

	public String getConfirmationText() {
		return confirmationText.getText();
	}

	public void click_On_PrintButton_For_First_Ticket() {
		printButtons.get(0).click();
	}

	public void click_On_PrintButton_For_Second_Ticket() {
		printButtons.get(1).click();
	}

	public void clickOnCloseButoon() {
		closeButton.click();
	}

}
