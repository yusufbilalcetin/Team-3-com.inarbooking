package pages.flights;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

import java.util.List;

public class ExtrasForYourFlight_Page extends BasePage {

	@FindBy(xpath = "//div[contains(text(),'Extras For Your Flight')]")
	private WebElement extrasForYourFlightText;

	@FindBy(css = "div>select")
	private WebElement selectMealDropdownMenu;

	@FindBy(css = "div>input")
	private List<WebElement> checkBoxesForExtras;

	@FindBy(xpath = "//span[contains(text(),'Go To Checkout')]")
	private WebElement goToCheckOutPageButton;

	public String getExtrasForYourFlightText() {
		return extrasForYourFlightText.getText();
	}

	public void chooseMealType(String string) {
		actions.moveToElement(extrasForYourFlightText).build().perform();
		Select select = new Select(selectMealDropdownMenu);
		select.selectByVisibleText(string);
	}

	public void clickOnCheckBoxesForExtras() {
		checkBoxesForExtras.get(2).click();
	}

	public void clickOnCheckOutButton() {
		actions.moveToElement(goToCheckOutPageButton).click().perform();
		// goToCheckOutPageButton.click();
	}

}
